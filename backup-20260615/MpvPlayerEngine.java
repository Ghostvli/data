package com.fongmi.android.tv.player.engine;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.orhanobut.logger.Logger;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.R;
import com.fongmi.android.tv.Setting;
import com.fongmi.android.tv.bean.Track;
import com.fongmi.android.tv.player.PlayerHelper;
import com.fongmi.android.tv.player.exo.TrackUtil;
import com.fongmi.android.tv.utils.ResUtil;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import is.xyz.mpv.BaseMPVView;
import is.xyz.mpv.MPV;
import is.xyz.mpv.MPVNode;

public class MpvPlayerEngine implements PlayerEngine, MPV.EventObserver {

    private BaseMPVView mpvView;
    private MpvPlayer mpvPlayer;
    Player.Listener listener;
    private int decode;
    private PlaySpec spec;
    private volatile int playbackState;
    private volatile float speed;
    private volatile boolean playing;
    private volatile boolean mpvDone;
    private boolean fileLoaded;
    private Long pendingSeekPosition;

    public MpvPlayerEngine(int decode, Player.Listener listener) {
        this.decode = decode;
        this.listener = listener;
        this.speed = 1.0f;
        this.playbackState = Player.STATE_IDLE;
        Player dummy = new androidx.media3.exoplayer.ExoPlayer.Builder(App.get()).build();
        this.mpvPlayer = new MpvPlayer(this, dummy);
    }

    // ── Threading helper ─────────────────────────────────────────
    private void onMain(Runnable r) {
        if (Looper.myLooper() == Looper.getMainLooper()) r.run();
        else new Handler(Looper.getMainLooper()).post(r);
    }

    // ── BaseMPVView wiring ───────────────────────────────────────
    public void setMpvView(BaseMPVView view) {
        this.mpvView = view;
        MPV mpv = view.getMpv();
        mpv.addObserver(this);
        setupMpvOptions(view);
    }

    public String[] getInitOptions() {
        String rtsp = Setting.getRtspTransport() == 0 ? "tcp" : "udp";
        String ua = Setting.getUa();
        if (ua.isEmpty()) ua = "Mozilla/5.0";
        String lavfOpts = "stimeout=15000000,headers=User-Agent: " + ua;
        if (decode == HARD) {
            return new String[]{
                "vo", "gpu", "gpu-context", "android", "hwdec", "mediacodec",
                "hwdec-codecs", "all", "keep-open", "yes", "force-seekable", "yes",
                "keepaspect", "yes", "keepaspect-window", "no",
                "deband", "no", "interpolation", "no",
                "cache", "yes", "demuxer-max-bytes", "50MiB",
                "demuxer-max-back-bytes", "10MiB", "cache-secs", "2",
                "cache-pause-initial", "no", "video-sync", "display-resample",
                "framedrop", "vo",
                "vd-lavc-skiploopfilter", "nonref",
                "demuxer-lavf-error-resilient", "yes",
                "demuxer-lavf-analyzeduration", "1000000",
                "demuxer-lavf-probesize", "1000000",
                "ao", "audiotrack",
                "rtsp-transport", rtsp,
                "demuxer-lavf-o", lavfOpts,
            };
        } else {
            return new String[]{
                "vo", "gpu", "hwdec", "no",
                "gpu-context", "android", "gpu-hwdecode-interop", "auto",
                "opengl-swapinterval", "1", "opengl-pbo", "yes",
                "hwdec-codecs", "all", "keep-open", "yes", "force-seekable", "yes",
                "keepaspect", "yes", "keepaspect-window", "no",
                "deband", "no", "interpolation", "no",
                "cache", "yes", "demuxer-max-bytes", "50MiB",
                "demuxer-max-back-bytes", "10MiB", "cache-secs", "2",
                "cache-pause-initial", "no", "video-sync", "display-resample",
                "framedrop", "vo",
                "vd-lavc-skiploopfilter", "nonref",
                "demuxer-lavf-error-resilient", "yes",
                "demuxer-lavf-analyzeduration", "1000000",
                "demuxer-lavf-probesize", "1000000",
                "ao", "audiotrack",
                "rtsp-transport", rtsp,
                "demuxer-lavf-o", lavfOpts,
            };
        }
    }

    private void setupMpvOptions(BaseMPVView view) {
        MPV mpv = view.getMpv();
        mpv.observeProperty("pause", 3);
        mpv.observeProperty("speed", 5);
    }

    @Override public Player getPlayer() { return mpvPlayer; }
    public PlaySpec getSpec() { return spec; }

    private void releaseMpv(BaseMPVView view) {
        if (view == null) return;
        MPV mpv = view.getMpv();
        if (mpv == null) return;
        try { mpv.removeObserver(this); } catch (Throwable ignored) {}
        try { mpv.command("stop"); } catch (Throwable ignored) {}
        try { mpv.setPropertyString("vo", "null"); } catch (Throwable ignored) {}
        try { mpv.setPropertyString("force-window", "no"); } catch (Throwable ignored) {}
        try { Thread.sleep(100L); } catch (Throwable ignored) {}
        try { mpv.detachSurface(); } catch (Throwable ignored) {}
        try { view.destroy(); } catch (Throwable ignored) {}
    }

    @Override public void release() {
        if (mpvView != null) { releaseMpv(mpvView); mpvView = null; }
        if (mpvPlayer != null) { mpvPlayer.release(); mpvPlayer = null; }
        mpvDone = true;
    }
    @Override public Player rebuild(Player.Listener l) { return mpvPlayer; }
    @Override public int getDecode() { return decode; }
    @Override public void setDecode(int d) { this.decode = d; Setting.putMpvDecode(d); }
    @Override public boolean isHard() { return decode == HARD; }
    @Override public String getDecodeText() { return ResUtil.getStringArray(R.array.select_decode)[decode]; }

    // ── Scale ───────────────────────────────────────────────────
    @Override
    public void setScale(int scale) {
        MPV m = mpvView != null ? mpvView.getMpv() : null;
        if (m == null) return;
        onMain(() -> applyScale(m, scale));
    }

    private void applyScale(MPV m, int scale) {
        try {
            boolean hw = "mediacodec_embed".equals(m.getPropertyString("vo"));
            int targetWidth = -1;
            int targetHeight = -1;
            if (scale == 0) {
                Integer w = m.getPropertyInt("width");
                Integer h = m.getPropertyInt("height");
                if (w != null && w > 0 && h != null && h > 0) {
                    targetWidth = w;
                    targetHeight = h;
                    if (hw) m.setPropertyString("android-surface-size", w + "x" + h);
                    else m.setPropertyDouble("video-aspect-override", (double) w / h);
                } else {
                    if (!hw) m.setPropertyString("video-aspect-override", "no");
                }
            } else if (scale == 1) {
                targetWidth = 16;
                targetHeight = 9;
                if (hw) m.setPropertyString("android-surface-size", "16x9");
                else m.setPropertyDouble("video-aspect-override", 1.7777777777777777d);
            } else if (scale == 2) {
                targetWidth = 4;
                targetHeight = 3;
                if (hw) m.setPropertyString("android-surface-size", "4x3");
                else m.setPropertyDouble("video-aspect-override", 1.3333333333333333d);
            } else if (scale == 3) {
                if (hw) {
                    m.setPropertyString("android-surface-size", "-1x-1");
                } else {
                    m.setPropertyString("video-aspect-override", "no");
                    m.command("set", "panscan", "1.0");
                }
            } else if (scale == 4) {
                if (hw) {
                    m.setPropertyString("android-surface-size", "-1x-1");
                } else {
                    m.setPropertyString("video-aspect-override", "no");
                    m.command("set", "panscan", "0.5");
                }
            }
            if (!hw && scale < 3) m.command("set", "panscan", "0.0");

            if (mpvView != null) {
                mpvView.setVideoSize(targetWidth, targetHeight);
            }
            mpvPlayer.notifyVideoSizeChanged(targetWidth, targetHeight);
        } catch (Throwable ignored) {}
    }

    // ── Playback control ────────────────────────────────────────
    @Override public void start(PlaySpec spec) {
        this.spec = spec;
        this.playing = true;
        this.mpvDone = false;
        this.fileLoaded = false;
        this.pendingSeekPosition = null;
        this.playbackState = Player.STATE_BUFFERING;
        Logger.t("SWITCH_TEST").d("start() state=BUFFERING, mpvDone=" + mpvDone);
        if (spec.getMetadata() != null) {
            mpvPlayer.updateMetadata(spec.getMetadata());
        }
        mpvPlayer.updateTimeline(0);
        mpvPlayer.notifyPlaybackStateChanged(Player.STATE_BUFFERING);
        mpvPlayer.notifyMediaItemTransition(Player.MEDIA_ITEM_TRANSITION_REASON_PLAYLIST_CHANGED);
        onMain(() -> {
            if (mpvView == null) { Logger.t("SWITCH_TEST").d("mpvView is null!"); return; }
            MPV m = mpvView.getMpv();
            if (m == null) { Logger.t("SWITCH_TEST").d("mpv is null!"); return; }
            String url = buildUrl(spec);
            Logger.t("SWITCH_TEST").d("Switching to URL: " + url);
            if (url != null) {
                Logger.t("MPV_SWITCH").d("Received new URL: " + url);
                try { m.setOptionString("ao", "audiotrack"); } catch (Throwable ignored) {}
                try {
                    android.view.Surface surface = mpvView.getHolder().getSurface();
                    if (surface != null && surface.isValid()) {
                        m.attachSurface(surface);
                    }
                } catch (Throwable ignored) {}
                try {
                    Map<String, String> headers = spec.getHeaders();
                    String ua = Setting.getUa();
                    String referer = null;
                    if (headers != null) {
                        for (Map.Entry<String, String> entry : headers.entrySet()) {
                            String key = entry.getKey().toLowerCase(Locale.ROOT);
                            String val = entry.getValue();
                            if ("user-agent".equals(key)) {
                                ua = val;
                            } else if ("referer".equals(key) || "referrer".equals(key)) {
                                referer = val;
                            }
                        }
                    }
                    m.setPropertyString("user-agent", ua);
                    if (referer != null) m.setPropertyString("referrer", referer);
                    StringBuilder lavfOpts = new StringBuilder("stimeout=15000000");
                    lavfOpts.append(",headers=User-Agent: ").append(ua);
                    if (referer != null) lavfOpts.append("\r\nReferer: ").append(referer);
                    m.setOptionString("demuxer-lavf-o", lavfOpts.toString());
                } catch (Throwable ignored) {}
                try {
                    m.setPropertyBoolean("pause", false);
                    m.setPropertyDouble("speed", speed);
                } catch (Throwable ignored) {}
                Logger.t("MPV_SWITCH").d("Calling loadfile: " + url);
                mpvView.playFile(url);
            }
        });
    }

    private String buildUrl(PlaySpec s) {
        String url = s.getUrl();
        if (url == null) return null;
        if (url.contains("/proxy?") && url.contains("do=m3u8")) {
            try {
                android.net.Uri uri = android.net.Uri.parse(url);
                String realUrl = uri.getQueryParameter("url");
                if (realUrl != null && !realUrl.isEmpty()) {
                    return realUrl;
                }
            } catch (Throwable ignored) {
            }
        }
        return url;
    }

    @Override public void setMetadata(MediaMetadata data) {
        mpvPlayer.updateMetadata(data);
    }
    @Override public boolean isLive() { return false; }
    @Override public boolean isVod() { return true; }
    @Override
    public void setTrack(List<Track> tracks) {
        MPV mpv = mpvView != null ? mpvView.getMpv() : null;
        if (mpv == null) return;
        try {
            for (Track track : tracks) {
                if (!track.isSelected()) continue;
                String formatDesc = track.getFormat();
                if (formatDesc == null) continue;
                Tracks currentTracks = getCurrentTracks();
                for (Tracks.Group group : currentTracks.getGroups()) {
                    if (group.getType() != track.getType()) continue;
                    for (int i = 0; i < group.length; i++) {
                        Format f = group.getTrackFormat(i);
                        if (formatDesc.equals(PlayerHelper.describeFormat(f))) {
                            String mpvProp = track.getType() == C.TRACK_TYPE_AUDIO ? "aid"
                                           : track.getType() == C.TRACK_TYPE_VIDEO ? "vid"
                                           : track.getType() == C.TRACK_TYPE_TEXT ? "sid" : null;
                            if (mpvProp != null && f.id != null) {
                                mpv.setPropertyInt(mpvProp, Integer.parseInt(f.id));
                                mpvPlayer.notifyTracksChanged(getCurrentTracks());
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            Log.e("MpvPlayerEngine", "setTrack error", e);
        }
    }

    @Override
    public void resetTrack() {
        MPV mpv = mpvView != null ? mpvView.getMpv() : null;
        if (mpv == null) return;
        try {
            mpv.setPropertyString("aid", "auto");
            mpv.setPropertyString("vid", "auto");
            mpv.setPropertyString("sid", "no");
        } catch (Throwable ignored) {}
    }

    @Override
    public boolean haveTrack(int type) {
        return TrackUtil.count(getCurrentTracks(), type) > 0;
    }

    @Override
    public Tracks getCurrentTracks() {
        MPV mpv = mpvView != null ? mpvView.getMpv() : null;
        if (mpv == null) return Tracks.EMPTY;
        try {
            Integer count = mpv.getPropertyInt("track-list/count");
            if (count == null || count <= 0) return Tracks.EMPTY;
            List<Tracks.Group> groups = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String typeStr = mpv.getPropertyString("track-list/" + i + "/type");
                if (typeStr == null) continue;
                Integer id = mpv.getPropertyInt("track-list/" + i + "/id");
                String lang = mpv.getPropertyString("track-list/" + i + "/lang");
                String title = mpv.getPropertyString("track-list/" + i + "/title");
                String codec = mpv.getPropertyString("track-list/" + i + "/codec");
                Boolean selected = mpv.getPropertyBoolean("track-list/" + i + "/selected");
                boolean isSelected = selected != null && selected;
                int trackId = id != null ? id : i + 1;

                Format.Builder builder = new Format.Builder()
                    .setId(String.valueOf(trackId))
                    .setSelectionFlags(isSelected ? C.SELECTION_FLAG_DEFAULT : 0);

                if ("audio".equals(typeStr)) {
                    Integer channels = mpv.getPropertyInt("track-list/" + i + "/demux-channels");
                    Integer samplerate = mpv.getPropertyInt("track-list/" + i + "/demux-samplerate");
                    Double bitrate = null;
                    try { bitrate = mpv.getPropertyDouble("track-list/" + i + "/demux-bitrate"); } catch (Throwable ignored) {}
                    if (bitrate == null || bitrate <= 0) {
                        try { bitrate = mpv.getPropertyDouble("track-list/" + i + "/codec-bitrate"); } catch (Throwable ignored) {}
                    }
                    String label = formatAudioLabel(lang, title, codec, channels, samplerate, bitrate);
                    builder.setSampleMimeType(MimeTypes.AUDIO_RAW)
                        .setLabel(label)
                        .setLanguage(lang)
                        .setChannelCount(channels != null ? channels : -1)
                        .setSampleRate(samplerate != null ? samplerate : -1)
                        .setAverageBitrate(bitrate != null ? bitrate.intValue() : -1)
                        .setCodecs(codec);
                } else if ("video".equals(typeStr)) {
                    Integer w = mpv.getPropertyInt("track-list/" + i + "/demux-w");
                    Integer h = mpv.getPropertyInt("track-list/" + i + "/demux-h");
                    Double fps = mpv.getPropertyDouble("track-list/" + i + "/demux-fps");
                    String signal = mpv.getPropertyString("track-list/" + i + "/demux-signal");
                    Double bitrate = null;
                    try { bitrate = mpv.getPropertyDouble("track-list/" + i + "/demux-bitrate"); } catch (Throwable ignored) {}
                    if (bitrate == null || bitrate <= 0) {
                        try { bitrate = mpv.getPropertyDouble("track-list/" + i + "/codec-bitrate"); } catch (Throwable ignored) {}
                    }
                    String label = formatVideoLabel(lang, title, codec, w, h, fps, signal, bitrate);
                    builder.setSampleMimeType(MimeTypes.VIDEO_H264)
                        .setLabel(label)
                        .setLanguage(lang)
                        .setWidth(w != null ? w : -1)
                        .setHeight(h != null ? h : -1)
                        .setFrameRate(fps != null ? fps.floatValue() : -1.0f)
                        .setAverageBitrate(bitrate != null ? bitrate.intValue() : -1)
                        .setCodecs(codec);
                } else if ("sub".equals(typeStr)) {
                    String label = title != null && !title.isEmpty() ? title : (lang != null && !lang.isEmpty() ? lang : "Sub " + trackId);
                    builder.setSampleMimeType(MimeTypes.TEXT_VTT)
                        .setLabel(label)
                        .setLanguage(lang)
                        .setCodecs(codec);
                } else {
                    continue;
                }

                Format format = builder.build();
                TrackGroup mediaTrackGroup = new TrackGroup(format);
                int[] trackSupport = new int[] { C.FORMAT_HANDLED };
                boolean[] trackSelected = new boolean[] { isSelected };
                groups.add(new Tracks.Group(mediaTrackGroup, false, trackSupport, trackSelected));
            }
            return new Tracks(ImmutableList.copyOf(groups));
        } catch (Throwable e) {
            Log.e("MpvPlayerEngine", "getCurrentTracks error", e);
            return Tracks.EMPTY;
        }
    }

    private String formatAudioLabel(String lang, String title, String codec, Integer channels, Integer samplerate, Double bitrate) {
        StringBuilder sb = new StringBuilder();
        if (title != null && !title.isEmpty()) {
            sb.append(title);
        } else if (lang != null && !lang.isEmpty()) {
            sb.append(lang);
        }
        if (codec != null && !codec.isEmpty()) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(codec);
        }
        if (channels != null && channels > 0) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(channels).append("ch");
        }
        if (samplerate != null && samplerate > 0) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(samplerate / 1000).append("kHz");
        }
        if (bitrate != null && bitrate > 0.0d) {
            if (sb.length() > 0) sb.append(" | ");
            if (bitrate >= 1000000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.1f", bitrate / 1000000.0d)).append("Mbps");
            } else if (bitrate >= 1000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.0f", bitrate / 1000.0d)).append("kbps");
            } else {
                sb.append(String.format(Locale.getDefault(), "%.0f", bitrate)).append("bps");
            }
        }
        return sb.length() > 0 ? sb.toString() : "Unknown";
    }

    private String formatVideoLabel(String lang, String title, String codec, Integer w, Integer h, Double fps, String signal, Double bitrate) {
        StringBuilder sb = new StringBuilder();
        if (title != null && !title.isEmpty()) {
            sb.append(title);
        }
        if (codec != null && !codec.isEmpty()) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(codec);
        }
        if (w != null && w > 0 && h != null && h > 0) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(w).append("x").append(h);
        }
        if (fps != null && fps > 0.0d) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(String.format(Locale.getDefault(), "%.2f", fps)).append("fps");
        }
        if (bitrate != null && bitrate > 0.0d) {
            if (sb.length() > 0) sb.append(" | ");
            if (bitrate >= 1000000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.1f", bitrate / 1000000.0d)).append("Mbps");
            } else if (bitrate >= 1000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.0f", bitrate / 1000.0d)).append("kbps");
            } else {
                sb.append(String.format(Locale.getDefault(), "%.0f", bitrate)).append("bps");
            }
        }
        if (signal != null && !signal.isEmpty()) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(signal.toUpperCase(Locale.getDefault()));
        }
        return sb.length() > 0 ? sb.toString() : "Unknown";
    }
    @Override public String getErrorMessage(PlaybackException e) { return e != null ? e.getMessage() : "MPV playback error"; }
    @Override public ErrorAction handleError(PlaybackException e) { return ErrorAction.FATAL; }

    @Override public int getPlaybackState() { return playbackState; }
    @Override public boolean isPlaying() { return playing; }

    @Override public long getDuration() {
        MPV m = mpvView != null ? mpvView.getMpv() : null;
        if (m == null) return 0;
        try { Double d = m.getPropertyDouble("duration"); return d != null ? (long)(d * 1000) : 0; }
        catch (Throwable e) { return 0; }
    }
    @Override public long getPosition() {
        MPV m = mpvView != null ? mpvView.getMpv() : null;
        if (m == null) return 0;
        try { Double d = m.getPropertyDouble("time-pos"); return d != null ? (long)(d * 1000) : 0; }
        catch (Throwable e) { return 0; }
    }

    @Override public void seekTo(long time) {
        onMain(() -> {
            MPV m = mpvView != null ? mpvView.getMpv() : null;
            if (m == null) return;
            if (!fileLoaded) {
                pendingSeekPosition = time;
                Logger.t("MpvPlayerEngine").d("seekTo pending: " + time + "ms");
            } else {
                try {
                    m.command("seek", String.valueOf(time / 1000.0), "absolute");
                    Logger.t("MpvPlayerEngine").d("seekTo execute: " + time + "ms");
                } catch (Throwable ignored) {}
            }
        });
    }
    @Override public void play() {
        onMain(() -> {
            MPV m = mpvView != null ? mpvView.getMpv() : null;
            if (m == null) return;
            try { m.setPropertyBoolean("pause", false); playing = true; } catch (Throwable ignored) {}
            mpvPlayer.notifyIsPlayingChanged(true);
            if (playbackState != Player.STATE_READY) {
                playbackState = Player.STATE_READY;
                mpvPlayer.notifyPlaybackStateChanged(Player.STATE_READY);
            }
        });
    }
    @Override public void pause() {
        onMain(() -> {
            MPV m = mpvView != null ? mpvView.getMpv() : null;
            if (m == null) return;
            try { m.setPropertyBoolean("pause", true); playing = false; } catch (Throwable ignored) {}
            mpvPlayer.notifyIsPlayingChanged(false);
        });
    }
    @Override public void stop() {
        Logger.t("MPV_SWITCH").d("stop() called, mpvDone=" + mpvDone);
        mpvDone = true;
        onMain(() -> {
            MPV m = mpvView != null ? mpvView.getMpv() : null;
            if (m == null) return;
            try { m.setPropertyBoolean("pause", true); } catch (Throwable ignored) {}
            playbackState = Player.STATE_IDLE;
            playing = false;
            mpvPlayer.notifyPlaybackStateChanged(Player.STATE_IDLE);
            mpvPlayer.notifyIsPlayingChanged(false);
            Logger.t("MPV_SWITCH").d("stop() completed, state=IDLE");
        });
    }
    public void forceStop() {
        Logger.t("MPV_SWITCH").d("forceStop() called");
        mpvDone = true;
        onMain(() -> {
            MPV m = mpvView != null ? mpvView.getMpv() : null;
            if (m != null) {
                try { m.setPropertyBoolean("pause", true); } catch (Throwable ignored) {}
                try { m.command("stop"); } catch (Throwable ignored) {}
                try { m.setPropertyString("ao", "null"); } catch (Throwable ignored) {}
            }
            playbackState = Player.STATE_IDLE;
            playing = false;
            if (mpvPlayer != null) {
                mpvPlayer.notifyPlaybackStateChanged(Player.STATE_IDLE);
                mpvPlayer.notifyIsPlayingChanged(false);
            }
            Logger.t("MPV_SWITCH").d("forceStop() completed");
        });
    }

    @Override public void setPlaybackSpeed(float speed) {
        this.speed = speed;
        onMain(() -> {
            MPV m = mpvView != null ? mpvView.getMpv() : null;
            if (m == null) return;
            try { m.setPropertyDouble("speed", speed); } catch (Throwable ignored) {}
        });
    }
    @Override public float getSpeed() { return speed; }

    // ── MPV EventObserver ─────────────────────────────────────────
    @Override public void event(int eventId, MPVNode node) {
        onMain(() -> {
            if (mpvPlayer == null) return;
            if (eventId == 7) { // START_FILE
                Logger.t("MPV_SWITCH").d("event START_FILE(7)");
            } else if (eventId == 8) { // FILE_LOADED
                long dur = getDuration();
                Logger.t("MPV_SWITCH").d("event FILE_LOADED(8), duration=" + dur + "ms");
                fileLoaded = true;
                playbackState = Player.STATE_READY;
                playing = true;
                readVideoSize();
                mpvPlayer.updateTimeline(dur);
                mpvPlayer.notifyTracksChanged(getCurrentTracks());
                mpvPlayer.notifyPlaybackStateChanged(Player.STATE_READY);
                mpvPlayer.notifyIsPlayingChanged(true);
                mpvPlayer.notifyRenderedFirstFrame();
                try {
                    MPV m = mpvView != null ? mpvView.getMpv() : null;
                    if (m != null) {
                        m.setPropertyBoolean("pause", false);
                        m.setPropertyDouble("speed", speed);
                        if (pendingSeekPosition != null && pendingSeekPosition > 0) {
                            long seekPos = pendingSeekPosition;
                            pendingSeekPosition = null;
                            m.command("seek", String.valueOf(seekPos / 1000.0), "absolute");
                            Logger.t("MpvPlayerEngine").d("seekTo execute pending: " + seekPos + "ms");
                        }
                    }
                } catch (Throwable ignored) {}
            } else if (eventId == 12) { // END_FILE
                long reason = -1;
                if (node != null && node.get("reason") != null) {
                    Long r = node.get("reason").asInt();
                    if (r != null) reason = r;
                }
                Logger.t("MPV_SWITCH").d("event END_FILE(12), reason=" + reason + ", mpvDone=" + mpvDone);
                if (mpvDone) return;
                if (reason == 1 || reason == 2 || reason == 3) return;
                playbackState = Player.STATE_ENDED;
                playing = false;
                mpvDone = true;
                mpvPlayer.notifyPlaybackStateChanged(Player.STATE_ENDED);
                mpvPlayer.notifyIsPlayingChanged(false);
            }
        });
    }

    private void readVideoSize() {
        MPV m = mpvView != null ? mpvView.getMpv() : null;
        if (m == null) return;
        try {
            Integer w = m.getPropertyInt("width");
            Integer h = m.getPropertyInt("height");
            if (w != null && w > 0 && h != null && h > 0) {
                if (mpvView != null) mpvView.setVideoSize(w, h);
                mpvPlayer.notifyVideoSizeChanged(w, h);
            }
        } catch (Throwable ignored) {}
    }
    @Override public void eventProperty(String property) {}
    @Override public void eventProperty(String property, double value) {
        onMain(() -> {
            if (mpvPlayer == null) return;
            if ("speed".equals(property)) speed = (float) value;
        });
    }
    @Override public void eventProperty(String property, long value) {}
    @Override public void eventProperty(String property, MPVNode node) {}
    @Override public void eventProperty(String property, String value) {}
    @Override public void eventProperty(String property, boolean value) {
        onMain(() -> {
            if (mpvPlayer == null) return;
            if ("pause".equals(property)) {
                if (playbackState == Player.STATE_BUFFERING) {
                    return;
                }
                playing = !value;
                playbackState = Player.STATE_READY;
                mpvPlayer.notifyIsPlayingChanged(playing);
                mpvPlayer.notifyPlaybackStateChanged(Player.STATE_READY);
            }
        });
    }
}

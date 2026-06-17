package com.fongmi.android.tv.player.engine;

import androidx.media3.common.ForwardingPlayer;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;

import java.util.concurrent.CopyOnWriteArrayList;

public class MpvPlayer extends ForwardingPlayer {

    private final MpvPlayerEngine engine;
    private final CopyOnWriteArrayList<Listener> listeners = new CopyOnWriteArrayList<>();
    private Timeline currentTimeline = new MpvTimeline(androidx.media3.common.C.TIME_UNSET, MediaItem.EMPTY);
    private boolean playWhenReady = true;
    private MediaMetadata mediaMetadata = MediaMetadata.EMPTY;

    public MpvPlayer(MpvPlayerEngine engine, Player exoDummy) {
        super(exoDummy);
        this.engine = engine;
    }

    @Override
    public MediaMetadata getMediaMetadata() {
        return mediaMetadata;
    }

    public void updateMetadata(MediaMetadata mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
        for (Listener l : listeners) {
            l.onMediaMetadataChanged(mediaMetadata);
        }
    }

    public void notifyMediaItemTransition(int reason) {
        MediaItem mediaItem = getCurrentMediaItem();
        for (Listener l : listeners) {
            l.onMediaItemTransition(mediaItem, reason);
        }
    }

    // ── Command availability ────────────────────────────────────
    @Override public boolean isCommandAvailable(int command) { return true; }
    @Override public Player.Commands getAvailableCommands() {
        return new Player.Commands.Builder().addAllCommands().build();
    }

    // ── Timeline & MediaItem Overrides ──────────────────────────
    @Override public Timeline getCurrentTimeline() { return currentTimeline; }
    @Override public int getMediaItemCount() { return currentTimeline.getWindowCount(); }
    @Override public int getCurrentMediaItemIndex() { return 0; }
    @Override public MediaItem getCurrentMediaItem() {
        if (engine.getSpec() == null || engine.getSpec().getUrl() == null) {
            return MediaItem.EMPTY;
        }
        return MediaItem.fromUri(engine.getSpec().getUrl());
    }

    public void updateTimeline(long durationMs) {
        long durationUs = durationMs > 0 ? durationMs * 1000 : androidx.media3.common.C.TIME_UNSET;
        MediaItem mediaItem = getCurrentMediaItem();
        this.currentTimeline = new MpvTimeline(durationUs, mediaItem);
        for (Listener l : listeners) {
            l.onTimelineChanged(currentTimeline, Player.TIMELINE_CHANGE_REASON_SOURCE_UPDATE);
        }
    }

    // ── State bridge ───────────────────────────────────────────
    @Override public int getPlaybackState() { return engine.getPlaybackState(); }
    @Override public boolean isPlaying() { return engine.isPlaying(); }
    @Override public long getDuration() { return engine.getDuration(); }
    @Override public long getCurrentPosition() { return engine.getPosition(); }
    @Override public long getContentPosition() { return engine.getPosition(); }
    @Override public long getContentDuration() { return engine.getDuration(); }
    @Override public PlaybackParameters getPlaybackParameters() { return new PlaybackParameters(engine.getSpeed()); }
    @Override public boolean isLoading() { return engine.getPlaybackState() == STATE_BUFFERING; }
    @Override public Tracks getCurrentTracks() { return engine.getCurrentTracks(); }

    // ── Actions ────────────────────────────────────────────────
    @Override public void seekTo(long positionMs) { engine.seekTo(positionMs); }
    @Override public void play() {
        this.playWhenReady = true;
        super.play();
        engine.play();
    }
    @Override public void pause() {
        this.playWhenReady = false;
        super.pause();
        engine.pause();
    }
    @Override public void stop() {
        this.playWhenReady = false;
        super.stop();
        engine.stop();
    }
    @Override public boolean getPlayWhenReady() { return playWhenReady; }
    @Override public void setPlayWhenReady(boolean playWhenReady) {
        this.playWhenReady = playWhenReady;
        super.setPlayWhenReady(playWhenReady);
        if (playWhenReady) engine.play(); else engine.pause();
    }
    @Override public void setPlaybackSpeed(float speed) { engine.setPlaybackSpeed(speed); }
    @Override public void setPlaybackParameters(PlaybackParameters p) { engine.setPlaybackSpeed(p.speed); }

    private static final class MpvTimeline extends Timeline {
        private final long durationUs;
        private final MediaItem mediaItem;

        public MpvTimeline(long durationUs, MediaItem mediaItem) {
            this.durationUs = durationUs;
            this.mediaItem = mediaItem;
        }

        @Override
        public int getWindowCount() {
            return 1;
        }

        @Override
        public Window getWindow(int windowIndex, Window window, long defaultPositionProjectionUs) {
            window.set(
                Window.SINGLE_WINDOW_UID,
                mediaItem,
                null,
                androidx.media3.common.C.TIME_UNSET,
                androidx.media3.common.C.TIME_UNSET,
                androidx.media3.common.C.TIME_UNSET,
                true, // isSeekable
                false, // isDynamic
                null, // liveConfiguration
                0, // defaultPositionUs
                durationUs,
                0, // firstPeriodIndex
                0, // lastPeriodIndex
                0 // positionInFirstPeriodUs
            );
            return window;
        }

        @Override
        public int getPeriodCount() {
            return 1;
        }

        @Override
        public Period getPeriod(int periodIndex, Period period, boolean setIds) {
            period.set(
                Window.SINGLE_WINDOW_UID,
                Window.SINGLE_WINDOW_UID,
                0,
                durationUs,
                0
            );
            return period;
        }

        @Override
        public int getIndexOfPeriod(Object uid) {
            return Window.SINGLE_WINDOW_UID.equals(uid) ? 0 : -1;
        }

        @Override
        public Object getUidOfPeriod(int periodIndex) {
            return Window.SINGLE_WINDOW_UID;
        }
    }

    // ── Listener management ────────────────────────────────────
    @Override public void addListener(Listener listener) {
        super.addListener(listener);
        listeners.add(listener);
    }
    @Override public void removeListener(Listener listener) {
        super.removeListener(listener);
        listeners.remove(listener);
    }

    /** Notify all registered listeners of state change (from engine thread, posts to main) */
    void notifyPlaybackStateChanged(int state) {
        for (Listener l : listeners) l.onPlaybackStateChanged(state);
    }

    void notifyIsPlayingChanged(boolean playing) {
        this.playWhenReady = playing;
        if (playing) super.play(); else super.pause();
        for (Listener l : listeners) l.onIsPlayingChanged(playing);
    }

    void notifyVideoSizeChanged(int width, int height) {
        VideoSize size = new VideoSize(width, height);
        for (Listener l : listeners) l.onVideoSizeChanged(size);
    }

    void notifyRenderedFirstFrame() {
        for (Listener l : listeners) l.onRenderedFirstFrame();
    }

    void notifyTracksChanged(Tracks tracks) {
        for (Listener l : listeners) l.onTracksChanged(tracks);
    }
}

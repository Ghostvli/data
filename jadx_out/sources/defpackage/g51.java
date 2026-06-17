package defpackage;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import defpackage.hd3;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g51 implements hd3 {
    private final IdentityHashMap<hd3.d, a> listeners = new IdentityHashMap<>();
    private final hd3 player;

    public g51(hd3 hd3Var) {
        this.player = hd3Var;
    }

    @Override // defpackage.hd3
    public void addListener(hd3.d dVar) {
        synchronized (this.listeners) {
            try {
                a aVar = this.listeners.get(dVar);
                if (aVar == null) {
                    aVar = new a(this, dVar);
                }
                this.player.addListener(aVar);
                this.listeners.put(dVar, aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hd3
    public void addMediaItem(fg2 fg2Var) {
        this.player.addMediaItem(fg2Var);
    }

    @Override // defpackage.hd3
    public void addMediaItems(List<fg2> list) {
        this.player.addMediaItems(list);
    }

    @Override // defpackage.hd3
    public boolean canAdvertiseSession() {
        return this.player.canAdvertiseSession();
    }

    @Override // defpackage.hd3
    public void clearMediaItems() {
        this.player.clearMediaItems();
    }

    @Override // defpackage.hd3
    public void clearVideoSurface() {
        this.player.clearVideoSurface();
    }

    @Override // defpackage.hd3
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // defpackage.hd3
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        this.player.clearVideoSurfaceView(surfaceView);
    }

    @Override // defpackage.hd3
    public void clearVideoTextureView(TextureView textureView) {
        this.player.clearVideoTextureView(textureView);
    }

    @Override // defpackage.hd3
    @Deprecated
    public void decreaseDeviceVolume() {
        this.player.decreaseDeviceVolume();
    }

    @Override // defpackage.hd3
    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override // defpackage.hd3
    public yb getAudioAttributes() {
        return this.player.getAudioAttributes();
    }

    @Override // defpackage.hd3
    public int getAudioSessionId() {
        return this.player.getAudioSessionId();
    }

    @Override // defpackage.hd3
    public hd3.b getAvailableCommands() {
        return this.player.getAvailableCommands();
    }

    @Override // defpackage.hd3
    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    @Override // defpackage.hd3
    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    @Override // defpackage.hd3
    public long getContentBufferedPosition() {
        return this.player.getContentBufferedPosition();
    }

    @Override // defpackage.hd3
    public long getContentDuration() {
        return this.player.getContentDuration();
    }

    @Override // defpackage.hd3
    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    @Override // defpackage.hd3
    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // defpackage.hd3
    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // defpackage.hd3
    public w50 getCurrentCues() {
        return this.player.getCurrentCues();
    }

    @Override // defpackage.hd3
    public long getCurrentLiveOffset() {
        return this.player.getCurrentLiveOffset();
    }

    @Override // defpackage.hd3
    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    @Override // defpackage.hd3
    public fg2 getCurrentMediaItem() {
        return this.player.getCurrentMediaItem();
    }

    @Override // defpackage.hd3
    public int getCurrentMediaItemIndex() {
        return this.player.getCurrentMediaItemIndex();
    }

    @Override // defpackage.hd3
    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    @Override // defpackage.hd3
    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Override // defpackage.hd3
    public no4 getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    @Override // defpackage.hd3
    public xr4 getCurrentTracks() {
        return this.player.getCurrentTracks();
    }

    @Override // defpackage.hd3
    @Deprecated
    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    @Override // defpackage.hd3
    public kk0 getDeviceInfo() {
        return this.player.getDeviceInfo();
    }

    @Override // defpackage.hd3
    public int getDeviceVolume() {
        return this.player.getDeviceVolume();
    }

    @Override // defpackage.hd3
    public long getDuration() {
        return this.player.getDuration();
    }

    @Override // defpackage.hd3
    public long getMaxSeekToPreviousPosition() {
        return this.player.getMaxSeekToPreviousPosition();
    }

    @Override // defpackage.hd3
    public fg2 getMediaItemAt(int i) {
        return this.player.getMediaItemAt(i);
    }

    @Override // defpackage.hd3
    public int getMediaItemCount() {
        return this.player.getMediaItemCount();
    }

    @Override // defpackage.hd3
    public ph2 getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    @Override // defpackage.hd3
    public int getNextMediaItemIndex() {
        return this.player.getNextMediaItemIndex();
    }

    @Override // defpackage.hd3
    @Deprecated
    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    @Override // defpackage.hd3
    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    @Override // defpackage.hd3
    public dc3 getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    @Override // defpackage.hd3
    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    @Override // defpackage.hd3
    public int getPlaybackSuppressionReason() {
        return this.player.getPlaybackSuppressionReason();
    }

    @Override // defpackage.hd3
    public ac3 getPlayerError() {
        return this.player.getPlayerError();
    }

    @Override // defpackage.hd3
    public ph2 getPlaylistMetadata() {
        return this.player.getPlaylistMetadata();
    }

    @Override // defpackage.hd3
    public int getPreviousMediaItemIndex() {
        return this.player.getPreviousMediaItemIndex();
    }

    @Override // defpackage.hd3
    @Deprecated
    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    @Override // defpackage.hd3
    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    @Override // defpackage.hd3
    public long getSeekBackIncrement() {
        return this.player.getSeekBackIncrement();
    }

    @Override // defpackage.hd3
    public long getSeekForwardIncrement() {
        return this.player.getSeekForwardIncrement();
    }

    @Override // defpackage.hd3
    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    @Override // defpackage.hd3
    public d94 getSurfaceSize() {
        return this.player.getSurfaceSize();
    }

    @Override // defpackage.hd3
    public long getTotalBufferedDuration() {
        return this.player.getTotalBufferedDuration();
    }

    @Override // defpackage.hd3
    public lr4 getTrackSelectionParameters() {
        return this.player.getTrackSelectionParameters();
    }

    @Override // defpackage.hd3
    public e35 getVideoSize() {
        return this.player.getVideoSize();
    }

    @Override // defpackage.hd3
    public float getVolume() {
        return this.player.getVolume();
    }

    public hd3 getWrappedPlayer() {
        return this.player;
    }

    @Override // defpackage.hd3
    public boolean hasNextMediaItem() {
        return this.player.hasNextMediaItem();
    }

    @Override // defpackage.hd3
    public boolean hasPreviousMediaItem() {
        return this.player.hasPreviousMediaItem();
    }

    @Override // defpackage.hd3
    @Deprecated
    public void increaseDeviceVolume() {
        this.player.increaseDeviceVolume();
    }

    @Override // defpackage.hd3
    public boolean isCommandAvailable(int i) {
        return this.player.isCommandAvailable(i);
    }

    @Override // defpackage.hd3
    public boolean isCurrentMediaItemDynamic() {
        return this.player.isCurrentMediaItemDynamic();
    }

    @Override // defpackage.hd3
    public boolean isCurrentMediaItemLive() {
        return this.player.isCurrentMediaItemLive();
    }

    @Override // defpackage.hd3
    public boolean isCurrentMediaItemSeekable() {
        return this.player.isCurrentMediaItemSeekable();
    }

    @Override // defpackage.hd3
    @Deprecated
    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    @Override // defpackage.hd3
    @Deprecated
    public boolean isCurrentWindowLive() {
        return this.player.isCurrentWindowLive();
    }

    @Override // defpackage.hd3
    @Deprecated
    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    @Override // defpackage.hd3
    public boolean isDeviceMuted() {
        return this.player.isDeviceMuted();
    }

    @Override // defpackage.hd3
    public boolean isLoading() {
        return this.player.isLoading();
    }

    @Override // defpackage.hd3
    public boolean isPlaying() {
        return this.player.isPlaying();
    }

    @Override // defpackage.hd3
    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    @Override // defpackage.hd3
    public void moveMediaItem(int i, int i2) {
        this.player.moveMediaItem(i, i2);
    }

    @Override // defpackage.hd3
    public void moveMediaItems(int i, int i2, int i3) {
        this.player.moveMediaItems(i, i2, i3);
    }

    @Override // defpackage.hd3
    public void mute() {
        this.player.mute();
    }

    @Override // defpackage.hd3
    public void pause() {
        this.player.pause();
    }

    @Override // defpackage.hd3
    public void play() {
        this.player.play();
    }

    @Override // defpackage.hd3
    public void prepare() {
        this.player.prepare();
    }

    @Override // defpackage.hd3
    public void release() {
        this.player.release();
    }

    @Override // defpackage.hd3
    public void removeListener(hd3.d dVar) {
        synchronized (this.listeners) {
            a aVarRemove = this.listeners.remove(dVar);
            hd3 hd3Var = this.player;
            if (aVarRemove != null) {
                dVar = aVarRemove;
            }
            hd3Var.removeListener(dVar);
        }
    }

    @Override // defpackage.hd3
    public void removeMediaItem(int i) {
        this.player.removeMediaItem(i);
    }

    @Override // defpackage.hd3
    public void removeMediaItems(int i, int i2) {
        this.player.removeMediaItems(i, i2);
    }

    @Override // defpackage.hd3
    public void replaceMediaItem(int i, fg2 fg2Var) {
        this.player.replaceMediaItem(i, fg2Var);
    }

    @Override // defpackage.hd3
    public void replaceMediaItems(int i, int i2, List<fg2> list) {
        this.player.replaceMediaItems(i, i2, list);
    }

    @Override // defpackage.hd3
    public void seekBack() {
        this.player.seekBack();
    }

    @Override // defpackage.hd3
    public void seekForward() {
        this.player.seekForward();
    }

    @Override // defpackage.hd3
    public void seekTo(long j) {
        this.player.seekTo(j);
    }

    @Override // defpackage.hd3
    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    @Override // defpackage.hd3
    public void seekToNext() {
        this.player.seekToNext();
    }

    @Override // defpackage.hd3
    public void seekToNextMediaItem() {
        this.player.seekToNextMediaItem();
    }

    @Override // defpackage.hd3
    public void seekToPrevious() {
        this.player.seekToPrevious();
    }

    @Override // defpackage.hd3
    public void seekToPreviousMediaItem() {
        this.player.seekToPreviousMediaItem();
    }

    @Override // defpackage.hd3
    public void setAudioAttributes(yb ybVar, boolean z) {
        this.player.setAudioAttributes(ybVar, z);
    }

    @Override // defpackage.hd3
    @Deprecated
    public void setDeviceMuted(boolean z) {
        this.player.setDeviceMuted(z);
    }

    @Override // defpackage.hd3
    @Deprecated
    public void setDeviceVolume(int i) {
        this.player.setDeviceVolume(i);
    }

    @Override // defpackage.hd3
    public void setMediaItem(fg2 fg2Var) {
        this.player.setMediaItem(fg2Var);
    }

    @Override // defpackage.hd3
    public void setMediaItems(List list, boolean z) {
        this.player.setMediaItems(list, z);
    }

    @Override // defpackage.hd3
    public void setPlayWhenReady(boolean z) {
        this.player.setPlayWhenReady(z);
    }

    @Override // defpackage.hd3
    public void setPlaybackParameters(dc3 dc3Var) {
        this.player.setPlaybackParameters(dc3Var);
    }

    @Override // defpackage.hd3
    public void setPlaybackSpeed(float f) {
        this.player.setPlaybackSpeed(f);
    }

    @Override // defpackage.hd3
    public void setPlaylistMetadata(ph2 ph2Var) {
        this.player.setPlaylistMetadata(ph2Var);
    }

    @Override // defpackage.hd3
    public void setRepeatMode(int i) {
        this.player.setRepeatMode(i);
    }

    @Override // defpackage.hd3
    public void setShuffleModeEnabled(boolean z) {
        this.player.setShuffleModeEnabled(z);
    }

    @Override // defpackage.hd3
    public void setTrackSelectionParameters(lr4 lr4Var) {
        this.player.setTrackSelectionParameters(lr4Var);
    }

    @Override // defpackage.hd3
    public void setVideoSurface(Surface surface) {
        this.player.setVideoSurface(surface);
    }

    @Override // defpackage.hd3
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // defpackage.hd3
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        this.player.setVideoSurfaceView(surfaceView);
    }

    @Override // defpackage.hd3
    public void setVideoTextureView(TextureView textureView) {
        this.player.setVideoTextureView(textureView);
    }

    @Override // defpackage.hd3
    public void setVolume(float f) {
        this.player.setVolume(f);
    }

    @Override // defpackage.hd3
    public void stop() {
        this.player.stop();
    }

    @Override // defpackage.hd3
    public void unmute() {
        this.player.unmute();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements hd3.d {
        public final g51 f;
        public final hd3.d g;

        public a(g51 g51Var, hd3.d dVar) {
            this.f = g51Var;
            this.g = dVar;
        }

        @Override // hd3.d
        public void onAudioAttributesChanged(yb ybVar) {
            this.g.onAudioAttributesChanged(ybVar);
        }

        @Override // hd3.d
        public void onAudioSessionIdChanged(int i) {
            this.g.onAudioSessionIdChanged(i);
        }

        @Override // hd3.d
        public void onAvailableCommandsChanged(hd3.b bVar) {
            this.g.onAvailableCommandsChanged(bVar);
        }

        @Override // hd3.d
        public void onCues(List list) {
            this.g.onCues(list);
        }

        @Override // hd3.d
        public void onDeviceInfoChanged(kk0 kk0Var) {
            this.g.onDeviceInfoChanged(kk0Var);
        }

        @Override // hd3.d
        public void onDeviceVolumeChanged(int i, boolean z) {
            this.g.onDeviceVolumeChanged(i, z);
        }

        @Override // hd3.d
        public void onEvents(hd3 hd3Var, hd3.c cVar) {
            this.g.onEvents(this.f, cVar);
        }

        @Override // hd3.d
        public void onIsLoadingChanged(boolean z) {
            this.g.onIsLoadingChanged(z);
        }

        @Override // hd3.d
        public void onIsPlayingChanged(boolean z) {
            this.g.onIsPlayingChanged(z);
        }

        @Override // hd3.d
        public void onLoadingChanged(boolean z) {
            this.g.onIsLoadingChanged(z);
        }

        @Override // hd3.d
        public void onMaxSeekToPreviousPositionChanged(long j) {
            this.g.onMaxSeekToPreviousPositionChanged(j);
        }

        @Override // hd3.d
        public void onMediaItemTransition(fg2 fg2Var, int i) {
            this.g.onMediaItemTransition(fg2Var, i);
        }

        @Override // hd3.d
        public void onMediaMetadataChanged(ph2 ph2Var) {
            this.g.onMediaMetadataChanged(ph2Var);
        }

        @Override // hd3.d
        public void onMetadata(xs2 xs2Var) {
            this.g.onMetadata(xs2Var);
        }

        @Override // hd3.d
        public void onPlayWhenReadyChanged(boolean z, int i) {
            this.g.onPlayWhenReadyChanged(z, i);
        }

        @Override // hd3.d
        public void onPlaybackParametersChanged(dc3 dc3Var) {
            this.g.onPlaybackParametersChanged(dc3Var);
        }

        @Override // hd3.d
        public void onPlaybackStateChanged(int i) {
            this.g.onPlaybackStateChanged(i);
        }

        @Override // hd3.d
        public void onPlaybackSuppressionReasonChanged(int i) {
            this.g.onPlaybackSuppressionReasonChanged(i);
        }

        @Override // hd3.d
        public void onPlayerError(ac3 ac3Var) {
            this.g.onPlayerError(ac3Var);
        }

        @Override // hd3.d
        public void onPlayerErrorChanged(ac3 ac3Var) {
            this.g.onPlayerErrorChanged(ac3Var);
        }

        @Override // hd3.d
        public void onPlayerStateChanged(boolean z, int i) {
            this.g.onPlayerStateChanged(z, i);
        }

        @Override // hd3.d
        public void onPlaylistMetadataChanged(ph2 ph2Var) {
            this.g.onPlaylistMetadataChanged(ph2Var);
        }

        @Override // hd3.d
        public void onPositionDiscontinuity(int i) {
            this.g.onPositionDiscontinuity(i);
        }

        @Override // hd3.d
        public void onRenderedFirstFrame() {
            this.g.onRenderedFirstFrame();
        }

        @Override // hd3.d
        public void onRepeatModeChanged(int i) {
            this.g.onRepeatModeChanged(i);
        }

        @Override // hd3.d
        public void onSeekBackIncrementChanged(long j) {
            this.g.onSeekBackIncrementChanged(j);
        }

        @Override // hd3.d
        public void onSeekForwardIncrementChanged(long j) {
            this.g.onSeekForwardIncrementChanged(j);
        }

        @Override // hd3.d
        public void onShuffleModeEnabledChanged(boolean z) {
            this.g.onShuffleModeEnabledChanged(z);
        }

        @Override // hd3.d
        public void onSkipSilenceEnabledChanged(boolean z) {
            this.g.onSkipSilenceEnabledChanged(z);
        }

        @Override // hd3.d
        public void onSurfaceSizeChanged(int i, int i2) {
            this.g.onSurfaceSizeChanged(i, i2);
        }

        @Override // hd3.d
        public void onTimelineChanged(no4 no4Var, int i) {
            this.g.onTimelineChanged(no4Var, i);
        }

        @Override // hd3.d
        public void onTrackSelectionParametersChanged(lr4 lr4Var) {
            this.g.onTrackSelectionParametersChanged(lr4Var);
        }

        @Override // hd3.d
        public void onTracksChanged(xr4 xr4Var) {
            this.g.onTracksChanged(xr4Var);
        }

        @Override // hd3.d
        public void onVideoSizeChanged(e35 e35Var) {
            this.g.onVideoSizeChanged(e35Var);
        }

        @Override // hd3.d
        public void onVolumeChanged(float f) {
            this.g.onVolumeChanged(f);
        }

        @Override // hd3.d
        public void onCues(w50 w50Var) {
            this.g.onCues(w50Var);
        }

        @Override // hd3.d
        public void onPositionDiscontinuity(hd3.e eVar, hd3.e eVar2, int i) {
            this.g.onPositionDiscontinuity(eVar, eVar2, i);
        }
    }

    @Override // defpackage.hd3
    public void addMediaItem(int i, fg2 fg2Var) {
        this.player.addMediaItem(i, fg2Var);
    }

    @Override // defpackage.hd3
    public void addMediaItems(int i, List<fg2> list) {
        this.player.addMediaItems(i, list);
    }

    @Override // defpackage.hd3
    public void clearVideoSurface(Surface surface) {
        this.player.clearVideoSurface(surface);
    }

    @Override // defpackage.hd3
    public void decreaseDeviceVolume(int i) {
        this.player.decreaseDeviceVolume(i);
    }

    @Override // defpackage.hd3
    public void increaseDeviceVolume(int i) {
        this.player.increaseDeviceVolume(i);
    }

    @Override // defpackage.hd3
    public void seekTo(int i, long j) {
        this.player.seekTo(i, j);
    }

    @Override // defpackage.hd3
    public void seekToDefaultPosition(int i) {
        this.player.seekToDefaultPosition(i);
    }

    @Override // defpackage.hd3
    public void setDeviceMuted(boolean z, int i) {
        this.player.setDeviceMuted(z, i);
    }

    @Override // defpackage.hd3
    public void setDeviceVolume(int i, int i2) {
        this.player.setDeviceVolume(i, i2);
    }

    @Override // defpackage.hd3
    public void setMediaItem(fg2 fg2Var, long j) {
        this.player.setMediaItem(fg2Var, j);
    }

    @Override // defpackage.hd3
    public void setMediaItems(List list, int i, long j) {
        this.player.setMediaItems(list, i, j);
    }

    @Override // defpackage.hd3
    public void setMediaItem(fg2 fg2Var, boolean z) {
        this.player.setMediaItem(fg2Var, z);
    }
}

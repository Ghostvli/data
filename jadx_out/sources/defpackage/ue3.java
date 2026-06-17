package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.session.b0;
import defpackage.fg2;
import defpackage.hd3;
import defpackage.no4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ue3 extends g51 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends no4 {
        public static final Object k = new Object();
        public final fg2 e;
        public final boolean f;
        public final boolean g;
        public final boolean h = false;
        public final fg2.g i;
        public final long j;

        public a(ue3 ue3Var) {
            this.e = ue3Var.getCurrentMediaItem();
            this.f = ue3Var.isCurrentMediaItemSeekable();
            this.g = ue3Var.isCurrentMediaItemDynamic();
            this.i = ue3Var.isCurrentMediaItemLive() ? fg2.g.f : null;
            this.j = fy4.c1(ue3Var.getContentDuration());
        }

        @Override // defpackage.no4
        public int h(Object obj) {
            return k.equals(obj) ? 0 : -1;
        }

        @Override // defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            Object obj = k;
            bVar.u(obj, obj, 0, this.j, 0L);
            bVar.f = this.h;
            return bVar;
        }

        @Override // defpackage.no4
        public int o() {
            return 1;
        }

        @Override // defpackage.no4
        public Object s(int i) {
            return k;
        }

        @Override // defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            dVar.h(k, this.e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f, this.g, this.i, 0L, this.j, 0, 0, 0L);
            dVar.k = this.h;
            return dVar;
        }

        @Override // defpackage.no4
        public int v() {
            return 1;
        }
    }

    public ue3(hd3 hd3Var) {
        super(hd3Var);
    }

    private void t() {
        gg3.v(Looper.myLooper() == getApplicationLooper());
    }

    @Override // defpackage.g51, defpackage.hd3
    public void addListener(hd3.d dVar) {
        t();
        super.addListener(dVar);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void addMediaItem(fg2 fg2Var) {
        t();
        super.addMediaItem(fg2Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void addMediaItems(List list) {
        t();
        super.addMediaItems(list);
    }

    public b0 b() {
        return new b0(getPlayerError(), 0, d(), c(), c(), 0, getPlaybackParameters(), getRepeatMode(), getShuffleModeEnabled(), getVideoSize(), h(), 0, m(), n(), 1.0f, e(), 0, f(), getDeviceInfo(), j(), p(), getPlayWhenReady(), 1, getPlaybackSuppressionReason(), getPlaybackState(), isPlaying(), isLoading(), l(), getSeekBackIncrement(), getSeekForwardIncrement(), getMaxSeekToPreviousPosition(), i(), getTrackSelectionParameters());
    }

    public hd3.e c() {
        boolean zIsCommandAvailable = isCommandAvailable(16);
        boolean zIsCommandAvailable2 = isCommandAvailable(17);
        int currentMediaItemIndex = zIsCommandAvailable2 ? getCurrentMediaItemIndex() : 0;
        gg3.v(currentMediaItemIndex >= 0);
        int currentPeriodIndex = zIsCommandAvailable2 ? getCurrentPeriodIndex() : 0;
        gg3.v(currentPeriodIndex >= 0);
        if (zIsCommandAvailable2) {
            no4 currentTimeline = getCurrentTimeline();
            if (!currentTimeline.w()) {
                gg3.v(currentMediaItemIndex < currentTimeline.v());
                no4.d dVarT = currentTimeline.t(currentMediaItemIndex, new no4.d());
                gg3.v(currentPeriodIndex == fy4.s(currentPeriodIndex, dVarT.n, dVarT.o));
            }
        }
        return new hd3.e(null, currentMediaItemIndex, zIsCommandAvailable ? getCurrentMediaItem() : null, null, currentPeriodIndex, zIsCommandAvailable ? getCurrentPosition() : 0L, zIsCommandAvailable ? getContentPosition() : 0L, zIsCommandAvailable ? getCurrentAdGroupIndex() : -1, zIsCommandAvailable ? getCurrentAdIndexInAdGroup() : -1);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void clearMediaItems() {
        t();
        super.clearMediaItems();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void clearVideoSurface() {
        t();
        super.clearVideoSurface();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        t();
        super.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        t();
        super.clearVideoSurfaceView(surfaceView);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void clearVideoTextureView(TextureView textureView) {
        t();
        super.clearVideoTextureView(textureView);
    }

    public c24 d() {
        boolean zIsCommandAvailable = isCommandAvailable(16);
        return new c24(c(), zIsCommandAvailable && isPlayingAd(), SystemClock.elapsedRealtime(), zIsCommandAvailable ? getDuration() : -9223372036854775807L, zIsCommandAvailable ? getBufferedPosition() : 0L, zIsCommandAvailable ? getBufferedPercentage() : 0, zIsCommandAvailable ? getTotalBufferedDuration() : 0L, zIsCommandAvailable ? getCurrentLiveOffset() : -9223372036854775807L, zIsCommandAvailable ? getContentDuration() : -9223372036854775807L, zIsCommandAvailable ? getContentBufferedPosition() : 0L);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void decreaseDeviceVolume() {
        t();
        super.decreaseDeviceVolume();
    }

    public yb e() {
        return isCommandAvailable(21) ? getAudioAttributes() : yb.i;
    }

    public w50 f() {
        return isCommandAvailable(28) ? getCurrentCues() : w50.d;
    }

    public fg2 g() {
        if (isCommandAvailable(16)) {
            return getCurrentMediaItem();
        }
        return null;
    }

    @Override // defpackage.g51, defpackage.hd3
    public yb getAudioAttributes() {
        t();
        return super.getAudioAttributes();
    }

    @Override // defpackage.g51, defpackage.hd3
    public hd3.b getAvailableCommands() {
        t();
        return super.getAvailableCommands();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getBufferedPercentage() {
        t();
        return super.getBufferedPercentage();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getBufferedPosition() {
        t();
        return super.getBufferedPosition();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getContentBufferedPosition() {
        t();
        return super.getContentBufferedPosition();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getContentDuration() {
        t();
        return super.getContentDuration();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getContentPosition() {
        t();
        return super.getContentPosition();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getCurrentAdGroupIndex() {
        t();
        return super.getCurrentAdGroupIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getCurrentAdIndexInAdGroup() {
        t();
        return super.getCurrentAdIndexInAdGroup();
    }

    @Override // defpackage.g51, defpackage.hd3
    public w50 getCurrentCues() {
        t();
        return super.getCurrentCues();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getCurrentLiveOffset() {
        t();
        return super.getCurrentLiveOffset();
    }

    @Override // defpackage.g51, defpackage.hd3
    public Object getCurrentManifest() {
        t();
        return super.getCurrentManifest();
    }

    @Override // defpackage.g51, defpackage.hd3
    public fg2 getCurrentMediaItem() {
        t();
        return super.getCurrentMediaItem();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getCurrentMediaItemIndex() {
        t();
        return super.getCurrentMediaItemIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getCurrentPeriodIndex() {
        t();
        return super.getCurrentPeriodIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getCurrentPosition() {
        t();
        return super.getCurrentPosition();
    }

    @Override // defpackage.g51, defpackage.hd3
    public no4 getCurrentTimeline() {
        t();
        return super.getCurrentTimeline();
    }

    @Override // defpackage.g51, defpackage.hd3
    public xr4 getCurrentTracks() {
        t();
        return super.getCurrentTracks();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getCurrentWindowIndex() {
        t();
        return super.getCurrentWindowIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public kk0 getDeviceInfo() {
        t();
        return super.getDeviceInfo();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getDeviceVolume() {
        t();
        return super.getDeviceVolume();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getDuration() {
        t();
        return super.getDuration();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getMaxSeekToPreviousPosition() {
        t();
        return super.getMaxSeekToPreviousPosition();
    }

    @Override // defpackage.g51, defpackage.hd3
    public fg2 getMediaItemAt(int i) {
        t();
        return super.getMediaItemAt(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getMediaItemCount() {
        t();
        return super.getMediaItemCount();
    }

    @Override // defpackage.g51, defpackage.hd3
    public ph2 getMediaMetadata() {
        t();
        return super.getMediaMetadata();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getNextMediaItemIndex() {
        t();
        return super.getNextMediaItemIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getNextWindowIndex() {
        t();
        return super.getNextWindowIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean getPlayWhenReady() {
        t();
        return super.getPlayWhenReady();
    }

    @Override // defpackage.g51, defpackage.hd3
    public dc3 getPlaybackParameters() {
        t();
        return super.getPlaybackParameters();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getPlaybackState() {
        t();
        return super.getPlaybackState();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getPlaybackSuppressionReason() {
        t();
        return super.getPlaybackSuppressionReason();
    }

    @Override // defpackage.g51, defpackage.hd3
    public ac3 getPlayerError() {
        t();
        return super.getPlayerError();
    }

    @Override // defpackage.g51, defpackage.hd3
    public ph2 getPlaylistMetadata() {
        t();
        return super.getPlaylistMetadata();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getPreviousMediaItemIndex() {
        t();
        return super.getPreviousMediaItemIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getPreviousWindowIndex() {
        t();
        return super.getPreviousWindowIndex();
    }

    @Override // defpackage.g51, defpackage.hd3
    public int getRepeatMode() {
        t();
        return super.getRepeatMode();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getSeekBackIncrement() {
        t();
        return super.getSeekBackIncrement();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getSeekForwardIncrement() {
        t();
        return super.getSeekForwardIncrement();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean getShuffleModeEnabled() {
        t();
        return super.getShuffleModeEnabled();
    }

    @Override // defpackage.g51, defpackage.hd3
    public d94 getSurfaceSize() {
        t();
        return super.getSurfaceSize();
    }

    @Override // defpackage.g51, defpackage.hd3
    public long getTotalBufferedDuration() {
        t();
        return super.getTotalBufferedDuration();
    }

    @Override // defpackage.g51, defpackage.hd3
    public lr4 getTrackSelectionParameters() {
        t();
        return super.getTrackSelectionParameters();
    }

    @Override // defpackage.g51, defpackage.hd3
    public e35 getVideoSize() {
        t();
        return super.getVideoSize();
    }

    @Override // defpackage.g51, defpackage.hd3
    public float getVolume() {
        t();
        return super.getVolume();
    }

    public no4 h() {
        return isCommandAvailable(17) ? getCurrentTimeline() : g() != null ? new a(this) : no4.a;
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean hasNextMediaItem() {
        t();
        return super.hasNextMediaItem();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean hasPreviousMediaItem() {
        t();
        return super.hasPreviousMediaItem();
    }

    public xr4 i() {
        return isCommandAvailable(30) ? getCurrentTracks() : xr4.b;
    }

    @Override // defpackage.g51, defpackage.hd3
    public void increaseDeviceVolume() {
        t();
        super.increaseDeviceVolume();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isCommandAvailable(int i) {
        t();
        return super.isCommandAvailable(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isCurrentMediaItemDynamic() {
        t();
        return super.isCurrentMediaItemDynamic();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isCurrentMediaItemLive() {
        t();
        return super.isCurrentMediaItemLive();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isCurrentMediaItemSeekable() {
        t();
        return super.isCurrentMediaItemSeekable();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isDeviceMuted() {
        t();
        return super.isDeviceMuted();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isLoading() {
        t();
        return super.isLoading();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isPlaying() {
        t();
        return super.isPlaying();
    }

    @Override // defpackage.g51, defpackage.hd3
    public boolean isPlayingAd() {
        t();
        return super.isPlayingAd();
    }

    public int j() {
        if (isCommandAvailable(23)) {
            return getDeviceVolume();
        }
        return 0;
    }

    public long k() {
        if (isCommandAvailable(16)) {
            return getDuration();
        }
        return -9223372036854775807L;
    }

    public ph2 l() {
        return isCommandAvailable(18) ? getMediaMetadata() : ph2.M;
    }

    public ph2 m() {
        return isCommandAvailable(18) ? getPlaylistMetadata() : ph2.M;
    }

    @Override // defpackage.g51, defpackage.hd3
    public void moveMediaItem(int i, int i2) {
        t();
        super.moveMediaItem(i, i2);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void moveMediaItems(int i, int i2, int i3) {
        t();
        super.moveMediaItems(i, i2, i3);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void mute() {
        t();
        super.mute();
    }

    public float n() {
        if (isCommandAvailable(22)) {
            return getVolume();
        }
        return 1.0f;
    }

    public boolean o() {
        return isCommandAvailable(16) && isCurrentMediaItemLive();
    }

    public boolean p() {
        return isCommandAvailable(23) && isDeviceMuted();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void pause() {
        t();
        super.pause();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void play() {
        t();
        super.play();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void prepare() {
        t();
        super.prepare();
    }

    public void q() {
        if (isCommandAvailable(1)) {
            play();
        }
    }

    public void r() {
        if (isCommandAvailable(2)) {
            prepare();
        }
    }

    @Override // defpackage.g51, defpackage.hd3
    public void release() {
        t();
        super.release();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void removeListener(hd3.d dVar) {
        t();
        super.removeListener(dVar);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void removeMediaItem(int i) {
        t();
        super.removeMediaItem(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void removeMediaItems(int i, int i2) {
        t();
        super.removeMediaItems(i, i2);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void replaceMediaItem(int i, fg2 fg2Var) {
        t();
        super.replaceMediaItem(i, fg2Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void replaceMediaItems(int i, int i2, List list) {
        t();
        super.replaceMediaItems(i, i2, list);
    }

    public void s() {
        if (isCommandAvailable(4)) {
            seekToDefaultPosition();
        }
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekBack() {
        t();
        super.seekBack();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekForward() {
        t();
        super.seekForward();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekTo(long j) {
        t();
        super.seekTo(j);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekToDefaultPosition(int i) {
        t();
        super.seekToDefaultPosition(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekToNext() {
        t();
        super.seekToNext();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekToNextMediaItem() {
        t();
        super.seekToNextMediaItem();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekToPrevious() {
        t();
        super.seekToPrevious();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekToPreviousMediaItem() {
        t();
        super.seekToPreviousMediaItem();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setDeviceMuted(boolean z) {
        t();
        super.setDeviceMuted(z);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setDeviceVolume(int i) {
        t();
        super.setDeviceVolume(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setMediaItem(fg2 fg2Var) {
        t();
        super.setMediaItem(fg2Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setMediaItems(List list, boolean z) {
        t();
        super.setMediaItems(list, z);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setPlayWhenReady(boolean z) {
        t();
        super.setPlayWhenReady(z);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setPlaybackParameters(dc3 dc3Var) {
        t();
        super.setPlaybackParameters(dc3Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setPlaybackSpeed(float f) {
        t();
        super.setPlaybackSpeed(f);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setPlaylistMetadata(ph2 ph2Var) {
        t();
        super.setPlaylistMetadata(ph2Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setRepeatMode(int i) {
        t();
        super.setRepeatMode(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setShuffleModeEnabled(boolean z) {
        t();
        super.setShuffleModeEnabled(z);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setTrackSelectionParameters(lr4 lr4Var) {
        t();
        super.setTrackSelectionParameters(lr4Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setVideoSurface(Surface surface) {
        t();
        super.setVideoSurface(surface);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        t();
        super.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        t();
        super.setVideoSurfaceView(surfaceView);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setVideoTextureView(TextureView textureView) {
        t();
        super.setVideoTextureView(textureView);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setVolume(float f) {
        t();
        super.setVolume(f);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void stop() {
        t();
        super.stop();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void unmute() {
        t();
        super.unmute();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void addMediaItem(int i, fg2 fg2Var) {
        t();
        super.addMediaItem(i, fg2Var);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void addMediaItems(int i, List list) {
        t();
        super.addMediaItems(i, list);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void clearVideoSurface(Surface surface) {
        t();
        super.clearVideoSurface(surface);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void decreaseDeviceVolume(int i) {
        t();
        super.decreaseDeviceVolume(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void increaseDeviceVolume(int i) {
        t();
        super.increaseDeviceVolume(i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekTo(int i, long j) {
        t();
        super.seekTo(i, j);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void seekToDefaultPosition() {
        t();
        super.seekToDefaultPosition();
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setDeviceMuted(boolean z, int i) {
        t();
        super.setDeviceMuted(z, i);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setDeviceVolume(int i, int i2) {
        t();
        super.setDeviceVolume(i, i2);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setMediaItem(fg2 fg2Var, long j) {
        t();
        super.setMediaItem(fg2Var, j);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setMediaItems(List list, int i, long j) {
        t();
        super.setMediaItems(list, i, j);
    }

    @Override // defpackage.g51, defpackage.hd3
    public void setMediaItem(fg2 fg2Var, boolean z) {
        t();
        super.setMediaItem(fg2Var, z);
    }
}

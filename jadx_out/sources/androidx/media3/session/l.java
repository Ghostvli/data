package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.session.l;
import defpackage.ac3;
import defpackage.b24;
import defpackage.d24;
import defpackage.d94;
import defpackage.dc3;
import defpackage.e24;
import defpackage.e35;
import defpackage.eo;
import defpackage.fa0;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.g20;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.jk;
import defpackage.kg2;
import defpackage.kk0;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.no4;
import defpackage.ph2;
import defpackage.w50;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yb;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class l implements hd3 {
    public final no4.d a;
    public boolean b;
    public final d c;
    public final c d;
    public final Handler e;
    public long f;
    public boolean g;
    public final int h;
    public final b i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Context a;
        public final e24 b;
        public jk f;
        public int g;
        public boolean i;
        public Bundle c = Bundle.EMPTY;
        public c d = new C0032a();
        public Looper e = fy4.f0();
        public long h = 100;

        /* JADX INFO: renamed from: androidx.media3.session.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0032a implements c {
            public C0032a() {
            }
        }

        public a(Context context, e24 e24Var) {
            this.a = (Context) gg3.q(context);
            this.b = (e24) gg3.q(e24Var);
        }

        public lu1 b() {
            final m mVar = new m(this.e);
            if (this.b.l() && this.f == null) {
                this.f = new eo(new fa0.b(this.a).g());
            }
            final l lVar = new l(this.a, this.b, this.c, this.d, this.e, mVar, this.f, this.g, this.h, this.i);
            fy4.o1(new Handler(this.e), new Runnable() { // from class: u82
                @Override // java.lang.Runnable
                public final void run() {
                    mVar.U(lVar);
                }
            });
            return mVar;
        }

        public a c(Looper looper) {
            this.e = (Looper) gg3.q(looper);
            return this;
        }

        public a d(Bundle bundle) {
            this.c = new Bundle((Bundle) gg3.q(bundle));
            return this;
        }

        public a e(c cVar) {
            this.d = (c) gg3.q(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        default lu1 A0(l lVar, y14 y14Var, Bundle bundle) {
            return x81.e(new d24(-6));
        }

        default void E0(l lVar, PendingIntent pendingIntent) {
        }

        default void F0(l lVar) {
        }

        default void H(l lVar, d0 d0Var) {
        }

        default void H0(l lVar, List list) {
        }

        default lu1 J0(l lVar, List list) {
            return x81.e(new d24(-6));
        }

        default void Q(l lVar, List list) {
        }

        default void S0(l lVar, Bundle bundle) {
        }

        default void V(l lVar, b24 b24Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        d0 a();

        void addListener(hd3.d dVar);

        void addMediaItem(int i, fg2 fg2Var);

        void addMediaItem(fg2 fg2Var);

        void addMediaItems(int i, List list);

        void addMediaItems(List list);

        void b();

        xi1 c();

        void clearMediaItems();

        void clearVideoSurface();

        void clearVideoSurface(Surface surface);

        void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(SurfaceView surfaceView);

        void clearVideoTextureView(TextureView textureView);

        Bundle d();

        void decreaseDeviceVolume();

        void decreaseDeviceVolume(int i);

        lu1 e(y14 y14Var, Bundle bundle);

        yb getAudioAttributes();

        int getAudioSessionId();

        hd3.b getAvailableCommands();

        int getBufferedPercentage();

        long getBufferedPosition();

        long getContentBufferedPosition();

        long getContentDuration();

        long getContentPosition();

        int getCurrentAdGroupIndex();

        int getCurrentAdIndexInAdGroup();

        w50 getCurrentCues();

        long getCurrentLiveOffset();

        int getCurrentMediaItemIndex();

        int getCurrentPeriodIndex();

        long getCurrentPosition();

        no4 getCurrentTimeline();

        xr4 getCurrentTracks();

        kk0 getDeviceInfo();

        int getDeviceVolume();

        long getDuration();

        long getMaxSeekToPreviousPosition();

        ph2 getMediaMetadata();

        int getNextMediaItemIndex();

        boolean getPlayWhenReady();

        dc3 getPlaybackParameters();

        int getPlaybackState();

        int getPlaybackSuppressionReason();

        ac3 getPlayerError();

        ph2 getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        long getSeekBackIncrement();

        long getSeekForwardIncrement();

        boolean getShuffleModeEnabled();

        d94 getSurfaceSize();

        long getTotalBufferedDuration();

        lr4 getTrackSelectionParameters();

        e35 getVideoSize();

        float getVolume();

        boolean hasNextMediaItem();

        boolean hasPreviousMediaItem();

        void increaseDeviceVolume();

        void increaseDeviceVolume(int i);

        boolean isConnected();

        boolean isDeviceMuted();

        boolean isLoading();

        boolean isPlaying();

        boolean isPlayingAd();

        void moveMediaItem(int i, int i2);

        void moveMediaItems(int i, int i2, int i3);

        void mute();

        void pause();

        void play();

        void prepare();

        void release();

        void removeListener(hd3.d dVar);

        void removeMediaItem(int i);

        void removeMediaItems(int i, int i2);

        void replaceMediaItem(int i, fg2 fg2Var);

        void replaceMediaItems(int i, int i2, List list);

        void seekBack();

        void seekForward();

        void seekTo(int i, long j);

        void seekTo(long j);

        void seekToDefaultPosition();

        void seekToDefaultPosition(int i);

        void seekToNext();

        void seekToNextMediaItem();

        void seekToPrevious();

        void seekToPreviousMediaItem();

        void setAudioAttributes(yb ybVar, boolean z);

        void setDeviceMuted(boolean z);

        void setDeviceMuted(boolean z, int i);

        void setDeviceVolume(int i);

        void setDeviceVolume(int i, int i2);

        void setMediaItem(fg2 fg2Var);

        void setMediaItem(fg2 fg2Var, long j);

        void setMediaItem(fg2 fg2Var, boolean z);

        void setMediaItems(List list, int i, long j);

        void setMediaItems(List list, boolean z);

        void setPlayWhenReady(boolean z);

        void setPlaybackParameters(dc3 dc3Var);

        void setPlaybackSpeed(float f);

        void setPlaylistMetadata(ph2 ph2Var);

        void setRepeatMode(int i);

        void setShuffleModeEnabled(boolean z);

        void setTrackSelectionParameters(lr4 lr4Var);

        void setVideoSurface(Surface surface);

        void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(SurfaceView surfaceView);

        void setVideoTextureView(TextureView textureView);

        void setVolume(float f);

        void stop();

        void unmute();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
    }

    public l(Context context, e24 e24Var, Bundle bundle, c cVar, Looper looper, b bVar, jk jkVar, int i, long j, boolean z) {
        gg3.r(context, "context must not be null");
        gg3.r(e24Var, "token must not be null");
        xz1.g("MediaController", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.0] [" + fy4.e + "]");
        this.a = new no4.d();
        this.f = -9223372036854775807L;
        this.d = cVar;
        this.e = new Handler(looper);
        this.i = bVar;
        this.h = i;
        d dVarD = d(context, e24Var, bundle, looper, jkVar, j, z);
        this.c = dVarD;
        dVarD.b();
    }

    public static /* synthetic */ void b(l lVar, c cVar) {
        lVar.getClass();
        cVar.F0(lVar);
    }

    public static lu1 c() {
        return x81.e(new d24(-100));
    }

    public static void m(Future future) {
        if (future.cancel(false)) {
            return;
        }
        try {
            ((l) x81.c(future)).release();
        } catch (CancellationException | ExecutionException e2) {
            xz1.j("MediaController", "MediaController future failed (so we couldn't release it)", e2);
        }
    }

    private void p() {
        gg3.w(Looper.myLooper() == getApplicationLooper(), "MediaController method is called from a wrong thread. See javadoc of MediaController for details.");
    }

    @Override // defpackage.hd3
    public final void addListener(hd3.d dVar) {
        gg3.r(dVar, "listener must not be null");
        this.c.addListener(dVar);
    }

    @Override // defpackage.hd3
    public final void addMediaItem(fg2 fg2Var) {
        p();
        if (j()) {
            this.c.addMediaItem(fg2Var);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring addMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void addMediaItems(List list) {
        p();
        if (j()) {
            this.c.addMediaItems(list);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        }
    }

    @Override // defpackage.hd3
    public final boolean canAdvertiseSession() {
        return false;
    }

    @Override // defpackage.hd3
    public final void clearMediaItems() {
        p();
        if (j()) {
            this.c.clearMediaItems();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring clearMediaItems().");
        }
    }

    @Override // defpackage.hd3
    public final void clearVideoSurface() {
        p();
        if (j()) {
            this.c.clearVideoSurface();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring clearVideoSurface().");
        }
    }

    @Override // defpackage.hd3
    public final void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        p();
        if (j()) {
            this.c.clearVideoSurfaceHolder(surfaceHolder);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring clearVideoSurfaceHolder().");
        }
    }

    @Override // defpackage.hd3
    public final void clearVideoSurfaceView(SurfaceView surfaceView) {
        p();
        if (j()) {
            this.c.clearVideoSurfaceView(surfaceView);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring clearVideoSurfaceView().");
        }
    }

    @Override // defpackage.hd3
    public final void clearVideoTextureView(TextureView textureView) {
        p();
        if (j()) {
            this.c.clearVideoTextureView(textureView);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring clearVideoTextureView().");
        }
    }

    public d d(Context context, e24 e24Var, Bundle bundle, Looper looper, jk jkVar, long j, boolean z) {
        return e24Var.l() ? new o(context, this, e24Var, bundle, looper, (jk) gg3.q(jkVar), j) : new n(context, this, e24Var, bundle, looper, z);
    }

    @Override // defpackage.hd3
    public final void decreaseDeviceVolume() {
        p();
        if (j()) {
            this.c.decreaseDeviceVolume();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        }
    }

    public final d0 e() {
        p();
        return !j() ? d0.b : this.c.a();
    }

    public Bundle f() {
        return this.c.d();
    }

    public int g() {
        return this.h;
    }

    @Override // defpackage.hd3
    public final Looper getApplicationLooper() {
        return this.e.getLooper();
    }

    @Override // defpackage.hd3
    public final yb getAudioAttributes() {
        p();
        return !j() ? yb.i : this.c.getAudioAttributes();
    }

    @Override // defpackage.hd3
    public final int getAudioSessionId() {
        p();
        if (j()) {
            return this.c.getAudioSessionId();
        }
        return 0;
    }

    @Override // defpackage.hd3
    public final hd3.b getAvailableCommands() {
        p();
        return !j() ? hd3.b.b : this.c.getAvailableCommands();
    }

    @Override // defpackage.hd3
    public final int getBufferedPercentage() {
        p();
        if (j()) {
            return this.c.getBufferedPercentage();
        }
        return 0;
    }

    @Override // defpackage.hd3
    public final long getBufferedPosition() {
        p();
        if (j()) {
            return this.c.getBufferedPosition();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final long getContentBufferedPosition() {
        p();
        if (j()) {
            return this.c.getContentBufferedPosition();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final long getContentDuration() {
        p();
        if (j()) {
            return this.c.getContentDuration();
        }
        return -9223372036854775807L;
    }

    @Override // defpackage.hd3
    public final long getContentPosition() {
        p();
        if (j()) {
            return this.c.getContentPosition();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final int getCurrentAdGroupIndex() {
        p();
        if (j()) {
            return this.c.getCurrentAdGroupIndex();
        }
        return -1;
    }

    @Override // defpackage.hd3
    public final int getCurrentAdIndexInAdGroup() {
        p();
        if (j()) {
            return this.c.getCurrentAdIndexInAdGroup();
        }
        return -1;
    }

    @Override // defpackage.hd3
    public final w50 getCurrentCues() {
        p();
        return j() ? this.c.getCurrentCues() : w50.d;
    }

    @Override // defpackage.hd3
    public final long getCurrentLiveOffset() {
        p();
        if (j()) {
            return this.c.getCurrentLiveOffset();
        }
        return -9223372036854775807L;
    }

    @Override // defpackage.hd3
    public final Object getCurrentManifest() {
        return null;
    }

    @Override // defpackage.hd3
    public final fg2 getCurrentMediaItem() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return null;
        }
        return currentTimeline.t(getCurrentMediaItemIndex(), this.a).c;
    }

    @Override // defpackage.hd3
    public final int getCurrentMediaItemIndex() {
        p();
        if (j()) {
            return this.c.getCurrentMediaItemIndex();
        }
        return -1;
    }

    @Override // defpackage.hd3
    public final int getCurrentPeriodIndex() {
        p();
        if (j()) {
            return this.c.getCurrentPeriodIndex();
        }
        return -1;
    }

    @Override // defpackage.hd3
    public final long getCurrentPosition() {
        p();
        if (j()) {
            return this.c.getCurrentPosition();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final no4 getCurrentTimeline() {
        p();
        return j() ? this.c.getCurrentTimeline() : no4.a;
    }

    @Override // defpackage.hd3
    public final xr4 getCurrentTracks() {
        p();
        return j() ? this.c.getCurrentTracks() : xr4.b;
    }

    @Override // defpackage.hd3
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // defpackage.hd3
    public final kk0 getDeviceInfo() {
        p();
        return !j() ? kk0.e : this.c.getDeviceInfo();
    }

    @Override // defpackage.hd3
    public final int getDeviceVolume() {
        p();
        if (j()) {
            return this.c.getDeviceVolume();
        }
        return 0;
    }

    @Override // defpackage.hd3
    public final long getDuration() {
        p();
        if (j()) {
            return this.c.getDuration();
        }
        return -9223372036854775807L;
    }

    @Override // defpackage.hd3
    public final long getMaxSeekToPreviousPosition() {
        p();
        if (j()) {
            return this.c.getMaxSeekToPreviousPosition();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final fg2 getMediaItemAt(int i) {
        return getCurrentTimeline().t(i, this.a).c;
    }

    @Override // defpackage.hd3
    public final int getMediaItemCount() {
        return getCurrentTimeline().v();
    }

    @Override // defpackage.hd3
    public final ph2 getMediaMetadata() {
        p();
        return j() ? this.c.getMediaMetadata() : ph2.M;
    }

    @Override // defpackage.hd3
    public final int getNextMediaItemIndex() {
        p();
        if (j()) {
            return this.c.getNextMediaItemIndex();
        }
        return -1;
    }

    @Override // defpackage.hd3
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override // defpackage.hd3
    public final boolean getPlayWhenReady() {
        p();
        return j() && this.c.getPlayWhenReady();
    }

    @Override // defpackage.hd3
    public final dc3 getPlaybackParameters() {
        p();
        return j() ? this.c.getPlaybackParameters() : dc3.d;
    }

    @Override // defpackage.hd3
    public final int getPlaybackState() {
        p();
        if (j()) {
            return this.c.getPlaybackState();
        }
        return 1;
    }

    @Override // defpackage.hd3
    public final int getPlaybackSuppressionReason() {
        p();
        if (j()) {
            return this.c.getPlaybackSuppressionReason();
        }
        return 0;
    }

    @Override // defpackage.hd3
    public final ac3 getPlayerError() {
        p();
        if (j()) {
            return this.c.getPlayerError();
        }
        return null;
    }

    @Override // defpackage.hd3
    public final ph2 getPlaylistMetadata() {
        p();
        return j() ? this.c.getPlaylistMetadata() : ph2.M;
    }

    @Override // defpackage.hd3
    public final int getPreviousMediaItemIndex() {
        p();
        if (j()) {
            return this.c.getPreviousMediaItemIndex();
        }
        return -1;
    }

    @Override // defpackage.hd3
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Override // defpackage.hd3
    public final int getRepeatMode() {
        p();
        if (j()) {
            return this.c.getRepeatMode();
        }
        return 0;
    }

    @Override // defpackage.hd3
    public final long getSeekBackIncrement() {
        p();
        if (j()) {
            return this.c.getSeekBackIncrement();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final long getSeekForwardIncrement() {
        p();
        if (j()) {
            return this.c.getSeekForwardIncrement();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final boolean getShuffleModeEnabled() {
        p();
        return j() && this.c.getShuffleModeEnabled();
    }

    @Override // defpackage.hd3
    public final d94 getSurfaceSize() {
        p();
        return j() ? this.c.getSurfaceSize() : d94.c;
    }

    @Override // defpackage.hd3
    public final long getTotalBufferedDuration() {
        p();
        if (j()) {
            return this.c.getTotalBufferedDuration();
        }
        return 0L;
    }

    @Override // defpackage.hd3
    public final lr4 getTrackSelectionParameters() {
        p();
        return !j() ? lr4.J : this.c.getTrackSelectionParameters();
    }

    @Override // defpackage.hd3
    public final e35 getVideoSize() {
        p();
        return j() ? this.c.getVideoSize() : e35.e;
    }

    @Override // defpackage.hd3
    public final float getVolume() {
        p();
        if (j()) {
            return this.c.getVolume();
        }
        return 1.0f;
    }

    public final xi1 h() {
        p();
        return j() ? this.c.c() : xi1.u();
    }

    @Override // defpackage.hd3
    public final boolean hasNextMediaItem() {
        p();
        return j() && this.c.hasNextMediaItem();
    }

    @Override // defpackage.hd3
    public final boolean hasPreviousMediaItem() {
        p();
        return j() && this.c.hasPreviousMediaItem();
    }

    public final long i() {
        return this.f;
    }

    @Override // defpackage.hd3
    public final void increaseDeviceVolume() {
        p();
        if (j()) {
            this.c.increaseDeviceVolume();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        }
    }

    @Override // defpackage.hd3
    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().c(i);
    }

    @Override // defpackage.hd3
    public final boolean isCurrentMediaItemDynamic() {
        p();
        no4 currentTimeline = getCurrentTimeline();
        return !currentTimeline.w() && currentTimeline.t(getCurrentMediaItemIndex(), this.a).i;
    }

    @Override // defpackage.hd3
    public final boolean isCurrentMediaItemLive() {
        p();
        no4 currentTimeline = getCurrentTimeline();
        return !currentTimeline.w() && currentTimeline.t(getCurrentMediaItemIndex(), this.a).g();
    }

    @Override // defpackage.hd3
    public final boolean isCurrentMediaItemSeekable() {
        p();
        no4 currentTimeline = getCurrentTimeline();
        return !currentTimeline.w() && currentTimeline.t(getCurrentMediaItemIndex(), this.a).h;
    }

    @Override // defpackage.hd3
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override // defpackage.hd3
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override // defpackage.hd3
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override // defpackage.hd3
    public final boolean isDeviceMuted() {
        p();
        if (j()) {
            return this.c.isDeviceMuted();
        }
        return false;
    }

    @Override // defpackage.hd3
    public final boolean isLoading() {
        p();
        return j() && this.c.isLoading();
    }

    @Override // defpackage.hd3
    public final boolean isPlaying() {
        p();
        return j() && this.c.isPlaying();
    }

    @Override // defpackage.hd3
    public final boolean isPlayingAd() {
        p();
        return j() && this.c.isPlayingAd();
    }

    public final boolean j() {
        return this.c.isConnected();
    }

    public final void k() {
        gg3.v(Looper.myLooper() == getApplicationLooper());
        gg3.v(!this.g);
        this.g = true;
        this.i.a();
    }

    public final void l(g20 g20Var) {
        gg3.v(Looper.myLooper() == getApplicationLooper());
        g20Var.accept(this.d);
    }

    @Override // defpackage.hd3
    public final void moveMediaItem(int i, int i2) {
        p();
        if (j()) {
            this.c.moveMediaItem(i, i2);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring moveMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void moveMediaItems(int i, int i2, int i3) {
        p();
        if (j()) {
            this.c.moveMediaItems(i, i2, i3);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring moveMediaItems().");
        }
    }

    @Override // defpackage.hd3
    public final void mute() {
        p();
        if (j()) {
            this.c.mute();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring mute().");
        }
    }

    public final void n(Runnable runnable) {
        fy4.o1(this.e, runnable);
    }

    public final lu1 o(y14 y14Var, Bundle bundle) {
        p();
        gg3.r(y14Var, "command must not be null");
        gg3.e(y14Var.a == 0, "command must be a custom command");
        return j() ? this.c.e(y14Var, bundle) : c();
    }

    @Override // defpackage.hd3
    public final void pause() {
        p();
        if (j()) {
            this.c.pause();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring pause().");
        }
    }

    @Override // defpackage.hd3
    public final void play() {
        p();
        if (j()) {
            this.c.play();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring play().");
        }
    }

    @Override // defpackage.hd3
    public final void prepare() {
        p();
        if (j()) {
            this.c.prepare();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring prepare().");
        }
    }

    @Override // defpackage.hd3
    public final void release() {
        p();
        if (this.b) {
            return;
        }
        xz1.g("MediaController", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.0] [" + fy4.e + "] [" + kg2.b() + "]");
        this.b = true;
        this.e.removeCallbacksAndMessages(null);
        try {
            this.c.release();
        } catch (Exception e2) {
            xz1.c("MediaController", "Exception while releasing impl", e2);
        }
        if (this.g) {
            l(new g20() { // from class: t82
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    l.b(this.a, (l.c) obj);
                }
            });
        } else {
            this.g = true;
            this.i.b();
        }
    }

    @Override // defpackage.hd3
    public final void removeListener(hd3.d dVar) {
        p();
        gg3.r(dVar, "listener must not be null");
        this.c.removeListener(dVar);
    }

    @Override // defpackage.hd3
    public final void removeMediaItem(int i) {
        p();
        if (j()) {
            this.c.removeMediaItem(i);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring removeMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void removeMediaItems(int i, int i2) {
        p();
        if (j()) {
            this.c.removeMediaItems(i, i2);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring removeMediaItems().");
        }
    }

    @Override // defpackage.hd3
    public final void replaceMediaItem(int i, fg2 fg2Var) {
        p();
        if (j()) {
            this.c.replaceMediaItem(i, fg2Var);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring replaceMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void replaceMediaItems(int i, int i2, List list) {
        p();
        if (j()) {
            this.c.replaceMediaItems(i, i2, list);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring replaceMediaItems().");
        }
    }

    @Override // defpackage.hd3
    public final void seekBack() {
        p();
        if (j()) {
            this.c.seekBack();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekBack().");
        }
    }

    @Override // defpackage.hd3
    public final void seekForward() {
        p();
        if (j()) {
            this.c.seekForward();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekForward().");
        }
    }

    @Override // defpackage.hd3
    public final void seekTo(long j) {
        p();
        if (j()) {
            this.c.seekTo(j);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // defpackage.hd3
    public final void seekToDefaultPosition() {
        p();
        if (j()) {
            this.c.seekToDefaultPosition();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // defpackage.hd3
    public final void seekToNext() {
        p();
        if (j()) {
            this.c.seekToNext();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekToNext().");
        }
    }

    @Override // defpackage.hd3
    public final void seekToNextMediaItem() {
        p();
        if (j()) {
            this.c.seekToNextMediaItem();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekToNextMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void seekToPrevious() {
        p();
        if (j()) {
            this.c.seekToPrevious();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekToPrevious().");
        }
    }

    @Override // defpackage.hd3
    public final void seekToPreviousMediaItem() {
        p();
        if (j()) {
            this.c.seekToPreviousMediaItem();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekToPreviousMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void setAudioAttributes(yb ybVar, boolean z) {
        p();
        if (j()) {
            this.c.setAudioAttributes(ybVar, z);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setAudioAttributes().");
        }
    }

    @Override // defpackage.hd3
    public final void setDeviceMuted(boolean z) {
        p();
        if (j()) {
            this.c.setDeviceMuted(z);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        }
    }

    @Override // defpackage.hd3
    public final void setDeviceVolume(int i) {
        p();
        if (j()) {
            this.c.setDeviceVolume(i);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        }
    }

    @Override // defpackage.hd3
    public final void setMediaItem(fg2 fg2Var) {
        p();
        gg3.r(fg2Var, "mediaItems must not be null");
        if (j()) {
            this.c.setMediaItem(fg2Var);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        }
    }

    @Override // defpackage.hd3
    public final void setMediaItems(List list, boolean z) {
        p();
        gg3.r(list, "mediaItems must not be null");
        for (int i = 0; i < list.size(); i++) {
            gg3.g(list.get(i) != null, "items must not contain null, index=%s", i);
        }
        if (j()) {
            this.c.setMediaItems(list, z);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // defpackage.hd3
    public final void setPlayWhenReady(boolean z) {
        p();
        if (j()) {
            this.c.setPlayWhenReady(z);
        }
    }

    @Override // defpackage.hd3
    public final void setPlaybackParameters(dc3 dc3Var) {
        p();
        gg3.r(dc3Var, "playbackParameters must not be null");
        if (j()) {
            this.c.setPlaybackParameters(dc3Var);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setPlaybackParameters().");
        }
    }

    @Override // defpackage.hd3
    public final void setPlaybackSpeed(float f) {
        p();
        if (j()) {
            this.c.setPlaybackSpeed(f);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setPlaybackSpeed().");
        }
    }

    @Override // defpackage.hd3
    public final void setPlaylistMetadata(ph2 ph2Var) {
        p();
        gg3.r(ph2Var, "playlistMetadata must not be null");
        if (j()) {
            this.c.setPlaylistMetadata(ph2Var);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setPlaylistMetadata().");
        }
    }

    @Override // defpackage.hd3
    public final void setRepeatMode(int i) {
        p();
        if (j()) {
            this.c.setRepeatMode(i);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setRepeatMode().");
        }
    }

    @Override // defpackage.hd3
    public final void setShuffleModeEnabled(boolean z) {
        p();
        if (j()) {
            this.c.setShuffleModeEnabled(z);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setShuffleMode().");
        }
    }

    @Override // defpackage.hd3
    public final void setTrackSelectionParameters(lr4 lr4Var) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        this.c.setTrackSelectionParameters(lr4Var);
    }

    @Override // defpackage.hd3
    public final void setVideoSurface(Surface surface) {
        p();
        if (j()) {
            this.c.setVideoSurface(surface);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setVideoSurface().");
        }
    }

    @Override // defpackage.hd3
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        p();
        if (j()) {
            this.c.setVideoSurfaceHolder(surfaceHolder);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setVideoSurfaceHolder().");
        }
    }

    @Override // defpackage.hd3
    public final void setVideoSurfaceView(SurfaceView surfaceView) {
        p();
        if (j()) {
            this.c.setVideoSurfaceView(surfaceView);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setVideoSurfaceView().");
        }
    }

    @Override // defpackage.hd3
    public final void setVideoTextureView(TextureView textureView) {
        p();
        if (j()) {
            this.c.setVideoTextureView(textureView);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setVideoTextureView().");
        }
    }

    @Override // defpackage.hd3
    public final void setVolume(float f) {
        p();
        gg3.e(f >= 0.0f && f <= 1.0f, "volume must be between 0 and 1");
        if (j()) {
            this.c.setVolume(f);
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring setVolume().");
        }
    }

    @Override // defpackage.hd3
    public final void stop() {
        p();
        if (j()) {
            this.c.stop();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring stop().");
        }
    }

    @Override // defpackage.hd3
    public final void unmute() {
        p();
        if (j()) {
            this.c.unmute();
        } else {
            xz1.i("MediaController", "The controller is not connected. Ignoring unmute().");
        }
    }

    @Override // defpackage.hd3
    public final void addMediaItem(int i, fg2 fg2Var) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring addMediaItem().");
        } else {
            this.c.addMediaItem(i, fg2Var);
        }
    }

    @Override // defpackage.hd3
    public final void addMediaItems(int i, List list) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        } else {
            this.c.addMediaItems(i, list);
        }
    }

    @Override // defpackage.hd3
    public final void clearVideoSurface(Surface surface) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring clearVideoSurface().");
        } else {
            this.c.clearVideoSurface(surface);
        }
    }

    @Override // defpackage.hd3
    public final void decreaseDeviceVolume(int i) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        } else {
            this.c.decreaseDeviceVolume(i);
        }
    }

    @Override // defpackage.hd3
    public final void increaseDeviceVolume(int i) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        } else {
            this.c.increaseDeviceVolume(i);
        }
    }

    @Override // defpackage.hd3
    public final void seekTo(int i, long j) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.c.seekTo(i, j);
        }
    }

    @Override // defpackage.hd3
    public final void seekToDefaultPosition(int i) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.c.seekToDefaultPosition(i);
        }
    }

    @Override // defpackage.hd3
    public final void setDeviceMuted(boolean z, int i) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        } else {
            this.c.setDeviceMuted(z, i);
        }
    }

    @Override // defpackage.hd3
    public final void setDeviceVolume(int i, int i2) {
        p();
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        } else {
            this.c.setDeviceVolume(i, i2);
        }
    }

    @Override // defpackage.hd3
    public final void setMediaItem(fg2 fg2Var, long j) {
        p();
        gg3.r(fg2Var, "mediaItems must not be null");
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        } else {
            this.c.setMediaItem(fg2Var, j);
        }
    }

    @Override // defpackage.hd3
    public final void setMediaItem(fg2 fg2Var, boolean z) {
        p();
        gg3.r(fg2Var, "mediaItems must not be null");
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.c.setMediaItem(fg2Var, z);
        }
    }

    @Override // defpackage.hd3
    public final void setMediaItems(List list, int i, long j) {
        p();
        gg3.r(list, "mediaItems must not be null");
        for (int i2 = 0; i2 < list.size(); i2++) {
            gg3.g(list.get(i2) != null, "items must not contain null, index=%s", i2);
        }
        if (!j()) {
            xz1.i("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.c.setMediaItems(list, i, j);
        }
    }
}

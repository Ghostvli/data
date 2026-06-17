package defpackage;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import defpackage.o21;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface hd3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final o21 a;

        public c(o21 o21Var) {
            this.a = o21Var;
        }

        public boolean a(int... iArr) {
            return this.a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.a.equals(((c) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        default void onAudioAttributesChanged(yb ybVar) {
        }

        default void onAudioSessionIdChanged(int i) {
        }

        default void onAvailableCommandsChanged(b bVar) {
        }

        default void onCues(List list) {
        }

        default void onDeviceInfoChanged(kk0 kk0Var) {
        }

        default void onDeviceVolumeChanged(int i, boolean z) {
        }

        default void onEvents(hd3 hd3Var, c cVar) {
        }

        default void onIsLoadingChanged(boolean z) {
        }

        default void onIsPlayingChanged(boolean z) {
        }

        default void onLoadingChanged(boolean z) {
        }

        default void onMaxSeekToPreviousPositionChanged(long j) {
        }

        default void onMediaItemTransition(fg2 fg2Var, int i) {
        }

        default void onMediaMetadataChanged(ph2 ph2Var) {
        }

        default void onMetadata(xs2 xs2Var) {
        }

        default void onPlayWhenReadyChanged(boolean z, int i) {
        }

        default void onPlaybackParametersChanged(dc3 dc3Var) {
        }

        default void onPlaybackStateChanged(int i) {
        }

        default void onPlaybackSuppressionReasonChanged(int i) {
        }

        default void onPlayerError(ac3 ac3Var) {
        }

        default void onPlayerErrorChanged(ac3 ac3Var) {
        }

        default void onPlayerStateChanged(boolean z, int i) {
        }

        default void onPlaylistMetadataChanged(ph2 ph2Var) {
        }

        default void onPositionDiscontinuity(int i) {
        }

        default void onRenderedFirstFrame() {
        }

        default void onRepeatModeChanged(int i) {
        }

        default void onSeekBackIncrementChanged(long j) {
        }

        default void onSeekForwardIncrementChanged(long j) {
        }

        default void onShuffleModeEnabledChanged(boolean z) {
        }

        default void onSkipSilenceEnabledChanged(boolean z) {
        }

        default void onSurfaceSizeChanged(int i, int i2) {
        }

        default void onTimelineChanged(no4 no4Var, int i) {
        }

        default void onTrackSelectionParametersChanged(lr4 lr4Var) {
        }

        default void onTracksChanged(xr4 xr4Var) {
        }

        default void onVideoSizeChanged(e35 e35Var) {
        }

        default void onVolumeChanged(float f) {
        }

        default void onCues(w50 w50Var) {
        }

        default void onPositionDiscontinuity(e eVar, e eVar2, int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public static final String k = fy4.N0(0);
        public static final String l = fy4.N0(1);
        public static final String m = fy4.N0(2);
        public static final String n = fy4.N0(3);
        public static final String o = fy4.N0(4);
        public static final String p = fy4.N0(5);
        public static final String q = fy4.N0(6);
        public final Object a;
        public final int b;
        public final int c;
        public final fg2 d;
        public final Object e;
        public final int f;
        public final long g;
        public final long h;
        public final int i;
        public final int j;

        public e(Object obj, int i, fg2 fg2Var, Object obj2, int i2, long j, long j2, int i3, int i4) {
            gg3.d(i >= 0);
            gg3.d(i2 >= 0);
            this.a = obj;
            this.b = i;
            this.c = i;
            this.d = fg2Var;
            this.e = obj2;
            this.f = i2;
            this.g = j;
            this.h = j2;
            this.i = i3;
            this.j = i4;
        }

        public static e c(Bundle bundle, int i) {
            int iMax = Math.max(0, bundle.getInt(k, 0));
            Bundle bundle2 = bundle.getBundle(l);
            return new e(null, iMax, bundle2 == null ? null : fg2.b(bundle2, i), null, Math.max(0, bundle.getInt(m, 0)), bundle.getLong(n, 0L), bundle.getLong(o, 0L), bundle.getInt(p, -1), bundle.getInt(q, -1));
        }

        public boolean a(e eVar) {
            return this.c == eVar.c && this.f == eVar.f && this.g == eVar.g && this.h == eVar.h && this.i == eVar.i && this.j == eVar.j && Objects.equals(this.d, eVar.d);
        }

        public e b(boolean z, boolean z2) {
            if (z && z2) {
                return this;
            }
            return new e(this.a, z2 ? this.c : 0, z ? this.d : null, this.e, z2 ? this.f : 0, z ? this.g : 0L, z ? this.h : 0L, z ? this.i : -1, z ? this.j : -1);
        }

        public Bundle d(int i) {
            Bundle bundle = new Bundle();
            if (i < 3 || this.c != 0) {
                bundle.putInt(k, this.c);
            }
            fg2 fg2Var = this.d;
            if (fg2Var != null) {
                bundle.putBundle(l, fg2Var.e(i));
            }
            if (i < 3 || this.f != 0) {
                bundle.putInt(m, this.f);
            }
            if (i < 3 || this.g != 0) {
                bundle.putLong(n, this.g);
            }
            if (i < 3 || this.h != 0) {
                bundle.putLong(o, this.h);
            }
            int i2 = this.i;
            if (i2 != -1) {
                bundle.putInt(p, i2);
            }
            int i3 = this.j;
            if (i3 != -1) {
                bundle.putInt(q, i3);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && e.class == obj.getClass()) {
                e eVar = (e) obj;
                if (a(eVar) && Objects.equals(this.a, eVar.a) && Objects.equals(this.e, eVar.e)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.a, Integer.valueOf(this.c), this.d, this.e, Integer.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j));
        }

        public String toString() {
            String str = "mediaItem=" + this.c + ", period=" + this.f + ", pos=" + this.g;
            if (this.i == -1) {
                return str;
            }
            return str + ", contentPos=" + this.h + ", adGroup=" + this.i + ", ad=" + this.j;
        }
    }

    void addListener(d dVar);

    void addMediaItem(int i, fg2 fg2Var);

    void addMediaItem(fg2 fg2Var);

    void addMediaItems(int i, List list);

    void addMediaItems(List list);

    boolean canAdvertiseSession();

    void clearMediaItems();

    void clearVideoSurface();

    void clearVideoSurface(Surface surface);

    void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    void decreaseDeviceVolume();

    void decreaseDeviceVolume(int i);

    Looper getApplicationLooper();

    yb getAudioAttributes();

    int getAudioSessionId();

    b getAvailableCommands();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    w50 getCurrentCues();

    long getCurrentLiveOffset();

    Object getCurrentManifest();

    fg2 getCurrentMediaItem();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    no4 getCurrentTimeline();

    xr4 getCurrentTracks();

    int getCurrentWindowIndex();

    kk0 getDeviceInfo();

    int getDeviceVolume();

    long getDuration();

    long getMaxSeekToPreviousPosition();

    fg2 getMediaItemAt(int i);

    int getMediaItemCount();

    ph2 getMediaMetadata();

    int getNextMediaItemIndex();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    dc3 getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    ac3 getPlayerError();

    ph2 getPlaylistMetadata();

    int getPreviousMediaItemIndex();

    int getPreviousWindowIndex();

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

    boolean isCommandAvailable(int i);

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowLive();

    boolean isCurrentWindowSeekable();

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

    void removeListener(d dVar);

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

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final b b = new a().f();
        public static final String c = fy4.N0(0);
        public final o21 a;

        public b(o21 o21Var) {
            this.a = o21Var;
        }

        public static b e(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(c);
            if (integerArrayList == null) {
                return b;
            }
            a aVar = new a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                aVar.a(integerArrayList.get(i).intValue());
            }
            return aVar.f();
        }

        public a b() {
            return new a();
        }

        public boolean c(int i) {
            return this.a.a(i);
        }

        public boolean d(int... iArr) {
            return this.a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int f(int i) {
            return this.a.c(i);
        }

        public int g() {
            return this.a.d();
        }

        public Bundle h() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < this.a.d(); i++) {
                arrayList.add(Integer.valueOf(this.a.c(i)));
            }
            bundle.putIntegerArrayList(c, arrayList);
            return bundle;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public static final int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};
            public final o21.b a;

            public a(b bVar) {
                o21.b bVar2 = new o21.b();
                this.a = bVar2;
                bVar2.b(bVar.a);
            }

            public a a(int i) {
                this.a.a(i);
                return this;
            }

            public a b(b bVar) {
                this.a.b(bVar.a);
                return this;
            }

            public a c(int... iArr) {
                this.a.c(iArr);
                return this;
            }

            public a d() {
                this.a.c(b);
                return this;
            }

            public a e(int i, boolean z) {
                this.a.d(i, z);
                return this;
            }

            public b f() {
                return new b(this.a.e());
            }

            public a g(int i, boolean z) {
                this.a.g(i, z);
                return this;
            }

            public a() {
                this.a = new o21.b();
            }
        }
    }
}

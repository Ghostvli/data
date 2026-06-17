package com.fongmi.android.tv.service;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.a;
import androidx.media3.session.e;
import androidx.media3.session.j;
import androidx.media3.session.u;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.service.PlaybackService;
import defpackage.ac3;
import defpackage.c00;
import defpackage.dc3;
import defpackage.e35;
import defpackage.fg2;
import defpackage.fl3;
import defpackage.g51;
import defpackage.hd3;
import defpackage.il;
import defpackage.kk0;
import defpackage.lh4;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.me3;
import defpackage.no4;
import defpackage.om3;
import defpackage.ph2;
import defpackage.t14;
import defpackage.t2;
import defpackage.ul4;
import defpackage.uu0;
import defpackage.vb3;
import defpackage.w50;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xs2;
import defpackage.y14;
import defpackage.yb;
import defpackage.yn3;
import j$.util.stream.Stream$EL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class PlaybackService extends MediaLibraryService implements MediaLibraryService.c.b, me3.c {
    public static final String LOCAL_BIND_ACTION = "com.sggc.fongmi.mobile".concat(".LOCAL_BIND");
    private static volatile boolean running;
    private hd3 exoPlayer;
    private boolean externalBound;
    private NavigationCallback navigationCallback;
    private String navigationKey;
    private Runnable onNewBinding;
    private me3 player;
    private MediaLibraryService.c session;
    private final List<PlayerCallback> playerCallbacks = new CopyOnWriteArrayList();
    private final IBinder binder = new LocalBinder();
    private final hd3.d listener = new hd3.d() { // from class: com.fongmi.android.tv.service.PlaybackService.2
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onAudioAttributesChanged(yb ybVar) {
            super.onAudioAttributesChanged(ybVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onAudioSessionIdChanged(int i) {
            super.onAudioSessionIdChanged(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onAvailableCommandsChanged(hd3.b bVar) {
            super.onAvailableCommandsChanged(bVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onCues(w50 w50Var) {
            super.onCues(w50Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onDeviceInfoChanged(kk0 kk0Var) {
            super.onDeviceInfoChanged(kk0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            super.onDeviceVolumeChanged(i, z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onEvents(hd3 hd3Var, hd3.c cVar) {
            super.onEvents(hd3Var, cVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onIsLoadingChanged(boolean z) {
            super.onIsLoadingChanged(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onIsPlayingChanged(boolean z) {
            super.onIsPlayingChanged(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onLoadingChanged(boolean z) {
            super.onLoadingChanged(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            super.onMaxSeekToPreviousPositionChanged(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onMediaItemTransition(fg2 fg2Var, int i) {
            super.onMediaItemTransition(fg2Var, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onMediaMetadataChanged(ph2 ph2Var) {
            super.onMediaMetadataChanged(ph2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onMetadata(xs2 xs2Var) {
            super.onMetadata(xs2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            super.onPlayWhenReadyChanged(z, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPlaybackParametersChanged(dc3 dc3Var) {
            super.onPlaybackParametersChanged(dc3Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onPlaybackStateChanged(int i) {
            if (i == 4) {
                if (PlaybackService.this.hasNavigationCallback() && PlaybackService.this.isNavigationOwner()) {
                    return;
                }
                PlaybackService.this.navigateItem(1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            super.onPlaybackSuppressionReasonChanged(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPlayerError(ac3 ac3Var) {
            super.onPlayerError(ac3Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPlayerErrorChanged(ac3 ac3Var) {
            super.onPlayerErrorChanged(ac3Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            super.onPlayerStateChanged(z, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPlaylistMetadataChanged(ph2 ph2Var) {
            super.onPlaylistMetadataChanged(ph2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onPositionDiscontinuity(int i) {
            super.onPositionDiscontinuity(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame() {
            super.onRenderedFirstFrame();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onRepeatModeChanged(int i) {
            super.onRepeatModeChanged(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onSeekBackIncrementChanged(long j) {
            super.onSeekBackIncrementChanged(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            super.onSeekForwardIncrementChanged(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            super.onShuffleModeEnabledChanged(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            super.onSkipSilenceEnabledChanged(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            super.onSurfaceSizeChanged(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onTimelineChanged(no4 no4Var, int i) {
            super.onTimelineChanged(no4Var, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onTrackSelectionParametersChanged(lr4 lr4Var) {
            super.onTrackSelectionParametersChanged(lr4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onTracksChanged(xr4 xr4Var) {
            super.onTracksChanged(xr4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onVideoSizeChanged(e35 e35Var) {
            super.onVideoSizeChanged(e35Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onVolumeChanged(float f) {
            super.onVolumeChanged(f);
        }

        @Override // hd3.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onCues(List list) {
            super.onCues(list);
        }

        @Override // hd3.d
        public /* bridge */ /* synthetic */ void onPositionDiscontinuity(hd3.e eVar, hd3.e eVar2, int i) {
            super.onPositionDiscontinuity(eVar, eVar2, i);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class LocalBinder extends Binder {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public LocalBinder() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PlaybackService getService() {
            return PlaybackService.this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface NavigationCallback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onAudio() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onLoop() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onNext() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onPrev() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onReplay() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onStop() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface PlayerCallback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onError(String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onPlayerRebuild(hd3 hd3Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onPlayingChanged(boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onPrepare() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onStateChanged(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onTitlesChanged() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onTracksChanged() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onVideoSizeChanged(e35 e35Var) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private PendingIntent buildDefaultIntent() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        return PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private a buildStopButton() {
        return new a.b(57415).f(3).b(getString(om3.p)).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void dispatch(final Consumer<NavigationCallback> consumer) {
        final NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            App.d(new Runnable() { // from class: yc3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(navigationCallback);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void dispatchNavigate(Consumer<NavigationCallback> consumer, int i) {
        if (hasNavigationCallback() && isNavigationOwner()) {
            dispatch(consumer);
        } else {
            navigateItem(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void handleAction(String str) {
        if (t2.e.equals(str)) {
            this.player.Y();
            return;
        }
        if (t2.f.equals(str)) {
            this.player.X();
            return;
        }
        if (t2.b.equals(str)) {
            dispatchPrev();
            return;
        }
        if (t2.c.equals(str)) {
            dispatchNext();
            return;
        }
        if (t2.a.equals(str)) {
            dispatchStop();
            return;
        }
        if (t2.d.equals(str)) {
            dispatchLoop();
        } else if (t2.g.equals(str)) {
            dispatchAudio();
        } else if (t2.h.equals(str)) {
            dispatchReplay();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasNavigationCallback() {
        return this.navigationCallback != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void interceptItem(fg2 fg2Var, long j) {
        if (isSameItem(fg2Var)) {
            return;
        }
        playViaManager(fg2Var, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void interceptItems(List<fg2> list, int i, long j) {
        if (list.isEmpty()) {
            return;
        }
        if (i < 0 || i >= list.size()) {
            i = 0;
        }
        fg2 fg2Var = list.get(i);
        if (j <= 0) {
            j = 0;
        }
        interceptItem(fg2Var, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isExternalBind(Intent intent) {
        return "android.media.browse.MediaBrowserService".equals(intent != null ? intent.getAction() : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isLocalBind(Intent intent) {
        return LOCAL_BIND_ACTION.equals(intent != null ? intent.getAction() : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNavigationOwner() {
        String str = this.navigationKey;
        return str == null || str.equals(this.player.B());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isRunning() {
        return running;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isSameItem(fg2 fg2Var) {
        fg2.h hVar;
        if (fg2Var == null || (hVar = fg2Var.b) == null) {
            return false;
        }
        return hVar.a.toString().equals(this.player.I());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$navigateItem$1(fg2 fg2Var, Result result) {
        startBrowse(this.player, fg2Var, result, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$navigateItem$2(fg2 fg2Var, int i) {
        final Result resultE;
        try {
            final fg2 fg2VarL = il.l(fg2Var.a, i);
            if (fg2VarL != null && fg2VarL.b != null && (resultE = il.e(fg2VarL.a)) != null && isRunning()) {
                App.d(new Runnable() { // from class: ic3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.lambda$navigateItem$1(fg2VarL, resultE);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void navigateItem(final int i) {
        final fg2 currentMediaItem = this.exoPlayer.getCurrentMediaItem();
        if (currentMediaItem == null) {
            return;
        }
        ul4.h(new Runnable() { // from class: hc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.lambda$navigateItem$2(currentMediaItem, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void playViaManager(fg2 fg2Var, long j) {
        Result resultE;
        if (fg2Var == null || fg2Var.b == null || (resultE = il.e(fg2Var.a)) == null) {
            return;
        }
        startBrowse(this.player, fg2Var, resultE, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void q(final String str, final MediaLibraryService.c cVar, final u.g gVar, final MediaLibraryService.b bVar) {
        final xi1 xi1VarR = il.r(str);
        App.d(new Runnable() { // from class: tc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                cVar.B(gVar, str, xi1VarR.size(), bVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void releaseExternal() {
        this.externalBound = false;
        saveProgress();
        il.b();
        tryShutdown();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void releaseSession() {
        MediaLibraryService.c cVar = this.session;
        if (cVar == null) {
            return;
        }
        cVar.s();
        this.session = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void removeForeground() {
        stopForeground(1);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001c: CONSTRUCTOR 
      (wrap:java.util.List:0x000d: INVOKE 
      (wrap:java.util.stream.Stream:0x0009: INVOKE 
      (wrap:java.util.stream.Stream:0x0000: INVOKE (r3v0 java.util.List) INTERFACE call: java.util.Collection.stream():java.util.stream.Stream A[MD:():java.util.stream.Stream<E> (c), WRAPPED] (LINE:1))
      (wrap:java.util.function.Function:0x0006: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:7) call: wc3.<init>():void type: CONSTRUCTOR)
     INTERFACE call: java.util.stream.Stream.map(java.util.function.Function):java.util.stream.Stream A[MD:<R>:(java.util.function.Function<? super T, ? extends R>):java.util.stream.Stream<R> (c), WRAPPED] (LINE:10))
     STATIC call: j$.util.stream.Stream$-EL.toList(java.util.stream.Stream):java.util.List A[MD:(java.util.stream.Stream):java.util.List (m), WRAPPED] (LINE:14))
      (wrap:int:0x0012: INVOKE (r4v0 int), (0 int) STATIC call: java.lang.Math.max(int, int):int A[MD:(int, int):int (c), WRAPPED] (LINE:19))
      (wrap:long:0x0016: INVOKE  STATIC call: il.f():long A[MD:():long (m), WRAPPED] (LINE:23))
     A[MD:(java.util.List, int, long):void (m)] (LINE:29) call: androidx.media3.session.u.i.<init>(java.util.List, int, long):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ u.i s(List list, int i) {
        return new u.i(Stream$EL.toList(list.stream().map(new Function() { // from class: wc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return il.p((fg2) obj);
            }
        })), Math.max(i, 0), il.f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void saveProgress() {
        if (hasNavigationCallback() || this.session == null || !il.q(this.player.E(), this.player.z())) {
            return;
        }
        this.session.A("VOD", 0, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setupNotification() {
        e eVarF = new e.c(this).f();
        this.session.u(xi1.w(buildStopButton()));
        eVarF.m(fl3.q);
        setMediaNotificationProvider(eVarF);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void startBrowse(me3 me3Var, fg2 fg2Var, Result result, long j) {
        me3Var.u0(vb3.c(result, fg2Var.a, fg2Var.e));
        if (j > 0) {
            me3Var.f0(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void stopAndClear() {
        this.player.v0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void tryShutdown() {
        if (hasNavigationCallback() || hasExternalClient()) {
            return;
        }
        shutdown();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private g51 wrap(hd3 hd3Var) {
        return new g51(hd3Var) { // from class: com.fongmi.android.tv.service.PlaybackService.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public hd3.b getAvailableCommands() {
                return super.getAvailableCommands().b().a(7).a(6).a(9).a(8).a(11).a(12).a(3).f();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public void seekToNext() {
                PlaybackService.this.dispatchNext();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public void seekToNextMediaItem() {
                PlaybackService.this.dispatchNext();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public void seekToPrevious() {
                PlaybackService.this.dispatchPrev();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public void seekToPreviousMediaItem() {
                PlaybackService.this.dispatchPrev();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public void setMediaItem(fg2 fg2Var) {
                PlaybackService.this.interceptItem(fg2Var, 0L);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void setMediaItems(List<fg2> list) {
                PlaybackService.this.interceptItems(list, 0, 0L);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g51, defpackage.hd3
            public void stop() {
                PlaybackService.this.dispatchStop();
            }

            @Override // defpackage.g51, defpackage.hd3
            public void setMediaItem(fg2 fg2Var, boolean z) {
                PlaybackService.this.interceptItem(fg2Var, 0L);
            }

            @Override // defpackage.g51, defpackage.hd3
            public void setMediaItem(fg2 fg2Var, long j) {
                PlaybackService.this.interceptItem(fg2Var, j);
            }

            @Override // defpackage.g51, defpackage.hd3
            public void setMediaItems(List<fg2> list, boolean z) {
                PlaybackService.this.interceptItems(list, 0, 0L);
            }

            @Override // defpackage.g51, defpackage.hd3
            public void setMediaItems(List<fg2> list, int i, long j) {
                PlaybackService.this.interceptItems(list, i, j);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addPlayerCallback(PlayerCallback playerCallback) {
        this.playerCallbacks.add(playerCallback);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatchAudio() {
        dispatch(new Consumer() { // from class: lc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.NavigationCallback) obj).onAudio();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatchLoop() {
        dispatch(new Consumer() { // from class: ad3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.NavigationCallback) obj).onLoop();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatchNext() {
        dispatchNavigate(new Consumer() { // from class: zc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.NavigationCallback) obj).onNext();
            }
        }, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatchPrev() {
        dispatchNavigate(new Consumer() { // from class: uc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.NavigationCallback) obj).onPrev();
            }
        }, -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatchReplay() {
        if (hasNavigationCallback() && isNavigationOwner()) {
            dispatch(new Consumer() { // from class: qc3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((PlaybackService.NavigationCallback) obj).onReplay();
                }
            });
        } else {
            this.player.f0(0L);
            this.player.Y();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatchStop() {
        if (this.player.C() == 1) {
            return;
        }
        if (hasNavigationCallback() && isNavigationOwner()) {
            dispatch(new Consumer() { // from class: oc3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((PlaybackService.NavigationCallback) obj).onStop();
                }
            });
        } else {
            stopAndClear();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasExternalClient() {
        return this.externalBound;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasPlayerCallback() {
        return !this.playerCallbacks.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ lu1 onAddMediaItems(u uVar, u.g gVar, List list) {
        return super.onAddMediaItems(uVar, gVar, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService, androidx.media3.session.x, defpackage.ft1, android.app.Service
    public IBinder onBind(Intent intent) {
        if (isLocalBind(intent)) {
            return this.binder;
        }
        if (isExternalBind(intent)) {
            this.externalBound = true;
        }
        return super.onBind(intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @lh4(threadMode = ThreadMode.MAIN)
    public void onConfigEvent(c00 c00Var) {
        if (this.session == null) {
            return;
        }
        if (c00Var.f()) {
            il.d();
            this.session.A("VOD", 0, null);
        } else if (c00Var.e()) {
            il.c();
            this.session.A("LIVE", 0, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public u.e onConnect(u uVar, u.g gVar) {
        return new u.e.a(uVar).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.x, defpackage.ft1, android.app.Service
    public void onCreate() {
        super.onCreate();
        running = true;
        me3 me3Var = new me3(this);
        this.player = me3Var;
        hd3 hd3VarD = me3Var.D();
        this.exoPlayer = hd3VarD;
        hd3VarD.addListener(this.listener);
        MediaLibraryService.c cVarC = new MediaLibraryService.c.a((MediaLibraryService) this, (hd3) wrap(this.exoPlayer), (MediaLibraryService.c.b) this).c();
        this.session = cVarC;
        cVarC.w(buildDefaultIntent());
        uu0.d().p(this);
        t14.b().h(this);
        setupNotification();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ lu1 onCustomCommand(u uVar, u.g gVar, y14 y14Var, Bundle bundle) {
        return super.onCustomCommand(uVar, gVar, y14Var, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.x, defpackage.ft1, android.app.Service
    public void onDestroy() {
        running = false;
        releaseSession();
        this.player.c0();
        removeForeground();
        t14.b().h(null);
        uu0.d().r(this);
        super.onDestroy();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public void onDisconnected(u uVar, u.g gVar) {
        if (gVar.f().equals(getPackageName())) {
            return;
        }
        tryShutdown();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onError(final String str) {
        this.playerCallbacks.forEach(new Consumer() { // from class: nc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onError(str);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public lu1 onGetChildren(MediaLibraryService.c cVar, u.g gVar, final String str, int i, int i2, final MediaLibraryService.b bVar) {
        return ul4.d().submit(new Callable() { // from class: mc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j.i(il.h(str), bVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public lu1 onGetItem(MediaLibraryService.c cVar, u.g gVar, String str) {
        fg2 fg2VarI = il.i(str);
        return x81.e(fg2VarI != null ? j.h(fg2VarI, null) : j.e(-3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public lu1 onGetLibraryRoot(MediaLibraryService.c cVar, u.g gVar, MediaLibraryService.b bVar) {
        return x81.e(j.h(il.j(), bVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public lu1 onGetSearchResult(MediaLibraryService.c cVar, u.g gVar, String str, int i, int i2, MediaLibraryService.b bVar) {
        return x81.e(j.i(il.k(), bVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ boolean onMediaButtonEvent(u uVar, u.g gVar, Intent intent) {
        return super.onMediaButtonEvent(uVar, gVar, intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    @Deprecated
    public /* bridge */ /* synthetic */ lu1 onPlaybackResumption(u uVar, u.g gVar) {
        return super.onPlaybackResumption(uVar, gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    @Deprecated
    public /* bridge */ /* synthetic */ int onPlayerCommandRequest(u uVar, u.g gVar, int i) {
        return super.onPlayerCommandRequest(uVar, gVar, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ void onPlayerInteractionFinished(u uVar, u.g gVar, hd3.b bVar) {
        super.onPlayerInteractionFinished(uVar, gVar, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onPlayerRebuild(final hd3 hd3Var) {
        this.exoPlayer.removeListener(this.listener);
        this.exoPlayer = hd3Var;
        hd3Var.addListener(this.listener);
        MediaLibraryService.c cVar = this.session;
        if (cVar != null) {
            cVar.v(wrap(hd3Var));
        }
        this.playerCallbacks.forEach(new Consumer() { // from class: gc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onPlayerRebuild(hd3Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onPlayingChanged(final boolean z) {
        this.playerCallbacks.forEach(new Consumer() { // from class: jc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onPlayingChanged(z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ void onPostConnect(u uVar, u.g gVar) {
        super.onPostConnect(uVar, gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onPrepare() {
        this.playerCallbacks.forEach(new Consumer() { // from class: rc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onPrepare();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public lu1 onSearch(final MediaLibraryService.c cVar, final u.g gVar, final String str, final MediaLibraryService.b bVar) {
        ul4.c(new Runnable() { // from class: vc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackService.q(str, cVar, gVar, bVar);
            }
        });
        return x81.e(j.k(bVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public lu1 onSetMediaItems(u uVar, u.g gVar, final List<fg2> list, final int i, long j) {
        saveProgress();
        return ul4.d().submit(new Callable() { // from class: kc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PlaybackService.s(list, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ lu1 onSetRating(u uVar, u.g gVar, yn3 yn3Var) {
        return super.onSetRating(uVar, gVar, yn3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.x, defpackage.ft1, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            handleAction(intent.getAction());
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onStateChanged(final int i) {
        this.playerCallbacks.forEach(new Consumer() { // from class: fc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onStateChanged(i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public /* bridge */ /* synthetic */ lu1 onSubscribe(MediaLibraryService.c cVar, u.g gVar, String str, MediaLibraryService.b bVar) {
        return super.onSubscribe(cVar, gVar, str, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.x, android.app.Service
    public void onTaskRemoved(Intent intent) {
        tryShutdown();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onTitlesChanged() {
        this.playerCallbacks.forEach(new Consumer() { // from class: pc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onTitlesChanged();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onTracksChanged() {
        this.playerCallbacks.forEach(new Consumer() { // from class: sc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onTracksChanged();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (isExternalBind(intent)) {
            releaseExternal();
        }
        if (isLocalBind(intent)) {
            tryShutdown();
        }
        return super.onUnbind(intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.MediaLibraryService.c.b
    public /* bridge */ /* synthetic */ lu1 onUnsubscribe(MediaLibraryService.c cVar, u.g gVar, String str) {
        return super.onUnsubscribe(cVar, gVar, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // me3.c
    public void onVideoSizeChanged(final e35 e35Var) {
        this.playerCallbacks.forEach(new Consumer() { // from class: xc3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PlaybackService.PlayerCallback) obj).onVideoSizeChanged(e35Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public me3 player() {
        return this.player;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void removePlayerCallback(PlayerCallback playerCallback) {
        this.playerCallbacks.remove(playerCallback);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void replaceBinding(Runnable runnable) {
        Runnable runnable2 = this.onNewBinding;
        if (runnable2 != null) {
            runnable2.run();
        }
        this.onNewBinding = runnable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void resetSessionActivity() {
        setSessionActivity(buildDefaultIntent());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNavigationCallback(NavigationCallback navigationCallback, String str) {
        this.navigationCallback = navigationCallback;
        this.navigationKey = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSessionActivity(PendingIntent pendingIntent) {
        MediaLibraryService.c cVar = this.session;
        if (cVar != null) {
            cVar.w(pendingIntent);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void shutdown() {
        if (running) {
            running = false;
            stopAndClear();
            stopSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void suspend() {
        stopAndClear();
        removeForeground();
    }

    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ lu1 onCustomCommand(u uVar, u.g gVar, y14 y14Var, Bundle bundle, u.j jVar) {
        return super.onCustomCommand(uVar, gVar, y14Var, bundle, jVar);
    }

    /* JADX DEBUG: Method merged with bridge method: onGetSession(Landroidx/media3/session/u$g;)Landroidx/media3/session/u; */
    @Override // androidx.media3.session.MediaLibraryService, androidx.media3.session.x
    public MediaLibraryService.c onGetSession(u.g gVar) {
        return this.session;
    }

    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ lu1 onPlaybackResumption(u uVar, u.g gVar, boolean z) {
        return super.onPlaybackResumption(uVar, gVar, z);
    }

    @Override // androidx.media3.session.u.d
    public /* bridge */ /* synthetic */ lu1 onSetRating(u uVar, u.g gVar, String str, yn3 yn3Var) {
        return super.onSetRating(uVar, gVar, str, yn3Var);
    }
}

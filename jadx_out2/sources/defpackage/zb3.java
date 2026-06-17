package defpackage;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.media3.session.l;
import androidx.media3.ui.PlayerView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.service.PlaybackService;
import com.fongmi.android.tv.ui.custom.CustomSeekView;
import defpackage.hd3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zb3 extends xg implements l.c, hd3.d, ServiceConnection {
    public lu1 H;
    public l I;
    public PlaybackService J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public FrameLayout P;
    public SurfaceView Q;
    public int R;
    public int S;
    public final PlaybackService.PlayerCallback T = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements SurfaceHolder.Callback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ void b() {
            zb3.this.K2().a0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (zb3.this.K2().R()) {
                return;
            }
            zb3.this.K2().V(i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            boolean zR = zb3.this.K2().R();
            zb3 zb3Var = zb3.this;
            if (zR) {
                zb3Var.K2().o0(surfaceHolder.getSurface());
            } else {
                zb3Var.K2().o0(surfaceHolder.getSurface());
                zb3.this.K2().V(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
            }
            App.e(new Runnable() { // from class: yb3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.b();
                }
            }, 100L);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            try {
                zb3.this.K2().p0();
                zb3.this.K2().t();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (zb3.this.P == null) {
                return;
            }
            int width = zb3.this.P.getWidth();
            int height = zb3.this.P.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            if (width == zb3.this.R && height == zb3.this.S) {
                return;
            }
            zb3.this.R = width;
            zb3.this.S = height;
            zb3.this.K2().a0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements PlaybackService.PlayerCallback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onError(String str) {
            if (zb3.this.v2()) {
                zb3.this.A2(str);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onPlayerRebuild(hd3 hd3Var) {
            if (zb3.this.v2()) {
                zb3.this.U2();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onPlayingChanged(boolean z) {
            if (zb3.this.v2()) {
                zb3.this.onIsPlayingChanged(z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onPrepare() {
            if (zb3.this.v2()) {
                zb3.this.D2();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onStateChanged(int i) {
            if (zb3.this.v2()) {
                zb3.this.B2(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onTitlesChanged() {
            if (zb3.this.v2()) {
                zb3.this.I2();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onTracksChanged() {
            if (zb3.this.v2()) {
                zb3.this.J2();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.fongmi.android.tv.service.PlaybackService.PlayerCallback
        public void onVideoSizeChanged(e35 e35Var) {
            if (zb3.this.v2()) {
                zb3.this.onVideoSizeChanged(e35Var);
            }
        }
    }

    public abstract void A2(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B2(int i) {
        H2(i);
    }

    public abstract void C2(boolean z);

    public abstract void D2();

    public abstract void E2();

    public abstract void F2();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G2(e35 e35Var) {
        Y2(e35Var.a, e35Var.b);
    }

    public abstract void H2(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I2() {
    }

    public abstract void J2();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public me3 K2() {
        PlaybackService playbackService = this.J;
        return playbackService == null ? me3.u() : playbackService.player();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        super.L1(bundle);
        ny0.q(m2());
        e2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L2() {
        if (this.M) {
            this.M = false;
            PlaybackService playbackService = this.J;
            if (playbackService != null) {
                playbackService.removePlayerCallback(this.T);
            }
            unbindService(this);
            this.J = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M2() {
        lu1 lu1Var = this.H;
        if (lu1Var != null) {
            l.m(lu1Var);
        }
        l lVar = this.I;
        if (lVar != null) {
            lVar.removeListener(this);
        }
        this.H = null;
        this.I = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N2() {
        try {
            if (this.J != null) {
                O2(v2());
            }
            j2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O2(boolean z) {
        this.J.removePlayerCallback(this.T);
        if (z) {
            this.J.setNavigationCallback(null, null);
        }
        if (this.J.hasExternalClient() || this.J.hasPlayerCallback()) {
            if (z) {
                this.J.suspend();
            }
            this.J.resetSessionActivity();
        } else if (z) {
            this.J.shutdown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P2(long j) {
        if (K2().Q()) {
            K2().f0(K2().E() + j);
            K2().Y();
        } else {
            this.I.seekTo(K2().E() + j);
            this.I.play();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PlaybackService Q2() {
        return this.J;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R2(boolean z) {
        this.K = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S2(boolean z) {
        this.O = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T2(boolean z) {
        this.L = z;
        PlaybackService playbackService = this.J;
        if (playbackService != null) {
            playbackService.setNavigationCallback(z ? null : n2(), o2());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U2() {
        l2();
        d2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V2(boolean z) {
        this.N = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean W2() {
        return (this.J == null || v2()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X2(String str, Result result, boolean z, long j, ph2 ph2Var) {
        if (result.getDrm() != null && !z71.A(result.getDrm().getUUID())) {
            A2(vr3.l(sm3.C));
            return;
        }
        if (result.hasMsg()) {
            A2(result.getMsg());
            return;
        }
        if (result.needParse() || z) {
            K2().Z();
            d2();
            K2().W(str, result, z, ph2Var);
        } else {
            K2().Z();
            d2();
            K2().t0(vb3.c(result, str, ph2Var), j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y2(int i, int i2) {
        if (this.P == null || this.Q == null || !K2().Q()) {
            return;
        }
        if (!K2().R()) {
            if (i <= 0 || i2 <= 0) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Q.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            this.Q.setLayoutParams(layoutParams);
            return;
        }
        if (i < 0 || i2 < 0) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.Q.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams2.gravity = 17;
            this.Q.setLayoutParams(layoutParams2);
            return;
        }
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int width = this.P.getWidth();
        int height = this.P.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        double d = ((double) i) / ((double) i2);
        double d2 = width;
        double d3 = height;
        if (d > d2 / d3) {
            height = (int) (d2 / d);
        } else {
            width = (int) (d3 * d);
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.height = height;
        layoutParams3.gravity = 17;
        this.Q.setLayoutParams(layoutParams3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c2() {
        ViewGroup viewGroup;
        SurfaceView surfaceView;
        if (K2().Q()) {
            m2().setVisibility(8);
            FrameLayout frameLayout = this.P;
            if (frameLayout == null) {
                this.P = new FrameLayout(this);
                ViewGroup viewGroup2 = (ViewGroup) m2().getParent();
                int iIndexOfChild = viewGroup2.indexOfChild(m2());
                viewGroup2.removeView(m2());
                this.P.setLayoutParams(m2().getLayoutParams());
                viewGroup2.addView(this.P, iIndexOfChild);
                SurfaceView surfaceView2 = new SurfaceView(this);
                this.Q = surfaceView2;
                this.P.addView(surfaceView2, new FrameLayout.LayoutParams(-1, -1));
                this.Q.getHolder().addCallback(new a());
                this.P.getViewTreeObserver().addOnGlobalLayoutListener(new b());
            } else if (frameLayout.getParent() == null && (viewGroup = (ViewGroup) m2().getParent()) != null) {
                int iIndexOfChild2 = viewGroup.indexOfChild(m2());
                ViewGroup.LayoutParams layoutParams = m2().getLayoutParams();
                viewGroup.removeView(m2());
                this.P.setLayoutParams(layoutParams);
                viewGroup.addView(this.P, iIndexOfChild2);
            }
            this.P.setVisibility(0);
            if (K2().R() || (surfaceView = this.Q) == null || surfaceView.getHolder() == null || this.Q.getHolder().getSurfaceFrame() == null) {
                return;
            }
            K2().V(this.Q.getHolder().getSurfaceFrame().width(), this.Q.getHolder().getSurfaceFrame().height());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d2() {
        if (this.J == null) {
            return;
        }
        if (K2().Q()) {
            c2();
            return;
        }
        k2();
        if (m2().getPlayer() == null) {
            m2().setPlayer(K2().D());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e2() {
        startService(new Intent(this, (Class<?>) PlaybackService.class));
        bindService(new Intent(this, (Class<?>) PlaybackService.class).setAction(PlaybackService.LOCAL_BIND_ACTION), this, 1);
        f2();
        this.M = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f2() {
        lu1 lu1VarB = new l.a(this, new e24(this, new ComponentName(this, (Class<?>) PlaybackService.class))).e(this).b();
        this.H = lu1VarB;
        lu1VarB.g(new Runnable() { // from class: xb3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.z2();
            }
        }, c30.h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PendingIntent g2() {
        Intent intentAddFlags = new Intent(this, getClass()).addFlags(131072);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intentAddFlags.putExtras(extras);
        }
        return PendingIntent.getActivity(this, 0, intentAddFlags, 201326592);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h2() {
        if (isInPictureInPictureMode()) {
            j2();
            finish();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l i2() {
        return this.I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j2() {
        M2();
        L2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k2() {
        FrameLayout frameLayout = this.P;
        if (frameLayout != null) {
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            if (viewGroup != null) {
                int iIndexOfChild = viewGroup.indexOfChild(this.P);
                ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
                viewGroup.removeView(this.P);
                if (viewGroup.indexOfChild(m2()) < 0) {
                    viewGroup.addView(m2(), iIndexOfChild, layoutParams);
                }
            }
            this.P.setVisibility(8);
        }
        m2().setVisibility(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l2() {
        if (K2().Q()) {
            k2();
        } else {
            m2().setPlayer(null);
        }
    }

    public abstract PlayerView m2();

    public abstract PlaybackService.NavigationCallback n2();

    public abstract String o2();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg, defpackage.x7, defpackage.u51, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        N2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onIsPlayingChanged(boolean z) {
        if (v2()) {
            if (z) {
                getWindow().addFlags(128);
            } else if (!r2()) {
                getWindow().clearFlags(128);
            }
            C2(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u51, android.app.Activity
    public void onPause() {
        super.onPause();
        if (x2()) {
            if (K2().Q()) {
                K2().X();
                return;
            }
            l lVar = this.I;
            if (lVar != null) {
                lVar.pause();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onPlaybackStateChanged(int i) {
        if (v2()) {
            H2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u51, android.app.Activity
    public void onResume() {
        super.onResume();
        T2(false);
        if (W2()) {
            l2();
            E2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PlaybackService service = ((PlaybackService.LocalBinder) iBinder).getService();
        this.J = service;
        service.replaceBinding(new Runnable() { // from class: wb3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.h2();
            }
        });
        this.J.setSessionActivity(g2());
        this.J.setNavigationCallback(n2(), o2());
        this.J.addPlayerCallback(this.T);
        p2().setPlayerManager(K2());
        F2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.J = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x7, defpackage.u51, android.app.Activity
    public void onStop() {
        super.onStop();
        if (v2() && q24.z()) {
            if (K2().Q()) {
                K2().X();
                return;
            }
            l lVar = this.I;
            if (lVar != null) {
                lVar.pause();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onVideoSizeChanged(e35 e35Var) {
        if (v2()) {
            G2(e35Var);
        }
    }

    public abstract CustomSeekView p2();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q2() {
        return this.K;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r2() {
        return K2().Q() ? K2().C() == 2 : this.I.getPlaybackState() == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s2() {
        return K2().Q() ? K2().C() == 4 : this.I.getPlaybackState() == 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t2() {
        return this.I.getPlaybackState() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean u2() {
        return this.O;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v2() {
        String strO2 = o2();
        if (strO2 != null) {
            return this.J != null && strO2.equals(K2().B());
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w2() {
        return (r2() || t2()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean x2() {
        return this.L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean y2() {
        return this.N;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z2() {
        try {
            this.I = (l) this.H.get();
            p2().setPlayer(this.I);
            this.I.addListener(this);
        } catch (Exception unused) {
        }
    }
}

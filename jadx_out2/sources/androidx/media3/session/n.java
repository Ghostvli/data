package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.session.b0;
import androidx.media3.session.c0;
import androidx.media3.session.g;
import androidx.media3.session.h;
import androidx.media3.session.l;
import androidx.media3.session.n;
import defpackage.ac3;
import defpackage.b24;
import defpackage.c24;
import defpackage.cc2;
import defpackage.d24;
import defpackage.d94;
import defpackage.dc3;
import defpackage.du2;
import defpackage.e24;
import defpackage.e35;
import defpackage.fg2;
import defpackage.fm;
import defpackage.fy4;
import defpackage.g20;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.kk0;
import defpackage.km;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.na;
import defpackage.no4;
import defpackage.p81;
import defpackage.ph2;
import defpackage.pu1;
import defpackage.u00;
import defpackage.w50;
import defpackage.w82;
import defpackage.x3;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yb;
import defpackage.yx0;
import defpackage.zi1;
import defpackage.zu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class n implements l.d {
    public hd3.b A;
    public hd3.b B;
    public Surface C;
    public SurfaceHolder D;
    public TextureView E;
    public g G;
    public MediaController H;
    public long I;
    public long J;
    public b0 K;
    public Bundle L;
    public final l a;
    public final c0 b;
    public final p c;
    public final Context d;
    public final e24 e;
    public final Bundle f;
    public final IBinder.DeathRecipient g;
    public final f h;
    public final pu1 i;
    public final b j;
    public final na k;
    public final SparseArray l;
    public final Handler m;
    public final boolean n;
    public e24 o;
    public e p;
    public boolean q;
    public PendingIntent s;
    public hd3.b z;
    public b0 r = b0.H;
    public d94 F = d94.c;
    public d0 y = d0.b;
    public xi1 t = xi1.u();
    public xi1 u = xi1.u();
    public xi1 v = xi1.u();
    public xi1 w = xi1.u();
    public zi1 x = zi1.j();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b {
        public final Handler a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Looper looper) {
            this.a = new Handler(looper, new Handler.Callback() { // from class: vd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f.c(message);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            try {
                n.this.G.W(n.this.c);
            } catch (RemoteException unused) {
                xz1.i("MCImplBase", "Error in sending flushCommandQueue");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean c(Message message) {
            if (message.what == 1) {
                b();
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            if (this.a.hasMessages(1)) {
                b();
            }
            this.a.removeCallbacksAndMessages(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e() {
            if (n.this.G == null || this.a.hasMessages(1)) {
                return;
            }
            this.a.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, long j) {
            this.a = i;
            this.b = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [androidx.media3.session.n.T2(java.util.List, int, long, boolean):void] */
        public static /* synthetic */ int a(c cVar) {
            return cVar.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [androidx.media3.session.n.T2(java.util.List, int, long, boolean):void] */
        public static /* synthetic */ long b(c cVar) {
            return cVar.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(g gVar, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements ServiceConnection {
        public final Bundle f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Bundle bundle) {
            this.f = bundle;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            l lVarY1 = n.this.Y1();
            l lVarY12 = n.this.Y1();
            Objects.requireNonNull(lVarY12);
            lVarY1.n(new cc2(lVarY12));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            l lVarY1;
            cc2 cc2Var;
            try {
                try {
                    if (n.this.e.e().equals(componentName.getPackageName())) {
                        h hVarZ0 = h.a.Z0(iBinder);
                        if (hVarZ0 != null) {
                            hVarZ0.y(n.this.c, new u00(n.this.W1().getPackageName(), Process.myPid(), this.f, n.this.a.g()).b());
                            return;
                        } else {
                            xz1.d("MCImplBase", "Service interface is missing.");
                            lVarY1 = n.this.Y1();
                            l lVarY12 = n.this.Y1();
                            Objects.requireNonNull(lVarY12);
                            cc2Var = new cc2(lVarY12);
                        }
                    } else {
                        xz1.d("MCImplBase", "Expected connection to " + n.this.e.e() + " but is connected to " + componentName);
                        lVarY1 = n.this.Y1();
                        l lVarY13 = n.this.Y1();
                        Objects.requireNonNull(lVarY13);
                        cc2Var = new cc2(lVarY13);
                    }
                } catch (RemoteException unused) {
                    xz1.i("MCImplBase", "Service " + componentName + " has died prematurely");
                    lVarY1 = n.this.Y1();
                    l lVarY14 = n.this.Y1();
                    Objects.requireNonNull(lVarY14);
                    cc2Var = new cc2(lVarY14);
                }
                lVarY1.n(cc2Var);
            } catch (Throwable th) {
                l lVarY15 = n.this.Y1();
                l lVarY16 = n.this.Y1();
                Objects.requireNonNull(lVarY16);
                lVarY15.n(new cc2(lVarY16));
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            l lVarY1 = n.this.Y1();
            l lVarY12 = n.this.Y1();
            Objects.requireNonNull(lVarY12);
            lVarY1.n(new cc2(lVarY12));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (n.this.E == null || n.this.E.getSurfaceTexture() != surfaceTexture) {
                return;
            }
            n.this.C = new Surface(surfaceTexture);
            n nVar = n.this;
            nVar.V2(nVar.C, i, i2);
            n.this.D2(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (n.this.E != null && n.this.E.getSurfaceTexture() == surfaceTexture) {
                n.this.C = null;
                n.this.V2(null, 0, 0);
                n.this.D2(0, 0);
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
            if (n.this.E != null && n.this.E.getSurfaceTexture() == surfaceTexture && n.this.isConnected()) {
                if (n.this.d2() >= 8) {
                    n.this.T1(new d() { // from class: xd2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // androidx.media3.session.n.d
                        public final void a(g gVar, int i3) {
                            gVar.s(n.this.c, i3, i, i2);
                        }
                    });
                }
                n.this.D2(i, i2);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, final int i2, final int i3) {
            if (n.this.D == surfaceHolder && n.this.isConnected()) {
                if (n.this.d2() >= 8) {
                    n.this.T1(new d() { // from class: wd2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // androidx.media3.session.n.d
                        public final void a(g gVar, int i4) {
                            gVar.s(n.this.c, i4, i2, i3);
                        }
                    });
                }
                n.this.D2(i2, i3);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (n.this.D != surfaceHolder) {
                return;
            }
            n.this.C = surfaceHolder.getSurface();
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            n nVar = n.this;
            nVar.V2(nVar.C, surfaceFrame.width(), surfaceFrame.height());
            n.this.D2(surfaceFrame.width(), surfaceFrame.height());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (n.this.D != surfaceHolder) {
                return;
            }
            n.this.C = null;
            n.this.V2(null, 0, 0);
            n.this.D2(0, 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public n(Context context, l lVar, e24 e24Var, Bundle bundle, Looper looper, boolean z) {
        this.n = z;
        hd3.b bVar = hd3.b.b;
        this.z = bVar;
        this.A = bVar;
        this.B = N1(bVar, bVar);
        this.i = new pu1(looper, zu.a, new pu1.b() { // from class: eb2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.b
            public final void a(Object obj, o21 o21Var) {
                ((hd3.d) obj).onEvents(this.a.Y1(), new hd3.c(o21Var));
            }
        });
        this.m = new Handler(looper);
        this.a = lVar;
        gg3.r(context, "context must not be null");
        gg3.r(e24Var, "token must not be null");
        this.d = context;
        this.b = new c0();
        this.c = new p(this);
        this.k = new na();
        this.e = e24Var;
        this.f = bundle;
        this.g = new IBinder.DeathRecipient() { // from class: fb2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                n.M(this.a);
            }
        };
        this.h = new f();
        this.L = Bundle.EMPTY;
        this.p = e24Var.h() != 0 ? new e(bundle) : null;
        this.j = new b(looper);
        this.I = -9223372036854775807L;
        this.J = -9223372036854775807L;
        this.l = new SparseArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void D0(n nVar, l.e eVar, y14 y14Var, Bundle bundle, g gVar, int i) {
        if (eVar != null) {
            nVar.l.put(i, eVar);
        }
        gVar.k0(nVar.c, i, y14Var.b(), bundle, eVar != null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void E2(no4 no4Var, List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            no4.d dVar = (no4.d) list.get(i);
            int i2 = dVar.n;
            int i3 = dVar.o;
            if (i2 == -1 || i3 == -1) {
                dVar.n = list2.size();
                dVar.o = list2.size();
                list2.add(P1(i));
            } else {
                dVar.n = list2.size();
                dVar.o = list2.size() + (i3 - i2);
                while (i2 <= i3) {
                    list2.add(c2(no4Var, i2, i));
                    i2++;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void F0(n nVar, float f2, g gVar, int i) {
        int iD2 = nVar.d2();
        p pVar = nVar.c;
        if (iD2 >= 6) {
            gVar.u0(pVar, i);
        } else {
            gVar.O0(pVar, i, f2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void K(n nVar, boolean z, boolean z2, int i, l.c cVar) {
        lu1 lu1Var = (lu1) gg3.r(cVar.J0(nVar.Y1(), nVar.w), "MediaController.Listener#onSetCustomLayout() must not return null");
        if (z) {
            cVar.H0(nVar.Y1(), nVar.w);
        }
        if (z2) {
            cVar.Q(nVar.Y1(), nVar.v);
        }
        nVar.Q2(i, lu1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 K2(List list, List list2, Bundle bundle, d0 d0Var, hd3.b bVar, int i) {
        if (!list2.isEmpty()) {
            return androidx.media3.session.a.j(list2, d0Var, bVar);
        }
        boolean z = false;
        boolean z2 = (bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bVar.d(6, 7)) ? false : true;
        if (!bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT") && !bVar.d(8, 9)) {
            z = true;
        }
        return androidx.media3.session.a.m(list, z2, z, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 L2(List list, List list2, d0 d0Var, hd3.b bVar, Bundle bundle) {
        if (list.isEmpty()) {
            list = androidx.media3.session.a.p(list2, bVar, bundle);
        }
        return androidx.media3.session.a.j(list, d0Var, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void M(n nVar) {
        l lVarY1 = nVar.Y1();
        l lVarY12 = nVar.Y1();
        Objects.requireNonNull(lVarY12);
        lVarY1.n(new cc2(lVarY12));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M1(int i) {
        if (i == 1) {
            return 0;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M2(int i, boolean z, int i2, no4 no4Var, int i3, int i4) {
        int iV = no4Var.v();
        for (int i5 = 0; i5 < iV && (i2 = no4Var.k(i2, i, z)) != -1; i5++) {
            if (i2 < i3 || i2 >= i4) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static no4 O1(List list, List list2) {
        return new no4.c(new xi1.a().j(list).k(), new xi1.a().j(list2).k(), a0.d(list.size()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void P(n nVar, Bundle bundle, boolean z, boolean z2, l.c cVar) {
        cVar.S0(nVar.Y1(), bundle);
        if (z) {
            cVar.H0(nVar.Y1(), nVar.w);
        }
        if (z2) {
            cVar.Q(nVar.Y1(), nVar.v);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static no4.b P1(int i) {
        return new no4.b().v(null, null, i, -9223372036854775807L, 0L, x3.g, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static no4.d Q1(fg2 fg2Var) {
        return new no4.d().h(0, fg2Var, null, 0L, 0L, 0L, true, false, null, 0L, -9223372036854775807L, -1, -1, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int X1(b0 b0Var) {
        return b0Var.c.a.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void Z0(final n nVar, List list, int i, int i2, g gVar, int i3) {
        nVar.getClass();
        km kmVar = new km(fm.i(list, new p81() { // from class: b92
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((fg2) obj).g(this.f.d2());
            }
        }));
        int iD2 = nVar.d2();
        p pVar = nVar.c;
        if (iD2 >= 2) {
            gVar.q0(pVar, i3, i, i2, kmVar);
        } else {
            gVar.I(pVar, i3, i2, kmVar);
            gVar.Y(nVar.c, i3, i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int Z1(no4 no4Var, int i, int i2, int i3) {
        if (i == -1) {
            return i;
        }
        while (i2 < i3) {
            no4.d dVar = new no4.d();
            no4Var.t(i2, dVar);
            i -= (dVar.o - dVar.n) + 1;
            i2++;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a0(n nVar) {
        e eVar = nVar.p;
        if (eVar != null) {
            nVar.d.unbindService(eVar);
            nVar.p = null;
        }
        nVar.c.t1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c b2(no4 no4Var, no4.d dVar, no4.b bVar, int i, long j) {
        gg3.o(i, no4Var.v());
        no4Var.t(i, dVar);
        if (j == -9223372036854775807L) {
            j = dVar.d();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = dVar.n;
        no4Var.l(i2, bVar);
        while (i2 < dVar.o && bVar.e != j) {
            int i3 = i2 + 1;
            if (no4Var.l(i3, bVar).e > j) {
                break;
            }
            i2 = i3;
        }
        no4Var.l(i2, bVar);
        return new c(i2, j - bVar.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static no4.b c2(no4 no4Var, int i, int i2) {
        no4.b bVar = new no4.b();
        no4Var.l(i, bVar);
        bVar.c = i2;
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void d0(n nVar) {
        b0 b0Var = nVar.K;
        if (b0Var != null) {
            nVar.y2(b0Var, b0.c.c);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b0 i2(b0 b0Var, int i, List list, long j, long j2) {
        int size;
        no4 no4Var = b0Var.j;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < no4Var.v(); i3++) {
            arrayList.add(no4Var.t(i3, new no4.d()));
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            arrayList.add(i4 + i, Q1((fg2) list.get(i4)));
        }
        E2(no4Var, arrayList, arrayList2);
        no4 no4VarO1 = O1(arrayList, arrayList2);
        if (b0Var.j.w()) {
            size = 0;
        } else {
            int size2 = b0Var.c.a.c;
            if (size2 >= i) {
                size2 += list.size();
            }
            i2 = size2;
            size = b0Var.c.a.f;
            if (size >= i) {
                size += list.size();
            }
        }
        return l2(b0Var, no4VarO1, i2, size, j, j2, 5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b0 j2(b0 b0Var, int i, int i2, boolean z, long j, long j2) {
        int i3;
        no4 no4Var;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        b0 b0VarL2;
        no4 no4Var2 = b0Var.j;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < no4Var2.v(); i10++) {
            if (i10 < i || i10 >= i2) {
                arrayList.add(no4Var2.t(i10, new no4.d()));
            }
        }
        E2(no4Var2, arrayList, arrayList2);
        no4 no4VarO1 = O1(arrayList, arrayList2);
        int iZ1 = 0;
        int iX1 = X1(b0Var);
        int i11 = b0Var.c.a.f;
        no4.d dVar = new no4.d();
        boolean z2 = iX1 >= i && iX1 < i2;
        if (no4VarO1.w()) {
            i3 = iX1;
            no4Var = no4Var2;
            i4 = i;
            i5 = i2;
            i7 = -1;
        } else {
            if (z2) {
                int iM2 = M2(b0Var.h, b0Var.i, iX1, no4Var2, i, i2);
                i3 = iX1;
                no4Var = no4Var2;
                i4 = i;
                i5 = i2;
                if (iM2 == -1) {
                    iM2 = no4VarO1.g(b0Var.i);
                } else if (iM2 >= i5) {
                    iM2 -= i5 - i4;
                }
                i8 = iM2;
                iZ1 = no4VarO1.t(i8, dVar).n;
            } else {
                i3 = iX1;
                no4Var = no4Var2;
                i4 = i;
                i5 = i2;
                if (i3 < i5) {
                    i6 = i11;
                    i7 = i3;
                    if (z2) {
                        i9 = 4;
                        b0VarL2 = l2(b0Var, no4VarO1, i7, i6, j, j2, 4);
                    } else if (i7 == -1) {
                        b0VarL2 = m2(b0Var, no4VarO1, c24.k, c24.l, 4);
                        i9 = 4;
                    } else if (z) {
                        i9 = 4;
                        b0VarL2 = l2(b0Var, no4VarO1, i7, i6, j, j2, 4);
                    } else {
                        i9 = 4;
                        no4.d dVarT = no4VarO1.t(i7, new no4.d());
                        long jC = dVarT.c();
                        long jE = dVarT.e();
                        hd3.e eVar = new hd3.e(null, i7, dVarT.c, null, i6, jC, jC, -1, -1);
                        b0VarL2 = m2(b0Var, no4VarO1, eVar, new c24(eVar, false, SystemClock.elapsedRealtime(), jE, jC, a0.c(jC, jE), 0L, -9223372036854775807L, jE, jC), 4);
                    }
                    int i12 = b0VarL2.A;
                    return i12 != 1 ? b0VarL2 : b0VarL2;
                }
                i8 = i3 - (i5 - i4);
                iZ1 = Z1(no4Var, i11, i4, i5);
            }
            i7 = i8;
        }
        i6 = iZ1;
        if (z2) {
        }
        int i122 = b0VarL2.A;
        return i122 != 1 ? b0VarL2 : b0VarL2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b0 l2(b0 b0Var, no4 no4Var, int i, int i2, long j, long j2, int i3) {
        fg2 fg2Var = no4Var.t(i, new no4.d()).c;
        hd3.e eVar = b0Var.c.a;
        hd3.e eVar2 = new hd3.e(null, i, fg2Var, null, i2, j, j2, eVar.i, eVar.j);
        boolean z = b0Var.c.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c24 c24Var = b0Var.c;
        return m2(b0Var, no4Var, eVar2, new c24(eVar2, z, jElapsedRealtime, c24Var.d, c24Var.e, c24Var.f, c24Var.g, c24Var.h, c24Var.i, c24Var.j), i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void m(n nVar, boolean z, boolean z2, int i, l.c cVar) {
        lu1 lu1Var = (lu1) gg3.r(cVar.J0(nVar.Y1(), nVar.w), "MediaController.Listener#onSetCustomLayout() must not return null");
        if (z) {
            cVar.H0(nVar.Y1(), nVar.w);
        }
        if (z2) {
            cVar.Q(nVar.Y1(), nVar.v);
        }
        nVar.Q2(i, lu1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b0 m2(b0 b0Var, no4 no4Var, hd3.e eVar, c24 c24Var, int i) {
        return new b0.b(b0Var).C(no4Var).p(b0Var.c.a).o(eVar).A(c24Var).i(i).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void t(n nVar, int i, fg2 fg2Var, g gVar, int i2) {
        int iD2 = nVar.d2();
        p pVar = nVar.c;
        if (iD2 >= 2) {
            gVar.V0(pVar, i2, i, fg2Var.g(nVar.d2()));
        } else {
            gVar.j(pVar, i2, i + 1, fg2Var.g(nVar.d2()));
            gVar.E0(nVar.c, i2, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void w0(n nVar, lu1 lu1Var, int i) {
        d24 d24Var;
        nVar.getClass();
        try {
            d24Var = (d24) gg3.r((d24) lu1Var.get(), "SessionResult must not be null");
        } catch (InterruptedException e2) {
            e = e2;
            xz1.j("MCImplBase", "Session operation failed", e);
            d24Var = new d24(-1);
        } catch (CancellationException e3) {
            xz1.j("MCImplBase", "Session operation cancelled", e3);
            d24Var = new d24(1);
        } catch (ExecutionException e4) {
            e = e4;
            xz1.j("MCImplBase", "Session operation failed", e);
            d24Var = new d24(-1);
        }
        nVar.P2(i, d24Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void x(final n nVar, int i) {
        nVar.k.remove(Integer.valueOf(i));
        nVar.l.delete(i);
        e24 e24Var = nVar.o;
        if (e24Var == null || e24Var.d() >= 5 || !nVar.k.isEmpty()) {
            return;
        }
        nVar.m.postDelayed(new Runnable() { // from class: j92
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                n.d0(this.f);
            }
        }, 500L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void z1(n nVar, float f2, g gVar, int i) {
        int iD2 = nVar.d2();
        p pVar = nVar.c;
        if (iD2 >= 6) {
            gVar.q(pVar, i);
        } else {
            gVar.O0(pVar, i, f2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A2(final int i, List list) {
        if (isConnected()) {
            xi1 xi1Var = this.v;
            xi1 xi1Var2 = this.w;
            this.t = xi1.p(list);
            xi1 xi1VarL2 = L2(this.u, list, this.y, this.B, this.L);
            this.v = xi1VarL2;
            this.w = J2(xi1VarL2, list, this.L, this.y, this.B);
            final boolean z = !this.v.equals(xi1Var);
            final boolean z2 = !this.w.equals(xi1Var2);
            Y1().l(new g20() { // from class: q92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    n.K(this.a, z2, z, i, (l.c) obj);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B2(final int i, List list) {
        if (isConnected()) {
            xi1 xi1Var = this.v;
            xi1 xi1Var2 = this.w;
            this.u = xi1.p(list);
            xi1 xi1VarL2 = L2(list, this.t, this.y, this.B, this.L);
            this.v = xi1VarL2;
            this.w = J2(xi1VarL2, this.t, this.L, this.y, this.B);
            final boolean z = !this.v.equals(xi1Var);
            final boolean z2 = !this.w.equals(xi1Var2);
            Y1().l(new g20() { // from class: m92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    n.m(this.a, z2, z, i, (l.c) obj);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C2(int i, final PendingIntent pendingIntent) {
        if (!isConnected() || Objects.equals(this.s, pendingIntent)) {
            return;
        }
        this.s = pendingIntent;
        Y1().l(new g20() { // from class: n92
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                l.c cVar = (l.c) obj;
                cVar.E0(this.a.Y1(), pendingIntent);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D2(final int i, final int i2) {
        if (this.F.b() == i && this.F.a() == i2) {
            return;
        }
        this.F = new d94(i, i2);
        this.i.k(24, new pu1.a() { // from class: vb2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((hd3.d) obj).onSurfaceSizeChanged(i, i2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F2(int i, int i2) {
        int iV = this.r.j.v();
        int iMin = Math.min(i2, iV);
        if (i >= iV || i == iMin || iV == 0) {
            return;
        }
        boolean z = getCurrentMediaItemIndex() >= i && getCurrentMediaItemIndex() < iMin;
        b0 b0VarJ2 = j2(this.r, i, iMin, false, getCurrentPosition(), getContentPosition());
        int i3 = this.r.c.a.c;
        W2(b0VarJ2, 0, null, z ? 4 : null, i3 >= i && i3 < iMin ? 3 : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G2(int i, int i2, List list) {
        int iV = this.r.j.v();
        if (i > iV) {
            return;
        }
        if (this.r.j.w()) {
            T2(list, -1, -9223372036854775807L, false);
            return;
        }
        int iMin = Math.min(i2, iV);
        b0 b0VarJ2 = j2(i2(this.r, iMin, list, getCurrentPosition(), getContentPosition()), i, iMin, true, getCurrentPosition(), getContentPosition());
        int i3 = this.r.c.a.c;
        boolean z = i3 >= i && i3 < iMin;
        W2(b0VarJ2, 0, null, z ? 4 : null, z ? 3 : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H2() {
        int i = Build.VERSION.SDK_INT >= 29 ? 4097 : 1;
        Intent intent = new Intent(x.SERVICE_INTERFACE);
        intent.setClassName(this.e.e(), this.e.g());
        try {
            if (this.d.bindService(intent, this.p, i)) {
                return true;
            }
            xz1.i("MCImplBase", "bind to " + this.e + " failed");
            return false;
        } catch (SecurityException e2) {
            xz1.j("MCImplBase", "bind to " + this.e + " not allowed", e2);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I2(Bundle bundle) {
        try {
            g.a.Z0((IBinder) gg3.q(this.e.a())).l0(this.c, this.b.c(), new u00(this.d.getPackageName(), Process.myPid(), bundle, this.a.g()).b());
            return true;
        } catch (RemoteException e2) {
            xz1.j("MCImplBase", "Failed to call connection request.", e2);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final xi1 J2(List list, List list2, Bundle bundle, d0 d0Var, hd3.b bVar) {
        return K2(list, list2, bundle, d0Var, bVar, d2());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K1(int i, List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.r.j.w()) {
            T2(list, -1, -9223372036854775807L, false);
        } else {
            W2(i2(this.r, Math.min(i, this.r.j.v()), list, getCurrentPosition(), getContentPosition()), 0, null, null, this.r.j.w() ? 3 : null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L1() {
        TextureView textureView = this.E;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            this.E = null;
        }
        SurfaceHolder surfaceHolder = this.D;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.h);
            this.D = null;
        }
        if (this.C != null) {
            this.C = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final hd3.b N1(hd3.b bVar, hd3.b bVar2) {
        hd3.b bVarF = a0.f(bVar, bVar2);
        boolean z = this.r.s.a == 0 && !this.n;
        return (!bVarF.c(32) || (z && bVarF.d(25, 33, 26, 34))) ? bVarF.b().a(32).g(25, z).g(33, z).g(26, z).g(34, z).f() : bVarF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N2(int i, long j) {
        int i2;
        int i3;
        b0 b0VarK2;
        no4 no4Var = this.r.j;
        if ((no4Var.w() || i < no4Var.v()) && !isPlayingAd()) {
            int i4 = getPlaybackState() == 1 ? 1 : 2;
            b0 b0Var = this.r;
            b0 b0VarM = b0Var.m(i4, b0Var.a);
            c cVarA2 = a2(no4Var, i, j);
            if (cVarA2 == null) {
                i2 = 1;
                i3 = 2;
                hd3.e eVar = new hd3.e(null, i, null, null, i, j == -9223372036854775807L ? 0L : j, j == -9223372036854775807L ? 0L : j, -1, -1);
                b0 b0Var2 = this.r;
                no4 no4Var2 = b0Var2.j;
                boolean z = this.r.c.b;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                c24 c24Var = this.r.c;
                b0VarK2 = m2(b0Var2, no4Var2, eVar, new c24(eVar, z, jElapsedRealtime, c24Var.d, j == -9223372036854775807L ? 0L : j, 0, 0L, c24Var.h, c24Var.i, j == -9223372036854775807L ? 0L : j), 1);
            } else {
                i2 = 1;
                i3 = 2;
                b0VarK2 = k2(b0VarM, no4Var, cVarA2);
            }
            int i5 = (this.r.j.w() || b0VarK2.c.a.c == this.r.c.a.c) ? 0 : i2;
            if (i5 == 0 && b0VarK2.c.a.g == this.r.c.a.g) {
                return;
            }
            W2(b0VarK2, null, null, Integer.valueOf(i2), i5 != 0 ? Integer.valueOf(i3) : null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O2(long j) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        N2(getCurrentMediaItemIndex(), Math.max(currentPosition, 0L));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P2(int i, d24 d24Var) {
        g gVar = this.G;
        if (gVar == null) {
            return;
        }
        try {
            gVar.P0(this.c, i, d24Var.b());
        } catch (RemoteException unused) {
            xz1.i("MCImplBase", "Error in sending");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q2(final int i, final lu1 lu1Var) {
        lu1Var.g(new Runnable() { // from class: ba2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                n.w0(this.f, lu1Var, i);
            }
        }, du2.b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lu1 R1(g gVar, d dVar, boolean z) {
        if (gVar == null) {
            return x81.e(new d24(-4));
        }
        p2();
        c0.a aVarA = this.b.a(new d24(1));
        int iS = aVarA.S();
        if (z) {
            if (this.k.isEmpty()) {
                this.K = this.r;
            }
            this.k.add(Integer.valueOf(iS));
        }
        try {
            dVar.a(gVar, iS);
            return aVarA;
        } catch (RemoteException e2) {
            xz1.j("MCImplBase", "Cannot connect to the service or the session is gone", e2);
            this.k.remove(Integer.valueOf(iS));
            this.b.e(iS, new d24(-100));
            return aVarA;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 R2(final y14 y14Var, final Bundle bundle, final l.e eVar) {
        return d2() < 7 ? e(y14Var, bundle) : U1(y14Var, new d(eVar, y14Var, bundle) { // from class: d92
            public final /* synthetic */ y14 b;
            public final /* synthetic */ Bundle c;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            {
                this.b = y14Var;
                this.c = bundle;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.n.d
            public final void a(g gVar, int i) {
                n.D0(this.a, null, this.b, this.c, gVar, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S1(d dVar) {
        this.j.e();
        R1(this.G, dVar, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S2(final int i, Object obj) {
        this.b.e(i, obj);
        Y1().n(new Runnable() { // from class: e92
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                n.x(this.f, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T1(d dVar) {
        this.j.e();
        lu1 lu1VarR1 = R1(this.G, dVar, true);
        try {
            i.d0(lu1VarR1, 3000L);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2);
        } catch (TimeoutException e3) {
            if (lu1VarR1 instanceof c0.a) {
                int iS = ((c0.a) lu1VarR1).S();
                this.k.remove(Integer.valueOf(iS));
                this.b.e(iS, new d24(-1));
            }
            xz1.j("MCImplBase", "Synchronous command takes too long on the session side.", e3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r26v0 ??, still in use, count: 1, list:
          (r26v0 ?? I:hd3$e) from 0x013b: CONSTRUCTOR (r25v0 ?? I:c24) = 
          (r26v0 ?? I:hd3$e)
          (r27v0 ?? I:boolean)
          (r28v0 ?? I:long)
          (r30v0 ?? I:long)
          (r32v0 ?? I:long)
          (r34v0 ?? I:int)
          (r35v0 ?? I:long)
          (r37v0 ?? I:long)
          (r39v0 ?? I:long)
          (r41v0 ?? I:long)
         A[MD:(hd3$e, boolean, long, long, long, int, long, long, long, long):void (m)] (LINE:316) call: c24.<init>(hd3$e, boolean, long, long, long, int, long, long, long, long):void type: CONSTRUCTOR
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void T2(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r26v0 ??, still in use, count: 1, list:
          (r26v0 ?? I:hd3$e) from 0x013b: CONSTRUCTOR (r25v0 ?? I:c24) = 
          (r26v0 ?? I:hd3$e)
          (r27v0 ?? I:boolean)
          (r28v0 ?? I:long)
          (r30v0 ?? I:long)
          (r32v0 ?? I:long)
          (r34v0 ?? I:int)
          (r35v0 ?? I:long)
          (r37v0 ?? I:long)
          (r39v0 ?? I:long)
          (r41v0 ?? I:long)
         A[MD:(hd3$e, boolean, long, long, long, int, long, long, long, long):void (m)] (LINE:316) call: c24.<init>(hd3$e, boolean, long, long, long, int, long, long, long, long):void type: CONSTRUCTOR
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r44v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lu1 U1(y14 y14Var, d dVar) {
        return V1(0, y14Var, dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U2(boolean z, int i) {
        int playbackSuppressionReason = getPlaybackSuppressionReason();
        if (playbackSuppressionReason == 1) {
            playbackSuppressionReason = 0;
        }
        b0 b0Var = this.r;
        if (b0Var.v == z && b0Var.z == playbackSuppressionReason) {
            return;
        }
        this.I = a0.e(b0Var, this.I, this.J, Y1().i());
        this.J = SystemClock.elapsedRealtime();
        W2(this.r.k(z, i, playbackSuppressionReason), null, Integer.valueOf(i), null, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lu1 V1(int i, y14 y14Var, d dVar) {
        return R1(y14Var != null ? f2(y14Var) : e2(i), dVar, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V2(final Surface surface, final int i, final int i2) {
        if (isConnected()) {
            if (d2() >= 8) {
                T1(new d() { // from class: ca2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // androidx.media3.session.n.d
                    public final void a(g gVar, int i3) {
                        gVar.u(this.a.c, i3, surface, i, i2);
                    }
                });
            } else {
                T1(new d() { // from class: da2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // androidx.media3.session.n.d
                    public final void a(g gVar, int i3) {
                        gVar.G(this.a.c, i3, surface);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Context W1() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W2(b0 b0Var, Integer num, Integer num2, Integer num3, Integer num4) {
        b0 b0Var2 = this.r;
        this.r = b0Var;
        q2(b0Var2, b0Var, num, num2, num3, num4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X2(c24 c24Var) {
        if (this.k.isEmpty()) {
            c24 c24Var2 = this.r.c;
            if (c24Var2.c >= c24Var.c || !a0.b(c24Var, c24Var2)) {
                return;
            }
            this.r = this.r.t(c24Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l Y1() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public d0 a() {
        return this.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c a2(no4 no4Var, int i, long j) {
        if (no4Var.w()) {
            return null;
        }
        no4.d dVar = new no4.d();
        no4.b bVar = new no4.b();
        if (i == -1 || i >= no4Var.v()) {
            i = no4Var.g(getShuffleModeEnabled());
            j = no4Var.t(i, dVar).c();
        }
        return b2(no4Var, dVar, bVar, i, fy4.c1(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void addListener(hd3.d dVar) {
        this.i.c(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void addMediaItem(final fg2 fg2Var) {
        if (g2(20)) {
            S1(new d() { // from class: ka2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.v0(nVar.c, i, fg2Var.g(nVar.d2()));
                }
            });
            K1(getCurrentTimeline().v(), Collections.singletonList(fg2Var));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void addMediaItems(final List list) {
        if (g2(20)) {
            S1(new d() { // from class: oc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.h(nVar.c, i, new km(fm.i(list, new p81() { // from class: pc2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.p81
                        public final Object apply(Object obj) {
                            return ((fg2) obj).g(nVar.d2());
                        }
                    })));
                }
            });
            K1(getCurrentTimeline().v(), list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void b() {
        boolean zH2;
        if (this.e.h() == 0) {
            this.p = null;
            zH2 = I2(this.f);
        } else {
            this.p = new e(this.f);
            zH2 = H2();
        }
        if (zH2) {
            return;
        }
        l lVarY1 = Y1();
        l lVarY12 = Y1();
        Objects.requireNonNull(lVarY12);
        lVarY1.n(new cc2(lVarY12));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public xi1 c() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearMediaItems() {
        if (g2(20)) {
            S1(new d() { // from class: ya2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.x(this.a.c, i);
                }
            });
            F2(0, Integer.MAX_VALUE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoSurface() {
        if (g2(27)) {
            L1();
            V2(null, 0, 0);
            D2(0, 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (g2(27) && surfaceHolder != null && this.D == surfaceHolder) {
            clearVideoSurface();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        if (g2(27)) {
            clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoTextureView(TextureView textureView) {
        if (g2(27) && textureView != null && this.E == textureView) {
            clearVideoSurface();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public Bundle d() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int d2() {
        return ((e24) gg3.q(this.o)).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void decreaseDeviceVolume() {
        if (g2(26)) {
            S1(new d() { // from class: gc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.I0(this.a.c, i);
                }
            });
            final int i = this.r.t - 1;
            if (i >= getDeviceInfo().b) {
                b0 b0Var = this.r;
                this.r = b0Var.e(i, b0Var.u);
                this.i.h(30, new pu1.a() { // from class: hc2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(i, this.a.r.u);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public lu1 e(final y14 y14Var, final Bundle bundle) {
        return d2() >= 7 ? R2(y14Var, bundle, null) : U1(y14Var, new d() { // from class: ia2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.n.d
            public final void a(g gVar, int i) {
                gVar.R0(this.a.c, i, y14Var.b(), bundle);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g e2(int i) {
        gg3.d(i != 0);
        if (this.y.a(i)) {
            return this.G;
        }
        xz1.i("MCImplBase", "Controller isn't allowed to call command, commandCode=" + i);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g f2(y14 y14Var) {
        gg3.d(y14Var.a == 0);
        if (this.y.b(y14Var) || androidx.media3.session.a.w(y14Var.b)) {
            return this.G;
        }
        xz1.i("MCImplBase", "Controller isn't allowed to call custom session command:" + y14Var.b);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g2(int i) {
        if (this.B.c(i)) {
            return true;
        }
        xz1.i("MCImplBase", "Controller isn't allowed to call command= " + i);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public yb getAudioAttributes() {
        return this.r.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getAudioSessionId() {
        return this.r.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public hd3.b getAvailableCommands() {
        return this.B;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getBufferedPercentage() {
        return this.r.c.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getBufferedPosition() {
        return this.r.c.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getContentBufferedPosition() {
        return this.r.c.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getContentDuration() {
        return this.r.c.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getContentPosition() {
        c24 c24Var = this.r.c;
        return !c24Var.b ? getCurrentPosition() : c24Var.a.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentAdGroupIndex() {
        return this.r.c.a.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentAdIndexInAdGroup() {
        return this.r.c.a.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public w50 getCurrentCues() {
        return this.r.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getCurrentLiveOffset() {
        return this.r.c.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentMediaItemIndex() {
        return X1(this.r);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentPeriodIndex() {
        return this.r.c.a.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getCurrentPosition() {
        long jE = a0.e(this.r, this.I, this.J, Y1().i());
        this.I = jE;
        return jE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public no4 getCurrentTimeline() {
        return this.r.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public xr4 getCurrentTracks() {
        return this.r.F;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public kk0 getDeviceInfo() {
        return this.r.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getDeviceVolume() {
        return this.r.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getDuration() {
        return this.r.c.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getMaxSeekToPreviousPosition() {
        return this.r.E;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public ph2 getMediaMetadata() {
        return this.r.B;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getNextMediaItemIndex() {
        if (this.r.j.w()) {
            return -1;
        }
        return this.r.j.k(getCurrentMediaItemIndex(), M1(this.r.h), this.r.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean getPlayWhenReady() {
        return this.r.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public dc3 getPlaybackParameters() {
        return this.r.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getPlaybackState() {
        return this.r.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getPlaybackSuppressionReason() {
        return this.r.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public ac3 getPlayerError() {
        return this.r.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public ph2 getPlaylistMetadata() {
        return this.r.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getPreviousMediaItemIndex() {
        if (this.r.j.w()) {
            return -1;
        }
        return this.r.j.r(getCurrentMediaItemIndex(), M1(this.r.h), this.r.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getRepeatMode() {
        return this.r.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getSeekBackIncrement() {
        return this.r.C;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getSeekForwardIncrement() {
        return this.r.D;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean getShuffleModeEnabled() {
        return this.r.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public d94 getSurfaceSize() {
        return this.F;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getTotalBufferedDuration() {
        return this.r.c.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public lr4 getTrackSelectionParameters() {
        return this.r.G;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public e35 getVideoSize() {
        return this.r.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public float getVolume() {
        return this.r.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h2() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void increaseDeviceVolume() {
        if (g2(26)) {
            S1(new d() { // from class: cb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.l(this.a.c, i);
                }
            });
            final int i = this.r.t + 1;
            int i2 = getDeviceInfo().c;
            if (i2 == 0 || i <= i2) {
                b0 b0Var = this.r;
                this.r = b0Var.e(i, b0Var.u);
                this.i.h(30, new pu1.a() { // from class: db2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(i, this.a.r.u);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isConnected() {
        return this.G != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isDeviceMuted() {
        return this.r.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isLoading() {
        return this.r.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isPlaying() {
        return this.r.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isPlayingAd() {
        return this.r.c.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final b0 k2(b0 b0Var, no4 no4Var, c cVar) {
        int i = b0Var.c.a.f;
        int i2 = cVar.a;
        no4.b bVar = new no4.b();
        no4Var.l(i, bVar);
        no4.b bVar2 = new no4.b();
        no4Var.l(i2, bVar2);
        boolean z = i != i2;
        long j = cVar.b;
        long jC1 = fy4.c1(getCurrentPosition()) - bVar.p();
        if (!z && j == jC1) {
            return b0Var;
        }
        gg3.v(b0Var.c.a.i == -1);
        hd3.e eVar = new hd3.e(null, bVar.c, b0Var.c.a.d, null, i, fy4.S1(bVar.e + jC1), fy4.S1(bVar.e + jC1), -1, -1);
        no4Var.l(i2, bVar2);
        no4.d dVar = new no4.d();
        no4Var.t(bVar2.c, dVar);
        long jS1 = fy4.S1(bVar2.e + j);
        hd3.e eVar2 = new hd3.e(null, bVar2.c, dVar.c, null, i2, jS1, jS1, -1, -1);
        b0 b0VarP = b0Var.p(eVar, eVar2, 1);
        if (z || j < jC1) {
            return b0VarP.t(new c24(eVar2, false, SystemClock.elapsedRealtime(), dVar.e(), jS1, a0.c(jS1, dVar.e()), 0L, -9223372036854775807L, -9223372036854775807L, jS1));
        }
        long jMax = Math.max(0L, fy4.c1(b0VarP.c.g) - (j - jC1));
        long jS12 = fy4.S1(bVar2.e + j + jMax);
        return b0VarP.t(new c24(eVar2, false, SystemClock.elapsedRealtime(), dVar.e(), jS12, a0.c(jS12, dVar.e()), fy4.S1(jMax), -9223372036854775807L, -9223372036854775807L, jS12));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void moveMediaItem(final int i, final int i2) {
        if (g2(20)) {
            gg3.d(i >= 0 && i2 >= 0);
            S1(new d() { // from class: zb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i3) {
                    gVar.Q0(this.a.c, i3, i, i2);
                }
            });
            n2(i, i + 1, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void moveMediaItems(final int i, final int i2, final int i3) {
        if (g2(20)) {
            gg3.d(i >= 0 && i <= i2 && i3 >= 0);
            S1(new d() { // from class: sa2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i4) {
                    gVar.B(this.a.c, i4, i, i2, i3);
                }
            });
            n2(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void mute() {
        if (g2(24)) {
            final float f2 = 0.0f;
            S1(new d() { // from class: wb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n.z1(this.a, f2, gVar, i);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.n != 0.0f) {
                this.r = b0Var.B(0.0f);
                this.i.h(22, new pu1.a() { // from class: xb2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onVolumeChanged(f2);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n2(int i, int i2, int i3) {
        int i4;
        int i5;
        no4 no4Var = this.r.j;
        int iV = no4Var.v();
        int iMin = Math.min(i2, iV);
        int i6 = iMin - i;
        int iMin2 = Math.min(i3, iV - i6);
        if (i >= iV || i == iMin || i == iMin2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < iV; i7++) {
            arrayList.add(no4Var.t(i7, new no4.d()));
        }
        fy4.b1(arrayList, i, iMin, iMin2);
        E2(no4Var, arrayList, arrayList2);
        no4 no4VarO1 = O1(arrayList, arrayList2);
        if (no4VarO1.w()) {
            return;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        if (currentMediaItemIndex >= i && currentMediaItemIndex < iMin) {
            i5 = (currentMediaItemIndex - i) + iMin2;
        } else if (iMin <= currentMediaItemIndex && iMin2 > currentMediaItemIndex) {
            i5 = currentMediaItemIndex - i6;
        } else {
            if (iMin <= currentMediaItemIndex || iMin2 > currentMediaItemIndex) {
                i4 = currentMediaItemIndex;
                no4.d dVar = new no4.d();
                W2(l2(this.r, no4VarO1, i4, no4VarO1.t(i4, dVar).n + (this.r.c.a.f - no4Var.t(currentMediaItemIndex, dVar).n), getCurrentPosition(), getContentPosition(), 5), 0, null, null, null);
            }
            i5 = currentMediaItemIndex + i6;
        }
        i4 = i5;
        no4.d dVar2 = new no4.d();
        W2(l2(this.r, no4VarO1, i4, no4VarO1.t(i4, dVar2).n + (this.r.c.a.f - no4Var.t(currentMediaItemIndex, dVar2).n), getCurrentPosition(), getContentPosition(), 5), 0, null, null, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o2(c24 c24Var) {
        if (isConnected()) {
            X2(c24Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p2() {
        MediaController mediaController;
        if (Build.VERSION.SDK_INT < 31 || (mediaController = this.H) == null) {
            return;
        }
        mediaController.getTransportControls().sendCustomAction("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST", (Bundle) null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void pause() {
        if (g2(1)) {
            S1(new d() { // from class: bb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.p(this.a.c, i);
                }
            });
            U2(false, 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void play() {
        if (!g2(1)) {
            xz1.i("MCImplBase", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
        } else {
            S1(new d() { // from class: kb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.r0(this.a.c, i);
                }
            });
            U2(true, 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void prepare() {
        if (g2(2)) {
            S1(new d() { // from class: nb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.O(this.a.c, i);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.A == 1) {
                W2(b0Var.m(b0Var.j.w() ? 4 : 2, null), null, null, null, null);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q2(b0 b0Var, final b0 b0Var2, final Integer num, final Integer num2, final Integer num3, final Integer num4) {
        if (num != null) {
            this.i.h(0, new pu1.a() { // from class: rc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onTimelineChanged(b0Var2.j, num.intValue());
                }
            });
        }
        if (num3 != null) {
            this.i.h(11, new pu1.a() { // from class: dd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    b0 b0Var3 = b0Var2;
                    ((hd3.d) obj).onPositionDiscontinuity(b0Var3.d, b0Var3.e, num3.intValue());
                }
            });
        }
        final fg2 fg2VarE = b0Var2.E();
        if (num4 != null) {
            this.i.h(1, new pu1.a() { // from class: nd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMediaItemTransition(fg2VarE, num4.intValue());
                }
            });
        }
        ac3 ac3Var = b0Var.a;
        final ac3 ac3Var2 = b0Var2.a;
        if (ac3Var != ac3Var2 && (ac3Var == null || !ac3Var.c(ac3Var2))) {
            this.i.h(10, new pu1.a() { // from class: od2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlayerErrorChanged(ac3Var2);
                }
            });
            if (ac3Var2 != null) {
                this.i.h(10, new pu1.a() { // from class: pd2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onPlayerError(ac3Var2);
                    }
                });
            }
        }
        if (!b0Var.F.equals(b0Var2.F)) {
            this.i.h(2, new pu1.a() { // from class: qd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onTracksChanged(b0Var2.F);
                }
            });
        }
        if (!b0Var.B.equals(b0Var2.B)) {
            this.i.h(14, new pu1.a() { // from class: rd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMediaMetadataChanged(b0Var2.B);
                }
            });
        }
        if (b0Var.y != b0Var2.y) {
            this.i.h(3, new pu1.a() { // from class: sd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onIsLoadingChanged(b0Var2.y);
                }
            });
        }
        if (b0Var.A != b0Var2.A) {
            this.i.h(4, new pu1.a() { // from class: td2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackStateChanged(b0Var2.A);
                }
            });
        }
        if (num2 != null) {
            this.i.h(5, new pu1.a() { // from class: a92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlayWhenReadyChanged(b0Var2.v, num2.intValue());
                }
            });
        }
        if (b0Var.z != b0Var2.z) {
            this.i.h(6, new pu1.a() { // from class: sc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackSuppressionReasonChanged(b0Var2.z);
                }
            });
        }
        if (b0Var.x != b0Var2.x) {
            this.i.h(7, new pu1.a() { // from class: tc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onIsPlayingChanged(b0Var2.x);
                }
            });
        }
        if (!b0Var.g.equals(b0Var2.g)) {
            this.i.h(12, new pu1.a() { // from class: uc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackParametersChanged(b0Var2.g);
                }
            });
        }
        if (b0Var.h != b0Var2.h) {
            this.i.h(8, new pu1.a() { // from class: vc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onRepeatModeChanged(b0Var2.h);
                }
            });
        }
        if (b0Var.i != b0Var2.i) {
            this.i.h(9, new pu1.a() { // from class: wc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onShuffleModeEnabledChanged(b0Var2.i);
                }
            });
        }
        if (!b0Var.m.equals(b0Var2.m)) {
            this.i.h(15, new pu1.a() { // from class: xc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaylistMetadataChanged(b0Var2.m);
                }
            });
        }
        if (b0Var.n != b0Var2.n) {
            this.i.h(22, new pu1.a() { // from class: zc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onVolumeChanged(b0Var2.n);
                }
            });
        }
        if (!b0Var.q.equals(b0Var2.q)) {
            this.i.h(20, new pu1.a() { // from class: ad2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAudioAttributesChanged(b0Var2.q);
                }
            });
        }
        if (b0Var.p != b0Var2.p) {
            this.i.h(21, new pu1.a() { // from class: bd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAudioSessionIdChanged(b0Var2.p);
                }
            });
        }
        if (!b0Var.r.a.equals(b0Var2.r.a)) {
            this.i.h(27, new pu1.a() { // from class: cd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onCues(b0Var2.r.a);
                }
            });
            this.i.h(27, new pu1.a() { // from class: ed2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onCues(b0Var2.r);
                }
            });
        }
        if (!b0Var.s.equals(b0Var2.s)) {
            this.i.h(29, new pu1.a() { // from class: fd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onDeviceInfoChanged(b0Var2.s);
                }
            });
        }
        if (b0Var.t != b0Var2.t || b0Var.u != b0Var2.u) {
            this.i.h(30, new pu1.a() { // from class: gd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    b0 b0Var3 = b0Var2;
                    ((hd3.d) obj).onDeviceVolumeChanged(b0Var3.t, b0Var3.u);
                }
            });
        }
        if (!b0Var.l.equals(b0Var2.l)) {
            this.i.h(25, new pu1.a() { // from class: hd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onVideoSizeChanged(b0Var2.l);
                }
            });
        }
        if (b0Var.C != b0Var2.C) {
            this.i.h(16, new pu1.a() { // from class: id2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onSeekBackIncrementChanged(b0Var2.C);
                }
            });
        }
        if (b0Var.D != b0Var2.D) {
            this.i.h(17, new pu1.a() { // from class: kd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onSeekForwardIncrementChanged(b0Var2.D);
                }
            });
        }
        if (b0Var.E != b0Var2.E) {
            this.i.h(18, new pu1.a() { // from class: ld2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMaxSeekToPreviousPositionChanged(b0Var2.E);
                }
            });
        }
        if (!b0Var.G.equals(b0Var2.G)) {
            this.i.h(19, new pu1.a() { // from class: md2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onTrackSelectionParametersChanged(b0Var2.G);
                }
            });
        }
        this.i.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r2(hd3.b bVar) {
        final n nVar;
        boolean z;
        boolean z2;
        if (isConnected() && !Objects.equals(this.A, bVar)) {
            this.A = bVar;
            hd3.b bVar2 = this.B;
            hd3.b bVarN1 = N1(this.z, bVar);
            this.B = bVarN1;
            if (Objects.equals(bVarN1, bVar2)) {
                nVar = this;
                z = false;
                z2 = false;
            } else {
                xi1 xi1Var = this.v;
                xi1 xi1Var2 = this.w;
                xi1 xi1VarL2 = L2(this.u, this.t, this.y, this.B, this.L);
                this.v = xi1VarL2;
                nVar = this;
                nVar.w = nVar.J2(xi1VarL2, this.t, this.L, this.y, this.B);
                z = !nVar.v.equals(xi1Var);
                z2 = !nVar.w.equals(xi1Var2);
                nVar.i.k(13, new pu1.a() { // from class: x92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onAvailableCommandsChanged(this.a.B);
                    }
                });
            }
            if (z2) {
                nVar.Y1().l(new g20() { // from class: y92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        n nVar2 = this.a;
                        ((l.c) obj).H0(nVar2.Y1(), nVar2.w);
                    }
                });
            }
            if (z) {
                nVar.Y1().l(new g20() { // from class: z92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        n nVar2 = this.a;
                        ((l.c) obj).Q(nVar2.Y1(), nVar2.v);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void release() {
        g gVar = this.G;
        if (this.q) {
            return;
        }
        this.q = true;
        this.o = null;
        this.m.removeCallbacksAndMessages(null);
        L1();
        this.j.d();
        this.G = null;
        if (gVar != null) {
            int iC = this.b.c();
            try {
                gVar.asBinder().unlinkToDeath(this.g, 0);
                gVar.L(this.c, iC);
            } catch (RemoteException unused) {
            }
        }
        this.i.i();
        this.b.b(30000L, new Runnable() { // from class: c92
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                n.a0(this.f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void removeListener(hd3.d dVar) {
        this.i.j(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void removeMediaItem(final int i) {
        if (g2(20)) {
            gg3.d(i >= 0);
            S1(new d() { // from class: wa2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.E0(this.a.c, i2, i);
                }
            });
            F2(i, i + 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void removeMediaItems(final int i, final int i2) {
        if (g2(20)) {
            gg3.d(i >= 0 && i2 >= i);
            S1(new d() { // from class: la2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i3) {
                    gVar.Y(this.a.c, i3, i, i2);
                }
            });
            F2(i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void replaceMediaItem(final int i, final fg2 fg2Var) {
        if (g2(20)) {
            gg3.d(i >= 0);
            S1(new d() { // from class: mc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    n.t(this.a, i, fg2Var, gVar, i2);
                }
            });
            G2(i, i + 1, xi1.w(fg2Var));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void replaceMediaItems(final int i, final int i2, final List list) {
        if (g2(20)) {
            gg3.d(i >= 0 && i <= i2);
            S1(new d() { // from class: rb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i3) {
                    n.Z0(this.a, list, i, i2, gVar, i3);
                }
            });
            G2(i, i2, list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s2(d0 d0Var, hd3.b bVar) {
        boolean z;
        final n nVar;
        final d0 d0Var2;
        boolean z2;
        if (isConnected()) {
            boolean zEquals = Objects.equals(this.z, bVar);
            boolean zEquals2 = Objects.equals(this.y, d0Var);
            if (zEquals && zEquals2) {
                return;
            }
            this.y = d0Var;
            boolean z3 = false;
            if (zEquals) {
                z = false;
            } else {
                this.z = bVar;
                hd3.b bVar2 = this.B;
                hd3.b bVarN1 = N1(bVar, this.A);
                this.B = bVarN1;
                z = !Objects.equals(bVarN1, bVar2);
            }
            if (!zEquals2 || z) {
                xi1 xi1Var = this.v;
                xi1 xi1Var2 = this.w;
                xi1 xi1VarL2 = L2(this.u, this.t, d0Var, this.B, this.L);
                this.v = xi1VarL2;
                nVar = this;
                d0Var2 = d0Var;
                nVar.w = nVar.J2(xi1VarL2, this.t, this.L, d0Var2, this.B);
                z2 = !nVar.v.equals(xi1Var);
                z3 = !nVar.w.equals(xi1Var2);
            } else {
                nVar = this;
                d0Var2 = d0Var;
                z2 = false;
            }
            if (z) {
                nVar.i.k(13, new pu1.a() { // from class: s92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onAvailableCommandsChanged(this.a.B);
                    }
                });
            }
            if (!zEquals2) {
                nVar.Y1().l(new g20() { // from class: t92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        l.c cVar = (l.c) obj;
                        cVar.H(this.a.Y1(), d0Var2);
                    }
                });
            }
            if (z3) {
                nVar.Y1().l(new g20() { // from class: u92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        n nVar2 = this.a;
                        ((l.c) obj).H0(nVar2.Y1(), nVar2.w);
                    }
                });
            }
            if (z2) {
                nVar.Y1().l(new g20() { // from class: w92
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        n nVar2 = this.a;
                        ((l.c) obj).Q(nVar2.Y1(), nVar2.v);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekBack() {
        if (g2(11)) {
            S1(new d() { // from class: za2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.z0(this.a.c, i);
                }
            });
            O2(-getSeekBackIncrement());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekForward() {
        if (g2(12)) {
            S1(new d() { // from class: ea2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.o0(this.a.c, i);
                }
            });
            O2(getSeekForwardIncrement());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekTo(final int i, final long j) {
        if (g2(10)) {
            gg3.d(i >= 0);
            S1(new d() { // from class: hb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.t(this.a.c, i2, i, j);
                }
            });
            N2(i, j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToDefaultPosition(final int i) {
        if (g2(10)) {
            gg3.d(i >= 0);
            S1(new d() { // from class: z82
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.r(this.a.c, i2, i);
                }
            });
            N2(i, -9223372036854775807L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToNext() {
        if (g2(9)) {
            S1(new d() { // from class: gb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.b0(this.a.c, i);
                }
            });
            no4 currentTimeline = getCurrentTimeline();
            if (currentTimeline.w() || isPlayingAd()) {
                return;
            }
            if (hasNextMediaItem()) {
                N2(getNextMediaItemIndex(), -9223372036854775807L);
                return;
            }
            no4.d dVarT = currentTimeline.t(getCurrentMediaItemIndex(), new no4.d());
            if (dVarT.i && dVarT.g()) {
                N2(getCurrentMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToNextMediaItem() {
        if (g2(8)) {
            S1(new d() { // from class: dc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.F0(this.a.c, i);
                }
            });
            if (getNextMediaItemIndex() != -1) {
                N2(getNextMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToPrevious() {
        if (g2(7)) {
            S1(new d() { // from class: xa2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.p0(this.a.c, i);
                }
            });
            no4 currentTimeline = getCurrentTimeline();
            if (currentTimeline.w() || isPlayingAd()) {
                return;
            }
            boolean zHasPreviousMediaItem = hasPreviousMediaItem();
            no4.d dVarT = currentTimeline.t(getCurrentMediaItemIndex(), new no4.d());
            if (dVarT.i && dVarT.g()) {
                if (zHasPreviousMediaItem) {
                    N2(getPreviousMediaItemIndex(), -9223372036854775807L);
                }
            } else if (!zHasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
                N2(getCurrentMediaItemIndex(), 0L);
            } else {
                N2(getPreviousMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToPreviousMediaItem() {
        if (g2(6)) {
            S1(new d() { // from class: va2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.Z(this.a.c, i);
                }
            });
            if (getPreviousMediaItemIndex() != -1) {
                N2(getPreviousMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setAudioAttributes(final yb ybVar, final boolean z) {
        if (g2(35)) {
            S1(new d() { // from class: kc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.S(this.a.c, i, ybVar.f(), z);
                }
            });
            if (this.r.q.equals(ybVar)) {
                return;
            }
            this.r = this.r.a(ybVar);
            this.i.h(20, new pu1.a() { // from class: lc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAudioAttributesChanged(ybVar);
                }
            });
            this.i.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setDeviceMuted(final boolean z) {
        if (g2(26)) {
            S1(new d() { // from class: ob2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.m(this.a.c, i, z);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.u != z) {
                this.r = b0Var.e(b0Var.t, z);
                this.i.h(30, new pu1.a() { // from class: pb2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(this.a.r.t, z);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setDeviceVolume(final int i) {
        if (g2(25)) {
            S1(new d() { // from class: ec2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.U(this.a.c, i2, i);
                }
            });
            kk0 deviceInfo = getDeviceInfo();
            b0 b0Var = this.r;
            if (b0Var.t == i || deviceInfo.b > i) {
                return;
            }
            int i2 = deviceInfo.c;
            if (i2 == 0 || i <= i2) {
                this.r = b0Var.e(i, b0Var.u);
                this.i.h(30, new pu1.a() { // from class: fc2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(i, this.a.r.u);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setMediaItem(final fg2 fg2Var) {
        if (g2(31)) {
            S1(new d() { // from class: ha2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.H(nVar.c, i, fg2Var.g(nVar.d2()));
                }
            });
            T2(Collections.singletonList(fg2Var), -1, -9223372036854775807L, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setMediaItems(final List list, final boolean z) {
        if (g2(20)) {
            S1(new d() { // from class: h92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.X(nVar.c, i, new km(fm.i(list, new p81() { // from class: aa2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.p81
                        public final Object apply(Object obj) {
                            return ((fg2) obj).g(this.f.d2());
                        }
                    })), z);
                }
            });
            T2(list, -1, -9223372036854775807L, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlayWhenReady(final boolean z) {
        if (g2(1)) {
            S1(new d() { // from class: yb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.s0(this.a.c, i, z);
                }
            });
            U2(z, 1);
        } else if (z) {
            xz1.i("MCImplBase", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlaybackParameters(final dc3 dc3Var) {
        if (g2(13)) {
            S1(new d() { // from class: ud2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.A(this.a.c, i, dc3Var.c());
                }
            });
            if (this.r.g.equals(dc3Var)) {
                return;
            }
            this.r = this.r.l(dc3Var);
            this.i.h(12, new pu1.a() { // from class: k92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackParametersChanged(dc3Var);
                }
            });
            this.i.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlaybackSpeed(final float f2) {
        if (g2(13)) {
            S1(new d() { // from class: oa2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.U0(this.a.c, i, f2);
                }
            });
            dc3 dc3Var = this.r.g;
            if (dc3Var.a != f2) {
                final dc3 dc3VarD = dc3Var.d(f2);
                this.r = this.r.l(dc3VarD);
                this.i.h(12, new pu1.a() { // from class: pa2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onPlaybackParametersChanged(dc3VarD);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlaylistMetadata(final ph2 ph2Var) {
        if (g2(19)) {
            S1(new d() { // from class: fa2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.K(nVar.c, i, ph2Var.f(nVar.d2()));
                }
            });
            if (this.r.m.equals(ph2Var)) {
                return;
            }
            this.r = this.r.o(ph2Var);
            this.i.h(15, new pu1.a() { // from class: ga2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaylistMetadataChanged(ph2Var);
                }
            });
            this.i.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setRepeatMode(final int i) {
        if (g2(15)) {
            S1(new d() { // from class: ac2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.v(this.a.c, i2, i);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.h != i) {
                this.r = b0Var.q(i);
                this.i.h(8, new pu1.a() { // from class: bc2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onRepeatModeChanged(i);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setShuffleModeEnabled(final boolean z) {
        if (g2(14)) {
            S1(new d() { // from class: ta2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.M(this.a.c, i, z);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.i != z) {
                this.r = b0Var.u(z);
                this.i.h(9, new pu1.a() { // from class: ua2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onShuffleModeEnabledChanged(z);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setTrackSelectionParameters(final lr4 lr4Var) {
        if (g2(29)) {
            S1(new d() { // from class: ic2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.W0(this.a.c, i, lr4Var.O());
                }
            });
            b0 b0Var = this.r;
            if (lr4Var != b0Var.G) {
                this.r = b0Var.y(lr4Var);
                this.i.h(19, new pu1.a() { // from class: jc2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onTrackSelectionParametersChanged(lr4Var);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoSurface(Surface surface) {
        if (g2(27)) {
            L1();
            this.C = surface;
            int i = surface == null ? 0 : -1;
            V2(surface, i, i);
            D2(i, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (g2(27)) {
            if (surfaceHolder == null) {
                clearVideoSurface();
                return;
            }
            if (this.D == surfaceHolder) {
                return;
            }
            L1();
            this.D = surfaceHolder;
            surfaceHolder.addCallback(this.h);
            Surface surface = surfaceHolder.getSurface();
            if (surface == null || !surface.isValid()) {
                this.C = null;
                V2(null, 0, 0);
                D2(0, 0);
            } else {
                this.C = surface;
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                V2(surface, surfaceFrame.width(), surfaceFrame.height());
                D2(surfaceFrame.width(), surfaceFrame.height());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        if (g2(27)) {
            setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoTextureView(TextureView textureView) {
        if (g2(27)) {
            if (textureView == null) {
                clearVideoSurface();
                return;
            }
            if (this.E == textureView) {
                return;
            }
            L1();
            this.E = textureView;
            textureView.setSurfaceTextureListener(this.h);
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            if (surfaceTexture == null) {
                V2(null, 0, 0);
                D2(0, 0);
            } else {
                Surface surface = new Surface(surfaceTexture);
                this.C = surface;
                V2(surface, textureView.getWidth(), textureView.getHeight());
                D2(textureView.getWidth(), textureView.getHeight());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVolume(final float f2) {
        if (g2(24)) {
            S1(new d() { // from class: qb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.O0(this.a.c, i, f2);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.n != f2) {
                this.r = b0Var.B(f2);
                this.i.h(22, new pu1.a() { // from class: sb2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onVolumeChanged(f2);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void stop() {
        if (g2(3)) {
            S1(new d() { // from class: lb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.i0(this.a.c, i);
                }
            });
            b0 b0Var = this.r;
            c24 c24Var = this.r.c;
            hd3.e eVar = c24Var.a;
            boolean z = c24Var.b;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c24 c24Var2 = this.r.c;
            long j = c24Var2.d;
            long j2 = c24Var2.a.g;
            int iC = a0.c(j2, j);
            c24 c24Var3 = this.r.c;
            b0 b0VarT = b0Var.t(new c24(eVar, z, jElapsedRealtime, j, j2, iC, 0L, c24Var3.h, c24Var3.i, c24Var3.a.g));
            this.r = b0VarT;
            if (b0VarT.A != 1) {
                this.r = b0VarT.m(1, b0VarT.a);
                this.i.h(4, new pu1.a() { // from class: mb2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onPlaybackStateChanged(1);
                    }
                });
                this.i.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t2(androidx.media3.session.c cVar) {
        if (this.G != null) {
            xz1.d("MCImplBase", "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
            Y1().release();
            return;
        }
        this.G = cVar.c;
        this.r = cVar.j;
        this.s = cVar.d;
        this.y = cVar.e;
        hd3.b bVar = cVar.f;
        this.z = bVar;
        hd3.b bVar2 = cVar.g;
        this.A = bVar2;
        hd3.b bVarN1 = N1(bVar, bVar2);
        this.B = bVarN1;
        xi1 xi1Var = cVar.k;
        this.t = xi1Var;
        xi1 xi1Var2 = cVar.l;
        this.u = xi1Var2;
        xi1 xi1VarL2 = L2(xi1Var2, xi1Var, this.y, bVarN1, cVar.i);
        this.v = xi1VarL2;
        this.w = K2(xi1VarL2, this.t, cVar.i, this.y, this.B, cVar.b);
        zi1.a aVar = new zi1.a();
        for (int i = 0; i < cVar.n.size(); i++) {
            androidx.media3.session.a aVar2 = (androidx.media3.session.a) cVar.n.get(i);
            y14 y14Var = aVar2.a;
            if (y14Var != null && y14Var.a == 0) {
                aVar.g(y14Var.b, aVar2);
            }
        }
        this.x = aVar.d();
        MediaSession.Token tokenF = cVar.m;
        if (tokenF == null) {
            tokenF = this.e.f();
        }
        MediaSession.Token token = tokenF;
        if (token != null) {
            this.H = new MediaController(this.d, token);
        }
        try {
            cVar.c.asBinder().linkToDeath(this.g, 0);
            this.o = new e24(this.e.i(), 0, cVar.a, cVar.b, this.e.e(), cVar.c, cVar.h, token);
            this.L = cVar.i;
            Y1().k();
        } catch (RemoteException unused) {
            Y1().release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u2(final int i, final y14 y14Var, final Bundle bundle) {
        if (isConnected()) {
            Y1().l(new g20() { // from class: p92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    n nVar = this.a;
                    nVar.Q2(i, (lu1) gg3.r(((l.c) obj).A0(nVar.Y1(), y14Var, bundle), "ControllerCallback#onCustomCommand() must not return null"));
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void unmute() {
        if (g2(24)) {
            final float f2 = this.r.o;
            S1(new d() { // from class: tb2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n.F0(this.a, f2, gVar, i);
                }
            });
            b0 b0Var = this.r;
            float f3 = b0Var.n;
            if (f3 == b0Var.o || f3 != 0.0f) {
                return;
            }
            this.r = b0Var.B(f2);
            this.i.h(22, new pu1.a() { // from class: ub2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onVolumeChanged(f2);
                }
            });
            this.i.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v2(int i, y14 y14Var, Bundle bundle, Bundle bundle2) {
        if (isConnected()) {
            w82.a(this.l.get(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w2(int i, final b24 b24Var) {
        if (isConnected()) {
            Y1().l(new g20() { // from class: r92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    l.c cVar = (l.c) obj;
                    cVar.V(this.a.Y1(), b24Var);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x2(final Bundle bundle) {
        if (isConnected()) {
            xi1 xi1Var = this.v;
            xi1 xi1Var2 = this.w;
            this.L = bundle;
            xi1 xi1VarL2 = L2(this.u, this.t, this.y, this.B, bundle);
            this.v = xi1VarL2;
            this.w = J2(xi1VarL2, this.t, this.L, this.y, this.B);
            final boolean z = !this.v.equals(xi1Var);
            final boolean z2 = !this.w.equals(xi1Var2);
            Y1().l(new g20() { // from class: l92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    n.P(this.a, bundle, z2, z, (l.c) obj);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y2(b0 b0Var, b0.c cVar) {
        b0 b0Var2;
        b0.c cVar2;
        if (isConnected()) {
            boolean z = d2() < 6;
            b0 b0Var3 = this.K;
            if (b0Var3 != null) {
                this.K = a0.g(b0Var3, b0Var, cVar, this.B, z, (e24) gg3.q(this.o));
                if (!this.k.isEmpty()) {
                    return;
                }
                b0 b0Var4 = this.K;
                b0.c cVar3 = b0.c.c;
                this.K = null;
                b0Var2 = b0Var4;
                cVar2 = cVar3;
            } else {
                b0Var2 = b0Var;
                cVar2 = cVar;
            }
            b0 b0Var5 = this.r;
            b0 b0VarG = a0.g(b0Var5, b0Var2, cVar2, this.B, z, (e24) gg3.q(this.o));
            this.r = b0VarG;
            Integer numValueOf = (b0Var5.d.equals(b0Var2.d) && b0Var5.e.equals(b0Var2.e)) ? null : Integer.valueOf(b0VarG.f);
            boolean zEquals = Objects.equals(b0Var5.E(), b0VarG.E());
            Integer numValueOf2 = !zEquals ? Integer.valueOf(b0VarG.b) : null;
            if (zEquals && numValueOf != null && (numValueOf.intValue() == 0 || numValueOf.intValue() == 1)) {
                if (b0Var5.e.c != b0VarG.e.c) {
                    numValueOf2 = Integer.valueOf(numValueOf.intValue() != 0 ? 2 : 1);
                } else if (b0Var5.h != 0 && numValueOf.intValue() == 0 && b0Var5.d.i == -1 && b0VarG.e.i == -1) {
                    numValueOf2 = 0;
                }
            }
            Integer numValueOf3 = !b0Var5.j.equals(b0VarG.j) ? Integer.valueOf(b0VarG.k) : null;
            int i = b0Var5.w;
            int i2 = b0VarG.w;
            q2(b0Var5, b0VarG, numValueOf3, (i == i2 && b0Var5.v == b0VarG.v) ? null : Integer.valueOf(i2), numValueOf, numValueOf2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z2() {
        this.i.k(26, new yx0());
    }

    @Override // androidx.media3.session.l.d
    public void clearVideoSurface(Surface surface) {
        if (g2(27) && surface != null && this.C == surface) {
            clearVideoSurface();
        }
    }

    @Override // androidx.media3.session.l.d
    public void addMediaItems(final int i, final List list) {
        if (g2(20)) {
            gg3.d(i >= 0);
            S1(new d() { // from class: ab2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    n nVar = this.a;
                    gVar.I(nVar.c, i2, i, new km(fm.i(list, new p81() { // from class: qc2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.p81
                        public final Object apply(Object obj) {
                            return ((fg2) obj).g(nVar.d2());
                        }
                    })));
                }
            });
            K1(i, list);
        }
    }

    @Override // androidx.media3.session.l.d
    public void seekTo(final long j) {
        if (g2(5)) {
            S1(new d() { // from class: v92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.H0(this.a.c, i, j);
                }
            });
            N2(getCurrentMediaItemIndex(), j);
        }
    }

    @Override // androidx.media3.session.l.d
    public void setMediaItems(final List list, final int i, final long j) {
        if (g2(20)) {
            S1(new d() { // from class: g92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    n nVar = this.a;
                    gVar.T0(nVar.c, i2, new km(fm.i(list, new p81() { // from class: o92
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.p81
                        public final Object apply(Object obj) {
                            return ((fg2) obj).g(nVar.d2());
                        }
                    })), i, j);
                }
            });
            T2(list, i, j, false);
        }
    }

    @Override // androidx.media3.session.l.d
    public void addMediaItem(final int i, final fg2 fg2Var) {
        if (g2(20)) {
            gg3.d(i >= 0);
            S1(new d() { // from class: nc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    n nVar = this.a;
                    gVar.j(nVar.c, i2, i, fg2Var.g(nVar.d2()));
                }
            });
            K1(i, Collections.singletonList(fg2Var));
        }
    }

    @Override // androidx.media3.session.l.d
    public void setMediaItem(final fg2 fg2Var, final long j) {
        if (g2(31)) {
            S1(new d() { // from class: f92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.C0(nVar.c, i, fg2Var.g(nVar.d2()), j);
                }
            });
            T2(Collections.singletonList(fg2Var), -1, j, false);
        }
    }

    @Override // androidx.media3.session.l.d
    public void seekToDefaultPosition() {
        if (g2(4)) {
            S1(new d() { // from class: ja2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    gVar.y0(this.a.c, i);
                }
            });
            N2(getCurrentMediaItemIndex(), -9223372036854775807L);
        }
    }

    @Override // androidx.media3.session.l.d
    public void setMediaItem(final fg2 fg2Var, final boolean z) {
        if (g2(31)) {
            S1(new d() { // from class: i92
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i) {
                    n nVar = this.a;
                    gVar.h0(nVar.c, i, fg2Var.g(nVar.d2()), z);
                }
            });
            T2(Collections.singletonList(fg2Var), -1, -9223372036854775807L, z);
        }
    }

    @Override // androidx.media3.session.l.d
    public void setDeviceMuted(final boolean z, final int i) {
        if (g2(34)) {
            S1(new d() { // from class: qa2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.N0(this.a.c, i2, z, i);
                }
            });
            b0 b0Var = this.r;
            if (b0Var.u != z) {
                this.r = b0Var.e(b0Var.t, z);
                this.i.h(30, new pu1.a() { // from class: ra2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(this.a.r.t, z);
                    }
                });
                this.i.e();
            }
        }
    }

    @Override // androidx.media3.session.l.d
    public void decreaseDeviceVolume(final int i) {
        if (g2(34)) {
            S1(new d() { // from class: yc2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.B0(this.a.c, i2, i);
                }
            });
            final int i2 = this.r.t - 1;
            if (i2 >= getDeviceInfo().b) {
                b0 b0Var = this.r;
                this.r = b0Var.e(i2, b0Var.u);
                this.i.h(30, new pu1.a() { // from class: jd2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(i2, this.a.r.u);
                    }
                });
                this.i.e();
            }
        }
    }

    @Override // androidx.media3.session.l.d
    public void increaseDeviceVolume(final int i) {
        if (g2(34)) {
            S1(new d() { // from class: ib2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i2) {
                    gVar.w0(this.a.c, i2, i);
                }
            });
            final int i2 = this.r.t + 1;
            int i3 = getDeviceInfo().c;
            if (i3 == 0 || i2 <= i3) {
                b0 b0Var = this.r;
                this.r = b0Var.e(i2, b0Var.u);
                this.i.h(30, new pu1.a() { // from class: jb2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(i2, this.a.r.u);
                    }
                });
                this.i.e();
            }
        }
    }

    @Override // androidx.media3.session.l.d
    public void setDeviceVolume(final int i, final int i2) {
        if (g2(33)) {
            S1(new d() { // from class: ma2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.n.d
                public final void a(g gVar, int i3) {
                    gVar.k(this.a.c, i3, i, i2);
                }
            });
            kk0 deviceInfo = getDeviceInfo();
            b0 b0Var = this.r;
            if (b0Var.t == i || deviceInfo.b > i) {
                return;
            }
            int i3 = deviceInfo.c;
            if (i3 == 0 || i <= i3) {
                this.r = b0Var.e(i, b0Var.u);
                this.i.h(30, new pu1.a() { // from class: na2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        hd3.d dVar = (hd3.d) obj;
                        dVar.onDeviceVolumeChanged(i, this.a.r.u);
                    }
                });
                this.i.e();
            }
        }
    }
}

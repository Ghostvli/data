package androidx.media3.session;

import android.app.PendingIntent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.a;
import androidx.media3.session.b;
import androidx.media3.session.b0;
import androidx.media3.session.g;
import androidx.media3.session.r;
import androidx.media3.session.u;
import androidx.media3.session.v;
import androidx.media3.session.z;
import defpackage.ac3;
import defpackage.br4;
import defpackage.c24;
import defpackage.d24;
import defpackage.dc3;
import defpackage.du2;
import defpackage.fg2;
import defpackage.fm;
import defpackage.fm2;
import defpackage.fy4;
import defpackage.g20;
import defpackage.gb;
import defpackage.gg3;
import defpackage.gq2;
import defpackage.h24;
import defpackage.hd3;
import defpackage.jr4;
import defpackage.km;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.p24;
import defpackage.p81;
import defpackage.ph2;
import defpackage.pw4;
import defpackage.t41;
import defpackage.u00;
import defpackage.u43;
import defpackage.ue3;
import defpackage.ui1;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yb;
import defpackage.yn3;
import defpackage.zi1;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends g.a {
    public final WeakReference d;
    public final androidx.media3.session.b e;
    public final Set f = Collections.synchronizedSet(new HashSet());
    public ui1 g = ui1.r();
    public zi1 h = zi1.j();
    public int i;
    public g j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements u.f {
        public final androidx.media3.session.f a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(androidx.media3.session.f fVar, int i) {
            this.a = fVar;
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void A(int i, hd3.b bVar) {
            this.a.N(i, bVar.h());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void D(int i, d24 d24Var) {
            this.a.X0(i, d24Var.b());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void H(int i, String str, int i2, MediaLibraryService.b bVar) {
            this.a.d0(i, str, i2, bVar == null ? null : bVar.b());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void I(int i, c24 c24Var, boolean z, boolean z2, int i2) {
            this.a.Q(i, c24Var.a(z, z2).c(i2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public IBinder O() {
            return this.a.asBinder();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void a(int i) {
            h24.b(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void b(int i) {
            this.a.b(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void c(int i, int i2, int i3) {
            this.a.c(i, i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void d(int i, PendingIntent pendingIntent) {
            this.a.d(i, pendingIntent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            return Objects.equals(O(), ((a) obj).O());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void h(int i, y14 y14Var, Bundle bundle) {
            this.a.R(i, y14Var.b(), bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return u43.b(O());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void i(int i, List list) {
            if (this.b >= 7) {
                this.a.a0(i, fm.i(list, new p81() { // from class: hq2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((a) obj).z(this.f.b);
                    }
                }));
            } else {
                this.a.g(i, fm.i(androidx.media3.session.a.m(list, true, true, 9), new p81() { // from class: iq2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((a) obj).z(this.f.b);
                    }
                }));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void s(int i, String str, int i2, MediaLibraryService.b bVar) {
            this.a.M0(i, str, i2, bVar == null ? null : bVar.b());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void t(int i, j jVar) {
            this.a.c0(i, jVar.l(this.b));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.f
        public void y(int i, b0 b0Var, hd3.b bVar, boolean z, boolean z2) {
            gg3.v(this.b != 0);
            boolean z3 = z || !bVar.c(17);
            boolean z4 = z2 || !bVar.c(30);
            if (this.b < 2) {
                this.a.L0(i, b0Var.C(bVar, z, true).G(this.b), z3);
            } else {
                b0 b0VarC = b0Var.C(bVar, z, z2);
                this.a.T(i, this.a instanceof p ? b0VarC.H() : b0VarC.G(this.b), new b0.c(z3, z4).b());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(ue3 ue3Var, u.g gVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void a(ue3 ue3Var, u.g gVar, List list);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(ue3 ue3Var, u.i iVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e implements u.j {
        public final v a;
        public final u.g b;
        public final int c;
        public final y14 d;
        public final Bundle e;
        public lu1 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(v vVar, u.g gVar, int i, y14 y14Var, Bundle bundle) {
            this.a = vVar;
            this.b = gVar;
            this.c = i;
            this.d = y14Var;
            this.e = bundle;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(lu1 lu1Var) {
            this.f = lu1Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        Object a(v vVar, u.g gVar, int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z(v vVar) {
        this.d = new WeakReference(vVar);
        this.e = new androidx.media3.session.b(vVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void A2(z zVar, int i, int i2, ue3 ue3Var) {
        g gVar;
        if (((v) gg3.q((v) zVar.d.get())).k1() || (gVar = zVar.j) == null) {
            return;
        }
        gVar.setFixedSize(i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void B2(z zVar, u.g gVar, ue3 ue3Var) {
        v vVar = (v) zVar.d.get();
        if (vVar == null || vVar.H0()) {
            return;
        }
        vVar.D0(gVar, false);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:boolean:0x0000: INVOKE (r3v0 androidx.media3.session.v) VIRTUAL call: androidx.media3.session.v.H0():boolean A[MD:():boolean (m), WRAPPED] (LINE:1)) != false) ? (wrap:lu1:0x000d: INVOKE 
      (wrap:d24:0x000a: CONSTRUCTOR (-100 int) A[MD:(int):void (m), WRAPPED] (LINE:11) call: d24.<init>(int):void type: CONSTRUCTOR)
     STATIC call: x81.e(java.lang.Object):lu1 A[MD:(java.lang.Object):lu1 (m), WRAPPED] (LINE:14)) : (wrap:lu1:0x001d: INVOKE 
      (wrap:lu1:0x0016: CHECK_CAST (lu1) (wrap:java.lang.Object:0x0012: INVOKE (r1v0 androidx.media3.session.z$f), (r3v0 androidx.media3.session.v), (r4v0 androidx.media3.session.u$g), (r5v0 int) INTERFACE call: androidx.media3.session.z.f.a(androidx.media3.session.v, androidx.media3.session.u$g, int):java.lang.Object A[MD:(androidx.media3.session.v, androidx.media3.session.u$g, int):java.lang.Object (m), WRAPPED] (LINE:19)))
      (wrap:gb:0x001a: CONSTRUCTOR 
      (r3v0 androidx.media3.session.v A[DONT_INLINE])
      (r4v0 androidx.media3.session.u$g A[DONT_INLINE])
      (r2v0 androidx.media3.session.z$c A[DONT_INLINE])
     A[MD:(androidx.media3.session.v, androidx.media3.session.u$g, androidx.media3.session.z$c):void (m), WRAPPED] (LINE:27) call: zp2.<init>(androidx.media3.session.v, androidx.media3.session.u$g, androidx.media3.session.z$c):void type: CONSTRUCTOR)
     STATIC call: fy4.Q1(lu1, gb):lu1 A[MD:(lu1, gb):lu1 (m), WRAPPED] (LINE:30)) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ lu1 C1(f fVar, final c cVar, final v vVar, final u.g gVar, int i) {
        return vVar.H0() ? x81.e(new d24(-100)) : fy4.Q1((lu1) fVar.a(vVar, gVar, i), new gb() { // from class: zp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.gb
            public final lu1 apply(Object obj) {
                v vVar2 = vVar;
                u.g gVar2 = gVar;
                return fy4.p1(vVar2.e0(), vVar2.Q(gVar2, new Runnable() { // from class: fq2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.D2(vVar2, cVar, gVar2, list);
                    }
                }), new d24(0));
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void D2(v vVar, c cVar, u.g gVar, List list) {
        if (vVar.H0()) {
            return;
        }
        cVar.a(vVar.v0(), gVar, list);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0004: CHECK_CAST (lu1) (wrap:java.lang.Object:0x0000: INVOKE (r0v0 androidx.media3.session.z$f), (r1v0 androidx.media3.session.v), (r2v0 androidx.media3.session.u$g), (r3v0 int) INTERFACE call: androidx.media3.session.z.f.a(androidx.media3.session.v, androidx.media3.session.u$g, int):java.lang.Object A[MD:(androidx.media3.session.v, androidx.media3.session.u$g, int):java.lang.Object (m), WRAPPED] (LINE:1)) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ lu1 E1(f fVar, v vVar, u.g gVar, int i) {
        return (lu1) fVar.a(vVar, gVar, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void E2(v vVar, p24 p24Var, g20 g20Var, lu1 lu1Var) {
        if (vVar.H0()) {
            p24Var.M(null);
            return;
        }
        try {
            g20Var.accept(lu1Var);
            p24Var.M(null);
        } catch (Throwable th) {
            p24Var.N(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void J1(v vVar, u.g gVar, int i, lu1 lu1Var) {
        d24 d24Var;
        try {
            d24Var = (d24) gg3.r((d24) lu1Var.get(), "SessionResult must not be null");
        } catch (InterruptedException e2) {
            e = e2;
            xz1.j("MediaSessionStub", "Session operation failed", e);
            d24Var = new d24(!(e.getCause() instanceof UnsupportedOperationException) ? -6 : -1);
        } catch (CancellationException e3) {
            xz1.j("MediaSessionStub", "Session operation cancelled", e3);
            d24Var = new d24(1);
        } catch (ExecutionException e4) {
            e = e4;
            xz1.j("MediaSessionStub", "Session operation failed", e);
            d24Var = new d24(!(e.getCause() instanceof UnsupportedOperationException) ? -6 : -1);
        }
        c3(vVar, gVar, i, d24Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void L1(z zVar, Surface surface, ue3 ue3Var) {
        if (((v) gg3.q((v) zVar.d.get())).k1()) {
            ue3Var.setVideoSurface(surface);
            return;
        }
        if (surface == null) {
            ue3Var.setVideoSurfaceHolder(null);
            zVar.j = null;
        } else {
            g gVar = new g(surface);
            zVar.j = gVar;
            ue3Var.setVideoSurfaceHolder(gVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void N1(z zVar, u.g gVar, y14 y14Var, v vVar, int i, androidx.media3.session.f fVar) {
        if (zVar.e.p(gVar)) {
            try {
                final androidx.media3.session.a aVarF = androidx.media3.session.a.f(y14Var);
                if (!aVarF.d()) {
                    xz1.i("MediaSessionStub", "Can't execute predefined custom command: " + y14Var.b);
                    c3(vVar, gVar, i, new d24(-6));
                    return;
                }
                y14 y14Var2 = aVarF.a;
                if (y14Var2 != null) {
                    gg3.v(y14Var2.a == 40010);
                    zVar.H2(fVar, i, 40010, f3(new f() { // from class: aq2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // androidx.media3.session.z.f
                        public final Object a(v vVar2, u.g gVar2, int i2) {
                            return vVar2.W0(gVar2, (yn3) gg3.q(aVarF.j));
                        }
                    }));
                    return;
                }
                if (aVarF.v(vVar.v0())) {
                    zVar.S2(gVar, i);
                } else {
                    int i2 = aVarF.b;
                    if (i2 == 31) {
                        zVar.g3(gVar, i, (fg2) gg3.q(aVarF.j), true);
                    } else {
                        zVar.U2(gVar, i, i2, d3(new g20() { // from class: bq2
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // defpackage.g20
                            public final void accept(Object obj) {
                                aVarF.k((ue3) obj);
                            }
                        }));
                    }
                }
                zVar.e.h(gVar);
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Failed to convert predefined custom command: " + y14Var.b, e2);
                c3(vVar, gVar, i, new d24(-3));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f N2(final f fVar, final c cVar) {
        return new f() { // from class: sp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i) {
                return z.C1(fVar, cVar, vVar, gVar, i);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f O2(final f fVar, final d dVar) {
        return new f() { // from class: mp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i) {
                return z.u1(fVar, dVar, vVar, gVar, i);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lu1 P2(final v vVar, u.g gVar, int i, f fVar, final g20 g20Var) {
        if (vVar.H0()) {
            return x81.f();
        }
        final lu1 lu1Var = (lu1) fVar.a(vVar, gVar, i);
        final p24 p24VarQ = p24.Q();
        lu1Var.g(new Runnable() { // from class: dq2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                z.E2(vVar, p24VarQ, g20Var, lu1Var);
            }
        }, du2.b());
        return p24VarQ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void S1(z zVar, final u.g gVar, int i, final v vVar, final int i2, final f fVar) {
        if (!zVar.e.q(gVar, i)) {
            c3(vVar, gVar, i2, new d24(-4));
            return;
        }
        int iS0 = vVar.S0(gVar, i);
        if (iS0 != 0) {
            c3(vVar, gVar, i2, new d24(iS0));
        } else if (i != 27) {
            zVar.e.f(gVar, i, new b.a() { // from class: xp2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.b.a
                public final lu1 run() {
                    return z.E1(fVar, vVar, gVar, i2);
                }
            });
        } else {
            vVar.Q(gVar, new Runnable() { // from class: vp2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    fVar.a(vVar, gVar, i2);
                }
            }).run();
            zVar.e.f(gVar, i, new b.a() { // from class: wp2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.b.a
                public final lu1 run() {
                    return x81.f();
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void W1(z zVar, u.g gVar, v vVar, androidx.media3.session.f fVar) throws Throwable {
        androidx.media3.session.f fVar2;
        hd3.b bVar;
        zVar.getClass();
        boolean z = false;
        try {
            zVar.f.remove(gVar);
            if (vVar.H0()) {
                h24.b(fVar);
                return;
            }
            IBinder iBinderO = ((a) gg3.q((a) gVar.c())).O();
            u.e eVarL0 = vVar.L0(gVar);
            if (!eVarL0.a && !gVar.h()) {
                h24.b(fVar);
                return;
            }
            if (!eVarL0.a) {
                eVarL0 = u.e.a(d0.b, hd3.b.b);
            }
            if (zVar.e.p(gVar)) {
                xz1.i("MediaSessionStub", "Controller " + gVar + " has sent connection request multiple times");
            }
            zVar.e.e(iBinderO, gVar, eVarL0.b, eVarL0.c);
            c0 c0VarN = zVar.e.n(gVar);
            if (c0VarN == null) {
                xz1.i("MediaSessionStub", "Ignoring connection request from unknown controller info");
                h24.b(fVar);
                return;
            }
            ue3 ue3VarV0 = vVar.v0();
            b0 b0VarU0 = vVar.u0();
            ac3 ac3VarT0 = vVar.t0();
            if (ac3VarT0 == null) {
                bVar = eVarL0.c;
            } else {
                zVar.e.v(gVar, ac3VarT0, eVarL0.c);
                b0VarU0 = v.W(b0VarU0, ac3VarT0);
                bVar = (hd3.b) gg3.q(v.V(eVarL0.c));
            }
            hd3.b bVar2 = bVar;
            b0 b0VarJ3 = zVar.j3(b0VarU0);
            MediaSession.Token tokenS0 = vVar.s0();
            PendingIntent pendingIntentW0 = eVarL0.g;
            if (pendingIntentW0 == null) {
                pendingIntentW0 = vVar.w0();
            }
            xi1 xi1VarK0 = eVarL0.d;
            if (xi1VarK0 == null) {
                xi1VarK0 = vVar.k0();
            }
            xi1 xi1VarO0 = eVarL0.e;
            if (xi1VarO0 == null) {
                xi1VarO0 = vVar.o0();
            }
            xi1 xi1VarH0 = vVar.h0();
            d0 d0Var = eVarL0.b;
            hd3.b availableCommands = ue3VarV0.getAvailableCommands();
            Bundle bundleC = vVar.A0().c();
            Bundle bundleX0 = eVarL0.f;
            if (bundleX0 == null) {
                bundleX0 = vVar.x0();
            }
            fVar2 = fVar;
            try {
                androidx.media3.session.c cVar = new androidx.media3.session.c(1010000300, 9, zVar, pendingIntentW0, xi1VarK0, xi1VarO0, xi1VarH0, d0Var, bVar2, availableCommands, bundleC, bundleX0, b0VarJ3, tokenS0);
                if (vVar.H0()) {
                    h24.b(fVar2);
                    return;
                }
                try {
                    fVar2.F(c0VarN.c(), fVar2 instanceof p ? cVar.j() : cVar.i(gVar.e()));
                    z = true;
                } catch (RemoteException unused) {
                }
                if (z) {
                    vVar.U0(gVar);
                }
                if (z) {
                    return;
                }
                h24.b(fVar2);
            } catch (Throwable th) {
                th = th;
                if (!z) {
                    h24.b(fVar2);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fVar2 = fVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a1(z zVar, u.g gVar, y14 y14Var, v vVar, int i, int i2, f fVar) {
        if (zVar.e.p(gVar)) {
            androidx.media3.session.b bVar = zVar.e;
            if (y14Var != null) {
                if (!bVar.s(gVar, y14Var)) {
                    c3(vVar, gVar, i, new d24(-4));
                    return;
                }
            } else if (!bVar.r(gVar, i2)) {
                c3(vVar, gVar, i, new d24(-4));
                return;
            }
            fVar.a(vVar, gVar, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a3(u.g gVar, int i, j jVar) {
        try {
            ((u.f) gg3.q(gVar.c())).t(i, jVar);
        } catch (RemoteException e2) {
            xz1.j("MediaSessionStub", "Failed to send result to browser " + gVar, e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f b3(final f fVar) {
        return new f() { // from class: pp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i) {
                return z.P2((r) vVar, gVar, i, fVar, new g20() { // from class: tp2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        z.g1(gVar, i, (lu1) obj);
                    }
                });
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c3(v vVar, u.g gVar, int i, d24 d24Var) {
        try {
            ((u.f) gg3.q(gVar.c())).D(i, d24Var);
            vVar.l1();
        } catch (RemoteException e2) {
            xz1.j("MediaSessionStub", "Failed to send result to controller " + gVar, e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f d3(final g20 g20Var) {
        return e3(new b() { // from class: op2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.b
            public final void a(ue3 ue3Var, u.g gVar) {
                g20Var.accept(ue3Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f e3(final b bVar) {
        return new f() { // from class: jp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i) {
                return z.z2(bVar, vVar, gVar, i);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f f3(final f fVar) {
        return new f() { // from class: qp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i) {
                return z.P2(vVar, gVar, i, fVar, new g20() { // from class: cq2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        z.J1(vVar, gVar, i, (lu1) obj);
                    }
                });
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void g1(u.g gVar, int i, lu1 lu1Var) {
        j jVarE;
        try {
            jVarE = (j) gg3.r((j) lu1Var.get(), "LibraryResult must not be null");
        } catch (InterruptedException e2) {
            e = e2;
            xz1.j("MediaSessionStub", "Library operation failed", e);
            jVarE = j.e(-1);
        } catch (CancellationException e3) {
            xz1.j("MediaSessionStub", "Library operation cancelled", e3);
            jVarE = j.e(1);
        } catch (ExecutionException e4) {
            e = e4;
            xz1.j("MediaSessionStub", "Library operation failed", e);
            jVarE = j.e(-1);
        }
        a3(gVar, i, jVarE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void l1(v vVar, d dVar, u.i iVar) {
        if (vVar.H0()) {
            return;
        }
        dVar.a(vVar.v0(), iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ lu1 q2(boolean z, y14 y14Var, Bundle bundle, v vVar, u.g gVar, int i) {
        Bundle bundle2;
        u.g gVar2;
        y14 y14Var2;
        v vVar2;
        e eVar;
        if (z) {
            y14Var2 = y14Var;
            vVar2 = vVar;
            bundle2 = bundle;
            gVar2 = gVar;
            eVar = new e(vVar2, gVar2, i, y14Var2, bundle2);
        } else {
            bundle2 = bundle;
            gVar2 = gVar;
            y14Var2 = y14Var;
            vVar2 = vVar;
            eVar = null;
        }
        lu1 lu1VarM0 = vVar2.M0(gVar2, eVar, y14Var2, bundle2);
        if (eVar != null) {
            eVar.a(lu1VarM0);
        }
        return lu1VarM0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void s1(z zVar, Surface surface, int i, int i2, ue3 ue3Var) {
        if (((v) gg3.q((v) zVar.d.get())).k1()) {
            ue3Var.setVideoSurface(surface);
            return;
        }
        if (surface == null) {
            ue3Var.setVideoSurfaceHolder(null);
            zVar.j = null;
        } else {
            g gVar = new g(surface, i, i2);
            zVar.j = gVar;
            ue3Var.setVideoSurfaceHolder(gVar);
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:boolean:0x0000: INVOKE (r3v0 androidx.media3.session.v) VIRTUAL call: androidx.media3.session.v.H0():boolean A[MD:():boolean (m), WRAPPED] (LINE:1)) != false) ? (wrap:lu1:0x000d: INVOKE 
      (wrap:d24:0x000a: CONSTRUCTOR (-100 int) A[MD:(int):void (m), WRAPPED] (LINE:11) call: d24.<init>(int):void type: CONSTRUCTOR)
     STATIC call: x81.e(java.lang.Object):lu1 A[MD:(java.lang.Object):lu1 (m), WRAPPED] (LINE:14)) : (wrap:lu1:0x001d: INVOKE 
      (wrap:lu1:0x0016: CHECK_CAST (lu1) (wrap:java.lang.Object:0x0012: INVOKE (r1v0 androidx.media3.session.z$f), (r3v0 androidx.media3.session.v), (r4v0 androidx.media3.session.u$g), (r5v0 int) INTERFACE call: androidx.media3.session.z.f.a(androidx.media3.session.v, androidx.media3.session.u$g, int):java.lang.Object A[MD:(androidx.media3.session.v, androidx.media3.session.u$g, int):java.lang.Object (m), WRAPPED] (LINE:19)))
      (wrap:gb:0x001a: CONSTRUCTOR 
      (r3v0 androidx.media3.session.v A[DONT_INLINE])
      (r4v0 androidx.media3.session.u$g A[DONT_INLINE])
      (r2v0 androidx.media3.session.z$d A[DONT_INLINE])
     A[MD:(androidx.media3.session.v, androidx.media3.session.u$g, androidx.media3.session.z$d):void (m), WRAPPED] (LINE:27) call: up2.<init>(androidx.media3.session.v, androidx.media3.session.u$g, androidx.media3.session.z$d):void type: CONSTRUCTOR)
     STATIC call: fy4.Q1(lu1, gb):lu1 A[MD:(lu1, gb):lu1 (m), WRAPPED] (LINE:30)) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ lu1 u1(f fVar, final d dVar, final v vVar, final u.g gVar, int i) {
        return vVar.H0() ? x81.e(new d24(-100)) : fy4.Q1((lu1) fVar.a(vVar, gVar, i), new gb() { // from class: up2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.gb
            public final lu1 apply(Object obj) {
                v vVar2 = vVar;
                return fy4.p1(vVar2.e0(), vVar2.Q(gVar, new Runnable() { // from class: eq2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.l1(vVar2, dVar, iVar);
                    }
                }), new d24(0));
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void u2(z zVar, int i, ue3 ue3Var, u.g gVar, List list) {
        zVar.getClass();
        if (list.size() == 1) {
            ue3Var.replaceMediaItem(zVar.Q2(gVar, ue3Var, i), (fg2) list.get(0));
        } else {
            ue3Var.replaceMediaItems(zVar.Q2(gVar, ue3Var, i), zVar.Q2(gVar, ue3Var, i + 1), list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ lu1 v1(List list, int i, long j, v vVar, u.g gVar, int i2) {
        int currentMediaItemIndex = i == -1 ? vVar.v0().getCurrentMediaItemIndex() : i;
        if (i == -1) {
            j = vVar.v0().getCurrentPosition();
        }
        return vVar.V0(gVar, list, currentMediaItemIndex, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ lu1 z2(b bVar, v vVar, u.g gVar, int i) {
        if (vVar.H0()) {
            return x81.f();
        }
        bVar.a(vVar.v0(), gVar);
        c3(vVar, gVar, i, new d24(0));
        return x81.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void A(androidx.media3.session.f fVar, int i, Bundle bundle) {
        if (fVar == null || bundle == null) {
            return;
        }
        try {
            final dc3 dc3VarA = dc3.a(bundle);
            T2(fVar, i, 13, d3(new g20() { // from class: qn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((ue3) obj).setPlaybackParameters(dc3VarA);
                }
            }));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for PlaybackParameters", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void A0(androidx.media3.session.f fVar, int i, final String str, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "subscribe(): Ignoring empty parentId");
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        H2(fVar, i, 50001, b3(new f() { // from class: dp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i2) {
                return ((r) vVar).L1(gVar, str, bVarA);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void B(androidx.media3.session.f fVar, int i, final int i2, final int i3, final int i4) {
        if (fVar == null || i2 < 0 || i3 < i2 || i4 < 0) {
            return;
        }
        T2(fVar, i, 20, d3(new g20() { // from class: ao2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).moveMediaItems(i2, i3, i4);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void B0(androidx.media3.session.f fVar, int i, final int i2) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 34, d3(new g20() { // from class: kn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).decreaseDeviceVolume(i2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void C(androidx.media3.session.f fVar, int i, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (fVar == null) {
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        H2(fVar, i, 50000, b3(new f() { // from class: xo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i2) {
                return ((r) vVar).I1(gVar, bVarA);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void C0(androidx.media3.session.f fVar, int i, Bundle bundle, final long j) {
        u.g gVarK;
        if (fVar == null || bundle == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final fg2 fg2VarB = fg2.b(bundle, gVarK.e());
            U2(gVarK, i, 31, f3(O2(new f() { // from class: bp2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return vVar.V0(gVar, xi1.w(fg2VarB), 0, j);
                }
            }, new gq2())));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void E0(androidx.media3.session.f fVar, int i, final int i2) {
        if (fVar == null || i2 < 0) {
            return;
        }
        T2(fVar, i, 20, e3(new b() { // from class: cp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.b
            public final void a(ue3 ue3Var, u.g gVar) {
                ue3Var.removeMediaItem(this.a.Q2(gVar, ue3Var, i2));
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void F0(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 8, d3(new g20() { // from class: in2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekToNextMediaItem();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F2(final androidx.media3.session.f fVar, final u.g gVar) {
        if (fVar == null || gVar == null) {
            h24.b(fVar);
            return;
        }
        final v vVar = (v) this.d.get();
        if (vVar == null || vVar.H0()) {
            h24.b(fVar);
        } else {
            this.f.add(gVar);
            fy4.o1(vVar.e0(), new Runnable() { // from class: vn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    z.W1(this.f, gVar, vVar, fVar);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void G(androidx.media3.session.f fVar, int i, final Surface surface) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 27, d3(new g20() { // from class: wo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                z.L1(this.a, surface, (ue3) obj);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void G0(androidx.media3.session.f fVar, int i, Bundle bundle) {
        if (fVar == null || bundle == null) {
            return;
        }
        try {
            final yn3 yn3VarA = yn3.a(bundle);
            H2(fVar, i, 40010, f3(new f() { // from class: pm2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return vVar.W0(gVar, yn3VarA);
                }
            }));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for Rating", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G2(final androidx.media3.session.f fVar, final int i, final y14 y14Var) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final v vVar = (v) this.d.get();
            if (vVar != null && !vVar.H0()) {
                final u.g gVarK = this.e.k(fVar.asBinder());
                if (gVarK == null) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } else {
                    fy4.o1(vVar.e0(), new Runnable() { // from class: rp2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            z.N1(this.f, gVarK, y14Var, vVar, i, fVar);
                        }
                    });
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void H(androidx.media3.session.f fVar, int i, Bundle bundle) {
        h0(fVar, i, bundle, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void H0(androidx.media3.session.f fVar, int i, final long j) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 5, d3(new g20() { // from class: gp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekTo(j);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H2(androidx.media3.session.f fVar, int i, int i2, f fVar2) {
        I2(fVar, i, null, i2, fVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void I(androidx.media3.session.f fVar, int i, final int i2, IBinder iBinder) {
        final u.g gVarK;
        if (fVar == null || iBinder == null || i2 < 0 || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final xi1 xi1VarD = fm.d(new p81() { // from class: sn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return fg2.b((Bundle) obj, gVarK.e());
                }
            }, km.a(iBinder));
            U2(gVarK, i, 20, f3(N2(new f() { // from class: tn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i3) {
                    return vVar.K0(gVar, xi1VarD);
                }
            }, new c() { // from class: un2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.c
                public final void a(ue3 ue3Var, u.g gVar, List list) {
                    ue3Var.addMediaItems(this.a.Q2(gVar, ue3Var, i2), list);
                }
            })));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void I0(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 26, d3(new g20() { // from class: go2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).decreaseDeviceVolume();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I2(androidx.media3.session.f fVar, final int i, final y14 y14Var, final int i2, final f fVar2) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final v vVar = (v) this.d.get();
            if (vVar != null && !vVar.H0()) {
                final u.g gVarK = this.e.k(fVar.asBinder());
                if (gVarK == null) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } else {
                    fy4.o1(vVar.e0(), new Runnable() { // from class: kp2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            z.a1(this.f, gVarK, y14Var, vVar, i, i2, fVar2);
                        }
                    });
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J2(androidx.media3.session.f fVar, int i, y14 y14Var, f fVar2) {
        I2(fVar, i, y14Var, 0, fVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void K(androidx.media3.session.f fVar, int i, Bundle bundle) {
        u.g gVarK;
        if (fVar == null || bundle == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final ph2 ph2VarC = ph2.c(bundle, gVarK.e());
            U2(gVarK, i, 19, d3(new g20() { // from class: ap2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((ue3) obj).setPlaylistMetadata(ph2VarC);
                }
            }));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaMetadata", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K2(xi1 xi1Var) {
        ui1.a aVarO = ui1.o();
        zi1.a aVarA = zi1.a();
        for (int i = 0; i < xi1Var.size(); i++) {
            br4 br4VarC = ((xr4.a) xi1Var.get(i)).c();
            String strL2 = (String) this.g.get(br4VarC);
            if (strL2 == null) {
                strL2 = L2(br4VarC);
            }
            aVarO.g(br4VarC, strL2);
            aVarA.g(br4VarC.b, strL2);
        }
        this.g = aVarO.d();
        this.h = aVarA.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void L(final androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            v vVar = (v) this.d.get();
            if (vVar != null && !vVar.H0()) {
                fy4.o1(vVar.e0(), new Runnable() { // from class: sm2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.e.u(fVar.asBinder());
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String L2(br4 br4Var) {
        StringBuilder sb = new StringBuilder();
        int i = this.i;
        this.i = i + 1;
        sb.append(fy4.N0(i));
        sb.append("-");
        sb.append(br4Var.b);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void M(androidx.media3.session.f fVar, int i, final boolean z) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 14, d3(new g20() { // from class: to2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setShuffleModeEnabled(z);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public androidx.media3.session.b M2() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void N0(androidx.media3.session.f fVar, int i, final boolean z, final int i2) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 34, d3(new g20() { // from class: zo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setDeviceMuted(z, i2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void O(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 2, d3(new g20() { // from class: yo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).prepare();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void O0(androidx.media3.session.f fVar, int i, final float f2) {
        if (fVar == null || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        T2(fVar, i, 24, d3(new g20() { // from class: so2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setVolume(f2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void P0(androidx.media3.session.f fVar, int i, Bundle bundle) {
        if (fVar == null || bundle == null) {
            return;
        }
        try {
            d24 d24VarA = d24.a(bundle);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                c0 c0VarO = this.e.o(fVar.asBinder());
                if (c0VarO == null) {
                    return;
                }
                c0VarO.e(i, d24VarA);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void Q0(androidx.media3.session.f fVar, int i, final int i2, final int i3) {
        if (fVar == null || i2 < 0 || i3 < 0) {
            return;
        }
        T2(fVar, i, 20, d3(new g20() { // from class: ep2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).moveMediaItem(i2, i3);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int Q2(u.g gVar, ue3 ue3Var, int i) {
        return (ue3Var.isCommandAvailable(17) && !this.e.q(gVar, 17) && this.e.q(gVar, 16)) ? i + ue3Var.getCurrentMediaItemIndex() : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void R0(androidx.media3.session.f fVar, int i, Bundle bundle, Bundle bundle2) {
        k0(fVar, i, bundle, bundle2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R2(u.g gVar, int i) {
        U2(gVar, i, 1, d3(new g20() { // from class: en2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).pause();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void S(androidx.media3.session.f fVar, int i, Bundle bundle, final boolean z) {
        if (fVar == null || bundle == null) {
            return;
        }
        try {
            final yb ybVarA = yb.a(bundle);
            T2(fVar, i, 35, d3(new g20() { // from class: ko2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((ue3) obj).setAudioAttributes(ybVarA, z);
                }
            }));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for AudioAttributes", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S2(final u.g gVar, int i) {
        U2(gVar, i, 1, d3(new g20() { // from class: wn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                z.B2(this.a, gVar, (ue3) obj);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void T0(androidx.media3.session.f fVar, int i, IBinder iBinder, final int i2, final long j) {
        final u.g gVarK;
        if (fVar == null || iBinder == null) {
            return;
        }
        if ((i2 == -1 || i2 >= 0) && (gVarK = this.e.k(fVar.asBinder())) != null) {
            try {
                final xi1 xi1VarD = fm.d(new p81() { // from class: bo2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return fg2.b((Bundle) obj, gVarK.e());
                    }
                }, km.a(iBinder));
                U2(gVarK, i, 20, f3(O2(new f() { // from class: co2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // androidx.media3.session.z.f
                    public final Object a(v vVar, u.g gVar, int i3) {
                        return z.v1(xi1VarD, i2, j, vVar, gVar, i3);
                    }
                }, new gq2())));
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T2(androidx.media3.session.f fVar, int i, int i2, f fVar2) {
        u.g gVarK = this.e.k(fVar.asBinder());
        if (gVarK != null) {
            U2(gVarK, i, i2, fVar2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void U(androidx.media3.session.f fVar, int i, final int i2) {
        if (fVar == null || i2 < 0) {
            return;
        }
        T2(fVar, i, 25, d3(new g20() { // from class: fp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setDeviceVolume(i2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void U0(androidx.media3.session.f fVar, int i, final float f2) {
        if (fVar == null || f2 <= 0.0f) {
            return;
        }
        T2(fVar, i, 13, d3(new g20() { // from class: bn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setPlaybackSpeed(f2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U2(final u.g gVar, final int i, final int i2, final f fVar) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final v vVar = (v) this.d.get();
            if (vVar != null && !vVar.H0()) {
                fy4.o1(vVar.e0(), new Runnable() { // from class: lp2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.S1(this.f, gVar, i2, vVar, i, fVar);
                    }
                });
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void V(androidx.media3.session.f fVar, int i, final String str, final int i2, final int i3, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "getChildren(): Ignoring empty parentId");
            return;
        }
        if (i2 < 0) {
            xz1.i("MediaSessionStub", "getChildren(): Ignoring negative page");
            return;
        }
        if (i3 < 1) {
            xz1.i("MediaSessionStub", "getChildren(): Ignoring pageSize less than 1");
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        H2(fVar, i, 50003, b3(new f() { // from class: rm2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i4) {
                return ((r) vVar).G1(gVar, str, i2, i3, bVarA);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void V0(androidx.media3.session.f fVar, int i, final int i2, Bundle bundle) {
        u.g gVarK;
        if (fVar == null || bundle == null || i2 < 0 || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final fg2 fg2VarB = fg2.b(bundle, gVarK.e());
            U2(gVarK, i, 20, f3(N2(new f() { // from class: mn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i3) {
                    return vVar.K0(gVar, xi1.w(fg2VarB));
                }
            }, new c() { // from class: nn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.c
                public final void a(ue3 ue3Var, u.g gVar, List list) {
                    z.u2(this.a, i2, ue3Var, gVar, list);
                }
            })));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V2() {
        for (u.g gVar : this.e.j()) {
            this.e.t(gVar);
            u.f fVarC = gVar.c();
            if (fVarC != null) {
                fVarC.a(0);
            }
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            u.f fVarC2 = ((u.g) it.next()).c();
            if (fVarC2 != null) {
                fVarC2.a(0);
            }
        }
        this.f.clear();
        this.d.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void W(androidx.media3.session.f fVar) {
        if (fVar == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            v vVar = (v) this.d.get();
            if (vVar != null && !vVar.H0()) {
                final u.g gVarK = this.e.k(fVar.asBinder());
                if (gVarK != null) {
                    fy4.o1(vVar.e0(), new Runnable() { // from class: yn2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.e.h(gVarK);
                        }
                    });
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void W0(androidx.media3.session.f fVar, int i, Bundle bundle) {
        if (fVar == null || bundle == null) {
            return;
        }
        try {
            final lr4 lr4VarN = lr4.N(bundle);
            T2(fVar, i, 29, d3(new g20() { // from class: zm2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((ue3) obj).setTrackSelectionParameters(this.a.i3(lr4VarN));
                }
            }));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for TrackSelectionParameters", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W2(u.g gVar, int i) {
        U2(gVar, i, 11, d3(new g20() { // from class: on2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekBack();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void X(androidx.media3.session.f fVar, int i, IBinder iBinder, final boolean z) {
        final u.g gVarK;
        if (fVar == null || iBinder == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final xi1 xi1VarD = fm.d(new p81() { // from class: np2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return fg2.b((Bundle) obj, gVarK.e());
                }
            }, km.a(iBinder));
            U2(gVarK, i, 20, f3(O2(new f() { // from class: yp2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    List list = xi1VarD;
                    boolean z2 = z;
                    return vVar.V0(gVar, list, z2 ? -1 : vVar.v0().getCurrentMediaItemIndex(), z2 ? -9223372036854775807L : vVar.v0().getCurrentPosition());
                }
            }, new gq2())));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X2(u.g gVar, int i) {
        U2(gVar, i, 12, d3(new g20() { // from class: eo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekForward();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void Y(androidx.media3.session.f fVar, int i, final int i2, final int i3) {
        if (fVar == null || i2 < 0 || i3 < i2) {
            return;
        }
        T2(fVar, i, 20, e3(new b() { // from class: om2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.b
            public final void a(ue3 ue3Var, u.g gVar) {
                z zVar = this.a;
                ue3Var.removeMediaItems(zVar.Q2(gVar, ue3Var, i2), zVar.Q2(gVar, ue3Var, i3));
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y2(u.g gVar, int i) {
        U2(gVar, i, 9, d3(new g20() { // from class: fo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekToNext();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void Z(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 6, d3(new g20() { // from class: zn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekToPreviousMediaItem();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z2(u.g gVar, int i) {
        U2(gVar, i, 7, d3(new g20() { // from class: rn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekToPrevious();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void b0(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        Y2(gVarK, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void e0(androidx.media3.session.f fVar, int i, final String str, final int i2, final int i3, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "getSearchResult(): Ignoring empty query");
            return;
        }
        if (i2 < 0) {
            xz1.i("MediaSessionStub", "getSearchResult(): Ignoring negative page");
            return;
        }
        if (i3 < 1) {
            xz1.i("MediaSessionStub", "getSearchResult(): Ignoring pageSize less than 1");
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        H2(fVar, i, 50006, b3(new f() { // from class: qo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i4) {
                return ((r) vVar).J1(gVar, str, i2, i3, bVarA);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void f0(androidx.media3.session.f fVar, int i, IBinder iBinder) {
        X(fVar, i, iBinder, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g3(u.g gVar, int i, final fg2 fg2Var, final boolean z) {
        U2(gVar, i, 31, f3(O2(new f() { // from class: xm2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar2, int i2) {
                fg2 fg2Var2 = fg2Var;
                boolean z2 = z;
                return vVar.V0(gVar2, xi1.w(fg2Var2), z2 ? -1 : vVar.v0().getCurrentMediaItemIndex(), z2 ? -9223372036854775807L : vVar.v0().getCurrentPosition());
            }
        }, new gq2())));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void h(androidx.media3.session.f fVar, int i, IBinder iBinder) {
        final u.g gVarK;
        if (fVar == null || iBinder == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final xi1 xi1VarD = fm.d(new p81() { // from class: lo2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return fg2.b((Bundle) obj, gVarK.e());
                }
            }, km.a(iBinder));
            U2(gVarK, i, 20, f3(N2(new f() { // from class: mo2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return vVar.K0(gVar, xi1VarD);
                }
            }, new c() { // from class: no2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.c
                public final void a(ue3 ue3Var, u.g gVar, List list) {
                    ue3Var.addMediaItems(list);
                }
            })));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void h0(androidx.media3.session.f fVar, int i, Bundle bundle, boolean z) {
        u.g gVarK;
        if (fVar == null || bundle == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            g3(gVarK, i, fg2.b(bundle, gVarK.e()), z);
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h3(u.g gVar, int i) {
        U2(gVar, i, 3, d3(new g20() { // from class: uo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).stop();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void i0(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        h3(gVarK, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lr4 i3(lr4 lr4Var) {
        if (lr4Var.H.isEmpty()) {
            return lr4Var;
        }
        lr4.c cVarL = lr4Var.M().L();
        pw4 it = lr4Var.H.values().iterator();
        while (it.hasNext()) {
            jr4 jr4Var = (jr4) it.next();
            br4 br4Var = (br4) this.g.q().get(jr4Var.a.b);
            if (br4Var == null || jr4Var.a.a != br4Var.a) {
                cVarL.J(jr4Var);
            } else {
                cVarL.J(new jr4(br4Var, jr4Var.b));
            }
        }
        return cVarL.K();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void j(androidx.media3.session.f fVar, int i, final int i2, Bundle bundle) {
        u.g gVarK;
        if (fVar == null || bundle == null || i2 < 0 || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final fg2 fg2VarB = fg2.b(bundle, gVarK.e());
            U2(gVarK, i, 20, f3(N2(new f() { // from class: fn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i3) {
                    return vVar.K0(gVar, xi1.w(fg2VarB));
                }
            }, new c() { // from class: gn2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.c
                public final void a(ue3 ue3Var, u.g gVar, List list) {
                    ue3Var.addMediaItems(this.a.Q2(gVar, ue3Var, i2), list);
                }
            })));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void j0(androidx.media3.session.f fVar, int i, final String str, Bundle bundle) {
        if (fVar == null || str == null || bundle == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "setRatingWithMediaId(): Ignoring empty mediaId");
            return;
        }
        try {
            final yn3 yn3VarA = yn3.a(bundle);
            H2(fVar, i, 40010, f3(new f() { // from class: ho2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return vVar.X0(gVar, str, yn3VarA);
                }
            }));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for Rating", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b0 j3(b0 b0Var) {
        xi1 xi1VarB = b0Var.F.b();
        K2(xi1VarB);
        xi1.a aVarM = xi1.m();
        for (int i = 0; i < xi1VarB.size(); i++) {
            xr4.a aVar = (xr4.a) xi1VarB.get(i);
            aVarM.a(aVar.a(k3(aVar.c())));
        }
        b0 b0VarC = b0Var.c(new xr4(aVarM.k()));
        if (b0VarC.G.H.isEmpty()) {
            return b0VarC;
        }
        lr4.c cVarL = b0VarC.G.M().L();
        pw4 it = b0VarC.G.H.values().iterator();
        while (it.hasNext()) {
            jr4 jr4Var = (jr4) it.next();
            cVarL.J(new jr4(k3(jr4Var.a), jr4Var.b));
        }
        return b0VarC.y(cVarL.K());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void k(androidx.media3.session.f fVar, int i, final int i2, final int i3) {
        if (fVar == null || i2 < 0) {
            return;
        }
        T2(fVar, i, 33, d3(new g20() { // from class: io2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setDeviceVolume(i2, i3);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void k0(androidx.media3.session.f fVar, int i, Bundle bundle, Bundle bundle2, final boolean z) {
        final Bundle bundleY = fy4.y(bundle2);
        if (fVar == null || bundle == null || bundleY == null) {
            return;
        }
        try {
            final y14 y14VarA = y14.a(bundle);
            if (androidx.media3.session.a.w(y14VarA.b)) {
                G2(fVar, i, y14VarA);
            } else {
                J2(fVar, i, y14VarA, f3(new f() { // from class: jn2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // androidx.media3.session.z.f
                    public final Object a(v vVar, u.g gVar, int i2) {
                        return z.q2(z, y14VarA, bundleY, vVar, gVar, i2);
                    }
                }));
            }
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for SessionCommand", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final br4 k3(br4 br4Var) {
        String str = (String) this.g.get(br4Var);
        if (str == null) {
            str = br4Var.b;
        }
        for (int i = 0; i < br4Var.a; i++) {
            if (br4Var.c(i).n != null) {
                t41[] t41VarArr = new t41[br4Var.a];
                for (int i2 = 0; i2 < br4Var.a; i2++) {
                    t41 t41VarC = br4Var.c(i2);
                    String str2 = t41VarC.n;
                    String str3 = str2 != null ? (String) this.h.get(str2) : null;
                    if (str3 != null) {
                        t41VarArr[i2] = t41VarC.b().w0(str3).Q();
                    } else {
                        t41VarArr[i2] = t41VarC;
                    }
                }
                return new br4(str, t41VarArr);
            }
        }
        return br4Var.a(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void l(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 26, d3(new g20() { // from class: ln2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).increaseDeviceVolume();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void l0(androidx.media3.session.f fVar, int i, Bundle bundle) {
        v vVar = (v) this.d.get();
        if (fVar == null || bundle == null || vVar == null) {
            h24.b(fVar);
            return;
        }
        try {
            u00 u00VarA = u00.a(bundle);
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            String str = u00VarA.c;
            int iA = h24.a(vVar.j0(), str, callingUid);
            if (iA == 1) {
                xz1.i("MediaSessionStub", "Ignoring connection from invalid package name " + str + " (uid=" + callingUid + ")");
                h24.b(fVar);
                return;
            }
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            if (callingPid == 0) {
                callingPid = u00VarA.d;
            }
            try {
                fm2.b bVar = new fm2.b(str, callingPid, callingUid);
                boolean zB = fm2.a(vVar.j0()).b(bVar);
                int i2 = u00VarA.a;
                int i3 = u00VarA.b;
                F2(fVar, new u.g(bVar, i2, i3, zB, new a(fVar, i3), u00VarA.e, u00VarA.f, iA == 0));
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for ConnectionRequest", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void m(androidx.media3.session.f fVar, int i, final boolean z) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 26, d3(new g20() { // from class: pn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setDeviceMuted(z);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void n(androidx.media3.session.f fVar, int i, final String str) {
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "unsubscribe(): Ignoring empty parentId");
        } else {
            H2(fVar, i, 50002, b3(new f() { // from class: qm2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return ((r) vVar).M1(gVar, str);
                }
            }));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void o(androidx.media3.session.f fVar, int i, final String str) {
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "getItem(): Ignoring empty mediaId");
        } else {
            H2(fVar, i, 50004, b3(new f() { // from class: do2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return ((r) vVar).H1(gVar, str);
                }
            }));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void o0(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        X2(gVarK, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void p(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        R2(gVarK, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void p0(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        Z2(gVarK, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void q(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 24, d3(new g20() { // from class: tm2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).mute();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void q0(androidx.media3.session.f fVar, int i, final int i2, final int i3, IBinder iBinder) {
        final u.g gVarK;
        if (fVar == null || iBinder == null || i2 < 0 || i3 < i2 || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final xi1 xi1VarD = fm.d(new p81() { // from class: um2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return fg2.b((Bundle) obj, gVarK.e());
                }
            }, km.a(iBinder));
            U2(gVarK, i, 20, f3(N2(new f() { // from class: vm2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i4) {
                    return vVar.K0(gVar, xi1VarD);
                }
            }, new c() { // from class: wm2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.c
                public final void a(ue3 ue3Var, u.g gVar, List list) {
                    z zVar = this.a;
                    ue3Var.replaceMediaItems(zVar.Q2(gVar, ue3Var, i2), zVar.Q2(gVar, ue3Var, i3), list);
                }
            })));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void r(androidx.media3.session.f fVar, int i, final int i2) {
        if (fVar == null || i2 < 0) {
            return;
        }
        T2(fVar, i, 10, e3(new b() { // from class: ym2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.b
            public final void a(ue3 ue3Var, u.g gVar) {
                ue3Var.seekToDefaultPosition(this.a.Q2(gVar, ue3Var, i2));
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void r0(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        S2(gVarK, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void s(androidx.media3.session.f fVar, int i, final int i2, final int i3) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 27, d3(new g20() { // from class: hn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                z.A2(this.a, i2, i3, (ue3) obj);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void s0(androidx.media3.session.f fVar, int i, final boolean z) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 1, d3(new g20() { // from class: an2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).setPlayWhenReady(z);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void t(androidx.media3.session.f fVar, int i, final int i2, final long j) {
        if (fVar == null || i2 < 0) {
            return;
        }
        T2(fVar, i, 10, e3(new b() { // from class: cn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.b
            public final void a(ue3 ue3Var, u.g gVar) {
                ue3Var.seekTo(this.a.Q2(gVar, ue3Var, i2), j);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void u(androidx.media3.session.f fVar, int i, final Surface surface, final int i2, final int i3) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 27, d3(new g20() { // from class: dn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                z.s1(this.a, surface, i2, i3, (ue3) obj);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void u0(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 24, d3(new g20() { // from class: vo2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).unmute();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void v(androidx.media3.session.f fVar, int i, final int i2) {
        if (fVar == null) {
            return;
        }
        if (i2 == 2 || i2 == 0 || i2 == 1) {
            T2(fVar, i, 15, d3(new g20() { // from class: jo2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((ue3) obj).setRepeatMode(i2);
                }
            }));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void v0(androidx.media3.session.f fVar, int i, Bundle bundle) {
        u.g gVarK;
        if (fVar == null || bundle == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        try {
            final fg2 fg2VarB = fg2.b(bundle, gVarK.e());
            U2(gVarK, i, 20, f3(N2(new f() { // from class: oo2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.f
                public final Object a(v vVar, u.g gVar, int i2) {
                    return vVar.K0(gVar, xi1.w(fg2VarB));
                }
            }, new c() { // from class: po2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.z.c
                public final void a(ue3 ue3Var, u.g gVar, List list) {
                    ue3Var.addMediaItems(list);
                }
            })));
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void w0(androidx.media3.session.f fVar, int i, final int i2) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 34, d3(new g20() { // from class: xn2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).increaseDeviceVolume(i2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void x(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 20, d3(new g20() { // from class: hp2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).clearMediaItems();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void x0(androidx.media3.session.f fVar, int i, final String str, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaSessionStub", "search(): Ignoring empty query");
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e2) {
                xz1.j("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        H2(fVar, i, 50005, b3(new f() { // from class: ip2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.z.f
            public final Object a(v vVar, u.g gVar, int i2) {
                return ((r) vVar).K1(gVar, str, bVarA);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void y0(androidx.media3.session.f fVar, int i) {
        if (fVar == null) {
            return;
        }
        T2(fVar, i, 4, d3(new g20() { // from class: ro2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ue3) obj).seekToDefaultPosition();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.g
    public void z0(androidx.media3.session.f fVar, int i) {
        u.g gVarK;
        if (fVar == null || (gVarK = this.e.k(fVar.asBinder())) == null) {
            return;
        }
        W2(gVarK, i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g implements SurfaceHolder {
        public final Surface a;
        public final Rect b;
        public SurfaceHolder.Callback c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(Surface surface, int i, int i2) {
            Rect rect = new Rect();
            this.b = rect;
            this.a = surface;
            rect.set(0, 0, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
            this.c = callback;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
            if (this.c == callback) {
                this.c = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i, int i2) {
            this.b.set(0, 0, i, i2);
            SurfaceHolder.Callback callback = this.c;
            if (callback != null) {
                callback.surfaceChanged(this, 1, i, i2);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void setFormat(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void setType(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect rect) {
            throw new UnsupportedOperationException();
        }

        public g(Surface surface) {
            this.b = new Rect();
            this.a = surface;
        }
    }
}

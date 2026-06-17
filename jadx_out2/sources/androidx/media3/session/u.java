package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.d0;
import defpackage.ac3;
import defpackage.c24;
import defpackage.d24;
import defpackage.dc3;
import defpackage.e24;
import defpackage.e35;
import defpackage.eo;
import defpackage.f94;
import defpackage.fa0;
import defpackage.fg2;
import defpackage.fm2;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.i94;
import defpackage.jk;
import defpackage.kk0;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.no4;
import defpackage.ph2;
import defpackage.ue3;
import defpackage.wi1;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.y02;
import defpackage.y14;
import defpackage.yb;
import defpackage.yn3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static final Object b = new Object();
    public static final HashMap c = new HashMap();
    public final v a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean a(PendingIntent pendingIntent) {
            return pendingIntent.isActivity();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c {
        public static final AtomicReference n = new AtomicReference(null);
        public final Context a;
        public final hd3 b;
        public String c;
        public d d;
        public PendingIntent e;
        public Bundle f;
        public Bundle g;
        public jk h;
        public boolean i;
        public xi1 j;
        public xi1 k;
        public xi1 l;
        public boolean m;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Context context, hd3 hd3Var, d dVar) {
            this.a = (Context) gg3.q(context.getApplicationContext());
            this.b = (hd3) gg3.q(hd3Var);
            gg3.d(hd3Var.canAdvertiseSession());
            this.c = "";
            this.d = dVar;
            this.f = new Bundle();
            this.g = new Bundle();
            this.j = xi1.u();
            this.k = xi1.u();
            this.i = true;
            this.m = true;
            this.l = xi1.u();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static wi1 b(Context context) {
            AtomicReference atomicReference = n;
            wi1 wi1Var = (wi1) atomicReference.get();
            if (wi1Var != null) {
                return wi1Var;
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowManager.class)).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            Point point2 = new Point();
            defaultDisplay.getRealSize(point2);
            int i = point2.y;
            int i2 = point2.x;
            Point point3 = new Point(i - (i2 - point.x), i2 - (i - point.y));
            wi1 wi1VarI = wi1.i(Math.max(point.x / 6, point.y / 6), Math.max(point3.x / 6, point3.y / 6));
            atomicReference.set(wi1VarI);
            return wi1VarI;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            int iC = u.c(this.a);
            jk jkVar = this.h;
            if (jkVar == null) {
                this.h = new fa0.b(this.a).i(iC).h(true).g();
            } else {
                this.h = new i94(jkVar, iC, true);
            }
            if (Build.VERSION.SDK_INT == 29) {
                this.h = new f94(this.h, b(this.a));
            }
            this.h = new eo(this.h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public static final d0 h = new d0.b().c().e();
        public static final d0 i = new d0.b().b().c().e();
        public static final hd3.b j = new hd3.b.a().d().f();
        public final boolean a;
        public final d0 b;
        public final hd3.b c;
        public final xi1 d;
        public final xi1 e;
        public final Bundle f;
        public final PendingIntent g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a {
            public d0 a;
            public hd3.b b = e.j;
            public xi1 c;
            public xi1 d;
            public Bundle e;
            public PendingIntent f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(u uVar) {
                this.a = uVar instanceof MediaLibraryService.c ? e.i : e.h;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public e a() {
                return new e(true, this.a, this.b, this.c, this.d, this.e, this.f);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a b(hd3.b bVar) {
                this.b = (hd3.b) gg3.q(bVar);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a c(d0 d0Var) {
                this.a = (d0) gg3.q(d0Var);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a d(List list) {
                this.c = list == null ? null : xi1.p(list);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a e(List list) {
                this.d = list == null ? null : xi1.p(list);
                return this;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(boolean z, d0 d0Var, hd3.b bVar, xi1 xi1Var, xi1 xi1Var2, Bundle bundle, PendingIntent pendingIntent) {
            this.a = z;
            this.b = d0Var;
            this.c = bVar;
            this.d = xi1Var;
            this.e = xi1Var2;
            this.f = bundle;
            this.g = pendingIntent;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static e a(d0 d0Var, hd3.b bVar) {
            return new e(true, d0Var, bVar, null, null, null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void A(int i, hd3.b bVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void B(int i, boolean z, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void C(int i, ac3 ac3Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void D(int i, d24 d24Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void E(int i, int i2, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void F(int i, dc3 dc3Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void G(int i, int i2, ac3 ac3Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void H(int i, String str, int i2, MediaLibraryService.b bVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void I(int i, c24 c24Var, boolean z, boolean z2, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void J(int i, ph2 ph2Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void K(int i, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void L(int i, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void a(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void b(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void c(int i, int i2, int i3) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void d(int i, PendingIntent pendingIntent) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void e(int i, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void f(int i, no4 no4Var, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void g(int i, ue3 ue3Var, ue3 ue3Var2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void h(int i, y14 y14Var, Bundle bundle) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void i(int i, List list) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void j(int i, long j) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void k(int i, long j) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void l(int i, kk0 kk0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void m(int i, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void n(int i, hd3.e eVar, hd3.e eVar2, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void o(int i, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void p(int i, fg2 fg2Var, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void q(int i, ph2 ph2Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void r(int i, e35 e35Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void s(int i, String str, int i2, MediaLibraryService.b bVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void t(int i, androidx.media3.session.j jVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void u(int i, yb ybVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void v(int i, float f) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void w(int i, lr4 lr4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void x(int i, xr4 xr4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void y(int i, b0 b0Var, hd3.b bVar, boolean z, boolean z2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void z(int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final fm2.b a;
        public final int b;
        public final int c;
        public final boolean d;
        public final f e;
        public final Bundle f;
        public final int g;
        public final boolean h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(fm2.b bVar, int i, int i2, boolean z, f fVar, Bundle bundle, int i3, boolean z2) {
            this.a = bVar;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = fVar;
            this.f = bundle;
            this.g = i3;
            this.h = z2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static g a() {
            return new g(new fm2.b("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY, 0, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Bundle b() {
            return new Bundle(this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f c() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int d() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int e() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            g gVar = (g) obj;
            f fVar = this.e;
            return (fVar == null && gVar.e == null) ? this.a.equals(gVar.a) : Objects.equals(fVar, gVar.e);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String f() {
            return this.a.a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public fm2.b g() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean h() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return Objects.hash(this.e, this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "ControllerInfo {pkg=" + this.a.a() + ", uid=" + this.a.c() + "}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface h {
        void a(u uVar);

        boolean b(u uVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i {
        public final xi1 a;
        public final int b;
        public final long c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(List list, int i, long j) {
            this.a = xi1.p(list);
            this.b = i;
            this.c = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return this.a.equals(iVar.a) && this.b == iVar.b && this.c == iVar.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + y02.c(this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface j {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u(Context context, String str, hd3 hd3Var, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, d dVar, Bundle bundle, Bundle bundle2, jk jkVar, boolean z, boolean z2, int i2, boolean z3) {
        synchronized (b) {
            HashMap map = c;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            map.put(str, this);
        }
        this.a = b(context, str, hd3Var, pendingIntent, xi1Var, xi1Var2, xi1Var3, dVar, bundle, bundle2, jkVar, z, z2, i2, z3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(Context context) {
        return v.f0(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        this.a.S();
    }

    public abstract v b(Context context, String str, hd3 hd3Var, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, d dVar, Bundle bundle, Bundle bundle2, jk jkVar, boolean z, boolean z2, int i2, boolean z3);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final jk d() {
        return this.a.g0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List e() {
        return this.a.i0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xi1 f() {
        return this.a.k0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String g() {
        return this.a.l0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v h() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final IBinder i() {
        return this.a.n0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xi1 j() {
        return this.a.o0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g k() {
        return this.a.q0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final MediaSession.Token l() {
        return this.a.s0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final hd3 m() {
        return this.a.v0().getWrappedPlayer();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PendingIntent n() {
        return this.a.w0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o() {
        return this.a.j1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final e24 p() {
        return this.a.A0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(androidx.media3.session.f fVar, g gVar) {
        this.a.T(fVar, gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean r() {
        return this.a.H0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s() {
        try {
            synchronized (b) {
                c.remove(this.a.l0());
            }
            this.a.Z0();
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(h hVar) {
        this.a.e1(hVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(List list) {
        gg3.r(list, "media button preferences must not be null");
        this.a.d1(xi1.p(list));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(hd3 hd3Var) {
        gg3.q(hd3Var);
        gg3.d(hd3Var.canAdvertiseSession());
        gg3.d(hd3Var.getApplicationLooper() == m().getApplicationLooper());
        gg3.v(hd3Var.getApplicationLooper() == Looper.myLooper());
        this.a.f1(hd3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 31 && pendingIntent != null) {
            gg3.d(b.a(pendingIntent));
        }
        this.a.h1(pendingIntent);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default lu1 onAddMediaItems(u uVar, g gVar, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((fg2) it.next()).b == null) {
                    return x81.d(new UnsupportedOperationException());
                }
            }
            return x81.e(list);
        }

        e onConnect(u uVar, g gVar);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default lu1 onCustomCommand(u uVar, g gVar, y14 y14Var, Bundle bundle) {
            return x81.e(new d24(-6));
        }

        void onDisconnected(u uVar, g gVar);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default boolean onMediaButtonEvent(u uVar, g gVar, Intent intent) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default lu1 onPlaybackResumption(u uVar, g gVar) {
            return x81.d(new UnsupportedOperationException());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default int onPlayerCommandRequest(u uVar, g gVar, int i) {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onPlayerInteractionFinished(u uVar, g gVar, hd3.b bVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onPostConnect(u uVar, g gVar) {
        }

        lu1 onSetMediaItems(u uVar, g gVar, List list, int i, long j);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default lu1 onSetRating(u uVar, g gVar, String str, yn3 yn3Var) {
            return x81.e(new d24(-6));
        }

        default lu1 onPlaybackResumption(u uVar, g gVar, boolean z) {
            return onPlaybackResumption(uVar, gVar);
        }

        default lu1 onCustomCommand(u uVar, g gVar, y14 y14Var, Bundle bundle, j jVar) {
            return onCustomCommand(uVar, gVar, y14Var, bundle);
        }

        default lu1 onSetRating(u uVar, g gVar, yn3 yn3Var) {
            return x81.e(new d24(-6));
        }
    }
}

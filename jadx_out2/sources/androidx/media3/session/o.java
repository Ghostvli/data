package androidx.media3.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.session.i;
import androidx.media3.session.l;
import androidx.media3.session.o;
import defpackage.ac3;
import defpackage.b24;
import defpackage.c24;
import defpackage.cd3;
import defpackage.ce;
import defpackage.d24;
import defpackage.d94;
import defpackage.dc3;
import defpackage.e24;
import defpackage.e35;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.g20;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.jk;
import defpackage.kk0;
import defpackage.lj3;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.no4;
import defpackage.ph2;
import defpackage.pi2;
import defpackage.pu1;
import defpackage.qh2;
import defpackage.v82;
import defpackage.w50;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yb;
import defpackage.z62;
import defpackage.zu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o implements l.d {
    public final Context a;
    public final l b;
    public final e24 c;
    public final pu1 d;
    public final c e;
    public final jk f;
    public final Bundle h;
    public final long i;
    public v82 j;
    public z62 k;
    public boolean l;
    public boolean m;
    public boolean p;
    public e n = new e();
    public e o = new e();
    public d q = new d();
    public long r = -9223372036854775807L;
    public long s = -9223372036854775807L;
    public final xi1 g = xi1.u();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends z62.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z62.b
        public void a() {
            z62 z62VarH0 = o.this.h0();
            if (z62VarH0 != null) {
                o.this.Z(z62VarH0.c());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z62.b
        public void b() {
            o.this.i0().release();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z62.b
        public void c() {
            o.this.i0().release();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c extends v82.a {
        public final Handler d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Looper looper) {
            this.d = new Handler(looper, new Handler.Callback() { // from class: cf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return o.c.o(this.f, message);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ boolean o(c cVar, Message message) {
            cVar.getClass();
            if (message.what == 1) {
                o oVar = o.this;
                oVar.l0(false, oVar.o);
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void q(c cVar, boolean z, l.c cVar2) {
            cVar.getClass();
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", z);
            o.n0(cVar2.A0(o.this.i0(), new y14("androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED", Bundle.EMPTY), bundle));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void a(v82.e eVar) {
            o oVar = o.this;
            oVar.o = oVar.o.c(eVar);
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void b(final boolean z) {
            o.this.i0().l(new g20() { // from class: bf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    o.c.q(this.a, z, (l.c) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void c(Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            o oVar = o.this;
            oVar.o = oVar.o.h(bundle);
            o.this.p = true;
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void d(qh2 qh2Var) {
            o oVar = o.this;
            oVar.o = oVar.o.b(qh2Var);
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void e(cd3 cd3Var) {
            o oVar = o.this;
            oVar.o = oVar.o.d(o.b0(cd3Var));
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void f(List list) {
            o oVar = o.this;
            oVar.o = oVar.o.e(o.a0(list));
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void g(CharSequence charSequence) {
            o oVar = o.this;
            oVar.o = oVar.o.f(charSequence);
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void h(int i) {
            o oVar = o.this;
            oVar.o = oVar.o.g(i);
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void i() {
            o.this.i0().release();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void j(final String str, final Bundle bundle) {
            if (str == null) {
                return;
            }
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            o.this.i0().l(new g20() { // from class: df2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    o.c cVar = this.a;
                    String str2 = str;
                    Bundle bundle2 = bundle;
                    o.n0(((l.c) obj).A0(o.this.i0(), new y14(str2, bundle2), bundle2));
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void k() {
            boolean z = o.this.m;
            o oVar = o.this;
            if (!z) {
                oVar.q0();
                return;
            }
            oVar.o = oVar.o.a(o.b0(o.this.j.i()), o.this.j.m(), o.this.j.n());
            b(o.this.j.p());
            this.d.removeMessages(1);
            o oVar2 = o.this;
            oVar2.l0(false, oVar2.o);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.a
        public void l(int i) {
            o oVar = o.this;
            oVar.o = oVar.o.i(i);
            s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r() {
            this.d.removeCallbacksAndMessages(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void s() {
            if (this.d.hasMessages(1)) {
                return;
            }
            this.d.sendEmptyMessageDelayed(1, o.this.i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o(Context context, l lVar, e24 e24Var, Bundle bundle, Looper looper, jk jkVar, long j) {
        this.d = new pu1(looper, zu.a, new pu1.b() { // from class: te2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.b
            public final void a(Object obj, o21 o21Var) {
                ((hd3.d) obj).onEvents(this.a.i0(), new hd3.c(o21Var));
            }
        });
        this.a = context;
        this.b = lVar;
        this.e = new c(looper);
        this.c = e24Var;
        this.h = bundle;
        this.f = jkVar;
        this.i = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void A(o oVar, AtomicInteger atomicInteger, List list, List list2, int i) {
        oVar.getClass();
        if (atomicInteger.incrementAndGet() == list.size()) {
            oVar.k0(list2, list, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void G(d dVar, hd3.d dVar2) {
        b0 b0Var = dVar.a;
        dVar2.onTimelineChanged(b0Var.j, b0Var.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d U(boolean z, e eVar, d dVar, e eVar2, String str, long j, boolean z2, int i, long j2, boolean z3, Context context) {
        int iF0;
        ph2 ph2Var;
        d0 d0VarU;
        xi1 xi1VarR;
        int iJ;
        r0(eVar, eVar2);
        List list = eVar.d;
        List list2 = eVar2.d;
        boolean z4 = list != list2;
        lj3 lj3VarH = z4 ? lj3.H(list2) : ((lj3) dVar.a.j).A();
        boolean z5 = eVar.c != eVar2.c || z;
        long jG0 = g0(eVar.b);
        long jG02 = g0(eVar2.b);
        boolean z6 = jG0 != jG02 || z;
        long jH = i.h(eVar2.c);
        boolean z7 = z4;
        if (z5 || z6 || z7) {
            boolean z8 = z5;
            iF0 = f0(eVar2.d, jG02);
            qh2 qh2Var = eVar2.c;
            boolean z9 = qh2Var != null;
            ph2 ph2VarB = (z9 && z8) ? i.B(qh2Var, i) : (z9 || !z6) ? dVar.a.B : iF0 == -1 ? ph2.M : i.z(((pi2.g) eVar2.d.get(iF0)).s(), i);
            if (iF0 != -1 || !z8) {
                if (iF0 != -1) {
                    lj3VarH = lj3VarH.B();
                    if (z9) {
                        lj3VarH = lj3VarH.E(iF0, i.x(((fg2) gg3.q(lj3VarH.I(iF0))).a, eVar2.c, i), jH);
                    }
                } else {
                    iF0 = 0;
                }
                ph2Var = ph2VarB;
            } else if (z9) {
                xz1.i("MCImplLegacy", "Adding a fake MediaItem at the end of the list because there's no QueueItem with the active queue id and current Timeline should have currently playing MediaItem.");
                lj3VarH = lj3VarH.C(i.v(eVar2.c, i), jH);
                iF0 = lj3VarH.v() - 1;
                ph2Var = ph2VarB;
            } else {
                lj3VarH = lj3VarH.B();
                iF0 = 0;
                ph2Var = ph2VarB;
            }
        } else {
            b0 b0Var = dVar.a;
            iF0 = b0Var.c.a.c;
            ph2Var = b0Var.B;
        }
        lj3 lj3Var = lj3VarH;
        int i2 = iF0;
        v82.e eVar3 = eVar2.a;
        hd3.b bVarN = i.N(eVar2.b, eVar3 != null ? eVar3.e() : 0, j, z2);
        CharSequence charSequence = eVar.e;
        CharSequence charSequence2 = eVar2.e;
        ph2 ph2VarC = charSequence == charSequence2 ? dVar.a.m : i.C(charSequence2);
        int iS = i.S(eVar2.f);
        boolean zY = i.Y(eVar2.g);
        cd3 cd3Var = eVar.b;
        cd3 cd3Var2 = eVar2.b;
        if (cd3Var != cd3Var2 || z3) {
            d0VarU = i.U(cd3Var2, z2);
            xi1VarR = i.r(eVar2.b, bVarN, eVar2.h);
        } else {
            d0VarU = dVar.b;
            xi1VarR = dVar.d;
        }
        d0 d0Var = d0VarU;
        xi1 xi1Var = xi1VarR;
        ac3 ac3VarG = i.G(eVar2.b, context);
        b24 b24VarW = i.W(eVar2.b, context);
        long jE = i.e(eVar2.b, eVar2.c, j2);
        long jC = i.c(eVar2.b, eVar2.c, j2);
        int iB = i.b(eVar2.b, eVar2.c, j2);
        long jZ = i.Z(eVar2.b, eVar2.c, j2);
        boolean zN = i.n(eVar2.c);
        dc3 dc3VarI = i.I(eVar2.b);
        v82.e eVar4 = eVar2.a;
        yb ybVarA = eVar4 == null ? yb.i : eVar4.a();
        boolean zF = i.F(eVar2.b);
        try {
            iJ = i.J(eVar2.b, eVar2.c, j2);
        } catch (i.b unused) {
            xz1.d("MCImplLegacy", String.format("Received invalid playback state %s from package %s. Keeping the previous state.", Integer.valueOf(eVar2.b.E()), str));
            iJ = dVar.a.A;
        }
        int i3 = iJ;
        boolean zM = i.m(eVar2.b);
        kk0 kk0VarF = i.f(eVar2.a);
        int iG = i.g(eVar2.a);
        boolean zK = i.k(eVar2.a);
        b0 b0Var2 = dVar.a;
        return c0(lj3Var, ph2Var, i2, ph2VarC, iS, zY, d0Var, bVarN, xi1Var, eVar2.h, ac3VarG, b24VarW, jH, jE, jC, iB, jZ, zN, dc3VarI, ybVarA, zF, i3, zM, kk0VarF, iG, zK, b0Var2.C, b0Var2.D, b0Var2.E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int V(int i, int i2, int i3) {
        return i < i2 ? i : i + i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int W(int i, int i2, int i3) {
        int i4 = i3 - i2;
        if (i < i2) {
            return i;
        }
        if (i < i3) {
            return -1;
        }
        return i - i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair X(e eVar, d dVar, e eVar2, d dVar2, long j) {
        Integer num = 3;
        Integer num2 = 0;
        boolean zW = dVar.a.j.w();
        boolean zW2 = dVar2.a.j.w();
        if (!zW || !zW2) {
            if (!zW || zW2) {
                fg2 fg2Var = (fg2) gg3.q(dVar.a.E());
                if (!((lj3) dVar2.a.j).z(fg2Var)) {
                    num2 = 4;
                } else if (fg2Var.equals(dVar2.a.E())) {
                    long jE = i.e(eVar.b, eVar.c, j);
                    long jE2 = i.e(eVar2.b, eVar2.c, j);
                    if (jE2 == 0 && dVar2.a.h == 1) {
                        num = num2;
                    } else if (Math.abs(jE - jE2) > 100) {
                        num2 = 5;
                        num = null;
                    } else {
                        num = null;
                        num2 = null;
                    }
                } else {
                    num = 1;
                }
            }
        }
        return Pair.create(num2, num);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List a0(List list) {
        return list == null ? Collections.EMPTY_LIST : a0.h(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cd3 b0(cd3 cd3Var) {
        if (cd3Var == null) {
            return null;
        }
        if (cd3Var.B() > 0.0f) {
            return cd3Var;
        }
        xz1.i("MCImplLegacy", "Adjusting playback speed to 1.0f because negative playback speed isn't supported.");
        return new cd3.b(cd3Var).h(cd3Var.E(), cd3Var.D(), 1.0f, cd3Var.A()).b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d c0(lj3 lj3Var, ph2 ph2Var, int i, ph2 ph2Var2, int i2, boolean z, d0 d0Var, hd3.b bVar, xi1 xi1Var, Bundle bundle, ac3 ac3Var, b24 b24Var, long j, long j2, long j3, int i3, long j4, boolean z2, dc3 dc3Var, yb ybVar, boolean z3, int i4, boolean z4, kk0 kk0Var, int i5, boolean z5, long j5, long j6, long j7) {
        c24 c24Var = new c24(d0(i, lj3Var.I(i), j2, z2), z2, SystemClock.elapsedRealtime(), j, j3, i3, j4, -9223372036854775807L, j, j3);
        hd3.e eVar = c24.k;
        return new d(new b0(ac3Var, 0, c24Var, eVar, eVar, 0, dc3Var, i2, z, e35.e, lj3Var, 0, ph2Var2, 1.0f, 1.0f, ybVar, 0, w50.d, kk0Var, i5, z5, z3, 1, 0, i4, z4, false, ph2Var, j5, j6, j7, xr4.b, lr4.J), d0Var, bVar, xi1Var, bundle, b24Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hd3.e d0(int i, fg2 fg2Var, long j, boolean z) {
        return new hd3.e(null, i, fg2Var, null, i, j, j, z ? 0 : -1, z ? 0 : -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c24 e0(hd3.e eVar, boolean z, long j, long j2, int i, long j3) {
        return new c24(eVar, z, SystemClock.elapsedRealtime(), j, j2, i, j3, -9223372036854775807L, j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f0(List list, long j) {
        if (list != null && j != -1) {
            for (int i = 0; i < list.size(); i++) {
                if (((pi2.g) list.get(i)).u() == j) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long g0(cd3 cd3Var) {
        if (cd3Var == null) {
            return -1L;
        }
        return cd3Var.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void h(o oVar) {
        z62 z62Var = new z62(oVar.a, oVar.c.b(), new b(), oVar.b.f());
        oVar.k = z62Var;
        z62Var.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void j(o oVar, pi2.h hVar) {
        v82 v82Var = new v82(oVar.a, hVar);
        oVar.j = v82Var;
        v82Var.r(oVar.e, oVar.i0().e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle j0(Bundle bundle) {
        return bundle == null ? Bundle.EMPTY : bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void l(d dVar, hd3.d dVar2) {
        b0 b0Var = dVar.a;
        dVar2.onDeviceVolumeChanged(b0Var.t, b0Var.u);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void n0(Future future) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void r(o oVar) {
        if (oVar.l || oVar.j.q()) {
            return;
        }
        oVar.q0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void r0(e eVar, e eVar2) {
        pi2.g gVar;
        qh2 qh2Var;
        qh2 qh2Var2 = eVar.c;
        if (qh2Var2 != null && (qh2Var = eVar2.c) != null) {
            qh2Var.F(qh2Var2);
        }
        if (eVar.d != eVar2.d) {
            HashMap map = new HashMap();
            for (int i = 0; i < eVar.d.size(); i++) {
                pi2.g gVar2 = (pi2.g) eVar.d.get(i);
                if (gVar2.s().u() != null) {
                    map.put(Long.valueOf(gVar2.u()), gVar2);
                }
            }
            for (int i2 = 0; i2 < eVar2.d.size(); i2++) {
                pi2.g gVar3 = (pi2.g) eVar2.d.get(i2);
                if (gVar3.s().u() != null && (gVar = (pi2.g) map.get(Long.valueOf(gVar3.u()))) != null) {
                    gVar3.s().C(gVar.s());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void s(o oVar, d dVar, l.c cVar) {
        n0(cVar.J0(oVar.i0(), dVar.d));
        cVar.H0(oVar.i0(), dVar.d);
        cVar.Q(oVar.i0(), dVar.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void s0(int i, long j) {
        Integer num;
        Integer num2;
        int i2;
        long j2;
        long j3;
        long j4;
        int i3 = i;
        long j5 = j;
        gg3.d(i3 >= 0);
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        no4 no4Var = this.q.a.j;
        if ((no4Var.w() || i3 < no4Var.v()) && !isPlayingAd()) {
            if (i3 != currentMediaItemIndex) {
                long J = ((lj3) this.q.a.j).J(i3);
                if (J != -1) {
                    this.j.o().s(J);
                    num = 2;
                } else {
                    xz1.i("MCImplLegacy", "Cannot seek to new media item due to the missing queue Id at media item, mediaItemIndex=" + i3);
                    i3 = currentMediaItemIndex;
                    num = null;
                }
            } else {
                i3 = currentMediaItemIndex;
                num = null;
            }
            long currentPosition = getCurrentPosition();
            if (j5 == -9223372036854775807L) {
                num2 = null;
                j5 = currentPosition;
            } else {
                this.j.o().l(j5);
                num2 = 1;
            }
            if (num == null) {
                long bufferedPosition = getBufferedPosition();
                long duration = getDuration();
                long jMax = j5 < currentPosition ? j5 : Math.max(j5, bufferedPosition);
                j2 = jMax;
                i2 = duration == -9223372036854775807L ? 0 : (int) ((100 * jMax) / duration);
                j3 = jMax - j5;
                j4 = duration;
            } else {
                i2 = 0;
                j2 = 0;
                j3 = 0;
                j4 = -9223372036854775807L;
            }
            b0 b0VarT = this.q.a.t(e0(d0(i3, !no4Var.w() ? no4Var.t(i3, new no4.d()).c : null, j5, false), false, j4, j2, i2, j3));
            if (b0VarT.A != 1) {
                b0VarT = b0VarT.m(2, null);
            }
            b0 b0Var = b0VarT;
            d dVar = this.q;
            v0(new d(b0Var, dVar.b, dVar.c, dVar.d, dVar.e, null), num2, num);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void z(o oVar, d dVar, l.c cVar) {
        n0(cVar.J0(oVar.i0(), dVar.d));
        cVar.H0(oVar.i0(), dVar.d);
        cVar.Q(oVar.i0(), dVar.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T(final List list, final int i) {
        final ArrayList arrayList = new ArrayList();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Runnable runnable = new Runnable() { // from class: ue2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                o.A(this.f, atomicInteger, list, arrayList, i);
            }
        };
        for (int i2 = 0; i2 < list.size(); i2++) {
            byte[] bArr = ((fg2) list.get(i2)).e.k;
            if (bArr == null) {
                arrayList.add(null);
                runnable.run();
            } else {
                lu1 lu1VarC = this.f.c(bArr);
                arrayList.add(lu1VarC);
                Handler handler = i0().e;
                Objects.requireNonNull(handler);
                lu1VarC.g(runnable, new ce(handler));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y() {
        i0().n(new Runnable() { // from class: qe2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                o.h(this.f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(final pi2.h hVar) {
        i0().n(new Runnable() { // from class: yd2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                o.j(this.f, hVar);
            }
        });
        i0().e.postDelayed(new Runnable() { // from class: je2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                o.r(this.f);
            }
        }, 500L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public d0 a() {
        return this.q.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void addListener(hd3.d dVar) {
        this.d.c(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void addMediaItem(fg2 fg2Var) {
        addMediaItems(Integer.MAX_VALUE, Collections.singletonList(fg2Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void addMediaItems(int i, List list) {
        gg3.d(i >= 0);
        if (list.isEmpty()) {
            return;
        }
        lj3 lj3Var = (lj3) this.q.a.j;
        if (lj3Var.w()) {
            t0(list);
            return;
        }
        int iMin = Math.min(i, getCurrentTimeline().v());
        b0 b0VarW = this.q.a.w(lj3Var.F(iMin, list), V(getCurrentMediaItemIndex(), iMin, list.size()), 0);
        d dVar = this.q;
        v0(new d(b0VarW, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        if (p0()) {
            T(list, iMin);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void b() {
        if (this.c.h() == 0) {
            Z((pi2.h) gg3.q(this.c.a()));
        } else {
            Y();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public xi1 c() {
        return this.q.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoSurface() {
        xz1.i("MCImplLegacy", "Session doesn't support clearing Surface");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        xz1.i("MCImplLegacy", "Session doesn't support clearing SurfaceHolder");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        xz1.i("MCImplLegacy", "Session doesn't support clearing SurfaceView");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void clearVideoTextureView(TextureView textureView) {
        xz1.i("MCImplLegacy", "Session doesn't support clearing TextureView");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public Bundle d() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void decreaseDeviceVolume(int i) {
        int deviceVolume = getDeviceVolume() - 1;
        if (deviceVolume >= getDeviceInfo().b) {
            b0 b0VarE = this.q.a.e(deviceVolume, isDeviceMuted());
            d dVar = this.q;
            v0(new d(b0VarE, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.b(-1, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public lu1 e(y14 y14Var, Bundle bundle) {
        if (this.j == null) {
            return x81.e(new d24(-100));
        }
        if (bundle.isEmpty()) {
            bundle = y14Var.c;
        } else if (!y14Var.c.isEmpty()) {
            Bundle bundle2 = new Bundle(y14Var.c);
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.j.o().m(y14Var.b, bundle);
        return x81.e(new d24(0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public yb getAudioAttributes() {
        return this.q.a.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getAudioSessionId() {
        return this.q.a.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public hd3.b getAvailableCommands() {
        return this.q.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getBufferedPercentage() {
        return this.q.a.c.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getBufferedPosition() {
        return this.q.a.c.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getContentBufferedPosition() {
        return getBufferedPosition();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getContentDuration() {
        return getDuration();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getContentPosition() {
        return getCurrentPosition();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentAdGroupIndex() {
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public w50 getCurrentCues() {
        xz1.i("MCImplLegacy", "Session doesn't support getting Cue");
        return w50.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getCurrentLiveOffset() {
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentMediaItemIndex() {
        return this.q.a.c.a.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getCurrentPeriodIndex() {
        return getCurrentMediaItemIndex();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getCurrentPosition() {
        long jE = a0.e(this.q.a, this.r, this.s, i0().i());
        this.r = jE;
        return jE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public no4 getCurrentTimeline() {
        return this.q.a.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public xr4 getCurrentTracks() {
        return xr4.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public kk0 getDeviceInfo() {
        return this.q.a.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getDeviceVolume() {
        b0 b0Var = this.q.a;
        if (b0Var.s.a == 1) {
            return b0Var.t;
        }
        v82 v82Var = this.j;
        if (v82Var != null) {
            return i.g(v82Var.h());
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getDuration() {
        return this.q.a.c.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getMaxSeekToPreviousPosition() {
        return this.q.a.E;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public ph2 getMediaMetadata() {
        fg2 fg2VarE = this.q.a.E();
        return fg2VarE == null ? ph2.M : fg2VarE.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getNextMediaItemIndex() {
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean getPlayWhenReady() {
        return this.q.a.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public dc3 getPlaybackParameters() {
        return this.q.a.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getPlaybackState() {
        return this.q.a.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getPlaybackSuppressionReason() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public ac3 getPlayerError() {
        return this.q.a.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public ph2 getPlaylistMetadata() {
        return this.q.a.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getPreviousMediaItemIndex() {
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public int getRepeatMode() {
        return this.q.a.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getSeekBackIncrement() {
        return this.q.a.C;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getSeekForwardIncrement() {
        return this.q.a.D;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean getShuffleModeEnabled() {
        return this.q.a.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public d94 getSurfaceSize() {
        xz1.i("MCImplLegacy", "Session doesn't support getting VideoSurfaceSize");
        return d94.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public long getTotalBufferedDuration() {
        return this.q.a.c.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public lr4 getTrackSelectionParameters() {
        return lr4.J;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public e35 getVideoSize() {
        xz1.i("MCImplLegacy", "Session doesn't support getting VideoSize");
        return e35.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public float getVolume() {
        return 1.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z62 h0() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean hasNextMediaItem() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean hasPreviousMediaItem() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l i0() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void increaseDeviceVolume(int i) {
        int deviceVolume = getDeviceVolume();
        int i2 = getDeviceInfo().c;
        if (i2 == 0 || deviceVolume + 1 <= i2) {
            b0 b0VarE = this.q.a.e(deviceVolume + 1, isDeviceMuted());
            d dVar = this.q;
            v0(new d(b0VarE, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.b(1, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isConnected() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isDeviceMuted() {
        b0 b0Var = this.q.a;
        if (b0Var.s.a == 1) {
            return b0Var.u;
        }
        v82 v82Var = this.j;
        return v82Var != null && i.k(v82Var.h());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isLoading() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isPlaying() {
        return this.q.a.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public boolean isPlayingAd() {
        return this.q.a.c.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k0(List list, List list2, int i) {
        Bitmap bitmap;
        for (int i2 = 0; i2 < list.size(); i2++) {
            lu1 lu1Var = (lu1) list.get(i2);
            if (lu1Var != null) {
                try {
                    bitmap = (Bitmap) x81.c(lu1Var);
                } catch (CancellationException | ExecutionException e2) {
                    xz1.c("MCImplLegacy", "Failed to get bitmap", e2);
                    bitmap = null;
                }
            } else {
                bitmap = null;
            }
            this.j.a(i.s((fg2) list2.get(i2), bitmap), i + i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l0(boolean z, final e eVar) {
        if (this.l || !this.m) {
            return;
        }
        d dVarU = U(z, this.n, this.q, eVar, this.j.g(), this.j.e(), this.j.q(), this.j.l(), i0().i(), this.p, this.a);
        Pair pairX = X(this.n, this.q, eVar, dVarU, i0().i());
        u0(z, eVar, true, dVarU, (Integer) pairX.first, (Integer) pairX.second);
        if (this.p) {
            this.p = false;
            i0().l(new g20() { // from class: se2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((l.c) obj).S0(this.a.i0(), eVar.h);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m0() {
        return !this.q.a.j.w();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void moveMediaItem(int i, int i2) {
        moveMediaItems(i, i + 1, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void moveMediaItems(int i, int i2, int i3) {
        gg3.d(i >= 0 && i <= i2 && i3 >= 0);
        lj3 lj3Var = (lj3) this.q.a.j;
        int iV = lj3Var.v();
        int iMin = Math.min(i2, iV);
        int i4 = iMin - i;
        int i5 = iV - i4;
        int i6 = i5 - 1;
        int iMin2 = Math.min(i3, i5);
        if (i >= iV || i == iMin || i == iMin2) {
            return;
        }
        int iW = W(getCurrentMediaItemIndex(), i, iMin);
        if (iW == -1) {
            iW = fy4.s(i, 0, i6);
            xz1.i("MCImplLegacy", "Currently playing item will be removed and added back to mimic move. Assumes item at " + iW + " would be the new current item");
        }
        b0 b0VarW = this.q.a.w(lj3Var.D(i, iMin, iMin2), V(iW, iMin2, i4), 0);
        d dVar = this.q;
        v0(new d(b0VarW, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        if (p0()) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < i4; i7++) {
                arrayList.add((pi2.g) this.n.d.get(i));
                this.j.s(((pi2.g) this.n.d.get(i)).s());
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                this.j.a(((pi2.g) arrayList.get(i8)).s(), i8 + iMin2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void mute() {
        xz1.i("MCImplLegacy", "Session doesn't support muting the player");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o0() {
        no4.d dVar = new no4.d();
        gg3.v(p0() && m0());
        b0 b0Var = this.q.a;
        lj3 lj3Var = (lj3) b0Var.j;
        int i = b0Var.c.a.c;
        fg2 fg2Var = lj3Var.t(i, dVar).c;
        if (lj3Var.J(i) != -1) {
            boolean z = this.q.a.v;
            v82 v82Var = this.j;
            if (z) {
                v82Var.o().c();
            } else {
                v82Var.o().g();
            }
        } else {
            fg2.i iVar = fg2Var.h;
            if (iVar.a != null) {
                boolean z2 = this.q.a.v;
                v82 v82Var2 = this.j;
                if (z2) {
                    v82.f fVarO = v82Var2.o();
                    fg2.i iVar2 = fg2Var.h;
                    fVarO.f(iVar2.a, j0(iVar2.c));
                } else {
                    v82.f fVarO2 = v82Var2.o();
                    fg2.i iVar3 = fg2Var.h;
                    fVarO2.j(iVar3.a, j0(iVar3.c));
                }
            } else {
                String str = iVar.b;
                d dVar2 = this.q;
                if (str != null) {
                    boolean z3 = dVar2.a.v;
                    v82 v82Var3 = this.j;
                    if (z3) {
                        v82.f fVarO3 = v82Var3.o();
                        fg2.i iVar4 = fg2Var.h;
                        fVarO3.e(iVar4.b, j0(iVar4.c));
                    } else {
                        v82.f fVarO4 = v82Var3.o();
                        fg2.i iVar5 = fg2Var.h;
                        fVarO4.i(iVar5.b, j0(iVar5.c));
                    }
                } else {
                    boolean z4 = dVar2.a.v;
                    v82 v82Var4 = this.j;
                    if (z4) {
                        v82Var4.o().d(fg2Var.a, j0(fg2Var.h.c));
                    } else {
                        v82Var4.o().h(fg2Var.a, j0(fg2Var.h.c));
                    }
                }
            }
        }
        if (this.q.a.c.a.g != 0) {
            this.j.o().l(this.q.a.c.a.g);
        }
        if (getAvailableCommands().c(20)) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < lj3Var.v(); i2++) {
                if (i2 != i && lj3Var.J(i2) == -1) {
                    arrayList.add(lj3Var.t(i2, dVar).c);
                }
            }
            T(arrayList, 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p0() {
        return this.q.a.A != 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void pause() {
        setPlayWhenReady(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void play() {
        setPlayWhenReady(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void prepare() {
        b0 b0Var = this.q.a;
        if (b0Var.A != 1) {
            return;
        }
        b0 b0VarM = b0Var.m(b0Var.j.w() ? 4 : 2, null);
        d dVar = this.q;
        v0(new d(b0VarM, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        if (m0()) {
            o0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q0() {
        if (this.l || this.m) {
            return;
        }
        this.m = true;
        l0(true, new e(this.j.h(), b0(this.j.i()), this.j.f(), a0(this.j.j()), this.j.k(), this.j.m(), this.j.n(), this.j.d()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void release() {
        if (this.l) {
            return;
        }
        this.l = true;
        z62 z62Var = this.k;
        if (z62Var != null) {
            z62Var.b();
            this.k = null;
        }
        v82 v82Var = this.j;
        if (v82Var != null) {
            v82Var.u(this.e);
            this.e.r();
            this.j = null;
        }
        this.m = false;
        this.d.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void removeListener(hd3.d dVar) {
        this.d.j(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void removeMediaItems(int i, int i2) {
        gg3.d(i >= 0 && i2 >= i);
        int iV = getCurrentTimeline().v();
        int iMin = Math.min(i2, iV);
        if (i >= iV || i == iMin) {
            return;
        }
        lj3 lj3VarG = ((lj3) this.q.a.j).G(i, iMin);
        int iW = W(getCurrentMediaItemIndex(), i, iMin);
        if (iW == -1) {
            iW = fy4.s(i, 0, lj3VarG.v() - 1);
            xz1.i("MCImplLegacy", "Currently playing item is removed. Assumes item at " + iW + " is the new current item");
        }
        b0 b0VarW = this.q.a.w(lj3VarG, iW, 0);
        d dVar = this.q;
        v0(new d(b0VarW, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        if (p0()) {
            while (i < iMin && i < this.n.d.size()) {
                this.j.s(((pi2.g) this.n.d.get(i)).s());
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void replaceMediaItem(int i, fg2 fg2Var) {
        replaceMediaItems(i, i + 1, xi1.w(fg2Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void replaceMediaItems(int i, int i2, List list) {
        gg3.d(i >= 0 && i <= i2);
        int iV = ((lj3) this.q.a.j).v();
        if (i > iV) {
            return;
        }
        int iMin = Math.min(i2, iV);
        addMediaItems(iMin, list);
        removeMediaItems(i, iMin);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekBack() {
        this.j.o().k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekForward() {
        this.j.o().a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekTo(long j) {
        s0(getCurrentMediaItemIndex(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToDefaultPosition() {
        s0(getCurrentMediaItemIndex(), 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToNext() {
        this.j.o().q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToNextMediaItem() {
        this.j.o().q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToPrevious() {
        this.j.o().r();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void seekToPreviousMediaItem() {
        this.j.o().r();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setAudioAttributes(yb ybVar, boolean z) {
        xz1.i("MCImplLegacy", "Legacy session doesn't support setting audio attributes remotely");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setDeviceMuted(boolean z, int i) {
        if (z != isDeviceMuted()) {
            b0 b0VarE = this.q.a.e(getDeviceVolume(), z);
            d dVar = this.q;
            v0(new d(b0VarE, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.b(z ? -100 : 100, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setDeviceVolume(int i, int i2) {
        kk0 deviceInfo = getDeviceInfo();
        int i3 = deviceInfo.b;
        int i4 = deviceInfo.c;
        if (i3 <= i && (i4 == 0 || i <= i4)) {
            b0 b0VarE = this.q.a.e(i, isDeviceMuted());
            d dVar = this.q;
            v0(new d(b0VarE, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.t(i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setMediaItem(fg2 fg2Var) {
        setMediaItem(fg2Var, -9223372036854775807L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setMediaItems(List list, int i, long j) {
        if (list.isEmpty()) {
            clearMediaItems();
            return;
        }
        b0 b0VarX = this.q.a.x(lj3.g.F(0, list), e0(d0(i, (fg2) list.get(i), j == -9223372036854775807L ? 0L : j, false), false, -9223372036854775807L, 0L, 0, 0L), 0);
        d dVar = this.q;
        v0(new d(b0VarX, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        if (p0()) {
            o0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlayWhenReady(boolean z) {
        b0 b0Var = this.q.a;
        if (b0Var.v == z) {
            return;
        }
        this.r = a0.e(b0Var, this.r, this.s, i0().i());
        this.s = SystemClock.elapsedRealtime();
        b0 b0VarK = this.q.a.k(z, 1, 0);
        d dVar = this.q;
        v0(new d(b0VarK, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        if (p0() && m0()) {
            v82 v82Var = this.j;
            if (z) {
                v82Var.o().c();
            } else {
                v82Var.o().b();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlaybackParameters(dc3 dc3Var) {
        if (!dc3Var.equals(getPlaybackParameters())) {
            b0 b0VarL = this.q.a.l(dc3Var);
            d dVar = this.q;
            v0(new d(b0VarL, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.o().n(dc3Var.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlaybackSpeed(float f) {
        if (f != getPlaybackParameters().a) {
            b0 b0VarL = this.q.a.l(new dc3(f));
            d dVar = this.q;
            v0(new d(b0VarL, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.o().n(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setPlaylistMetadata(ph2 ph2Var) {
        xz1.i("MCImplLegacy", "Session doesn't support setting playlist metadata");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setRepeatMode(int i) {
        if (i != getRepeatMode()) {
            b0 b0VarQ = this.q.a.q(i);
            d dVar = this.q;
            v0(new d(b0VarQ, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.o().o(i.K(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setShuffleModeEnabled(boolean z) {
        if (z != getShuffleModeEnabled()) {
            b0 b0VarU = this.q.a.u(z);
            d dVar = this.q;
            v0(new d(b0VarU, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        }
        this.j.o().p(i.L(z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setTrackSelectionParameters(lr4 lr4Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoSurface(Surface surface) {
        xz1.i("MCImplLegacy", "Session doesn't support setting Surface");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        xz1.i("MCImplLegacy", "Session doesn't support setting SurfaceHolder");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        xz1.i("MCImplLegacy", "Session doesn't support setting SurfaceView");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVideoTextureView(TextureView textureView) {
        xz1.i("MCImplLegacy", "Session doesn't support setting TextureView");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void setVolume(float f) {
        xz1.i("MCImplLegacy", "Session doesn't support setting player volume");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void stop() {
        b0 b0Var = this.q.a;
        if (b0Var.A == 1) {
            return;
        }
        c24 c24Var = b0Var.c;
        hd3.e eVar = c24Var.a;
        boolean z = c24Var.b;
        long j = c24Var.d;
        long j2 = eVar.g;
        b0 b0VarT = b0Var.t(e0(eVar, z, j, j2, a0.c(j2, j), 0L));
        b0 b0Var2 = this.q.a;
        if (b0Var2.A != 1) {
            b0VarT = b0VarT.m(1, b0Var2.a);
        }
        b0 b0Var3 = b0VarT;
        d dVar = this.q;
        v0(new d(b0Var3, dVar.b, dVar.c, dVar.d, dVar.e, null), null, null);
        this.j.o().t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t0(List list) {
        setMediaItems(list, 0, -9223372036854775807L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u0(boolean z, e eVar, boolean z2, final d dVar, final Integer num, final Integer num2) {
        e eVar2 = this.n;
        final d dVar2 = this.q;
        if (eVar2 != eVar) {
            this.n = new e(eVar);
        }
        if (z2) {
            this.o = this.n;
        }
        this.q = dVar;
        if (z) {
            i0().k();
            if (dVar2.d.equals(dVar.d)) {
                return;
            }
            i0().e.post(new Runnable() { // from class: ve2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    o oVar = this.f;
                    oVar.i0().l(new g20() { // from class: re2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.g20
                        public final void accept(Object obj) {
                            o.s(this.a, dVar, (l.c) obj);
                        }
                    });
                }
            });
            return;
        }
        if (!dVar2.a.j.equals(dVar.a.j)) {
            this.d.h(0, new pu1.a() { // from class: ee2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    o.G(dVar, (hd3.d) obj);
                }
            });
        }
        if (!TextUtils.equals(eVar2.e, eVar.e)) {
            this.d.h(15, new pu1.a() { // from class: he2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaylistMetadataChanged(dVar.a.m);
                }
            });
        }
        if (num != null) {
            this.d.h(11, new pu1.a() { // from class: ie2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPositionDiscontinuity(dVar2.a.c.a, dVar.a.c.a, num.intValue());
                }
            });
        }
        if (num2 != null) {
            this.d.h(1, new pu1.a() { // from class: ke2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMediaItemTransition(dVar.a.E(), num2.intValue());
                }
            });
        }
        if (!a0.a(eVar2.b, eVar.b)) {
            final ac3 ac3VarG = i.G(eVar.b, this.a);
            this.d.h(10, new pu1.a() { // from class: le2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlayerErrorChanged(ac3VarG);
                }
            });
            if (ac3VarG != null) {
                this.d.h(10, new pu1.a() { // from class: me2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onPlayerError(ac3VarG);
                    }
                });
            }
        }
        if (eVar2.c != eVar.c) {
            this.d.h(14, new pu1.a() { // from class: ne2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMediaMetadataChanged(this.a.q.a.B);
                }
            });
        }
        if (dVar2.a.A != dVar.a.A) {
            this.d.h(4, new pu1.a() { // from class: oe2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackStateChanged(dVar.a.A);
                }
            });
        }
        if (dVar2.a.v != dVar.a.v) {
            this.d.h(5, new pu1.a() { // from class: pe2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlayWhenReadyChanged(dVar.a.v, 4);
                }
            });
        }
        if (dVar2.a.x != dVar.a.x) {
            this.d.h(7, new pu1.a() { // from class: we2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onIsPlayingChanged(dVar.a.x);
                }
            });
        }
        if (!dVar2.a.g.equals(dVar.a.g)) {
            this.d.h(12, new pu1.a() { // from class: xe2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackParametersChanged(dVar.a.g);
                }
            });
        }
        if (dVar2.a.h != dVar.a.h) {
            this.d.h(8, new pu1.a() { // from class: ye2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onRepeatModeChanged(dVar.a.h);
                }
            });
        }
        if (dVar2.a.i != dVar.a.i) {
            this.d.h(9, new pu1.a() { // from class: ze2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onShuffleModeEnabledChanged(dVar.a.i);
                }
            });
        }
        if (!dVar2.a.q.equals(dVar.a.q)) {
            this.d.h(20, new pu1.a() { // from class: af2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAudioAttributesChanged(dVar.a.q);
                }
            });
        }
        if (dVar2.a.p != dVar.a.p) {
            this.d.h(21, new pu1.a() { // from class: zd2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAudioSessionIdChanged(dVar.a.p);
                }
            });
        }
        if (!dVar2.a.s.equals(dVar.a.s)) {
            this.d.h(29, new pu1.a() { // from class: ae2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onDeviceInfoChanged(dVar.a.s);
                }
            });
        }
        b0 b0Var = dVar2.a;
        int i = b0Var.t;
        b0 b0Var2 = dVar.a;
        if (i != b0Var2.t || b0Var.u != b0Var2.u) {
            this.d.h(30, new pu1.a() { // from class: be2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    o.l(dVar, (hd3.d) obj);
                }
            });
        }
        if (!dVar2.c.equals(dVar.c)) {
            this.d.h(13, new pu1.a() { // from class: ce2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAvailableCommandsChanged(dVar.c);
                }
            });
        }
        if (!dVar2.b.equals(dVar.b)) {
            i0().l(new g20() { // from class: de2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((l.c) obj).H(this.a.i0(), dVar.b);
                }
            });
        }
        if (!dVar2.d.equals(dVar.d)) {
            i0().l(new g20() { // from class: fe2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    o.z(this.a, dVar, (l.c) obj);
                }
            });
        }
        if (dVar.f != null) {
            i0().l(new g20() { // from class: ge2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((l.c) obj).V(this.a.i0(), dVar.f);
                }
            });
        }
        this.d.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.l.d
    public void unmute() {
        xz1.i("MCImplLegacy", "Session doesn't support unmuting the player");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0(d dVar, Integer num, Integer num2) {
        u0(false, this.n, false, dVar, num, num2);
    }

    @Override // androidx.media3.session.l.d
    public void clearVideoSurface(Surface surface) {
        xz1.i("MCImplLegacy", "Session doesn't support clearing Surface");
    }

    @Override // androidx.media3.session.l.d
    public void seekTo(int i, long j) {
        s0(i, j);
    }

    @Override // androidx.media3.session.l.d
    public void setMediaItem(fg2 fg2Var, long j) {
        setMediaItems(xi1.w(fg2Var), 0, j);
    }

    @Override // androidx.media3.session.l.d
    public void seekToDefaultPosition(int i) {
        s0(i, 0L);
    }

    @Override // androidx.media3.session.l.d
    public void setMediaItem(fg2 fg2Var, boolean z) {
        setMediaItem(fg2Var);
    }

    @Override // androidx.media3.session.l.d
    public void addMediaItem(int i, fg2 fg2Var) {
        addMediaItems(i, Collections.singletonList(fg2Var));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final b0 a;
        public final d0 b;
        public final hd3.b c;
        public final xi1 d;
        public final Bundle e;
        public final b24 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
            this.a = b0.H.v(lj3.g);
            this.b = d0.b;
            this.c = hd3.b.b;
            this.d = xi1.u();
            this.e = Bundle.EMPTY;
            this.f = null;
        }

        public d(b0 b0Var, d0 d0Var, hd3.b bVar, xi1 xi1Var, Bundle bundle, b24 b24Var) {
            this.a = b0Var;
            this.b = d0Var;
            this.c = bVar;
            this.d = xi1Var;
            this.e = bundle == null ? Bundle.EMPTY : bundle;
            this.f = b24Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final v82.e a;
        public final cd3 b;
        public final qh2 c;
        public final List d;
        public final CharSequence e;
        public final int f;
        public final int g;
        public final Bundle h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e a(cd3 cd3Var, int i, int i2) {
            return new e(this.a, cd3Var, this.c, this.d, this.e, i, i2, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e b(qh2 qh2Var) {
            return new e(this.a, this.b, qh2Var, this.d, this.e, this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e c(v82.e eVar) {
            return new e(eVar, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e d(cd3 cd3Var) {
            return new e(this.a, cd3Var, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e e(List list) {
            return new e(this.a, this.b, this.c, list, this.e, this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e f(CharSequence charSequence) {
            return new e(this.a, this.b, this.c, this.d, charSequence, this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e g(int i) {
            return new e(this.a, this.b, this.c, this.d, this.e, i, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e h(Bundle bundle) {
            return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e i(int i) {
            return new e(this.a, this.b, this.c, this.d, this.e, this.f, i, this.h);
        }

        public e(v82.e eVar, cd3 cd3Var, qh2 qh2Var, List list, CharSequence charSequence, int i, int i2, Bundle bundle) {
            this.a = eVar;
            this.b = cd3Var;
            this.c = qh2Var;
            this.d = (List) gg3.q(list);
            this.e = charSequence;
            this.f = i;
            this.g = i2;
            this.h = bundle == null ? Bundle.EMPTY : bundle;
        }

        public e() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = Collections.EMPTY_LIST;
            this.e = null;
            this.f = 0;
            this.g = 0;
            this.h = Bundle.EMPTY;
        }
    }

    @Override // androidx.media3.session.l.d
    public void setDeviceMuted(boolean z) {
        setDeviceMuted(z, 1);
    }

    @Override // androidx.media3.session.l.d
    public void setDeviceVolume(int i) {
        setDeviceVolume(i, 1);
    }

    @Override // androidx.media3.session.l.d
    public void decreaseDeviceVolume() {
        decreaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.l.d
    public void increaseDeviceVolume() {
        increaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.l.d
    public void addMediaItems(List list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // androidx.media3.session.l.d
    public void setMediaItems(List list, boolean z) {
        t0(list);
    }
}

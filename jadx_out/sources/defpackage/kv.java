package defpackage;

import defpackage.aa5;
import defpackage.ha5;
import defpackage.l42;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kv implements ha5 {
    public final jv a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[aa5.b.values().length];
            a = iArr;
            try {
                iArr[aa5.b.o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[aa5.b.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[aa5.b.l.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[aa5.b.v.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[aa5.b.x.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[aa5.b.t.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[aa5.b.m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[aa5.b.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[aa5.b.w.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[aa5.b.y.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[aa5.b.k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[aa5.b.p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public kv(jv jvVar) {
        jv jvVar2 = (jv) bl1.b(jvVar, "output");
        this.a = jvVar2;
        jvVar2.a = this;
    }

    public static kv P(jv jvVar) {
        Object obj = jvVar.a;
        return obj != null ? (kv) obj : new kv(jvVar);
    }

    @Override // defpackage.ha5
    public void A(int i, List list, py3 py3Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), py3Var);
        }
    }

    @Override // defpackage.ha5
    public void B(int i, List list, boolean z) {
        if (list instanceof al) {
            Q(i, (al) list, z);
        } else {
            R(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void C(int i, List list, py3 py3Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            o(i, list.get(i2), py3Var);
        }
    }

    @Override // defpackage.ha5
    public void D(int i, List list, boolean z) {
        if (list instanceof nk1) {
            p0(i, (nk1) list, z);
        } else {
            q0(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void E(int i, List list, boolean z) {
        if (list instanceof s02) {
            n0(i, (s02) list, z);
        } else {
            o0(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void F(int i, long j) {
        this.a.v0(i, j);
    }

    @Override // defpackage.ha5
    public void G(int i, float f) {
        this.a.h0(i, f);
    }

    @Override // defpackage.ha5
    public void H(int i) {
        this.a.y0(i, 4);
    }

    @Override // defpackage.ha5
    public void I(int i, List list, boolean z) {
        if (list instanceof nk1) {
            l0(i, (nk1) list, z);
        } else {
            m0(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void J(int i, int i2) {
        this.a.b0(i, i2);
    }

    @Override // defpackage.ha5
    public void K(int i, List list, boolean z) {
        if (list instanceof s02) {
            f0(i, (s02) list, z);
        } else {
            g0(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void L(int i, List list, boolean z) {
        if (list instanceof nk1) {
            V(i, (nk1) list, z);
        } else {
            W(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void M(int i, List list, boolean z) {
        if (list instanceof cn0) {
            T(i, (cn0) list, z);
        } else {
            U(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void N(int i, int i2) {
        this.a.t0(i, i2);
    }

    @Override // defpackage.ha5
    public void O(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.Y(i, (hn) list.get(i2));
        }
    }

    public final void Q(int i, al alVar, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < alVar.size()) {
                this.a.W(i, alVar.l(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iE = 0;
        for (int i3 = 0; i3 < alVar.size(); i3++) {
            iE += jv.e(alVar.l(i3));
        }
        this.a.A0(iE);
        while (i2 < alVar.size()) {
            this.a.X(alVar.l(i2));
            i2++;
        }
    }

    public final void R(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.W(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iE = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iE += jv.e(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.A0(iE);
        while (i2 < list.size()) {
            this.a.X(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void S(int i, l42.a aVar, Map map) {
        int[] iArr = a.a;
        throw null;
    }

    public final void T(int i, cn0 cn0Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < cn0Var.size()) {
                this.a.Z(i, cn0Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < cn0Var.size(); i4++) {
            i3 += jv.i(cn0Var.m(i4));
        }
        this.a.A0(i3);
        while (i2 < cn0Var.size()) {
            this.a.a0(cn0Var.m(i2));
            i2++;
        }
    }

    public final void U(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Z(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += jv.i(((Double) list.get(i4)).doubleValue());
        }
        this.a.A0(i3);
        while (i2 < list.size()) {
            this.a.a0(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void V(int i, nk1 nk1Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < nk1Var.size()) {
                this.a.b0(i, nk1Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < nk1Var.size(); i3++) {
            iK += jv.k(nk1Var.m(i3));
        }
        this.a.A0(iK);
        while (i2 < nk1Var.size()) {
            this.a.c0(nk1Var.m(i2));
            i2++;
        }
    }

    public final void W(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.b0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += jv.k(((Integer) list.get(i3)).intValue());
        }
        this.a.A0(iK);
        while (i2 < list.size()) {
            this.a.c0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void X(int i, nk1 nk1Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < nk1Var.size()) {
                this.a.d0(i, nk1Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < nk1Var.size(); i3++) {
            iM += jv.m(nk1Var.m(i3));
        }
        this.a.A0(iM);
        while (i2 < nk1Var.size()) {
            this.a.e0(nk1Var.m(i2));
            i2++;
        }
    }

    public final void Y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.d0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM += jv.m(((Integer) list.get(i3)).intValue());
        }
        this.a.A0(iM);
        while (i2 < list.size()) {
            this.a.e0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void Z(int i, s02 s02Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < s02Var.size()) {
                this.a.f0(i, s02Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iO = 0;
        for (int i3 = 0; i3 < s02Var.size(); i3++) {
            iO += jv.o(s02Var.m(i3));
        }
        this.a.A0(iO);
        while (i2 < s02Var.size()) {
            this.a.g0(s02Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void a(int i, Object obj, py3 py3Var) {
        p0 p0Var = (p0) obj;
        this.a.y0(i, 2);
        this.a.A0(p0Var.getSerializedSize(py3Var));
        py3Var.g(p0Var, this);
    }

    public final void a0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.f0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iO = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iO += jv.o(((Long) list.get(i3)).longValue());
        }
        this.a.A0(iO);
        while (i2 < list.size()) {
            this.a.g0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void b(int i, List list, boolean z) {
        if (list instanceof s21) {
            b0(i, (s21) list, z);
        } else {
            c0(i, list, z);
        }
    }

    public final void b0(int i, s21 s21Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < s21Var.size()) {
                this.a.h0(i, s21Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iQ = 0;
        for (int i3 = 0; i3 < s21Var.size(); i3++) {
            iQ += jv.q(s21Var.m(i3));
        }
        this.a.A0(iQ);
        while (i2 < s21Var.size()) {
            this.a.i0(s21Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void c(int i, int i2) {
        this.a.z0(i, i2);
    }

    public final void c0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.h0(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iQ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iQ += jv.q(((Float) list.get(i3)).floatValue());
        }
        this.a.A0(iQ);
        while (i2 < list.size()) {
            this.a.i0(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public final void d(int i, Object obj) {
        boolean z = obj instanceof hn;
        jv jvVar = this.a;
        if (z) {
            jvVar.o0(i, (hn) obj);
        } else {
            jvVar.n0(i, (rs2) obj);
        }
    }

    public final void d0(int i, nk1 nk1Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < nk1Var.size()) {
                this.a.j0(i, nk1Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iS = 0;
        for (int i3 = 0; i3 < nk1Var.size(); i3++) {
            iS += jv.s(nk1Var.m(i3));
        }
        this.a.A0(iS);
        while (i2 < nk1Var.size()) {
            this.a.k0(nk1Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void e(int i, hn hnVar) {
        this.a.Y(i, hnVar);
    }

    public final void e0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iS = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iS += jv.s(((Integer) list.get(i3)).intValue());
        }
        this.a.A0(iS);
        while (i2 < list.size()) {
            this.a.k0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void f(int i, int i2) {
        this.a.d0(i, i2);
    }

    public final void f0(int i, s02 s02Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < s02Var.size()) {
                this.a.l0(i, s02Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < s02Var.size(); i3++) {
            iU += jv.u(s02Var.m(i3));
        }
        this.a.A0(iU);
        while (i2 < s02Var.size()) {
            this.a.m0(s02Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void g(int i, double d) {
        this.a.Z(i, d);
    }

    public final void g0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.l0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += jv.u(((Long) list.get(i3)).longValue());
        }
        this.a.A0(iU);
        while (i2 < list.size()) {
            this.a.m0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void h(int i, List list, boolean z) {
        if (list instanceof s02) {
            j0(i, (s02) list, z);
        } else {
            k0(i, list, z);
        }
    }

    public final void h0(int i, nk1 nk1Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < nk1Var.size()) {
                this.a.p0(i, nk1Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iZ = 0;
        for (int i3 = 0; i3 < nk1Var.size(); i3++) {
            iZ += jv.z(nk1Var.m(i3));
        }
        this.a.A0(iZ);
        while (i2 < nk1Var.size()) {
            this.a.q0(nk1Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void i(int i, List list, boolean z) {
        if (list instanceof s02) {
            r0(i, (s02) list, z);
        } else {
            s0(i, list, z);
        }
    }

    public final void i0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.p0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iZ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZ += jv.z(((Integer) list.get(i3)).intValue());
        }
        this.a.A0(iZ);
        while (i2 < list.size()) {
            this.a.q0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void j(int i, long j) {
        this.a.f0(i, j);
    }

    public final void j0(int i, s02 s02Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < s02Var.size()) {
                this.a.r0(i, s02Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < s02Var.size(); i3++) {
            iB += jv.B(s02Var.m(i3));
        }
        this.a.A0(iB);
        while (i2 < s02Var.size()) {
            this.a.s0(s02Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public ha5.a k() {
        return ha5.a.ASCENDING;
    }

    public final void k0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.r0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += jv.B(((Long) list.get(i3)).longValue());
        }
        this.a.A0(iB);
        while (i2 < list.size()) {
            this.a.s0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void l(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.x0(i, (String) list.get(i2));
        }
    }

    public final void l0(int i, nk1 nk1Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < nk1Var.size()) {
                this.a.t0(i, nk1Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iD = 0;
        for (int i3 = 0; i3 < nk1Var.size(); i3++) {
            iD += jv.D(nk1Var.m(i3));
        }
        this.a.A0(iD);
        while (i2 < nk1Var.size()) {
            this.a.u0(nk1Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void m(int i, String str) {
        this.a.x0(i, str);
    }

    public void m0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.t0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iD += jv.D(((Integer) list.get(i3)).intValue());
        }
        this.a.A0(iD);
        while (i2 < list.size()) {
            this.a.u0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void n(int i, long j) {
        this.a.B0(i, j);
    }

    public final void n0(int i, s02 s02Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < s02Var.size()) {
                this.a.v0(i, s02Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iF = 0;
        for (int i3 = 0; i3 < s02Var.size(); i3++) {
            iF += jv.F(s02Var.m(i3));
        }
        this.a.A0(iF);
        while (i2 < s02Var.size()) {
            this.a.w0(s02Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void o(int i, Object obj, py3 py3Var) {
        this.a.y0(i, 3);
        py3Var.g((p0) obj, this);
        this.a.y0(i, 4);
    }

    public final void o0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.v0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iF += jv.F(((Long) list.get(i3)).longValue());
        }
        this.a.A0(iF);
        while (i2 < list.size()) {
            this.a.w0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void p(int i, List list, boolean z) {
        if (list instanceof nk1) {
            d0(i, (nk1) list, z);
        } else {
            e0(i, list, z);
        }
    }

    public final void p0(int i, nk1 nk1Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < nk1Var.size()) {
                this.a.z0(i, nk1Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < nk1Var.size(); i3++) {
            iK += jv.K(nk1Var.m(i3));
        }
        this.a.A0(iK);
        while (i2 < nk1Var.size()) {
            this.a.A0(nk1Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void q(int i, long j) {
        this.a.l0(i, j);
    }

    public void q0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.z0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += jv.K(((Integer) list.get(i3)).intValue());
        }
        this.a.A0(iK);
        while (i2 < list.size()) {
            this.a.A0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void r(int i, boolean z) {
        this.a.W(i, z);
    }

    public final void r0(int i, s02 s02Var, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < s02Var.size()) {
                this.a.B0(i, s02Var.m(i2));
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < s02Var.size(); i3++) {
            iM += jv.M(s02Var.m(i3));
        }
        this.a.A0(iM);
        while (i2 < s02Var.size()) {
            this.a.C0(s02Var.m(i2));
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void s(int i, l42.a aVar, Map map) {
        if (this.a.Q()) {
            S(i, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.a.y0(i, 2);
            this.a.A0(l42.a(aVar, entry.getKey(), entry.getValue()));
            l42.b(this.a, aVar, entry.getKey(), entry.getValue());
        }
    }

    public final void s0(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.B0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.y0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM += jv.M(((Long) list.get(i3)).longValue());
        }
        this.a.A0(iM);
        while (i2 < list.size()) {
            this.a.C0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.ha5
    public void t(int i, int i2) {
        this.a.p0(i, i2);
    }

    @Override // defpackage.ha5
    public void u(int i) {
        this.a.y0(i, 3);
    }

    @Override // defpackage.ha5
    public void v(int i, int i2) {
        this.a.j0(i, i2);
    }

    @Override // defpackage.ha5
    public void w(int i, List list, boolean z) {
        if (list instanceof s02) {
            Z(i, (s02) list, z);
        } else {
            a0(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void x(int i, List list, boolean z) {
        if (list instanceof nk1) {
            h0(i, (nk1) list, z);
        } else {
            i0(i, list, z);
        }
    }

    @Override // defpackage.ha5
    public void y(int i, long j) {
        this.a.r0(i, j);
    }

    @Override // defpackage.ha5
    public void z(int i, List list, boolean z) {
        if (list instanceof nk1) {
            X(i, (nk1) list, z);
        } else {
            Y(i, list, z);
        }
    }
}

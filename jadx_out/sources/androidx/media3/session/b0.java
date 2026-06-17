package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import defpackage.ac3;
import defpackage.c24;
import defpackage.dc3;
import defpackage.e35;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.kk0;
import defpackage.lr4;
import defpackage.no4;
import defpackage.ph2;
import defpackage.w50;
import defpackage.xr4;
import defpackage.yb;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b0 {
    public static final b0 H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;
    public static final String a0;
    public static final String b0;
    public static final String c0;
    public static final String d0;
    public static final String e0;
    public static final String f0;
    public static final String g0;
    public static final String h0;
    public static final String i0;
    public static final String j0;
    public static final String k0;
    public static final String l0;
    public static final String m0;
    public static final String n0;
    public static final String o0;
    public static final String p0;
    public final int A;
    public final ph2 B;
    public final long C;
    public final long D;
    public final long E;
    public final xr4 F;
    public final lr4 G;
    public final ac3 a;
    public final int b;
    public final c24 c;
    public final hd3.e d;
    public final hd3.e e;
    public final int f;
    public final dc3 g;
    public final int h;
    public final boolean i;
    public final no4 j;
    public final int k;
    public final e35 l;
    public final ph2 m;
    public final float n;
    public final float o;
    public final int p;
    public final yb q;
    public final w50 r;
    public final kk0 s;
    public final int t;
    public final boolean u;
    public final boolean v;
    public final int w;
    public final boolean x;
    public final boolean y;
    public final int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int A;
        public ph2 B;
        public long C;
        public long D;
        public long E;
        public xr4 F;
        public lr4 G;
        public ac3 a;
        public int b;
        public c24 c;
        public hd3.e d;
        public hd3.e e;
        public int f;
        public dc3 g;
        public int h;
        public boolean i;
        public no4 j;
        public int k;
        public e35 l;
        public ph2 m;
        public float n;
        public float o;
        public int p;
        public yb q;
        public w50 r;
        public kk0 s;
        public int t;
        public boolean u;
        public boolean v;
        public int w;
        public boolean x;
        public boolean y;
        public int z;

        public b(b0 b0Var) {
            this.a = b0Var.a;
            this.b = b0Var.b;
            this.c = b0Var.c;
            this.d = b0Var.d;
            this.e = b0Var.e;
            this.f = b0Var.f;
            this.g = b0Var.g;
            this.h = b0Var.h;
            this.i = b0Var.i;
            this.j = b0Var.j;
            this.k = b0Var.k;
            this.l = b0Var.l;
            this.m = b0Var.m;
            this.n = b0Var.n;
            this.o = b0Var.o;
            this.p = b0Var.p;
            this.q = b0Var.q;
            this.r = b0Var.r;
            this.s = b0Var.s;
            this.t = b0Var.t;
            this.u = b0Var.u;
            this.v = b0Var.v;
            this.w = b0Var.w;
            this.x = b0Var.x;
            this.y = b0Var.y;
            this.z = b0Var.z;
            this.A = b0Var.A;
            this.B = b0Var.B;
            this.C = b0Var.C;
            this.D = b0Var.D;
            this.E = b0Var.E;
            this.F = b0Var.F;
            this.G = b0Var.G;
        }

        public b A(c24 c24Var) {
            this.c = c24Var;
            return this;
        }

        public b B(boolean z) {
            this.i = z;
            return this;
        }

        public b C(no4 no4Var) {
            this.j = no4Var;
            return this;
        }

        public b D(int i) {
            this.k = i;
            return this;
        }

        public b E(lr4 lr4Var) {
            this.G = lr4Var;
            return this;
        }

        public b F(float f) {
            this.o = f;
            return this;
        }

        public b G(e35 e35Var) {
            this.l = e35Var;
            return this;
        }

        public b H(float f) {
            this.o = f != 0.0f ? f : this.n;
            this.n = f;
            return this;
        }

        public b0 a() {
            gg3.v(this.j.w() || this.c.a.c < this.j.v());
            return new b0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.j, this.k, this.m, this.n, this.o, this.q, this.p, this.r, this.s, this.t, this.u, this.v, this.w, this.z, this.A, this.x, this.y, this.B, this.C, this.D, this.E, this.F, this.G);
        }

        public b b(yb ybVar) {
            this.q = ybVar;
            return this;
        }

        public b c(int i) {
            this.p = i;
            return this;
        }

        public b d(w50 w50Var) {
            this.r = w50Var;
            return this;
        }

        public b e(xr4 xr4Var) {
            this.F = xr4Var;
            return this;
        }

        public b f(kk0 kk0Var) {
            this.s = kk0Var;
            return this;
        }

        public b g(boolean z) {
            this.u = z;
            return this;
        }

        public b h(int i) {
            this.t = i;
            return this;
        }

        public b i(int i) {
            this.f = i;
            return this;
        }

        public b j(boolean z) {
            this.y = z;
            return this;
        }

        public b k(boolean z) {
            this.x = z;
            return this;
        }

        public b l(long j) {
            this.E = j;
            return this;
        }

        public b m(int i) {
            this.b = i;
            return this;
        }

        public b n(ph2 ph2Var) {
            this.B = ph2Var;
            return this;
        }

        public b o(hd3.e eVar) {
            this.e = eVar;
            return this;
        }

        public b p(hd3.e eVar) {
            this.d = eVar;
            return this;
        }

        public b q(boolean z) {
            this.v = z;
            return this;
        }

        public b r(int i) {
            this.w = i;
            return this;
        }

        public b s(dc3 dc3Var) {
            this.g = dc3Var;
            return this;
        }

        public b t(int i) {
            this.A = i;
            return this;
        }

        public b u(int i) {
            this.z = i;
            return this;
        }

        public b v(ac3 ac3Var) {
            this.a = ac3Var;
            return this;
        }

        public b w(ph2 ph2Var) {
            this.m = ph2Var;
            return this;
        }

        public b x(int i) {
            this.h = i;
            return this;
        }

        public b y(long j) {
            this.C = j;
            return this;
        }

        public b z(long j) {
            this.D = j;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public static final c c = new c(false, false);
        public static final String d = fy4.N0(0);
        public static final String e = fy4.N0(1);
        public final boolean a;
        public final boolean b;

        public c(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public static c a(Bundle bundle) {
            return new c(bundle.getBoolean(d, false), bundle.getBoolean(e, false));
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putBoolean(d, this.a);
            bundle.putBoolean(e, this.b);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(this.a), Boolean.valueOf(this.b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d extends Binder {
        public d() {
        }

        public b0 a() {
            return b0.this;
        }
    }

    static {
        c24 c24Var = c24.l;
        hd3.e eVar = c24.k;
        dc3 dc3Var = dc3.d;
        e35 e35Var = e35.e;
        no4 no4Var = no4.a;
        ph2 ph2Var = ph2.M;
        H = new b0(null, 0, c24Var, eVar, eVar, 0, dc3Var, 0, false, e35Var, no4Var, 0, ph2Var, 1.0f, 1.0f, yb.i, 0, w50.d, kk0.e, 0, false, false, 1, 0, 1, false, false, ph2Var, 5000L, 15000L, 3000L, xr4.b, lr4.J);
        I = fy4.N0(1);
        J = fy4.N0(2);
        K = fy4.N0(3);
        L = fy4.N0(4);
        M = fy4.N0(5);
        N = fy4.N0(6);
        O = fy4.N0(7);
        P = fy4.N0(33);
        Q = fy4.N0(8);
        R = fy4.N0(9);
        S = fy4.N0(10);
        T = fy4.N0(11);
        U = fy4.N0(12);
        V = fy4.N0(13);
        W = fy4.N0(14);
        X = fy4.N0(15);
        Y = fy4.N0(16);
        Z = fy4.N0(17);
        a0 = fy4.N0(18);
        b0 = fy4.N0(19);
        c0 = fy4.N0(20);
        d0 = fy4.N0(21);
        e0 = fy4.N0(22);
        f0 = fy4.N0(23);
        g0 = fy4.N0(24);
        h0 = fy4.N0(25);
        i0 = fy4.N0(26);
        j0 = fy4.N0(27);
        k0 = fy4.N0(28);
        l0 = fy4.N0(29);
        m0 = fy4.N0(30);
        n0 = fy4.N0(31);
        o0 = fy4.N0(32);
        p0 = fy4.N0(34);
    }

    public b0(ac3 ac3Var, int i, c24 c24Var, hd3.e eVar, hd3.e eVar2, int i2, dc3 dc3Var, int i3, boolean z, e35 e35Var, no4 no4Var, int i4, ph2 ph2Var, float f, float f2, yb ybVar, int i5, w50 w50Var, kk0 kk0Var, int i6, boolean z2, boolean z3, int i7, int i8, int i9, boolean z4, boolean z5, ph2 ph2Var2, long j, long j2, long j3, xr4 xr4Var, lr4 lr4Var) {
        this.a = ac3Var;
        this.b = i;
        this.c = c24Var;
        this.d = eVar;
        this.e = eVar2;
        this.f = i2;
        this.g = dc3Var;
        this.h = i3;
        this.i = z;
        this.l = e35Var;
        this.j = no4Var;
        this.k = i4;
        this.m = ph2Var;
        this.n = f;
        this.o = f2;
        this.p = i5;
        this.q = ybVar;
        this.r = w50Var;
        this.s = kk0Var;
        this.t = i6;
        this.u = z2;
        this.v = z3;
        this.w = i7;
        this.z = i8;
        this.A = i9;
        this.x = z4;
        this.y = z5;
        this.B = ph2Var2;
        this.C = j;
        this.D = j2;
        this.E = j3;
        this.F = xr4Var;
        this.G = lr4Var;
    }

    public static b0 D(Bundle bundle, int i) {
        ac3 ac3Var;
        long j;
        IBinder binder = bundle.getBinder(o0);
        if (binder instanceof d) {
            return ((d) binder).a();
        }
        Bundle bundle2 = bundle.getBundle(a0);
        ac3 ac3VarD = bundle2 == null ? null : ac3.d(bundle2);
        int i2 = bundle.getInt(c0, 0);
        Bundle bundle3 = bundle.getBundle(b0);
        c24 c24VarB = bundle3 == null ? c24.l : c24.b(bundle3, i);
        Bundle bundle4 = bundle.getBundle(d0);
        hd3.e eVarC = bundle4 == null ? c24.k : hd3.e.c(bundle4, i);
        Bundle bundle5 = bundle.getBundle(e0);
        hd3.e eVarC2 = bundle5 == null ? c24.k : hd3.e.c(bundle5, i);
        int i3 = bundle.getInt(f0, 0);
        Bundle bundle6 = bundle.getBundle(I);
        dc3 dc3VarA = bundle6 == null ? dc3.d : dc3.a(bundle6);
        int i4 = bundle.getInt(J, 0);
        boolean z = bundle.getBoolean(K, false);
        Bundle bundle7 = bundle.getBundle(L);
        no4 no4VarD = bundle7 == null ? no4.a : no4.d(bundle7, i);
        int i5 = bundle.getInt(n0, 0);
        Bundle bundle8 = bundle.getBundle(M);
        e35 e35VarA = bundle8 == null ? e35.e : e35.a(bundle8);
        Bundle bundle9 = bundle.getBundle(N);
        ph2 ph2VarC = bundle9 == null ? ph2.M : ph2.c(bundle9, i);
        float f = bundle.getFloat(O, 1.0f);
        float f2 = bundle.getFloat(P, 1.0f);
        int i6 = bundle.getInt(p0, 0);
        Bundle bundle10 = bundle.getBundle(Q);
        yb ybVarA = bundle10 == null ? yb.i : yb.a(bundle10);
        Bundle bundle11 = bundle.getBundle(g0);
        w50 w50VarC = bundle11 == null ? w50.d : w50.c(bundle11);
        Bundle bundle12 = bundle.getBundle(R);
        kk0 kk0VarA = bundle12 == null ? kk0.e : kk0.a(bundle12);
        yb ybVar = ybVarA;
        int i7 = bundle.getInt(S, 0);
        boolean z2 = bundle.getBoolean(T, false);
        boolean z3 = bundle.getBoolean(U, false);
        int i8 = bundle.getInt(V, 1);
        int i9 = bundle.getInt(W, 0);
        int i10 = bundle.getInt(X, 1);
        boolean z4 = bundle.getBoolean(Y, false);
        boolean z5 = bundle.getBoolean(Z, false);
        Bundle bundle13 = bundle.getBundle(h0);
        ph2 ph2VarC2 = bundle13 == null ? ph2.M : ph2.c(bundle13, i);
        String str = i0;
        if (i < 4) {
            ac3Var = ac3VarD;
            j = 0;
        } else {
            ac3Var = ac3VarD;
            j = 5000;
        }
        long j2 = bundle.getLong(str, j);
        long j3 = bundle.getLong(j0, i < 4 ? 0L : 15000L);
        long j4 = bundle.getLong(k0, i >= 4 ? 3000L : 0L);
        Bundle bundle14 = bundle.getBundle(m0);
        xr4 xr4VarA = bundle14 == null ? xr4.b : xr4.a(bundle14);
        Bundle bundle15 = bundle.getBundle(l0);
        return new b0(ac3Var, i2, c24VarB, eVarC, eVarC2, i3, dc3VarA, i4, z, e35VarA, no4VarD, i5, ph2VarC, f, f2, ybVar, i6, w50VarC, kk0VarA, i7, z2, z3, i8, i9, i10, z4, z5, ph2VarC2, j2, j3, j4, xr4VarA, bundle15 == null ? lr4.J : lr4.N(bundle15));
    }

    public b0 A(e35 e35Var) {
        return new b(this).G(e35Var).a();
    }

    public b0 B(float f) {
        return new b(this).H(f).a();
    }

    public b0 C(hd3.b bVar, boolean z, boolean z2) {
        b bVar2 = new b(this);
        boolean zC = bVar.c(16);
        boolean zC2 = bVar.c(17);
        bVar2.A(this.c.a(zC, zC2));
        bVar2.p(this.d.b(zC, zC2));
        bVar2.o(this.e.b(zC, zC2));
        if (!zC2 && zC && !this.j.w()) {
            bVar2.C(this.j.c(this.c.a.c));
        } else if (z || !zC2) {
            bVar2.C(no4.a);
        }
        if (!bVar.c(18)) {
            bVar2.w(ph2.M);
        }
        if (!bVar.c(22)) {
            bVar2.H(1.0f);
        }
        if (!bVar.c(21)) {
            bVar2.b(yb.i);
        }
        if (!bVar.c(28)) {
            bVar2.d(w50.d);
        }
        if (!bVar.c(23)) {
            bVar2.h(0).g(false);
        }
        if (!bVar.c(18)) {
            bVar2.n(ph2.M);
        }
        if (z2 || !bVar.c(30)) {
            bVar2.e(xr4.b);
        }
        return bVar2.a();
    }

    public fg2 E() {
        if (this.j.w()) {
            return null;
        }
        return this.j.t(this.c.a.c, new no4.d()).c;
    }

    public final boolean F(int i, boolean z, int i2) {
        return i == 3 && z && i2 == 0;
    }

    public Bundle G(int i) {
        Bundle bundle = new Bundle();
        ac3 ac3Var = this.a;
        if (ac3Var != null) {
            bundle.putBundle(a0, ac3Var.i());
        }
        int i2 = this.b;
        if (i2 != 0) {
            bundle.putInt(c0, i2);
        }
        if (i < 3 || !this.c.equals(c24.l)) {
            bundle.putBundle(b0, this.c.c(i));
        }
        if (i < 3 || !c24.k.a(this.d)) {
            bundle.putBundle(d0, this.d.d(i));
        }
        if (i < 3 || !c24.k.a(this.e)) {
            bundle.putBundle(e0, this.e.d(i));
        }
        int i3 = this.f;
        if (i3 != 0) {
            bundle.putInt(f0, i3);
        }
        if (!this.g.equals(dc3.d)) {
            bundle.putBundle(I, this.g.c());
        }
        int i4 = this.h;
        if (i4 != 0) {
            bundle.putInt(J, i4);
        }
        boolean z = this.i;
        if (z) {
            bundle.putBoolean(K, z);
        }
        if (!this.j.equals(no4.a)) {
            bundle.putBundle(L, this.j.y(i));
        }
        int i5 = this.k;
        if (i5 != 0) {
            bundle.putInt(n0, i5);
        }
        if (!this.l.equals(e35.e)) {
            bundle.putBundle(M, this.l.b());
        }
        ph2 ph2Var = this.m;
        ph2 ph2Var2 = ph2.M;
        if (!ph2Var.equals(ph2Var2)) {
            bundle.putBundle(N, this.m.f(i));
        }
        float f = this.n;
        if (f != 1.0f) {
            bundle.putFloat(O, f);
        }
        float f2 = this.o;
        if (f2 != 1.0f) {
            bundle.putFloat(P, f2);
        }
        int i6 = this.p;
        if (i6 != 0) {
            bundle.putInt(p0, i6);
        }
        if (!this.q.equals(yb.i)) {
            bundle.putBundle(Q, this.q.f());
        }
        if (!this.r.equals(w50.d)) {
            bundle.putBundle(g0, this.r.d());
        }
        if (!this.s.equals(kk0.e)) {
            bundle.putBundle(R, this.s.b());
        }
        int i7 = this.t;
        if (i7 != 0) {
            bundle.putInt(S, i7);
        }
        boolean z2 = this.u;
        if (z2) {
            bundle.putBoolean(T, z2);
        }
        boolean z3 = this.v;
        if (z3) {
            bundle.putBoolean(U, z3);
        }
        int i8 = this.w;
        if (i8 != 1) {
            bundle.putInt(V, i8);
        }
        int i9 = this.z;
        if (i9 != 0) {
            bundle.putInt(W, i9);
        }
        int i10 = this.A;
        if (i10 != 1) {
            bundle.putInt(X, i10);
        }
        boolean z4 = this.x;
        if (z4) {
            bundle.putBoolean(Y, z4);
        }
        boolean z5 = this.y;
        if (z5) {
            bundle.putBoolean(Z, z5);
        }
        if (!this.B.equals(ph2Var2)) {
            bundle.putBundle(h0, this.B.f(i));
        }
        long j = i < 6 ? 0L : 5000L;
        long j2 = this.C;
        if (j2 != j) {
            bundle.putLong(i0, j2);
        }
        long j3 = i < 6 ? 0L : 15000L;
        long j4 = this.D;
        if (j4 != j3) {
            bundle.putLong(j0, j4);
        }
        long j5 = i >= 6 ? 3000L : 0L;
        long j6 = this.E;
        if (j6 != j5) {
            bundle.putLong(k0, j6);
        }
        if (!this.F.equals(xr4.b)) {
            bundle.putBundle(m0, this.F.g());
        }
        if (!this.G.equals(lr4.J)) {
            bundle.putBundle(l0, this.G.O());
        }
        return bundle;
    }

    public Bundle H() {
        Bundle bundle = new Bundle();
        bundle.putBinder(o0, new d());
        return bundle;
    }

    public b0 a(yb ybVar) {
        return new b(this).b(ybVar).a();
    }

    public b0 b(int i) {
        return new b(this).c(i).a();
    }

    public b0 c(xr4 xr4Var) {
        return new b(this).e(xr4Var).a();
    }

    public b0 d(kk0 kk0Var) {
        return new b(this).f(kk0Var).a();
    }

    public b0 e(int i, boolean z) {
        return new b(this).h(i).g(z).a();
    }

    public b0 f(boolean z) {
        return new b(this).j(z).a();
    }

    public b0 g(boolean z) {
        return new b(this).k(z).a();
    }

    public b0 h(long j) {
        return new b(this).l(j).a();
    }

    public b0 i(int i) {
        return new b(this).m(i).a();
    }

    public b0 j(ph2 ph2Var) {
        return new b(this).n(ph2Var).a();
    }

    public b0 k(boolean z, int i, int i2) {
        return new b(this).q(z).r(i).u(i2).k(F(this.A, z, i2)).a();
    }

    public b0 l(dc3 dc3Var) {
        return new b(this).s(dc3Var).a();
    }

    public b0 m(int i, ac3 ac3Var) {
        return new b(this).v(ac3Var).t(i).k(F(i, this.v, this.z)).a();
    }

    public b0 n(ac3 ac3Var) {
        return new b(this).v(ac3Var).a();
    }

    public b0 o(ph2 ph2Var) {
        return new b(this).w(ph2Var).a();
    }

    public b0 p(hd3.e eVar, hd3.e eVar2, int i) {
        return new b(this).p(eVar).o(eVar2).i(i).a();
    }

    public b0 q(int i) {
        return new b(this).x(i).a();
    }

    public b0 r(long j) {
        return new b(this).y(j).a();
    }

    public b0 s(long j) {
        return new b(this).z(j).a();
    }

    public b0 t(c24 c24Var) {
        return new b(this).A(c24Var).a();
    }

    public b0 u(boolean z) {
        return new b(this).B(z).a();
    }

    public b0 v(no4 no4Var) {
        return new b(this).C(no4Var).a();
    }

    public b0 w(no4 no4Var, int i, int i2) {
        b bVarD = new b(this).C(no4Var).D(i2);
        hd3.e eVar = this.c.a;
        hd3.e eVar2 = new hd3.e(eVar.a, i, eVar.d, eVar.e, eVar.f, eVar.g, eVar.h, eVar.i, eVar.j);
        c24 c24Var = this.c;
        return bVarD.A(new c24(eVar2, c24Var.b, c24Var.c, c24Var.d, c24Var.e, c24Var.f, c24Var.g, c24Var.h, c24Var.i, c24Var.j)).a();
    }

    public b0 x(no4 no4Var, c24 c24Var, int i) {
        return new b(this).C(no4Var).A(c24Var).D(i).a();
    }

    public b0 y(lr4 lr4Var) {
        return new b(this).E(lr4Var).a();
    }

    public b0 z(float f) {
        return new b(this).F(f).a();
    }
}

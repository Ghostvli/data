package defpackage;

import android.os.Bundle;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lr4 {
    public static final lr4 J;
    public static final lr4 K;
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
    public static final String q0;
    public static final String r0;
    public static final String s0;
    public static final String t0;
    public static final String u0;
    public static final String v0;
    public static final String w0;
    public final int A;
    public final boolean B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final zi1 H;
    public final dj1 I;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final xi1 m;
    public final xi1 n;
    public final xi1 o;
    public final int p;
    public final xi1 q;
    public final xi1 r;
    public final int s;
    public final int t;
    public final int u;
    public final xi1 v;
    public final b w;
    public final boolean x;
    public final xi1 y;
    public final xi1 z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final b d = new a().d();
        public static final String e = fy4.N0(1);
        public static final String f = fy4.N0(2);
        public static final String g = fy4.N0(3);
        public final int a;
        public final boolean b;
        public final boolean c;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public int a = 0;
            public boolean b = false;
            public boolean c = false;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b d() {
                return new b(this);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a e(int i) {
                this.a = i;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a f(boolean z) {
                this.b = z;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a g(boolean z) {
                this.c = z;
                return this;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b a(Bundle bundle) {
            a aVar = new a();
            String str = e;
            b bVar = d;
            return aVar.e(bundle.getInt(str, bVar.a)).f(bundle.getBoolean(f, bVar.b)).g(bundle.getBoolean(g, bVar.c)).d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putInt(e, this.a);
            bundle.putBoolean(f, this.b);
            bundle.putBoolean(g, this.c);
            return bundle;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.a == bVar.a && this.b == bVar.b && this.c == bVar.c) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return ((((this.a + 31) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        lr4 lr4VarK = new c().K();
        J = lr4VarK;
        K = lr4VarK;
        L = fy4.N0(1);
        M = fy4.N0(2);
        N = fy4.N0(3);
        O = fy4.N0(4);
        P = fy4.N0(5);
        Q = fy4.N0(6);
        R = fy4.N0(7);
        S = fy4.N0(8);
        T = fy4.N0(9);
        U = fy4.N0(10);
        V = fy4.N0(11);
        W = fy4.N0(12);
        X = fy4.N0(13);
        Y = fy4.N0(14);
        Z = fy4.N0(15);
        a0 = fy4.N0(16);
        b0 = fy4.N0(17);
        c0 = fy4.N0(18);
        d0 = fy4.N0(19);
        e0 = fy4.N0(20);
        f0 = fy4.N0(21);
        g0 = fy4.N0(22);
        h0 = fy4.N0(23);
        i0 = fy4.N0(24);
        j0 = fy4.N0(25);
        k0 = fy4.N0(26);
        l0 = fy4.N0(27);
        m0 = fy4.N0(28);
        n0 = fy4.N0(29);
        o0 = fy4.N0(30);
        p0 = fy4.N0(31);
        q0 = fy4.N0(32);
        r0 = fy4.N0(33);
        s0 = fy4.N0(34);
        t0 = fy4.N0(35);
        u0 = fy4.N0(36);
        v0 = fy4.N0(37);
        w0 = fy4.N0(38);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lr4(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
        this.j = cVar.j;
        this.k = cVar.k;
        this.l = cVar.l;
        this.m = cVar.m;
        this.n = cVar.n;
        this.o = cVar.o;
        this.p = cVar.p;
        this.q = cVar.q;
        this.s = cVar.s;
        this.t = cVar.t;
        this.r = cVar.r;
        this.u = cVar.u;
        this.v = cVar.v;
        this.w = cVar.w;
        this.x = cVar.x;
        this.y = cVar.y;
        this.A = cVar.z;
        this.B = cVar.A;
        this.z = cVar.B;
        this.C = cVar.C;
        this.D = cVar.D;
        this.E = cVar.E;
        this.F = cVar.F;
        this.G = cVar.G;
        this.H = zi1.c(cVar.H);
        this.I = dj1.p(cVar.I);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lr4 N(Bundle bundle) {
        return new c(bundle).K();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c M() {
        return new c(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle O() {
        Bundle bundle = new Bundle();
        bundle.putInt(Q, this.a);
        bundle.putInt(R, this.b);
        bundle.putInt(S, this.c);
        bundle.putInt(T, this.d);
        bundle.putInt(U, this.e);
        bundle.putInt(V, this.f);
        bundle.putInt(W, this.g);
        bundle.putInt(X, this.h);
        bundle.putInt(Y, this.i);
        bundle.putInt(Z, this.j);
        bundle.putBoolean(r0, this.k);
        bundle.putBoolean(a0, this.l);
        bundle.putStringArray(b0, (String[]) this.m.toArray(new String[0]));
        bundle.putStringArray(q0, (String[]) this.o.toArray(new String[0]));
        bundle.putStringArray(u0, (String[]) this.n.toArray(new String[0]));
        bundle.putInt(j0, this.p);
        bundle.putStringArray(L, (String[]) this.q.toArray(new String[0]));
        bundle.putInt(M, this.s);
        bundle.putInt(c0, this.t);
        bundle.putInt(d0, this.u);
        bundle.putStringArray(v0, (String[]) this.r.toArray(new String[0]));
        bundle.putStringArray(e0, (String[]) this.v.toArray(new String[0]));
        bundle.putBoolean(t0, this.x);
        bundle.putStringArray(N, (String[]) this.y.toArray(new String[0]));
        bundle.putInt(O, this.A);
        bundle.putBoolean(s0, this.B);
        bundle.putStringArray(w0, (String[]) this.z.toArray(new String[0]));
        bundle.putInt(k0, this.C);
        bundle.putBoolean(P, this.D);
        bundle.putInt(l0, this.w.a);
        bundle.putBoolean(m0, this.w.b);
        bundle.putBoolean(n0, this.w.c);
        bundle.putBundle(o0, this.w.b());
        bundle.putBoolean(p0, this.E);
        bundle.putBoolean(f0, this.F);
        bundle.putBoolean(g0, this.G);
        bundle.putParcelableArrayList(h0, fm.h(this.H.values(), new p81() { // from class: kr4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((jr4) obj).c();
            }
        }));
        bundle.putIntArray(i0, ll1.n(this.I));
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            lr4 lr4Var = (lr4) obj;
            if (this.a == lr4Var.a && this.b == lr4Var.b && this.c == lr4Var.c && this.d == lr4Var.d && this.e == lr4Var.e && this.f == lr4Var.f && this.g == lr4Var.g && this.h == lr4Var.h && this.l == lr4Var.l && this.i == lr4Var.i && this.j == lr4Var.j && this.k == lr4Var.k && this.m.equals(lr4Var.m) && this.n.equals(lr4Var.n) && this.o.equals(lr4Var.o) && this.p == lr4Var.p && this.q.equals(lr4Var.q) && this.s == lr4Var.s && this.t == lr4Var.t && this.r.equals(lr4Var.r) && this.u == lr4Var.u && this.v.equals(lr4Var.v) && this.w.equals(lr4Var.w) && this.x == lr4Var.x && this.z.equals(lr4Var.z) && this.y.equals(lr4Var.y) && this.A == lr4Var.A && this.B == lr4Var.B && this.C == lr4Var.C && this.D == lr4Var.D && this.E == lr4Var.E && this.F == lr4Var.F && this.G == lr4Var.G && this.H.equals(lr4Var.H) && this.I.equals(lr4Var.I)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.a + 31) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + (this.l ? 1 : 0)) * 31) + this.i) * 31) + this.j) * 31) + (this.k ? 1 : 0)) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p) * 31) + this.q.hashCode()) * 31) + this.s) * 31) + this.t) * 31) + this.r.hashCode()) * 31) + this.u) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31) + (this.x ? 1 : 0)) * 31) + this.y.hashCode()) * 31) + this.A) * 31) + (this.B ? 1 : 0)) * 31) + this.z.hashCode()) * 31) + this.C) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + this.H.hashCode()) * 31) + this.I.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public boolean A;
        public xi1 B;
        public int C;
        public boolean D;
        public boolean E;
        public boolean F;
        public boolean G;
        public HashMap H;
        public HashSet I;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public xi1 m;
        public xi1 n;
        public xi1 o;
        public int p;
        public xi1 q;
        public xi1 r;
        public int s;
        public int t;
        public int u;
        public xi1 v;
        public b w;
        public boolean x;
        public xi1 y;
        public int z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Bundle bundle) {
            String str = lr4.Q;
            lr4 lr4Var = lr4.J;
            this.a = bundle.getInt(str, lr4Var.a);
            this.b = bundle.getInt(lr4.R, lr4Var.b);
            this.c = bundle.getInt(lr4.S, lr4Var.c);
            this.d = bundle.getInt(lr4.T, lr4Var.d);
            this.e = bundle.getInt(lr4.U, lr4Var.e);
            this.f = bundle.getInt(lr4.V, lr4Var.f);
            this.g = bundle.getInt(lr4.W, lr4Var.g);
            this.h = bundle.getInt(lr4.X, lr4Var.h);
            this.i = bundle.getInt(lr4.Y, lr4Var.i);
            int i = bundle.getInt(lr4.Z, lr4Var.j);
            this.j = i;
            this.k = this.i == Integer.MAX_VALUE && i == Integer.MAX_VALUE && bundle.getBoolean(lr4.r0, lr4Var.k);
            this.l = bundle.getBoolean(lr4.a0, lr4Var.l);
            this.m = xi1.q((String[]) eu2.a(bundle.getStringArray(lr4.b0), new String[0]));
            this.n = xi1.q((String[]) eu2.a(bundle.getStringArray(lr4.u0), new String[0]));
            this.o = xi1.q((String[]) eu2.a(bundle.getStringArray(lr4.q0), new String[0]));
            this.p = bundle.getInt(lr4.j0, lr4Var.p);
            this.q = P((String[]) eu2.a(bundle.getStringArray(lr4.L), new String[0]));
            this.r = xi1.q((String[]) eu2.a(bundle.getStringArray(lr4.v0), new String[0]));
            this.s = bundle.getInt(lr4.M, lr4Var.s);
            this.t = bundle.getInt(lr4.c0, lr4Var.t);
            this.u = bundle.getInt(lr4.d0, lr4Var.u);
            this.v = xi1.q((String[]) eu2.a(bundle.getStringArray(lr4.e0), new String[0]));
            this.w = N(bundle);
            this.x = bundle.getBoolean(lr4.t0, lr4Var.x);
            this.y = P((String[]) eu2.a(bundle.getStringArray(lr4.N), new String[0]));
            this.z = bundle.getInt(lr4.O, lr4Var.A);
            this.A = this.y.isEmpty() && this.z == 0 && bundle.getBoolean(lr4.s0, lr4Var.B);
            this.C = bundle.getInt(lr4.k0, lr4Var.C);
            this.B = xi1.q((String[]) eu2.a(bundle.getStringArray(lr4.w0), new String[0]));
            this.D = bundle.getBoolean(lr4.P, lr4Var.D);
            this.E = bundle.getBoolean(lr4.p0, lr4Var.E);
            this.F = bundle.getBoolean(lr4.f0, lr4Var.F);
            this.G = bundle.getBoolean(lr4.g0, lr4Var.G);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(lr4.h0);
            xi1 xi1VarU = parcelableArrayList == null ? xi1.u() : fm.d(new p81() { // from class: mr4
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return jr4.a((Bundle) obj);
                }
            }, parcelableArrayList);
            this.H = new HashMap();
            for (int i2 = 0; i2 < xi1VarU.size(); i2++) {
                jr4 jr4Var = (jr4) xi1VarU.get(i2);
                this.H.put(jr4Var.a, jr4Var);
            }
            int[] iArr = (int[]) eu2.a(bundle.getIntArray(lr4.i0), new int[0]);
            this.I = new HashSet();
            for (int i3 : iArr) {
                this.I.add(Integer.valueOf(i3));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b N(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(lr4.o0);
            if (bundle2 != null) {
                return b.a(bundle2);
            }
            b.a aVar = new b.a();
            String str = lr4.l0;
            b bVar = b.d;
            return aVar.e(bundle.getInt(str, bVar.a)).f(bundle.getBoolean(lr4.m0, bVar.b)).g(bundle.getBoolean(lr4.n0, bVar.c)).d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static xi1 P(String[] strArr) {
            xi1.a aVarM = xi1.m();
            for (String str : (String[]) gg3.q(strArr)) {
                aVarM.a(fy4.f1((String) gg3.q(str)));
            }
            return aVarM.k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c J(jr4 jr4Var) {
            this.H.put(jr4Var.a, jr4Var);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public lr4 K() {
            return new lr4(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c L() {
            this.H.clear();
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c M(int i) {
            Iterator it = this.H.values().iterator();
            while (it.hasNext()) {
                if (((jr4) it.next()).b() == i) {
                    it.remove();
                }
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void O(lr4 lr4Var) {
            this.a = lr4Var.a;
            this.b = lr4Var.b;
            this.c = lr4Var.c;
            this.d = lr4Var.d;
            this.e = lr4Var.e;
            this.f = lr4Var.f;
            this.g = lr4Var.g;
            this.h = lr4Var.h;
            this.i = lr4Var.i;
            this.j = lr4Var.j;
            this.k = lr4Var.k;
            this.l = lr4Var.l;
            this.n = lr4Var.n;
            this.m = lr4Var.m;
            this.o = lr4Var.o;
            this.p = lr4Var.p;
            this.q = lr4Var.q;
            this.s = lr4Var.s;
            this.r = lr4Var.r;
            this.t = lr4Var.t;
            this.u = lr4Var.u;
            this.v = lr4Var.v;
            this.w = lr4Var.w;
            this.x = lr4Var.x;
            this.y = lr4Var.y;
            this.z = lr4Var.A;
            this.A = lr4Var.B;
            this.B = lr4Var.z;
            this.C = lr4Var.C;
            this.D = lr4Var.D;
            this.E = lr4Var.E;
            this.F = lr4Var.F;
            this.G = lr4Var.G;
            this.I = new HashSet(lr4Var.I);
            this.H = new HashMap(lr4Var.H);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c Q(lr4 lr4Var) {
            O(lr4Var);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c R(Set set) {
            this.I.clear();
            this.I.addAll(set);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c S(boolean z) {
            this.G = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c T(int i) {
            this.C = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c U(jr4 jr4Var) {
            M(jr4Var.b());
            this.H.put(jr4Var.a, jr4Var);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c V(String str) {
            return str == null ? W(new String[0]) : W(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c W(String... strArr) {
            this.v = xi1.q(strArr);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c X(String str) {
            return str == null ? Y(new String[0]) : Y(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c Y(String... strArr) {
            this.y = P(strArr);
            this.A = false;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c Z(int i) {
            this.z = i;
            this.A = false;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c a0(int i, boolean z) {
            HashSet hashSet = this.I;
            if (z) {
                hashSet.add(Integer.valueOf(i));
                return this;
            }
            hashSet.remove(Integer.valueOf(i));
            return this;
        }

        public c(lr4 lr4Var) {
            O(lr4Var);
        }

        public c() {
            this.a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = true;
            this.m = xi1.u();
            this.n = xi1.u();
            this.o = xi1.u();
            this.p = 0;
            this.q = xi1.u();
            this.r = xi1.u();
            this.s = 0;
            this.t = Integer.MAX_VALUE;
            this.u = Integer.MAX_VALUE;
            this.v = xi1.u();
            this.w = b.d;
            this.x = false;
            this.y = xi1.u();
            this.z = 0;
            this.A = true;
            this.B = xi1.u();
            this.C = 0;
            this.D = false;
            this.E = false;
            this.F = false;
            this.G = false;
            this.H = new HashMap();
            this.I = new HashSet();
        }
    }
}

package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t41 {
    public final float A;
    public final int B;
    public final float C;
    public final byte[] D;
    public final int E;
    public final bx F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public int R;
    public final String a;
    public final String b;
    public final List c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final String k;
    public final xs2 l;
    public final Object m;
    public final String n;
    public final String o;
    public final String p;
    public final int q;
    public final int r;
    public final List s;
    public final oo0 t;
    public final long u;
    public final boolean v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;
    public static final t41 S = new b().Q();
    public static final String T = fy4.N0(0);
    public static final String U = fy4.N0(1);
    public static final String V = fy4.N0(2);
    public static final String W = fy4.N0(3);
    public static final String X = fy4.N0(4);
    public static final String Y = fy4.N0(5);
    public static final String Z = fy4.N0(6);
    public static final String a0 = fy4.N0(7);
    public static final String b0 = fy4.N0(8);
    public static final String c0 = fy4.N0(9);
    public static final String d0 = fy4.N0(10);
    public static final String e0 = fy4.N0(11);
    public static final String f0 = fy4.N0(12);
    public static final String g0 = fy4.N0(13);
    public static final String h0 = fy4.N0(14);
    public static final String i0 = fy4.N0(15);
    public static final String j0 = fy4.N0(16);
    public static final String k0 = fy4.N0(17);
    public static final String l0 = fy4.N0(18);
    public static final String m0 = fy4.N0(19);
    public static final String n0 = fy4.N0(20);
    public static final String o0 = fy4.N0(21);
    public static final String p0 = fy4.N0(22);
    public static final String q0 = fy4.N0(23);
    public static final String r0 = fy4.N0(24);
    public static final String s0 = fy4.N0(25);
    public static final String t0 = fy4.N0(26);
    public static final String u0 = fy4.N0(27);
    public static final String v0 = fy4.N0(28);
    public static final String w0 = fy4.N0(29);
    public static final String x0 = fy4.N0(30);
    public static final String y0 = fy4.N0(31);
    public static final String z0 = fy4.N0(32);
    public static final String A0 = fy4.N0(33);
    public static final String B0 = fy4.N0(34);
    public static final String C0 = fy4.N0(35);
    public static final String D0 = fy4.N0(36);
    public static final String E0 = fy4.N0(37);

    public t41(b bVar) {
        this.a = bVar.a;
        String strF1 = fy4.f1(bVar.d);
        this.d = strF1;
        if (bVar.c.isEmpty() && bVar.b != null) {
            this.c = xi1.w(new rr1(strF1, bVar.b));
            this.b = bVar.b;
        } else if (bVar.c.isEmpty() || bVar.b != null) {
            gg3.v(i(bVar));
            this.c = bVar.c;
            this.b = bVar.b;
        } else {
            this.c = bVar.c;
            this.b = f(bVar.c, strF1);
        }
        this.e = bVar.e;
        gg3.w(bVar.g == 0 || (bVar.f & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.f = bVar.f;
        this.g = bVar.g;
        int i = bVar.h;
        this.h = i;
        int i2 = bVar.i;
        this.i = i2;
        this.j = i2 != -1 ? i2 : i;
        this.k = bVar.j;
        this.l = bVar.k;
        this.m = bVar.l;
        this.n = bVar.m;
        this.o = bVar.n;
        this.p = bVar.o;
        this.q = bVar.p;
        this.r = bVar.q;
        this.s = bVar.r == null ? Collections.EMPTY_LIST : bVar.r;
        oo0 oo0Var = bVar.s;
        this.t = oo0Var;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A == -1 ? 0 : bVar.A;
        this.C = bVar.B == -1.0f ? 1.0f : bVar.B;
        this.D = bVar.C;
        this.E = bVar.D;
        this.F = bVar.E;
        this.G = bVar.F;
        this.H = bVar.G;
        this.I = bVar.H;
        this.J = bVar.I;
        this.K = bVar.J == -1 ? 0 : bVar.J;
        this.L = bVar.K != -1 ? bVar.K : 0;
        this.M = bVar.L;
        this.N = bVar.M;
        this.O = bVar.N;
        this.P = bVar.O;
        if (bVar.P != 0 || oo0Var == null) {
            this.Q = bVar.P;
        } else {
            this.Q = 1;
        }
    }

    public static /* synthetic */ String a(rr1 rr1Var) {
        return rr1Var.a + ": " + rr1Var.b;
    }

    public static Object d(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    public static t41 e(Bundle bundle) {
        b bVar = new b();
        fm.c(bundle);
        String string = bundle.getString(T);
        t41 t41Var = S;
        bVar.k0((String) d(string, t41Var.a)).m0((String) d(bundle.getString(U), t41Var.b));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(z0);
        bVar.n0(parcelableArrayList == null ? xi1.u() : fm.d(new p81() { // from class: s41
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return rr1.a((Bundle) obj);
            }
        }, parcelableArrayList)).o0((String) d(bundle.getString(V), t41Var.d)).C0(bundle.getInt(W, t41Var.e)).y0(bundle.getInt(X, t41Var.f)).S(bundle.getInt(A0, t41Var.g)).T(bundle.getInt(Y, t41Var.h)).u0(bundle.getInt(Z, t41Var.i)).V((String) d(bundle.getString(a0), t41Var.k)).w0((String) d(bundle.getString(E0), t41Var.n)).X((String) d(bundle.getString(c0), t41Var.o)).A0((String) d(bundle.getString(d0), t41Var.p)).p0(bundle.getInt(e0, t41Var.q));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(j(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        b bVarD0 = bVar.l0(arrayList).d0((oo0) bundle.getParcelable(g0));
        String str = h0;
        t41 t41Var2 = S;
        bVarD0.E0(bundle.getLong(str, t41Var2.u)).H0(bundle.getInt(i0, t41Var2.w)).i0(bundle.getInt(j0, t41Var2.x)).c0(bundle.getInt(C0, t41Var2.y)).b0(bundle.getInt(D0, t41Var2.z)).g0(bundle.getFloat(k0, t41Var2.A)).z0(bundle.getInt(l0, t41Var2.B)).v0(bundle.getFloat(m0, t41Var2.C)).x0(bundle.getByteArray(n0)).D0(bundle.getInt(o0, t41Var2.E)).r0(bundle.getInt(B0, t41Var2.G));
        Bundle bundle2 = bundle.getBundle(p0);
        if (bundle2 != null) {
            bVar.W(bx.f(bundle2));
        }
        bVar.U(bundle.getInt(q0, t41Var2.H)).B0(bundle.getInt(r0, t41Var2.I)).t0(bundle.getInt(s0, t41Var2.J)).e0(bundle.getInt(t0, t41Var2.K)).f0(bundle.getInt(u0, t41Var2.L)).R(bundle.getInt(v0, t41Var2.M)).F0(bundle.getInt(x0, t41Var2.O)).G0(bundle.getInt(y0, t41Var2.P)).Y(bundle.getInt(w0, t41Var2.Q));
        return bVar.Q();
    }

    public static String f(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rr1 rr1Var = (rr1) it.next();
            if (TextUtils.equals(rr1Var.a, str)) {
                return rr1Var.b;
            }
        }
        return ((rr1) list.get(0)).b;
    }

    public static boolean i(b bVar) {
        if (bVar.c.isEmpty() && bVar.b == null) {
            return true;
        }
        for (int i = 0; i < bVar.c.size(); i++) {
            if (((rr1) bVar.c.get(i)).b.equals(bVar.b)) {
                return true;
            }
        }
        return false;
    }

    public static String j(int i) {
        return f0 + "_" + Integer.toString(i, 36);
    }

    public static String l(t41 t41Var) {
        if (t41Var == null) {
            return "null";
        }
        wn1 wn1VarG = wn1.g(',');
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(t41Var.a);
        sb.append(", mimeType=");
        sb.append(t41Var.p);
        if (t41Var.o != null) {
            sb.append(", container=");
            sb.append(t41Var.o);
        }
        if (t41Var.n != null) {
            sb.append(", primaryGroupId=");
            sb.append(t41Var.n);
        }
        if (t41Var.j != -1) {
            sb.append(", bitrate=");
            sb.append(t41Var.j);
        }
        if (t41Var.k != null) {
            sb.append(", codecs=");
            sb.append(t41Var.k);
        }
        if (t41Var.t != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                oo0 oo0Var = t41Var.t;
                if (i >= oo0Var.i) {
                    break;
                }
                UUID uuid = oo0Var.v(i).g;
                if (uuid.equals(kn.c)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(kn.d)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(kn.f)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(kn.e)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(kn.b)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i++;
            }
            sb.append(", drm=[");
            wn1VarG.c(sb, linkedHashSet);
            sb.append(']');
        }
        if (t41Var.w != -1 && t41Var.x != -1) {
            sb.append(", res=");
            sb.append(t41Var.w);
            sb.append("x");
            sb.append(t41Var.x);
        }
        if (t41Var.y != -1 && t41Var.z != -1) {
            sb.append(", decRes=");
            sb.append(t41Var.y);
            sb.append("x");
            sb.append(t41Var.z);
        }
        if (!dn0.a(t41Var.C, 1.0d, 0.001d)) {
            sb.append(", par=");
            sb.append(fy4.M("%.3f", Float.valueOf(t41Var.C)));
        }
        bx bxVar = t41Var.F;
        if (bxVar != null && bxVar.j()) {
            sb.append(", color=");
            sb.append(t41Var.F.o());
        }
        if (t41Var.A != -1.0f) {
            sb.append(", fps=");
            sb.append(t41Var.A);
        }
        if (t41Var.G != -1) {
            sb.append(", maxSubLayers=");
            sb.append(t41Var.G);
        }
        if (t41Var.H != -1) {
            sb.append(", channels=");
            sb.append(t41Var.H);
        }
        if (t41Var.I != -1) {
            sb.append(", sample_rate=");
            sb.append(t41Var.I);
        }
        if (t41Var.d != null) {
            sb.append(", language=");
            sb.append(t41Var.d);
        }
        if (!t41Var.c.isEmpty()) {
            sb.append(", labels=[");
            wn1VarG.c(sb, ru1.i(t41Var.c, new p81() { // from class: q41
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return t41.a((rr1) obj);
                }
            }));
            sb.append("]");
        }
        if (t41Var.e != 0) {
            sb.append(", selectionFlags=[");
            wn1VarG.c(sb, fy4.x0(t41Var.e));
            sb.append("]");
        }
        if (t41Var.f != 0) {
            sb.append(", roleFlags=[");
            wn1VarG.c(sb, fy4.w0(t41Var.f));
            sb.append("]");
        }
        if (t41Var.m != null) {
            sb.append(", customData=");
            sb.append(t41Var.m);
        }
        if ((t41Var.f & 32768) != 0) {
            sb.append(", auxiliaryTrackType=");
            sb.append(fy4.T(t41Var.g));
        }
        return sb.toString();
    }

    public b b() {
        return new b();
    }

    public t41 c(int i) {
        return b().Y(i).Q();
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && t41.class == obj.getClass()) {
            t41 t41Var = (t41) obj;
            int i2 = this.R;
            if ((i2 == 0 || (i = t41Var.R) == 0 || i2 == i) && this.e == t41Var.e && this.f == t41Var.f && this.g == t41Var.g && this.h == t41Var.h && this.i == t41Var.i && this.q == t41Var.q && this.u == t41Var.u && this.w == t41Var.w && this.x == t41Var.x && this.y == t41Var.y && this.z == t41Var.z && this.B == t41Var.B && this.E == t41Var.E && this.G == t41Var.G && this.H == t41Var.H && this.I == t41Var.I && this.J == t41Var.J && this.K == t41Var.K && this.L == t41Var.L && this.M == t41Var.M && this.O == t41Var.O && this.P == t41Var.P && this.Q == t41Var.Q && Float.compare(this.A, t41Var.A) == 0 && Float.compare(this.C, t41Var.C) == 0 && Objects.equals(this.a, t41Var.a) && Objects.equals(this.b, t41Var.b) && this.c.equals(t41Var.c) && Objects.equals(this.k, t41Var.k) && Objects.equals(this.n, t41Var.n) && Objects.equals(this.o, t41Var.o) && Objects.equals(this.p, t41Var.p) && Objects.equals(this.d, t41Var.d) && Arrays.equals(this.D, t41Var.D) && Objects.equals(this.l, t41Var.l) && Objects.equals(this.F, t41Var.F) && Objects.equals(this.t, t41Var.t) && h(t41Var) && Objects.equals(this.m, t41Var.m)) {
                return true;
            }
        }
        return false;
    }

    public int g() {
        int i;
        int i2 = this.w;
        if (i2 == -1 || (i = this.x) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public boolean h(t41 t41Var) {
        if (this.s.size() != t41Var.s.size()) {
            return false;
        }
        for (int i = 0; i < this.s.size(); i++) {
            if (!Arrays.equals((byte[]) this.s.get(i), (byte[]) t41Var.s.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.R == 0) {
            String str = this.a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.b;
            int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.c.hashCode()) * 31;
            String str3 = this.d;
            int iHashCode3 = (((((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31;
            String str4 = this.k;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            xs2 xs2Var = this.l;
            int iHashCode5 = (iHashCode4 + (xs2Var == null ? 0 : xs2Var.hashCode())) * 31;
            Object obj = this.m;
            int iHashCode6 = (iHashCode5 + (obj == null ? 0 : obj.hashCode())) * 31;
            String str5 = this.n;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.o;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.p;
            this.R = ((((((((((((((((((((((((((((((((((((((((iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.q) * 31) + ((int) this.u)) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + Float.floatToIntBits(this.A)) * 31) + this.B) * 31) + Float.floatToIntBits(this.C)) * 31) + this.E) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.O) * 31) + this.P) * 31) + this.Q;
        }
        return this.R;
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putString(T, this.a);
        bundle.putString(U, this.b);
        bundle.putParcelableArrayList(z0, fm.h(this.c, new p81() { // from class: r41
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((rr1) obj).b();
            }
        }));
        bundle.putString(V, this.d);
        bundle.putInt(W, this.e);
        bundle.putInt(X, this.f);
        int i = this.g;
        if (i != S.g) {
            bundle.putInt(A0, i);
        }
        bundle.putInt(Y, this.h);
        bundle.putInt(Z, this.i);
        bundle.putString(a0, this.k);
        String str = this.n;
        if (str != null) {
            bundle.putString(E0, str);
        }
        bundle.putString(c0, this.o);
        bundle.putString(d0, this.p);
        bundle.putInt(e0, this.q);
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            bundle.putByteArray(j(i2), (byte[]) this.s.get(i2));
        }
        bundle.putParcelable(g0, this.t);
        bundle.putLong(h0, this.u);
        bundle.putInt(i0, this.w);
        bundle.putInt(j0, this.x);
        bundle.putInt(C0, this.y);
        bundle.putInt(D0, this.z);
        bundle.putFloat(k0, this.A);
        bundle.putInt(l0, this.B);
        bundle.putFloat(m0, this.C);
        bundle.putByteArray(n0, this.D);
        bundle.putInt(o0, this.E);
        bx bxVar = this.F;
        if (bxVar != null) {
            bundle.putBundle(p0, bxVar.n());
        }
        bundle.putInt(B0, this.G);
        bundle.putInt(q0, this.H);
        bundle.putInt(r0, this.I);
        bundle.putInt(s0, this.J);
        bundle.putInt(t0, this.K);
        bundle.putInt(u0, this.L);
        bundle.putInt(v0, this.M);
        bundle.putInt(x0, this.O);
        bundle.putInt(y0, this.P);
        bundle.putInt(w0, this.Q);
        return bundle;
    }

    public t41 m(t41 t41Var) {
        String str;
        if (this == t41Var) {
            return this;
        }
        int iK = nt2.k(this.p);
        String str2 = t41Var.a;
        int i = t41Var.O;
        int i2 = t41Var.P;
        String str3 = t41Var.b;
        if (str3 == null) {
            str3 = this.b;
        }
        List list = !t41Var.c.isEmpty() ? t41Var.c : this.c;
        String str4 = this.d;
        if ((iK == 3 || iK == 1) && (str = t41Var.d) != null) {
            str4 = str;
        }
        int i3 = this.h;
        if (i3 == -1) {
            i3 = t41Var.h;
        }
        int i4 = this.i;
        if (i4 == -1) {
            i4 = t41Var.i;
        }
        String str5 = this.k;
        if (str5 == null) {
            String strZ = fy4.Z(t41Var.k, iK);
            if (fy4.I1(strZ).length == 1) {
                str5 = strZ;
            }
        }
        String str6 = this.n;
        if (str6 == null) {
            str6 = t41Var.n;
        }
        xs2 xs2Var = this.l;
        xs2 xs2VarB = t41Var.l;
        if (xs2Var != null) {
            xs2VarB = xs2Var.b(xs2VarB);
        }
        float f = this.A;
        if (f == -1.0f && iK == 2) {
            f = t41Var.A;
        }
        return b().k0(str2).m0(str3).n0(list).o0(str4).C0(this.e | t41Var.e).y0(this.f | t41Var.f).T(i3).u0(i4).V(str5).s0(xs2VarB).w0(str6).d0(oo0.u(t41Var.t, this.t)).g0(f).F0(i).G0(i2).Q();
    }

    public String toString() {
        return "Format(" + this.a + ", " + this.b + ", " + this.o + ", " + this.p + ", " + this.k + ", " + this.j + ", " + this.d + ", [" + this.w + ", " + this.x + ", " + this.A + ", " + this.F + "], [" + this.H + ", " + this.I + "])";
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public int A;
        public float B;
        public byte[] C;
        public int D;
        public bx E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public String a;
        public String b;
        public List c;
        public String d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public String j;
        public xs2 k;
        public Object l;
        public String m;
        public String n;
        public String o;
        public int p;
        public int q;
        public List r;
        public oo0 s;
        public long t;
        public boolean u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        public b(t41 t41Var) {
            this.a = t41Var.a;
            this.b = t41Var.b;
            this.c = t41Var.c;
            this.d = t41Var.d;
            this.e = t41Var.e;
            this.f = t41Var.f;
            this.h = t41Var.h;
            this.i = t41Var.i;
            this.j = t41Var.k;
            this.k = t41Var.l;
            this.l = t41Var.m;
            this.m = t41Var.n;
            this.n = t41Var.o;
            this.o = t41Var.p;
            this.p = t41Var.q;
            this.q = t41Var.r;
            this.r = t41Var.s;
            this.s = t41Var.t;
            this.t = t41Var.u;
            this.u = t41Var.v;
            this.v = t41Var.w;
            this.w = t41Var.x;
            this.x = t41Var.y;
            this.y = t41Var.z;
            this.z = t41Var.A;
            this.A = t41Var.B;
            this.B = t41Var.C;
            this.C = t41Var.D;
            this.D = t41Var.E;
            this.E = t41Var.F;
            this.F = t41Var.G;
            this.G = t41Var.H;
            this.H = t41Var.I;
            this.I = t41Var.J;
            this.J = t41Var.K;
            this.K = t41Var.L;
            this.L = t41Var.M;
            this.M = t41Var.N;
            this.N = t41Var.O;
            this.O = t41Var.P;
            this.P = t41Var.Q;
        }

        public b A0(String str) {
            this.o = nt2.u(str);
            return this;
        }

        public b B0(int i) {
            this.H = i;
            return this;
        }

        public b C0(int i) {
            this.e = i;
            return this;
        }

        public b D0(int i) {
            this.D = i;
            return this;
        }

        public b E0(long j) {
            this.t = j;
            return this;
        }

        public b F0(int i) {
            this.N = i;
            return this;
        }

        public b G0(int i) {
            this.O = i;
            return this;
        }

        public b H0(int i) {
            this.v = i;
            return this;
        }

        public t41 Q() {
            return new t41(this);
        }

        public b R(int i) {
            this.L = i;
            return this;
        }

        public b S(int i) {
            this.g = i;
            return this;
        }

        public b T(int i) {
            this.h = i;
            return this;
        }

        public b U(int i) {
            this.G = i;
            return this;
        }

        public b V(String str) {
            this.j = str;
            return this;
        }

        public b W(bx bxVar) {
            this.E = bxVar;
            return this;
        }

        public b X(String str) {
            this.n = nt2.u(str);
            return this;
        }

        public b Y(int i) {
            this.P = i;
            return this;
        }

        public b Z(int i) {
            this.M = i;
            return this;
        }

        public b a0(Object obj) {
            this.l = obj;
            return this;
        }

        public b b0(int i) {
            this.y = i;
            return this;
        }

        public b c0(int i) {
            this.x = i;
            return this;
        }

        public b d0(oo0 oo0Var) {
            this.s = oo0Var;
            return this;
        }

        public b e0(int i) {
            this.J = i;
            return this;
        }

        public b f0(int i) {
            this.K = i;
            return this;
        }

        public b g0(float f) {
            this.z = f;
            return this;
        }

        public b h0(boolean z) {
            this.u = z;
            return this;
        }

        public b i0(int i) {
            this.w = i;
            return this;
        }

        public b j0(int i) {
            this.a = Integer.toString(i);
            return this;
        }

        public b k0(String str) {
            this.a = str;
            return this;
        }

        public b l0(List list) {
            this.r = list;
            return this;
        }

        public b m0(String str) {
            this.b = str;
            return this;
        }

        public b n0(List list) {
            this.c = xi1.p(list);
            return this;
        }

        public b o0(String str) {
            this.d = str;
            return this;
        }

        public b p0(int i) {
            this.p = i;
            return this;
        }

        public b q0(int i) {
            this.q = i;
            return this;
        }

        public b r0(int i) {
            this.F = i;
            return this;
        }

        public b s0(xs2 xs2Var) {
            this.k = xs2Var;
            return this;
        }

        public b t0(int i) {
            this.I = i;
            return this;
        }

        public b u0(int i) {
            this.i = i;
            return this;
        }

        public b v0(float f) {
            this.B = f;
            return this;
        }

        public b w0(String str) {
            this.m = str;
            return this;
        }

        public b x0(byte[] bArr) {
            this.C = bArr;
            return this;
        }

        public b y0(int i) {
            this.f = i;
            return this;
        }

        public b z0(int i) {
            this.A = i;
            return this;
        }

        public b() {
            this.c = xi1.u();
            this.h = -1;
            this.i = -1;
            this.p = -1;
            this.q = -1;
            this.t = Long.MAX_VALUE;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1.0f;
            this.B = 1.0f;
            this.D = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.L = -1;
            this.M = 1;
            this.N = -1;
            this.O = -1;
            this.P = 0;
            this.g = 0;
        }
    }
}

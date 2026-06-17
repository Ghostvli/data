package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ph2 {
    public static final ph2 M = new b().L();
    public static final String N = fy4.N0(0);
    public static final String O = fy4.N0(1);
    public static final String P = fy4.N0(2);
    public static final String Q = fy4.N0(3);
    public static final String R = fy4.N0(4);
    public static final String S = fy4.N0(5);
    public static final String T = fy4.N0(6);
    public static final String U = fy4.N0(8);
    public static final String V = fy4.N0(9);
    public static final String W = fy4.N0(10);
    public static final String X = fy4.N0(11);
    public static final String Y = fy4.N0(12);
    public static final String Z = fy4.N0(13);
    public static final String a0 = fy4.N0(14);
    public static final String b0 = fy4.N0(15);
    public static final String c0 = fy4.N0(16);
    public static final String d0 = fy4.N0(17);
    public static final String e0 = fy4.N0(18);
    public static final String f0 = fy4.N0(19);
    public static final String g0 = fy4.N0(20);
    public static final String h0 = fy4.N0(21);
    public static final String i0 = fy4.N0(22);
    public static final String j0 = fy4.N0(23);
    public static final String k0 = fy4.N0(24);
    public static final String l0 = fy4.N0(25);
    public static final String m0 = fy4.N0(26);
    public static final String n0 = fy4.N0(27);
    public static final String o0 = fy4.N0(28);
    public static final String p0 = fy4.N0(29);
    public static final String q0 = fy4.N0(30);
    public static final String r0 = fy4.N0(31);
    public static final String s0 = fy4.N0(32);
    public static final String t0 = fy4.N0(33);
    public static final String u0 = fy4.N0(34);
    public static final String v0 = fy4.N0(1000);
    public final CharSequence A;
    public final CharSequence B;
    public final CharSequence C;
    public final CharSequence D;
    public final Integer E;
    public final Integer F;
    public final CharSequence G;
    public final CharSequence H;
    public final CharSequence I;
    public final Integer J;
    public final Bundle K;
    public final xi1 L;
    public final CharSequence a;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final CharSequence e;
    public final CharSequence f;
    public final CharSequence g;
    public final Long h;
    public final yn3 i;
    public final yn3 j;
    public final byte[] k;
    public lm l;
    public final Integer m;
    public final Uri n;
    public final Integer o;
    public final Integer p;
    public final Integer q;
    public final Boolean r;
    public final Boolean s;
    public final Integer t;
    public final Integer u;
    public final Integer v;
    public final Integer w;
    public final Integer x;
    public final Integer y;
    public final Integer z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ph2(b bVar) {
        Boolean boolValueOf = bVar.r;
        Integer numValueOf = bVar.q;
        Integer numValueOf2 = bVar.I;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                numValueOf = Integer.valueOf(numValueOf2 != null ? d(numValueOf2.intValue()) : 0);
            }
        } else if (numValueOf != null) {
            boolean z = numValueOf.intValue() != -1;
            boolValueOf = Boolean.valueOf(z);
            if (z && numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(e(numValueOf.intValue()));
            }
        }
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = numValueOf;
        this.r = boolValueOf;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        this.C = bVar.B;
        this.D = bVar.C;
        this.E = bVar.D;
        this.F = bVar.E;
        this.G = bVar.F;
        this.H = bVar.G;
        this.I = bVar.H;
        this.J = numValueOf2;
        this.L = bVar.K;
        this.K = bVar.J;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ph2 c(Bundle bundle, int i) {
        Bundle bundle2;
        Bundle bundle3;
        b bVar = new b();
        bVar.s0(bundle.getCharSequence(N)).S(bundle.getCharSequence(O)).R(bundle.getCharSequence(P)).Q(bundle.getCharSequence(Q)).a0(bundle.getCharSequence(R)).q0(bundle.getCharSequence(S)).Y(bundle.getCharSequence(T)).U((Uri) bundle.getParcelable(X)).x0(bundle.getCharSequence(i0)).W(bundle.getCharSequence(j0)).X(bundle.getCharSequence(k0)).e0(bundle.getCharSequence(n0)).V(bundle.getCharSequence(o0)).p0(bundle.getCharSequence(q0)).c0(fy4.y(bundle.getBundle(v0)));
        String str = W;
        if (bundle.containsKey(str)) {
            String str2 = p0;
            Integer numValueOf = bundle.containsKey(str2) ? Integer.valueOf(bundle.getInt(str2)) : null;
            if (i >= 9) {
                Bundle bundle4 = bundle.getBundle(str);
                if (bundle4 != null) {
                    bVar.T(lm.d(bundle4), numValueOf);
                }
            } else {
                bVar.T(bundle.getByteArray(str), numValueOf);
            }
        }
        String str3 = U;
        if (bundle.containsKey(str3) && (bundle3 = bundle.getBundle(str3)) != null) {
            bVar.w0(yn3.a(bundle3));
        }
        String str4 = V;
        if (bundle.containsKey(str4) && (bundle2 = bundle.getBundle(str4)) != null) {
            bVar.i0(yn3.a(bundle2));
        }
        String str5 = t0;
        if (bundle.containsKey(str5)) {
            bVar.b0(Long.valueOf(bundle.getLong(str5)));
        }
        String str6 = Y;
        if (bundle.containsKey(str6)) {
            bVar.v0(Integer.valueOf(bundle.getInt(str6)));
        }
        String str7 = Z;
        if (bundle.containsKey(str7)) {
            bVar.u0(Integer.valueOf(bundle.getInt(str7)));
        }
        String str8 = a0;
        if (bundle.containsKey(str8)) {
            bVar.d0(Integer.valueOf(bundle.getInt(str8)));
        }
        String str9 = s0;
        if (bundle.containsKey(str9)) {
            bVar.f0(Boolean.valueOf(bundle.getBoolean(str9)));
        }
        String str10 = b0;
        if (bundle.containsKey(str10)) {
            bVar.g0(Boolean.valueOf(bundle.getBoolean(str10)));
        }
        String str11 = c0;
        if (bundle.containsKey(str11)) {
            bVar.l0(Integer.valueOf(bundle.getInt(str11)));
        }
        String str12 = d0;
        if (bundle.containsKey(str12)) {
            bVar.k0(Integer.valueOf(bundle.getInt(str12)));
        }
        String str13 = e0;
        if (bundle.containsKey(str13)) {
            bVar.j0(Integer.valueOf(bundle.getInt(str13)));
        }
        String str14 = f0;
        if (bundle.containsKey(str14)) {
            bVar.o0(Integer.valueOf(bundle.getInt(str14)));
        }
        String str15 = g0;
        if (bundle.containsKey(str15)) {
            bVar.n0(Integer.valueOf(bundle.getInt(str15)));
        }
        String str16 = h0;
        if (bundle.containsKey(str16)) {
            bVar.m0(Integer.valueOf(bundle.getInt(str16)));
        }
        String str17 = l0;
        if (bundle.containsKey(str17)) {
            bVar.Z(Integer.valueOf(bundle.getInt(str17)));
        }
        String str18 = m0;
        if (bundle.containsKey(str18)) {
            bVar.t0(Integer.valueOf(bundle.getInt(str18)));
        }
        String str19 = r0;
        if (bundle.containsKey(str19)) {
            bVar.h0(Integer.valueOf(bundle.getInt(str19)));
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(u0);
        if (stringArrayList != null) {
            bVar.r0(stringArrayList);
        }
        return bVar.L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 31:
            case 32:
            case 33:
            case Token.GETPROPNOWARN /* 34 */:
            case 35:
                return 1;
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            default:
                return 0;
            case 21:
                return 2;
            case 22:
                return 3;
            case 23:
                return 4;
            case 24:
                return 5;
            case 25:
                return 6;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 23;
            case 5:
                return 24;
            case 6:
                return 25;
            default:
                return 20;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b b() {
        return new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ph2.class == obj.getClass()) {
            ph2 ph2Var = (ph2) obj;
            if (TextUtils.equals(this.a, ph2Var.a) && TextUtils.equals(this.b, ph2Var.b) && TextUtils.equals(this.c, ph2Var.c) && TextUtils.equals(this.d, ph2Var.d) && TextUtils.equals(this.e, ph2Var.e) && TextUtils.equals(this.f, ph2Var.f) && TextUtils.equals(this.g, ph2Var.g) && Objects.equals(this.h, ph2Var.h) && Objects.equals(this.i, ph2Var.i) && Objects.equals(this.j, ph2Var.j) && Arrays.equals(this.k, ph2Var.k) && Objects.equals(this.m, ph2Var.m) && Objects.equals(this.n, ph2Var.n) && Objects.equals(this.o, ph2Var.o) && Objects.equals(this.p, ph2Var.p) && Objects.equals(this.q, ph2Var.q) && Objects.equals(this.r, ph2Var.r) && Objects.equals(this.s, ph2Var.s) && Objects.equals(this.u, ph2Var.u) && Objects.equals(this.v, ph2Var.v) && Objects.equals(this.w, ph2Var.w) && Objects.equals(this.x, ph2Var.x) && Objects.equals(this.y, ph2Var.y) && Objects.equals(this.z, ph2Var.z) && TextUtils.equals(this.A, ph2Var.A) && TextUtils.equals(this.C, ph2Var.C) && TextUtils.equals(this.D, ph2Var.D) && Objects.equals(this.E, ph2Var.E) && Objects.equals(this.F, ph2Var.F) && TextUtils.equals(this.G, ph2Var.G) && TextUtils.equals(this.H, ph2Var.H) && TextUtils.equals(this.I, ph2Var.I) && Objects.equals(this.J, ph2Var.J) && Objects.equals(this.L, ph2Var.L)) {
                if ((this.K == null) == (ph2Var.K == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle f(int i) {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.a;
        if (charSequence != null) {
            bundle.putCharSequence(N, charSequence);
        }
        CharSequence charSequence2 = this.b;
        if (charSequence2 != null) {
            bundle.putCharSequence(O, charSequence2);
        }
        CharSequence charSequence3 = this.c;
        if (charSequence3 != null) {
            bundle.putCharSequence(P, charSequence3);
        }
        CharSequence charSequence4 = this.d;
        if (charSequence4 != null) {
            bundle.putCharSequence(Q, charSequence4);
        }
        CharSequence charSequence5 = this.e;
        if (charSequence5 != null) {
            bundle.putCharSequence(R, charSequence5);
        }
        CharSequence charSequence6 = this.f;
        if (charSequence6 != null) {
            bundle.putCharSequence(S, charSequence6);
        }
        CharSequence charSequence7 = this.g;
        if (charSequence7 != null) {
            bundle.putCharSequence(T, charSequence7);
        }
        Long l = this.h;
        if (l != null) {
            bundle.putLong(t0, l.longValue());
        }
        byte[] bArr = this.k;
        if (bArr != null) {
            if (i >= 9) {
                if (this.l == null) {
                    this.l = new lm(this.k);
                }
                bundle.putBundle(W, this.l.e());
            } else if (bArr.length <= 500000) {
                bundle.putByteArray(W, bArr);
            }
        }
        Uri uri = this.n;
        if (uri != null) {
            bundle.putParcelable(X, uri);
        }
        CharSequence charSequence8 = this.A;
        if (charSequence8 != null) {
            bundle.putCharSequence(i0, charSequence8);
        }
        CharSequence charSequence9 = this.C;
        if (charSequence9 != null) {
            bundle.putCharSequence(j0, charSequence9);
        }
        CharSequence charSequence10 = this.D;
        if (charSequence10 != null) {
            bundle.putCharSequence(k0, charSequence10);
        }
        CharSequence charSequence11 = this.G;
        if (charSequence11 != null) {
            bundle.putCharSequence(n0, charSequence11);
        }
        CharSequence charSequence12 = this.H;
        if (charSequence12 != null) {
            bundle.putCharSequence(o0, charSequence12);
        }
        CharSequence charSequence13 = this.I;
        if (charSequence13 != null) {
            bundle.putCharSequence(q0, charSequence13);
        }
        yn3 yn3Var = this.i;
        if (yn3Var != null) {
            bundle.putBundle(U, yn3Var.c());
        }
        yn3 yn3Var2 = this.j;
        if (yn3Var2 != null) {
            bundle.putBundle(V, yn3Var2.c());
        }
        Integer num = this.o;
        if (num != null) {
            bundle.putInt(Y, num.intValue());
        }
        Integer num2 = this.p;
        if (num2 != null) {
            bundle.putInt(Z, num2.intValue());
        }
        Integer num3 = this.q;
        if (num3 != null) {
            bundle.putInt(a0, num3.intValue());
        }
        Boolean bool = this.r;
        if (bool != null) {
            bundle.putBoolean(s0, bool.booleanValue());
        }
        Boolean bool2 = this.s;
        if (bool2 != null) {
            bundle.putBoolean(b0, bool2.booleanValue());
        }
        Integer num4 = this.u;
        if (num4 != null) {
            bundle.putInt(c0, num4.intValue());
        }
        Integer num5 = this.v;
        if (num5 != null) {
            bundle.putInt(d0, num5.intValue());
        }
        Integer num6 = this.w;
        if (num6 != null) {
            bundle.putInt(e0, num6.intValue());
        }
        Integer num7 = this.x;
        if (num7 != null) {
            bundle.putInt(f0, num7.intValue());
        }
        Integer num8 = this.y;
        if (num8 != null) {
            bundle.putInt(g0, num8.intValue());
        }
        Integer num9 = this.z;
        if (num9 != null) {
            bundle.putInt(h0, num9.intValue());
        }
        Integer num10 = this.E;
        if (num10 != null) {
            bundle.putInt(l0, num10.intValue());
        }
        Integer num11 = this.F;
        if (num11 != null) {
            bundle.putInt(m0, num11.intValue());
        }
        Integer num12 = this.m;
        if (num12 != null) {
            bundle.putInt(p0, num12.intValue());
        }
        Integer num13 = this.J;
        if (num13 != null) {
            bundle.putInt(r0, num13.intValue());
        }
        if (!this.L.isEmpty()) {
            bundle.putStringArrayList(u0, new ArrayList<>(this.L));
        }
        Bundle bundle2 = this.K;
        if (bundle2 != null) {
            bundle.putBundle(v0, bundle2);
        }
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, Integer.valueOf(Arrays.hashCode(this.k)), this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, Boolean.valueOf(this.K == null), this.L);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public CharSequence A;
        public CharSequence B;
        public CharSequence C;
        public Integer D;
        public Integer E;
        public CharSequence F;
        public CharSequence G;
        public CharSequence H;
        public Integer I;
        public Bundle J;
        public xi1 K;
        public CharSequence a;
        public CharSequence b;
        public CharSequence c;
        public CharSequence d;
        public CharSequence e;
        public CharSequence f;
        public CharSequence g;
        public Long h;
        public yn3 i;
        public yn3 j;
        public byte[] k;
        public lm l;
        public Integer m;
        public Uri n;
        public Integer o;
        public Integer p;
        public Integer q;
        public Boolean r;
        public Boolean s;
        public Integer t;
        public Integer u;
        public Integer v;
        public Integer w;
        public Integer x;
        public Integer y;
        public CharSequence z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(ph2 ph2Var) {
            this.a = ph2Var.a;
            this.b = ph2Var.b;
            this.c = ph2Var.c;
            this.d = ph2Var.d;
            this.e = ph2Var.e;
            this.f = ph2Var.f;
            this.g = ph2Var.g;
            this.h = ph2Var.h;
            this.i = ph2Var.i;
            this.j = ph2Var.j;
            this.k = ph2Var.k;
            this.l = ph2Var.l;
            this.m = ph2Var.m;
            this.n = ph2Var.n;
            this.o = ph2Var.o;
            this.p = ph2Var.p;
            this.q = ph2Var.q;
            this.r = ph2Var.r;
            this.s = ph2Var.s;
            this.t = ph2Var.u;
            this.u = ph2Var.v;
            this.v = ph2Var.w;
            this.w = ph2Var.x;
            this.x = ph2Var.y;
            this.y = ph2Var.z;
            this.z = ph2Var.A;
            this.A = ph2Var.B;
            this.B = ph2Var.C;
            this.C = ph2Var.D;
            this.D = ph2Var.E;
            this.E = ph2Var.F;
            this.F = ph2Var.G;
            this.G = ph2Var.H;
            this.H = ph2Var.I;
            this.I = ph2Var.J;
            this.K = ph2Var.L;
            this.J = ph2Var.K;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ph2 L() {
            return new ph2(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b M(byte[] bArr, int i) {
            if (this.k != null && i != 3 && Objects.equals(this.m, 3)) {
                return this;
            }
            this.k = (byte[]) bArr.clone();
            this.l = null;
            this.m = Integer.valueOf(i);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b N(ph2 ph2Var) {
            if (ph2Var != null) {
                CharSequence charSequence = ph2Var.a;
                if (charSequence != null) {
                    s0(charSequence);
                }
                CharSequence charSequence2 = ph2Var.b;
                if (charSequence2 != null) {
                    S(charSequence2);
                }
                CharSequence charSequence3 = ph2Var.c;
                if (charSequence3 != null) {
                    R(charSequence3);
                }
                CharSequence charSequence4 = ph2Var.d;
                if (charSequence4 != null) {
                    Q(charSequence4);
                }
                CharSequence charSequence5 = ph2Var.e;
                if (charSequence5 != null) {
                    a0(charSequence5);
                }
                CharSequence charSequence6 = ph2Var.f;
                if (charSequence6 != null) {
                    q0(charSequence6);
                }
                CharSequence charSequence7 = ph2Var.g;
                if (charSequence7 != null) {
                    Y(charSequence7);
                }
                Long l = ph2Var.h;
                if (l != null) {
                    b0(l);
                }
                yn3 yn3Var = ph2Var.i;
                if (yn3Var != null) {
                    w0(yn3Var);
                }
                yn3 yn3Var2 = ph2Var.j;
                if (yn3Var2 != null) {
                    i0(yn3Var2);
                }
                Uri uri = ph2Var.n;
                if (uri != null || ph2Var.k != null) {
                    U(uri);
                    T(ph2Var.k, ph2Var.m);
                    this.l = ph2Var.l;
                }
                Integer num = ph2Var.o;
                if (num != null) {
                    v0(num);
                }
                Integer num2 = ph2Var.p;
                if (num2 != null) {
                    u0(num2);
                }
                Integer num3 = ph2Var.q;
                if (num3 != null) {
                    d0(num3);
                }
                Boolean bool = ph2Var.r;
                if (bool != null) {
                    f0(bool);
                }
                Boolean bool2 = ph2Var.s;
                if (bool2 != null) {
                    g0(bool2);
                }
                Integer num4 = ph2Var.t;
                if (num4 != null) {
                    l0(num4);
                }
                Integer num5 = ph2Var.u;
                if (num5 != null) {
                    l0(num5);
                }
                Integer num6 = ph2Var.v;
                if (num6 != null) {
                    k0(num6);
                }
                Integer num7 = ph2Var.w;
                if (num7 != null) {
                    j0(num7);
                }
                Integer num8 = ph2Var.x;
                if (num8 != null) {
                    o0(num8);
                }
                Integer num9 = ph2Var.y;
                if (num9 != null) {
                    n0(num9);
                }
                Integer num10 = ph2Var.z;
                if (num10 != null) {
                    m0(num10);
                }
                CharSequence charSequence8 = ph2Var.A;
                if (charSequence8 != null) {
                    x0(charSequence8);
                }
                CharSequence charSequence9 = ph2Var.C;
                if (charSequence9 != null) {
                    W(charSequence9);
                }
                CharSequence charSequence10 = ph2Var.D;
                if (charSequence10 != null) {
                    X(charSequence10);
                }
                Integer num11 = ph2Var.E;
                if (num11 != null) {
                    Z(num11);
                }
                Integer num12 = ph2Var.F;
                if (num12 != null) {
                    t0(num12);
                }
                CharSequence charSequence11 = ph2Var.G;
                if (charSequence11 != null) {
                    e0(charSequence11);
                }
                CharSequence charSequence12 = ph2Var.H;
                if (charSequence12 != null) {
                    V(charSequence12);
                }
                CharSequence charSequence13 = ph2Var.I;
                if (charSequence13 != null) {
                    p0(charSequence13);
                }
                Integer num13 = ph2Var.J;
                if (num13 != null) {
                    h0(num13);
                }
                Bundle bundle = ph2Var.K;
                if (bundle != null) {
                    c0(bundle);
                }
                if (!ph2Var.L.isEmpty()) {
                    r0(ph2Var.L);
                }
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b O(xs2 xs2Var) {
            for (int i = 0; i < xs2Var.j(); i++) {
                xs2Var.e(i).b(this);
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b P(List list) {
            for (int i = 0; i < list.size(); i++) {
                xs2 xs2Var = (xs2) list.get(i);
                for (int i2 = 0; i2 < xs2Var.j(); i2++) {
                    xs2Var.e(i2).b(this);
                }
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b Q(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b R(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b S(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b T(byte[] bArr, Integer num) {
            this.k = bArr == null ? null : (byte[]) bArr.clone();
            this.l = null;
            this.m = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b U(Uri uri) {
            this.n = uri;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b V(CharSequence charSequence) {
            this.G = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b W(CharSequence charSequence) {
            this.B = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b X(CharSequence charSequence) {
            this.C = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b Y(CharSequence charSequence) {
            this.g = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b Z(Integer num) {
            this.D = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b a0(CharSequence charSequence) {
            this.e = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b0(Long l) {
            gg3.d(l == null || l.longValue() >= 0);
            this.h = l;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c0(Bundle bundle) {
            this.J = bundle;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d0(Integer num) {
            this.q = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e0(CharSequence charSequence) {
            this.F = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f0(Boolean bool) {
            this.r = bool;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b g0(Boolean bool) {
            this.s = bool;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b h0(Integer num) {
            this.I = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b i0(yn3 yn3Var) {
            this.j = yn3Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b j0(Integer num) {
            this.v = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b k0(Integer num) {
            this.u = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b l0(Integer num) {
            this.t = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b m0(Integer num) {
            this.y = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b n0(Integer num) {
            this.x = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b o0(Integer num) {
            this.w = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b p0(CharSequence charSequence) {
            this.H = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b q0(CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b r0(List list) {
            this.K = xi1.p(list);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b s0(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b t0(Integer num) {
            this.E = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b u0(Integer num) {
            this.p = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b v0(Integer num) {
            this.o = num;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b w0(yn3 yn3Var) {
            this.i = yn3Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b x0(CharSequence charSequence) {
            this.z = charSequence;
            return this;
        }

        public b() {
            this.K = xi1.u();
        }
    }
}

package defpackage;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'k' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c01 {
    public static final c01 A;
    public static final c01 B;
    public static final c01 C;
    public static final c01 D;
    public static final c01 E;
    public static final c01 F;
    public static final c01 G;
    public static final c01 H;
    public static final c01 I;
    public static final c01 J;
    public static final c01 K;
    public static final c01 L;
    public static final c01 M;
    public static final c01 N;
    public static final c01 O;
    public static final c01 P;
    public static final c01 Q;
    public static final c01 R;
    public static final c01 S;
    public static final c01 T;
    public static final c01 U;
    public static final c01 V;
    public static final c01 W;
    public static final c01 X;
    public static final c01 Y;
    public static final c01 Z;
    public static final c01 a0;
    public static final c01 b0;
    public static final c01 c0;
    public static final c01 d0;
    public static final c01 e0;
    public static final c01 f0;
    public static final c01 g0;
    public static final c01 h0;
    public static final c01 i0;
    public static final c01[] j0;
    public static final c01 k;
    public static final Type[] k0;
    public static final c01 l;
    public static final /* synthetic */ c01[] l0;
    public static final c01 m;
    public static final c01 n;
    public static final c01 o;
    public static final c01 p;
    public static final c01 q;
    public static final c01 r;
    public static final c01 s;
    public static final c01 t;
    public static final c01 u;
    public static final c01 v;
    public static final c01 w;
    public static final c01 x;
    public static final c01 y;
    public static final c01 z;
    public final hn1 f;
    public final int g;
    public final b h;
    public final Class i;
    public final boolean j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[hn1.values().length];
            a = iArr;
            try {
                iArr[hn1.p.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[hn1.r.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[hn1.o.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);

        public final boolean f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        b(boolean z) {
            this.f = z;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        b bVar = b.SCALAR;
        hn1 hn1Var = hn1.m;
        k = new c01("DOUBLE", 0, 0, bVar, hn1Var);
        hn1 hn1Var2 = hn1.l;
        l = new c01("FLOAT", 1, 1, bVar, hn1Var2);
        hn1 hn1Var3 = hn1.k;
        m = new c01("INT64", 2, 2, bVar, hn1Var3);
        n = new c01("UINT64", 3, 3, bVar, hn1Var3);
        hn1 hn1Var4 = hn1.j;
        o = new c01("INT32", 4, 4, bVar, hn1Var4);
        p = new c01("FIXED64", 5, 5, bVar, hn1Var3);
        q = new c01("FIXED32", 6, 6, bVar, hn1Var4);
        hn1 hn1Var5 = hn1.n;
        r = new c01("BOOL", 7, 7, bVar, hn1Var5);
        hn1 hn1Var6 = hn1.o;
        s = new c01("STRING", 8, 8, bVar, hn1Var6);
        hn1 hn1Var7 = hn1.r;
        t = new c01("MESSAGE", 9, 9, bVar, hn1Var7);
        hn1 hn1Var8 = hn1.p;
        u = new c01("BYTES", 10, 10, bVar, hn1Var8);
        v = new c01("UINT32", 11, 11, bVar, hn1Var4);
        hn1 hn1Var9 = hn1.q;
        w = new c01("ENUM", 12, 12, bVar, hn1Var9);
        x = new c01("SFIXED32", 13, 13, bVar, hn1Var4);
        y = new c01("SFIXED64", 14, 14, bVar, hn1Var3);
        z = new c01("SINT32", 15, 15, bVar, hn1Var4);
        A = new c01("SINT64", 16, 16, bVar, hn1Var3);
        B = new c01("GROUP", 17, 17, bVar, hn1Var7);
        b bVar2 = b.VECTOR;
        C = new c01("DOUBLE_LIST", 18, 18, bVar2, hn1Var);
        D = new c01("FLOAT_LIST", 19, 19, bVar2, hn1Var2);
        E = new c01("INT64_LIST", 20, 20, bVar2, hn1Var3);
        F = new c01("UINT64_LIST", 21, 21, bVar2, hn1Var3);
        G = new c01("INT32_LIST", 22, 22, bVar2, hn1Var4);
        H = new c01("FIXED64_LIST", 23, 23, bVar2, hn1Var3);
        I = new c01("FIXED32_LIST", 24, 24, bVar2, hn1Var4);
        J = new c01("BOOL_LIST", 25, 25, bVar2, hn1Var5);
        K = new c01("STRING_LIST", 26, 26, bVar2, hn1Var6);
        L = new c01("MESSAGE_LIST", 27, 27, bVar2, hn1Var7);
        M = new c01("BYTES_LIST", 28, 28, bVar2, hn1Var8);
        N = new c01("UINT32_LIST", 29, 29, bVar2, hn1Var4);
        O = new c01("ENUM_LIST", 30, 30, bVar2, hn1Var9);
        P = new c01("SFIXED32_LIST", 31, 31, bVar2, hn1Var4);
        Q = new c01("SFIXED64_LIST", 32, 32, bVar2, hn1Var3);
        R = new c01("SINT32_LIST", 33, 33, bVar2, hn1Var4);
        S = new c01("SINT64_LIST", 34, 34, bVar2, hn1Var3);
        b bVar3 = b.PACKED_VECTOR;
        T = new c01("DOUBLE_LIST_PACKED", 35, 35, bVar3, hn1Var);
        U = new c01("FLOAT_LIST_PACKED", 36, 36, bVar3, hn1Var2);
        V = new c01("INT64_LIST_PACKED", 37, 37, bVar3, hn1Var3);
        W = new c01("UINT64_LIST_PACKED", 38, 38, bVar3, hn1Var3);
        X = new c01("INT32_LIST_PACKED", 39, 39, bVar3, hn1Var4);
        Y = new c01("FIXED64_LIST_PACKED", 40, 40, bVar3, hn1Var3);
        Z = new c01("FIXED32_LIST_PACKED", 41, 41, bVar3, hn1Var4);
        a0 = new c01("BOOL_LIST_PACKED", 42, 42, bVar3, hn1Var5);
        b0 = new c01("UINT32_LIST_PACKED", 43, 43, bVar3, hn1Var4);
        c0 = new c01("ENUM_LIST_PACKED", 44, 44, bVar3, hn1Var9);
        d0 = new c01("SFIXED32_LIST_PACKED", 45, 45, bVar3, hn1Var4);
        e0 = new c01("SFIXED64_LIST_PACKED", 46, 46, bVar3, hn1Var3);
        f0 = new c01("SINT32_LIST_PACKED", 47, 47, bVar3, hn1Var4);
        g0 = new c01("SINT64_LIST_PACKED", 48, 48, bVar3, hn1Var3);
        h0 = new c01("GROUP_LIST", 49, 49, bVar2, hn1Var7);
        i0 = new c01("MAP", 50, 50, b.MAP, hn1.i);
        l0 = a();
        k0 = new Type[0];
        c01[] c01VarArrValues = values();
        j0 = new c01[c01VarArrValues.length];
        for (c01 c01Var : c01VarArrValues) {
            j0[c01Var.g] = c01Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c01(String str, int i, int i2, b bVar, hn1 hn1Var) {
        int i3;
        this.g = i2;
        this.h = bVar;
        this.f = hn1Var;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            this.i = hn1Var.b();
        } else {
            this.i = null;
        }
        this.j = (bVar != b.SCALAR || (i3 = a.a[hn1Var.ordinal()]) == 1 || i3 == 2 || i3 == 3) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c01[] a() {
        return new c01[]{k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c01 valueOf(String str) {
        return (c01) Enum.valueOf(c01.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c01[] values() {
        return (c01[]) l0.clone();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        return this.g;
    }
}

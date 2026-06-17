package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.xi1;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dx2 {
    public static final byte[] a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final int b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int[] e;
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
            this.a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = iArr;
            this.f = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final xi1 a;
        public final int[] b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(List list, int[] iArr) {
            this.a = xi1.p(list);
            this.b = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public final xi1 a;
        public final int[] b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(List list, int[] iArr) {
            this.a = xi1.p(list);
            this.b = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final b a;
        public final int b;
        public final c c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final float l;
        public final int m;
        public final int n;
        public final int o;
        public final int p;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(b bVar, int i, c cVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, int i10, int i11, int i12, int i13) {
            this.a = bVar;
            this.b = i;
            this.c = cVar;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.l = f;
            this.m = i10;
            this.n = i11;
            this.o = i12;
            this.p = i13;
            this.j = i8;
            this.k = i9;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i {
        public final int a;
        public final int b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j {
        public final xi1 a;
        public final int[] b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j(List list, int[] iArr) {
            this.a = xi1.p(list);
            this.b = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k {
        public final b a;
        public final xi1 b;
        public final d c;
        public final f d;
        public final j e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(b bVar, List list, d dVar, f fVar, j jVar) {
            this.a = bVar;
            this.b = list != null ? xi1.p(list) : xi1.u();
            this.c = dVar;
            this.d = fVar;
            this.e = jVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class l {
        public final int a;
        public final int b;
        public final boolean c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public l(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class m {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final float h;
        public final int i;
        public final int j;
        public final boolean k;
        public final boolean l;
        public final int m;
        public final int n;
        public final int o;
        public final boolean p;
        public final int q;
        public final int r;
        public final int s;
        public final int t;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public m(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, boolean z, boolean z2, int i10, int i11, int i12, boolean z3, int i13, int i14, int i15, int i16) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = f;
            this.i = i8;
            this.j = i9;
            this.k = z;
            this.l = z2;
            this.m = i10;
            this.n = i11;
            this.o = i12;
            this.p = z3;
            this.q = i13;
            this.r = i14;
            this.s = i15;
            this.t = i16;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r15v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r15v2, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r15v36, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r18v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r18v25, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static k A(s73 s73Var, b bVar) {
        int[] iArr;
        int i2;
        int i3;
        int[] iArr2;
        j jVarY;
        int i4;
        int i5;
        int i6;
        int[] iArr3;
        xi1 xi1Var;
        int i7;
        boolean[][] zArr;
        int[] iArr4;
        int i8;
        int i9;
        s73Var.m(4);
        boolean zE = s73Var.e();
        boolean zE2 = s73Var.e();
        int iF = s73Var.f(6);
        int i10 = iF + 1;
        int iF2 = s73Var.f(3);
        s73Var.m(17);
        c cVarR = r(s73Var, true, iF2, null);
        boolean z = false;
        for (int i11 = s73Var.e() ? 0 : iF2; i11 <= iF2; i11++) {
            s73Var.i();
            s73Var.i();
            s73Var.i();
        }
        int iF3 = s73Var.f(6);
        int i12 = s73Var.i() + 1;
        d dVar = new d(xi1.w(cVarR), new int[1]);
        Object[] objArr = i10 >= 2 && i12 >= 2;
        Object[] objArr2 = zE && zE2;
        int i13 = iF3 + 1;
        Object[] objArr3 = i13 >= i10;
        if (objArr != true || objArr2 != true || objArr3 != true) {
            return new k(bVar, null, dVar, null, null);
        }
        Class cls = Integer.TYPE;
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) cls, i12, i13);
        int i14 = 1;
        int[] iArr6 = new int[i12];
        int[] iArr7 = new int[i12];
        iArr5[0][0] = 0;
        iArr6[0] = 1;
        iArr7[0] = 0;
        for (int i15 = 1; i15 < i12; i15++) {
            int i16 = 0;
            for (int i17 = 0; i17 <= iF3; i17++) {
                if (s73Var.e()) {
                    iArr5[i15][i16] = i17;
                    iArr7[i15] = i17;
                    i16++;
                }
                iArr6[i15] = i16;
            }
        }
        if (s73Var.e()) {
            s73Var.m(64);
            if (s73Var.e()) {
                s73Var.i();
            }
            int i18 = s73Var.i();
            int i19 = 0;
            while (i19 < i18) {
                s73Var.i();
                if (i19 == 0 || s73Var.e()) {
                    z = true;
                }
                G(s73Var, z, iF2);
                i19++;
                z = false;
            }
        }
        if (!s73Var.e()) {
            return new k(bVar, null, dVar, null, null);
        }
        s73Var.b();
        c cVarR2 = r(s73Var, false, iF2, cVarR);
        boolean zE3 = s73Var.e();
        int i20 = 6;
        boolean[] zArr2 = new boolean[16];
        int i21 = 0;
        for (int i22 = 0; i22 < 16; i22++) {
            boolean zE4 = s73Var.e();
            zArr2[i22] = zE4;
            if (zE4) {
                i21++;
            }
        }
        if (i21 == 0 || !zArr2[1]) {
            return new k(bVar, null, dVar, null, null);
        }
        int[] iArr8 = new int[i21];
        for (int i23 = 0; i23 < i21 - (zE3 ? 1 : 0); i23++) {
            iArr8[i23] = s73Var.f(3);
        }
        int[] iArr9 = new int[i21 + 1];
        if (zE3) {
            int i24 = 1;
            while (i24 < i21) {
                int[] iArr10 = iArr9;
                for (int i25 = 0; i25 < i24; i25++) {
                    iArr10[i24] = iArr10[i24] + iArr8[i25] + 1;
                }
                i24++;
                iArr9 = iArr10;
            }
            iArr = iArr9;
            iArr[i21] = 6;
        } else {
            iArr = iArr9;
        }
        int[][] iArr11 = (int[][]) Array.newInstance((Class<?>) cls, i10, i21);
        int[] iArr12 = new int[i10];
        iArr12[0] = 0;
        boolean zE5 = s73Var.e();
        int i26 = 1;
        while (i26 < i10) {
            if (zE5) {
                i9 = i26;
                iArr12[i9] = s73Var.f(i20);
            } else {
                i9 = i26;
                iArr12[i9] = i9;
            }
            if (zE3) {
                for (int i27 = 0; i27 < i21; i27++) {
                    iArr11[i9][i27] = (iArr12[i9] & ((1 << iArr[r33]) - 1)) >> iArr[i27];
                }
            } else {
                int i28 = 0;
                while (i28 < i21) {
                    int i29 = i28;
                    iArr11[i9][i29] = s73Var.f(iArr8[i28] + 1);
                    i28 = i29 + 1;
                }
            }
            i26 = i9 + 1;
            i20 = 6;
        }
        int[] iArr13 = new int[i13];
        int i30 = 1;
        int i31 = 0;
        while (i31 < i10) {
            iArr13[iArr12[i31]] = -1;
            int[] iArr14 = iArr13;
            int i32 = 0;
            int i33 = 0;
            while (i32 < 16) {
                if (zArr2[i32]) {
                    if (i32 == i14) {
                        iArr14[iArr12[i31]] = iArr11[i31][i33];
                    }
                    i33++;
                }
                i32++;
                i14 = 1;
            }
            if (i31 > 0) {
                int i34 = 0;
                while (true) {
                    if (i34 >= i31) {
                        i30++;
                        break;
                    }
                    int i35 = i34;
                    if (iArr14[iArr12[i31]] == iArr14[iArr12[i34]]) {
                        break;
                    }
                    i34 = i35 + 1;
                }
            }
            i31++;
            iArr13 = iArr14;
            i14 = 1;
        }
        int[] iArr15 = iArr13;
        int iF4 = s73Var.f(4);
        if (i30 < 2 || iF4 == 0) {
            return new k(bVar, null, dVar, null, null);
        }
        int[] iArr16 = new int[i30];
        for (int i36 = 0; i36 < i30; i36++) {
            iArr16[i36] = s73Var.f(iF4);
        }
        int[] iArr17 = new int[i13];
        int i37 = 0;
        while (i37 < i10) {
            int[] iArr18 = iArr17;
            iArr18[Math.min(iArr12[i37], iF3)] = i37;
            i37++;
            iArr17 = iArr18;
        }
        int[] iArr19 = iArr17;
        xi1.a aVarM = xi1.m();
        int i38 = 0;
        while (i38 <= iF3) {
            int i39 = i30;
            int[] iArr20 = iArr7;
            int iMin = Math.min(iArr15[i38], i39 - 1);
            aVarM.a(new a(iArr19[i38], iMin >= 0 ? iArr16[iMin] : -1));
            i38++;
            i30 = i39;
            iArr7 = iArr20;
            iArr16 = iArr16;
        }
        int[] iArr21 = iArr7;
        xi1 xi1VarK = aVarM.k();
        if (((a) xi1VarK.get(0)).b == -1) {
            return new k(bVar, null, dVar, null, null);
        }
        int i40 = 1;
        while (true) {
            if (i40 > iF3) {
                i2 = -1;
                i3 = -1;
                break;
            }
            i2 = -1;
            if (((a) xi1VarK.get(i40)).b != -1) {
                i3 = i40;
                break;
            }
            i40++;
        }
        if (i3 == i2) {
            return new k(bVar, null, dVar, null, null);
        }
        Class cls2 = Boolean.TYPE;
        boolean[][] zArr3 = (boolean[][]) Array.newInstance((Class<?>) cls2, i10, i10);
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) cls2, i10, i10);
        int i41 = 1;
        while (i41 < i10) {
            boolean[][] zArr5 = zArr4;
            for (int i42 = 0; i42 < i41; i42++) {
                boolean[] zArr6 = zArr3[i41];
                boolean[] zArr7 = zArr5[i41];
                boolean zE6 = s73Var.e();
                zArr7[i42] = zE6;
                zArr6[i42] = zE6;
            }
            i41++;
            zArr4 = zArr5;
        }
        boolean[][] zArr8 = zArr4;
        for (int i43 = 1; i43 < i10; i43++) {
            int i44 = 0;
            while (i44 < iF) {
                int[] iArr22 = iArr12;
                int i45 = 0;
                while (true) {
                    if (i45 < i43) {
                        boolean[] zArr9 = zArr8[i43];
                        if (zArr9[i45] && zArr8[i45][i44]) {
                            zArr9[i44] = true;
                            break;
                        }
                        i45++;
                    }
                }
                i44++;
                iArr12 = iArr22;
            }
        }
        int[] iArr23 = iArr12;
        int[] iArr24 = new int[i13];
        for (int i46 = 0; i46 < i10; i46++) {
            int i47 = 0;
            for (int i48 = 0; i48 < i46; i48++) {
                i47 += zArr3[i46][i48] ? 1 : 0;
            }
            iArr24[iArr23[i46]] = i47;
        }
        int i49 = 0;
        for (int i50 = 0; i50 < i10; i50++) {
            if (iArr24[iArr23[i50]] == 0) {
                i49++;
            }
        }
        if (i49 > 1) {
            return new k(bVar, null, dVar, null, null);
        }
        int[] iArr25 = new int[i10];
        int[] iArr26 = new int[i12];
        if (s73Var.e()) {
            iArr2 = iArr24;
            int i51 = 0;
            while (i51 < i10) {
                int i52 = i51;
                iArr25[i52] = s73Var.f(3);
                i51 = i52 + 1;
            }
        } else {
            iArr2 = iArr24;
            Arrays.fill(iArr25, 0, i10, iF2);
        }
        int i53 = 0;
        while (i53 < i12) {
            int i54 = i53;
            boolean[][] zArr10 = zArr3;
            int[] iArr27 = iArr25;
            int iMax = 0;
            for (int i55 = 0; i55 < iArr6[i54]; i55++) {
                iMax = Math.max(iMax, iArr27[((a) xi1VarK.get(iArr5[i54][i55])).a]);
            }
            iArr26[i54] = iMax + 1;
            i53 = i54 + 1;
            iArr25 = iArr27;
            zArr3 = zArr10;
        }
        boolean[][] zArr11 = zArr3;
        if (s73Var.e()) {
            int i56 = 0;
            while (i56 < iF) {
                int i57 = i56 + 1;
                int i58 = i57;
                while (i58 < i10) {
                    if (zArr11[i58][i56]) {
                        i8 = i56;
                        s73Var.m(3);
                    } else {
                        i8 = i56;
                    }
                    i58++;
                    i56 = i8;
                }
                i56 = i57;
            }
        }
        s73Var.l();
        int i59 = s73Var.i() + 1;
        xi1.a aVarM2 = xi1.m();
        aVarM2.a(cVarR);
        if (i59 > 1) {
            aVarM2.a(cVarR2);
            for (int i60 = 2; i60 < i59; i60++) {
                cVarR2 = r(s73Var, s73Var.e(), iF2, cVarR2);
                aVarM2.a(cVarR2);
            }
        }
        xi1 xi1VarK2 = aVarM2.k();
        int i61 = s73Var.i() + i12;
        if (i61 > i12) {
            return new k(bVar, null, dVar, null, null);
        }
        int iF5 = s73Var.f(2);
        boolean[][] zArr12 = (boolean[][]) Array.newInstance((Class<?>) cls2, i61, i13);
        int[] iArr28 = new int[i61];
        int i62 = 0;
        int[] iArr29 = new int[i61];
        int i63 = 0;
        while (i63 < i12) {
            iArr28[i63] = i62;
            iArr29[i63] = iArr21[i63];
            if (iF5 == 0) {
                i7 = i63;
                zArr = zArr12;
                xi1Var = xi1VarK2;
                iArr4 = iArr28;
                Arrays.fill(zArr12[i7], i62, iArr6[i7], true);
                iArr4[i7] = iArr6[i7];
            } else {
                xi1Var = xi1VarK2;
                i7 = i63;
                zArr = zArr12;
                iArr4 = iArr28;
                if (iF5 == 1) {
                    int i64 = iArr21[i7];
                    for (int i65 = 0; i65 < iArr6[i7]; i65++) {
                        zArr[i7][i65] = iArr5[i7][i65] == i64;
                    }
                    iArr4[i7] = 1;
                } else {
                    i62 = 0;
                    zArr[0][0] = true;
                    iArr4[0] = 1;
                    i63 = i7 + 1;
                    zArr12 = zArr;
                    iArr28 = iArr4;
                    xi1VarK2 = xi1Var;
                }
            }
            i62 = 0;
            i63 = i7 + 1;
            zArr12 = zArr;
            iArr28 = iArr4;
            xi1VarK2 = xi1Var;
        }
        xi1 xi1Var2 = xi1VarK2;
        boolean[][] zArr13 = zArr12;
        int[] iArr30 = iArr28;
        int[] iArr31 = new int[i13];
        int i66 = 2;
        int[] iArr32 = new int[2];
        iArr32[1] = i13;
        iArr32[i62] = i61;
        boolean[][] zArr14 = (boolean[][]) Array.newInstance((Class<?>) cls2, iArr32);
        int i67 = 1;
        int i68 = 0;
        while (i67 < i61) {
            if (iF5 == i66) {
                for (int i69 = 0; i69 < iArr6[i67]; i69++) {
                    zArr13[i67][i69] = s73Var.e();
                    int i70 = iArr30[i67];
                    boolean z2 = zArr13[i67][i69];
                    iArr30[i67] = i70 + (z2 ? 1 : 0);
                    if (z2) {
                        iArr29[i67] = iArr5[i67][i69];
                    }
                }
            }
            if (i68 == 0) {
                i4 = 0;
                if (iArr5[i67][0] == 0 && zArr13[i67][0]) {
                    for (int i71 = 1; i71 < iArr6[i67]; i71++) {
                        if (iArr5[i67][i71] == i3 && zArr13[i67][i3]) {
                            i68 = i67;
                        }
                    }
                }
            } else {
                i4 = 0;
            }
            int i72 = i4;
            while (i72 < iArr6[i67]) {
                if (i59 > 1) {
                    zArr14[i67][i72] = zArr13[i67][i72];
                    i6 = i3;
                    iArr3 = iArr31;
                    i5 = i59;
                    int iD = dn0.d(i59, RoundingMode.CEILING);
                    if (!zArr14[i67][i72]) {
                        int i73 = ((a) xi1VarK.get(iArr5[i67][i72])).a;
                        int i74 = i4;
                        while (true) {
                            if (i74 >= i72) {
                                break;
                            }
                            int i75 = i73;
                            if (zArr8[i75][((a) xi1VarK.get(iArr5[i67][i74])).a]) {
                                zArr14[i67][i72] = true;
                                break;
                            }
                            i74++;
                            i73 = i75;
                        }
                    }
                    if (zArr14[i67][i72]) {
                        if (i68 <= 0 || i67 != i68) {
                            s73Var.m(iD);
                        } else {
                            iArr3[i72] = s73Var.f(iD);
                        }
                    }
                } else {
                    i5 = i59;
                    i6 = i3;
                    iArr3 = iArr31;
                }
                i72++;
                i3 = i6;
                iArr31 = iArr3;
                i59 = i5;
            }
            int i76 = i59;
            int i77 = i3;
            int[] iArr33 = iArr31;
            if (iArr30[i67] == 1 && iArr2[iArr29[i67]] > 0) {
                s73Var.l();
            }
            i67++;
            i3 = i77;
            iArr31 = iArr33;
            i59 = i76;
            i66 = 2;
        }
        int[] iArr34 = iArr31;
        if (i68 == 0) {
            return new k(bVar, null, dVar, null, null);
        }
        f fVarT = t(s73Var, i10);
        s73Var.m(2);
        for (int i78 = 1; i78 < i10; i78++) {
            if (iArr2[iArr23[i78]] == 0) {
                s73Var.l();
            }
        }
        F(s73Var, i61, iArr26, iArr6, zArr14);
        L(s73Var, i10, zArr11);
        if (s73Var.e()) {
            s73Var.b();
            jVarY = y(s73Var, i10, i12, iArr26);
        } else {
            jVarY = null;
        }
        return new k(bVar, xi1VarK, new d(xi1Var2, iArr34), fVarT, jVarY);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static l B(byte[] bArr, int i2, int i3) {
        return C(bArr, i2 + 1, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static l C(byte[] bArr, int i2, int i3) {
        s73 s73Var = new s73(bArr, i2, i3);
        int i4 = s73Var.i();
        int i5 = s73Var.i();
        s73Var.l();
        return new l(i4, i5, s73Var.e());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static m D(byte[] bArr, int i2, int i3) {
        return E(bArr, i2 + 1, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static m E(byte[] bArr, int i2, int i3) {
        int i4;
        boolean zE;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        float f2;
        int i14;
        int i15;
        int i16;
        boolean z2;
        int i17;
        int i18;
        int i19;
        boolean zE2;
        boolean zE3;
        int i20;
        int i21;
        s73 s73Var = new s73(bArr, i2, i3);
        int iF = s73Var.f(8);
        int iF2 = s73Var.f(8);
        int iF3 = s73Var.f(8);
        int i22 = s73Var.i();
        if (iF == 100 || iF == 110 || iF == 122 || iF == 244 || iF == 44 || iF == 83 || iF == 86 || iF == 118 || iF == 128 || iF == 138) {
            i4 = s73Var.i();
            zE = i4 == 3 ? s73Var.e() : false;
            i5 = s73Var.i();
            int i23 = s73Var.i();
            s73Var.l();
            if (s73Var.e()) {
                int i24 = i4 != 3 ? 8 : 12;
                i6 = 16;
                int i25 = 0;
                while (i25 < i24) {
                    if (s73Var.e()) {
                        K(s73Var, i25 < 6 ? 16 : 64);
                    }
                    i25++;
                }
            } else {
                i6 = 16;
            }
            i7 = i23;
        } else {
            i4 = 1;
            i6 = 16;
            i7 = 0;
            zE = false;
            i5 = 0;
        }
        int i26 = s73Var.i() + 4;
        int i27 = s73Var.i();
        if (i27 == 0) {
            i10 = s73Var.i() + 4;
            i8 = iF;
            i9 = i27;
            z = false;
        } else {
            if (i27 == 1) {
                boolean zE4 = s73Var.e();
                s73Var.h();
                s73Var.h();
                i8 = iF;
                long jI = s73Var.i();
                i9 = i27;
                for (int i28 = 0; i28 < jI; i28++) {
                    s73Var.i();
                }
                z = zE4;
            } else {
                i8 = iF;
                i9 = i27;
                z = false;
            }
            i10 = 0;
        }
        int i29 = s73Var.i();
        s73Var.l();
        int i30 = s73Var.i() + 1;
        int i31 = s73Var.i() + 1;
        boolean zE5 = s73Var.e();
        int i32 = (2 - (zE5 ? 1 : 0)) * i31;
        if (!zE5) {
            s73Var.l();
        }
        s73Var.l();
        int i33 = i30 * 16;
        int i34 = i32 * 16;
        if (s73Var.e()) {
            int i35 = s73Var.i();
            int i36 = s73Var.i();
            int i37 = s73Var.i();
            int i38 = s73Var.i();
            if (i4 == 0) {
                i21 = 2 - (zE5 ? 1 : 0);
                i20 = 1;
            } else {
                i20 = i4 == 3 ? 1 : 2;
                i21 = (i4 == 1 ? 2 : 1) * (2 - (zE5 ? 1 : 0));
            }
            i33 -= (i35 + i36) * i20;
            i34 -= (i37 + i38) * i21;
        }
        int i39 = i33;
        int i40 = i8;
        int i41 = ((i40 == 44 || i40 == 86 || i40 == 100 || i40 == 110 || i40 == 122 || i40 == 244) && (iF2 & 16) != 0) ? 0 : i6;
        float f3 = 1.0f;
        if (s73Var.e()) {
            if (s73Var.e()) {
                int iF4 = s73Var.f(8);
                if (iF4 == 255) {
                    int i42 = i6;
                    int iF5 = s73Var.f(i42);
                    int iF6 = s73Var.f(i42);
                    if (iF5 != 0 && iF6 != 0) {
                        f3 = iF5 / iF6;
                    }
                } else {
                    float[] fArr = b;
                    if (iF4 < fArr.length) {
                        f3 = fArr[iF4];
                    } else {
                        xz1.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iF4);
                    }
                }
            }
            if (s73Var.e()) {
                s73Var.l();
            }
            if (s73Var.e()) {
                s73Var.m(3);
                i18 = s73Var.e() ? 1 : 2;
                if (s73Var.e()) {
                    int iF7 = s73Var.f(8);
                    int iF8 = s73Var.f(8);
                    s73Var.m(8);
                    int iK = bx.k(iF7);
                    int iL = bx.l(iF8);
                    i19 = iK;
                    i17 = iL;
                    if (s73Var.e()) {
                        s73Var.i();
                        s73Var.i();
                    }
                    if (s73Var.e()) {
                        s73Var.m(65);
                    }
                    zE2 = s73Var.e();
                    if (zE2) {
                        J(s73Var);
                    }
                    zE3 = s73Var.e();
                    if (zE3) {
                        J(s73Var);
                    }
                    if (!zE2 || zE3) {
                        s73Var.l();
                    }
                    s73Var.l();
                    if (s73Var.e()) {
                        s73Var.l();
                        s73Var.i();
                        s73Var.i();
                        s73Var.i();
                        s73Var.i();
                        i41 = s73Var.i();
                        s73Var.i();
                    }
                    i16 = i17;
                    i15 = i18;
                    i11 = i41;
                    i12 = i5;
                    i13 = i10;
                    f2 = f3;
                    z2 = z;
                    i14 = i19;
                } else {
                    i17 = -1;
                }
            } else {
                i17 = -1;
                i18 = -1;
            }
            i19 = -1;
            if (s73Var.e()) {
            }
            if (s73Var.e()) {
            }
            zE2 = s73Var.e();
            if (zE2) {
            }
            zE3 = s73Var.e();
            if (zE3) {
            }
            if (!zE2) {
                s73Var.l();
                s73Var.l();
                if (s73Var.e()) {
                }
                i16 = i17;
                i15 = i18;
                i11 = i41;
                i12 = i5;
                i13 = i10;
                f2 = f3;
                z2 = z;
                i14 = i19;
            }
        } else {
            i11 = i41;
            i12 = i5;
            i13 = i10;
            f2 = 1.0f;
            i14 = -1;
            i15 = -1;
            i16 = -1;
            z2 = z;
        }
        return new m(i40, iF2, iF3, i22, i29, i39, i34, f2, i12, i7, zE, zE5, i26, i9, i13, z2, i14, i15, i16, i11);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void F(s73 s73Var, int i2, int[] iArr, int[] iArr2, boolean[][] zArr) {
        for (int i3 = 1; i3 < i2; i3++) {
            boolean zE = s73Var.e();
            int i4 = 0;
            while (i4 < iArr[i3]) {
                if ((i4 <= 0 || !zE) ? i4 == 0 : s73Var.e()) {
                    for (int i5 = 0; i5 < iArr2[i3]; i5++) {
                        if (zArr[i3][i5]) {
                            s73Var.i();
                        }
                    }
                    s73Var.i();
                    s73Var.i();
                }
                i4++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static void G(s73 s73Var, boolean z, int i2) {
        ?? r9;
        ?? r1;
        boolean zE;
        boolean zE2;
        if (z) {
            boolean zE3 = s73Var.e();
            boolean zE4 = s73Var.e();
            if (zE3 || zE4) {
                zE = s73Var.e();
                if (zE) {
                    s73Var.m(19);
                }
                s73Var.m(8);
                if (zE) {
                    s73Var.m(4);
                }
                s73Var.m(15);
                r1 = zE4;
                r9 = zE3;
            } else {
                zE = false;
                r1 = zE4;
                r9 = zE3;
            }
        } else {
            r9 = 0;
            r1 = 0;
            zE = false;
        }
        for (int i3 = 0; i3 <= i2; i3++) {
            boolean zE5 = s73Var.e();
            if (!zE5) {
                zE5 = s73Var.e();
            }
            if (zE5) {
                s73Var.i();
                zE2 = false;
            } else {
                zE2 = s73Var.e();
            }
            int i4 = !zE2 ? s73Var.i() : 0;
            int i5 = r9 + r1;
            for (int i6 = 0; i6 < i5; i6++) {
                for (int i7 = 0; i7 <= i4; i7++) {
                    s73Var.i();
                    s73Var.i();
                    if (zE) {
                        s73Var.i();
                        s73Var.i();
                    }
                    s73Var.l();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void H(s73 s73Var) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (s73Var.e()) {
                    int iMin = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        s73Var.h();
                    }
                    for (int i5 = 0; i5 < iMin; i5++) {
                        s73Var.h();
                    }
                } else {
                    s73Var.i();
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void I(s73 s73Var) {
        int i2 = s73Var.i();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i5 == 0 || !s73Var.e()) {
                int i6 = s73Var.i();
                int i7 = s73Var.i();
                int[] iArr2 = new int[i6];
                int i8 = 0;
                while (i8 < i6) {
                    iArr2[i8] = (i8 > 0 ? iArr2[i8 - 1] : 0) - (s73Var.i() + 1);
                    s73Var.l();
                    i8++;
                }
                int[] iArr3 = new int[i7];
                int i9 = 0;
                while (i9 < i7) {
                    iArr3[i9] = (i9 > 0 ? iArr3[i9 - 1] : 0) + s73Var.i() + 1;
                    s73Var.l();
                    i9++;
                }
                i3 = i6;
                iArr = iArr2;
                i4 = i7;
                iArrCopyOf = iArr3;
            } else {
                int i10 = i3 + i4;
                int i11 = (1 - ((s73Var.e() ? 1 : 0) * 2)) * (s73Var.i() + 1);
                int i12 = i10 + 1;
                boolean[] zArr = new boolean[i12];
                for (int i13 = 0; i13 <= i10; i13++) {
                    if (s73Var.e()) {
                        zArr[i13] = true;
                    } else {
                        zArr[i13] = s73Var.e();
                    }
                }
                int[] iArr4 = new int[i12];
                int[] iArr5 = new int[i12];
                int i14 = 0;
                for (int i15 = i4 - 1; i15 >= 0; i15--) {
                    int i16 = iArrCopyOf[i15] + i11;
                    if (i16 < 0 && zArr[i3 + i15]) {
                        iArr4[i14] = i16;
                        i14++;
                    }
                }
                if (i11 < 0 && zArr[i10]) {
                    iArr4[i14] = i11;
                    i14++;
                }
                for (int i17 = 0; i17 < i3; i17++) {
                    int i18 = iArr[i17] + i11;
                    if (i18 < 0 && zArr[i17]) {
                        iArr4[i14] = i18;
                        i14++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i14);
                int i19 = 0;
                for (int i20 = i3 - 1; i20 >= 0; i20--) {
                    int i21 = iArr[i20] + i11;
                    if (i21 > 0 && zArr[i20]) {
                        iArr5[i19] = i21;
                        i19++;
                    }
                }
                if (i11 > 0 && zArr[i10]) {
                    iArr5[i19] = i11;
                    i19++;
                }
                for (int i22 = 0; i22 < i4; i22++) {
                    int i23 = iArrCopyOf[i22] + i11;
                    if (i23 > 0 && zArr[i3 + i22]) {
                        iArr5[i19] = i23;
                        i19++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i19);
                iArr = iArrCopyOf2;
                i3 = i14;
                i4 = i19;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void J(s73 s73Var) {
        int i2 = s73Var.i() + 1;
        s73Var.m(8);
        for (int i3 = 0; i3 < i2; i3++) {
            s73Var.i();
            s73Var.i();
            s73Var.l();
        }
        s73Var.m(20);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void K(s73 s73Var, int i2) {
        int iH = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i2; i4++) {
            if (iH != 0) {
                iH = ((s73Var.h() + i3) + Buffer.DEFAULT_SIZE) % Buffer.DEFAULT_SIZE;
            }
            if (iH != 0) {
                i3 = iH;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void L(s73 s73Var, int i2, boolean[][] zArr) {
        int i3 = s73Var.i() + 2;
        if (s73Var.e()) {
            s73Var.m(i3);
        } else {
            for (int i4 = 1; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (zArr[i4][i5]) {
                        s73Var.m(i3);
                    }
                }
            }
        }
        int i6 = s73Var.i();
        for (int i7 = 1; i7 <= i6; i7++) {
            s73Var.m(8);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M(byte[] bArr, int i2) {
        int i3;
        synchronized (c) {
            int iG = 0;
            int i4 = 0;
            while (iG < i2) {
                try {
                    iG = g(bArr, iG, i2);
                    if (iG < i2) {
                        int[] iArr = d;
                        if (iArr.length <= i4) {
                            d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        d[i4] = iG;
                        iG += 3;
                        i4++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i3 = i2 - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i3 - i5);
        }
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i2, int i3, int i4, int i5) {
        return i2 - ((i3 == 1 ? 2 : 1) * (i4 + i5));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(int i2, int i3, int i4, int i5) {
        int i6 = 2;
        if (i3 != 1 && i3 != 2) {
            i6 = 1;
        }
        return i2 - (i6 * (i4 + i5));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(s73 s73Var) {
        s73Var.m(4);
        int iF = s73Var.f(3);
        s73Var.l();
        c cVarR = r(s73Var, true, iF, null);
        return gv.i(cVarR.a, cVarR.b, cVarR.c, cVarR.d, cVarR.e, cVarR.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(byte[] bArr, int i2, int i3, boolean[] zArr) {
        int i4 = i3 - i2;
        gg3.v(i4 >= 0);
        if (i4 == 0) {
            return i3;
        }
        if (zArr[0]) {
            c(zArr);
            return i2 - 3;
        }
        if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
            c(zArr);
            return i2 - 2;
        }
        if (i4 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
            c(zArr);
            return i2 - 1;
        }
        int i5 = i3 - 1;
        int i6 = i2 + 2;
        while (i6 < i5) {
            byte b2 = bArr[i6];
            if ((b2 & 254) == 0) {
                int i7 = i6 - 2;
                if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && b2 == 1) {
                    c(zArr);
                    return i7;
                }
                i6 -= 2;
            }
            i6 += 3;
        }
        zArr[0] = i4 <= 2 ? !(i4 != 2 ? !(zArr[1] && bArr[i5] == 1) : !(zArr[2] && bArr[i3 + (-2)] == 0 && bArr[i5] == 1)) : bArr[i3 + (-3)] == 0 && bArr[i3 + (-2)] == 0 && bArr[i5] == 1;
        zArr[1] = i4 <= 1 ? zArr[2] && bArr[i5] == 0 : bArr[i3 + (-2)] == 0 && bArr[i5] == 0;
        zArr[2] = bArr[i5] == 0;
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 f(byte[] bArr) {
        boolean[] zArr = new boolean[3];
        xi1.a aVarM = xi1.m();
        int i2 = 0;
        while (i2 < bArr.length) {
            int iE = e(bArr, i2, bArr.length, zArr);
            if (iE != bArr.length) {
                aVarM.a(Integer.valueOf(iE));
            }
            i2 = iE + 3;
        }
        return aVarM.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String h(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            byte[] bArr = (byte[]) list.get(i2);
            int length = bArr.length;
            if (length > 3) {
                xi1 xi1VarF = f(bArr);
                for (int i3 = 0; i3 < xi1VarF.size(); i3++) {
                    if (((Integer) xi1VarF.get(i3)).intValue() + 3 < length) {
                        s73 s73Var = new s73(bArr, ((Integer) xi1VarF.get(i3)).intValue() + 3, length);
                        b bVarQ = q(s73Var);
                        if (bVarQ.a == 33 && bVarQ.b == 0) {
                            return d(s73Var);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(t41 t41Var) {
        String str;
        if (Objects.equals(t41Var.p, "video/dolby-vision") && (str = t41Var.k) != null) {
            if (str.startsWith("dva1") || t41Var.k.startsWith("dvav")) {
                return "video/avc";
            }
            if (t41Var.k.startsWith("dvh1") || t41Var.k.startsWith("dvhe")) {
                return "video/hevc";
            }
        }
        return t41Var.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean l(byte[] bArr, int i2, int i3, t41 t41Var) {
        if (Objects.equals(t41Var.p, "video/avc")) {
            return m(bArr[i2]);
        }
        if (Objects.equals(t41Var.p, "video/hevc")) {
            return n(bArr, i2, i3, t41Var);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m(byte b2) {
        if (((b2 & 96) >> 5) != 0) {
            return true;
        }
        int i2 = b2 & 31;
        return (i2 == 1 || i2 == 9 || i2 == 14) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean n(byte[] bArr, int i2, int i3, t41 t41Var) {
        b bVarQ = q(new s73(bArr, i2, i3 + i2));
        int i4 = bVarQ.a;
        if (i4 == 35) {
            return false;
        }
        return (i4 <= 14 && i4 % 2 == 0 && bVarQ.c == t41Var.G - 1) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean o(t41 t41Var, byte[] bArr, int i2) {
        String strJ = j(t41Var);
        if (strJ == null) {
            return false;
        }
        switch (strJ) {
            case "video/hevc":
                if (((bArr[i2] & 126) >> 1) == 39) {
                }
                break;
            case "video/avc":
                if ((bArr[i2] & 31) == 6) {
                }
                break;
            case "video/vvc":
                if (((bArr[i2 + 1] & 248) >> 3) == 23) {
                }
                break;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(t41 t41Var) {
        String strJ = j(t41Var);
        if (Objects.equals(strJ, "video/avc")) {
            return 1;
        }
        return (Objects.equals(strJ, "video/hevc") || Objects.equals(strJ, "video/vvc")) ? 2 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b q(s73 s73Var) {
        s73Var.l();
        return new b(s73Var.f(6), s73Var.f(6), s73Var.f(3) - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c r(s73 s73Var, boolean z, int i2, c cVar) {
        int[] iArr;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean zE;
        int iF;
        int i6;
        int[] iArr2 = new int[6];
        if (z) {
            int iF2 = s73Var.f(2);
            zE = s73Var.e();
            iF = s73Var.f(5);
            i6 = 0;
            for (int i7 = 0; i7 < 32; i7++) {
                if (s73Var.e()) {
                    i6 |= 1 << i7;
                }
            }
            for (int i8 = 0; i8 < 6; i8++) {
                iArr2[i8] = s73Var.f(8);
            }
            i3 = iF2;
        } else {
            if (cVar == null) {
                iArr = iArr2;
                i3 = 0;
                z2 = false;
                i4 = 0;
                i5 = 0;
                int iF3 = s73Var.f(8);
                int i9 = 0;
                for (int i10 = 0; i10 < i2; i10++) {
                    if (s73Var.e()) {
                        i9 += 88;
                    }
                    if (s73Var.e()) {
                        i9 += 8;
                    }
                }
                s73Var.m(i9);
                if (i2 > 0) {
                    s73Var.m((8 - i2) * 2);
                }
                return new c(i3, z2, i4, i5, iArr, iF3);
            }
            int i11 = cVar.a;
            zE = cVar.b;
            iF = cVar.c;
            i6 = cVar.d;
            iArr2 = cVar.e;
            i3 = i11;
        }
        iArr = iArr2;
        z2 = zE;
        i4 = iF;
        i5 = i6;
        int iF32 = s73Var.f(8);
        int i92 = 0;
        while (i10 < i2) {
        }
        s73Var.m(i92);
        if (i2 > 0) {
        }
        return new c(i3, z2, i4, i5, iArr, iF32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e s(s73 s73Var) {
        int i2;
        int i3;
        int iF;
        int iF2 = s73Var.f(16);
        int iF3 = s73Var.f(16);
        if (s73Var.e()) {
            int iF4 = s73Var.f(2);
            if (iF4 == 3) {
                s73Var.l();
            }
            int iF5 = s73Var.f(4);
            iF = s73Var.f(4);
            i3 = iF5;
            i2 = iF4;
        } else {
            i2 = 0;
            i3 = 0;
            iF = 0;
        }
        if (s73Var.e()) {
            int i4 = s73Var.i();
            int i5 = s73Var.i();
            int i6 = s73Var.i();
            int i7 = s73Var.i();
            iF2 = b(iF2, i2, i4, i5);
            iF3 = a(iF3, i2, i6, i7);
        }
        return new e(i2, i3, iF, iF2, iF3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f t(s73 s73Var, int i2) {
        int i3 = s73Var.i();
        int i4 = i3 + 1;
        xi1.a aVarN = xi1.n(i4);
        int[] iArr = new int[i2];
        for (int i5 = 0; i5 < i4; i5++) {
            aVarN.a(s(s73Var));
        }
        int i6 = 1;
        if (i4 <= 1 || !s73Var.e()) {
            while (i6 < i2) {
                iArr[i6] = Math.min(i6, i3);
                i6++;
            }
        } else {
            int iD = dn0.d(i4, RoundingMode.CEILING);
            while (i6 < i2) {
                iArr[i6] = s73Var.f(iD);
                i6++;
            }
        }
        return new f(aVarN.k(), iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static g u(byte[] bArr, int i2, int i3) {
        byte b2;
        int i4 = i2 + 2;
        int i5 = i3 - 1;
        while (true) {
            b2 = bArr[i5];
            if (b2 != 0 || i5 <= i4) {
                break;
            }
            i5--;
        }
        if (b2 != 0 && i5 > i4) {
            s73 s73Var = new s73(bArr, i4, i5 + 1);
            while (s73Var.c(16)) {
                int iF = s73Var.f(8);
                int i6 = 0;
                while (iF == 255) {
                    i6 += 255;
                    iF = s73Var.f(8);
                }
                int i7 = i6 + iF;
                int iF2 = s73Var.f(8);
                int i8 = 0;
                while (iF2 == 255) {
                    i8 += 255;
                    iF2 = s73Var.f(8);
                }
                int i9 = i8 + iF2;
                if (i9 == 0 || !s73Var.c(i9)) {
                    break;
                }
                if (i7 == 176) {
                    int i10 = s73Var.i();
                    boolean zE = s73Var.e();
                    int i11 = zE ? s73Var.i() : 0;
                    int i12 = s73Var.i();
                    int i13 = -1;
                    int i14 = -1;
                    int iF3 = -1;
                    int iF4 = -1;
                    int i15 = -1;
                    int iF5 = -1;
                    for (int i16 = 0; i16 <= i12; i16++) {
                        i13 = s73Var.i();
                        i14 = s73Var.i();
                        iF3 = s73Var.f(6);
                        if (iF3 == 63) {
                            return null;
                        }
                        iF4 = s73Var.f(iF3 == 0 ? Math.max(0, i10 - 30) : Math.max(0, (iF3 + i10) - 31));
                        if (zE) {
                            int iF6 = s73Var.f(6);
                            if (iF6 == 63) {
                                return null;
                            }
                            i15 = iF6;
                            iF5 = s73Var.f(iF6 == 0 ? Math.max(0, i11 - 30) : Math.max(0, (iF6 + i11) - 31));
                        }
                        if (s73Var.e()) {
                            s73Var.m(10);
                        }
                    }
                    return new g(i10, i11, i12 + 1, i13, i14, iF3, iF4, i15, iF5);
                }
                s73Var.m(i9 * 8);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static h v(byte[] bArr, int i2, int i3, k kVar) {
        return w(bArr, i2 + 2, i3, q(new s73(bArr, i2, i3)), kVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h w(byte[] bArr, int i2, int i3, b bVar, k kVar) {
        int i4;
        int iA;
        int iB;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iMax;
        int i11;
        int i12;
        int i13;
        float f2;
        int i14;
        int i15;
        int i16;
        int i17;
        j jVar;
        int i18;
        int iK;
        int iL;
        f fVar;
        s73 s73Var = new s73(bArr, i2, i3);
        s73Var.m(4);
        int iF = s73Var.f(3);
        boolean z = bVar.b != 0 && iF == 7;
        int i19 = (kVar == null || kVar.b.isEmpty()) ? 0 : ((a) kVar.b.get(Math.min(bVar.b, kVar.b.size() - 1))).a;
        c cVarR = null;
        if (!z) {
            s73Var.l();
            cVarR = r(s73Var, true, iF, null);
        } else if (kVar != null) {
            d dVar = kVar.c;
            int i20 = dVar.b[i19];
            if (dVar.a.size() > i20) {
                cVarR = (c) kVar.c.a.get(i20);
            }
        }
        int i21 = s73Var.i();
        if (z) {
            int iF2 = s73Var.e() ? s73Var.f(8) : -1;
            if (kVar == null || (fVar = kVar.d) == null) {
                i7 = 0;
                i6 = 0;
                i9 = 0;
                i10 = 0;
                i5 = 0;
                i4 = 0;
                i8 = 0;
            } else {
                if (iF2 == -1) {
                    iF2 = fVar.b[i19];
                }
                if (iF2 != -1 && fVar.a.size() > iF2) {
                    e eVar = (e) kVar.d.a.get(iF2);
                    i4 = eVar.a;
                    i8 = eVar.d;
                    i6 = eVar.e;
                    i9 = eVar.b;
                    i5 = eVar.c;
                    i7 = i6;
                    i10 = i8;
                }
            }
        } else {
            i4 = s73Var.i();
            if (i4 == 3) {
                s73Var.l();
            }
            int i22 = s73Var.i();
            int i23 = s73Var.i();
            if (s73Var.e()) {
                int i24 = s73Var.i();
                int i25 = s73Var.i();
                int i26 = s73Var.i();
                int i27 = s73Var.i();
                iB = b(i22, i4, i24, i25);
                iA = a(i23, i4, i26, i27);
            } else {
                iA = i23;
                iB = i22;
            }
            int i28 = s73Var.i();
            i5 = s73Var.i();
            i6 = iA;
            i7 = i23;
            i8 = iB;
            i9 = i28;
            i10 = i22;
        }
        int i29 = s73Var.i();
        if (z) {
            iMax = -1;
        } else {
            int i30 = s73Var.e() ? 0 : iF;
            iMax = -1;
            while (i30 <= iF) {
                s73Var.i();
                iMax = Math.max(s73Var.i(), iMax);
                s73Var.i();
                i30++;
                i7 = i7;
            }
        }
        int i31 = i7;
        s73Var.i();
        s73Var.i();
        s73Var.i();
        s73Var.i();
        s73Var.i();
        s73Var.i();
        if (s73Var.e()) {
            if (z ? s73Var.e() : false) {
                s73Var.m(6);
            } else if (s73Var.e()) {
                H(s73Var);
            }
        }
        int i32 = 2;
        s73Var.m(2);
        if (s73Var.e()) {
            s73Var.m(8);
            s73Var.i();
            s73Var.i();
            s73Var.l();
        }
        I(s73Var);
        if (s73Var.e()) {
            int i33 = s73Var.i();
            int i34 = 0;
            while (i34 < i33) {
                s73Var.m(i29 + 5);
                i34++;
                i32 = 2;
            }
        }
        s73Var.m(i32);
        if (!s73Var.e()) {
            i11 = iF;
            i12 = i4;
            i13 = i8;
            f2 = 1.0f;
            i14 = -1;
            i15 = -1;
            i16 = -1;
        } else if (s73Var.e()) {
            int iF3 = s73Var.f(8);
            if (iF3 == 255) {
                int iF4 = s73Var.f(16);
                int iF5 = s73Var.f(16);
                if (iF4 != 0 && iF5 != 0) {
                    f2 = iF4 / iF5;
                }
                if (s73Var.e()) {
                }
                if (!s73Var.e()) {
                }
            } else {
                float[] fArr = b;
                if (iF3 < fArr.length) {
                    f2 = fArr[iF3];
                    if (s73Var.e()) {
                    }
                    if (!s73Var.e()) {
                    }
                } else {
                    xz1.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iF3);
                    f2 = 1.0f;
                    if (s73Var.e()) {
                    }
                    if (!s73Var.e()) {
                    }
                }
            }
        } else {
            f2 = 1.0f;
            if (s73Var.e()) {
                s73Var.l();
            }
            if (!s73Var.e()) {
                s73Var.m(3);
                i17 = s73Var.e() ? 1 : 2;
                if (s73Var.e()) {
                    int iF6 = s73Var.f(8);
                    int iF7 = s73Var.f(8);
                    s73Var.m(8);
                    iK = bx.k(iF6);
                    iL = bx.l(iF7);
                } else {
                    iK = -1;
                    iL = -1;
                }
                if (s73Var.e()) {
                    s73Var.i();
                    s73Var.i();
                }
                s73Var.l();
                if (s73Var.e()) {
                    i6 *= 2;
                }
                i11 = iF;
                i16 = iL;
                i12 = i4;
                i13 = i8;
                i15 = i17;
                i14 = iK;
            } else if (kVar == null || (jVar = kVar.e) == null || jVar.a.size() <= (i18 = jVar.b[i19])) {
                i17 = -1;
                iK = -1;
                iL = -1;
                if (s73Var.e()) {
                }
                s73Var.l();
                if (s73Var.e()) {
                }
                i11 = iF;
                i16 = iL;
                i12 = i4;
                i13 = i8;
                i15 = i17;
                i14 = iK;
            } else {
                i iVar = (i) kVar.e.a.get(i18);
                iK = iVar.a;
                int i35 = iVar.b;
                iL = iVar.c;
                i17 = i35;
                if (s73Var.e()) {
                }
                s73Var.l();
                if (s73Var.e()) {
                }
                i11 = iF;
                i16 = iL;
                i12 = i4;
                i13 = i8;
                i15 = i17;
                i14 = iK;
            }
        }
        return new h(bVar, i11, cVarR, i12, i9, i5, i21, i13, i6, i10, i31, f2, iMax, i14, i15, i16);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i x(s73 s73Var) {
        s73Var.m(3);
        int i2 = s73Var.e() ? 1 : 2;
        int iK = bx.k(s73Var.f(8));
        int iL = bx.l(s73Var.f(8));
        s73Var.m(8);
        return new i(iK, i2, iL);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j y(s73 s73Var, int i2, int i3, int[] iArr) {
        if (!s73Var.e() ? s73Var.e() : true) {
            s73Var.l();
        }
        boolean zE = s73Var.e();
        boolean zE2 = s73Var.e();
        if (zE || zE2) {
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < iArr[i4]; i5++) {
                    boolean zE3 = zE ? s73Var.e() : false;
                    boolean zE4 = zE2 ? s73Var.e() : false;
                    if (zE3) {
                        s73Var.m(32);
                    }
                    if (zE4) {
                        s73Var.m(18);
                    }
                }
            }
        }
        boolean zE5 = s73Var.e();
        int iF = zE5 ? s73Var.f(4) + 1 : i2;
        xi1.a aVarN = xi1.n(iF);
        int[] iArr2 = new int[i2];
        for (int i6 = 0; i6 < iF; i6++) {
            aVarN.a(x(s73Var));
        }
        if (zE5 && iF > 1) {
            for (int i7 = 0; i7 < i2; i7++) {
                iArr2[i7] = s73Var.f(4);
            }
        }
        return new j(aVarN.k(), iArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static k z(byte[] bArr, int i2, int i3) {
        s73 s73Var = new s73(bArr, i2, i3);
        return A(s73Var, q(s73Var));
    }
}

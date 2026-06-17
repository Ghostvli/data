package defpackage;

import defpackage.bl1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ha {
    public static volatile int a = 100;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public int a;
        public long b;
        public Object c;
        public final xy0 d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(xy0 xy0Var) {
            xy0Var.getClass();
            this.d = xy0Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int A(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        nk1 nk1Var = (nk1) iVar;
        int I = I(bArr, i2, aVar);
        nk1Var.e(hv.d(aVar.a));
        while (I < i3) {
            int I2 = I(bArr, I, aVar);
            if (i != aVar.a) {
                break;
            }
            I = I(bArr, I2, aVar);
            nk1Var.e(hv.d(aVar.a));
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int B(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        s02 s02Var = (s02) iVar;
        int iL = L(bArr, i2, aVar);
        s02Var.f(hv.e(aVar.b));
        while (iL < i3) {
            int I = I(bArr, iL, aVar);
            if (i != aVar.a) {
                break;
            }
            iL = L(bArr, I, aVar);
            s02Var.f(hv.e(aVar.b));
        }
        return iL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int C(byte[] bArr, int i, a aVar) throws ol1 {
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        if (i2 < 0) {
            throw ol1.g();
        }
        if (i2 == 0) {
            aVar.c = "";
            return I;
        }
        aVar.c = new String(bArr, I, i2, bl1.a);
        return I + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:8:0x001a) to fix multi-entry loop: BACK_EDGE: B:8:0x001a -> B:9:0x001b */
    public static int D(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) throws ol1 {
        int I = I(bArr, i2, aVar);
        int i4 = aVar.a;
        if (i4 < 0) {
            throw ol1.g();
        }
        if (i4 == 0) {
            iVar.add("");
        } else {
            iVar.add(new String(bArr, I, i4, bl1.a));
            I += i4;
        }
        while (I < i3) {
            int I2 = I(bArr, I, aVar);
            if (i != aVar.a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i5 = aVar.a;
            if (i5 < 0) {
                throw ol1.g();
            }
            if (i5 == 0) {
                iVar.add("");
            } else {
                iVar.add(new String(bArr, I, i5, bl1.a));
                I += i5;
            }
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:10:0x0022) to fix multi-entry loop: BACK_EDGE: B:10:0x0022 -> B:11:0x0023 */
    public static int E(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) throws ol1 {
        int I = I(bArr, i2, aVar);
        int i4 = aVar.a;
        if (i4 < 0) {
            throw ol1.g();
        }
        if (i4 == 0) {
            iVar.add("");
        } else {
            int i5 = I + i4;
            if (!wx4.f(bArr, I, i5)) {
                throw ol1.d();
            }
            iVar.add(new String(bArr, I, i4, bl1.a));
            I = i5;
        }
        while (I < i3) {
            int I2 = I(bArr, I, aVar);
            if (i != aVar.a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i6 = aVar.a;
            if (i6 < 0) {
                throw ol1.g();
            }
            if (i6 == 0) {
                iVar.add("");
            } else {
                int i7 = I + i6;
                if (!wx4.f(bArr, I, i7)) {
                    throw ol1.d();
                }
                iVar.add(new String(bArr, I, i6, bl1.a));
                I = i7;
            }
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int F(byte[] bArr, int i, a aVar) throws ol1 {
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        if (i2 < 0) {
            throw ol1.g();
        }
        if (i2 == 0) {
            aVar.c = "";
            return I;
        }
        aVar.c = wx4.a(bArr, I, i2);
        return I + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int G(int i, byte[] bArr, int i2, int i3, mw4 mw4Var, a aVar) throws ol1 {
        if (aa5.a(i) == 0) {
            throw ol1.c();
        }
        int iB = aa5.b(i);
        if (iB == 0) {
            int iL = L(bArr, i2, aVar);
            mw4Var.r(i, Long.valueOf(aVar.b));
            return iL;
        }
        if (iB == 1) {
            mw4Var.r(i, Long.valueOf(j(bArr, i2)));
            return i2 + 8;
        }
        if (iB == 2) {
            int I = I(bArr, i2, aVar);
            int i4 = aVar.a;
            if (i4 < 0) {
                throw ol1.g();
            }
            if (i4 > bArr.length - I) {
                throw ol1.m();
            }
            if (i4 == 0) {
                mw4Var.r(i, hn.g);
            } else {
                mw4Var.r(i, hn.e(bArr, I, i4));
            }
            return I + i4;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw ol1.c();
            }
            mw4Var.r(i, Integer.valueOf(h(bArr, i2)));
            return i2 + 4;
        }
        mw4 mw4VarO = mw4.o();
        int i5 = (i & (-8)) | 4;
        int i6 = aVar.e + 1;
        aVar.e = i6;
        a(i6);
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int I2 = I(bArr, i2, aVar);
            i7 = aVar.a;
            if (i7 == i5) {
                i2 = I2;
                break;
            }
            i2 = G(i7, bArr, I2, i3, mw4VarO, aVar);
        }
        aVar.e--;
        if (i2 > i3 || i7 != i5) {
            throw ol1.h();
        }
        mw4Var.r(i, mw4VarO);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int H(int i, byte[] bArr, int i2, a aVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            aVar.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            aVar.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            aVar.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                aVar.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int I(byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return H(b, bArr, i2, aVar);
        }
        aVar.a = b;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int J(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        nk1 nk1Var = (nk1) iVar;
        int I = I(bArr, i2, aVar);
        nk1Var.e(aVar.a);
        while (I < i3) {
            int I2 = I(bArr, I, aVar);
            if (i != aVar.a) {
                break;
            }
            I = I(bArr, I2, aVar);
            nk1Var.e(aVar.a);
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int K(long j, byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i3 = 7;
        while (b < 0) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            i3 += 7;
            j2 |= ((long) (b2 & 127)) << i3;
            i2 = i4;
            b = b2;
        }
        aVar.b = j2;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int L(byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j < 0) {
            return K(j, bArr, i2, aVar);
        }
        aVar.b = j;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        s02 s02Var = (s02) iVar;
        int iL = L(bArr, i2, aVar);
        s02Var.f(aVar.b);
        while (iL < i3) {
            int I = I(bArr, iL, aVar);
            if (i != aVar.a) {
                break;
            }
            iL = L(bArr, I, aVar);
            s02Var.f(aVar.b);
        }
        return iL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int N(Object obj, py3 py3Var, byte[] bArr, int i, int i2, int i3, a aVar) throws ol1 {
        int i4 = aVar.e + 1;
        aVar.e = i4;
        a(i4);
        int iB0 = ((us2) py3Var).b0(obj, bArr, i, i2, i3, aVar);
        aVar.e--;
        aVar.c = obj;
        return iB0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int O(Object obj, py3 py3Var, byte[] bArr, int i, int i2, a aVar) throws ol1 {
        int iH = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iH = H(i3, bArr, iH, aVar);
            i3 = aVar.a;
        }
        int i4 = iH;
        if (i3 < 0 || i3 > i2 - i4) {
            throw ol1.m();
        }
        int i5 = aVar.e + 1;
        aVar.e = i5;
        a(i5);
        int i6 = i4 + i3;
        py3Var.e(obj, bArr, i4, i6, aVar);
        aVar.e--;
        aVar.c = obj;
        return i6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(int i) throws ol1 {
        if (i >= a) {
            throw ol1.i();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        al alVar = (al) iVar;
        int iL = L(bArr, i2, aVar);
        alVar.f(aVar.b != 0);
        while (iL < i3) {
            int I = I(bArr, iL, aVar);
            if (i != aVar.a) {
                break;
            }
            iL = L(bArr, I, aVar);
            alVar.f(aVar.b != 0);
        }
        return iL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(byte[] bArr, int i, a aVar) throws ol1 {
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        if (i2 < 0) {
            throw ol1.g();
        }
        if (i2 > bArr.length - I) {
            throw ol1.m();
        }
        if (i2 == 0) {
            aVar.c = hn.g;
            return I;
        }
        aVar.c = hn.e(bArr, I, i2);
        return I + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:9:0x001b) to fix multi-entry loop: BACK_EDGE: B:9:0x001b -> B:10:0x001c */
    public static int d(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) throws ol1 {
        int I = I(bArr, i2, aVar);
        int i4 = aVar.a;
        if (i4 < 0) {
            throw ol1.g();
        }
        if (i4 > bArr.length - I) {
            throw ol1.m();
        }
        if (i4 == 0) {
            iVar.add(hn.g);
        } else {
            iVar.add(hn.e(bArr, I, i4));
            I += i4;
        }
        while (I < i3) {
            int I2 = I(bArr, I, aVar);
            if (i != aVar.a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i5 = aVar.a;
            if (i5 < 0) {
                throw ol1.g();
            }
            if (i5 > bArr.length - I) {
                throw ol1.m();
            }
            if (i5 == 0) {
                iVar.add(hn.g);
            } else {
                iVar.add(hn.e(bArr, I, i5));
                I += i5;
            }
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static double e(byte[] bArr, int i) {
        return Double.longBitsToDouble(j(bArr, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        cn0 cn0Var = (cn0) iVar;
        cn0Var.e(e(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = I(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            cn0Var.e(e(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(int i, byte[] bArr, int i2, int i3, Object obj, rs2 rs2Var, lw4 lw4Var, a aVar) {
        if (aVar.d.a(rs2Var, i >>> 3) == null) {
            return G(i, bArr, i2, i3, us2.u(obj), aVar);
        }
        w82.a(obj);
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        nk1 nk1Var = (nk1) iVar;
        nk1Var.e(h(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = I(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            nk1Var.e(h(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long j(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        s02 s02Var = (s02) iVar;
        s02Var.f(j(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = I(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            s02Var.f(j(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float l(byte[] bArr, int i) {
        return Float.intBitsToFloat(h(bArr, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int m(int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) {
        s21 s21Var = (s21) iVar;
        s21Var.e(l(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = I(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            s21Var.e(l(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int n(py3 py3Var, byte[] bArr, int i, int i2, int i3, a aVar) throws ol1 {
        Object objNewInstance = py3Var.newInstance();
        int iN = N(objNewInstance, py3Var, bArr, i, i2, i3, aVar);
        py3Var.b(objNewInstance);
        aVar.c = objNewInstance;
        return iN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(py3 py3Var, int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) throws ol1 {
        int i4 = (i & (-8)) | 4;
        int iN = n(py3Var, bArr, i2, i3, i4, aVar);
        iVar.add(aVar.c);
        while (iN < i3) {
            int I = I(bArr, iN, aVar);
            if (i != aVar.a) {
                break;
            }
            iN = n(py3Var, bArr, I, i3, i4, aVar);
            iVar.add(aVar.c);
        }
        return iN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(py3 py3Var, byte[] bArr, int i, int i2, a aVar) throws ol1 {
        Object objNewInstance = py3Var.newInstance();
        int iO = O(objNewInstance, py3Var, bArr, i, i2, aVar);
        py3Var.b(objNewInstance);
        aVar.c = objNewInstance;
        return iO;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int q(py3 py3Var, int i, byte[] bArr, int i2, int i3, bl1.i iVar, a aVar) throws ol1 {
        int iP = p(py3Var, bArr, i2, i3, aVar);
        iVar.add(aVar.c);
        while (iP < i3) {
            int I = I(bArr, iP, aVar);
            if (i != aVar.a) {
                break;
            }
            iP = p(py3Var, bArr, I, i3, aVar);
            iVar.add(aVar.c);
        }
        return iP;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int r(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        al alVar = (al) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a + I;
        while (I < i2) {
            I = L(bArr, I, aVar);
            alVar.f(aVar.b != 0);
        }
        if (I == i2) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int s(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        cn0 cn0Var = (cn0) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        int i3 = I + i2;
        if (i3 > bArr.length) {
            throw ol1.m();
        }
        cn0Var.j(cn0Var.size() + (i2 / 8));
        while (I < i3) {
            cn0Var.e(e(bArr, I));
            I += 8;
        }
        if (I == i3) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int t(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        nk1 nk1Var = (nk1) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        int i3 = I + i2;
        if (i3 > bArr.length) {
            throw ol1.m();
        }
        nk1Var.j(nk1Var.size() + (i2 / 4));
        while (I < i3) {
            nk1Var.e(h(bArr, I));
            I += 4;
        }
        if (I == i3) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int u(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        s02 s02Var = (s02) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        int i3 = I + i2;
        if (i3 > bArr.length) {
            throw ol1.m();
        }
        s02Var.j(s02Var.size() + (i2 / 8));
        while (I < i3) {
            s02Var.f(j(bArr, I));
            I += 8;
        }
        if (I == i3) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int v(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        s21 s21Var = (s21) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a;
        int i3 = I + i2;
        if (i3 > bArr.length) {
            throw ol1.m();
        }
        s21Var.j(s21Var.size() + (i2 / 4));
        while (I < i3) {
            s21Var.e(l(bArr, I));
            I += 4;
        }
        if (I == i3) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int w(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        nk1 nk1Var = (nk1) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a + I;
        while (I < i2) {
            I = I(bArr, I, aVar);
            nk1Var.e(hv.d(aVar.a));
        }
        if (I == i2) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int x(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        s02 s02Var = (s02) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a + I;
        while (I < i2) {
            I = L(bArr, I, aVar);
            s02Var.f(hv.e(aVar.b));
        }
        if (I == i2) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int y(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        nk1 nk1Var = (nk1) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a + I;
        while (I < i2) {
            I = I(bArr, I, aVar);
            nk1Var.e(aVar.a);
        }
        if (I == i2) {
            return I;
        }
        throw ol1.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int z(byte[] bArr, int i, bl1.i iVar, a aVar) throws ol1 {
        s02 s02Var = (s02) iVar;
        int I = I(bArr, i, aVar);
        int i2 = aVar.a + I;
        while (I < i2) {
            I = L(bArr, I, aVar);
            s02Var.f(aVar.b);
        }
        if (I == i2) {
            return I;
        }
        throw ol1.m();
    }
}

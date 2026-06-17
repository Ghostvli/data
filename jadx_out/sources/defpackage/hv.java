package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hv {
    public static volatile int g = 100;
    public static g h = g.CONTROL;
    public int a;
    public int b;
    public int c;
    public int d;
    public Object e;
    public boolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b extends hv {
        public final byte[] i;
        public final boolean j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public boolean p;
        public int q;

        public b(byte[] bArr, int i, int i2, boolean z) {
            super();
            this.q = Integer.MAX_VALUE;
            this.i = bArr;
            this.k = i2 + i;
            this.m = i;
            this.n = i;
            this.j = z;
        }

        @Override // defpackage.hv
        public int A() {
            return O();
        }

        @Override // defpackage.hv
        public long B() {
            return P();
        }

        @Override // defpackage.hv
        public int C() {
            return hv.d(R());
        }

        @Override // defpackage.hv
        public long D() {
            return hv.e(V());
        }

        @Override // defpackage.hv
        public String E() throws ol1 {
            int iR = R();
            if (iR > 0) {
                int i = this.k;
                int i2 = this.m;
                if (iR <= i - i2) {
                    String str = new String(this.i, i2, iR, bl1.a);
                    this.m += iR;
                    return str;
                }
            }
            if (iR == 0) {
                return "";
            }
            if (iR < 0) {
                throw ol1.g();
            }
            throw ol1.m();
        }

        @Override // defpackage.hv
        public String F() throws ol1 {
            int iR = R();
            if (iR > 0) {
                int i = this.k;
                int i2 = this.m;
                if (iR <= i - i2) {
                    String strA = wx4.a(this.i, i2, iR);
                    this.m += iR;
                    return strA;
                }
            }
            if (iR == 0) {
                return "";
            }
            if (iR <= 0) {
                throw ol1.g();
            }
            throw ol1.m();
        }

        @Override // defpackage.hv
        public int G() throws ol1 {
            if (g()) {
                this.o = 0;
                return 0;
            }
            int iR = R();
            this.o = iR;
            if (aa5.a(iR) != 0) {
                return this.o;
            }
            throw ol1.c();
        }

        @Override // defpackage.hv
        public int H() {
            return R();
        }

        @Override // defpackage.hv
        public long I() {
            return V();
        }

        @Override // defpackage.hv
        public boolean J(int i) throws ol1 {
            int iB = aa5.b(i);
            if (iB == 0) {
                Z();
                return true;
            }
            if (iB == 1) {
                Y(8);
                return true;
            }
            if (iB == 2) {
                Y(R());
                return true;
            }
            if (iB == 3) {
                K();
                a(aa5.c(aa5.a(i), 4));
                return true;
            }
            if (iB == 4) {
                c();
                return false;
            }
            if (iB != 5) {
                throw ol1.e();
            }
            Y(4);
            return true;
        }

        public final hn L(boolean z) {
            int iR = R();
            if (iR > 0) {
                int i = this.k;
                int i2 = this.m;
                if (iR <= i - i2) {
                    hn hnVarD = (this.j && this.p) ? hn.D(this.i, i2, iR, z) : hn.f(this.i, i2, iR, z);
                    this.m += iR;
                    return hnVarD;
                }
            }
            return iR == 0 ? hn.g : hn.E(N(iR), z);
        }

        public byte M() throws ol1 {
            int i = this.m;
            if (i == this.k) {
                throw ol1.m();
            }
            byte[] bArr = this.i;
            this.m = i + 1;
            return bArr[i];
        }

        public byte[] N(int i) throws ol1 {
            if (i > 0) {
                int i2 = this.k;
                int i3 = this.m;
                if (i <= i2 - i3) {
                    int i4 = i + i3;
                    this.m = i4;
                    return Arrays.copyOfRange(this.i, i3, i4);
                }
            }
            if (i > 0) {
                throw ol1.m();
            }
            if (i == 0) {
                return bl1.c;
            }
            throw ol1.g();
        }

        public int O() throws ol1 {
            int i = this.m;
            if (this.k - i < 4) {
                throw ol1.m();
            }
            byte[] bArr = this.i;
            this.m = i + 4;
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
        }

        public long P() throws ol1 {
            int i = this.m;
            if (this.k - i < 8) {
                throw ol1.m();
            }
            byte[] bArr = this.i;
            this.m = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public abstract int Q();

        public abstract int R();

        public int S() throws ol1 {
            try {
                int iT = T();
                if (this.m <= this.k) {
                    return iT;
                }
                throw ol1.m();
            } catch (IndexOutOfBoundsException unused) {
                throw ol1.m();
            } catch (ol1 e) {
                if (this.m > this.k) {
                    throw ol1.m();
                }
                throw e;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[PHI: r3
          0x0069: PHI (r3v6 int) = (r3v5 int), (r3v10 int), (r3v12 int) binds: [B:16:0x0041, B:20:0x004d, B:24:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int T() throws defpackage.ol1 {
            /*
                r7 = this;
                int r0 = r7.m
                byte[] r1 = r7.i
                int r2 = r0 + 1
                r3 = r1[r0]
                if (r3 < 0) goto Lc
                goto L6f
            Lc:
                int r4 = r0 + 2
                r2 = r1[r2]
                int r2 = r2 << 7
                r2 = r2 ^ r3
                if (r2 >= 0) goto L19
                r3 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            L17:
                r2 = r4
                goto L6f
            L19:
                int r3 = r0 + 3
                r4 = r1[r4]
                int r4 = r4 << 14
                r2 = r2 ^ r4
                if (r2 < 0) goto L27
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
                r2 = r3
                r3 = r0
                goto L6f
            L27:
                int r4 = r0 + 4
                r3 = r1[r3]
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L36
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r3 = r2 ^ r0
                goto L17
            L36:
                int r3 = r0 + 5
                r4 = r1[r4]
                int r5 = r4 << 28
                r2 = r2 ^ r5
                r5 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r5
                if (r4 >= 0) goto L69
                int r4 = r0 + 6
                r3 = r1[r3]
                if (r3 >= 0) goto L6d
                int r3 = r0 + 7
                r4 = r1[r4]
                if (r4 >= 0) goto L69
                int r4 = r0 + 8
                r3 = r1[r3]
                if (r3 >= 0) goto L6d
                int r3 = r0 + 9
                r4 = r1[r4]
                if (r4 >= 0) goto L69
                int r0 = r0 + 10
                r1 = r1[r3]
                if (r1 < 0) goto L64
                r3 = r2
                r2 = r0
                goto L6f
            L64:
                ol1 r7 = defpackage.ol1.f()
                throw r7
            L69:
                r6 = r3
                r3 = r2
                r2 = r6
                goto L6f
            L6d:
                r3 = r2
                goto L17
            L6f:
                r7.m = r2
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: hv.b.T():int");
        }

        public int U() {
            int i;
            int i2 = this.m;
            int i3 = this.k;
            if (i3 != i2) {
                byte[] bArr = this.i;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.m = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.m = i5;
                    return i;
                }
            }
            return (int) W();
        }

        public long V() {
            long j;
            long j2;
            long j3;
            int i = this.m;
            int i2 = this.k;
            if (i2 != i) {
                byte[] bArr = this.i;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.m = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (((long) bArr[i8]) << 28);
                                if (j6 >= 0) {
                                    j2 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (((long) bArr[i10]) << 42);
                                        if (j6 >= 0) {
                                            j2 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (((long) bArr[i4]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                j6 = j7 ^ (((long) bArr[i10]) << 56);
                                                if (j6 >= 0) {
                                                    j2 = 71499008037633920L;
                                                } else {
                                                    int i11 = i + 10;
                                                    long j8 = (((long) bArr[i4]) << 63) ^ j6;
                                                    if (j8 >= 0) {
                                                        j = j8 ^ (-9151873028817141888L);
                                                        i4 = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j = j7 ^ j3;
                                    i4 = i10;
                                }
                                j = j6 ^ j2;
                            }
                        }
                    }
                    this.m = i4;
                    return j;
                }
            }
            return W();
        }

        public long W() throws ol1 {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte bM = M();
                j |= ((long) (bM & 127)) << i;
                if ((bM & 128) == 0) {
                    return j;
                }
            }
            throw ol1.f();
        }

        public final void X() {
            int i = this.k + this.l;
            this.k = i;
            int i2 = i - this.n;
            int i3 = this.q;
            if (i2 <= i3) {
                this.l = 0;
                return;
            }
            int i4 = i2 - i3;
            this.l = i4;
            this.k = i - i4;
        }

        public void Y(int i) throws ol1 {
            if (i >= 0) {
                int i2 = this.k;
                int i3 = this.m;
                if (i <= i2 - i3) {
                    this.m = i3 + i;
                    return;
                }
            }
            if (i >= 0) {
                throw ol1.m();
            }
            throw ol1.g();
        }

        public final void Z() throws ol1 {
            if (this.k - this.m >= 10) {
                a0();
            } else {
                b0();
            }
        }

        @Override // defpackage.hv
        public void a(int i) throws ol1 {
            if (this.o != i) {
                throw ol1.b();
            }
        }

        public final void a0() throws ol1 {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.i;
                int i2 = this.m;
                this.m = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw ol1.f();
        }

        public final void b0() throws ol1 {
            for (int i = 0; i < 10; i++) {
                if (M() >= 0) {
                    return;
                }
            }
            throw ol1.f();
        }

        @Override // defpackage.hv
        public int f() {
            return this.m - this.n;
        }

        @Override // defpackage.hv
        public boolean g() {
            return this.m == this.k;
        }

        @Override // defpackage.hv
        public void o(int i) {
            this.q = i;
            X();
        }

        @Override // defpackage.hv
        public int p(int i) throws ol1 {
            if (i < 0) {
                throw ol1.g();
            }
            int iF = i + f();
            if (iF < 0) {
                throw ol1.l();
            }
            int i2 = this.q;
            if (iF > i2) {
                throw ol1.m();
            }
            this.q = iF;
            X();
            return i2;
        }

        @Override // defpackage.hv
        public boolean q() {
            return V() != 0;
        }

        @Override // defpackage.hv
        public hn r() {
            return L(false);
        }

        @Override // defpackage.hv
        public double s() {
            return Double.longBitsToDouble(P());
        }

        @Override // defpackage.hv
        public int t() {
            return Q();
        }

        @Override // defpackage.hv
        public int u() {
            return O();
        }

        @Override // defpackage.hv
        public long v() {
            return P();
        }

        @Override // defpackage.hv
        public float w() {
            return Float.intBitsToFloat(O());
        }

        @Override // defpackage.hv
        public int x() {
            return Q();
        }

        @Override // defpackage.hv
        public long y() {
            return V();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends b {
        public c(byte[] bArr, int i, int i2, boolean z) {
            super(bArr, i, i2, z);
        }

        @Override // hv.b
        public int Q() {
            return super.S();
        }

        @Override // hv.b
        public int R() {
            return super.S();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends b {
        public d(byte[] bArr, int i, int i2, boolean z) {
            super(bArr, i, i2, z);
        }

        @Override // hv.b
        public int Q() {
            return super.U();
        }

        @Override // hv.b
        public int R() {
            return super.S();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends b {
        public e(byte[] bArr, int i, int i2, boolean z) {
            super(bArr, i, i2, z);
        }

        @Override // hv.b
        public int Q() {
            return super.U();
        }

        @Override // hv.b
        public int R() {
            return super.U();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends hv {
        public final InputStream i;
        public final byte[] j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;

        public f(InputStream inputStream, int i) {
            super();
            this.p = Integer.MAX_VALUE;
            bl1.b(inputStream, "input");
            this.i = inputStream;
            this.j = new byte[i];
            this.k = 0;
            this.m = 0;
            this.o = 0;
        }

        public static int L(InputStream inputStream) throws ol1 {
            try {
                return inputStream.available();
            } catch (ol1 e) {
                e.j();
                throw e;
            }
        }

        public static int M(InputStream inputStream, byte[] bArr, int i, int i2) throws ol1 {
            try {
                return inputStream.read(bArr, i, i2);
            } catch (ol1 e) {
                e.j();
                throw e;
            }
        }

        private hn N(boolean z) throws ol1 {
            int iV = V();
            int i = this.k;
            int i2 = this.m;
            if (iV <= i - i2 && iV > 0) {
                hn hnVarF = hn.f(this.j, i2, iV, z);
                this.m += iV;
                return hnVarF;
            }
            if (iV == 0) {
                return hn.g;
            }
            if (iV >= 0) {
                return O(iV, z);
            }
            throw ol1.g();
        }

        private void Y() {
            int i = this.k + this.l;
            this.k = i;
            int i2 = this.o + i;
            int i3 = this.p;
            if (i2 <= i3) {
                this.l = 0;
                return;
            }
            int i4 = i2 - i3;
            this.l = i4;
            this.k = i - i4;
        }

        public static long a0(InputStream inputStream, long j) throws ol1 {
            try {
                return inputStream.skip(j);
            } catch (ol1 e) {
                e.j();
                throw e;
            }
        }

        private void d0() throws ol1 {
            if (this.k - this.m >= 10) {
                e0();
            } else {
                f0();
            }
        }

        private void e0() throws ol1 {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.j;
                int i2 = this.m;
                this.m = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw ol1.f();
        }

        private void f0() throws ol1 {
            for (int i = 0; i < 10; i++) {
                if (P() >= 0) {
                    return;
                }
            }
            throw ol1.f();
        }

        @Override // defpackage.hv
        public int A() {
            return T();
        }

        @Override // defpackage.hv
        public long B() {
            return U();
        }

        @Override // defpackage.hv
        public int C() {
            return hv.d(V());
        }

        @Override // defpackage.hv
        public long D() {
            return hv.e(W());
        }

        @Override // defpackage.hv
        public String E() throws ol1 {
            int iV = V();
            if (iV > 0) {
                int i = this.k;
                int i2 = this.m;
                if (iV <= i - i2) {
                    String str = new String(this.j, i2, iV, bl1.a);
                    this.m += iV;
                    return str;
                }
            }
            if (iV == 0) {
                return "";
            }
            if (iV < 0) {
                throw ol1.g();
            }
            if (iV > this.k) {
                return new String(Q(iV, false), bl1.a);
            }
            Z(iV);
            String str2 = new String(this.j, this.m, iV, bl1.a);
            this.m += iV;
            return str2;
        }

        @Override // defpackage.hv
        public String F() throws IOException {
            byte[] bArrQ;
            int iV = V();
            int i = this.m;
            int i2 = this.k;
            if (iV <= i2 - i && iV > 0) {
                bArrQ = this.j;
                this.m = i + iV;
            } else {
                if (iV == 0) {
                    return "";
                }
                if (iV < 0) {
                    throw ol1.g();
                }
                i = 0;
                if (iV <= i2) {
                    Z(iV);
                    bArrQ = this.j;
                    this.m = iV;
                } else {
                    bArrQ = Q(iV, false);
                }
            }
            return wx4.a(bArrQ, i, iV);
        }

        @Override // defpackage.hv
        public int G() throws ol1 {
            if (g()) {
                this.n = 0;
                return 0;
            }
            int iV = V();
            this.n = iV;
            if (aa5.a(iV) != 0) {
                return this.n;
            }
            throw ol1.c();
        }

        @Override // defpackage.hv
        public int H() {
            return V();
        }

        @Override // defpackage.hv
        public long I() {
            return W();
        }

        @Override // defpackage.hv
        public boolean J(int i) throws ol1 {
            int iB = aa5.b(i);
            if (iB == 0) {
                d0();
                return true;
            }
            if (iB == 1) {
                b0(8);
                return true;
            }
            if (iB == 2) {
                b0(V());
                return true;
            }
            if (iB == 3) {
                K();
                a(aa5.c(aa5.a(i), 4));
                return true;
            }
            if (iB == 4) {
                c();
                return false;
            }
            if (iB != 5) {
                throw ol1.e();
            }
            b0(4);
            return true;
        }

        public final hn O(int i, boolean z) throws IOException {
            byte[] bArrR = R(i);
            if (bArrR != null) {
                return hn.f(bArrR, 0, bArrR.length, z);
            }
            int i2 = this.m;
            int i3 = this.k;
            int length = i3 - i2;
            this.o += i3;
            this.m = 0;
            this.k = 0;
            List<byte[]> listS = S(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.j, i2, bArr, 0, length);
            for (byte[] bArr2 : listS) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            if (!z || wx4.e(bArr)) {
                return hn.C(bArr);
            }
            throw ol1.d();
        }

        public byte P() throws ol1 {
            if (this.m == this.k) {
                Z(1);
            }
            byte[] bArr = this.j;
            int i = this.m;
            this.m = i + 1;
            return bArr[i];
        }

        public final byte[] Q(int i, boolean z) throws IOException {
            byte[] bArrR = R(i);
            if (bArrR != null) {
                return z ? (byte[]) bArrR.clone() : bArrR;
            }
            int i2 = this.m;
            int i3 = this.k;
            int length = i3 - i2;
            this.o += i3;
            this.m = 0;
            this.k = 0;
            List<byte[]> listS = S(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.j, i2, bArr, 0, length);
            for (byte[] bArr2 : listS) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] R(int i) throws ol1 {
            if (i == 0) {
                return bl1.c;
            }
            if (i < 0) {
                throw ol1.g();
            }
            int i2 = this.o;
            int i3 = this.m;
            int i4 = i2 + i3 + i;
            if (i4 - this.d > 0) {
                throw ol1.l();
            }
            int i5 = this.p;
            if (i4 > i5) {
                b0((i5 - i2) - i3);
                throw ol1.m();
            }
            int i6 = this.k - i3;
            int i7 = i - i6;
            if (i7 >= 4096 && i7 > L(this.i)) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.j, this.m, bArr, 0, i6);
            this.o += this.k;
            this.m = 0;
            this.k = 0;
            while (i6 < i) {
                int iM = M(this.i, bArr, i6, i - i6);
                if (iM == -1) {
                    throw ol1.m();
                }
                this.o += iM;
                i6 += iM;
            }
            return bArr;
        }

        public final List S(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int iMin = Math.min(i, Buffer.SEGMENTING_THRESHOLD);
                byte[] bArr = new byte[iMin];
                int i2 = 0;
                while (i2 < iMin) {
                    int i3 = this.i.read(bArr, i2, iMin - i2);
                    if (i3 == -1) {
                        throw ol1.m();
                    }
                    this.o += i3;
                    i2 += i3;
                }
                i -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int T() throws ol1 {
            int i = this.m;
            if (this.k - i < 4) {
                Z(4);
                i = this.m;
            }
            byte[] bArr = this.j;
            this.m = i + 4;
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
        }

        public long U() throws ol1 {
            int i = this.m;
            if (this.k - i < 8) {
                Z(8);
                i = this.m;
            }
            byte[] bArr = this.j;
            this.m = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public int V() {
            int i;
            int i2 = this.m;
            int i3 = this.k;
            if (i3 != i2) {
                byte[] bArr = this.j;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.m = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.m = i5;
                    return i;
                }
            }
            return (int) X();
        }

        public long W() {
            long j;
            long j2;
            long j3;
            int i = this.m;
            int i2 = this.k;
            if (i2 != i) {
                byte[] bArr = this.j;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.m = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (((long) bArr[i8]) << 28);
                                if (j6 >= 0) {
                                    j2 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (((long) bArr[i10]) << 42);
                                        if (j6 >= 0) {
                                            j2 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (((long) bArr[i4]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                j6 = j7 ^ (((long) bArr[i10]) << 56);
                                                if (j6 >= 0) {
                                                    j2 = 71499008037633920L;
                                                } else {
                                                    int i11 = i + 10;
                                                    long j8 = (((long) bArr[i4]) << 63) ^ j6;
                                                    if (j8 >= 0) {
                                                        j = j8 ^ (-9151873028817141888L);
                                                        i4 = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j = j7 ^ j3;
                                    i4 = i10;
                                }
                                j = j6 ^ j2;
                            }
                        }
                    }
                    this.m = i4;
                    return j;
                }
            }
            return X();
        }

        public long X() throws ol1 {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte bP = P();
                j |= ((long) (bP & 127)) << i;
                if ((bP & 128) == 0) {
                    return j;
                }
            }
            throw ol1.f();
        }

        public final void Z(int i) throws ol1 {
            if (g0(i)) {
                return;
            }
            if (i <= (this.d - this.o) - this.m) {
                throw ol1.m();
            }
            throw ol1.l();
        }

        @Override // defpackage.hv
        public void a(int i) throws ol1 {
            if (this.n != i) {
                throw ol1.b();
            }
        }

        public void b0(int i) throws ol1 {
            int i2 = this.k;
            int i3 = this.m;
            if (i > i2 - i3 || i < 0) {
                c0(i);
            } else {
                this.m = i3 + i;
            }
        }

        public final void c0(int i) throws ol1 {
            if (i < 0) {
                throw ol1.g();
            }
            int i2 = this.o;
            int i3 = this.m;
            int i4 = i2 + i3 + i;
            int i5 = this.p;
            if (i4 > i5) {
                b0((i5 - i2) - i3);
                throw ol1.m();
            }
            this.o = i2 + i3;
            int i6 = this.k - i3;
            this.k = 0;
            this.m = 0;
            while (i6 < i) {
                try {
                    long j = i - i6;
                    long jA0 = a0(this.i, j);
                    if (jA0 < 0 || jA0 > j) {
                        throw new IllegalStateException(this.i.getClass() + "#skip returned invalid result: " + jA0 + "\nThe InputStream implementation is buggy.");
                    }
                    if (jA0 == 0) {
                        break;
                    } else {
                        i6 += (int) jA0;
                    }
                } finally {
                    this.o += i6;
                    Y();
                }
            }
            if (i6 >= i) {
                return;
            }
            int i7 = this.k;
            int i8 = i7 - this.m;
            this.m = i7;
            Z(1);
            while (true) {
                int i9 = i - i8;
                int i10 = this.k;
                if (i9 <= i10) {
                    this.m = i9;
                    return;
                } else {
                    i8 += i10;
                    this.m = i10;
                    Z(1);
                }
            }
        }

        @Override // defpackage.hv
        public int f() {
            return this.o + this.m;
        }

        @Override // defpackage.hv
        public boolean g() {
            return this.m == this.k && !g0(1);
        }

        public final boolean g0(int i) throws ol1 {
            int i2 = this.m;
            int i3 = i2 + i;
            int i4 = this.k;
            if (i3 <= i4) {
                throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
            }
            int i5 = this.d;
            int i6 = this.o;
            if (i > (i5 - i6) - i2 || i6 + i2 + i > this.p) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.j;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.o += i2;
                this.k -= i2;
                this.m = 0;
            }
            InputStream inputStream = this.i;
            byte[] bArr2 = this.j;
            int i7 = this.k;
            int iM = M(inputStream, bArr2, i7, Math.min(bArr2.length - i7, (this.d - this.o) - i7));
            if (iM != 0 && iM >= -1 && iM <= this.j.length) {
                if (iM <= 0) {
                    return false;
                }
                this.k += iM;
                Y();
                return this.k >= i || g0(i);
            }
            throw new IllegalStateException(this.i.getClass() + "#read(byte[]) returned invalid result: " + iM + "\nThe InputStream implementation is buggy.");
        }

        @Override // defpackage.hv
        public void o(int i) {
            this.p = i;
            Y();
        }

        @Override // defpackage.hv
        public int p(int i) throws ol1 {
            if (i < 0) {
                throw ol1.g();
            }
            int i2 = i + this.o + this.m;
            if (i2 < 0) {
                throw ol1.l();
            }
            int i3 = this.p;
            if (i2 > i3) {
                throw ol1.m();
            }
            this.p = i2;
            Y();
            return i3;
        }

        @Override // defpackage.hv
        public boolean q() {
            return W() != 0;
        }

        @Override // defpackage.hv
        public hn r() {
            return N(false);
        }

        @Override // defpackage.hv
        public double s() {
            return Double.longBitsToDouble(U());
        }

        @Override // defpackage.hv
        public int t() {
            return V();
        }

        @Override // defpackage.hv
        public int u() {
            return T();
        }

        @Override // defpackage.hv
        public long v() {
            return U();
        }

        @Override // defpackage.hv
        public float w() {
            return Float.intBitsToFloat(T());
        }

        @Override // defpackage.hv
        public int x() {
            return V();
        }

        @Override // defpackage.hv
        public long y() {
            return W();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum g {
        CONTROL,
        NEW_ALL_CASES,
        NEW_TAGS_LENGTHS_UNSIGNED_ONLY
    }

    public hv() {
        this.c = g;
        this.d = Integer.MAX_VALUE;
        this.f = false;
    }

    public static int d(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long e(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static hv h(InputStream inputStream) {
        return i(inputStream, Buffer.SEGMENTING_THRESHOLD);
    }

    public static hv i(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? l(bl1.c) : new f(inputStream, i);
        }
        jl.a("bufferSize must be > 0");
        return null;
    }

    public static hv j(ByteBuffer byteBuffer) {
        return k(byteBuffer, false);
    }

    public static hv k(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return n(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return n(bArr, 0, iRemaining, true);
    }

    public static hv l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static hv m(byte[] bArr, int i, int i2) {
        return n(bArr, i, i2, false);
    }

    public static hv n(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        hv cVar;
        hv eVar;
        int iOrdinal = h.ordinal();
        try {
            if (iOrdinal == 1) {
                i3 = i2;
                cVar = new c(bArr, i, i3, z);
            } else {
                if (iOrdinal != 2) {
                    eVar = new e(bArr, i, i2, z);
                    i3 = i2;
                    eVar.p(i3);
                    return eVar;
                }
                i3 = i2;
                cVar = new d(bArr, i, i3, z);
            }
            eVar.p(i3);
            return eVar;
        } catch (ol1 e2) {
            throw new IllegalArgumentException(e2);
        }
        eVar = cVar;
    }

    public static int z(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw ol1.m();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw ol1.m();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw ol1.f();
    }

    public abstract int A();

    public abstract long B();

    public abstract int C();

    public abstract long D();

    public abstract String E();

    public abstract String F();

    public abstract int G();

    public abstract int H();

    public abstract long I();

    public abstract boolean J(int i);

    public void K() throws ol1 {
        int iG;
        do {
            iG = G();
            if (iG == 0) {
                return;
            }
            b();
            this.b++;
            this.b--;
        } while (J(iG));
    }

    public abstract void a(int i);

    public void b() throws ol1 {
        if (this.a + this.b >= this.c) {
            throw ol1.i();
        }
    }

    public void c() {
        if (this.b == 0) {
            a(0);
        }
    }

    public abstract int f();

    public abstract boolean g();

    public abstract void o(int i);

    public abstract int p(int i);

    public abstract boolean q();

    public abstract hn r();

    public abstract double s();

    public abstract int t();

    public abstract int u();

    public abstract long v();

    public abstract float w();

    public abstract int x();

    public abstract long y();
}

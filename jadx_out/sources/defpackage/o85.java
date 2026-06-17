package defpackage;

import android.util.Pair;
import defpackage.t41;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o85 implements hz0 {
    public static final pz0 h = new pz0() { // from class: n85
        @Override // defpackage.pz0
        public final hz0[] d() {
            return o85.g();
        }
    };
    public mz0 a;
    public gr4 b;
    public b e;
    public int c = 0;
    public long d = -1;
    public int f = -1;
    public long g = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements b {
        public static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, Token.ASSIGN_URSH, Token.AND, 130, Token.BLOCK, Token.DOTDOT, Token.WITHEXPR, 190, 209, 230, 253, 279, HttpStatusCodesKt.HTTP_TEMP_REDIRECT, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final mz0 a;
        public final gr4 b;
        public final p85 c;
        public final int d;
        public final byte[] e;
        public final r73 f;
        public final int g;
        public final t41 h;
        public int i;
        public long j;
        public int k;
        public long l;

        public a(mz0 mz0Var, gr4 gr4Var, p85 p85Var) throws r83 {
            this.a = mz0Var;
            this.b = gr4Var;
            this.c = p85Var;
            int iMax = Math.max(1, p85Var.c / 10);
            this.g = iMax;
            r73 r73Var = new r73(p85Var.g);
            r73Var.I();
            int I = r73Var.I();
            this.d = I;
            int i = p85Var.b;
            int i2 = (((p85Var.e - (i * 4)) * 8) / (p85Var.f * i)) + 1;
            if (I != i2) {
                throw r83.a("Expected frames per block: " + i2 + "; got: " + I, null);
            }
            int iN = fy4.n(iMax, I);
            this.e = new byte[p85Var.e * iN];
            this.f = new r73(iN * h(I, i));
            int i3 = ((p85Var.c * p85Var.e) * 8) / I;
            this.h = new t41.b().A0("audio/raw").T(i3).u0(i3).p0(h(iMax, i)).U(p85Var.b).B0(p85Var.c).t0(2).Q();
        }

        public static int h(int i, int i2) {
            return i * 2 * i2;
        }

        @Override // o85.b
        public void a(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:4:0x001b). Please report as a decompilation issue!!! */
        @Override // o85.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(defpackage.jz0 r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.g
                int r1 = r6.k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.d
                int r0 = defpackage.fy4.n(r0, r1)
                p85 r1 = r6.c
                int r1 = r1.e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.i
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.e
                int r5 = r6.i
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.i
                int r4 = r4 + r3
                r6.i = r4
                goto L1e
            L3e:
                int r7 = r6.i
                p85 r8 = r6.c
                int r8 = r8.e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.e
                r73 r9 = r6.f
                r6.d(r8, r7, r9)
                int r8 = r6.i
                p85 r9 = r6.c
                int r9 = r9.e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.i = r8
                r73 r7 = r6.f
                int r7 = r7.j()
                gr4 r8 = r6.b
                r73 r9 = r6.f
                r8.a(r9, r7)
                int r8 = r6.k
                int r8 = r8 + r7
                r6.k = r8
                int r7 = r6.f(r8)
                int r8 = r6.g
                if (r7 < r8) goto L75
                r6.i(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L82
                r6.i(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: o85.a.b(jz0, long):boolean");
        }

        @Override // o85.b
        public void c(int i, long j) {
            r85 r85Var = new r85(this.c, this.d, i, j);
            this.a.u(r85Var);
            this.b.g(this.h);
            this.b.e(r85Var.i());
        }

        public final void d(byte[] bArr, int i, r73 r73Var) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.c.b; i3++) {
                    e(bArr, i2, i3, r73Var.f());
                }
            }
            int iG = g(this.d * i);
            r73Var.f0(0);
            r73Var.e0(iG);
        }

        public final void e(byte[] bArr, int i, int i2, byte[] bArr2) {
            p85 p85Var = this.c;
            int i3 = p85Var.e;
            int i4 = p85Var.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int iS = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int iMin = Math.min(bArr[i5 + 2] & 255, 88);
            int i8 = n[iMin];
            int i9 = ((i * this.d * i4) + i2) * 2;
            bArr2[i9] = (byte) (iS & 255);
            bArr2[i9 + 1] = (byte) (iS >> 8);
            for (int i10 = 0; i10 < i7 * 2; i10++) {
                byte b = bArr[((i10 / 8) * i4 * 4) + i6 + ((i10 / 2) % 4)];
                int i11 = i10 % 2 == 0 ? b & 15 : (b & 255) >> 4;
                int i12 = ((((i11 & 7) * 2) + 1) * i8) >> 3;
                if ((i11 & 8) != 0) {
                    i12 = -i12;
                }
                iS = fy4.s(iS + i12, -32768, 32767);
                i9 += i4 * 2;
                bArr2[i9] = (byte) (iS & 255);
                bArr2[i9 + 1] = (byte) (iS >> 8);
                int i13 = iMin + m[i11];
                int[] iArr = n;
                iMin = fy4.s(i13, 0, iArr.length - 1);
                i8 = iArr[iMin];
            }
        }

        public final int f(int i) {
            return i / (this.c.b * 2);
        }

        public final int g(int i) {
            return h(i, this.c.b);
        }

        public final void i(int i) {
            long jU1 = this.j + fy4.u1(this.l, 1000000L, this.c.c);
            int iG = g(i);
            this.b.b(jU1, 1, iG, this.k - iG, null);
            this.l += (long) i;
            this.k -= iG;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(long j);

        boolean b(jz0 jz0Var, long j);

        void c(int i, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements b {
        public final mz0 a;
        public final gr4 b;
        public final p85 c;
        public final t41 d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public c(mz0 mz0Var, gr4 gr4Var, p85 p85Var, String str, int i) throws r83 {
            this.a = mz0Var;
            this.b = gr4Var;
            this.c = p85Var;
            int i2 = (p85Var.b * p85Var.f) / 8;
            if (p85Var.e != i2) {
                throw r83.a("Expected block size: " + i2 + "; got: " + p85Var.e, null);
            }
            int i3 = p85Var.c;
            int i4 = i3 * i2 * 8;
            int iMax = Math.max(i2, (i3 * i2) / 10);
            this.e = iMax;
            this.d = new t41.b().X("audio/wav").A0(str).T(i4).u0(i4).p0(iMax).U(p85Var.b).B0(p85Var.c).t0(i).Q();
        }

        @Override // o85.b
        public void a(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }

        @Override // o85.b
        public boolean b(jz0 jz0Var, long j) {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int iD = this.b.d(jz0Var, (int) Math.min(i2 - i, j2), true);
                if (iD == -1) {
                    j2 = 0;
                } else {
                    this.g += iD;
                    j2 -= (long) iD;
                }
            }
            int i3 = this.c.e;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long jU1 = this.f + fy4.u1(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.b(jU1, 1, i5, i6, null);
                this.h += (long) i4;
                this.g = i6;
            }
            return j2 <= 0;
        }

        @Override // o85.b
        public void c(int i, long j) {
            r85 r85Var = new r85(this.c, 1, i, j);
            this.a.u(r85Var);
            this.b.g(this.d);
            this.b.e(r85Var.i());
        }
    }

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new o85()};
    }

    private void h() {
        gg3.q(this.b);
        fy4.l(this.a);
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.c = j == 0 ? 0 : 4;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(j2);
        }
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a = mz0Var;
        this.b = mz0Var.e(0, 1);
        mz0Var.o();
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        h();
        int i = this.c;
        if (i == 0) {
            i(jz0Var);
            return 0;
        }
        if (i == 1) {
            k(jz0Var);
            return 0;
        }
        if (i == 2) {
            j(jz0Var);
            return 0;
        }
        if (i == 3) {
            m(jz0Var);
            return 0;
        }
        if (i == 4) {
            return l(jz0Var);
        }
        z20.a();
        return 0;
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return q85.a(jz0Var);
    }

    public final void i(jz0 jz0Var) throws r83 {
        gg3.v(jz0Var.getPosition() == 0);
        int i = this.f;
        if (i != -1) {
            jz0Var.q(i);
            this.c = 4;
        } else {
            if (!q85.a(jz0Var)) {
                throw r83.a("Unsupported or unrecognized wav file type.", null);
            }
            jz0Var.q((int) (jz0Var.k() - jz0Var.getPosition()));
            this.c = 1;
        }
    }

    public final void j(jz0 jz0Var) throws r83 {
        p85 p85VarB = q85.b(jz0Var);
        int i = p85VarB.a;
        if (i == 17) {
            this.e = new a(this.a, this.b, p85VarB);
        } else if (i == 6) {
            this.e = new c(this.a, this.b, p85VarB, "audio/g711-alaw", -1);
        } else if (i == 7) {
            this.e = new c(this.a, this.b, p85VarB, "audio/g711-mlaw", -1);
        } else {
            int iA = s85.a(i, p85VarB.f);
            if (iA == 0) {
                throw r83.e("Unsupported WAV format type: " + p85VarB.a);
            }
            this.e = new c(this.a, this.b, p85VarB, "audio/raw", iA);
        }
        this.c = 3;
    }

    public final void k(jz0 jz0Var) {
        this.d = q85.c(jz0Var);
        this.c = 2;
    }

    public final int l(jz0 jz0Var) {
        gg3.v(this.g != -1);
        return ((b) gg3.q(this.e)).b(jz0Var, this.g - jz0Var.getPosition()) ? -1 : 0;
    }

    public final void m(jz0 jz0Var) throws r83 {
        Pair pairE = q85.e(jz0Var);
        this.f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j = this.d;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        this.g = ((long) this.f) + jLongValue;
        long length = jz0Var.getLength();
        if (length != -1 && this.g > length) {
            xz1.i("WavExtractor", "Data exceeds input length: " + this.g + ", " + length);
            this.g = length;
        }
        ((b) gg3.q(this.e)).c(this.f, this.g);
        this.c = 4;
    }

    @Override // defpackage.hz0
    public void release() {
    }
}

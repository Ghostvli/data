package defpackage;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ka4 {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public final b i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public double q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements b {
        public final float[] a;
        public float[] b;
        public float[] c;
        public float[] d;
        public double e;
        public double f;
        public double g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            this.a = new float[ka4.this.h];
            this.b = new float[ka4.this.h * ka4.this.b];
            this.c = new float[ka4.this.h * ka4.this.b];
            this.d = new float[ka4.this.h * ka4.this.b];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public int a(int i, int i2, int i3) {
            return s(this.a, i, i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void b(int i, long j, long j2) {
            int i2 = 0;
            while (i2 < ka4.this.b) {
                a aVar = this;
                this.c[(ka4.this.k * ka4.this.b) + i2] = aVar.w(this.d, (ka4.this.b * i) + i2, j, j2);
                i2++;
                this = aVar;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void c(int i, int i2) {
            for (int i3 = 0; i3 < ka4.this.b * i2; i3++) {
                this.b[i + i3] = 0.0f;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void d(int i, int i2) {
            int i3 = ka4.this.h / i2;
            int i4 = ka4.this.b * i2;
            int i5 = i * ka4.this.b;
            for (int i6 = 0; i6 < i3; i6++) {
                double d = 0.0d;
                for (int i7 = 0; i7 < i4; i7++) {
                    d += (double) this.b[(i6 * i4) + i5 + i7];
                }
                this.a[i6] = (float) (d / ((double) i4));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public int e(int i, int i2, int i3) {
            return s(this.b, i, i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void f() {
            this.g = this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void flush() {
            this.g = 0.0d;
            this.e = 0.0d;
            this.f = 0.0d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void i(int i) {
            this.c = r(this.c, ka4.this.k, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public boolean j() {
            if (this.e == 0.0d || ka4.this.p == 0) {
                return false;
            }
            double d = this.f;
            double d2 = this.e;
            return d <= d2 * 3.0d && d2 * 2.0d > this.g * 3.0d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void l(int i, int i2, int i3, int i4, int i5) {
            float[] fArr = this.c;
            float[] fArr2 = this.b;
            x(i, i2, fArr, i3, fArr2, i4, fArr2, i5);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void m(ByteBuffer byteBuffer, int i) {
            byteBuffer.asFloatBuffer().get(this.b, ka4.this.j * ka4.this.b, i / o());
            byteBuffer.position(byteBuffer.position() + i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void n(int i) {
            this.d = r(this.d, ka4.this.l, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public int o() {
            return 4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void p(int i) {
            this.b = r(this.b, ka4.this.j, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void q(ByteBuffer byteBuffer, int i) {
            byteBuffer.asFloatBuffer().put(this.c, 0, ka4.this.b * i);
            byteBuffer.position(byteBuffer.position() + (i * o() * ka4.this.b));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final float[] r(float[] fArr, int i, int i2) {
            int length = fArr.length / ka4.this.b;
            return i + i2 <= length ? fArr : Arrays.copyOf(fArr, (((length * 3) / 2) + i2) * ka4.this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int s(float[] fArr, int i, int i2, int i3) {
            int i4 = ka4.this.b * i;
            double d = 1.0d;
            int i5 = 0;
            double d2 = 0.0d;
            int i6 = 255;
            int i7 = i2;
            while (i7 <= i3) {
                double dAbs = 0.0d;
                for (int i8 = 0; i8 < i7; i8++) {
                    dAbs += (double) Math.abs(fArr[i4 + i8] - fArr[(i4 + i7) + i8]);
                }
                int i9 = i4;
                double d3 = i7;
                if (((double) i5) * dAbs < d * d3) {
                    i5 = i7;
                    d = dAbs;
                }
                if (((double) i6) * dAbs > d3 * d2) {
                    i6 = i7;
                    d2 = dAbs;
                }
                i7++;
                i4 = i9;
            }
            this.e = d / ((double) i5);
            this.f = d2 / ((double) i6);
            return i5;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: g()Ljava/lang/Object; */
        @Override // ka4.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public float[] g() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: h()Ljava/lang/Object; */
        @Override // ka4.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public float[] h() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: k()Ljava/lang/Object; */
        @Override // ka4.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public float[] k() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final float w(float[] fArr, int i, long j, long j2) {
            float f = fArr[i];
            float f2 = fArr[i + ka4.this.b];
            long j3 = ((long) ka4.this.n) * j;
            long j4 = ((long) ka4.this.m) * j2;
            long j5 = ((long) (ka4.this.m + 1)) * j2;
            long j6 = j5 - j3;
            return ((j6 * f) + ((r3 - j6) * f2)) / (j5 - j4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void x(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, float[] fArr3, int i5) {
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = (i3 * i2) + i6;
                int i8 = (i5 * i2) + i6;
                int i9 = (i4 * i2) + i6;
                for (int i10 = 0; i10 < i; i10++) {
                    fArr[i7] = ((fArr2[i9] * (i - i10)) + (fArr3[i8] * i10)) / i;
                    i7 += i2;
                    i9 += i2;
                    i8 += i2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        int a(int i, int i2, int i3);

        void b(int i, long j, long j2);

        void c(int i, int i2);

        void d(int i, int i2);

        int e(int i, int i2, int i3);

        void f();

        void flush();

        Object g();

        Object h();

        void i(int i);

        boolean j();

        Object k();

        void l(int i, int i2, int i3, int i4, int i5);

        void m(ByteBuffer byteBuffer, int i);

        void n(int i);

        int o();

        void p(int i);

        void q(ByteBuffer byteBuffer, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements b {
        public final short[] a;
        public short[] b;
        public short[] c;
        public short[] d;
        public int e;
        public int f;
        public int g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
            this.a = new short[ka4.this.h];
            this.b = new short[ka4.this.h * ka4.this.b];
            this.c = new short[ka4.this.h * ka4.this.b];
            this.d = new short[ka4.this.h * ka4.this.b];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public int a(int i, int i2, int i3) {
            return s(this.a, i, i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void b(int i, long j, long j2) {
            int i2 = 0;
            while (i2 < ka4.this.b) {
                c cVar = this;
                this.c[(ka4.this.k * ka4.this.b) + i2] = cVar.w(this.d, (ka4.this.b * i) + i2, j, j2);
                i2++;
                this = cVar;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void c(int i, int i2) {
            for (int i3 = 0; i3 < ka4.this.b * i2; i3++) {
                this.b[i + i3] = 0;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void d(int i, int i2) {
            short[] sArr = this.b;
            int i3 = ka4.this.h / i2;
            int i4 = ka4.this.b * i2;
            int i5 = i * ka4.this.b;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    i7 += sArr[(i6 * i4) + i5 + i8];
                }
                this.a[i6] = (short) (i7 / i4);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public int e(int i, int i2, int i3) {
            return s(this.b, i, i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void f() {
            this.g = this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void flush() {
            this.g = 0;
            this.e = 0;
            this.f = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void i(int i) {
            this.c = r(this.c, ka4.this.k, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public boolean j() {
            if (this.e == 0 || ka4.this.p == 0) {
                return false;
            }
            int i = this.f;
            int i2 = this.e;
            return i <= i2 * 3 && i2 * 2 > this.g * 3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void l(int i, int i2, int i3, int i4, int i5) {
            short[] sArr = this.c;
            short[] sArr2 = this.b;
            x(i, i2, sArr, i3, sArr2, i4, sArr2, i5);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void m(ByteBuffer byteBuffer, int i) {
            byteBuffer.asShortBuffer().get(this.b, ka4.this.j * ka4.this.b, i / 2);
            byteBuffer.position(byteBuffer.position() + i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void n(int i) {
            this.d = r(this.d, ka4.this.l, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public int o() {
            return 2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void p(int i) {
            this.b = r(this.b, ka4.this.j, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ka4.b
        public void q(ByteBuffer byteBuffer, int i) {
            byteBuffer.asShortBuffer().put(this.c, 0, ka4.this.b * i);
            byteBuffer.position(byteBuffer.position() + (i * o() * ka4.this.b));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final short[] r(short[] sArr, int i, int i2) {
            int length = sArr.length / ka4.this.b;
            return i + i2 <= length ? sArr : Arrays.copyOf(sArr, (((length * 3) / 2) + i2) * ka4.this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int s(short[] sArr, int i, int i2, int i3) {
            int i4 = i * ka4.this.b;
            int i5 = 255;
            int i6 = 1;
            int i7 = 0;
            int i8 = 0;
            while (i2 <= i3) {
                int iAbs = 0;
                for (int i9 = 0; i9 < i2; i9++) {
                    iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
                }
                if (iAbs * i7 < i6 * i2) {
                    i7 = i2;
                    i6 = iAbs;
                }
                if (iAbs * i5 > i8 * i2) {
                    i5 = i2;
                    i8 = iAbs;
                }
                i2++;
            }
            this.e = i6 / i7;
            this.f = i8 / i5;
            return i7;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: g()Ljava/lang/Object; */
        @Override // ka4.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public short[] g() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: h()Ljava/lang/Object; */
        @Override // ka4.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public short[] h() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: k()Ljava/lang/Object; */
        @Override // ka4.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public short[] k() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final short w(short[] sArr, int i, long j, long j2) {
            short s = sArr[i];
            short s2 = sArr[i + ka4.this.b];
            long j3 = ((long) ka4.this.n) * j;
            long j4 = ((long) ka4.this.m) * j2;
            long j5 = ((long) (ka4.this.m + 1)) * j2;
            long j6 = j5 - j3;
            long j7 = j5 - j4;
            return (short) (((((long) s) * j6) + ((j7 - j6) * ((long) s2))) / j7);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void x(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = (i3 * i2) + i6;
                int i8 = (i5 * i2) + i6;
                int i9 = (i4 * i2) + i6;
                for (int i10 = 0; i10 < i; i10++) {
                    sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                    i7 += i2;
                    i9 += i2;
                    i8 += i2;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ka4(int i, int i2, float f, float f2, int i3, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = i / i3;
        this.f = i / 400;
        int i4 = i / 65;
        this.g = i4;
        this.h = i4 * 2;
        this.i = z ? new a() : new c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(float f, int i) {
        int i2;
        int i3;
        if (this.k == i) {
            return;
        }
        int i4 = this.a;
        long j = (long) (i4 / f);
        long j2 = i4;
        while (j != 0 && j2 != 0 && j % 2 == 0 && j2 % 2 == 0) {
            j /= 2;
            j2 /= 2;
        }
        s(i);
        int i5 = 0;
        while (true) {
            int i6 = this.l;
            if (i5 >= i6 - 1) {
                w(i6 - 1);
                return;
            }
            while (true) {
                i2 = this.m;
                long j3 = ((long) (i2 + 1)) * j;
                i3 = this.n;
                if (j3 <= ((long) i3) * j2) {
                    break;
                }
                this.i.i(1);
                this.i.b(i5, j2, j);
                this.n++;
                this.k++;
            }
            int i7 = i2 + 1;
            this.m = i7;
            if (i7 == j2) {
                this.m = 0;
                gg3.v(((long) i3) == j);
                this.n = 0;
            }
            i5++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(double d) {
        int iY;
        int i = this.j;
        if (i < this.h) {
            return;
        }
        int i2 = 0;
        do {
            if (this.o > 0) {
                iY = k(i2);
            } else {
                int iM = m(i2);
                iY = d > 1.0d ? iM + y(i2, d, iM) : r(i2, d, iM);
            }
            i2 += iY;
        } while (this.h + i2 <= i);
        x(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int k(int i) {
        int iMin = Math.min(this.h, this.o);
        l(i, iMin);
        this.o -= iMin;
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(int i, int i2) {
        this.i.i(i2);
        Object objG = this.i.g();
        int i3 = i * this.b;
        Object objH = this.i.h();
        int i4 = this.k;
        int i5 = this.b;
        System.arraycopy(objG, i3, objH, i4 * i5, i5 * i2);
        this.k += i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int m(int i) {
        int iA;
        int i2 = this.a;
        int i3 = i2 > 4000 ? i2 / 4000 : 1;
        if (this.b == 1 && i3 == 1) {
            iA = this.i.e(i, this.f, this.g);
        } else {
            this.i.d(i, i3);
            int iA2 = this.i.a(0, this.f / i3, this.g / i3);
            if (i3 != 1) {
                int i4 = iA2 * i3;
                int i5 = i3 * 4;
                int i6 = i4 - i5;
                int i7 = i4 + i5;
                int i8 = this.f;
                if (i6 < i8) {
                    i6 = i8;
                }
                int i9 = this.g;
                if (i7 > i9) {
                    i7 = i9;
                }
                int i10 = this.b;
                b bVar = this.i;
                if (i10 == 1) {
                    iA = bVar.e(i, i6, i7);
                } else {
                    bVar.d(i, 1);
                    iA = this.i.a(0, i6, i7);
                }
            } else {
                iA = iA2;
            }
        }
        int i11 = this.i.j() ? this.p : iA;
        this.i.f();
        this.p = iA;
        return i11;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0.0d;
        this.i.flush();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(ByteBuffer byteBuffer) {
        gg3.v(this.k >= 0);
        int iMin = Math.min(byteBuffer.remaining() / (this.b * this.i.o()), this.k);
        this.i.q(byteBuffer, iMin);
        this.k -= iMin;
        System.arraycopy(this.i.h(), iMin * this.b, this.i.h(), 0, this.k * this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p() {
        gg3.v(this.k >= 0);
        return this.k * this.b * this.i.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int q() {
        return this.j * this.b * this.i.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int r(int i, double d, int i2) {
        int iRound;
        double d2 = this.q;
        if (d < 0.5d) {
            double d3 = ((((double) i2) * d) / (1.0d - d)) + d2;
            iRound = (int) Math.round(d3);
            this.q = d3 - ((double) iRound);
        } else {
            double d4 = ((((double) i2) * ((2.0d * d) - 1.0d)) / (1.0d - d)) + d2;
            int iRound2 = (int) Math.round(d4);
            this.o = iRound2;
            this.q = d4 - ((double) iRound2);
            iRound = i2;
        }
        int i3 = i2 + iRound;
        this.i.i(i3);
        Object objG = this.i.g();
        int i4 = this.b * i;
        Object objH = this.i.h();
        int i5 = this.k;
        int i6 = this.b;
        System.arraycopy(objG, i4, objH, i5 * i6, i6 * i2);
        this.i.l(iRound, this.b, this.k + i2, i + i2, i);
        this.k += i3;
        return iRound;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(int i) {
        int i2 = this.k - i;
        this.i.n(i2);
        Object objH = this.i.h();
        int i3 = this.b * i;
        Object objK = this.i.k();
        int i4 = this.l;
        int i5 = this.b;
        System.arraycopy(objH, i3, objK, i4 * i5, i5 * i2);
        this.k = i;
        this.l += i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t() {
        int i = this.k;
        float f = this.c;
        float f2 = this.d;
        double d = f / f2;
        float f3 = this.e * f2;
        if (d > 1.0000100135803223d || d < 0.9999899864196777d) {
            j(d);
        } else {
            l(0, this.j);
            this.j = 0;
        }
        if (f3 != 1.0f) {
            i(f3, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u() {
        int i = this.j;
        float f = this.c;
        float f2 = this.d;
        double d = f / f2;
        double d2 = this.e * f2;
        int i2 = this.o;
        int i3 = this.k + ((int) ((((((((double) (i - i2)) / d) + ((double) i2)) + this.q) + ((double) this.l)) / d2) + 0.5d));
        this.q = 0.0d;
        this.i.p((this.h * 2) + i);
        this.i.c(i * this.b, this.h * 2);
        this.j += this.h * 2;
        t();
        if (this.k > i3) {
            this.k = Math.max(i3, 0);
        }
        this.j = 0;
        this.o = 0;
        this.l = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        int iO = iRemaining / (this.b * this.i.o());
        this.i.p(iO);
        this.i.m(byteBuffer, iRemaining);
        this.j += iO;
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(int i) {
        if (i == 0) {
            return;
        }
        System.arraycopy(this.i.k(), this.b * i, this.i.k(), 0, (this.l - i) * this.b);
        this.l -= i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(int i) {
        int i2 = this.j - i;
        System.arraycopy(this.i.g(), i * this.b, this.i.g(), 0, this.b * i2);
        this.j = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int y(int i, double d, int i2) {
        int i3;
        double d2 = this.q;
        if (d >= 2.0d) {
            double d3 = (((double) i2) / (d - 1.0d)) + d2;
            int iRound = (int) Math.round(d3);
            this.q = d3 - ((double) iRound);
            i3 = iRound;
        } else {
            double d4 = ((((double) i2) * (2.0d - d)) / (d - 1.0d)) + d2;
            int iRound2 = (int) Math.round(d4);
            this.o = iRound2;
            this.q = d4 - ((double) iRound2);
            i3 = i2;
        }
        this.i.i(i3);
        this.i.l(i3, this.b, this.k, i, i + i2);
        this.k += i3;
        return i3;
    }
}

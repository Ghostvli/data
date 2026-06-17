package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rb4 extends ih {
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public long R;
    public long S;
    public c T;
    public int U;
    public int Y;
    public int Z;
    public int a0;
    public long b0;
    public a[] d0;
    public int V = 0;
    public int W = 0;
    public boolean X = false;
    public float[] c0 = new float[4];

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a {
        public b a;
        public b b;
        public long c;
        public long d;
        public long e;
        public float f;
        public float g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float[] a() {
            b bVar = this.a;
            return new float[]{bVar.a, bVar.b};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float b() {
            return this.b.a(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float[] c() {
            b bVar = this.b;
            return new float[]{bVar.a, bVar.b};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(b bVar, b bVar2) {
            this.a = bVar;
            this.b = bVar2;
            this.f = bVar2.a - bVar.a;
            this.g = bVar2.b - bVar.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b {
        public float a;
        public float b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float a(b bVar) {
            float fAbs = Math.abs(this.a - bVar.a);
            float fAbs2 = Math.abs(this.b - bVar.b);
            return (float) Math.sqrt((fAbs * fAbs) + (fAbs2 * fAbs2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public int a = 0;
        public float b;
        public float c;
        public int d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, int i2, float f, float f2) {
            b(i, i2, f, f2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a(int i, int i2, int i3) {
            if (this.a != i) {
                return (this.d == i2 && this.e == i3) ? false : true;
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i, int i2, float f, float f2) {
            if (Float.compare(this.b, f) != 0 || Float.compare(this.c, f2) != 0) {
                this.a++;
            }
            this.d = i;
            this.e = i2;
            this.b = f;
            this.c = f2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final float F(long j, long j2) {
        float f = j / j2;
        return (-1.0f) * f * (f - 2.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(float[][] fArr) {
        a[] aVarArr;
        if (fArr != null) {
            int length = fArr.length;
            int i = 0;
            float[] fArr2 = fArr[0];
            this.L = fArr2[0];
            this.M = fArr2[1];
            float[] fArr3 = fArr[length - 1];
            this.N = fArr3[0];
            this.O = fArr3[1];
            if (fArr.length > 1) {
                this.d0 = new a[fArr.length - 1];
                int i2 = 0;
                while (true) {
                    aVarArr = this.d0;
                    if (i2 >= aVarArr.length) {
                        break;
                    }
                    aVarArr[i2] = new a();
                    a aVar = this.d0[i2];
                    float[] fArr4 = fArr[i2];
                    b bVar = new b(fArr4[0], fArr4[1]);
                    i2++;
                    float[] fArr5 = fArr[i2];
                    aVar.d(bVar, new b(fArr5[0], fArr5[1]));
                }
                float fB = 0.0f;
                for (a aVar2 : aVarArr) {
                    fB += aVar2.b();
                }
                a[] aVarArr2 = this.d0;
                int length2 = aVarArr2.length;
                a aVar3 = null;
                while (i < length2) {
                    a aVar4 = aVarArr2[i];
                    long jB = (long) ((aVar4.b() / fB) * this.R);
                    aVar4.c = jB;
                    long j = aVar3 == null ? 0L : aVar3.e;
                    aVar4.d = j;
                    aVar4.e = j + jB;
                    i++;
                    aVar3 = aVar4;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H(c cVar) {
        this.T = cVar;
        this.U = cVar.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(float f, float f2, float f3, float f4, long j, long j2) {
        this.L = f;
        this.M = f2;
        this.N = f3;
        this.O = f4;
        this.P = f3 - f;
        this.Q = f4 - f2;
        this.R = j;
        this.S = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public float d() {
        return this.c0[3];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public float g() {
        return this.c0[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public float[] h(fh1 fh1Var, long j) {
        char c2;
        a aVar;
        int i;
        if (!q()) {
            return null;
        }
        char c3 = 2;
        if (this.T.a(this.U, this.V, this.W)) {
            c cVar = this.T;
            float f = cVar.b;
            float f2 = cVar.c;
            I(this.L * f, this.M * f2, this.N * f, this.O * f2, this.R, this.S);
            a[] aVarArr = this.d0;
            if (aVarArr != null && aVarArr.length > 0) {
                int length = aVarArr.length;
                float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, length + 1, 2);
                int i2 = 0;
                while (i2 < length) {
                    fArr[i2] = this.d0[i2].a();
                    int i3 = i2 + 1;
                    fArr[i3] = this.d0[i2].c();
                    i2 = i3;
                }
                for (float[] fArr2 : fArr) {
                    fArr2[0] = fArr2[0] * f;
                    fArr2[1] = fArr2[1] * f2;
                }
                G(fArr);
            }
            c cVar2 = this.T;
            this.U = cVar2.a;
            this.V = cVar2.d;
            this.W = cVar2.e;
        }
        long jB = j - b();
        long j2 = this.b0;
        if (j2 > 0 && (i = this.a0) != 0) {
            if (jB >= j2) {
                this.E = this.Z;
            } else {
                this.E = this.Y + ((int) (i * (jB / j2)));
            }
        }
        float f3 = this.L;
        float f4 = this.M;
        long j3 = jB - this.S;
        long j4 = this.R;
        if (j4 <= 0 || j3 < 0 || j3 > j4) {
            c2 = 2;
            if (j3 > j4) {
                f3 = this.N;
                f4 = this.O;
            }
        } else {
            a[] aVarArr2 = this.d0;
            if (aVarArr2 != null) {
                int length2 = aVarArr2.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        c2 = c3;
                        aVar = null;
                        break;
                    }
                    a aVar2 = aVarArr2[i4];
                    c2 = c3;
                    if (j3 >= aVar2.d && j3 < aVar2.e) {
                        aVar = aVar2;
                        break;
                    }
                    b bVar = aVar2.b;
                    float f5 = bVar.a;
                    i4++;
                    f4 = bVar.b;
                    f3 = f5;
                    c3 = c2;
                }
                if (aVar != null) {
                    float f6 = aVar.f;
                    float f7 = aVar.g;
                    float f8 = (jB - aVar.d) / aVar.c;
                    b bVar2 = aVar.a;
                    float f9 = bVar2.a;
                    float f10 = bVar2.b;
                    if (f6 != 0.0f) {
                        f3 = f9 + (f6 * f8);
                    }
                    if (f7 != 0.0f) {
                        f4 = f10 + (f7 * f8);
                    }
                }
            } else {
                c2 = 2;
                float F = this.X ? F(j3, j4) : j3 / j4;
                float f11 = this.P;
                if (f11 != 0.0f) {
                    f3 = this.L + (f11 * F);
                }
                float f12 = this.Q;
                if (f12 != 0.0f) {
                    f4 = this.M + (f12 * F);
                }
            }
        }
        float[] fArr3 = this.c0;
        fArr3[0] = f3;
        fArr3[1] = f4;
        fArr3[c2] = f3 + this.o;
        fArr3[3] = f4 + this.p;
        E(!s());
        return this.c0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public float i() {
        return this.c0[2];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public float l() {
        return this.c0[1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public int m() {
        return 7;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public void y(fh1 fh1Var, float f, float f2) {
        h(fh1Var, this.D.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ih
    public void z(fh1 fh1Var, boolean z) {
        super.z(fh1Var, z);
        if (this.V == 0 || this.W == 0) {
            this.V = fh1Var.b();
            this.W = fh1Var.a();
        }
    }
}

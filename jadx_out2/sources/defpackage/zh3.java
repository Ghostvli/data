package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zh3 {
    public final a a;
    public final a b;
    public final int c;
    public final boolean d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final b[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(b... bVarArr) {
            this.a = bVarArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b a(int i) {
            return this.a[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            return this.a.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final int b;
        public final float[] c;
        public final float[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.a = i;
            gg3.d(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.c = fArr;
            this.d = fArr2;
            this.b = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int a() {
            return this.c.length / 3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zh3(a aVar, a aVar2, int i) {
        this.a = aVar;
        this.b = aVar2;
        this.c = i;
        this.d = aVar == aVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zh3 a(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        int i5 = i;
        gg3.d(f > 0.0f);
        gg3.d(i5 >= 1);
        gg3.d(i2 >= 1);
        gg3.d(f2 > 0.0f && f2 <= 180.0f);
        gg3.d(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
        float f4 = radians / i5;
        float f5 = radians2 / i2;
        int i6 = i2 + 1;
        int i7 = ((i6 * 2) + 2) * i5;
        float[] fArr = new float[i7 * 3];
        float[] fArr2 = new float[i7 * 2];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < i5) {
            float f6 = radians / 2.0f;
            float f7 = (i8 * f4) - f6;
            int i11 = i8 + 1;
            float f8 = (i11 * f4) - f6;
            int i12 = 0;
            while (i12 < i6) {
                float f9 = radians;
                float f10 = radians2;
                int i13 = 0;
                int i14 = 2;
                while (i13 < i14) {
                    float f11 = f4;
                    float f12 = i12 * f5;
                    float f13 = f5;
                    float f14 = f7;
                    double d = f;
                    double d2 = (f12 + 3.1415927f) - (f10 / 2.0f);
                    double d3 = i13 == 0 ? f7 : f8;
                    fArr[i9] = -((float) (Math.cos(d3) * Math.sin(d2) * d));
                    fArr[i9 + 1] = (float) (d * Math.sin(d3));
                    int i15 = i9 + 3;
                    fArr[i9 + 2] = (float) (d * Math.cos(d2) * Math.cos(d3));
                    fArr2[i10] = f12 / f10;
                    int i16 = i10 + 2;
                    fArr2[i10 + 1] = ((i8 + i13) * f11) / f9;
                    if ((i12 == 0 && i13 == 0) || (i12 == i2 && i13 == 1)) {
                        System.arraycopy(fArr, i9, fArr, i15, 3);
                        i9 += 6;
                        i4 = 2;
                        System.arraycopy(fArr2, i10, fArr2, i16, 2);
                        i10 += 4;
                    } else {
                        i4 = 2;
                        i9 = i15;
                        i10 = i16;
                    }
                    i13++;
                    i14 = i4;
                    f4 = f11;
                    f5 = f13;
                    f7 = f14;
                }
                i12++;
                radians2 = f10;
                radians = f9;
                f4 = f4;
            }
            i5 = i;
            i8 = i11;
        }
        return new zh3(new a(new b(0, fArr, fArr2, 1)), i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zh3 b(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public zh3(a aVar, int i) {
        this(aVar, aVar, i);
    }
}

package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v11 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final long[] a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;
        public final long g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j, long j2) {
            this.a = jArr;
            this.b = iArr;
            this.c = i;
            this.d = jArr2;
            this.e = iArr2;
            this.f = j;
            this.g = j2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b a(int i, long[] jArr, int[] iArr, long j) {
        int[] iArr2 = iArr;
        int i2 = 8192 / i;
        int i3 = 0;
        int iN = 0;
        for (int i4 : iArr2) {
            iN += fy4.n(i4, i2);
        }
        long[] jArr2 = new long[iN];
        int[] iArr3 = new int[iN];
        long[] jArr3 = new long[iN];
        int[] iArr4 = new int[iN];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int iMax = 0;
        while (i3 < iArr2.length) {
            int i8 = iArr2[i3];
            long j2 = jArr[i3];
            while (i8 > 0) {
                int iMin = Math.min(i2, i8);
                jArr2[i7] = j2;
                int i9 = i * iMin;
                iArr3[i7] = i9;
                i6 += i9;
                iMax = Math.max(iMax, i9);
                jArr3[i7] = ((long) i5) * j;
                iArr4[i7] = 1;
                j2 += (long) iArr3[i7];
                i5 += iMin;
                i8 -= iMin;
                i7++;
                i2 = i2;
            }
            i3++;
            iArr2 = iArr;
        }
        return new b(jArr2, iArr3, iMax, jArr3, iArr4, j * ((long) i5), i6);
    }
}

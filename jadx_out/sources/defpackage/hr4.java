package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hr4 {
    public final iq4 a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final int[] h;
    public final long i;
    public final boolean j;

    public hr4(iq4 iq4Var, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, int[] iArr3, boolean z, long j, int i2) {
        gg3.d(iArr.length == jArr2.length);
        gg3.d(jArr.length == jArr2.length);
        gg3.d(iArr2.length == jArr2.length);
        this.a = iq4Var;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = iArr3;
        this.j = z;
        this.i = j;
        this.b = i2;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        int i = 0;
        if (this.j) {
            return fy4.k(this.f, j, true, false);
        }
        int length = this.h.length - 1;
        int i2 = -1;
        while (i <= length) {
            int i3 = ((length - i) / 2) + i;
            if (this.f[this.h[i3]] <= j) {
                i = i3 + 1;
                i2 = i3;
            } else {
                length = i3 - 1;
            }
        }
        if (i2 == -1) {
            return -1;
        }
        long j2 = this.f[this.h[i2]];
        if (j2 == j) {
            while (i2 > 0 && this.f[this.h[i2 - 1]] == j2) {
                i2--;
            }
        }
        return this.h[i2];
    }

    public int b(long j) {
        int i = 0;
        if (this.j) {
            return fy4.g(this.f, j, true, false);
        }
        int length = this.h.length - 1;
        int i2 = -1;
        while (i <= length) {
            int i3 = ((length - i) / 2) + i;
            if (this.f[this.h[i3]] >= j) {
                length = i3 - 1;
                i2 = i3;
            } else {
                i = i3 + 1;
            }
        }
        if (i2 == -1) {
            return -1;
        }
        long j2 = this.f[this.h[i2]];
        if (j2 == j) {
            while (true) {
                int[] iArr = this.h;
                if (i2 >= iArr.length - 1) {
                    break;
                }
                int i4 = i2 + 1;
                if (this.f[iArr[i4]] != j2) {
                    break;
                }
                i2 = i4;
            }
        }
        return this.h[i2];
    }
}

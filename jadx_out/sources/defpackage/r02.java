package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r02 {
    public int a;
    public long[] b;

    public r02(int i) {
        this.b = new long[i];
    }

    public void a(long j) {
        int i = this.a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public void b(long[] jArr) {
        int length = this.a + jArr.length;
        long[] jArr2 = this.b;
        if (length > jArr2.length) {
            this.b = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, this.b, this.a, jArr.length);
        this.a = length;
    }

    public long c(int i) {
        if (i >= 0 && i < this.a) {
            return this.b[i];
        }
        q02.a("Invalid index ", i, ", size is ", this.a);
        return 0L;
    }

    public int d() {
        return this.a;
    }
}

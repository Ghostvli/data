package defpackage;

import defpackage.yz3;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class st implements yz3 {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public final long f;

    public st(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    public int b(long j) {
        return fy4.k(this.e, j, true, true);
    }

    @Override // defpackage.yz3
    public boolean e() {
        return true;
    }

    @Override // defpackage.yz3
    public yz3.a g(long j) {
        int iB = b(j);
        a04 a04Var = new a04(this.e[iB], this.c[iB]);
        if (a04Var.a >= j || iB == this.a - 1) {
            return new yz3.a(a04Var);
        }
        int i = iB + 1;
        return new yz3.a(a04Var, new a04(this.e[i], this.c[i]));
    }

    @Override // defpackage.yz3
    public long i() {
        return this.f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}

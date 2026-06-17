package defpackage;

import defpackage.dv2;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class na5 implements b04 {
    public final long a;
    public final int b;
    public final long c;
    public final int d;
    public final long e;
    public final long f;
    public final long[] g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public na5(long j, int i, long j2, int i2, long j3, long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.d = i2;
        this.e = j3;
        this.g = jArr;
        this.f = j3 != -1 ? j + j3 : -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static na5 b(ma5 ma5Var, long j) {
        long jA = ma5Var.a();
        if (jA == -9223372036854775807L) {
            return null;
        }
        dv2.a aVar = ma5Var.a;
        return new na5(j, aVar.c, jA, aVar.f, ma5Var.c, ma5Var.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long a(long j) {
        long j2 = j - this.a;
        if (!e() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) gg3.q(this.g);
        double d = (j2 * 256.0d) / this.e;
        int iK = fy4.k(jArr, (long) d, true, true);
        long j3 = j(iK);
        long j4 = jArr[iK];
        int i = iK + 1;
        long j5 = j(i);
        return j3 + Math.round((j4 == (iK == 99 ? 256L : jArr[i]) ? 0.0d : (d - j4) / (r0 - j4)) * (j5 - j3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long c() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long d() {
        return this.a + ((long) this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public boolean e() {
        return this.g != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public yz3.a g(long j) {
        if (!e()) {
            return new yz3.a(new a04(0L, this.a + ((long) this.b)));
        }
        long jT = fy4.t(j, 0L, this.c);
        double d = (jT * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) gg3.q(this.g))[i];
                d2 = d3 + ((d - ((double) i)) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new yz3.a(new a04(jT, this.a + fy4.t(Math.round((d2 / 256.0d) * this.e), this.b, this.e - 1)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public int h() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public long i() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long j(int i) {
        return (this.c * ((long) i)) / 100;
    }
}

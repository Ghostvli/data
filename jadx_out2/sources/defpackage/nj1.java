package defpackage;

import defpackage.yz3;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nj1 implements b04 {
    public final long a;
    public final long b;
    public final int c;
    public final mj1 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nj1(long j, long j2, long j3) {
        this.d = new mj1(new long[]{j2}, new long[]{0}, j);
        this.a = j2;
        this.b = j3;
        int i = -2147483647;
        if (j == -9223372036854775807L) {
            this.c = -2147483647;
            return;
        }
        long jX1 = fy4.x1(j2 - j3, 8L, j, RoundingMode.HALF_UP);
        if (jX1 > 0 && jX1 <= 2147483647L) {
            i = (int) jX1;
        }
        this.c = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long a(long j) {
        return this.d.a(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b(long j) {
        return this.d.j(j, 100000L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long c() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long d() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public boolean e() {
        return this.d.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public yz3.a g(long j) {
        return this.d.g(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public int h() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public long i() {
        return this.d.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(long j, long j2) {
        if (b(j)) {
            return;
        }
        this.d.b(j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(long j) {
        this.d.k(j);
    }
}

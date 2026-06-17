package defpackage;

import defpackage.f21;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e21 implements yz3 {
    public final f21 a;
    public final long b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e21(f21 f21Var, long j) {
        this.a = f21Var;
        this.b = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final a04 b(long j, long j2) {
        return new a04((j * 1000000) / ((long) this.a.e), this.b + j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public boolean e() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public yz3.a g(long j) {
        gg3.q(this.a.k);
        f21 f21Var = this.a;
        f21.a aVar = f21Var.k;
        long[] jArr = aVar.a;
        long[] jArr2 = aVar.b;
        int iK = fy4.k(jArr, f21Var.i(j), true, false);
        a04 a04VarB = b(iK == -1 ? 0L : jArr[iK], iK != -1 ? jArr2[iK] : 0L);
        if (a04VarB.a == j || iK == jArr.length - 1) {
            return new yz3.a(a04VarB);
        }
        int i = iK + 1;
        return new yz3.a(a04VarB, b(jArr[i], jArr2[i]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public long i() {
        return this.a.f();
    }
}

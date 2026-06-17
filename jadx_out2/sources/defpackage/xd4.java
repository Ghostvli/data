package defpackage;

import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xd4 implements mz0 {
    public final long f;
    public final mz0 g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends h51 {
        public final /* synthetic */ yz3 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yz3 yz3Var, yz3 yz3Var2) {
            super(yz3Var);
            this.b = yz3Var2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h51, defpackage.yz3
        public yz3.a g(long j) {
            yz3.a aVarG = this.b.g(j);
            a04 a04Var = aVarG.a;
            a04 a04Var2 = new a04(a04Var.a, a04Var.b + xd4.this.f);
            a04 a04Var3 = aVarG.b;
            return new yz3.a(a04Var2, new a04(a04Var3.a, a04Var3.b + xd4.this.f));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xd4(long j, mz0 mz0Var) {
        this.f = j;
        this.g = mz0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mz0
    public gr4 e(int i, int i2) {
        return this.g.e(i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mz0
    public void o() {
        this.g.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mz0
    public void u(yz3 yz3Var) {
        this.g.u(new a(yz3Var, yz3Var));
    }
}

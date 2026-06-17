package defpackage;

import defpackage.sr2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i32 extends e32 implements sr2 {
    public sr2.a e;

    public i32(long j) {
        super(j);
    }

    @Override // defpackage.sr2
    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20 || i == 15) {
            m(h() / 2);
        }
    }

    @Override // defpackage.sr2
    public /* bridge */ /* synthetic */ yr3 c(wq1 wq1Var, yr3 yr3Var) {
        return (yr3) super.k(wq1Var, yr3Var);
    }

    @Override // defpackage.sr2
    public void d(sr2.a aVar) {
        this.e = aVar;
    }

    @Override // defpackage.sr2
    public /* bridge */ /* synthetic */ yr3 e(wq1 wq1Var) {
        return (yr3) super.l(wq1Var);
    }

    @Override // defpackage.e32
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(yr3 yr3Var) {
        return yr3Var == null ? super.i(null) : yr3Var.c();
    }

    @Override // defpackage.e32
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(wq1 wq1Var, yr3 yr3Var) {
        sr2.a aVar = this.e;
        if (aVar == null || yr3Var == null) {
            return;
        }
        aVar.d(yr3Var);
    }
}

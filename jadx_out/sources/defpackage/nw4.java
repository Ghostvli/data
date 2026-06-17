package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nw4 extends lw4 {
    @Override // defpackage.lw4
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public mw4 g(Object obj) {
        return ((i91) obj).unknownFields;
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(mw4 mw4Var) {
        return mw4Var.d();
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(mw4 mw4Var) {
        return mw4Var.e();
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public mw4 k(mw4 mw4Var, mw4 mw4Var2) {
        return mw4.c().equals(mw4Var2) ? mw4Var : mw4.c().equals(mw4Var) ? mw4.n(mw4Var, mw4Var2) : mw4Var.k(mw4Var2);
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public mw4 n() {
        return mw4.o();
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, mw4 mw4Var) {
        p(obj, mw4Var);
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, mw4 mw4Var) {
        ((i91) obj).unknownFields = mw4Var;
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public mw4 r(mw4 mw4Var) {
        mw4Var.h();
        return mw4Var;
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(mw4 mw4Var, ha5 ha5Var) {
        mw4Var.t(ha5Var);
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(mw4 mw4Var, ha5 ha5Var) {
        mw4Var.v(ha5Var);
    }

    @Override // defpackage.lw4
    public void j(Object obj) {
        g(obj).h();
    }

    @Override // defpackage.lw4
    public boolean q(io3 io3Var) {
        return false;
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(mw4 mw4Var, int i, int i2) {
        mw4Var.r(aa5.c(i, 5), Integer.valueOf(i2));
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(mw4 mw4Var, int i, long j) {
        mw4Var.r(aa5.c(i, 1), Long.valueOf(j));
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(mw4 mw4Var, int i, mw4 mw4Var2) {
        mw4Var.r(aa5.c(i, 3), mw4Var2);
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(mw4 mw4Var, int i, hn hnVar) {
        mw4Var.r(aa5.c(i, 2), hnVar);
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(mw4 mw4Var, int i, long j) {
        mw4Var.r(aa5.c(i, 0), Long.valueOf(j));
    }

    @Override // defpackage.lw4
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public mw4 f(Object obj) {
        mw4 mw4VarG = g(obj);
        if (mw4VarG != mw4.c()) {
            return mw4VarG;
        }
        mw4 mw4VarO = mw4.o();
        p(obj, mw4VarO);
        return mw4VarO;
    }
}

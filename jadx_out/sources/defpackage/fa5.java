package defpackage;

import defpackage.jq2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fa5 extends oy {
    public static final Void q = null;
    public final jq2 p;

    public fa5(jq2 jq2Var) {
        this.p = jq2Var;
    }

    @Override // defpackage.oy, defpackage.ji
    public final void E(hs4 hs4Var) {
        super.E(hs4Var);
        Y();
    }

    public jq2.b P(jq2.b bVar) {
        return bVar;
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final jq2.b K(Void r1, jq2.b bVar) {
        return P(bVar);
    }

    public long R(long j, jq2.b bVar) {
        return j;
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final long L(Void r1, long j, jq2.b bVar) {
        return R(j, bVar);
    }

    public int T(int i) {
        return i;
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final int M(Void r1, int i) {
        return T(i);
    }

    public abstract void V(no4 no4Var);

    @Override // defpackage.oy
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void N(Void r1, jq2 jq2Var, no4 no4Var) {
        V(no4Var);
    }

    public final void X() {
        O(q, this.p);
    }

    public void Y() {
        X();
    }

    @Override // defpackage.jq2
    public fg2 i() {
        return this.p.i();
    }

    @Override // defpackage.jq2
    public boolean n() {
        return this.p.n();
    }

    @Override // defpackage.jq2
    public no4 o() {
        return this.p.o();
    }

    @Override // defpackage.jq2
    public void q(fg2 fg2Var) {
        this.p.q(fg2Var);
    }
}

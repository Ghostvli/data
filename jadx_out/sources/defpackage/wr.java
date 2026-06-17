package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class wr extends vr {
    public /* synthetic */ wr(z21 z21Var, g40 g40Var, int i, tl tlVar, int i2, we0 we0Var) {
        this(z21Var, (i2 & 2) != 0 ? bs0.f : g40Var, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? tl.f : tlVar);
    }

    @Override // defpackage.tr
    public tr i(g40 g40Var, int i, tl tlVar) {
        return new wr(this.i, g40Var, i, tlVar);
    }

    @Override // defpackage.tr
    public z21 j() {
        return this.i;
    }

    @Override // defpackage.vr
    public Object q(a31 a31Var, f30 f30Var) {
        Object objCollect = this.i.collect(a31Var, f30Var);
        return objCollect == kl1.e() ? objCollect : fw4.a;
    }

    public wr(z21 z21Var, g40 g40Var, int i, tl tlVar) {
        super(z21Var, g40Var, i, tlVar);
    }
}

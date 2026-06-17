package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class qo4 extends ty3 implements Runnable {
    public final long j;

    public qo4(long j, f30 f30Var) {
        super(f30Var.getContext(), f30Var);
        this.j = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w(so4.a(this.j, hj0.b(getContext()), this));
    }

    @Override // defpackage.w, defpackage.sn1
    public String t0() {
        return super.t0() + "(timeMillis=" + this.j + ')';
    }
}

package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class x54 extends d1 {
    public long a = -1;
    public f30 b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Z */
    @Override // defpackage.d1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(v54 v54Var) {
        if (this.a >= 0) {
            return false;
        }
        this.a = v54Var.X();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;)[Lf30; */
    @Override // defpackage.d1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public f30[] b(v54 v54Var) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return v54Var.W(j);
    }
}

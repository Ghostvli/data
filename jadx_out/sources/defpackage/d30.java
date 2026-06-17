package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class d30 implements u40 {
    public final g40 f;

    public d30(g40 g40Var) {
        this.f = g40Var;
    }

    @Override // defpackage.u40
    public g40 g() {
        return this.f;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + g() + ')';
    }
}

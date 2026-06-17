package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ft3 extends hh {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ft3(f30 f30Var) {
        super(f30Var);
        if (f30Var == null || f30Var.getContext() == bs0.f) {
            return;
        }
        jl.a("Coroutines with restricted suspension must have EmptyCoroutineContext");
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public g40 getContext() {
        return bs0.f;
    }
}

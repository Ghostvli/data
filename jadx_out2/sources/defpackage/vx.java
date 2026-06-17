package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vx {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final tx a(ln1 ln1Var) {
        return new ux(ln1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ tx b(ln1 ln1Var, int i, Object obj) {
        if ((i & 1) != 0) {
            ln1Var = null;
        }
        return a(ln1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean c(tx txVar, Object obj) {
        Throwable thD = kt3.d(obj);
        return thD == null ? txVar.P(obj) : txVar.M(thD);
    }
}

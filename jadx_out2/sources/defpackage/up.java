package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class up {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void a(qp qpVar, qm0 qm0Var) {
        c(qpVar, new rm0(qm0Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final sp b(f30 f30Var) {
        if (!(f30Var instanceof gm0)) {
            return new sp(f30Var, 1);
        }
        sp spVarO = ((gm0) f30Var).o();
        if (spVarO != null) {
            if (!spVarO.O()) {
                spVarO = null;
            }
            if (spVarO != null) {
                return spVarO;
            }
        }
        return new sp(f30Var, 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void c(qp qpVar, np npVar) {
        if (qpVar instanceof sp) {
            ((sp) qpVar).H(npVar);
        } else {
            fn.a("third-party implementation of CancellableContinuation is not supported");
        }
    }
}

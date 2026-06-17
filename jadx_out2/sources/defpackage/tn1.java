package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tn1 {
    public static final qj4 a = new qj4("COMPLETING_ALREADY");
    public static final qj4 b = new qj4("COMPLETING_WAITING_CHILDREN");
    public static final qj4 c = new qj4("COMPLETING_RETRY");
    public static final qj4 d = new qj4("TOO_LATE_TO_CANCEL");
    public static final qj4 e = new qj4("SEALED");
    public static final zr0 f = new zr0(false);
    public static final zr0 g = new zr0(true);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object g(Object obj) {
        return obj instanceof gj1 ? new hj1((gj1) obj) : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object h(Object obj) {
        gj1 gj1Var;
        hj1 hj1Var = obj instanceof hj1 ? (hj1) obj : null;
        return (hj1Var == null || (gj1Var = hj1Var.a) == null) ? obj : gj1Var;
    }
}

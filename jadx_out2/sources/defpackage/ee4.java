package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ee4 {
    public static final qj4 a = new qj4("NONE");
    public static final qj4 b = new qj4("PENDING");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final qw2 a(Object obj) {
        if (obj == null) {
            obj = m43.a;
        }
        return new de4(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 d(ce4 ce4Var, g40 g40Var, int i, tl tlVar) {
        return (((i < 0 || i >= 2) && i != -2) || tlVar != tl.g) ? w54.e(ce4Var, g40Var, i, tlVar) : ce4Var;
    }
}

package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bl4 {
    public final gr4 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends r83 {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    public bl4(gr4 gr4Var) {
        this.a = gr4Var;
    }

    public final boolean a(r73 r73Var, long j) {
        return b(r73Var) && c(r73Var, j);
    }

    public abstract boolean b(r73 r73Var);

    public abstract boolean c(r73 r73Var, long j);
}

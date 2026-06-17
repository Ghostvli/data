package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ij4 implements nw3 {
    public final jj4 a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ij4(jj4 jj4Var) {
        jj4Var.getClass();
        this.a = jj4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nw3
    public boolean b() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/String;)Llw3; */
    @Override // defpackage.nw3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public gj4 a(String str) {
        str.getClass();
        String databaseName = this.a.getDatabaseName();
        if (databaseName == null) {
            if (!il1.a(str, ":memory:")) {
                vq3.a("This driver is configured to open an in-memory database but a file-based named '", str, "' was requested.");
                return null;
            }
        } else if (!il1.a(databaseName, str) && !il1.a(wg4.N0(databaseName, '/', null, 2, null), wg4.N0(str, '/', null, 2, null))) {
            throw new IllegalArgumentException(("This driver is configured to open a database named '" + this.a.getDatabaseName() + "' but '" + str + "' was requested.").toString());
        }
        return new gj4(this.a.getWritableDatabase());
    }
}

package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mw3 {
    public static final long a(lw3 lw3Var) throws Exception {
        lw3Var.getClass();
        if (b(lw3Var) == 0) {
            return -1L;
        }
        ow3 ow3VarA0 = lw3Var.a0("SELECT last_insert_rowid()");
        try {
            ow3VarA0.Y();
            long j = ow3VarA0.getLong(0);
            ne.a(ow3VarA0, null);
            return j;
        } finally {
        }
    }

    public static final int b(lw3 lw3Var) throws Exception {
        lw3Var.getClass();
        ow3 ow3VarA0 = lw3Var.a0("SELECT changes()");
        try {
            ow3VarA0.Y();
            int i = (int) ow3VarA0.getLong(0);
            ne.a(ow3VarA0, null);
            return i;
        } finally {
        }
    }
}

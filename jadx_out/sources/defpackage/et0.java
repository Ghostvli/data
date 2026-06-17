package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class et0 {
    public abstract void a(ow3 ow3Var, Object obj);

    public abstract String b();

    public final int c(lw3 lw3Var, Object obj) throws Exception {
        lw3Var.getClass();
        if (obj == null) {
            return 0;
        }
        ow3 ow3VarA0 = lw3Var.a0(b());
        try {
            a(ow3VarA0, obj);
            ow3VarA0.Y();
            ne.a(ow3VarA0, null);
            return mw3.b(lw3Var);
        } finally {
        }
    }

    public final int d(lw3 lw3Var, Iterable iterable) throws Exception {
        lw3Var.getClass();
        int iB = 0;
        if (iterable == null) {
            return 0;
        }
        ow3 ow3VarA0 = lw3Var.a0(b());
        try {
            for (Object obj : iterable) {
                if (obj != null) {
                    a(ow3VarA0, obj);
                    ow3VarA0.Y();
                    ow3VarA0.reset();
                    iB += mw3.b(lw3Var);
                }
            }
            fw4 fw4Var = fw4.a;
            ne.a(ow3VarA0, null);
            return iB;
        } finally {
        }
    }
}

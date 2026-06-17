package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class it1 {
    public static final void a(int i) {
        if (i >= 1) {
            return;
        }
        vx4.a("Expected positive parallelism level, but got ", i);
    }

    public static final n40 b(n40 n40Var, String str) {
        return str != null ? new ex2(n40Var, str) : n40Var;
    }
}

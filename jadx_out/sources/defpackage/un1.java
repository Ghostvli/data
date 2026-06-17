package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class un1 {
    public final Map a = new HashMap();
    public final Map b = new HashMap();

    public vs0 a(wq1 wq1Var, boolean z) {
        return (vs0) b(z).get(wq1Var);
    }

    public final Map b(boolean z) {
        return z ? this.b : this.a;
    }

    public void c(wq1 wq1Var, vs0 vs0Var) {
        b(vs0Var.p()).put(wq1Var, vs0Var);
    }

    public void d(wq1 wq1Var, vs0 vs0Var) {
        Map mapB = b(vs0Var.p());
        if (vs0Var.equals(mapB.get(wq1Var))) {
            mapB.remove(wq1Var);
        }
    }
}

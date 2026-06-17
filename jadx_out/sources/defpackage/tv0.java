package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tv0 {
    public static final Executor a(n40 n40Var) {
        Executor executorH0;
        qv0 qv0Var = n40Var instanceof qv0 ? (qv0) n40Var : null;
        return (qv0Var == null || (executorH0 = qv0Var.h0()) == null) ? new lm0(n40Var) : executorH0;
    }

    public static final n40 b(Executor executor) {
        n40 n40Var;
        lm0 lm0Var = executor instanceof lm0 ? (lm0) executor : null;
        return (lm0Var == null || (n40Var = lm0Var.f) == null) ? new rv0(executor) : n40Var;
    }
}

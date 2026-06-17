package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class so4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final po4 a(long j, gj0 gj0Var, ln1 ln1Var) {
        return new po4("Timed out waiting for " + j + " ms", ln1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object b(qo4 qo4Var, Function2 function2) {
        on1.d(qo4Var, hj0.b(qo4Var.i.getContext()).y(qo4Var.j, qo4Var, qo4Var.getContext()));
        return aw4.c(qo4Var, qo4Var, function2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object c(long j, Function2 function2, f30 f30Var) {
        if (j <= 0) {
            throw new po4("Timed out immediately");
        }
        Object objB = b(new qo4(j, f30Var), function2);
        if (objB == kl1.e()) {
            ta0.c(f30Var);
        }
        return objB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object d(long j, Function2 function2, f30 f30Var) {
        return c(hj0.c(j), function2, f30Var);
    }
}

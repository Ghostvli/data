package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v40 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final u40 a(g40 g40Var) {
        if (g40Var.a(ln1.e) == null) {
            g40Var = g40Var.N(pn1.b(null, 1, null));
        }
        return new d30(g40Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void b(u40 u40Var, CancellationException cancellationException) {
        ln1 ln1Var = (ln1) u40Var.g().a(ln1.e);
        if (ln1Var != null) {
            ln1Var.h(cancellationException);
        } else {
            rn1.a("Scope cannot be cancelled because it does not have a job: ", u40Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(u40 u40Var, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        b(u40Var, cancellationException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object d(Function2 function2, f30 f30Var) {
        ty3 ty3Var = new ty3(f30Var.getContext(), f30Var);
        Object objB = aw4.b(ty3Var, ty3Var, function2);
        if (objB == kl1.e()) {
            ta0.c(f30Var);
        }
        return objB;
    }
}

package defpackage;

import defpackage.kt3;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vp {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void a(f30 f30Var, Throwable th) throws Throwable {
        kt3.a aVar = kt3.g;
        f30Var.resumeWith(kt3.b(lt3.a(th)));
        throw th;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void b(f30 f30Var, f30 f30Var2) throws Throwable {
        try {
            f30 f30VarC = jl1.c(f30Var);
            kt3.a aVar = kt3.g;
            hm0.b(f30VarC, kt3.b(fw4.a));
        } catch (Throwable th) {
            a(f30Var2, th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void c(Function2 function2, Object obj, f30 f30Var) {
        try {
            f30 f30VarC = jl1.c(jl1.a(function2, obj, f30Var));
            kt3.a aVar = kt3.g;
            hm0.b(f30VarC, kt3.b(fw4.a));
        } catch (Throwable th) {
            a(f30Var, th);
        }
    }
}

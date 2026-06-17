package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zy {
    public static final qj4 a = new qj4("CLOSED");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final az b(az azVar) {
        while (true) {
            Object objG = azVar.g();
            if (objG == a) {
                return azVar;
            }
            az azVar2 = (az) objG;
            if (azVar2 != null) {
                azVar = azVar2;
            } else if (azVar.m()) {
                return azVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object c(f04 f04Var, long j, Function2 function2) {
        while (true) {
            if (f04Var.c >= j && !f04Var.k()) {
                return h04.a(f04Var);
            }
            Object objG = f04Var.g();
            if (objG == a) {
                return h04.a(a);
            }
            f04 f04Var2 = (f04) ((az) objG);
            if (f04Var2 == null) {
                f04Var2 = (f04) function2.invoke(Long.valueOf(f04Var.c + 1), f04Var);
                if (f04Var.o(f04Var2)) {
                    if (f04Var.k()) {
                        f04Var.n();
                    }
                }
            }
            f04Var = f04Var2;
        }
    }
}

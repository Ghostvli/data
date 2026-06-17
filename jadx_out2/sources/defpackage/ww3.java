package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ww3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(tw3 tw3Var, int i, g40.b bVar) {
        g40.c key = bVar.getKey();
        g40.b bVarA = tw3Var.g.a(key);
        if (key != ln1.e) {
            if (bVar != bVarA) {
                return Integer.MIN_VALUE;
            }
            return i + 1;
        }
        ln1 ln1Var = (ln1) bVarA;
        ln1 ln1VarC = c((ln1) bVar, ln1Var);
        if (ln1VarC == ln1Var) {
            return ln1Var == null ? i : i + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + ln1VarC + ", expected child of " + ln1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void b(final tw3 tw3Var, g40 g40Var) {
        if (((Number) g40Var.T(0, new Function2() { // from class: vw3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(ww3.a(tw3Var, ((Integer) obj).intValue(), (g40.b) obj2));
            }
        })).intValue() == tw3Var.h) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + tw3Var.g + ",\n\t\tbut emission happened in " + g40Var + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ln1 c(ln1 ln1Var, ln1 ln1Var2) {
        while (ln1Var != null) {
            if (ln1Var == ln1Var2 || !(ln1Var instanceof ty3)) {
                return ln1Var;
            }
            ln1Var = ((ty3) ln1Var).c0();
        }
        return null;
    }
}

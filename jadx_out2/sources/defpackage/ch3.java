package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ch3 {
    /* JADX DEBUG: Class process forced to load method for inline: cs.b(int, tl, kotlin.jvm.functions.Function1, int, java.lang.Object):or */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final oo3 a(u40 u40Var, g40 g40Var, int i, tl tlVar, y40 y40Var, Function1 function1, Function2 function2) {
        dh3 dh3Var = new dh3(k40.h(u40Var, g40Var), cs.b(i, tlVar, null, 4, null));
        if (function1 != null) {
            dh3Var.k0(function1);
        }
        dh3Var.R0(y40Var, dh3Var, function2);
        return dh3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ oo3 b(u40 u40Var, g40 g40Var, int i, tl tlVar, y40 y40Var, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            g40Var = bs0.f;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            tlVar = tl.f;
        }
        if ((i2 & 8) != 0) {
            y40Var = y40.f;
        }
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        return a(u40Var, g40Var, i, tlVar, y40Var, function12, function2);
    }
}

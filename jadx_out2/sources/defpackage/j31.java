package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j31 {
    public static final Function1 a = new Function1() { // from class: h31
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return j31.d(obj);
        }
    };
    public static final Function2 b = new Function2() { // from class: i31
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(j31.c(obj, obj2));
        }
    };

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean c(Object obj, Object obj2) {
        return il1.a(obj, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object d(Object obj) {
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 e(z21 z21Var) {
        return z21Var instanceof ce4 ? z21Var : f(z21Var, a, b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 f(z21 z21Var, Function1 function1, Function2 function2) {
        if (z21Var instanceof tm0) {
            tm0 tm0Var = (tm0) z21Var;
            if (tm0Var.g == function1 && tm0Var.h == function2) {
                return z21Var;
            }
        }
        return new tm0(z21Var, function1, function2);
    }
}

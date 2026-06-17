package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p63 {
    public static final void a(Function1 function1, Object obj, g40 g40Var) throws IllegalAccessException, InvocationTargetException {
        xv4 xv4VarB = b(function1, obj, null);
        if (xv4VarB != null) {
            r40.a(g40Var, xv4VarB);
        }
    }

    public static final xv4 b(Function1 function1, Object obj, xv4 xv4Var) throws IllegalAccessException, InvocationTargetException {
        try {
            function1.invoke(obj);
            return xv4Var;
        } catch (Throwable th) {
            if (xv4Var != null && xv4Var.getCause() != th) {
                mv0.a(xv4Var, th);
                return xv4Var;
            }
            return new xv4("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static /* synthetic */ xv4 c(Function1 function1, Object obj, xv4 xv4Var, int i, Object obj2) {
        if ((i & 2) != 0) {
            xv4Var = null;
        }
        return b(function1, obj, xv4Var);
    }
}

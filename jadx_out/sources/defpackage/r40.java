package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r40 {
    public static final void a(g40 g40Var, Throwable th) {
        try {
            o40 o40Var = (o40) g40Var.a(o40.c);
            if (o40Var != null) {
                o40Var.t(g40Var, th);
            } else {
                q40.a(g40Var, th);
            }
        } catch (Throwable th2) {
            q40.a(g40Var, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        mv0.a(runtimeException, th);
        return runtimeException;
    }
}

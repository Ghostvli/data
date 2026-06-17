package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ob3 {
    public static Object a(b0 b0Var) {
        return b0Var.f();
    }

    public static Object b(b0 b0Var, long j, TimeUnit timeUnit) {
        return b0Var.h(j, timeUnit);
    }

    public static void c() {
        Thread.currentThread().interrupt();
    }

    public static boolean d(Throwable th, Class cls) {
        return cls.isInstance(th);
    }

    public static void e(Throwable th) {
        gg3.q(th);
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public static void f(Throwable th) {
        gg3.q(th);
        if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
            throw ((Error) th);
        }
    }
}

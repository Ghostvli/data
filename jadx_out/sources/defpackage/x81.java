package defpackage;

import defpackage.ti1;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x81 extends rb1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Runnable {
        public final Future f;
        public final v81 g;

        public a(Future future, v81 v81Var) {
            this.f = future;
            this.g = v81Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Object obj = this.f;
            if ((obj instanceof el1) && (thA = fl1.a((el1) obj)) != null) {
                this.g.b(thA);
                return;
            }
            try {
                this.g.a(x81.c(this.f));
            } catch (ExecutionException e) {
                this.g.b(e.getCause());
            } catch (Throwable th) {
                this.g.b(th);
            }
        }

        public String toString() {
            return eu2.b(this).c(this.g).toString();
        }
    }

    public static void a(lu1 lu1Var, v81 v81Var, Executor executor) {
        gg3.q(v81Var);
        lu1Var.g(new a(lu1Var, v81Var), executor);
    }

    public static lu1 b(lu1 lu1Var, Class cls, p81 p81Var, Executor executor) {
        return s.T(lu1Var, cls, p81Var, executor);
    }

    public static Object c(Future future) {
        gg3.A(future.isDone(), "Future was expected to be done: %s", future);
        return ew4.a(future);
    }

    public static lu1 d(Throwable th) {
        gg3.q(th);
        return new ti1.a(th);
    }

    public static lu1 e(Object obj) {
        return obj == null ? ti1.g : new ti1(obj);
    }

    public static lu1 f() {
        return ti1.g;
    }

    public static lu1 g(lu1 lu1Var, p81 p81Var, Executor executor) {
        return h1.T(lu1Var, p81Var, executor);
    }

    public static lu1 h(lu1 lu1Var, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return lu1Var.isDone() ? lu1Var : ro4.W(lu1Var, j, timeUnit, scheduledExecutorService);
    }
}

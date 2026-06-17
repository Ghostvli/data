package defpackage;

import defpackage.p31;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ro4 extends p31.a {
    public lu1 m;
    public ScheduledFuture n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Runnable {
        public ro4 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(ro4 ro4Var) {
            this.f = ro4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            lu1 lu1Var;
            ro4 ro4Var = this.f;
            if (ro4Var == null || (lu1Var = ro4Var.m) == null) {
                return;
            }
            this.f = null;
            if (lu1Var.isDone()) {
                ro4Var.O(lu1Var);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = ro4Var.n;
                ro4Var.n = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (jAbs > 10) {
                            str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                        }
                    } catch (Throwable th) {
                        ro4Var.N(new c(str));
                        throw th;
                    }
                }
                ro4Var.N(new c(str + ": " + lu1Var));
            } finally {
                lu1Var.cancel(true);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ro4(lu1 lu1Var) {
        this.m = (lu1) gg3.q(lu1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lu1 W(lu1 lu1Var, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        ro4 ro4Var = new ro4(lu1Var);
        b bVar = new b(ro4Var);
        ro4Var.n = scheduledExecutorService.schedule(bVar, j, timeUnit);
        lu1Var.g(bVar, du2.b());
        return ro4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b0
    public String L() {
        lu1 lu1Var = this.m;
        ScheduledFuture scheduledFuture = this.n;
        if (lu1Var == null) {
            return null;
        }
        String str = "inputFuture=[" + lu1Var + "]";
        if (scheduledFuture != null) {
            long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
            if (delay > 0) {
                return str + ", remaining delay=[" + delay + " ms]";
            }
        }
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b0
    public void y() {
        J(this.m);
        ScheduledFuture scheduledFuture = this.n;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.m = null;
        this.n = null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends TimeoutException {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        public c(String str) {
            super(str);
        }
    }
}

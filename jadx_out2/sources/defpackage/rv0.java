package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class rv0 extends qv0 implements gj0 {
    public final Executor i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rv0(Executor executor) {
        this.i = executor;
        if (h0() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) h0()).setRemoveOnCancelPolicy(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gj0
    public void F(long j, qp qpVar) {
        long j2;
        Executor executorH0 = h0();
        ScheduledFuture scheduledFutureJ0 = null;
        ScheduledExecutorService scheduledExecutorService = executorH0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorH0 : null;
        if (scheduledExecutorService != null) {
            j2 = j;
            scheduledFutureJ0 = j0(scheduledExecutorService, new pt3(this, qpVar), qpVar.getContext(), j2);
        } else {
            j2 = j;
        }
        if (scheduledFutureJ0 != null) {
            up.c(qpVar, new mp(scheduledFutureJ0));
        } else {
            qf0.n.F(j2, qpVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public void c0(g40 g40Var, Runnable runnable) {
        try {
            Executor executorH0 = h0();
            g1.a();
            executorH0.execute(runnable);
        } catch (RejectedExecutionException e) {
            g1.a();
            i0(g40Var, e);
            mm0.b().c0(g40Var, runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorH0 = h0();
        ExecutorService executorService = executorH0 instanceof ExecutorService ? (ExecutorService) executorH0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return (obj instanceof rv0) && ((rv0) obj).h0() == h0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qv0
    public Executor h0() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return System.identityHashCode(h0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i0(g40 g40Var, RejectedExecutionException rejectedExecutionException) {
        on1.c(g40Var, lv0.a("The task was rejected", rejectedExecutionException));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ScheduledFuture j0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, g40 g40Var, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            this.i0(g40Var, e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public String toString() {
        return h0().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gj0
    public qm0 y(long j, Runnable runnable, g40 g40Var) {
        long j2;
        Runnable runnable2;
        g40 g40Var2;
        Executor executorH0 = h0();
        ScheduledFuture scheduledFutureJ0 = null;
        ScheduledExecutorService scheduledExecutorService = executorH0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorH0 : null;
        if (scheduledExecutorService != null) {
            j2 = j;
            runnable2 = runnable;
            g40Var2 = g40Var;
            scheduledFutureJ0 = j0(scheduledExecutorService, runnable2, g40Var2, j2);
        } else {
            j2 = j;
            runnable2 = runnable;
            g40Var2 = g40Var;
        }
        return scheduledFutureJ0 != null ? new pm0(scheduledFutureJ0) : qf0.n.y(j2, runnable2, g40Var2);
    }
}

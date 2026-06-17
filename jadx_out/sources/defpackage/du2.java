package defpackage;

import defpackage.b0;
import defpackage.c51;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class du2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends k0 {
        public final ExecutorService f;

        public a(ExecutorService executorService) {
            this.f = (ExecutorService) gg3.q(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) {
            return this.f.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List shutdownNow() {
            return this.f.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends a implements ScheduledExecutorService, qu1 {
        public final ScheduledExecutorService g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends c51.a implements mu1 {
            public final ScheduledFuture g;

            public a(lu1 lu1Var, ScheduledFuture scheduledFuture) {
                super(lu1Var);
                this.g = scheduledFuture;
            }

            @Override // defpackage.b51, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boolean zCancel = super.cancel(z);
                if (zCancel) {
                    this.g.cancel(z);
                }
                return zCancel;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.g.compareTo(delayed);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.g.getDelay(timeUnit);
            }
        }

        /* JADX INFO: renamed from: du2$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class RunnableC0076b extends b0.f implements Runnable {
            public final Runnable m;

            public RunnableC0076b(Runnable runnable) {
                this.m = (Runnable) gg3.q(runnable);
            }

            @Override // defpackage.b0
            public String L() {
                return "task=[" + this.m + "]";
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.m.run();
                } catch (Throwable th) {
                    N(th);
                    throw th;
                }
            }
        }

        public b(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.g = (ScheduledExecutorService) gg3.q(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public mu1 schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            rt4 rt4VarT = rt4.T(runnable, null);
            return new a(rt4VarT, this.g.schedule(rt4VarT, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public mu1 schedule(Callable callable, long j, TimeUnit timeUnit) {
            rt4 rt4VarU = rt4.U(callable);
            return new a(rt4VarU, this.g.schedule(rt4VarU, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public mu1 scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            RunnableC0076b runnableC0076b = new RunnableC0076b(runnable);
            return new a(runnableC0076b, this.g.scheduleAtFixedRate(runnableC0076b, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public mu1 scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            RunnableC0076b runnableC0076b = new RunnableC0076b(runnable);
            return new a(runnableC0076b, this.g.scheduleWithFixedDelay(runnableC0076b, j, j2, timeUnit));
        }
    }

    public static /* synthetic */ void a(Executor executor, b0 b0Var, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            b0Var.N(e);
        }
    }

    public static Executor b() {
        return tl0.INSTANCE;
    }

    public static qu1 c(ExecutorService executorService) {
        return executorService instanceof qu1 ? (qu1) executorService : executorService instanceof ScheduledExecutorService ? new b((ScheduledExecutorService) executorService) : new a(executorService);
    }

    public static Executor d(final Executor executor, final b0 b0Var) {
        gg3.q(executor);
        gg3.q(b0Var);
        return executor == b() ? executor : new Executor() { // from class: cu2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                du2.a(executor, b0Var, runnable);
            }
        };
    }
}

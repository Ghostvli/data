package defpackage;

import defpackage.b0;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p31 extends qb1 {
    public static p31 R(lu1 lu1Var) {
        return lu1Var instanceof p31 ? (p31) lu1Var : new a51(lu1Var);
    }

    public final void Q(v81 v81Var, Executor executor) {
        x81.a(this, v81Var, executor);
    }

    public final p31 S(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (p31) x81.h(this, j, timeUnit, scheduledExecutorService);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a extends p31 implements b0.e {
        @Override // defpackage.b0, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // defpackage.b0, defpackage.lu1
        public final void g(Runnable runnable, Executor executor) {
            super.g(runnable, executor);
        }

        @Override // defpackage.b0, java.util.concurrent.Future
        public final Object get() {
            return super.get();
        }

        @Override // defpackage.b0, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // defpackage.b0, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // defpackage.b0, java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return super.get(j, timeUnit);
        }
    }
}

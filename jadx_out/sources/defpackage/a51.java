package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a51 extends p31 {
    public final lu1 m;

    public a51(lu1 lu1Var) {
        this.m = (lu1) gg3.q(lu1Var);
    }

    @Override // defpackage.b0, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.m.cancel(z);
    }

    @Override // defpackage.b0, defpackage.lu1
    public void g(Runnable runnable, Executor executor) {
        this.m.g(runnable, executor);
    }

    @Override // defpackage.b0, java.util.concurrent.Future
    public Object get() {
        return this.m.get();
    }

    @Override // defpackage.b0, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.m.isCancelled();
    }

    @Override // defpackage.b0, java.util.concurrent.Future
    public boolean isDone() {
        return this.m.isDone();
    }

    @Override // defpackage.b0
    public String toString() {
        return this.m.toString();
    }

    @Override // defpackage.b0, java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.m.get(j, timeUnit);
    }
}

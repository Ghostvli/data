package defpackage;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0 extends AbstractExecutorService implements qu1, AutoCloseable {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: submit(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future; */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public lu1 submit(Runnable runnable, Object obj) {
        return (lu1) super.submit(runnable, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        e45.a(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return rt4.T(runnable, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future; */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public lu1 submit(Runnable runnable) {
        return (lu1) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Callable callable) {
        return rt4.U(callable);
    }

    /* JADX DEBUG: Method merged with bridge method: submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future; */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public lu1 submit(Callable callable) {
        return (lu1) super.submit(callable);
    }
}

package com.hierynomus.protocol.commons.concurrent;

import com.hierynomus.protocol.commons.concurrent.AFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TransformedFuture<T, V> extends AFuture<V> {
    private AFuture.Function<T, V> function;
    private Future<T> wrapped;

    public TransformedFuture(Future<T> future, AFuture.Function<T, V> function) {
        this.wrapped = future;
        this.function = function;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.wrapped.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return (V) this.function.apply(this.wrapped.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.wrapped.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.wrapped.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return (V) this.function.apply(this.wrapped.get(j, timeUnit));
    }
}

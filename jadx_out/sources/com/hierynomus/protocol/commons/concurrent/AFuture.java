package com.hierynomus.protocol.commons.concurrent;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AFuture<V> implements Future<V> {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Function<A, B> {
        B apply(A a);
    }

    public <T> AFuture<T> map(Function<V, T> function) {
        return new TransformedFuture(this, function);
    }
}

package com.hierynomus.protocol.commons.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CancellableFuture<V> extends AFuture<V> {
    private final CancelCallback callback;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final AFuture<V> wrappedFuture;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface CancelCallback {
        void cancel();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CancellableFuture(AFuture<V> aFuture, CancelCallback cancelCallback) {
        this.wrappedFuture = aFuture;
        this.callback = cancelCallback;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.lock.writeLock().lock();
        try {
            if (!isDone() && !this.cancelled.getAndSet(true)) {
                this.callback.cancel();
                return true;
            }
            return false;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.concurrent.Future
    public V get() {
        return this.wrappedFuture.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        this.lock.readLock().lock();
        try {
            return this.cancelled.get();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isDone() {
        boolean z;
        this.lock.readLock().lock();
        try {
            if (!this.cancelled.get()) {
                z = this.wrappedFuture.isDone();
            }
            return z;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return this.wrappedFuture.get(j, timeUnit);
    }
}

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

    public CancellableFuture(AFuture<V> aFuture, CancelCallback cancelCallback) {
        this.wrappedFuture = aFuture;
        this.callback = cancelCallback;
    }

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

    @Override // java.util.concurrent.Future
    public V get() {
        return this.wrappedFuture.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        this.lock.readLock().lock();
        try {
            return this.cancelled.get();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isDone() {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.cancelled     // Catch: java.lang.Throwable -> L1c
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L1e
            com.hierynomus.protocol.commons.concurrent.AFuture<V> r0 = r1.wrappedFuture     // Catch: java.lang.Throwable -> L1c
            boolean r0 = r0.isDone()     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1a
            goto L1e
        L1a:
            r0 = 0
            goto L1f
        L1c:
            r0 = move-exception
            goto L29
        L1e:
            r0 = 1
        L1f:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r1.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            return r0
        L29:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r1.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hierynomus.protocol.commons.concurrent.CancellableFuture.isDone():boolean");
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return this.wrappedFuture.get(j, timeUnit);
    }
}

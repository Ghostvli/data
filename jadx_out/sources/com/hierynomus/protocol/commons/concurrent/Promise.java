package com.hierynomus.protocol.commons.concurrent;

import defpackage.j02;
import defpackage.n02;
import java.lang.Throwable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Promise<V, T extends Throwable> {
    private final Condition cond;
    private final ReentrantLock lock;
    private final j02 logger;
    private final String name;
    private T pendingEx;
    private V val;
    private final ExceptionWrapper<T> wrapper;

    public Promise(String str, ExceptionWrapper<T> exceptionWrapper, ReentrantLock reentrantLock) {
        this.logger = n02.k(getClass());
        this.name = str;
        this.wrapper = exceptionWrapper;
        reentrantLock = reentrantLock == null ? new ReentrantLock() : reentrantLock;
        this.lock = reentrantLock;
        this.cond = reentrantLock.newCondition();
    }

    public void clear() {
        this.lock.lock();
        try {
            this.pendingEx = null;
            deliver(null);
        } finally {
            this.lock.unlock();
        }
    }

    public void deliver(V v) {
        this.lock.lock();
        try {
            this.logger.f("Setting << {} >> to `{}`", this.name, v);
            this.val = v;
            this.cond.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public void deliverError(Throwable th) {
        this.lock.lock();
        try {
            this.pendingEx = (T) this.wrapper.wrap(th);
            this.cond.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public AFuture<V> future() {
        return new PromiseBackedFuture(this);
    }

    public boolean hasWaiters() {
        this.lock.lock();
        try {
            return this.lock.hasWaiters(this.cond);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean inError() {
        this.lock.lock();
        try {
            return this.pendingEx != null;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isDelivered() {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.lock
            r0.lock()
            T extends java.lang.Throwable r0 = r1.pendingEx     // Catch: java.lang.Throwable -> Lf
            if (r0 != 0) goto L11
            V r0 = r1.val     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L11
            r0 = 1
            goto L12
        Lf:
            r0 = move-exception
            goto L18
        L11:
            r0 = 0
        L12:
            java.util.concurrent.locks.ReentrantLock r1 = r1.lock
            r1.unlock()
            return r0
        L18:
            java.util.concurrent.locks.ReentrantLock r1 = r1.lock
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hierynomus.protocol.commons.concurrent.Promise.isDelivered():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isFulfilled() {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.lock
            r0.lock()
            T extends java.lang.Throwable r0 = r1.pendingEx     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            V r0 = r1.val     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L19
        L12:
            r0 = 1
        L13:
            java.util.concurrent.locks.ReentrantLock r1 = r1.lock
            r1.unlock()
            return r0
        L19:
            java.util.concurrent.locks.ReentrantLock r1 = r1.lock
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hierynomus.protocol.commons.concurrent.Promise.isFulfilled():boolean");
    }

    public void lock() {
        this.lock.lock();
    }

    public V retrieve(long j, TimeUnit timeUnit) throws Throwable {
        V vTryRetrieve = tryRetrieve(j, timeUnit);
        if (vTryRetrieve != null) {
            return vTryRetrieve;
        }
        throw this.wrapper.wrap(new TimeoutException("Timeout expired"));
    }

    public String toString() {
        return this.name;
    }

    public V tryRetrieve(long j, TimeUnit timeUnit) {
        this.lock.lock();
        try {
            try {
                T t = this.pendingEx;
                if (t != null) {
                    throw t;
                }
                V v = this.val;
                if (v != null) {
                    this.lock.unlock();
                    return v;
                }
                this.logger.q("Awaiting << {} >>", this.name);
                if (j == 0) {
                    while (this.val == null && this.pendingEx == null) {
                        this.cond.await();
                    }
                } else if (!this.cond.await(j, timeUnit)) {
                    this.lock.unlock();
                    return null;
                }
                T t2 = this.pendingEx;
                if (t2 != null) {
                    this.logger.o("<< {} >> woke to: {}", this.name, t2);
                    throw this.pendingEx;
                }
                V v2 = this.val;
                this.lock.unlock();
                return v2;
            } catch (InterruptedException e) {
                throw this.wrapper.wrap(e);
            }
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void unlock() {
        this.lock.unlock();
    }

    public V retrieve() {
        return tryRetrieve(0L, TimeUnit.SECONDS);
    }

    public Promise(String str, ExceptionWrapper<T> exceptionWrapper) {
        this(str, exceptionWrapper, null);
    }
}

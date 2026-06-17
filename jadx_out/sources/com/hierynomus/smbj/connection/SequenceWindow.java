package com.hierynomus.smbj.connection;

import com.hierynomus.smbj.common.SMBRuntimeException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SequenceWindow {
    private static final long MAX_WAIT = 5000;
    static final int PREFERRED_MINIMUM_CREDITS = 512;
    private AtomicLong lowestAvailable = new AtomicLong(0);
    private Semaphore available = new Semaphore(1);

    private long[] range(long j, long j2) {
        int i = (int) (j2 - j);
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = ((long) i2) + j;
        }
        return jArr;
    }

    public int available() {
        return this.available.availablePermits();
    }

    public void creditsGranted(int i) {
        this.available.release(i);
    }

    public void disableCredits() {
        this.available = new NoopSemaphore();
    }

    public long[] get(int i) {
        try {
            if (this.available.tryAcquire(i, MAX_WAIT, TimeUnit.MILLISECONDS)) {
                long j = i;
                long andAdd = this.lowestAvailable.getAndAdd(j);
                return range(andAdd, j + andAdd);
            }
            throw new SMBRuntimeException("Not enough credits (" + this.available.availablePermits() + " available) to hand out " + i + " sequence numbers");
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new SMBRuntimeException("Got interrupted waiting for " + i + " to be available. Credits available at this moment: " + this.available.availablePermits());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class NoopSemaphore extends Semaphore {
        public NoopSemaphore() {
            super(1);
        }

        @Override // java.util.concurrent.Semaphore
        public int availablePermits() {
            return Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.Semaphore
        public void release(int i) {
        }

        @Override // java.util.concurrent.Semaphore
        public boolean tryAcquire() {
            return true;
        }

        @Override // java.util.concurrent.Semaphore
        public boolean tryAcquire(int i) {
            return true;
        }

        @Override // java.util.concurrent.Semaphore
        public boolean tryAcquire(int i, long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.Semaphore
        public boolean tryAcquire(long j, TimeUnit timeUnit) {
            return true;
        }
    }

    public long get() {
        return get(1)[0];
    }
}

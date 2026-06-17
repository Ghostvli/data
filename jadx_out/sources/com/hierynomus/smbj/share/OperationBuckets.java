package com.hierynomus.smbj.share;

import com.hierynomus.smbj.common.SMBRuntimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class OperationBuckets {
    private List<OperationBucket> buckets = new ArrayList();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class OperationBucket {
        private final int index;
        private boolean free = false;
        private short sequenceNumber = 0;

        public OperationBucket(int i) {
            this.index = i;
        }

        public static /* synthetic */ short access$112(OperationBucket operationBucket, int i) {
            short s = (short) (operationBucket.sequenceNumber + i);
            operationBucket.sequenceNumber = s;
            return s;
        }

        public int getIndex() {
            return this.index;
        }

        public short getSequenceNumber() {
            return this.sequenceNumber;
        }
    }

    public void freeBucket(int i) {
        this.lock.writeLock().lock();
        try {
            OperationBucket operationBucket = this.buckets.get(i - 1);
            operationBucket.free = true;
            OperationBucket.access$112(operationBucket, 1);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public OperationBucket takeFreeBucket() {
        this.lock.writeLock().lock();
        try {
            for (OperationBucket operationBucket : this.buckets) {
                if (operationBucket.free) {
                    operationBucket.free = false;
                    return operationBucket;
                }
            }
            if (this.buckets.size() >= 64) {
                throw new SMBRuntimeException("No OperationBucket found which is free");
            }
            OperationBucket operationBucket2 = new OperationBucket(this.buckets.size() + 1);
            this.buckets.add(operationBucket2);
            return operationBucket2;
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}

package com.hierynomus.smbj.share;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2LockFlag;
import com.hierynomus.mssmb2.messages.submodule.SMB2LockElement;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.share.OperationBuckets;
import com.hierynomus.smbj.share.Share;
import defpackage.j02;
import defpackage.n02;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Open<S extends Share> implements Closeable {
    protected SMB2FileId fileId;
    protected SmbPath name;
    protected S share;
    protected final j02 logger = n02.k(getClass());
    private OperationBuckets operationBuckets = new OperationBuckets();

    public Open(SMB2FileId sMB2FileId, SmbPath smbPath, S s) {
        this.fileId = sMB2FileId;
        this.name = smbPath;
        this.share = s;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.share.closeFileId(this.fileId);
    }

    public void closeSilently() {
        try {
            close();
        } catch (Exception e) {
            this.logger.k("{} close failed for {},{},{}", getClass().getSimpleName(), this.name, this.share, this.fileId, e);
        }
    }

    public SMB2FileId getFileId() {
        return this.fileId;
    }

    public void lockRequest(List<SMB2LockElement> list) {
        short sequenceNumber;
        int index;
        SMB2Dialect dialect = this.share.getDialect();
        SMB2Dialect sMB2Dialect = SMB2Dialect.SMB_2_0_2;
        if (dialect != sMB2Dialect) {
            OperationBuckets.OperationBucket operationBucketTakeFreeBucket = this.operationBuckets.takeFreeBucket();
            sequenceNumber = operationBucketTakeFreeBucket.getSequenceNumber();
            index = operationBucketTakeFreeBucket.getIndex();
        } else {
            sequenceNumber = 0;
            index = 0;
        }
        this.share.sendLockRequest(this.fileId, sequenceNumber, index, list);
        if (this.share.getDialect() != sMB2Dialect) {
            this.operationBuckets.freeBucket(index);
        }
    }

    public Open<S>.LockBuilder requestLock() {
        return new LockBuilder();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class LockBuilder {
        private List<SMB2LockElement> elements = new ArrayList();

        public LockBuilder() {
        }

        private Open<S>.LockBuilder addElement(long j, long j2, Set<SMB2LockFlag> set) {
            this.elements.add(new SMB2LockElement(j, j2, set));
            return this;
        }

        public Open<S>.LockBuilder exclusiveLock(long j, long j2, boolean z) {
            EnumSet enumSetOf = EnumSet.of(SMB2LockFlag.SMB2_LOCKFLAG_EXCLUSIVE_LOCK);
            if (z) {
                enumSetOf.add(SMB2LockFlag.SMB2_LOCKFLAG_FAIL_IMMEDIATELY);
            }
            return addElement(j, j2, enumSetOf);
        }

        public void send() {
            Open.this.lockRequest(this.elements);
        }

        public Open<S>.LockBuilder sharedLock(long j, long j2, boolean z) {
            EnumSet enumSetOf = EnumSet.of(SMB2LockFlag.SMB2_LOCKFLAG_SHARED_LOCK);
            if (z) {
                enumSetOf.add(SMB2LockFlag.SMB2_LOCKFLAG_FAIL_IMMEDIATELY);
            }
            return addElement(j, j2, enumSetOf);
        }

        public Open<S>.LockBuilder unlock(long j, long j2) {
            return addElement(j, j2, EnumSet.of(SMB2LockFlag.SMB2_LOCKFLAG_UNLOCK));
        }

        public Open<S>.LockBuilder exclusiveLock(long j, long j2) {
            return exclusiveLock(j, j2, false);
        }

        public Open<S>.LockBuilder sharedLock(long j, long j2) {
            return sharedLock(j, j2, false);
        }
    }
}

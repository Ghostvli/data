package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB2LockFlag implements EnumWithValue<SMB2LockFlag> {
    SMB2_LOCKFLAG_SHARED_LOCK(1),
    SMB2_LOCKFLAG_EXCLUSIVE_LOCK(2),
    SMB2_LOCKFLAG_UNLOCK(4),
    SMB2_LOCKFLAG_FAIL_IMMEDIATELY(16);

    private long value;

    SMB2LockFlag(long j) {
        this.value = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

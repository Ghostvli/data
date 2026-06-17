package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB2GlobalCapability implements EnumWithValue<SMB2GlobalCapability> {
    SMB2_GLOBAL_CAP_DFS(1),
    SMB2_GLOBAL_CAP_LEASING(2),
    SMB2_GLOBAL_CAP_LARGE_MTU(4),
    SMB2_GLOBAL_CAP_MULTI_CHANNEL(8),
    SMB2_GLOBAL_CAP_PERSISTENT_HANDLES(16),
    SMB2_GLOBAL_CAP_DIRECTORY_LEASING(32),
    SMB2_GLOBAL_CAP_ENCRYPTION(64);

    private long i;

    SMB2GlobalCapability(long j) {
        this.i = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.i;
    }
}

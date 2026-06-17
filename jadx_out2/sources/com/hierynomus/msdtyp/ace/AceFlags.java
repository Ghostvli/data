package com.hierynomus.msdtyp.ace;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum AceFlags implements EnumWithValue<AceFlags> {
    CONTAINER_INHERIT_ACE(2),
    FAILED_ACCESS_ACE_FLAG(128),
    INHERIT_ONLY_ACE(8),
    INHERITED_ACE(16),
    NO_PROPAGATE_INHERIT_ACE(4),
    OBJECT_INHERIT_ACE(1),
    SUCCESSFUL_ACCESS_ACE_FLAG(64);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    AceFlags(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

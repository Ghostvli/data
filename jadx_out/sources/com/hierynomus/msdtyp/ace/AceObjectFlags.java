package com.hierynomus.msdtyp.ace;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum AceObjectFlags implements EnumWithValue<AceObjectFlags> {
    NONE(0),
    ACE_OBJECT_TYPE_PRESENT(1),
    ACE_INHERITED_OBJECT_TYPE_PRESENT(2);

    private long value;

    AceObjectFlags(long j) {
        this.value = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

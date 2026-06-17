package com.hierynomus.msdtyp.ace;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum AceType implements EnumWithValue<AceType> {
    ACCESS_ALLOWED_ACE_TYPE(0),
    ACCESS_DENIED_ACE_TYPE(1),
    SYSTEM_AUDIT_ACE_TYPE(2),
    SYSTEM_ALARM_ACE_TYPE(3),
    ACCESS_ALLOWED_COMPOUND_ACE_TYPE(4),
    ACCESS_ALLOWED_OBJECT_ACE_TYPE(5),
    ACCESS_DENIED_OBJECT_ACE_TYPE(6),
    SYSTEM_AUDIT_OBJECT_ACE_TYPE(7),
    SYSTEM_ALARM_OBJECT_ACE_TYPE(8),
    ACCESS_ALLOWED_CALLBACK_ACE_TYPE(9),
    ACCESS_DENIED_CALLBACK_ACE_TYPE(10),
    ACCESS_ALLOWED_CALLBACK_OBJECT_ACE_TYPE(11),
    ACCESS_DENIED_CALLBACK_OBJECT_ACE_TYPE(12),
    SYSTEM_AUDIT_CALLBACK_ACE_TYPE(13),
    SYSTEM_ALARM_CALLBACK_ACE_TYPE(14),
    SYSTEM_AUDIT_CALLBACK_OBJECT_ACE_TYPE(15),
    SYSTEM_ALARM_CALLBACK_OBJECT_ACE_TYPE(16),
    SYSTEM_MANDATORY_LABEL_ACE_TYPE(17),
    SYSTEM_RESOURCE_ATTRIBUTE_ACE_TYPE(18),
    SYSTEM_SCOPED_POLICY_ID_ACE_TYPE(19);

    private long value;

    AceType(long j) {
        this.value = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

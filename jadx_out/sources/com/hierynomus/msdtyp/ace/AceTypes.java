package com.hierynomus.msdtyp.ace;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msdtyp.SID;
import com.hierynomus.protocol.commons.EnumWithValue;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AceTypes {
    private AceTypes() {
    }

    public static ACE accessAllowedAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid) {
        return new AceType1(new AceHeader(AceType.ACCESS_ALLOWED_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid);
    }

    public static ACE accessAllowedCallbackAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid, byte[] bArr) {
        return new AceType3(new AceHeader(AceType.ACCESS_ALLOWED_CALLBACK_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid, bArr);
    }

    public static ACE accessAllowedCallbackObjectAce(Set<AceFlags> set, Set<AccessMask> set2, UUID uuid, UUID uuid2, SID sid, byte[] bArr) {
        return new AceType4(new AceHeader(AceType.ACCESS_ALLOWED_CALLBACK_OBJECT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), uuid, uuid2, sid, bArr);
    }

    public static ACE accessAllowedObjectAce(Set<AceFlags> set, Set<AccessMask> set2, UUID uuid, UUID uuid2, SID sid) {
        return new AceType2(new AceHeader(AceType.ACCESS_ALLOWED_OBJECT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), uuid, uuid2, sid);
    }

    public static ACE accessDeniedAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid) {
        return new AceType1(new AceHeader(AceType.ACCESS_DENIED_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid);
    }

    public static ACE accessDeniedCallbackAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid, byte[] bArr) {
        return new AceType3(new AceHeader(AceType.ACCESS_DENIED_CALLBACK_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid, bArr);
    }

    public static ACE accessDeniedCallbackObjectAce(Set<AceFlags> set, Set<AccessMask> set2, UUID uuid, UUID uuid2, SID sid, byte[] bArr) {
        return new AceType4(new AceHeader(AceType.ACCESS_DENIED_CALLBACK_OBJECT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), uuid, uuid2, sid, bArr);
    }

    public static ACE accessDeniedObjectAce(Set<AceFlags> set, Set<AccessMask> set2, UUID uuid, UUID uuid2, SID sid) {
        return new AceType2(new AceHeader(AceType.ACCESS_DENIED_OBJECT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), uuid, uuid2, sid);
    }

    public static ACE systemAuditAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid) {
        return new AceType1(new AceHeader(AceType.SYSTEM_AUDIT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid);
    }

    public static ACE systemAuditCallbackAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid, byte[] bArr) {
        return new AceType3(new AceHeader(AceType.SYSTEM_AUDIT_CALLBACK_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid, bArr);
    }

    public static ACE systemAuditCallbackObjectAce(Set<AceFlags> set, Set<AccessMask> set2, UUID uuid, UUID uuid2, SID sid, byte[] bArr) {
        return new AceType4(new AceHeader(AceType.SYSTEM_AUDIT_CALLBACK_OBJECT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), uuid, uuid2, sid, bArr);
    }

    public static ACE systemAuditObjectAce(Set<AceFlags> set, Set<AccessMask> set2, UUID uuid, UUID uuid2, SID sid, byte[] bArr) {
        return new AceType4(new AceHeader(AceType.SYSTEM_AUDIT_OBJECT_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), uuid, uuid2, sid, bArr);
    }

    public static ACE systemMandatoryLabelAce(Set<AceFlags> set, Set<AccessMask> set2, SID sid) {
        return new AceType1(new AceHeader(AceType.SYSTEM_MANDATORY_LABEL_ACE_TYPE, set), EnumWithValue.EnumUtils.toLong(set2), sid);
    }

    public static ACE systemResourceAttributeAce(Set<AceFlags> set, byte[] bArr) {
        return new AceType3(new AceHeader(AceType.SYSTEM_RESOURCE_ATTRIBUTE_ACE_TYPE, set), 0L, SID.EVERYONE, bArr);
    }

    public static ACE systemScopedPolicyIdAce(Set<AceFlags> set, SID sid) {
        return new AceType1(new AceHeader(AceType.SYSTEM_SCOPED_POLICY_ID_ACE_TYPE, set), 0L, sid);
    }
}

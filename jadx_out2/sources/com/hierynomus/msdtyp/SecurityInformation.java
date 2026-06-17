package com.hierynomus.msdtyp;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SecurityInformation implements EnumWithValue<SecurityInformation> {
    OWNER_SECURITY_INFORMATION(1),
    GROUP_SECURITY_INFORMATION(2),
    DACL_SECURITY_INFORMATION(4),
    SACL_SECURITY_INFORMATION(8),
    LABEL_SECURITY_INFORMATION(16),
    UNPROTECTED_SACL_SECURITY_INFORMATION(268435456),
    UNPROTECTED_DACL_SECURITY_INFORMATION(536870912),
    PROTECTED_SACL_SECURITY_INFORMATION(1073741824),
    PROTECTED_DACL_SECURITY_INFORMATION(2147483648L),
    ATTRIBUTE_SECURITY_INFORMATION(32),
    SCOPE_SECURITY_INFORMATION(64),
    BACKUP_SECURITY_INFORMATION(65536);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    SecurityInformation(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

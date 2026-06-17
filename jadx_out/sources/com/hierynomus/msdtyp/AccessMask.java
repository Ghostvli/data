package com.hierynomus.msdtyp;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum AccessMask implements EnumWithValue<AccessMask> {
    FILE_READ_DATA(1),
    FILE_WRITE_DATA(2),
    FILE_APPEND_DATA(4),
    FILE_EXECUTE(32),
    FILE_LIST_DIRECTORY(1),
    FILE_ADD_FILE(2),
    FILE_ADD_SUBDIRECTORY(4),
    FILE_TRAVERSE(32),
    FILE_DELETE_CHILD(64),
    FILE_READ_ATTRIBUTES(128),
    FILE_WRITE_ATTRIBUTES(256),
    FILE_READ_EA(8),
    FILE_WRITE_EA(16),
    DELETE(65536),
    READ_CONTROL(131072),
    WRITE_DAC(262144),
    WRITE_OWNER(524288),
    SYNCHRONIZE(1048576),
    ACCESS_SYSTEM_SECURITY(16777216),
    MAXIMUM_ALLOWED(33554432),
    GENERIC_ALL(268435456),
    GENERIC_EXECUTE(536870912),
    GENERIC_WRITE(1073741824),
    GENERIC_READ(2147483648L),
    ADS_RIGHT_DS_CONTROL_ACCESS(256),
    ADS_RIGHT_DS_CREATE_CHILD(1),
    ADS_RIGHT_DS_DELETE_CHILD(2),
    ADS_RIGHT_DS_READ_PROP(16),
    ADS_RIGHT_DS_WRITE_PROP(32),
    ADS_RIGHT_DS_SELF(8);

    private long value;

    AccessMask(long j) {
        this.value = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

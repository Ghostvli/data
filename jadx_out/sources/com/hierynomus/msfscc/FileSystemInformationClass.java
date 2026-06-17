package com.hierynomus.msfscc;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum FileSystemInformationClass implements EnumWithValue<FileSystemInformationClass> {
    FileFsVolumeInformation(1),
    FileFsLabelInformation(2),
    FileFsSizeInformation(3),
    FileFsDeviceInformation(4),
    FileFsAttributeInformation(5),
    FileFsControlInformation(6),
    FileFsFullSizeInformation(7),
    FileFsObjectIdInformation(8),
    FileFsDriverPathInformation(9),
    FileFsVolumeFlagsInformation(10),
    FileFsSectorSizeInformation(11);

    private long value;

    FileSystemInformationClass(long j) {
        this.value = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

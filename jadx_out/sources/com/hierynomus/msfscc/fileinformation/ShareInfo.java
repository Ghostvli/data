package com.hierynomus.msfscc.fileinformation;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ShareInfo {
    private final long actualAvailableAllocationUnits;
    private final long actualFreeSpace;
    private final long bytesPerSector;
    private final long callerAvailableAllocationUnits;
    private final long callerFreeSpace;
    private final long sectorsPerAllocationUnit;
    private final long totalAllocationUnits;
    private final long totalSpace;

    public ShareInfo(long j, long j2, long j3, long j4, long j5) {
        this.totalAllocationUnits = j;
        this.callerAvailableAllocationUnits = j2;
        this.actualAvailableAllocationUnits = j3;
        this.sectorsPerAllocationUnit = j4;
        this.bytesPerSector = j5;
        long j6 = j4 * j5;
        this.totalSpace = j * j6;
        this.callerFreeSpace = j2 * j6;
        this.actualFreeSpace = j3 * j6;
    }

    public static ShareInfo parseFsFullSizeInformation(Buffer.PlainBuffer plainBuffer) {
        return new ShareInfo(plainBuffer.readLong(), plainBuffer.readLong(), plainBuffer.readLong(), plainBuffer.readUInt32(), plainBuffer.readUInt32());
    }

    public long getAvailableAllocationUnits() {
        return this.actualAvailableAllocationUnits;
    }

    public long getBytesPerSector() {
        return this.bytesPerSector;
    }

    public long getCallerAvailableAllocationUnits() {
        return this.callerAvailableAllocationUnits;
    }

    public long getCallerFreeSpace() {
        return this.callerFreeSpace;
    }

    public long getFreeSpace() {
        return this.actualFreeSpace;
    }

    public long getSectorsPerAllocationUnit() {
        return this.sectorsPerAllocationUnit;
    }

    public long getTotalAllocationUnits() {
        return this.totalAllocationUnits;
    }

    public long getTotalSpace() {
        return this.totalSpace;
    }
}

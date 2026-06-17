package com.hierynomus.msfscc.fileinformation;

import com.hierynomus.msdtyp.FileTime;
import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class VolumeInfo {
    private final boolean supportsObjects;
    private final FileTime volumeCreationTime;
    private final String volumeLabel;
    private final int volumeSerialNumber;

    public VolumeInfo(FileTime fileTime, int i, boolean z, String str) {
        this.volumeCreationTime = fileTime;
        this.volumeSerialNumber = i;
        this.supportsObjects = z;
        this.volumeLabel = str;
    }

    public static VolumeInfo parseFileFsVolumeInformation(Buffer.PlainBuffer plainBuffer) throws Buffer.BufferException {
        FileTime fileTime = MsDataTypes.readFileTime(plainBuffer);
        int uInt32AsInt = plainBuffer.readUInt32AsInt();
        long uInt32 = plainBuffer.readUInt32();
        boolean z = plainBuffer.readBoolean();
        plainBuffer.skip(1);
        return new VolumeInfo(fileTime, uInt32AsInt, z, plainBuffer.readString(Charsets.UTF_16LE, ((int) uInt32) / 2));
    }

    public FileTime getVolumeCreationTime() {
        return this.volumeCreationTime;
    }

    public String getVolumeLabel() {
        return this.volumeLabel;
    }

    public int getVolumeSerialNumber() {
        return this.volumeSerialNumber;
    }

    public boolean isSupportsObjects() {
        return this.supportsObjects;
    }

    public String toString() {
        return "VolumeInfo{volumeCreationTime=" + this.volumeCreationTime + ", volumeSerialNumber=" + this.volumeSerialNumber + ", supportsObjects=" + this.supportsObjects + ", volumeLabel='" + this.volumeLabel + "'}";
    }
}

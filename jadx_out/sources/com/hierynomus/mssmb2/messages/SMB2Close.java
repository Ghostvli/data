package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.FileTime;
import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2Close extends SMB2Packet {
    private long allocationSize;
    private FileTime changeTime;
    private FileTime creationTime;
    private byte[] fileAttributes;
    private SMB2FileId fileId;
    private FileTime lastAccessTime;
    private FileTime lastWriteTime;
    private long size;

    public SMB2Close(SMB2Dialect sMB2Dialect, long j, long j2, SMB2FileId sMB2FileId) {
        super(24, sMB2Dialect, SMB2MessageCommandCode.SMB2_CLOSE, j, j2);
        this.fileId = sMB2FileId;
    }

    public long getAllocationSize() {
        return this.allocationSize;
    }

    public FileTime getChangeTime() {
        return this.changeTime;
    }

    public FileTime getCreationTime() {
        return this.creationTime;
    }

    public byte[] getFileAttributes() {
        return this.fileAttributes;
    }

    public FileTime getLastAccessTime() {
        return this.lastAccessTime;
    }

    public FileTime getLastWriteTime() {
        return this.lastWriteTime;
    }

    public long getSize() {
        return this.size;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.readUInt16();
        sMBBuffer.readUInt16();
        sMBBuffer.skip(4);
        this.creationTime = MsDataTypes.readFileTime(sMBBuffer);
        this.lastAccessTime = MsDataTypes.readFileTime(sMBBuffer);
        this.lastWriteTime = MsDataTypes.readFileTime(sMBBuffer);
        this.changeTime = MsDataTypes.readFileTime(sMBBuffer);
        this.allocationSize = sMBBuffer.readUInt64();
        this.size = sMBBuffer.readUInt64();
        this.fileAttributes = sMBBuffer.readRawBytes(4);
    }

    public void setFileId(SMB2FileId sMB2FileId) {
        this.fileId = sMB2FileId;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putUInt16(1);
        sMBBuffer.putReserved4();
        this.fileId.write(sMBBuffer);
    }

    public SMB2Close() {
    }
}

package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.FileTime;
import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.mssmb2.SMB2CreateAction;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2CreateResponse extends SMB2Packet {
    private FileTime changeTime;
    private SMB2CreateAction createAction;
    private FileTime creationTime;
    private Set<FileAttributes> fileAttributes;
    private SMB2FileId fileId;
    private FileTime lastAccessTime;
    private FileTime lastWriteTime;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getChangeTime() {
        return this.changeTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2CreateAction getCreateAction() {
        return this.createAction;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getCreationTime() {
        return this.creationTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<FileAttributes> getFileAttributes() {
        return this.fileAttributes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2FileId getFileId() {
        return this.fileId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getLastAccessTime() {
        return this.lastAccessTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getLastWriteTime() {
        return this.lastWriteTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.readUInt16();
        sMBBuffer.readByte();
        sMBBuffer.readByte();
        this.createAction = (SMB2CreateAction) EnumWithValue.EnumUtils.valueOf(sMBBuffer.readUInt32(), SMB2CreateAction.class, null);
        this.creationTime = MsDataTypes.readFileTime(sMBBuffer);
        this.lastAccessTime = MsDataTypes.readFileTime(sMBBuffer);
        this.lastWriteTime = MsDataTypes.readFileTime(sMBBuffer);
        this.changeTime = MsDataTypes.readFileTime(sMBBuffer);
        sMBBuffer.readRawBytes(8);
        sMBBuffer.readRawBytes(8);
        this.fileAttributes = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32(), FileAttributes.class);
        sMBBuffer.skip(4);
        this.fileId = SMB2FileId.read(sMBBuffer);
        sMBBuffer.readUInt32();
        sMBBuffer.readUInt32();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFileAttributes(Set<FileAttributes> set) {
        this.fileAttributes = set;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFileId(SMB2FileId sMB2FileId) {
        this.fileId = sMB2FileId;
    }
}

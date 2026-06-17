package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2IoctlResponse extends SMB2Packet {
    private int controlCode;
    private SMB2FileId fileId;
    byte[] inputBuffer;
    byte[] outputBuffer;

    public int getControlCode() {
        return this.controlCode;
    }

    public SMB2FileId getFileId() {
        return this.fileId;
    }

    public byte[] getInputBuffer() {
        return this.inputBuffer;
    }

    public byte[] getOutputBuffer() {
        return this.outputBuffer;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        sMBBuffer.skip(2);
        this.controlCode = sMBBuffer.readUInt32AsInt();
        this.fileId = SMB2FileId.read(sMBBuffer);
        int uInt32AsInt = sMBBuffer.readUInt32AsInt();
        int uInt32AsInt2 = sMBBuffer.readUInt32AsInt();
        int uInt32AsInt3 = sMBBuffer.readUInt32AsInt();
        int uInt32AsInt4 = sMBBuffer.readUInt32AsInt();
        sMBBuffer.skip(4);
        sMBBuffer.skip(4);
        if (uInt32AsInt2 > 0) {
            sMBBuffer.rpos(uInt32AsInt);
            this.inputBuffer = sMBBuffer.readRawBytes(uInt32AsInt2);
        }
        if (uInt32AsInt4 > 0) {
            sMBBuffer.rpos(uInt32AsInt3);
            this.outputBuffer = sMBBuffer.readRawBytes(uInt32AsInt4);
        }
    }
}

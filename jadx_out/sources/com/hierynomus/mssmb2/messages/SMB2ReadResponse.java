package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2ReadResponse extends SMB2Packet {
    private byte[] data;
    private int dataLength;

    public byte[] getData() {
        return this.data;
    }

    public int getDataLength() {
        return this.dataLength;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        byte b = sMBBuffer.readByte();
        sMBBuffer.skip(1);
        this.dataLength = sMBBuffer.readUInt32AsInt();
        sMBBuffer.readUInt32AsInt();
        sMBBuffer.skip(4);
        sMBBuffer.rpos(b);
        this.data = sMBBuffer.readRawBytes(this.dataLength);
    }
}

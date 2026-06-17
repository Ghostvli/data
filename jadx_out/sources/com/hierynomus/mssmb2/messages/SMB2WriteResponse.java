package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2WriteResponse extends SMB2Packet {
    private int bytesWritten;

    public int getBytesWritten() {
        return this.bytesWritten;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        sMBBuffer.skip(2);
        this.bytesWritten = sMBBuffer.readUInt32AsInt();
        sMBBuffer.skip(4);
        sMBBuffer.skip(2);
        sMBBuffer.skip(2);
    }
}

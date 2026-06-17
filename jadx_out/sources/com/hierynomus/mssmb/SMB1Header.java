package com.hierynomus.mssmb;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB1Header implements SMBHeader {
    private int headerStartPosition;
    private int messageEndPosition;

    @Override // com.hierynomus.smb.SMBHeader
    public int getHeaderStartPosition() {
        return this.headerStartPosition;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public int getMessageEndPosition() {
        return this.messageEndPosition;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public void readFrom(Buffer<?> buffer) {
        throw new UnsupportedOperationException("Receiving SMBv1 messages not supported in SMBJ");
    }

    public void setMessageEndPosition(int i) {
        this.messageEndPosition = i;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public void writeTo(SMBBuffer sMBBuffer) {
        this.headerStartPosition = sMBBuffer.wpos();
        sMBBuffer.putRawBytes(new byte[]{-1, 83, 77, 66});
        sMBBuffer.putByte((byte) 114);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putByte((byte) 24);
        sMBBuffer.putUInt16(51283);
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt64(0L);
        sMBBuffer.putReserved2();
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt16(0);
    }
}

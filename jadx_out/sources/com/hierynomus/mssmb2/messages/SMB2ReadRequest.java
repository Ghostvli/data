package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2MultiCreditPacket;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2ReadRequest extends SMB2MultiCreditPacket {
    private final SMB2FileId fileId;
    private final long offset;

    public SMB2ReadRequest(SMB2Dialect sMB2Dialect, SMB2FileId sMB2FileId, long j, long j2, long j3, int i) {
        super(49, sMB2Dialect, SMB2MessageCommandCode.SMB2_READ, j, j2, i);
        this.fileId = sMB2FileId;
        this.offset = j3;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putByte((byte) 0);
        sMBBuffer.putByte((byte) 0);
        sMBBuffer.putUInt32(getPayloadSize());
        sMBBuffer.putUInt64(this.offset);
        this.fileId.write(sMBBuffer);
        sMBBuffer.putUInt32(1L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt16(0);
        sMBBuffer.putByte((byte) 0);
    }
}

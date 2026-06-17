package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2MultiCreditPacket;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.io.ByteChunkProvider;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2IoctlRequest extends SMB2MultiCreditPacket {
    private final long controlCode;
    private final SMB2FileId fileId;
    private final boolean fsctl;
    private final ByteChunkProvider inputData;
    private long maxOutputResponse;

    public SMB2IoctlRequest(SMB2Dialect sMB2Dialect, long j, long j2, long j3, SMB2FileId sMB2FileId, ByteChunkProvider byteChunkProvider, boolean z, int i) {
        super(57, sMB2Dialect, SMB2MessageCommandCode.SMB2_IOCTL, j, j2, Math.max(byteChunkProvider.bytesLeft(), i));
        this.controlCode = j3;
        this.fileId = sMB2FileId;
        this.inputData = byteChunkProvider;
        this.fsctl = z;
        this.maxOutputResponse = i;
    }

    public long getControlCode() {
        return this.controlCode;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putReserved2();
        sMBBuffer.putUInt32(this.controlCode);
        this.fileId.write(sMBBuffer);
        int iBytesLeft = this.inputData.bytesLeft();
        if (iBytesLeft > 0) {
            sMBBuffer.putUInt32(120L);
            sMBBuffer.putUInt32(iBytesLeft);
        } else {
            sMBBuffer.putUInt32(0L);
            sMBBuffer.putUInt32(0L);
        }
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(this.maxOutputResponse);
        sMBBuffer.putUInt32(this.fsctl ? 1L : 0L);
        sMBBuffer.putReserved4();
        while (this.inputData.bytesLeft() > 0) {
            this.inputData.writeChunk(sMBBuffer);
        }
    }
}

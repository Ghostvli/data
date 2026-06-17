package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2MultiCreditPacket;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.io.ByteChunkProvider;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2WriteRequest extends SMB2MultiCreditPacket {
    private final ByteChunkProvider byteProvider;
    private final SMB2FileId fileId;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2WriteRequest(SMB2Dialect sMB2Dialect, SMB2FileId sMB2FileId, long j, long j2, ByteChunkProvider byteChunkProvider, int i) {
        super(49, sMB2Dialect, SMB2MessageCommandCode.SMB2_WRITE, j, j2, Math.min(i, byteChunkProvider.bytesLeft()));
        this.fileId = sMB2FileId;
        this.byteProvider = byteChunkProvider;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putUInt16(Token.ASSIGN_MOD);
        sMBBuffer.putUInt32(getPayloadSize());
        sMBBuffer.putUInt64(this.byteProvider.getOffset());
        this.fileId.write(sMBBuffer);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(Math.max(0, this.byteProvider.bytesLeft() - getPayloadSize()));
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt16(0);
        sMBBuffer.putUInt32(0L);
        this.byteProvider.writeChunks(sMBBuffer, getCreditsAssigned());
    }
}

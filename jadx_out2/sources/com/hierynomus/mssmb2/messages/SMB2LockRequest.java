package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.messages.submodule.SMB2LockElement;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import defpackage.jl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2LockRequest extends SMB2Packet {
    private final SMB2FileId fileId;
    private final List<SMB2LockElement> lockElements;
    private final int lockSequenceIndex;
    private final short lockSequenceNumber;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2LockRequest(SMB2Dialect sMB2Dialect, long j, long j2, short s, int i, SMB2FileId sMB2FileId, List<SMB2LockElement> list) {
        super(48, sMB2Dialect, SMB2MessageCommandCode.SMB2_LOCK, j, j2);
        if (s < 0 || s > 15) {
            jl.a("Only 4-bit integer value is allowed for lockSequenceNumber.");
            throw null;
        }
        this.lockSequenceNumber = s;
        if (i < 0 || i > 64) {
            jl.a("Only value between 0 to 64 (inclusive) is allowed for lockSequenceIndex.");
            throw null;
        }
        this.lockSequenceIndex = i;
        this.fileId = sMB2FileId;
        this.lockElements = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getLsnAndLsi() {
        return (this.lockSequenceIndex << 4) + this.lockSequenceNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putUInt16(this.lockElements.size());
        sMBBuffer.putUInt32(getLsnAndLsi());
        this.fileId.write(sMBBuffer);
        for (SMB2LockElement sMB2LockElement : this.lockElements) {
            sMBBuffer.putUInt64(sMB2LockElement.getOffset());
            sMBBuffer.putUInt64(sMB2LockElement.getLength());
            sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(sMB2LockElement.getLockFlags()));
            sMBBuffer.putReserved4();
        }
    }
}

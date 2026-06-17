package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2ChangeNotifyFlags;
import com.hierynomus.mssmb2.SMB2CompletionFilter;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2MultiCreditPacket;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2ChangeNotifyRequest extends SMB2MultiCreditPacket {
    private final Set<SMB2CompletionFilter> completionFilter;
    private final SMB2FileId fileId;
    private final Set<SMB2ChangeNotifyFlags> flags;

    public SMB2ChangeNotifyRequest(SMB2Dialect sMB2Dialect, long j, long j2, SMB2FileId sMB2FileId, Set<SMB2CompletionFilter> set, Set<SMB2ChangeNotifyFlags> set2, int i) {
        super(32, sMB2Dialect, SMB2MessageCommandCode.SMB2_CHANGE_NOTIFY, j, j2, i);
        this.fileId = sMB2FileId;
        this.completionFilter = set;
        this.flags = set2;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putUInt16((int) EnumWithValue.EnumUtils.toLong(this.flags));
        sMBBuffer.putUInt32(getPayloadSize());
        this.fileId.write(sMBBuffer);
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.completionFilter));
        sMBBuffer.putReserved4();
    }
}

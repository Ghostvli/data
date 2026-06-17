package com.hierynomus.mssmb2;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBPacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2PacketData extends SMBPacketData<SMB2PacketHeader> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2PacketData(byte[] bArr) {
        super(new SMB2PacketHeader(), bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getSequenceNumber() {
        return getHeader().getMessageId();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isCompounded() {
        return getHeader().getNextCommandOffset() != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDecrypted() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isIntermediateAsyncResponse() {
        return EnumWithValue.EnumUtils.isSet(getHeader().getFlags(), SMB2MessageFlag.SMB2_FLAGS_ASYNC_COMMAND) && getHeader().getStatusCode() == NtStatus.STATUS_PENDING.getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isOplockBreakNotification() {
        return getHeader().getMessageId() == -1 && getHeader().getMessage() == SMB2MessageCommandCode.SMB2_OPLOCK_BREAK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSuccess() {
        long statusCode = getHeader().getStatusCode();
        return NtStatus.isSuccess(statusCode) && statusCode != NtStatus.STATUS_PENDING.getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2PacketData next() {
        if (isCompounded()) {
            return new SMB2PacketData(this.dataBuffer);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getHeader().getMessage() + " with message id << " + getHeader().getMessageId() + " >>";
    }

    public SMB2PacketData(SMBBuffer sMBBuffer) {
        super(new SMB2PacketHeader(), sMBBuffer);
    }
}

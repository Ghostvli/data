package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBHeader;
import com.hierynomus.smbj.common.Check;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2PacketHeader implements SMBHeader {
    public static final byte[] EMPTY_SIGNATURE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final byte[] PROTOCOL_ID = {-2, 83, 77, 66};
    public static final int SIGNATURE_OFFSET = 48;
    public static final int SIGNATURE_SIZE = 16;
    public static final int STRUCTURE_SIZE = 64;
    private long asyncId;
    private int creditCharge = 1;
    private int creditRequest;
    private int creditResponse;
    private SMB2Dialect dialect;
    private long flags;
    private int headerStartPosition;
    private SMB2MessageCommandCode message;
    private int messageEndPosition;
    private long messageId;
    private int nextCommandOffset;
    private long sessionId;
    private byte[] signature;
    private long statusCode;
    private long treeId;

    /* JADX INFO: renamed from: com.hierynomus.mssmb2.SMB2PacketHeader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$mssmb2$SMB2Dialect;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[SMB2Dialect.values().length];
            $SwitchMap$com$hierynomus$mssmb2$SMB2Dialect = iArr;
            try {
                iArr[SMB2Dialect.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2Dialect[SMB2Dialect.SMB_2_0_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isPacketHeader(byte[] bArr) {
        return Arrays.equals(PROTOCOL_ID, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeChannelSequenceReserved(SMBBuffer sMBBuffer) {
        if (!this.dialect.isSmb3x()) {
            sMBBuffer.putReserved4();
        } else {
            sMBBuffer.putRawBytes(new byte[]{0, 0});
            sMBBuffer.putReserved(2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeCreditCharge(SMBBuffer sMBBuffer) {
        int i = AnonymousClass1.$SwitchMap$com$hierynomus$mssmb2$SMB2Dialect[this.dialect.ordinal()];
        if (i == 1 || i == 2) {
            sMBBuffer.putReserved(2);
        } else {
            sMBBuffer.putUInt16(this.creditCharge);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeCreditRequest(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.creditRequest + this.creditCharge);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getAsyncId() {
        return this.asyncId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCreditCharge() {
        return this.creditCharge;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCreditRequest() {
        return this.creditRequest;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCreditResponse() {
        return this.creditResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getFlags() {
        return this.flags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public int getHeaderStartPosition() {
        return this.headerStartPosition;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2MessageCommandCode getMessage() {
        return this.message;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public int getMessageEndPosition() {
        return this.messageEndPosition;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getMessageId() {
        return this.messageId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getNextCommandOffset() {
        return this.nextCommandOffset;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getSessionId() {
        return this.sessionId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getSignature() {
        return this.signature;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getStatusCode() {
        return this.statusCode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTreeId() {
        return this.treeId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isFlagSet(SMB2MessageFlag sMB2MessageFlag) {
        return EnumWithValue.EnumUtils.isSet(this.flags, sMB2MessageFlag);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public void readFrom(Buffer<?> buffer) throws Buffer.BufferException {
        this.headerStartPosition = buffer.rpos();
        Check.ensureEquals(buffer.readRawBytes(4), PROTOCOL_ID, "Could not find SMB2 Packet header");
        buffer.skip(2);
        buffer.readUInt16();
        this.statusCode = buffer.readUInt32();
        this.message = SMB2MessageCommandCode.lookup(buffer.readUInt16());
        this.creditResponse = buffer.readUInt16();
        this.flags = buffer.readUInt32();
        this.nextCommandOffset = buffer.readUInt32AsInt();
        this.messageId = buffer.readLong();
        if (EnumWithValue.EnumUtils.isSet(this.flags, SMB2MessageFlag.SMB2_FLAGS_ASYNC_COMMAND)) {
            this.asyncId = buffer.readLong();
        } else {
            buffer.skip(4);
            this.treeId = buffer.readUInt32();
        }
        this.sessionId = buffer.readLong();
        this.signature = buffer.readRawBytes(16);
        int i = this.nextCommandOffset;
        if (i != 0) {
            this.messageEndPosition = this.headerStartPosition + i;
        } else {
            this.messageEndPosition = buffer.wpos();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAsyncId(long j) {
        this.asyncId = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCreditCharge(int i) {
        this.creditCharge = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCreditRequest(int i) {
        this.creditRequest = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCreditResponse(int i) {
        this.creditResponse = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDialect(SMB2Dialect sMB2Dialect) {
        this.dialect = sMB2Dialect;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFlag(SMB2MessageFlag sMB2MessageFlag) {
        this.flags |= sMB2MessageFlag.getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFlags(long j) {
        this.flags = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMessageEndPosition(int i) {
        this.messageEndPosition = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMessageId(long j) {
        this.messageId = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMessageType(SMB2MessageCommandCode sMB2MessageCommandCode) {
        this.message = sMB2MessageCommandCode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNextCommandOffset(int i) {
        this.nextCommandOffset = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSessionId(long j) {
        this.sessionId = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setStatusCode(long j) {
        this.statusCode = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTreeId(long j) {
        this.treeId = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return String.format("dialect=%s, creditCharge=%s, creditRequest=%s, creditResponse=%s, message=%s, messageId=%s, asyncId=%s, sessionId=%s, treeId=%s, status=0x%08x, flags=%s, nextCommandOffset=%s", this.dialect, Integer.valueOf(this.creditCharge), Integer.valueOf(this.creditRequest), Integer.valueOf(this.creditResponse), this.message, Long.valueOf(this.messageId), Long.valueOf(this.asyncId), Long.valueOf(this.sessionId), Long.valueOf(this.treeId), Long.valueOf(this.statusCode), Long.valueOf(this.flags), Integer.valueOf(this.nextCommandOffset));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public void writeTo(SMBBuffer sMBBuffer) {
        this.headerStartPosition = sMBBuffer.wpos();
        sMBBuffer.putRawBytes(PROTOCOL_ID);
        sMBBuffer.putUInt16(64);
        writeCreditCharge(sMBBuffer);
        writeChannelSequenceReserved(sMBBuffer);
        sMBBuffer.putUInt16(this.message.getValue());
        writeCreditRequest(sMBBuffer);
        sMBBuffer.putUInt32(this.flags);
        sMBBuffer.putUInt32(this.nextCommandOffset);
        sMBBuffer.putLong(this.messageId);
        if (EnumWithValue.EnumUtils.isSet(this.flags, SMB2MessageFlag.SMB2_FLAGS_ASYNC_COMMAND)) {
            sMBBuffer.putLong(this.asyncId);
        } else {
            sMBBuffer.putReserved4();
            sMBBuffer.putUInt32(this.treeId);
        }
        sMBBuffer.putLong(this.sessionId);
        sMBBuffer.putRawBytes(EMPTY_SIGNATURE);
    }
}

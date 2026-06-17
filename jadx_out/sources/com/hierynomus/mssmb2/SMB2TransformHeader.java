package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBHeader;
import com.hierynomus.smbj.common.Check;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2TransformHeader implements SMBHeader {
    public static final byte[] ENCRYPTED_PROTOCOL_ID = {-3, 83, 77, 66};
    private int flagsEncryptionAlgorithm;
    private int headerStartPosition;
    private int messageEndPosition;
    private byte[] nonce;
    private int originalMessageSize;
    private long sessionId;
    private byte[] signature;

    public SMB2TransformHeader(byte[] bArr, int i, long j) {
        this.signature = new byte[16];
        this.nonce = bArr;
        this.originalMessageSize = i;
        this.sessionId = j;
    }

    public static boolean isEncrypted(byte[] bArr) {
        return Arrays.equals(ENCRYPTED_PROTOCOL_ID, bArr);
    }

    public int getFlagsEncryptionAlgorithm() {
        return this.flagsEncryptionAlgorithm;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public int getHeaderStartPosition() {
        return this.headerStartPosition;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public int getMessageEndPosition() {
        return this.messageEndPosition;
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public int getOriginalMessageSize() {
        return this.originalMessageSize;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public void readFrom(Buffer<?> buffer) throws Buffer.BufferException {
        this.headerStartPosition = buffer.rpos();
        Check.ensureEquals(buffer.readRawBytes(4), ENCRYPTED_PROTOCOL_ID, "Could not find SMB2 Packet header");
        this.signature = buffer.readRawBytes(16);
        this.nonce = buffer.readRawBytes(16);
        this.originalMessageSize = buffer.readUInt32AsInt();
        buffer.skip(2);
        this.flagsEncryptionAlgorithm = buffer.readUInt16();
        this.sessionId = buffer.readLong();
        this.messageEndPosition = buffer.wpos();
    }

    public void setMessageEndPosition(int i) {
        this.messageEndPosition = i;
    }

    public void setSignature(byte[] bArr) {
        this.signature = bArr;
    }

    @Override // com.hierynomus.smb.SMBHeader
    public void writeTo(SMBBuffer sMBBuffer) {
        this.headerStartPosition = sMBBuffer.rpos();
        sMBBuffer.putRawBytes(ENCRYPTED_PROTOCOL_ID);
        sMBBuffer.putRawBytes(this.signature);
        sMBBuffer.putRawBytes(this.nonce);
        sMBBuffer.putReserved(16 - this.nonce.length);
        sMBBuffer.putUInt32(this.originalMessageSize);
        sMBBuffer.putReserved2();
        sMBBuffer.putUInt16(1);
        sMBBuffer.putLong(this.sessionId);
    }

    public SMB2TransformHeader() {
    }
}

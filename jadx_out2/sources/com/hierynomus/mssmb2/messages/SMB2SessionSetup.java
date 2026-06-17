package com.hierynomus.mssmb2.messages;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2GlobalCapability;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2SessionSetup extends SMB2Packet {
    private long clientCapabilities;
    private SMB2Dialect negotiatedDialect;
    private long previousSessionId;
    private byte[] securityBuffer;
    private byte securityMode;
    private Set<SMB2SessionFlags> sessionFlags;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SMB2SecurityMode implements EnumWithValue<SMB2SecurityMode> {
        SMB2_NEGOTIATE_SIGNING_ENABLED(1),
        SMB2_NEGOTIATE_SIGNING_REQUIRED(2);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        SMB2SecurityMode(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SMB2SessionFlags implements EnumWithValue<SMB2SessionFlags> {
        SMB2_SESSION_FLAG_IS_GUEST(1),
        SMB2_SESSION_FLAG_IS_NULL(2),
        SMB2_SESSION_FLAG_ENCRYPT_DATA(4);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        SMB2SessionFlags(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2SessionSetup(SMB2Dialect sMB2Dialect, Set<SMB2SecurityMode> set, Set<SMB2GlobalCapability> set2) {
        super(25, sMB2Dialect, SMB2MessageCommandCode.SMB2_SESSION_SETUP);
        this.negotiatedDialect = sMB2Dialect;
        this.securityMode = (byte) EnumWithValue.EnumUtils.toLong(set);
        this.clientCapabilities = EnumWithValue.EnumUtils.toLong(set2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void putFlags(SMBBuffer sMBBuffer) {
        if (!this.negotiatedDialect.isSmb3x() || this.previousSessionId == 0) {
            sMBBuffer.putByte((byte) 0);
        } else {
            sMBBuffer.putByte((byte) 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private byte[] readSecurityBuffer(SMBBuffer sMBBuffer, int i, int i2) {
        if (i2 <= 0) {
            return new byte[0];
        }
        sMBBuffer.rpos(i);
        return sMBBuffer.readRawBytes(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getSecurityBuffer() {
        return this.securityBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<SMB2SessionFlags> getSessionFlags() {
        return this.sessionFlags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) {
        sMBBuffer.readUInt16();
        this.sessionFlags = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt16(), SMB2SessionFlags.class);
        this.securityBuffer = readSecurityBuffer(sMBBuffer, sMBBuffer.readUInt16(), sMBBuffer.readUInt16());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPreviousSessionId(long j) {
        this.previousSessionId = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSecurityBuffer(byte[] bArr) {
        this.securityBuffer = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSessionFlags(Set<SMB2SessionFlags> set) {
        this.sessionFlags = set;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        putFlags(sMBBuffer);
        sMBBuffer.putByte(this.securityMode);
        sMBBuffer.putUInt32(this.clientCapabilities & 255);
        sMBBuffer.putReserved4();
        sMBBuffer.putUInt16(88);
        byte[] bArr = this.securityBuffer;
        sMBBuffer.putUInt16(bArr != null ? bArr.length : 0);
        sMBBuffer.putUInt64(this.previousSessionId);
        byte[] bArr2 = this.securityBuffer;
        if (bArr2 != null) {
            sMBBuffer.putRawBytes(bArr2);
        }
    }

    public SMB2SessionSetup() {
    }
}

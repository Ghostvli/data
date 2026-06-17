package com.hierynomus.ntlm.messages;

import com.hierynomus.protocol.commons.ByteArrayUtils;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.j02;
import defpackage.n02;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmChallenge extends NtlmPacket {
    private static final j02 logger = n02.k(NtlmChallenge.class);
    private EnumSet<NtlmNegotiateFlag> negotiateFlags;
    private byte[] serverChallenge;
    private TargetInfo targetInfo;
    private int targetInfoBufferOffset;
    private int targetInfoLen;
    private String targetName;
    private int targetNameBufferOffset;
    private int targetNameLen;
    private WindowsVersion version;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readTargetInfo(Buffer.PlainBuffer plainBuffer) {
        if (this.targetInfoLen > 0) {
            plainBuffer.rpos(this.targetInfoBufferOffset);
            this.targetInfo = new TargetInfo().readFrom(plainBuffer);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readTargetInfoFields(Buffer.PlainBuffer plainBuffer) throws Buffer.BufferException {
        if (!this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_TARGET_INFO)) {
            plainBuffer.skip(8);
            return;
        }
        this.targetInfoLen = plainBuffer.readUInt16();
        plainBuffer.skip(2);
        this.targetInfoBufferOffset = plainBuffer.readUInt32AsInt();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readTargetName(Buffer.PlainBuffer plainBuffer) {
        if (this.targetNameLen > 0) {
            plainBuffer.rpos(this.targetNameBufferOffset);
            this.targetName = plainBuffer.readString(Charsets.UTF_16LE, this.targetNameLen / 2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readTargetNameFields(Buffer.PlainBuffer plainBuffer) throws Buffer.BufferException {
        this.targetNameLen = plainBuffer.readUInt16();
        plainBuffer.skip(2);
        this.targetNameBufferOffset = plainBuffer.readUInt32AsInt();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readVersion(Buffer.PlainBuffer plainBuffer) throws Buffer.BufferException {
        if (!this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_VERSION)) {
            plainBuffer.skip(8);
            return;
        }
        WindowsVersion from = new WindowsVersion().readFrom(plainBuffer);
        this.version = from;
        logger.q("Windows version = {}", from);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EnumSet<NtlmNegotiateFlag> getNegotiateFlags() {
        return this.negotiateFlags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getServerChallenge() {
        return this.serverChallenge;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TargetInfo getTargetInfo() {
        return this.targetInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTargetName() {
        return this.targetName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public WindowsVersion getVersion() {
        return this.version;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: read(Lcom/hierynomus/protocol/commons/buffer/Buffer;)V */
    @Override // com.hierynomus.ntlm.messages.NtlmPacket, com.hierynomus.protocol.Packet
    public void read(Buffer.PlainBuffer plainBuffer) {
        plainBuffer.readString(Charsets.UTF_8, 8);
        plainBuffer.readUInt32();
        readTargetNameFields(plainBuffer);
        this.negotiateFlags = EnumWithValue.EnumUtils.toEnumSet(plainBuffer.readUInt32(), NtlmNegotiateFlag.class);
        this.serverChallenge = plainBuffer.readRawBytes(8);
        plainBuffer.skip(8);
        readTargetInfoFields(plainBuffer);
        readVersion(plainBuffer);
        readTargetName(plainBuffer);
        readTargetInfo(plainBuffer);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "NtlmChallenge{\n  targetName='" + this.targetName + "',\n  negotiateFlags=" + this.negotiateFlags + ",\n  serverChallenge=" + ByteArrayUtils.printHex(this.serverChallenge) + ",\n  version=" + this.version + ",\n  targetInfo=" + this.targetInfo + "\n}";
    }
}

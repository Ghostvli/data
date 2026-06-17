package com.hierynomus.ntlm.messages;

import com.hierynomus.ntlm.functions.NtlmFunctions;
import com.hierynomus.protocol.commons.ByteArrayUtils;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import java.util.Set;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmAuthenticate extends NtlmMessage {
    private byte[] domainName;
    private byte[] encryptedRandomSessionKey;
    private byte[] lmResponse;
    private byte[] mic;
    private byte[] ntResponse;
    private byte[] userName;
    private byte[] workstation;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtlmAuthenticate(byte[] bArr, byte[] bArr2, String str, String str2, String str3, byte[] bArr3, Set<NtlmNegotiateFlag> set, WindowsVersion windowsVersion) {
        super(set, windowsVersion);
        this.lmResponse = Utils.ensureNotNull(bArr);
        this.ntResponse = Utils.ensureNotNull(bArr2);
        this.userName = Utils.ensureNotNull(str);
        this.domainName = Utils.ensureNotNull(str2);
        this.workstation = Utils.ensureNotNull(str3);
        this.encryptedRandomSessionKey = Utils.ensureNotNull(bArr3);
        this.negotiateFlags = set;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getBaseMessageSize() {
        int i = (this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_VERSION) || this.mic != null) ? 72 : 64;
        return this.mic != null ? i + 16 : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getVersion() {
        Buffer.PlainBuffer plainBuffer = new Buffer.PlainBuffer(Endian.LE);
        plainBuffer.putByte((byte) 6);
        plainBuffer.putByte((byte) 1);
        plainBuffer.putUInt16(7600);
        plainBuffer.putRawBytes(new byte[]{0, 0, 0});
        plainBuffer.putByte((byte) 15);
        return plainBuffer.getCompactData();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMic(byte[] bArr) {
        this.mic = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("NtlmAuthenticate{\n  mic=");
        byte[] bArr = this.mic;
        sb.append(bArr != null ? ByteArrayUtils.printHex(bArr) : _UrlKt.PATH_SEGMENT_ENCODE_SET_URI);
        sb.append(",\n  lmResponse=");
        sb.append(ByteArrayUtils.printHex(this.lmResponse));
        sb.append(",\n  ntResponse=");
        sb.append(ByteArrayUtils.printHex(this.ntResponse));
        sb.append(",\n  domainName='");
        sb.append(NtlmFunctions.unicode(this.domainName));
        sb.append("',\n  userName='");
        sb.append(NtlmFunctions.unicode(this.userName));
        sb.append("',\n  workstation='");
        sb.append(NtlmFunctions.unicode(this.workstation));
        sb.append("',\n  encryptedRandomSessionKey=[<secret>],\n}");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: write(Lcom/hierynomus/protocol/commons/buffer/Buffer;)V */
    @Override // com.hierynomus.ntlm.messages.NtlmPacket, com.hierynomus.protocol.Packet
    public void write(Buffer.PlainBuffer plainBuffer) {
        plainBuffer.putString("NTLMSSP\u0000", Charsets.UTF_8);
        plainBuffer.putUInt32(3L);
        Utils.writeOffsettedByteArrayFields(plainBuffer, this.encryptedRandomSessionKey, Utils.writeOffsettedByteArrayFields(plainBuffer, this.workstation, Utils.writeOffsettedByteArrayFields(plainBuffer, this.userName, Utils.writeOffsettedByteArrayFields(plainBuffer, this.domainName, Utils.writeOffsettedByteArrayFields(plainBuffer, this.ntResponse, Utils.writeOffsettedByteArrayFields(plainBuffer, this.lmResponse, getBaseMessageSize()))))));
        plainBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.negotiateFlags));
        if (this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_VERSION)) {
            plainBuffer.putRawBytes(getVersion());
        } else if (this.mic != null) {
            plainBuffer.putUInt64(0L);
        }
        byte[] bArr = this.mic;
        if (bArr != null) {
            plainBuffer.putRawBytes(bArr, 0, 16);
        }
        plainBuffer.putRawBytes(this.lmResponse);
        plainBuffer.putRawBytes(this.ntResponse);
        plainBuffer.putRawBytes(this.domainName);
        plainBuffer.putRawBytes(this.userName);
        plainBuffer.putRawBytes(this.workstation);
        plainBuffer.putRawBytes(this.encryptedRandomSessionKey);
    }
}

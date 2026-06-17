package com.hierynomus.ntlm.messages;

import com.hierynomus.ntlm.functions.NtlmFunctions;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmNegotiate extends NtlmMessage {
    private byte[] domain;
    private boolean omitVersion;
    private byte[] workstation;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtlmNegotiate(Set<NtlmNegotiateFlag> set, String str, String str2, WindowsVersion windowsVersion, boolean z) {
        super(set, windowsVersion);
        this.domain = str != null ? NtlmFunctions.oem(str) : Utils.EMPTY;
        this.workstation = str2 != null ? NtlmFunctions.oem(str2) : Utils.EMPTY;
        this.omitVersion = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "NtlmNegotiate{\n  domain='" + NtlmFunctions.oem(this.domain) + "'',\n  workstation='" + NtlmFunctions.oem(this.workstation) + "',\n  negotiateFlags=" + this.negotiateFlags + ",\n  version=" + this.version + "\n}";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: write(Lcom/hierynomus/protocol/commons/buffer/Buffer;)V */
    @Override // com.hierynomus.ntlm.messages.NtlmPacket, com.hierynomus.protocol.Packet
    public void write(Buffer.PlainBuffer plainBuffer) {
        plainBuffer.putString("NTLMSSP\u0000", Charsets.UTF_8);
        plainBuffer.putUInt32(1L);
        plainBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.negotiateFlags));
        int iWriteOffsettedByteArrayFields = !this.omitVersion ? 40 : 32;
        if (this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_OEM_DOMAIN_SUPPLIED)) {
            iWriteOffsettedByteArrayFields = Utils.writeOffsettedByteArrayFields(plainBuffer, this.domain, iWriteOffsettedByteArrayFields);
        } else {
            plainBuffer.putUInt16(0);
            plainBuffer.putUInt16(0);
            plainBuffer.putUInt32(0L);
        }
        if (this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_OEM_WORKSTATION_SUPPLIED)) {
            Utils.writeOffsettedByteArrayFields(plainBuffer, this.workstation, iWriteOffsettedByteArrayFields);
        } else {
            plainBuffer.putUInt16(0);
            plainBuffer.putUInt16(0);
            plainBuffer.putUInt32(0L);
        }
        if (!this.omitVersion && this.negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_VERSION)) {
            this.version.writeTo(plainBuffer);
        } else if (!this.omitVersion) {
            plainBuffer.putUInt64(0L);
        }
        plainBuffer.putRawBytes(this.domain);
        plainBuffer.putRawBytes(this.workstation);
    }
}

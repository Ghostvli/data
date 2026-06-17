package com.hierynomus.ntlm.messages;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum NtlmNegotiateFlag implements EnumWithValue<NtlmNegotiateFlag> {
    NTLMSSP_NEGOTIATE_56(2147483648L),
    NTLMSSP_NEGOTIATE_KEY_EXCH(1073741824),
    NTLMSSP_NEGOTIATE_128(536870912),
    NTLMSSP_NEGOTIATE_VERSION(33554432),
    NTLMSSP_NEGOTIATE_TARGET_INFO(8388608),
    NTLMSSP_REQUEST_NON_NT_SESSION_KEY(4194304),
    NTLMSSP_NEGOTIATE_IDENTIFY(1048576),
    NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY(524288),
    NTLMSSP_TARGET_TYPE_SERVER(131072),
    NTLMSSP_TARGET_TYPE_DOMAIN(65536),
    NTLMSSP_NEGOTIATE_ALWAYS_SIGN(32768),
    NTLMSSP_NEGOTIATE_OEM_WORKSTATION_SUPPLIED(8192),
    NTLMSSP_NEGOTIATE_OEM_DOMAIN_SUPPLIED(4096),
    NTLMSSP_NEGOTIATE_ANONYMOUS(2048),
    NTLMSSP_NEGOTIATE_NTLM(512),
    NTLMSSP_NEGOTIATE_LM_KEY(128),
    NTLMSSP_NEGOTIATE_DATAGRAM(64),
    NTLMSSP_NEGOTIATE_SEAL(32),
    NTLMSSP_NEGOTIATE_SIGN(16),
    NTLMSSP_REQUEST_TARGET(4),
    NTLM_NEGOTIATE_OEM(2),
    NTLMSSP_NEGOTIATE_UNICODE(1);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    NtlmNegotiateFlag(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

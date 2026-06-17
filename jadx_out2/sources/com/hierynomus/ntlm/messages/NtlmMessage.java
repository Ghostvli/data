package com.hierynomus.ntlm.messages;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class NtlmMessage extends NtlmPacket {
    protected static Set<NtlmNegotiateFlag> DEFAULT_FLAGS = EnumSet.of(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_NTLM, NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_UNICODE);
    protected Set<NtlmNegotiateFlag> negotiateFlags;
    protected WindowsVersion version;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtlmMessage(Set<NtlmNegotiateFlag> set, WindowsVersion windowsVersion) {
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) set);
        this.negotiateFlags = enumSetCopyOf;
        enumSetCopyOf.addAll(DEFAULT_FLAGS);
        this.version = windowsVersion;
    }
}

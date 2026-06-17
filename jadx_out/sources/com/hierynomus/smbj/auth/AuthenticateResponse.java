package com.hierynomus.smbj.auth;

import com.hierynomus.ntlm.messages.NtlmNegotiateFlag;
import com.hierynomus.ntlm.messages.WindowsVersion;
import com.hierynomus.spnego.SpnegoToken;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AuthenticateResponse {
    private SpnegoToken negToken;
    private Set<NtlmNegotiateFlag> negotiateFlags;
    private String netBiosName;
    private byte[] sessionKey;
    private WindowsVersion windowsVersion;

    public AuthenticateResponse(SpnegoToken spnegoToken) {
        this.negToken = spnegoToken;
    }

    public SpnegoToken getNegToken() {
        return this.negToken;
    }

    public Set<NtlmNegotiateFlag> getNegotiateFlags() {
        return this.negotiateFlags;
    }

    public String getNetBiosName() {
        return this.netBiosName;
    }

    public byte[] getSessionKey() {
        return this.sessionKey;
    }

    public WindowsVersion getWindowsVersion() {
        return this.windowsVersion;
    }

    public void setNegToken(SpnegoToken spnegoToken) {
        this.negToken = spnegoToken;
    }

    public void setNegotiateFlags(Set<NtlmNegotiateFlag> set) {
        this.negotiateFlags = set;
    }

    public void setNetBiosName(String str) {
        this.netBiosName = str;
    }

    public void setSessionKey(byte[] bArr) {
        this.sessionKey = bArr;
    }

    public void setWindowsVersion(WindowsVersion windowsVersion) {
        this.windowsVersion = windowsVersion;
    }

    public AuthenticateResponse() {
    }
}

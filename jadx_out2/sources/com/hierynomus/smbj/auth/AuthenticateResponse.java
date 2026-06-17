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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AuthenticateResponse(SpnegoToken spnegoToken) {
        this.negToken = spnegoToken;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SpnegoToken getNegToken() {
        return this.negToken;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<NtlmNegotiateFlag> getNegotiateFlags() {
        return this.negotiateFlags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNetBiosName() {
        return this.netBiosName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getSessionKey() {
        return this.sessionKey;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public WindowsVersion getWindowsVersion() {
        return this.windowsVersion;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNegToken(SpnegoToken spnegoToken) {
        this.negToken = spnegoToken;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNegotiateFlags(Set<NtlmNegotiateFlag> set) {
        this.negotiateFlags = set;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNetBiosName(String str) {
        this.netBiosName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSessionKey(byte[] bArr) {
        this.sessionKey = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWindowsVersion(WindowsVersion windowsVersion) {
        this.windowsVersion = windowsVersion;
    }

    public AuthenticateResponse() {
    }
}

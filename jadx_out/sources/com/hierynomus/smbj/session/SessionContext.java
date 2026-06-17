package com.hierynomus.smbj.session;

import com.hierynomus.mssmb2.messages.SMB2SessionSetup;
import java.util.Arrays;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SessionContext {
    private SecretKey applicationKey;
    private SecretKey decryptionKey;
    private boolean encryptData;
    private SecretKey encryptionKey;
    byte[] preauthIntegrityHashValue;
    private Set<SMB2SessionSetup.SMB2SessionFlags> sessionFlags;
    private SecretKey sessionKey;
    private SecretKey signingKey;
    private boolean signingRequired;

    public void established(SMB2SessionSetup sMB2SessionSetup) {
        this.sessionFlags = sMB2SessionSetup.getSessionFlags();
    }

    public SecretKey getApplicationKey() {
        return this.applicationKey;
    }

    public SecretKey getDecryptionKey() {
        return this.decryptionKey;
    }

    public SecretKey getEncryptionKey() {
        return this.encryptionKey;
    }

    public byte[] getPreauthIntegrityHashValue() {
        return this.preauthIntegrityHashValue;
    }

    public SecretKey getSessionKey() {
        return this.sessionKey;
    }

    public SecretKey getSigningKey() {
        return this.signingKey;
    }

    public boolean isAnonymous() {
        return this.sessionFlags.contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_IS_NULL);
    }

    public boolean isEncryptData() {
        return this.encryptData;
    }

    public boolean isGuest() {
        return this.sessionFlags.contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_IS_GUEST);
    }

    public boolean isSigningRequired() {
        return this.signingRequired;
    }

    public void setApplicationKey(SecretKey secretKey) {
        this.applicationKey = secretKey;
    }

    public void setDecryptionKey(SecretKey secretKey) {
        this.decryptionKey = secretKey;
    }

    public void setEncryptData(boolean z) {
        this.encryptData = z;
    }

    public void setEncryptionKey(SecretKey secretKey) {
        this.encryptionKey = secretKey;
    }

    public void setPreauthIntegrityHashValue(byte[] bArr) {
        this.preauthIntegrityHashValue = Arrays.copyOf(bArr, bArr.length);
    }

    public void setSessionKey(SecretKeySpec secretKeySpec) {
        this.sessionKey = secretKeySpec;
    }

    public void setSigningKey(SecretKey secretKey) {
        this.signingKey = secretKey;
    }

    public void setSigningRequired(boolean z) {
        this.signingRequired = z;
    }
}

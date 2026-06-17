package com.hierynomus.security.jce;

import com.hierynomus.security.MessageDigest;
import com.hierynomus.security.SecurityException;
import com.hierynomus.security.jce.messagedigest.MD4;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JceMessageDigest implements MessageDigest {
    private java.security.MessageDigest md;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JceMessageDigest(String str, Provider provider, String str2) throws SecurityException {
        try {
            if (provider != null) {
                this.md = java.security.MessageDigest.getInstance(str, provider);
            } else if (str2 != null) {
                this.md = java.security.MessageDigest.getInstance(str, str2);
            } else {
                this.md = java.security.MessageDigest.getInstance(str);
            }
        } catch (NoSuchAlgorithmException e) {
            if (!"MD4".equals(str)) {
                throw new SecurityException(e);
            }
            this.md = new MD4();
        } catch (NoSuchProviderException e2) {
            throw new SecurityException(e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public byte[] digest() {
        return this.md.digest();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public int getDigestLength() {
        return this.md.getDigestLength();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public void reset() {
        this.md.reset();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public void update(byte b) {
        this.md.update(b);
    }

    @Override // com.hierynomus.security.MessageDigest
    public void update(byte[] bArr) {
        this.md.update(bArr);
    }

    @Override // com.hierynomus.security.MessageDigest
    public void update(byte[] bArr, int i, int i2) {
        this.md.update(bArr, i, i2);
    }
}

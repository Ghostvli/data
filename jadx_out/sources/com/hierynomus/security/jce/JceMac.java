package com.hierynomus.security.jce;

import com.hierynomus.security.Mac;
import com.hierynomus.security.SecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JceMac implements Mac {
    private final String algorithm;
    private javax.crypto.Mac mac;

    public JceMac(String str, Provider provider, String str2) throws SecurityException {
        this.algorithm = str;
        try {
            if (provider != null) {
                this.mac = javax.crypto.Mac.getInstance(str, provider);
            } else if (str2 != null) {
                this.mac = javax.crypto.Mac.getInstance(str, str2);
            } else {
                this.mac = javax.crypto.Mac.getInstance(str);
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.Mac
    public byte[] doFinal() {
        return this.mac.doFinal();
    }

    @Override // com.hierynomus.security.Mac
    public void init(byte[] bArr) throws SecurityException {
        try {
            this.mac.init(new SecretKeySpec(bArr, this.algorithm));
        } catch (InvalidKeyException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.Mac
    public void reset() {
        this.mac.reset();
    }

    @Override // com.hierynomus.security.Mac
    public void update(byte b) {
        this.mac.update(b);
    }

    @Override // com.hierynomus.security.Mac
    public void update(byte[] bArr) {
        this.mac.update(bArr);
    }

    @Override // com.hierynomus.security.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
    }
}

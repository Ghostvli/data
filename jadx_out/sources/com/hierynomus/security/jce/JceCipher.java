package com.hierynomus.security.jce;

import com.hierynomus.security.Cipher;
import com.hierynomus.security.SecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JceCipher implements Cipher {
    private javax.crypto.Cipher cipher;

    public JceCipher(String str, Provider provider, String str2) throws SecurityException {
        try {
            if (provider != null) {
                this.cipher = javax.crypto.Cipher.getInstance(str, provider);
            } else if (str2 != null) {
                this.cipher = javax.crypto.Cipher.getInstance(str, str2);
            } else {
                this.cipher = javax.crypto.Cipher.getInstance(str);
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.Cipher
    public int doFinal(byte[] bArr, int i) throws SecurityException {
        try {
            return this.cipher.doFinal(bArr, i);
        } catch (BadPaddingException | IllegalBlockSizeException | ShortBufferException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.Cipher
    public void init(Cipher.CryptMode cryptMode, byte[] bArr) throws SecurityException {
        try {
            Cipher.CryptMode cryptMode2 = Cipher.CryptMode.DECRYPT;
            javax.crypto.Cipher cipher = this.cipher;
            if (cryptMode2 == cryptMode) {
                cipher.init(2, new SecretKeySpec(bArr, this.cipher.getAlgorithm().split(ServiceReference.DELIMITER)[0]));
            } else {
                cipher.init(1, new SecretKeySpec(bArr, this.cipher.getAlgorithm().split(ServiceReference.DELIMITER)[0]));
            }
        } catch (InvalidKeyException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.Cipher
    public void reset() {
    }

    @Override // com.hierynomus.security.Cipher
    public int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws SecurityException {
        try {
            return this.cipher.update(bArr, i, i2, bArr2, i3);
        } catch (ShortBufferException e) {
            throw new SecurityException(e);
        }
    }
}

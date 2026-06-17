package com.hierynomus.security.jce;

import com.hierynomus.security.AEADBlockCipher;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.SecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JceAEADCipher implements AEADBlockCipher {
    private Cipher cipher;

    public JceAEADCipher(String str, Provider provider, String str2) throws SecurityException {
        try {
            if (provider != null) {
                this.cipher = Cipher.getInstance(str, provider);
            } else if (str2 != null) {
                this.cipher = Cipher.getInstance(str, str2);
            } else {
                this.cipher = Cipher.getInstance(str);
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.AEADBlockCipher
    public byte[] doFinal(byte[] bArr, int i, int i2) throws SecurityException {
        try {
            return this.cipher.doFinal(bArr, i, i2);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.AEADBlockCipher
    public void init(Cipher.CryptMode cryptMode, byte[] bArr, GCMParameterSpec gCMParameterSpec) throws SecurityException {
        try {
            Cipher.CryptMode cryptMode2 = Cipher.CryptMode.DECRYPT;
            javax.crypto.Cipher cipher = this.cipher;
            if (cryptMode2 == cryptMode) {
                cipher.init(2, new SecretKeySpec(bArr, this.cipher.getAlgorithm().split(ServiceReference.DELIMITER)[0]), gCMParameterSpec);
            } else {
                cipher.init(1, new SecretKeySpec(bArr, this.cipher.getAlgorithm().split(ServiceReference.DELIMITER)[0]), gCMParameterSpec);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
            throw new SecurityException(e);
        }
    }

    @Override // com.hierynomus.security.AEADBlockCipher
    public void reset() {
    }

    @Override // com.hierynomus.security.AEADBlockCipher
    public byte[] update(byte[] bArr, int i, int i2) {
        return this.cipher.update(bArr, i, i2);
    }

    @Override // com.hierynomus.security.AEADBlockCipher
    public void updateAAD(byte[] bArr, int i, int i2) {
        this.cipher.updateAAD(bArr, i, i2);
    }
}

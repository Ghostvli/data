package com.hierynomus.security;

import com.hierynomus.security.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface AEADBlockCipher {
    byte[] doFinal(byte[] bArr, int i, int i2);

    void init(Cipher.CryptMode cryptMode, byte[] bArr, GCMParameterSpec gCMParameterSpec);

    void reset();

    byte[] update(byte[] bArr, int i, int i2);

    void updateAAD(byte[] bArr, int i, int i2);
}

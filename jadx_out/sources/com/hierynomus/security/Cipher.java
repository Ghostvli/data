package com.hierynomus.security;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Cipher {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum CryptMode {
        ENCRYPT,
        DECRYPT
    }

    int doFinal(byte[] bArr, int i);

    void init(CryptMode cryptMode, byte[] bArr);

    void reset();

    int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3);
}

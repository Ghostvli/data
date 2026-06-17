package com.hierynomus.security;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Mac {
    byte[] doFinal();

    void init(byte[] bArr);

    void reset();

    void update(byte b);

    void update(byte[] bArr);

    void update(byte[] bArr, int i, int i2);
}

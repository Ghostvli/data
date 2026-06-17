package com.hierynomus.security;

import com.hierynomus.security.jce.derivationfunction.DerivationParameters;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i, int i2);

    void init(DerivationParameters derivationParameters);
}

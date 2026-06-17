package com.hierynomus.security.jce.derivationfunction;

import defpackage.jl;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CounterDerivationParameters implements DerivationParameters {
    private int counterLength;
    private byte[] fixedCounterSuffix;
    private byte[] seed;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CounterDerivationParameters(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null || bArr.length == 0) {
            jl.a("Missing Seed for KDF");
            throw null;
        }
        this.seed = Arrays.copyOf(bArr, bArr.length);
        if (bArr2 == null) {
            this.fixedCounterSuffix = new byte[0];
        } else {
            this.fixedCounterSuffix = Arrays.copyOf(bArr2, bArr2.length);
        }
        this.counterLength = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCounterLength() {
        return this.counterLength;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getFixedCounterSuffix() {
        return this.fixedCounterSuffix;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getSeed() {
        return this.seed;
    }
}

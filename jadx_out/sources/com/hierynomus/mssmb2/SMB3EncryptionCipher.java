package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB3EncryptionCipher implements EnumWithValue<SMB3EncryptionCipher> {
    AES_128_CCM(1, "AES/CCM/NoPadding", 11),
    AES_128_GCM(2, "AES/GCM/NoPadding", 12);

    private String algorithmName;
    private int nonceLength;
    private long value;

    SMB3EncryptionCipher(long j, String str, int i) {
        this.value = j;
        this.algorithmName = str;
        this.nonceLength = i;
    }

    public String getAlgorithmName() {
        return this.algorithmName;
    }

    public int getNonceLength() {
        return this.nonceLength;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

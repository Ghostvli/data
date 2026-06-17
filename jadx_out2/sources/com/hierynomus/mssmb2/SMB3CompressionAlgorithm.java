package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB3CompressionAlgorithm implements EnumWithValue<SMB3CompressionAlgorithm> {
    NONE(0),
    LZNT1(1),
    LZ77(2),
    LZ77_HUFFMAN(3);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    SMB3CompressionAlgorithm(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

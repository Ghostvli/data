package com.hierynomus.asn1.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum ASN1Encoding {
    PRIMITIVE(0),
    CONSTRUCTED(32);

    private int value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    ASN1Encoding(int i) {
        this.value = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ASN1Encoding parseEncoding(byte b) {
        return (b & 32) == 0 ? PRIMITIVE : CONSTRUCTED;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getValue() {
        return this.value;
    }
}

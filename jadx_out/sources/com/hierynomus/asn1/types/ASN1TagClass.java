package com.hierynomus.asn1.types;

import defpackage.e04;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum ASN1TagClass {
    UNIVERSAL(0),
    APPLICATION(64),
    CONTEXT_SPECIFIC(128),
    PRIVATE(192);

    private int value;

    ASN1TagClass(int i) {
        this.value = i;
    }

    public static ASN1TagClass parseClass(byte b) {
        int i = b & 192;
        for (ASN1TagClass aSN1TagClass : values()) {
            if (aSN1TagClass.value == i) {
                return aSN1TagClass;
            }
        }
        e04.a("Could not parse ASN.1 Tag Class (should be impossible)");
        return null;
    }

    public int getValue() {
        return this.value;
    }
}

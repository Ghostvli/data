package com.hierynomus.asn1;

import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ASN1Parser<T extends ASN1Object> {
    protected ASN1Decoder decoder;

    public ASN1Parser(ASN1Decoder aSN1Decoder) {
        this.decoder = aSN1Decoder;
    }

    public abstract T parse(ASN1Tag<T> aSN1Tag, byte[] bArr);
}

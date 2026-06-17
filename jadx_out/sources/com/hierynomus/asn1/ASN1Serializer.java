package com.hierynomus.asn1;

import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ASN1Serializer<T extends ASN1Object> {
    protected final ASN1Encoder encoder;

    public ASN1Serializer(ASN1Encoder aSN1Encoder) {
        this.encoder = aSN1Encoder;
    }

    public abstract void serialize(T t, ASN1OutputStream aSN1OutputStream);

    public abstract int serializedLength(T t);
}

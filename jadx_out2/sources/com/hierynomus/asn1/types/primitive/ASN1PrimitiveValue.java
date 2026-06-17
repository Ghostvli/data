package com.hierynomus.asn1.types.primitive;

import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Primitive;
import com.hierynomus.asn1.types.ASN1Tag;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ASN1PrimitiveValue<T> extends ASN1Object<T> implements ASN1Primitive {
    protected byte[] valueBytes;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1PrimitiveValue(ASN1Tag aSN1Tag, byte[] bArr) {
        super(aSN1Tag);
        this.valueBytes = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int valueHash() {
        return Arrays.hashCode(this.valueBytes);
    }

    public ASN1PrimitiveValue(ASN1Tag aSN1Tag) {
        super(aSN1Tag);
    }
}

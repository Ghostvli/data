package com.hierynomus.asn1.types.string;

import com.hierynomus.asn1.encodingrules.ber.BERDecoder;
import com.hierynomus.asn1.types.ASN1Constructed;
import com.hierynomus.asn1.types.ASN1Encoding;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Primitive;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.types.constructed.ASN1Sequence;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ASN1String<T> extends ASN1Object<T> implements ASN1Primitive, ASN1Constructed {
    protected byte[] valueBytes;

    public ASN1String(ASN1Tag<?> aSN1Tag, byte[] bArr) {
        super(aSN1Tag);
        this.valueBytes = bArr;
    }

    public byte[] getValueBytes() {
        byte[] bArr = this.valueBytes;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Object> iterator() {
        if (this.tag.getAsn1Encoding() != ASN1Encoding.CONSTRUCTED) {
            return Collections.singletonList(this).iterator();
        }
        ASN1Tag<ASN1Sequence> aSN1Tag = ASN1Tag.SEQUENCE;
        return ((ASN1Sequence) aSN1Tag.newParser(new BERDecoder()).parse(aSN1Tag, this.valueBytes)).iterator();
    }

    public abstract int length();
}

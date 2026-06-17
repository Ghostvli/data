package com.hierynomus.asn1.types.primitive;

import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.ASN1Parser;
import com.hierynomus.asn1.ASN1Serializer;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1Integer extends ASN1PrimitiveValue<BigInteger> {
    private BigInteger value;

    public ASN1Integer(BigInteger bigInteger) {
        super(ASN1Tag.INTEGER);
        this.value = bigInteger;
        this.valueBytes = bigInteger.toByteArray();
    }

    @Override // com.hierynomus.asn1.types.primitive.ASN1PrimitiveValue
    public int valueHash() {
        return this.value.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1Integer> {
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1Integer aSN1Integer, ASN1OutputStream aSN1OutputStream) throws IOException {
            aSN1OutputStream.write(aSN1Integer.valueBytes);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1Integer aSN1Integer) {
            return aSN1Integer.valueBytes.length;
        }
    }

    @Override // com.hierynomus.asn1.types.ASN1Object
    public BigInteger getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1Integer> {
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1Integer parse(ASN1Tag<ASN1Integer> aSN1Tag, byte[] bArr) {
            return new ASN1Integer(bArr, new BigInteger(bArr));
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1Integer>) aSN1Tag, bArr);
        }
    }

    public ASN1Integer(long j) {
        this(BigInteger.valueOf(j));
    }

    private ASN1Integer(byte[] bArr, BigInteger bigInteger) {
        super(ASN1Tag.INTEGER, bArr);
        this.value = bigInteger;
    }
}

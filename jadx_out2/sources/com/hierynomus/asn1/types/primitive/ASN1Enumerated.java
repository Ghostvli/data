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
public class ASN1Enumerated extends ASN1PrimitiveValue<BigInteger> {
    private final BigInteger value;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1Enumerated> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void calculateBytes(ASN1Enumerated aSN1Enumerated) {
            aSN1Enumerated.valueBytes = aSN1Enumerated.value.toByteArray();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serialize(Lcom/hierynomus/asn1/types/ASN1Object;Lcom/hierynomus/asn1/ASN1OutputStream;)V */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1Enumerated aSN1Enumerated, ASN1OutputStream aSN1OutputStream) throws IOException {
            if (aSN1Enumerated.valueBytes == null) {
                calculateBytes(aSN1Enumerated);
            }
            aSN1OutputStream.write(aSN1Enumerated.valueBytes);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serializedLength(Lcom/hierynomus/asn1/types/ASN1Object;)I */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1Enumerated aSN1Enumerated) {
            if (aSN1Enumerated.valueBytes == null) {
                calculateBytes(aSN1Enumerated);
            }
            return aSN1Enumerated.valueBytes.length;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1Enumerated(int i) {
        this(BigInteger.valueOf(i));
    }

    /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
    @Override // com.hierynomus.asn1.types.ASN1Object
    public BigInteger getValue() {
        return this.value;
    }

    public ASN1Enumerated(BigInteger bigInteger) {
        super(ASN1Tag.ENUMERATED);
        this.value = bigInteger;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1Enumerated> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1Enumerated parse(ASN1Tag<ASN1Enumerated> aSN1Tag, byte[] bArr) {
            return new ASN1Enumerated(new BigInteger(bArr), bArr);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1Enumerated>) aSN1Tag, bArr);
        }
    }

    private ASN1Enumerated(BigInteger bigInteger, byte[] bArr) {
        super(ASN1Tag.ENUMERATED, bArr);
        this.value = bigInteger;
    }
}

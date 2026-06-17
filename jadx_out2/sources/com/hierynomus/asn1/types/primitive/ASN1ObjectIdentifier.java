package com.hierynomus.asn1.types.primitive;

import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.ASN1Parser;
import com.hierynomus.asn1.ASN1Serializer;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.util.Checks;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1ObjectIdentifier extends ASN1PrimitiveValue<String> {
    private String oid;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1ObjectIdentifier> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void calculateBytes(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            String str = aSN1ObjectIdentifier.oid;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            byteArrayOutputStream.write((Integer.parseInt(stringTokenizer.nextToken()) * 40) + Integer.parseInt(stringTokenizer.nextToken()));
            while (stringTokenizer.hasMoreTokens()) {
                BigInteger bigInteger = new BigInteger(stringTokenizer.nextToken());
                if (bigInteger.intValue() <= 0 || bigInteger.intValue() >= 127) {
                    for (int iBitLength = ((bigInteger.bitLength() / 7) + (bigInteger.bitLength() % 7 > 0 ? 1 : 0)) - 1; iBitLength >= 0; iBitLength--) {
                        byte bByteValue = (byte) (bigInteger.shiftRight(iBitLength * 7).byteValue() & 127);
                        if (iBitLength > 0) {
                            bByteValue = (byte) (bByteValue | 128);
                        }
                        byteArrayOutputStream.write(bByteValue);
                    }
                } else {
                    byteArrayOutputStream.write(bigInteger.intValue());
                }
            }
            aSN1ObjectIdentifier.valueBytes = byteArrayOutputStream.toByteArray();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serialize(Lcom/hierynomus/asn1/types/ASN1Object;Lcom/hierynomus/asn1/ASN1OutputStream;)V */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1OutputStream aSN1OutputStream) throws IOException {
            if (aSN1ObjectIdentifier.valueBytes == null) {
                calculateBytes(aSN1ObjectIdentifier);
            }
            aSN1OutputStream.write(aSN1ObjectIdentifier.valueBytes);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serializedLength(Lcom/hierynomus/asn1/types/ASN1Object;)I */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            if (aSN1ObjectIdentifier.valueBytes == null) {
                calculateBytes(aSN1ObjectIdentifier);
            }
            return aSN1ObjectIdentifier.valueBytes.length;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1ObjectIdentifier(String str) {
        super(ASN1Tag.OBJECT_IDENTIFIER);
        this.oid = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.asn1.types.primitive.ASN1PrimitiveValue
    public int valueHash() {
        return this.oid.hashCode();
    }

    /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
    @Override // com.hierynomus.asn1.types.ASN1Object
    public String getValue() {
        return this.oid;
    }

    private ASN1ObjectIdentifier(byte[] bArr, String str) {
        super(ASN1Tag.OBJECT_IDENTIFIER, bArr);
        this.oid = str;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1ObjectIdentifier> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1ObjectIdentifier parse(ASN1Tag<ASN1ObjectIdentifier> aSN1Tag, byte[] bArr) {
            int i;
            Checks.checkArgument(bArr.length > 0, "An ASN.1 OBJECT IDENTIFIER should have at least a one byte value", new Object[0]);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            StringBuilder sb = new StringBuilder();
            int i2 = byteArrayInputStream.read();
            sb.append(i2 / 40);
            sb.append('.');
            sb.append(i2 % 40);
            while (byteArrayInputStream.available() > 0) {
                int i3 = byteArrayInputStream.read();
                if (i3 < 127) {
                    sb.append('.');
                    sb.append(i3);
                } else {
                    BigInteger bigIntegerValueOf = BigInteger.valueOf(i3 & 127);
                    do {
                        i = byteArrayInputStream.read();
                        bigIntegerValueOf = bigIntegerValueOf.shiftLeft(7).add(BigInteger.valueOf(i & 127));
                    } while (i > 127);
                    sb.append('.');
                    sb.append(bigIntegerValueOf);
                }
            }
            return new ASN1ObjectIdentifier(bArr, sb.toString());
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1ObjectIdentifier>) aSN1Tag, bArr);
        }
    }
}

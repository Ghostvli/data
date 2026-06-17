package com.hierynomus.asn1.types.string;

import com.hierynomus.asn1.ASN1InputStream;
import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.ASN1ParseException;
import com.hierynomus.asn1.ASN1Parser;
import com.hierynomus.asn1.ASN1Serializer;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.util.Checks;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1BitString extends ASN1String<boolean[]> {
    private boolean[] bits;
    private int unusedBits;

    public ASN1BitString(boolean[] zArr) {
        super(ASN1Tag.BIT_STRING, constructBytes(zArr));
        this.bits = zArr;
        this.unusedBits = 8 - (zArr.length % 8);
    }

    private boolean[] constructBits() {
        int length = length();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = isSet(i);
        }
        return zArr;
    }

    private static byte[] constructBytes(boolean[] zArr) {
        int length = (zArr.length / 8) + (zArr.length % 8 > 0 ? 1 : 0);
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                int i3 = (i * 8) + i2;
                bArr[i] = (byte) (bArr[i] + (((i3 >= zArr.length || !zArr[i3]) ? 0 : 1) << (7 - i2)));
            }
        }
        return bArr;
    }

    @Override // com.hierynomus.asn1.types.ASN1Object
    public boolean[] getValue() {
        boolean[] zArr = this.bits;
        return Arrays.copyOf(zArr, zArr.length);
    }

    public boolean isSet(int i) {
        return (this.valueBytes[i / 8] & (1 << (7 - (i % 8)))) != 0;
    }

    @Override // com.hierynomus.asn1.types.string.ASN1String
    public int length() {
        return (this.valueBytes.length * 8) - this.unusedBits;
    }

    @Override // com.hierynomus.asn1.types.ASN1Object
    public String valueString() {
        return Arrays.toString(this.bits);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1BitString> {
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1BitString aSN1BitString, ASN1OutputStream aSN1OutputStream) throws IOException {
            aSN1OutputStream.write(aSN1BitString.unusedBits);
            aSN1OutputStream.write(aSN1BitString.valueBytes);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1BitString aSN1BitString) {
            return aSN1BitString.valueBytes.length + 1;
        }
    }

    private ASN1BitString(ASN1Tag<ASN1BitString> aSN1Tag, byte[] bArr, int i) {
        super(aSN1Tag, bArr);
        this.unusedBits = i;
        this.bits = constructBits();
    }

    public ASN1BitString(byte[] bArr, int i) {
        this(ASN1Tag.BIT_STRING, bArr, i);
    }

    public ASN1BitString(BitSet bitSet) {
        this(ASN1Tag.BIT_STRING, constructBytes(bitSet), 0);
    }

    private static byte[] constructBytes(BitSet bitSet) {
        int length = (bitSet.length() / 8) + 1;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i] = (byte) (bArr[i] + ((bitSet.get((i * 8) + i2) ? 1 : 0) << (7 - i2)));
            }
        }
        return bArr;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1BitString> {
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1BitString parse(ASN1Tag<ASN1BitString> aSN1Tag, byte[] bArr) {
            if (!aSN1Tag.isConstructed()) {
                return new ASN1BitString(aSN1Tag, Arrays.copyOfRange(bArr, 1, bArr.length), bArr[0]);
            }
            try {
                ASN1InputStream aSN1InputStream = new ASN1InputStream(this.decoder, bArr);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte b = 0;
                    while (aSN1InputStream.available() > 0) {
                        ASN1Tag tag = aSN1InputStream.readTag();
                        Checks.checkState(tag.getTag() == aSN1Tag.getTag(), "Expected an ASN.1 BIT STRING as Constructed object, got: %s", tag);
                        byte[] value = aSN1InputStream.readValue(aSN1InputStream.readLength());
                        byteArrayOutputStream.write(value, 1, value.length - 1);
                        if (aSN1InputStream.available() <= 0) {
                            b = value[0];
                        }
                    }
                    ASN1BitString aSN1BitString = new ASN1BitString(aSN1Tag, byteArrayOutputStream.toByteArray(), b);
                    aSN1InputStream.close();
                    return aSN1BitString;
                } finally {
                }
            } catch (IOException e) {
                throw new ASN1ParseException(e, "Unable to parse Constructed ASN.1 BIT STRING", new Object[0]);
            }
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1BitString>) aSN1Tag, bArr);
        }
    }
}

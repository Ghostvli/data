package com.hierynomus.asn1.types.primitive;

import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.ASN1Parser;
import com.hierynomus.asn1.ASN1Serializer;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.util.Checks;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1Boolean extends ASN1PrimitiveValue<Boolean> {
    private boolean value;

    public ASN1Boolean(boolean z) {
        super(ASN1Tag.BOOLEAN);
        this.value = z;
    }

    @Override // com.hierynomus.asn1.types.ASN1Object
    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }

    @Override // com.hierynomus.asn1.types.primitive.ASN1PrimitiveValue
    public int valueHash() {
        return this.value ? 1231 : 1237;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1Boolean> {
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1Boolean aSN1Boolean, ASN1OutputStream aSN1OutputStream) throws IOException {
            aSN1OutputStream.write(aSN1Boolean.value ? 1 : 0);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1Boolean aSN1Boolean) {
            return 1;
        }
    }

    private ASN1Boolean(byte[] bArr, boolean z) {
        super(ASN1Tag.BOOLEAN, bArr);
        this.value = z;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1Boolean> {
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1Boolean parse(ASN1Tag<ASN1Boolean> aSN1Tag, byte[] bArr) {
            Checks.checkState(bArr.length == 1, "Value of ASN1Boolean should have length 1, but was %s", Integer.valueOf(bArr.length));
            return new ASN1Boolean(bArr, bArr[0] != 0);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1Boolean>) aSN1Tag, bArr);
        }
    }
}

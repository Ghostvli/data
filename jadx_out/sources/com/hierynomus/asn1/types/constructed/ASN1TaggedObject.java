package com.hierynomus.asn1.types.constructed;

import com.hierynomus.asn1.ASN1InputStream;
import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.ASN1ParseException;
import com.hierynomus.asn1.ASN1Parser;
import com.hierynomus.asn1.ASN1Serializer;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Constructed;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1TaggedObject extends ASN1Object<ASN1Object> implements ASN1Constructed {
    private byte[] bytes;
    private ASN1Decoder decoder;
    private boolean explicit;
    private final ASN1Object object;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1TaggedObject> {
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        private void calculateBytes(ASN1TaggedObject aSN1TaggedObject) throws IOException {
            ASN1Object aSN1Object = aSN1TaggedObject.object;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(this.encoder, byteArrayOutputStream);
            try {
                if (aSN1TaggedObject.explicit) {
                    aSN1OutputStream.writeObject(aSN1Object);
                } else {
                    aSN1Object.getTag().newSerializer(this.encoder).serialize(aSN1Object, aSN1OutputStream);
                }
                aSN1TaggedObject.bytes = byteArrayOutputStream.toByteArray();
                aSN1OutputStream.close();
            } catch (Throwable th) {
                try {
                    aSN1OutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1TaggedObject aSN1TaggedObject, ASN1OutputStream aSN1OutputStream) throws IOException {
            if (aSN1TaggedObject.bytes == null) {
                calculateBytes(aSN1TaggedObject);
            }
            aSN1OutputStream.write(aSN1TaggedObject.bytes);
        }

        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1TaggedObject aSN1TaggedObject) throws IOException {
            if (aSN1TaggedObject.bytes == null) {
                calculateBytes(aSN1TaggedObject);
            }
            return aSN1TaggedObject.bytes.length;
        }
    }

    public ASN1TaggedObject(ASN1Tag aSN1Tag, ASN1Object aSN1Object, boolean z) {
        super(z ? aSN1Tag.constructed() : aSN1Tag.asEncoded(aSN1Object.getTag().getAsn1Encoding()));
        this.object = aSN1Object;
        this.explicit = z;
        this.bytes = null;
    }

    public ASN1Object getObject() {
        ASN1Object aSN1Object = this.object;
        if (aSN1Object != null) {
            return aSN1Object;
        }
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(this.decoder, this.bytes);
            try {
                ASN1Object object = aSN1InputStream.readObject();
                aSN1InputStream.close();
                return object;
            } catch (Throwable th) {
                try {
                    aSN1InputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (ASN1ParseException e) {
            throw new ASN1ParseException(e, "Unable to parse the explicit Tagged Object with %s, it might be implicit", this.tag);
        } catch (IOException e2) {
            throw new ASN1ParseException(e2, "Could not parse the inputstream", new Object[0]);
        }
    }

    public int getTagNo() {
        return this.tag.getTag();
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Object> iterator() {
        return ((ASN1Sequence) getObject(ASN1Tag.SEQUENCE)).iterator();
    }

    @Override // com.hierynomus.asn1.types.ASN1Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append(this.tag);
        if (this.object != null) {
            sb.append(",");
            sb.append(this.object);
        } else {
            sb.append(",<unknown>");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.hierynomus.asn1.types.ASN1Object
    public ASN1Object getValue() {
        return getObject();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1TaggedObject> {
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1TaggedObject parse(ASN1Tag<ASN1TaggedObject> aSN1Tag, byte[] bArr) {
            return new ASN1TaggedObject(aSN1Tag, bArr, this.decoder);
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1TaggedObject>) aSN1Tag, bArr);
        }
    }

    public ASN1TaggedObject(ASN1Tag aSN1Tag, ASN1Object aSN1Object) {
        this(aSN1Tag, aSN1Object, true);
    }

    private ASN1TaggedObject(ASN1Tag aSN1Tag, byte[] bArr, ASN1Decoder aSN1Decoder) {
        super(aSN1Tag);
        this.explicit = true;
        this.bytes = bArr;
        this.decoder = aSN1Decoder;
        this.object = null;
    }

    public <T extends ASN1Object> T getObject(ASN1Tag<T> aSN1Tag) {
        ASN1Object aSN1Object = this.object;
        if (aSN1Object != null && aSN1Object.getTag().equals(aSN1Tag)) {
            return (T) this.object;
        }
        if (this.object == null && this.bytes != null) {
            return (T) aSN1Tag.newParser(this.decoder).parse(aSN1Tag, this.bytes);
        }
        throw new ASN1ParseException("Unable to parse the implicit Tagged Object with %s, it is explicit", aSN1Tag);
    }
}

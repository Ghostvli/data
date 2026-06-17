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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1Sequence extends ASN1Object<List<ASN1Object>> implements ASN1Constructed {
    private byte[] bytes;
    private final List<ASN1Object> objects;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1Sequence> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void calculateBytes(ASN1Sequence aSN1Sequence) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(this.encoder, byteArrayOutputStream);
            Iterator<ASN1Object> it = aSN1Sequence.iterator();
            while (it.hasNext()) {
                aSN1OutputStream.writeObject(it.next());
            }
            aSN1Sequence.bytes = byteArrayOutputStream.toByteArray();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serialize(Lcom/hierynomus/asn1/types/ASN1Object;Lcom/hierynomus/asn1/ASN1OutputStream;)V */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1Sequence aSN1Sequence, ASN1OutputStream aSN1OutputStream) throws IOException {
            if (aSN1Sequence.bytes != null) {
                aSN1OutputStream.write(aSN1Sequence.bytes);
                return;
            }
            Iterator<ASN1Object> it = aSN1Sequence.iterator();
            while (it.hasNext()) {
                aSN1OutputStream.writeObject(it.next());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serializedLength(Lcom/hierynomus/asn1/types/ASN1Object;)I */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1Sequence aSN1Sequence) throws IOException {
            if (aSN1Sequence.bytes == null) {
                calculateBytes(aSN1Sequence);
            }
            return aSN1Sequence.bytes.length;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ASN1Sequence(List<ASN1Object> list, byte[] bArr) {
        super(ASN1Tag.SEQUENCE);
        this.objects = list;
        this.bytes = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1Object get(int i) {
        return this.objects.get(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
    @Override // com.hierynomus.asn1.types.ASN1Object
    public List<ASN1Object> getValue() {
        return new ArrayList(this.objects);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator<ASN1Object> iterator() {
        return new ArrayList(this.objects).iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        return this.objects.size();
    }

    public ASN1Sequence(List<ASN1Object> list) {
        super(ASN1Tag.SEQUENCE);
        this.objects = list;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1Sequence> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1Sequence parse(ASN1Tag<ASN1Sequence> aSN1Tag, byte[] bArr) {
            ArrayList arrayList = new ArrayList();
            try {
                ASN1InputStream aSN1InputStream = new ASN1InputStream(this.decoder, bArr);
                try {
                    Iterator<ASN1Object> it = aSN1InputStream.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                    aSN1InputStream.close();
                    return new ASN1Sequence(arrayList, bArr);
                } finally {
                }
            } catch (IOException e) {
                throw new ASN1ParseException(e, "Unable to parse the ASN.1 SEQUENCE contents.", new Object[0]);
            }
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1Sequence>) aSN1Tag, bArr);
        }
    }
}

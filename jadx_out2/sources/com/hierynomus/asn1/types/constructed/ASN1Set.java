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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1Set extends ASN1Object<Set<ASN1Object>> implements ASN1Constructed {
    private byte[] bytes;
    private final Set<ASN1Object> objects;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Serializer extends ASN1Serializer<ASN1Set> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Serializer(ASN1Encoder aSN1Encoder) {
            super(aSN1Encoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void calculateBytes(ASN1Set aSN1Set) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(this.encoder, byteArrayOutputStream);
            Iterator<ASN1Object> it = aSN1Set.iterator();
            while (it.hasNext()) {
                aSN1OutputStream.writeObject(it.next());
            }
            aSN1Set.bytes = byteArrayOutputStream.toByteArray();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serialize(Lcom/hierynomus/asn1/types/ASN1Object;Lcom/hierynomus/asn1/ASN1OutputStream;)V */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public void serialize(ASN1Set aSN1Set, ASN1OutputStream aSN1OutputStream) throws IOException {
            if (aSN1Set.bytes != null) {
                aSN1OutputStream.write(aSN1Set.bytes);
                return;
            }
            Iterator<ASN1Object> it = aSN1Set.iterator();
            while (it.hasNext()) {
                aSN1OutputStream.writeObject(it.next());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: serializedLength(Lcom/hierynomus/asn1/types/ASN1Object;)I */
        @Override // com.hierynomus.asn1.ASN1Serializer
        public int serializedLength(ASN1Set aSN1Set) throws IOException {
            if (aSN1Set.bytes == null) {
                calculateBytes(aSN1Set);
            }
            return aSN1Set.bytes.length;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1Set(Set<ASN1Object> set) {
        super(ASN1Tag.SET);
        this.objects = new HashSet(set);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
    @Override // com.hierynomus.asn1.types.ASN1Object
    public Set<ASN1Object> getValue() {
        return new HashSet(this.objects);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator<ASN1Object> iterator() {
        return new HashSet(this.objects).iterator();
    }

    private ASN1Set(Set<ASN1Object> set, byte[] bArr) {
        super(ASN1Tag.SET);
        this.objects = set;
        this.bytes = bArr;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Parser extends ASN1Parser<ASN1Set> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Parser(ASN1Decoder aSN1Decoder) {
            super(aSN1Decoder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.asn1.ASN1Parser
        public ASN1Set parse(ASN1Tag<ASN1Set> aSN1Tag, byte[] bArr) {
            HashSet hashSet = new HashSet();
            try {
                ASN1InputStream aSN1InputStream = new ASN1InputStream(this.decoder, bArr);
                try {
                    Iterator<ASN1Object> it = aSN1InputStream.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next());
                    }
                    aSN1InputStream.close();
                    return new ASN1Set(hashSet, bArr);
                } finally {
                }
            } catch (IOException e) {
                throw new ASN1ParseException(e, "Could not parse ASN.1 SET contents.", new Object[0]);
            }
        }

        @Override // com.hierynomus.asn1.ASN1Parser
        public /* bridge */ /* synthetic */ ASN1Object parse(ASN1Tag aSN1Tag, byte[] bArr) {
            return parse((ASN1Tag<ASN1Set>) aSN1Tag, bArr);
        }
    }
}

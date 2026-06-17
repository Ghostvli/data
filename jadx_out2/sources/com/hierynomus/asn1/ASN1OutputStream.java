package com.hierynomus.asn1;

import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1OutputStream extends FilterOutputStream {
    private final ASN1Encoder encoder;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1OutputStream(ASN1Encoder aSN1Encoder, OutputStream outputStream) {
        super(outputStream);
        this.encoder = aSN1Encoder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int lengthBytes(int i) {
        int i2 = 1;
        while (i > 255) {
            i2++;
            i >>= 8;
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeLength(int i) throws IOException {
        if (i < 127) {
            write(i);
            return;
        }
        int iLengthBytes = lengthBytes(i);
        write(iLengthBytes | 128);
        while (iLengthBytes > 0) {
            write(i >> ((iLengthBytes - 1) * 8));
            iLengthBytes--;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeTag(ASN1Tag aSN1Tag) throws IOException {
        write((byte) (aSN1Tag.getTag() | aSN1Tag.getAsn1TagClass().getValue() | aSN1Tag.getAsn1Encoding().getValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeObject(ASN1Object aSN1Object) throws IOException {
        writeTag(aSN1Object.getTag());
        ASN1Serializer aSN1SerializerNewSerializer = aSN1Object.getTag().newSerializer(this.encoder);
        writeLength(aSN1SerializerNewSerializer.serializedLength(aSN1Object));
        aSN1SerializerNewSerializer.serialize(aSN1Object, this);
    }
}

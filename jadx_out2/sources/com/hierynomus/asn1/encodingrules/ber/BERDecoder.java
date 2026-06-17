package com.hierynomus.asn1.encodingrules.ber;

import com.hierynomus.asn1.ASN1ParseException;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.types.ASN1Encoding;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.types.ASN1TagClass;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BERDecoder implements ASN1Decoder {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.asn1.encodingrules.ASN1Decoder
    public int readLength(InputStream inputStream) {
        try {
            int i = inputStream.read();
            if (i <= 127) {
                return i;
            }
            int i2 = i & 127;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = (i3 << 8) + inputStream.read();
            }
            if (i3 != 0) {
                return i3;
            }
            throw new ASN1ParseException("The indefinite length form is not (yet) supported!");
        } catch (IOException e) {
            throw new ASN1ParseException("Unable to read the length of the ASN.1 object.", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.asn1.encodingrules.ASN1Decoder
    public ASN1Tag<? extends ASN1Object> readTag(InputStream inputStream) {
        try {
            int i = inputStream.read();
            byte b = (byte) i;
            ASN1TagClass aSN1TagClass = ASN1TagClass.parseClass(b);
            ASN1Encoding encoding = ASN1Encoding.parseEncoding(b);
            int i2 = i & 31;
            if (i2 <= 30) {
                return ASN1Tag.forTag(aSN1TagClass, i2).asEncoded(encoding);
            }
            int i3 = inputStream.read();
            if ((i3 & 127) == 0) {
                throw new ASN1ParseException("corrupted stream - invalid high tag number found");
            }
            int i4 = 0;
            while (i3 >= 0 && (i3 & 128) != 0) {
                i4 = ((i3 & 127) | i4) << 7;
                i3 = inputStream.read();
            }
            if (i3 >= 0) {
                return ASN1Tag.forTag(aSN1TagClass, (i3 & 127) | i4).asEncoded(encoding);
            }
            throw new ASN1ParseException("EOF found inside tag value.");
        } catch (IOException e) {
            throw new ASN1ParseException("Unable to parse ASN.1 tag", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.asn1.encodingrules.ASN1Decoder
    public byte[] readValue(int i, InputStream inputStream) {
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            }
            return bArr;
        } catch (IOException e) {
            throw new ASN1ParseException("Unable to read the value of the ASN.1 object", e);
        }
    }
}

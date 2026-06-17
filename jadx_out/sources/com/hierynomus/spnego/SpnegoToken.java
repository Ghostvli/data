package com.hierynomus.spnego;

import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.encodingrules.der.DEREncoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.types.constructed.ASN1Sequence;
import com.hierynomus.asn1.types.constructed.ASN1TaggedObject;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpnegoToken {
    private String tokenName;
    private int tokenTagNo;

    public SpnegoToken(int i, String str) {
        this.tokenTagNo = i;
        this.tokenName = str;
    }

    public void parseSpnegoToken(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (aSN1Object instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Object;
            if (aSN1TaggedObject.getTagNo() == this.tokenTagNo) {
                ASN1Object object = aSN1TaggedObject.getObject();
                if (!(object instanceof ASN1Sequence)) {
                    throw new SpnegoException("Expected a " + this.tokenName + " (SEQUENCE), not: " + object);
                }
                for (ASN1Object aSN1Object2 : (ASN1Sequence) object) {
                    if (!(aSN1Object2 instanceof ASN1TaggedObject)) {
                        throw new SpnegoException("Expected an ASN.1 TaggedObject as " + this.tokenName + " contents, not: " + aSN1Object2);
                    }
                    parseTagged((ASN1TaggedObject) aSN1Object2);
                }
                return;
            }
        }
        throw new SpnegoException("Expected to find the " + this.tokenName + " (CHOICE [" + this.tokenTagNo + "]) header, not: " + aSN1Object);
    }

    public abstract void parseTagged(ASN1TaggedObject aSN1TaggedObject);

    public abstract void write(Buffer<?> buffer);

    public void writeGss(Buffer<?> buffer, ASN1Object<?> aSN1Object) throws IOException {
        ASN1TaggedObject aSN1TaggedObject = new ASN1TaggedObject(ASN1Tag.contextSpecific(this.tokenTagNo).constructed(), aSN1Object);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectIdentifiers.SPNEGO);
        arrayList.add(aSN1TaggedObject);
        ASN1TaggedObject aSN1TaggedObject2 = new ASN1TaggedObject(ASN1Tag.application(0), (ASN1Object) new ASN1Sequence(arrayList), false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(new DEREncoder(), byteArrayOutputStream);
        try {
            aSN1OutputStream.writeObject(aSN1TaggedObject2);
            aSN1OutputStream.close();
            buffer.putRawBytes(byteArrayOutputStream.toByteArray());
        } catch (Throwable th) {
            try {
                aSN1OutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

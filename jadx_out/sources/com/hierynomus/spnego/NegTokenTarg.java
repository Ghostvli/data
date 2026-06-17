package com.hierynomus.spnego;

import com.hierynomus.asn1.ASN1InputStream;
import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.encodingrules.der.DERDecoder;
import com.hierynomus.asn1.encodingrules.der.DEREncoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.types.constructed.ASN1Sequence;
import com.hierynomus.asn1.types.constructed.ASN1TaggedObject;
import com.hierynomus.asn1.types.primitive.ASN1Enumerated;
import com.hierynomus.asn1.types.primitive.ASN1ObjectIdentifier;
import com.hierynomus.asn1.types.string.ASN1OctetString;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import defpackage.k23;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NegTokenTarg extends SpnegoToken {
    private byte[] mechListMic;
    private BigInteger negotiationResult;
    private byte[] responseToken;
    private ASN1ObjectIdentifier supportedMech;

    public NegTokenTarg() {
        super(1, "NegTokenTarg");
    }

    private NegTokenTarg read(Buffer<?> buffer) throws SpnegoException {
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(new DERDecoder(), buffer.asInputStream());
            try {
                parseSpnegoToken(aSN1InputStream.readObject());
                aSN1InputStream.close();
                return this;
            } finally {
            }
        } catch (IOException e) {
            throw new SpnegoException("Could not read NegTokenTarg from buffer", e);
        }
    }

    private void readMechListMIC(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (aSN1Object instanceof ASN1OctetString) {
            this.mechListMic = ((ASN1OctetString) aSN1Object).getValue();
        } else {
            k23.a("Expected the responseToken (OCTET_STRING) contents, not: ", aSN1Object);
        }
    }

    private void readNegResult(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (aSN1Object instanceof ASN1Enumerated) {
            this.negotiationResult = ((ASN1Enumerated) aSN1Object).getValue();
            return;
        }
        throw new SpnegoException("Expected the negResult (ENUMERATED) contents, not: " + this.supportedMech);
    }

    private void readResponseToken(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (aSN1Object instanceof ASN1OctetString) {
            this.responseToken = ((ASN1OctetString) aSN1Object).getValue();
        } else {
            k23.a("Expected the responseToken (OCTET_STRING) contents, not: ", aSN1Object);
        }
    }

    private void readSupportedMech(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (aSN1Object instanceof ASN1ObjectIdentifier) {
            this.supportedMech = (ASN1ObjectIdentifier) aSN1Object;
        } else {
            k23.a("Expected the supportedMech (OBJECT IDENTIFIER) contents, not: ", aSN1Object);
        }
    }

    public byte[] getMechListMic() {
        return this.mechListMic;
    }

    public BigInteger getNegotiationResult() {
        return this.negotiationResult;
    }

    public byte[] getResponseToken() {
        return this.responseToken;
    }

    public ASN1ObjectIdentifier getSupportedMech() {
        return this.supportedMech;
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void parseTagged(ASN1TaggedObject aSN1TaggedObject) throws SpnegoException {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            readNegResult(aSN1TaggedObject.getObject());
            return;
        }
        if (tagNo == 1) {
            readSupportedMech(aSN1TaggedObject.getObject());
            return;
        }
        if (tagNo == 2) {
            readResponseToken(aSN1TaggedObject.getObject());
            return;
        }
        if (tagNo == 3) {
            readMechListMIC(aSN1TaggedObject.getObject());
            return;
        }
        throw new SpnegoException("Unknown Object Tag " + aSN1TaggedObject.getTagNo() + " encountered.");
    }

    public void setMechListMic(byte[] bArr) {
        this.mechListMic = bArr;
    }

    public void setNegotiationResult(BigInteger bigInteger) {
        this.negotiationResult = bigInteger;
    }

    public void setResponseToken(byte[] bArr) {
        this.responseToken = bArr;
    }

    public void setSupportedMech(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.supportedMech = aSN1ObjectIdentifier;
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void write(Buffer<?> buffer) throws SpnegoException {
        ArrayList arrayList = new ArrayList();
        try {
            if (this.negotiationResult != null) {
                arrayList.add(new ASN1TaggedObject(ASN1Tag.contextSpecific(0).constructed(), new ASN1Enumerated(this.negotiationResult)));
            }
            if (this.supportedMech != null) {
                arrayList.add(new ASN1TaggedObject(ASN1Tag.contextSpecific(1).constructed(), this.supportedMech));
            }
            byte[] bArr = this.responseToken;
            if (bArr != null && bArr.length > 0) {
                arrayList.add(new ASN1TaggedObject(ASN1Tag.contextSpecific(2).constructed(), new ASN1OctetString(this.responseToken)));
            }
            byte[] bArr2 = this.mechListMic;
            if (bArr2 != null && bArr2.length > 0) {
                arrayList.add(new ASN1TaggedObject(ASN1Tag.contextSpecific(3).constructed(), new ASN1OctetString(this.mechListMic)));
            }
            writeGss(buffer, new ASN1Sequence(arrayList));
        } catch (IOException e) {
            throw new SpnegoException("Could not write NegTokenTarg to buffer", e);
        }
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void writeGss(Buffer<?> buffer, ASN1Object<?> aSN1Object) throws IOException {
        ASN1TaggedObject aSN1TaggedObject = new ASN1TaggedObject(ASN1Tag.contextSpecific(1).constructed(), (ASN1Object) aSN1Object, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(new DEREncoder(), byteArrayOutputStream);
        try {
            aSN1OutputStream.writeObject(aSN1TaggedObject);
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

    public NegTokenTarg read(byte[] bArr) {
        return read(new Buffer.PlainBuffer(bArr, Endian.LE));
    }
}

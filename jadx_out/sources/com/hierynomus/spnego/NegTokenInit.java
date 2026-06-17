package com.hierynomus.spnego;

import com.hierynomus.asn1.ASN1InputStream;
import com.hierynomus.asn1.encodingrules.der.DERDecoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import com.hierynomus.asn1.types.ASN1TagClass;
import com.hierynomus.asn1.types.constructed.ASN1Sequence;
import com.hierynomus.asn1.types.constructed.ASN1TaggedObject;
import com.hierynomus.asn1.types.primitive.ASN1ObjectIdentifier;
import com.hierynomus.asn1.types.string.ASN1OctetString;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import defpackage.k23;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NegTokenInit extends SpnegoToken {
    static final String ADS_IGNORE_PRINCIPAL = "not_defined_in_RFC4178@please_ignore";
    protected byte[] mechToken;
    private List<ASN1ObjectIdentifier> mechTypes;

    public NegTokenInit() {
        super(0, "NegTokenInit");
        this.mechTypes = new ArrayList();
    }

    private void addMechToken(List<ASN1Object> list) {
        byte[] bArr = this.mechToken;
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        list.add(new ASN1TaggedObject(ASN1Tag.contextSpecific(2).constructed(), (ASN1Object) new ASN1OctetString(this.mechToken), true));
    }

    private void addMechTypeList(List<ASN1Object> list) {
        if (this.mechTypes.size() > 0) {
            list.add(new ASN1TaggedObject(ASN1Tag.contextSpecific(0).constructed(), (ASN1Object) new ASN1Sequence(new ArrayList(this.mechTypes)), true));
        }
    }

    private NegTokenInit read(Buffer<?> buffer) throws SpnegoException {
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(new DERDecoder(), buffer.asInputStream());
            try {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1InputStream.readObject();
                if (aSN1TaggedObject.getTag().getAsn1TagClass() != ASN1TagClass.APPLICATION) {
                    throw new SpnegoException("Incorrect GSS-API ASN.1 token received, expected to find an [APPLICATION 0], not: " + aSN1TaggedObject);
                }
                ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1TaggedObject.getObject(ASN1Tag.SEQUENCE);
                ASN1Object aSN1Object = aSN1Sequence.get(0);
                if (aSN1Object instanceof ASN1ObjectIdentifier) {
                    parseSpnegoToken(aSN1Sequence.get(1));
                    aSN1InputStream.close();
                    return this;
                }
                throw new SpnegoException("Expected to find the SPNEGO OID (" + ObjectIdentifiers.SPNEGO + "), not: " + aSN1Object);
            } finally {
            }
        } catch (IOException e) {
            throw new SpnegoException("Could not read NegTokenInit from buffer", e);
        }
    }

    public void addSupportedMech(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.mechTypes.add(aSN1ObjectIdentifier);
    }

    public List<ASN1ObjectIdentifier> getSupportedMechTypes() {
        return this.mechTypes;
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void parseTagged(ASN1TaggedObject aSN1TaggedObject) throws SpnegoException {
        if (aSN1TaggedObject.getObject().toString().contains(ADS_IGNORE_PRINCIPAL)) {
            return;
        }
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            readMechTypeList(aSN1TaggedObject.getObject());
            return;
        }
        if (tagNo != 1) {
            if (tagNo == 2) {
                readMechToken(aSN1TaggedObject.getObject());
            } else {
                if (tagNo == 3) {
                    return;
                }
                throw new SpnegoException("Unknown Object Tag " + aSN1TaggedObject.getTagNo() + " encountered.");
            }
        }
    }

    public void readMechToken(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (aSN1Object instanceof ASN1OctetString) {
            this.mechToken = ((ASN1OctetString) aSN1Object).getValue();
        } else {
            k23.a("Expected the MechToken (OCTET_STRING) contents, not: ", aSN1Object);
        }
    }

    public void readMechTypeList(ASN1Object<?> aSN1Object) throws SpnegoException {
        if (!(aSN1Object instanceof ASN1Sequence)) {
            k23.a("Expected the MechTypeList (SEQUENCE) contents, not: ", aSN1Object);
            return;
        }
        for (ASN1Object aSN1Object2 : (ASN1Sequence) aSN1Object) {
            if (!(aSN1Object2 instanceof ASN1ObjectIdentifier)) {
                k23.a("Expected a MechType (OBJECT IDENTIFIER) as contents of the MechTypeList, not: ", aSN1Object2);
                return;
            }
            this.mechTypes.add((ASN1ObjectIdentifier) aSN1Object2);
        }
    }

    public void setMechToken(byte[] bArr) {
        this.mechToken = bArr;
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void write(Buffer<?> buffer) throws SpnegoException {
        try {
            ArrayList arrayList = new ArrayList();
            addMechTypeList(arrayList);
            addMechToken(arrayList);
            writeGss(buffer, new ASN1Sequence(arrayList));
        } catch (IOException e) {
            throw new SpnegoException("Unable to write NegTokenInit", e);
        }
    }

    public NegTokenInit read(byte[] bArr) {
        return read(new Buffer.PlainBuffer(bArr, Endian.LE));
    }
}

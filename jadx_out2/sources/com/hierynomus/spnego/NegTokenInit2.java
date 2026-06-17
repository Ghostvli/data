package com.hierynomus.spnego;

import com.hierynomus.asn1.types.constructed.ASN1TaggedObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NegTokenInit2 extends NegTokenInit {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.spnego.NegTokenInit, com.hierynomus.spnego.SpnegoToken
    public void parseTagged(ASN1TaggedObject aSN1TaggedObject) throws SpnegoException {
        if (aSN1TaggedObject.getObject().toString().contains("not_defined_in_RFC4178@please_ignore")) {
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
                return;
            }
            if (tagNo == 3 || tagNo == 4) {
                return;
            }
            throw new SpnegoException("Unknown Object Tag " + aSN1TaggedObject.getTagNo() + " encountered.");
        }
    }
}

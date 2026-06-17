package com.hierynomus.asn1.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ASN1Object<T> {
    protected ASN1Tag tag;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1Object(ASN1Tag aSN1Tag) {
        this.tag = aSN1Tag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ASN1Object aSN1Object = (ASN1Object) obj;
            if (this.tag != aSN1Object.tag) {
                return false;
            }
            if (getValue() != null) {
                return getValue().equals(aSN1Object.getValue());
            }
            if (aSN1Object.getValue() == null) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ASN1Tag getTag() {
        return this.tag;
    }

    public abstract T getValue();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.tag.getTag();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getClass().getSimpleName() + "[" + valueString() + "]";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String valueString() {
        if (getValue() != null) {
            return getValue().toString();
        }
        return null;
    }
}

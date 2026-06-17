package com.hierynomus.spnego;

import com.hierynomus.asn1.types.constructed.ASN1TaggedObject;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RawToken extends SpnegoToken {
    private byte[] rawToken;

    public RawToken(byte[] bArr) {
        super(0, null);
        this.rawToken = bArr;
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void parseTagged(ASN1TaggedObject aSN1TaggedObject) {
        throw new UnsupportedOperationException("RawToken does not support parsing of tagged objects");
    }

    @Override // com.hierynomus.spnego.SpnegoToken
    public void write(Buffer<?> buffer) {
        byte[] bArr = this.rawToken;
        if (bArr != null) {
            buffer.putRawBytes(bArr);
        }
    }
}

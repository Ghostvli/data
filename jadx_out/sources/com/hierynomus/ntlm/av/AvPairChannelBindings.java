package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairChannelBindings extends AvPair<byte[]> {
    public AvPairChannelBindings() {
        super(AvId.MsvAvChannelBindings);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, byte[]] */
    @Override // com.hierynomus.ntlm.av.AvPair
    public AvPair<byte[]> read(Buffer<?> buffer) {
        this.value = buffer.readRawBytes(buffer.readUInt16());
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hierynomus.ntlm.av.AvPair
    public void write(Buffer<?> buffer) {
        buffer.putUInt16((int) this.avId.getValue());
        buffer.putUInt16(((byte[]) this.value).length);
        buffer.putRawBytes((byte[]) this.value);
    }

    public AvPairChannelBindings(byte[] bArr) {
        super(AvId.MsvAvChannelBindings, bArr);
    }
}

package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairEnd extends AvPair<Void> {
    public AvPairEnd() {
        super(AvId.MsvAvEOL);
    }

    @Override // com.hierynomus.ntlm.av.AvPair
    public AvPair<Void> read(Buffer<?> buffer) {
        buffer.readUInt16();
        return this;
    }

    @Override // com.hierynomus.ntlm.av.AvPair
    public void write(Buffer<?> buffer) {
        buffer.putUInt16((int) this.avId.getValue());
        buffer.putUInt16(0);
    }
}

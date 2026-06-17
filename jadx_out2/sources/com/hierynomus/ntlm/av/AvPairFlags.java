package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairFlags extends AvPair<Long> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AvPairFlags(long j) {
        super(AvId.MsvAvFlags, Long.valueOf(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Long] */
    @Override // com.hierynomus.ntlm.av.AvPair
    public AvPair<Long> read(Buffer<?> buffer) {
        buffer.readUInt16();
        this.value = Long.valueOf(buffer.readUInt32());
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hierynomus.ntlm.av.AvPair
    public void write(Buffer<?> buffer) {
        buffer.putUInt16((int) this.avId.getValue());
        buffer.putUInt16(4);
        buffer.putUInt32(((Long) this.value).longValue());
    }

    public AvPairFlags() {
        super(AvId.MsvAvFlags);
    }
}

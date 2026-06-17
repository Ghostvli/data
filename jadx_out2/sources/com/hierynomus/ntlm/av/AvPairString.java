package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairString extends AvPair<String> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AvPairString(AvId avId) {
        super(avId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Return type fixed from 'com.hierynomus.ntlm.av.AvPairString' to match base method */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    @Override // com.hierynomus.ntlm.av.AvPair
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public AvPair<String> read2(Buffer<?> buffer) {
        this.value = buffer.readString(Charsets.UTF_16LE, buffer.readUInt16() / 2);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hierynomus.ntlm.av.AvPair
    public void write(Buffer<?> buffer) {
        buffer.putUInt16((int) this.avId.getValue());
        buffer.putUInt16(((String) this.value).length() * 2);
        buffer.putString((String) this.value, Charsets.UTF_16LE);
    }

    public AvPairString(AvId avId, String str) {
        super(avId, str);
    }

    /* JADX DEBUG: Return type fixed from 'com.hierynomus.ntlm.av.AvPair' to match base method */
    @Override // com.hierynomus.ntlm.av.AvPair
    public /* bridge */ /* synthetic */ AvPair<String> read(Buffer buffer) {
        return read2((Buffer<?>) buffer);
    }
}

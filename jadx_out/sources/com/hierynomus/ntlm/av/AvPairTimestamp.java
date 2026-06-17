package com.hierynomus.ntlm.av;

import com.hierynomus.msdtyp.FileTime;
import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairTimestamp extends AvPair<FileTime> {
    public AvPairTimestamp() {
        super(AvId.MsvAvTimestamp);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.hierynomus.msdtyp.FileTime] */
    @Override // com.hierynomus.ntlm.av.AvPair
    public AvPair<FileTime> read(Buffer<?> buffer) {
        buffer.readUInt16();
        this.value = MsDataTypes.readFileTime(buffer);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hierynomus.ntlm.av.AvPair
    public void write(Buffer<?> buffer) {
        buffer.putUInt16((int) this.avId.getValue());
        buffer.putUInt16(8);
        MsDataTypes.putFileTime((FileTime) this.value, buffer);
    }
}

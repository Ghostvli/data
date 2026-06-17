package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairSingleHost extends AvPair<byte[]> {
    private byte[] machineID;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AvPairSingleHost(byte[] bArr, byte[] bArr2) {
        super(AvId.MsvAvSingleHost, bArr);
        this.machineID = bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Return type fixed from 'com.hierynomus.ntlm.av.AvPairSingleHost' to match base method */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, byte[]] */
    @Override // com.hierynomus.ntlm.av.AvPair
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public AvPair<byte[]> read2(Buffer<?> buffer) throws Buffer.BufferException {
        buffer.readUInt16();
        buffer.readUInt32();
        buffer.skip(4);
        this.value = buffer.readRawBytes(8);
        this.machineID = buffer.readRawBytes(32);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hierynomus.ntlm.av.AvPair
    public void write(Buffer<?> buffer) {
        buffer.putUInt16((int) this.avId.getValue());
        buffer.putUInt16(48);
        buffer.putUInt32(48L);
        buffer.putUInt32(0L);
        buffer.putRawBytes((byte[]) this.value);
        buffer.putRawBytes(this.machineID);
    }

    public AvPairSingleHost() {
        super(AvId.MsvAvSingleHost);
    }

    /* JADX DEBUG: Return type fixed from 'com.hierynomus.ntlm.av.AvPair' to match base method */
    @Override // com.hierynomus.ntlm.av.AvPair
    public /* bridge */ /* synthetic */ AvPair<byte[]> read(Buffer buffer) {
        return read2((Buffer<?>) buffer);
    }
}

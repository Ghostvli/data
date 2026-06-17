package com.hierynomus.smb;

import com.hierynomus.protocol.Packet;
import com.hierynomus.smb.SMBHeader;
import com.hierynomus.smb.SMBPacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SMBPacket<D extends SMBPacketData<H>, H extends SMBHeader> implements Packet<SMBBuffer> {
    protected SMBBuffer buffer;
    protected H header;

    public SMBPacket(H h) {
        this.header = h;
    }

    public SMBBuffer getBuffer() {
        return this.buffer;
    }

    public H getHeader() {
        return this.header;
    }

    @Override // com.hierynomus.protocol.Packet
    public final void read(SMBBuffer sMBBuffer) {
        throw new UnsupportedOperationException("Call read(D extends PacketData<H>) instead of this method");
    }

    public abstract void read(D d);
}

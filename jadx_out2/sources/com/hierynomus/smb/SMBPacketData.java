package com.hierynomus.smb;

import com.hierynomus.protocol.PacketData;
import com.hierynomus.smb.SMBHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SMBPacketData<H extends SMBHeader> implements PacketData<SMBBuffer> {
    protected SMBBuffer dataBuffer;
    private H header;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMBPacketData(H h, SMBBuffer sMBBuffer) {
        this.header = h;
        this.dataBuffer = sMBBuffer;
        readHeader();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public H getHeader() {
        return this.header;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readHeader() {
        this.header.readFrom(this.dataBuffer);
    }

    /* JADX DEBUG: Method merged with bridge method: getDataBuffer()Lcom/hierynomus/protocol/commons/buffer/Buffer; */
    @Override // com.hierynomus.protocol.PacketData
    public SMBBuffer getDataBuffer() {
        return this.dataBuffer;
    }

    public SMBPacketData(H h, byte[] bArr) {
        this(h, new SMBBuffer(bArr));
    }

    public SMBPacketData(H h) {
        this.header = h;
    }
}

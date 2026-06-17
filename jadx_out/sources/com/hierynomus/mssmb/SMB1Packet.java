package com.hierynomus.mssmb;

import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBPacket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB1Packet extends SMBPacket<SMB1PacketData, SMB1Header> {
    public SMB1Packet() {
        super(new SMB1Header());
    }

    @Override // com.hierynomus.smb.SMBPacket
    public void read(SMB1PacketData sMB1PacketData) {
        throw new UnsupportedOperationException("Receiving SMBv1 messages not supported in SMBJ");
    }

    @Override // com.hierynomus.protocol.Packet
    public final void write(SMBBuffer sMBBuffer) {
        this.buffer = sMBBuffer;
        ((SMB1Header) this.header).writeTo(sMBBuffer);
        writeTo(sMBBuffer);
    }

    public void writeTo(SMBBuffer sMBBuffer) {
        throw new UnsupportedOperationException("Sending SMBv1 messages not supported in SMBJ");
    }
}

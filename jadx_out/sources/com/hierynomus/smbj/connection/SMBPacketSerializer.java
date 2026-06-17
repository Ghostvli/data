package com.hierynomus.smbj.connection;

import com.hierynomus.protocol.transport.PacketSerializer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBPacket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBPacketSerializer implements PacketSerializer<SMBPacket<?, ?>, SMBBuffer> {
    @Override // com.hierynomus.protocol.transport.PacketSerializer
    public SMBBuffer write(SMBPacket<?, ?> sMBPacket) {
        SMBBuffer sMBBuffer = new SMBBuffer();
        sMBPacket.write(sMBBuffer);
        return sMBBuffer;
    }
}

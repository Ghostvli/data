package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smb.SMBPacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2CompoundedPacketHandler extends SMB2PacketHandler {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler, com.hierynomus.smbj.connection.packet.AbstractIncomingPacketHandler
    public boolean canHandle(SMBPacketData<?> sMBPacketData) {
        return super.canHandle(sMBPacketData) && ((SMB2PacketData) sMBPacketData).isCompounded();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler
    public void doSMB2Handle(SMB2PacketData sMB2PacketData) throws TransportException {
        do {
            this.next.handle(sMB2PacketData);
            try {
                sMB2PacketData = sMB2PacketData.next();
            } catch (Buffer.BufferException e) {
                throw new TransportException("Missing compounded message data", e);
            }
        } while (sMB2PacketData != null);
    }
}

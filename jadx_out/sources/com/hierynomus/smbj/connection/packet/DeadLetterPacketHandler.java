package com.hierynomus.smbj.connection.packet;

import com.hierynomus.smb.SMBPacketData;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeadLetterPacketHandler extends AbstractIncomingPacketHandler {
    private static final j02 logger = n02.k(DeadLetterPacketHandler.class);

    @Override // com.hierynomus.smbj.connection.packet.AbstractIncomingPacketHandler
    public boolean canHandle(SMBPacketData<?> sMBPacketData) {
        return true;
    }

    @Override // com.hierynomus.smbj.connection.packet.AbstractIncomingPacketHandler
    public void doHandle(SMBPacketData<?> sMBPacketData) {
        logger.d("Packet << {} >> ended up in dead letters", sMBPacketData);
    }
}

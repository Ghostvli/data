package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.smbj.connection.SequenceWindow;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2CreditGrantingPacketHandler extends SMB2PacketHandler {
    private static final j02 logger = n02.k(SMB2CreditGrantingPacketHandler.class);
    private SequenceWindow sequenceWindow;

    public SMB2CreditGrantingPacketHandler(SequenceWindow sequenceWindow) {
        this.sequenceWindow = sequenceWindow;
    }

    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler
    public void doSMB2Handle(SMB2PacketData sMB2PacketData) {
        this.sequenceWindow.creditsGranted(sMB2PacketData.getHeader().getCreditResponse());
        logger.s("Server granted us {} credits for {}, now available: {} credits", Integer.valueOf(sMB2PacketData.getHeader().getCreditResponse()), sMB2PacketData, Integer.valueOf(this.sequenceWindow.available()));
        this.next.handle(sMB2PacketData);
    }
}

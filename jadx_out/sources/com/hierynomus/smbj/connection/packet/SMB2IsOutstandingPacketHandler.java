package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.DeadLetterPacketData;
import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.smbj.connection.OutstandingRequests;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2IsOutstandingPacketHandler extends SMB2PacketHandler {
    private static final j02 logger = n02.k(SMB2IsOutstandingPacketHandler.class);
    private OutstandingRequests outstandingRequests;

    public SMB2IsOutstandingPacketHandler(OutstandingRequests outstandingRequests) {
        this.outstandingRequests = outstandingRequests;
    }

    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler
    public void doSMB2Handle(SMB2PacketData sMB2PacketData) {
        long sequenceNumber = sMB2PacketData.getSequenceNumber();
        if (this.outstandingRequests.isOutstanding(Long.valueOf(sequenceNumber)) || sMB2PacketData.isOplockBreakNotification()) {
            this.next.handle(sMB2PacketData);
        } else {
            logger.r("Received response with unknown sequence number << {} >>", Long.valueOf(sequenceNumber));
            this.next.handle(new DeadLetterPacketData(sMB2PacketData.getHeader()));
        }
    }
}

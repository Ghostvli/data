package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.smbj.connection.OutstandingRequests;
import com.hierynomus.smbj.connection.Request;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2AsyncResponsePacketHandler extends SMB2PacketHandler {
    private static final j02 logger = n02.k(SMB2AsyncResponsePacketHandler.class);
    private OutstandingRequests outstandingRequests;

    public SMB2AsyncResponsePacketHandler(OutstandingRequests outstandingRequests) {
        this.outstandingRequests = outstandingRequests;
    }

    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler
    public void doSMB2Handle(SMB2PacketData sMB2PacketData) {
        Request requestByMessageId = this.outstandingRequests.getRequestByMessageId(Long.valueOf(sMB2PacketData.getHeader().getMessageId()));
        j02 j02Var = logger;
        j02Var.i("Send/Recv of packet {} took << {} ms >>", sMB2PacketData, Long.valueOf(System.currentTimeMillis() - requestByMessageId.getTimestamp().getTime()));
        if (!sMB2PacketData.isIntermediateAsyncResponse()) {
            this.next.handle(sMB2PacketData);
        } else {
            j02Var.f("Received ASYNC packet {} with AsyncId << {} >>", sMB2PacketData, Long.valueOf(sMB2PacketData.getHeader().getAsyncId()));
            requestByMessageId.setAsyncId(sMB2PacketData.getHeader().getAsyncId());
        }
    }
}

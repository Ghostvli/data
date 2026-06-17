package com.hierynomus.smbj.connection.packet;

import com.hierynomus.smb.SMBPacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractIncomingPacketHandler implements IncomingPacketHandler {
    protected IncomingPacketHandler next;

    public abstract boolean canHandle(SMBPacketData<?> sMBPacketData);

    public abstract void doHandle(SMBPacketData<?> sMBPacketData);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.IncomingPacketHandler
    public void handle(SMBPacketData<?> sMBPacketData) {
        if (canHandle(sMBPacketData)) {
            doHandle(sMBPacketData);
        } else {
            this.next.handle(sMBPacketData);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.IncomingPacketHandler
    public IncomingPacketHandler setNext(IncomingPacketHandler incomingPacketHandler) {
        this.next = incomingPacketHandler;
        return this;
    }
}

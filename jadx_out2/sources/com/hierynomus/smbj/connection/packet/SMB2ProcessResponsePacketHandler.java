package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.SMB2MessageConverter;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.connection.OutstandingRequests;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2ProcessResponsePacketHandler extends SMB2PacketHandler {
    private static final j02 logger = n02.k(SMB2ProcessResponsePacketHandler.class);
    private final OutstandingRequests outstandingRequests;
    private final SMB2MessageConverter smb2Converter;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2ProcessResponsePacketHandler(SMB2MessageConverter sMB2MessageConverter, OutstandingRequests outstandingRequests) {
        this.smb2Converter = sMB2MessageConverter;
        this.outstandingRequests = outstandingRequests;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler
    public void doSMB2Handle(SMB2PacketData sMB2PacketData) throws TransportException {
        try {
            SMB2Packet packet = this.smb2Converter.readPacket(this.outstandingRequests.getRequestByMessageId(Long.valueOf(sMB2PacketData.getHeader().getMessageId())).getPacket(), sMB2PacketData);
            this.outstandingRequests.receivedResponseFor(Long.valueOf(packet.getHeader().getMessageId())).getPromise().deliver(packet);
        } catch (Buffer.BufferException e) {
            logger.r("Failed to deserialize SMB2 Packet Data of {}", sMB2PacketData);
            throw new TransportException("Unable to deserialize SMB2 Packet Data.", e);
        }
    }
}

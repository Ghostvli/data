package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.DeadLetterPacketData;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2MessageFlag;
import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.smbj.connection.SessionTable;
import com.hierynomus.smbj.connection.Signatory;
import com.hierynomus.smbj.session.Session;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2SignatureVerificationPacketHandler extends SMB2PacketHandler {
    private static final j02 logger = n02.k(SMB2SignatureVerificationPacketHandler.class);
    private SessionTable sessionTable;
    private Signatory signatory;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2SignatureVerificationPacketHandler(SessionTable sessionTable, Signatory signatory) {
        this.sessionTable = sessionTable;
        this.signatory = signatory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.SMB2PacketHandler
    public void doSMB2Handle(SMB2PacketData sMB2PacketData) {
        if (sMB2PacketData.getHeader().getMessageId() == -1) {
            logger.b("Message ID is 0xFFFFFFFFFFFFFFFF, no verification necessary");
            this.next.handle(sMB2PacketData);
            return;
        }
        if (sMB2PacketData.isDecrypted()) {
            logger.b("Passthrough Signature Verification as packet is decrypted");
            this.next.handle(sMB2PacketData);
            return;
        }
        SMB2PacketHeader header = sMB2PacketData.getHeader();
        SMB2MessageFlag sMB2MessageFlag = SMB2MessageFlag.SMB2_FLAGS_SIGNED;
        if (!header.isFlagSet(sMB2MessageFlag)) {
            if (!sMB2PacketData.getHeader().isFlagSet(sMB2MessageFlag) && !sMB2PacketData.isIntermediateAsyncResponse() && !sMB2PacketData.isOplockBreakNotification()) {
                Session sessionFind = this.sessionTable.find(Long.valueOf(sMB2PacketData.getHeader().getSessionId()));
                if (sessionFind != null && sessionFind.isSigningRequired()) {
                    logger.d("Illegal request, session requires message signing, but packet {} is not signed.", sMB2PacketData);
                    this.next.handle(new DeadLetterPacketData(sMB2PacketData.getHeader()));
                    return;
                }
            }
            this.next.handle(sMB2PacketData);
            return;
        }
        long sessionId = sMB2PacketData.getHeader().getSessionId();
        if (sessionId == 0 || sMB2PacketData.getHeader().getMessage() == SMB2MessageCommandCode.SMB2_SESSION_SETUP) {
            this.next.handle(sMB2PacketData);
            return;
        }
        Session sessionFind2 = this.sessionTable.find(Long.valueOf(sessionId));
        if (sessionFind2 == null) {
            logger.o("Could not find session << {} >> for packet {}.", Long.valueOf(sessionId), sMB2PacketData);
            this.next.handle(new DeadLetterPacketData(sMB2PacketData.getHeader()));
        } else if (this.signatory.verify(sMB2PacketData, sessionFind2.getSigningKey(sMB2PacketData.getHeader(), false))) {
            logger.q("Signature for packet {} verified.", sMB2PacketData);
            this.next.handle(sMB2PacketData);
        } else {
            logger.d("Invalid packet signature for packet {}", sMB2PacketData);
            this.next.handle(new DeadLetterPacketData(sMB2PacketData.getHeader()));
        }
    }
}

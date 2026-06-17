package com.hierynomus.smbj.connection.packet;

import com.hierynomus.mssmb2.DeadLetterPacketData;
import com.hierynomus.mssmb2.SMB2CompressionTransformHeader;
import com.hierynomus.mssmb2.SMB2DecryptedPacketData;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.mssmb2.SMB2TransformHeader;
import com.hierynomus.mssmb2.SMB3CompressedPacketData;
import com.hierynomus.mssmb2.SMB3EncryptedPacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smb.SMBPacketData;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.connection.PacketEncryptor;
import com.hierynomus.smbj.connection.SessionTable;
import com.hierynomus.smbj.session.Session;
import defpackage.j02;
import defpackage.n02;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB3DecryptingPacketHandler extends AbstractIncomingPacketHandler {
    private static final j02 logger = n02.k(SMB3DecryptingPacketHandler.class);
    private PacketEncryptor encryptor;
    private SessionTable sessionTable;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB3DecryptingPacketHandler(SessionTable sessionTable, PacketEncryptor packetEncryptor) {
        this.sessionTable = sessionTable;
        this.encryptor = packetEncryptor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void handleCompressedPacket(SMBPacketData<?> sMBPacketData, byte[] bArr) {
        logger.q("Packet {} is compressed.", sMBPacketData);
        try {
            this.next.handle(new SMB3CompressedPacketData(bArr, true));
        } catch (Buffer.BufferException e) {
            throw new SMBRuntimeException("Could not load compression header", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void handleSMB2Packet(byte[] bArr, SMB3EncryptedPacketData sMB3EncryptedPacketData) {
        try {
            SMB2DecryptedPacketData sMB2DecryptedPacketData = new SMB2DecryptedPacketData(bArr);
            j02 j02Var = logger;
            j02Var.f("Decrypted packet {} is packet {}.", sMB3EncryptedPacketData, sMB2DecryptedPacketData);
            if (sMB2DecryptedPacketData.getHeader().getSessionId() == sMB3EncryptedPacketData.getHeader().getSessionId()) {
                this.next.handle(sMB2DecryptedPacketData);
            } else {
                j02Var.o("Mismatched sessionId between encrypted packet {} and decrypted contents {}", sMB3EncryptedPacketData, sMB2DecryptedPacketData);
                this.next.handle(new DeadLetterPacketData(sMB2DecryptedPacketData.getHeader()));
            }
        } catch (Buffer.BufferException e) {
            throw new SMBRuntimeException("Could not load SMB2 Packet", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.AbstractIncomingPacketHandler
    public boolean canHandle(SMBPacketData<?> sMBPacketData) {
        return sMBPacketData instanceof SMB3EncryptedPacketData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.connection.packet.AbstractIncomingPacketHandler
    public void doHandle(SMBPacketData<?> sMBPacketData) throws TransportException {
        SMB3EncryptedPacketData sMB3EncryptedPacketData = (SMB3EncryptedPacketData) sMBPacketData;
        j02 j02Var = logger;
        j02Var.q("Decrypting packet {}", sMB3EncryptedPacketData);
        if (!this.encryptor.canDecrypt(sMB3EncryptedPacketData)) {
            this.next.handle(new DeadLetterPacketData(sMBPacketData.getHeader()));
            return;
        }
        Session sessionFind = this.sessionTable.find(Long.valueOf(sMB3EncryptedPacketData.getHeader().getSessionId()));
        if (sessionFind == null) {
            this.next.handle(new DeadLetterPacketData(sMBPacketData.getHeader()));
            return;
        }
        byte[] bArrDecrypt = this.encryptor.decrypt(sMB3EncryptedPacketData, sessionFind.getSessionContext().getDecryptionKey());
        byte[] bArrCopyOf = Arrays.copyOf(bArrDecrypt, 4);
        if (SMB2TransformHeader.isEncrypted(bArrCopyOf)) {
            j02Var.r("Encountered a nested encrypted packet in packet {}, disconnecting the transport", sMBPacketData);
            throw new TransportException("Cannot nest an encrypted packet in encrypted packet " + sMBPacketData);
        }
        if (SMB2CompressionTransformHeader.isCompressed(bArrCopyOf)) {
            handleCompressedPacket(sMBPacketData, bArrDecrypt);
        } else if (SMB2PacketHeader.isPacketHeader(bArrCopyOf)) {
            handleSMB2Packet(bArrDecrypt, sMB3EncryptedPacketData);
        } else {
            j02Var.r("Could not determine the encrypted packet contents of packet {}", sMBPacketData);
            throw new TransportException("Could not determine the encrypted packet data, disconnecting");
        }
    }
}

package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.mssmb2.SMB2TransformHeader;
import com.hierynomus.mssmb2.SMB3EncryptedPacketData;
import com.hierynomus.mssmb2.SMB3EncryptionCipher;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.security.AEADBlockCipher;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.SecurityException;
import com.hierynomus.security.SecurityProvider;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SMBRuntimeException;
import defpackage.e04;
import defpackage.j02;
import defpackage.n02;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PacketEncryptor {
    private static final j02 logger = n02.k(PacketEncryptor.class);
    private SMB3EncryptionCipher cipher;
    private SMB2Dialect dialect;
    private AtomicInteger nonceCounter = new AtomicInteger(0);
    private SecurityProvider securityProvider;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class EncryptedPacketWrapper extends SMB2Packet {
        private final SecretKey encryptionKey;
        private final SMB2Packet packet;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public EncryptedPacketWrapper(SMB2Packet sMB2Packet, SecretKey secretKey) {
            this.packet = sMB2Packet;
            this.encryptionKey = secretKey;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: getHeader()Lcom/hierynomus/smb/SMBHeader; */
        @Override // com.hierynomus.smb.SMBPacket
        public SMB2PacketHeader getHeader() {
            return this.packet.getHeader();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.mssmb2.SMB2Packet
        public int getMaxPayloadSize() {
            return this.packet.getMaxPayloadSize();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.mssmb2.SMB2Packet
        public SMB2Packet getPacket() {
            return this.packet.getPacket();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.mssmb2.SMB2Packet
        public long getSequenceNumber() {
            return this.packet.getSequenceNumber();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.mssmb2.SMB2Packet
        public int getStructureSize() {
            return this.packet.getStructureSize();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.mssmb2.SMB2Packet
        public String toString() {
            return "Encrypted[" + this.packet.toString() + "]";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: write(Lcom/hierynomus/protocol/commons/buffer/Buffer;)V */
        @Override // com.hierynomus.mssmb2.SMB2Packet, com.hierynomus.protocol.Packet
        public void write(SMBBuffer sMBBuffer) {
            SMBBuffer sMBBuffer2 = new SMBBuffer();
            this.packet.write(sMBBuffer2);
            byte[] compactData = sMBBuffer2.getCompactData();
            byte[] newNonce = PacketEncryptor.this.getNewNonce();
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, newNonce);
            SMB2TransformHeader sMB2TransformHeader = new SMB2TransformHeader(newNonce, compactData.length, this.packet.getHeader().getSessionId());
            byte[] bArrCreateAAD = PacketEncryptor.this.createAAD(sMB2TransformHeader);
            try {
                AEADBlockCipher aEADBlockCipher = PacketEncryptor.this.securityProvider.getAEADBlockCipher(PacketEncryptor.this.cipher.getAlgorithmName());
                aEADBlockCipher.init(Cipher.CryptMode.ENCRYPT, this.encryptionKey.getEncoded(), gCMParameterSpec);
                aEADBlockCipher.updateAAD(bArrCreateAAD, 0, bArrCreateAAD.length);
                byte[] bArrDoFinal = aEADBlockCipher.doFinal(compactData, 0, compactData.length);
                if (bArrDoFinal.length != compactData.length + 16) {
                    e04.a("Invalid length for cipherText after encryption.");
                    return;
                }
                byte[] bArr = new byte[16];
                System.arraycopy(bArrDoFinal, compactData.length, bArr, 0, 16);
                sMB2TransformHeader.setSignature(bArr);
                sMB2TransformHeader.writeTo(sMBBuffer);
                sMBBuffer.putRawBytes(bArrDoFinal, 0, compactData.length);
            } catch (SecurityException e) {
                PacketEncryptor.logger.r("Security exception while encrypting packet << {} >>", this.packet.getHeader());
                throw new SMBRuntimeException(e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PacketEncryptor(SecurityProvider securityProvider) {
        this.securityProvider = securityProvider;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean canDecrypt(SMB3EncryptedPacketData sMB3EncryptedPacketData) {
        return this.dialect.isSmb3x() && sMB3EncryptedPacketData.getDataBuffer().available() != 0 && sMB3EncryptedPacketData.getHeader().getFlagsEncryptionAlgorithm() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] createAAD(SMB2TransformHeader sMB2TransformHeader) {
        SMBBuffer sMBBuffer = new SMBBuffer();
        sMB2TransformHeader.writeTo(sMBBuffer);
        sMBBuffer.rpos(20);
        return sMBBuffer.getCompactData();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] decrypt(SMB3EncryptedPacketData sMB3EncryptedPacketData, SecretKey secretKey) {
        byte[] bArrCopyOf = Arrays.copyOf(sMB3EncryptedPacketData.getHeader().getNonce(), this.cipher.getNonceLength());
        try {
            byte[] bArrCreateAAD = createAAD(sMB3EncryptedPacketData.getHeader());
            byte[] cipherText = sMB3EncryptedPacketData.getCipherText();
            byte[] signature = sMB3EncryptedPacketData.getHeader().getSignature();
            AEADBlockCipher aEADBlockCipher = this.securityProvider.getAEADBlockCipher(this.cipher.getAlgorithmName());
            aEADBlockCipher.init(Cipher.CryptMode.DECRYPT, secretKey.getEncoded(), new GCMParameterSpec(128, bArrCopyOf));
            aEADBlockCipher.updateAAD(bArrCreateAAD, 0, bArrCreateAAD.length);
            byte[] bArrUpdate = aEADBlockCipher.update(cipherText, 0, cipherText.length);
            byte[] bArrDoFinal = aEADBlockCipher.doFinal(signature, 0, signature.length);
            if (bArrUpdate == null || bArrUpdate.length == 0) {
                return bArrDoFinal;
            }
            byte[] bArr = new byte[bArrUpdate.length + bArrDoFinal.length];
            System.arraycopy(bArrUpdate, 0, bArr, 0, bArrUpdate.length);
            System.arraycopy(bArrDoFinal, 0, bArr, bArrUpdate.length, bArrDoFinal.length);
            return bArr;
        } catch (Buffer.BufferException e) {
            logger.r("Could not read cipherText from packet << {} >>", sMB3EncryptedPacketData);
            throw new SMBRuntimeException("Could not read cipherText from packet", e);
        } catch (SecurityException e2) {
            logger.r("Security exception while decrypting packet << {} >>", sMB3EncryptedPacketData);
            throw new SMBRuntimeException(e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2Packet encrypt(SMB2Packet sMB2Packet, SecretKey secretKey) {
        if (secretKey != null) {
            return new EncryptedPacketWrapper(sMB2Packet, secretKey);
        }
        logger.q("Not wrapping {} as encrypted, as no key is set.", sMB2Packet.getHeader().getMessage());
        return sMB2Packet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getNewNonce() {
        long jNanoTime = System.nanoTime();
        SMBBuffer sMBBuffer = new SMBBuffer();
        sMBBuffer.putUInt64(jNanoTime);
        sMBBuffer.putReserved(this.cipher.getNonceLength() - 8);
        return sMBBuffer.getCompactData();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void init(ConnectionContext connectionContext) {
        this.dialect = connectionContext.getNegotiatedProtocol().getDialect();
        if (connectionContext.getNegotiatedProtocol().getDialect().equals(SMB2Dialect.SMB_3_1_1)) {
            this.cipher = connectionContext.getCipherId();
        } else {
            this.cipher = SMB3EncryptionCipher.AES_128_CCM;
        }
        logger.c("Initialized PacketEncryptor with Cipher << {} >>", this.cipher);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCipher(SMB3EncryptionCipher sMB3EncryptionCipher) {
        this.cipher = sMB3EncryptionCipher;
    }
}

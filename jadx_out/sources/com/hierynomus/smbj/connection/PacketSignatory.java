package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb2.SMB2MessageFlag;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketData;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.security.Mac;
import com.hierynomus.security.SecurityException;
import com.hierynomus.security.SecurityProvider;
import com.hierynomus.smb.SMBBuffer;
import defpackage.j02;
import defpackage.n02;
import java.util.Arrays;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PacketSignatory implements Signatory {
    private static final j02 logger = n02.k(PacketSignatory.class);
    private SecurityProvider securityProvider;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class SignedPacketWrapper extends SMB2Packet {
        private SecretKey secretKey;
        private final SMB2Packet wrappedPacket;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class SigningBuffer extends SMBBuffer {
            private final Mac mac;
            private SMBBuffer wrappedBuffer;

            public SigningBuffer(SMBBuffer sMBBuffer) {
                this.wrappedBuffer = sMBBuffer;
                this.mac = PacketSignatory.getMac(SignedPacketWrapper.this.secretKey, PacketSignatory.this.securityProvider);
            }

            @Override // com.hierynomus.protocol.commons.buffer.Buffer
            public Buffer<SMBBuffer> putBuffer(Buffer<? extends Buffer<?>> buffer) {
                this.mac.update(buffer.array(), buffer.rpos(), buffer.available());
                this.wrappedBuffer.putBuffer(buffer);
                return this;
            }

            @Override // com.hierynomus.protocol.commons.buffer.Buffer
            public Buffer<SMBBuffer> putByte(byte b) {
                this.mac.update(b);
                this.wrappedBuffer.putByte(b);
                return this;
            }

            @Override // com.hierynomus.protocol.commons.buffer.Buffer
            public Buffer<SMBBuffer> putRawBytes(byte[] bArr, int i, int i2) {
                this.mac.update(bArr, i, i2);
                this.wrappedBuffer.putRawBytes(bArr, i, i2);
                return this;
            }
        }

        public SignedPacketWrapper(SMB2Packet sMB2Packet, SecretKey secretKey) {
            this.wrappedPacket = sMB2Packet;
            this.secretKey = secretKey;
        }

        @Override // com.hierynomus.smb.SMBPacket
        public SMB2PacketHeader getHeader() {
            return this.wrappedPacket.getHeader();
        }

        @Override // com.hierynomus.mssmb2.SMB2Packet
        public int getMaxPayloadSize() {
            return this.wrappedPacket.getMaxPayloadSize();
        }

        @Override // com.hierynomus.mssmb2.SMB2Packet
        public SMB2Packet getPacket() {
            return this.wrappedPacket.getPacket();
        }

        @Override // com.hierynomus.mssmb2.SMB2Packet
        public long getSequenceNumber() {
            return this.wrappedPacket.getSequenceNumber();
        }

        @Override // com.hierynomus.mssmb2.SMB2Packet
        public int getStructureSize() {
            return this.wrappedPacket.getStructureSize();
        }

        @Override // com.hierynomus.mssmb2.SMB2Packet
        public String toString() {
            return "Signed(" + this.wrappedPacket.toString() + ")";
        }

        @Override // com.hierynomus.mssmb2.SMB2Packet, com.hierynomus.protocol.Packet
        public void write(SMBBuffer sMBBuffer) {
            try {
                this.wrappedPacket.getHeader().setFlag(SMB2MessageFlag.SMB2_FLAGS_SIGNED);
                int iWpos = sMBBuffer.wpos();
                SigningBuffer signingBuffer = new SigningBuffer(sMBBuffer);
                this.wrappedPacket.write((SMBBuffer) signingBuffer);
                System.arraycopy(signingBuffer.mac.doFinal(), 0, sMBBuffer.array(), iWpos + 48, 16);
            } catch (SecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public PacketSignatory(SecurityProvider securityProvider) {
        this.securityProvider = securityProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Mac getMac(SecretKey secretKey, SecurityProvider securityProvider) {
        Mac mac = securityProvider.getMac(secretKey.getAlgorithm());
        mac.init(secretKey.getEncoded());
        return mac;
    }

    @Override // com.hierynomus.smbj.connection.Signatory
    public SMB2Packet sign(SMB2Packet sMB2Packet, SecretKey secretKey) {
        if (secretKey != null) {
            return new SignedPacketWrapper(sMB2Packet, secretKey);
        }
        logger.q("Not wrapping {} as signed, as no key is set.", sMB2Packet.getHeader().getMessage());
        return sMB2Packet;
    }

    @Override // com.hierynomus.smbj.connection.Signatory
    public boolean verify(SMB2PacketData sMB2PacketData, SecretKey secretKey) {
        try {
            SMBBuffer dataBuffer = sMB2PacketData.getDataBuffer();
            Mac mac = getMac(secretKey, this.securityProvider);
            mac.update(dataBuffer.array(), sMB2PacketData.getHeader().getHeaderStartPosition(), 48);
            mac.update(SMB2PacketHeader.EMPTY_SIGNATURE);
            mac.update(dataBuffer.array(), 64, sMB2PacketData.getHeader().getMessageEndPosition() - 64);
            byte[] bArrDoFinal = mac.doFinal();
            byte[] signature = sMB2PacketData.getHeader().getSignature();
            for (int i = 0; i < 16; i++) {
                if (bArrDoFinal[i] != signature[i]) {
                    j02 j02Var = logger;
                    j02Var.p("Signatures for packet {} do not match (received: {}, calculated: {})", sMB2PacketData, Arrays.toString(signature), Arrays.toString(bArrDoFinal));
                    j02Var.o("Packet {} has header: {}", sMB2PacketData, sMB2PacketData.getHeader());
                    return false;
                }
            }
            return true;
        } catch (SecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}

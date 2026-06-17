package com.hierynomus.mssmb2;

import com.hierynomus.protocol.transport.PacketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB3EncryptedPacketFactory implements PacketFactory<SMB3EncryptedPacketData> {
    @Override // com.hierynomus.protocol.transport.PacketFactory
    public boolean canHandle(byte[] bArr) {
        return bArr.length >= 4 && bArr[0] == -3 && bArr[1] == 83 && bArr[2] == 77 && bArr[3] == 66;
    }

    @Override // com.hierynomus.protocol.transport.PacketFactory
    public SMB3EncryptedPacketData read(byte[] bArr) {
        return new SMB3EncryptedPacketData(bArr);
    }
}

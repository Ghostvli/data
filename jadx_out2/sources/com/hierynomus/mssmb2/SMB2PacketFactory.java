package com.hierynomus.mssmb2;

import com.hierynomus.protocol.transport.PacketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2PacketFactory implements PacketFactory<SMB2PacketData> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.PacketFactory
    public boolean canHandle(byte[] bArr) {
        return bArr.length >= 4 && bArr[0] == -2 && bArr[1] == 83 && bArr[2] == 77 && bArr[3] == 66;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: read([B)Lcom/hierynomus/protocol/PacketData; */
    @Override // com.hierynomus.protocol.transport.PacketFactory
    public SMB2PacketData read(byte[] bArr) {
        return new SMB2PacketData(bArr);
    }
}

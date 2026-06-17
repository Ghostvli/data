package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketData;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NoSignatory implements Signatory {
    @Override // com.hierynomus.smbj.connection.Signatory
    public SMB2Packet sign(SMB2Packet sMB2Packet, SecretKey secretKey) {
        return sMB2Packet;
    }

    @Override // com.hierynomus.smbj.connection.Signatory
    public boolean verify(SMB2PacketData sMB2PacketData, SecretKey secretKey) {
        return true;
    }
}

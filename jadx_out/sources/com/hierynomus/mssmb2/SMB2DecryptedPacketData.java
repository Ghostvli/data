package com.hierynomus.mssmb2;

import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2DecryptedPacketData extends SMB2PacketData {
    public SMB2DecryptedPacketData(byte[] bArr) {
        super(bArr);
    }

    @Override // com.hierynomus.mssmb2.SMB2PacketData
    public boolean isDecrypted() {
        return true;
    }

    @Override // com.hierynomus.mssmb2.SMB2PacketData
    public SMB2PacketData next() {
        if (isCompounded()) {
            return new SMB2DecryptedPacketData(this.dataBuffer);
        }
        return null;
    }

    public SMB2DecryptedPacketData(SMBBuffer sMBBuffer) {
        super(sMBBuffer);
    }
}

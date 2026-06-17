package com.hierynomus.mssmb2;

import com.hierynomus.smb.SMBPacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB3EncryptedPacketData extends SMBPacketData<SMB2TransformHeader> {
    public SMB3EncryptedPacketData(byte[] bArr) {
        super(new SMB2TransformHeader(), bArr);
    }

    public byte[] getCipherText() {
        return getDataBuffer().readRawBytes(getHeader().getOriginalMessageSize());
    }

    public String toString() {
        return "Encrypted for session id << " + getHeader().getSessionId() + " >>";
    }
}

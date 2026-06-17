package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.ByteArrayUtils;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2FileId {
    private byte[] persistentHandle;
    private byte[] volatileHandle;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2FileId() {
        this.persistentHandle = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1};
        this.volatileHandle = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SMB2FileId read(SMBBuffer sMBBuffer) {
        return new SMB2FileId(sMBBuffer.readRawBytes(8), sMBBuffer.readRawBytes(8));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "SMB2FileId{persistentHandle=" + ByteArrayUtils.printHex(this.persistentHandle) + '}';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void write(SMBBuffer sMBBuffer) {
        sMBBuffer.putRawBytes(this.persistentHandle);
        sMBBuffer.putRawBytes(this.volatileHandle);
    }

    public SMB2FileId(byte[] bArr, byte[] bArr2) {
        this.persistentHandle = bArr;
        this.volatileHandle = bArr2;
    }
}

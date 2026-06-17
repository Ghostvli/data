package com.hierynomus.msdtyp.ace;

import com.hierynomus.msdtyp.SID;
import com.hierynomus.smb.SMBBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class AceType3 extends ACE {
    private long accessMask;
    private byte[] applicationData;
    private SID sid;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AceType3(AceHeader aceHeader, long j, SID sid, byte[] bArr) {
        super(aceHeader);
        this.accessMask = j;
        this.sid = sid;
        this.applicationData = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AceType3 read(AceHeader aceHeader, SMBBuffer sMBBuffer, int i) {
        return new AceType3(aceHeader, sMBBuffer.readUInt32(), SID.read(sMBBuffer), sMBBuffer.readRawBytes(aceHeader.getAceSize() - (sMBBuffer.rpos() - i)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.ACE
    public long getAccessMask() {
        return this.accessMask;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getApplicationData() {
        return this.applicationData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.ACE
    public SID getSid() {
        return this.sid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return String.format("AceType3{type=%s, flags=%s, access=0x%x, sid=%s, data=%s}", this.aceHeader.getAceType(), this.aceHeader.getAceFlags(), Long.valueOf(this.accessMask), this.sid, Arrays.toString(this.applicationData));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.ACE
    public void writeBody(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt32(this.accessMask);
        this.sid.write(sMBBuffer);
        sMBBuffer.putRawBytes(this.applicationData);
    }
}

package com.hierynomus.msdtyp.ace;

import com.hierynomus.msdtyp.SID;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class AceType1 extends ACE {
    private long accessMask;
    private SID sid;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AceType1(AceHeader aceHeader, long j, SID sid) {
        super(aceHeader);
        this.accessMask = j;
        this.sid = sid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AceType1 read(AceHeader aceHeader, SMBBuffer sMBBuffer) {
        return new AceType1(aceHeader, sMBBuffer.readUInt32(), SID.read(sMBBuffer));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.ACE
    public long getAccessMask() {
        return this.accessMask;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.ACE
    public SID getSid() {
        return this.sid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return String.format("AceType1{type=%s, flags=%s, access=0x%x, sid=%s}", this.aceHeader.getAceType(), this.aceHeader.getAceFlags(), Long.valueOf(this.accessMask), this.sid);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.ACE
    public void writeBody(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt32(this.accessMask);
        this.sid.write(sMBBuffer);
    }
}

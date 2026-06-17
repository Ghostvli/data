package com.hierynomus.msdtyp.ace;

import com.hierynomus.msdtyp.SID;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class AceType4 extends AceType2 {
    private byte[] applicationData;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AceType4(AceHeader aceHeader, long j, UUID uuid, UUID uuid2, SID sid, byte[] bArr) {
        super(aceHeader, j, uuid, uuid2, sid);
        this.applicationData = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AceType4 read(AceHeader aceHeader, SMBBuffer sMBBuffer, int i) throws Buffer.BufferException {
        AceType4 aceType4 = new AceType4(aceHeader);
        aceType4.readBody(sMBBuffer, i);
        return aceType4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getApplicationData() {
        return this.applicationData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.AceType2
    public void readBody(SMBBuffer sMBBuffer, int i) throws Buffer.BufferException {
        super.readBody(sMBBuffer, i);
        this.applicationData = sMBBuffer.readRawBytes(this.aceHeader.getAceSize() - (sMBBuffer.rpos() - i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.AceType2
    public String toString() {
        return String.format("AceType4{type=%s, flags=%s, access=0x%x, objectType=%s, inheritedObjectType=%s, sid=%s, data=%s}", this.aceHeader.getAceType(), this.aceHeader.getAceFlags(), Long.valueOf(this.accessMask), this.objectType, this.inheritedObjectType, this.sid, Arrays.toString(this.applicationData));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdtyp.ace.AceType2, com.hierynomus.msdtyp.ace.ACE
    public void writeBody(SMBBuffer sMBBuffer) {
        super.writeBody(sMBBuffer);
        sMBBuffer.putRawBytes(this.applicationData);
    }

    private AceType4(AceHeader aceHeader) {
        super(aceHeader);
    }
}

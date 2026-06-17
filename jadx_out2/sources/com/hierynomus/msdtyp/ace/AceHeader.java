package com.hierynomus.msdtyp.ace;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AceHeader {
    private Set<AceFlags> aceFlags;
    private int aceSize;
    private AceType aceType;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AceHeader(AceType aceType, Set<AceFlags> set) {
        this.aceType = aceType;
        this.aceFlags = set;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AceHeader readFrom(SMBBuffer sMBBuffer) {
        AceType aceType = (AceType) EnumWithValue.EnumUtils.valueOf(sMBBuffer.readByte(), AceType.class, null);
        EnumSet enumSet = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readByte(), AceFlags.class);
        int uInt16 = sMBBuffer.readUInt16();
        AceHeader aceHeader = new AceHeader(aceType, enumSet);
        aceHeader.aceSize = uInt16;
        return aceHeader;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<AceFlags> getAceFlags() {
        return this.aceFlags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getAceSize() {
        return this.aceSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AceType getAceType() {
        return this.aceType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "AceHeader{aceType=" + this.aceType + ", aceFlags=" + this.aceFlags + ", aceSize=" + this.aceSize + '}';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeTo(SMBBuffer sMBBuffer, int i) {
        sMBBuffer.putByte((byte) this.aceType.getValue());
        sMBBuffer.putByte((byte) EnumWithValue.EnumUtils.toLong(this.aceFlags));
        sMBBuffer.putUInt16(i);
    }

    public AceHeader() {
    }

    public void writeTo(SMBBuffer sMBBuffer) {
        writeTo(sMBBuffer, this.aceSize);
    }
}

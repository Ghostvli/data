package com.hierynomus.msdtyp;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SecurityDescriptor {
    private Set<Control> control;
    private ACL dacl;
    private SID groupSid;
    private SID ownerSid;
    private ACL sacl;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Control implements EnumWithValue<Control> {
        NONE(0),
        OD(1),
        GD(2),
        DP(4),
        DD(8),
        SP(16),
        SD(32),
        SS(64),
        DT(128),
        DC(256),
        SC(512),
        DI(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE),
        SI(2048),
        PD(4096),
        PS(8192),
        RM(Http2Stream.EMIT_BUFFER_SIZE),
        SR(32768);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        Control(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SecurityDescriptor(Set<Control> set, SID sid, SID sid2, ACL acl, ACL acl2) {
        this.control = set;
        this.ownerSid = sid;
        this.groupSid = sid2;
        this.sacl = acl;
        this.dacl = acl2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SecurityDescriptor read(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        SID sid;
        SID sid2;
        ACL acl;
        int iRpos = sMBBuffer.rpos();
        sMBBuffer.readByte();
        sMBBuffer.readByte();
        EnumSet enumSet = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt16(), Control.class);
        int uInt32AsInt = sMBBuffer.readUInt32AsInt();
        int uInt32AsInt2 = sMBBuffer.readUInt32AsInt();
        int uInt32AsInt3 = sMBBuffer.readUInt32AsInt();
        int uInt32AsInt4 = sMBBuffer.readUInt32AsInt();
        ACL acl2 = null;
        if (uInt32AsInt > 0) {
            sMBBuffer.rpos(uInt32AsInt + iRpos);
            sid = SID.read(sMBBuffer);
        } else {
            sid = null;
        }
        if (uInt32AsInt2 > 0) {
            sMBBuffer.rpos(uInt32AsInt2 + iRpos);
            sid2 = SID.read(sMBBuffer);
        } else {
            sid2 = null;
        }
        if (uInt32AsInt3 > 0) {
            sMBBuffer.rpos(uInt32AsInt3 + iRpos);
            acl = ACL.read(sMBBuffer);
        } else {
            acl = null;
        }
        if (uInt32AsInt4 > 0) {
            sMBBuffer.rpos(iRpos + uInt32AsInt4);
            acl2 = ACL.read(sMBBuffer);
        }
        return new SecurityDescriptor(enumSet, sid, sid2, acl, acl2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<Control> getControl() {
        return this.control;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ACL getDacl() {
        return this.dacl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SID getGroupSid() {
        return this.groupSid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SID getOwnerSid() {
        return this.ownerSid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ACL getSacl() {
        return this.sacl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "SecurityDescriptor{control=" + this.control + ", ownerSid=" + this.ownerSid + ", groupSid=" + this.groupSid + ", sacl=" + this.sacl + ", dacl=" + this.dacl + '}';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void write(SMBBuffer sMBBuffer) {
        int iWpos;
        int iWpos2;
        int iWpos3;
        int iWpos4 = sMBBuffer.wpos();
        sMBBuffer.putByte((byte) 1);
        int iWpos5 = 0;
        sMBBuffer.putByte((byte) 0);
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) this.control);
        enumSetCopyOf.add(Control.SR);
        if (this.sacl != null) {
            enumSetCopyOf.add(Control.SP);
        }
        if (this.dacl != null) {
            enumSetCopyOf.add(Control.DP);
        }
        sMBBuffer.putUInt16((int) EnumWithValue.EnumUtils.toLong(enumSetCopyOf));
        int iWpos6 = sMBBuffer.wpos();
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        if (this.ownerSid != null) {
            iWpos = sMBBuffer.wpos() - iWpos4;
            this.ownerSid.write(sMBBuffer);
        } else {
            iWpos = 0;
        }
        if (this.groupSid != null) {
            iWpos2 = sMBBuffer.wpos() - iWpos4;
            this.groupSid.write(sMBBuffer);
        } else {
            iWpos2 = 0;
        }
        if (this.sacl != null) {
            iWpos3 = sMBBuffer.wpos() - iWpos4;
            this.sacl.write(sMBBuffer);
        } else {
            iWpos3 = 0;
        }
        if (this.dacl != null) {
            iWpos5 = sMBBuffer.wpos() - iWpos4;
            this.dacl.write(sMBBuffer);
        }
        int iWpos7 = sMBBuffer.wpos();
        sMBBuffer.wpos(iWpos6);
        sMBBuffer.putUInt32(iWpos);
        sMBBuffer.putUInt32(iWpos2);
        sMBBuffer.putUInt32(iWpos3);
        sMBBuffer.putUInt32(iWpos5);
        sMBBuffer.wpos(iWpos7);
    }

    public SecurityDescriptor() {
    }
}

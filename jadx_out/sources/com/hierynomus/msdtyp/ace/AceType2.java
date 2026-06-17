package com.hierynomus.msdtyp.ace;

import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.msdtyp.SID;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.EnumSet;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class AceType2 extends ACE {
    long accessMask;
    UUID inheritedObjectType;
    UUID objectType;
    SID sid;

    public AceType2(AceHeader aceHeader, long j, UUID uuid, UUID uuid2, SID sid) {
        super(aceHeader);
        this.accessMask = j;
        this.sid = sid;
        this.objectType = uuid;
        this.inheritedObjectType = uuid2;
    }

    public static AceType2 read(AceHeader aceHeader, SMBBuffer sMBBuffer, int i) throws Buffer.BufferException {
        AceType2 aceType2 = new AceType2(aceHeader);
        aceType2.readBody(sMBBuffer, i);
        return aceType2;
    }

    @Override // com.hierynomus.msdtyp.ace.ACE
    public long getAccessMask() {
        return this.accessMask;
    }

    public UUID getInheritedObjectType() {
        return this.inheritedObjectType;
    }

    public UUID getObjectType() {
        return this.objectType;
    }

    @Override // com.hierynomus.msdtyp.ace.ACE
    public SID getSid() {
        return this.sid;
    }

    public void readBody(SMBBuffer sMBBuffer, int i) throws Buffer.BufferException {
        this.accessMask = sMBBuffer.readUInt32();
        EnumSet enumSet = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32(), AceObjectFlags.class);
        this.objectType = null;
        if (enumSet.contains(AceObjectFlags.ACE_OBJECT_TYPE_PRESENT)) {
            this.objectType = MsDataTypes.readGuid(sMBBuffer);
        } else {
            sMBBuffer.skip(16);
        }
        this.inheritedObjectType = null;
        if (enumSet.contains(AceObjectFlags.ACE_INHERITED_OBJECT_TYPE_PRESENT)) {
            this.inheritedObjectType = MsDataTypes.readGuid(sMBBuffer);
        } else {
            sMBBuffer.skip(16);
        }
        this.sid = SID.read(sMBBuffer);
    }

    public String toString() {
        return String.format("AceType2{type=%s, flags=%s, access=0x%x, objectType=%s, inheritedObjectType=%s, sid=%s}", this.aceHeader.getAceType(), this.aceHeader.getAceFlags(), Long.valueOf(this.accessMask), this.objectType, this.inheritedObjectType, this.sid);
    }

    @Override // com.hierynomus.msdtyp.ace.ACE
    public void writeBody(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt32(this.accessMask);
        EnumSet enumSetNoneOf = EnumSet.noneOf(AceObjectFlags.class);
        if (this.objectType != null) {
            enumSetNoneOf.add(AceObjectFlags.ACE_OBJECT_TYPE_PRESENT);
        }
        if (this.inheritedObjectType != null) {
            enumSetNoneOf.add(AceObjectFlags.ACE_INHERITED_OBJECT_TYPE_PRESENT);
        }
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(enumSetNoneOf));
        UUID uuid = this.objectType;
        if (uuid != null) {
            MsDataTypes.putGuid(uuid, sMBBuffer);
        } else {
            sMBBuffer.putReserved(16);
        }
        UUID uuid2 = this.inheritedObjectType;
        if (uuid2 != null) {
            MsDataTypes.putGuid(uuid2, sMBBuffer);
        } else {
            sMBBuffer.putReserved(16);
        }
        this.sid.write(sMBBuffer);
    }

    public AceType2(AceHeader aceHeader) {
        super(aceHeader);
    }
}

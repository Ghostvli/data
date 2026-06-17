package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2ShareCapabilities;
import com.hierynomus.mssmb2.SMB2ShareFlags;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2TreeConnectResponse extends SMB2Packet {
    private Set<SMB2ShareCapabilities> capabilities;
    private Set<AccessMask> maximalAccess;
    private Set<SMB2ShareFlags> shareFlags;
    private byte shareType;

    public Set<SMB2ShareCapabilities> getCapabilities() {
        return this.capabilities;
    }

    public Set<AccessMask> getMaximalAccess() {
        return this.maximalAccess;
    }

    public Set<SMB2ShareFlags> getShareFlags() {
        return this.shareFlags;
    }

    public boolean isDiskShare() {
        return this.shareType == 1;
    }

    public boolean isNamedPipe() {
        return this.shareType == 2;
    }

    public boolean isPrinterShare() {
        return this.shareType == 3;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        this.shareType = sMBBuffer.readByte();
        sMBBuffer.readByte();
        this.shareFlags = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32(), SMB2ShareFlags.class);
        this.capabilities = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32(), SMB2ShareCapabilities.class);
        this.maximalAccess = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32(), AccessMask.class);
    }

    public void setCapabilities(Set<SMB2ShareCapabilities> set) {
        this.capabilities = set;
    }

    public void setShareFlags(Set<SMB2ShareFlags> set) {
        this.shareFlags = set;
    }

    public void setShareType(byte b) {
        this.shareType = b;
    }
}

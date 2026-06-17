package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.FileTime;
import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2GlobalCapability;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2NegotiateResponse extends SMB2Packet {
    private Set<SMB2GlobalCapability> capabilities = EnumSet.noneOf(SMB2GlobalCapability.class);
    private SMB2Dialect dialect;
    private byte[] gssToken;
    private int maxReadSize;
    private int maxTransactSize;
    private int maxWriteSize;
    private List<SMB2NegotiateContext> negotiateContextList;
    private int securityMode;
    private UUID serverGuid;
    private FileTime serverStartTime;
    private FileTime systemTime;

    private int readNegotiateContextCount(Buffer<?> buffer) throws Buffer.BufferException {
        if (this.dialect == SMB2Dialect.SMB_3_1_1) {
            return buffer.readUInt16();
        }
        buffer.skip(2);
        return 0;
    }

    private List<SMB2NegotiateContext> readNegotiateContextList(SMBBuffer sMBBuffer, int i, int i2) {
        if (this.dialect != SMB2Dialect.SMB_3_1_1) {
            return Collections.EMPTY_LIST;
        }
        sMBBuffer.rpos(i);
        try {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(SMB2NegotiateContext.factory(sMBBuffer));
            }
            return arrayList;
        } catch (Buffer.BufferException e) {
            throw new IllegalArgumentException("unknown error when parse negotiateContext", e);
        }
    }

    private int readNegotiateContextOffset(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        if (this.dialect == SMB2Dialect.SMB_3_1_1) {
            return sMBBuffer.readUInt16();
        }
        sMBBuffer.skip(2);
        return 0;
    }

    private byte[] readSecurityBuffer(SMBBuffer sMBBuffer, int i, int i2) {
        if (i2 <= 0) {
            return new byte[0];
        }
        sMBBuffer.rpos(i);
        return sMBBuffer.readRawBytes(i2);
    }

    public Set<SMB2GlobalCapability> getCapabilities() {
        return this.capabilities;
    }

    public SMB2Dialect getDialect() {
        return this.dialect;
    }

    public byte[] getGssToken() {
        return this.gssToken;
    }

    public int getMaxReadSize() {
        return this.maxReadSize;
    }

    public int getMaxTransactSize() {
        return this.maxTransactSize;
    }

    public int getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public List<SMB2NegotiateContext> getNegotiateContextList() {
        return this.negotiateContextList;
    }

    public int getSecurityMode() {
        return this.securityMode;
    }

    public UUID getServerGuid() {
        return this.serverGuid;
    }

    public FileTime getServerStartTime() {
        return this.serverStartTime;
    }

    public FileTime getSystemTime() {
        return this.systemTime;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        this.securityMode = sMBBuffer.readUInt16();
        this.dialect = SMB2Dialect.lookup(sMBBuffer.readUInt16());
        int negotiateContextCount = readNegotiateContextCount(sMBBuffer);
        this.serverGuid = MsDataTypes.readGuid(sMBBuffer);
        this.capabilities = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32(), SMB2GlobalCapability.class);
        this.maxTransactSize = sMBBuffer.readUInt32AsInt();
        this.maxReadSize = sMBBuffer.readUInt32AsInt();
        this.maxWriteSize = sMBBuffer.readUInt32AsInt();
        this.systemTime = MsDataTypes.readFileTime(sMBBuffer);
        this.serverStartTime = MsDataTypes.readFileTime(sMBBuffer);
        int uInt16 = sMBBuffer.readUInt16();
        int uInt162 = sMBBuffer.readUInt16();
        int negotiateContextOffset = readNegotiateContextOffset(sMBBuffer);
        this.gssToken = readSecurityBuffer(sMBBuffer, uInt16, uInt162);
        this.negotiateContextList = readNegotiateContextList(sMBBuffer, negotiateContextOffset, negotiateContextCount);
    }

    public void setDialect(SMB2Dialect sMB2Dialect) {
        this.dialect = sMB2Dialect;
    }

    public void setServerGuid(UUID uuid) {
        this.serverGuid = uuid;
    }

    public void setSystemTime(FileTime fileTime) {
        this.systemTime = fileTime;
    }
}

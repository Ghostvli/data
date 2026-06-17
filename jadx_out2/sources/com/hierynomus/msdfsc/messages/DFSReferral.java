package com.hierynomus.msdfsc.messages;

import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import defpackage.ug4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DFSReferral {
    String dfsAlternatePath;
    String dfsPath;
    List<String> expandedNames;
    protected String path;
    long referralEntryFlags;
    private ServerType serverType;
    String specialName;
    int ttl;
    private int versionNumber;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ReferralEntryFlags implements EnumWithValue<ReferralEntryFlags> {
        NameListReferral(2),
        TargetSetBoundary(4);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        ReferralEntryFlags(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ServerType implements EnumWithValue<ServerType> {
        LINK(0),
        ROOT(1);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        ServerType(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DFSReferral(int i, ServerType serverType, int i2) {
        this.versionNumber = i;
        this.serverType = serverType;
        this.referralEntryFlags = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DFSReferral factory(SMBBuffer sMBBuffer) {
        int uInt16 = sMBBuffer.readUInt16();
        sMBBuffer.rpos(sMBBuffer.rpos() - 2);
        if (uInt16 == 1) {
            return new DFSReferralV1().read(sMBBuffer);
        }
        if (uInt16 == 2) {
            return new DFSReferralV2().read(sMBBuffer);
        }
        if (uInt16 == 3 || uInt16 == 4) {
            return new DFSReferralV34().read(sMBBuffer);
        }
        ug4.a("Incorrect version number ", uInt16, " while parsing DFS Referrals");
        return null;
    }

    public abstract int determineSize();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDfsAlternatePath() {
        return this.dfsAlternatePath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDfsPath() {
        return this.dfsPath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<String> getExpandedNames() {
        return this.expandedNames;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPath() {
        return this.path;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getReferralEntryFlags() {
        return this.referralEntryFlags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServerType getServerType() {
        return this.serverType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSpecialName() {
        return this.specialName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTtl() {
        return this.ttl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getVersionNumber() {
        return this.versionNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final DFSReferral read(SMBBuffer sMBBuffer) {
        int iRpos = sMBBuffer.rpos();
        this.versionNumber = sMBBuffer.readUInt16();
        int uInt16 = sMBBuffer.readUInt16();
        this.serverType = (ServerType) EnumWithValue.EnumUtils.valueOf(sMBBuffer.readUInt16(), ServerType.class, null);
        this.referralEntryFlags = sMBBuffer.readUInt16();
        readReferral(sMBBuffer, iRpos);
        sMBBuffer.rpos(iRpos + uInt16);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String readOffsettedString(SMBBuffer sMBBuffer, int i, int i2) {
        int iRpos = sMBBuffer.rpos();
        sMBBuffer.rpos(i + i2);
        String nullTerminatedString = sMBBuffer.readNullTerminatedString(Charsets.UTF_16);
        sMBBuffer.rpos(iRpos);
        return nullTerminatedString;
    }

    public abstract void readReferral(SMBBuffer sMBBuffer, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDfsPath(String str) {
        this.dfsPath = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "DFSReferral[path=" + this.path + ",dfsPath=" + this.dfsPath + ",dfsAlternatePath=" + this.dfsAlternatePath + ",specialName=" + this.specialName + ",ttl=" + this.ttl + "]";
    }

    public abstract void writeOffsettedData(SMBBuffer sMBBuffer);

    public abstract int writeReferral(SMBBuffer sMBBuffer, int i, int i2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int writeTo(SMBBuffer sMBBuffer, int i) {
        int iWpos = sMBBuffer.wpos();
        sMBBuffer.putUInt16(this.versionNumber);
        sMBBuffer.putUInt16(determineSize());
        sMBBuffer.putUInt16((int) this.serverType.value);
        sMBBuffer.putUInt16((int) this.referralEntryFlags);
        return writeReferral(sMBBuffer, iWpos, i);
    }

    public DFSReferral() {
    }
}

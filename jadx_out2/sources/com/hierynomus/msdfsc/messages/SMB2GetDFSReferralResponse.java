package com.hierynomus.msdfsc.messages;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2GetDFSReferralResponse {
    private String originalPath;
    private int pathConsumed;
    private List<DFSReferral> referralEntries;
    private EnumSet<ReferralHeaderFlags> referralHeaderFlags;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ReferralHeaderFlags implements EnumWithValue<ReferralHeaderFlags> {
        ReferralServers(1),
        StorageServers(2),
        TargetFailback(4);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        ReferralHeaderFlags(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2GetDFSReferralResponse(String str, int i, EnumSet<ReferralHeaderFlags> enumSet, List<DFSReferral> list) {
        new ArrayList();
        this.originalPath = str;
        this.pathConsumed = i;
        this.referralHeaderFlags = enumSet;
        this.referralEntries = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPathConsumed() {
        return this.pathConsumed;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<DFSReferral> getReferralEntries() {
        return this.referralEntries;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<ReferralHeaderFlags> getReferralHeaderFlags() {
        return this.referralHeaderFlags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getVersionNumber() {
        if (this.referralEntries.isEmpty()) {
            return 0;
        }
        return this.referralEntries.get(0).getVersionNumber();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void read(SMBBuffer sMBBuffer) {
        this.pathConsumed = sMBBuffer.readUInt16();
        int uInt16 = sMBBuffer.readUInt16();
        this.referralHeaderFlags = EnumWithValue.EnumUtils.toEnumSet(sMBBuffer.readUInt32AsInt(), ReferralHeaderFlags.class);
        for (int i = 0; i < uInt16; i++) {
            DFSReferral dFSReferralFactory = DFSReferral.factory(sMBBuffer);
            if (dFSReferralFactory.getDfsPath() == null) {
                dFSReferralFactory.setDfsPath(this.originalPath);
            }
            this.referralEntries.add(dFSReferralFactory);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.pathConsumed);
        sMBBuffer.putUInt16(this.referralEntries.size());
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.referralHeaderFlags));
        int iWpos = sMBBuffer.wpos();
        Iterator<DFSReferral> it = this.referralEntries.iterator();
        while (it.hasNext()) {
            iWpos += it.next().determineSize();
        }
        Iterator<DFSReferral> it2 = this.referralEntries.iterator();
        int iWriteTo = 0;
        while (it2.hasNext()) {
            iWriteTo = it2.next().writeTo(sMBBuffer, iWriteTo + iWpos);
        }
        Iterator<DFSReferral> it3 = this.referralEntries.iterator();
        while (it3.hasNext()) {
            it3.next().writeOffsettedData(sMBBuffer);
        }
    }

    public SMB2GetDFSReferralResponse(String str) {
        this.referralEntries = new ArrayList();
        this.originalPath = str;
    }
}

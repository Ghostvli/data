package com.hierynomus.msdfsc.messages;

import com.hierynomus.msdfsc.messages.DFSReferral;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DFSReferralV1 extends DFSReferral {
    public DFSReferralV1(int i, DFSReferral.ServerType serverType, String str) {
        super(i, serverType, 0);
        this.path = str;
    }

    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public int determineSize() {
        return ((this.path.length() + 1) * 2) + 8;
    }

    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public void readReferral(SMBBuffer sMBBuffer, int i) {
        this.referralEntryFlags = 0L;
        this.path = sMBBuffer.readNullTerminatedString(Charsets.UTF_16);
    }

    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public void writeOffsettedData(SMBBuffer sMBBuffer) {
    }

    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public int writeReferral(SMBBuffer sMBBuffer, int i, int i2) {
        sMBBuffer.putNullTerminatedString(this.path, Charsets.UTF_16);
        return i2;
    }

    public DFSReferralV1() {
    }
}

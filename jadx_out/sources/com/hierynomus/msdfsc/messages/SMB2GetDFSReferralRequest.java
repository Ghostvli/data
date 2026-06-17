package com.hierynomus.msdfsc.messages;

import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2GetDFSReferralRequest {
    private String requestFileName;

    public SMB2GetDFSReferralRequest(String str) {
        this.requestFileName = str;
    }

    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(4);
        sMBBuffer.putNullTerminatedString(this.requestFileName, Charsets.UTF_16);
    }
}

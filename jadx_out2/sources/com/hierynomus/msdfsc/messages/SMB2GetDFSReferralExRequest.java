package com.hierynomus.msdfsc.messages;

import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2GetDFSReferralExRequest {
    private int maxReferralLevel;
    private String requestFileName;
    private int requestFlags;
    private String siteName;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum RequestFlags {
        FLAGS_SITENAMEPRESENT(1);

        private int value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        RequestFlags(int i) {
            this.value = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2GetDFSReferralExRequest(String str, String str2) {
        this.maxReferralLevel = 0;
        this.requestFlags = RequestFlags.FLAGS_SITENAMEPRESENT.getValue();
        this.requestFileName = str;
        this.siteName = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.maxReferralLevel);
        sMBBuffer.putUInt16(this.requestFlags);
        int i = this.requestFlags;
        RequestFlags requestFlags = RequestFlags.FLAGS_SITENAMEPRESENT;
        int value = i & requestFlags.getValue();
        String str = this.requestFileName;
        if (value != 0) {
            sMBBuffer.putUInt32(((long) (str.length() + 2 + this.siteName.length())) + 2);
        } else {
            sMBBuffer.putUInt32(((long) str.length()) + 2);
        }
        sMBBuffer.putStringLengthUInt16(this.requestFileName);
        sMBBuffer.putString(this.requestFileName);
        if ((this.requestFlags & requestFlags.getValue()) != 0) {
            sMBBuffer.putStringLengthUInt16(this.requestFileName);
            sMBBuffer.putString(this.requestFileName);
        }
    }

    public SMB2GetDFSReferralExRequest(String str) {
        this.maxReferralLevel = 0;
        this.requestFlags = 0;
        this.requestFileName = str;
        this.siteName = null;
    }
}

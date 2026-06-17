package com.hierynomus.msdfsc.messages;

import com.hierynomus.msdfsc.messages.DFSReferral;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.smb.SMBBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DFSReferralV2 extends DFSReferral {
    private static final int SIZE = 22;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DFSReferralV2(int i, DFSReferral.ServerType serverType, int i2, String str, String str2, String str3) {
        super(i, serverType, 0);
        this.ttl = i2;
        this.dfsPath = str;
        this.dfsAlternatePath = str2;
        this.path = str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public int determineSize() {
        return 22;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public void readReferral(SMBBuffer sMBBuffer, int i) {
        this.referralEntryFlags = 0L;
        sMBBuffer.readUInt32AsInt();
        this.ttl = sMBBuffer.readUInt32AsInt();
        int uInt16 = sMBBuffer.readUInt16();
        int uInt162 = sMBBuffer.readUInt16();
        int uInt163 = sMBBuffer.readUInt16();
        this.dfsPath = readOffsettedString(sMBBuffer, i, uInt16);
        this.dfsAlternatePath = readOffsettedString(sMBBuffer, i, uInt162);
        this.path = readOffsettedString(sMBBuffer, i, uInt163);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public void writeOffsettedData(SMBBuffer sMBBuffer) {
        String str = this.dfsPath;
        Charset charset = Charsets.UTF_16;
        sMBBuffer.putNullTerminatedString(str, charset);
        sMBBuffer.putNullTerminatedString(this.dfsAlternatePath, charset);
        sMBBuffer.putNullTerminatedString(this.path, charset);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public int writeReferral(SMBBuffer sMBBuffer, int i, int i2) {
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(this.ttl);
        sMBBuffer.putUInt16(i2 - i);
        int length = i2 + ((this.dfsPath.length() + 1) * 2);
        sMBBuffer.putUInt16(length - i);
        int length2 = length + ((this.dfsAlternatePath.length() + 1) * 2);
        sMBBuffer.putUInt16(length2 - i);
        return length2 + ((this.path.length() + 1) * 2);
    }

    public DFSReferralV2() {
    }
}

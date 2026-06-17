package com.hierynomus.msdfsc.messages;

import com.hierynomus.msdfsc.messages.DFSReferral;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DFSReferralV34 extends DFSReferral {
    private static final int SIZE = 34;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DFSReferralV34(int i, DFSReferral.ServerType serverType, int i2, int i3, String str, String str2, String str3) {
        super(i, serverType, i2);
        this.ttl = i3;
        this.dfsPath = str;
        this.dfsAlternatePath = str2;
        this.path = str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public int determineSize() {
        return 34;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public void readReferral(SMBBuffer sMBBuffer, int i) throws Buffer.BufferException {
        this.ttl = sMBBuffer.readUInt32AsInt();
        if (!EnumWithValue.EnumUtils.isSet(this.referralEntryFlags, DFSReferral.ReferralEntryFlags.NameListReferral)) {
            this.dfsPath = readOffsettedString(sMBBuffer, i, sMBBuffer.readUInt16());
            this.dfsAlternatePath = readOffsettedString(sMBBuffer, i, sMBBuffer.readUInt16());
            this.path = readOffsettedString(sMBBuffer, i, sMBBuffer.readUInt16());
            sMBBuffer.skip(16);
            return;
        }
        this.specialName = readOffsettedString(sMBBuffer, i, sMBBuffer.readUInt16());
        int uInt16 = sMBBuffer.readUInt16();
        int uInt162 = sMBBuffer.readUInt16();
        this.expandedNames = new ArrayList(uInt16);
        int iRpos = sMBBuffer.rpos();
        sMBBuffer.rpos(i + uInt162);
        for (int i2 = 0; i2 < uInt16; i2++) {
            this.expandedNames.add(sMBBuffer.readNullTerminatedString(Charsets.UTF_16));
        }
        sMBBuffer.rpos(iRpos);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public void writeOffsettedData(SMBBuffer sMBBuffer) {
        if (EnumWithValue.EnumUtils.isSet(this.referralEntryFlags, DFSReferral.ReferralEntryFlags.NameListReferral)) {
            sMBBuffer.putNullTerminatedString(this.specialName, Charsets.UTF_16);
            Iterator<String> it = this.expandedNames.iterator();
            while (it.hasNext()) {
                sMBBuffer.putNullTerminatedString(it.next(), Charsets.UTF_16);
            }
            return;
        }
        String str = this.dfsPath;
        Charset charset = Charsets.UTF_16;
        sMBBuffer.putNullTerminatedString(str, charset);
        sMBBuffer.putNullTerminatedString(this.dfsAlternatePath, charset);
        sMBBuffer.putNullTerminatedString(this.path, charset);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.msdfsc.messages.DFSReferral
    public int writeReferral(SMBBuffer sMBBuffer, int i, int i2) {
        sMBBuffer.putUInt32(this.ttl);
        if (EnumWithValue.EnumUtils.isSet(this.referralEntryFlags, DFSReferral.ReferralEntryFlags.NameListReferral)) {
            sMBBuffer.putUInt16(i2 - i);
            int length = i2 + ((this.specialName.length() + 1) * 2);
            sMBBuffer.putUInt16(this.expandedNames.size());
            sMBBuffer.putUInt16(length - i);
            Iterator<String> it = this.expandedNames.iterator();
            while (it.hasNext()) {
                length += (it.next().length() + 1) * 2;
            }
            return length;
        }
        sMBBuffer.putUInt16(i2 - i);
        int length2 = i2 + ((this.dfsPath.length() + 1) * 2);
        sMBBuffer.putUInt16(length2 - i);
        int length3 = length2 + ((this.dfsAlternatePath.length() + 1) * 2);
        sMBBuffer.putUInt16(length3 - i);
        int length4 = length3 + ((this.path.length() + 1) * 2);
        sMBBuffer.putReserved4();
        sMBBuffer.putReserved4();
        sMBBuffer.putReserved4();
        sMBBuffer.putReserved4();
        return length4;
    }

    public DFSReferralV34() {
    }

    public DFSReferralV34(int i, DFSReferral.ServerType serverType, int i2, int i3, String str, List<String> list) {
        super(i, serverType, i2);
        this.ttl = i3;
        this.specialName = str;
        this.expandedNames = list;
    }
}

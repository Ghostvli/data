package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2Functions;
import com.hierynomus.mssmb2.SMB2ImpersonationLevel;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SmbPath;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2CreateRequest extends SMB2Packet {
    private final Set<AccessMask> accessMask;
    private final SMB2CreateDisposition createDisposition;
    private final Set<SMB2CreateOptions> createOptions;
    private final Set<FileAttributes> fileAttributes;
    private final SMB2ImpersonationLevel impersonationLevel;
    private final SmbPath path;
    private final Set<SMB2ShareAccess> shareAccess;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2CreateRequest(SMB2Dialect sMB2Dialect, long j, long j2, SMB2ImpersonationLevel sMB2ImpersonationLevel, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4, SmbPath smbPath) {
        super(57, sMB2Dialect, SMB2MessageCommandCode.SMB2_CREATE, j, j2);
        this.impersonationLevel = (SMB2ImpersonationLevel) EnumWithValue.EnumUtils.ensureNotNull(sMB2ImpersonationLevel, SMB2ImpersonationLevel.Identification);
        this.accessMask = set;
        this.fileAttributes = EnumWithValue.EnumUtils.ensureNotNull(set2, FileAttributes.class);
        this.shareAccess = EnumWithValue.EnumUtils.ensureNotNull(set3, SMB2ShareAccess.class);
        this.createDisposition = (SMB2CreateDisposition) EnumWithValue.EnumUtils.ensureNotNull(sMB2CreateDisposition, SMB2CreateDisposition.FILE_OPEN_IF);
        this.createOptions = EnumWithValue.EnumUtils.ensureNotNull(set4, SMB2CreateOptions.class);
        this.path = smbPath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2CreateDisposition getCreateDisposition() {
        return this.createDisposition;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        byte[] bArrUnicode;
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putByte((byte) 0);
        sMBBuffer.putByte((byte) 0);
        sMBBuffer.putUInt32(this.impersonationLevel.getValue());
        sMBBuffer.putReserved(8);
        sMBBuffer.putReserved(8);
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.accessMask));
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.fileAttributes));
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.shareAccess));
        sMBBuffer.putUInt32(this.createDisposition.getValue());
        sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.createOptions));
        int i = this.structureSize + 63;
        String path = this.path.getPath();
        if (path == null || path.trim().length() == 0) {
            sMBBuffer.putUInt16(i);
            sMBBuffer.putUInt16(0);
            bArrUnicode = new byte[1];
        } else {
            bArrUnicode = SMB2Functions.unicode(path);
            sMBBuffer.putUInt16(i);
            sMBBuffer.putUInt16(bArrUnicode.length);
        }
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putUInt32(0L);
        sMBBuffer.putRawBytes(bArrUnicode);
    }
}

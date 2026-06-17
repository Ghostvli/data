package com.hierynomus.smbj.share;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.msfscc.fsctl.FsCtlPipeWaitRequest;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2ImpersonationLevel;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2IoctlResponse;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.io.ArrayByteChunkProvider;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PipeShare extends Share {
    private static final int FSCTL_PIPE_WAIT = 1114136;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PipeShare(SmbPath smbPath, TreeConnect treeConnect) {
        super(smbPath, treeConnect);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.share.Share
    public void closeFileId(SMB2FileId sMB2FileId) {
        super.closeFileId(sMB2FileId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NamedPipe open(String str, SMB2ImpersonationLevel sMB2ImpersonationLevel, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        SmbPath smbPath = new SmbPath(this.smbPath, str);
        return new NamedPipe(super.openFileId(smbPath, sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4), this, smbPath);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2FileId openFileId(String str, SMB2ImpersonationLevel sMB2ImpersonationLevel, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        return super.openFileId(new SmbPath(this.smbPath, str), sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean waitForPipe(String str, long j, TimeUnit timeUnit) {
        SMBBuffer sMBBuffer = new SMBBuffer();
        new FsCtlPipeWaitRequest(str, j, timeUnit, j > 0).write(sMBBuffer);
        SMB2IoctlResponse sMB2IoctlResponse = (SMB2IoctlResponse) receive(ioctlAsync(1114136L, true, new ArrayByteChunkProvider(sMBBuffer.getCompactData(), 0L)), j > 0 ? timeUnit.toMillis(j) + 20 : 0L);
        long statusCode = sMB2IoctlResponse.getHeader().getStatusCode();
        if (statusCode == NtStatus.STATUS_SUCCESS.getValue()) {
            return true;
        }
        if (statusCode == NtStatus.STATUS_IO_TIMEOUT.getValue()) {
            return false;
        }
        throw new SMBApiException(sMB2IoctlResponse.getHeader(), "Error while waiting for pipe " + str);
    }

    public boolean waitForPipe(String str) {
        return waitForPipe(str, 0L, TimeUnit.MILLISECONDS);
    }
}

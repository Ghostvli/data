package com.hierynomus.smbj.share;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.smbj.ProgressListener;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.io.ByteChunkProvider;
import com.hierynomus.smbj.io.InputStreamByteChunkProvider;
import java.io.InputStream;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PrinterShare extends Share {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PrinterShare(SmbPath smbPath, TreeConnect treeConnect) {
        super(smbPath, treeConnect);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void print(ByteChunkProvider byteChunkProvider, ProgressListener progressListener) {
        SMB2FileId sMB2FileIdOpenFileId = openFileId(this.smbPath, null, EnumSet.of(AccessMask.FILE_WRITE_DATA), EnumSet.of(FileAttributes.FILE_ATTRIBUTE_NORMAL), EnumSet.of(SMB2ShareAccess.FILE_SHARE_WRITE), SMB2CreateDisposition.FILE_CREATE, EnumSet.of(SMB2CreateOptions.FILE_NON_DIRECTORY_FILE, SMB2CreateOptions.FILE_WRITE_THROUGH));
        try {
            new SMB2Writer(this, sMB2FileIdOpenFileId, getSmbPath().toString()).write(byteChunkProvider, progressListener);
        } finally {
            closeFileId(sMB2FileIdOpenFileId);
        }
    }

    public void print(InputStream inputStream, ProgressListener progressListener) {
        print(new InputStreamByteChunkProvider(inputStream), progressListener);
    }

    public void print(ByteChunkProvider byteChunkProvider) {
        print(byteChunkProvider, (ProgressListener) null);
    }

    public void print(InputStream inputStream) {
        print(inputStream, (ProgressListener) null);
    }
}

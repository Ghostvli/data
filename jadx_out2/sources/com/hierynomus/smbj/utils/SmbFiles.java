package com.hierynomus.smbj.utils;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.io.InputStreamByteChunkProvider;
import com.hierynomus.smbj.share.DiskShare;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SmbFiles {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long copy(File file, DiskShare diskShare, String str, boolean z) throws IOException {
        if (file == null || !file.exists() || !file.canRead() || !file.isFile()) {
            return 0L;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long jWrite = write(fileInputStream, diskShare, str, z);
            fileInputStream.close();
            return jWrite;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION, THROW, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public static long write(InputStream inputStream, DiskShare diskShare, String str, boolean z) {
        if (str == null || inputStream == null) {
            return 0L;
        }
        com.hierynomus.smbj.share.File fileOpenFile = diskShare.openFile(str, EnumSet.of(AccessMask.GENERIC_WRITE), EnumSet.of(FileAttributes.FILE_ATTRIBUTE_NORMAL), EnumSet.of(SMB2ShareAccess.FILE_SHARE_WRITE), z ? SMB2CreateDisposition.FILE_OVERWRITE_IF : SMB2CreateDisposition.FILE_CREATE, EnumSet.noneOf(SMB2CreateOptions.class));
        try {
            long jWrite = fileOpenFile.write(new InputStreamByteChunkProvider(inputStream));
            fileOpenFile.close();
            return jWrite;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void mkdirs(DiskShare diskShare, SmbPath smbPath) {
        if (diskShare.folderExists(smbPath.getPath())) {
            return;
        }
        mkdirs(diskShare, smbPath.getParent());
        diskShare.mkdir(smbPath.getPath());
    }

    public void mkdirs(DiskShare diskShare, String str) {
        mkdirs(diskShare, new SmbPath(diskShare.getSmbPath(), str));
    }
}

package com.hierynomus.msfscc.fileinformation;

import com.hierynomus.msdtyp.FileTime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileDirectoryInformation extends FileDirectoryQueryableInformation {
    private final long allocationSize;
    private final FileTime changeTime;
    private final FileTime creationTime;
    private final long endOfFile;
    private final long fileAttributes;
    private final FileTime lastAccessTime;
    private final FileTime lastWriteTime;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileDirectoryInformation(long j, long j2, String str, FileTime fileTime, FileTime fileTime2, FileTime fileTime3, FileTime fileTime4, long j3, long j4, long j5) {
        super(j, j2, str);
        this.creationTime = fileTime;
        this.lastAccessTime = fileTime2;
        this.lastWriteTime = fileTime3;
        this.changeTime = fileTime4;
        this.endOfFile = j3;
        this.allocationSize = j4;
        this.fileAttributes = j5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getAllocationSize() {
        return this.allocationSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getChangeTime() {
        return this.changeTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getCreationTime() {
        return this.creationTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getEndOfFile() {
        return this.endOfFile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getFileAttributes() {
        return this.fileAttributes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getLastAccessTime() {
        return this.lastAccessTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime getLastWriteTime() {
        return this.lastWriteTime;
    }
}

package com.hierynomus.msfscc.fileinformation;

import com.hierynomus.msdtyp.FileTime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileIdBothDirectoryInformation extends FileDirectoryQueryableInformation {
    private final long allocationSize;
    private final FileTime changeTime;
    private final FileTime creationTime;
    private final long eaSize;
    private final long endOfFile;
    private final long fileAttributes;
    private final long fileId;
    private final FileTime lastAccessTime;
    private final FileTime lastWriteTime;
    private final String shortName;

    public FileIdBothDirectoryInformation(long j, long j2, String str, FileTime fileTime, FileTime fileTime2, FileTime fileTime3, FileTime fileTime4, long j3, long j4, long j5, long j6, String str2, long j7) {
        super(j, j2, str);
        this.creationTime = fileTime;
        this.lastAccessTime = fileTime2;
        this.lastWriteTime = fileTime3;
        this.changeTime = fileTime4;
        this.endOfFile = j3;
        this.allocationSize = j4;
        this.fileAttributes = j5;
        this.eaSize = j6;
        this.shortName = str2;
        this.fileId = j7;
    }

    public long getAllocationSize() {
        return this.allocationSize;
    }

    public FileTime getChangeTime() {
        return this.changeTime;
    }

    public FileTime getCreationTime() {
        return this.creationTime;
    }

    public long getEaSize() {
        return this.eaSize;
    }

    public long getEndOfFile() {
        return this.endOfFile;
    }

    public long getFileAttributes() {
        return this.fileAttributes;
    }

    public long getFileId() {
        return this.fileId;
    }

    public FileTime getLastAccessTime() {
        return this.lastAccessTime;
    }

    public FileTime getLastWriteTime() {
        return this.lastWriteTime;
    }

    public String getShortName() {
        return this.shortName;
    }
}

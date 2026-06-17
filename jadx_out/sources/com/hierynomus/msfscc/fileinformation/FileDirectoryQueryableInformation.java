package com.hierynomus.msfscc.fileinformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FileDirectoryQueryableInformation implements FileInformation {
    private long fileIndex;
    private final String fileName;
    private long nextOffset;

    public FileDirectoryQueryableInformation(long j, long j2, String str) {
        this.nextOffset = j;
        this.fileIndex = j2;
        this.fileName = str;
    }

    public long getFileIndex() {
        return this.fileIndex;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getNextOffset() {
        return this.nextOffset;
    }
}

package com.hierynomus.msfscc.fileinformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileStandardInformation implements FileQueryableInformation {
    private long allocationSize;
    private boolean deletePending;
    private boolean directory;
    private long endOfFile;
    private long numberOfLinks;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileStandardInformation(long j, long j2, long j3, boolean z, boolean z2) {
        this.allocationSize = j;
        this.endOfFile = j2;
        this.numberOfLinks = j3;
        this.deletePending = z;
        this.directory = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getAllocationSize() {
        return this.allocationSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getEndOfFile() {
        return this.endOfFile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getNumberOfLinks() {
        return this.numberOfLinks;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDeletePending() {
        return this.deletePending;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDirectory() {
        return this.directory;
    }
}

package com.hierynomus.msfscc.fileinformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileRenameInformation implements FileSettableInformation {
    private final String fileName;
    private final int fileNameLength;
    private final boolean replaceIfExists;
    private final long rootDirectory;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileRenameInformation(boolean z, long j, String str) {
        this.replaceIfExists = z;
        this.rootDirectory = j;
        this.fileNameLength = str.length();
        this.fileName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFileName() {
        return this.fileName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getFileNameLength() {
        return this.fileNameLength;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getRootDirectory() {
        return this.rootDirectory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isReplaceIfExists() {
        return this.replaceIfExists;
    }
}

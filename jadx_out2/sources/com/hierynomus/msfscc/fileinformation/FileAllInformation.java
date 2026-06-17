package com.hierynomus.msfscc.fileinformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileAllInformation implements FileQueryableInformation {
    private FileAccessInformation accessInformation;
    private FileAlignmentInformation alignmentInformation;
    private FileBasicInformation basicInformation;
    private FileEaInformation eaInformation;
    private FileInternalInformation internalInformation;
    private FileModeInformation modeInformation;
    private String nameInformation;
    private FilePositionInformation positionInformation;
    private FileStandardInformation standardInformation;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileAllInformation(FileBasicInformation fileBasicInformation, FileStandardInformation fileStandardInformation, FileInternalInformation fileInternalInformation, FileEaInformation fileEaInformation, FileAccessInformation fileAccessInformation, FilePositionInformation filePositionInformation, FileModeInformation fileModeInformation, FileAlignmentInformation fileAlignmentInformation, String str) {
        this.basicInformation = fileBasicInformation;
        this.standardInformation = fileStandardInformation;
        this.internalInformation = fileInternalInformation;
        this.eaInformation = fileEaInformation;
        this.accessInformation = fileAccessInformation;
        this.positionInformation = filePositionInformation;
        this.modeInformation = fileModeInformation;
        this.alignmentInformation = fileAlignmentInformation;
        this.nameInformation = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileAccessInformation getAccessInformation() {
        return this.accessInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileAlignmentInformation getAlignmentInformation() {
        return this.alignmentInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileBasicInformation getBasicInformation() {
        return this.basicInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileEaInformation getEaInformation() {
        return this.eaInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileInternalInformation getInternalInformation() {
        return this.internalInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileModeInformation getModeInformation() {
        return this.modeInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNameInformation() {
        return this.nameInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FilePositionInformation getPositionInformation() {
        return this.positionInformation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileStandardInformation getStandardInformation() {
        return this.standardInformation;
    }
}

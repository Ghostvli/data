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

    public FileAccessInformation getAccessInformation() {
        return this.accessInformation;
    }

    public FileAlignmentInformation getAlignmentInformation() {
        return this.alignmentInformation;
    }

    public FileBasicInformation getBasicInformation() {
        return this.basicInformation;
    }

    public FileEaInformation getEaInformation() {
        return this.eaInformation;
    }

    public FileInternalInformation getInternalInformation() {
        return this.internalInformation;
    }

    public FileModeInformation getModeInformation() {
        return this.modeInformation;
    }

    public String getNameInformation() {
        return this.nameInformation;
    }

    public FilePositionInformation getPositionInformation() {
        return this.positionInformation;
    }

    public FileStandardInformation getStandardInformation() {
        return this.standardInformation;
    }
}

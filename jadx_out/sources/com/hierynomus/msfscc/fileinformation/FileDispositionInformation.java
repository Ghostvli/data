package com.hierynomus.msfscc.fileinformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileDispositionInformation implements FileSettableInformation {
    private boolean deleteOnClose;

    public FileDispositionInformation() {
        this.deleteOnClose = true;
    }

    public boolean isDeleteOnClose() {
        return this.deleteOnClose;
    }

    public FileDispositionInformation(boolean z) {
        this.deleteOnClose = z;
    }
}

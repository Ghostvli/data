package com.hierynomus.msfscc.fileinformation;

import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileEndOfFileInformation implements FileSettableInformation {
    private long endOfFile;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileEndOfFileInformation(long j) {
        if (j >= 0) {
            this.endOfFile = j;
        } else {
            jl.a("endOfFile MUST be greater than or equal to 0");
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getEndOfFile() {
        return this.endOfFile;
    }
}

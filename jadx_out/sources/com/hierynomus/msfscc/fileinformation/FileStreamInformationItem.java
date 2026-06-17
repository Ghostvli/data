package com.hierynomus.msfscc.fileinformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileStreamInformationItem {
    private long allocSize;
    private String name;
    private long size;

    public FileStreamInformationItem(long j, long j2, String str) {
        this.size = j;
        this.allocSize = j2;
        this.name = str;
    }

    public long getAllocSize() {
        return this.allocSize;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }
}

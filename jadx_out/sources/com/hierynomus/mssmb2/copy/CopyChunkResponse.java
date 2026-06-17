package com.hierynomus.mssmb2.copy;

import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CopyChunkResponse {
    private long chunkBytesWritten;
    private long chunksWritten;
    private long totalBytesWritten;

    public CopyChunkResponse(long j, long j2, long j3) {
        this.chunksWritten = j;
        this.chunkBytesWritten = j2;
        this.totalBytesWritten = j3;
    }

    public long getChunkBytesWritten() {
        return this.chunkBytesWritten;
    }

    public long getChunksWritten() {
        return this.chunksWritten;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public final void read(SMBBuffer sMBBuffer) {
        this.chunksWritten = sMBBuffer.readUInt32();
        this.chunkBytesWritten = sMBBuffer.readUInt32();
        this.totalBytesWritten = sMBBuffer.readUInt32();
    }

    public CopyChunkResponse() {
    }
}

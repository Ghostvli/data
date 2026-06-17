package com.hierynomus.mssmb2.copy;

import com.hierynomus.smb.SMBBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CopyChunkResponse {
    private long chunkBytesWritten;
    private long chunksWritten;
    private long totalBytesWritten;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CopyChunkResponse(long j, long j2, long j3) {
        this.chunksWritten = j;
        this.chunkBytesWritten = j2;
        this.totalBytesWritten = j3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getChunkBytesWritten() {
        return this.chunkBytesWritten;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getChunksWritten() {
        return this.chunksWritten;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void read(SMBBuffer sMBBuffer) {
        this.chunksWritten = sMBBuffer.readUInt32();
        this.chunkBytesWritten = sMBBuffer.readUInt32();
        this.totalBytesWritten = sMBBuffer.readUInt32();
    }

    public CopyChunkResponse() {
    }
}

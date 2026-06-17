package com.hierynomus.mssmb2.copy;

import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CopyChunkRequest {
    private static final long ctlCode = 1343730;
    private List<Chunk> chunks;
    private byte[] resumeKey;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Chunk {
        private long length;
        private long srcOffset;
        private long tgtOffset;

        public Chunk(long j, long j2, long j3) {
            this.srcOffset = j;
            this.tgtOffset = j2;
            this.length = j3;
        }

        public long getLength() {
            return this.length;
        }

        public long getSrcOffset() {
            return this.srcOffset;
        }

        public long getTgtOffset() {
            return this.tgtOffset;
        }
    }

    public CopyChunkRequest(byte[] bArr, List<Chunk> list) {
        ArrayList arrayList = new ArrayList();
        this.chunks = arrayList;
        this.resumeKey = bArr;
        arrayList.addAll(list);
    }

    public static long getCtlCode() {
        return ctlCode;
    }

    public List<Chunk> getChunks() {
        return this.chunks;
    }

    public byte[] getResumeKey() {
        return this.resumeKey;
    }

    public void write(SMBBuffer sMBBuffer) {
        sMBBuffer.putRawBytes(getResumeKey());
        sMBBuffer.putUInt32(getChunks().size());
        sMBBuffer.putUInt32(0L);
        for (Chunk chunk : getChunks()) {
            sMBBuffer.putUInt64(chunk.getSrcOffset());
            sMBBuffer.putUInt64(chunk.getTgtOffset());
            sMBBuffer.putUInt32(chunk.getLength());
            sMBBuffer.putUInt32(0L);
        }
    }
}

package com.hierynomus.smbj.io;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferByteChunkProvider extends CachingByteChunkProvider {
    private ByteBuffer buffer;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ByteBufferByteChunkProvider(ByteBuffer byteBuffer, long j) {
        this.buffer = byteBuffer;
        this.offset = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider
    public /* bridge */ /* synthetic */ int bytesLeft() {
        return super.bytesLeft();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider
    public boolean isAvailable() {
        return super.isAvailable() || this.buffer.hasRemaining();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider
    public int prepareChunk(byte[] bArr, int i) {
        int iMin = Math.min(bArr.length, Math.min(i, this.buffer.remaining()));
        if (iMin == 0) {
            return -1;
        }
        this.buffer.get(bArr, 0, iMin);
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider
    public /* bridge */ /* synthetic */ void prepareWrite(int i) {
        super.prepareWrite(i);
    }

    public ByteBufferByteChunkProvider(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }
}

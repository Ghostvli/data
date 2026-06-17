package com.hierynomus.smbj.io;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ArrayByteChunkProvider extends ByteChunkProvider {
    private int bufferOffset;
    private final byte[] data;
    private int remaining;

    public ArrayByteChunkProvider(byte[] bArr, int i, int i2, long j) {
        this.data = bArr;
        this.offset = j;
        this.bufferOffset = i;
        this.remaining = i2;
    }

    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int bytesLeft() {
        return this.remaining;
    }

    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int getChunk(byte[] bArr) {
        int length = bArr.length;
        int i = this.remaining;
        if (length > i) {
            length = i;
        }
        System.arraycopy(this.data, this.bufferOffset, bArr, 0, length);
        this.bufferOffset += length;
        this.remaining -= length;
        return length;
    }

    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public boolean isAvailable() {
        return this.remaining > 0;
    }

    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public void prepareWrite(int i) {
    }

    public ArrayByteChunkProvider(byte[] bArr, long j) {
        this(bArr, 0, bArr.length, j);
    }
}

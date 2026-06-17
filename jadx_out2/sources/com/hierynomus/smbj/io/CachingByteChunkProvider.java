package com.hierynomus.smbj.io;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import com.hierynomus.smbj.common.SMBRuntimeException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
abstract class CachingByteChunkProvider extends ByteChunkProvider {
    private Buffer<Buffer.PlainBuffer> buffer;
    private BufferByteChunkProvider cachingProvider;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CachingByteChunkProvider() {
        Buffer.PlainBuffer plainBuffer = new Buffer.PlainBuffer(Endian.BE);
        this.buffer = plainBuffer;
        this.cachingProvider = new BufferByteChunkProvider(plainBuffer);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int bytesLeft() {
        return this.cachingProvider.bytesLeft();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cachingProvider.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int getChunk(byte[] bArr) {
        return this.cachingProvider.getChunk(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public boolean isAvailable() {
        return this.cachingProvider.isAvailable();
    }

    public abstract int prepareChunk(byte[] bArr, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public void prepareWrite(int i) {
        Buffer<Buffer.PlainBuffer> buffer = this.buffer;
        if (buffer == null) {
            return;
        }
        byte[] bArr = new byte[1024];
        buffer.compact();
        int iAvailable = this.buffer.available();
        while (true) {
            i -= iAvailable;
            if (i <= 0) {
                return;
            }
            try {
                iAvailable = prepareChunk(bArr, i);
                if (iAvailable == -1) {
                    return;
                } else {
                    this.buffer.putRawBytes(bArr, 0, iAvailable);
                }
            } catch (IOException e) {
                throw new SMBRuntimeException(e);
            }
        }
    }
}

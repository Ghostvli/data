package com.hierynomus.smbj.io;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smbj.common.SMBRuntimeException;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteChunkProvider implements Closeable {
    protected static final int CHUNK_SIZE = 65536;
    protected int chunkSize = 65536;
    private int lastWriteSize;
    protected long offset;

    public abstract int bytesLeft();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public abstract int getChunk(byte[] bArr);

    public int getChunkSize() {
        return this.chunkSize;
    }

    public int getLastWriteSize() {
        return this.lastWriteSize;
    }

    public long getOffset() {
        return this.offset;
    }

    public abstract boolean isAvailable();

    public abstract void prepareWrite(int i);

    public void writeChunk(OutputStream outputStream) {
        this.lastWriteSize = 0;
        byte[] bArr = new byte[this.chunkSize];
        try {
            int chunk = getChunk(bArr);
            outputStream.write(bArr, 0, chunk);
            this.offset += (long) chunk;
            this.lastWriteSize += chunk;
        } catch (IOException e) {
            throw new SMBRuntimeException(e);
        }
    }

    public void writeChunks(Buffer<?> buffer, int i) {
        this.lastWriteSize = 0;
        byte[] bArr = new byte[this.chunkSize];
        for (int i2 = 0; i2 < i; i2++) {
            try {
                int chunk = getChunk(bArr);
                buffer.putRawBytes(bArr, 0, chunk);
                this.offset += (long) chunk;
                this.lastWriteSize += chunk;
            } catch (IOException e) {
                throw new SMBRuntimeException(e);
            }
        }
    }

    public void writeChunk(Buffer<?> buffer) {
        this.lastWriteSize = 0;
        byte[] bArr = new byte[this.chunkSize];
        try {
            int chunk = getChunk(bArr);
            buffer.putRawBytes(bArr, 0, chunk);
            this.offset += (long) chunk;
            this.lastWriteSize += chunk;
        } catch (IOException e) {
            throw new SMBRuntimeException(e);
        }
    }
}

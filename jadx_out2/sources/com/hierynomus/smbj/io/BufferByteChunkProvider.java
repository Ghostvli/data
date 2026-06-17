package com.hierynomus.smbj.io;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BufferByteChunkProvider extends ByteChunkProvider {
    private Buffer<?> buffer;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BufferByteChunkProvider(Buffer<?> buffer) {
        this.buffer = buffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int bytesLeft() {
        return this.buffer.available();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int getChunk(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.buffer.available() < bArr.length) {
            length = this.buffer.available();
        }
        try {
            this.buffer.readRawBytes(bArr, 0, length);
            return length;
        } catch (Buffer.BufferException e) {
            throw new IOException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public boolean isAvailable() {
        return this.buffer.available() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public void prepareWrite(int i) {
    }
}

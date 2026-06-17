package com.hierynomus.smbj.share;

import com.hierynomus.smbj.ProgressListener;
import com.hierynomus.smbj.io.ByteChunkProvider;
import defpackage.j02;
import defpackage.n02;
import defpackage.sb1;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class FileOutputStream extends OutputStream {
    private static final j02 logger = n02.k(FileOutputStream.class);
    private boolean isClosed = false;
    private ProgressListener progressListener;
    private ByteArrayProvider provider;
    private SMB2Writer writer;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileOutputStream(SMB2Writer sMB2Writer, int i, long j, ProgressListener progressListener) {
        this.writer = sMB2Writer;
        this.progressListener = progressListener;
        this.provider = new ByteArrayProvider(i, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void sendWriteRequest() {
        this.writer.write(this.provider, this.progressListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void verifyConnectionNotClosed() throws IOException {
        if (this.isClosed) {
            sb1.a("Stream is closed");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (this.provider.isAvailable()) {
            sendWriteRequest();
        }
        this.provider.reset();
        this.isClosed = true;
        this.writer = null;
        logger.q("EOF, {} bytes written", Long.valueOf(this.provider.getOffset()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        verifyConnectionNotClosed();
        if (this.provider.isAvailable()) {
            sendWriteRequest();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        verifyConnectionNotClosed();
        do {
            int iMin = Math.min(i2, this.provider.maxSize());
            while (this.provider.isBufferFull(iMin)) {
                flush();
            }
            if (!this.provider.isBufferFull()) {
                this.provider.writeBytes(bArr, i, iMin);
            }
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ByteArrayProvider extends ByteChunkProvider {
        private RingBuffer buf;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private ByteArrayProvider(int i, long j) {
            this.buf = new RingBuffer(i);
            this.offset = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.buf = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.io.ByteChunkProvider
        public int bytesLeft() {
            return this.buf.size();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.io.ByteChunkProvider
        public int getChunk(byte[] bArr) {
            return this.buf.read(bArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.io.ByteChunkProvider
        public boolean isAvailable() {
            RingBuffer ringBuffer = this.buf;
            return (ringBuffer == null || ringBuffer.isEmpty()) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isBufferFull() {
            return this.buf.isFull();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int maxSize() {
            return this.buf.maxSize();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.io.ByteChunkProvider
        public void prepareWrite(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void writeByte(int i) {
            this.buf.write(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void writeBytes(byte[] bArr, int i, int i2) {
            this.buf.write(bArr, i, i2);
        }

        public boolean isBufferFull(int i) {
            return this.buf.isFull(i);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        verifyConnectionNotClosed();
        if (this.provider.isBufferFull()) {
            flush();
        }
        if (this.provider.isBufferFull()) {
            return;
        }
        this.provider.writeByte(i);
    }
}

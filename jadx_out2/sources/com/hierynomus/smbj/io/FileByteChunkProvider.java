package com.hierynomus.smbj.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileByteChunkProvider extends ByteChunkProvider {
    private File file;
    private InputStreamByteChunkProvider underlyingProvider;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileByteChunkProvider(File file, long j) throws IOException {
        this.file = file;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.underlyingProvider = new InputStreamByteChunkProvider(fileInputStream);
        ensureSkipped(fileInputStream, j);
        this.offset = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void ensureSkipped(FileInputStream fileInputStream, long j) throws IOException {
        long jSkip = 0;
        while (jSkip < j && fileInputStream.available() > 0) {
            jSkip += fileInputStream.skip(j);
        }
        if (jSkip >= j) {
            return;
        }
        throw new IOException("Was unable to go to the requested offset of " + j + " of file " + this.file);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int bytesLeft() {
        return this.underlyingProvider.bytesLeft();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.underlyingProvider.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public int getChunk(byte[] bArr) {
        return this.underlyingProvider.getChunk(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public boolean isAvailable() {
        return this.underlyingProvider.isAvailable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.io.ByteChunkProvider
    public void prepareWrite(int i) {
        this.underlyingProvider.prepareWrite(i);
    }

    public FileByteChunkProvider(File file) {
        this(file, 0L);
    }
}

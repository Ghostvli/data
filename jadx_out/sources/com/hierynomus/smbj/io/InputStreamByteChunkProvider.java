package com.hierynomus.smbj.io;

import com.hierynomus.smbj.common.SMBRuntimeException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class InputStreamByteChunkProvider extends CachingByteChunkProvider {
    private boolean close;

    /* JADX INFO: renamed from: is, reason: collision with root package name */
    private BufferedInputStream f2is;

    public InputStreamByteChunkProvider(InputStream inputStream) {
        if (inputStream instanceof BufferedInputStream) {
            this.f2is = (BufferedInputStream) inputStream;
        } else {
            this.f2is = new BufferedInputStream(inputStream);
            this.close = true;
        }
    }

    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider
    public /* bridge */ /* synthetic */ int bytesLeft() {
        return super.bytesLeft();
    }

    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        BufferedInputStream bufferedInputStream = this.f2is;
        if (bufferedInputStream == null || !this.close) {
            return;
        }
        try {
            bufferedInputStream.close();
        } finally {
            this.f2is = null;
        }
    }

    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider
    public boolean isAvailable() {
        try {
            if (super.isAvailable()) {
                return true;
            }
            BufferedInputStream bufferedInputStream = this.f2is;
            if (bufferedInputStream != null) {
                return bufferedInputStream.available() > 0;
            }
            return false;
        } catch (IOException e) {
            throw new SMBRuntimeException(e);
        }
    }

    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider
    public int prepareChunk(byte[] bArr, int i) {
        int iMin = Math.min(i, bArr.length);
        if (iMin == 0) {
            return -1;
        }
        return this.f2is.read(bArr, 0, iMin);
    }

    @Override // com.hierynomus.smbj.io.CachingByteChunkProvider, com.hierynomus.smbj.io.ByteChunkProvider
    public /* bridge */ /* synthetic */ void prepareWrite(int i) {
        super.prepareWrite(i);
    }
}

package com.hierynomus.smbj.share;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2ReadResponse;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.ProgressListener;
import defpackage.j02;
import defpackage.n02;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class FileInputStream extends InputStream implements InputStreamRetargetInterface {
    private static final j02 logger = n02.k(FileInputStream.class);
    private byte[] buf;
    private int bufferSize;
    private File file;
    private boolean isClosed;
    private Future<SMB2ReadResponse> nextResponse;
    private ProgressListener progressListener;
    private final long readTimeout;
    private long offset = 0;
    private int curr = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileInputStream(File file, int i, long j, ProgressListener progressListener) {
        this.file = file;
        this.bufferSize = i;
        this.progressListener = progressListener;
        this.readTimeout = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void loadBuffer() {
        if (this.isClosed) {
            return;
        }
        if (this.nextResponse == null) {
            this.nextResponse = sendRequest();
        }
        SMB2ReadResponse sMB2ReadResponse = (SMB2ReadResponse) Futures.get(this.nextResponse, this.readTimeout, TimeUnit.MILLISECONDS, TransportException.Wrapper);
        long statusCode = sMB2ReadResponse.getHeader().getStatusCode();
        NtStatus ntStatus = NtStatus.STATUS_SUCCESS;
        if (statusCode == ntStatus.getValue()) {
            this.buf = sMB2ReadResponse.getData();
            this.curr = 0;
            this.offset += (long) sMB2ReadResponse.getDataLength();
            ProgressListener progressListener = this.progressListener;
            if (progressListener != null) {
                progressListener.onProgressChanged(sMB2ReadResponse.getDataLength(), this.offset);
            }
        }
        if (sMB2ReadResponse.getHeader().getStatusCode() == NtStatus.STATUS_END_OF_FILE.getValue() || sMB2ReadResponse.getDataLength() == 0) {
            logger.q("EOF, {} bytes read", Long.valueOf(this.offset));
            this.isClosed = true;
        } else {
            if (sMB2ReadResponse.getHeader().getStatusCode() == ntStatus.getValue()) {
                this.nextResponse = sendRequest();
                return;
            }
            throw new SMBApiException(sMB2ReadResponse.getHeader(), "Read failed for " + this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Future<SMB2ReadResponse> sendRequest() {
        return this.file.readAsync(this.offset, this.bufferSize);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.isClosed = true;
        this.file = null;
        this.buf = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.buf;
        if (bArr2 == null || this.curr >= bArr2.length) {
            loadBuffer();
        }
        if (this.isClosed) {
            return -1;
        }
        byte[] bArr3 = this.buf;
        int length = bArr3.length;
        int i3 = this.curr;
        if (length - i3 <= i2) {
            i2 = bArr3.length - i3;
        }
        System.arraycopy(bArr3, i3, bArr, i, i2);
        this.curr += i2;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.InputStream
    public long skip(long j) {
        byte[] bArr = this.buf;
        if (bArr == null) {
            this.offset += j;
            return j;
        }
        int i = this.curr;
        if (((long) i) + j < bArr.length) {
            this.curr = (int) (((long) i) + j);
            return j;
        }
        this.offset += (((long) i) + j) - ((long) bArr.length);
        this.buf = null;
        this.nextResponse = null;
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this.buf;
        if (bArr == null || this.curr >= bArr.length) {
            loadBuffer();
        }
        if (this.isClosed) {
            return -1;
        }
        byte[] bArr2 = this.buf;
        int i = this.curr;
        this.curr = i + 1;
        return bArr2[i] & 255;
    }
}

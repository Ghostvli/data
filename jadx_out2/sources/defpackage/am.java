package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class am extends OutputStream {
    public final OutputStream f;
    public byte[] g;
    public ma h;
    public int i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public am(OutputStream outputStream, ma maVar, int i) {
        this.f = outputStream;
        this.h = maVar;
        this.g = (byte[]) maVar.d(i, byte[].class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() throws IOException {
        int i = this.i;
        if (i > 0) {
            this.f.write(this.g, 0, i);
            this.i = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() throws IOException {
        if (this.i == this.g.length) {
            a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f.close();
            h();
        } catch (Throwable th) {
            this.f.close();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f.flush();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        byte[] bArr = this.g;
        if (bArr != null) {
            this.h.put(bArr);
            this.g = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.i;
            if (i6 == 0 && i4 >= this.g.length) {
                this.f.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.g.length - i6);
            System.arraycopy(bArr, i5, this.g, this.i, iMin);
            this.i += iMin;
            i3 += iMin;
            c();
        } while (i3 < i2);
    }

    public am(OutputStream outputStream, ma maVar) {
        this(outputStream, maVar, 65536);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.g;
        int i2 = this.i;
        this.i = i2 + 1;
        bArr[i2] = (byte) i;
        c();
    }
}

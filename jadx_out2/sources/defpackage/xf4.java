package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xf4 implements Closeable {
    public final InputStream f;
    public final Charset g;
    public byte[] h;
    public int i;
    public int j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ByteArrayOutputStream {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, xf4.this.g.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xf4(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            jl.a("capacity <= 0");
            throw null;
        }
        if (!charset.equals(hy4.a)) {
            jl.a("Unsupported encoding");
            throw null;
        }
        this.f = inputStream;
        this.g = charset;
        this.h = new byte[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() throws IOException {
        InputStream inputStream = this.f;
        byte[] bArr = this.h;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            ll.a();
        } else {
            this.i = 0;
            this.j = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f) {
            try {
                if (this.h != null) {
                    this.h = null;
                    this.f.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h() {
        return this.j == -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String i() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f) {
            try {
                if (this.h == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.i >= this.j) {
                    c();
                }
                for (int i3 = this.i; i3 != this.j; i3++) {
                    byte[] bArr2 = this.h;
                    if (bArr2[i3] == 10) {
                        int i4 = this.i;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] != 13) {
                                i2 = i3;
                            }
                        }
                        String str = new String(bArr2, i4, i2 - i4, this.g.name());
                        this.i = i3 + 1;
                        return str;
                    }
                }
                a aVar = new a((this.j - this.i) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.h;
                    int i5 = this.i;
                    aVar.write(bArr3, i5, this.j - i5);
                    this.j = -1;
                    c();
                    i = this.i;
                    while (i != this.j) {
                        bArr = this.h;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.i;
                if (i != i6) {
                    aVar.write(bArr, i6, i - i6);
                }
                this.i = i + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public xf4(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }
}

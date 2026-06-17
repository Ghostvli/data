package defpackage;

import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class dp3 extends FilterInputStream implements InputStreamRetargetInterface {
    public volatile byte[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final ma k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public dp3(InputStream inputStream, ma maVar, int i) {
        super(inputStream);
        this.i = -1;
        this.k = maVar;
        this.f = (byte[]) maVar.d(i, byte[].class);
    }

    public static IOException i() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.i;
        if (i != -1) {
            int i2 = this.j - i;
            int i3 = this.h;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.g == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.k.d(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f = bArr2;
                    this.k.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.j - this.i;
                this.j = i4;
                this.i = 0;
                this.g = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                int i6 = this.j;
                if (i5 > 0) {
                    i6 += i5;
                }
                this.g = i6;
                return i5;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.i = -1;
            this.j = 0;
            this.g = i7;
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f == null || inputStream == null) {
            throw i();
        }
        return (this.g - this.j) + inputStream.available();
    }

    public synchronized void c() {
        this.h = this.f.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f != null) {
            this.k.put(this.f);
            this.f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void h() {
        if (this.f != null) {
            this.k.put(this.f);
            this.f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.h = Math.max(this.h, i);
        this.i = this.j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.f;
        if (bArr2 == null) {
            throw i();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw i();
        }
        int i5 = this.j;
        int i6 = this.g;
        if (i5 < i6) {
            int i7 = i6 - i5 >= i2 ? i2 : i6 - i5;
            System.arraycopy(bArr2, i5, bArr, i, i7);
            this.j += i7;
            if (i7 == i2 || inputStream.available() == 0) {
                return i7;
            }
            i += i7;
            i3 = i2 - i7;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.i == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (a(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.f && (bArr2 = this.f) == null) {
                    throw i();
                }
                int i8 = this.g;
                int i9 = this.j;
                i4 = i8 - i9 >= i3 ? i3 : i8 - i9;
                System.arraycopy(bArr2, i9, bArr, i, i4);
                this.j += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.i;
        if (-1 == i) {
            throw new a("Mark has been invalidated, pos: " + this.j + " markLimit: " + this.h);
        }
        this.j = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f;
        if (bArr == null) {
            throw i();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw i();
        }
        int i = this.g;
        int i2 = this.j;
        if (i - i2 >= j) {
            this.j = (int) (((long) i2) + j);
            return j;
        }
        long j2 = ((long) i) - ((long) i2);
        this.j = i;
        if (this.i == -1 || j > this.h) {
            long jSkip = inputStream.skip(j - j2);
            if (jSkip > 0) {
                this.i = -1;
            }
            return j2 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.g;
        int i4 = this.j;
        if (i3 - i4 >= j - j2) {
            this.j = (int) ((((long) i4) + j) - j2);
            return j;
        }
        long j3 = (j2 + ((long) i3)) - ((long) i4);
        this.j = i3;
        return j3;
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    public dp3(InputStream inputStream, ma maVar) {
        this(inputStream, maVar, 65536);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.j >= this.g && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f && (bArr = this.f) == null) {
                throw i();
            }
            int i = this.g;
            int i2 = this.j;
            if (i - i2 <= 0) {
                return -1;
            }
            this.j = i2 + 1;
            return bArr[i2] & 255;
        }
        throw i();
    }
}

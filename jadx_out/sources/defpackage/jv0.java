package defpackage;

import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jv0 extends InputStream implements InputStreamRetargetInterface {
    public static final Queue h = iy4.g(0);
    public InputStream f;
    public IOException g;

    public static jv0 c(InputStream inputStream) {
        jv0 jv0Var;
        Queue queue = h;
        synchronized (queue) {
            jv0Var = (jv0) queue.poll();
        }
        if (jv0Var == null) {
            jv0Var = new jv0();
        }
        jv0Var.i(inputStream);
        return jv0Var;
    }

    public IOException a() {
        return this.g;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    public void h() {
        this.g = null;
        this.f = null;
        Queue queue = h;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void i(InputStream inputStream) {
        this.f = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f.read();
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f.skip(j);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f.read(bArr);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f.read(bArr, i, i2);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }
}

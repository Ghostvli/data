package defpackage;

import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ha0 extends InputStream implements InputStreamRetargetInterface {
    public final aa0 f;
    public final ja0 g;
    public long k;
    public boolean i = false;
    public boolean j = false;
    public final byte[] h = new byte[1];

    public ha0(aa0 aa0Var, ja0 ja0Var) {
        this.f = aa0Var;
        this.g = ja0Var;
    }

    public final void a() {
        if (this.i) {
            return;
        }
        this.f.a(this.g);
        this.i = true;
    }

    public void c() {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.j) {
            return;
        }
        this.f.close();
        this.j = true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        gg3.v(!this.j);
        a();
        int i3 = this.f.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.k += (long) i3;
        return i3;
    }

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
        if (read(this.h) == -1) {
            return -1;
        }
        return this.h[0] & 255;
    }
}

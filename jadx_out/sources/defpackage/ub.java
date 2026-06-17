package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ub {
    public final File a;
    public final File b;

    public ub(File file) {
        this.a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.a.delete();
        this.b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.b.delete();
    }

    public boolean c() {
        return this.a.exists() || this.b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.a);
    }

    public final void e() {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
    }

    public OutputStream f() throws IOException {
        if (this.a.exists()) {
            boolean zExists = this.b.exists();
            File file = this.a;
            if (zExists) {
                file.delete();
            } else if (!file.renameTo(this.b)) {
                xz1.i("AtomicFile", "Couldn't rename file " + this.a + " to backup file " + this.b);
            }
        }
        try {
            return new a(this.a);
        } catch (FileNotFoundException e) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.a, e);
            }
            try {
                return new a(this.a);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.a, e2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends OutputStream {
        public final FileOutputStream f;
        public boolean g = false;

        public a(File file) {
            this.f = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.g) {
                return;
            }
            this.g = true;
            flush();
            try {
                this.f.getFD().sync();
            } catch (IOException e) {
                xz1.j("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.f.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f.write(bArr, i, i2);
        }
    }
}

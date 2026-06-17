package defpackage;

import defpackage.ao;
import defpackage.z90;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fo implements z90 {
    public final ao a;
    public final long b;
    public final int c;
    public ja0 d;
    public long e;
    public File f;
    public OutputStream g;
    public long h;
    public long i;
    public qt3 j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends ao.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(IOException iOException) {
            super(iOException);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements z90.a {
        public ao a;
        public long b = 5242880;
        public int c = 20480;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z90.a
        public z90 a() {
            return new fo((ao) gg3.q(this.a), this.b, this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(ao aoVar) {
            this.a = aoVar;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo(ao aoVar, long j, int i) {
        gg3.w(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < 2097152) {
            xz1.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.a = (ao) gg3.q(aoVar);
        this.b = j == -1 ? Long.MAX_VALUE : j;
        this.c = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.z90
    public void a(ja0 ja0Var) throws a {
        gg3.q(ja0Var.i);
        if (ja0Var.h == -1 && ja0Var.d(2)) {
            this.d = null;
            return;
        }
        this.d = ja0Var;
        this.e = ja0Var.d(4) ? this.b : Long.MAX_VALUE;
        this.i = 0L;
        try {
            c(ja0Var);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            fy4.p(this.g);
            this.g = null;
            File file = (File) fy4.l(this.f);
            this.f = null;
            this.a.f(file, this.h);
        } catch (Throwable th) {
            fy4.p(this.g);
            this.g = null;
            File file2 = (File) fy4.l(this.f);
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(ja0 ja0Var) {
        long j = ja0Var.h;
        this.f = this.a.a((String) fy4.l(ja0Var.i), ja0Var.g + this.i, j != -1 ? Math.min(j - this.i, this.e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.c > 0) {
            qt3 qt3Var = this.j;
            if (qt3Var == null) {
                this.j = new qt3(fileOutputStream, this.c);
            } else {
                qt3Var.a(fileOutputStream);
            }
            this.g = this.j;
        } else {
            this.g = fileOutputStream;
        }
        this.h = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.z90
    public void close() throws a {
        if (this.d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.z90
    public void write(byte[] bArr, int i, int i2) throws a {
        ja0 ja0Var = this.d;
        if (ja0Var == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    b();
                    c(ja0Var);
                }
                int iMin = (int) Math.min(i2 - i3, this.e - this.h);
                ((OutputStream) fy4.l(this.g)).write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new a(e);
            }
        }
    }
}

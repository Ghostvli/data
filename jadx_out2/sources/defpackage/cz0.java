package defpackage;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.bz0;
import defpackage.mi2;
import defpackage.t41;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cz0 implements mi2 {
    public final Uri f;
    public final er4 g;
    public final byte[] h;
    public final AtomicBoolean i = new AtomicBoolean();
    public final AtomicReference j = new AtomicReference();
    public final ArrayList k = new ArrayList();
    public lu1 l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements gx3 {
        public int f = 0;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public void a() throws IOException {
            Throwable th = (Throwable) cz0.this.j.get();
            if (th != null) {
                throw new IOException(th);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b() {
            if (this.f == 2) {
                this.f = 1;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int e(long j) {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public boolean isReady() {
            return cz0.this.i.get();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2 = this.f;
            if (i2 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if ((i & 2) != 0 || i2 == 0) {
                u41Var.b = cz0.this.g.b(0).c(0);
                this.f = 1;
                return -5;
            }
            if (!cz0.this.i.get()) {
                return -3;
            }
            int length = cz0.this.h.length;
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.timeUs = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(length);
                decoderInputBuffer.data.put(cz0.this.h, 0, length);
            }
            if ((i & 1) == 0) {
                this.f = 2;
            }
            return -4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cz0(Uri uri, String str, bz0 bz0Var) {
        this.f = uri;
        this.g = new er4(new br4(new t41.b().A0(str).Q()));
        this.h = uri.toString().getBytes(StandardCharsets.UTF_8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        return !this.i.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return this.i.get() ? Long.MIN_VALUE : 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return this.i.get() ? Long.MIN_VALUE : 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return !this.i.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        for (int i = 0; i < jy0VarArr.length; i++) {
            gx3 gx3Var = gx3VarArr[i];
            if (gx3Var != null && (jy0VarArr[i] == null || !zArr[i])) {
                this.k.remove(gx3Var);
                gx3VarArr[i] = null;
            }
            if (gx3VarArr[i] == null && jy0VarArr[i] != null) {
                a aVar = new a();
                this.k.add(aVar);
                gx3VarArr[i] = aVar;
                zArr2[i] = true;
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        lu1 lu1Var = this.l;
        if (lu1Var != null) {
            lu1Var.cancel(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void m() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long n(long j) {
        for (int i = 0; i < this.k.size(); i++) {
            ((a) this.k.get(i)).b();
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long q() {
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        aVar.e(this);
        new bz0.a(this.f);
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public er4 s() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void t(long j, boolean z) {
    }
}

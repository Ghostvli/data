package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b74 implements fb0 {
    public final Thread a;
    public final DecoderInputBuffer[] e;
    public final androidx.media3.decoder.a[] f;
    public int g;
    public int h;
    public DecoderInputBuffer i;
    public ib0 j;
    public boolean k;
    public boolean l;
    public int m;
    public final Object b = new Object();
    public long n = -9223372036854775807L;
    public final ArrayDeque c = new ArrayDeque();
    public final ArrayDeque d = new ArrayDeque();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends Thread {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str) {
            super(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b74.this.v();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b74(DecoderInputBuffer[] decoderInputBufferArr, androidx.media3.decoder.a[] aVarArr) {
        this.e = decoderInputBufferArr;
        this.g = decoderInputBufferArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = i();
        }
        this.f = aVarArr;
        this.h = aVarArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f[i2] = j();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.a = aVar;
        aVar.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fb0
    public final void b(long j) {
        synchronized (this.b) {
            try {
                gg3.v(this.g == this.e.length || this.k);
                this.n = j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f(Ljava/lang/Object;)V */
    @Override // defpackage.fb0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void f(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.b) {
            r();
            gg3.d(decoderInputBuffer == this.i);
            this.c.addLast(decoderInputBuffer);
            q();
            this.i = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fb0
    public final void flush() {
        synchronized (this.b) {
            try {
                this.k = true;
                this.m = 0;
                DecoderInputBuffer decoderInputBuffer = this.i;
                if (decoderInputBuffer != null) {
                    s(decoderInputBuffer);
                    this.i = null;
                }
                while (!this.c.isEmpty()) {
                    s((DecoderInputBuffer) this.c.removeFirst());
                }
                while (!this.d.isEmpty()) {
                    ((androidx.media3.decoder.a) this.d.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h() {
        return !this.c.isEmpty() && this.h > 0;
    }

    public abstract DecoderInputBuffer i();

    public abstract androidx.media3.decoder.a j();

    public abstract ib0 k(Throwable th);

    public abstract ib0 l(DecoderInputBuffer decoderInputBuffer, androidx.media3.decoder.a aVar, boolean z);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m() {
        ib0 ib0VarK;
        synchronized (this.b) {
            while (!this.l && !h()) {
                try {
                    this.b.wait();
                } finally {
                }
            }
            if (this.l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.c.removeFirst();
            androidx.media3.decoder.a[] aVarArr = this.f;
            int i = this.h - 1;
            this.h = i;
            androidx.media3.decoder.a aVar = aVarArr[i];
            boolean z = this.k;
            this.k = false;
            if (decoderInputBuffer.isEndOfStream()) {
                aVar.addFlag(4);
            } else {
                aVar.timeUs = decoderInputBuffer.timeUs;
                if (decoderInputBuffer.isFirstSample()) {
                    aVar.addFlag(134217728);
                }
                if (!p(decoderInputBuffer.timeUs)) {
                    aVar.shouldBeSkipped = true;
                }
                try {
                    ib0VarK = l(decoderInputBuffer, aVar, z);
                } catch (OutOfMemoryError e) {
                    ib0VarK = k(e);
                } catch (RuntimeException e2) {
                    ib0VarK = k(e2);
                }
                if (ib0VarK != null) {
                    synchronized (this.b) {
                        this.j = ib0VarK;
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                try {
                    if (this.k) {
                        aVar.release();
                    } else {
                        boolean z2 = aVar.shouldBeSkipped;
                        int i2 = this.m;
                        if (z2) {
                            this.m = i2 + 1;
                            aVar.release();
                        } else {
                            aVar.skippedOutputBufferCount = i2;
                            this.m = 0;
                            this.d.addLast(aVar);
                        }
                    }
                    s(decoderInputBuffer);
                } finally {
                }
            }
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d()Ljava/lang/Object; */
    @Override // defpackage.fb0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final DecoderInputBuffer d() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.b) {
            r();
            gg3.v(this.i == null);
            int i = this.g;
            if (i == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.e;
                int i2 = i - 1;
                this.g = i2;
                decoderInputBuffer = decoderInputBufferArr[i2];
            }
            this.i = decoderInputBuffer;
        }
        return decoderInputBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a()Ljava/lang/Object; */
    @Override // defpackage.fb0
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final androidx.media3.decoder.a a() {
        synchronized (this.b) {
            try {
                r();
                if (this.d.isEmpty()) {
                    return null;
                }
                return (androidx.media3.decoder.a) this.d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p(long j) {
        boolean z;
        synchronized (this.b) {
            long j2 = this.n;
            z = j2 == -9223372036854775807L || j >= j2;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        if (h()) {
            this.b.notify();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r() throws ib0 {
        ib0 ib0Var = this.j;
        if (ib0Var != null) {
            throw ib0Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fb0
    public void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.clear();
        DecoderInputBuffer[] decoderInputBufferArr = this.e;
        int i = this.g;
        this.g = i + 1;
        decoderInputBufferArr[i] = decoderInputBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(androidx.media3.decoder.a aVar) {
        synchronized (this.b) {
            u(aVar);
            q();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(androidx.media3.decoder.a aVar) {
        aVar.clear();
        androidx.media3.decoder.a[] aVarArr = this.f;
        int i = this.h;
        this.h = i + 1;
        aVarArr[i] = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (m());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(int i) {
        gg3.v(this.g == this.e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.e) {
            decoderInputBuffer.ensureSpaceForWrite(i);
        }
    }
}

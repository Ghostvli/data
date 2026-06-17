package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xy1 implements bz1 {
    public static final c d = h(false, -9223372036854775807L);
    public static final c e = h(true, -9223372036854775807L);
    public static final c f;
    public static final c g;
    public final eq3 a;
    public d b;
    public IOException c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void j(e eVar, long j, long j2, boolean z);

        void l(e eVar, long j, long j2);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void p(e eVar, long j, long j2, int i) {
        }

        c v(e eVar, long j, long j2, IOException iOException, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, long j) {
            this.a = i;
            this.b = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c() {
            int i = this.a;
            return i == 0 || i == 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d extends Handler implements Runnable {
        public final int f;
        public final e g;
        public final long h;
        public b i;
        public IOException j;
        public int k;
        public Thread l;
        public boolean m;
        public volatile boolean n;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Looper looper, e eVar, b bVar, int i, long j) {
            super(looper);
            this.g = eVar;
            this.i = bVar;
            this.f = i;
            this.h = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(boolean z) {
            this.n = z;
            this.j = null;
            if (hasMessages(1)) {
                this.m = true;
                removeMessages(1);
                if (!z) {
                    sendEmptyMessage(2);
                }
            } else {
                synchronized (this) {
                    try {
                        this.m = true;
                        this.g.c();
                        Thread thread = this.l;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) gg3.q(this.i)).j(this.g, jElapsedRealtime, jElapsedRealtime - this.h, true);
                this.i = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ((b) gg3.q(this.i)).p(this.g, jElapsedRealtime, jElapsedRealtime - this.h, this.k);
            this.j = null;
            xy1.this.a.execute((Runnable) gg3.q(xy1.this.b));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c() {
            xy1.this.b = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long d() {
            return Math.min((this.k - 1) * 1000, 5000);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(int i) throws IOException {
            IOException iOException = this.j;
            if (iOException != null && this.k > i) {
                throw iOException;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(long j) {
            gg3.v(xy1.this.b == null);
            xy1.this.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(1, j);
            } else {
                b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.n) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                b();
                return;
            }
            if (i == 4) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.h;
            b bVar = (b) gg3.q(this.i);
            if (this.m) {
                bVar.j(this.g, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 2) {
                try {
                    bVar.l(this.g, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    xz1.e("LoadTask", "Unexpected exception handling load completed", e);
                    xy1.this.c = new h(e);
                    return;
                }
            }
            if (i2 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.j = iOException;
            int i3 = this.k + 1;
            this.k = i3;
            c cVarV = bVar.v(this.g, jElapsedRealtime, j, iOException, i3);
            if (cVarV.a == 3) {
                xy1.this.c = this.j;
            } else if (cVarV.a != 2) {
                if (cVarV.a == 1) {
                    this.k = 1;
                }
                f(cVarV.b != -9223372036854775807L ? cVarV.b : d());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = this.m;
                    this.l = Thread.currentThread();
                }
                if (!z) {
                    hq4.a("load:".concat(this.g.getClass().getSimpleName()));
                    try {
                        this.g.b();
                        hq4.b();
                    } catch (Throwable th) {
                        hq4.b();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.l = null;
                    Thread.interrupted();
                }
                if (this.n) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e) {
                if (this.n) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (Exception e2) {
                if (this.n) {
                    return;
                }
                xz1.e("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(3, new h(e2)).sendToTarget();
            } catch (OutOfMemoryError e3) {
                if (this.n) {
                    return;
                }
                xz1.e("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(3, new h(e3)).sendToTarget();
            } catch (Error e4) {
                if (!this.n) {
                    xz1.e("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void b();

        void c();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        void i();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g implements Runnable {
        public final f f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(f fVar) {
            this.f = fVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            this.f.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends IOException {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(Throwable th) {
            String str;
            StringBuilder sb = new StringBuilder("Unexpected ");
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                str = ": " + th.getMessage();
            } else {
                str = "";
            }
            sb.append(str);
            super(sb.toString(), th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        long j = -9223372036854775807L;
        f = new c(2, j);
        g = new c(3, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xy1(String str) {
        this(eq3.L(fy4.d1("ExoPlayer:Loader:" + str), new g20() { // from class: wy1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                ((ExecutorService) obj).shutdown();
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c h(boolean z, long j) {
        return new c(z ? 1 : 0, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bz1
    public void a() throws IOException {
        k(Integer.MIN_VALUE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        ((d) gg3.q(this.b)).a(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        this.c = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i() {
        return this.c != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j() {
        return this.b != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        d dVar = this.b;
        if (dVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = dVar.f;
            }
            dVar.e(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        m(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(f fVar) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.a.execute(new g(fVar));
        }
        this.a.release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long n(e eVar, b bVar, int i) {
        Looper looper = (Looper) gg3.q(Looper.myLooper());
        this.c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, eVar, bVar, i, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }

    public xy1(eq3 eq3Var) {
        this.a = eq3Var;
    }
}

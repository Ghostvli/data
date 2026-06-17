package defpackage;

import android.media.MediaFormat;
import android.view.Surface;
import defpackage.d35;
import defpackage.p25;
import defpackage.t41;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class aj0 implements d35 {
    public final l25 a;
    public final m25 b;
    public final p25 c;
    public final Queue d;
    public Surface e;
    public t41 f;
    public long g;
    public d35.a h;
    public Executor i;
    public j25 j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements p25.a {
        public t41 a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // p25.a
        public void a() {
            aj0.this.i.execute(new Runnable() { // from class: cj0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    aj0.this.h.b();
                }
            });
            ((d35.b) aj0.this.d.remove()).skip();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // p25.a
        public void b(long j, long j2, boolean z) {
            if (z && aj0.this.e != null) {
                aj0.this.i.execute(new Runnable() { // from class: bj0
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        aj0.this.h.a();
                    }
                });
            }
            t41 t41VarQ = this.a;
            if (t41VarQ == null) {
                t41VarQ = new t41.b().Q();
            }
            aj0.this.j.h(j2, j, t41VarQ, null);
            ((d35.b) aj0.this.d.remove()).a(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // p25.a
        public void onVideoSizeChanged(final e35 e35Var) {
            this.a = new t41.b().H0(e35Var.a).i0(e35Var.b).A0("video/raw").Q();
            aj0.this.i.execute(new Runnable() { // from class: dj0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    aj0.this.h.onVideoSizeChanged(e35Var);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public aj0(l25 l25Var, m25 m25Var, zu zuVar) {
        this.a = l25Var;
        this.b = m25Var;
        l25Var.m(zuVar);
        this.c = new p25(new b(), l25Var, m25Var);
        this.d = new ArrayDeque();
        this.f = new t41.b().Q();
        this.g = -9223372036854775807L;
        this.h = d35.a.a;
        this.i = new Executor() { // from class: xi0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                aj0.a(runnable);
            }
        };
        this.j = new j25() { // from class: yi0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.j25
            public final void h(long j, long j2, t41 t41Var, MediaFormat mediaFormat) {
                aj0.x(j, j2, t41Var, mediaFormat);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Runnable runnable) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void x(long j, long j2, t41 t41Var, MediaFormat mediaFormat) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public boolean b() {
        return this.c.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void c(long j, long j2) throws d35.c {
        try {
            this.c.j(j, j2);
        } catch (zv0 e) {
            throw new d35.c(e, this.f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public Surface d() {
        return (Surface) gg3.q(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void e(Surface surface, d94 d94Var) {
        this.e = surface;
        this.a.o(surface);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public boolean f(long j, d35.b bVar) {
        this.d.add(bVar);
        this.c.g(j);
        this.i.execute(new Runnable() { // from class: zi0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.h.c();
            }
        });
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void g() {
        this.b.d();
        this.a.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void h() {
        this.b.d();
        this.a.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void i(long j) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public boolean isInitialized() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void j() {
        this.c.l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void k(int i) {
        this.a.l(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void l() {
        this.e = null;
        this.a.o(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public boolean m(t41 t41Var) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void n(boolean z) {
        if (z) {
            this.a.k();
        }
        this.b.d();
        this.c.b();
        this.d.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void o(List list) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void p(boolean z) {
        this.a.e(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public boolean q(boolean z) {
        return this.a.d(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void r(int i, t41 t41Var, long j, int i2, List list) {
        gg3.v(list.isEmpty());
        int i3 = t41Var.w;
        t41 t41Var2 = this.f;
        if (i3 != t41Var2.w || t41Var.x != t41Var2.x) {
            this.c.i(i3, t41Var.x);
        }
        float f = t41Var.A;
        if (f != this.f.A) {
            this.a.n(f);
        }
        this.f = t41Var;
        if (j != this.g) {
            this.c.h(i2, j);
            this.g = j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void release() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void s(d35.a aVar, Executor executor) {
        this.h = aVar;
        this.i = executor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void setPlaybackSpeed(float f) {
        this.a.p(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void t(j25 j25Var) {
        this.j = j25Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void u() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d35
    public void v() {
        this.a.a();
    }
}

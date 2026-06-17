package defpackage;

import defpackage.l25;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class p25 {
    public final a a;
    public final l25 b;
    public final m25 g;
    public long l;
    public final l25.a c = new l25.a();
    public final ko4 d = new ko4();
    public final ko4 e = new ko4();
    public final t02 f = new t02();
    public long h = -9223372036854775807L;
    public e35 k = e35.e;
    public long i = -9223372036854775807L;
    public long j = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a();

        void b(long j, long j2, boolean z);

        void onVideoSizeChanged(e35 e35Var);
    }

    public p25(a aVar, l25 l25Var, m25 m25Var) {
        this.a = aVar;
        this.b = l25Var;
        this.g = m25Var;
    }

    public static Object c(ko4 ko4Var) {
        gg3.d(ko4Var.l() > 0);
        while (ko4Var.l() > 1) {
            ko4Var.i();
        }
        return gg3.q(ko4Var.i());
    }

    public final void a() {
        this.f.f();
        this.a.a();
    }

    public void b() {
        this.f.b();
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.j = -9223372036854775807L;
        if (this.e.l() > 0) {
            this.l = ((Long) c(this.e)).longValue();
        }
        if (this.d.l() > 0) {
            this.d.a(0L, (e35) c(this.d));
        }
    }

    public boolean d() {
        long j = this.j;
        return j != -9223372036854775807L && this.i == j;
    }

    public final boolean e(long j) {
        Long l = (Long) this.e.j(j);
        if (l == null || l.longValue() == this.l) {
            return false;
        }
        this.l = l.longValue();
        return true;
    }

    public final boolean f(long j) {
        e35 e35Var = (e35) this.d.j(j);
        if (e35Var == null || e35Var.equals(e35.e) || e35Var.equals(this.k)) {
            return false;
        }
        this.k = e35Var;
        return true;
    }

    public void g(long j) {
        this.f.a(j);
        this.h = j;
        this.j = -9223372036854775807L;
    }

    public void h(int i, long j) {
        if (this.f.e()) {
            this.b.j(i);
            this.l = j;
        } else {
            ko4 ko4Var = this.e;
            long j2 = this.h;
            ko4Var.a(j2 == -9223372036854775807L ? -4611686018427387904L : j2 + 1, Long.valueOf(j));
        }
    }

    public void i(int i, int i2) {
        ko4 ko4Var = this.d;
        long j = this.h;
        ko4Var.a(j == -9223372036854775807L ? 0L : j + 1, new e35(i, i2));
    }

    public void j(long j, long j2) {
        while (!this.f.e()) {
            long jD = this.f.d();
            if (e(jD)) {
                this.b.j(2);
            }
            int iC = this.b.c(jD, j, j2, this.l, false, false, this.c);
            if (iC != 5 && iC != 4) {
                this.g.b(jD, this.c.f());
            }
            if (iC == 0 || iC == 1) {
                this.i = jD;
                k(iC == 0);
            } else if (iC == 2 || iC == 3) {
                this.i = jD;
                a();
            } else {
                if (iC != 4) {
                    if (iC == 5) {
                        return;
                    }
                    e04.a(String.valueOf(iC));
                    return;
                }
                this.i = jD;
            }
        }
    }

    public final void k(boolean z) {
        long jF = this.f.f();
        if (f(jF)) {
            this.a.onVideoSizeChanged(this.k);
        }
        this.a.b(z ? zu.a.nanoTime() : this.c.g(), jF, this.b.g());
    }

    public void l() {
        if (this.h == -9223372036854775807L) {
            this.h = Long.MIN_VALUE;
            this.i = Long.MIN_VALUE;
        }
        this.j = this.h;
    }
}

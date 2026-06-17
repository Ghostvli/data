package defpackage;

import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tj {
    public final a a;
    public final f b;
    public c c;
    public final int d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements yz3 {
        public final d a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = dVar;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        @Override // defpackage.yz3
        public boolean e() {
            return true;
        }

        @Override // defpackage.yz3
        public yz3.a g(long j) {
            return new yz3.a(new a04(j, c.h(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // defpackage.yz3
        public long i() {
            return this.b;
        }

        public long n(long j) {
            return this.a.a(j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements d {
        @Override // tj.d
        public long a(long j) {
            return j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final long a;
        public final long b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = h(j2, j3, j4, j5, j6, j7);
        }

        public static long h(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return fy4.t(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        public final long i() {
            return this.g;
        }

        public final long j() {
            return this.f;
        }

        public final long k() {
            return this.h;
        }

        public final long l() {
            return this.a;
        }

        public final long m() {
            return this.b;
        }

        public final void n() {
            this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        public final void o(long j, long j2) {
            this.e = j;
            this.g = j2;
            n();
        }

        public final void p(long j, long j2) {
            this.d = j;
            this.f = j2;
            n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        long a(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public static final e d = new e(-3, -9223372036854775807L, -1);
        public final int a;
        public final long b;
        public final long c;

        public e(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static e d(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e e(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e f(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        e a(jz0 jz0Var, long j);

        default void b() {
        }
    }

    public tj(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.b = fVar;
        this.d = i;
        this.a = new a(dVar, j, j2, j3, j4, j5, j6);
    }

    public c a(long j) {
        return new c(j, this.a.n(j), this.a.c, this.a.d, this.a.e, this.a.f, this.a.g);
    }

    public final yz3 b() {
        return this.a;
    }

    public int c(jz0 jz0Var, yf3 yf3Var) {
        while (true) {
            c cVar = (c) gg3.q(this.c);
            long j = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j <= this.d) {
                e(false, j);
                return g(jz0Var, j, yf3Var);
            }
            if (!i(jz0Var, jK)) {
                return g(jz0Var, jK, yf3Var);
            }
            jz0Var.p();
            e eVarA = this.b.a(jz0Var, cVar.m());
            int i = eVarA.a;
            if (i == -3) {
                e(false, jK);
                return g(jz0Var, jK, yf3Var);
            }
            if (i == -2) {
                cVar.p(eVarA.b, eVarA.c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        e04.a("Invalid case");
                        return 0;
                    }
                    i(jz0Var, eVarA.c);
                    e(true, eVarA.c);
                    return g(jz0Var, eVarA.c, yf3Var);
                }
                cVar.o(eVarA.b, eVarA.c);
            }
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e(boolean z, long j) {
        this.c = null;
        this.b.b();
        f(z, j);
    }

    public void f(boolean z, long j) {
    }

    public final int g(jz0 jz0Var, long j, yf3 yf3Var) {
        if (j == jz0Var.getPosition()) {
            return 0;
        }
        yf3Var.a = j;
        return 1;
    }

    public final void h(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.l() != j) {
            this.c = a(j);
        }
    }

    public final boolean i(jz0 jz0Var, long j) {
        long position = j - jz0Var.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        jz0Var.q((int) position);
        return true;
    }
}

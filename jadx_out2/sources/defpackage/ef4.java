package defpackage;

import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ef4 {
    public gr4 b;
    public mz0 c;
    public h53 d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public long k;
    public boolean l;
    public boolean m;
    public final f53 a = new f53();
    public b j = new b();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public t41 a;
        public h53 b;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements h53 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h53
        public long a(jz0 jz0Var) {
            return -1L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h53
        public yz3 b() {
            return new yz3.b(-9223372036854775807L);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h53
        public void c(long j) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        gg3.q(this.b);
        fy4.l(this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long b(long j) {
        return (j * 1000000) / ((long) this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long c(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(mz0 mz0Var, gr4 gr4Var) {
        this.c = mz0Var;
        this.b = gr4Var;
        l(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(long j) {
        this.g = j;
    }

    public abstract long f(r73 r73Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int g(jz0 jz0Var, yf3 yf3Var) {
        a();
        int i = this.h;
        if (i == 0) {
            return j(jz0Var);
        }
        if (i == 1) {
            jz0Var.q((int) this.f);
            this.h = 2;
            return 0;
        }
        if (i == 2) {
            fy4.l(this.d);
            return k(jz0Var, yf3Var);
        }
        if (i == 3) {
            return -1;
        }
        z20.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h(jz0 jz0Var) {
        while (this.a.d(jz0Var)) {
            this.k = jz0Var.getPosition() - this.f;
            if (!i(this.a.c(), this.f, this.j)) {
                return true;
            }
            this.f = jz0Var.getPosition();
        }
        this.h = 3;
        return false;
    }

    public abstract boolean i(r73 r73Var, long j, b bVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int j(jz0 jz0Var) {
        if (!h(jz0Var)) {
            return -1;
        }
        t41 t41Var = this.j.a;
        this.i = t41Var.I;
        if (!this.m) {
            this.b.g(t41Var);
            this.m = true;
        }
        h53 h53Var = this.j.b;
        if (h53Var != null) {
            this.d = h53Var;
        } else if (jz0Var.getLength() == -1) {
            this.d = new c();
        } else {
            g53 g53VarB = this.a.b();
            this.d = new wg0(this, this.f, jz0Var.getLength(), g53VarB.h + g53VarB.i, g53VarB.c, (g53VarB.b & 4) != 0);
        }
        this.h = 2;
        this.a.f();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int k(jz0 jz0Var, yf3 yf3Var) {
        long jA = this.d.a(jz0Var);
        if (jA >= 0) {
            yf3Var.a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.l) {
            yz3 yz3Var = (yz3) gg3.q(this.d.b());
            this.c.u(yz3Var);
            this.b.e(yz3Var.i());
            this.l = true;
        }
        if (this.k <= 0 && !this.a.d(jz0Var)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        r73 r73VarC = this.a.c();
        long jF = f(r73VarC);
        if (jF >= 0) {
            long j = this.g;
            if (j + jF >= this.e) {
                long jB = b(j);
                this.b.a(r73VarC, r73VarC.j());
                this.b.b(jB, 1, r73VarC.j(), 0, null);
                this.e = -1L;
            }
        }
        this.g += jF;
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(boolean z) {
        if (z) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(long j, long j2) {
        this.a.e();
        if (j == 0) {
            l(!this.l);
        } else if (this.h != 0) {
            this.e = c(j2);
            ((h53) fy4.l(this.d)).c(this.e);
            this.h = 2;
        }
    }
}

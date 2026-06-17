package defpackage;

import defpackage.yz3;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wg0 implements h53 {
    public final g53 a;
    public final long b;
    public final long c;
    public final ef4 d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements yz3 {
        public b() {
        }

        @Override // defpackage.yz3
        public boolean e() {
            return true;
        }

        @Override // defpackage.yz3
        public yz3.a g(long j) {
            return new yz3.a(new a04(j, fy4.t((wg0.this.b + BigInteger.valueOf(wg0.this.d.c(j)).multiply(BigInteger.valueOf(wg0.this.c - wg0.this.b)).divide(BigInteger.valueOf(wg0.this.f)).longValue()) - 30000, wg0.this.b, wg0.this.c - 1)));
        }

        @Override // defpackage.yz3
        public long i() {
            return wg0.this.d.b(wg0.this.f);
        }
    }

    public wg0(ef4 ef4Var, long j, long j2, long j3, long j4, boolean z) {
        gg3.d(j >= 0 && j2 > j);
        this.d = ef4Var;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new g53();
    }

    @Override // defpackage.h53
    public long a(jz0 jz0Var) throws IOException {
        int i = this.e;
        if (i == 0) {
            long position = jz0Var.getPosition();
            this.g = position;
            this.e = 1;
            long j = this.c - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long jI = i(jz0Var);
                if (jI != -1) {
                    return jI;
                }
                this.e = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                z20.a();
                return 0L;
            }
            k(jz0Var);
            this.e = 4;
            return -(this.k + 2);
        }
        this.f = j(jz0Var);
        this.e = 4;
        return this.g;
    }

    @Override // defpackage.h53
    public void c(long j) {
        this.h = fy4.t(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }

    @Override // defpackage.h53
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f != 0) {
            return new b();
        }
        return null;
    }

    public final long i(jz0 jz0Var) throws IOException {
        if (this.i == this.j) {
            return -1L;
        }
        long position = jz0Var.getPosition();
        if (!this.a.d(jz0Var, this.j)) {
            long j = this.i;
            if (j != position) {
                return j;
            }
            sb1.a("No ogg page can be found.");
            return 0L;
        }
        this.a.a(jz0Var, false);
        jz0Var.p();
        long j2 = this.h;
        g53 g53Var = this.a;
        long j3 = g53Var.c;
        long j4 = j2 - j3;
        int i = g53Var.h + g53Var.i;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.j = position;
            this.l = j3;
        } else {
            this.i = jz0Var.getPosition() + ((long) i);
            this.k = this.a.c;
        }
        long j5 = this.j;
        long j6 = this.i;
        if (j5 - j6 < 100000) {
            this.j = j6;
            return j6;
        }
        long position2 = jz0Var.getPosition() - (((long) i) * (j4 <= 0 ? 2L : 1L));
        long j7 = this.j;
        long j8 = this.i;
        return fy4.t(position2 + ((j4 * (j7 - j8)) / (this.l - this.k)), j8, j7 - 1);
    }

    public long j(jz0 jz0Var) throws r83, EOFException {
        this.a.b();
        if (!this.a.c(jz0Var)) {
            ll.a();
            return 0L;
        }
        this.a.a(jz0Var, false);
        g53 g53Var = this.a;
        jz0Var.q(g53Var.h + g53Var.i);
        long j = this.a.c;
        while (true) {
            g53 g53Var2 = this.a;
            if ((g53Var2.b & 4) == 4 || !g53Var2.c(jz0Var) || jz0Var.getPosition() >= this.c || !this.a.a(jz0Var, true)) {
                break;
            }
            g53 g53Var3 = this.a;
            if (!nz0.f(jz0Var, g53Var3.h + g53Var3.i)) {
                break;
            }
            j = this.a.c;
        }
        return j;
    }

    public final void k(jz0 jz0Var) throws r83 {
        while (true) {
            this.a.c(jz0Var);
            this.a.a(jz0Var, false);
            g53 g53Var = this.a;
            if (g53Var.c > this.h) {
                jz0Var.p();
                return;
            } else {
                jz0Var.q(g53Var.h + g53Var.i);
                this.i = jz0Var.getPosition();
                this.k = this.a.c;
            }
        }
    }
}

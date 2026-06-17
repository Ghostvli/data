package defpackage;

import defpackage.ki4;
import defpackage.t41;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ed1 implements hz0 {
    public mz0 b;
    public iu2 c;
    public jz0 d;
    public wd4 e;
    public yu2 f;
    public int h;
    public long i;
    public int j;
    public final r73 a = new r73(16);
    public long k = -1;
    public int g = 0;

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        if (j != 0) {
            if (this.g == 3) {
                ((yu2) gg3.q(this.f)).a(j, j2);
                return;
            }
            return;
        }
        this.g = 0;
        this.j = 0;
        this.k = -1L;
        yu2 yu2Var = this.f;
        if (yu2Var != null) {
            yu2Var.release();
            this.f = null;
        }
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.b = mz0Var;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        while (true) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    j(jz0Var);
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            return k(jz0Var, yf3Var);
                        }
                        if (i == 4) {
                            return -1;
                        }
                        z20.a();
                        return 0;
                    }
                    l(jz0Var);
                }
            } else if (!i(jz0Var)) {
                g();
                return -1;
            }
        }
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return gd1.a(jz0Var, true);
    }

    public final void g() {
        ((mz0) gg3.q(this.b)).o();
        this.b.u(new yz3.b(-9223372036854775807L));
        this.g = 4;
    }

    public final void h(iu2 iu2Var) {
        ((mz0) gg3.q(this.b)).e(1024, 4).g(new t41.b().X("image/heic").s0(new xs2(iu2Var)).Q());
    }

    public final boolean i(jz0 jz0Var) {
        if (this.j == 0) {
            if (!jz0Var.d(this.a.f(), 0, 8, true)) {
                return false;
            }
            this.j = 8;
            this.a.f0(0);
            this.i = this.a.S();
            this.h = this.a.z();
        }
        if (this.i == 1) {
            jz0Var.readFully(this.a.f(), 8, 8);
            this.j += 8;
            this.i = this.a.X();
        }
        if (this.h == 1836086884) {
            long position = jz0Var.getPosition();
            this.k = position;
            int i = this.j;
            iu2 iu2Var = new iu2(0L, position - ((long) i), -9223372036854775807L, position, this.i - ((long) i));
            this.c = iu2Var;
            h(iu2Var);
            this.g = 2;
        } else {
            this.g = 1;
        }
        return true;
    }

    public final void j(jz0 jz0Var) {
        jz0Var.q((int) (this.i - ((long) this.j)));
        this.j = 0;
        this.g = 0;
    }

    public final int k(jz0 jz0Var, yf3 yf3Var) {
        if (this.e == null || jz0Var != this.d) {
            this.d = jz0Var;
            this.e = new wd4(jz0Var, this.k);
        }
        int iD = ((yu2) gg3.q(this.f)).d(this.e, yf3Var);
        if (iD == 1) {
            yf3Var.a += this.k;
        }
        return iD;
    }

    public final void l(jz0 jz0Var) {
        if (this.f == null) {
            this.f = new yu2(ki4.a.a, 8);
        }
        wd4 wd4Var = new wd4(jz0Var, this.k);
        this.e = wd4Var;
        if (!this.f.e(wd4Var)) {
            g();
        } else {
            this.f.b(new xd4(this.k, (mz0) gg3.q(this.b)));
            this.g = 3;
        }
    }

    @Override // defpackage.hz0
    public void release() {
        yu2 yu2Var = this.f;
        if (yu2Var != null) {
            yu2Var.release();
            this.f = null;
        }
    }
}

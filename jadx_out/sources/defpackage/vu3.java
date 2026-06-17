package defpackage;

import android.os.SystemClock;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vu3 implements hz0 {
    public final gv3 a;
    public final int d;
    public mz0 g;
    public boolean h;
    public boolean k;
    public final r73 b = new r73(65507);
    public final r73 c = new r73();
    public final Object e = new Object();
    public final ev3 f = new ev3();
    public volatile long i = -9223372036854775807L;
    public volatile int j = -1;
    public long l = -9223372036854775807L;
    public long m = -9223372036854775807L;

    public vu3(fv3 fv3Var, int i) {
        this.d = i;
        this.a = (gv3) gg3.q(new dh0().a(fv3Var));
    }

    public static long g(long j) {
        return j - 30;
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        synchronized (this.e) {
            try {
                if (!this.k) {
                    this.k = true;
                }
                this.l = j;
                this.m = j2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a.b(mz0Var, this.d);
        mz0Var.o();
        mz0Var.u(new yz3.b(-9223372036854775807L));
        this.g = mz0Var;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        gg3.q(this.g);
        int i = jz0Var.read(this.b.f(), 0, 65507);
        if (i == -1) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        this.b.f0(0);
        this.b.e0(i);
        cv3 cv3VarD = cv3.d(this.b);
        if (cv3VarD == null) {
            return 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jG = g(jElapsedRealtime);
        this.f.d(cv3VarD, jElapsedRealtime);
        cv3 cv3VarE = this.f.e(jG);
        if (cv3VarE == null) {
            return 0;
        }
        if (!this.h) {
            if (this.i == -9223372036854775807L) {
                this.i = cv3VarE.h;
            }
            if (this.j == -1) {
                this.j = cv3VarE.g;
            }
            this.a.c(this.i, this.j);
            this.h = true;
        }
        synchronized (this.e) {
            try {
                if (!this.k) {
                    do {
                        this.c.c0(cv3VarE.k);
                        this.a.d(this.c, cv3VarE.h, cv3VarE.g, cv3VarE.e);
                        cv3VarE = this.f.e(jG);
                    } while (cv3VarE != null);
                } else if (this.l != -9223372036854775807L && this.m != -9223372036854775807L) {
                    this.f.f();
                    this.a.a(this.l, this.m);
                    this.k = false;
                    this.l = -9223372036854775807L;
                    this.m = -9223372036854775807L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public boolean h() {
        return this.h;
    }

    public void i() {
        synchronized (this.e) {
            this.k = true;
        }
    }

    public void j(int i) {
        this.j = i;
    }

    public void k(long j) {
        this.i = j;
    }

    @Override // defpackage.hz0
    public void release() {
    }
}

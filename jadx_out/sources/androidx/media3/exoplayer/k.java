package androidx.media3.exoplayer;

import defpackage.er4;
import defpackage.gg3;
import defpackage.gx3;
import defpackage.is0;
import defpackage.j5;
import defpackage.jq2;
import defpackage.jy0;
import defpackage.mi2;
import defpackage.ni2;
import defpackage.no4;
import defpackage.or4;
import defpackage.pr4;
import defpackage.wu;
import defpackage.xz1;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final mi2 a;
    public final Object b;
    public final gx3[] c;
    public final long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public ni2 h;
    public boolean i;
    public final boolean[] j;
    public final p[] k;
    public final or4 l;
    public final m m;
    public k n;
    public er4 o;
    public pr4 p;
    public long q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        k a(ni2 ni2Var, long j);
    }

    public k(p[] pVarArr, long j, or4 or4Var, j5 j5Var, m mVar, ni2 ni2Var, pr4 pr4Var, long j2) {
        this.k = pVarArr;
        this.q = j;
        this.l = or4Var;
        this.m = mVar;
        jq2.b bVar = ni2Var.a;
        this.b = bVar.a;
        this.h = ni2Var;
        this.d = j2;
        this.o = er4.d;
        this.p = pr4Var;
        this.c = new gx3[pVarArr.length];
        this.j = new boolean[pVarArr.length];
        this.a = f(bVar, mVar, j5Var, ni2Var.b, ni2Var.e, ni2Var.g);
    }

    public static mi2 f(jq2.b bVar, m mVar, j5 j5Var, long j, long j2, boolean z) {
        mi2 mi2VarH = mVar.h(bVar, j5Var, j);
        return j2 != -9223372036854775807L ? new wu(mi2VarH, !z, 0L, j2) : mi2VarH;
    }

    public static void y(m mVar, mi2 mi2Var) {
        try {
            if (mi2Var instanceof wu) {
                mVar.z(((wu) mi2Var).f);
            } else {
                mVar.z(mi2Var);
            }
        } catch (RuntimeException e) {
            xz1.e("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public void A(k kVar) {
        if (kVar == this.n) {
            return;
        }
        g();
        this.n = kVar;
        i();
    }

    public void B(long j) {
        this.q = j;
    }

    public long C(long j) {
        return j - m();
    }

    public long D(long j) {
        return j + m();
    }

    public void E() {
        mi2 mi2Var = this.a;
        if (mi2Var instanceof wu) {
            long j = this.h.e;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((wu) mi2Var).B(0L, j);
        }
    }

    public long a(pr4 pr4Var, long j, boolean z) {
        return b(pr4Var, j, z, new boolean[this.k.length]);
    }

    public long b(pr4 pr4Var, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= pr4Var.a) {
                break;
            }
            boolean[] zArr2 = this.j;
            if (z || !pr4Var.b(this.p, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        h(this.c);
        g();
        this.p = pr4Var;
        i();
        long jK = this.a.k(pr4Var.c, this.j, this.c, zArr, j);
        c(this.c);
        this.g = false;
        int i2 = 0;
        while (true) {
            gx3[] gx3VarArr = this.c;
            if (i2 >= gx3VarArr.length) {
                return jK;
            }
            if (gx3VarArr[i2] != null) {
                gg3.v(pr4Var.c(i2));
                if (this.k[i2].d() != -2) {
                    this.g = true;
                }
            } else {
                gg3.v(pr4Var.c[i2] == null);
            }
            i2++;
        }
    }

    public final void c(gx3[] gx3VarArr) {
        int i = 0;
        while (true) {
            p[] pVarArr = this.k;
            if (i >= pVarArr.length) {
                return;
            }
            if (pVarArr[i].d() == -2 && this.p.c(i)) {
                gx3VarArr[i] = new is0();
            }
            i++;
        }
    }

    public boolean d(ni2 ni2Var) {
        if (!l.e(this.h.f, ni2Var.f)) {
            return false;
        }
        ni2 ni2Var2 = this.h;
        return ni2Var2.b == ni2Var.b && ni2Var2.a.equals(ni2Var.a);
    }

    public void e(j jVar) {
        gg3.v(u());
        this.a.b(jVar);
    }

    public final void g() {
        if (!u()) {
            return;
        }
        int i = 0;
        while (true) {
            pr4 pr4Var = this.p;
            if (i >= pr4Var.a) {
                return;
            }
            boolean zC = pr4Var.c(i);
            jy0 jy0Var = this.p.c[i];
            if (zC && jy0Var != null) {
                jy0Var.disable();
            }
            i++;
        }
    }

    public final void h(gx3[] gx3VarArr) {
        int i = 0;
        while (true) {
            p[] pVarArr = this.k;
            if (i >= pVarArr.length) {
                return;
            }
            if (pVarArr[i].d() == -2) {
                gx3VarArr[i] = null;
            }
            i++;
        }
    }

    public final void i() {
        if (!u()) {
            return;
        }
        int i = 0;
        while (true) {
            pr4 pr4Var = this.p;
            if (i >= pr4Var.a) {
                return;
            }
            boolean zC = pr4Var.c(i);
            jy0 jy0Var = this.p.c[i];
            if (zC && jy0Var != null) {
                jy0Var.enable();
            }
            i++;
        }
    }

    public long j() {
        if (!this.f) {
            return this.h.b;
        }
        long jF = this.g ? this.a.f() : Long.MIN_VALUE;
        return jF == Long.MIN_VALUE ? this.h.f : jF;
    }

    public k k() {
        return this.n;
    }

    public long l() {
        if (this.f) {
            return this.a.c();
        }
        return 0L;
    }

    public long m() {
        return this.q;
    }

    public long n() {
        return this.h.b + this.q;
    }

    public er4 o() {
        return this.o;
    }

    public pr4 p() {
        return this.p;
    }

    public void q(float f, no4 no4Var, boolean z) {
        this.f = true;
        this.o = this.a.s();
        pr4 pr4VarZ = z(f, no4Var, z);
        ni2 ni2Var = this.h;
        long jMax = ni2Var.b;
        long j = ni2Var.f;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jA = a(pr4VarZ, jMax, false);
        long j2 = this.q;
        ni2 ni2Var2 = this.h;
        this.q = j2 + (ni2Var2.b - jA);
        this.h = ni2Var2.b(jA, ni2Var2.c);
    }

    public boolean r() {
        try {
            if (this.f) {
                for (gx3 gx3Var : this.c) {
                    if (gx3Var != null) {
                        gx3Var.a();
                    }
                }
            } else {
                this.a.m();
            }
            return false;
        } catch (IOException unused) {
            return true;
        }
    }

    public boolean s() {
        if (this.f) {
            return !this.g || this.a.f() == Long.MIN_VALUE;
        }
        return false;
    }

    public boolean t() {
        if (this.f) {
            return s() || j() - this.h.b >= this.d;
        }
        return false;
    }

    public final boolean u() {
        return this.n == null;
    }

    public void v(mi2.a aVar, long j) {
        this.e = true;
        this.a.r(aVar, j);
    }

    public void w(long j) {
        gg3.v(u());
        if (this.f) {
            this.a.g(C(j));
        }
    }

    public void x() {
        g();
        y(this.m, this.a);
    }

    public pr4 z(float f, no4 no4Var, boolean z) {
        pr4 pr4VarK = this.l.k(this.k, o(), this.h.a, no4Var);
        for (int i = 0; i < pr4VarK.a; i++) {
            boolean zC = pr4VarK.c(i);
            jy0[] jy0VarArr = pr4VarK.c;
            if (zC) {
                if (jy0VarArr[i] == null && this.k[i].d() != -2) {
                    z = false;
                }
                gg3.v(z);
            } else {
                gg3.v(jy0VarArr[i] == null);
            }
        }
        for (jy0 jy0Var : pr4VarK.c) {
            if (jy0Var != null) {
                jy0Var.o(f);
                jy0Var.g(z);
            }
        }
        return pr4VarK;
    }
}

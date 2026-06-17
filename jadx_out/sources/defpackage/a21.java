package defpackage;

import defpackage.b21;
import defpackage.c21;
import defpackage.f21;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a21 implements hz0 {
    public static final pz0 o = new pz0() { // from class: z11
        @Override // defpackage.pz0
        public final hz0[] d() {
            return a21.g();
        }
    };
    public final byte[] a;
    public final r73 b;
    public final boolean c;
    public final b21.a d;
    public mz0 e;
    public gr4 f;
    public int g;
    public xs2 h;
    public f21 i;
    public int j;
    public int k;
    public y11 l;
    public int m;
    public long n;

    public a21(int i) {
        this.a = new byte[42];
        this.b = new r73(new byte[32768], 0);
        this.c = (i & 1) != 0;
        this.d = new b21.a();
        this.g = 0;
    }

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new a21()};
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            y11 y11Var = this.l;
            if (y11Var != null) {
                y11Var.h(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.b0(0);
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.e = mz0Var;
        this.f = mz0Var.e(0, 1);
        mz0Var.o();
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        int i = this.g;
        if (i == 0) {
            n(jz0Var);
            return 0;
        }
        if (i == 1) {
            k(jz0Var);
            return 0;
        }
        if (i == 2) {
            p(jz0Var);
            return 0;
        }
        if (i == 3) {
            o(jz0Var);
            return 0;
        }
        if (i == 4) {
            i(jz0Var);
            return 0;
        }
        if (i == 5) {
            return m(jz0Var, yf3Var);
        }
        z20.a();
        return 0;
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) throws Throwable {
        c21.c(jz0Var, false);
        return c21.a(jz0Var);
    }

    public final long h(r73 r73Var, boolean z) {
        boolean zD;
        gg3.q(this.i);
        int iG = r73Var.g();
        while (iG <= r73Var.j() - 16) {
            r73Var.f0(iG);
            if (b21.d(r73Var, this.i, this.k, this.d)) {
                r73Var.f0(iG);
                return this.d.a;
            }
            iG++;
        }
        if (!z) {
            r73Var.f0(iG);
            return -1L;
        }
        while (iG <= r73Var.j() - this.j) {
            r73Var.f0(iG);
            try {
                zD = b21.d(r73Var, this.i, this.k, this.d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (r73Var.g() <= r73Var.j() ? zD : false) {
                r73Var.f0(iG);
                return this.d.a;
            }
            iG++;
        }
        r73Var.f0(r73Var.j());
        return -1L;
    }

    public final void i(jz0 jz0Var) {
        this.k = c21.b(jz0Var);
        ((mz0) fy4.l(this.e)).u(j(jz0Var.getPosition(), jz0Var.getLength()));
        this.g = 5;
    }

    public final yz3 j(long j, long j2) {
        gg3.q(this.i);
        f21 f21Var = this.i;
        f21.a aVar = f21Var.k;
        if (aVar != null && aVar.a.length > 0) {
            return new e21(f21Var, j);
        }
        if (j2 == -1 || f21Var.j <= 0) {
            return new yz3.b(f21Var.f());
        }
        y11 y11Var = new y11(f21Var, this.k, j, j2);
        this.l = y11Var;
        return y11Var.b();
    }

    public final void k(jz0 jz0Var) {
        byte[] bArr = this.a;
        jz0Var.s(bArr, 0, bArr.length);
        jz0Var.p();
        this.g = 2;
    }

    public final void l() {
        ((gr4) fy4.l(this.f)).b((this.n * 1000000) / ((long) ((f21) fy4.l(this.i)).e), 1, this.m, 0, null);
    }

    public final int m(jz0 jz0Var, yf3 yf3Var) {
        boolean z;
        gg3.q(this.f);
        gg3.q(this.i);
        y11 y11Var = this.l;
        if (y11Var != null && y11Var.d()) {
            return this.l.c(jz0Var, yf3Var);
        }
        if (this.n == -1) {
            this.n = b21.j(jz0Var, this.i);
            return 0;
        }
        int iJ = this.b.j();
        if (iJ < 32768) {
            int i = jz0Var.read(this.b.f(), iJ, 32768 - iJ);
            z = i == -1;
            r73 r73Var = this.b;
            if (!z) {
                r73Var.e0(iJ + i);
            } else if (r73Var.a() == 0) {
                l();
                return -1;
            }
        } else {
            z = false;
        }
        int iG = this.b.g();
        int i2 = this.m;
        int i3 = this.j;
        if (i2 < i3) {
            r73 r73Var2 = this.b;
            r73Var2.g0(Math.min(i3 - i2, r73Var2.a()));
        }
        long jH = h(this.b, z);
        int iG2 = this.b.g() - iG;
        this.b.f0(iG);
        this.f.a(this.b, iG2);
        this.m += iG2;
        if (jH != -1) {
            l();
            this.m = 0;
            this.n = jH;
        }
        int length = this.b.f().length - this.b.j();
        if (this.b.a() < 16 && length < 16) {
            int iA = this.b.a();
            System.arraycopy(this.b.f(), this.b.g(), this.b.f(), 0, iA);
            this.b.f0(0);
            this.b.e0(iA);
        }
        return 0;
    }

    public final void n(jz0 jz0Var) {
        this.h = c21.d(jz0Var, !this.c);
        this.g = 1;
    }

    public final void o(jz0 jz0Var) {
        c21.a aVar = new c21.a(this.i);
        boolean zE = false;
        while (!zE) {
            zE = c21.e(jz0Var, aVar);
            this.i = (f21) fy4.l(aVar.a);
        }
        gg3.q(this.i);
        this.j = Math.max(this.i.c, 6);
        ((gr4) fy4.l(this.f)).g(this.i.g(this.a, this.h).b().X("audio/flac").Q());
        ((gr4) fy4.l(this.f)).e(this.i.f());
        this.g = 4;
    }

    public final void p(jz0 jz0Var) throws r83 {
        c21.i(jz0Var);
        this.g = 3;
    }

    @Override // defpackage.hz0
    public void release() {
    }

    public a21() {
        this(0);
    }
}

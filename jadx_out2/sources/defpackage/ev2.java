package defpackage;

import defpackage.fv2;
import defpackage.t41;
import defpackage.wt4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ev2 implements cr0 {
    public final String a;
    public String f;
    public gr4 g;
    public boolean j;
    public int l;
    public int m;
    public int o;
    public int p;
    public int t;
    public boolean v;
    public int e = 0;
    public final r73 b = new r73(new byte[15], 2);
    public final q73 c = new q73();
    public final r73 d = new r73();
    public fv2.b q = new fv2.b();
    public int r = -2147483647;
    public int s = -1;
    public long u = -1;
    public boolean k = true;
    public boolean n = true;
    public double h = -9.223372036854776E18d;
    public double i = -9.223372036854776E18d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ev2(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean k(r73 r73Var) {
        int i = this.l;
        if ((i & 2) == 0) {
            r73Var.f0(r73Var.j());
            return false;
        }
        if ((i & 4) != 0) {
            return true;
        }
        while (r73Var.a() > 0) {
            int i2 = this.m << 8;
            this.m = i2;
            int iQ = i2 | r73Var.Q();
            this.m = iQ;
            if (fv2.e(iQ)) {
                r73Var.f0(r73Var.g() - 3);
                this.m = 0;
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void a(r73 r73Var) throws r83 {
        gg3.q(this.g);
        while (r73Var.a() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i == 1) {
                    b(r73Var, this.b, false);
                    if (this.b.a() == 0) {
                        boolean zI = i();
                        r73 r73Var2 = this.b;
                        if (zI) {
                            r73Var2.f0(0);
                            gr4 gr4Var = this.g;
                            r73 r73Var3 = this.b;
                            gr4Var.a(r73Var3, r73Var3.j());
                            this.b.b0(2);
                            this.d.b0(this.q.c);
                            this.n = true;
                            this.e = 2;
                        } else if (r73Var2.j() < 15) {
                            r73 r73Var4 = this.b;
                            r73Var4.e0(r73Var4.j() + 1);
                            this.n = false;
                        }
                    } else {
                        this.n = false;
                    }
                } else {
                    if (i != 2) {
                        z20.a();
                        return;
                    }
                    if (j(this.q.a)) {
                        b(r73Var, this.d, true);
                    }
                    l(r73Var);
                    int i2 = this.o;
                    fv2.b bVar = this.q;
                    if (i2 == bVar.c) {
                        int i3 = bVar.a;
                        if (i3 == 1) {
                            h(new q73(this.d.f()));
                        } else if (i3 == 17) {
                            this.t = fv2.f(new q73(this.d.f()));
                        } else if (i3 == 2) {
                            g();
                        }
                        this.e = 1;
                    }
                }
            } else if (k(r73Var)) {
                this.e = 1;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(r73 r73Var, r73 r73Var2, boolean z) {
        int iG = r73Var.g();
        int iMin = Math.min(r73Var.a(), r73Var2.a());
        r73Var.u(r73Var2.f(), r73Var2.g(), iMin);
        r73Var2.g0(iMin);
        if (z) {
            r73Var.f0(iG);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        this.e = 0;
        this.m = 0;
        this.b.b0(2);
        this.o = 0;
        this.p = 0;
        this.r = -2147483647;
        this.s = -1;
        this.t = 0;
        this.u = -1L;
        this.v = false;
        this.j = false;
        this.n = true;
        this.k = true;
        this.h = -9.223372036854776E18d;
        this.i = -9.223372036854776E18d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.l = i;
        if (!this.k && (this.p != 0 || !this.n)) {
            this.j = true;
        }
        if (j != -9223372036854775807L) {
            if (this.j) {
                this.i = j;
            } else {
                this.h = j;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.f = dVar.b();
        this.g = mz0Var.e(dVar.c(), 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        int i;
        if (this.v) {
            this.k = false;
            i = 1;
        } else {
            i = 0;
        }
        double d = (((double) (this.s - this.t)) * 1000000.0d) / ((double) this.r);
        long jRound = Math.round(this.h);
        if (this.j) {
            this.j = false;
            this.h = this.i;
        } else {
            this.h += d;
        }
        this.g.b(jRound, i, this.p, 0, null);
        this.v = false;
        this.t = 0;
        this.p = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(q73 q73Var) throws r83 {
        fv2.c cVarH = fv2.h(q73Var);
        this.r = cVarH.b;
        this.s = cVarH.c;
        long j = this.u;
        long j2 = this.q.b;
        if (j != j2) {
            this.u = j2;
            int i = cVarH.a;
            String strConcat = i != -1 ? "mhm1".concat(String.format(".%02X", Integer.valueOf(i))) : "mhm1";
            byte[] bArr = cVarH.d;
            this.g.g(new t41.b().k0(this.f).X(this.a).A0("audio/mhm1").B0(this.r).V(strConcat).l0((bArr == null || bArr.length <= 0) ? null : xi1.x(fy4.f, bArr)).Q());
        }
        this.v = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i() throws r83 {
        int iJ = this.b.j();
        this.c.o(this.b.f(), iJ);
        boolean zG = fv2.g(this.c, this.q);
        if (zG) {
            this.o = 0;
            this.p += this.q.c + iJ;
        }
        return zG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j(int i) {
        return i == 1 || i == 17;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(r73 r73Var) {
        int iMin = Math.min(r73Var.a(), this.q.c - this.o);
        this.g.a(r73Var, iMin);
        this.o += iMin;
    }
}

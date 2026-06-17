package defpackage;

import defpackage.k;
import defpackage.t41;
import defpackage.wt4;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xr1 implements cr0 {
    public final String a;
    public final int b;
    public final String c;
    public final r73 d;
    public final q73 e;
    public gr4 f;
    public String g;
    public t41 h;
    public int i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public long s;
    public int t;
    public long u;
    public int v;
    public String w;

    public xr1(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
        r73 r73Var = new r73(1024);
        this.d = r73Var;
        this.e = new q73(r73Var.f());
        this.m = -9223372036854775807L;
    }

    public static long b(q73 q73Var) {
        return q73Var.h((q73Var.h(2) + 1) * 8);
    }

    @Override // defpackage.cr0
    public void a(r73 r73Var) throws r83 {
        gg3.q(this.f);
        while (r73Var.a() > 0) {
            int i = this.i;
            if (i != 0) {
                if (i == 1) {
                    int iQ = r73Var.Q();
                    if ((iQ & 224) == 224) {
                        this.l = iQ;
                        this.i = 2;
                    } else if (iQ != 86) {
                        this.i = 0;
                    }
                } else if (i == 2) {
                    int iQ2 = ((this.l & (-225)) << 8) | r73Var.Q();
                    this.k = iQ2;
                    if (iQ2 > this.d.f().length) {
                        m(this.k);
                    }
                    this.j = 0;
                    this.i = 3;
                } else {
                    if (i != 3) {
                        z20.a();
                        return;
                    }
                    int iMin = Math.min(r73Var.a(), this.k - this.j);
                    r73Var.u(this.e.a, this.j, iMin);
                    int i2 = this.j + iMin;
                    this.j = i2;
                    if (i2 == this.k) {
                        this.e.p(0);
                        g(this.e);
                        this.i = 0;
                    }
                }
            } else if (r73Var.Q() == 86) {
                this.i = 1;
            }
        }
    }

    @Override // defpackage.cr0
    public void c() {
        this.i = 0;
        this.m = -9223372036854775807L;
        this.n = false;
    }

    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.m = j;
    }

    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.f = mz0Var.e(dVar.c(), 1);
        this.g = dVar.b();
    }

    public final void g(q73 q73Var) throws r83 {
        if (!q73Var.g()) {
            this.n = true;
            l(q73Var);
        } else if (!this.n) {
            return;
        }
        if (this.o != 0) {
            throw r83.a(null, null);
        }
        if (this.p != 0) {
            throw r83.a(null, null);
        }
        k(q73Var, j(q73Var));
        if (this.r) {
            q73Var.r((int) this.s);
        }
    }

    public final int h(q73 q73Var) throws r83 {
        int iB = q73Var.b();
        k.b bVarE = k.e(q73Var, true);
        this.w = bVarE.c;
        this.t = bVarE.a;
        this.v = bVarE.b;
        return iB - q73Var.b();
    }

    public final void i(q73 q73Var) {
        int iH = q73Var.h(3);
        this.q = iH;
        if (iH == 0) {
            q73Var.r(8);
            return;
        }
        if (iH == 1) {
            q73Var.r(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            q73Var.r(6);
        } else if (iH == 6 || iH == 7) {
            q73Var.r(1);
        } else {
            z20.a();
        }
    }

    public final int j(q73 q73Var) throws r83 {
        int iH;
        if (this.q != 0) {
            throw r83.a(null, null);
        }
        int i = 0;
        do {
            iH = q73Var.h(8);
            i += iH;
        } while (iH == 255);
        return i;
    }

    public final void k(q73 q73Var, int i) {
        int iE = q73Var.e();
        int i2 = iE & 7;
        r73 r73Var = this.d;
        if (i2 == 0) {
            r73Var.f0(iE >> 3);
        } else {
            q73Var.i(r73Var.f(), 0, i * 8);
            this.d.f0(0);
        }
        this.f.a(this.d, i);
        gg3.v(this.m != -9223372036854775807L);
        this.f.b(this.m, 1, i, 0, null);
        this.m += this.u;
    }

    public final void l(q73 q73Var) throws r83 {
        boolean zG;
        int iH = q73Var.h(1);
        int iH2 = iH == 1 ? q73Var.h(1) : 0;
        this.o = iH2;
        if (iH2 != 0) {
            throw r83.a(null, null);
        }
        if (iH == 1) {
            b(q73Var);
        }
        if (!q73Var.g()) {
            throw r83.a(null, null);
        }
        this.p = q73Var.h(6);
        int iH3 = q73Var.h(4);
        int iH4 = q73Var.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw r83.a(null, null);
        }
        if (iH == 0) {
            int iE = q73Var.e();
            int iH5 = h(q73Var);
            q73Var.p(iE);
            byte[] bArr = new byte[(iH5 + 7) / 8];
            q73Var.i(bArr, 0, iH5);
            t41 t41VarQ = new t41.b().k0(this.g).X(this.c).A0("audio/mp4a-latm").V(this.w).U(this.v).B0(this.t).l0(Collections.singletonList(bArr)).o0(this.a).y0(this.b).Q();
            if (!t41VarQ.equals(this.h)) {
                this.h = t41VarQ;
                this.u = 1024000000 / ((long) t41VarQ.I);
                this.f.g(t41VarQ);
            }
        } else {
            q73Var.r(((int) b(q73Var)) - h(q73Var));
        }
        i(q73Var);
        boolean zG2 = q73Var.g();
        this.r = zG2;
        this.s = 0L;
        if (zG2) {
            if (iH == 1) {
                this.s = b(q73Var);
            } else {
                do {
                    zG = q73Var.g();
                    this.s = (this.s << 8) + ((long) q73Var.h(8));
                } while (zG);
            }
        }
        if (q73Var.g()) {
            q73Var.r(8);
        }
    }

    public final void m(int i) {
        this.d.b0(i);
        this.e.n(this.d.f());
    }
}

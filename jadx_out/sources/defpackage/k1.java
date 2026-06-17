package defpackage;

import defpackage.l1;
import defpackage.t41;
import defpackage.wt4;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements cr0 {
    public final q73 a;
    public final r73 b;
    public final String c;
    public final int d;
    public final String e;
    public String f;
    public gr4 g;
    public int h;
    public int i;
    public boolean j;
    public long k;
    public t41 l;
    public int m;
    public long n;

    public k1(String str, int i, String str2) {
        q73 q73Var = new q73(new byte[128]);
        this.a = q73Var;
        this.b = new r73(q73Var.a);
        this.h = 0;
        this.n = -9223372036854775807L;
        this.c = str;
        this.d = i;
        this.e = str2;
    }

    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        gg3.q(this.g);
        while (r73Var.a() > 0) {
            int i = this.h;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(r73Var.a(), this.m - this.i);
                        this.g.a(r73Var, iMin);
                        int i2 = this.i + iMin;
                        this.i = i2;
                        if (i2 == this.m) {
                            gg3.v(this.n != -9223372036854775807L);
                            this.g.b(this.n, 1, this.m, 0, null);
                            this.n += this.k;
                            this.h = 0;
                        }
                    }
                } else if (b(r73Var, this.b.f(), 128)) {
                    g();
                    this.b.f0(0);
                    this.g.a(this.b, 128);
                    this.h = 2;
                }
            } else if (h(r73Var)) {
                this.h = 1;
                this.b.f()[0] = 11;
                this.b.f()[1] = 119;
                this.i = 2;
            }
        }
    }

    public final boolean b(r73 r73Var, byte[] bArr, int i) {
        int iMin = Math.min(r73Var.a(), i - this.i);
        r73Var.u(bArr, this.i, iMin);
        int i2 = this.i + iMin;
        this.i = i2;
        return i2 == i;
    }

    @Override // defpackage.cr0
    public void c() {
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.n = -9223372036854775807L;
    }

    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.n = j;
    }

    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.f = dVar.b();
        this.g = mz0Var.e(dVar.c(), 1);
    }

    public final void g() {
        this.a.p(0);
        l1.b bVarF = l1.f(this.a);
        t41 t41Var = this.l;
        if (t41Var == null || bVarF.d != t41Var.H || bVarF.c != t41Var.I || !Objects.equals(bVarF.a, t41Var.p)) {
            t41.b bVarU0 = new t41.b().k0(this.f).X(this.e).A0(bVarF.a).U(bVarF.d).B0(bVarF.c).o0(this.c).y0(this.d).u0(bVarF.g);
            if ("audio/ac3".equals(bVarF.a)) {
                bVarU0.T(bVarF.g);
            }
            t41 t41VarQ = bVarU0.Q();
            this.l = t41VarQ;
            this.g.g(t41VarQ);
        }
        this.m = bVarF.e;
        this.k = (((long) bVarF.f) * 1000000) / ((long) this.l.I);
    }

    public final boolean h(r73 r73Var) {
        while (true) {
            if (r73Var.a() <= 0) {
                return false;
            }
            if (this.j) {
                int iQ = r73Var.Q();
                if (iQ == 119) {
                    this.j = false;
                    return true;
                }
                this.j = iQ == 11;
            } else {
                this.j = r73Var.Q() == 11;
            }
        }
    }

    public k1(String str) {
        this(null, 0, str);
    }
}

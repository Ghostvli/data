package defpackage;

import defpackage.l1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class su3 implements gv3 {
    public final fv3 a;
    public gr4 c;
    public int d;
    public long f;
    public long g;
    public final q73 b = new q73();
    public long e = -9223372036854775807L;

    public su3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.e = j;
        this.g = j2;
    }

    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 1);
        this.c = gr4VarE;
        gr4VarE.g(this.a.c);
    }

    @Override // defpackage.gv3
    public void c(long j, int i) {
        gg3.v(this.e == -9223372036854775807L);
        this.e = j;
    }

    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        int iQ = r73Var.Q() & 3;
        int iQ2 = r73Var.Q() & 255;
        long jA = iv3.a(this.g, j, this.e, this.a.b);
        if (iQ == 0) {
            e();
            if (iQ2 == 1) {
                i(r73Var, jA);
                return;
            } else {
                h(r73Var, iQ2, jA);
                return;
            }
        }
        if (iQ == 1 || iQ == 2) {
            e();
        } else if (iQ != 3) {
            jl.a(String.valueOf(iQ));
            return;
        }
        g(r73Var, z, iQ, jA);
    }

    public final void e() {
        if (this.d > 0) {
            f();
        }
    }

    public final void f() {
        ((gr4) fy4.l(this.c)).b(this.f, 1, this.d, 0, null);
        this.d = 0;
    }

    public final void g(r73 r73Var, boolean z, int i, long j) {
        int iA = r73Var.a();
        ((gr4) gg3.q(this.c)).a(r73Var, iA);
        this.d += iA;
        this.f = j;
        if (z && i == 3) {
            f();
        }
    }

    public final void h(r73 r73Var, int i, long j) {
        this.b.n(r73Var.f());
        this.b.s(2);
        long j2 = j;
        for (int i2 = 0; i2 < i; i2++) {
            l1.b bVarF = l1.f(this.b);
            ((gr4) gg3.q(this.c)).a(r73Var, bVarF.e);
            ((gr4) fy4.l(this.c)).b(j2, 1, bVarF.e, 0, null);
            j2 += ((long) (bVarF.f / bVarF.c)) * 1000000;
            this.b.s(bVarF.e);
        }
    }

    public final void i(r73 r73Var, long j) {
        int iA = r73Var.a();
        ((gr4) gg3.q(this.c)).a(r73Var, iA);
        ((gr4) fy4.l(this.c)).b(j, 1, iA, 0, null);
    }
}

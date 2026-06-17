package defpackage;

import defpackage.t41;
import defpackage.wt4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a93 implements vz3 {
    public t41 a;
    public yo4 b;
    public gr4 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a93(String str, String str2) {
        this.a = new t41.b().X(str2).A0(str).Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vz3
    public void a(r73 r73Var) {
        c();
        long jE = this.b.e();
        long jF = this.b.f();
        if (jE == -9223372036854775807L || jF == -9223372036854775807L) {
            return;
        }
        t41 t41Var = this.a;
        if (jF != t41Var.u) {
            t41 t41VarQ = t41Var.b().E0(jF).Q();
            this.a = t41VarQ;
            this.c.g(t41VarQ);
        }
        int iA = r73Var.a();
        this.c.a(r73Var, iA);
        this.c.b(jE, 1, iA, 0, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vz3
    public void b(yo4 yo4Var, mz0 mz0Var, wt4.d dVar) {
        this.b = yo4Var;
        dVar.a();
        gr4 gr4VarE = mz0Var.e(dVar.c(), 5);
        this.c = gr4VarE;
        gr4VarE.g(this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        gg3.q(this.b);
        fy4.l(this.c);
    }
}

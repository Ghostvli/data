package defpackage;

import defpackage.qt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j20 extends gi {
    public final int o;
    public final long p;
    public final qt q;
    public long r;
    public volatile boolean s;
    public boolean t;

    public j20(aa0 aa0Var, ja0 ja0Var, t41 t41Var, int i, Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, qt qtVar) {
        super(aa0Var, ja0Var, t41Var, i, obj, j, j2, j3, j4, j5);
        this.o = i2;
        this.p = j6;
        this.q = qtVar;
    }

    @Override // xy1.e
    public final void b() {
        ii iiVarJ = j();
        if (this.r == 0) {
            iiVarJ.b(this.p);
            qt qtVar = this.q;
            qt.b bVarL = l(iiVarJ);
            long j = this.k;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.p;
            long j3 = this.l;
            qtVar.c(bVarL, j2, j3 != -9223372036854775807L ? j3 - this.p : -9223372036854775807L);
        }
        try {
            ja0 ja0VarE = this.b.e(this.r);
            ne4 ne4Var = this.i;
            sf0 sf0Var = new sf0(ne4Var, ja0VarE.g, ne4Var.a(ja0VarE));
            do {
                try {
                    if (this.s) {
                        break;
                    }
                } finally {
                    this.r = sf0Var.getPosition() - this.b.g;
                }
            } while (this.q.a(sf0Var));
            m(iiVarJ);
            this.r = sf0Var.getPosition() - this.b.g;
            n();
            ia0.a(this.i);
            this.t = !this.s;
        } catch (Throwable th) {
            n();
            ia0.a(this.i);
            throw th;
        }
    }

    @Override // xy1.e
    public final void c() {
        this.s = true;
    }

    @Override // defpackage.v72
    public long g() {
        return this.j + ((long) this.o);
    }

    @Override // defpackage.v72
    public boolean h() {
        return this.t;
    }

    public qt.b l(ii iiVar) {
        return iiVar;
    }

    public final void m(ii iiVar) {
        if (nt2.q(this.d.o)) {
            t41 t41Var = this.d;
            int i = t41Var.O;
            if ((i <= 1 && t41Var.P <= 1) || i == -1 || t41Var.P == -1) {
                return;
            }
            gr4 gr4VarE = iiVar.e(0, 4);
            t41 t41Var2 = this.d;
            int i2 = t41Var2.O * t41Var2.P;
            long j = (this.h - this.g) / ((long) i2);
            for (int i3 = 1; i3 < i2; i3++) {
                gr4VarE.a(new r73(), 0);
                gr4VarE.b(((long) i3) * j, 0, 0, 0, null);
            }
        }
    }

    public void n() {
    }
}

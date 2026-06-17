package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ru3 implements gv3 {
    public final fv3 a;
    public final q73 b = new q73();
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public long g;
    public gr4 h;
    public long i;

    public ru3(fv3 fv3Var) {
        this.a = fv3Var;
        this.c = fv3Var.b;
        String str = (String) gg3.q((String) fv3Var.d.get("mode"));
        if (xa.a(str, "AAC-hbr")) {
            this.d = 13;
            this.e = 3;
        } else {
            if (!xa.a(str, "AAC-lbr")) {
                fn.a("AAC mode not supported");
                throw null;
            }
            this.d = 6;
            this.e = 2;
        }
        this.f = this.e + this.d;
    }

    public static void e(gr4 gr4Var, long j, int i) {
        gr4Var.b(j, 1, i, 0, null);
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.g = j;
        this.i = j2;
    }

    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 1);
        this.h = gr4VarE;
        gr4VarE.g(this.a.c);
    }

    @Override // defpackage.gv3
    public void c(long j, int i) {
        this.g = j;
    }

    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        gg3.q(this.h);
        short sM = r73Var.M();
        int i2 = sM / this.f;
        long jA = iv3.a(this.i, j, this.g, this.c);
        this.b.m(r73Var);
        if (i2 == 1) {
            int iH = this.b.h(this.d);
            this.b.r(this.e);
            this.h.a(r73Var, r73Var.a());
            if (z) {
                e(this.h, jA, iH);
                return;
            }
            return;
        }
        r73Var.g0((sM + 7) / 8);
        for (int i3 = 0; i3 < i2; i3++) {
            int iH2 = this.b.h(this.d);
            this.b.r(this.e);
            this.h.a(r73Var, iH2);
            e(this.h, jA, iH2);
            jA += fy4.u1(i2, 1000000L, this.c);
        }
    }
}

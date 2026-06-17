package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k74 extends gi {
    public final int o;
    public final t41 p;
    public long q;
    public boolean r;

    public k74(aa0 aa0Var, ja0 ja0Var, t41 t41Var, int i, Object obj, long j, long j2, long j3, int i2, t41 t41Var2) {
        super(aa0Var, ja0Var, t41Var, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.o = i2;
        this.p = t41Var2;
    }

    @Override // xy1.e
    public void b() {
        ii iiVarJ = j();
        iiVarJ.b(0L);
        int iD = 0;
        gr4 gr4VarE = iiVarJ.e(0, this.o);
        gr4VarE.g(this.p);
        try {
            long jA = this.i.a(this.b.e(this.q));
            if (jA != -1) {
                jA += this.q;
            }
            sf0 sf0Var = new sf0(this.i, this.q, jA);
            while (true) {
                long j = this.q;
                if (iD == -1) {
                    gr4VarE.b(this.g, 1, (int) j, 0, null);
                    ia0.a(this.i);
                    this.r = true;
                    return;
                }
                this.q = j + ((long) iD);
                iD = gr4VarE.d(sf0Var, Integer.MAX_VALUE, true);
            }
        } catch (Throwable th) {
            ia0.a(this.i);
            throw th;
        }
    }

    @Override // xy1.e
    public void c() {
    }

    @Override // defpackage.v72
    public boolean h() {
        return this.r;
    }
}

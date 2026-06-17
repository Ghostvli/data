package defpackage;

import defpackage.qt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ak1 extends pt {
    public final qt j;
    public qt.b k;
    public st l;
    public long m;
    public volatile boolean n;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ak1(aa0 aa0Var, ja0 ja0Var, t41 t41Var, int i, Object obj, qt qtVar) {
        super(aa0Var, ja0Var, 2, t41Var, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.j = qtVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public void b() {
        if (this.m == 0) {
            this.j.c(this.k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            ja0 ja0VarE = this.b.e(this.m);
            ne4 ne4Var = this.i;
            sf0 sf0Var = new sf0(ne4Var, ja0VarE.g, ne4Var.a(ja0VarE));
            while (!this.n && this.j.a(sf0Var)) {
                try {
                } finally {
                    this.m = sf0Var.getPosition() - this.b.g;
                    this.l = this.j.b();
                }
            }
        } finally {
            ia0.a(this.i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public void c() {
        this.n = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(qt.b bVar) {
        this.k = bVar;
    }
}

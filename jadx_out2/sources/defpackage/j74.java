package defpackage;

import defpackage.t41;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class j74 implements hz0 {
    public final int a;
    public final int b;
    public final String c;
    public int d;
    public int e;
    public mz0 f;
    public gr4 g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j74(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        if (j == 0 || this.e == 1) {
            this.e = 1;
            this.d = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.f = mz0Var;
        g(this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        int i = this.e;
        if (i == 1) {
            h(jz0Var);
            return 0;
        }
        if (i == 2) {
            return -1;
        }
        z20.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        gg3.v((this.a == -1 || this.b == -1) ? false : true);
        r73 r73Var = new r73(this.b);
        jz0Var.s(r73Var.f(), 0, this.b);
        return r73Var.Y() == this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(String str) {
        gr4 gr4VarE = this.f.e(1024, 4);
        this.g = gr4VarE;
        gr4VarE.g(new t41.b().X(str).A0(str).Q());
        this.f.o();
        this.f.u(new n74(-9223372036854775807L));
        this.e = 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(jz0 jz0Var) {
        int iD = ((gr4) gg3.q(this.g)).d(jz0Var, 1024, true);
        if (iD != -1) {
            this.d += iD;
            return;
        }
        this.e = 2;
        this.g.b(0L, 1, this.d, 0, null);
        this.d = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }
}

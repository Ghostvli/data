package defpackage;

import defpackage.p1;
import defpackage.t41;
import defpackage.wt4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 implements cr0 {
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
    public boolean k;
    public long l;
    public t41 m;
    public int n;
    public long o;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o1(String str, int i, String str2) {
        q73 q73Var = new q73(new byte[16]);
        this.a = q73Var;
        this.b = new r73(q73Var.a);
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.o = -9223372036854775807L;
        this.c = str;
        this.d = i;
        this.e = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean b(r73 r73Var, byte[] bArr, int i) {
        int iMin = Math.min(r73Var.a(), i - this.i);
        r73Var.u(bArr, this.i, iMin);
        int i2 = this.i + iMin;
        this.i = i2;
        return i2 == i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void g() {
        this.a.p(0);
        p1.c cVarG = p1.g(this.a);
        t41 t41Var = this.m;
        if (t41Var == null || cVarG.c != t41Var.H || cVarG.b != t41Var.I || !"audio/ac4".equals(t41Var.p)) {
            t41 t41VarQ = new t41.b().k0(this.f).X(this.e).A0("audio/ac4").U(cVarG.c).B0(cVarG.b).o0(this.c).y0(this.d).Q();
            this.m = t41VarQ;
            this.g.g(t41VarQ);
        }
        this.n = cVarG.d;
        this.l = (((long) cVarG.e) * 1000000) / ((long) this.m.I);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean h(r73 r73Var) {
        int iQ;
        while (true) {
            if (r73Var.a() <= 0) {
                return false;
            }
            if (this.j) {
                iQ = r73Var.Q();
                this.j = iQ == 172;
                if (iQ == 64 || iQ == 65) {
                    break;
                }
            } else {
                this.j = r73Var.Q() == 172;
            }
        }
        this.k = iQ == 65;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        gg3.q(this.g);
        while (r73Var.a() > 0) {
            int i = this.h;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(r73Var.a(), this.n - this.i);
                        this.g.a(r73Var, iMin);
                        int i2 = this.i + iMin;
                        this.i = i2;
                        if (i2 == this.n) {
                            gg3.v(this.o != -9223372036854775807L);
                            this.g.b(this.o, 1, this.n, 0, null);
                            this.o += this.l;
                            this.h = 0;
                        }
                    }
                } else if (b(r73Var, this.b.f(), 16)) {
                    g();
                    this.b.f0(0);
                    this.g.a(this.b, 16);
                    this.h = 2;
                }
            } else if (h(r73Var)) {
                this.h = 1;
                this.b.f()[0] = -84;
                this.b.f()[1] = (byte) (this.k ? 65 : 64);
                this.i = 2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.o = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.o = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.f = dVar.b();
        this.g = mz0Var.e(dVar.c(), 1);
    }

    public o1(String str) {
        this(null, 0, str);
    }
}

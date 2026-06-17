package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zu3 implements gv3 {
    public final fv3 a;
    public final int b;
    public gr4 c;
    public long d;
    public int e;
    public int f;
    public long g;
    public long h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zu3(fv3 fv3Var) {
        this.a = fv3Var;
        try {
            this.b = e(fv3Var.d);
            this.d = -9223372036854775807L;
            this.e = -1;
            this.f = 0;
            this.g = 0L;
            this.h = -9223372036854775807L;
        } catch (r83 e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(zi1 zi1Var) throws r83 {
        String str = (String) zi1Var.get("config");
        int i = 0;
        i = 0;
        if (str != null && str.length() % 2 == 0) {
            q73 q73Var = new q73(fy4.X(str));
            int iH = q73Var.h(1);
            if (iH != 0) {
                throw r83.b("unsupported audio mux version: " + iH, null);
            }
            gg3.e(q73Var.h(1) == 1, "Only supports allStreamsSameTimeFraming.");
            int iH2 = q73Var.h(6);
            gg3.e(q73Var.h(4) == 0, "Only suppors one program.");
            gg3.e(q73Var.h(3) == 0, "Only suppors one layer.");
            i = iH2;
        }
        return i + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void f() {
        ((gr4) gg3.q(this.c)).b(this.h, 1, this.f, 0, null);
        this.f = 0;
        this.h = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.d = j;
        this.f = 0;
        this.g = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 2);
        this.c = gr4VarE;
        ((gr4) fy4.l(gr4VarE)).g(this.a.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void c(long j, int i) {
        gg3.v(this.d == -9223372036854775807L);
        this.d = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        gg3.q(this.c);
        int iB = cv3.b(this.e);
        if (this.f > 0 && iB < i) {
            f();
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            int i3 = 0;
            while (r73Var.g() < r73Var.j()) {
                int iQ = r73Var.Q();
                i3 += iQ;
                if (iQ != 255) {
                    break;
                }
            }
            this.c.a(r73Var, i3);
            this.f += i3;
        }
        this.h = iv3.a(this.g, j, this.d, this.a.b);
        if (z) {
            f();
        }
        this.e = i;
    }
}

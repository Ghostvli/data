package defpackage;

import defpackage.rp0;
import defpackage.t41;
import defpackage.wt4;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qp0 implements cr0 {
    public final r73 a;
    public final String c;
    public final int d;
    public final String e;
    public String f;
    public gr4 g;
    public int i;
    public int j;
    public long k;
    public t41 l;
    public int m;
    public int n;
    public int h = 0;
    public long q = -9223372036854775807L;
    public final AtomicInteger b = new AtomicInteger();
    public int o = -1;
    public int p = -1;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qp0(String str, int i, int i2, String str2) {
        this.a = new r73(new byte[i2]);
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
    @Override // defpackage.cr0
    public void a(r73 r73Var) throws r83 {
        gg3.q(this.g);
        while (r73Var.a() > 0) {
            switch (this.h) {
                case 0:
                    if (j(r73Var)) {
                        int i = this.n;
                        if (i == 3 || i == 4) {
                            this.h = 4;
                        } else if (i != 1) {
                            this.h = 2;
                        } else {
                            this.h = 1;
                        }
                    }
                    break;
                case 1:
                    if (b(r73Var, this.a.f(), 18)) {
                        g();
                        this.a.f0(0);
                        this.g.a(this.a, 18);
                        this.h = 6;
                    }
                    break;
                case 2:
                    if (b(r73Var, this.a.f(), 7)) {
                        this.o = rp0.k(this.a.f());
                        this.h = 3;
                    }
                    break;
                case 3:
                    if (b(r73Var, this.a.f(), this.o)) {
                        h();
                        this.a.f0(0);
                        this.g.a(this.a, this.o);
                        this.h = 6;
                    }
                    break;
                case 4:
                    if (b(r73Var, this.a.f(), 6)) {
                        int iM = rp0.m(this.a.f());
                        this.p = iM;
                        int i2 = this.i;
                        if (i2 > iM) {
                            int i3 = i2 - iM;
                            this.i = i2 - i3;
                            r73Var.f0(r73Var.g() - i3);
                        }
                        this.h = 5;
                    }
                    break;
                case 5:
                    if (b(r73Var, this.a.f(), this.p)) {
                        i();
                        this.a.f0(0);
                        this.g.a(this.a, this.p);
                        this.h = 6;
                    }
                    break;
                case 6:
                    int iMin = Math.min(r73Var.a(), this.m - this.i);
                    this.g.a(r73Var, iMin);
                    int i4 = this.i + iMin;
                    this.i = i4;
                    if (i4 == this.m) {
                        gg3.v(this.q != -9223372036854775807L);
                        this.g.b(this.q, this.n == 4 ? 0 : 1, this.m, 0, null);
                        this.q += this.k;
                        this.h = 0;
                    }
                    break;
                default:
                    z20.a();
                    return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.q = -9223372036854775807L;
        this.b.set(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.q = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.f = dVar.b();
        this.g = mz0Var.e(dVar.c(), 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        byte[] bArrF = this.a.f();
        if (this.l == null) {
            t41 t41VarI = rp0.i(bArrF, this.f, this.c, this.d, this.e, null);
            this.l = t41VarI;
            this.g.g(t41VarI);
        }
        this.m = rp0.b(bArrF);
        this.k = ll1.e(fy4.t1(rp0.h(bArrF), this.l.I));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() throws r83 {
        rp0.b bVarJ = rp0.j(this.a.f());
        k(bVarJ);
        this.m = bVarJ.d;
        long j = bVarJ.e;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        this.k = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() throws r83 {
        rp0.b bVarL = rp0.l(this.a.f(), this.b);
        if (this.n == 3) {
            k(bVarL);
        }
        this.m = bVarL.d;
        long j = bVarL.e;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        this.k = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j(r73 r73Var) {
        while (r73Var.a() > 0) {
            int i = this.j << 8;
            this.j = i;
            int iQ = i | r73Var.Q();
            this.j = iQ;
            int iC = rp0.c(iQ);
            this.n = iC;
            if (iC != 0) {
                byte[] bArrF = this.a.f();
                int i2 = this.j;
                bArrF[0] = (byte) ((i2 >> 24) & 255);
                bArrF[1] = (byte) ((i2 >> 16) & 255);
                bArrF[2] = (byte) ((i2 >> 8) & 255);
                bArrF[3] = (byte) (i2 & 255);
                this.i = 4;
                this.j = 0;
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(rp0.b bVar) {
        int i;
        int i2 = bVar.b;
        if (i2 == -2147483647 || (i = bVar.c) == -1) {
            return;
        }
        t41 t41Var = this.l;
        if (t41Var != null && i == t41Var.H && i2 == t41Var.I && Objects.equals(bVar.a, t41Var.p)) {
            return;
        }
        t41 t41Var2 = this.l;
        t41 t41VarQ = (t41Var2 == null ? new t41.b() : t41Var2.b()).k0(this.f).X(this.e).A0(bVar.a).U(bVar.c).B0(bVar.b).o0(this.c).y0(this.d).Q();
        this.l = t41VarQ;
        this.g.g(t41VarQ);
    }
}

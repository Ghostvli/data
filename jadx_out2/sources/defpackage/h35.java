package defpackage;

import defpackage.bl4;
import defpackage.t41;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h35 extends bl4 {
    public final r73 b;
    public final r73 c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h35(gr4 gr4Var) {
        super(gr4Var);
        this.b = new r73(dx2.a);
        this.c = new r73(4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bl4
    public boolean b(r73 r73Var) throws bl4.a {
        int iQ = r73Var.Q();
        int i = (iQ >> 4) & 15;
        int i2 = iQ & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        throw new bl4.a("Video format not supported: " + i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bl4
    public boolean c(r73 r73Var, long j) throws r83 {
        int iQ = r73Var.Q();
        long jA = j + (((long) r73Var.A()) * 1000);
        if (iQ == 0 && !this.e) {
            r73 r73Var2 = new r73(new byte[r73Var.a()]);
            r73Var.u(r73Var2.f(), 0, r73Var.a());
            cf cfVarB = cf.b(r73Var2);
            this.d = cfVarB.b;
            this.a.g(new t41.b().X("video/x-flv").A0("video/avc").V(cfVarB.l).H0(cfVarB.c).i0(cfVarB.d).v0(cfVarB.k).l0(cfVarB.a).Q());
            this.e = true;
            return false;
        }
        if (iQ != 1 || !this.e) {
            return false;
        }
        int i = this.g == 1 ? 1 : 0;
        if (!this.f && i == 0) {
            return false;
        }
        byte[] bArrF = this.c.f();
        bArrF[0] = 0;
        bArrF[1] = 0;
        bArrF[2] = 0;
        int i2 = 4 - this.d;
        int i3 = 0;
        while (r73Var.a() > 0) {
            r73Var.u(this.c.f(), i2, this.d);
            this.c.f0(0);
            int iU = this.c.U();
            this.b.f0(0);
            this.a.a(this.b, 4);
            this.a.a(r73Var, iU);
            i3 = i3 + 4 + iU;
        }
        this.a.b(jA, i, i3, 0, null);
        this.f = true;
        return true;
    }
}

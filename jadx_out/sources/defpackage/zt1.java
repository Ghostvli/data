package defpackage;

import defpackage.xi1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zt1 implements df {
    public final xi1 a;
    public final int b;

    public zt1(int i, xi1 xi1Var) {
        this.b = i;
        this.a = xi1Var;
    }

    public static df a(int i, int i2, r73 r73Var) {
        switch (i) {
            case 1718776947:
                return ve4.d(i2, r73Var);
            case 1751742049:
                return ff.b(r73Var);
            case 1752331379:
                return gf.c(r73Var);
            case 1852994675:
                return df4.a(r73Var);
            default:
                return null;
        }
    }

    public static zt1 c(int i, r73 r73Var) {
        xi1.a aVar = new xi1.a();
        int iJ = r73Var.j();
        int iB = -2;
        while (r73Var.a() > 8) {
            int iD = r73Var.D();
            int iG = r73Var.g() + r73Var.D();
            r73Var.e0(iG);
            df dfVarC = iD == 1414744396 ? c(r73Var.D(), r73Var) : a(iD, iB, r73Var);
            if (dfVarC != null) {
                if (dfVarC.getType() == 1752331379) {
                    iB = ((gf) dfVarC).b();
                }
                aVar.a(dfVarC);
            }
            r73Var.f0(iG);
            r73Var.e0(iJ);
        }
        return new zt1(i, aVar.k());
    }

    public df b(Class cls) {
        pw4 it = this.a.iterator();
        while (it.hasNext()) {
            df dfVar = (df) it.next();
            if (dfVar.getClass() == cls) {
                return dfVar;
            }
        }
        return null;
    }

    @Override // defpackage.df
    public int getType() {
        return this.b;
    }
}

package defpackage;

import defpackage.if3;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jf3 {
    public static final no1.a a = no1.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", "d");

    public static if3 a(no1 no1Var, f12 f12Var, int i) {
        boolean zU = false;
        boolean z = i == 3;
        String strF = null;
        if3.a aVarB = null;
        j6 j6VarF = null;
        z6 z6VarB = null;
        j6 j6VarF2 = null;
        j6 j6VarE = null;
        j6 j6VarE2 = null;
        j6 j6VarF3 = null;
        j6 j6VarF4 = null;
        while (no1Var.t()) {
            switch (no1Var.M(a)) {
                case 0:
                    strF = no1Var.F();
                    break;
                case 1:
                    aVarB = if3.a.b(no1Var.y());
                    break;
                case 2:
                    j6VarF = a7.f(no1Var, f12Var, false);
                    break;
                case 3:
                    z6VarB = n6.b(no1Var, f12Var);
                    break;
                case 4:
                    j6VarF2 = a7.f(no1Var, f12Var, false);
                    break;
                case 5:
                    j6VarE2 = a7.e(no1Var, f12Var);
                    break;
                case 6:
                    j6VarF4 = a7.f(no1Var, f12Var, false);
                    break;
                case 7:
                    j6VarE = a7.e(no1Var, f12Var);
                    break;
                case 8:
                    j6VarF3 = a7.f(no1Var, f12Var, false);
                    break;
                case 9:
                    zU = no1Var.u();
                    break;
                case 10:
                    z = no1Var.y() == 3;
                    break;
                default:
                    no1Var.N();
                    no1Var.O();
                    break;
            }
        }
        return new if3(strF, aVarB, j6VarF, z6VarB, j6VarF2, j6VarE, j6VarE2, j6VarF3, j6VarF4, zU, z);
    }
}

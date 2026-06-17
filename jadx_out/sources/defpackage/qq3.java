package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qq3 {
    public static final no1.a a = no1.a.a("nm", "c", "o", "tr", "hd");

    public static oq3 a(no1 no1Var, f12 f12Var) {
        String strF = null;
        j6 j6VarF = null;
        j6 j6VarF2 = null;
        x6 x6VarH = null;
        boolean zU = false;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                j6VarF = a7.f(no1Var, f12Var, false);
            } else if (iM == 2) {
                j6VarF2 = a7.f(no1Var, f12Var, false);
            } else if (iM == 3) {
                x6VarH = y6.h(no1Var, f12Var);
            } else if (iM != 4) {
                no1Var.O();
            } else {
                zU = no1Var.u();
            }
        }
        return new oq3(strF, j6VarF, j6VarF2, x6VarH, zU);
    }
}

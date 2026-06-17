package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m54 {
    public static no1.a a = no1.a.a("nm", "ind", "ks", "hd");

    public static l54 a(no1 no1Var, f12 f12Var) {
        String strF = null;
        int iY = 0;
        boolean zU = false;
        q6 q6VarK = null;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                iY = no1Var.y();
            } else if (iM == 2) {
                q6VarK = a7.k(no1Var, f12Var);
            } else if (iM != 3) {
                no1Var.O();
            } else {
                zU = no1Var.u();
            }
        }
        return new l54(strF, iY, q6VarK, zU);
    }
}

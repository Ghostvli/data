package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ou3 {
    public static final no1.a a = no1.a.a("nm", "r", "hd");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static mu3 a(no1 no1Var, f12 f12Var) {
        boolean zU = false;
        String strF = null;
        j6 j6VarF = null;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                j6VarF = a7.f(no1Var, f12Var, true);
            } else if (iM != 2) {
                no1Var.O();
            } else {
                zU = no1Var.u();
            }
        }
        if (zU) {
            return null;
        }
        return new mu3(strF, j6VarF);
    }
}

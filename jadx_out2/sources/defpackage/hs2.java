package defpackage;

import defpackage.fs2;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hs2 {
    public static final no1.a a = no1.a.a("nm", "mm", "hd");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fs2 a(no1 no1Var) {
        String strF = null;
        boolean zU = false;
        fs2.a aVarB = null;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                aVarB = fs2.a.b(no1Var.y());
            } else if (iM != 2) {
                no1Var.N();
                no1Var.O();
            } else {
                zU = no1Var.u();
            }
        }
        return new fs2(strF, aVarB, zU);
    }
}

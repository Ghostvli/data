package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d41 {
    public static final no1.a a = no1.a.a("fFamily", "fName", "fStyle", "ascent");

    public static y31 a(no1 no1Var) {
        no1Var.h();
        String strF = null;
        String strF2 = null;
        float fV = 0.0f;
        String strF3 = null;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                strF3 = no1Var.F();
            } else if (iM == 2) {
                strF2 = no1Var.F();
            } else if (iM != 3) {
                no1Var.N();
                no1Var.O();
            } else {
                fV = (float) no1Var.v();
            }
        }
        no1Var.l();
        return new y31(strF, strF3, strF2, fV);
    }
}

package defpackage;

import defpackage.no1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c41 {
    public static final no1.a a = no1.a.a("ch", "size", "w", "style", "fFamily", "data");
    public static final no1.a b = no1.a.a("shapes");

    public static b41 a(no1 no1Var, f12 f12Var) {
        ArrayList arrayList = new ArrayList();
        no1Var.h();
        double dV = 0.0d;
        String strF = null;
        String strF2 = null;
        char cCharAt = 0;
        double dV2 = 0.0d;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                cCharAt = no1Var.F().charAt(0);
            } else if (iM == 1) {
                dV2 = no1Var.v();
            } else if (iM == 2) {
                dV = no1Var.v();
            } else if (iM == 3) {
                strF = no1Var.F();
            } else if (iM == 4) {
                strF2 = no1Var.F();
            } else if (iM != 5) {
                no1Var.N();
                no1Var.O();
            } else {
                no1Var.h();
                while (no1Var.t()) {
                    if (no1Var.M(b) != 0) {
                        no1Var.N();
                        no1Var.O();
                    } else {
                        no1Var.c();
                        while (no1Var.t()) {
                            arrayList.add((f54) w20.a(no1Var, f12Var));
                        }
                        no1Var.i();
                    }
                }
                no1Var.l();
            }
        }
        no1Var.l();
        return new b41(arrayList, cCharAt, dV2, dV, strF, strF2);
    }
}

package defpackage;

import defpackage.no1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g54 {
    public static final no1.a a = no1.a.a("nm", "hd", "it");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f54 a(no1 no1Var, f12 f12Var) {
        ArrayList arrayList = new ArrayList();
        String strF = null;
        boolean zU = false;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                zU = no1Var.u();
            } else if (iM != 2) {
                no1Var.O();
            } else {
                no1Var.c();
                while (no1Var.t()) {
                    v20 v20VarA = w20.a(no1Var, f12Var);
                    if (v20VarA != null) {
                        arrayList.add(v20VarA);
                    }
                }
                no1Var.i();
            }
        }
        return new f54(strF, arrayList, zU);
    }
}

package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class du {
    public static final no1.a a = no1.a.a("nm", "p", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "hd", "d");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cu a(no1 no1Var, f12 f12Var, int i) {
        boolean z = i == 3;
        boolean zU = false;
        String strF = null;
        z6 z6VarB = null;
        o6 o6VarI = null;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                z6VarB = n6.b(no1Var, f12Var);
            } else if (iM == 2) {
                o6VarI = a7.i(no1Var, f12Var);
            } else if (iM == 3) {
                zU = no1Var.u();
            } else if (iM != 4) {
                no1Var.N();
                no1Var.O();
            } else {
                z = no1Var.y() == 3;
            }
        }
        return new cu(strF, z6VarB, o6VarI, z, zU);
    }
}

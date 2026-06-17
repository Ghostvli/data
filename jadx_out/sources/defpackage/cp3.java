package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cp3 {
    public static final no1.a a = no1.a.a("nm", "p", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "r", "hd");

    public static bp3 a(no1 no1Var, f12 f12Var) {
        String strF = null;
        z6 z6VarB = null;
        o6 o6VarI = null;
        j6 j6VarE = null;
        boolean zU = false;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                z6VarB = n6.b(no1Var, f12Var);
            } else if (iM == 2) {
                o6VarI = a7.i(no1Var, f12Var);
            } else if (iM == 3) {
                j6VarE = a7.e(no1Var, f12Var);
            } else if (iM != 4) {
                no1Var.O();
            } else {
                zU = no1Var.u();
            }
        }
        return new bp3(strF, z6VarB, o6VarI, j6VarE, zU);
    }
}

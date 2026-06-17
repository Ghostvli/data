package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;
import defpackage.p54;
import org.jupnp.support.messagebox.parser.MessageElement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q54 {
    public static final no1.a a = no1.a.a(SardineUtil.CUSTOM_NAMESPACE_PREFIX, "e", "o", "nm", MessageElement.XPATH_PREFIX, "hd");

    public static p54 a(no1 no1Var, f12 f12Var) {
        String strF = null;
        p54.a aVarB = null;
        j6 j6VarF = null;
        j6 j6VarF2 = null;
        j6 j6VarF3 = null;
        boolean zU = false;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                j6VarF = a7.f(no1Var, f12Var, false);
            } else if (iM == 1) {
                j6VarF2 = a7.f(no1Var, f12Var, false);
            } else if (iM == 2) {
                j6VarF3 = a7.f(no1Var, f12Var, false);
            } else if (iM == 3) {
                strF = no1Var.F();
            } else if (iM == 4) {
                aVarB = p54.a.b(no1Var.y());
            } else if (iM != 5) {
                no1Var.O();
            } else {
                zU = no1Var.u();
            }
        }
        return new p54(strF, aVarB, j6VarF, j6VarF2, j6VarF3, zU);
    }
}

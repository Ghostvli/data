package defpackage;

import android.graphics.Path;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cb1 {
    public static final no1.a a = no1.a.a("nm", "g", "o", "t", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "e", "r", "hd");
    public static final no1.a b = no1.a.a("p", "k");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ab1 a(no1 no1Var, f12 f12Var) {
        l6 l6Var = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strF = null;
        gb1 gb1Var = null;
        k6 k6VarG = null;
        o6 o6VarI = null;
        o6 o6VarI2 = null;
        boolean zU = false;
        while (no1Var.t()) {
            switch (no1Var.M(a)) {
                case 0:
                    strF = no1Var.F();
                    break;
                case 1:
                    no1Var.h();
                    int iY = -1;
                    while (no1Var.t()) {
                        int iM = no1Var.M(b);
                        if (iM == 0) {
                            iY = no1Var.y();
                        } else if (iM != 1) {
                            no1Var.N();
                            no1Var.O();
                        } else {
                            k6VarG = a7.g(no1Var, f12Var, iY);
                        }
                    }
                    no1Var.l();
                    break;
                case 2:
                    l6Var = a7.h(no1Var, f12Var);
                    break;
                case 3:
                    gb1Var = no1Var.y() == 1 ? gb1.LINEAR : gb1.RADIAL;
                    break;
                case 4:
                    o6VarI = a7.i(no1Var, f12Var);
                    break;
                case 5:
                    o6VarI2 = a7.i(no1Var, f12Var);
                    break;
                case 6:
                    fillType = no1Var.y() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zU = no1Var.u();
                    break;
                default:
                    no1Var.N();
                    no1Var.O();
                    break;
            }
        }
        if (l6Var == null) {
            l6Var = new l6(Collections.singletonList(new dr1(100)));
        }
        return new ab1(strF, gb1Var, fillType, k6VarG, l6Var, o6VarI, o6VarI2, null, null, zU);
    }
}

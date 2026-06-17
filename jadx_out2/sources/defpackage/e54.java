package defpackage;

import android.graphics.Path;
import defpackage.no1;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e54 {
    public static final no1.a a = no1.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d54 a(no1 no1Var, f12 f12Var) {
        l6 l6Var = null;
        String strF = null;
        i6 i6VarC = null;
        boolean zU = false;
        boolean zU2 = false;
        int iY = 1;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
            } else if (iM == 1) {
                i6VarC = a7.c(no1Var, f12Var);
            } else if (iM == 2) {
                l6Var = a7.h(no1Var, f12Var);
            } else if (iM == 3) {
                zU = no1Var.u();
            } else if (iM == 4) {
                iY = no1Var.y();
            } else if (iM != 5) {
                no1Var.N();
                no1Var.O();
            } else {
                zU2 = no1Var.u();
            }
        }
        if (l6Var == null) {
            l6Var = new l6(Collections.singletonList(new dr1(100)));
        }
        return new d54(strF, zU, iY == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, i6VarC, l6Var, zU2);
    }
}

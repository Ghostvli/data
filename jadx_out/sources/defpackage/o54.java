package defpackage;

import defpackage.n54;
import defpackage.no1;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o54 {
    public static final no1.a a = no1.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
    public static final no1.a b = no1.a.a("n", "v");

    /* JADX WARN: Multi-variable type inference failed */
    public static n54 a(no1 no1Var, f12 f12Var) {
        Object objE;
        ArrayList arrayList = new ArrayList();
        String strF = null;
        n54.b bVar = null;
        n54.c cVar = null;
        Object obj = null;
        i6 i6VarC = null;
        j6 j6VarE = null;
        String str = null;
        float fV = 0.0f;
        boolean zU = false;
        l6 l6Var = null;
        while (no1Var.t()) {
            switch (no1Var.M(a)) {
                case 0:
                    strF = no1Var.F();
                    break;
                case 1:
                    i6VarC = a7.c(no1Var, f12Var);
                    break;
                case 2:
                    j6VarE = a7.e(no1Var, f12Var);
                    break;
                case 3:
                    l6Var = a7.h(no1Var, f12Var);
                    break;
                case 4:
                    bVar = n54.b.values()[no1Var.y() - 1];
                    break;
                case 5:
                    cVar = n54.c.values()[no1Var.y() - 1];
                    break;
                case 6:
                    fV = (float) no1Var.v();
                    break;
                case 7:
                    zU = no1Var.u();
                    break;
                case 8:
                    no1Var.c();
                    while (no1Var.t()) {
                        no1Var.h();
                        String strF2 = str;
                        objE = strF2;
                        while (no1Var.t()) {
                            int iM = no1Var.M(b);
                            if (iM == 0) {
                                strF2 = no1Var.F();
                            } else if (iM != 1) {
                                no1Var.N();
                                no1Var.O();
                            } else {
                                objE = a7.e(no1Var, f12Var);
                            }
                        }
                        no1Var.l();
                        strF2.getClass();
                        switch (strF2) {
                            case "d":
                            case "g":
                                f12Var.u(true);
                                arrayList.add(objE);
                                break;
                            case "o":
                                obj = objE;
                                break;
                        }
                        str = null;
                    }
                    no1Var.i();
                    if (arrayList.size() == 1) {
                        arrayList.add((j6) arrayList.get(0));
                    }
                    break;
                default:
                    no1Var.O();
                    continue;
            }
            str = null;
        }
        if (l6Var == null) {
            l6Var = new l6(Collections.singletonList(new dr1(100)));
        }
        if (bVar == null) {
            bVar = n54.b.BUTT;
        }
        if (cVar == null) {
            cVar = n54.c.MITER;
        }
        return new n54(strF, obj, arrayList, i6VarC, l6Var, j6VarE, bVar, cVar, fV, zU);
    }
}

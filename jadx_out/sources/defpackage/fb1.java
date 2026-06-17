package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.n54;
import defpackage.no1;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fb1 {
    public static final no1.a a = no1.a.a("nm", "g", "o", "t", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "e", "w", "lc", "lj", "ml", "hd", "d");
    public static final no1.a b = no1.a.a("p", "k");
    public static final no1.a c = no1.a.a("n", "v");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0027. Please report as an issue. */
    public static db1 a(no1 no1Var, f12 f12Var) {
        l6 l6Var;
        ArrayList arrayList = new ArrayList();
        gb1 gb1Var = null;
        String strF = null;
        k6 k6VarG = null;
        o6 o6VarI = null;
        o6 o6VarI2 = null;
        j6 j6VarE = null;
        n54.b bVar = null;
        n54.c cVar = null;
        j6 j6Var = null;
        float fV = 0.0f;
        boolean zU = false;
        l6 l6VarH = null;
        while (no1Var.t()) {
            gb1 gb1Var2 = gb1Var;
            switch (no1Var.M(a)) {
                case 0:
                    strF = no1Var.F();
                    gb1Var = gb1Var2;
                    break;
                case 1:
                    l6Var = l6VarH;
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
                    gb1Var = gb1Var2;
                    l6VarH = l6Var;
                    break;
                case 2:
                    l6VarH = a7.h(no1Var, f12Var);
                    gb1Var = gb1Var2;
                    break;
                case 3:
                    l6Var = l6VarH;
                    gb1Var = no1Var.y() == 1 ? gb1.LINEAR : gb1.RADIAL;
                    l6VarH = l6Var;
                    break;
                case 4:
                    o6VarI = a7.i(no1Var, f12Var);
                    gb1Var = gb1Var2;
                    break;
                case 5:
                    o6VarI2 = a7.i(no1Var, f12Var);
                    gb1Var = gb1Var2;
                    break;
                case 6:
                    j6VarE = a7.e(no1Var, f12Var);
                    gb1Var = gb1Var2;
                    break;
                case 7:
                    l6Var = l6VarH;
                    bVar = n54.b.values()[no1Var.y() - 1];
                    gb1Var = gb1Var2;
                    l6VarH = l6Var;
                    break;
                case 8:
                    l6Var = l6VarH;
                    cVar = n54.c.values()[no1Var.y() - 1];
                    gb1Var = gb1Var2;
                    l6VarH = l6Var;
                    break;
                case 9:
                    l6Var = l6VarH;
                    fV = (float) no1Var.v();
                    gb1Var = gb1Var2;
                    l6VarH = l6Var;
                    break;
                case 10:
                    zU = no1Var.u();
                    gb1Var = gb1Var2;
                    break;
                case 11:
                    no1Var.c();
                    while (no1Var.t()) {
                        no1Var.h();
                        String strF2 = null;
                        j6 j6VarE2 = null;
                        while (no1Var.t()) {
                            int iM2 = no1Var.M(c);
                            if (iM2 != 0) {
                                l6 l6Var2 = l6VarH;
                                if (iM2 != 1) {
                                    no1Var.N();
                                    no1Var.O();
                                } else {
                                    j6VarE2 = a7.e(no1Var, f12Var);
                                }
                                l6VarH = l6Var2;
                            } else {
                                strF2 = no1Var.F();
                            }
                        }
                        l6 l6Var3 = l6VarH;
                        no1Var.l();
                        if (strF2.equals("o")) {
                            j6Var = j6VarE2;
                        } else {
                            if (strF2.equals("d") || strF2.equals("g")) {
                                f12Var.u(true);
                                arrayList.add(j6VarE2);
                            }
                            l6VarH = l6Var3;
                        }
                        l6VarH = l6Var3;
                    }
                    l6Var = l6VarH;
                    no1Var.i();
                    if (arrayList.size() == 1) {
                        arrayList.add((j6) arrayList.get(0));
                    }
                    gb1Var = gb1Var2;
                    l6VarH = l6Var;
                    break;
                default:
                    no1Var.N();
                    no1Var.O();
                    gb1Var = gb1Var2;
                    break;
            }
        }
        l6 l6Var4 = l6VarH;
        return new db1(strF, gb1Var, k6VarG, l6Var4 == null ? new l6(Collections.singletonList(new dr1(100))) : l6Var4, o6VarI, o6VarI2, j6VarE, bVar, cVar, fV, arrayList, j6Var, zU);
    }
}

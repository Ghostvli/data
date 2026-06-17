package defpackage;

import android.graphics.Rect;
import defpackage.no1;
import defpackage.yr1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p12 {
    public static final no1.a a = no1.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    public static no1.a b = no1.a.a(Name.MARK, "layers", "w", "h", "p", "u");
    public static final no1.a c = no1.a.a("list");
    public static final no1.a d = no1.a.a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0044. Please report as an issue. */
    public static f12 a(no1 no1Var) {
        float f;
        no1 no1Var2 = no1Var;
        float fE = uy4.e();
        w02 w02Var = new w02();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        mb4 mb4Var = new mb4();
        f12 f12Var = new f12();
        no1Var2.h();
        float fV = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        int iV = 0;
        int iV2 = 0;
        while (no1Var2.t()) {
            switch (no1Var2.M(a)) {
                case 0:
                    f = fE;
                    iV2 = (int) no1Var.v();
                    no1Var2 = no1Var;
                    fE = f;
                    break;
                case 1:
                    f = fE;
                    iV = (int) no1Var.v();
                    no1Var2 = no1Var;
                    fE = f;
                    break;
                case 2:
                    f = fE;
                    fV = (float) no1Var.v();
                    no1Var2 = no1Var;
                    fE = f;
                    break;
                case 3:
                    f = fE;
                    fV2 = ((float) no1Var.v()) - 0.01f;
                    no1Var2 = no1Var;
                    fE = f;
                    break;
                case 4:
                    f = fE;
                    fV3 = (float) no1Var.v();
                    no1Var2 = no1Var;
                    fE = f;
                    break;
                case 5:
                    String[] strArrSplit = no1Var2.F().split("\\.");
                    if (!uy4.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        f12Var.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    no1Var2 = no1Var;
                    break;
                case 6:
                    e(no1Var2, f12Var, arrayList, w02Var);
                    no1Var2 = no1Var;
                    break;
                case 7:
                    b(no1Var2, f12Var, map, map2);
                    no1Var2 = no1Var;
                    break;
                case 8:
                    d(no1Var2, map3);
                    no1Var2 = no1Var;
                    break;
                case 9:
                    c(no1Var2, f12Var, mb4Var);
                    no1Var2 = no1Var;
                    break;
                case 10:
                    f(no1Var2, arrayList2);
                    no1Var2 = no1Var;
                    break;
                default:
                    no1Var2.N();
                    no1Var2.O();
                    no1Var2 = no1Var;
                    break;
            }
        }
        float f2 = fE;
        f12Var.s(new Rect(0, 0, (int) (iV2 * f2), (int) (iV * f2)), fV, fV2, fV3, arrayList, w02Var, map, map2, uy4.e(), mb4Var, map3, arrayList2, iV2, iV);
        return f12Var;
    }

    public static void b(no1 no1Var, f12 f12Var, Map map, Map map2) {
        no1Var.c();
        while (no1Var.t()) {
            ArrayList arrayList = new ArrayList();
            w02 w02Var = new w02();
            no1Var.h();
            int iY = 0;
            int iY2 = 0;
            String strF = null;
            String strF2 = null;
            String strF3 = null;
            while (no1Var.t()) {
                int iM = no1Var.M(b);
                if (iM == 0) {
                    strF = no1Var.F();
                } else if (iM == 1) {
                    no1Var.c();
                    while (no1Var.t()) {
                        yr1 yr1VarA = zr1.a(no1Var, f12Var);
                        w02Var.h(yr1VarA.e(), yr1VarA);
                        arrayList.add(yr1VarA);
                    }
                    no1Var.i();
                } else if (iM == 2) {
                    iY = no1Var.y();
                } else if (iM == 3) {
                    iY2 = no1Var.y();
                } else if (iM == 4) {
                    strF2 = no1Var.F();
                } else if (iM != 5) {
                    no1Var.N();
                    no1Var.O();
                } else {
                    strF3 = no1Var.F();
                }
            }
            no1Var.l();
            if (strF2 != null) {
                l22 l22Var = new l22(iY, iY2, strF, strF2, strF3);
                map2.put(l22Var.e(), l22Var);
            } else {
                map.put(strF, arrayList);
            }
        }
        no1Var.i();
    }

    public static void c(no1 no1Var, f12 f12Var, mb4 mb4Var) {
        no1Var.c();
        while (no1Var.t()) {
            b41 b41VarA = c41.a(no1Var, f12Var);
            mb4Var.g(b41VarA.hashCode(), b41VarA);
        }
        no1Var.i();
    }

    public static void d(no1 no1Var, Map map) {
        no1Var.h();
        while (no1Var.t()) {
            if (no1Var.M(c) != 0) {
                no1Var.N();
                no1Var.O();
            } else {
                no1Var.c();
                while (no1Var.t()) {
                    y31 y31VarA = d41.a(no1Var);
                    map.put(y31VarA.b(), y31VarA);
                }
                no1Var.i();
            }
        }
        no1Var.l();
    }

    public static void e(no1 no1Var, f12 f12Var, List list, w02 w02Var) {
        no1Var.c();
        int i = 0;
        while (no1Var.t()) {
            yr1 yr1VarA = zr1.a(no1Var, f12Var);
            if (yr1VarA.g() == yr1.a.IMAGE) {
                i++;
            }
            list.add(yr1VarA);
            w02Var.h(yr1VarA.e(), yr1VarA);
            if (i > 4) {
                k02.c("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        no1Var.i();
    }

    public static void f(no1 no1Var, List list) {
        no1Var.c();
        while (no1Var.t()) {
            no1Var.h();
            float fV = 0.0f;
            String strF = null;
            float fV2 = 0.0f;
            while (no1Var.t()) {
                int iM = no1Var.M(d);
                if (iM == 0) {
                    strF = no1Var.F();
                } else if (iM == 1) {
                    fV = (float) no1Var.v();
                } else if (iM != 2) {
                    no1Var.N();
                    no1Var.O();
                } else {
                    fV2 = (float) no1Var.v();
                }
            }
            no1Var.l();
            list.add(new c52(strF, fV, fV2));
        }
        no1Var.i();
    }
}

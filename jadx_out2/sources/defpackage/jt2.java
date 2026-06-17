package defpackage;

import defpackage.bu3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jt2 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean a(bu3.e eVar, int i, int i2) {
        eVar.getClass();
        Map mapE = eVar.e();
        if (!mapE.containsKey(Integer.valueOf(i))) {
            return false;
        }
        Map mapH = (Map) mapE.get(Integer.valueOf(i));
        if (mapH == null) {
            mapH = y42.h();
        }
        return mapH.containsKey(Integer.valueOf(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final List b(bu3.e eVar, int i, int i2) {
        eVar.getClass();
        if (i == i2) {
            return ow.j();
        }
        return c(eVar, new ArrayList(), i2 > i, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final List c(bu3.e eVar, List list, boolean z, int i, int i2) {
        int iIntValue;
        boolean z2;
        while (true) {
            if (z) {
                if (i >= i2) {
                    return list;
                }
            } else if (i <= i2) {
                return list;
            }
            i73 i73VarF = z ? eVar.f(i) : eVar.g(i);
            if (i73VarF == null) {
                return null;
            }
            Map map = (Map) i73VarF.a();
            Iterator it = ((Iterable) i73VarF.b()).iterator();
            while (it.hasNext()) {
                iIntValue = ((Number) it.next()).intValue();
                if (!z) {
                    if (i2 <= iIntValue && iIntValue < i) {
                        Object obj = map.get(Integer.valueOf(iIntValue));
                        obj.getClass();
                        list.add(obj);
                        z2 = true;
                        break;
                    }
                } else if (i + 1 <= iIntValue && iIntValue <= i2) {
                    Object obj2 = map.get(Integer.valueOf(iIntValue));
                    obj2.getClass();
                    list.add(obj2);
                    z2 = true;
                    break;
                }
            }
            iIntValue = i;
            z2 = false;
            if (!z2) {
                return null;
            }
            i = iIntValue;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean d(ma0 ma0Var, int i, int i2) {
        ma0Var.getClass();
        if (i > i2 && ma0Var.l) {
            return false;
        }
        Set setC = ma0Var.c();
        return ma0Var.k && (setC == null || !setC.contains(Integer.valueOf(i)));
    }
}

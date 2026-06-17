package defpackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xy3 extends bl4 {
    public long b;
    public long[] c;
    public long[] d;

    public xy3() {
        super(new wl0());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    public static Boolean g(r73 r73Var) {
        return Boolean.valueOf(r73Var.Q() == 1);
    }

    public static Object h(r73 r73Var, int i) {
        if (i == 0) {
            return j(r73Var);
        }
        if (i == 1) {
            return g(r73Var);
        }
        if (i == 2) {
            return n(r73Var);
        }
        if (i == 3) {
            return l(r73Var);
        }
        if (i == 8) {
            return k(r73Var);
        }
        if (i == 10) {
            return m(r73Var);
        }
        if (i != 11) {
            return null;
        }
        return i(r73Var);
    }

    public static Date i(r73 r73Var) {
        Date date = new Date((long) j(r73Var).doubleValue());
        r73Var.g0(2);
        return date;
    }

    public static Double j(r73 r73Var) {
        return Double.valueOf(Double.longBitsToDouble(r73Var.J()));
    }

    public static HashMap k(r73 r73Var) {
        int iU = r73Var.U();
        HashMap map = new HashMap(iU);
        for (int i = 0; i < iU; i++) {
            String strN = n(r73Var);
            Object objH = h(r73Var, o(r73Var));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    public static HashMap l(r73 r73Var) {
        HashMap map = new HashMap();
        while (true) {
            String strN = n(r73Var);
            int iO = o(r73Var);
            if (iO == 9) {
                return map;
            }
            Object objH = h(r73Var, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    public static ArrayList m(r73 r73Var) {
        int iU = r73Var.U();
        ArrayList arrayList = new ArrayList(iU);
        for (int i = 0; i < iU; i++) {
            Object objH = h(r73Var, o(r73Var));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    public static String n(r73 r73Var) {
        int iY = r73Var.Y();
        int iG = r73Var.g();
        r73Var.g0(iY);
        return new String(r73Var.f(), iG, iY);
    }

    public static int o(r73 r73Var) {
        return r73Var.Q();
    }

    @Override // defpackage.bl4
    public boolean b(r73 r73Var) {
        return true;
    }

    @Override // defpackage.bl4
    public boolean c(r73 r73Var, long j) {
        if (o(r73Var) != 2 || !"onMetaData".equals(n(r73Var)) || r73Var.a() == 0 || o(r73Var) != 8) {
            return false;
        }
        HashMap mapK = k(r73Var);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.b;
    }

    public long[] e() {
        return this.d;
    }

    public long[] f() {
        return this.c;
    }
}

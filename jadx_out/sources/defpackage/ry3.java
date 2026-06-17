package defpackage;

import defpackage.xk4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ry3 {
    public static final String[] a = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return sx.a((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return sx.a((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
        }
    }

    public static final int a(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        if (wg4.P(upperCase, "INT", false, 2, null)) {
            return 3;
        }
        if (wg4.P(upperCase, "CHAR", false, 2, null) || wg4.P(upperCase, "CLOB", false, 2, null) || wg4.P(upperCase, "TEXT", false, 2, null)) {
            return 2;
        }
        if (wg4.P(upperCase, "BLOB", false, 2, null)) {
            return 5;
        }
        return (wg4.P(upperCase, "REAL", false, 2, null) || wg4.P(upperCase, "FLOA", false, 2, null) || wg4.P(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
    }

    public static final Map b(lw3 lw3Var, String str) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA table_info(`" + str + "`)");
        try {
            if (!ow3VarA0.Y()) {
                Map mapH = y42.h();
                ne.a(ow3VarA0, null);
                return mapH;
            }
            int iA = pw3.a(ow3VarA0, "name");
            int iA2 = pw3.a(ow3VarA0, "type");
            int iA3 = pw3.a(ow3VarA0, "notnull");
            int iA4 = pw3.a(ow3VarA0, "pk");
            int iA5 = pw3.a(ow3VarA0, "dflt_value");
            Map mapC = x42.c();
            do {
                String strI = ow3VarA0.I(iA);
                mapC.put(strI, new xk4.a(strI, ow3VarA0.I(iA2), ow3VarA0.getLong(iA3) != 0, (int) ow3VarA0.getLong(iA4), ow3VarA0.isNull(iA5) ? null : ow3VarA0.I(iA5), 2));
            } while (ow3VarA0.Y());
            Map mapB = x42.b(mapC);
            ne.a(ow3VarA0, null);
            return mapB;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ne.a(ow3VarA0, th);
                throw th2;
            }
        }
    }

    public static final List c(ow3 ow3Var) {
        int iA = pw3.a(ow3Var, Name.MARK);
        int iA2 = pw3.a(ow3Var, "seq");
        int iA3 = pw3.a(ow3Var, "from");
        int iA4 = pw3.a(ow3Var, "to");
        List listC = nw.c();
        while (ow3Var.Y()) {
            listC.add(new o41((int) ow3Var.getLong(iA), (int) ow3Var.getLong(iA2), ow3Var.I(iA3), ow3Var.I(iA4)));
        }
        return ww.W(nw.a(listC));
    }

    public static final Set d(lw3 lw3Var, String str) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int iA = pw3.a(ow3VarA0, Name.MARK);
            int iA2 = pw3.a(ow3VarA0, "seq");
            int iA3 = pw3.a(ow3VarA0, "table");
            int iA4 = pw3.a(ow3VarA0, "on_delete");
            int iA5 = pw3.a(ow3VarA0, "on_update");
            List listC = c(ow3VarA0);
            ow3VarA0.reset();
            Set setB = n24.b();
            while (ow3VarA0.Y()) {
                if (ow3VarA0.getLong(iA2) == 0) {
                    int i = (int) ow3VarA0.getLong(iA);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<o41> arrayList3 = new ArrayList();
                    for (Object obj : listC) {
                        if (((o41) obj).e() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (o41 o41Var : arrayList3) {
                        arrayList.add(o41Var.b());
                        arrayList2.add(o41Var.f());
                    }
                    setB.add(new xk4.c(ow3VarA0.I(iA3), ow3VarA0.I(iA4), ow3VarA0.I(iA5), arrayList, arrayList2));
                }
            }
            Set setA = n24.a(setB);
            ne.a(ow3VarA0, null);
            return setA;
        } finally {
        }
    }

    public static final xk4.d e(lw3 lw3Var, String str, boolean z) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iA = pw3.a(ow3VarA0, "seqno");
            int iA2 = pw3.a(ow3VarA0, "cid");
            int iA3 = pw3.a(ow3VarA0, "name");
            int iA4 = pw3.a(ow3VarA0, "desc");
            if (iA != -1 && iA2 != -1 && iA3 != -1 && iA4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (ow3VarA0.Y()) {
                    if (((int) ow3VarA0.getLong(iA2)) >= 0) {
                        int i = (int) ow3VarA0.getLong(iA);
                        String strI = ow3VarA0.I(iA3);
                        String str2 = ow3VarA0.getLong(iA4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i), strI);
                        linkedHashMap2.put(Integer.valueOf(i), str2);
                    }
                }
                List listX = ww.X(linkedHashMap.entrySet(), new a());
                ArrayList arrayList = new ArrayList(pw.t(listX, 10));
                Iterator it = listX.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listA0 = ww.a0(arrayList);
                List listX2 = ww.X(linkedHashMap2.entrySet(), new b());
                ArrayList arrayList2 = new ArrayList(pw.t(listX2, 10));
                Iterator it2 = listX2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                xk4.d dVar = new xk4.d(str, z, listA0, ww.a0(arrayList2));
                ne.a(ow3VarA0, null);
                return dVar;
            }
            ne.a(ow3VarA0, null);
            return null;
        } finally {
        }
    }

    public static final Set f(lw3 lw3Var, String str) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA index_list(`" + str + "`)");
        try {
            int iA = pw3.a(ow3VarA0, "name");
            int iA2 = pw3.a(ow3VarA0, "origin");
            int iA3 = pw3.a(ow3VarA0, "unique");
            if (iA != -1 && iA2 != -1 && iA3 != -1) {
                Set setB = n24.b();
                while (ow3VarA0.Y()) {
                    if (il1.a("c", ow3VarA0.I(iA2))) {
                        xk4.d dVarE = e(lw3Var, ow3VarA0.I(iA), ow3VarA0.getLong(iA3) == 1);
                        if (dVarE == null) {
                            ne.a(ow3VarA0, null);
                            return null;
                        }
                        setB.add(dVarE);
                    }
                }
                Set setA = n24.a(setB);
                ne.a(ow3VarA0, null);
                return setA;
            }
            ne.a(ow3VarA0, null);
            return null;
        } finally {
        }
    }

    public static final xk4 g(lw3 lw3Var, String str) {
        lw3Var.getClass();
        str.getClass();
        return new xk4(str, b(lw3Var, str), d(lw3Var, str), f(lw3Var, str));
    }
}

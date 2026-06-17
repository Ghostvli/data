package defpackage;

import defpackage.xk4;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yk4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return sx.a(((xk4.a) obj).a, ((xk4.a) obj2).a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return sx.a(((xk4.d) obj).a, ((xk4.d) obj2).a);
        }
    }

    public static final boolean a(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            int i4 = i3 + 1;
            if (i3 == 0 && cCharAt != '(') {
                return false;
            }
            if (cCharAt == '(') {
                i2++;
            } else if (cCharAt == ')' && i2 - 1 == 0 && i3 != str.length() - 1) {
                return false;
            }
            i++;
            i3 = i4;
        }
        return i2 == 0;
    }

    public static final boolean b(String str, String str2) {
        str.getClass();
        if (il1.a(str, str2)) {
            return true;
        }
        if (a(str)) {
            return il1.a(wg4.O0(str.substring(1, str.length() - 1)).toString(), str2);
        }
        return false;
    }

    public static final boolean c(xk4.a aVar, Object obj) {
        aVar.getClass();
        if (aVar == obj) {
            return true;
        }
        if (!(obj instanceof xk4.a)) {
            return false;
        }
        xk4.a aVar2 = (xk4.a) obj;
        if (aVar.a() != aVar2.a() || !il1.a(aVar.a, aVar2.a) || aVar.c != aVar2.c) {
            return false;
        }
        String str = aVar.e;
        String str2 = aVar2.e;
        if (aVar.f == 1 && aVar2.f == 2 && str != null && !b(str, str2)) {
            return false;
        }
        if (aVar.f == 2 && aVar2.f == 1 && str2 != null && !b(str2, str)) {
            return false;
        }
        int i = aVar.f;
        return (i == 0 || i != aVar2.f || (str == null ? str2 == null : b(str, str2))) && aVar.g == aVar2.g;
    }

    public static final boolean d(xk4.c cVar, Object obj) {
        cVar.getClass();
        if (cVar == obj) {
            return true;
        }
        if (!(obj instanceof xk4.c)) {
            return false;
        }
        xk4.c cVar2 = (xk4.c) obj;
        if (il1.a(cVar.a, cVar2.a) && il1.a(cVar.b, cVar2.b) && il1.a(cVar.c, cVar2.c) && il1.a(cVar.d, cVar2.d)) {
            return il1.a(cVar.e, cVar2.e);
        }
        return false;
    }

    public static final boolean e(xk4.d dVar, Object obj) {
        dVar.getClass();
        if (dVar == obj) {
            return true;
        }
        if (!(obj instanceof xk4.d)) {
            return false;
        }
        xk4.d dVar2 = (xk4.d) obj;
        if (dVar.b == dVar2.b && il1.a(dVar.c, dVar2.c) && il1.a(dVar.d, dVar2.d)) {
            return sg4.K(dVar.a, "index_", false, 2, null) ? sg4.K(dVar2.a, "index_", false, 2, null) : il1.a(dVar.a, dVar2.a);
        }
        return false;
    }

    public static final boolean f(xk4 xk4Var, Object obj) {
        Set set;
        xk4Var.getClass();
        if (xk4Var == obj) {
            return true;
        }
        if (!(obj instanceof xk4)) {
            return false;
        }
        xk4 xk4Var2 = (xk4) obj;
        if (!il1.a(xk4Var.a, xk4Var2.a) || !il1.a(xk4Var.b, xk4Var2.b) || !il1.a(xk4Var.c, xk4Var2.c)) {
            return false;
        }
        Set set2 = xk4Var.d;
        if (set2 == null || (set = xk4Var2.d) == null) {
            return true;
        }
        return il1.a(set2, set);
    }

    public static final String g(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return " }";
        }
        return lg4.j(ww.P(collection, ",\n", "\n", "\n", 0, null, null, 56, null), null, 1, null) + "},";
    }

    public static final int h(xk4.a aVar) {
        aVar.getClass();
        return (((((aVar.a.hashCode() * 31) + aVar.g) * 31) + (aVar.c ? 1231 : 1237)) * 31) + aVar.d;
    }

    public static final int i(xk4.c cVar) {
        cVar.getClass();
        return (((((((cVar.a.hashCode() * 31) + cVar.b.hashCode()) * 31) + cVar.c.hashCode()) * 31) + cVar.d.hashCode()) * 31) + cVar.e.hashCode();
    }

    public static final int j(xk4.d dVar) {
        dVar.getClass();
        return ((((((sg4.K(dVar.a, "index_", false, 2, null) ? -1184239155 : dVar.a.hashCode()) * 31) + (dVar.b ? 1 : 0)) * 31) + dVar.c.hashCode()) * 31) + dVar.d.hashCode();
    }

    public static final int k(xk4 xk4Var) {
        xk4Var.getClass();
        return (((xk4Var.a.hashCode() * 31) + xk4Var.b.hashCode()) * 31) + xk4Var.c.hashCode();
    }

    public static final String l(Collection collection) {
        return lg4.j(ww.P(collection, ",", null, null, 0, null, null, 62, null), null, 1, null) + lg4.j(" }", null, 1, null);
    }

    public static final String m(Collection collection) {
        return lg4.j(ww.P(collection, ",", null, null, 0, null, null, 62, null), null, 1, null) + lg4.j("},", null, 1, null);
    }

    public static final String n(xk4.a aVar) {
        aVar.getClass();
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(aVar.a);
        sb.append("',\n            |   type = '");
        sb.append(aVar.b);
        sb.append("',\n            |   affinity = '");
        sb.append(aVar.g);
        sb.append("',\n            |   notNull = '");
        sb.append(aVar.c);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(aVar.d);
        sb.append("',\n            |   defaultValue = '");
        String str = aVar.e;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return lg4.j(lg4.p(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final String o(xk4.c cVar) {
        cVar.getClass();
        return lg4.j(lg4.p("\n            |ForeignKey {\n            |   referenceTable = '" + cVar.a + "',\n            |   onDelete = '" + cVar.b + "',\n            |   onUpdate = '" + cVar.c + "',\n            |   columnNames = {" + m(ww.W(cVar.d)) + "\n            |   referenceColumnNames = {" + l(ww.W(cVar.e)) + "\n            |}\n        ", null, 1, null), null, 1, null);
    }

    public static final String p(xk4.d dVar) {
        dVar.getClass();
        return lg4.j(lg4.p("\n            |Index {\n            |   name = '" + dVar.a + "',\n            |   unique = '" + dVar.b + "',\n            |   columns = {" + m(dVar.c) + "\n            |   orders = {" + l(dVar.d) + "\n            |}\n        ", null, 1, null), null, 1, null);
    }

    public static final String q(xk4 xk4Var) {
        List listJ;
        xk4Var.getClass();
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(xk4Var.a);
        sb.append("',\n            |    columns = {");
        sb.append(g(ww.X(xk4Var.b.values(), new a())));
        sb.append("\n            |    foreignKeys = {");
        sb.append(g(xk4Var.c));
        sb.append("\n            |    indices = {");
        Set set = xk4Var.d;
        if (set == null || (listJ = ww.X(set, new b())) == null) {
            listJ = ow.j();
        }
        sb.append(g(listJ));
        sb.append("\n            |}\n        ");
        return lg4.p(sb.toString(), null, 1, null);
    }
}

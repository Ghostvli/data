package defpackage;

import android.net.Uri;
import defpackage.ze1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ef1 {
    public final a a;
    public final HashMap b;
    public final List c;
    public String d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ef1(a aVar, String str, Uri uri, int i) {
        this.a = aVar;
        HashMap map = new HashMap();
        this.b = map;
        map.put(str, uri);
        this.d = str;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 a(List list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            ze1.a aVar = (ze1.a) list.get(i);
            if (aVar.a != null) {
                try {
                    h(aVar.a, null, i, arrayList, new a(aVar.b, aVar.e, aVar.d), map, map2);
                } catch (r83 unused) {
                }
            }
        }
        return xi1.p(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 b(List list) throws r83 {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            ze1.b bVar = (ze1.b) list.get(i);
            h(bVar.a, bVar.g, i, arrayList, new a(bVar.b, bVar.h), map, map2);
        }
        return xi1.p(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(Uri uri, String str, int i, List list, a aVar, Map map, Map map2) throws r83 {
        Integer num = (Integer) map.get(aVar);
        if (num == null) {
            map2.put(aVar, 0);
            if (str == null) {
                map2.put(aVar, 1);
                str = ".";
            }
            ef1 ef1Var = new ef1(aVar, str, uri, i);
            map.put(aVar, Integer.valueOf(list.size()));
            list.add(ef1Var);
            return;
        }
        if (str == null) {
            int iIntValue = ((Integer) gg3.q((Integer) map2.get(aVar))).intValue() + 1;
            String strE = gg4.e(".", iIntValue);
            map2.put(aVar, Integer.valueOf(iIntValue));
            str = strE;
        }
        ef1 ef1Var2 = (ef1) list.get(num.intValue());
        Uri uriG = ef1Var2.g(str);
        if (uriG != null && !uri.equals(uriG)) {
            throw r83.c(String.format("Different playlist URLs are found for pathway ID %s within the HlsRedundantGroup", str), null);
        }
        ef1Var2.i(str, uri, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dj1 c() {
        return dj1.p(this.b.keySet());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dj1 d() {
        return dj1.p(this.b.values());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String e() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Uri f() {
        return (Uri) gg3.q((Uri) this.b.get(this.d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Uri g(String str) {
        return (Uri) this.b.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(String str, Uri uri, int i) {
        this.b.put(str, uri);
        if (i != -1) {
            this.c.add(Integer.valueOf(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(String str) {
        gg3.v(this.b.containsKey(str));
        this.d = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k() {
        return this.b.size();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final t41 a;
        public final String b;
        public final String c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(t41 t41Var, String str, String str2) {
            this.a = t41Var.b().k0(null).s0(null).Q();
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && Objects.equals(this.b, aVar.b) && Objects.equals(this.c, aVar.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return Objects.hash(this.a, this.b, this.c);
        }

        public a(t41 t41Var, String str) {
            this(t41Var, str, null);
        }
    }
}

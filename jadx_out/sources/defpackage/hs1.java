package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hs1 implements cd1 {
    public final Map c;
    public volatile Map d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final String d;
        public static final Map e;
        public boolean a = true;
        public Map b = e;
        public boolean c = true;

        static {
            String strG = g();
            d = strG;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strG)) {
                map.put("User-Agent", Collections.singletonList(new b(strG)));
            }
            e = Collections.unmodifiableMap(map);
        }

        public static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(String str, gs1 gs1Var) {
            if (this.c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, gs1Var);
            }
            e();
            f(str).add(gs1Var);
            return this;
        }

        public a b(String str, String str2) {
            return a(str, new b(str2));
        }

        public hs1 c() {
            this.a = true;
            return new hs1(this.b);
        }

        public final Map d() {
            HashMap map = new HashMap(this.b.size());
            for (Map.Entry entry : this.b.entrySet()) {
                map.put((String) entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            return map;
        }

        public final void e() {
            if (this.a) {
                this.a = false;
                this.b = d();
            }
        }

        public final List f(String str) {
            List list = (List) this.b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.b.put(str, arrayList);
            return arrayList;
        }

        public a h(String str, gs1 gs1Var) {
            e();
            if (gs1Var == null) {
                this.b.remove(str);
            } else {
                List listF = f(str);
                listF.clear();
                listF.add(gs1Var);
            }
            if (this.c && "User-Agent".equalsIgnoreCase(str)) {
                this.c = false;
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements gs1 {
        public final String a;

        public b(String str) {
            this.a = str;
        }

        @Override // defpackage.gs1
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    public hs1(Map map) {
        this.c = Collections.unmodifiableMap(map);
    }

    public final String a(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strA = ((gs1) list.get(i)).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final Map b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.c.entrySet()) {
            String strA = a((List) entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put((String) entry.getKey(), strA);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof hs1) {
            return this.c.equals(((hs1) obj).c);
        }
        return false;
    }

    @Override // defpackage.cd1
    public Map getHeaders() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}

package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class xq3 {
    public final String a;
    public final String b;
    public final Map c;
    public final byte[] d;
    public final pz1 e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public String a;
        public String b;
        public byte[] d;
        public pz1 e;
        public final Map c = new LinkedHashMap();
        public boolean f = true;

        public xq3 g() {
            return new xq3(this);
        }

        public a h(String str) {
            this.a = "GET";
            this.b = str;
            return this;
        }

        public a i(String str) {
            this.a = "HEAD";
            this.b = str;
            return this;
        }

        public a j(Map map) {
            this.c.clear();
            if (map != null) {
                this.c.putAll(map);
            }
            return this;
        }

        public a k(pz1 pz1Var) {
            this.e = pz1Var;
            return this;
        }

        public a l(String str, byte[] bArr) {
            this.a = "POST";
            this.b = str;
            this.d = bArr;
            return this;
        }
    }

    public xq3(String str, String str2, Map map, byte[] bArr, pz1 pz1Var, boolean z) {
        Objects.requireNonNull(str, "Request's httpMethod is null");
        this.a = str;
        Objects.requireNonNull(str2, "Request's url is null");
        this.b = str2;
        this.d = bArr;
        this.e = pz1Var;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        if (z && pz1Var != null) {
            linkedHashMap.putAll(b(pz1Var));
        }
        this.c = Collections.unmodifiableMap(linkedHashMap);
    }

    public static Map b(pz1 pz1Var) {
        if (pz1Var == null) {
            return Collections.EMPTY_MAP;
        }
        String strE = pz1Var.e();
        if (!pz1Var.d().isEmpty()) {
            strE = pz1Var.g() + ", " + strE + ";q=0.9";
        }
        return Collections.singletonMap("Accept-Language", Collections.singletonList(strE));
    }

    public static a e() {
        return new a();
    }

    public byte[] a() {
        return this.d;
    }

    public Map c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            xq3 xq3Var = (xq3) obj;
            if (this.a.equals(xq3Var.a) && this.b.equals(xq3Var.b) && this.c.equals(xq3Var.c) && Arrays.equals(this.d, xq3Var.d) && Objects.equals(this.e, xq3Var.e)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.b;
    }

    public int hashCode() {
        return (Objects.hash(this.a, this.b, this.c, this.e) * 31) + Arrays.hashCode(this.d);
    }

    public xq3(a aVar) {
        this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f);
    }
}

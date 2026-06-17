package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ws3 {
    public final int a;
    public final String b;
    public final Map c;
    public final String d;
    public final String e;

    public ws3(int i, String str, Map map, String str2, String str3) {
        this.a = i;
        this.b = str;
        this.c = map == null ? Collections.EMPTY_MAP : map;
        this.d = str2 == null ? "" : str2;
        this.e = str3;
    }

    public String a(String str) {
        for (Map.Entry entry : this.c.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2 != null && str2.equalsIgnoreCase(str) && !((List) entry.getValue()).isEmpty()) {
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }
}

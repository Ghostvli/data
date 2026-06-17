package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bb5 {
    public static final Map a = new HashMap();
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static s83 f;
    public static s83 g;

    public static String a(String str, String str2) throws Exception {
        s83 s83Var = g;
        if (s83Var != null) {
            throw s83Var;
        }
        b(str);
        if (c == null) {
            try {
                c = jc5.c(b);
            } catch (s83 e2) {
                g = e2;
                throw e2;
            } catch (Exception e3) {
                g = new s83("Could not get signature parameter deobfuscation JavaScript function", e3);
                throw e3;
            }
        }
        try {
            return (String) aa4.a(an1.b(c, "deobfuscate", str2), "");
        } catch (Exception e4) {
            uo1.a("Could not run signature parameter deobfuscation JavaScript function", e4);
            return null;
        }
    }

    public static void b(String str) {
        if (b == null) {
            b = ab5.c(str);
        }
    }

    public static String c(String str, String str2) throws Exception {
        String strD = ne5.d(str2);
        if (strD == null) {
            return str2;
        }
        Map map = a;
        CharSequence charSequence = (String) map.get(strD);
        if (charSequence != null) {
            return str2.replace(strD, charSequence);
        }
        b(str);
        s83 s83Var = f;
        if (s83Var != null) {
            throw s83Var;
        }
        if (e == null) {
            try {
                String strC = ne5.c(b);
                d = strC;
                e = ne5.b(b, strC);
            } catch (s83 e2) {
                f = e2;
                throw e2;
            } catch (Exception e3) {
                f = new s83("Could not get throttling parameter deobfuscation JavaScript function", e3);
                throw e3;
            }
        }
        try {
            String strB = an1.b(e, d, strD);
            if (yy4.n(strB)) {
                throw new IllegalStateException("Extracted n-parameter is empty");
            }
            map.put(strD, strB);
            return str2.replace(strD, strB);
        } catch (Exception e4) {
            uo1.a("Could not run throttling parameter deobfuscation JavaScript function", e4);
            return null;
        }
    }
}

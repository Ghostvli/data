package defpackage;

import defpackage.p83;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jc5 {
    public static final Pattern[] a = {Pattern.compile("\\b(?:[a-zA-Z0-9_$]+)&&\\((?:[a-zA-Z0-9_$]+)=([a-zA-Z0-9_$]{2,})\\((\\d+,)decodeURIComponent\\((?:[a-zA-Z0-9_$]+)\\)\\)"), Pattern.compile("\\b(?:[a-zA-Z0-9_$]+)&&\\((?:[a-zA-Z0-9_$]+)=([a-zA-Z0-9_$]{2,})\\(decodeURIComponent\\((?:[a-zA-Z0-9_$]+)\\)\\)"), Pattern.compile("\\bm=([a-zA-Z0-9$]{2,})\\(decodeURIComponent\\(h\\.s\\)\\)"), Pattern.compile("\\bc&&\\(c=([a-zA-Z0-9$]{2,})\\(decodeURIComponent\\(c\\)\\)"), Pattern.compile("(?:\\b|[^a-zA-Z0-9$])([a-zA-Z0-9$]{2,})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)"), Pattern.compile("([\\w$]+)\\s*=\\s*function\\((\\w+)\\)\\{\\s*\\2=\\s*\\2\\.split\\(\"\"\\)\\s*;")};
    public static final Pattern b = Pattern.compile("(var [A-z]=['\"].*['\"].split\\(\"[;{]\"\\))");
    public static final Pattern c = Pattern.compile("[;,]([A-Za-z0-9_$]{2,})\\[..");

    public static String a(String str, String str2) throws s83 {
        String str3 = str2 + "=function";
        return str3 + bn1.a(str, str3);
    }

    public static String b(String str, String str2) {
        return "var " + p83.k("(" + Pattern.quote(str2) + "=function\\([a-zA-Z0-9_]+\\)\\{.+?\\})", str);
    }

    public static String c(String str) throws s83 {
        String strB;
        try {
            j73 j73VarD = d(str);
            String str2 = (String) j73VarD.a();
            String str3 = (String) j73VarD.b();
            try {
                strB = a(str, str2);
            } catch (Exception unused) {
                strB = b(str, str2);
            }
            an1.a(strB);
            return p83.l(b, str) + ";" + e(str, p83.l(c, strB)) + strB + ";" + ("function deobfuscate(a){return " + str2 + "(" + str3 + "a);}");
        } catch (Exception e) {
            uo1.a("Could not parse deobfuscation function", e);
            return null;
        }
    }

    public static j73 d(String str) throws s83 {
        try {
            Matcher matcherM = p83.m(a, str);
            return new j73(matcherM.group(1), matcherM.groupCount() > 1 ? matcherM.group(2) : "");
        } catch (p83.a e) {
            uo1.a("Could not find deobfuscation function with any of the known patterns", e);
            return null;
        }
    }

    public static String e(String str, String str2) {
        return p83.k("(var " + Pattern.quote(str2) + "=\\{(?>.|\\n)+?\\}\\};)", str).replace("\n", "");
    }
}

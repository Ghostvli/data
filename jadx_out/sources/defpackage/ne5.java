package defpackage;

import defpackage.p83;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ne5 {
    public static final Pattern a = Pattern.compile("[&?]n=([^&]+)");
    public static final Pattern[] b = {Pattern.compile("([A-Za-z0-9_\\$]{2,})=function.*return [A-Z]\\[\\d+\\]"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+\\([a-zA-Z0-9$_]+\\),[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+\\[[a-zA-Z0-9$_]+]\\|\\|null\\)&&\\([a-zA-Z0-9$_]+=([a-zA-Z0-9$_]+)\\[(\\d+)]"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+\\([a-zA-Z0-9$_]+\\),[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+\\[[a-zA-Z0-9$_]+]\\|\\|null\\).+\\|\\|([a-zA-Z0-9$_]+)\\(\"\"\\)"), Pattern.compile(",[a-zA-Z0-9$_]+\\([a-zA-Z0-9$_]+\\),[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+\\[[a-zA-Z0-9$_]+]\\|\\|null\\)&&\\(\\b[a-zA-Z0-9$_]+=([a-zA-Z0-9$_]+)\\[(\\d+)]\\([a-zA-Z0-9$_]\\),[a-zA-Z0-9$_]+\\.set\\((?:\"n+\"|[a-zA-Z0-9$_]+),[a-zA-Z0-9$_]+\\)"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.get\\([a-zA-Z0-9$_]+\\)\\).+\\|\\|([a-zA-Z0-9$_]+)\\(\"\"\\)"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.get\\([a-zA-Z0-9$_]+\\)\\)&&\\([a-zA-Z0-9$_]+=([a-zA-Z0-9$_]+)\\[(\\d+)]"), Pattern.compile("\\([a-zA-Z0-9$_]=String\\.fromCharCode\\(110\\),[a-zA-Z0-9$_]=[a-zA-Z0-9$_]\\.get\\([a-zA-Z0-9$_]\\)\\)&&\\([a-zA-Z0-9$_]=([a-zA-Z0-9$_]+)(?:\\[(\\d+)])?\\([a-zA-Z0-9$_]\\)"), Pattern.compile("\\.get\\(\"n\"\\)\\)&&\\([a-zA-Z0-9$_]=([a-zA-Z0-9$_]+)(?:\\[(\\d+)])?\\([a-zA-Z0-9$_]\\)")};

    public static String a(String str) {
        return Pattern.compile(";\\s*if\\s*\\(\\s*typeof\\s+[a-zA-Z0-9$_]++\\s*===?\\s*([\"'])undefined\\1\\s*\\)\\s*return\\s+" + p83.k("=\\s*function\\s*\\(\\s*([^)]*)\\s*\\)", str).split(",")[0].trim() + ";", 32).matcher(str).replaceFirst(";");
    }

    public static String b(String str, String str2) {
        String strF;
        try {
            strF = e(str, str2);
        } catch (Exception unused) {
            strF = f(str, str2);
        }
        return a(strF);
    }

    public static String c(String str) throws s83 {
        try {
            Matcher matcherM = p83.m(b, str);
            String strGroup = matcherM.group(1);
            if (matcherM.groupCount() == 1) {
                return strGroup;
            }
            return p83.l(Pattern.compile("var " + Pattern.quote(strGroup) + "\\s*=\\s*\\[(.+?)][;,]"), str).split(",")[Integer.parseInt(matcherM.group(2))];
        } catch (p83.a e) {
            uo1.a("Could not find deobfuscation function with any of the known patterns in the base JavaScript player code", e);
            return null;
        }
    }

    public static String d(String str) {
        if (!str.contains("&n=") && !str.contains("?n=")) {
            return null;
        }
        try {
            return p83.l(a, str);
        } catch (p83.a unused) {
            return null;
        }
    }

    public static String e(String str, String str2) throws s83 {
        String str3 = str2 + "=function";
        return str3 + bn1.a(str, str3) + ";";
    }

    public static String f(String str, String str2) {
        return g("function " + str2 + p83.l(Pattern.compile(Pattern.quote(str2) + "=\\s*function([\\S\\s]*?\\}\\s*return [\\w$]+?\\.join\\(\"\"\\)\\s*\\};)", 32), str));
    }

    public static String g(String str) {
        an1.a(str);
        return str;
    }
}

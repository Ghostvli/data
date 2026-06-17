package defpackage;

import defpackage.sn3;
import defpackage.wm0;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class wb implements Map.Entry, Cloneable {
    public static final String[] i = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    public static final Pattern j = Pattern.compile("[^-a-zA-Z0-9_:.]+");
    public static final Pattern k = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
    public String f;
    public String g;
    public xb h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wb(String str, String str2, xb xbVar) {
        zy4.j(str);
        String strTrim = str.trim();
        zy4.h(strTrim);
        this.f = strTrim;
        this.g = str2;
        this.h = xbVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(String str, wm0.a.EnumC0128a enumC0128a) {
        if (enumC0128a == wm0.a.EnumC0128a.xml && !k(str)) {
            String strReplaceAll = j.matcher(str).replaceAll("_");
            if (k(strReplaceAll)) {
                return strReplaceAll;
            }
            return null;
        }
        if (enumC0128a != wm0.a.EnumC0128a.html || j(str)) {
            return str;
        }
        String strReplaceAll2 = k.matcher(str).replaceAll("_");
        if (j(strReplaceAll2)) {
            return strReplaceAll2;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(String str, String str2, uj3 uj3Var, wm0.a aVar) {
        String strC = c(str, aVar.j());
        if (strC == null) {
            return;
        }
        h(strC, str2, uj3Var, aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(String str, String str2, uj3 uj3Var, wm0.a aVar) {
        uj3Var.b(str);
        if (m(str, str2, aVar)) {
            return;
        }
        uj3Var.b("=\"");
        bt0.m(uj3Var, xb.j(str2), aVar, 2);
        uj3Var.a('\"');
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(String str) {
        return Arrays.binarySearch(i, z33.a(str)) >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean j(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || ((cCharAt >= 127 && cCharAt <= 159) || cCharAt == ' ' || cCharAt == '\"' || cCharAt == '\'' || cCharAt == '/' || cCharAt == '=')) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean k(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt < 'a' || cCharAt > 'z') && !((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_' || cCharAt == ':')) {
            return false;
        }
        for (int i2 = 1; i2 < length; i2++) {
            char cCharAt2 = str.charAt(i2);
            if ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && !((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '-' || cCharAt2 == '_' || cCharAt2 == ':' || cCharAt2 == '.'))) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m(String str, String str2, wm0.a aVar) {
        if (aVar.j() != wm0.a.EnumC0128a.html) {
            return false;
        }
        if (str2 != null) {
            return (str2.isEmpty() || str2.equalsIgnoreCase(str)) && i(str);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public wb clone() {
        try {
            return (wb) super.clone();
        } catch (CloneNotSupportedException e) {
            wg1.a(e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getKey()Ljava/lang/Object; */
    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return xb.j(this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String e() {
        StringBuilder sbE = fg4.e();
        f(uj3.d(sbE), new wm0.a());
        return fg4.v(sbE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            wb wbVar = (wb) obj;
            if (Objects.equals(this.f, wbVar.f) && Objects.equals(this.g, wbVar.g)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(uj3 uj3Var, wm0.a aVar) {
        g(this.f, this.g, uj3Var, aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map.Entry
    public int hashCode() {
        return Objects.hash(this.f, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: setValue(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        int iW;
        String strM = this.g;
        xb xbVar = this.h;
        if (xbVar != null && (iW = xbVar.w(this.f)) != -1) {
            strM = this.h.m(this.f);
            this.h.h[iW] = str;
        }
        this.g = str;
        return xb.j(strM);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sn3.a n() {
        xb xbVar = this.h;
        return xbVar == null ? sn3.a.c : xbVar.G(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return e();
    }
}

package defpackage;

import android.text.TextUtils;
import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class y85 {
    public static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    public static final Pattern d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    public final r73 a = new r73();
    public final StringBuilder b = new StringBuilder();

    public static boolean b(r73 r73Var) {
        int iG = r73Var.g();
        int iJ = r73Var.j();
        byte[] bArrF = r73Var.f();
        if (iG + 2 > iJ) {
            return false;
        }
        int i = iG + 1;
        if (bArrF[iG] != 47) {
            return false;
        }
        int i2 = iG + 2;
        if (bArrF[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iJ) {
                r73Var.g0(iJ - r73Var.g());
                return true;
            }
            if (((char) bArrF[i2]) == '*' && ((char) bArrF[i3]) == '/') {
                i2 += 2;
                iJ = i2;
            } else {
                i2 = i3;
            }
        }
    }

    public static boolean c(r73 r73Var) {
        char cK = k(r73Var, r73Var.g());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        r73Var.g0(1);
        return true;
    }

    public static void e(String str, z85 z85Var) {
        Matcher matcher = d.matcher(xa.f(str));
        if (!matcher.matches()) {
            xz1.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) gg3.q(matcher.group(2));
        str2.getClass();
        switch (str2) {
            case "%":
                z85Var.t(3);
                break;
            case "em":
                z85Var.t(2);
                break;
            case "px":
                z85Var.t(1);
                break;
            default:
                z20.a();
                return;
        }
        z85Var.s(Float.parseFloat((String) gg3.q(matcher.group(1))));
    }

    public static String f(r73 r73Var, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int iG = r73Var.g();
        int iJ = r73Var.j();
        while (iG < iJ && !z) {
            char c2 = (char) r73Var.f()[iG];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                iG++;
                sb.append(c2);
            }
        }
        r73Var.g0(iG - r73Var.g());
        return sb.toString();
    }

    public static String g(r73 r73Var, StringBuilder sb) {
        n(r73Var);
        if (r73Var.a() == 0) {
            return null;
        }
        String strF = f(r73Var, sb);
        if (!strF.isEmpty()) {
            return strF;
        }
        return "" + ((char) r73Var.Q());
    }

    public static String h(r73 r73Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iG = r73Var.g();
            String strG = g(r73Var, sb);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || ";".equals(strG)) {
                r73Var.f0(iG);
                z = true;
            } else {
                sb2.append(strG);
            }
        }
        return sb2.toString();
    }

    public static String i(r73 r73Var, StringBuilder sb) {
        n(r73Var);
        if (r73Var.a() < 5 || !"::cue".equals(r73Var.N(5))) {
            return null;
        }
        int iG = r73Var.g();
        String strG = g(r73Var, sb);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            r73Var.f0(iG);
            return "";
        }
        String strL = "(".equals(strG) ? l(r73Var) : null;
        if (")".equals(g(r73Var, sb))) {
            return strL;
        }
        return null;
    }

    public static void j(r73 r73Var, z85 z85Var, StringBuilder sb) {
        n(r73Var);
        String strF = f(r73Var, sb);
        if (!strF.isEmpty() && ":".equals(g(r73Var, sb))) {
            n(r73Var);
            String strH = h(r73Var, sb);
            if (strH == null || strH.isEmpty()) {
                return;
            }
            int iG = r73Var.g();
            String strG = g(r73Var, sb);
            if (!";".equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    r73Var.f0(iG);
                }
            }
            if ("color".equals(strF)) {
                z85Var.q(ex.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                z85Var.n(ex.b(strH));
                return;
            }
            boolean z = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    z85Var.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        z85Var.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!DavPrincipal.KEY_ALL.equals(strH) && !strH.startsWith("digits")) {
                    z = false;
                }
                z85Var.p(z);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if ("underline".equals(strH)) {
                    z85Var.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                z85Var.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if ("bold".equals(strH)) {
                    z85Var.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if ("italic".equals(strH)) {
                    z85Var.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, z85Var);
            }
        }
    }

    public static char k(r73 r73Var, int i) {
        return (char) r73Var.f()[i];
    }

    public static String l(r73 r73Var) {
        int iG = r73Var.g();
        int iJ = r73Var.j();
        boolean z = false;
        while (iG < iJ && !z) {
            int i = iG + 1;
            z = ((char) r73Var.f()[iG]) == ')';
            iG = i;
        }
        return r73Var.N((iG - 1) - r73Var.g()).trim();
    }

    public static void m(r73 r73Var) {
        while (!TextUtils.isEmpty(r73Var.B())) {
        }
    }

    public static void n(r73 r73Var) {
        while (true) {
            for (boolean z = true; r73Var.a() > 0 && z; z = false) {
                if (c(r73Var) || b(r73Var)) {
                    break;
                }
            }
            return;
        }
    }

    public final void a(z85 z85Var, String str) {
        if (str.isEmpty()) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                z85Var.z((String) gg3.q(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrG1 = fy4.G1(str, "\\.");
        String str2 = strArrG1[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            z85Var.y(str2.substring(0, iIndexOf2));
            z85Var.x(str2.substring(iIndexOf2 + 1));
        } else {
            z85Var.y(str2);
        }
        if (strArrG1.length > 1) {
            z85Var.w((String[]) fy4.j1(strArrG1, 1, strArrG1.length));
        }
    }

    public List d(r73 r73Var) {
        this.b.setLength(0);
        int iG = r73Var.g();
        m(r73Var);
        this.a.d0(r73Var.f(), r73Var.g());
        this.a.f0(iG);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.a, this.b);
            if (strI == null || !"{".equals(g(this.a, this.b))) {
                break;
            }
            z85 z85Var = new z85();
            a(z85Var, strI);
            String str = null;
            boolean z = false;
            while (!z) {
                int iG2 = this.a.g();
                String strG = g(this.a, this.b);
                boolean z2 = strG == null || "}".equals(strG);
                if (!z2) {
                    this.a.f0(iG2);
                    j(this.a, z85Var, this.b);
                }
                str = strG;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(z85Var);
            }
        }
        return arrayList;
    }
}

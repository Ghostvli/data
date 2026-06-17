package defpackage;

import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fi0 implements fr4 {
    public final Resources a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fi0(Resources resources) {
        this.a = (Resources) gg3.q(resources);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(t41 t41Var) {
        int iK = nt2.k(t41Var.p);
        if (iK != -1) {
            return iK;
        }
        if (nt2.n(t41Var.k) != null) {
            return 2;
        }
        if (nt2.c(t41Var.k) != null) {
            return 1;
        }
        if (t41Var.w == -1 && t41Var.x == -1) {
            return (t41Var.H == -1 && t41Var.I == -1) ? -1 : 1;
        }
        return 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fr4
    public String a(t41 t41Var) {
        int i = i(t41Var);
        String strJ = i == 2 ? j(h(t41Var), g(t41Var), c(t41Var)) : i == 1 ? j(e(t41Var), b(t41Var), c(t41Var)) : e(t41Var);
        if (!strJ.isEmpty()) {
            return strJ;
        }
        String str = t41Var.d;
        return (str == null || str.trim().isEmpty()) ? this.a.getString(om3.F) : this.a.getString(om3.G, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String b(t41 t41Var) {
        int i = t41Var.H;
        if (i == -1 || i < 1) {
            return "";
        }
        if (i == 1) {
            return this.a.getString(om3.s);
        }
        if (i == 2) {
            return this.a.getString(om3.B);
        }
        if (i == 6 || i == 7) {
            return this.a.getString(om3.D);
        }
        Resources resources = this.a;
        return i != 8 ? resources.getString(om3.C) : resources.getString(om3.E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String c(t41 t41Var) {
        int i = t41Var.j;
        return i == -1 ? "" : this.a.getString(om3.r, Float.valueOf(i / 1000000.0f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String d(t41 t41Var) {
        return TextUtils.isEmpty(t41Var.b) ? "" : t41Var.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String e(t41 t41Var) {
        String strJ = j(f(t41Var), h(t41Var));
        return TextUtils.isEmpty(strJ) ? d(t41Var) : strJ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String f(t41 t41Var) {
        String str = t41Var.d;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        Locale localeG0 = fy4.g0();
        String displayName = localeForLanguageTag.getDisplayName(localeG0);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeG0) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String g(t41 t41Var) {
        int i = t41Var.w;
        int i2 = t41Var.x;
        return (i == -1 || i2 == -1) ? "" : this.a.getString(om3.t, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String h(t41 t41Var) {
        String string = (t41Var.f & 2) != 0 ? this.a.getString(om3.u) : "";
        if ((t41Var.f & 4) != 0) {
            string = j(string, this.a.getString(om3.x));
        }
        if ((t41Var.f & 8) != 0) {
            string = j(string, this.a.getString(om3.w));
        }
        return (t41Var.f & 1088) != 0 ? j(string, this.a.getString(om3.v)) : string;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (!str.isEmpty()) {
                string = TextUtils.isEmpty(string) ? str : this.a.getString(om3.q, string, str);
            }
        }
        return string;
    }
}

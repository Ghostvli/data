package defpackage;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayDeque;
import java.util.Map;
import org.json.HTTP;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cu4 {
    public static void a(Spannable spannable, int i, int i2, du4 du4Var, zt4 zt4Var, Map map, int i3) {
        zt4 zt4VarE;
        du4 du4VarF;
        int i4;
        if (du4Var.n() != -1) {
            spannable.setSpan(new StyleSpan(du4Var.n()), i, i2, 33);
        }
        if (du4Var.u()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (du4Var.v()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (du4Var.s()) {
            hb4.b(spannable, new ForegroundColorSpan(du4Var.d()), i, i2, 33);
        }
        if (du4Var.r()) {
            hb4.b(spannable, new BackgroundColorSpan(du4Var.b()), i, i2, 33);
        }
        if (du4Var.e() != null) {
            hb4.b(spannable, new TypefaceSpan(du4Var.e()), i, i2, 33);
        }
        if (du4Var.q() != null) {
            jm4 jm4Var = (jm4) gg3.q(du4Var.q());
            int i5 = jm4Var.a;
            if (i5 == -1) {
                i5 = (i3 == 2 || i3 == 1) ? 3 : 1;
                i4 = 1;
            } else {
                i4 = jm4Var.b;
            }
            int i6 = jm4Var.c;
            if (i6 == -2) {
                i6 = 1;
            }
            hb4.b(spannable, new km4(i5, i4, i6), i, i2, 33);
        }
        int iL = du4Var.l();
        if (iL == 2) {
            zt4 zt4VarD = d(zt4Var, map);
            if (zt4VarD != null && (zt4VarE = e(zt4VarD, map)) != null) {
                if (zt4VarE.g() != 1 || zt4VarE.f(0).b == null) {
                    xz1.g("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) fy4.l(zt4VarE.f(0).b);
                    du4 du4VarF2 = f(zt4VarE.f, zt4VarE.l(), map);
                    int iK = du4VarF2 != null ? du4VarF2.k() : -1;
                    if (iK == -1 && (du4VarF = f(zt4VarD.f, zt4VarD.l(), map)) != null) {
                        iK = du4VarF.k();
                    }
                    spannable.setSpan(new aw3(str, iK), i, i2, 33);
                }
            }
        } else if (iL == 3 || iL == 4) {
            spannable.setSpan(new kj0(), i, i2, 33);
        }
        if (du4Var.p()) {
            hb4.b(spannable, new sf1(), i, i2, 33);
        }
        int iG = du4Var.g();
        if (iG == 1) {
            hb4.b(spannable, new AbsoluteSizeSpan((int) du4Var.f(), true), i, i2, 33);
        } else if (iG == 2) {
            hb4.b(spannable, new RelativeSizeSpan(du4Var.f()), i, i2, 33);
        } else {
            if (iG != 3) {
                return;
            }
            hb4.a(spannable, du4Var.f() / 100.0f, i, i2, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll(HTTP.CRLF, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static zt4 d(zt4 zt4Var, Map map) {
        while (zt4Var != null) {
            du4 du4VarF = f(zt4Var.f, zt4Var.l(), map);
            if (du4VarF != null && du4VarF.l() == 1) {
                return zt4Var;
            }
            zt4Var = zt4Var.j;
        }
        return null;
    }

    public static zt4 e(zt4 zt4Var, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(zt4Var);
        while (!arrayDeque.isEmpty()) {
            zt4 zt4Var2 = (zt4) arrayDeque.pop();
            du4 du4VarF = f(zt4Var2.f, zt4Var2.l(), map);
            if (du4VarF != null && du4VarF.l() == 3) {
                return zt4Var2;
            }
            for (int iG = zt4Var2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(zt4Var2.f(iG));
            }
        }
        return null;
    }

    public static du4 f(du4 du4Var, String[] strArr, Map map) {
        int i = 0;
        if (du4Var == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (du4) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                du4 du4Var2 = new du4();
                int length = strArr.length;
                while (i < length) {
                    du4Var2.a((du4) map.get(strArr[i]));
                    i++;
                }
                return du4Var2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return du4Var.a((du4) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    du4Var.a((du4) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return du4Var;
    }
}

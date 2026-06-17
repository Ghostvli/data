package defpackage;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import defpackage.ki4;
import defpackage.ld4;
import defpackage.p50;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kd4 implements ki4 {
    public static final Pattern g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final boolean a;
    public final jd4 b;
    public Map d;
    public float e = -3.4028235E38f;
    public float f = -3.4028235E38f;
    public final r73 c = new r73();

    public kd4(List list) {
        if (list == null || list.isEmpty()) {
            this.a = false;
            this.b = null;
            return;
        }
        this.a = true;
        String strN = fy4.N((byte[]) list.get(0));
        gg3.d(strN.startsWith("Format:"));
        this.b = (jd4) gg3.q(jd4.a(strN));
        j(new r73((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    public static int d(long j, List list, List list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    public static float e(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static p50 f(String str, int i, ld4 ld4Var, ld4.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        p50.b bVarT = new p50.b().o(spannableString).t(i);
        if (ld4Var != null) {
            if (ld4Var.c != null) {
                spannableString.setSpan(new ForegroundColorSpan(ld4Var.c.intValue()), 0, spannableString.length(), 33);
            }
            if (ld4Var.j == 3 && ld4Var.d != null) {
                spannableString.setSpan(new BackgroundColorSpan(ld4Var.d.intValue()), 0, spannableString.length(), 33);
            }
            float f3 = ld4Var.e;
            if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                bVarT.q(f3 / f2, 1);
            }
            boolean z = ld4Var.f;
            if (z && ld4Var.g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ld4Var.g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ld4Var.h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ld4Var.i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i2 = bVar.a;
        if (i2 == -1) {
            i2 = ld4Var != null ? ld4Var.b : -1;
        }
        bVarT.p(p(i2)).l(o(i2)).i(n(i2));
        PointF pointF = bVar.b;
        if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            bVarT.k(e(bVarT.d()));
            bVarT.h(e(bVarT.c()), 0);
        } else {
            bVarT.k(pointF.x / f);
            bVarT.h(bVar.b.y / f2, 0);
        }
        return bVarT.a();
    }

    public static Map l(r73 r73Var, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ld4.a aVarA = null;
        while (true) {
            String strC = r73Var.C(charset);
            if (strC == null || (r73Var.a() != 0 && r73Var.n(charset) == 91)) {
                break;
            }
            if (strC.startsWith("Format:")) {
                aVarA = ld4.a.a(strC);
            } else if (strC.startsWith("Style:")) {
                if (aVarA == null) {
                    xz1.i("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strC));
                } else {
                    ld4 ld4VarB = ld4.b(strC, aVarA);
                    if (ld4VarB != null) {
                        linkedHashMap.put(ld4VarB.a, ld4VarB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long m(String str) {
        Matcher matcher = g.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) fy4.l(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) fy4.l(matcher.group(2))) * 60000000) + (Long.parseLong((String) fy4.l(matcher.group(3))) * 1000000) + (Long.parseLong((String) fy4.l(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    public static int n(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                xz1.i("SsaParser", "Unknown alignment: " + i);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    public static int o(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                xz1.i("SsaParser", "Unknown alignment: " + i);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    public static Layout.Alignment p(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                xz1.i("SsaParser", "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.c.d0(bArr, i + i2);
        this.c.f0(i);
        Charset charsetG = g(this.c);
        if (!this.a) {
            j(this.c, charsetG);
        }
        i(this.c, arrayList, arrayList2, charsetG);
        ArrayList arrayList3 = (bVar.a == -9223372036854775807L || !bVar.b) ? null : new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            List list = (List) arrayList.get(i3);
            if (!list.isEmpty() || i3 == 0) {
                if (i3 == arrayList.size() - 1) {
                    z20.a();
                    return;
                }
                long jLongValue = ((Long) arrayList2.get(i3)).longValue();
                long jLongValue2 = ((Long) arrayList2.get(i3 + 1)).longValue();
                y50 y50Var = new y50(list, jLongValue, jLongValue2 - jLongValue);
                long j = bVar.a;
                if (j == -9223372036854775807L || jLongValue2 >= j) {
                    g20Var.accept(y50Var);
                } else if (arrayList3 != null) {
                    arrayList3.add(y50Var);
                }
            }
        }
        if (arrayList3 != null) {
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                g20Var.accept((y50) it.next());
            }
        }
    }

    @Override // defpackage.ki4
    public int c() {
        return 1;
    }

    public final Charset g(r73 r73Var) {
        Charset charsetA0 = r73Var.a0();
        return charsetA0 != null ? charsetA0 : StandardCharsets.UTF_8;
    }

    public final void h(String str, jd4 jd4Var, List list, List list2) {
        int i;
        int i2;
        gg3.d(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", jd4Var.f);
        if (strArrSplit.length != jd4Var.f) {
            xz1.i("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(str));
            return;
        }
        int i3 = jd4Var.a;
        if (i3 != -1) {
            try {
                i = Integer.parseInt(strArrSplit[i3].trim());
            } catch (RuntimeException unused) {
                xz1.i("SsaParser", "Fail to parse layer: " + strArrSplit[jd4Var.a]);
                i = 0;
            }
        } else {
            i = 0;
        }
        int i4 = i;
        long jM = m(strArrSplit[jd4Var.b]);
        if (jM == -9223372036854775807L) {
            xz1.i("SsaParser", "Skipping invalid timing: ".concat(str));
            return;
        }
        long jM2 = m(strArrSplit[jd4Var.c]);
        if (jM2 == -9223372036854775807L || jM2 <= jM) {
            xz1.i("SsaParser", "Skipping invalid timing: ".concat(str));
            return;
        }
        Map map = this.d;
        ld4 ld4Var = (map == null || (i2 = jd4Var.d) == -1) ? null : (ld4) map.get(strArrSplit[i2].trim());
        String str2 = strArrSplit[jd4Var.e];
        p50 p50VarF = f(ld4.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), i4, ld4Var, ld4.b.b(str2), this.e, this.f);
        int iD = d(jM2, list2, list);
        for (int iD2 = d(jM, list2, list); iD2 < iD; iD2++) {
            ((List) list.get(iD2)).add(p50VarF);
        }
    }

    public final void i(r73 r73Var, List list, List list2, Charset charset) {
        jd4 jd4VarA = this.a ? this.b : null;
        while (true) {
            String strC = r73Var.C(charset);
            if (strC == null) {
                return;
            }
            if (strC.startsWith("Format:")) {
                jd4VarA = jd4.a(strC);
            } else if (strC.startsWith("Dialogue:")) {
                if (jd4VarA == null) {
                    xz1.i("SsaParser", "Skipping dialogue line before complete format: ".concat(strC));
                } else {
                    h(strC, jd4VarA, list, list2);
                }
            }
        }
    }

    public final void j(r73 r73Var, Charset charset) {
        while (true) {
            String strC = r73Var.C(charset);
            if (strC == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strC)) {
                k(r73Var, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strC)) {
                this.d = l(r73Var, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(strC)) {
                xz1.g("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strC)) {
                return;
            }
        }
    }

    public final void k(r73 r73Var, Charset charset) {
        while (true) {
            String strC = r73Var.C(charset);
            if (strC == null) {
                return;
            }
            if (r73Var.a() != 0 && r73Var.n(charset) == 91) {
                return;
            }
            String[] strArrSplit = strC.split(":");
            if (strArrSplit.length == 2) {
                String strF = xa.f(strArrSplit[0].trim());
                strF.getClass();
                if (strF.equals("playresx")) {
                    this.e = Float.parseFloat(strArrSplit[1].trim());
                } else if (strF.equals("playresy")) {
                    try {
                        this.f = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }
}

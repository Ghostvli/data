package defpackage;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import defpackage.ki4;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kh4 implements ki4 {
    public static final Pattern d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    public static final Pattern e = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder a = new StringBuilder();
    public final ArrayList b = new ArrayList();
    public final r73 c = new r73();

    private Charset e(r73 r73Var) {
        Charset charsetA0 = r73Var.a0();
        return charsetA0 != null ? charsetA0 : StandardCharsets.UTF_8;
    }

    public static float f(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        d04.a();
        return 0.0f;
    }

    public static long g(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) gg3.q(matcher.group(i + 2))) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) + (Long.parseLong((String) gg3.q(matcher.group(i + 3))) * 1000);
        String strGroup2 = matcher.group(i + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        StringBuilder sb;
        String str;
        this.c.d0(bArr, i + i2);
        this.c.f0(i);
        Charset charsetE = e(this.c);
        long j = -9223372036854775807L;
        ArrayList arrayList = (bVar.a == -9223372036854775807L || !bVar.b) ? null : new ArrayList();
        while (true) {
            String strC = this.c.C(charsetE);
            if (strC == null) {
                break;
            }
            if (!strC.isEmpty()) {
                try {
                    Integer.parseInt(strC);
                    String strC2 = this.c.C(charsetE);
                    if (strC2 == null) {
                        xz1.i("SubripParser", "Unexpected end");
                        break;
                    }
                    Matcher matcher = d.matcher(strC2);
                    if (matcher.matches()) {
                        long jG = g(matcher, 1);
                        long jG2 = g(matcher, 6);
                        int i3 = 0;
                        this.a.setLength(0);
                        this.b.clear();
                        String strC3 = this.c.C(charsetE);
                        while (true) {
                            boolean zIsEmpty = TextUtils.isEmpty(strC3);
                            sb = this.a;
                            if (zIsEmpty) {
                                break;
                            }
                            if (sb.length() > 0) {
                                this.a.append("<br>");
                            }
                            this.a.append(h(strC3, this.b));
                            strC3 = this.c.C(charsetE);
                        }
                        Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                        while (true) {
                            if (i3 >= this.b.size()) {
                                str = null;
                                break;
                            }
                            str = (String) this.b.get(i3);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        long j2 = j;
                        long j3 = bVar.a;
                        if (j3 == j2 || jG2 >= j3) {
                            g20Var.accept(new y50(xi1.w(d(spannedFromHtml, str)), jG, jG2 - jG));
                        } else if (arrayList != null) {
                            arrayList.add(new y50(xi1.w(d(spannedFromHtml, str)), jG, jG2 - jG));
                        }
                        j = j2;
                    } else {
                        xz1.i("SubripParser", "Skipping invalid timing: ".concat(strC2));
                    }
                } catch (NumberFormatException unused) {
                    xz1.i("SubripParser", "Skipping invalid index: ".concat(strC));
                }
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                g20Var.accept((y50) it.next());
            }
        }
    }

    @Override // defpackage.ki4
    public int c() {
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.p50 d(android.text.Spanned r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kh4.d(android.text.Spanned, java.lang.String):p50");
    }

    public final String h(String str, ArrayList arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = e.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }
}

package defpackage;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import defpackage.ki4;
import defpackage.p50;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class iu4 implements ki4 {
    public final r73 a = new r73();
    public final boolean b;
    public final int c;
    public final int d;
    public final String e;
    public final float f;
    public final int g;

    public iu4(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.c = 0;
            this.d = -1;
            this.e = "sans-serif";
            this.b = false;
            this.f = 0.85f;
            this.g = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.c = bArr[24];
        this.d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.e = "Serif".equals(fy4.O(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.g = i;
        boolean z = (bArr[0] & 32) != 0;
        this.b = z;
        if (z) {
            this.f = fy4.r(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.f = 0.85f;
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    public static void f(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    public static void g(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, 16711713);
        }
    }

    public static String h(r73 r73Var) {
        gg3.d(r73Var.a() >= 2);
        int iY = r73Var.Y();
        if (iY == 0) {
            return "";
        }
        int iG = r73Var.g();
        Charset charsetA0 = r73Var.a0();
        int iG2 = iY - (r73Var.g() - iG);
        if (charsetA0 == null) {
            charsetA0 = StandardCharsets.UTF_8;
        }
        return r73Var.O(iG2, charsetA0);
    }

    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        this.a.d0(bArr, i2 + i);
        this.a.f0(i);
        String strH = h(this.a);
        if (strH.isEmpty()) {
            g20Var.accept(new y50(xi1.u(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strH);
        f(spannableStringBuilder, this.c, 0, 0, spannableStringBuilder.length(), 16711680);
        e(spannableStringBuilder, this.d, -1, 0, spannableStringBuilder.length(), 16711680);
        g(spannableStringBuilder, this.e, 0, spannableStringBuilder.length());
        float fR = this.f;
        while (this.a.a() >= 8) {
            int iG = this.a.g();
            int iZ = this.a.z();
            int iZ2 = this.a.z();
            if (iZ2 == 1937013100) {
                gg3.d(this.a.a() >= 2);
                int iY = this.a.Y();
                for (int i3 = 0; i3 < iY; i3++) {
                    d(this.a, spannableStringBuilder);
                }
            } else if (iZ2 == 1952608120 && this.b) {
                gg3.d(this.a.a() >= 2);
                fR = fy4.r(this.a.Y() / this.g, 0.0f, 0.95f);
            }
            this.a.f0(iG + iZ);
        }
        g20Var.accept(new y50(xi1.w(new p50.b().o(spannableStringBuilder).h(fR, 0).i(0).a()), -9223372036854775807L, -9223372036854775807L));
    }

    @Override // defpackage.ki4
    public int c() {
        return 2;
    }

    public final void d(r73 r73Var, SpannableStringBuilder spannableStringBuilder) {
        gg3.d(r73Var.a() >= 12);
        int iY = r73Var.Y();
        int iY2 = r73Var.Y();
        r73Var.g0(2);
        int iQ = r73Var.Q();
        r73Var.g0(1);
        int iZ = r73Var.z();
        if (iY2 > spannableStringBuilder.length()) {
            xz1.i("Tx3gParser", "Truncating styl end (" + iY2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iY2 = spannableStringBuilder.length();
        }
        int i = iY2;
        if (iY < i) {
            f(spannableStringBuilder, iQ, this.c, iY, i, 0);
            e(spannableStringBuilder, iZ, this.d, iY, i, 0);
            return;
        }
        xz1.i("Tx3gParser", "Ignoring styl with start (" + iY + ") >= end (" + i + ").");
    }
}

package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import com.fongmi.android.tv.bean.Style;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fh3 {
    public static int a(Context context) {
        return Math.abs(q24.o() - ((vr3.r(context) ? 7 : 5) + (vr3.s() ? 1 : 0)));
    }

    public static int b(Context context, Style style) {
        boolean zIsLand = style.isLand();
        int iA = a(context);
        return zIsLand ? iA - 1 : iA;
    }

    public static int c(Context context) {
        DisplayCutout cutout;
        if (Build.VERSION.SDK_INT >= 29 && (cutout = vr3.d(context).getCutout()) != null) {
            return cutout.getSafeInsetRight() | cutout.getSafeInsetLeft();
        }
        return 0;
    }

    public static int d() {
        return 1;
    }

    public static int[] e(Context context) {
        return g(context, Style.rect());
    }

    public static int[] f(Context context, int i, int i2, Style style) {
        int iK = (vr3.k(context) - i) / i2;
        return new int[]{iK, (int) (iK / style.getRatio())};
    }

    public static int[] g(Context context, Style style) {
        int iB = b(context, style);
        int iA = vr3.a(32) + vr3.a((iB - 1) * 16) + c(context);
        if (style.isOval()) {
            iA += vr3.a(iB * 16);
        }
        return f(context, iA, iB, style);
    }
}

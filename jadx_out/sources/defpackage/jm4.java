package defpackage;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jm4 {
    public static final Pattern d = Pattern.compile("\\s+");
    public static final dj1 e = dj1.x("auto", "none");
    public static final dj1 f = dj1.y("dot", "sesame", "circle");
    public static final dj1 g = dj1.x("filled", "open");
    public static final dj1 h = dj1.y("after", "before", "outside");
    public final int a;
    public final int b;
    public final int c;

    public jm4(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static jm4 a(String str) {
        if (str == null) {
            return null;
        }
        String strF = xa.f(str.trim());
        if (strF.isEmpty()) {
            return null;
        }
        return b(dj1.q(TextUtils.split(strF, d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.jm4 b(defpackage.dj1 r7) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jm4.b(dj1):jm4");
    }
}

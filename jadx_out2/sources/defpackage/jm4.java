package defpackage;

import android.text.TextUtils;
import defpackage.m24;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jm4(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static jm4 b(dj1 dj1Var) {
        int i;
        m24.e eVarE;
        int i2;
        int iHashCode;
        String str = (String) km1.c(m24.e(h, dj1Var), "outside");
        int iHashCode2 = str.hashCode();
        int i3 = 1;
        if (iHashCode2 != -1392885889) {
            if (iHashCode2 != -1106037339) {
                if (iHashCode2 == 92734940 && str.equals("after")) {
                    i = 2;
                }
            } else if (str.equals("outside")) {
                i = -2;
            }
            eVarE = m24.e(e, dj1Var);
            int i4 = -1;
            if (eVarE.isEmpty()) {
                String str2 = (String) eVarE.iterator().next();
                int iHashCode3 = str2.hashCode();
                if (iHashCode3 == 3005871) {
                    str2.equals("auto");
                } else if (iHashCode3 == 3387192 && str2.equals("none")) {
                    i4 = 0;
                }
                return new jm4(i4, 0, i);
            }
            m24.e eVarE2 = m24.e(g, dj1Var);
            m24.e eVarE3 = m24.e(f, dj1Var);
            if (eVarE2.isEmpty() && eVarE3.isEmpty()) {
                return new jm4(-1, 0, i);
            }
            String str3 = (String) km1.c(eVarE2, "filled");
            int iHashCode4 = str3.hashCode();
            if (iHashCode4 != -1274499742) {
                if (iHashCode4 == 3417674 && str3.equals("open")) {
                    i2 = 2;
                }
                String str4 = (String) km1.c(eVarE3, "circle");
                iHashCode = str4.hashCode();
                if (iHashCode != -1360216880) {
                    str4.equals("circle");
                } else if (iHashCode != -905816648) {
                    if (iHashCode == 99657 && str4.equals("dot")) {
                        i3 = 2;
                    }
                } else if (str4.equals("sesame")) {
                    i3 = 3;
                }
                return new jm4(i3, i2, i);
            }
            str3.equals("filled");
            i2 = 1;
            String str42 = (String) km1.c(eVarE3, "circle");
            iHashCode = str42.hashCode();
            if (iHashCode != -1360216880) {
            }
            return new jm4(i3, i2, i);
        }
        str.equals("before");
        i = 1;
        eVarE = m24.e(e, dj1Var);
        int i42 = -1;
        if (eVarE.isEmpty()) {
        }
    }
}

package defpackage;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sg4 extends rg4 {
    public static boolean A(String str, int i, String str2, int i2, int i3, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static /* synthetic */ boolean B(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return A(str, i, str2, i2, i3, z);
    }

    public static String C(CharSequence charSequence, int i) {
        charSequence.getClass();
        if (i < 0) {
            gn.a("Count 'n' must be non-negative, but was ", i, 46);
            return null;
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length != 1) {
            StringBuilder sb = new StringBuilder(charSequence.length() * i);
            if (1 <= i) {
                while (true) {
                    sb.append(charSequence);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            return sb.toString();
        }
        char cCharAt = charSequence.charAt(0);
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = cCharAt;
        }
        return new String(cArr);
    }

    public static final String D(String str, char c, char c2, boolean z) {
        str.getClass();
        if (!z) {
            String strReplace = str.replace(c, c2);
            strReplace.getClass();
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (at.d(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static final String E(String str, String str2, String str3, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int i = 0;
        int iW = wg4.W(str, str2, 0, z);
        if (iW < 0) {
            return str;
        }
        int length = str2.length();
        int iB = xn3.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iW);
            sb.append(str3);
            i = iW + length;
            if (iW >= str.length()) {
                break;
            }
            iW = wg4.W(str, str2, iW + iB, z);
        } while (iW > 0);
        sb.append((CharSequence) str, i, str.length());
        return sb.toString();
    }

    public static /* synthetic */ String F(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return D(str, c, c2, z);
    }

    public static /* synthetic */ String G(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return E(str, str2, str3, z);
    }

    public static boolean H(String str, String str2, int i, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.startsWith(str2, i) : A(str, i, str2, 0, str2.length(), z);
    }

    public static boolean I(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.startsWith(str2) : A(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean J(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return H(str, str2, i, z);
    }

    public static /* synthetic */ boolean K(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return I(str, str2, z);
    }

    public static String u(char[] cArr) {
        cArr.getClass();
        return new String(cArr);
    }

    public static String v(char[] cArr, int i, int i2) {
        cArr.getClass();
        i0.Companion.a(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static boolean w(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.endsWith(str2) : A(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return w(str, str2, z);
    }

    public static boolean y(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator z(yf4 yf4Var) {
        yf4Var.getClass();
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        comparator.getClass();
        return comparator;
    }
}

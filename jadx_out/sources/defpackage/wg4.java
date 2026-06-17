package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wg4 extends sg4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements f14 {
        public final /* synthetic */ CharSequence a;

        public a(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // defpackage.f14
        public Iterator iterator() {
            return new ot1(this.a);
        }
    }

    public static final List A0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        charSequence.getClass();
        cArr.getClass();
        if (cArr.length == 1) {
            return B0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableH = p14.h(n0(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(pw.t(iterableH, 10));
        Iterator it = iterableH.iterator();
        while (it.hasNext()) {
            arrayList.add(H0(charSequence, (sk1) it.next()));
        }
        return arrayList;
    }

    public static final List B0(CharSequence charSequence, String str, boolean z, int i) {
        z0(i);
        int length = 0;
        int iW = W(charSequence, str, 0, z);
        if (iW == -1 || i == 1) {
            return nw.d(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? xn3.d(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iW).toString());
            length = str.length() + iW;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iW = W(charSequence, str, length, z);
        } while (iW != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List C0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return A0(charSequence, cArr, z, i);
    }

    public static final boolean D0(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return charSequence.length() > 0 && at.d(charSequence.charAt(0), c, z);
    }

    public static final boolean E0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? sg4.K((String) charSequence, (String) charSequence2, false, 2, null) : p0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean F0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D0(charSequence, c, z);
    }

    public static /* synthetic */ boolean G0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return E0(charSequence, charSequence2, z);
    }

    public static final String H0(CharSequence charSequence, sk1 sk1Var) {
        charSequence.getClass();
        sk1Var.getClass();
        return charSequence.subSequence(sk1Var.j().intValue(), sk1Var.g().intValue() + 1).toString();
    }

    public static final String I0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iZ = Z(str, c, 0, false, 6, null);
        return iZ == -1 ? str2 : str.substring(iZ + 1, str.length());
    }

    public static String J0(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int iA0 = a0(str, str2, 0, false, 6, null);
        return iA0 == -1 ? str3 : str.substring(iA0 + str2.length(), str.length());
    }

    public static /* synthetic */ String K0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return I0(str, c, str2);
    }

    public static /* synthetic */ String L0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return J0(str, str2, str3);
    }

    public static final boolean M(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return Z(charSequence, c, 0, z, 2, null) >= 0;
    }

    public static final String M0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iF0 = f0(str, c, 0, false, 6, null);
        return iF0 == -1 ? str2 : str.substring(iF0 + 1, str.length());
    }

    public static final boolean N(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return charSequence2 instanceof String ? a0(charSequence, (String) charSequence2, 0, z, 2, null) >= 0 : Y(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    public static /* synthetic */ String N0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return M0(str, c, str2);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return M(charSequence, c, z);
    }

    public static CharSequence O0(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zC = zs.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return N(charSequence, charSequence2, z);
    }

    public static String P0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        cArr.getClass();
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ua.w(cArr, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean Q(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return charSequence.length() > 0 && at.d(charSequence.charAt(U(charSequence)), c, z);
    }

    public static String Q0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        cArr.getClass();
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!ua.w(cArr, str.charAt(i))) {
                charSequenceSubSequence = str.subSequence(i, str.length());
                break;
            }
            i++;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean R(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? sg4.x((String) charSequence, (String) charSequence2, false, 2, null) : p0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean S(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Q(charSequence, c, z);
    }

    public static /* synthetic */ boolean T(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return R(charSequence, charSequence2, z);
    }

    public static final int U(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.length() - 1;
    }

    public static final int V(CharSequence charSequence, char c, int i, boolean z) {
        charSequence.getClass();
        return (z || !(charSequence instanceof String)) ? b0(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final int W(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? Y(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static final int X(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        qk1 sk1Var = !z2 ? new sk1(xn3.b(i, 0), xn3.d(i2, charSequence.length())) : xn3.h(xn3.d(i, U(charSequence)), xn3.b(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iB = sk1Var.b();
            int iC = sk1Var.c();
            int iD = sk1Var.d();
            if ((iD <= 0 || iB > iC) && (iD >= 0 || iC > iB)) {
                return -1;
            }
            int i3 = iB;
            while (true) {
                String str = (String) charSequence2;
                boolean z3 = z;
                if (sg4.A(str, 0, (String) charSequence, i3, str.length(), z3)) {
                    return i3;
                }
                if (i3 == iC) {
                    return -1;
                }
                i3 += iD;
                z = z3;
            }
        } else {
            boolean z4 = z;
            int iB2 = sk1Var.b();
            int iC2 = sk1Var.c();
            int iD2 = sk1Var.d();
            if ((iD2 <= 0 || iB2 > iC2) && (iD2 >= 0 || iC2 > iB2)) {
                return -1;
            }
            int i4 = iB2;
            while (true) {
                boolean z5 = z4;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z4 = z5;
                if (p0(charSequence4, 0, charSequence3, i4, charSequence2.length(), z5)) {
                    return i4;
                }
                if (i4 == iC2) {
                    return -1;
                }
                i4 += iD2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static /* synthetic */ int Y(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return X(charSequence, charSequence2, i, i2, z, z2);
    }

    public static /* synthetic */ int Z(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return V(charSequence, c, i, z);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return W(charSequence, str, i, z);
    }

    public static final int b0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ua.H(cArr), i);
        }
        int iB = xn3.b(i, 0);
        int iU = U(charSequence);
        if (iB > iU) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c : cArr) {
                if (at.d(c, cCharAt, z)) {
                    return iB;
                }
            }
            if (iB == iU) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean c0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!zs.c(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final int d0(CharSequence charSequence, char c, int i, boolean z) {
        charSequence.getClass();
        return (z || !(charSequence instanceof String)) ? h0(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static final int e0(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? X(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = U(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return d0(charSequence, c, i, z);
    }

    public static /* synthetic */ int g0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = U(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return e0(charSequence, str, i, z);
    }

    public static final int h0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ua.H(cArr), i);
        }
        for (int iD = xn3.d(i, U(charSequence)); -1 < iD; iD--) {
            char cCharAt = charSequence.charAt(iD);
            for (char c : cArr) {
                if (at.d(c, cCharAt, z)) {
                    return iD;
                }
            }
        }
        return -1;
    }

    public static final f14 i0(CharSequence charSequence) {
        charSequence.getClass();
        return new a(charSequence);
    }

    public static List j0(CharSequence charSequence) {
        charSequence.getClass();
        return p14.n(i0(charSequence));
    }

    public static final CharSequence k0(CharSequence charSequence, int i, char c) {
        charSequence.getClass();
        if (i < 0) {
            ug4.a("Desired length ", i, " is less than zero.");
            return null;
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String l0(String str, int i, char c) {
        str.getClass();
        return k0(str, i, c).toString();
    }

    public static final f14 m0(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        z0(i2);
        return new lj0(charSequence, i, i2, new Function2() { // from class: vg4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return wg4.o0(cArr, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ f14 n0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m0(charSequence, cArr, i, z, i2);
    }

    public static final i73 o0(char[] cArr, boolean z, CharSequence charSequence, int i) {
        charSequence.getClass();
        int iB0 = b0(charSequence, cArr, i, z);
        if (iB0 < 0) {
            return null;
        }
        return fu4.a(Integer.valueOf(iB0), 1);
    }

    public static final boolean p0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!at.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String q0(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return G0(str, charSequence, false, 2, null) ? str.substring(charSequence.length()) : str;
    }

    public static String r0(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return T(str, charSequence, false, 2, null) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    public static String s0(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return t0(str, charSequence, charSequence);
    }

    public static final String t0(String str, CharSequence charSequence, CharSequence charSequence2) {
        str.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        return (str.length() >= charSequence.length() + charSequence2.length() && G0(str, charSequence, false, 2, null) && T(str, charSequence2, false, 2, null)) ? str.substring(charSequence.length(), str.length() - charSequence2.length()) : str;
    }

    public static final String u0(String str, char c, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int iZ = Z(str, c, 0, false, 6, null);
        return iZ == -1 ? str3 : y0(str, iZ + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String v0(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return u0(str, c, str2, str3);
    }

    public static final String w0(String str, char c, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int iF0 = f0(str, c, 0, false, 6, null);
        return iF0 == -1 ? str3 : y0(str, 0, iF0, str2).toString();
    }

    public static /* synthetic */ String x0(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return w0(str, c, str2, str3);
    }

    public static final CharSequence y0(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < i) {
            tg4.a("End index (", i2, ") is less than start index (", i);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence, 0, i);
        sb.append(charSequence2);
        sb.append(charSequence, i2, charSequence.length());
        return sb;
    }

    public static final void z0(int i) {
        if (i >= 0) {
            return;
        }
        vx4.a("Limit must be non-negative, but was ", i);
    }
}

package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class lg4 extends hg4 {
    public static final Function1 e(final String str) {
        return str.length() == 0 ? new Function1() { // from class: ig4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return lg4.f((String) obj);
            }
        } : new Function1() { // from class: jg4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return lg4.g(str, (String) obj);
            }
        };
    }

    public static final String f(String str) {
        str.getClass();
        return str;
    }

    public static final String g(String str, String str2) {
        str2.getClass();
        return str + str2;
    }

    public static final int h(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!zs.c(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    public static final String i(String str, final String str2) {
        str.getClass();
        str2.getClass();
        return p14.l(p14.m(wg4.i0(str), new Function1() { // from class: kg4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return lg4.k(str2, (String) obj);
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    public static final String k(String str, String str2) {
        str2.getClass();
        if (wg4.c0(str2)) {
            return str2.length() < str.length() ? str : str2;
        }
        return str + str2;
    }

    public static final String l(String str, String str2) {
        String str3;
        str.getClass();
        str2.getClass();
        List listJ0 = wg4.j0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listJ0) {
            if (!wg4.c0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(pw.t(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it.next())));
        }
        Integer num = (Integer) ww.S(arrayList2);
        int i = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listJ0.size());
        Function1 function1E = e(str2);
        int iL = ow.l(listJ0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listJ0) {
            int i2 = i + 1;
            if (i < 0) {
                ow.s();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == iL) && wg4.c0(str4)) {
                str4 = null;
            } else {
                String strR0 = yg4.R0(str4, iIntValue);
                if (strR0 != null && (str3 = (String) function1E.invoke(strR0)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        return ((StringBuilder) ww.M(arrayList3, new StringBuilder(length), (Token.IMPORT & 2) != 0 ? ", " : "\n", (Token.IMPORT & 4) != 0 ? "" : null, (Token.IMPORT & 8) == 0 ? null : "", (Token.IMPORT & 16) != 0 ? -1 : 0, (Token.IMPORT & 32) != 0 ? "..." : null, (Token.IMPORT & 64) != 0 ? null : null)).toString();
    }

    public static final String m(String str, String str2, String str3) {
        int i;
        String strSubstring;
        String str4;
        str.getClass();
        str2.getClass();
        str3.getClass();
        if (wg4.c0(str3)) {
            jl.a("marginPrefix must be non-blank string.");
            return null;
        }
        List listJ0 = wg4.j0(str);
        int length = str.length() + (str2.length() * listJ0.size());
        Function1 function1E = e(str2);
        int iL = ow.l(listJ0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listJ0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                ow.s();
            }
            String str5 = (String) obj;
            if ((i2 == 0 || i2 == iL) && wg4.c0(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!zs.c(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1 && sg4.J(str5, str3, i, false, 4, null)) {
                    int length3 = i + str3.length();
                    str5.getClass();
                    strSubstring = str5.substring(length3);
                } else {
                    strSubstring = null;
                }
                if (strSubstring != null && (str4 = (String) function1E.invoke(strSubstring)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        return ((StringBuilder) ww.M(arrayList, new StringBuilder(length), (Token.IMPORT & 2) != 0 ? ", " : "\n", (Token.IMPORT & 4) != 0 ? "" : null, (Token.IMPORT & 8) == 0 ? null : "", (Token.IMPORT & 16) != 0 ? -1 : 0, (Token.IMPORT & 32) != 0 ? "..." : null, (Token.IMPORT & 64) != 0 ? null : null)).toString();
    }

    public static String n(String str) {
        str.getClass();
        return l(str, "");
    }

    public static final String o(String str, String str2) {
        str.getClass();
        str2.getClass();
        return m(str, "", str2);
    }

    public static /* synthetic */ String p(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return o(str, str2);
    }
}

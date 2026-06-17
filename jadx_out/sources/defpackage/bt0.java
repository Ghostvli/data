package defpackage;

import defpackage.bt0;
import defpackage.wm0;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Supplier;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bt0 {
    public static final char[] a = {',', ';'};
    public static final HashMap b = new HashMap();
    public static final ArrayList c = new ArrayList(Token.ASSIGN_RSH);
    public static final ThreadLocal d = new ea4(new Supplier() { // from class: at0
        @Override // java.util.function.Supplier
        public final Object get() {
            return bt0.a();
        }
    });
    public static final ThreadLocal e = new ThreadLocal();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        ascii,
        utf,
        fallback;

        public static b b(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 bt0$c, still in use, count: 1, list:
      (r0v1 bt0$c) from 0x0033: IGET (r0v1 bt0$c) A[WRAPPED] (LINE:52) bt0.c.f java.lang.String[]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        xhtml(dt0.a, 4),
        base(dt0.b, Token.ASSIGN_RSH),
        extended(dt0.c, 2125);

        public String[] f;
        public int[] g;
        public int[] h;
        public String[] i;

        static {
            Collections.addAll(bt0.c, new c(dt0.b, Token.ASSIGN_RSH).f);
            bt0.c.sort(new Comparator() { // from class: ct0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return bt0.c.a((String) obj, (String) obj2);
                }
            });
        }

        public c(String str, int i) {
            bt0.s(this, str, i);
        }

        public static /* synthetic */ int a(String str, String str2) {
            return str2.length() - str.length();
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) m.clone();
        }

        public int m(String str) {
            int iBinarySearch = Arrays.binarySearch(this.f, str);
            if (iBinarySearch >= 0) {
                return this.g[iBinarySearch];
            }
            return -1;
        }

        public String n(int i) {
            int iBinarySearch = Arrays.binarySearch(this.h, i);
            if (iBinarySearch < 0) {
                return "";
            }
            String[] strArr = this.i;
            if (iBinarySearch < strArr.length - 1) {
                int i2 = iBinarySearch + 1;
                if (this.h[i2] == i) {
                    return strArr[i2];
                }
            }
            return strArr[iBinarySearch];
        }
    }

    public static /* synthetic */ char[] a() {
        return new char[2];
    }

    public static void d(uj3 uj3Var, int i, c cVar) {
        if ((i & 2) == 0 || (i & 1) == 0) {
            uj3Var.a('\'');
        } else if (cVar == c.xhtml) {
            uj3Var.b("&#x27;");
        } else {
            uj3Var.b("&apos;");
        }
    }

    public static void e(uj3 uj3Var, c cVar, int i) {
        String strN = cVar.n(i);
        if ("".equals(strN)) {
            uj3Var.b("&#x").b(Integer.toHexString(i)).a(';');
        } else {
            uj3Var.a('&').b(strN).a(';');
        }
    }

    public static void f(int i, uj3 uj3Var, int i2, c cVar, b bVar, CharsetEncoder charsetEncoder) {
        if (c.xhtml != cVar || r(i)) {
            char c2 = (char) i;
            if (i >= 65536) {
                if (!h(bVar, c2, charsetEncoder)) {
                    e(uj3Var, cVar, i);
                    return;
                } else {
                    char[] cArr = (char[]) d.get();
                    uj3Var.c(cArr, 0, Character.toChars(i, cArr, 0));
                    return;
                }
            }
            if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
                uj3Var.a(c2);
                return;
            }
            if (c2 == '\"') {
                if ((i2 & 2) != 0) {
                    uj3Var.b("&quot;");
                    return;
                } else {
                    uj3Var.a(c2);
                    return;
                }
            }
            if (c2 == '<') {
                uj3Var.b("&lt;");
                return;
            }
            if (c2 == '>') {
                uj3Var.b("&gt;");
                return;
            }
            if (c2 == 160) {
                g(uj3Var, cVar);
                return;
            }
            if (c2 == '&') {
                uj3Var.b("&amp;");
                return;
            }
            if (c2 == '\'') {
                d(uj3Var, i2, cVar);
            } else if (c2 < ' ' || !h(bVar, c2, charsetEncoder)) {
                e(uj3Var, cVar, i);
            } else {
                uj3Var.a(c2);
            }
        }
    }

    public static void g(uj3 uj3Var, c cVar) {
        if (cVar != c.xhtml) {
            uj3Var.b("&nbsp;");
        } else {
            uj3Var.b("&#xa0;");
        }
    }

    public static boolean h(b bVar, char c2, CharsetEncoder charsetEncoder) {
        int i = a.a[bVar.ordinal()];
        return i != 1 ? i != 2 ? charsetEncoder.canEncode(c2) : c2 < 55296 || c2 >= 57344 : c2 < 128;
    }

    public static int i(String str, int[] iArr) {
        String str2 = (String) b.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int iM = c.extended.m(str);
        if (iM == -1) {
            return 0;
        }
        iArr[0] = iM;
        return 1;
    }

    public static void j(String str, uj3 uj3Var, c cVar, Charset charset, int i) {
        boolean z;
        uj3 uj3Var2;
        boolean z2;
        c cVar2;
        boolean z3;
        int i2;
        b bVarB = b.b(charset.name());
        CharsetEncoder charsetEncoderK = k(charset);
        int length = str.length();
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iCharCount = 0;
        while (iCharCount < length) {
            boolean z7 = z4;
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((i & 4) != 0) {
                z = true;
                if (fg4.o(iCodePointAt)) {
                    if (((i & 8) != 0 && !z5) || z6) {
                        z = z5;
                        uj3Var2 = uj3Var;
                        z2 = z7;
                    } else if ((i & 16) != 0) {
                        boolean z8 = z5;
                        uj3Var2 = uj3Var;
                        z2 = true;
                        z = z8;
                    } else {
                        uj3Var.a(' ');
                        boolean z9 = z5;
                        uj3Var2 = uj3Var;
                        z2 = z7;
                        cVar2 = cVar;
                        z3 = true;
                        z = z9;
                        i2 = i;
                        iCharCount += Character.charCount(iCodePointAt);
                        z4 = z2;
                        uj3Var = uj3Var2;
                        i = i2;
                        z5 = z;
                        z6 = z3;
                        cVar = cVar2;
                    }
                    cVar2 = cVar;
                    z3 = z6;
                    i2 = i;
                    iCharCount += Character.charCount(iCodePointAt);
                    z4 = z2;
                    uj3Var = uj3Var2;
                    i = i2;
                    z5 = z;
                    z6 = z3;
                    cVar = cVar2;
                } else if (z7) {
                    uj3Var.a(' ');
                    uj3Var2 = uj3Var;
                    cVar2 = cVar;
                    i2 = i;
                    z2 = false;
                    z3 = false;
                } else {
                    uj3Var2 = uj3Var;
                    i2 = i;
                    z2 = z7;
                    cVar2 = cVar;
                    z3 = false;
                }
            } else {
                z = z5;
                uj3Var2 = uj3Var;
                z2 = z7;
                cVar2 = cVar;
                z3 = z6;
                i2 = i;
            }
            f(iCodePointAt, uj3Var2, i2, cVar2, bVarB, charsetEncoderK);
            iCharCount += Character.charCount(iCodePointAt);
            z4 = z2;
            uj3Var = uj3Var2;
            i = i2;
            z5 = z;
            z6 = z3;
            cVar = cVar2;
        }
    }

    public static CharsetEncoder k(Charset charset) {
        ThreadLocal threadLocal = e;
        CharsetEncoder charsetEncoder = (CharsetEncoder) threadLocal.get();
        if (charsetEncoder != null && charsetEncoder.charset().equals(charset)) {
            return charsetEncoder;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        threadLocal.set(charsetEncoderNewEncoder);
        return charsetEncoderNewEncoder;
    }

    public static String l(String str) {
        return n(str, c.base, la0.b);
    }

    public static void m(uj3 uj3Var, String str, wm0.a aVar, int i) {
        j(str, uj3Var, aVar.e(), aVar.c(), i);
    }

    public static String n(String str, c cVar, Charset charset) {
        if (str == null) {
            return "";
        }
        StringBuilder sbE = fg4.e();
        j(str, uj3.d(sbE), cVar, charset, 3);
        return fg4.v(sbE);
    }

    public static String o(String str) {
        for (String str2 : c) {
            if (str.startsWith(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static boolean p(String str) {
        return c.base.m(str) != -1;
    }

    public static boolean q(String str) {
        return c.extended.m(str) != -1;
    }

    public static boolean r(int i) {
        if (i == 9 || i == 10 || i == 13) {
            return true;
        }
        if (i >= 32 && i <= 55295) {
            return true;
        }
        if (i < 57344 || i > 65533) {
            return i >= 65536 && i <= 1114111;
        }
        return true;
    }

    public static void s(c cVar, String str, int i) {
        int i2;
        cVar.f = new String[i];
        cVar.g = new int[i];
        cVar.h = new int[i];
        cVar.i = new String[i];
        xs xsVar = new xs(str);
        int i3 = 0;
        while (!xsVar.i0()) {
            try {
                String strZ = xsVar.Z('=');
                xsVar.B();
                int i4 = Integer.parseInt(xsVar.c0(a), 36);
                char cG0 = xsVar.g0();
                xsVar.B();
                if (cG0 == ',') {
                    i2 = Integer.parseInt(xsVar.Z(';'), 36);
                    xsVar.B();
                } else {
                    i2 = -1;
                }
                int i5 = Integer.parseInt(xsVar.Z('&'), 36);
                xsVar.B();
                cVar.f[i3] = strZ;
                cVar.g[i3] = i4;
                cVar.h[i5] = i4;
                cVar.i[i5] = strZ;
                if (i2 != -1) {
                    b.put(strZ, new String(new int[]{i4, i2}, 0, 2));
                }
                i3++;
            } catch (Throwable th) {
                try {
                    xsVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        zy4.e(i3 == i, "Unexpected count of entities loaded");
        xsVar.close();
    }
}

package defpackage;

import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class kz0 {
    public static final i02 a;
    public static volatile i02 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum c {
        DEBUG,
        WARN,
        ERROR
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        b bVar = new b();
        a = bVar;
        b = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(String str, String str2) {
        d(c.DEBUG, str, str2, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(String str, String str2, Object... objArr) {
        e(c.DEBUG, str, null, str2, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(String str, Object... objArr) {
        int i;
        int i2;
        if (str == null || objArr == null || objArr.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + Math.min(32, objArr.length * 16));
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt == '{' && (i2 = i3 + 1) < length && str.charAt(i2) == '{') {
                sb.append('{');
            } else if (cCharAt == '}' && (i = i3 + 1) < length && str.charAt(i) == '}') {
                sb.append('}');
            } else if (cCharAt == '{') {
                int iIndexOf = str.indexOf(Token.IF, i3 + 1);
                if (iIndexOf < 0) {
                    sb.append((CharSequence) str, i3, length);
                    break;
                }
                if (i4 < objArr.length) {
                    sb.append(objArr[i4]);
                    i4++;
                } else {
                    sb.append((CharSequence) str, i3, iIndexOf + 1);
                }
                i3 = iIndexOf + 1;
            } else {
                sb.append(cCharAt);
                i3++;
            }
            i3 += 2;
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(c cVar, String str, String str2, Throwable th) {
        if (b == a) {
            return;
        }
        int i = a.a[cVar.ordinal()];
        if (i == 1) {
            if (th == null) {
                b.a(str, str2);
                return;
            } else {
                b.f(str, str2, th);
                return;
            }
        }
        if (i == 2) {
            if (th == null) {
                b.d(str, str2);
                return;
            } else {
                b.b(str, str2, th);
                return;
            }
        }
        if (i != 3) {
            return;
        }
        if (th == null) {
            b.c(str, str2);
        } else {
            b.e(str, str2, th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(c cVar, String str, Throwable th, String str2, Object... objArr) {
        if (b == a) {
            return;
        }
        d(cVar, str, c(str2, objArr), th);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements i02 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i02
        public void a(String str, String str2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i02
        public void b(String str, String str2, Throwable th) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i02
        public void c(String str, String str2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i02
        public void d(String str, String str2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i02
        public void e(String str, String str2, Throwable th) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i02
        public void f(String str, String str2, Throwable th) {
        }

        public b() {
        }
    }
}

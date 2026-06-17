package defpackage;

import okhttp3.internal.http2.Settings;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.classfile.a;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class uu4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int a(int i) {
        return ((i & Settings.DEFAULT_INITIAL_WINDOW_SIZE) << 8) | 7;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int b(String str, a aVar) {
        return a(aVar.a(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int c(int i) {
        return ((i & Settings.DEFAULT_INITIAL_WINDOW_SIZE) << 8) | 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int d(String str, a aVar) {
        if (str.length() != 1) {
            return b(str, aVar);
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return 2;
        }
        if (cCharAt != 'S' && cCharAt != 'Z' && cCharAt != 'I') {
            if (cCharAt == 'J') {
                return 4;
            }
            switch (cCharAt) {
                case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
                case Token.ENUM_NEXT /* 67 */:
                    break;
                case Token.ENUM_ID /* 68 */:
                    return 3;
                default:
                    jl.a("bad type");
                    return 0;
            }
        }
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Class e(String str) {
        try {
            return Class.forName(str.replace('/', '.'));
        } catch (ClassNotFoundException e) {
            wg1.a(e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int f(int i) {
        return i >>> 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String g(int i, a aVar) {
        if (h(i) == 7) {
            return (String) aVar.p(f(i));
        }
        jl.a("expecting object type");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int h(int i) {
        return i & 255;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(int i) {
        return i == 3 || i == 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(int i, int i2, a aVar) {
        if (i != i2) {
            int iH = h(i);
            int iH2 = h(i2);
            boolean z = iH == 7;
            boolean z2 = iH2 == 7;
            if (!z || i2 != 5) {
                if (iH != 0 && iH2 != 0) {
                    if (i != 5 || !z2) {
                        if (z && z2) {
                            String strG = g(i, aVar);
                            String strG2 = g(i2, aVar);
                            String str = (String) aVar.p(2);
                            String str2 = (String) aVar.p(4);
                            if (strG.equals(str)) {
                                strG = str2;
                            }
                            if (strG2.equals(str)) {
                                strG2 = str2;
                            }
                            Class<?> clsE = e(strG);
                            Class<?> clsE2 = e(strG2);
                            if (!clsE.isAssignableFrom(clsE2)) {
                                if (!clsE2.isAssignableFrom(clsE)) {
                                    if (clsE2.isInterface() || clsE.isInterface()) {
                                        return b("java/lang/Object", aVar);
                                    }
                                    for (Class<? super Object> superclass = clsE2.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                                        if (superclass.isAssignableFrom(clsE)) {
                                            return b(ClassFileWriter.n0(superclass.getName()), aVar);
                                        }
                                    }
                                }
                            }
                        }
                        pp3.a("bad merge attempt between ", k(i, aVar), " and ", k(i2, aVar));
                    }
                    return i2;
                }
                return 0;
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String k(int i, a aVar) {
        int iH = h(i);
        switch (iH) {
            case 0:
                return "top";
            case 1:
                return "int";
            case 2:
                return "float";
            case 3:
                return "double";
            case 4:
                return "long";
            case 5:
                return "null";
            case 6:
                return "uninitialized_this";
            default:
                if (iH == 7) {
                    return g(i, aVar);
                }
                if (iH == 8) {
                    return "uninitialized";
                }
                jl.a("bad type");
                return null;
        }
    }
}

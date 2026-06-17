package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zy4 {
    public static void a(String str) {
        throw new az4(str);
    }

    public static void b(boolean z) {
        if (z) {
            throw new az4("Must be false");
        }
    }

    public static void c(boolean z, String str) {
        if (z) {
            throw new az4(str);
        }
    }

    public static void d(boolean z) {
        if (!z) {
            throw new az4("Must be true");
        }
    }

    public static void e(boolean z, String str) {
        if (!z) {
            throw new az4(str);
        }
    }

    public static void f(Object[] objArr) {
        g(objArr, "Array must not contain any null objects");
    }

    public static void g(Object[] objArr, String str) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw new az4(str);
            }
        }
    }

    public static void h(String str) {
        if (str == null || str.length() == 0) {
            throw new az4("String must not be empty");
        }
    }

    public static void i(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new az4(str2);
        }
    }

    public static void j(Object obj) {
        if (obj == null) {
            throw new az4("Object must not be null");
        }
    }

    public static void k(Object obj, String str) {
        if (obj == null) {
            throw new az4(str);
        }
    }

    public static void l(Object obj, String str) {
        if (obj == null) {
            throw new az4(String.format("The parameter '%s' must not be null.", str));
        }
    }

    public static void m(String str) {
        throw new IllegalStateException(str);
    }
}

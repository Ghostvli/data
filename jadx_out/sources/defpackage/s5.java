package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s5 {
    public static boolean a;
    public static boolean b;
    public static final Class c = a("libcore.io.Memory");
    public static final boolean d;

    static {
        d = (a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return c;
    }

    public static boolean c() {
        if (a) {
            return true;
        }
        return (c == null || d) ? false : true;
    }
}

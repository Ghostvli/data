package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mb3 {
    public static final q93 a = c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements q93 {
        public b() {
        }
    }

    public static String a(String str) {
        if (e(str)) {
            return null;
        }
        return str;
    }

    public static String b(String str, Object... objArr) {
        return gg4.b(str, objArr);
    }

    public static q93 c() {
        return new b();
    }

    public static String d(String str) {
        return str == null ? "" : str;
    }

    public static boolean e(String str) {
        return str == null || str.isEmpty();
    }

    public static String f(Object obj) {
        return String.valueOf(obj);
    }
}

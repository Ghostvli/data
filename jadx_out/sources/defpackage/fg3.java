package defpackage;

import android.text.TextUtils;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fg3 {
    public static void a(boolean z) {
        b(z, "");
    }

    public static void b(boolean z, String str) {
        if (z) {
            return;
        }
        jl.a(str);
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        jl.a("Must not be null or empty");
        return null;
    }

    public static Collection d(Collection collection) {
        if (!collection.isEmpty()) {
            return collection;
        }
        jl.a("Must not be empty.");
        return null;
    }

    public static Object e(Object obj) {
        return f(obj, "Argument must not be null");
    }

    public static Object f(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        om1.a(str);
        return null;
    }
}

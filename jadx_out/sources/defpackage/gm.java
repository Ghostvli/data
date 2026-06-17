package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gm {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static Object[] a(Bundle bundle, String str, Class cls) {
            return bundle.getParcelableArray(str, cls);
        }
    }

    public static Parcelable[] a(Bundle bundle, String str, Class cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) a.a(bundle, str, cls) : bundle.getParcelableArray(str);
    }
}

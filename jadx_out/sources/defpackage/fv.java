package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fv {
    public static final wn1 a = wn1.h(",");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public abstract fv a();

        public abstract a b(long j);

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);
    }

    public static Uri b(Uri uri) {
        return (!uri.isHierarchical() || uri.getQueryParameter("CMCD") == null) ? uri : kx4.e(uri, "CMCD");
    }

    public abstract ja0 a(ja0 ja0Var);
}

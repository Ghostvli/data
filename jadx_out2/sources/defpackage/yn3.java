package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yn3 {
    public static final String a = fy4.N0(0);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yn3 a(Bundle bundle) {
        int i = bundle.getInt(a, -1);
        if (i == 0) {
            return dd1.d(bundle);
        }
        if (i == 1) {
            return la3.d(bundle);
        }
        if (i == 2) {
            return td4.d(bundle);
        }
        if (i == 3) {
            return vn4.d(bundle);
        }
        b.a("Unknown RatingType: ", i);
        return null;
    }

    public abstract boolean b();

    public abstract Bundle c();
}

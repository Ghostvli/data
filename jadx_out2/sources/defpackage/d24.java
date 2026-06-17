package defpackage;

import android.os.Bundle;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d24 {
    public static final String e = fy4.N0(0);
    public static final String f = fy4.N0(1);
    public static final String g = fy4.N0(2);
    public static final String h = fy4.N0(3);
    public final int a;
    public final Bundle b;
    public final long c;
    public final b24 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d24(int i, Bundle bundle, long j, b24 b24Var) {
        gg3.d(b24Var == null || i < 0);
        this.a = i;
        this.b = new Bundle(bundle);
        this.c = j;
        if (b24Var == null && i < 0) {
            b24Var = new b24(i, "no error message provided");
        }
        this.d = b24Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d24 a(Bundle bundle) {
        int i = bundle.getInt(e, -1);
        Bundle bundleY = fy4.y(bundle.getBundle(f));
        long j = bundle.getLong(g, SystemClock.elapsedRealtime());
        Bundle bundle2 = bundle.getBundle(h);
        b24 b24VarA = bundle2 != null ? b24.a(bundle2) : i != 0 ? new b24(i, "no error message provided") : null;
        if (bundleY == null) {
            bundleY = Bundle.EMPTY;
        }
        return new d24(i, bundleY, j, b24VarA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(e, this.a);
        bundle.putBundle(f, this.b);
        bundle.putLong(g, this.c);
        b24 b24Var = this.d;
        if (b24Var != null) {
            bundle.putBundle(h, b24Var.b());
        }
        return bundle;
    }

    public d24(int i, Bundle bundle) {
        this(i, bundle, SystemClock.elapsedRealtime(), null);
    }

    public d24(int i) {
        this(i, Bundle.EMPTY);
    }
}

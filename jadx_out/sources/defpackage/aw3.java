package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class aw3 implements wr1 {
    public static final String c = fy4.N0(0);
    public static final String d = fy4.N0(1);
    public final String a;
    public final int b;

    public aw3(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static aw3 a(Bundle bundle) {
        return new aw3((String) gg3.q(bundle.getString(c)), bundle.getInt(d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(c, this.a);
        bundle.putInt(d, this.b);
        return bundle;
    }
}

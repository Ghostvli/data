package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class km4 implements wr1 {
    public static final String d = fy4.N0(0);
    public static final String e = fy4.N0(1);
    public static final String f = fy4.N0(2);
    public int a;
    public int b;
    public final int c;

    public km4(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static km4 a(Bundle bundle) {
        return new km4(bundle.getInt(d), bundle.getInt(e), bundle.getInt(f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(d, this.a);
        bundle.putInt(e, this.b);
        bundle.putInt(f, this.c);
        return bundle;
    }
}

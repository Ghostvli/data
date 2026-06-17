package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class u00 {
    public static final String g = fy4.N0(0);
    public static final String h = fy4.N0(1);
    public static final String i = fy4.N0(2);
    public static final String j = fy4.N0(3);
    public static final String k = fy4.N0(4);
    public static final String l = fy4.N0(5);
    public final int a;
    public final int b;
    public final String c;
    public final int d;
    public final Bundle e;
    public final int f;

    public u00(String str, int i2, Bundle bundle, int i3) {
        this(1010000300, 9, str, i2, new Bundle(bundle), i3);
    }

    public static u00 a(Bundle bundle) {
        int i2 = bundle.getInt(g, 0);
        int i3 = bundle.getInt(k, 0);
        String str = (String) gg3.q(bundle.getString(h));
        String str2 = i;
        gg3.d(bundle.containsKey(str2));
        int i4 = bundle.getInt(str2);
        Bundle bundle2 = bundle.getBundle(j);
        int i5 = bundle.getInt(l, 0);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new u00(i2, i3, str, i4, bundle2, i5);
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(g, this.a);
        bundle.putString(h, this.c);
        bundle.putInt(i, this.d);
        bundle.putBundle(j, this.e);
        bundle.putInt(k, this.b);
        bundle.putInt(l, this.f);
        return bundle;
    }

    public u00(int i2, int i3, String str, int i4, Bundle bundle, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.d = i4;
        this.e = bundle;
        this.f = i5;
    }
}

package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b24 {
    public static final String d = fy4.N0(0);
    public static final String e = fy4.N0(1);
    public static final String f = fy4.N0(2);
    public int a;
    public String b;
    public Bundle c;

    public b24(int i, String str, Bundle bundle) {
        boolean z = true;
        if (i >= 0 && i != 1) {
            z = false;
        }
        gg3.d(z);
        this.a = i;
        this.b = str;
        this.c = bundle;
    }

    public static b24 a(Bundle bundle) {
        int i = bundle.getInt(d, 1000);
        String string = bundle.getString(e, "");
        Bundle bundleY = fy4.y(bundle.getBundle(f));
        if (bundleY == null) {
            bundleY = Bundle.EMPTY;
        }
        return new b24(i, string, bundleY);
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(d, this.a);
        bundle.putString(e, this.b);
        if (!this.c.isEmpty()) {
            bundle.putBundle(f, this.c);
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b24)) {
            return false;
        }
        b24 b24Var = (b24) obj;
        return this.a == b24Var.a && Objects.equals(this.b, b24Var.b);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), this.b);
    }

    public b24(int i, String str) {
        this(i, str, Bundle.EMPTY);
    }
}

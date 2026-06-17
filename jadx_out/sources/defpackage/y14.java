package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class y14 {
    public static final xi1 d = xi1.w(40010);
    public static final xi1 e = xi1.B(50000, 50001, 50002, 50003, 50004, 50005, 50006);
    public static final String f = fy4.N0(0);
    public static final String g = fy4.N0(1);
    public static final String h = fy4.N0(2);
    public final int a;
    public final String b;
    public final Bundle c;

    public y14(String str, Bundle bundle) {
        this.a = 0;
        this.b = (String) gg3.q(str);
        this.c = new Bundle((Bundle) gg3.q(bundle));
    }

    public static y14 a(Bundle bundle) {
        int i = bundle.getInt(f, 0);
        if (i != 0) {
            return new y14(i);
        }
        String str = (String) gg3.q(bundle.getString(g));
        Bundle bundleY = fy4.y(bundle.getBundle(h));
        if (bundleY == null) {
            bundleY = Bundle.EMPTY;
        }
        return new y14(str, bundleY);
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f, this.a);
        bundle.putString(g, this.b);
        bundle.putBundle(h, this.c);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y14)) {
            return false;
        }
        y14 y14Var = (y14) obj;
        return this.a == y14Var.a && TextUtils.equals(this.b, y14Var.b);
    }

    public int hashCode() {
        return Objects.hash(this.b, Integer.valueOf(this.a));
    }

    public y14(int i) {
        gg3.e(i != 0, "commandCode shouldn't be COMMAND_CODE_CUSTOM");
        this.a = i;
        this.b = "";
        this.c = Bundle.EMPTY;
    }
}

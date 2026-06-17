package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class rr1 {
    public static final String c = fy4.N0(0);
    public static final String d = fy4.N0(1);
    public final String a;
    public final String b;

    public rr1(String str, String str2) {
        this.a = fy4.f1(str);
        this.b = str2;
    }

    public static rr1 a(Bundle bundle) {
        return new rr1(bundle.getString(c), (String) gg3.q(bundle.getString(d)));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.a;
        if (str != null) {
            bundle.putString(c, str);
        }
        bundle.putString(d, this.b);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            rr1 rr1Var = (rr1) obj;
            if (Objects.equals(this.a, rr1Var.a) && Objects.equals(this.b, rr1Var.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        String str = this.a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}

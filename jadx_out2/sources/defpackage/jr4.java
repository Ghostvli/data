package defpackage;

import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jr4 {
    public static final String c = fy4.N0(0);
    public static final String d = fy4.N0(1);
    public final br4 a;
    public final xi1 b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jr4(br4 br4Var, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= br4Var.a)) {
            throw new IndexOutOfBoundsException();
        }
        this.a = br4Var;
        this.b = xi1.p(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jr4 a(Bundle bundle) {
        return new jr4(br4.b((Bundle) gg3.q(bundle.getBundle(c))), ll1.c((int[]) gg3.q(bundle.getIntArray(d))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        return this.a.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c, this.a.h());
        bundle.putIntArray(d, ll1.n(this.b));
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && jr4.class == obj.getClass()) {
            jr4 jr4Var = (jr4) obj;
            if (this.a.equals(jr4Var.a) && this.b.equals(jr4Var.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }
}

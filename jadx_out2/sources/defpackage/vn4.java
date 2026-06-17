package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vn4 extends yn3 {
    public static final String d = fy4.N0(1);
    public static final String e = fy4.N0(2);
    public final boolean b;
    public final boolean c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn4() {
        this.b = false;
        this.c = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static vn4 d(Bundle bundle) {
        gg3.d(bundle.getInt(yn3.a, -1) == 3);
        return bundle.getBoolean(d, false) ? new vn4(bundle.getBoolean(e, false)) : new vn4();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yn3
    public boolean b() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yn3
    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(yn3.a, 3);
        bundle.putBoolean(d, this.b);
        bundle.putBoolean(e, this.c);
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof vn4)) {
            return false;
        }
        vn4 vn4Var = (vn4) obj;
        return this.c == vn4Var.c && this.b == vn4Var.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.b), Boolean.valueOf(this.c));
    }

    public vn4(boolean z) {
        this.b = true;
        this.c = z;
    }
}

package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lb0 {
    public final String a;
    public final t41 b;
    public final t41 c;
    public final int d;
    public final int e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lb0(String str, t41 t41Var, t41 t41Var2, int i, int i2) {
        gg3.d(i == 0 || i2 == 0);
        gg3.d(true ^ TextUtils.isEmpty(str));
        this.a = str;
        this.b = (t41) gg3.q(t41Var);
        this.c = (t41) gg3.q(t41Var2);
        this.d = i;
        this.e = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && lb0.class == obj.getClass()) {
            lb0 lb0Var = (lb0) obj;
            if (this.d == lb0Var.d && this.e == lb0Var.e && this.a.equals(lb0Var.a) && this.b.equals(lb0Var.b) && this.c.equals(lb0Var.c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((((((((527 + this.d) * 31) + this.e) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}

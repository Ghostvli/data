package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pr4 {
    public final int a;
    public final jq3[] b;
    public final jy0[] c;
    public final xr4 d;
    public final Object e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pr4(jq3[] jq3VarArr, jy0[] jy0VarArr, xr4 xr4Var, Object obj) {
        gg3.d(jq3VarArr.length == jy0VarArr.length);
        this.b = jq3VarArr;
        this.c = (jy0[]) jy0VarArr.clone();
        this.d = xr4Var;
        this.e = obj;
        this.a = jq3VarArr.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(pr4 pr4Var) {
        if (pr4Var == null || pr4Var.c.length != this.c.length) {
            return false;
        }
        for (int i = 0; i < this.c.length; i++) {
            if (!b(pr4Var, i)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b(pr4 pr4Var, int i) {
        return pr4Var != null && Objects.equals(this.b[i], pr4Var.b[i]) && Objects.equals(this.c[i], pr4Var.c[i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(int i) {
        return this.b[i] != null;
    }
}

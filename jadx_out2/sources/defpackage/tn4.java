package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class tn4 {
    public final g40 a;
    public final Object[] b;
    public final fn4[] c;
    public int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tn4(g40 g40Var, int i) {
        this.a = g40Var;
        this.b = new Object[i];
        this.c = new fn4[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(fn4 fn4Var, Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        fn4[] fn4VarArr = this.c;
        this.d = i + 1;
        fn4Var.getClass();
        fn4VarArr[i] = fn4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(g40 g40Var) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            fn4 fn4Var = this.c[length];
            fn4Var.getClass();
            fn4Var.S(g40Var, this.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}

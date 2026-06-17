package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x5 {
    public static final x5 c;
    public final h02 a;
    public final d42 b;

    static {
        c = y5.c() ? y5.b() : null;
    }

    public x5(h02 h02Var, d42 d42Var) {
        this.a = h02Var;
        this.b = d42Var;
    }

    public static boolean a() {
        return c != null;
    }

    public static x5 b() {
        return c;
    }
}

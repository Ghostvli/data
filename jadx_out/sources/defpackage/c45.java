package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c45 {
    public final g45 a = new g45();

    public final void a(String str, AutoCloseable autoCloseable) {
        str.getClass();
        autoCloseable.getClass();
        g45 g45Var = this.a;
        if (g45Var != null) {
            g45Var.d(str, autoCloseable);
        }
    }

    public final void b() {
        g45 g45Var = this.a;
        if (g45Var != null) {
            g45Var.e();
        }
        d();
    }

    public final AutoCloseable c(String str) {
        str.getClass();
        g45 g45Var = this.a;
        if (g45Var != null) {
            return g45Var.g(str);
        }
        return null;
    }

    public void d() {
    }
}

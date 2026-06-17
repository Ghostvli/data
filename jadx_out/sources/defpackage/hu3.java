package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hu3 implements iu3 {
    public final int a;
    public final String b;
    public final String c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final boolean a;
        public final String b;

        public a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    public hu3(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public abstract void a(lw3 lw3Var);

    public abstract void b(lw3 lw3Var);

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final int e() {
        return this.a;
    }

    public abstract void f(lw3 lw3Var);

    public abstract void g(lw3 lw3Var);

    public abstract void h(lw3 lw3Var);

    public abstract void i(lw3 lw3Var);

    public abstract a j(lw3 lw3Var);
}

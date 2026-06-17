package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class l54 implements v20 {
    public final String a;
    public final int b;
    public final q6 c;
    public final boolean d;

    public l54(String str, int i, q6 q6Var, boolean z) {
        this.a = str;
        this.b = i;
        this.c = q6Var;
        this.d = z;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new a54(g22Var, biVar, this);
    }

    public String b() {
        return this.a;
    }

    public q6 c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}

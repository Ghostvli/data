package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mu3 implements v20 {
    public final String a;
    public final z6 b;

    public mu3(String str, z6 z6Var) {
        this.a = str;
        this.b = z6Var;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new nu3(g22Var, biVar, this);
    }

    public z6 b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }
}

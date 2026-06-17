package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cu implements v20 {
    public final String a;
    public final z6 b;
    public final o6 c;
    public final boolean d;
    public final boolean e;

    public cu(String str, z6 z6Var, o6 o6Var, boolean z, boolean z2) {
        this.a = str;
        this.b = z6Var;
        this.c = o6Var;
        this.d = z;
        this.e = z2;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new nr0(g22Var, biVar, this);
    }

    public String b() {
        return this.a;
    }

    public z6 c() {
        return this.b;
    }

    public o6 d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }
}

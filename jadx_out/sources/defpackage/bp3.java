package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bp3 implements v20 {
    public final String a;
    public final z6 b;
    public final z6 c;
    public final j6 d;
    public final boolean e;

    public bp3(String str, z6 z6Var, z6 z6Var2, j6 j6Var, boolean z) {
        this.a = str;
        this.b = z6Var;
        this.c = z6Var2;
        this.d = j6Var;
        this.e = z;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new ap3(g22Var, biVar, this);
    }

    public j6 b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public z6 d() {
        return this.b;
    }

    public z6 e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}

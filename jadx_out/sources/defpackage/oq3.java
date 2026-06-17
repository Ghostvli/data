package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class oq3 implements v20 {
    public final String a;
    public final j6 b;
    public final j6 c;
    public final x6 d;
    public final boolean e;

    public oq3(String str, j6 j6Var, j6 j6Var2, x6 x6Var, boolean z) {
        this.a = str;
        this.b = j6Var;
        this.c = j6Var2;
        this.d = x6Var;
        this.e = z;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new pq3(g22Var, biVar, this);
    }

    public j6 b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public j6 d() {
        return this.c;
    }

    public x6 e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }
}

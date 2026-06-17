package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class if3 implements v20 {
    public final String a;
    public final a b;
    public final j6 c;
    public final z6 d;
    public final j6 e;
    public final j6 f;
    public final j6 g;
    public final j6 h;
    public final j6 i;
    public final boolean j;
    public final boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        STAR(1),
        POLYGON(2);

        public final int f;

        a(int i2) {
            this.f = i2;
        }

        public static a b(int i2) {
            for (a aVar : values()) {
                if (aVar.f == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public if3(String str, a aVar, j6 j6Var, z6 z6Var, j6 j6Var2, j6 j6Var3, j6 j6Var4, j6 j6Var5, j6 j6Var6, boolean z, boolean z2) {
        this.a = str;
        this.b = aVar;
        this.c = j6Var;
        this.d = z6Var;
        this.e = j6Var2;
        this.f = j6Var3;
        this.g = j6Var4;
        this.h = j6Var5;
        this.i = j6Var6;
        this.j = z;
        this.k = z2;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new hf3(g22Var, biVar, this);
    }

    public j6 b() {
        return this.f;
    }

    public j6 c() {
        return this.h;
    }

    public String d() {
        return this.a;
    }

    public j6 e() {
        return this.g;
    }

    public j6 f() {
        return this.i;
    }

    public j6 g() {
        return this.c;
    }

    public z6 h() {
        return this.d;
    }

    public j6 i() {
        return this.e;
    }

    public a j() {
        return this.b;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.k;
    }
}

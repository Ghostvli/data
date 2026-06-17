package defpackage;

import defpackage.n54;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class db1 implements v20 {
    public final String a;
    public final gb1 b;
    public final k6 c;
    public final l6 d;
    public final o6 e;
    public final o6 f;
    public final j6 g;
    public final n54.b h;
    public final n54.c i;
    public final float j;
    public final List k;
    public final j6 l;
    public final boolean m;

    public db1(String str, gb1 gb1Var, k6 k6Var, l6 l6Var, o6 o6Var, o6 o6Var2, j6 j6Var, n54.b bVar, n54.c cVar, float f, List list, j6 j6Var2, boolean z) {
        this.a = str;
        this.b = gb1Var;
        this.c = k6Var;
        this.d = l6Var;
        this.e = o6Var;
        this.f = o6Var2;
        this.g = j6Var;
        this.h = bVar;
        this.i = cVar;
        this.j = f;
        this.k = list;
        this.l = j6Var2;
        this.m = z;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new eb1(g22Var, biVar, this);
    }

    public n54.b b() {
        return this.h;
    }

    public j6 c() {
        return this.l;
    }

    public o6 d() {
        return this.f;
    }

    public k6 e() {
        return this.c;
    }

    public gb1 f() {
        return this.b;
    }

    public n54.c g() {
        return this.i;
    }

    public List h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.a;
    }

    public l6 k() {
        return this.d;
    }

    public o6 l() {
        return this.e;
    }

    public j6 m() {
        return this.g;
    }

    public boolean n() {
        return this.m;
    }
}

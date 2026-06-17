package defpackage;

import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ab1 implements v20 {
    public final gb1 a;
    public final Path.FillType b;
    public final k6 c;
    public final l6 d;
    public final o6 e;
    public final o6 f;
    public final String g;
    public final j6 h;
    public final j6 i;
    public final boolean j;

    public ab1(String str, gb1 gb1Var, Path.FillType fillType, k6 k6Var, l6 l6Var, o6 o6Var, o6 o6Var2, j6 j6Var, j6 j6Var2, boolean z) {
        this.a = gb1Var;
        this.b = fillType;
        this.c = k6Var;
        this.d = l6Var;
        this.e = o6Var;
        this.f = o6Var2;
        this.g = str;
        this.h = j6Var;
        this.i = j6Var2;
        this.j = z;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new bb1(g22Var, f12Var, biVar, this);
    }

    public o6 b() {
        return this.f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public k6 d() {
        return this.c;
    }

    public gb1 e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public l6 g() {
        return this.d;
    }

    public o6 h() {
        return this.e;
    }

    public boolean i() {
        return this.j;
    }
}

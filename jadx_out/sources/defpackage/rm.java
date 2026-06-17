package defpackage;

import defpackage.ki4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rm implements te1 {
    public static final yf3 f = new yf3();
    public final hz0 a;
    public final t41 b;
    public final yo4 c;
    public final ki4.a d;
    public final boolean e;

    public rm(hz0 hz0Var, t41 t41Var, yo4 yo4Var, ki4.a aVar, boolean z) {
        this.a = hz0Var;
        this.b = t41Var;
        this.c = yo4Var;
        this.d = aVar;
        this.e = z;
    }

    @Override // defpackage.te1
    public boolean a(jz0 jz0Var) {
        return this.a.d(jz0Var, f) == 0;
    }

    @Override // defpackage.te1
    public void b(mz0 mz0Var) {
        this.a.b(mz0Var);
    }

    @Override // defpackage.te1
    public void c() {
        this.a.a(0L, 0L);
    }

    @Override // defpackage.te1
    public boolean d() {
        hz0 hz0VarC = this.a.c();
        return (hz0VarC instanceof d5) || (hz0VarC instanceof j1) || (hz0VarC instanceof n1) || (hz0VarC instanceof pu2);
    }

    @Override // defpackage.te1
    public boolean e() {
        hz0 hz0VarC = this.a.c();
        return (hz0VarC instanceof vt4) || (hz0VarC instanceof q71);
    }

    @Override // defpackage.te1
    public te1 f() {
        hz0 pu2Var;
        gg3.v(!e());
        hz0 hz0VarC = this.a.c();
        hz0 hz0Var = this.a;
        gg3.A(hz0VarC == hz0Var, "Can't recreate wrapped extractors. Outer type: %s", hz0Var.getClass());
        hz0 hz0Var2 = this.a;
        if (hz0Var2 instanceof d95) {
            pu2Var = new d95(this.b.d, this.c, this.d, this.e);
        } else if (hz0Var2 instanceof d5) {
            pu2Var = new d5();
        } else if (hz0Var2 instanceof j1) {
            pu2Var = new j1();
        } else if (hz0Var2 instanceof n1) {
            pu2Var = new n1();
        } else {
            if (!(hz0Var2 instanceof pu2)) {
                e04.a("Unexpected extractor type for recreation: ".concat(hz0Var2.getClass().getSimpleName()));
                return null;
            }
            pu2Var = new pu2();
        }
        return new rm(pu2Var, this.b, this.c, this.d, this.e);
    }
}

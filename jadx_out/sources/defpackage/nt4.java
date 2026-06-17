package defpackage;

import defpackage.p54;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nt4 implements k20, zh.b {
    public final String a;
    public final boolean b;
    public final List c = new ArrayList();
    public final p54.a d;
    public final zh e;
    public final zh f;
    public final zh g;

    public nt4(bi biVar, p54 p54Var) {
        this.a = p54Var.c();
        this.b = p54Var.g();
        this.d = p54Var.f();
        t21 t21VarA = p54Var.e().a();
        this.e = t21VarA;
        t21 t21VarA2 = p54Var.b().a();
        this.f = t21VarA2;
        t21 t21VarA3 = p54Var.d().a();
        this.g = t21VarA3;
        biVar.j(t21VarA);
        biVar.j(t21VarA2);
        biVar.j(t21VarA3);
        t21VarA.a(this);
        t21VarA2.a(this);
        t21VarA3.a(this);
    }

    @Override // zh.b
    public void a() {
        for (int i = 0; i < this.c.size(); i++) {
            ((zh.b) this.c.get(i)).a();
        }
    }

    @Override // defpackage.k20
    public void b(List list, List list2) {
    }

    public void f(zh.b bVar) {
        this.c.add(bVar);
    }

    public zh g() {
        return this.f;
    }

    public zh h() {
        return this.g;
    }

    public zh j() {
        return this.e;
    }

    public p54.a k() {
        return this.d;
    }

    public boolean l() {
        return this.b;
    }
}

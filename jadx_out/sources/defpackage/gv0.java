package defpackage;

import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class gv0 extends os1 {
    public String f;
    public uh4 g;
    public Queue h;

    public gv0(uh4 uh4Var, Queue queue) {
        this.g = uh4Var;
        this.f = uh4Var.getName();
        this.h = queue;
    }

    @Override // defpackage.l0
    public void D(rs1 rs1Var, b52 b52Var, String str, Object[] objArr, Throwable th) {
        wh4 wh4Var = new wh4();
        wh4Var.k(System.currentTimeMillis());
        wh4Var.e(rs1Var);
        wh4Var.f(this.g);
        wh4Var.g(this.f);
        if (b52Var != null) {
            wh4Var.a(b52Var);
        }
        wh4Var.h(str);
        wh4Var.i(Thread.currentThread().getName());
        wh4Var.d(objArr);
        wh4Var.j(th);
        this.h.add(wh4Var);
    }

    @Override // defpackage.j02
    public boolean e() {
        return true;
    }

    @Override // defpackage.j02
    public boolean g() {
        return true;
    }

    @Override // defpackage.j02
    public String getName() {
        return this.f;
    }

    @Override // defpackage.j02
    public boolean j() {
        return true;
    }

    @Override // defpackage.j02
    public boolean l() {
        return true;
    }

    @Override // defpackage.j02
    public boolean n() {
        return true;
    }
}

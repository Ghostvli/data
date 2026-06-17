package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ze3 extends xj1 {
    public ze3(int i) {
        super(i);
    }

    @Override // defpackage.yw
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public xe3 a(ye3 ye3Var) {
        xe3 xe3Var = new xe3(g(), ye3Var.getUrl(), ye3Var.getName());
        try {
            xe3Var.j(ye3Var.d());
        } catch (Exception e) {
            b(e);
        }
        try {
            xe3Var.k(ye3Var.a());
        } catch (Exception e2) {
            b(e2);
        }
        try {
            xe3Var.l(ye3Var.b());
        } catch (Exception e3) {
            b(e3);
        }
        try {
            xe3Var.f(ye3Var.n());
        } catch (Exception e4) {
            b(e4);
        }
        try {
            xe3Var.i(ye3Var.c());
        } catch (Exception e5) {
            b(e5);
        }
        try {
            xe3Var.g(ye3Var.getDescription());
        } catch (Exception e6) {
            b(e6);
        }
        try {
            xe3Var.h(ye3Var.i());
        } catch (Exception e7) {
            b(e7);
        }
        return xe3Var;
    }
}

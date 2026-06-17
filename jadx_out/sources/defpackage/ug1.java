package defpackage;

import defpackage.vt2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ug1 implements vt2 {
    public static final s63 b = s63.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    public final ut2 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements wt2 {
        public final ut2 a = new ut2(500);

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ug1(this.a);
        }
    }

    public ug1(ut2 ut2Var) {
        this.a = ut2Var;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(ra1 ra1Var, int i, int i2, u63 u63Var) {
        ut2 ut2Var = this.a;
        if (ut2Var != null) {
            ra1 ra1Var2 = (ra1) ut2Var.a(ra1Var, 0, 0);
            if (ra1Var2 == null) {
                this.a.b(ra1Var, 0, 0, ra1Var);
            } else {
                ra1Var = ra1Var2;
            }
        }
        return new vt2.a(ra1Var, new yg1(ra1Var, ((Integer) u63Var.c(b)).intValue()));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ra1 ra1Var) {
        return true;
    }
}

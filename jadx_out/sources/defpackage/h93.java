package defpackage;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class h93 extends dr1 {
    public Path q;
    public final dr1 r;

    public h93(f12 f12Var, dr1 dr1Var) {
        super(f12Var, (PointF) dr1Var.b, (PointF) dr1Var.c, dr1Var.d, dr1Var.e, dr1Var.f, dr1Var.g, dr1Var.h);
        this.r = dr1Var;
        j();
    }

    public void j() {
        Object obj;
        Object obj2;
        Object obj3 = this.c;
        boolean z = (obj3 == null || (obj2 = this.b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) ? false : true;
        Object obj4 = this.b;
        if (obj4 == null || (obj = this.c) == null || z) {
            return;
        }
        dr1 dr1Var = this.r;
        this.q = uy4.d((PointF) obj4, (PointF) obj, dr1Var.o, dr1Var.p);
    }

    public Path k() {
        return this.q;
    }
}

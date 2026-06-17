package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ay3 extends er1 {
    public final by3 i;

    public ay3(List list) {
        super(list);
        this.i = new by3();
    }

    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public by3 i(dr1 dr1Var, float f) {
        Object obj;
        float f2;
        Object obj2 = dr1Var.b;
        if (obj2 == null || (obj = dr1Var.c) == null) {
            e04.a("Missing values for keyframe.");
            return null;
        }
        by3 by3Var = (by3) obj2;
        by3 by3Var2 = (by3) obj;
        y22 y22Var = this.e;
        if (y22Var != null) {
            f2 = f;
            by3 by3Var3 = (by3) y22Var.b(dr1Var.g, dr1Var.h.floatValue(), by3Var, by3Var2, f2, e(), f());
            if (by3Var3 != null) {
                return by3Var3;
            }
        } else {
            f2 = f;
        }
        this.i.d(ot2.i(by3Var.b(), by3Var2.b(), f2), ot2.i(by3Var.c(), by3Var2.c(), f2));
        return this.i;
    }
}

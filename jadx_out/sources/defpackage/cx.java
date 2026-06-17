package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cx extends er1 {
    public cx(List list) {
        super(list);
    }

    public int r() {
        return s(b(), d());
    }

    public int s(dr1 dr1Var, float f) {
        float f2;
        Float f3;
        if (dr1Var.b == null || dr1Var.c == null) {
            e04.a("Missing values for keyframe.");
            return 0;
        }
        y22 y22Var = this.e;
        if (y22Var == null || (f3 = dr1Var.h) == null) {
            f2 = f;
        } else {
            f2 = f;
            Integer num = (Integer) y22Var.b(dr1Var.g, f3.floatValue(), (Integer) dr1Var.b, (Integer) dr1Var.c, f2, e(), f());
            if (num != null) {
                return num.intValue();
            }
        }
        return c91.c(ot2.b(f2, 0.0f, 1.0f), ((Integer) dr1Var.b).intValue(), ((Integer) dr1Var.c).intValue());
    }

    @Override // defpackage.zh
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer i(dr1 dr1Var, float f) {
        return Integer.valueOf(s(dr1Var, f));
    }
}

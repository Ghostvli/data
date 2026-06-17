package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uk1 extends er1 {
    public uk1(List list) {
        super(list);
    }

    public int r(dr1 dr1Var, float f) {
        float f2;
        if (dr1Var.b == null) {
            e04.a("Missing values for keyframe.");
            return 0;
        }
        int iH = dr1Var.c == null ? dr1Var.h() : dr1Var.e();
        y22 y22Var = this.e;
        if (y22Var != null) {
            f2 = f;
            Integer num = (Integer) y22Var.b(dr1Var.g, dr1Var.h.floatValue(), (Integer) dr1Var.b, Integer.valueOf(iH), f2, e(), f());
            if (num != null) {
                return num.intValue();
            }
        } else {
            f2 = f;
        }
        return ot2.j(dr1Var.h(), iH, f2);
    }

    @Override // defpackage.zh
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(dr1 dr1Var, float f) {
        return Integer.valueOf(r(dr1Var, f));
    }
}

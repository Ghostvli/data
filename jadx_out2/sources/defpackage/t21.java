package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t21 extends er1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t21(List list) {
        super(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float r() {
        return s(b(), d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float s(dr1 dr1Var, float f) {
        float f2;
        if (dr1Var.b == null || dr1Var.c == null) {
            e04.a("Missing values for keyframe.");
            return 0.0f;
        }
        y22 y22Var = this.e;
        if (y22Var != null) {
            f2 = f;
            Float f3 = (Float) y22Var.b(dr1Var.g, dr1Var.h.floatValue(), (Float) dr1Var.b, (Float) dr1Var.c, f2, e(), f());
            if (f3 != null) {
                return f3.floatValue();
            }
        } else {
            f2 = f;
        }
        return ot2.i(dr1Var.g(), dr1Var.d(), f2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ldr1;F)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Float i(dr1 dr1Var, float f) {
        return Float.valueOf(s(dr1Var, f));
    }
}

package defpackage;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ff3 extends er1 {
    public final PointF i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ff3(List list) {
        super(list);
        this.i = new PointF();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ldr1;F)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(dr1 dr1Var, float f) {
        return j(dr1Var, f, f, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Ldr1;FFF)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public PointF j(dr1 dr1Var, float f, float f2, float f3) {
        Object obj;
        PointF pointF;
        Object obj2 = dr1Var.b;
        if (obj2 == null || (obj = dr1Var.c) == null) {
            e04.a("Missing values for keyframe.");
            return null;
        }
        PointF pointF2 = (PointF) obj2;
        PointF pointF3 = (PointF) obj;
        y22 y22Var = this.e;
        if (y22Var != null && (pointF = (PointF) y22Var.b(dr1Var.g, dr1Var.h.floatValue(), pointF2, pointF3, f, e(), f())) != null) {
            return pointF;
        }
        PointF pointF4 = this.i;
        float f4 = pointF2.x;
        float f5 = f4 + (f2 * (pointF3.x - f4));
        float f6 = pointF2.y;
        pointF4.set(f5, f6 + (f3 * (pointF3.y - f6)));
        return this.i;
    }
}

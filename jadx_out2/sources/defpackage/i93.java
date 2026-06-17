package defpackage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i93 extends er1 {
    public final PointF i;
    public final float[] j;
    public final float[] k;
    public final PathMeasure l;
    public h93 m;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i93(List list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.k = new float[2];
        this.l = new PathMeasure();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ldr1;F)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(dr1 dr1Var, float f) {
        float f2;
        h93 h93Var = (h93) dr1Var;
        Path pathK = h93Var.k();
        y22 y22Var = this.e;
        if (y22Var == null || dr1Var.h == null) {
            f2 = f;
        } else {
            f2 = f;
            PointF pointF = (PointF) y22Var.b(h93Var.g, h93Var.h.floatValue(), (PointF) h93Var.b, (PointF) h93Var.c, e(), f2, f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (pathK == null) {
            return (PointF) dr1Var.b;
        }
        if (this.m != h93Var) {
            this.l.setPath(pathK, false);
            this.m = h93Var;
        }
        float length = this.l.getLength();
        float f3 = f2 * length;
        this.l.getPosTan(f3, this.j, this.k);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        if (f3 < 0.0f) {
            PointF pointF3 = this.i;
            float[] fArr2 = this.k;
            pointF3.offset(fArr2[0] * f3, fArr2[1] * f3);
        } else if (f3 > length) {
            PointF pointF4 = this.i;
            float[] fArr3 = this.k;
            float f4 = f3 - length;
            pointF4.offset(fArr3[0] * f4, fArr3[1] * f4);
        }
        return this.i;
    }
}

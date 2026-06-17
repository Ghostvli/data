package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i54 extends bi {
    public final o20 E;
    public final ry F;
    public gp0 G;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i54(g22 g22Var, yr1 yr1Var, ry ryVar, f12 f12Var) {
        super(g22Var, yr1Var);
        this.F = ryVar;
        o20 o20Var = new o20(g22Var, this, new f54("__container", yr1Var.o(), false), f12Var);
        this.E = o20Var;
        List list = Collections.EMPTY_LIST;
        o20Var.b(list, list);
        if (z() != null) {
            this.G = new gp0(this, this, z());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi
    public void I(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        this.E.h(zq1Var, i, list, zq1Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi, defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.E.d(rectF, this.o, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        gp0 gp0Var;
        gp0 gp0Var2;
        gp0 gp0Var3;
        gp0 gp0Var4;
        gp0 gp0Var5;
        super.g(obj, y22Var);
        if (obj == q22.e && (gp0Var5 = this.G) != null) {
            gp0Var5.c(y22Var);
            return;
        }
        if (obj == q22.J && (gp0Var4 = this.G) != null) {
            gp0Var4.f(y22Var);
            return;
        }
        if (obj == q22.K && (gp0Var3 = this.G) != null) {
            gp0Var3.d(y22Var);
            return;
        }
        if (obj == q22.L && (gp0Var2 = this.G) != null) {
            gp0Var2.e(y22Var);
        } else {
            if (obj != q22.M || (gp0Var = this.G) == null) {
                return;
            }
            gp0Var.g(y22Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi
    public void u(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        gp0 gp0Var = this.G;
        if (gp0Var != null) {
            dp0Var = gp0Var.b(matrix, i);
        }
        this.E.i(canvas, matrix, i, dp0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi
    public xk x() {
        xk xkVarX = super.x();
        return xkVarX != null ? xkVarX : this.F.x();
    }
}

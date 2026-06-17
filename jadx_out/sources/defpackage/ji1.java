package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.a53;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ji1 extends bi {
    public final Paint E;
    public final Rect F;
    public final Rect G;
    public final RectF H;
    public final l22 I;
    public zh J;
    public zh K;
    public gp0 L;
    public a53 M;
    public a53.b N;

    public ji1(g22 g22Var, yr1 yr1Var) {
        super(g22Var, yr1Var);
        this.E = new qr1(3);
        this.F = new Rect();
        this.G = new Rect();
        this.H = new RectF();
        this.I = g22Var.N(yr1Var.n());
        if (z() != null) {
            this.L = new gp0(this, this, z());
        }
    }

    public final Bitmap P() {
        Bitmap bitmap;
        zh zhVar = this.K;
        if (zhVar != null && (bitmap = (Bitmap) zhVar.h()) != null) {
            return bitmap;
        }
        Bitmap bitmapE = this.p.E(this.q.n());
        if (bitmapE != null) {
            return bitmapE;
        }
        l22 l22Var = this.I;
        if (l22Var != null) {
            return l22Var.b();
        }
        return null;
    }

    @Override // defpackage.bi, defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        Bitmap bitmapP;
        super.d(rectF, matrix, z);
        if (this.I != null) {
            float fE = uy4.e();
            if (this.p.O() || (bitmapP = P()) == null) {
                rectF.set(0.0f, 0.0f, this.I.f() * fE, this.I.d() * fE);
            } else {
                rectF.set(0.0f, 0.0f, bitmapP.getWidth() * fE, bitmapP.getHeight() * fE);
            }
            this.o.mapRect(rectF);
        }
    }

    @Override // defpackage.bi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        gp0 gp0Var;
        gp0 gp0Var2;
        gp0 gp0Var3;
        gp0 gp0Var4;
        gp0 gp0Var5;
        super.g(obj, y22Var);
        if (obj == q22.N) {
            if (y22Var == null) {
                this.J = null;
                return;
            } else {
                this.J = new bz4(y22Var);
                return;
            }
        }
        if (obj == q22.Q) {
            if (y22Var == null) {
                this.K = null;
                return;
            } else {
                this.K = new bz4(y22Var);
                return;
            }
        }
        if (obj == q22.e && (gp0Var5 = this.L) != null) {
            gp0Var5.c(y22Var);
            return;
        }
        if (obj == q22.J && (gp0Var4 = this.L) != null) {
            gp0Var4.f(y22Var);
            return;
        }
        if (obj == q22.K && (gp0Var3 = this.L) != null) {
            gp0Var3.d(y22Var);
            return;
        }
        if (obj == q22.L && (gp0Var2 = this.L) != null) {
            gp0Var2.e(y22Var);
        } else {
            if (obj != q22.M || (gp0Var = this.L) == null) {
                return;
            }
            gp0Var.g(y22Var);
        }
    }

    @Override // defpackage.bi
    public void u(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        Bitmap bitmapP = P();
        if (bitmapP == null || bitmapP.isRecycled() || this.I == null) {
            return;
        }
        float fE = uy4.e();
        this.E.setAlpha(i);
        zh zhVar = this.J;
        if (zhVar != null) {
            this.E.setColorFilter((ColorFilter) zhVar.h());
        }
        gp0 gp0Var = this.L;
        if (gp0Var != null) {
            dp0Var = gp0Var.b(matrix, i);
        }
        this.F.set(0, 0, bitmapP.getWidth(), bitmapP.getHeight());
        boolean zO = this.p.O();
        Rect rect = this.G;
        if (zO) {
            rect.set(0, 0, (int) (this.I.f() * fE), (int) (this.I.d() * fE));
        } else {
            rect.set(0, 0, (int) (bitmapP.getWidth() * fE), (int) (bitmapP.getHeight() * fE));
        }
        boolean z = dp0Var != null;
        if (z) {
            if (this.M == null) {
                this.M = new a53();
            }
            if (this.N == null) {
                this.N = new a53.b();
            }
            this.N.f();
            dp0Var.c(i, this.N);
            RectF rectF = this.H;
            Rect rect2 = this.G;
            rectF.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            matrix.mapRect(this.H);
            canvas = this.M.j(canvas, this.H, this.N);
        }
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmapP, this.F, this.G, this.E);
        if (z) {
            this.M.e();
            if (this.M.f()) {
                return;
            }
        }
        canvas.restore();
    }
}

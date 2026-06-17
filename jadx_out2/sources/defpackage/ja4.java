package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ja4 extends bi {
    public final RectF E;
    public final Paint F;
    public final float[] G;
    public final Path H;
    public final yr1 I;
    public zh J;
    public zh K;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ja4(g22 g22Var, yr1 yr1Var) {
        super(g22Var, yr1Var);
        this.E = new RectF();
        qr1 qr1Var = new qr1();
        this.F = qr1Var;
        this.G = new float[8];
        this.H = new Path();
        this.I = yr1Var;
        qr1Var.setAlpha(0);
        qr1Var.setStyle(Paint.Style.FILL);
        qr1Var.setColor(yr1Var.p());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi, defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.E.set(0.0f, 0.0f, this.I.r(), this.I.q());
        this.o.mapRect(this.E);
        rectF.set(this.E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
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
        if (obj == q22.a) {
            if (y22Var != null) {
                this.K = new bz4(y22Var);
            } else {
                this.K = null;
                this.F.setColor(this.I.p());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bi
    public void u(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        int iAlpha = Color.alpha(this.I.p());
        if (iAlpha == 0) {
            return;
        }
        zh zhVar = this.K;
        Integer num = zhVar == null ? null : (Integer) zhVar.h();
        Paint paint = this.F;
        if (num != null) {
            paint.setColor(num.intValue());
        } else {
            paint.setColor(this.I.p());
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.x.k() == null ? 100 : ((Integer) this.x.k().h()).intValue())) / 100.0f) * 255.0f);
        this.F.setAlpha(iIntValue);
        Paint paint2 = this.F;
        if (dp0Var != null) {
            dp0Var.b(paint2);
        } else {
            paint2.clearShadowLayer();
        }
        zh zhVar2 = this.J;
        if (zhVar2 != null) {
            this.F.setColorFilter((ColorFilter) zhVar2.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.G;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.I.r();
            float[] fArr2 = this.G;
            fArr2[3] = 0.0f;
            fArr2[4] = this.I.r();
            this.G[5] = this.I.q();
            float[] fArr3 = this.G;
            fArr3[6] = 0.0f;
            fArr3[7] = this.I.q();
            matrix.mapPoints(this.G);
            this.H.reset();
            Path path = this.H;
            float[] fArr4 = this.G;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.H;
            float[] fArr5 = this.G;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.H;
            float[] fArr6 = this.G;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.H;
            float[] fArr7 = this.G;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.H;
            float[] fArr8 = this.G;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.H.close();
            canvas.drawPath(this.H, this.F);
        }
    }
}

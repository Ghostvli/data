package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class eb1 extends xi {
    public bz4 A;
    public final String q;
    public final boolean r;
    public final w02 s;
    public final w02 t;
    public final RectF u;
    public final gb1 v;
    public final int w;
    public final zh x;
    public final zh y;
    public final zh z;

    public eb1(g22 g22Var, bi biVar, db1 db1Var) {
        super(g22Var, biVar, db1Var.b().b(), db1Var.g().b(), db1Var.i(), db1Var.k(), db1Var.m(), db1Var.h(), db1Var.c());
        this.s = new w02();
        this.t = new w02();
        this.u = new RectF();
        this.q = db1Var.j();
        this.v = db1Var.f();
        this.r = db1Var.n();
        this.w = (int) (g22Var.H().d() / 32.0f);
        zh zhVarA = db1Var.e().a();
        this.x = zhVarA;
        zhVarA.a(this);
        biVar.j(zhVarA);
        zh zhVarA2 = db1Var.l().a();
        this.y = zhVarA2;
        zhVarA2.a(this);
        biVar.j(zhVarA2);
        zh zhVarA3 = db1Var.d().a();
        this.z = zhVarA3;
        zhVarA3.a(this);
        biVar.j(zhVarA3);
    }

    @Override // defpackage.xi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        super.g(obj, y22Var);
        if (obj == q22.O) {
            bz4 bz4Var = this.A;
            if (bz4Var != null) {
                this.f.H(bz4Var);
            }
            if (y22Var == null) {
                this.A = null;
                return;
            }
            bz4 bz4Var2 = new bz4(y22Var);
            this.A = bz4Var2;
            bz4Var2.a(this);
            this.f.j(this.A);
        }
    }

    @Override // defpackage.k20
    public String getName() {
        return this.q;
    }

    @Override // defpackage.xi, defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        if (this.r) {
            return;
        }
        d(this.u, matrix, false);
        this.i.setShader(this.v == gb1.LINEAR ? m() : n());
        super.i(canvas, matrix, i, dp0Var);
    }

    public final int[] k(int[] iArr) {
        bz4 bz4Var = this.A;
        if (bz4Var != null) {
            Integer[] numArr = (Integer[]) bz4Var.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    public final int l() {
        int iRound = Math.round(this.y.f() * this.w);
        int iRound2 = Math.round(this.z.f() * this.w);
        int iRound3 = Math.round(this.x.f() * this.w);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient m() {
        long jL = l();
        LinearGradient linearGradient = (LinearGradient) this.s.d(jL);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.y.h();
        PointF pointF2 = (PointF) this.z.h();
        wa1 wa1Var = (wa1) this.x.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, k(wa1Var.d()), wa1Var.e(), Shader.TileMode.CLAMP);
        this.s.h(jL, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient n() {
        long jL = l();
        RadialGradient radialGradient = (RadialGradient) this.t.d(jL);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.y.h();
        PointF pointF2 = (PointF) this.z.h();
        wa1 wa1Var = (wa1) this.x.h();
        int[] iArrK = k(wa1Var.d());
        float[] fArrE = wa1Var.e();
        RadialGradient radialGradient2 = new RadialGradient(pointF.x, pointF.y, (float) Math.hypot(pointF2.x - r7, pointF2.y - r8), iArrK, fArrE, Shader.TileMode.CLAMP);
        this.t.h(jL, radialGradient2);
        return radialGradient2;
    }
}

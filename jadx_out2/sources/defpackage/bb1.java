package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bb1 implements mo0, zh.b, br1 {
    public final String a;
    public final boolean b;
    public final bi c;
    public final w02 d = new w02();
    public final w02 e = new w02();
    public final Path f;
    public final Paint g;
    public final RectF h;
    public final List i;
    public final gb1 j;
    public final zh k;
    public final zh l;
    public final zh m;
    public final zh n;
    public zh o;
    public bz4 p;
    public final g22 q;
    public final int r;
    public zh s;
    public float t;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bb1(g22 g22Var, f12 f12Var, bi biVar, ab1 ab1Var) {
        Path path = new Path();
        this.f = path;
        this.g = new qr1(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.t = 0.0f;
        this.c = biVar;
        this.a = ab1Var.f();
        this.b = ab1Var.i();
        this.q = g22Var;
        this.j = ab1Var.e();
        path.setFillType(ab1Var.c());
        this.r = (int) (f12Var.d() / 32.0f);
        zh zhVarA = ab1Var.d().a();
        this.k = zhVarA;
        zhVarA.a(this);
        biVar.j(zhVarA);
        zh zhVarA2 = ab1Var.g().a();
        this.l = zhVarA2;
        zhVarA2.a(this);
        biVar.j(zhVarA2);
        zh zhVarA3 = ab1Var.h().a();
        this.m = zhVarA3;
        zhVarA3.a(this);
        biVar.j(zhVarA3);
        zh zhVarA4 = ab1Var.b().a();
        this.n = zhVarA4;
        zhVarA4.a(this);
        biVar.j(zhVarA4);
        if (biVar.x() != null) {
            t21 t21VarA = biVar.x().a().a();
            this.s = t21VarA;
            t21VarA.a(this);
            biVar.j(this.s);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int[] f(int[] iArr) {
        bz4 bz4Var = this.p;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int j() {
        int iRound = Math.round(this.m.f() * this.r);
        int iRound2 = Math.round(this.n.f() * this.r);
        int iRound3 = Math.round(this.k.f() * this.r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private LinearGradient k() {
        float[] fArr;
        int[] iArr;
        long j = j();
        LinearGradient linearGradient = (LinearGradient) this.d.d(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.m.h();
        PointF pointF2 = (PointF) this.n.h();
        wa1 wa1Var = (wa1) this.k.h();
        int[] iArrF = f(wa1Var.d());
        float[] fArrE = wa1Var.e();
        if (iArrF.length < 2) {
            iArr = new int[]{iArrF[0], iArrF[0]};
            fArr = new float[]{0.0f, 1.0f};
        } else {
            fArr = fArrE;
            iArr = iArrF;
        }
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, iArr, fArr, Shader.TileMode.CLAMP);
        this.d.h(j, linearGradient2);
        return linearGradient2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private RadialGradient l() {
        float[] fArr;
        int[] iArr;
        long j = j();
        RadialGradient radialGradient = (RadialGradient) this.e.d(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.m.h();
        PointF pointF2 = (PointF) this.n.h();
        wa1 wa1Var = (wa1) this.k.h();
        int[] iArrF = f(wa1Var.d());
        float[] fArrE = wa1Var.e();
        if (iArrF.length < 2) {
            iArr = new int[]{iArrF[0], iArrF[0]};
            fArr = new float[]{0.0f, 1.0f};
        } else {
            fArr = fArrE;
            iArr = iArrF;
        }
        float f = pointF.x;
        float f2 = pointF.y;
        float fHypot = (float) Math.hypot(pointF2.x - f, pointF2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArr, fArr, Shader.TileMode.CLAMP);
        this.e.h(j, radialGradient2);
        return radialGradient2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        this.q.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public void b(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            k20 k20Var = (k20) list2.get(i);
            if (k20Var instanceof f93) {
                this.i.add((f93) k20Var);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        int i = 0;
        while (true) {
            int size = this.i.size();
            Path path = this.f;
            if (i >= size) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((f93) this.i.get(i)).getPath(), matrix);
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.d) {
            this.l.o(y22Var);
            return;
        }
        if (obj == q22.N) {
            zh zhVar = this.o;
            if (zhVar != null) {
                this.c.H(zhVar);
            }
            if (y22Var == null) {
                this.o = null;
                return;
            }
            bz4 bz4Var = new bz4(y22Var);
            this.o = bz4Var;
            bz4Var.a(this);
            this.c.j(this.o);
            return;
        }
        if (obj != q22.O) {
            if (obj == q22.j) {
                zh zhVar2 = this.s;
                if (zhVar2 != null) {
                    zhVar2.o(y22Var);
                    return;
                }
                bz4 bz4Var2 = new bz4(y22Var);
                this.s = bz4Var2;
                bz4Var2.a(this);
                this.c.j(this.s);
                return;
            }
            return;
        }
        bz4 bz4Var3 = this.p;
        if (bz4Var3 != null) {
            this.c.H(bz4Var3);
        }
        if (y22Var == null) {
            this.p = null;
            return;
        }
        this.d.a();
        this.e.a();
        bz4 bz4Var4 = new bz4(y22Var);
        this.p = bz4Var4;
        bz4Var4.a(this);
        this.c.j(this.p);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public String getName() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        Path path;
        if (this.b) {
            return;
        }
        if (or1.h()) {
            or1.b("GradientFillContent#draw");
        }
        this.f.reset();
        int i2 = 0;
        while (true) {
            int size = this.i.size();
            path = this.f;
            if (i2 >= size) {
                break;
            }
            path.addPath(((f93) this.i.get(i2)).getPath(), matrix);
            i2++;
        }
        path.computeBounds(this.h, false);
        Shader shaderK = this.j == gb1.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.g.setShader(shaderK);
        zh zhVar = this.o;
        if (zhVar != null) {
            this.g.setColorFilter((ColorFilter) zhVar.h());
        }
        zh zhVar2 = this.s;
        if (zhVar2 != null) {
            float fFloatValue = ((Float) zhVar2.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.g.setMaskFilter(null);
            } else if (fFloatValue != this.t) {
                this.g.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.t = fFloatValue;
        }
        float fIntValue = ((Integer) this.l.h()).intValue() / 100.0f;
        this.g.setAlpha(ot2.c((int) (i * fIntValue), 0, 255));
        if (dp0Var != null) {
            dp0Var.d((int) (fIntValue * 255.0f), this.g);
        }
        canvas.drawPath(this.f, this.g);
        if (or1.h()) {
            or1.c("GradientFillContent#draw");
        }
    }
}

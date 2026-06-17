package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import defpackage.p54;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xi implements zh.b, br1, mo0 {
    public final g22 e;
    public final bi f;
    public final float[] h;
    public final Paint i;
    public final zh j;
    public final zh k;
    public final List l;
    public final zh m;
    public zh n;
    public zh o;
    public float p;
    public final PathMeasure a = new PathMeasure();
    public final Path b = new Path();
    public final Path c = new Path();
    public final RectF d = new RectF();
    public final List g = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final List a;
        public final nt4 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(nt4 nt4Var) {
            this.a = new ArrayList();
            this.b = nt4Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xi(g22 g22Var, bi biVar, Paint.Cap cap, Paint.Join join, float f, l6 l6Var, j6 j6Var, List list, j6 j6Var2) {
        qr1 qr1Var = new qr1(1);
        this.i = qr1Var;
        this.p = 0.0f;
        this.e = g22Var;
        this.f = biVar;
        qr1Var.setStyle(Paint.Style.STROKE);
        qr1Var.setStrokeCap(cap);
        qr1Var.setStrokeJoin(join);
        qr1Var.setStrokeMiter(f);
        this.k = l6Var.a();
        this.j = j6Var.a();
        if (j6Var2 == null) {
            this.m = null;
        } else {
            this.m = j6Var2.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(((j6) list.get(i)).a());
        }
        biVar.j(this.k);
        biVar.j(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            biVar.j((zh) this.l.get(i2));
        }
        zh zhVar = this.m;
        if (zhVar != null) {
            biVar.j(zhVar);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((zh) this.l.get(i3)).a(this);
        }
        zh zhVar2 = this.m;
        if (zhVar2 != null) {
            zhVar2.a(this);
        }
        if (biVar.x() != null) {
            t21 t21VarA = biVar.x().a().a();
            this.o = t21VarA;
            t21VarA.a(this);
            biVar.j(this.o);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        this.e.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // defpackage.k20
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(List list, List list2) {
        nt4 nt4Var = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            k20 k20Var = (k20) list.get(size);
            if (k20Var instanceof nt4) {
                nt4 nt4Var2 = (nt4) k20Var;
                if (nt4Var2.k() == p54.a.INDIVIDUALLY) {
                    nt4Var = nt4Var2;
                }
            }
        }
        if (nt4Var != null) {
            nt4Var.f(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            k20 k20Var2 = (k20) list2.get(size2);
            if (k20Var2 instanceof nt4) {
                nt4 nt4Var3 = (nt4) k20Var2;
                if (nt4Var3.k() == p54.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(nt4Var3);
                    nt4Var3.f(this);
                } else if (k20Var2 instanceof f93) {
                    if (bVar == null) {
                        bVar = new b(nt4Var);
                    }
                    bVar.a.add((f93) k20Var2);
                }
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        if (or1.h()) {
            or1.b("StrokeContent#getBounds");
        }
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = (b) this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.b.addPath(((f93) bVar.a.get(i2)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float fR = ((t21) this.j).r();
        RectF rectF2 = this.d;
        float f = fR / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        if (or1.h()) {
            or1.c("StrokeContent#getBounds");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        if (or1.h()) {
            or1.b("StrokeContent#applyDashPattern");
        }
        if (this.l.isEmpty()) {
            if (or1.h()) {
                or1.c("StrokeContent#applyDashPattern");
                return;
            }
            return;
        }
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = ((Float) ((zh) this.l.get(i)).h()).floatValue();
            int i2 = i % 2;
            float[] fArr = this.h;
            if (i2 == 0) {
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else if (fArr[i] < 0.1f) {
                fArr[i] = 0.1f;
            }
        }
        zh zhVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, zhVar == null ? 0.0f : ((Float) zhVar.h()).floatValue()));
        if (or1.h()) {
            or1.c("StrokeContent#applyDashPattern");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.d) {
            this.k.o(y22Var);
            return;
        }
        if (obj == q22.v) {
            this.j.o(y22Var);
            return;
        }
        if (obj == q22.N) {
            zh zhVar = this.n;
            if (zhVar != null) {
                this.f.H(zhVar);
            }
            if (y22Var == null) {
                this.n = null;
                return;
            }
            bz4 bz4Var = new bz4(y22Var);
            this.n = bz4Var;
            bz4Var.a(this);
            this.f.j(this.n);
            return;
        }
        if (obj == q22.j) {
            zh zhVar2 = this.o;
            if (zhVar2 != null) {
                zhVar2.o(y22Var);
                return;
            }
            bz4 bz4Var2 = new bz4(y22Var);
            this.o = bz4Var2;
            bz4Var2.a(this);
            this.f.j(this.o);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        if (or1.h()) {
            or1.b("StrokeContent#draw");
        }
        if (uy4.h(matrix)) {
            if (or1.h()) {
                or1.c("StrokeContent#draw");
                return;
            }
            return;
        }
        float fIntValue = ((Integer) this.k.h()).intValue() / 100.0f;
        this.i.setAlpha(ot2.c((int) (i * fIntValue), 0, 255));
        this.i.setStrokeWidth(((t21) this.j).r());
        if (this.i.getStrokeWidth() <= 0.0f) {
            if (or1.h()) {
                or1.c("StrokeContent#draw");
                return;
            }
            return;
        }
        f();
        zh zhVar = this.n;
        if (zhVar != null) {
            this.i.setColorFilter((ColorFilter) zhVar.h());
        }
        zh zhVar2 = this.o;
        if (zhVar2 != null) {
            float fFloatValue = ((Float) zhVar2.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.i.setMaskFilter(null);
            } else if (fFloatValue != this.p) {
                this.i.setMaskFilter(this.f.y(fFloatValue));
            }
            this.p = fFloatValue;
        }
        if (dp0Var != null) {
            dp0Var.d((int) (fIntValue * 255.0f), this.i);
        }
        canvas.save();
        canvas.concat(matrix);
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = (b) this.g.get(i2);
            if (bVar.b != null) {
                j(canvas, bVar);
            } else {
                if (or1.h()) {
                    or1.b("StrokeContent#buildPath");
                }
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((f93) bVar.a.get(size)).getPath());
                }
                if (or1.h()) {
                    or1.c("StrokeContent#buildPath");
                    or1.b("StrokeContent#drawPath");
                }
                canvas.drawPath(this.b, this.i);
                if (or1.h()) {
                    or1.c("StrokeContent#drawPath");
                }
            }
        }
        canvas.restore();
        if (or1.h()) {
            or1.c("StrokeContent#draw");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(Canvas canvas, b bVar) {
        if (or1.h()) {
            or1.b("StrokeContent#applyTrimPath");
        }
        if (bVar.b == null) {
            if (or1.h()) {
                or1.c("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((f93) bVar.a.get(size)).getPath());
        }
        float fFloatValue = ((Float) bVar.b.j().h()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) bVar.b.g().h()).floatValue() / 100.0f;
        float fFloatValue3 = ((Float) bVar.b.h().h()).floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.b, this.i);
            if (or1.h()) {
                or1.c("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float f = fFloatValue3 * length;
        float f2 = (fFloatValue * length) + f;
        float fMin = Math.min((fFloatValue2 * length) + f, (f2 + length) - 1.0f);
        float f3 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((f93) bVar.a.get(size2)).getPath());
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            if (fMin > length) {
                float f4 = fMin - length;
                if (f4 >= f3 + length2 || f3 >= f4) {
                    float f5 = f3 + length2;
                    if (f5 >= f2 && f3 <= fMin) {
                        if (f5 > fMin || f2 >= f3) {
                            uy4.a(this.c, f2 < f3 ? 0.0f : (f2 - f3) / length2, fMin > f5 ? 1.0f : (fMin - f3) / length2, 0.0f);
                            canvas.drawPath(this.c, this.i);
                        } else {
                            canvas.drawPath(this.c, this.i);
                        }
                    }
                } else {
                    uy4.a(this.c, f2 > length ? (f2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.i);
                }
            }
            f3 += length2;
        }
        if (or1.h()) {
            or1.c("StrokeContent#applyTrimPath");
        }
    }
}

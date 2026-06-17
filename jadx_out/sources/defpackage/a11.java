package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a11 implements mo0, zh.b, br1 {
    public final Path a;
    public final Paint b;
    public final bi c;
    public final String d;
    public final boolean e;
    public final List f;
    public final zh g;
    public final zh h;
    public zh i;
    public final g22 j;
    public zh k;
    public float l;

    public a11(g22 g22Var, bi biVar, d54 d54Var) {
        Path path = new Path();
        this.a = path;
        this.b = new qr1(1);
        this.f = new ArrayList();
        this.c = biVar;
        this.d = d54Var.d();
        this.e = d54Var.f();
        this.j = g22Var;
        if (biVar.x() != null) {
            t21 t21VarA = biVar.x().a().a();
            this.k = t21VarA;
            t21VarA.a(this);
            biVar.j(this.k);
        }
        if (d54Var.b() == null || d54Var.e() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(d54Var.c());
        zh zhVarA = d54Var.b().a();
        this.g = zhVarA;
        zhVarA.a(this);
        biVar.j(zhVarA);
        zh zhVarA2 = d54Var.e().a();
        this.h = zhVarA2;
        zhVarA2.a(this);
        biVar.j(zhVarA2);
    }

    @Override // zh.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // defpackage.k20
    public void b(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            k20 k20Var = (k20) list2.get(i);
            if (k20Var instanceof f93) {
                this.f.add((f93) k20Var);
            }
        }
    }

    @Override // defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        int i = 0;
        while (true) {
            int size = this.f.size();
            Path path = this.a;
            if (i >= size) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((f93) this.f.get(i)).getPath(), matrix);
                i++;
            }
        }
    }

    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.a) {
            this.g.o(y22Var);
            return;
        }
        if (obj == q22.d) {
            this.h.o(y22Var);
            return;
        }
        if (obj == q22.N) {
            zh zhVar = this.i;
            if (zhVar != null) {
                this.c.H(zhVar);
            }
            if (y22Var == null) {
                this.i = null;
                return;
            }
            bz4 bz4Var = new bz4(y22Var);
            this.i = bz4Var;
            bz4Var.a(this);
            this.c.j(this.i);
            return;
        }
        if (obj == q22.j) {
            zh zhVar2 = this.k;
            if (zhVar2 != null) {
                zhVar2.o(y22Var);
                return;
            }
            bz4 bz4Var2 = new bz4(y22Var);
            this.k = bz4Var2;
            bz4Var2.a(this);
            this.c.j(this.k);
        }
    }

    @Override // defpackage.k20
    public String getName() {
        return this.d;
    }

    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }

    @Override // defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        Path path;
        if (this.e) {
            return;
        }
        if (or1.h()) {
            or1.b("FillContent#draw");
        }
        float fIntValue = ((Integer) this.h.h()).intValue() / 100.0f;
        int i2 = 0;
        this.b.setColor((ot2.c((int) (i * fIntValue), 0, 255) << 24) | (((cx) this.g).r() & 16777215));
        zh zhVar = this.i;
        if (zhVar != null) {
            this.b.setColorFilter((ColorFilter) zhVar.h());
        }
        zh zhVar2 = this.k;
        if (zhVar2 != null) {
            float fFloatValue = ((Float) zhVar2.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.b.setMaskFilter(null);
            } else if (fFloatValue != this.l) {
                this.b.setMaskFilter(this.c.y(fFloatValue));
            }
            this.l = fFloatValue;
        }
        Paint paint = this.b;
        if (dp0Var != null) {
            dp0Var.d((int) (fIntValue * 255.0f), paint);
        } else {
            paint.clearShadowLayer();
        }
        this.a.reset();
        while (true) {
            int size = this.f.size();
            path = this.a;
            if (i2 >= size) {
                break;
            }
            path.addPath(((f93) this.f.get(i2)).getPath(), matrix);
            i2++;
        }
        canvas.drawPath(path, this.b);
        if (or1.h()) {
            or1.c("FillContent#draw");
        }
    }
}

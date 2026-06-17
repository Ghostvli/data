package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import defpackage.e52;
import defpackage.yr1;
import defpackage.zh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bi implements mo0, zh.b, ar1 {
    public Paint A;
    public float B;
    public BlurMaskFilter C;
    public qr1 D;
    public final Path a = new Path();
    public final Matrix b = new Matrix();
    public final Matrix c = new Matrix();
    public final Paint d = new qr1(1);
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final RectF i;
    public final RectF j;
    public final RectF k;
    public final RectF l;
    public final RectF m;
    public final String n;
    public final Matrix o;
    public final g22 p;
    public final yr1 q;
    public f52 r;
    public t21 s;
    public bi t;
    public bi u;
    public List v;
    public final List w;
    public final ms4 x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[e52.a.values().length];
            b = iArr;
            try {
                iArr[e52.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[e52.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[e52.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[e52.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[yr1.a.values().length];
            a = iArr2;
            try {
                iArr2[yr1.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[yr1.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[yr1.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[yr1.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[yr1.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[yr1.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[yr1.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public bi(g22 g22Var, yr1 yr1Var) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.e = new qr1(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f = new qr1(1, mode2);
        qr1 qr1Var = new qr1(1);
        this.g = qr1Var;
        this.h = new qr1(PorterDuff.Mode.CLEAR);
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new RectF();
        this.o = new Matrix();
        this.w = new ArrayList();
        this.y = true;
        this.B = 0.0f;
        this.p = g22Var;
        this.q = yr1Var;
        this.n = yr1Var.j() + "#draw";
        if (yr1Var.i() == yr1.b.INVERT) {
            qr1Var.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            qr1Var.setXfermode(new PorterDuffXfermode(mode));
        }
        ms4 ms4VarB = yr1Var.x().b();
        this.x = ms4VarB;
        ms4VarB.e(this);
        if (yr1Var.h() != null && !yr1Var.h().isEmpty()) {
            f52 f52Var = new f52(yr1Var.h());
            this.r = f52Var;
            Iterator it = f52Var.a().iterator();
            while (it.hasNext()) {
                ((zh) it.next()).a(this);
            }
            for (zh zhVar : this.r.c()) {
                j(zhVar);
                zhVar.a(this);
            }
        }
        O();
    }

    public static bi v(ry ryVar, yr1 yr1Var, g22 g22Var, f12 f12Var) {
        switch (a.a[yr1Var.g().ordinal()]) {
            case 1:
                return new i54(g22Var, yr1Var, ryVar, f12Var);
            case 2:
                return new ry(g22Var, yr1Var, f12Var.o(yr1Var.n()), f12Var);
            case 3:
                return new ja4(g22Var, yr1Var);
            case 4:
                return new ji1(g22Var, yr1Var);
            case 5:
                return new l43(g22Var, yr1Var);
            case 6:
                return new rm4(g22Var, yr1Var);
            default:
                k02.c("Unknown layer type " + yr1Var.g());
                return null;
        }
    }

    public yr1 A() {
        return this.q;
    }

    public boolean B() {
        f52 f52Var = this.r;
        return (f52Var == null || f52Var.a().isEmpty()) ? false : true;
    }

    public boolean C() {
        return this.t != null;
    }

    public final void D(RectF rectF, Matrix matrix) {
        this.k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (B()) {
            int size = this.r.b().size();
            for (int i = 0; i < size; i++) {
                e52 e52Var = (e52) this.r.b().get(i);
                Path path = (Path) ((zh) this.r.a().get(i)).h();
                if (path != null) {
                    this.a.set(path);
                    this.a.transform(matrix);
                    int i2 = a.b[e52Var.a().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && e52Var.d()) {
                        return;
                    }
                    this.a.computeBounds(this.m, false);
                    RectF rectF2 = this.k;
                    if (i == 0) {
                        rectF2.set(this.m);
                    } else {
                        rectF2.set(Math.min(rectF2.left, this.m.left), Math.min(this.k.top, this.m.top), Math.max(this.k.right, this.m.right), Math.max(this.k.bottom, this.m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void E(RectF rectF, Matrix matrix) {
        if (C() && this.q.i() != yr1.b.INVERT) {
            this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.t.d(this.l, matrix, true);
            if (rectF.intersect(this.l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void F() {
        this.p.invalidateSelf();
    }

    public final void G(float f) {
        this.p.H().n().a(this.q.j(), f);
    }

    public void H(zh zhVar) {
        this.w.remove(zhVar);
    }

    public void I(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
    }

    public void J(bi biVar) {
        this.t = biVar;
    }

    public void K(boolean z) {
        if (z && this.A == null) {
            this.A = new qr1();
        }
        this.z = z;
    }

    public void L(bi biVar) {
        this.u = biVar;
    }

    public void M(float f) {
        if (or1.h()) {
            or1.b("BaseLayer#setProgress");
            or1.b("BaseLayer#setProgress.transform");
        }
        this.x.m(f);
        if (or1.h()) {
            or1.c("BaseLayer#setProgress.transform");
        }
        if (this.r != null) {
            if (or1.h()) {
                or1.b("BaseLayer#setProgress.mask");
            }
            for (int i = 0; i < this.r.a().size(); i++) {
                ((zh) this.r.a().get(i)).n(f);
            }
            if (or1.h()) {
                or1.c("BaseLayer#setProgress.mask");
            }
        }
        if (this.s != null) {
            if (or1.h()) {
                or1.b("BaseLayer#setProgress.inout");
            }
            this.s.n(f);
            if (or1.h()) {
                or1.c("BaseLayer#setProgress.inout");
            }
        }
        if (this.t != null) {
            if (or1.h()) {
                or1.b("BaseLayer#setProgress.matte");
            }
            this.t.M(f);
            if (or1.h()) {
                or1.c("BaseLayer#setProgress.matte");
            }
        }
        if (or1.h()) {
            or1.b("BaseLayer#setProgress.animations." + this.w.size());
        }
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            ((zh) this.w.get(i2)).n(f);
        }
        if (or1.h()) {
            or1.c("BaseLayer#setProgress.animations." + this.w.size());
            or1.c("BaseLayer#setProgress");
        }
    }

    public final void N(boolean z) {
        if (z != this.y) {
            this.y = z;
            F();
        }
    }

    public final void O() {
        if (this.q.f().isEmpty()) {
            N(true);
            return;
        }
        t21 t21Var = new t21(this.q.f());
        this.s = t21Var;
        t21Var.m();
        this.s.a(new zh.b() { // from class: ai
            @Override // zh.b
            public final void a() {
                bi biVar = this.a;
                biVar.N(biVar.s.r() == 1.0f);
            }
        });
        N(((Float) this.s.h()).floatValue() == 1.0f);
        j(this.s);
    }

    @Override // zh.b
    public void a() {
        F();
    }

    @Override // defpackage.k20
    public void b(List list, List list2) {
    }

    @Override // defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.o.set(matrix);
        if (z) {
            List list = this.v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.o.preConcat(((bi) this.v.get(size)).x.i());
                }
            } else {
                bi biVar = this.u;
                if (biVar != null) {
                    this.o.preConcat(biVar.x.i());
                }
            }
        }
        this.o.preConcat(this.x.i());
    }

    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        this.x.f(obj, y22Var);
    }

    @Override // defpackage.k20
    public String getName() {
        return this.q.j();
    }

    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        bi biVar = this.t;
        if (biVar != null) {
            zq1 zq1VarA = zq1Var2.a(biVar.getName());
            if (zq1Var.c(this.t.getName(), i)) {
                list.add(zq1VarA.i(this.t));
            }
            if (zq1Var.g(this.t.getName(), i) && zq1Var.h(getName(), i)) {
                this.t.I(zq1Var, zq1Var.e(this.t.getName(), i) + i, list, zq1VarA);
            }
        }
        if (zq1Var.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                zq1Var2 = zq1Var2.a(getName());
                if (zq1Var.c(getName(), i)) {
                    list.add(zq1Var2.i(this));
                }
            }
            if (zq1Var.h(getName(), i)) {
                I(zq1Var, i + zq1Var.e(getName(), i), list, zq1Var2);
            }
        }
    }

    @Override // defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        Paint paint;
        Integer num;
        or1.b(this.n);
        if (!this.y || this.q.y()) {
            or1.c(this.n);
            return;
        }
        s();
        if (or1.h()) {
            or1.b("Layer#parentMatrix");
        }
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.v.size() - 1; size >= 0; size--) {
            this.b.preConcat(((bi) this.v.get(size)).x.i());
        }
        if (or1.h()) {
            or1.c("Layer#parentMatrix");
        }
        zh zhVarK = this.x.k();
        int iIntValue = (int) ((((i / 255.0f) * ((zhVarK == null || (num = (Integer) zhVarK.h()) == null) ? 100 : num.intValue())) / 100.0f) * 255.0f);
        if (!C() && !B() && w() == pr1.NORMAL) {
            this.b.preConcat(this.x.i());
            if (or1.h()) {
                or1.b("Layer#drawLayer");
            }
            u(canvas, this.b, iIntValue, dp0Var);
            if (or1.h()) {
                or1.c("Layer#drawLayer");
            }
            G(or1.c(this.n));
            return;
        }
        if (or1.h()) {
            or1.b("Layer#computeBounds");
        }
        d(this.i, this.b, false);
        E(this.i, matrix);
        this.b.preConcat(this.x.i());
        D(this.i, this.b);
        this.j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.c);
        if (!this.c.isIdentity()) {
            Matrix matrix2 = this.c;
            matrix2.invert(matrix2);
            this.c.mapRect(this.j);
        }
        if (!this.i.intersect(this.j)) {
            this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        if (or1.h()) {
            or1.c("Layer#computeBounds");
        }
        if (this.i.width() >= 1.0f && this.i.height() >= 1.0f) {
            if (or1.h()) {
                or1.b("Layer#saveLayer");
            }
            this.d.setAlpha(255);
            h73.b(this.d, w().b());
            uy4.n(canvas, this.i, this.d);
            if (or1.h()) {
                or1.c("Layer#saveLayer");
            }
            if (w() != pr1.MULTIPLY) {
                t(canvas);
            } else if (Build.VERSION.SDK_INT < 29) {
                if (this.D == null) {
                    qr1 qr1Var = new qr1();
                    this.D = qr1Var;
                    qr1Var.setColor(-1);
                }
                RectF rectF = this.i;
                canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.D);
            }
            if (or1.h()) {
                or1.b("Layer#drawLayer");
            }
            u(canvas, this.b, iIntValue, dp0Var);
            if (or1.h()) {
                or1.c("Layer#drawLayer");
            }
            if (B()) {
                p(canvas, this.b);
            }
            if (C()) {
                if (or1.h()) {
                    or1.b("Layer#drawMatte");
                    or1.b("Layer#saveLayer");
                }
                uy4.o(canvas, this.i, this.g, 19);
                if (or1.h()) {
                    or1.c("Layer#saveLayer");
                }
                t(canvas);
                this.t.i(canvas, matrix, i, null);
                if (or1.h()) {
                    or1.b("Layer#restoreLayer");
                }
                canvas.restore();
                if (or1.h()) {
                    or1.c("Layer#restoreLayer");
                    or1.c("Layer#drawMatte");
                }
            }
            if (or1.h()) {
                or1.b("Layer#restoreLayer");
            }
            canvas.restore();
            if (or1.h()) {
                or1.c("Layer#restoreLayer");
            }
        }
        if (this.z && (paint = this.A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.A.setColor(-251901);
            this.A.setStrokeWidth(4.0f);
            canvas.drawRect(this.i, this.A);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setColor(1357638635);
            canvas.drawRect(this.i, this.A);
        }
        G(or1.c(this.n));
    }

    public void j(zh zhVar) {
        if (zhVar == null) {
            return;
        }
        this.w.add(zhVar);
    }

    public final void k(Canvas canvas, Matrix matrix, zh zhVar, zh zhVar2) {
        this.a.set((Path) zhVar.h());
        this.a.transform(matrix);
        this.d.setAlpha((int) (((Integer) zhVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.a, this.d);
    }

    public final void l(Canvas canvas, Matrix matrix, zh zhVar, zh zhVar2) {
        uy4.n(canvas, this.i, this.e);
        this.a.set((Path) zhVar.h());
        this.a.transform(matrix);
        this.d.setAlpha((int) (((Integer) zhVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.a, this.d);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, zh zhVar, zh zhVar2) {
        uy4.n(canvas, this.i, this.d);
        canvas.drawRect(this.i, this.d);
        this.a.set((Path) zhVar.h());
        this.a.transform(matrix);
        this.d.setAlpha((int) (((Integer) zhVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.a, this.f);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, zh zhVar, zh zhVar2) {
        uy4.n(canvas, this.i, this.e);
        canvas.drawRect(this.i, this.d);
        this.f.setAlpha((int) (((Integer) zhVar2.h()).intValue() * 2.55f));
        this.a.set((Path) zhVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix, zh zhVar, zh zhVar2) {
        uy4.n(canvas, this.i, this.f);
        canvas.drawRect(this.i, this.d);
        this.f.setAlpha((int) (((Integer) zhVar2.h()).intValue() * 2.55f));
        this.a.set((Path) zhVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f);
        canvas.restore();
    }

    public final void p(Canvas canvas, Matrix matrix) {
        if (or1.h()) {
            or1.b("Layer#saveLayer");
        }
        uy4.o(canvas, this.i, this.e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            t(canvas);
        }
        if (or1.h()) {
            or1.c("Layer#saveLayer");
        }
        for (int i = 0; i < this.r.b().size(); i++) {
            e52 e52Var = (e52) this.r.b().get(i);
            zh zhVar = (zh) this.r.a().get(i);
            zh zhVar2 = (zh) this.r.c().get(i);
            int i2 = a.b[e52Var.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.d.setColor(-16777216);
                        this.d.setAlpha(255);
                        canvas.drawRect(this.i, this.d);
                    }
                    if (e52Var.d()) {
                        o(canvas, matrix, zhVar, zhVar2);
                    } else {
                        q(canvas, matrix, zhVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (e52Var.d()) {
                            m(canvas, matrix, zhVar, zhVar2);
                        } else {
                            k(canvas, matrix, zhVar, zhVar2);
                        }
                    }
                } else if (e52Var.d()) {
                    n(canvas, matrix, zhVar, zhVar2);
                } else {
                    l(canvas, matrix, zhVar, zhVar2);
                }
            } else if (r()) {
                this.d.setAlpha(255);
                canvas.drawRect(this.i, this.d);
            }
        }
        if (or1.h()) {
            or1.b("Layer#restoreLayer");
        }
        canvas.restore();
        if (or1.h()) {
            or1.c("Layer#restoreLayer");
        }
    }

    public final void q(Canvas canvas, Matrix matrix, zh zhVar) {
        this.a.set((Path) zhVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f);
    }

    public final boolean r() {
        if (this.r.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.r.b().size(); i++) {
            if (((e52) this.r.b().get(i)).a() != e52.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void s() {
        if (this.v != null) {
            return;
        }
        if (this.u == null) {
            this.v = Collections.EMPTY_LIST;
            return;
        }
        this.v = new ArrayList();
        for (bi biVar = this.u; biVar != null; biVar = biVar.u) {
            this.v.add(biVar);
        }
    }

    public final void t(Canvas canvas) {
        if (or1.h()) {
            or1.b("Layer#clearLayer");
        }
        RectF rectF = this.i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.h);
        if (or1.h()) {
            or1.c("Layer#clearLayer");
        }
    }

    public abstract void u(Canvas canvas, Matrix matrix, int i, dp0 dp0Var);

    public pr1 w() {
        return this.q.a();
    }

    public xk x() {
        return this.q.b();
    }

    public BlurMaskFilter y(float f) {
        if (this.B == f) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f;
        return blurMaskFilter;
    }

    public ep0 z() {
        return this.q.d();
    }
}

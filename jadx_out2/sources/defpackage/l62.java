package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import defpackage.k54;
import defpackage.y44;
import defpackage.z44;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class l62 extends Drawable implements r54 {
    public static final String K = "l62";
    public static final y44 L = y44.e().p(0, 0.0f).m();
    public static final Paint M;
    public static final e[] N;
    public int A;
    public final RectF B;
    public boolean C;
    public boolean D;
    public y44 E;
    public ed4 F;
    public dd4[] G;
    public float[] H;
    public float[] I;
    public d J;
    public final y44.c f;
    public c g;
    public final k54.g[] h;
    public final k54.g[] i;
    public final BitSet j;
    public boolean k;
    public boolean l;
    public final Matrix m;
    public final Path n;
    public final Path o;
    public final RectF p;
    public final RectF q;
    public final Region r;
    public final Region s;
    public final Paint t;
    public final Paint u;
    public final v44 v;
    public final z44.b w;
    public final z44 x;
    public PorterDuffColorFilter y;
    public PorterDuffColorFilter z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements y44.c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // y44.c
        public d40 a(d40 d40Var) {
            return d40Var instanceof dq3 ? d40Var : new b5(-l62.this.K(), d40Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements z44.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z44.b
        public void a(k54 k54Var, Matrix matrix, int i) {
            l62.this.j.set(i + 4, k54Var.e());
            l62.this.i[i] = k54Var.f(matrix);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z44.b
        public void b(k54 k54Var, Matrix matrix, int i) {
            l62.this.j.set(i, k54Var.e());
            l62.this.h[i] = k54Var.f(matrix);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(float f);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends v21 {
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(int i) {
            super("cornerSizeAtIndex" + i);
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)F */
        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(l62 l62Var) {
            if (l62Var.H != null) {
                return l62Var.H[this.b];
            }
            return 0.0f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;F)V */
        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(l62 l62Var, float f) {
            if (l62Var.H == null || l62Var.H[this.b] == f) {
                return;
            }
            l62Var.H[this.b] = f;
            if (l62Var.J != null) {
                l62Var.J.a(l62Var.A());
            }
            l62Var.invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        int i = 0;
        Paint paint = new Paint(1);
        M = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        N = new e[4];
        while (true) {
            e[] eVarArr = N;
            if (i >= eVarArr.length) {
                return;
            }
            eVarArr[i] = new e(i);
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l62(c cVar) {
        this.f = new a();
        this.h = new k54.g[4];
        this.i = new k54.g[4];
        this.j = new BitSet(8);
        this.m = new Matrix();
        this.n = new Path();
        this.o = new Path();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new Region();
        this.s = new Region();
        Paint paint = new Paint(1);
        this.t = paint;
        Paint paint2 = new Paint(1);
        this.u = paint2;
        this.v = new v44();
        this.x = z44.m();
        this.B = new RectF();
        this.C = true;
        this.D = true;
        this.G = new dd4[4];
        this.g = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        w0();
        s0(getState());
        this.w = new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int Y(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static l62 s(Context context, float f, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(h62.c(context, mk3.l, l62.class.getSimpleName()));
        }
        l62 l62Var = new l62();
        l62Var.S(context);
        l62Var.e0(colorStateList);
        l62Var.d0(f);
        return l62Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float A() {
        float[] fArr = this.H;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFY = y();
        return (((this.x.h(3, J()).a(rectFY) + this.x.h(2, J()).a(rectFY)) - this.x.h(1, J()).a(rectFY)) - this.x.h(0, J()).a(rectFY)) / 2.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float B() {
        return this.g.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList C() {
        return this.g.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float D() {
        return this.g.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float E() {
        return this.g.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Path F() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int G() {
        return this.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int H() {
        return (int) (((double) this.g.s) * Math.sin(Math.toRadians(r4.t)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int I() {
        return (int) (((double) this.g.s) * Math.cos(Math.toRadians(r4.t)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y44 J() {
        return this.g.a.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float K() {
        if (R()) {
            return this.u.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float L() {
        float[] fArr = this.H;
        return fArr != null ? fArr[3] : this.g.a.c().x().a(y());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float M() {
        float[] fArr = this.H;
        return fArr != null ? fArr[0] : this.g.a.c().z().a(y());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float N() {
        return this.g.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float O() {
        return B() + N();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P() {
        c cVar = this.g;
        int i = cVar.q;
        if (i == 1 || cVar.r <= 0) {
            return false;
        }
        return i == 2 || a0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Q() {
        Paint.Style style = this.g.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean R() {
        Paint.Style style = this.g.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.u.getStrokeWidth() > 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(Context context) {
        this.g.b = new fr0(context);
        x0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T() {
        super.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean U() {
        for (dd4 dd4Var : this.G) {
            if (dd4Var != null && dd4Var.g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean V() {
        fr0 fr0Var = this.g.b;
        return fr0Var != null && fr0Var.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean W() {
        if (this.g.a.b(getState()).B(y())) {
            return this.H == null || this.D;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X(Canvas canvas) {
        if (P()) {
            canvas.save();
            Z(canvas);
            if (!this.C) {
                t(canvas);
                canvas.restore();
                return;
            }
            Rect bounds = getBounds();
            int iWidth = (int) (this.B.width() - bounds.width());
            int iHeight = (int) (this.B.height() - bounds.height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path. extra width: " + iWidth + " extra height: " + iHeight + " path bounds: " + this.B);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.B.width()) + (this.g.r * 2) + iWidth, ((int) this.B.height()) + (this.g.r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            int i = bounds.left;
            int i2 = this.g.r;
            float f = (i - i2) - iWidth;
            float f2 = (bounds.top - i2) - iHeight;
            canvas2.translate(-f, -f2);
            t(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(Canvas canvas) {
        canvas.translate(H(), I());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a0() {
        return (W() || this.n.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b0(float f) {
        setShapeAppearanceModel(this.g.a.a(f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c0(ed4 ed4Var) {
        if (this.F == ed4Var) {
            return;
        }
        this.F = ed4Var;
        int i = 0;
        while (true) {
            dd4[] dd4VarArr = this.G;
            if (i >= dd4VarArr.length) {
                u0(getState(), true);
                invalidateSelf();
                return;
            } else {
                if (dd4VarArr[i] == null) {
                    dd4VarArr[i] = new dd4(this, N[i]);
                }
                this.G[i].w(new ed4().f(ed4Var.a()).h(ed4Var.c()));
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d0(float f) {
        c cVar = this.g;
        if (cVar.o != f) {
            cVar.o = f;
            x0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.t.setColorFilter(this.y);
        int alpha = this.t.getAlpha();
        this.t.setAlpha(Y(alpha, this.g.m));
        this.u.setColorFilter(this.z);
        this.u.setStrokeWidth(this.g.l);
        int alpha2 = this.u.getAlpha();
        this.u.setAlpha(Y(alpha2, this.g.m));
        boolean zR0 = r0();
        if (Q()) {
            if (this.k) {
                if (zR0) {
                    k(y(), this.n);
                }
                this.k = false;
            }
            X(canvas);
            u(canvas);
        }
        if (R()) {
            if (this.l) {
                v0();
                if (zR0) {
                    o();
                }
                this.l = false;
            }
            x(canvas);
        }
        this.t.setAlpha(alpha);
        this.u.setAlpha(alpha2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0(ColorStateList colorStateList) {
        c cVar = this.g;
        if (cVar.d != colorStateList) {
            cVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f0(float f) {
        c cVar = this.g;
        if (cVar.k != f) {
            cVar.k = f;
            this.k = true;
            this.l = true;
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g0(d dVar) {
        this.J = dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.g.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.g.q == 2) {
            return;
        }
        RectF rectFY = y();
        if (rectFY.isEmpty()) {
            return;
        }
        float fN = n(rectFY, this.g.a.c(), this.H);
        if (fN >= 0.0f) {
            outline.setRoundRect(getBounds(), fN * this.g.k);
            return;
        }
        if (this.k) {
            k(rectFY, this.n);
            this.k = false;
        }
        go0.j(outline, this.n);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.g.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.r.set(getBounds());
        k(y(), this.n);
        this.s.setPath(this.n, this.r);
        this.r.op(this.s, Region.Op.DIFFERENCE);
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h0(int i, int i2, int i3, int i4) {
        c cVar = this.g;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.g.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i0(float f) {
        c cVar = this.g;
        if (cVar.n != f) {
            cVar.n = f;
            x0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.k = true;
        this.l = true;
        super.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.g.g;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.g.f;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.g.e;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        ColorStateList colorStateList4 = this.g.d;
        return (colorStateList4 != null && colorStateList4.isStateful()) || this.g.a.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PorterDuffColorFilter j(Paint paint, boolean z) {
        if (!z) {
            return null;
        }
        int color = paint.getColor();
        int iR = r(color);
        this.A = iR;
        if (iR != color) {
            return new PorterDuffColorFilter(iR, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j0(int i) {
        c cVar = this.g;
        if (cVar.q != i) {
            cVar.q = i;
            T();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(RectF rectF, Path path) {
        l(rectF, path);
        if (this.g.j != 1.0f) {
            this.m.reset();
            Matrix matrix = this.m;
            float f = this.g.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.m);
        }
        path.computeBounds(this.B, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k0(x44 x44Var) {
        if (x44Var instanceof y44) {
            setShapeAppearanceModel((y44) x44Var);
        } else {
            l0((he4) x44Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(RectF rectF, Path path) {
        this.x.f(this.g.a.c(), this.H, this.g.k, rectF, this.w, path);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l0(he4 he4Var) {
        c cVar = this.g;
        if (cVar.a != he4Var) {
            cVar.a = he4Var;
            u0(getState(), true);
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float m() {
        float fN = n(y(), this.g.a.c(), this.H);
        return fN >= 0.0f ? fN * this.g.k : fN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m0(float f, int i) {
        q0(f);
        o0(ColorStateList.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.g = new c(this.g);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float n(RectF rectF, y44 y44Var, float[] fArr) {
        if (fArr == null) {
            if (y44Var.B(rectF)) {
                return y44Var.x().a(rectF);
            }
            return -1.0f;
        }
        if (this.D) {
            return fArr[0];
        }
        return -1.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n0(float f, ColorStateList colorStateList) {
        q0(f);
        o0(colorStateList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o() {
        this.x.f(this.E, this.I, this.g.k, z(), null, this.o);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o0(ColorStateList colorStateList) {
        c cVar = this.g;
        if (cVar.e != colorStateList) {
            cVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.k = true;
        this.l = true;
        super.onBoundsChange(rect);
        if (!this.g.a.d() || rect.isEmpty()) {
            return;
        }
        u0(getState(), true ^ U());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.g.a.d()) {
            t0(iArr);
        }
        boolean z = s0(iArr) || w0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PorterDuffColorFilter p(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = r(colorForState);
        }
        this.A = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p0(ColorStateList colorStateList) {
        this.g.f = colorStateList;
        w0();
        T();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PorterDuffColorFilter q(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? j(paint, z) : p(colorStateList, mode, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q0(float f) {
        this.g.l = f;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int r(int i) {
        float fO = O() + E();
        fr0 fr0Var = this.g.b;
        return fr0Var != null ? fr0Var.c(i, fO) : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean r0() {
        return P() || !W();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean s0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.g.d == null || color2 == (colorForState2 = this.g.d.getColorForState(iArr, (color2 = this.t.getColor())))) {
            z = false;
        } else {
            this.t.setColor(colorForState2);
            z = true;
        }
        if (this.g.e == null || color == (colorForState = this.g.e.getColorForState(iArr, (color = this.u.getColor())))) {
            return z;
        }
        this.u.setColor(colorForState);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        c cVar = this.g;
        if (cVar.m != i) {
            cVar.m = i;
            T();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.c = colorFilter;
        T();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r54
    public void setShapeAppearanceModel(y44 y44Var) {
        this.g.a = y44Var;
        this.H = null;
        this.I = null;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.g.g = colorStateList;
        w0();
        T();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.g;
        if (cVar.h != mode) {
            cVar.h = mode;
            w0();
            T();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(Canvas canvas) {
        if (this.j.cardinality() > 0) {
            Log.w(K, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.g.s != 0) {
            canvas.drawPath(this.n, this.v.c());
        }
        for (int i = 0; i < 4; i++) {
            this.h[i].a(this.v, this.g.r, canvas);
            this.i[i].a(this.v, this.g.r, canvas);
        }
        if (this.C) {
            int iH = H();
            int I = I();
            canvas.translate(-iH, -I);
            canvas.drawPath(this.n, M);
            canvas.translate(iH, I);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0(int[] iArr) {
        u0(iArr, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(Canvas canvas) {
        v(canvas, this.t, this.n, this.g.a.c(), this.H, y());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u0(int[] iArr, boolean z) {
        RectF rectFY = y();
        if (!this.g.a.d() || rectFY.isEmpty()) {
            return;
        }
        boolean z2 = z | (this.F == null);
        if (this.H == null) {
            this.H = new float[4];
        }
        y44 y44VarB = this.g.a.b(iArr);
        boolean z3 = q62.a(this.H) && y44VarB.B(y());
        this.D = z3;
        if (!z3) {
            this.k = true;
            this.l = true;
        }
        for (int i = 0; i < 4; i++) {
            float fA = this.x.h(i, y44VarB).a(rectFY);
            if (z2) {
                this.H[i] = fA;
            }
            dd4 dd4Var = this.G[i];
            if (dd4Var != null) {
                dd4Var.r(fA);
                if (z2) {
                    this.G[i].x();
                }
            }
        }
        if (z2) {
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(Canvas canvas, Paint paint, Path path, y44 y44Var, float[] fArr, RectF rectF) {
        float fN = n(rectF, y44Var, fArr);
        if (fN < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f = fN * this.g.k;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0() {
        this.E = J().D(this.f);
        float[] fArr = this.H;
        if (fArr == null) {
            this.I = null;
            return;
        }
        if (this.I == null) {
            this.I = new float[fArr.length];
        }
        float fK = K();
        int i = 0;
        while (true) {
            float[] fArr2 = this.H;
            if (i >= fArr2.length) {
                return;
            }
            this.I[i] = Math.max(0.0f, fArr2[i] - fK);
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w(Canvas canvas, Paint paint, Path path, RectF rectF) {
        v(canvas, paint, path, this.g.a.c(), this.H, rectF);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w0() {
        PorterDuffColorFilter porterDuffColorFilter = this.y;
        PorterDuffColorFilter porterDuffColorFilter2 = this.z;
        c cVar = this.g;
        this.y = q(cVar.g, cVar.h, this.t, true);
        c cVar2 = this.g;
        this.z = q(cVar2.f, cVar2.h, this.u, false);
        c cVar3 = this.g;
        if (cVar3.u) {
            this.v.d(cVar3.g.getColorForState(getState(), 0));
        }
        return (u43.a(porterDuffColorFilter, this.y) && u43.a(porterDuffColorFilter2, this.z)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x(Canvas canvas) {
        v(canvas, this.u, this.o, this.E, this.I, z());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x0() {
        float fO = O();
        this.g.r = (int) Math.ceil(0.75f * fO);
        this.g.s = (int) Math.ceil(fO * 0.25f);
        w0();
        if (r0()) {
            invalidateSelf();
        } else {
            T();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RectF y() {
        this.p.set(getBounds());
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final RectF z() {
        this.q.set(y());
        float fK = K();
        this.q.inset(fK, fK);
        return this.q;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends Drawable.ConstantState {
        public x44 a;
        public fr0 b;
        public ColorFilter c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(c cVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.l = cVar.l;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            l62 l62Var = new l62(this);
            l62Var.k = true;
            l62Var.l = true;
            return l62Var;
        }

        public c(x44 x44Var, fr0 fr0Var) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = x44Var;
            this.b = fr0Var;
        }
    }

    public l62(Context context, AttributeSet attributeSet, int i, int i2) {
        this(y44.i(context, attributeSet, i, i2).m());
    }

    public l62(y44 y44Var) {
        this(new c(y44Var, null));
    }

    public l62(x44 x44Var) {
        this(new c(x44Var, null));
    }

    public l62() {
        this(new y44());
    }
}

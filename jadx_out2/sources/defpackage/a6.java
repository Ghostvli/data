package defpackage;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class a6 extends o {
    public Canvas e;
    public int f;
    public int g;
    public float h;
    public Camera a = new Camera();
    public Matrix b = new Matrix();
    public final a c = new a();
    public ah d = new g74();
    public float i = 1.0f;
    public int j = 160;
    public float k = 1.0f;
    public int l = 0;
    public boolean m = true;
    public int n = 2048;
    public int o = 2048;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public float a;
        public final TextPaint c;
        public final TextPaint d;
        public Paint e;
        public Paint f;
        public Paint g;
        public boolean v;
        public final Map b = new HashMap(10);
        public int h = 4;
        public float i = 4.0f;
        public float j = 3.5f;
        public float k = 1.0f;
        public float l = 1.0f;
        public int m = 204;
        public boolean n = false;
        public boolean o = false;
        public boolean p = true;
        public boolean q = true;
        public boolean r = false;
        public boolean s = false;
        public boolean t = true;
        public boolean u = true;
        public int w = k5.a;
        public float x = 1.0f;
        public boolean y = false;
        public int z = 0;
        public int A = 0;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            TextPaint textPaint = new TextPaint();
            this.c = textPaint;
            textPaint.setStrokeWidth(this.j);
            this.d = new TextPaint(textPaint);
            this.e = new Paint();
            Paint paint = new Paint();
            this.f = paint;
            paint.setStrokeWidth(this.h);
            Paint paint2 = this.f;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.g = paint3;
            paint3.setStyle(style);
            this.g.setStrokeWidth(4.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(ih ihVar, Paint paint, boolean z) {
            if (this.v) {
                if (z) {
                    paint.setStyle(this.s ? Paint.Style.FILL : Paint.Style.FILL_AND_STROKE);
                    paint.setColor(ihVar.i & 16777215);
                    paint.setAlpha(this.s ? (int) (this.m * (this.w / k5.a)) : this.w);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(ihVar.f & 16777215);
                    paint.setAlpha(this.w);
                }
            } else if (z) {
                paint.setStyle(this.s ? Paint.Style.FILL : Paint.Style.FILL_AND_STROKE);
                paint.setColor(ihVar.i & 16777215);
                paint.setAlpha(this.s ? this.m : k5.a);
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(ihVar.f & 16777215);
                paint.setAlpha(k5.a);
            }
            if (ihVar.m() == 7) {
                paint.setAlpha(ihVar.c());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g(ih ihVar, Paint paint) {
            if (this.y) {
                Float fValueOf = (Float) this.b.get(Float.valueOf(ihVar.k));
                if (fValueOf == null || this.a != this.x) {
                    float f = this.x;
                    this.a = f;
                    fValueOf = Float.valueOf(ihVar.k * f);
                    this.b.put(Float.valueOf(ihVar.k), fValueOf);
                }
                paint.setTextSize(fValueOf.floatValue());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h() {
            this.b.clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(boolean z) {
            this.q = this.p;
            this.o = this.n;
            this.s = this.r;
            this.u = this.t;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Paint j(ih ihVar) {
            this.g.setColor(ihVar.l);
            return this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public TextPaint k(ih ihVar, boolean z) {
            TextPaint textPaint;
            int i;
            if (z) {
                textPaint = this.c;
            } else {
                textPaint = this.d;
                textPaint.set(this.c);
            }
            textPaint.setTextSize(ihVar.k);
            g(ihVar, textPaint);
            if (this.o) {
                float f = this.i;
                if (f <= 0.0f || (i = ihVar.i) == 0) {
                    textPaint.clearShadowLayer();
                } else {
                    textPaint.setShadowLayer(f, 0.0f, 0.0f, i);
                }
            }
            textPaint.setAntiAlias(this.u);
            return textPaint;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float l() {
            boolean z = this.o;
            if (z && this.q) {
                return Math.max(this.i, this.j);
            }
            if (z) {
                return this.i;
            }
            if (this.q) {
                return this.j;
            }
            return 0.0f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Paint m(ih ihVar) {
            this.f.setColor(ihVar.j);
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean n(ih ihVar) {
            return (this.q || this.s) && this.j > 0.0f && ihVar.i != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void o(float f, float f2, int i) {
            if (this.k == f && this.l == f2 && this.m == i) {
                return;
            }
            if (f <= 1.0f) {
                f = 1.0f;
            }
            this.k = f;
            if (f2 <= 1.0f) {
                f2 = 1.0f;
            }
            this.l = f2;
            if (i < 0) {
                i = 0;
            } else if (i > 255) {
                i = 255;
            }
            this.m = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void p(float f) {
            this.y = f != 1.0f;
            this.x = f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q(float f) {
            this.i = f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r(float f) {
            this.c.setStrokeWidth(f);
            this.j = f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s(int i) {
            this.v = i != k5.a;
            this.w = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int E(Canvas canvas) {
        return canvas.getMaximumBitmapHeight();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int F(Canvas canvas) {
        return canvas.getMaximumBitmapWidth();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o
    public void A(int i) {
        this.c.s(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(ih ihVar, TextPaint textPaint, boolean z) {
        this.d.d(ihVar, textPaint, z);
        L(ihVar, ihVar.o, ihVar.p);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Lih;Ljava/lang/Object;FFZ)V */
    @Override // defpackage.o
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public synchronized void v(ih ihVar, Canvas canvas, float f, float f2, boolean z) {
        ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.c(ihVar, canvas, f, f2, z, this.c);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x()Ljava/lang/Object; */
    @Override // defpackage.o
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public Canvas x() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized TextPaint G(ih ihVar, boolean z) {
        return this.c.k(ihVar, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float H() {
        return this.c.l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I(Paint paint) {
        int alpha = paint.getAlpha();
        int i = k5.a;
        if (alpha != i) {
            paint.setAlpha(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J(Canvas canvas) {
        canvas.restore();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int K(ih ihVar, Canvas canvas, float f, float f2) {
        this.a.save();
        float f3 = this.h;
        if (f3 != 0.0f) {
            this.a.setLocation(0.0f, 0.0f, f3);
        }
        this.a.rotateY(-ihVar.h);
        this.a.rotateZ(-ihVar.g);
        this.a.getMatrix(this.b);
        this.b.preTranslate(-f, -f2);
        this.b.postTranslate(f, f2);
        this.a.restore();
        int iSave = canvas.save();
        canvas.concat(this.b);
        return iSave;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(ih ihVar, float f, float f2) {
        int i = ihVar.m;
        float f3 = f + (i * 2);
        float f4 = f2 + (i * 2);
        if (ihVar.l != 0) {
            f3 += 8.0f;
            f4 += 8.0f;
        }
        ihVar.o = f3 + H();
        ihVar.p = f4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: y(Ljava/lang/Object;)V */
    @Override // defpackage.o
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void y(Canvas canvas) {
        Q(canvas);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(float f) {
        this.c.r(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(float f, float f2, int i) {
        this.c.o(f, f2, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(float f) {
        this.c.q(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q(Canvas canvas) {
        this.e = canvas;
        if (canvas != null) {
            this.f = canvas.getWidth();
            this.g = canvas.getHeight();
            if (this.m) {
                this.n = F(canvas);
                this.o = E(canvas);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int a() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int b() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public float c() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void d(ih ihVar, boolean z) {
        ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.e(ihVar, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void e(float f) {
        float fMax = Math.max(f, b() / 682.0f) * 25.0f;
        this.l = (int) fMax;
        if (f > 1.0f) {
            this.l = (int) (fMax * f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void f(int i) {
        this.c.z = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int g() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void h(int i, float[] fArr) {
        if (i != -1) {
            if (i == 0) {
                a aVar = this.c;
                aVar.n = false;
                aVar.p = false;
                aVar.r = false;
                return;
            }
            if (i == 1) {
                a aVar2 = this.c;
                aVar2.n = true;
                aVar2.p = false;
                aVar2.r = false;
                P(fArr[0]);
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                a aVar3 = this.c;
                aVar3.n = false;
                aVar3.p = false;
                aVar3.r = true;
                O(fArr[0], fArr[1], (int) fArr[2]);
                return;
            }
        }
        a aVar4 = this.c;
        aVar4.n = false;
        aVar4.p = true;
        aVar4.r = false;
        N(fArr[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void i(float f, int i, float f2) {
        this.i = f;
        this.j = i;
        this.k = f2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public boolean isHardwareAccelerated() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int j() {
        return this.c.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int k() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void l(boolean z) {
        this.m = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int m() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public float n() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int o() {
        return this.c.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int p() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void q(ih ihVar, boolean z) {
        TextPaint textPaintG = G(ihVar, z);
        if (this.c.q) {
            this.c.f(ihVar, textPaintG, true);
        }
        B(ihVar, textPaintG, z);
        if (this.c.q) {
            this.c.f(ihVar, textPaintG, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public int r(ih ihVar) {
        boolean z;
        a6 a6Var;
        boolean z2;
        float fL = ihVar.l();
        float fG = ihVar.g();
        if (this.e == null) {
            return 0;
        }
        int i = 1;
        Paint paint = null;
        if (ihVar.m() != 7) {
            z = false;
        } else {
            if (ihVar.c() == k5.b) {
                return 0;
            }
            if (ihVar.g == 0.0f && ihVar.h == 0.0f) {
                z2 = false;
            } else {
                K(ihVar, this.e, fG, fL);
                z2 = true;
            }
            if (ihVar.c() != k5.a) {
                paint = this.c.e;
                paint.setAlpha(ihVar.c());
            }
            z = z2;
        }
        if (paint != null && paint.getAlpha() == k5.b) {
            return 0;
        }
        if (this.d.b(ihVar, this.e, fG, fL, paint, this.c.c)) {
            a6Var = this;
        } else {
            a aVar = this.c;
            if (paint != null) {
                aVar.c.setAlpha(paint.getAlpha());
                this.c.d.setAlpha(paint.getAlpha());
            } else {
                I(aVar.c);
            }
            a6Var = this;
            a6Var.v(ihVar, this.e, fG, fL, false);
            i = 2;
        }
        if (z) {
            a6Var.J(a6Var.e);
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void s(ih ihVar) {
        ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.f(ihVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fh1
    public void t(int i, int i2) {
        this.f = i;
        this.g = i2;
        this.h = (float) (((double) (i / 2.0f)) / Math.tan(0.4799655442984406d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o
    public void u() {
        this.d.a();
        this.c.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o
    public ah w() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o
    public void z(float f) {
        this.c.p(f);
    }
}

package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import defpackage.no0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class eu extends no0 {
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public float m;
    public boolean n;
    public float o;
    public final RectF p;
    public final Pair q;

    public eu(ju juVar) {
        super(juVar);
        this.p = new RectF();
        this.q = new Pair(new no0.b(), new no0.b());
    }

    @Override // defpackage.no0
    public void a(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        float fWidth = rect.width() / f();
        float fHeight = rect.height() / e();
        oi oiVar = this.a;
        float f2 = (((ju) oiVar).r / 2.0f) + ((ju) oiVar).s;
        canvas.translate((f2 * fWidth) + rect.left, (f2 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((ju) this.a).t != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        oi oiVar2 = this.a;
        this.f = ((ju) oiVar2).a * f;
        this.g = Math.min(((ju) oiVar2).a / 2, ((ju) oiVar2).a()) * f;
        oi oiVar3 = this.a;
        this.h = ((ju) oiVar3).l * f;
        float f4 = (((ju) oiVar3).r - ((ju) oiVar3).a) / 2.0f;
        this.i = f4;
        if (z || z2) {
            float f5 = ((1.0f - f) * ((ju) oiVar3).a) / 2.0f;
            if ((z && ((ju) oiVar3).g == 2) || (z2 && ((ju) oiVar3).h == 1)) {
                this.i = f4 + f5;
            } else if ((z && ((ju) oiVar3).g == 1) || (z2 && ((ju) oiVar3).h == 2)) {
                this.i = f4 - f5;
            }
        }
        if (z2 && ((ju) oiVar3).h == 3) {
            this.o = f;
        } else {
            this.o = 1.0f;
        }
    }

    @Override // defpackage.no0
    public void b(Canvas canvas, Paint paint, int i, int i2) {
    }

    @Override // defpackage.no0
    public void c(Canvas canvas, Paint paint, no0.a aVar, int i) {
        int iA = h62.a(aVar.c, i);
        canvas.save();
        canvas.rotate(aVar.g);
        this.n = aVar.h;
        float f = aVar.a;
        float f2 = aVar.b;
        int i2 = aVar.d;
        m(canvas, paint, f, f2, iA, i2, i2, aVar.e, aVar.f, true);
        canvas.restore();
    }

    @Override // defpackage.no0
    public void d(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        int iA = h62.a(i, i2);
        this.n = false;
        m(canvas, paint, f, f2, iA, i3, i3, 0.0f, 0.0f, false);
    }

    @Override // defpackage.no0
    public int e() {
        return p();
    }

    @Override // defpackage.no0
    public int f() {
        return p();
    }

    @Override // defpackage.no0
    public void g() {
        this.b.rewind();
        this.b.moveTo(1.0f, 0.0f);
        for (int i = 0; i < 2; i++) {
            this.b.cubicTo(1.0f, 0.5522848f, 0.5522848f, 1.0f, 0.0f, 1.0f);
            this.b.cubicTo(-0.5522848f, 1.0f, -1.0f, 0.5522848f, -1.0f, 0.0f);
            this.b.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.b.cubicTo(0.5522848f, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.e.reset();
        Matrix matrix = this.e;
        float f = this.i;
        matrix.setScale(f, f);
        this.b.transform(this.e);
        if (((ju) this.a).b(this.n)) {
            this.d.setPath(this.b, false);
            l(this.d, this.b, this.k);
        }
        this.d.setPath(this.b, false);
    }

    public final void j(Path path, no0.b bVar, no0.b bVar2) {
        float f = (this.j / 2.0f) * 0.48f;
        no0.b bVar3 = new no0.b(this, bVar);
        no0.b bVar4 = new no0.b(this, bVar2);
        bVar3.b(f);
        bVar4.b(-f);
        float[] fArr = bVar3.a;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float[] fArr2 = bVar4.a;
        float f4 = fArr2[0];
        float f5 = fArr2[1];
        float[] fArr3 = bVar2.a;
        path.cubicTo(f2, f3, f4, f5, fArr3[0], fArr3[1]);
    }

    public final void k(PathMeasure pathMeasure, Path path, Pair pair, float f, float f2, float f3, float f4) {
        float f5 = this.h * f3;
        boolean z = this.n;
        ju juVar = (ju) this.a;
        int i = z ? juVar.j : juVar.k;
        float f6 = this.i;
        if (f6 != this.m || (pathMeasure == this.d && (f5 != this.k || i != this.l))) {
            this.k = f5;
            this.l = i;
            this.m = f6;
            g();
        }
        path.rewind();
        float f7 = 0.0f;
        float fA = r62.a(f2, 0.0f, 1.0f);
        if (((ju) this.a).b(this.n)) {
            float f8 = f4 / ((float) ((((double) this.i) * 6.283185307179586d) / ((double) this.j)));
            f += f8;
            f7 = 0.0f - (f8 * 360.0f);
        }
        float f9 = f % 1.0f;
        float length = (pathMeasure.getLength() * f9) / 2.0f;
        float length2 = ((f9 + fA) * pathMeasure.getLength()) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        no0.b bVar = (no0.b) pair.first;
        bVar.c();
        pathMeasure.getPosTan(length, bVar.a, bVar.b);
        no0.b bVar2 = (no0.b) pair.second;
        bVar2.c();
        pathMeasure.getPosTan(length2, bVar2.a, bVar2.b);
        this.e.reset();
        this.e.setRotate(f7);
        bVar.d(f7);
        bVar2.d(f7);
        path.transform(this.e);
    }

    public final void l(PathMeasure pathMeasure, Path path, float f) {
        path.rewind();
        float length = pathMeasure.getLength();
        boolean z = this.n;
        ju juVar = (ju) this.a;
        int iMax = Math.max(3, (int) ((length / (z ? juVar.j : juVar.k)) / 2.0f)) * 2;
        this.j = length / iMax;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iMax; i++) {
            no0.b bVar = new no0.b();
            float f2 = i;
            pathMeasure.getPosTan(this.j * f2, bVar.a, bVar.b);
            no0.b bVar2 = new no0.b();
            float f3 = this.j;
            pathMeasure.getPosTan((f2 * f3) + (f3 / 2.0f), bVar2.a, bVar2.b);
            arrayList.add(bVar);
            bVar2.a(f * 2.0f);
            arrayList.add(bVar2);
        }
        arrayList.add((no0.b) arrayList.get(0));
        no0.b bVar3 = (no0.b) arrayList.get(0);
        float[] fArr = bVar3.a;
        int i2 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i2 < arrayList.size()) {
            no0.b bVar4 = (no0.b) arrayList.get(i2);
            j(path, bVar3, bVar4);
            i2++;
            bVar3 = bVar4;
        }
    }

    public final void m(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3, float f3, float f4, boolean z) {
        float f5 = f2 >= f ? f2 - f : (f2 + 1.0f) - f;
        float f6 = f % 1.0f;
        if (f6 < 0.0f) {
            f6 += 1.0f;
        }
        if (this.o < 1.0f) {
            float f7 = f6 + f5;
            if (f7 > 1.0f) {
                m(canvas, paint, f6, 1.0f, i, i2, 0, f3, f4, z);
                m(canvas, paint, 1.0f, f7, i, 0, i3, f3, f4, z);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.g / this.i);
        float f8 = f5 - 0.99f;
        if (f8 >= 0.0f) {
            float f9 = ((f8 * degrees) / 180.0f) / 0.01f;
            f5 += f9;
            if (!z) {
                f6 -= f9 / 2.0f;
            }
        }
        float fB = q62.b(1.0f - this.o, 1.0f, f6);
        float fB2 = q62.b(0.0f, this.o, f5);
        float degrees2 = (float) Math.toDegrees(i2 / this.i);
        float degrees3 = ((fB2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i3 / this.i));
        float f10 = (fB * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        boolean z2 = ((ju) this.a).b(this.n) && z && f3 > 0.0f;
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.f);
        float f11 = this.g * 2.0f;
        float f12 = degrees * 2.0f;
        if (degrees3 < f12) {
            float f13 = degrees3 / f12;
            float f14 = f10 + (degrees * f13);
            no0.b bVar = new no0.b();
            if (z2) {
                float length = ((f14 / 360.0f) * this.d.getLength()) / 2.0f;
                float f15 = this.h * f3;
                float f16 = this.i;
                if (f16 != this.m || f15 != this.k) {
                    this.k = f15;
                    this.m = f16;
                    g();
                }
                this.d.getPosTan(length, bVar.a, bVar.b);
            } else {
                bVar.d(f14 + 90.0f);
                bVar.a(-this.i);
            }
            paint.setStyle(Paint.Style.FILL);
            o(canvas, paint, bVar, f11, this.f, f13);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(((ju) this.a).g() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f17 = f10 + degrees;
        float f18 = degrees3 - f12;
        ((no0.b) this.q.first).c();
        ((no0.b) this.q.second).c();
        if (z2) {
            k(this.d, this.c, this.q, f17 / 360.0f, f18 / 360.0f, f3, f4);
            canvas.drawPath(this.c, paint);
        } else {
            ((no0.b) this.q.first).d(f17 + 90.0f);
            ((no0.b) this.q.first).a(-this.i);
            ((no0.b) this.q.second).d(f17 + f18 + 90.0f);
            ((no0.b) this.q.second).a(-this.i);
            RectF rectF = this.p;
            float f19 = this.i;
            rectF.set(-f19, -f19, f19, f19);
            canvas.drawArc(this.p, f17, f18, false, paint);
        }
        if (((ju) this.a).g() || this.g <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        n(canvas, paint, (no0.b) this.q.first, f11, this.f);
        n(canvas, paint, (no0.b) this.q.second, f11, this.f);
    }

    public final void n(Canvas canvas, Paint paint, no0.b bVar, float f, float f2) {
        o(canvas, paint, bVar, f, f2, 1.0f);
    }

    public final void o(Canvas canvas, Paint paint, no0.b bVar, float f, float f2, float f3) {
        float fMin = Math.min(f2, this.f);
        float f4 = f / 2.0f;
        float fMin2 = Math.min(f4, (this.g * fMin) / this.f);
        RectF rectF = new RectF((-f) / 2.0f, (-fMin) / 2.0f, f4, fMin / 2.0f);
        canvas.save();
        float[] fArr = bVar.a;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(i(bVar.b));
        canvas.scale(f3, f3);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    public final int p() {
        oi oiVar = this.a;
        return ((ju) oiVar).r + (((ju) oiVar).s * 2);
    }
}

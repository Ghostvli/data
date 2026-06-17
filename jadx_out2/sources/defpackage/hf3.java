package defpackage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import defpackage.if3;
import defpackage.p54;
import defpackage.zh;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class hf3 implements f93, zh.b, br1 {
    public final String e;
    public final g22 f;
    public final if3.a g;
    public final boolean h;
    public final boolean i;
    public final zh j;
    public final zh k;
    public final zh l;
    public final zh m;
    public final zh n;
    public final zh o;
    public final zh p;
    public boolean r;
    public final Path a = new Path();
    public final Path b = new Path();
    public final PathMeasure c = new PathMeasure();
    public final float[] d = new float[2];
    public final uy q = new uy();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[if3.a.values().length];
            a = iArr;
            try {
                iArr[if3.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[if3.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hf3(g22 g22Var, bi biVar, if3 if3Var) {
        this.f = g22Var;
        this.e = if3Var.d();
        if3.a aVarJ = if3Var.j();
        this.g = aVarJ;
        this.h = if3Var.k();
        this.i = if3Var.l();
        t21 t21VarA = if3Var.g().a();
        this.j = t21VarA;
        zh zhVarA = if3Var.h().a();
        this.k = zhVarA;
        t21 t21VarA2 = if3Var.i().a();
        this.l = t21VarA2;
        t21 t21VarA3 = if3Var.e().a();
        this.n = t21VarA3;
        t21 t21VarA4 = if3Var.f().a();
        this.p = t21VarA4;
        if3.a aVar = if3.a.STAR;
        if (aVarJ == aVar) {
            this.m = if3Var.b().a();
            this.o = if3Var.c().a();
        } else {
            this.m = null;
            this.o = null;
        }
        biVar.j(t21VarA);
        biVar.j(zhVarA);
        biVar.j(t21VarA2);
        biVar.j(t21VarA3);
        biVar.j(t21VarA4);
        if (aVarJ == aVar) {
            biVar.j(this.m);
            biVar.j(this.o);
        }
        t21VarA.a(this);
        zhVarA.a(this);
        t21VarA2.a(this);
        t21VarA3.a(this);
        t21VarA4.a(this);
        if (aVarJ == aVar) {
            this.m.a(this);
            this.o.a(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void k() {
        this.r = false;
        this.f.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            k20 k20Var = (k20) list.get(i);
            if (k20Var instanceof nt4) {
                nt4 nt4Var = (nt4) k20Var;
                if (nt4Var.k() == p54.a.SIMULTANEOUSLY) {
                    this.q.a(nt4Var);
                    nt4Var.f(this);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        double d;
        float f;
        float f2;
        float f3;
        int iFloor = (int) Math.floor(((Float) this.j.h()).floatValue());
        double radians = Math.toRadians((this.l == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d2 = iFloor;
        float fFloatValue = ((Float) this.p.h()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) this.n.h()).floatValue();
        double d3 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d3);
        float fSin = (float) (Math.sin(radians) * d3);
        this.a.moveTo(fCos, fSin);
        double d4 = (float) (6.283185307179586d / d2);
        double dCeil = Math.ceil(d2);
        double d5 = radians + d4;
        int i = 0;
        while (true) {
            double d6 = i;
            if (d6 >= dCeil) {
                PointF pointF = (PointF) this.k.h();
                this.a.offset(pointF.x, pointF.y);
                this.a.close();
                return;
            }
            float fCos2 = (float) (d3 * Math.cos(d5));
            float fSin2 = (float) (Math.sin(d5) * d3);
            if (fFloatValue != 0.0f) {
                d = dCeil;
                f = fFloatValue;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f4 = fFloatValue2 * f * 0.25f;
                float f5 = f4 * fCos3;
                float f6 = f4 * fSin3;
                float fCos4 = ((float) Math.cos(dAtan22)) * f4;
                float fSin4 = f4 * ((float) Math.sin(dAtan22));
                if (d6 == d - 1.0d) {
                    this.b.reset();
                    this.b.moveTo(fCos, fSin);
                    float f7 = fCos - f5;
                    float f8 = fSin - f6;
                    float f9 = fCos2 + fCos4;
                    float f10 = fSin2 + fSin4;
                    f2 = fCos2;
                    f3 = fSin2;
                    this.b.cubicTo(f7, f8, f9, f10, f2, f3);
                    this.c.setPath(this.b, false);
                    PathMeasure pathMeasure = this.c;
                    pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, this.d, null);
                    Path path = this.a;
                    float[] fArr = this.d;
                    path.cubicTo(f7, f8, f9, f10, fArr[0], fArr[1]);
                } else {
                    f2 = fCos2;
                    f3 = fSin2;
                    this.a.cubicTo(fCos - f5, fSin - f6, f2 + fCos4, f3 + fSin4, f2, f3);
                }
                fCos = f2;
                fSin = f3;
            } else {
                fCos = fCos2;
                fSin = fSin2;
                d = dCeil;
                f = fFloatValue;
                if (d6 == d - 1.0d) {
                    i++;
                    dCeil = d;
                    fFloatValue = f;
                } else {
                    this.a.lineTo(fCos, fSin);
                }
            }
            d5 += d4;
            i++;
            dCeil = d;
            fFloatValue = f;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        zh zhVar;
        zh zhVar2;
        if (obj == q22.z) {
            this.j.o(y22Var);
            return;
        }
        if (obj == q22.A) {
            this.l.o(y22Var);
            return;
        }
        if (obj == q22.n) {
            this.k.o(y22Var);
            return;
        }
        if (obj == q22.B && (zhVar2 = this.m) != null) {
            zhVar2.o(y22Var);
            return;
        }
        if (obj == q22.C) {
            this.n.o(y22Var);
            return;
        }
        if (obj == q22.D && (zhVar = this.o) != null) {
            zhVar.o(y22Var);
        } else if (obj == q22.E) {
            this.p.o(y22Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public String getName() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f93
    public Path getPath() {
        boolean z = this.r;
        Path path = this.a;
        if (z) {
            return path;
        }
        path.reset();
        if (this.h) {
            this.r = true;
            return this.a;
        }
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            j();
        } else if (i == 2) {
            f();
        }
        this.a.close();
        this.q.b(this.a);
        this.r = true;
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        float f;
        float f2;
        int i;
        float fCos;
        float fSin;
        float f3;
        float f4;
        double d;
        float f5;
        int i2;
        float f6;
        double d2;
        float f7;
        float f8;
        double d3;
        float f9;
        float f10;
        float fFloatValue = ((Float) this.j.h()).floatValue();
        double radians = Math.toRadians((this.l == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f11 = (float) (6.283185307179586d / d4);
        if (this.i) {
            f11 *= -1.0f;
        }
        float f12 = f11 / 2.0f;
        float f13 = fFloatValue - ((int) fFloatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (double) ((1.0f - f13) * f12);
        }
        float fFloatValue2 = ((Float) this.n.h()).floatValue();
        float fFloatValue3 = ((Float) this.m.h()).floatValue();
        zh zhVar = this.o;
        float fFloatValue4 = zhVar != null ? ((Float) zhVar.h()).floatValue() / 100.0f : 0.0f;
        zh zhVar2 = this.p;
        float fFloatValue5 = zhVar2 != null ? ((Float) zhVar2.h()).floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f5 = ((fFloatValue2 - fFloatValue3) * f13) + fFloatValue3;
            f2 = 0.0f;
            i = i3;
            double d5 = f5;
            f = 2.0f;
            float fCos2 = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.a.moveTo(fCos2, fSin);
            d = radians + ((double) ((f11 * f13) / 2.0f));
            f3 = f13;
            fCos = fCos2;
            f4 = f12;
        } else {
            f = 2.0f;
            f2 = 0.0f;
            i = i3;
            double d6 = fFloatValue2;
            fCos = (float) (Math.cos(radians) * d6);
            fSin = (float) (d6 * Math.sin(radians));
            this.a.moveTo(fCos, fSin);
            f3 = f13;
            f4 = f12;
            d = radians + ((double) f4);
            f5 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i4 = 0;
        boolean z = false;
        double d7 = d;
        float f14 = fSin;
        float f15 = fCos;
        double d8 = d7;
        while (true) {
            double d9 = i4;
            if (d9 >= dCeil) {
                PointF pointF = (PointF) this.k.h();
                this.a.offset(pointF.x, pointF.y);
                this.a.close();
                return;
            }
            float f16 = z ? fFloatValue2 : fFloatValue3;
            if (f5 == f2 || d9 != dCeil - 2.0d) {
                i2 = i4;
                f6 = f4;
            } else {
                i2 = i4;
                f6 = (f11 * f3) / f;
            }
            if (f5 == f2 || d9 != dCeil - 1.0d) {
                d2 = d9;
                f7 = f16;
            } else {
                d2 = d9;
                f7 = f5;
            }
            double d10 = f7;
            float fCos3 = (float) (d10 * Math.cos(d8));
            float f17 = f11;
            float fSin2 = (float) (d10 * Math.sin(d8));
            if (fFloatValue4 == f2 && fFloatValue5 == f2) {
                this.a.lineTo(fCos3, fSin2);
                f10 = fCos3;
                f9 = fSin2;
                f8 = f4;
                d3 = d8;
            } else {
                f8 = f4;
                d3 = d8;
                double dAtan2 = (float) (Math.atan2(f14, f15) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                float f18 = f15;
                float f19 = f14;
                f9 = fSin2;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f20 = z ? fFloatValue4 : fFloatValue5;
                float f21 = z ? fFloatValue5 : fFloatValue4;
                float f22 = (z ? fFloatValue3 : fFloatValue2) * f20 * 0.47829f;
                float f23 = fCos4 * f22;
                float f24 = f22 * fSin3;
                float f25 = (z ? fFloatValue2 : fFloatValue3) * f21 * 0.47829f;
                float f26 = fCos5 * f25;
                float f27 = f25 * fSin4;
                if (i != 0) {
                    if (i2 == 0) {
                        f23 *= f3;
                        f24 *= f3;
                    } else if (d2 == dCeil - 1.0d) {
                        f26 *= f3;
                        f27 *= f3;
                    }
                }
                f10 = fCos3;
                this.a.cubicTo(f18 - f23, f19 - f24, fCos3 + f26, f9 + f27, f10, f9);
            }
            d8 = d3 + ((double) f6);
            z = !z;
            i4 = i2 + 1;
            f4 = f8;
            f15 = f10;
            f14 = f9;
            f11 = f17;
        }
    }
}

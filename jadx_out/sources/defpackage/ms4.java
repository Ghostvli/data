package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import defpackage.zh;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ms4 {
    public final Matrix b;
    public final Matrix c;
    public final Matrix d;
    public final float[] e;
    public zh l;
    public zh m;
    public zh n;
    public zh o;
    public zh p;
    public t21 q;
    public t21 r;
    public t21 s;
    public t21 t;
    public t21 u;
    public zh v;
    public zh w;
    public final boolean x;
    public final Matrix a = new Matrix();
    public float f = Float.NaN;
    public float g = Float.NaN;
    public float h = Float.NaN;
    public float i = 1.0f;
    public float j = 1.0f;
    public boolean k = true;

    public ms4(x6 x6Var) {
        this.l = x6Var.c() == null ? null : x6Var.c().a();
        this.m = x6Var.f() == null ? null : x6Var.f().a();
        this.n = x6Var.k() == null ? null : x6Var.k().a();
        this.o = x6Var.g() == null ? null : x6Var.g().a();
        this.q = x6Var.l() == null ? null : x6Var.l().a();
        this.x = x6Var.o();
        this.s = x6Var.h() == null ? null : x6Var.h().a();
        this.t = x6Var.i() == null ? null : x6Var.i().a();
        this.u = x6Var.j() == null ? null : x6Var.j().a();
        if (this.q != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.r = x6Var.m() == null ? null : x6Var.m().a();
        if (x6Var.e() != null) {
            this.p = x6Var.e().a();
        }
        if (x6Var.n() != null) {
            this.v = x6Var.n().a();
        } else {
            this.v = null;
        }
        if (x6Var.d() != null) {
            this.w = x6Var.d().a();
        } else {
            this.w = null;
        }
    }

    public void d(bi biVar) {
        biVar.j(this.p);
        biVar.j(this.v);
        biVar.j(this.w);
        biVar.j(this.l);
        biVar.j(this.m);
        biVar.j(this.n);
        biVar.j(this.o);
        biVar.j(this.q);
        biVar.j(this.r);
        biVar.j(this.s);
        biVar.j(this.t);
        biVar.j(this.u);
    }

    public void e(zh.b bVar) {
        zh zhVar = this.p;
        if (zhVar != null) {
            zhVar.a(bVar);
        }
        zh zhVar2 = this.v;
        if (zhVar2 != null) {
            zhVar2.a(bVar);
        }
        zh zhVar3 = this.w;
        if (zhVar3 != null) {
            zhVar3.a(bVar);
        }
        zh zhVar4 = this.l;
        if (zhVar4 != null) {
            zhVar4.a(bVar);
        }
        zh zhVar5 = this.m;
        if (zhVar5 != null) {
            zhVar5.a(bVar);
        }
        zh zhVar6 = this.n;
        if (zhVar6 != null) {
            zhVar6.a(bVar);
        }
        zh zhVar7 = this.o;
        if (zhVar7 != null) {
            zhVar7.a(bVar);
        }
        t21 t21Var = this.q;
        if (t21Var != null) {
            t21Var.a(bVar);
        }
        t21 t21Var2 = this.r;
        if (t21Var2 != null) {
            t21Var2.a(bVar);
        }
        t21 t21Var3 = this.s;
        if (t21Var3 != null) {
            t21Var3.a(bVar);
            this.s.a(new zh.b() { // from class: js4
                @Override // zh.b
                public final void a() {
                    this.a.k = true;
                }
            });
        }
        t21 t21Var4 = this.t;
        if (t21Var4 != null) {
            t21Var4.a(bVar);
            this.t.a(new zh.b() { // from class: ks4
                @Override // zh.b
                public final void a() {
                    this.a.k = true;
                }
            });
        }
        t21 t21Var5 = this.u;
        if (t21Var5 != null) {
            t21Var5.a(bVar);
            this.u.a(new zh.b() { // from class: ls4
                @Override // zh.b
                public final void a() {
                    this.a.k = true;
                }
            });
        }
    }

    public boolean f(Object obj, y22 y22Var) {
        Float fValueOf = Float.valueOf(100.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (obj == q22.f) {
            zh zhVar = this.l;
            if (zhVar == null) {
                this.l = new bz4(y22Var, new PointF());
                return true;
            }
            zhVar.o(y22Var);
            return true;
        }
        if (obj == q22.g) {
            zh zhVar2 = this.m;
            if (zhVar2 == null) {
                this.m = new bz4(y22Var, new PointF());
                return true;
            }
            zhVar2.o(y22Var);
            return true;
        }
        if (obj == q22.h) {
            zh zhVar3 = this.m;
            if (zhVar3 instanceof zc4) {
                ((zc4) zhVar3).t(y22Var);
                return true;
            }
        }
        if (obj == q22.i) {
            zh zhVar4 = this.m;
            if (zhVar4 instanceof zc4) {
                ((zc4) zhVar4).u(y22Var);
                return true;
            }
        }
        if (obj == q22.o) {
            zh zhVar5 = this.n;
            if (zhVar5 == null) {
                this.n = new bz4(y22Var, new by3());
                return true;
            }
            zhVar5.o(y22Var);
            return true;
        }
        if (obj == q22.p) {
            zh zhVar6 = this.o;
            if (zhVar6 == null) {
                this.o = new bz4(y22Var, fValueOf2);
                return true;
            }
            zhVar6.o(y22Var);
            return true;
        }
        if (obj == q22.c) {
            zh zhVar7 = this.p;
            if (zhVar7 == null) {
                this.p = new bz4(y22Var, 100);
                return true;
            }
            zhVar7.o(y22Var);
            return true;
        }
        if (obj == q22.F) {
            zh zhVar8 = this.v;
            if (zhVar8 == null) {
                this.v = new bz4(y22Var, fValueOf);
                return true;
            }
            zhVar8.o(y22Var);
            return true;
        }
        if (obj == q22.G) {
            zh zhVar9 = this.w;
            if (zhVar9 == null) {
                this.w = new bz4(y22Var, fValueOf);
                return true;
            }
            zhVar9.o(y22Var);
            return true;
        }
        if (obj == q22.t) {
            if (this.q == null) {
                this.q = new t21(Collections.singletonList(new dr1(fValueOf2)));
            }
            this.q.o(y22Var);
            return true;
        }
        if (obj == q22.u) {
            if (this.r == null) {
                this.r = new t21(Collections.singletonList(new dr1(fValueOf2)));
            }
            this.r.o(y22Var);
            return true;
        }
        if (obj == q22.q) {
            if (this.s == null) {
                this.s = new t21(Collections.singletonList(new dr1(fValueOf2)));
            }
            this.s.o(y22Var);
            return true;
        }
        if (obj == q22.r) {
            if (this.t == null) {
                this.t = new t21(Collections.singletonList(new dr1(fValueOf2)));
            }
            this.t.o(y22Var);
            return true;
        }
        if (obj != q22.s) {
            return false;
        }
        if (this.u == null) {
            this.u = new t21(Collections.singletonList(new dr1(fValueOf2)));
        }
        this.u.o(y22Var);
        return true;
    }

    public final void g() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public zh h() {
        return this.w;
    }

    public Matrix i() {
        t21 t21Var;
        t21 t21Var2;
        PointF pointF;
        by3 by3Var;
        PointF pointF2;
        this.a.reset();
        t21 t21Var3 = this.s;
        if ((t21Var3 != null && t21Var3.r() != 0.0f) || (((t21Var = this.t) != null && t21Var.r() != 0.0f) || ((t21Var2 = this.u) != null && t21Var2.r() != 0.0f))) {
            t21 t21Var4 = this.s;
            float fR = t21Var4 != null ? t21Var4.r() : 0.0f;
            t21 t21Var5 = this.t;
            float fR2 = t21Var5 != null ? t21Var5.r() : 0.0f;
            t21 t21Var6 = this.u;
            float fR3 = t21Var6 != null ? t21Var6.r() : 0.0f;
            if (this.k || fR != this.f || fR2 != this.g || fR3 != this.h) {
                this.f = fR;
                this.g = fR2;
                this.h = fR3;
                if (fR != 0.0f) {
                    this.i = (float) Math.cos(Math.toRadians(fR));
                } else {
                    this.i = 1.0f;
                }
                if (fR2 != 0.0f) {
                    this.j = (float) Math.cos(Math.toRadians(fR2));
                } else {
                    this.j = 1.0f;
                }
                this.k = false;
            }
            zh zhVar = this.l;
            PointF pointF3 = zhVar == null ? null : (PointF) zhVar.h();
            zh zhVar2 = this.m;
            PointF pointF4 = zhVar2 == null ? null : (PointF) zhVar2.h();
            zh zhVar3 = this.n;
            by3 by3Var2 = zhVar3 != null ? (by3) zhVar3.h() : null;
            is4.b(this.a, pointF3, pointF4, by3Var2 != null ? by3Var2.b() : 1.0f, by3Var2 != null ? by3Var2.c() : 1.0f, fR, fR2, fR3, this.i, this.j);
            return this.a;
        }
        zh zhVar4 = this.m;
        if (zhVar4 != null && (pointF2 = (PointF) zhVar4.h()) != null) {
            float f = pointF2.x;
            if (f != 0.0f || pointF2.y != 0.0f) {
                this.a.preTranslate(f, pointF2.y);
            }
        }
        if (!this.x) {
            zh zhVar5 = this.o;
            if (zhVar5 != null) {
                float fFloatValue = zhVar5 instanceof bz4 ? ((Float) zhVar5.h()).floatValue() : ((t21) zhVar5).r();
                if (fFloatValue != 0.0f) {
                    this.a.preRotate(fFloatValue);
                }
            }
        } else if (zhVar4 != null) {
            float f2 = zhVar4.f();
            PointF pointF5 = (PointF) zhVar4.h();
            float f3 = pointF5.x;
            float f4 = pointF5.y;
            zhVar4.n(1.0E-4f + f2);
            PointF pointF6 = (PointF) zhVar4.h();
            zhVar4.n(f2);
            this.a.preRotate((float) Math.toDegrees(Math.atan2(pointF6.y - f4, pointF6.x - f3)));
        }
        if (this.q != null) {
            float fCos = this.r == null ? 0.0f : (float) Math.cos(Math.toRadians((-r4.r()) + 90.0f));
            float fSin = this.r == null ? 1.0f : (float) Math.sin(Math.toRadians((-r6.r()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.r()));
            g();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f5 = -fSin;
            fArr[3] = f5;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            g();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            g();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f5;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        zh zhVar6 = this.n;
        if (zhVar6 != null && (by3Var = (by3) zhVar6.h()) != null && (by3Var.b() != 1.0f || by3Var.c() != 1.0f)) {
            this.a.preScale(by3Var.b(), by3Var.c());
        }
        zh zhVar7 = this.l;
        if (zhVar7 != null && (pointF = (PointF) zhVar7.h()) != null) {
            float f6 = pointF.x;
            if (f6 != 0.0f || pointF.y != 0.0f) {
                this.a.preTranslate(-f6, -pointF.y);
            }
        }
        return this.a;
    }

    public Matrix j(float f) {
        zh zhVar = this.m;
        PointF pointF = zhVar == null ? null : (PointF) zhVar.h();
        zh zhVar2 = this.n;
        by3 by3Var = zhVar2 == null ? null : (by3) zhVar2.h();
        zh zhVar3 = this.l;
        PointF pointF2 = zhVar3 != null ? (PointF) zhVar3.h() : null;
        this.a.reset();
        if (pointF != null) {
            this.a.preTranslate(pointF.x * f, pointF.y * f);
        }
        t21 t21Var = this.s;
        float fR = t21Var != null ? t21Var.r() * f : 0.0f;
        t21 t21Var2 = this.t;
        float fR2 = t21Var2 != null ? t21Var2.r() * f : 0.0f;
        t21 t21Var3 = this.u;
        float fR3 = t21Var3 != null ? t21Var3.r() * f : 0.0f;
        if (fR == 0.0f && fR2 == 0.0f && fR3 == 0.0f) {
            zh zhVar4 = this.o;
            if (zhVar4 != null) {
                this.a.preRotate(((Float) zhVar4.h()).floatValue() * f, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
            }
        } else {
            float fCos = fR != 0.0f ? (float) Math.cos(Math.toRadians(fR)) : 1.0f;
            float fCos2 = fR2 != 0.0f ? (float) Math.cos(Math.toRadians(fR2)) : 1.0f;
            if (fR3 != 0.0f) {
                this.a.preRotate(fR3, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
            }
            is4.a(this.a, fR, fR2, 0.0f, fCos, fCos2);
        }
        if (by3Var != null) {
            double d = f;
            this.a.preScale((float) Math.pow(by3Var.b(), d), (float) Math.pow(by3Var.c(), d));
        }
        return this.a;
    }

    public zh k() {
        return this.p;
    }

    public zh l() {
        return this.v;
    }

    public void m(float f) {
        zh zhVar = this.p;
        if (zhVar != null) {
            zhVar.n(f);
        }
        zh zhVar2 = this.v;
        if (zhVar2 != null) {
            zhVar2.n(f);
        }
        zh zhVar3 = this.w;
        if (zhVar3 != null) {
            zhVar3.n(f);
        }
        zh zhVar4 = this.l;
        if (zhVar4 != null) {
            zhVar4.n(f);
        }
        zh zhVar5 = this.m;
        if (zhVar5 != null) {
            zhVar5.n(f);
        }
        zh zhVar6 = this.n;
        if (zhVar6 != null) {
            zhVar6.n(f);
        }
        zh zhVar7 = this.o;
        if (zhVar7 != null) {
            zhVar7.n(f);
        }
        t21 t21Var = this.q;
        if (t21Var != null) {
            t21Var.n(f);
        }
        t21 t21Var2 = this.r;
        if (t21Var2 != null) {
            t21Var2.n(f);
        }
        t21 t21Var3 = this.s;
        if (t21Var3 != null) {
            t21Var3.n(f);
        }
        t21 t21Var4 = this.t;
        if (t21Var4 != null) {
            t21Var4.n(f);
        }
        t21 t21Var5 = this.u;
        if (t21Var5 != null) {
            t21Var5.n(f);
        }
    }
}

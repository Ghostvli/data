package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import defpackage.p54;
import defpackage.zh;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ap3 implements zh.b, br1, f93 {
    public final String c;
    public final boolean d;
    public final g22 e;
    public final zh f;
    public final zh g;
    public final zh h;
    public boolean k;
    public final Path a = new Path();
    public final RectF b = new RectF();
    public final uy i = new uy();
    public zh j = null;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ap3(g22 g22Var, bi biVar, bp3 bp3Var) {
        this.c = bp3Var.c();
        this.d = bp3Var.f();
        this.e = g22Var;
        zh zhVarA = bp3Var.d().a();
        this.f = zhVarA;
        zh zhVarA2 = bp3Var.e().a();
        this.g = zhVarA2;
        t21 t21VarA = bp3Var.b().a();
        this.h = t21VarA;
        biVar.j(zhVarA);
        biVar.j(zhVarA2);
        biVar.j(t21VarA);
        zhVarA.a(this);
        zhVarA2.a(this);
        t21VarA.a(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void f() {
        this.k = false;
        this.e.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // defpackage.k20
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            k20 k20Var = (k20) list.get(i);
            if (k20Var instanceof nt4) {
                nt4 nt4Var = (nt4) k20Var;
                if (nt4Var.k() == p54.a.SIMULTANEOUSLY) {
                    this.i.a(nt4Var);
                    nt4Var.f(this);
                } else if (k20Var instanceof nu3) {
                    this.j = ((nu3) k20Var).h();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.l) {
            this.g.o(y22Var);
        } else if (obj == q22.n) {
            this.f.o(y22Var);
        } else if (obj == q22.m) {
            this.h.o(y22Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public String getName() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f93
    public Path getPath() {
        zh zhVar;
        boolean z = this.k;
        Path path = this.a;
        if (z) {
            return path;
        }
        path.reset();
        if (this.d) {
            this.k = true;
            return this.a;
        }
        PointF pointF = (PointF) this.g.h();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        zh zhVar2 = this.h;
        float fR = zhVar2 == null ? 0.0f : ((t21) zhVar2).r();
        if (fR == 0.0f && (zhVar = this.j) != null) {
            fR = Math.min(((Float) zhVar.h()).floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fR > fMin) {
            fR = fMin;
        }
        PointF pointF2 = (PointF) this.f.h();
        this.a.moveTo(pointF2.x + f, (pointF2.y - f2) + fR);
        this.a.lineTo(pointF2.x + f, (pointF2.y + f2) - fR);
        if (fR > 0.0f) {
            RectF rectF = this.b;
            float f3 = pointF2.x;
            float f4 = fR * 2.0f;
            float f5 = pointF2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x - f) + fR, pointF2.y + f2);
        if (fR > 0.0f) {
            RectF rectF2 = this.b;
            float f6 = pointF2.x;
            float f7 = pointF2.y;
            float f8 = fR * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x - f, (pointF2.y - f2) + fR);
        if (fR > 0.0f) {
            RectF rectF3 = this.b;
            float f9 = pointF2.x;
            float f10 = pointF2.y;
            float f11 = fR * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x + f) - fR, pointF2.y - f2);
        if (fR > 0.0f) {
            RectF rectF4 = this.b;
            float f12 = pointF2.x;
            float f13 = fR * 2.0f;
            float f14 = pointF2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.b(this.a);
        this.k = true;
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }
}

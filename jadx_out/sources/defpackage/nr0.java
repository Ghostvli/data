package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import defpackage.p54;
import defpackage.zh;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nr0 implements f93, zh.b, br1 {
    public final String b;
    public final g22 c;
    public final zh d;
    public final zh e;
    public final cu f;
    public boolean h;
    public final Path a = new Path();
    public final uy g = new uy();

    public nr0(g22 g22Var, bi biVar, cu cuVar) {
        this.b = cuVar.b();
        this.c = g22Var;
        zh zhVarA = cuVar.d().a();
        this.d = zhVarA;
        zh zhVarA2 = cuVar.c().a();
        this.e = zhVarA2;
        this.f = cuVar;
        biVar.j(zhVarA);
        biVar.j(zhVarA2);
        zhVarA.a(this);
        zhVarA2.a(this);
    }

    @Override // zh.b
    public void a() {
        f();
    }

    @Override // defpackage.k20
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            k20 k20Var = (k20) list.get(i);
            if (k20Var instanceof nt4) {
                nt4 nt4Var = (nt4) k20Var;
                if (nt4Var.k() == p54.a.SIMULTANEOUSLY) {
                    this.g.a(nt4Var);
                    nt4Var.f(this);
                }
            }
        }
    }

    public final void f() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.k) {
            this.d.o(y22Var);
        } else if (obj == q22.n) {
            this.e.o(y22Var);
        }
    }

    @Override // defpackage.k20
    public String getName() {
        return this.b;
    }

    @Override // defpackage.f93
    public Path getPath() {
        boolean z = this.h;
        Path path = this.a;
        if (z) {
            return path;
        }
        path.reset();
        if (this.f.e()) {
            this.h = true;
            return this.a;
        }
        PointF pointF = (PointF) this.d.h();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        boolean zF = this.f.f();
        Path path2 = this.a;
        if (zF) {
            float f5 = -f2;
            path2.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            path2.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointF2 = (PointF) this.e.h();
        this.a.offset(pointF2.x, pointF2.y);
        this.a.close();
        this.g.b(this.a);
        this.h = true;
        return this.a;
    }

    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }
}

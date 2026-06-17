package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import defpackage.zh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pq3 implements mo0, f93, ib1, zh.b, br1 {
    public final Matrix a = new Matrix();
    public final Path b = new Path();
    public final g22 c;
    public final bi d;
    public final String e;
    public final boolean f;
    public final zh g;
    public final zh h;
    public final ms4 i;
    public o20 j;

    public pq3(g22 g22Var, bi biVar, oq3 oq3Var) {
        this.c = g22Var;
        this.d = biVar;
        this.e = oq3Var.c();
        this.f = oq3Var.f();
        t21 t21VarA = oq3Var.b().a();
        this.g = t21VarA;
        biVar.j(t21VarA);
        t21VarA.a(this);
        t21 t21VarA2 = oq3Var.d().a();
        this.h = t21VarA2;
        biVar.j(t21VarA2);
        t21VarA2.a(this);
        ms4 ms4VarB = oq3Var.e().b();
        this.i = ms4VarB;
        ms4VarB.d(biVar);
        ms4VarB.e(this);
    }

    @Override // zh.b
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // defpackage.k20
    public void b(List list, List list2) {
        this.j.b(list, list2);
    }

    @Override // defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.j.d(rectF, matrix, z);
    }

    @Override // defpackage.ib1
    public void f(ListIterator listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((k20) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new o20(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (this.i.f(obj, y22Var)) {
            return;
        }
        if (obj == q22.x) {
            this.g.o(y22Var);
        } else if (obj == q22.y) {
            this.h.o(y22Var);
        }
    }

    @Override // defpackage.k20
    public String getName() {
        return this.e;
    }

    @Override // defpackage.f93
    public Path getPath() {
        Path path = this.j.getPath();
        this.b.reset();
        float fFloatValue = ((Float) this.g.h()).floatValue();
        float fFloatValue2 = ((Float) this.h.h()).floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.j(i + fFloatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }

    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
        for (int i2 = 0; i2 < this.j.k().size(); i2++) {
            k20 k20Var = (k20) this.j.k().get(i2);
            if (k20Var instanceof br1) {
                ot2.k(zq1Var, i, list, zq1Var2, (br1) k20Var);
            }
        }
    }

    @Override // defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        float fFloatValue = ((Float) this.g.h()).floatValue();
        float fFloatValue2 = ((Float) this.h.h()).floatValue();
        float fFloatValue3 = ((Float) this.i.l().h()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) this.i.h().h()).floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.j(f + fFloatValue2));
            this.j.i(canvas, this.a, (int) (i * ot2.i(fFloatValue3, fFloatValue4, f / fFloatValue)), dp0Var);
        }
    }
}

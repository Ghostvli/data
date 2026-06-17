package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import defpackage.a53;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o20 implements mo0, f93, zh.b, ar1 {
    public final a53.b a;
    public final RectF b;
    public final a53 c;
    public final Matrix d;
    public final Path e;
    public final RectF f;
    public final String g;
    public final boolean h;
    public final List i;
    public final g22 j;
    public List k;
    public ms4 l;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o20(g22 g22Var, bi biVar, String str, boolean z, List list, x6 x6Var) {
        this.a = new a53.b();
        this.b = new RectF();
        this.c = new a53();
        this.d = new Matrix();
        this.e = new Path();
        this.f = new RectF();
        this.g = str;
        this.j = g22Var;
        this.h = z;
        this.i = list;
        if (x6Var != null) {
            ms4 ms4VarB = x6Var.b();
            this.l = ms4VarB;
            ms4VarB.d(biVar);
            this.l.e(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            k20 k20Var = (k20) list.get(size);
            if (k20Var instanceof ib1) {
                arrayList.add((ib1) k20Var);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((ib1) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List f(g22 g22Var, f12 f12Var, bi biVar, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            k20 k20VarA = ((v20) list.get(i)).a(g22Var, f12Var, biVar);
            if (k20VarA != null) {
                arrayList.add(k20VarA);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x6 j(List list) {
        for (int i = 0; i < list.size(); i++) {
            v20 v20Var = (v20) list.get(i);
            if (v20Var instanceof x6) {
                return (x6) v20Var;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        this.j.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public void b(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.i.size());
        arrayList.addAll(list);
        for (int size = this.i.size() - 1; size >= 0; size--) {
            k20 k20Var = (k20) this.i.get(size);
            k20Var.b(arrayList, this.i.subList(0, size));
            arrayList.add(k20Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.d.set(matrix);
        ms4 ms4Var = this.l;
        if (ms4Var != null) {
            this.d.preConcat(ms4Var.i());
        }
        this.f.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.i.size() - 1; size >= 0; size--) {
            k20 k20Var = (k20) this.i.get(size);
            if (k20Var instanceof mo0) {
                ((mo0) k20Var).d(this.f, this.d, z);
                rectF.union(this.f);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        ms4 ms4Var = this.l;
        if (ms4Var != null) {
            ms4Var.f(obj, y22Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public String getName() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f93
    public Path getPath() {
        this.d.reset();
        ms4 ms4Var = this.l;
        if (ms4Var != null) {
            this.d.set(ms4Var.i());
        }
        this.e.reset();
        if (this.h) {
            return this.e;
        }
        for (int size = this.i.size() - 1; size >= 0; size--) {
            k20 k20Var = (k20) this.i.get(size);
            if (k20Var instanceof f93) {
                this.e.addPath(((f93) k20Var).getPath(), this.d);
            }
        }
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        if (zq1Var.g(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                zq1Var2 = zq1Var2.a(getName());
                if (zq1Var.c(getName(), i)) {
                    list.add(zq1Var2.i(this));
                }
            }
            if (zq1Var.h(getName(), i)) {
                int iE = i + zq1Var.e(getName(), i);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    k20 k20Var = (k20) this.i.get(i2);
                    if (k20Var instanceof ar1) {
                        ((ar1) k20Var).h(zq1Var, iE, list, zq1Var2);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        if (this.h) {
            return;
        }
        this.d.set(matrix);
        ms4 ms4Var = this.l;
        if (ms4Var != null) {
            this.d.preConcat(ms4Var.i());
            i = (int) (((((this.l.k() == null ? 100 : ((Integer) this.l.k().h()).intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = (this.j.d0() && n() && i != 255) || (dp0Var != null && this.j.e0() && n());
        int i2 = z ? 255 : i;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(this.b, matrix, true);
            a53.b bVar = this.a;
            bVar.a = i;
            if (dp0Var != null) {
                dp0Var.a(bVar);
                dp0Var = null;
            } else {
                bVar.d = null;
            }
            canvas = this.c.j(canvas, this.b, this.a);
        } else if (dp0Var != null) {
            dp0 dp0Var2 = new dp0(dp0Var);
            dp0Var2.i(i2);
            dp0Var = dp0Var2;
        }
        for (int size = this.i.size() - 1; size >= 0; size--) {
            Object obj = this.i.get(size);
            if (obj instanceof mo0) {
                ((mo0) obj).i(canvas, this.d, i2, dp0Var);
            }
        }
        if (z) {
            this.c.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List k() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List l() {
        if (this.k == null) {
            this.k = new ArrayList();
            for (int i = 0; i < this.i.size(); i++) {
                k20 k20Var = (k20) this.i.get(i);
                if (k20Var instanceof f93) {
                    this.k.add((f93) k20Var);
                }
            }
        }
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Matrix m() {
        ms4 ms4Var = this.l;
        if (ms4Var != null) {
            return ms4Var.i();
        }
        this.d.reset();
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n() {
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            if ((this.i.get(i2) instanceof mo0) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public o20(g22 g22Var, bi biVar, f54 f54Var, f12 f12Var) {
        this(g22Var, biVar, f54Var.c(), f54Var.d(), f(g22Var, f12Var, biVar, f54Var.b()), j(f54Var.b()));
    }
}

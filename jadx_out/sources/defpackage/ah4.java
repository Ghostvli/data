package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ah4 extends xi {
    public final bi q;
    public final String r;
    public final boolean s;
    public final zh t;
    public zh u;

    public ah4(g22 g22Var, bi biVar, n54 n54Var) {
        super(g22Var, biVar, n54Var.b().b(), n54Var.e().b(), n54Var.g(), n54Var.i(), n54Var.j(), n54Var.f(), n54Var.d());
        this.q = biVar;
        this.r = n54Var.h();
        this.s = n54Var.k();
        zh zhVarA = n54Var.c().a();
        this.t = zhVarA;
        zhVarA.a(this);
        biVar.j(zhVarA);
    }

    @Override // defpackage.xi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        super.g(obj, y22Var);
        if (obj == q22.b) {
            this.t.o(y22Var);
            return;
        }
        if (obj == q22.N) {
            zh zhVar = this.u;
            if (zhVar != null) {
                this.q.H(zhVar);
            }
            if (y22Var == null) {
                this.u = null;
                return;
            }
            bz4 bz4Var = new bz4(y22Var);
            this.u = bz4Var;
            bz4Var.a(this);
            this.q.j(this.t);
        }
    }

    @Override // defpackage.k20
    public String getName() {
        return this.r;
    }

    @Override // defpackage.xi, defpackage.mo0
    public void i(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        if (this.s) {
            return;
        }
        this.i.setColor(((cx) this.t).r());
        zh zhVar = this.u;
        if (zhVar != null) {
            this.i.setColorFilter((ColorFilter) zhVar.h());
        }
        super.i(canvas, matrix, i, dp0Var);
    }
}

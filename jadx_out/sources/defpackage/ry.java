package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import defpackage.a53;
import defpackage.yr1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ry extends bi {
    public zh E;
    public final List F;
    public final RectF G;
    public final RectF H;
    public final RectF I;
    public final a53 J;
    public final a53.b K;
    public float L;
    public boolean M;
    public gp0 N;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[yr1.b.values().length];
            a = iArr;
            try {
                iArr[yr1.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[yr1.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ry(g22 g22Var, yr1 yr1Var, List list, f12 f12Var) {
        int i;
        bi biVar;
        super(g22Var, yr1Var);
        this.F = new ArrayList();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new RectF();
        this.J = new a53();
        this.K = new a53.b();
        this.M = true;
        j6 j6VarV = yr1Var.v();
        if (j6VarV != null) {
            t21 t21VarA = j6VarV.a();
            this.E = t21VarA;
            j(t21VarA);
            this.E.a(this);
        } else {
            this.E = null;
        }
        w02 w02Var = new w02(f12Var.k().size());
        int size = list.size() - 1;
        bi biVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            yr1 yr1Var2 = (yr1) list.get(size);
            bi biVarV = bi.v(this, yr1Var2, g22Var, f12Var);
            if (biVarV != null) {
                w02Var.h(biVarV.A().e(), biVarV);
                if (biVar2 != null) {
                    biVar2.J(biVarV);
                    biVar2 = null;
                } else {
                    this.F.add(0, biVarV);
                    int i2 = a.a[yr1Var2.i().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        biVar2 = biVarV;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < w02Var.k(); i++) {
            bi biVar3 = (bi) w02Var.d(w02Var.g(i));
            if (biVar3 != null && (biVar = (bi) w02Var.d(biVar3.A().k())) != null) {
                biVar3.L(biVar);
            }
        }
        if (z() != null) {
            this.N = new gp0(this, this, z());
        }
    }

    @Override // defpackage.bi
    public void I(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            ((bi) this.F.get(i2)).h(zq1Var, i, list, zq1Var2);
        }
    }

    @Override // defpackage.bi
    public void K(boolean z) {
        super.K(z);
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            ((bi) it.next()).K(z);
        }
    }

    @Override // defpackage.bi
    public void M(float f) {
        if (or1.h()) {
            or1.b("CompositionLayer#setProgress");
        }
        this.L = f;
        super.M(f);
        if (this.E != null) {
            f = ((((Float) this.E.h()).floatValue() * this.q.c().i()) - this.q.c().p()) / (this.p.H().e() + 0.01f);
        }
        if (this.E == null) {
            f -= this.q.s();
        }
        if (this.q.w() != 0.0f && !"__container".equals(this.q.j())) {
            f /= this.q.w();
        }
        for (int size = this.F.size() - 1; size >= 0; size--) {
            ((bi) this.F.get(size)).M(f);
        }
        if (or1.h()) {
            or1.c("CompositionLayer#setProgress");
        }
    }

    public float P() {
        return this.L;
    }

    public void Q(boolean z) {
        this.M = z;
    }

    @Override // defpackage.bi, defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.G.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((bi) this.F.get(size)).d(this.G, this.o, true);
            rectF.union(this.G);
        }
    }

    @Override // defpackage.bi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        gp0 gp0Var;
        gp0 gp0Var2;
        gp0 gp0Var3;
        gp0 gp0Var4;
        gp0 gp0Var5;
        super.g(obj, y22Var);
        if (obj == q22.H) {
            if (y22Var == null) {
                zh zhVar = this.E;
                if (zhVar != null) {
                    zhVar.o(null);
                    return;
                }
                return;
            }
            bz4 bz4Var = new bz4(y22Var);
            this.E = bz4Var;
            bz4Var.a(this);
            j(this.E);
            return;
        }
        if (obj == q22.e && (gp0Var5 = this.N) != null) {
            gp0Var5.c(y22Var);
            return;
        }
        if (obj == q22.J && (gp0Var4 = this.N) != null) {
            gp0Var4.f(y22Var);
            return;
        }
        if (obj == q22.K && (gp0Var3 = this.N) != null) {
            gp0Var3.d(y22Var);
            return;
        }
        if (obj == q22.L && (gp0Var2 = this.N) != null) {
            gp0Var2.e(y22Var);
        } else {
            if (obj != q22.M || (gp0Var = this.N) == null) {
                return;
            }
            gp0Var.g(y22Var);
        }
    }

    @Override // defpackage.bi
    public void u(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        Canvas canvasJ;
        if (or1.h()) {
            or1.b("CompositionLayer#draw");
        }
        boolean z = false;
        boolean z2 = (dp0Var == null && this.N == null) ? false : true;
        if ((this.p.d0() && this.F.size() > 1 && i != 255) || (z2 && this.p.e0())) {
            z = true;
        }
        int i2 = z ? 255 : i;
        gp0 gp0Var = this.N;
        if (gp0Var != null) {
            dp0Var = gp0Var.b(matrix, i2);
        }
        if (this.M || !"__container".equals(this.q.j())) {
            this.H.set(0.0f, 0.0f, this.q.m(), this.q.l());
            matrix.mapRect(this.H);
        } else {
            this.H.setEmpty();
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                ((bi) it.next()).d(this.I, matrix, true);
                this.H.union(this.I);
            }
        }
        if (z) {
            this.K.f();
            a53.b bVar = this.K;
            bVar.a = i;
            if (dp0Var != null) {
                dp0Var.a(bVar);
                dp0Var = null;
            }
            canvasJ = this.J.j(canvas, this.H, this.K);
        } else {
            canvasJ = canvas;
        }
        canvas.save();
        if (canvas.clipRect(this.H)) {
            for (int size = this.F.size() - 1; size >= 0; size--) {
                ((bi) this.F.get(size)).i(canvasJ, matrix, i2, dp0Var);
            }
        }
        if (z) {
            this.J.e();
        }
        canvas.restore();
        if (or1.h()) {
            or1.c("CompositionLayer#draw");
        }
    }
}

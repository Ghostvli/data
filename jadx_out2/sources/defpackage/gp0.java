package defpackage;

import android.graphics.Color;
import android.graphics.Matrix;
import defpackage.zh;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gp0 implements zh.b {
    public final bi a;
    public final zh.b b;
    public final zh c;
    public final t21 d;
    public final t21 e;
    public final t21 f;
    public final t21 g;
    public Matrix h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends y22 {
        public final /* synthetic */ y22 d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(y22 y22Var) {
            this.d = y22Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Lk22;)Ljava/lang/Object; */
        @Override // defpackage.y22
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(k22 k22Var) {
            Float f = (Float) this.d.a(k22Var);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gp0(zh.b bVar, bi biVar, ep0 ep0Var) {
        this.b = bVar;
        this.a = biVar;
        zh zhVarA = ep0Var.a().a();
        this.c = zhVarA;
        zhVarA.a(this);
        biVar.j(zhVarA);
        t21 t21VarA = ep0Var.d().a();
        this.d = t21VarA;
        t21VarA.a(this);
        biVar.j(t21VarA);
        t21 t21VarA2 = ep0Var.b().a();
        this.e = t21VarA2;
        t21VarA2.a(this);
        biVar.j(t21VarA2);
        t21 t21VarA3 = ep0Var.c().a();
        this.f = t21VarA3;
        t21VarA3.a(this);
        biVar.j(t21VarA3);
        t21 t21VarA4 = ep0Var.e().a();
        this.g = t21VarA4;
        t21VarA4.a(this);
        biVar.j(t21VarA4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        this.b.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dp0 b(Matrix matrix, int i) {
        float fR = this.e.r() * 0.017453292f;
        float fFloatValue = ((Float) this.f.h()).floatValue();
        double d = fR;
        float fSin = ((float) Math.sin(d)) * fFloatValue;
        float fCos = ((float) Math.cos(d + 3.141592653589793d)) * fFloatValue;
        float fFloatValue2 = ((Float) this.g.h()).floatValue();
        int iIntValue = ((Integer) this.c.h()).intValue();
        dp0 dp0Var = new dp0(fFloatValue2 * 0.33f, fSin, fCos, Color.argb(Math.round((((Float) this.d.h()).floatValue() * i) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        dp0Var.k(matrix);
        if (this.h == null) {
            this.h = new Matrix();
        }
        this.a.x.i().invert(this.h);
        dp0Var.k(this.h);
        return dp0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(y22 y22Var) {
        this.c.o(y22Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(y22 y22Var) {
        this.e.o(y22Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(y22 y22Var) {
        this.f.o(y22Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(y22 y22Var) {
        t21 t21Var = this.d;
        if (y22Var == null) {
            t21Var.o(null);
        } else {
            t21Var.o(new a(y22Var));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(y22 y22Var) {
        this.g.o(y22Var);
    }
}

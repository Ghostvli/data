package defpackage;

import defpackage.rb4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class y80 {
    public int a = 0;
    public int b = 0;
    public rb4.c c = null;
    public float d = 1.0f;
    public long e = 3800;
    public long f = 4000;
    public up0 g;
    public up0 h;
    public up0 i;
    public fh1 j;
    public t80 k;

    public static y80 a() {
        return new y80();
    }

    public ih b(int i, float f, float f2, float f3, float f4) {
        float f5;
        int i2 = this.a;
        int i3 = this.b;
        boolean zK = k(f, f2, f3);
        up0 up0Var = this.g;
        if (up0Var == null) {
            up0 up0Var2 = new up0(this.e);
            this.g = up0Var2;
            up0Var2.a(f4);
        } else if (zK) {
            up0Var.b(this.e);
        }
        if (this.h == null) {
            this.h = new up0(3800L);
        }
        float f6 = 1.0f;
        if (!zK || f <= 0.0f) {
            f5 = 1.0f;
        } else {
            h();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f6 = f / i2;
                f5 = f2 / i3;
            }
            int i4 = (int) f;
            int i5 = (int) f2;
            i(i4, i5, f6, f5);
            if (f2 > 0.0f) {
                j(i4, i5, f6, f5);
            }
        }
        if (i == 1) {
            return new nn3(this.g);
        }
        if (i == 4) {
            return new qz0(this.h);
        }
        if (i == 5) {
            return new rz0(this.h);
        }
        if (i == 6) {
            return new nr1(this.g);
        }
        if (i != 7) {
            return null;
        }
        rb4 rb4Var = new rb4();
        i((int) f, (int) f2, f6, f5);
        rb4Var.H(this.c);
        return rb4Var;
    }

    public ih c(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public ih d(int i, t80 t80Var) {
        if (t80Var == null) {
            return null;
        }
        this.k = t80Var;
        o oVarB = t80Var.b();
        this.j = oVarB;
        return c(i, oVarB.b(), this.j.a(), this.d, t80Var.q);
    }

    public void e(t80 t80Var) {
        this.k = t80Var;
        this.j = t80Var.b();
        d(1, t80Var);
    }

    public void f() {
        this.j = null;
        this.b = 0;
        this.a = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f = 4000L;
    }

    public void g(float f) {
        up0 up0Var = this.g;
        if (up0Var == null || this.h == null) {
            return;
        }
        up0Var.a(f);
        h();
    }

    public void h() {
        up0 up0Var = this.g;
        long j = up0Var == null ? 0L : up0Var.h;
        up0 up0Var2 = this.h;
        long j2 = up0Var2 == null ? 0L : up0Var2.h;
        up0 up0Var3 = this.i;
        long j3 = up0Var3 != null ? up0Var3.h : 0L;
        long jMax = Math.max(j, j2);
        this.f = jMax;
        long jMax2 = Math.max(jMax, j3);
        this.f = jMax2;
        long jMax3 = Math.max(3800L, jMax2);
        this.f = jMax3;
        this.f = Math.max(this.e, jMax3);
    }

    public final void i(int i, int i2, float f, float f2) {
        if (this.c == null) {
            this.c = new rb4.c(i, i2, f, f2);
        }
        this.c.b(i, i2, f, f2);
    }

    public final synchronized void j(int i, int i2, float f, float f2) {
        rb4.c cVar = this.c;
        if (cVar != null) {
            cVar.b(i, i2, f, f2);
        }
    }

    public boolean k(float f, float f2, float f3) {
        int i = (int) f;
        if (this.a == i && this.b == ((int) f2) && this.d == f3) {
            return false;
        }
        long j = (long) (((f * f3) / 682.0f) * 3800.0f);
        this.e = j;
        long jMin = Math.min(9000L, j);
        this.e = jMin;
        this.e = Math.max(4000L, jMin);
        this.a = i;
        this.b = (int) f2;
        this.d = f3;
        return true;
    }
}

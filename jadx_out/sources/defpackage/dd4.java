package defpackage;

import android.util.AndroidRuntimeException;
import defpackage.dq0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dd4 extends dq0 {
    public ed4 B;
    public float C;
    public boolean D;

    public dd4(Object obj, v21 v21Var) {
        super(obj, v21Var);
        this.B = null;
        this.C = Float.MAX_VALUE;
        this.D = false;
    }

    @Override // defpackage.dq0
    public void n(float f) {
    }

    @Override // defpackage.dq0
    public void o() {
        v();
        this.B.i(f());
        super.o();
    }

    @Override // defpackage.dq0
    public boolean q(long j) {
        boolean z = this.D;
        float f = this.C;
        if (z) {
            if (f != Float.MAX_VALUE) {
                this.B.g(f);
                this.C = Float.MAX_VALUE;
            }
            this.b = this.B.b();
            this.a = 0.0f;
            this.D = false;
            return true;
        }
        ed4 ed4Var = this.B;
        if (f != Float.MAX_VALUE) {
            long j2 = j / 2;
            dq0.o oVarJ = ed4Var.j(this.b, this.a, j2);
            this.B.g(this.C);
            this.C = Float.MAX_VALUE;
            dq0.o oVarJ2 = this.B.j(oVarJ.a, oVarJ.b, j2);
            this.b = oVarJ2.a;
            this.a = oVarJ2.b;
        } else {
            dq0.o oVarJ3 = ed4Var.j(this.b, this.a, j);
            this.b = oVarJ3.a;
            this.a = oVarJ3.b;
        }
        float fMax = Math.max(this.b, this.h);
        this.b = fMax;
        float fMin = Math.min(fMax, this.g);
        this.b = fMin;
        if (!u(fMin, this.a)) {
            return false;
        }
        this.b = this.B.b();
        this.a = 0.0f;
        return true;
    }

    public void r(float f) {
        if (g()) {
            this.C = f;
            return;
        }
        if (this.B == null) {
            this.B = new ed4(f);
        }
        this.B.g(f);
        o();
    }

    public boolean s() {
        return this.B.b > 0.0d;
    }

    public ed4 t() {
        return this.B;
    }

    public boolean u(float f, float f2) {
        return this.B.e(f, f2);
    }

    public final void v() {
        ed4 ed4Var = this.B;
        if (ed4Var == null) {
            fn.a("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
            return;
        }
        double dB = ed4Var.b();
        if (dB > this.g) {
            fn.a("Final position of the spring cannot be greater than the max value.");
        } else {
            if (dB >= this.h) {
                return;
            }
            fn.a("Final position of the spring cannot be less than the min value.");
        }
    }

    public dd4 w(ed4 ed4Var) {
        this.B = ed4Var;
        return this;
    }

    public void x() {
        if (!s()) {
            fn.a("Spring animations can only come to an end when there is damping");
        } else {
            if (!d().j()) {
                throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
            }
            if (this.f) {
                this.D = true;
            }
        }
    }
}

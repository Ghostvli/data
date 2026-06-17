package defpackage;

import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class x22 extends fi implements Choreographer.FrameCallback {
    public f12 q;
    public float i = 1.0f;
    public boolean j = false;
    public long k = 0;
    public float l = 0.0f;
    public float m = 0.0f;
    public int n = 0;
    public float o = -2.1474836E9f;
    public float p = 2.1474836E9f;
    public boolean r = false;
    public boolean s = false;

    public void A(float f) {
        B(this.o, f);
    }

    public void B(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        f12 f12Var = this.q;
        float fP = f12Var == null ? -3.4028235E38f : f12Var.p();
        f12 f12Var2 = this.q;
        float f3 = f12Var2 == null ? Float.MAX_VALUE : f12Var2.f();
        float fB = ot2.b(f, fP, f3);
        float fB2 = ot2.b(f2, fP, f3);
        if (fB == this.o && fB2 == this.p) {
            return;
        }
        this.o = fB;
        this.p = fB2;
        z((int) ot2.b(this.m, fB, fB2));
    }

    public void C(int i) {
        B(i, (int) this.p);
    }

    public void D(float f) {
        this.i = f;
    }

    public void E(boolean z) {
        this.s = z;
    }

    public final void F() {
        if (this.q == null) {
            return;
        }
        float f = this.m;
        float f2 = this.o;
        if (f < f2 || f > this.p) {
            r14.a("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(f2), Float.valueOf(this.p), Float.valueOf(this.m)});
        }
    }

    @Override // defpackage.fi
    public void a() {
        super.a();
        b(q());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        u();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        t();
        if (this.q == null || !isRunning()) {
            return;
        }
        if (or1.h()) {
            or1.b("LottieValueAnimator#doFrame");
        }
        float fM = (this.k != 0 ? j - r2 : 0L) / m();
        float f = this.l;
        if (q()) {
            fM = -fM;
        }
        float f2 = f + fM;
        boolean zD = ot2.d(f2, o(), n());
        float f3 = this.l;
        float fB = ot2.b(f2, o(), n());
        this.l = fB;
        if (this.s) {
            fB = (float) Math.floor(fB);
        }
        this.m = fB;
        this.k = j;
        if (zD) {
            h(f3);
        } else if (getRepeatCount() == -1 || this.n < getRepeatCount()) {
            if (getRepeatMode() == 2) {
                this.j = !this.j;
                x();
            } else {
                float fN = q() ? n() : o();
                this.l = fN;
                this.m = fN;
            }
            this.k = j;
            h(f3);
            d();
            this.n++;
        } else {
            float fO = this.i < 0.0f ? o() : n();
            this.l = fO;
            this.m = fO;
            u();
            h(f3);
            b(q());
        }
        F();
        if (or1.h()) {
            or1.c("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fO;
        float fN;
        float fO2;
        if (this.q == null) {
            return 0.0f;
        }
        if (q()) {
            fO = n() - this.m;
            fN = n();
            fO2 = o();
        } else {
            fO = this.m - o();
            fN = n();
            fO2 = o();
        }
        return fO / (fN - fO2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(k());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        f12 f12Var = this.q;
        if (f12Var == null) {
            return 0L;
        }
        return (long) f12Var.d();
    }

    public final void h(float f) {
        if (this.s && this.l == f) {
            return;
        }
        g();
    }

    public void i() {
        this.q = null;
        this.o = -2.1474836E9f;
        this.p = 2.1474836E9f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.r;
    }

    public void j() {
        u();
        b(q());
    }

    public float k() {
        f12 f12Var = this.q;
        if (f12Var == null) {
            return 0.0f;
        }
        return (this.m - f12Var.p()) / (this.q.f() - this.q.p());
    }

    public float l() {
        return this.m;
    }

    public final float m() {
        f12 f12Var = this.q;
        if (f12Var == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / f12Var.i()) / Math.abs(this.i);
    }

    public float n() {
        f12 f12Var = this.q;
        if (f12Var == null) {
            return 0.0f;
        }
        float f = this.p;
        return f == 2.1474836E9f ? f12Var.f() : f;
    }

    public float o() {
        f12 f12Var = this.q;
        if (f12Var == null) {
            return 0.0f;
        }
        float f = this.o;
        return f == -2.1474836E9f ? f12Var.p() : f;
    }

    public float p() {
        return this.i;
    }

    public final boolean q() {
        return p() < 0.0f;
    }

    public void r() {
        u();
        c();
    }

    public void s() {
        this.r = true;
        f(q());
        z((int) (q() ? n() : o()));
        this.k = 0L;
        this.n = 0;
        t();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.j) {
            return;
        }
        this.j = false;
        x();
    }

    public void t() {
        if (isRunning()) {
            v(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void u() {
        v(true);
    }

    public void v(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.r = false;
        }
    }

    public void w() {
        this.r = true;
        t();
        this.k = 0L;
        if (q() && l() == o()) {
            z(n());
        } else if (!q() && l() == n()) {
            z(o());
        }
        e();
    }

    public void x() {
        D(-p());
    }

    public void y(f12 f12Var) {
        boolean z = this.q == null;
        this.q = f12Var;
        if (z) {
            B(Math.max(this.o, f12Var.p()), Math.min(this.p, f12Var.f()));
        } else {
            B((int) f12Var.p(), (int) f12Var.f());
        }
        float f = this.m;
        this.m = 0.0f;
        this.l = 0.0f;
        z((int) f);
        g();
    }

    public void z(float f) {
        if (this.l == f) {
            return;
        }
        float fB = ot2.b(f, o(), n());
        this.l = fB;
        if (this.s) {
            fB = (float) Math.floor(fB);
        }
        this.m = fB;
        this.k = 0L;
        g();
    }
}

package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import defpackage.dq0;
import defpackage.no0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class uj0 extends ho0 {
    public static final v21 G = new a("indicatorLevel");
    public boolean A;
    public final ValueAnimator B;
    public ValueAnimator C;
    public TimeInterpolator D;
    public TimeInterpolator E;
    public TimeInterpolator F;
    public no0 w;
    public final dd4 x;
    public final no0.a y;
    public float z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends v21 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str) {
            super(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)F */
        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(uj0 uj0Var) {
            return uj0Var.F() * 10000.0f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;F)V */
        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(uj0 uj0Var, float f) {
            uj0Var.M(f / 10000.0f);
            uj0Var.H((int) f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uj0(Context context, final oi oiVar, no0 no0Var) {
        super(context, oiVar);
        this.A = false;
        K(no0Var);
        no0.a aVar = new no0.a();
        this.y = aVar;
        aVar.h = true;
        dd4 dd4Var = new dd4(this, G);
        this.x = dd4Var;
        dd4Var.w(new ed4().f(1.0f).h(50.0f));
        ValueAnimator valueAnimator = new ValueAnimator();
        this.B = valueAnimator;
        valueAnimator.setDuration(1000L);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sj0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                uj0.v(this.a, oiVar, valueAnimator2);
            }
        });
        if (oiVar.b(true) && oiVar.m != 0) {
            valueAnimator.start();
        }
        p(1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uj0 B(Context context, ju juVar, eu euVar) {
        return new uj0(context, juVar, euVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uj0 C(Context context, nt1 nt1Var, jt1 jt1Var) {
        return new uj0(context, nt1Var, jt1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void v(uj0 uj0Var, oi oiVar, ValueAnimator valueAnimator) {
        uj0Var.getClass();
        if (oiVar.b(true) && oiVar.m != 0 && uj0Var.isVisible()) {
            uj0Var.invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(dq0.p pVar) {
        this.x.b(pVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float D(int i) {
        float f = i;
        oi oiVar = this.g;
        return (f < oiVar.o * 10000.0f || f > oiVar.p * 10000.0f) ? 0.0f : 1.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public no0 E() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float F() {
        return this.y.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G() {
        if (this.C != null) {
            return;
        }
        Context context = this.f;
        int i = mk3.O;
        TimeInterpolator timeInterpolator = k7.a;
        this.E = lu2.g(context, i, timeInterpolator);
        this.F = lu2.g(this.f, mk3.J, timeInterpolator);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.C = valueAnimator;
        valueAnimator.setDuration(500L);
        this.C.setFloatValues(0.0f, 1.0f);
        this.C.setInterpolator(null);
        this.C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tj0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                uj0 uj0Var = this.a;
                uj0Var.y.e = uj0Var.D.getInterpolation(uj0Var.C.getAnimatedFraction());
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(int i) {
        if (this.g.b(true)) {
            G();
            float fD = D(i);
            float f = this.z;
            ValueAnimator valueAnimator = this.C;
            if (fD == f) {
                if (valueAnimator.isRunning()) {
                    return;
                }
                J(fD);
                return;
            }
            if (valueAnimator.isRunning()) {
                this.C.cancel();
            }
            this.z = fD;
            if (fD == 1.0f) {
                this.D = this.E;
                this.C.start();
            } else {
                this.D = this.F;
                this.C.reverse();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(dq0.p pVar) {
        this.x.h(pVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J(float f) {
        this.y.e = f;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K(no0 no0Var) {
        this.w = no0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L(boolean z) {
        if (z && !this.B.isRunning()) {
            this.B.start();
        } else {
            if (z || !this.B.isRunning()) {
                return;
            }
            this.B.cancel();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(float f) {
        this.y.b = f;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(float f) {
        setLevel((int) (f * 10000.0f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(float f) {
        this.g.p = f;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(float f) {
        this.g.o = f;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q() {
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        if (iWidth <= 0 || iHeight <= 0) {
            return;
        }
        boolean z = this.w instanceof jt1;
        dd4 dd4Var = this.x;
        if (z) {
            dd4Var.k(10000.0f / iWidth);
        } else {
            dd4Var.k((float) (10000.0d / (((double) Math.min(iHeight, iWidth)) * 3.141592653589793d)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.u)) {
            canvas.save();
            this.w.h(canvas, getBounds(), h(), m(), l());
            this.y.f = i();
            this.s.setStyle(Paint.Style.FILL);
            this.s.setAntiAlias(true);
            no0.a aVar = this.y;
            oi oiVar = this.g;
            aVar.c = oiVar.e[0];
            int iA = oiVar.i;
            no0 no0Var = this.w;
            if (iA > 0) {
                if (!(no0Var instanceof jt1)) {
                    iA = (int) ((iA * r62.a(F(), 0.0f, 0.01f)) / 0.01f);
                }
                this.w.d(canvas, this.s, F(), 1.0f, this.g.f, getAlpha(), iA);
            } else {
                no0Var.d(canvas, this.s, 0.0f, 1.0f, oiVar.f, getAlpha(), 0);
            }
            this.w.c(canvas, this.s, this.y, getAlpha());
            this.w.b(canvas, this.s, this.g.e[0], getAlpha());
            canvas.restore();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.w.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.w.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.x.x();
        M(getLevel() / 10000.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ void o(h6 h6Var) {
        super.o(h6Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        float fD = D(i);
        if (this.A) {
            this.x.x();
            M(i / 10000.0f);
            J(fD);
            return true;
        }
        Q();
        this.x.m(F() * 10000.0f);
        this.x.r(i);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean s(boolean z, boolean z2, boolean z3) {
        return super.s(z, z2, z3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public boolean t(boolean z, boolean z2, boolean z3) {
        boolean zT = super.t(z, z2, z3);
        float fA = this.h.a(this.f.getContentResolver());
        if (fA == 0.0f) {
            this.A = true;
            return zT;
        }
        this.A = false;
        this.x.t().h(50.0f / fA);
        return zT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean u(h6 h6Var) {
        return super.u(h6Var);
    }
}

package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ho0 extends Drawable implements Animatable {
    public static final Property v = new c(Float.class, "growFraction");
    public final Context f;
    public final oi g;
    public ValueAnimator i;
    public ValueAnimator j;
    public boolean k;
    public boolean l;
    public float m;
    public List o;
    public h6 p;
    public boolean q;
    public float r;
    public int t;
    public float n = -1.0f;
    public final Paint s = new Paint();
    public Rect u = new Rect();
    public m7 h = new m7();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ho0.this.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ho0.super.setVisible(false, false);
            ho0.this.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends Property {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ho0 ho0Var) {
            return Float.valueOf(ho0Var.h());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ho0 ho0Var, Float f) {
            ho0Var.p(f.floatValue());
        }
    }

    public ho0(Context context, oi oiVar) {
        this.f = context;
        this.g = oiVar;
        setAlpha(255);
    }

    public final void d(ValueAnimator... valueAnimatorArr) {
        boolean z = this.q;
        this.q = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.q = z;
    }

    public final void e() {
        h6 h6Var = this.p;
        if (h6Var != null) {
            h6Var.b(this);
        }
        List list = this.o;
        if (list == null || this.q) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((h6) it.next()).b(this);
        }
    }

    public final void f() {
        h6 h6Var = this.p;
        if (h6Var != null) {
            h6Var.c(this);
        }
        List list = this.o;
        if (list == null || this.q) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((h6) it.next()).c(this);
        }
    }

    public final void g(ValueAnimator... valueAnimatorArr) {
        boolean z = this.q;
        this.q = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.q = z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        if (this.g.d() || this.g.c()) {
            return (this.l || this.k) ? this.m : this.r;
        }
        return 1.0f;
    }

    public float i() {
        float f = this.n;
        if (f > 0.0f) {
            return f;
        }
        if (this.g.b(k()) && this.g.m != 0) {
            float fA = this.h.a(this.f.getContentResolver());
            if (fA > 0.0f) {
                boolean zK = k();
                oi oiVar = this.g;
                float fUptimeMillis = (SystemClock.uptimeMillis() % ((long) r6)) / ((int) ((((zK ? oiVar.j : oiVar.k) * 1000.0f) / this.g.m) * fA));
                return fUptimeMillis < 0.0f ? (fUptimeMillis % 1.0f) + 1.0f : fUptimeMillis;
            }
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return m() || l();
    }

    public boolean j() {
        return s(false, false, false);
    }

    public final boolean k() {
        return this instanceof uj0;
    }

    public boolean l() {
        ValueAnimator valueAnimator = this.j;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.l;
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.i;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.k;
    }

    public final void n() {
        if (this.i == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<ho0, Float>) v, 0.0f, 1.0f);
            this.i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.i.setInterpolator(k7.b);
            r(this.i);
        }
        if (this.j == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<ho0, Float>) v, 1.0f, 0.0f);
            this.j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.j.setInterpolator(k7.b);
            q(this.j);
        }
    }

    public void o(h6 h6Var) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        if (this.o.contains(h6Var)) {
            return;
        }
        this.o.add(h6Var);
    }

    public void p(float f) {
        if (this.r != f) {
            this.r = f;
            invalidateSelf();
        }
    }

    public final void q(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.j;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            jl.a("Cannot set hideAnimator while the current hideAnimator is running.");
        } else {
            this.j = valueAnimator;
            valueAnimator.addListener(new b());
        }
    }

    public final void r(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.i;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            jl.a("Cannot set showAnimator while the current showAnimator is running.");
        } else {
            this.i = valueAnimator;
            valueAnimator.addListener(new a());
        }
    }

    public boolean s(boolean z, boolean z2, boolean z3) {
        return t(z, z2, z3 && this.h.a(this.f.getContentResolver()) > 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.s.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return s(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        t(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        t(false, true, false);
    }

    public boolean t(boolean z, boolean z2, boolean z3) {
        n();
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator = z ? this.i : this.j;
        ValueAnimator valueAnimator2 = z ? this.j : this.i;
        if (!z3) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z4 = !z || super.setVisible(z, false);
        oi oiVar = this.g;
        if (!(z ? oiVar.d() : oiVar.c())) {
            g(valueAnimator);
            return z4;
        }
        if (z2 || !valueAnimator.isPaused()) {
            valueAnimator.start();
            return z4;
        }
        valueAnimator.resume();
        return z4;
    }

    public boolean u(h6 h6Var) {
        List list = this.o;
        if (list == null || !list.contains(h6Var)) {
            return false;
        }
        this.o.remove(h6Var);
        if (!this.o.isEmpty()) {
            return true;
        }
        this.o = null;
        return true;
    }
}

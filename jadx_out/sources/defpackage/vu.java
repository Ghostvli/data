package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vu extends ss0 {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;
    public final View.OnClickListener j;
    public final View.OnFocusChangeListener k;
    public AnimatorSet l;
    public ValueAnimator m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            vu.this.b.c0(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            vu.this.b.c0(false);
        }
    }

    public vu(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.j = new View.OnClickListener() { // from class: qu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                vu.v(this.f, view);
            }
        };
        this.k = new View.OnFocusChangeListener() { // from class: ru
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                vu vuVar = this.a;
                vuVar.A(vuVar.E());
            }
        };
        this.e = lu2.f(aVar.getContext(), mk3.H, 100);
        this.f = lu2.f(aVar.getContext(), mk3.H, 150);
        this.g = lu2.g(aVar.getContext(), mk3.M, k7.a);
        this.h = lu2.g(aVar.getContext(), mk3.L, k7.d);
    }

    public static /* synthetic */ void v(vu vuVar, View view) {
        EditText editText = vuVar.i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        vuVar.r();
    }

    public static /* synthetic */ void x(vu vuVar, ValueAnimator valueAnimator) {
        vuVar.getClass();
        vuVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(vu vuVar, ValueAnimator valueAnimator) {
        vuVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        vuVar.d.setScaleX(fFloatValue);
        vuVar.d.setScaleY(fFloatValue);
    }

    public final void A(boolean z) {
        boolean z2 = this.b.H() == z;
        if (z && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z2) {
                this.l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.l.cancel();
        this.m.start();
        if (z2) {
            this.m.end();
        }
    }

    public final ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.g);
        valueAnimatorOfFloat.setDuration(this.e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: su
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                vu.x(this.a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: uu
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                vu.y(this.a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    public final boolean E() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }

    @Override // defpackage.ss0
    public void a(Editable editable) {
        if (this.b.y() != null) {
            return;
        }
        A(E());
    }

    @Override // defpackage.ss0
    public int c() {
        return tm3.g;
    }

    @Override // defpackage.ss0
    public int d() {
        return gl3.g;
    }

    @Override // defpackage.ss0
    public View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override // defpackage.ss0
    public View.OnClickListener f() {
        return this.j;
    }

    @Override // defpackage.ss0
    public View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override // defpackage.ss0
    public void n(EditText editText) {
        this.i = editText;
        this.a.setEndIconVisible(E());
    }

    @Override // defpackage.ss0
    public void q(boolean z) {
        if (this.b.y() == null) {
            return;
        }
        A(z);
    }

    @Override // defpackage.ss0
    public void s() {
        D();
    }

    @Override // defpackage.ss0
    public void u() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: tu
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.A(true);
                }
            });
        }
    }
}

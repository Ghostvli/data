package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pp0 extends ss0 {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final View.OnClickListener i;
    public final View.OnFocusChangeListener j;
    public final AccessibilityManager.TouchExplorationStateChangeListener k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            pp0.this.r();
            pp0.this.r.start();
        }
    }

    public pp0(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.i = new View.OnClickListener() { // from class: lp0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.J();
            }
        };
        this.j = new View.OnFocusChangeListener() { // from class: mp0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                pp0.y(this.a, view, z);
            }
        };
        this.k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: np0
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                pp0.w(this.a, z);
            }
        };
        this.o = Long.MAX_VALUE;
        this.f = lu2.f(aVar.getContext(), mk3.H, 67);
        this.e = lu2.f(aVar.getContext(), mk3.H, 50);
        this.g = lu2.g(aVar.getContext(), mk3.M, k7.a);
    }

    public static /* synthetic */ void A(pp0 pp0Var) {
        pp0Var.K();
        pp0Var.H(false);
    }

    public static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        zt2.a("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        return null;
    }

    private void F() {
        this.r = E(this.f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.e, 1.0f, 0.0f);
        this.q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    public static /* synthetic */ void v(pp0 pp0Var) {
        boolean zIsPopupShowing = pp0Var.h.isPopupShowing();
        pp0Var.H(zIsPopupShowing);
        pp0Var.m = zIsPopupShowing;
    }

    public static /* synthetic */ void w(pp0 pp0Var, boolean z) {
        AutoCompleteTextView autoCompleteTextView = pp0Var.h;
        if (autoCompleteTextView == null || rq0.a(autoCompleteTextView)) {
            return;
        }
        pp0Var.d.setImportantForAccessibility(z ? 2 : 1);
    }

    public static /* synthetic */ void x(pp0 pp0Var, ValueAnimator valueAnimator) {
        pp0Var.getClass();
        pp0Var.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(pp0 pp0Var, View view, boolean z) {
        pp0Var.l = z;
        pp0Var.r();
        if (z) {
            return;
        }
        pp0Var.H(false);
        pp0Var.m = false;
    }

    public static /* synthetic */ boolean z(pp0 pp0Var, View view, MotionEvent motionEvent) {
        pp0Var.getClass();
        if (motionEvent.getAction() == 1) {
            if (pp0Var.G()) {
                pp0Var.m = false;
            }
            pp0Var.J();
            pp0Var.K();
        }
        return false;
    }

    public final ValueAnimator E(int i, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.g);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ip0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                pp0.x(this.a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final boolean G() {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.o;
        return jUptimeMillis < 0 || jUptimeMillis > 300;
    }

    public final void H(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    public final void I() {
        this.h.setOnTouchListener(new View.OnTouchListener() { // from class: jp0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return pp0.z(this.f, view, motionEvent);
            }
        });
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: kp0
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                pp0.A(this.a);
            }
        });
        this.h.setThreshold(0);
    }

    public final void J() {
        if (this.h == null) {
            return;
        }
        if (G()) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        H(!this.n);
        boolean z = this.n;
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (!z) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            this.h.showDropDown();
        }
    }

    public final void K() {
        this.m = true;
        this.o = SystemClock.uptimeMillis();
    }

    @Override // defpackage.ss0
    public void a(Editable editable) {
        if (this.p.isTouchExplorationEnabled() && rq0.a(this.h) && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new Runnable() { // from class: op0
            @Override // java.lang.Runnable
            public final void run() {
                pp0.v(this.f);
            }
        });
    }

    @Override // defpackage.ss0
    public int c() {
        return tm3.i;
    }

    @Override // defpackage.ss0
    public int d() {
        return gl3.f;
    }

    @Override // defpackage.ss0
    public View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override // defpackage.ss0
    public View.OnClickListener f() {
        return this.i;
    }

    @Override // defpackage.ss0
    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.k;
    }

    @Override // defpackage.ss0
    public boolean i(int i) {
        return i != 0;
    }

    @Override // defpackage.ss0
    public boolean j() {
        return true;
    }

    @Override // defpackage.ss0
    public boolean k() {
        return this.l;
    }

    @Override // defpackage.ss0
    public boolean l() {
        return true;
    }

    @Override // defpackage.ss0
    public boolean m() {
        return this.n;
    }

    @Override // defpackage.ss0
    public void n(EditText editText) {
        this.h = D(editText);
        I();
        this.a.setErrorIconDrawable((Drawable) null);
        if (!rq0.a(editText) && this.p.isTouchExplorationEnabled()) {
            this.d.setImportantForAccessibility(2);
        }
        this.a.setEndIconVisible(true);
    }

    @Override // defpackage.ss0
    public void o(View view, g2 g2Var) {
        if (!rq0.a(this.h)) {
            g2Var.l0(Spinner.class.getName());
        }
        if (g2Var.V()) {
            g2Var.x0(null);
        }
    }

    @Override // defpackage.ss0
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.p.isEnabled() || rq0.a(this.h)) {
            return;
        }
        boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z) {
            J();
            K();
        }
    }

    @Override // defpackage.ss0
    public void s() {
        F();
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // defpackage.ss0
    public boolean t() {
        return true;
    }

    @Override // defpackage.ss0
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }
}

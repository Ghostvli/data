package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import defpackage.c30;
import defpackage.k7;
import defpackage.ld1;
import defpackage.lu2;
import defpackage.md1;
import defpackage.mk3;
import defpackage.nd1;
import defpackage.pd1;
import defpackage.ug4;
import defpackage.w82;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {
    public static final int t = mk3.C;
    public static final int u = mk3.F;
    public static final int v = mk3.L;
    public pd1 f;
    public AccessibilityManager g;
    public AccessibilityManager.TouchExplorationStateChangeListener h;
    public boolean i;
    public final LinkedHashSet j;
    public int k;
    public int l;
    public TimeInterpolator m;
    public TimeInterpolator n;
    public int o;
    public int p;
    public int q;
    public ViewPropertyAnimator r;
    public boolean s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideViewOnScrollBehavior.this.h == null || HideViewOnScrollBehavior.this.g == null) {
                return;
            }
            HideViewOnScrollBehavior.this.g.removeTouchExplorationStateChangeListener(HideViewOnScrollBehavior.this.h);
            HideViewOnScrollBehavior.this.h = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideViewOnScrollBehavior.this.r = null;
        }
    }

    public HideViewOnScrollBehavior() {
        this.i = true;
        this.j = new LinkedHashSet();
        this.o = 0;
        this.p = 2;
        this.q = 0;
        this.s = false;
    }

    public static /* synthetic */ void K(HideViewOnScrollBehavior hideViewOnScrollBehavior, View view, boolean z) {
        if (hideViewOnScrollBehavior.i && z && hideViewOnScrollBehavior.U()) {
            hideViewOnScrollBehavior.X(view);
        }
    }

    private void P(View view, int i, long j, TimeInterpolator timeInterpolator) {
        this.r = this.f.d(view, i).setInterpolator(timeInterpolator).setDuration(j).setListener(new b());
    }

    private void Q(final View view) {
        if (this.g == null) {
            this.g = (AccessibilityManager) c30.i(view.getContext(), AccessibilityManager.class);
        }
        if (this.g == null || this.h != null) {
            return;
        }
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: od1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                HideViewOnScrollBehavior.K(this.a, view, z);
            }
        };
        this.h = touchExplorationStateChangeListener;
        this.g.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        view.addOnAttachStateChangeListener(new a());
    }

    private void b0(View view, int i) {
        this.p = i;
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public final boolean R(int i) {
        return i == 80 || i == 81;
    }

    public final boolean S(int i) {
        return i == 3 || i == 19;
    }

    public boolean T() {
        return this.p == 2;
    }

    public boolean U() {
        return this.p == 1;
    }

    public final void V(View view, int i) {
        if (this.s) {
            return;
        }
        int i2 = ((CoordinatorLayout.f) view.getLayoutParams()).c;
        if (R(i2)) {
            W(1);
        } else {
            W(S(Gravity.getAbsoluteGravity(i2, i)) ? 2 : 0);
        }
    }

    public final void W(int i) {
        pd1 pd1Var = this.f;
        if (pd1Var == null || pd1Var.c() != i) {
            if (i == 0) {
                this.f = new nd1();
                return;
            }
            if (i == 1) {
                this.f = new ld1();
            } else if (i == 2) {
                this.f = new md1();
            } else {
                ug4.a("Invalid view edge position value: ", i, ". Must be 0, 1 or 2.");
            }
        }
    }

    public void X(View view) {
        Y(view, true);
    }

    public void Y(View view, boolean z) {
        if (T()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.r;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        b0(view, 2);
        int iB = this.f.b();
        if (z) {
            P(view, iB, this.k, this.m);
        } else {
            this.f.e(view, iB);
        }
    }

    public void Z(View view) {
        a0(view, true);
    }

    public void a0(View view, boolean z) {
        AccessibilityManager accessibilityManager;
        if (U()) {
            return;
        }
        if (this.i && (accessibilityManager = this.g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.r;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        b0(view, 1);
        int i = this.o + this.q;
        if (z) {
            P(view, i, this.l, this.n);
        } else {
            this.f.e(view, i);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i) {
        Q(view);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        V(view, i);
        this.o = this.f.a(view, marginLayoutParams);
        this.k = lu2.f(view.getContext(), t, 225);
        this.l = lu2.f(view.getContext(), u, Token.COMMENT);
        Context context = view.getContext();
        int i2 = v;
        this.m = lu2.g(context, i2, k7.d);
        this.n = lu2.g(view.getContext(), i2, k7.c);
        return super.r(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            Z(view);
        } else if (i2 < 0) {
            X(view);
        }
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = true;
        this.j = new LinkedHashSet();
        this.o = 0;
        this.p = 2;
        this.q = 0;
        this.s = false;
    }
}

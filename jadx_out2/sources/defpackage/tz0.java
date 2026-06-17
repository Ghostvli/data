package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ss4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class tz0 extends s55 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tz0(int i) {
        m0(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float o0(gt4 gt4Var, float f) {
        Float f2;
        return (gt4Var == null || (f2 = (Float) gt4Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s55, defpackage.ss4
    public void i(gt4 gt4Var) {
        super.i(gt4Var);
        Float fValueOf = (Float) gt4Var.b.getTag(kl3.d);
        if (fValueOf == null) {
            fValueOf = gt4Var.b.getVisibility() == 0 ? Float.valueOf(g55.b(gt4Var.b)) : Float.valueOf(0.0f);
        }
        gt4Var.a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s55
    public Animator j0(ViewGroup viewGroup, View view, gt4 gt4Var, gt4 gt4Var2) {
        g55.c(view);
        return n0(view, o0(gt4Var, 0.0f), 1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s55
    public Animator l0(ViewGroup viewGroup, View view, gt4 gt4Var, gt4 gt4Var2) {
        g55.c(view);
        Animator animatorN0 = n0(view, o0(gt4Var, 1.0f), 0.0f);
        if (animatorN0 == null) {
            g55.e(view, o0(gt4Var2, 1.0f));
        }
        return animatorN0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Animator n0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        g55.e(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) g55.b, f2);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        y().a(aVar);
        return objectAnimatorOfFloat;
    }

    public tz0() {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends AnimatorListenerAdapter implements ss4.g {
        public final View a;
        public boolean b = false;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(View view) {
            this.a = view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void a(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void b(ss4 ss4Var) {
            this.a.setTag(kl3.d, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void c(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void e(ss4 ss4Var) {
            this.a.setTag(kl3.d, Float.valueOf(this.a.getVisibility() == 0 ? g55.b(this.a) : 0.0f));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void f(ss4 ss4Var, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void g(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            g55.e(this.a, 1.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (this.b) {
                this.a.setLayerType(0, null);
            }
            if (z) {
                return;
            }
            g55.e(this.a, 1.0f);
            g55.a(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a.hasOverlappingRendering() && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }
    }
}

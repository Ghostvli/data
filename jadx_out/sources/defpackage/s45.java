package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s45 {
    public final WeakReference a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ u45 a;
        public final /* synthetic */ View b;

        public a(u45 u45Var, View view) {
            this.a = u45Var;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.c(this.b);
        }
    }

    public s45(View view) {
        this.a = new WeakReference(view);
    }

    public s45 b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void c() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public s45 e(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public s45 f(Interpolator interpolator) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public s45 g(u45 u45Var) {
        View view = (View) this.a.get();
        if (view != null) {
            h(view, u45Var);
        }
        return this;
    }

    public final void h(View view, u45 u45Var) {
        if (u45Var != null) {
            view.animate().setListener(new a(u45Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public s45 i(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public s45 j(final w45 w45Var) {
        final View view = (View) this.a.get();
        if (view != null) {
            view.animate().setUpdateListener(w45Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: r45
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    w45Var.a(view);
                }
            } : null);
        }
        return this;
    }

    public void k() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public s45 l(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}

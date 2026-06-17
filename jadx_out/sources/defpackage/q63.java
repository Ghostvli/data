package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q63 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View f;
    public ViewTreeObserver g;
    public final Runnable h;

    public q63(View view, Runnable runnable) {
        this.f = view;
        this.g = view.getViewTreeObserver();
        this.h = runnable;
    }

    public static q63 a(View view, Runnable runnable) {
        if (view == null) {
            om1.a("view == null");
            return null;
        }
        if (runnable == null) {
            om1.a("runnable == null");
            return null;
        }
        q63 q63Var = new q63(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(q63Var);
        view.addOnAttachStateChangeListener(q63Var);
        return q63Var;
    }

    public void b() {
        if (this.g.isAlive()) {
            this.g.removeOnPreDrawListener(this);
        } else {
            this.f.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.h.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.g = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}

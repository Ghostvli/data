package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.oy0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c {
    public int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View f;
        public final /* synthetic */ int g;
        public final /* synthetic */ oy0 h;

        public a(View view, int i, oy0 oy0Var) {
            this.f = view;
            this.g = i;
            this.h = oy0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f == this.g) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                oy0 oy0Var = this.h;
                expandableBehavior.N((View) oy0Var, this.f, oy0Var.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f = 0;
    }

    public final boolean L(boolean z) {
        int i = this.f;
        return z ? i == 0 || i == 2 : i == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oy0 M(CoordinatorLayout coordinatorLayout, View view) {
        List listR = coordinatorLayout.r(view);
        int size = listR.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) listR.get(i);
            if (k(coordinatorLayout, view, view2)) {
                return (oy0) view2;
            }
        }
        return null;
    }

    public abstract boolean N(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean k(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
        oy0 oy0Var = (oy0) view2;
        if (!L(oy0Var.a())) {
            return false;
        }
        this.f = oy0Var.a() ? 1 : 2;
        return N((View) oy0Var, view, oy0Var.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i) {
        oy0 oy0VarM;
        if (view.isLaidOut() || (oy0VarM = M(coordinatorLayout, view)) == null || !L(oy0VarM.a())) {
            return false;
        }
        int i2 = oy0VarM.a() ? 1 : 2;
        this.f = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i2, oy0VarM));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
    }
}

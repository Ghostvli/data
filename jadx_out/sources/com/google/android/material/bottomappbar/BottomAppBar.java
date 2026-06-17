package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.ak3;
import defpackage.mk3;
import defpackage.w82;
import defpackage.ym3;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final int c0 = ym3.s;
    public static final int d0 = mk3.C;
    public static final int e0 = mk3.L;

    public static /* synthetic */ void T(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static /* synthetic */ View U(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static /* synthetic */ boolean W(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static /* synthetic */ void X(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        throw null;
    }

    public static /* synthetic */ int Y(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static void Z(BottomAppBar bottomAppBar, View view) {
        ((CoordinatorLayout.f) view.getLayoutParams()).d = 17;
        throw null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect u;
        public WeakReference v;
        public int w;
        public final View.OnLayoutChangeListener x;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                w82.a(Behavior.this.v.get());
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.x = new a();
            this.u = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            w82.a(view);
            return a0(coordinatorLayout, null, view2, view3, i, i2);
        }

        public boolean Z(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.v = new WeakReference(bottomAppBar);
            View viewU = BottomAppBar.U(bottomAppBar);
            if (viewU != null && !viewU.isLaidOut()) {
                BottomAppBar.Z(bottomAppBar, viewU);
                this.w = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewU.getLayoutParams())).bottomMargin;
                if (viewU instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewU;
                    if (BottomAppBar.Y(bottomAppBar) == 0 && BottomAppBar.W(bottomAppBar)) {
                        floatingActionButton.setElevation(0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(ak3.b);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(ak3.a);
                    }
                    BottomAppBar.X(bottomAppBar, floatingActionButton);
                }
                viewU.addOnLayoutChangeListener(this.x);
                BottomAppBar.T(bottomAppBar);
            }
            coordinatorLayout.I(bottomAppBar, i);
            return super.r(coordinatorLayout, bottomAppBar, i);
        }

        public boolean a0(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            throw null;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, View view, int i) {
            w82.a(view);
            return Z(coordinatorLayout, null, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.x = new a();
            this.u = new Rect();
        }
    }
}

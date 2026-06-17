package com.fongmi.android.tv.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CustomFabBehavior extends FloatingActionButton.Behavior {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends FloatingActionButton.b {
        public final /* synthetic */ FloatingActionButton a;

        public a(FloatingActionButton floatingActionButton) {
            this.a = floatingActionButton;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            this.a.setVisibility(4);
        }
    }

    public CustomFabBehavior() {
    }

    public final void S(FloatingActionButton floatingActionButton) {
        floatingActionButton.h(new a(floatingActionButton));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public void z(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        super.z(coordinatorLayout, floatingActionButton, view, i, i2, i3, i4, i5, iArr);
        if ("top".equals(floatingActionButton.getTag())) {
            if (i2 > 0 && floatingActionButton.getVisibility() == 4) {
                floatingActionButton.l();
                return;
            } else {
                if (i2 >= 0 || floatingActionButton.getVisibility() != 0) {
                    return;
                }
                S(floatingActionButton);
                return;
            }
        }
        if (i2 > 0 && floatingActionButton.getVisibility() == 0) {
            S(floatingActionButton);
        } else {
            if (i2 >= 0 || floatingActionButton.getVisibility() != 4) {
                return;
            }
            floatingActionButton.l();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public boolean G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, View view2, int i, int i2) {
        return i == 2 || super.G(coordinatorLayout, floatingActionButton, view, view2, i, i2);
    }

    public CustomFabBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

package defpackage;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cj {
    public cj(SwipeDismissBehavior swipeDismissBehavior) {
        swipeDismissBehavior.R(0.1f);
        swipeDismissBehavior.Q(0.6f);
        swipeDismissBehavior.S(0);
    }

    public boolean a(View view) {
        return false;
    }

    public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                r94.b().e(null);
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            r94.b().f(null);
        }
    }
}

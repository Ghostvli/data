package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zc1 extends m45 {
    public Runnable i;
    public OverScroller j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public VelocityTracker o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final CoordinatorLayout f;
        public final View g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(CoordinatorLayout coordinatorLayout, View view) {
            this.f = coordinatorLayout;
            this.g = view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.g == null || (overScroller = zc1.this.j) == null) {
                return;
            }
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            zc1 zc1Var = zc1.this;
            if (!zComputeScrollOffset) {
                zc1Var.T(this.f, this.g);
            } else {
                zc1Var.V(this.f, this.g, zc1Var.j.getCurrY());
                this.g.postOnAnimation(this);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zc1() {
        this.l = -1;
        this.n = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.o;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.o.computeCurrentVelocity(1000);
                P(coordinatorLayout, view, -R(view), 0, this.o.getYVelocity(this.l));
                z = true;
            }
            this.k = false;
            this.l = -1;
            velocityTracker = this.o;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.o = null;
            }
            velocityTracker2 = this.o;
            if (velocityTracker2 != null) {
            }
            if (this.k) {
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.l);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int i = this.m - y;
            this.m = y;
            U(coordinatorLayout, view, i, Q(view), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.l = motionEvent.getPointerId(i2);
                this.m = (int) (motionEvent.getY(i2) + 0.5f);
            }
        }
        z = false;
        velocityTracker2 = this.o;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.k || z;
        z = false;
        this.k = false;
        this.l = -1;
        velocityTracker = this.o;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.o;
        if (velocityTracker2 != null) {
        }
        if (this.k) {
        }
    }

    public abstract boolean N(View view);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O() {
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P(CoordinatorLayout coordinatorLayout, View view, int i, int i2, float f) {
        Runnable runnable = this.i;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.i = null;
        }
        if (this.j == null) {
            this.j = new OverScroller(view.getContext());
        }
        this.j.fling(0, K(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.j.computeScrollOffset()) {
            T(coordinatorLayout, view);
            return false;
        }
        a aVar = new a(coordinatorLayout, view);
        this.i = aVar;
        view.postOnAnimation(aVar);
        return true;
    }

    public abstract int Q(View view);

    public abstract int R(View view);

    public abstract int S();

    public abstract void T(CoordinatorLayout coordinatorLayout, View view);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int U(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return W(coordinatorLayout, view, S() - i, i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int V(CoordinatorLayout coordinatorLayout, View view, int i) {
        return W(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int W(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.n < 0) {
            this.n = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.k) {
            int i = this.l;
            if (i == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.m) > this.n) {
                this.m = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.l = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = N(view) && coordinatorLayout.B(view, x, y2);
            this.k = z;
            if (z) {
                this.m = y2;
                this.l = motionEvent.getPointerId(0);
                O();
                OverScroller overScroller = this.j;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.j.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.o;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public zc1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = -1;
        this.n = -1;
    }
}

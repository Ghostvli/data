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

        public a(CoordinatorLayout coordinatorLayout, View view) {
            this.f = coordinatorLayout;
            this.g = view;
        }

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

    public zc1() {
        this.l = -1;
        this.n = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean J(androidx.coordinatorlayout.widget.CoordinatorLayout r10, android.view.View r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            int r1 = r12.getActionMasked()
            r6 = -1
            r7 = 0
            r8 = 1
            if (r1 == r8) goto L4d
            r3 = 2
            if (r1 == r3) goto L2d
            r2 = 3
            if (r1 == r2) goto L71
            r2 = 6
            if (r1 == r2) goto L13
            goto L4b
        L13:
            int r1 = r12.getActionIndex()
            if (r1 != 0) goto L1b
            r1 = r8
            goto L1c
        L1b:
            r1 = r7
        L1c:
            int r2 = r12.getPointerId(r1)
            r9.l = r2
            float r1 = r12.getY(r1)
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r2
            int r1 = (int) r1
            r9.m = r1
            goto L4b
        L2d:
            int r1 = r9.l
            int r1 = r12.findPointerIndex(r1)
            if (r1 != r6) goto L36
            return r7
        L36:
            float r1 = r12.getY(r1)
            int r1 = (int) r1
            int r3 = r9.m
            int r3 = r3 - r1
            r9.m = r1
            int r4 = r9.Q(r11)
            r5 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.U(r1, r2, r3, r4, r5)
        L4b:
            r1 = r7
            goto L80
        L4d:
            android.view.VelocityTracker r1 = r9.o
            if (r1 == 0) goto L71
            r1.addMovement(r12)
            android.view.VelocityTracker r1 = r9.o
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            android.view.VelocityTracker r1 = r9.o
            int r3 = r9.l
            float r5 = r1.getYVelocity(r3)
            int r1 = r9.R(r11)
            int r3 = -r1
            r4 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.P(r1, r2, r3, r4, r5)
            r1 = r8
            goto L72
        L71:
            r1 = r7
        L72:
            r9.k = r7
            r9.l = r6
            android.view.VelocityTracker r2 = r9.o
            if (r2 == 0) goto L80
            r2.recycle()
            r2 = 0
            r9.o = r2
        L80:
            android.view.VelocityTracker r2 = r9.o
            if (r2 == 0) goto L87
            r2.addMovement(r12)
        L87:
            boolean r0 = r9.k
            if (r0 != 0) goto L8f
            if (r1 == 0) goto L8e
            goto L8f
        L8e:
            return r7
        L8f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zc1.J(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract boolean N(View view);

    public final void O() {
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
    }

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

    public final int U(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return W(coordinatorLayout, view, S() - i, i2, i3);
    }

    public int V(CoordinatorLayout coordinatorLayout, View view, int i) {
        return W(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int W(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3);

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

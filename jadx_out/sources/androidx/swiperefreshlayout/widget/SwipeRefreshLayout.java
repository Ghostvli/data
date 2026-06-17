package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.bu;
import defpackage.c30;
import defpackage.iu;
import defpackage.l23;
import defpackage.l35;
import defpackage.m23;
import defpackage.n23;
import defpackage.o23;
import defpackage.p23;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements o23, n23, l23 {
    public static final String U = "SwipeRefreshLayout";
    public static final int[] V = {R.attr.enabled};
    public bu A;
    public int B;
    public int C;
    public float D;
    public int E;
    public int F;
    public int G;
    public iu H;
    public Animation I;
    public Animation J;
    public Animation K;
    public Animation L;
    public Animation M;
    public boolean N;
    public int O;
    public boolean P;
    public boolean Q;
    public Animation.AnimationListener R;
    public final Animation S;
    public final Animation T;
    public View f;
    public j g;
    public boolean h;
    public int i;
    public float j;
    public float k;
    public final p23 l;
    public final m23 m;
    public final int[] n;
    public final int[] o;
    public final int[] p;
    public boolean q;
    public int r;
    public int s;
    public float t;
    public float u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public final DecelerateInterpolator z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.h) {
                swipeRefreshLayout.t();
                return;
            }
            swipeRefreshLayout.H.setAlpha(255);
            SwipeRefreshLayout.this.H.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.N && (jVar = swipeRefreshLayout2.g) != null) {
                jVar.q();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.s = swipeRefreshLayout3.A.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends Animation {
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public d(int i, int i2) {
            this.f = i;
            this.g = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.H.setAlpha((int) (this.f + ((this.g - r0) * f)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.x) {
                return;
            }
            swipeRefreshLayout.A(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.P ? swipeRefreshLayout.F - Math.abs(swipeRefreshLayout.E) : swipeRefreshLayout.F;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.C + ((int) ((iAbs - r1) * f))) - swipeRefreshLayout2.A.getTop());
            SwipeRefreshLayout.this.H.e(1.0f - f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.r(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f2 = swipeRefreshLayout.D;
            swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
            SwipeRefreshLayout.this.r(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface i {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface j {
        void q();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.j = -1.0f;
        this.n = new int[2];
        this.o = new int[2];
        this.p = new int[2];
        this.w = -1;
        this.B = -1;
        this.R = new a();
        this.S = new f();
        this.T = new g();
        this.i = ViewConfiguration.get(context).getScaledTouchSlop();
        this.r = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.z = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O = (int) (displayMetrics.density * 40.0f);
        e();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.F = i2;
        this.j = i2;
        this.l = new p23(this);
        this.m = new m23(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.O;
        this.s = i3;
        this.E = i3;
        r(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void s(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.w) {
            this.w = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void setColorViewAlpha(int i2) {
        this.A.getBackground().setAlpha(i2);
        this.H.setAlpha(i2);
    }

    public void A(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.J = cVar;
        cVar.setDuration(150L);
        this.A.b(animationListener);
        this.A.clearAnimation();
        this.A.startAnimation(this.J);
    }

    public final void B(int i2, Animation.AnimationListener animationListener) {
        this.C = i2;
        this.D = this.A.getScaleX();
        h hVar = new h();
        this.M = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.M);
    }

    public final void C(Animation.AnimationListener animationListener) {
        this.A.setVisibility(0);
        this.H.setAlpha(255);
        b bVar = new b();
        this.I = bVar;
        bVar.setDuration(this.r);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.I);
    }

    public final void b(int i2, Animation.AnimationListener animationListener) {
        this.C = i2;
        this.S.reset();
        this.S.setDuration(200L);
        this.S.setInterpolator(this.z);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.S);
    }

    public final void c(int i2, Animation.AnimationListener animationListener) {
        if (this.x) {
            B(i2, animationListener);
            return;
        }
        this.C = i2;
        this.T.reset();
        this.T.setDuration(200L);
        this.T.setInterpolator(this.z);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.T);
    }

    public boolean d() {
        View view = this.f;
        return view instanceof ListView ? ((ListView) view).canScrollList(-1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 285) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v(true, true);
        return true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.m.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.m.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.m.c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.m.f(i2, i3, i4, i5, iArr);
    }

    public final void e() {
        this.A = new bu(getContext());
        iu iuVar = new iu(getContext());
        this.H = iuVar;
        iuVar.l(1);
        this.A.setImageDrawable(this.H);
        this.A.setVisibility(8);
        addView(this.A);
    }

    public void f(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        if (i6 == 0) {
            this.m.e(i2, i3, i4, i5, iArr, i6, iArr2);
        }
    }

    public final void g() {
        if (this.f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.A)) {
                    this.f = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.B;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.l.a();
    }

    public int getProgressCircleDiameter() {
        return this.O;
    }

    public int getProgressViewEndOffset() {
        return this.F;
    }

    public int getProgressViewStartOffset() {
        return this.E;
    }

    public final void h(float f2) {
        if (f2 > this.j) {
            u(true, true);
            return;
        }
        this.h = false;
        this.H.j(0.0f, 0.0f);
        c(this.s, !this.x ? new e() : null);
        this.H.d(false);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.m.j();
    }

    public final boolean i(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.m.l();
    }

    @Override // defpackage.o23
    public void j(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 != 0) {
            return;
        }
        int i7 = iArr[1];
        f(i2, i3, i4, i5, this.o, i6, iArr);
        int i8 = i5 - (iArr[1] - i7);
        if ((i8 == 0 ? i5 + this.o[1] : i8) >= 0 || d()) {
            return;
        }
        float fAbs = this.k + Math.abs(r14);
        this.k = fAbs;
        q(fAbs);
        iArr[1] = iArr[1] + i8;
    }

    @Override // defpackage.n23
    public void k(View view, int i2, int i3, int i4, int i5, int i6) {
        j(view, i2, i3, i4, i5, i6, this.p);
    }

    @Override // defpackage.n23
    public boolean l(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(view, view2, i2);
        }
        return false;
    }

    @Override // defpackage.n23
    public void m(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // defpackage.n23
    public void n(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // defpackage.n23
    public void o(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.g()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.y
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.y = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L81
            boolean r1 = r4.y
            if (r1 != 0) goto L81
            boolean r1 = r4.d()
            if (r1 != 0) goto L81
            boolean r1 = r4.h
            if (r1 != 0) goto L81
            boolean r1 = r4.q
            if (r1 == 0) goto L29
            goto L81
        L29:
            if (r0 == 0) goto L5d
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L58
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L58
            r1 = 6
            if (r0 == r1) goto L39
            goto L7e
        L39:
            r4.s(r5)
            goto L7e
        L3d:
            int r0 = r4.w
            if (r0 != r3) goto L49
            java.lang.String r4 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.U
            java.lang.String r5 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r4, r5)
            return r2
        L49:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L50
            return r2
        L50:
            float r5 = r5.getY(r0)
            r4.x(r5)
            goto L7e
        L58:
            r4.v = r2
            r4.w = r3
            goto L7e
        L5d:
            int r0 = r4.E
            bu r1 = r4.A
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.w = r0
            r4.v = r2
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L78
            return r2
        L78:
            float r5 = r5.getY(r0)
            r4.u = r5
        L7e:
            boolean r4 = r4.v
            return r4
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f == null) {
            g();
        }
        View view = this.f;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.A.getMeasuredWidth();
        int measuredHeight2 = this.A.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.s;
        this.A.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f == null) {
            g();
        }
        View view = this.f;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), Buffer.MAX_SIZE));
        this.A.measure(View.MeasureSpec.makeMeasureSpec(this.O, Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec(this.O, Buffer.MAX_SIZE));
        this.B = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.A) {
                this.B = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.k;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = (int) f2;
                    this.k = 0.0f;
                } else {
                    this.k = f2 - f3;
                    iArr[1] = i3;
                }
                q(this.k);
            }
        }
        if (this.P && i3 > 0 && this.k == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.A.setVisibility(8);
        }
        int[] iArr2 = this.n;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        j(view, i2, i3, i4, i5, 0, this.p);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.l.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.k = 0.0f;
        this.q = true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        setRefreshing(kVar.f);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new k(super.onSaveInstanceState(), this.h);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.y || this.h || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.l.d(view);
        this.q = false;
        float f2 = this.k;
        if (f2 > 0.0f) {
            h(f2);
            this.k = 0.0f;
        } else {
            post(new Runnable() { // from class: pj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.t();
                }
            });
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.y && actionMasked == 0) {
            this.y = false;
        }
        if (!isEnabled() || this.y || d() || this.h || this.q) {
            return false;
        }
        if (actionMasked == 0) {
            this.w = motionEvent.getPointerId(0);
            this.v = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.w);
                if (iFindPointerIndex < 0) {
                    Log.e(U, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.v) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.t) * 0.5f;
                    this.v = false;
                    h(y);
                }
                this.w = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.w);
                if (iFindPointerIndex2 < 0) {
                    Log.e(U, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                x(y2);
                if (this.v) {
                    float f2 = (y2 - this.t) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    q(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(U, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.w = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    s(motionEvent);
                }
            }
        }
        return true;
    }

    public boolean p() {
        return this.h;
    }

    public final void q(float f2) {
        float f3;
        this.H.d(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.j));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.j;
        int i2 = this.G;
        if (i2 > 0) {
            f3 = i2;
        } else {
            boolean z = this.P;
            int i3 = this.F;
            if (z) {
                i3 -= this.E;
            }
            f3 = i3;
        }
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i4 = this.E + ((int) ((f3 * fMin) + (f3 * fPow * 2.0f)));
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
        }
        if (!this.x) {
            this.A.setScaleX(1.0f);
            this.A.setScaleY(1.0f);
        }
        if (this.x) {
            setAnimationProgress(Math.min(1.0f, f2 / this.j));
        }
        float f4 = this.j;
        iu iuVar = this.H;
        if (f2 < f4) {
            if (iuVar.getAlpha() > 76 && !i(this.K)) {
                z();
            }
        } else if (iuVar.getAlpha() < 255 && !i(this.L)) {
            y();
        }
        this.H.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.H.e(Math.min(1.0f, fMax));
        this.H.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i4 - this.s);
    }

    public void r(float f2) {
        setTargetOffsetTopAndBottom((this.C + ((int) ((this.E - r0) * f2))) - this.A.getTop());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        View view;
        if (!this.Q || (view = this.f) == null || l35.O(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setAnimationProgress(float f2) {
        this.A.setScaleX(f2);
        this.A.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        g();
        this.H.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = c30.b(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.j = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        t();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.Q = z;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.m.m(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.g = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.A.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(c30.b(getContext(), i2));
    }

    public void setRefreshing(boolean z) {
        v(z, false);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.O = (int) (displayMetrics.density * 56.0f);
            } else {
                this.O = (int) (displayMetrics.density * 40.0f);
            }
            this.A.setImageDrawable(null);
            this.H.l(i2);
            this.A.setImageDrawable(this.H);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.G = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.A.bringToFront();
        l35.S(this.A, i2);
        this.s = this.A.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.m.o(i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.m.q();
    }

    public void t() {
        this.A.clearAnimation();
        this.H.stop();
        this.A.setVisibility(8);
        setColorViewAlpha(255);
        if (this.x) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.E - this.s);
        }
        this.s = this.A.getTop();
    }

    public final void u(boolean z, boolean z2) {
        if (this.h != z) {
            this.N = z2;
            g();
            this.h = z;
            if (z) {
                b(this.s, this.R);
            } else {
                A(this.R);
            }
        }
    }

    public final void v(boolean z, boolean z2) {
        if (!z || this.h == z) {
            u(z, false);
            return;
        }
        this.h = z;
        boolean z3 = this.P;
        int i2 = this.F;
        if (!z3) {
            i2 += this.E;
        }
        setTargetOffsetTopAndBottom(i2 - this.s);
        this.N = z2;
        C(this.R);
    }

    public final Animation w(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.A.b(null);
        this.A.clearAnimation();
        this.A.startAnimation(dVar);
        return dVar;
    }

    public final void x(float f2) {
        float f3 = this.u;
        float f4 = f2 - f3;
        int i2 = this.i;
        if (f4 <= i2 || this.v) {
            return;
        }
        this.t = f3 + i2;
        this.v = true;
        this.H.setAlpha(76);
    }

    public final void y() {
        this.L = w(this.H.getAlpha(), 255);
    }

    public final void z() {
        this.K = w(this.H.getAlpha(), 76);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k extends View.BaseSavedState {
        public static final Parcelable.Creator<k> CREATOR = new a();
        public final boolean f;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i) {
                return new k[i];
            }
        }

        public k(Parcel parcel) {
            super(parcel);
            this.f = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        }

        public k(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f = z;
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }
}

package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.i;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.e04;
import defpackage.l35;
import defpackage.lk1;
import defpackage.n23;
import defpackage.nb0;
import defpackage.nk3;
import defpackage.o23;
import defpackage.ob0;
import defpackage.p23;
import defpackage.pl3;
import defpackage.w95;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements nb0, n23, o23 {
    public static final int[] L = {nk3.b, R.attr.windowContentOverlay};
    public static final w95 M = new w95.a().d(lk1.c(0, 1, 0, 1)).a();
    public static final Rect N = new Rect();
    public w95 A;
    public w95 B;
    public w95 C;
    public d D;
    public OverScroller E;
    public ViewPropertyAnimator F;
    public final AnimatorListenerAdapter G;
    public final Runnable H;
    public final Runnable I;
    public final p23 J;
    public final f K;
    public int f;
    public int g;
    public ContentFrameLayout h;
    public ActionBarContainer i;
    public ob0 j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public final Rect r;
    public final Rect s;
    public final Rect t;
    public final Rect u;
    public final Rect v;
    public final Rect w;
    public final Rect x;
    public final Rect y;
    public w95 z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.o = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.o = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.i.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.i.animate().translationY(-ActionBarOverlayLayout.this.i.getHeight()).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a();

        void b();

        void c(boolean z);

        void d();

        void e();

        void onWindowVisibilityChanged(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends View {
        public f(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.x = new Rect();
        this.y = new Rect();
        w95 w95Var = w95.b;
        this.z = w95Var;
        this.A = w95Var;
        this.B = w95Var;
        this.C = w95Var;
        this.G = new a();
        this.H = new b();
        this.I = new c();
        w(context);
        this.J = new p23(this);
        f fVar = new f(context);
        this.K = fVar;
        addView(fVar);
    }

    public void A() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(pl3.b);
            this.i = (ActionBarContainer) findViewById(pl3.c);
            this.j = u(findViewById(pl3.a));
        }
    }

    public final void B() {
        v();
        this.H.run();
    }

    public final boolean C(float f2) {
        this.E.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.E.getFinalY() > this.i.getHeight();
    }

    @Override // defpackage.nb0
    public void a(Menu menu, i.a aVar) {
        A();
        this.j.a(menu, aVar);
    }

    @Override // defpackage.nb0
    public boolean b() {
        A();
        return this.j.b();
    }

    @Override // defpackage.nb0
    public void c() {
        A();
        this.j.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // defpackage.nb0
    public boolean d() {
        A();
        return this.j.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.k != null) {
            int bottom = this.i.getVisibility() == 0 ? (int) (this.i.getBottom() + this.i.getTranslationY() + 0.5f) : 0;
            this.k.setBounds(0, bottom, getWidth(), this.k.getIntrinsicHeight() + bottom);
            this.k.draw(canvas);
        }
    }

    @Override // defpackage.nb0
    public boolean e() {
        A();
        return this.j.e();
    }

    @Override // defpackage.nb0
    public boolean f() {
        A();
        return this.j.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // defpackage.nb0
    public boolean g() {
        A();
        return this.j.g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.i;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.J.a();
    }

    public CharSequence getTitle() {
        A();
        return this.j.getTitle();
    }

    @Override // defpackage.nb0
    public void h(int i) {
        A();
        if (i == 2) {
            this.j.u();
        } else if (i == 5) {
            this.j.v();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // defpackage.nb0
    public void i() {
        A();
        this.j.h();
    }

    @Override // defpackage.o23
    public void j(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        k(view, i, i2, i3, i4, i5);
    }

    @Override // defpackage.n23
    public void k(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // defpackage.n23
    public boolean l(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // defpackage.n23
    public void m(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // defpackage.n23
    public void n(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // defpackage.n23
    public void o(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        A();
        w95 w95VarX = w95.x(windowInsets, this);
        boolean zQ = q(this.i, new Rect(w95VarX.j(), w95VarX.l(), w95VarX.k(), w95VarX.i()), true, true, false, true);
        l35.f(this, w95VarX, this.r);
        Rect rect = this.r;
        w95 w95VarM = w95VarX.m(rect.left, rect.top, rect.right, rect.bottom);
        this.z = w95VarM;
        boolean z = true;
        if (!this.A.equals(w95VarM)) {
            this.A = this.z;
            zQ = true;
        }
        if (this.s.equals(this.r)) {
            z = zQ;
        } else {
            this.s.set(this.r);
        }
        if (z) {
            requestLayout();
        }
        return w95VarX.a().c().b().v();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w(getContext());
        l35.d0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        A();
        measureChildWithMargins(this.i, i, 0, i2, 0);
        e eVar = (e) this.i.getLayoutParams();
        int iMax = Math.max(0, this.i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.i.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.i.getMeasuredState());
        boolean z = (l35.H(this) & Buffer.DEFAULT_SIZE) != 0;
        if (z) {
            measuredHeight = this.f;
            if (this.m && this.i.getTabContainer() != null) {
                measuredHeight += this.f;
            }
        } else {
            measuredHeight = this.i.getVisibility() != 8 ? this.i.getMeasuredHeight() : 0;
        }
        this.t.set(this.r);
        this.B = this.z;
        if (this.l || z || !r()) {
            this.B = new w95.a(this.B).d(lk1.c(this.B.j(), this.B.l() + measuredHeight, this.B.k(), this.B.i())).a();
        } else {
            Rect rect = this.t;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.B = this.B.m(0, measuredHeight, 0, 0);
        }
        q(this.h, this.t, true, true, true, true);
        if (!this.C.equals(this.B)) {
            w95 w95Var = this.B;
            this.C = w95Var;
            l35.g(this.h, w95Var);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        e eVar2 = (e) this.h.getLayoutParams();
        int iMax3 = Math.max(iMax, this.h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.n || !z) {
            return false;
        }
        if (C(f3)) {
            p();
        } else {
            B();
        }
        this.o = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.p + i2;
        this.p = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.J.b(view, view2, i);
        this.p = getActionBarHideOffset();
        v();
        d dVar = this.D;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.i.getVisibility() != 0) {
            return false;
        }
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.n && !this.o) {
            if (this.p <= this.i.getHeight()) {
                z();
            } else {
                y();
            }
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        A();
        int i2 = this.q ^ i;
        this.q = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & Buffer.DEFAULT_SIZE) != 0;
        d dVar = this.D;
        if (dVar != null) {
            dVar.c(!z2);
            if (z || !z2) {
                this.D.a();
            } else {
                this.D.d();
            }
        }
        if ((i2 & Buffer.DEFAULT_SIZE) == 0 || this.D == null) {
            return;
        }
        l35.d0(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        d dVar = this.D;
        if (dVar != null) {
            dVar.onWindowVisibilityChanged(i);
        }
    }

    public final void p() {
        v();
        this.I.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.View r2, android.graphics.Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        /*
            r1 = this;
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r1 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r1
            r2 = 1
            if (r4 == 0) goto L13
            int r4 = r1.leftMargin
            int r0 = r3.left
            if (r4 == r0) goto L13
            r1.leftMargin = r0
            r4 = r2
            goto L14
        L13:
            r4 = 0
        L14:
            if (r5 == 0) goto L1f
            int r5 = r1.topMargin
            int r0 = r3.top
            if (r5 == r0) goto L1f
            r1.topMargin = r0
            r4 = r2
        L1f:
            if (r7 == 0) goto L2a
            int r5 = r1.rightMargin
            int r7 = r3.right
            if (r5 == r7) goto L2a
            r1.rightMargin = r7
            r4 = r2
        L2a:
            if (r6 == 0) goto L35
            int r5 = r1.bottomMargin
            int r3 = r3.bottom
            if (r5 == r3) goto L35
            r1.bottomMargin = r3
            return r2
        L35:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    public final boolean r() {
        l35.f(this.K, M, this.u);
        return !this.u.equals(N);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    public void setActionBarHideOffset(int i) {
        v();
        this.i.setTranslationY(-Math.max(0, Math.min(i, this.i.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.D = dVar;
        if (getWindowToken() != null) {
            this.D.onWindowVisibilityChanged(this.g);
            int i = this.q;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                l35.d0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (z) {
                return;
            }
            v();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        A();
        this.j.setIcon(i);
    }

    public void setLogo(int i) {
        A();
        this.j.m(i);
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // defpackage.nb0
    public void setWindowCallback(Window.Callback callback) {
        A();
        this.j.setWindowCallback(callback);
    }

    @Override // defpackage.nb0
    public void setWindowTitle(CharSequence charSequence) {
        A();
        this.j.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ob0 u(View view) {
        if (view instanceof ob0) {
            return (ob0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        e04.a("Can't make a decor toolbar out of ".concat(view.getClass().getSimpleName()));
        return null;
    }

    public void v() {
        removeCallbacks(this.H);
        removeCallbacks(this.I);
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void w(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(L);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.k = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.E = new OverScroller(context);
    }

    public boolean x() {
        return this.l;
    }

    public final void y() {
        v();
        postDelayed(this.I, 600L);
    }

    public final void z() {
        v();
        postDelayed(this.H, 600L);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i, int i2) {
            super(i, i2);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public void setIcon(Drawable drawable) {
        A();
        this.j.setIcon(drawable);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }
}

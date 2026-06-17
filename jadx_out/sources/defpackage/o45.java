package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.internal.Buffer;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o45 extends ViewGroup {
    public static final int[] k0 = {R.attr.layout_gravity};
    public static final Comparator l0 = new a();
    public static final Interpolator m0 = new b();
    public static final n n0 = new n();
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public float I;
    public float J;
    public float K;
    public float L;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public EdgeEffect T;
    public EdgeEffect U;
    public boolean V;
    public boolean W;
    public boolean a0;
    public int b0;
    public List c0;
    public j d0;
    public j e0;
    public int f;
    public List f0;
    public final ArrayList g;
    public int g0;
    public final f h;
    public ArrayList h0;
    public final Rect i;
    public final Runnable i0;
    public f73 j;
    public int j0;
    public int k;
    public int l;
    public Parcelable m;
    public ClassLoader n;
    public Scroller o;
    public boolean p;
    public k q;
    public int r;
    public Drawable s;
    public int t;
    public int u;
    public float v;
    public float w;
    public int x;
    public int y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.b - fVar2.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o45.this.setScrollState(0);
            o45.this.D();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements d63 {
        public final Rect a = new Rect();

        public d() {
        }

        @Override // defpackage.d63
        public w95 a(View view, w95 w95Var) {
            w95 w95VarT = l35.T(view, w95Var);
            if (w95VarT.o()) {
                return w95VarT;
            }
            Rect rect = this.a;
            rect.left = w95VarT.j();
            rect.top = w95VarT.l();
            rect.right = w95VarT.k();
            rect.bottom = w95VarT.i();
            int childCount = o45.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                w95 w95VarG = l35.g(o45.this.getChildAt(i), w95VarT);
                rect.left = Math.min(w95VarG.j(), rect.left);
                rect.top = Math.min(w95VarG.l(), rect.top);
                rect.right = Math.min(w95VarG.k(), rect.right);
                rect.bottom = Math.min(w95VarG.i(), rect.bottom);
            }
            return w95VarT.p(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends r1 {
        public h() {
        }

        @Override // defpackage.r1
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            f73 f73Var;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(o45.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (f73Var = o45.this.j) == null) {
                return;
            }
            accessibilityEvent.setItemCount(f73Var.c());
            accessibilityEvent.setFromIndex(o45.this.k);
            accessibilityEvent.setToIndex(o45.this.k);
        }

        @Override // defpackage.r1
        public void g(View view, g2 g2Var) {
            super.g(view, g2Var);
            g2Var.l0(o45.class.getName());
            g2Var.H0(n());
            if (o45.this.canScrollHorizontally(1)) {
                g2Var.a(Buffer.SEGMENTING_THRESHOLD);
            }
            if (o45.this.canScrollHorizontally(-1)) {
                g2Var.a(8192);
            }
        }

        @Override // defpackage.r1
        public boolean j(View view, int i, Bundle bundle) {
            if (super.j(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!o45.this.canScrollHorizontally(1)) {
                    return false;
                }
                o45 o45Var = o45.this;
                o45Var.setCurrentItem(o45Var.k + 1);
                return true;
            }
            if (i != 8192 || !o45.this.canScrollHorizontally(-1)) {
                return false;
            }
            o45 o45Var2 = o45.this;
            o45Var2.setCurrentItem(o45Var2.k - 1);
            return true;
        }

        public final boolean n() {
            f73 f73Var = o45.this.j;
            return f73Var != null && f73Var.c() > 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface i {
        void a(o45 o45Var, f73 f73Var, f73 f73Var2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface j {
        void a(int i, float f, int i2);

        void b(int i);

        void c(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class k extends DataSetObserver {
        public k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            o45.this.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            o45.this.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m implements j {
        @Override // o45.j
        public void a(int i, float f, int i2) {
        }

        @Override // o45.j
        public void b(int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class n implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.a;
            return z != gVar2.a ? z ? 1 : -1 : gVar.e - gVar2.e;
        }
    }

    public o45(Context context) {
        super(context);
        this.g = new ArrayList();
        this.h = new f();
        this.i = new Rect();
        this.l = -1;
        this.m = null;
        this.n = null;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.i0 = new c();
        this.j0 = 0;
        u();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.A != z) {
            this.A = z;
        }
    }

    public static boolean v(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    public boolean A() {
        f73 f73Var = this.j;
        if (f73Var == null || this.k >= f73Var.c() - 1) {
            return false;
        }
        M(this.k + 1, true);
        return true;
    }

    public final boolean B(int i2) {
        if (this.g.size() == 0) {
            if (this.V) {
                return false;
            }
            this.a0 = false;
            x(0, 0.0f, 0);
            if (this.a0) {
                return false;
            }
            e04.a("onPageScrolled did not call superclass implementation");
            return false;
        }
        f fVarS = s();
        int clientWidth = getClientWidth();
        int i3 = this.r;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarS.b;
        float f3 = ((i2 / f2) - fVarS.e) / (fVarS.d + (i3 / f2));
        this.a0 = false;
        x(i5, f3, (int) (i4 * f3));
        if (this.a0) {
            return true;
        }
        e04.a("onPageScrolled did not call superclass implementation");
        return false;
    }

    public final boolean C(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.I - f2;
        this.I = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.v * clientWidth;
        float f5 = this.w * clientWidth;
        boolean z3 = false;
        f fVar = (f) this.g.get(0);
        ArrayList arrayList = this.g;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.b != 0) {
            f4 = fVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.b != this.j.c() - 1) {
            f5 = fVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.T.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.U.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.I += scrollX - i2;
        scrollTo(i2, getScrollY());
        B(i2);
        return z3;
    }

    public void D() {
        E(this.k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc A[PHI: r7 r10 r15
      0x00cc: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E(int r18) {
        /*
            Method dump skipped, instruction units count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o45.E(int):void");
    }

    public final void F(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.g.isEmpty()) {
            if (!this.o.isFinished()) {
                this.o.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        f fVarT = t(this.k);
        int iMin = (int) ((fVarT != null ? Math.min(fVarT.e, this.w) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            g(false);
            scrollTo(iMin, getScrollY());
        }
    }

    public final void G() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public void H(i iVar) {
        List list = this.f0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void I(j jVar) {
        List list = this.c0;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public final void J(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final boolean K() {
        this.M = -1;
        n();
        this.T.onRelease();
        this.U.onRelease();
        return this.T.isFinished() || this.U.isFinished();
    }

    public final void L(int i2, boolean z, int i3, boolean z2) {
        f fVarT = t(i2);
        int clientWidth = fVarT != null ? (int) (getClientWidth() * Math.max(this.v, Math.min(fVarT.e, this.w))) : 0;
        if (z) {
            P(clientWidth, 0, i3);
            if (z2) {
                k(i2);
                return;
            }
            return;
        }
        if (z2) {
            k(i2);
        }
        g(false);
        scrollTo(clientWidth, 0);
        B(clientWidth);
    }

    public void M(int i2, boolean z) {
        this.B = false;
        N(i2, z, false);
    }

    public void N(int i2, boolean z, boolean z2) {
        O(i2, z, z2, 0);
    }

    public void O(int i2, boolean z, boolean z2, int i3) {
        f73 f73Var = this.j;
        if (f73Var == null || f73Var.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.k == i2 && this.g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.j.c()) {
            i2 = this.j.c() - 1;
        }
        int i4 = this.C;
        int i5 = this.k;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.g.size(); i6++) {
                ((f) this.g.get(i6)).c = true;
            }
        }
        boolean z3 = this.k != i2;
        if (!this.V) {
            E(i2);
            L(i2, z, i3, z3);
        } else {
            this.k = i2;
            if (z3) {
                k(i2);
            }
            requestLayout();
        }
    }

    public void P(int i2, int i3, int i4) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.o;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            boolean z = this.p;
            Scroller scroller2 = this.o;
            scrollX = z ? scroller2.getCurrX() : scroller2.getStartX();
            this.o.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            g(false);
            D();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fM = f3 + (m(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fM / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.j.f(this.k)) + this.r)) + 1.0f) * 100.0f), 600);
        this.p = false;
        this.o.startScroll(i5, scrollY, i6, i7, iMin);
        l35.X(this);
    }

    public final void Q() {
        if (this.g0 != 0) {
            ArrayList arrayList = this.h0;
            if (arrayList == null) {
                this.h0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.h0.add(getChildAt(i2));
            }
            Collections.sort(this.h0, n0);
        }
    }

    public f a(int i2, int i3) {
        f fVar = new f();
        fVar.b = i2;
        fVar.a = this.j.g(this, i2);
        fVar.d = this.j.f(i2);
        if (i3 < 0 || i3 >= this.g.size()) {
            this.g.add(fVar);
            return fVar;
        }
        this.g.add(i3, fVar);
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        f fVarR;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.k) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        f fVarR;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.k) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zV = gVar.a | v(view);
        gVar.a = zV;
        if (!this.z) {
            super.addView(view, i2, layoutParams);
        } else if (zV) {
            e04.a("Cannot add pager decor view during layout");
        } else {
            gVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.f0 == null) {
            this.f0 = new ArrayList();
        }
        this.f0.add(iVar);
    }

    public void c(j jVar) {
        if (this.c0 == null) {
            this.c0 = new ArrayList();
        }
        this.c0.add(jVar);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.j == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.v)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.w));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.p = true;
        if (this.o.isFinished() || !this.o.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.o.getCurrX();
        int currY = this.o.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!B(currX)) {
                this.o.abortAnimation();
                scrollTo(0, currY);
            }
        }
        l35.X(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(int r5) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o45.d(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || o(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarR;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        f73 f73Var;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (f73Var = this.j) != null && f73Var.c() > 1)) {
            if (!this.T.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.v * width);
                this.T.setSize(height, width);
                zDraw = this.T.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.U.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.w + 1.0f)) * width2);
                this.U.setSize(height2, width2);
                zDraw |= this.U.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.T.finish();
            this.U.finish();
        }
        if (zDraw) {
            l35.X(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.s;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iC = this.j.c();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.r / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.b;
            int i6 = fVar.b;
            if (i5 < i6) {
                float f3 = fVar2.e + fVar2.d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= fVar.b && i8 < this.g.size()) {
                    Object obj = this.g.get(i8);
                    while (true) {
                        fVar4 = (f) obj;
                        if (i7 <= fVar4.b || i8 >= this.g.size() - 1) {
                            break;
                        }
                        i8++;
                        obj = this.g.get(i8);
                    }
                    while (i7 < fVar4.b) {
                        f3 += this.j.f(i7) + f2;
                        i7++;
                    }
                    fVar4.e = f3;
                    f3 += fVar4.d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.g.size() - 1;
                float f4 = fVar2.e;
                while (true) {
                    i5--;
                    if (i5 < fVar.b || size < 0) {
                        break;
                    }
                    Object obj2 = this.g.get(size);
                    while (true) {
                        fVar3 = (f) obj2;
                        if (i5 >= fVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        obj2 = this.g.get(size);
                    }
                    while (i5 > fVar3.b) {
                        f4 -= this.j.f(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.d + f2;
                    fVar3.e = f4;
                }
            }
        }
        int size2 = this.g.size();
        float f5 = fVar.e;
        int i9 = fVar.b;
        int i10 = i9 - 1;
        this.v = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = iC - 1;
        this.w = i9 == i11 ? (fVar.d + f5) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            f fVar5 = (f) this.g.get(i12);
            while (true) {
                i4 = fVar5.b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.j.f(i10) + f2;
                i10--;
            }
            f5 -= fVar5.d + f2;
            fVar5.e = f5;
            if (i4 == 0) {
                this.v = f5;
            }
            i12--;
            i10--;
        }
        float f6 = fVar.e + fVar.d + f2;
        int i13 = fVar.b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            f fVar6 = (f) this.g.get(i14);
            while (true) {
                i3 = fVar6.b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.j.f(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.w = (fVar6.d + f6) - 1.0f;
            }
            fVar6.e = f6;
            f6 += fVar6.d + f2;
            i14++;
            i13++;
        }
        this.W = false;
    }

    public boolean f(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && f(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    public final void g(boolean z) {
        boolean z2 = this.j0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.o.isFinished()) {
                this.o.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.o.getCurrX();
                int currY = this.o.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        B(currX);
                    }
                }
            }
        }
        this.B = false;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            f fVar = (f) this.g.get(i2);
            if (fVar.c) {
                fVar.c = false;
                z2 = true;
            }
        }
        if (z2) {
            Runnable runnable = this.i0;
            if (z) {
                l35.Y(this, runnable);
            } else {
                runnable.run();
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public f73 getAdapter() {
        return this.j;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.g0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) ((View) this.h0.get(i3)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.k;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.r;
    }

    public void h() {
        int iC = this.j.c();
        this.f = iC;
        boolean z = this.g.size() < (this.C * 2) + 1 && this.g.size() < iC;
        int iMax = this.k;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.g.size()) {
            f fVar = (f) this.g.get(i2);
            int iD = this.j.d(fVar.a);
            if (iD != -1) {
                if (iD == -2) {
                    this.g.remove(i2);
                    i2--;
                    if (!z2) {
                        this.j.o(this);
                        z2 = true;
                    }
                    this.j.a(this, fVar.b, fVar.a);
                    int i3 = this.k;
                    if (i3 == fVar.b) {
                        iMax = Math.max(0, Math.min(i3, iC - 1));
                    }
                } else {
                    int i4 = fVar.b;
                    if (i4 != iD) {
                        if (i4 == this.k) {
                            iMax = iD;
                        }
                        fVar.b = iD;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.j.b(this);
        }
        Collections.sort(this.g, l0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                g gVar = (g) getChildAt(i5).getLayoutParams();
                if (!gVar.a) {
                    gVar.c = 0.0f;
                }
            }
            N(iMax, false, true);
            requestLayout();
        }
    }

    public final int i(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.Q || Math.abs(i3) <= this.O) {
            i2 += (int) (f2 + (i2 >= this.k ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.g.size() <= 0) {
            return i2;
        }
        return Math.max(((f) this.g.get(0)).b, Math.min(i2, ((f) this.g.get(r1.size() - 1)).b));
    }

    public final void j(int i2, float f2, int i3) {
        j jVar = this.d0;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List list = this.c0;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = (j) this.c0.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    public final void k(int i2) {
        j jVar = this.d0;
        if (jVar != null) {
            jVar.c(i2);
        }
        List list = this.c0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.c0.get(i3);
                if (jVar2 != null) {
                    jVar2.c(i2);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.c(i2);
        }
    }

    public final void l(int i2) {
        j jVar = this.d0;
        if (jVar != null) {
            jVar.b(i2);
        }
        List list = this.c0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.c0.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    public float m(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public final void n() {
        this.D = false;
        this.E = false;
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.N = null;
        }
    }

    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            return keyEvent.hasModifiers(2) ? z() : d(17);
        }
        if (keyCode == 22) {
            return keyEvent.hasModifiers(2) ? A() : d(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return d(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return d(1);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.i0);
        Scroller scroller = this.o;
        if (scroller != null && !scroller.isFinished()) {
            this.o.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        float f2;
        int i3;
        super.onDraw(canvas);
        if (this.r <= 0 || this.s == null || this.g.size() <= 0 || this.j == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f3 = this.r / width;
        int i4 = 0;
        f fVar = (f) this.g.get(0);
        float f4 = fVar.e;
        int size = this.g.size();
        int i5 = fVar.b;
        int i6 = ((f) this.g.get(size - 1)).b;
        while (i5 < i6) {
            while (true) {
                i2 = fVar.b;
                if (i5 <= i2 || i4 >= size) {
                    break;
                }
                i4++;
                fVar = (f) this.g.get(i4);
            }
            if (i5 == i2) {
                float f5 = fVar.e;
                float f6 = fVar.d;
                f2 = (f5 + f6) * width;
                f4 = f5 + f6 + f3;
            } else {
                float f7 = this.j.f(i5);
                f2 = (f4 + f7) * width;
                f4 += f7 + f3;
            }
            if (this.r + f2 > scrollX) {
                i3 = scrollX;
                this.s.setBounds(Math.round(f2), this.t, Math.round(this.r + f2), this.u);
                this.s.draw(canvas);
            } else {
                i3 = scrollX;
            }
            if (f2 > i3 + r2) {
                return;
            }
            i5++;
            scrollX = i3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            K();
            return false;
        }
        if (action != 0) {
            if (this.D) {
                return true;
            }
            if (this.E) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            this.M = motionEvent.getPointerId(0);
            this.E = false;
            this.p = true;
            this.o.computeScrollOffset();
            if (this.j0 != 2 || Math.abs(this.o.getFinalX() - this.o.getCurrX()) <= this.R) {
                g(false);
                this.D = false;
            } else {
                this.o.abortAnimation();
                this.B = false;
                D();
                this.D = true;
                J(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.M;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.I;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.L);
                if (f2 != 0.0f && !w(this.I, f2) && f(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.I = x2;
                    this.J = y2;
                    this.E = true;
                    return false;
                }
                int i3 = this.H;
                if (fAbs > i3 && fAbs * 0.5f > fAbs2) {
                    this.D = true;
                    J(true);
                    setScrollState(1);
                    float f3 = this.K;
                    float f4 = this.H;
                    this.I = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.J = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.E = true;
                }
                if (this.D && C(x2)) {
                    l35.X(this);
                }
            }
        } else if (action == 6) {
            y(motionEvent);
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        return this.D;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o45.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        g gVar;
        g gVar2;
        int i4;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.G = Math.min(measuredWidth / 10, this.F);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = com.hierynomus.protocol.commons.buffer.Buffer.MAX_SIZE;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.a) {
                int i7 = gVar2.b;
                int i8 = i7 & 7;
                int i9 = i7 & Token.ASSIGN_MOD;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        this.x = View.MeasureSpec.makeMeasureSpec(paddingLeft, com.hierynomus.protocol.commons.buffer.Buffer.MAX_SIZE);
        this.y = View.MeasureSpec.makeMeasureSpec(measuredHeight, com.hierynomus.protocol.commons.buffer.Buffer.MAX_SIZE);
        this.z = true;
        D();
        this.z = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.c), com.hierynomus.protocol.commons.buffer.Buffer.MAX_SIZE), this.y);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f fVarR;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.k && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.c());
        f73 f73Var = this.j;
        if (f73Var != null) {
            f73Var.k(lVar.i, lVar.j);
            N(lVar.h, false, true);
        } else {
            this.l = lVar.h;
            this.m = lVar.i;
            this.n = lVar.j;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        l lVar = new l(super.onSaveInstanceState());
        lVar.h = this.k;
        f73 f73Var = this.j;
        if (f73Var != null) {
            lVar.i = f73Var.l();
        }
        return lVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.r;
            F(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00da  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o45.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final Rect p(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public f q(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return r(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public f r(View view) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            f fVar = (f) this.g.get(i2);
            if (this.j.h(view, fVar.a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.z) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final f s() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.r / clientWidth : 0.0f;
        int i3 = 0;
        boolean z = true;
        f fVar = null;
        int i4 = -1;
        float f4 = 0.0f;
        while (i3 < this.g.size()) {
            f fVar2 = (f) this.g.get(i3);
            if (!z && fVar2.b != (i2 = i4 + 1)) {
                fVar2 = this.h;
                fVar2.e = f2 + f4 + f3;
                fVar2.b = i2;
                fVar2.d = this.j.f(i2);
                i3--;
            }
            f fVar3 = fVar2;
            f2 = fVar3.e;
            float f5 = fVar3.d + f2 + f3;
            if (!z && scrollX < f2) {
                break;
            }
            if (scrollX < f5 || i3 == this.g.size() - 1) {
                return fVar3;
            }
            int i5 = fVar3.b;
            float f6 = fVar3.d;
            i3++;
            i4 = i5;
            f4 = f6;
            fVar = fVar3;
            z = false;
        }
        return fVar;
    }

    public void setAdapter(f73 f73Var) {
        f73 f73Var2 = this.j;
        if (f73Var2 != null) {
            f73Var2.n(null);
            this.j.o(this);
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                f fVar = (f) this.g.get(i2);
                this.j.a(this, fVar.b, fVar.a);
            }
            this.j.b(this);
            this.g.clear();
            G();
            this.k = 0;
            scrollTo(0, 0);
        }
        f73 f73Var3 = this.j;
        this.j = f73Var;
        this.f = 0;
        if (f73Var != null) {
            if (this.q == null) {
                this.q = new k();
            }
            this.j.n(this.q);
            this.B = false;
            boolean z = this.V;
            this.V = true;
            this.f = this.j.c();
            if (this.l >= 0) {
                this.j.k(this.m, this.n);
                N(this.l, false, true);
                this.l = -1;
                this.m = null;
                this.n = null;
            } else if (z) {
                requestLayout();
            } else {
                D();
            }
        }
        List list = this.f0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((i) this.f0.get(i3)).a(this, f73Var3, f73Var);
        }
    }

    public void setCurrentItem(int i2) {
        this.B = false;
        N(i2, !this.V, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.C) {
            this.C = i2;
            D();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.d0 = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.r;
        this.r = i2;
        int width = getWidth();
        F(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.j0 == i2) {
            return;
        }
        this.j0 = i2;
        l(i2);
    }

    public f t(int i2) {
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            f fVar = (f) this.g.get(i3);
            if (fVar.b == i2) {
                return fVar;
            }
        }
        return null;
    }

    public void u() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.o = new Scroller(context, m0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.H = viewConfiguration.getScaledPagingTouchSlop();
        this.O = (int) (400.0f * f2);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new EdgeEffect(context);
        this.U = new EdgeEffect(context);
        this.Q = (int) (25.0f * f2);
        this.R = (int) (2.0f * f2);
        this.F = (int) (f2 * 16.0f);
        l35.g0(this, new h());
        if (l35.v(this) == 0) {
            l35.m0(this, 1);
        }
        l35.p0(this, new d());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s;
    }

    public final boolean w(float f2, float f3) {
        if (f2 >= this.G || f3 <= 0.0f) {
            return f2 > ((float) (getWidth() - this.G)) && f3 < 0.0f;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.b0
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            o45$g r8 = (o45.g) r8
            boolean r9 = r8.a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.j(r12, r13, r14)
            r11.a0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o45.x(int, float, int):void");
    }

    public final void y(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.M) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.I = motionEvent.getX(i2);
            this.M = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean z() {
        int i2 = this.k;
        if (i2 <= 0) {
            return false;
        }
        M(i2 - 1, true);
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(c30.e(getContext(), i2));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        public float c;
        public boolean d;
        public int e;
        public int f;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o45.k0);
            this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }

        public g() {
            super(-1, -1);
            this.c = 0.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l extends p {
        public static final Parcelable.Creator<l> CREATOR = new a();
        public int h;
        public Parcelable i;
        public ClassLoader j;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new l(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i) {
                return new l[i];
            }
        }

        public l(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.h = parcel.readInt();
            this.i = parcel.readParcelable(classLoader);
            this.j = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.h + "}";
        }

        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
            parcel.writeParcelable(this.i, i);
        }

        public l(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public o45(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList();
        this.h = new f();
        this.i = new Rect();
        this.l = -1;
        this.m = null;
        this.n = null;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.i0 = new c();
        this.j0 = 0;
        u();
    }
}

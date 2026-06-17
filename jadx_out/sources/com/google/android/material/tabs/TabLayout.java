package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.focus.FocusRingDrawable;
import defpackage.ag;
import defpackage.an4;
import defpackage.cn3;
import defpackage.dn4;
import defpackage.e04;
import defpackage.e55;
import defpackage.e9;
import defpackage.f73;
import defpackage.g2;
import defpackage.gf3;
import defpackage.gm3;
import defpackage.go0;
import defpackage.jl;
import defpackage.k62;
import defpackage.k7;
import defpackage.l35;
import defpackage.l62;
import defpackage.lu2;
import defpackage.m62;
import defpackage.mk3;
import defpackage.mn3;
import defpackage.o45;
import defpackage.o62;
import defpackage.tf3;
import defpackage.tm3;
import defpackage.tn0;
import defpackage.uf3;
import defpackage.uz0;
import defpackage.vf3;
import defpackage.vq0;
import defpackage.wt3;
import defpackage.yf;
import defpackage.ym3;
import defpackage.zk3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int f0 = ym3.n;
    public static final tf3 g0 = new vf3(16);
    public int A;
    public final int B;
    public final int C;
    public final int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public com.google.android.material.tabs.a O;
    public final TimeInterpolator P;
    public c Q;
    public final ArrayList R;
    public c S;
    public ValueAnimator T;
    public o45 U;
    public f73 V;
    public DataSetObserver W;
    public h a0;
    public b b0;
    public boolean c0;
    public int d0;
    public final tf3 e0;
    public int f;
    public final ArrayList g;
    public g h;
    public final f i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final int n;
    public final int o;
    public int p;
    public ColorStateList q;
    public ColorStateList r;
    public ColorStateList s;
    public Drawable t;
    public int u;
    public PorterDuff.Mode v;
    public float w;
    public float x;
    public float y;
    public final int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements o45.i {
        public boolean a;

        public b() {
        }

        @Override // o45.i
        public void a(o45 o45Var, f73 f73Var, f73 f73Var2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.U == o45Var) {
                tabLayout.K(f73Var2, this.a);
            }
        }

        public void b(boolean z) {
            this.a = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void a(g gVar);

        void b(g gVar);

        void c(g gVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d extends c {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.D();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.D();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends LinearLayout {
        public ValueAnimator f;
        public int g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View b;

            public a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        public f(Context context) {
            super(context);
            this.g = -1;
            setWillNotDraw(false);
        }

        public void c(int i, int i2) {
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f != i) {
                this.f.cancel();
            }
            k(true, i, i2);
        }

        public boolean d() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.t.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.t.getIntrinsicHeight();
            }
            int i = TabLayout.this.H;
            if (i == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i != 1) {
                height = 0;
                if (i != 2) {
                    iHeight = i != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.t.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.t.getBounds();
                TabLayout.this.t.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout.this.t.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f == -1) {
                tabLayout.f = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f);
        }

        public final void f(int i) {
            if (TabLayout.this.d0 == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i);
                com.google.android.material.tabs.a aVar = TabLayout.this.O;
                TabLayout tabLayout = TabLayout.this;
                aVar.c(tabLayout, childAt, tabLayout.t);
                TabLayout.this.f = i;
            }
        }

        public final void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        public void h(int i, float f) {
            TabLayout.this.f = Math.round(i + f);
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f.cancel();
            }
            j(getChildAt(i), getChildAt(i + 1), f);
        }

        public void i(int i) {
            Rect bounds = TabLayout.this.t.getBounds();
            TabLayout.this.t.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        public final void j(View view, View view2, float f) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.t;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.t.getBounds().bottom);
            } else {
                com.google.android.material.tabs.a aVar = TabLayout.this.O;
                TabLayout tabLayout = TabLayout.this;
                aVar.d(tabLayout, view, view2, f, tabLayout.t);
            }
            postInvalidateOnAnimation();
        }

        public final void k(boolean z, int i, int i2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f == i) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.f = i;
            a aVar = new a(childAt, childAt2);
            if (!z) {
                this.f.removeAllUpdateListeners();
                this.f.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f = valueAnimator;
            valueAnimator.setInterpolator(TabLayout.this.P);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.start();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.F == 1 || tabLayout.I == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) e55.b(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.F = 0;
                    tabLayout2.S(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g {
        public Object a;
        public Drawable b;
        public CharSequence c;
        public CharSequence d;
        public View f;
        public TabLayout h;
        public i i;
        public int e = -1;
        public int g = 1;
        public int j = -1;

        public View e() {
            return this.f;
        }

        public Drawable f() {
            return this.b;
        }

        public int g() {
            return this.e;
        }

        public int h() {
            return this.g;
        }

        public CharSequence i() {
            return this.c;
        }

        public boolean j() {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                return selectedTabPosition != -1 && selectedTabPosition == this.e;
            }
            jl.a("Tab not attached to a TabLayout");
            return false;
        }

        public void k() {
            this.h = null;
            this.i = null;
            this.a = null;
            this.b = null;
            this.j = -1;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void l() {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                tabLayout.I(this);
            } else {
                jl.a("Tab not attached to a TabLayout");
            }
        }

        public void m(int i) {
            this.e = i;
        }

        public g n(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.i.setContentDescription(charSequence);
            }
            this.c = charSequence;
            o();
            return this;
        }

        public void o() {
            i iVar = this.i;
            if (iVar != null) {
                iVar.p();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h implements o45.j {
        public final WeakReference a;
        public int b;
        public int c;

        public h(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
        }

        @Override // o45.j
        public void a(int i, float f, int i2) {
            boolean z;
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z2 = true;
                if (i3 != 2 || this.b == 1) {
                    z = true;
                } else {
                    z = true;
                    z2 = false;
                }
                if (i3 == 2 && this.b == 0) {
                    z = false;
                }
                tabLayout.N(i, f, z2, z, false);
            }
        }

        @Override // o45.j
        public void b(int i) {
            this.b = this.c;
            this.c = i;
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                tabLayout.T(this.c);
            }
        }

        @Override // o45.j
        public void c(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.J(tabLayout.z(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        public void d() {
            this.c = 0;
            this.b = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class i extends LinearLayout {
        public g f;
        public TextView g;
        public ImageView h;
        public View i;
        public yf j;
        public View k;
        public TextView l;
        public ImageView m;
        public Drawable n;
        public int o;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements View.OnLayoutChangeListener {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.a.getVisibility() == 0) {
                    i.this.o(this.a);
                }
            }
        }

        public i(Context context) {
            super(context);
            this.o = 2;
            q(context);
            setPaddingRelative(TabLayout.this.j, TabLayout.this.k, TabLayout.this.l, TabLayout.this.m);
            setGravity(17);
            setOrientation(!TabLayout.this.J ? 1 : 0);
            setClickable(true);
            l35.q0(this, gf3.b(getContext(), 1002));
        }

        private yf getBadge() {
            return this.j;
        }

        private yf getOrCreateBadge() {
            if (this.j == null) {
                this.j = yf.e(getContext());
            }
            n();
            yf yfVar = this.j;
            if (yfVar != null) {
                return yfVar;
            }
            e04.a("Unable to create badge");
            return null;
        }

        public final void d(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.n;
            if ((drawable == null || !drawable.isStateful()) ? false : this.n.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final float e(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        public final void f(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        public final void g(Canvas canvas) {
            Drawable drawable = this.n;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.n.draw(canvas);
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.g, this.h, this.k};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.g, this.h, this.k};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public g getTab() {
            return this.f;
        }

        public final boolean h() {
            return this.j != null;
        }

        public final void i() {
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(gm3.c, (ViewGroup) this, false);
            this.h = imageView;
            addView(imageView, 0);
        }

        public final void j() {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(gm3.d, (ViewGroup) this, false);
            this.g = textView;
            addView(textView);
        }

        public void k() {
            setTab(null);
            setSelected(false);
        }

        public final void l(View view) {
            if (h() && view != null) {
                f(false);
                ag.b(this.j, view, null);
                this.i = view;
            }
        }

        public final void m() {
            if (h()) {
                f(true);
                View view = this.i;
                if (view != null) {
                    ag.e(this.j, view);
                    this.i = null;
                }
            }
        }

        public final void n() {
            g gVar;
            g gVar2;
            if (h()) {
                if (this.k != null) {
                    m();
                    return;
                }
                if (this.h != null && (gVar2 = this.f) != null && gVar2.f() != null) {
                    View view = this.i;
                    ImageView imageView = this.h;
                    if (view == imageView) {
                        o(imageView);
                        return;
                    } else {
                        m();
                        l(this.h);
                        return;
                    }
                }
                if (this.g == null || (gVar = this.f) == null || gVar.h() != 1) {
                    m();
                    return;
                }
                View view2 = this.i;
                TextView textView = this.g;
                if (view2 == textView) {
                    o(textView);
                } else {
                    m();
                    l(this.g);
                }
            }
        }

        public final void o(View view) {
            if (h() && view == this.i) {
                ag.f(this.j, view, null);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            g2 g2VarP0 = g2.P0(accessibilityNodeInfo);
            yf yfVar = this.j;
            if (yfVar != null && yfVar.isVisible()) {
                g2VarP0.p0(this.j.j());
            }
            g2VarP0.o0(g2.f.a(0, 1, this.f.g(), 1, false, isSelected()));
            if (isSelected()) {
                g2VarP0.m0(false);
                g2VarP0.d0(g2.a.i);
            }
            g2VarP0.F0(getResources().getString(tm3.j));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.A, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.g != null) {
                float f = TabLayout.this.w;
                if (isSelected() && TabLayout.this.p != -1) {
                    f = TabLayout.this.x;
                }
                int i3 = this.o;
                ImageView imageView = this.h;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.g;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.y;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.g.getTextSize();
                int lineCount = this.g.getLineCount();
                int maxLines = this.g.getMaxLines();
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.I != 1 || f <= textSize || lineCount != 1 || ((layout = this.g.getLayout()) != null && e(layout, 0, f) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.g.setTextSize(0, f);
                        this.g.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        public final void p() {
            s();
            g gVar = this.f;
            setSelected(gVar != null && gVar.j());
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f.l();
            return true;
        }

        public final void q(Context context) {
            int i = TabLayout.this.z;
            if (i != 0) {
                Drawable drawableB = e9.b(context, i);
                this.n = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.n.setState(getDrawableState());
                }
            } else {
                this.n = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable drawableD = gradientDrawable;
            if (TabLayout.this.s != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = wt3.a(TabLayout.this.s);
                if (TabLayout.this.N) {
                    drawableD = FocusRingDrawable.D(context, new RippleDrawable(colorStateListA, null, null));
                } else {
                    RippleDrawable rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable, gradientDrawable2);
                    FocusRingDrawable.s(context, rippleDrawable);
                    drawableD = rippleDrawable;
                }
            }
            setBackground(drawableD);
            TabLayout.this.invalidate();
        }

        public final void r() {
            setOrientation(!TabLayout.this.J ? 1 : 0);
            TextView textView = this.l;
            if (textView == null && this.m == null) {
                t(this.g, this.h, true);
            } else {
                t(textView, this.m, false);
            }
        }

        public final void s() {
            ViewParent parent;
            g gVar = this.f;
            View viewE = gVar != null ? gVar.e() : null;
            if (viewE != null) {
                ViewParent parent2 = viewE.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(viewE);
                    }
                    View view = this.k;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.k);
                    }
                    addView(viewE);
                }
                this.k = viewE;
                TextView textView = this.g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.h;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.h.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewE.findViewById(R.id.text1);
                this.l = textView2;
                if (textView2 != null) {
                    this.o = textView2.getMaxLines();
                }
                this.m = (ImageView) viewE.findViewById(R.id.icon);
            } else {
                View view2 = this.k;
                if (view2 != null) {
                    removeView(view2);
                    this.k = null;
                }
                this.l = null;
                this.m = null;
            }
            if (this.k == null) {
                if (this.h == null) {
                    i();
                }
                if (this.g == null) {
                    j();
                    this.o = this.g.getMaxLines();
                }
                an4.m(this.g, TabLayout.this.n);
                if (!isSelected() || TabLayout.this.p == -1) {
                    an4.m(this.g, TabLayout.this.o);
                } else {
                    an4.m(this.g, TabLayout.this.p);
                }
                ColorStateList colorStateList = TabLayout.this.q;
                if (colorStateList != null) {
                    this.g.setTextColor(colorStateList);
                }
                t(this.g, this.h, true);
                n();
                d(this.h);
                d(this.g);
            } else {
                TextView textView3 = this.l;
                if (textView3 != null || this.m != null) {
                    t(textView3, this.m, false);
                }
            }
            if (gVar == null || TextUtils.isEmpty(gVar.d)) {
                return;
            }
            setContentDescription(gVar.d);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.g;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.k;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f) {
                this.f = gVar;
                p();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void t(android.widget.TextView r8, android.widget.ImageView r9, boolean r10) {
            /*
                Method dump skipped, instruction units count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i.t(android.widget.TextView, android.widget.ImageView, boolean):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j implements d {
        public final o45 a;

        public j(o45 o45Var) {
            this.a = o45Var;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.a.setCurrentItem(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f0;
        super(o62.d(context, attributeSet, i2, i3), attributeSet, i2);
        this.f = -1;
        this.g = new ArrayList();
        this.p = -1;
        this.u = 0;
        this.A = Integer.MAX_VALUE;
        this.L = -1;
        this.R = new ArrayList();
        this.e0 = new uf3(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.i = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayI = dn4.i(context2, attributeSet, cn3.t6, i2, i3, cn3.S6);
        ColorStateList colorStateListF = go0.f(getBackground());
        if (colorStateListF != null) {
            l62 l62Var = new l62();
            l62Var.e0(colorStateListF);
            l62Var.S(context2);
            l62Var.d0(getElevation());
            setBackground(l62Var);
        }
        setSelectedTabIndicator(k62.e(context2, typedArrayI, cn3.z6));
        setSelectedTabIndicatorColor(typedArrayI.getColor(cn3.C6, 0));
        fVar.i(typedArrayI.getDimensionPixelSize(cn3.F6, -1));
        setSelectedTabIndicatorGravity(typedArrayI.getInt(cn3.E6, 0));
        setTabIndicatorAnimationMode(typedArrayI.getInt(cn3.B6, 0));
        setTabIndicatorFullWidth(typedArrayI.getBoolean(cn3.D6, true));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(cn3.K6, 0);
        this.m = dimensionPixelSize;
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        this.j = typedArrayI.getDimensionPixelSize(cn3.N6, dimensionPixelSize);
        this.k = typedArrayI.getDimensionPixelSize(cn3.O6, this.k);
        this.l = typedArrayI.getDimensionPixelSize(cn3.M6, this.l);
        this.m = typedArrayI.getDimensionPixelSize(cn3.L6, this.m);
        if (dn4.g(context2)) {
            this.n = mk3.d0;
        } else {
            this.n = mk3.b0;
        }
        int resourceId = typedArrayI.getResourceId(cn3.S6, ym3.f);
        this.o = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, mn3.u2);
        try {
            this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(mn3.v2, 0);
            this.q = k62.b(context2, typedArrayObtainStyledAttributes, mn3.y2);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayI.hasValue(cn3.Q6)) {
                this.p = typedArrayI.getResourceId(cn3.Q6, resourceId);
            }
            int i4 = this.p;
            if (i4 != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i4, mn3.u2);
                try {
                    this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(mn3.v2, (int) this.w);
                    ColorStateList colorStateListB = k62.b(context2, typedArrayObtainStyledAttributes, mn3.y2);
                    if (colorStateListB != null) {
                        this.q = r(this.q.getDefaultColor(), colorStateListB.getColorForState(new int[]{R.attr.state_selected}, colorStateListB.getDefaultColor()));
                    }
                } finally {
                }
            }
            if (typedArrayI.hasValue(cn3.T6)) {
                this.q = k62.b(context2, typedArrayI, cn3.T6);
            }
            if (typedArrayI.hasValue(cn3.R6)) {
                this.q = r(this.q.getDefaultColor(), typedArrayI.getColor(cn3.R6, 0));
            }
            this.r = k62.b(context2, typedArrayI, cn3.x6);
            this.v = e55.g(typedArrayI.getInt(cn3.y6, -1), null);
            this.s = k62.b(context2, typedArrayI, cn3.P6);
            this.G = typedArrayI.getInt(cn3.A6, 300);
            this.P = lu2.g(context2, mk3.L, k7.b);
            this.B = typedArrayI.getDimensionPixelSize(cn3.I6, -1);
            this.C = typedArrayI.getDimensionPixelSize(cn3.H6, -1);
            this.z = typedArrayI.getResourceId(cn3.u6, 0);
            this.E = typedArrayI.getDimensionPixelSize(cn3.v6, 0);
            this.I = typedArrayI.getInt(cn3.J6, 1);
            this.F = typedArrayI.getInt(cn3.w6, 0);
            this.J = typedArrayI.getBoolean(cn3.G6, false);
            this.N = typedArrayI.getBoolean(cn3.U6, false);
            typedArrayI.recycle();
            Resources resources = getResources();
            this.y = resources.getDimensionPixelSize(zk3.m);
            this.D = resources.getDimensionPixelSize(zk3.l);
            o();
        } finally {
        }
    }

    private int getDefaultHeight() {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.g.get(i2);
            if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.i())) {
                return !this.J ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i2 = this.B;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.I;
        if (i3 == 0 || i3 == 2) {
            return this.D;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.i.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public static ColorStateList r(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.i.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.i.getChildAt(i3);
                if ((i3 != i2 || childAt.isSelected()) && (i3 == i2 || !childAt.isSelected())) {
                    childAt.setSelected(i3 == i2);
                    childAt.setActivated(i3 == i2);
                } else {
                    childAt.setSelected(i3 == i2);
                    childAt.setActivated(i3 == i2);
                    if (childAt instanceof i) {
                        ((i) childAt).s();
                    }
                }
                i3++;
            }
        }
    }

    public final boolean A() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    public boolean B() {
        return this.K;
    }

    public g C() {
        g gVarT = t();
        gVarT.h = this;
        gVarT.i = u(gVarT);
        if (gVarT.j != -1) {
            gVarT.i.setId(gVarT.j);
        }
        return gVarT;
    }

    public void D() {
        int currentItem;
        F();
        f73 f73Var = this.V;
        if (f73Var != null) {
            int iC = f73Var.c();
            for (int i2 = 0; i2 < iC; i2++) {
                j(C().n(this.V.e(i2)), false);
            }
            o45 o45Var = this.U;
            if (o45Var == null || iC <= 0 || (currentItem = o45Var.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            I(z(currentItem));
        }
    }

    public boolean E(g gVar) {
        return g0.b(gVar);
    }

    public void F() {
        for (int childCount = this.i.getChildCount() - 1; childCount >= 0; childCount--) {
            H(childCount);
        }
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            it.remove();
            gVar.k();
            E(gVar);
        }
        this.h = null;
    }

    public void G(c cVar) {
        this.R.remove(cVar);
    }

    public final void H(int i2) {
        i iVar = (i) this.i.getChildAt(i2);
        this.i.removeViewAt(i2);
        if (iVar != null) {
            iVar.k();
            this.e0.b(iVar);
        }
        requestLayout();
    }

    public void I(g gVar) {
        J(gVar, true);
    }

    public void J(g gVar, boolean z) {
        g gVar2 = this.h;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                v(gVar);
                m(gVar.g());
                return;
            }
            return;
        }
        int iG = gVar != null ? gVar.g() : -1;
        if (z) {
            if ((gVar2 == null || gVar2.g() == -1) && iG != -1) {
                L(iG, 0.0f, true);
            } else {
                m(iG);
            }
            if (iG != -1) {
                setSelectedTabView(iG);
            }
        }
        this.h = gVar;
        if (gVar2 != null && gVar2.h != null) {
            x(gVar2);
        }
        if (gVar != null) {
            w(gVar);
        }
    }

    public void K(f73 f73Var, boolean z) {
        DataSetObserver dataSetObserver;
        f73 f73Var2 = this.V;
        if (f73Var2 != null && (dataSetObserver = this.W) != null) {
            f73Var2.p(dataSetObserver);
        }
        this.V = f73Var;
        if (z && f73Var != null) {
            if (this.W == null) {
                this.W = new e();
            }
            f73Var.j(this.W);
        }
        D();
    }

    public void L(int i2, float f2, boolean z) {
        M(i2, f2, z, true);
    }

    public void M(int i2, float f2, boolean z, boolean z2) {
        N(i2, f2, z, z2, true);
    }

    public void N(int i2, float f2, boolean z, boolean z2, boolean z3) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.i.getChildCount()) {
            return;
        }
        if (z2) {
            this.i.h(i2, f2);
        }
        ValueAnimator valueAnimator = this.T;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.T.cancel();
        }
        int iP = p(i2, f2);
        int scrollX = getScrollX();
        boolean z4 = (i2 < getSelectedTabPosition() && iP >= scrollX) || (i2 > getSelectedTabPosition() && iP <= scrollX) || i2 == getSelectedTabPosition();
        if (getLayoutDirection() == 1) {
            z4 = (i2 < getSelectedTabPosition() && iP <= scrollX) || (i2 > getSelectedTabPosition() && iP >= scrollX) || i2 == getSelectedTabPosition();
        }
        if (z4 || this.d0 == 1 || z3) {
            if (i2 < 0) {
                iP = 0;
            }
            scrollTo(iP, 0);
        }
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void O(o45 o45Var, boolean z) {
        P(o45Var, z, false);
    }

    public final void P(o45 o45Var, boolean z, boolean z2) {
        o45 o45Var2 = this.U;
        if (o45Var2 != null) {
            h hVar = this.a0;
            if (hVar != null) {
                o45Var2.I(hVar);
            }
            b bVar = this.b0;
            if (bVar != null) {
                this.U.H(bVar);
            }
        }
        c cVar = this.S;
        if (cVar != null) {
            G(cVar);
            this.S = null;
        }
        if (o45Var != null) {
            this.U = o45Var;
            if (this.a0 == null) {
                this.a0 = new h(this);
            }
            this.a0.d();
            o45Var.c(this.a0);
            j jVar = new j(o45Var);
            this.S = jVar;
            g(jVar);
            f73 adapter = o45Var.getAdapter();
            if (adapter != null) {
                K(adapter, z);
            }
            if (this.b0 == null) {
                this.b0 = new b();
            }
            this.b0.b(z);
            o45Var.b(this.b0);
            L(o45Var.getCurrentItem(), 0.0f, true);
        } else {
            this.U = null;
            K(null, false);
        }
        this.c0 = z2;
    }

    public final void Q() {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((g) this.g.get(i2)).o();
        }
    }

    public final void R(LinearLayout.LayoutParams layoutParams) {
        if (this.I == 1 && this.F == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void S(boolean z) {
        for (int i2 = 0; i2 < this.i.getChildCount(); i2++) {
            View childAt = this.i.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            R((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public void T(int i2) {
        this.d0 = i2;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        l(view);
    }

    public void g(c cVar) {
        if (this.R.contains(cVar)) {
            return;
        }
        this.R.add(cVar);
    }

    public int getSelectedTabPosition() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.g.size();
    }

    public int getTabGravity() {
        return this.F;
    }

    public ColorStateList getTabIconTint() {
        return this.r;
    }

    public int getTabIndicatorAnimationMode() {
        return this.M;
    }

    public int getTabIndicatorGravity() {
        return this.H;
    }

    public int getTabMaxWidth() {
        return this.A;
    }

    public int getTabMode() {
        return this.I;
    }

    public ColorStateList getTabRippleColor() {
        return this.s;
    }

    public Drawable getTabSelectedIndicator() {
        return this.t;
    }

    public ColorStateList getTabTextColors() {
        return this.q;
    }

    public void h(d dVar) {
        g(dVar);
    }

    public void i(g gVar, int i2, boolean z) {
        if (gVar.h != this) {
            jl.a("Tab belongs to a different TabLayout.");
            return;
        }
        q(gVar, i2);
        k(gVar);
        if (z) {
            gVar.l();
        }
    }

    public void j(g gVar, boolean z) {
        i(gVar, this.g.size(), z);
    }

    public final void k(g gVar) {
        i iVar = gVar.i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.i.addView(iVar, gVar.g(), s());
    }

    public final void l(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void m(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !isLaidOut() || this.i.d()) {
            L(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iP = p(i2, 0.0f);
        if (scrollX != iP) {
            y();
            this.T.setIntValues(scrollX, iP);
            this.T.start();
        }
        this.i.c(i2, this.G);
    }

    public final void n(int i2) {
        if (i2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.i.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.i.setGravity(8388611);
    }

    public final void o() {
        int i2 = this.I;
        this.i.setPaddingRelative((i2 == 0 || i2 == 2) ? Math.max(0, this.E - this.j) : 0, 0, 0, 0);
        int i3 = this.I;
        if (i3 == 0) {
            n(this.F);
        } else if (i3 == 1 || i3 == 2) {
            if (this.F == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.i.setGravity(1);
        }
        S(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m62.e(this);
        if (this.U == null) {
            ViewParent parent = getParent();
            if (parent instanceof o45) {
                P((o45) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c0) {
            setupWithViewPager(null);
            this.c0 = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.i.getChildCount(); i2++) {
            View childAt = this.i.getChildAt(i2);
            if (childAt instanceof i) {
                ((i) childAt).g(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g2.P0(accessibilityNodeInfo).n0(g2.e.a(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return A() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = defpackage.e55.b(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.C
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = defpackage.e55.b(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.A = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.I
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r7.measure(r6, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || A()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final int p(int i2, float f2) {
        View childAt;
        int i3 = this.I;
        if ((i3 != 0 && i3 != 2) || (childAt = this.i.getChildAt(i2)) == null) {
            return 0;
        }
        int i4 = i2 + 1;
        View childAt2 = i4 < this.i.getChildCount() ? this.i.getChildAt(i4) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return getLayoutDirection() == 0 ? left + i5 : left - i5;
    }

    public final void q(g gVar, int i2) {
        gVar.m(i2);
        this.g.add(i2, gVar);
        int size = this.g.size();
        int i3 = -1;
        for (int i4 = i2 + 1; i4 < size; i4++) {
            if (((g) this.g.get(i4)).g() == this.f) {
                i3 = i4;
            }
            ((g) this.g.get(i4)).m(i4);
        }
        this.f = i3;
    }

    public final LinearLayout.LayoutParams s() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        R(layoutParams);
        return layoutParams;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        m62.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.J != z) {
            this.J = z;
            for (int i2 = 0; i2 < this.i.getChildCount(); i2++) {
                View childAt = this.i.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).r();
                }
            }
            o();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.Q;
        if (cVar2 != null) {
            G(cVar2);
        }
        this.Q = cVar;
        if (cVar != null) {
            g(cVar);
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        y();
        this.T.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = tn0.r(drawable).mutate();
        this.t = drawableMutate;
        go0.l(drawableMutate, this.u);
        int intrinsicHeight = this.L;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.t.getIntrinsicHeight();
        }
        this.i.i(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.u = i2;
        go0.l(this.t, i2);
        S(false);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.H != i2) {
            this.H = i2;
            this.i.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.L = i2;
        this.i.i(i2);
    }

    public void setTabGravity(int i2) {
        if (this.F != i2) {
            this.F = i2;
            o();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            Q();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(e9.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.M = i2;
        if (i2 == 0) {
            this.O = new com.google.android.material.tabs.a();
            return;
        }
        if (i2 == 1) {
            this.O = new vq0();
        } else {
            if (i2 == 2) {
                this.O = new uz0();
                return;
            }
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.K = z;
        this.i.g();
        this.i.postInvalidateOnAnimation();
    }

    public void setTabMode(int i2) {
        if (i2 != this.I) {
            this.I = i2;
            o();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.s != colorStateList) {
            this.s = colorStateList;
            for (int i2 = 0; i2 < this.i.getChildCount(); i2++) {
                View childAt = this.i.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).q(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(e9.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.q != colorStateList) {
            this.q = colorStateList;
            Q();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(f73 f73Var) {
        K(f73Var, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.N != z) {
            this.N = z;
            for (int i2 = 0; i2 < this.i.getChildCount(); i2++) {
                View childAt = this.i.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).q(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(o45 o45Var) {
        O(o45Var, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public g t() {
        g gVar = (g) g0.a();
        return gVar == null ? new g() : gVar;
    }

    public final i u(g gVar) {
        tf3 tf3Var = this.e0;
        i iVar = tf3Var != null ? (i) tf3Var.a() : null;
        if (iVar == null) {
            iVar = new i(getContext());
        }
        iVar.setTab(gVar);
        iVar.setFocusable(true);
        iVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.d)) {
            iVar.setContentDescription(gVar.c);
            return iVar;
        }
        iVar.setContentDescription(gVar.d);
        return iVar;
    }

    public final void v(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).a(gVar);
        }
    }

    public final void w(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).b(gVar);
        }
    }

    public final void x(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).c(gVar);
        }
    }

    public final void y() {
        if (this.T == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.T = valueAnimator;
            valueAnimator.setInterpolator(this.P);
            this.T.setDuration(this.G);
            this.T.addUpdateListener(new a());
        }
    }

    public g z(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return (g) this.g.get(i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        l(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        l(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        l(view);
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(e9.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.a0);
    }

    public TabLayout(Context context) {
        this(context, null);
    }
}

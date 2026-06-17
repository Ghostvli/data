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
import com.hierynomus.protocol.commons.buffer.Buffer;
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
import defpackage.up4;
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements o45.i {
        public boolean a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // o45.i
        public void a(o45 o45Var, f73 f73Var, f73 f73Var2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.U == o45Var) {
                tabLayout.K(f73Var2, this.a);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.D();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(Context context) {
            super(context);
            this.g = -1;
            setWillNotDraw(false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(int i, int i2) {
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f != i) {
                this.f.cancel();
            }
            k(true, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f == -1) {
                tabLayout.f = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void f(int i) {
            if (TabLayout.this.d0 == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i);
                com.google.android.material.tabs.a aVar = TabLayout.this.O;
                TabLayout tabLayout = TabLayout.this;
                aVar.c(tabLayout, childAt, tabLayout.t);
                TabLayout.this.f = i;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(int i, float f) {
            TabLayout.this.f = Math.round(i + f);
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f.cancel();
            }
            j(getChildAt(i), getChildAt(i + 1), f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(int i) {
            Rect bounds = TabLayout.this.t.getBounds();
            TabLayout.this.t.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View e() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Drawable f() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int g() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int h() {
            return this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CharSequence i() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean j() {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                return selectedTabPosition != -1 && selectedTabPosition == this.e;
            }
            jl.a("Tab not attached to a TabLayout");
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l() {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                tabLayout.I(this);
            } else {
                jl.a("Tab not attached to a TabLayout");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void m(int i) {
            this.e = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g n(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.i.setContentDescription(charSequence);
            }
            this.c = charSequence;
            o();
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // o45.j
        public void b(int i) {
            this.b = this.c;
            this.c = i;
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                tabLayout.T(this.c);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // o45.j
        public void c(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.J(tabLayout.z(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(View view) {
                this.a = view;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.a.getVisibility() == 0) {
                    i.this.o(this.a);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private yf getBadge() {
            return this.j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final float e(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void f(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g(Canvas canvas) {
            Drawable drawable = this.n;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.n.draw(canvas);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g getTab() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean h() {
            return this.j != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void i() {
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(gm3.c, (ViewGroup) this, false);
            this.h = imageView;
            addView(imageView, 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void j() {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(gm3.d, (ViewGroup) this, false);
            this.g = textView;
            addView(textView);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k() {
            setTab(null);
            setSelected(false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void l(View view) {
            if (h() && view != null) {
                f(false);
                ag.b(this.j, view, null);
                this.i = view;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void o(View view) {
            if (h() && view == this.i) {
                ag.f(this.j, view, null);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p() {
            s();
            g gVar = this.f;
            setSelected(gVar != null && gVar.j());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r() {
            setOrientation(!TabLayout.this.J ? 1 : 0);
            TextView textView = this.l;
            if (textView == null && this.m == null) {
                t(this.g, this.h, true);
            } else {
                t(textView, this.m, false);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setTab(g gVar) {
            if (gVar != this.f) {
                this.f = gVar;
                p();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void t(TextView textView, ImageView imageView, boolean z) {
            boolean z2;
            g gVar = this.f;
            Drawable drawableMutate = (gVar == null || gVar.f() == null) ? null : tn0.r(this.f.f()).mutate();
            if (drawableMutate != null) {
                drawableMutate.setTintList(TabLayout.this.r);
                PorterDuff.Mode mode = TabLayout.this.v;
                if (mode != null) {
                    drawableMutate.setTintMode(mode);
                }
            }
            g gVar2 = this.f;
            CharSequence charSequenceI = gVar2 != null ? gVar2.i() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceI);
            if (textView == null) {
                z2 = false;
            } else if (!zIsEmpty) {
                z2 = this.f.g == 1;
                textView.setText(!zIsEmpty ? charSequenceI : null);
                textView.setVisibility(z2 ? 0 : 8);
                if (!zIsEmpty) {
                    setVisibility(0);
                }
            }
            if (z && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iB = (z2 && imageView.getVisibility() == 0) ? (int) e55.b(getContext(), 8) : 0;
                if (TabLayout.this.J) {
                    if (iB != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(iB);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iB != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iB;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f;
            CharSequence charSequence = gVar3 != null ? gVar3.d : null;
            if (zIsEmpty) {
                charSequenceI = charSequence;
            }
            up4.a(this, charSequenceI);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j implements d {
        public final o45 a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j(o45 o45Var) {
            this.a = o45Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.a.setCurrentItem(gVar.g());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getTabScrollRange() {
        return Math.max(0, ((this.i.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ColorStateList r(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean A() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B() {
        return this.K;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g C() {
        g gVarT = t();
        gVarT.h = this;
        gVarT.i = u(gVarT);
        if (gVarT.j != -1) {
            gVarT.i.setId(gVarT.j);
        }
        return gVarT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean E(g gVar) {
        return g0.b(gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(c cVar) {
        this.R.remove(cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(int i2) {
        i iVar = (i) this.i.getChildAt(i2);
        this.i.removeViewAt(i2);
        if (iVar != null) {
            iVar.k();
            this.e0.b(iVar);
        }
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(g gVar) {
        J(gVar, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L(int i2, float f2, boolean z) {
        M(i2, f2, z, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M(int i2, float f2, boolean z, boolean z2) {
        N(i2, f2, z, z2, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(o45 o45Var, boolean z) {
        P(o45Var, z, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q() {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((g) this.g.get(i2)).o();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R(LinearLayout.LayoutParams layoutParams) {
        if (this.I == 1 && this.F == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T(int i2) {
        this.d0 = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        l(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(c cVar) {
        if (this.R.contains(cVar)) {
            return;
        }
        this.R.add(cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSelectedTabPosition() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTabCount() {
        return this.g.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTabGravity() {
        return this.F;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getTabIconTint() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTabIndicatorAnimationMode() {
        return this.M;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTabIndicatorGravity() {
        return this.H;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTabMaxWidth() {
        return this.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTabMode() {
        return this.I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getTabRippleColor() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getTabSelectedIndicator() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getTabTextColors() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(d dVar) {
        g(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(g gVar, boolean z) {
        i(gVar, this.g.size(), z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(g gVar) {
        i iVar = gVar.i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.i.addView(iVar, gVar.g(), s());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c0) {
            setupWithViewPager(null);
            this.c0 = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g2.P0(accessibilityNodeInfo).n0(g2.e.a(1, getTabCount(), false, 1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return A() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int iRound = Math.round(e55.b(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(iRound + getPaddingTop() + getPaddingBottom(), Buffer.MAX_SIZE);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i3) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int iB = this.C;
            if (iB <= 0) {
                iB = (int) (size - e55.b(getContext(), 56));
            }
            this.A = iB;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i4 = this.I;
            if (i4 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Buffer.MAX_SIZE), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || A()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final LinearLayout.LayoutParams s() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        R(layoutParams);
        return layoutParams;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        m62.d(this, f2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        y();
        this.T.addListener(animatorListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSelectedTabIndicatorColor(int i2) {
        this.u = i2;
        go0.l(this.t, i2);
        S(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.H != i2) {
            this.H = i2;
            this.i.postInvalidateOnAnimation();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.L = i2;
        this.i.i(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabGravity(int i2) {
        if (this.F != i2) {
            this.F = i2;
            o();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            Q();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabIconTintResource(int i2) {
        setTabIconTint(e9.a(getContext(), i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabIndicatorFullWidth(boolean z) {
        this.K = z;
        this.i.g();
        this.i.postInvalidateOnAnimation();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabMode(int i2) {
        if (i2 != this.I) {
            this.I = i2;
            o();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(e9.a(getContext(), i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.q != colorStateList) {
            this.q = colorStateList;
            Q();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setTabsFromPagerAdapter(f73 f73Var) {
        K(f73Var, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setupWithViewPager(o45 o45Var) {
        O(o45Var, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g t() {
        g gVar = (g) g0.a();
        return gVar == null ? new g() : gVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).a(gVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).b(gVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).c(gVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y() {
        if (this.T == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.T = valueAnimator;
            valueAnimator.setInterpolator(this.P);
            this.T.setDuration(this.G);
            this.T.addUpdateListener(new a());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Method merged with bridge method: generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams; */
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

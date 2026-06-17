package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.internal.BaselineLayout;
import defpackage.g2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b23 extends FrameLayout implements e23 {
    public static final int[] o0 = {R.attr.state_checked};
    public static final c p0;
    public static final c q0;
    public final TextView A;
    public final TextView B;
    public BaselineLayout C;
    public TextView D;
    public TextView E;
    public BaselineLayout F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public ColorStateList L;
    public boolean M;
    public g N;
    public ColorStateList O;
    public Drawable P;
    public Drawable Q;
    public ValueAnimator R;
    public c S;
    public float T;
    public boolean U;
    public int V;
    public int W;
    public int a0;
    public int b0;
    public boolean c0;
    public int d0;
    public int e0;
    public boolean f;
    public yf f0;
    public ColorStateList g;
    public int g0;
    public Drawable h;
    public int h0;
    public int i;
    public int i0;
    public int j;
    public boolean j0;
    public int k;
    public boolean k0;
    public int l;
    public boolean l0;
    public float m;
    public boolean m0;
    public float n;
    public Rect n0;
    public float o;
    public float p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public final LinearLayout u;
    public final LinearLayout v;
    public final View w;
    public final FrameLayout x;
    public final ImageView y;
    public final BaselineLayout z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final /* synthetic */ int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i) {
            this.f = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            b23.this.A(this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(float f) {
            this.a = f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b23.this.p(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.a);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        a aVar = null;
        p0 = new c(aVar);
        q0 = new d(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b23(Context context) {
        super(context);
        this.f = false;
        this.G = -1;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.M = false;
        this.S = p0;
        this.T = 0.0f;
        this.U = false;
        this.V = 0;
        this.W = 0;
        this.a0 = -2;
        this.b0 = 0;
        this.c0 = false;
        this.d0 = 0;
        this.e0 = 0;
        this.h0 = 0;
        this.i0 = 49;
        this.j0 = false;
        this.k0 = false;
        this.l0 = false;
        this.m0 = false;
        this.n0 = new Rect();
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.u = (LinearLayout) findViewById(ol3.i);
        LinearLayout linearLayout = (LinearLayout) findViewById(ol3.l);
        this.v = linearLayout;
        this.w = findViewById(ol3.h);
        this.x = (FrameLayout) findViewById(ol3.j);
        this.y = (ImageView) findViewById(ol3.k);
        BaselineLayout baselineLayout = (BaselineLayout) findViewById(ol3.m);
        this.z = baselineLayout;
        TextView textView = (TextView) findViewById(ol3.o);
        this.A = textView;
        TextView textView2 = (TextView) findViewById(ol3.n);
        this.B = textView2;
        j();
        this.F = baselineLayout;
        setBackgroundResource(getItemBackgroundResId());
        this.i = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.j = baselineLayout.getPaddingBottom();
        this.k = 0;
        this.l = 0;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        this.D.setImportantForAccessibility(2);
        this.E.setImportantForAccessibility(2);
        setFocusable(true);
        f();
        this.b0 = getResources().getDimensionPixelSize(zk3.C);
        linearLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: a23
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                b23.a(this.a, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void G(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void H() {
        g gVar = this.N;
        if (gVar != null) {
            setVisibility((!gVar.isVisible() || (!this.j0 && this.k0)) ? 8 : 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(b23 b23Var, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        if (b23Var.y.getVisibility() == 0) {
            b23Var.z(b23Var.y);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b23Var.v.getLayoutParams();
        int i9 = (i3 - i) + layoutParams.rightMargin + layoutParams.leftMargin;
        int i10 = (i4 - i2) + layoutParams.topMargin + layoutParams.bottomMargin;
        boolean z2 = true;
        if (b23Var.g0 == 1 && b23Var.a0 == -2) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b23Var.w.getLayoutParams();
            if (b23Var.a0 != -2 || b23Var.w.getMeasuredWidth() == i9) {
                z = false;
            } else {
                layoutParams2.width = Math.max(i9, Math.min(b23Var.V, b23Var.getMeasuredWidth() - (b23Var.d0 * 2)));
                z = true;
            }
            if (b23Var.w.getMeasuredHeight() < i10) {
                layoutParams2.height = i10;
            } else {
                z2 = z;
            }
            if (z2) {
                b23Var.w.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < iIndexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof b23) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getSuggestedIconWidth() {
        yf yfVar = this.f0;
        int minimumWidth = yfVar == null ? 0 : yfVar.getMinimumWidth() - this.f0.m();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.y.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setLabelPivots(TextView textView) {
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void u(TextView textView, int i) {
        an4.m(textView, i);
        int iJ = k62.j(textView.getContext(), i, 0);
        if (iJ != 0) {
            textView.setTextSize(0, iJ);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void v(View view, int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void w(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(int i) {
        if (i > 0 || getVisibility() != 0) {
            int iMin = Math.min(this.V, i - (this.d0 * 2));
            int iMax = this.W;
            if (this.g0 == 1) {
                int measuredWidth = i - (this.e0 * 2);
                int i2 = this.a0;
                if (i2 != -1) {
                    measuredWidth = i2 == -2 ? this.u.getMeasuredWidth() : Math.min(i2, measuredWidth);
                }
                iMin = measuredWidth;
                iMax = Math.max(this.b0, this.v.getMeasuredHeight());
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
            if (k()) {
                iMax = iMin;
            }
            layoutParams.height = iMax;
            layoutParams.width = Math.max(0, iMin);
            this.w.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B() {
        if (k()) {
            this.S = q0;
        } else {
            this.S = p0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C() {
        TextView textView = this.B;
        textView.setTypeface(textView.getTypeface(), this.M ? 1 : 0);
        TextView textView2 = this.E;
        textView2.setTypeface(textView2.getTypeface(), this.M ? 1 : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        t(textView, i);
        f();
        textView.setMinimumHeight(k62.i(textView.getContext(), i, 0));
        ColorStateList colorStateList = this.L;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        t(textView, i);
        f();
        textView.setMinimumHeight(k62.i(textView.getContext(), i, 0));
        ColorStateList colorStateList = this.L;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        this.h0 = 0;
        this.F = this.z;
        int i7 = 8;
        if (this.g0 == 1) {
            if (this.C.getParent() == null) {
                e();
            }
            Rect rect = this.n0;
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = rect.top;
            i = rect.bottom;
            this.h0 = 1;
            int i11 = this.e0;
            this.F = this.C;
            i5 = i10;
            i4 = i9;
            i3 = i8;
            i2 = i11;
            i6 = 0;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 8;
            i7 = 0;
        }
        this.z.setVisibility(i7);
        this.C.setVisibility(i6);
        ((FrameLayout.LayoutParams) this.u.getLayoutParams()).gravity = this.i0;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.v.getLayoutParams();
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.topMargin = i5;
        layoutParams.bottomMargin = i;
        setPadding(i2, 0, i2, 0);
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.j.a
    public void d(g gVar, int i) {
        this.N = gVar;
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setIcon(gVar.getIcon());
        setTitle(gVar.getTitle());
        setId(gVar.getItemId());
        if (!TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(gVar.getContentDescription());
        }
        up4.a(this, !TextUtils.isEmpty(gVar.getTooltipText()) ? gVar.getTooltipText() : gVar.getTitle());
        H();
        this.f = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.U) {
            this.x.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.v.addView(this.C, layoutParams);
        q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        float textSize = this.A.getTextSize();
        float textSize2 = this.B.getTextSize();
        this.m = textSize - textSize2;
        this.n = (textSize2 * 1.0f) / textSize;
        this.o = (textSize * 1.0f) / textSize2;
        float textSize3 = this.D.getTextSize();
        float textSize4 = this.E.getTextSize();
        this.p = textSize3 - textSize4;
        this.q = (textSize4 * 1.0f) / textSize3;
        this.r = (textSize3 * 1.0f) / textSize4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        o();
        this.N = null;
        this.T = 0.0f;
        this.f = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getActiveIndicatorDrawable() {
        return this.w.getBackground();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yf getBadge() {
        return this.f0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BaselineLayout getExpandedLabelGroup() {
        return this.C;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemBackgroundResId() {
        return gl3.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.N;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemDefaultMarginResId() {
        return zk3.f0;
    }

    public abstract int getItemLayoutResId();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemPosition() {
        return this.G;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BaselineLayout getLabelGroup() {
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        return this.u.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        if (this.g0 == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.v.getLayoutParams();
            return this.v.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.z.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams2.leftMargin + this.z.getMeasuredWidth() + layoutParams2.rightMargin);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Drawable h(ColorStateList colorStateList) {
        return FocusRingDrawable.D(getContext(), new RippleDrawable(wt3.a(colorStateList), null, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i() {
        return this.f0 != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        float dimension = getResources().getDimension(zk3.b);
        float dimension2 = getResources().getDimension(zk3.a);
        BaselineLayout baselineLayout = new BaselineLayout(getContext());
        this.C = baselineLayout;
        baselineLayout.setVisibility(8);
        this.C.setDuplicateParentStateEnabled(true);
        this.C.setMeasurePaddingFromBaseline(this.l0);
        TextView textView = new TextView(getContext());
        this.D = textView;
        textView.setMaxLines(1);
        TextView textView2 = this.D;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        this.D.setDuplicateParentStateEnabled(true);
        this.D.setIncludeFontPadding(false);
        this.D.setGravity(16);
        this.D.setTextSize(dimension);
        TextView textView3 = new TextView(getContext());
        this.E = textView3;
        textView3.setMaxLines(1);
        this.E.setEllipsize(truncateAt);
        this.E.setDuplicateParentStateEnabled(true);
        this.E.setVisibility(4);
        this.E.setIncludeFontPadding(false);
        this.E.setGravity(16);
        this.E.setTextSize(dimension2);
        this.C.addView(this.D);
        this.C.addView(this.E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k() {
        return this.c0 && this.s == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(float f) {
        if (!this.U || !this.f || !isAttachedToWindow()) {
            p(f, f);
            return;
        }
        ValueAnimator valueAnimator = this.R;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.R = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.T, f);
        this.R = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new b(f));
        this.R.setInterpolator(lu2.g(getContext(), mk3.L, k7.b));
        this.R.setDuration(lu2.f(getContext(), mk3.C, getResources().getInteger(zl3.b)));
        this.R.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        g gVar = this.N;
        if (gVar != null) {
            setChecked(gVar.isChecked());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        Drawable drawableH = this.h;
        Drawable drawable = null;
        drawable = null;
        drawable = null;
        boolean z = true;
        if (this.g != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.U && activeIndicatorDrawable != null) {
                RippleDrawable rippleDrawable = new RippleDrawable(wt3.d(this.g), null, activeIndicatorDrawable);
                FocusRingDrawable.t(getContext(), rippleDrawable, activeIndicatorDrawable instanceof l62 ? (l62) activeIndicatorDrawable : null);
                drawable = rippleDrawable;
                z = false;
            } else if (drawableH == null) {
                drawableH = h(this.g);
            }
        }
        this.x.setPadding(0, 0, 0, 0);
        this.x.setForeground(drawable);
        setBackground(drawableH);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o() {
        y(this.y);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        g gVar = this.N;
        if (gVar != null && gVar.isCheckable() && this.N.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, o0);
        }
        return iArrOnCreateDrawableState;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        yf yfVar = this.f0;
        if (yfVar != null && yfVar.isVisible()) {
            CharSequence title = this.N.getTitle();
            if (!TextUtils.isEmpty(this.N.getContentDescription())) {
                title = this.N.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.f0.j()));
        }
        g2 g2VarP0 = g2.P0(accessibilityNodeInfo);
        g2VarP0.o0(g2.f.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            g2VarP0.m0(false);
            g2VarP0.d0(g2.a.i);
        }
        g2VarP0.F0(getResources().getString(tm3.j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new a(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(float f, float f2) {
        this.S.d(f, f2, this.w);
        this.T = f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        int i = this.y.getLayoutParams().width > 0 ? this.l : 0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
            layoutParams.leftMargin = getLayoutDirection() != 1 ? i : 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r(View view, View view2, float f, float f2) {
        v(this.u, this.g0 == 0 ? (int) (this.i + f2) : 0, 0, this.i0);
        LinearLayout linearLayout = this.v;
        int i = this.g0;
        v(linearLayout, i == 0 ? 0 : this.n0.top, i == 0 ? 0 : this.n0.bottom, i == 0 ? 17 : 8388627);
        G(this.z, this.j);
        this.F.setVisibility(0);
        w(view, 1.0f, 1.0f, 0);
        w(view2, f, f, 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s() {
        LinearLayout linearLayout = this.u;
        int i = this.i;
        v(linearLayout, i, i, this.g0 == 0 ? 17 : this.i0);
        v(this.v, 0, 0, 17);
        G(this.z, 0);
        this.F.setVisibility(8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorDrawable(Drawable drawable) {
        this.w.setBackground(drawable);
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorEnabled(boolean z) {
        this.U = z;
        n();
        this.w.setVisibility(z ? 0 : 8);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorExpandedHeight(int i) {
        this.b0 = i;
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorExpandedMarginHorizontal(int i) {
        this.e0 = i;
        if (this.g0 == 1) {
            setPadding(i, 0, i, 0);
        }
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorExpandedPadding(Rect rect) {
        this.n0 = rect;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorExpandedWidth(int i) {
        this.a0 = i;
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorHeight(int i) {
        this.W = i;
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorLabelPadding(int i) {
        if (this.k != i) {
            this.k = i;
            ((LinearLayout.LayoutParams) this.z.getLayoutParams()).topMargin = i;
            if (this.C.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
                layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
                if (getLayoutDirection() == 1) {
                    i = 0;
                }
                layoutParams.leftMargin = i;
                requestLayout();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorMarginHorizontal(int i) {
        this.d0 = i;
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorResizeable(boolean z) {
        this.c0 = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorWidth(int i) {
        this.V = i;
        A(getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBadge(yf yfVar) {
        if (this.f0 == yfVar) {
            return;
        }
        if (i() && this.y != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            y(this.y);
        }
        this.f0 = yfVar;
        yfVar.O(this.h0);
        ImageView imageView = this.y;
        if (imageView != null) {
            x(imageView);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChecked(boolean z) {
        setLabelPivots(this.B);
        setLabelPivots(this.A);
        setLabelPivots(this.E);
        setLabelPivots(this.D);
        l(z ? 1.0f : 0.0f);
        TextView textView = this.B;
        TextView textView2 = this.A;
        float f = this.m;
        float f2 = this.n;
        float f3 = this.o;
        if (this.g0 == 1) {
            textView = this.E;
            textView2 = this.D;
            f = this.p;
            f2 = this.q;
            f3 = this.r;
        }
        int i = this.s;
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        s();
                    }
                } else if (z) {
                    r(textView, textView2, f2, f);
                } else {
                    r(textView2, textView, f3, 0.0f);
                }
            } else if (z) {
                r(textView, textView2, f2, 0.0f);
            } else {
                s();
            }
        } else if (this.t) {
            if (z) {
                r(textView, textView2, f2, 0.0f);
            } else {
                s();
            }
        } else if (z) {
            r(textView, textView2, f2, f);
        } else {
            r(textView2, textView, f3, 0.0f);
        }
        refreshDrawableState();
        setSelected(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.A.setEnabled(z);
        this.B.setEnabled(z);
        this.D.setEnabled(z);
        this.E.setEnabled(z);
        this.y.setEnabled(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.e23
    public void setExpanded(boolean z) {
        this.j0 = z;
        H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHorizontalTextAppearanceActive(int i) {
        this.J = i;
        TextView textView = this.E;
        if (i == 0) {
            i = this.H;
        }
        D(textView, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHorizontalTextAppearanceInactive(int i) {
        this.K = i;
        TextView textView = this.D;
        if (i == 0) {
            i = this.I;
        }
        E(textView, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIcon(Drawable drawable) {
        if (drawable == this.P) {
            return;
        }
        this.P = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = tn0.r(drawable).mutate();
            this.Q = drawable;
            ColorStateList colorStateList = this.O;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.y.setImageDrawable(drawable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconLabelHorizontalSpacing(int i) {
        if (this.l != i) {
            this.l = i;
            q();
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconSize(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.y.setLayoutParams(layoutParams);
        q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.O = colorStateList;
        if (this.N == null || (drawable = this.Q) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.Q.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.h = drawable;
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemGravity(int i) {
        this.i0 = i;
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemIconGravity(int i) {
        if (this.g0 != i) {
            this.g0 = i;
            F();
            n();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemPaddingBottom(int i) {
        if (this.j != i) {
            this.j = i;
            m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemPaddingTop(int i) {
        if (this.i != i) {
            this.i = i;
            m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemPosition(int i) {
        this.G = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemRippleColor(ColorStateList colorStateList) {
        this.g = colorStateList;
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLabelFontScalingEnabled(boolean z) {
        this.m0 = z;
        setTextAppearanceActive(this.H);
        setTextAppearanceInactive(this.I);
        setHorizontalTextAppearanceActive(this.J);
        setHorizontalTextAppearanceInactive(this.K);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLabelMaxLines(int i) {
        this.A.setMaxLines(i);
        this.B.setMaxLines(i);
        this.D.setMaxLines(i);
        this.E.setMaxLines(i);
        if (Build.VERSION.SDK_INT > 34) {
            this.A.setGravity(17);
            this.B.setGravity(17);
        } else {
            TextView textView = this.A;
            if (i > 1) {
                textView.setEllipsize(null);
                this.B.setEllipsize(null);
                this.A.setGravity(17);
                this.B.setGravity(17);
            } else {
                textView.setGravity(16);
                this.B.setGravity(16);
            }
        }
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLabelVisibilityMode(int i) {
        if (this.s != i) {
            this.s = i;
            B();
            A(getWidth());
            m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.l0 = z;
        this.z.setMeasurePaddingFromBaseline(z);
        this.A.setIncludeFontPadding(z);
        this.B.setIncludeFontPadding(z);
        this.C.setMeasurePaddingFromBaseline(z);
        this.D.setIncludeFontPadding(z);
        this.E.setIncludeFontPadding(z);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.e23
    public void setOnlyShowWhenExpanded(boolean z) {
        this.k0 = z;
        H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShifting(boolean z) {
        if (this.t != z) {
            this.t = z;
            m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextAppearanceActive(int i) {
        this.H = i;
        D(this.B, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        this.M = z;
        setTextAppearanceActive(this.H);
        setHorizontalTextAppearanceActive(this.J);
        C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextAppearanceInactive(int i) {
        this.I = i;
        E(this.A, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextColor(ColorStateList colorStateList) {
        this.L = colorStateList;
        if (colorStateList != null) {
            this.A.setTextColor(colorStateList);
            this.B.setTextColor(colorStateList);
            this.D.setTextColor(colorStateList);
            this.E.setTextColor(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitle(CharSequence charSequence) {
        this.A.setText(charSequence);
        this.B.setText(charSequence);
        this.D.setText(charSequence);
        this.E.setText(charSequence);
        g gVar = this.N;
        if (gVar == null || TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        g gVar2 = this.N;
        if (gVar2 != null && !TextUtils.isEmpty(gVar2.getTooltipText())) {
            charSequence = this.N.getTooltipText();
        }
        up4.a(this, charSequence);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(TextView textView, int i) {
        if (this.m0) {
            an4.m(textView, i);
        } else {
            u(textView, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(View view) {
        if (i() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            ag.a(this.f0, view);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(View view) {
        if (i()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ag.e(this.f0, view);
            }
            this.f0 = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(View view) {
        if (i()) {
            ag.f(this.f0, view, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float a(float f, float f2) {
            return k7.b(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float b(float f) {
            return k7.a(0.4f, 1.0f, f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float c(float f) {
            return 1.0f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(float f, float f2, View view) {
            view.setScaleX(b(f));
            view.setScaleY(c(f));
            view.setAlpha(a(f, f2));
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:5) call: b23.c.<init>():void type: THIS */
        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
            super(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b23.c
        public float c(float f) {
            return b(f);
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:6) call: b23.d.<init>():void type: THIS */
        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : getContext().getDrawable(i));
    }
}

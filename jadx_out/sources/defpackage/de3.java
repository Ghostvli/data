package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.media3.ui.DefaultTimeBar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class de3 {
    public boolean B;
    public boolean C;
    public final androidx.media3.ui.b a;
    public final View b;
    public final ViewGroup c;
    public final ViewGroup d;
    public final ViewGroup e;
    public final ViewGroup f;
    public final ViewGroup g;
    public final ViewGroup h;
    public final ViewGroup i;
    public final ViewGroup j;
    public final View k;
    public final View l;
    public final AnimatorSet m;
    public final AnimatorSet n;
    public final AnimatorSet o;
    public final AnimatorSet p;
    public final AnimatorSet q;
    public final ValueAnimator r;
    public final ValueAnimator s;
    public final Runnable t = new Runnable() { // from class: qd3
        @Override // java.lang.Runnable
        public final void run() {
            this.f.Z();
        }
    };
    public final Runnable u = new Runnable() { // from class: wd3
        @Override // java.lang.Runnable
        public final void run() {
            this.f.E();
        }
    };
    public final Runnable v = new Runnable() { // from class: xd3
        @Override // java.lang.Runnable
        public final void run() {
            this.f.I();
        }
    };
    public final Runnable w = new Runnable() { // from class: yd3
        @Override // java.lang.Runnable
        public final void run() {
            this.f.H();
        }
    };
    public final Runnable x = new Runnable() { // from class: zd3
        @Override // java.lang.Runnable
        public final void run() {
            this.f.F();
        }
    };
    public final View.OnLayoutChangeListener y = new View.OnLayoutChangeListener() { // from class: ae3
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.a.O(view, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    };
    public boolean D = true;
    public int A = 0;
    public final List z = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (de3.this.b != null) {
                de3.this.b.setVisibility(4);
            }
            if (de3.this.c != null) {
                de3.this.c.setVisibility(4);
            }
            if (de3.this.d != null) {
                de3.this.d.setVisibility(4);
            }
            if (de3.this.f != null) {
                de3.this.f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(de3.this.k instanceof DefaultTimeBar) || de3.this.B) {
                return;
            }
            ((DefaultTimeBar) de3.this.k).h(250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (de3.this.b != null) {
                de3.this.b.setVisibility(0);
            }
            if (de3.this.c != null) {
                de3.this.c.setVisibility(0);
            }
            if (de3.this.d != null) {
                de3.this.d.setVisibility(0);
            }
            if (de3.this.f != null) {
                de3.this.f.setVisibility(de3.this.B ? 0 : 4);
            }
            if (!(de3.this.k instanceof DefaultTimeBar) || de3.this.B) {
                return;
            }
            ((DefaultTimeBar) de3.this.k).q(250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ androidx.media3.ui.b a;

        public c(androidx.media3.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            de3.this.W(1);
            if (de3.this.C) {
                this.a.post(de3.this.t);
                de3.this.C = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            de3.this.W(3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ androidx.media3.ui.b a;

        public d(androidx.media3.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            de3.this.W(2);
            if (de3.this.C) {
                this.a.post(de3.this.t);
                de3.this.C = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            de3.this.W(3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ androidx.media3.ui.b a;

        public e(androidx.media3.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            de3.this.W(2);
            if (de3.this.C) {
                this.a.post(de3.this.t);
                de3.this.C = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            de3.this.W(3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            de3.this.W(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            de3.this.W(4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            de3.this.W(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            de3.this.W(4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (de3.this.g != null) {
                de3.this.g.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (de3.this.i != null) {
                de3.this.i.setVisibility(0);
                de3.this.i.setTranslationX(de3.this.i.getWidth());
                de3.this.i.scrollTo(de3.this.i.getWidth(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (de3.this.i != null) {
                de3.this.i.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (de3.this.g != null) {
                de3.this.g.setVisibility(0);
            }
        }
    }

    public de3(androidx.media3.ui.b bVar) {
        this.a = bVar;
        this.c = (ViewGroup) bVar.findViewById(wl3.U);
        this.b = bVar.findViewById(wl3.l);
        this.d = (ViewGroup) bVar.findViewById(wl3.g);
        this.f = (ViewGroup) bVar.findViewById(wl3.x);
        ViewGroup viewGroup = (ViewGroup) bVar.findViewById(wl3.e);
        this.e = viewGroup;
        this.j = (ViewGroup) bVar.findViewById(wl3.T);
        View viewFindViewById = bVar.findViewById(wl3.H);
        this.k = viewFindViewById;
        this.g = (ViewGroup) bVar.findViewById(wl3.d);
        this.h = (ViewGroup) bVar.findViewById(wl3.o);
        this.i = (ViewGroup) bVar.findViewById(wl3.p);
        View viewFindViewById2 = bVar.findViewById(wl3.B);
        this.l = viewFindViewById2;
        View viewFindViewById3 = bVar.findViewById(wl3.A);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: be3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f.Q(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: be3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f.Q(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ce3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                de3.d(this.a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rd3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                de3.f(this.a, valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = bVar.getResources();
        float dimension = resources.getDimension(wk3.b) - resources.getDimension(wk3.c);
        float dimension2 = resources.getDimension(wk3.b);
        AnimatorSet animatorSet = new AnimatorSet();
        this.m = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(bVar));
        animatorSet.play(valueAnimatorOfFloat).with(K(0.0f, dimension, viewFindViewById)).with(K(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.n = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(bVar));
        animatorSet2.play(K(dimension, dimension2, viewFindViewById)).with(K(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.o = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(bVar));
        animatorSet3.play(valueAnimatorOfFloat).with(K(0.0f, dimension2, viewFindViewById)).with(K(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.p = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(K(dimension, 0.0f, viewFindViewById)).with(K(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.q = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(K(dimension2, 0.0f, viewFindViewById)).with(K(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.r = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ud3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                de3.a(this.a, valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.s = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vd3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                de3.l(this.a, valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    public static int A(View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static int C(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public static ObjectAnimator K(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
    }

    public static /* synthetic */ void a(de3 de3Var, ValueAnimator valueAnimator) {
        de3Var.getClass();
        de3Var.z(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void d(de3 de3Var, ValueAnimator valueAnimator) {
        de3Var.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = de3Var.b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = de3Var.c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = de3Var.d;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup3 = de3Var.f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(fFloatValue);
        }
    }

    public static /* synthetic */ void f(de3 de3Var, ValueAnimator valueAnimator) {
        de3Var.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = de3Var.b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = de3Var.c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = de3Var.d;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup3 = de3Var.f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(fFloatValue);
        }
    }

    public static /* synthetic */ void l(de3 de3Var, ValueAnimator valueAnimator) {
        de3Var.getClass();
        de3Var.z(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public boolean B(View view) {
        return view != null && this.z.contains(view);
    }

    public void D() {
        int i2 = this.A;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        S();
        if (!this.D) {
            F();
        } else if (this.A == 1) {
            I();
        } else {
            E();
        }
    }

    public final void E() {
        this.o.start();
    }

    public final void F() {
        W(2);
    }

    public void G() {
        int i2 = this.A;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        S();
        F();
    }

    public final void H() {
        this.m.start();
        R(this.v, 2000L);
    }

    public final void I() {
        this.n.start();
    }

    public boolean J() {
        return this.A == 0 && this.a.n0();
    }

    public void L() {
        this.a.addOnLayoutChangeListener(this.y);
    }

    public void M() {
        this.a.removeOnLayoutChangeListener(this.y);
    }

    public void N(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public final void O(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean zB0 = b0();
        if (this.B != zB0) {
            this.B = zB0;
            view.post(new Runnable() { // from class: sd3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.a0();
                }
            });
        }
        boolean z = i4 - i2 != i8 - i6;
        if (this.B || !z) {
            return;
        }
        view.post(new Runnable() { // from class: td3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.P();
            }
        });
    }

    public final void P() {
        int i2;
        if (this.g == null || this.h == null) {
            return;
        }
        int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        while (true) {
            if (this.h.getChildCount() <= 1) {
                break;
            }
            int childCount = this.h.getChildCount() - 2;
            View childAt = this.h.getChildAt(childCount);
            this.h.removeViewAt(childCount);
            this.g.addView(childAt, 0);
        }
        View view = this.l;
        if (view != null) {
            view.setVisibility(8);
        }
        int iC = C(this.j);
        int childCount2 = this.g.getChildCount() - 1;
        for (int i3 = 0; i3 < childCount2; i3++) {
            iC += C(this.g.getChildAt(i3));
        }
        if (iC <= width) {
            ViewGroup viewGroup = this.i;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.s.isStarted()) {
                return;
            }
            this.r.cancel();
            this.s.start();
            return;
        }
        View view2 = this.l;
        if (view2 != null) {
            view2.setVisibility(0);
            iC += C(this.l);
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt2 = this.g.getChildAt(i4);
            iC -= C(childAt2);
            arrayList.add(childAt2);
            if (iC <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.g.removeViews(0, arrayList.size());
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            this.h.addView((View) arrayList.get(i2), this.h.getChildCount() - 1);
        }
    }

    public final void Q(View view) {
        T();
        if (view.getId() == wl3.B) {
            this.r.start();
        } else if (view.getId() == wl3.A) {
            this.s.start();
        }
    }

    public final void R(Runnable runnable, long j) {
        if (j >= 0) {
            this.a.postDelayed(runnable, j);
        }
    }

    public void S() {
        this.a.removeCallbacks(this.x);
        this.a.removeCallbacks(this.u);
        this.a.removeCallbacks(this.w);
        this.a.removeCallbacks(this.v);
    }

    public void T() {
        if (this.A == 3) {
            return;
        }
        S();
        int showTimeoutMs = this.a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.D) {
                R(this.x, showTimeoutMs);
            } else if (this.A == 1) {
                R(this.v, 2000L);
            } else {
                R(this.w, showTimeoutMs);
            }
        }
    }

    public void U(boolean z) {
        this.D = z;
    }

    public void V(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            this.z.remove(view);
            return;
        }
        if (this.B && X(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.z.add(view);
    }

    public final void W(int i2) {
        int i3 = this.A;
        this.A = i2;
        if (i2 == 2) {
            this.a.setVisibility(8);
        } else if (i3 == 2) {
            this.a.setVisibility(0);
        }
        if (i3 != i2) {
            this.a.o0();
        }
    }

    public final boolean X(View view) {
        int id = view.getId();
        return id == wl3.e || id == wl3.w || id == wl3.G || id == wl3.z || id == wl3.K || id == wl3.L || id == wl3.q || id == wl3.r;
    }

    public void Y() {
        if (!this.a.n0()) {
            this.a.setVisibility(0);
            this.a.w0();
            this.a.t0();
        }
        Z();
    }

    public final void Z() {
        if (!this.D) {
            W(0);
            T();
            return;
        }
        int i2 = this.A;
        if (i2 == 1) {
            this.p.start();
        } else if (i2 == 2) {
            this.q.start();
        } else if (i2 == 3) {
            this.C = true;
        } else if (i2 == 4) {
            return;
        }
        T();
    }

    public final void a0() {
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.B ? 0 : 4);
        }
        if (this.k != null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(wk3.d);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.B) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.k.setLayoutParams(marginLayoutParams);
            }
            View view = this.k;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.B) {
                    defaultTimeBar.i(true);
                } else {
                    int i2 = this.A;
                    if (i2 == 1) {
                        defaultTimeBar.i(false);
                    } else if (i2 != 3) {
                        defaultTimeBar.p();
                    }
                }
            }
        }
        for (View view2 : this.z) {
            view2.setVisibility((this.B && X(view2)) ? 4 : 0);
        }
    }

    public final boolean b0() {
        int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        int height = (this.a.getHeight() - this.a.getPaddingBottom()) - this.a.getPaddingTop();
        int iC = C(this.d);
        ViewGroup viewGroup = this.d;
        int paddingLeft = iC - (viewGroup != null ? viewGroup.getPaddingLeft() + this.d.getPaddingRight() : 0);
        int iA = A(this.d);
        ViewGroup viewGroup2 = this.d;
        return width <= Math.max(paddingLeft, C(this.j) + C(this.l)) || height <= (iA - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.d.getPaddingBottom() : 0)) + (A(this.e) * 2);
    }

    public final void z(float f2) {
        if (this.i != null) {
            this.i.setTranslationX((int) (r0.getWidth() * (1.0f - f2)));
        }
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup2 = this.g;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
    }
}

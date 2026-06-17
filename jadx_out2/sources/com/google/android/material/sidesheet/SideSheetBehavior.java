package com.google.android.material.sidesheet;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.b64;
import defpackage.c64;
import defpackage.cn3;
import defpackage.d64;
import defpackage.g2;
import defpackage.g64;
import defpackage.j2;
import defpackage.jl;
import defpackage.jr1;
import defpackage.k62;
import defpackage.k7;
import defpackage.l35;
import defpackage.l62;
import defpackage.n62;
import defpackage.nf;
import defpackage.ns1;
import defpackage.p;
import defpackage.r62;
import defpackage.t64;
import defpackage.tm3;
import defpackage.u35;
import defpackage.ug4;
import defpackage.vt3;
import defpackage.y44;
import defpackage.ym3;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c implements b64 {
    public static final int E = tm3.w;
    public static final int F = ym3.q;
    public n62 A;
    public int B;
    public final Set C;
    public final u35.d D;
    public d64 f;
    public float g;
    public l62 h;
    public ColorStateList i;
    public y44 j;
    public final d k;
    public float l;
    public boolean m;
    public int n;
    public int o;
    public u35 p;
    public boolean q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public WeakReference w;
    public WeakReference x;
    public int y;
    public VelocityTracker z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends u35.d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int a(View view, int i, int i2) {
            return r62.b(i, SideSheetBehavior.this.f.g(), SideSheetBehavior.this.f.f());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int d(View view) {
            return SideSheetBehavior.this.s + SideSheetBehavior.this.o0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public void j(int i) {
            if (i == 1 && SideSheetBehavior.this.m) {
                SideSheetBehavior.this.J0(1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public void k(View view, int i, int i2, int i3, int i4) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewJ0 = SideSheetBehavior.this.j0();
            if (viewJ0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) != null) {
                SideSheetBehavior.this.f.p(marginLayoutParams, view.getLeft(), view.getRight());
                viewJ0.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.d0(view, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public void l(View view, float f, float f2) {
            int iZ = SideSheetBehavior.this.Z(view, f, f2);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.O0(view, iZ, sideSheetBehavior.N0());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public boolean m(View view, int i) {
            return (SideSheetBehavior.this.n == 1 || SideSheetBehavior.this.w == null || SideSheetBehavior.this.w.get() != view) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.J0(5);
            if (SideSheetBehavior.this.w == null || SideSheetBehavior.this.w.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.w.get()).requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d {
        public int a;
        public boolean b;
        public final Runnable c = new Runnable() { // from class: s64
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.d.a(this.f);
            }
        };

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void a(d dVar) {
            dVar.b = false;
            if (SideSheetBehavior.this.p != null && SideSheetBehavior.this.p.l(true)) {
                dVar.b(dVar.a);
            } else if (SideSheetBehavior.this.n == 2) {
                SideSheetBehavior.this.J0(dVar.a);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i) {
            if (SideSheetBehavior.this.w == null || SideSheetBehavior.this.w.get() == null) {
                return;
            }
            this.a = i;
            if (this.b) {
                return;
            }
            ((View) SideSheetBehavior.this.w.get()).postOnAnimation(this.c);
            this.b = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new d();
        this.m = true;
        this.n = 5;
        this.o = 5;
        this.r = 0.1f;
        this.y = -1;
        this.C = new LinkedHashSet();
        this.D = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cn3.x5);
        if (typedArrayObtainStyledAttributes.hasValue(cn3.z5)) {
            this.i = k62.b(context, typedArrayObtainStyledAttributes, cn3.z5);
        }
        if (typedArrayObtainStyledAttributes.hasValue(cn3.C5)) {
            this.j = y44.i(context, attributeSet, 0, F).m();
        }
        if (typedArrayObtainStyledAttributes.hasValue(cn3.B5)) {
            F0(typedArrayObtainStyledAttributes.getResourceId(cn3.B5, -1));
        }
        c0(context);
        this.l = typedArrayObtainStyledAttributes.getDimension(cn3.y5, -1.0f);
        G0(typedArrayObtainStyledAttributes.getBoolean(cn3.A5, true));
        typedArrayObtainStyledAttributes.recycle();
        this.g = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void C0(View view, g2.a aVar, int i) {
        l35.c0(view, aVar, null, b0(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void E0(View view, Runnable runnable) {
        if (z0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean K(SideSheetBehavior sideSheetBehavior, int i, View view, j2.a aVar) {
        sideSheetBehavior.a(i);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean K0() {
        if (this.p != null) {
            return this.m || this.n == 1;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void L(SideSheetBehavior sideSheetBehavior, int i) {
        WeakReference weakReference = sideSheetBehavior.w;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            sideSheetBehavior.O0(view, i, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void M(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view, ValueAnimator valueAnimator) {
        sideSheetBehavior.f.o(marginLayoutParams, k7.c(i, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void O0(View view, int i, boolean z) {
        if (!A0(view, i, z)) {
            J0(i);
        } else {
            J0(2);
            this.k.b(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void P0() {
        View view;
        WeakReference weakReference = this.w;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        l35.a0(view, 262144);
        l35.a0(view, 1048576);
        if (this.n != 5) {
            C0(view, g2.a.y, 5);
        }
        if (this.n != 3) {
            C0(view, g2.a.w, 3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private j2 b0(final int i) {
        return new j2() { // from class: q64
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.j2
            public final boolean a(View view, j2.a aVar) {
                return SideSheetBehavior.K(this.a, i, view, aVar);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void c0(Context context) {
        if (this.j == null) {
            return;
        }
        l62 l62Var = new l62(this.j);
        this.h = l62Var;
        l62Var.S(context);
        ColorStateList colorStateList = this.i;
        if (colorStateList != null) {
            this.h.e0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.h.setTint(typedValue.data);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SideSheetBehavior f0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            jl.a("The view is not a child of CoordinatorLayout");
            return null;
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
        if (cVarF instanceof SideSheetBehavior) {
            return (SideSheetBehavior) cVarF;
        }
        jl.a("The view is not associated with SideSheetBehavior");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int g0(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), Buffer.MAX_SIZE);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean A0(View view, int i, boolean z) {
        int iP0 = p0(i);
        u35 u35VarT0 = t0();
        if (u35VarT0 != null) {
            return z ? u35VarT0.H(iP0, view.getTop()) : u35VarT0.J(view, iP0, view.getTop());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B0(CoordinatorLayout coordinatorLayout) {
        int i;
        View viewFindViewById;
        if (this.x != null || (i = this.y) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i)) == null) {
            return;
        }
        this.x = new WeakReference(viewFindViewById);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        c cVar = (c) parcelable;
        if (cVar.c() != null) {
            super.D(coordinatorLayout, view, cVar.c());
        }
        int i = cVar.h;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.n = i;
        this.o = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D0() {
        VelocityTracker velocityTracker = this.z;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.z = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
        return new c(super.E(coordinatorLayout, view), this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F0(int i) {
        this.y = i;
        a0();
        WeakReference weakReference = this.w;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i == -1 || !view.isLaidOut()) {
                return;
            }
            view.requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G0(boolean z) {
        this.m = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H0(int i) {
        d64 d64Var = this.f;
        if (d64Var == null || d64Var.j() != i) {
            if (i == 0) {
                this.f = new vt3(this);
                if (this.j == null || w0()) {
                    return;
                }
                y44.b bVarC = this.j.C();
                bVarC.G(0.0f).y(0.0f);
                R0(bVarC.m());
                return;
            }
            if (i != 1) {
                ug4.a("Invalid sheet edge position value: ", i, ". Must be 0 or 1.");
                return;
            }
            this.f = new ns1(this);
            if (this.j == null || v0()) {
                return;
            }
            y44.b bVarC2 = this.j.C();
            bVarC2.C(0.0f).u(0.0f);
            R0(bVarC2.m());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I0(View view, int i) {
        H0(Gravity.getAbsoluteGravity(((CoordinatorLayout.f) view.getLayoutParams()).c, i) == 3 ? 1 : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.n == 1 && actionMasked == 0) {
            return true;
        }
        if (K0()) {
            this.p.A(motionEvent);
        }
        if (actionMasked == 0) {
            D0();
        }
        if (this.z == null) {
            this.z = VelocityTracker.obtain();
        }
        this.z.addMovement(motionEvent);
        if (K0() && actionMasked == 2 && !this.q && x0(motionEvent)) {
            this.p.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J0(int i) {
        View view;
        if (this.n == i) {
            return;
        }
        this.n = i;
        if (i == 3 || i == 5) {
            this.o = i;
        }
        WeakReference weakReference = this.w;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        S0(view);
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((c64) it.next()).a(view, i);
        }
        P0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L0(View view, float f) {
        return this.f.n(view, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M0(View view) {
        return (view.isShown() || l35.n(view) != null) && this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean N0() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference weakReference = this.w;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.w.get();
        View viewJ0 = j0();
        if (viewJ0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) == null) {
            return;
        }
        this.f.o(marginLayoutParams, (int) ((this.s * view.getScaleX()) + this.v));
        viewJ0.requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R0(y44 y44Var) {
        l62 l62Var = this.h;
        if (l62Var != null) {
            l62Var.setShapeAppearanceModel(y44Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S0(View view) {
        int i = this.n == 5 ? 4 : 0;
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Lc64;)V */
    @Override // defpackage.b64
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void b(t64 t64Var) {
        this.C.add(t64Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int X(int i, View view) {
        int i2 = this.n;
        if (i2 == 1 || i2 == 2) {
            return i - this.f.h(view);
        }
        if (i2 == 3) {
            return 0;
        }
        if (i2 == 5) {
            return this.f.e();
        }
        jr1.a("Unexpected value: ", this.n);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float Y(float f, float f2) {
        return Math.abs(f - f2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int Z(View view, float f, float f2) {
        if (y0(f)) {
            return 3;
        }
        if (L0(view, f)) {
            return (this.f.m(f, f2) || this.f.l(view)) ? 5 : 3;
        }
        if (f != 0.0f && g64.a(f, f2)) {
            return 5;
        }
        int left = view.getLeft();
        return Math.abs(left - k0()) < Math.abs(left - this.f.e()) ? 3 : 5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b64
    public void a(final int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference weakReference = this.w;
        if (weakReference == null || weakReference.get() == null) {
            J0(i);
        } else {
            E0((View) this.w.get(), new Runnable() { // from class: p64
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    SideSheetBehavior.L(this.f, i);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a0() {
        WeakReference weakReference = this.x;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.x = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void c() {
        n62 n62Var = this.A;
        if (n62Var == null) {
            return;
        }
        nf nfVarC = n62Var.c();
        if (nfVarC == null || Build.VERSION.SDK_INT < 34) {
            a(5);
        } else {
            this.A.h(nfVarC, l0(), new b(), i0());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void d(nf nfVar) {
        n62 n62Var = this.A;
        if (n62Var == null) {
            return;
        }
        n62Var.l(nfVar, l0());
        Q0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d0(View view, int i) {
        if (this.C.isEmpty()) {
            return;
        }
        float fB = this.f.b(i);
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((c64) it.next()).b(view, fB);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void e(nf nfVar) {
        n62 n62Var = this.A;
        if (n62Var == null) {
            return;
        }
        n62Var.j(nfVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e0(View view) {
        if (l35.n(view) == null) {
            l35.i0(view, view.getResources().getString(E));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void f() {
        n62 n62Var = this.A;
        if (n62Var == null) {
            return;
        }
        n62Var.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b64
    public int getState() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h0() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ValueAnimator.AnimatorUpdateListener i0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewJ0 = j0();
        if (viewJ0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.f.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: r64
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.M(this.a, marginLayoutParams, iC, viewJ0, valueAnimator);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View j0() {
        WeakReference weakReference = this.x;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k0() {
        return this.f.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int l0() {
        d64 d64Var = this.f;
        return (d64Var == null || d64Var.j() == 0) ? 5 : 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void m(CoordinatorLayout.f fVar) {
        super.m(fVar);
        this.w = null;
        this.p = null;
        this.A = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float m0() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float n0() {
        return 0.5f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int o0() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p() {
        super.p();
        this.w = null;
        this.p = null;
        this.A = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p0(int i) {
        if (i == 3) {
            return k0();
        }
        if (i == 5) {
            return this.f.e();
        }
        defpackage.b.a("Invalid state to get outer edge offset: ", i);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        u35 u35Var;
        if (!M0(view)) {
            this.q = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D0();
        }
        if (this.z == null) {
            this.z = VelocityTracker.obtain();
        }
        this.z.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.B = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.q) {
            this.q = false;
            return false;
        }
        return (this.q || (u35Var = this.p) == null || !u35Var.I(motionEvent)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int q0() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.w == null) {
            this.w = new WeakReference(view);
            this.A = new n62(view);
            l62 l62Var = this.h;
            if (l62Var != null) {
                view.setBackground(l62Var);
                l62 l62Var2 = this.h;
                float elevation = this.l;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                l62Var2.d0(elevation);
            } else {
                ColorStateList colorStateList = this.i;
                if (colorStateList != null) {
                    l35.j0(view, colorStateList);
                }
            }
            S0(view);
            P0();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            e0(view);
        }
        I0(view, i);
        if (this.p == null) {
            this.p = u35.n(coordinatorLayout, this.D);
        }
        int iH = this.f.h(view);
        coordinatorLayout.I(view, i);
        this.t = coordinatorLayout.getWidth();
        this.u = this.f.i(coordinatorLayout);
        this.s = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.v = marginLayoutParams != null ? this.f.a(marginLayoutParams) : 0;
        l35.R(view, X(iH, view));
        B0(coordinatorLayout);
        for (c64 c64Var : this.C) {
            if (c64Var instanceof t64) {
                ((t64) c64Var).c(view);
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int r0() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(g0(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, -1, marginLayoutParams.width), g0(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, -1, marginLayoutParams.height));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int s0() {
        return 500;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u35 t0() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CoordinatorLayout.f u0() {
        View view;
        WeakReference weakReference = this.w;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) view.getLayoutParams();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v0() {
        CoordinatorLayout.f fVarU0 = u0();
        return fVarU0 != null && ((ViewGroup.MarginLayoutParams) fVarU0).leftMargin > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w0() {
        CoordinatorLayout.f fVarU0 = u0();
        return fVarU0 != null && ((ViewGroup.MarginLayoutParams) fVarU0).rightMargin > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x0(MotionEvent motionEvent) {
        return K0() && Y((float) this.B, motionEvent.getX()) > ((float) this.p.v());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean y0(float f) {
        return this.f.k(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean z0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && view.isAttachedToWindow();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends p {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public final int h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = parcel.readInt();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
        }

        public c(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.h = sideSheetBehavior.n;
        }
    }

    public SideSheetBehavior() {
        this.k = new d();
        this.m = true;
        this.n = 5;
        this.o = 5;
        this.r = 0.1f;
        this.y = -1;
        this.C = new LinkedHashSet();
        this.D = new a();
    }
}

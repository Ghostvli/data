package com.google.android.material.bottomsheet;

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
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.cn3;
import defpackage.e55;
import defpackage.g2;
import defpackage.j2;
import defpackage.jl;
import defpackage.k62;
import defpackage.l35;
import defpackage.l62;
import defpackage.lk1;
import defpackage.mk1;
import defpackage.mk3;
import defpackage.nf;
import defpackage.p;
import defpackage.r62;
import defpackage.s52;
import defpackage.tm3;
import defpackage.u35;
import defpackage.v52;
import defpackage.w95;
import defpackage.y44;
import defpackage.ym3;
import defpackage.zk3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c implements s52 {
    public static final int u0 = ym3.l;
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public y44 F;
    public boolean G;
    public final i H;
    public ValueAnimator I;
    public int J;
    public int K;
    public int L;
    public float M;
    public int N;
    public float O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public u35 W;
    public boolean X;
    public int Y;
    public boolean Z;
    public float a0;
    public int b0;
    public int c0;
    public int d0;
    public WeakReference e0;
    public int f;
    public WeakReference f0;
    public boolean g;
    public WeakReference g0;
    public boolean h;
    public final List h0;
    public float i;
    public final ArrayList i0;
    public int j;
    public VelocityTracker j0;
    public boolean k;
    public v52 k0;
    public int l;
    public int l0;
    public boolean m;
    public int m0;
    public int n;
    public WeakReference n0;
    public int o;
    public boolean o0;
    public l62 p;
    public Map p0;
    public ColorStateList q;
    public final SparseIntArray q0;
    public int r;
    public final SparseIntArray r0;
    public int s;
    public final SparseIntArray s0;
    public int t;
    public final u35.d t0;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final /* synthetic */ View f;
        public final /* synthetic */ int g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(View view, int i) {
            this.f = view;
            this.g = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.q1(this.f, this.g, false);
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
            BottomSheetBehavior.this.j1(5);
            WeakReference weakReference = BottomSheetBehavior.this.e0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((View) BottomSheetBehavior.this.e0.get()).requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.p != null) {
                BottomSheetBehavior.this.p.f0(fFloatValue);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements e55.c {
        public final /* synthetic */ boolean a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(boolean z) {
            this.a = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // e55.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public w95 a(View view, w95 w95Var, e55.d dVar) {
            boolean z;
            lk1 lk1VarF = w95Var.f(w95.n.e());
            lk1 lk1VarF2 = w95Var.f(w95.n.c());
            BottomSheetBehavior.this.D = lk1VarF.b;
            boolean zF = e55.f(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.v) {
                BottomSheetBehavior.this.C = w95Var.i();
                paddingBottom = dVar.d + BottomSheetBehavior.this.C;
            }
            if (BottomSheetBehavior.this.w) {
                paddingLeft = (zF ? dVar.c : dVar.a) + lk1VarF.a;
            }
            if (BottomSheetBehavior.this.x) {
                paddingRight = (zF ? dVar.a : dVar.c) + lk1VarF.c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z2 = true;
            if (BottomSheetBehavior.this.z) {
                int i = marginLayoutParams.leftMargin;
                int i2 = lk1VarF.a;
                if (i != i2) {
                    marginLayoutParams.leftMargin = i2;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (BottomSheetBehavior.this.A) {
                int i3 = marginLayoutParams.rightMargin;
                int i4 = lk1VarF.c;
                if (i3 != i4) {
                    marginLayoutParams.rightMargin = i4;
                    z = true;
                }
            }
            if (BottomSheetBehavior.this.B) {
                int i5 = marginLayoutParams.topMargin;
                int i6 = lk1VarF.b;
                if (i5 != i6) {
                    marginLayoutParams.topMargin = i6;
                } else {
                    z2 = z;
                }
            }
            if (z2) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.a) {
                BottomSheetBehavior.this.t = lk1VarF2.d;
            }
            if (!BottomSheetBehavior.this.v && !this.a) {
                return w95Var;
            }
            BottomSheetBehavior.this.v1(false);
            return w95Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends u35.d {
        public long a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int b(View view, int i, int i2) {
            return r62.b(i, BottomSheetBehavior.this.z0(), e(view));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int e(View view) {
            boolean zO0 = BottomSheetBehavior.this.o0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return zO0 ? bottomSheetBehavior.d0 : bottomSheetBehavior.N;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public void j(int i) {
            if (i == 1 && BottomSheetBehavior.this.R) {
                BottomSheetBehavior.this.j1(1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.u0(i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // u35.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void l(View view, float f, float f2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i = 6;
            if (f2 < 0.0f) {
                if (bottomSheetBehavior.g) {
                    i = 3;
                } else {
                    int top = view.getTop();
                    long jUptimeMillis = SystemClock.uptimeMillis() - this.a;
                    boolean zO1 = BottomSheetBehavior.this.o1();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (zO1) {
                        if (!bottomSheetBehavior2.l1(jUptimeMillis, (top * 100.0f) / bottomSheetBehavior2.d0)) {
                            i = 4;
                        }
                    } else if (top <= bottomSheetBehavior2.L) {
                    }
                    i = 3;
                }
            } else if (bottomSheetBehavior.P && bottomSheetBehavior.n1(view, f2)) {
                if ((Math.abs(f) < Math.abs(f2) && f2 > BottomSheetBehavior.this.j) || n(view)) {
                    i = 5;
                } else if (BottomSheetBehavior.this.g || Math.abs(view.getTop() - BottomSheetBehavior.this.z0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.L)) {
                }
            } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                int top2 = view.getTop();
                boolean z = BottomSheetBehavior.this.g;
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (!z) {
                    int i2 = bottomSheetBehavior3.L;
                    if (top2 < i2) {
                        if (top2 >= Math.abs(top2 - bottomSheetBehavior3.N)) {
                            if (BottomSheetBehavior.this.o1()) {
                            }
                        }
                    } else if (Math.abs(top2 - i2) >= Math.abs(top2 - BottomSheetBehavior.this.N) || BottomSheetBehavior.this.o1()) {
                    }
                } else if (Math.abs(top2 - bottomSheetBehavior3.K) < Math.abs(top2 - BottomSheetBehavior.this.N)) {
                }
            } else if (!BottomSheetBehavior.this.g) {
                int top3 = view.getTop();
                if (Math.abs(top3 - BottomSheetBehavior.this.L) >= Math.abs(top3 - BottomSheetBehavior.this.N) || BottomSheetBehavior.this.o1()) {
                }
            }
            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
            bottomSheetBehavior4.q1(view, i, bottomSheetBehavior4.p1());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.U;
            if (i2 == 1 || bottomSheetBehavior.o0) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.l0 == i) {
                boolean z = bottomSheetBehavior.k;
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                View viewB0 = z ? bottomSheetBehavior2.n0 != null ? (View) BottomSheetBehavior.this.n0.get() : null : bottomSheetBehavior2.B0();
                if (viewB0 != null && viewB0.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.a = SystemClock.uptimeMillis();
            WeakReference weakReference = BottomSheetBehavior.this.e0;
            return weakReference != null && weakReference.get() == view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.d0 + bottomSheetBehavior.z0()) / 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements j2 {
        public final /* synthetic */ int a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.j2
        public boolean a(View view, j2.a aVar) {
            BottomSheetBehavior.this.a(this.a);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class g {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(View view) {
        }

        public abstract void b(View view, float f);

        public abstract void c(View view, int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.f = 0;
        this.g = true;
        this.h = false;
        this.r = -1;
        this.s = -1;
        this.H = new i(this, null);
        this.M = 0.5f;
        this.O = -1.0f;
        this.R = true;
        this.S = true;
        this.U = 4;
        this.V = 4;
        this.a0 = 0.1f;
        this.h0 = new ArrayList();
        this.i0 = new ArrayList();
        this.m0 = -1;
        this.q0 = new SparseIntArray();
        this.r0 = new SparseIntArray();
        this.s0 = new SparseIntArray();
        this.t0 = new e();
        this.o = context.getResources().getDimensionPixelSize(zk3.d0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cn3.m0);
        if (typedArrayObtainStyledAttributes.hasValue(cn3.q0)) {
            this.q = k62.b(context, typedArrayObtainStyledAttributes, cn3.q0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(cn3.K0)) {
            this.F = y44.i(context, attributeSet, mk3.e, u0).m();
        }
        s0(context);
        t0();
        this.O = typedArrayObtainStyledAttributes.getDimension(cn3.p0, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(cn3.n0)) {
            d1(typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.n0, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(cn3.o0)) {
            c1(typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.o0, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(cn3.y0);
        if (typedValuePeekValue == null || (i2 = typedValuePeekValue.data) != -1) {
            e1(typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.y0, -1));
        } else {
            e1(i2);
        }
        b1(typedArrayObtainStyledAttributes.getBoolean(cn3.w0, false));
        Z0(typedArrayObtainStyledAttributes.getBoolean(cn3.C0, false));
        Y0(typedArrayObtainStyledAttributes.getBoolean(cn3.u0, true));
        i1(typedArrayObtainStyledAttributes.getBoolean(cn3.B0, false));
        V0(typedArrayObtainStyledAttributes.getBoolean(cn3.r0, true));
        W0(typedArrayObtainStyledAttributes.getBoolean(cn3.s0, true));
        g1(typedArrayObtainStyledAttributes.getInt(cn3.z0, 0));
        a1(typedArrayObtainStyledAttributes.getFloat(cn3.v0, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(cn3.t0);
        if (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) {
            X0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.t0, 0));
        } else {
            X0(typedValuePeekValue2.data);
        }
        h1(typedArrayObtainStyledAttributes.getInt(cn3.A0, 500));
        this.k = typedArrayObtainStyledAttributes.getBoolean(cn3.x0, false);
        this.v = typedArrayObtainStyledAttributes.getBoolean(cn3.G0, false);
        this.w = typedArrayObtainStyledAttributes.getBoolean(cn3.H0, false);
        this.x = typedArrayObtainStyledAttributes.getBoolean(cn3.I0, false);
        this.y = typedArrayObtainStyledAttributes.getBoolean(cn3.J0, true);
        this.z = typedArrayObtainStyledAttributes.getBoolean(cn3.D0, false);
        this.A = typedArrayObtainStyledAttributes.getBoolean(cn3.E0, false);
        this.B = typedArrayObtainStyledAttributes.getBoolean(cn3.F0, false);
        this.E = typedArrayObtainStyledAttributes.getBoolean(cn3.L0, true);
        typedArrayObtainStyledAttributes.recycle();
        this.i = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static BottomSheetBehavior x0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            jl.a("The view is not a child of CoordinatorLayout");
            return null;
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
        if (cVarF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVarF;
        }
        jl.a("The view is not associated with BottomSheetBehavior");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l62 A0() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View B0() {
        if (this.h0.isEmpty()) {
            return null;
        }
        return (View) ((WeakReference) this.h0.get(0)).get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C0(int i2) {
        if (i2 == 3) {
            return z0();
        }
        if (i2 == 4) {
            return this.N;
        }
        if (i2 == 5) {
            return this.d0;
        }
        if (i2 == 6) {
            return this.L;
        }
        defpackage.b.a("Invalid state to get top offset: ", i2);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.D(coordinatorLayout, view, hVar.c());
        T0(hVar);
        int i2 = hVar.h;
        if (i2 == 1 || i2 == 2) {
            this.U = 4;
            this.V = 4;
        } else {
            this.U = i2;
            this.V = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float D0() {
        VelocityTracker velocityTracker = this.j0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.i);
        return this.j0.getYVelocity(this.l0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
        return new h(super.E(coordinatorLayout, view), this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E0() {
        Iterator it = this.h0.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean F0() {
        WeakReference weakReference = this.e0;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.e0.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        this.Y = 0;
        this.Z = false;
        return (i2 & 2) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G0() {
        if (this.U == 3) {
            return this.E || F0();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean H0() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
        int i3 = 3;
        if (view.getTop() == z0()) {
            j1(3);
            return;
        }
        if (!L0() || (O0(view2) && this.Z)) {
            if (this.Y > 0) {
                if (!this.g && view.getTop() > this.L) {
                    i3 = 6;
                }
            } else if (this.P && n1(view, D0())) {
                i3 = 5;
            } else if (this.Y == 0) {
                int top = view.getTop();
                if (!this.g) {
                    int i4 = this.L;
                    if (top < i4) {
                        if (top >= Math.abs(top - this.N)) {
                            if (o1()) {
                            }
                        }
                    } else if (Math.abs(top - i4) < Math.abs(top - this.N)) {
                    }
                } else if (Math.abs(top - this.K) >= Math.abs(top - this.N)) {
                    i3 = 4;
                }
            } else {
                if (!this.g) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - this.L) < Math.abs(top2 - this.N)) {
                    }
                }
                i3 = 4;
            }
            q1(view, i3, false);
            this.Z = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean I0() {
        return this.P;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.U == 1 && actionMasked == 0) {
            return true;
        }
        if (m1()) {
            this.W.A(motionEvent);
        }
        if (actionMasked == 0) {
            S0();
        }
        if (this.j0 == null) {
            this.j0 = VelocityTracker.obtain();
        }
        this.j0.addMovement(motionEvent);
        if (m1() && actionMasked == 2 && !this.X && Math.abs(this.m0 - motionEvent.getY()) > this.W.v()) {
            this.W.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.X;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean J0() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean K0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && view.isAttachedToWindow();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L0() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M0(CoordinatorLayout coordinatorLayout, int i2, int i3) {
        WeakReference weakReference = this.g0;
        View view = weakReference != null ? (View) weakReference.get() : null;
        return view != null && coordinatorLayout.B(view, i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean N0(CoordinatorLayout coordinatorLayout, MotionEvent motionEvent) {
        if (this.k) {
            WeakReference weakReference = this.n0;
            return (weakReference == null || weakReference.get() == null) ? false : true;
        }
        View viewB0 = B0();
        return viewB0 != null && coordinatorLayout.B(viewB0, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean O0(View view) {
        Iterator it = this.h0.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P0(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view.isNestedScrollingEnabled()) {
            this.h0.add(new WeakReference(view));
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                P0(viewGroup.getChildAt(i2));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q0(g gVar) {
        this.i0.remove(gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R0(View view, g2.a aVar, int i2) {
        l35.c0(view, aVar, null, r0(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S0() {
        this.l0 = -1;
        this.m0 = -1;
        this.n0 = null;
        VelocityTracker velocityTracker = this.j0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.j0 = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T0(h hVar) {
        int i2 = this.f;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.l = hVar.i;
        }
        if (i2 == -1 || (i2 & 2) == 2) {
            this.g = hVar.j;
        }
        if (i2 == -1 || (i2 & 4) == 4) {
            this.P = hVar.k;
        }
        if (i2 == -1 || (i2 & 8) == 8) {
            this.Q = hVar.l;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U0(View view, Runnable runnable) {
        if (K0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V0(boolean z) {
        this.R = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W0(boolean z) {
        this.S = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X0(int i2) {
        if (i2 < 0) {
            jl.a("offset must be greater than or equal to 0");
        } else {
            this.J = i2;
            t1(this.U, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y0(boolean z) {
        if (this.g == z) {
            return;
        }
        this.g = z;
        if (this.e0 != null) {
            i0();
        }
        j1((this.g && this.U == 6) ? 3 : this.U);
        t1(this.U, true);
        r1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z0(boolean z) {
        this.u = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(int i2) {
        if (i2 == 1 || i2 == 2) {
            StringBuilder sb = new StringBuilder("STATE_");
            sb.append(i2 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.P && i2 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i2);
            return;
        }
        int i3 = (i2 == 6 && this.g && C0(i2) <= this.K) ? 3 : i2;
        WeakReference weakReference = this.e0;
        if (weakReference == null || weakReference.get() == null) {
            j1(i2);
        } else {
            View view = (View) this.e0.get();
            U0(view, new a(view, i3));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a1(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            jl.a("ratio must be a float value between 0 and 1");
            return;
        }
        this.M = f2;
        if (this.e0 != null) {
            k0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b1(boolean z) {
        if (this.P != z) {
            this.P = z;
            if (!z && this.U == 5) {
                a(4);
            }
            r1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void c() {
        v52 v52Var = this.k0;
        if (v52Var == null) {
            return;
        }
        nf nfVarC = v52Var.c();
        if (nfVarC == null || Build.VERSION.SDK_INT < 34) {
            a(this.P ? 5 : 4);
            return;
        }
        boolean z = this.P;
        v52 v52Var2 = this.k0;
        if (z) {
            v52Var2.h(nfVarC, new b());
        } else {
            v52Var2.i(nfVarC, null);
            a(4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c1(int i2) {
        this.s = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void d(nf nfVar) {
        v52 v52Var = this.k0;
        if (v52Var == null) {
            return;
        }
        v52Var.l(nfVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d1(int i2) {
        this.r = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void e(nf nfVar) {
        v52 v52Var = this.k0;
        if (v52Var == null) {
            return;
        }
        v52Var.j(nfVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e1(int i2) {
        f1(i2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s52
    public void f() {
        v52 v52Var = this.k0;
        if (v52Var == null) {
            return;
        }
        v52Var.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f1(int i2, boolean z) {
        boolean z2 = this.m;
        if (i2 == -1) {
            if (z2) {
                return;
            } else {
                this.m = true;
            }
        } else {
            if (!z2 && this.l == i2) {
                return;
            }
            this.m = false;
            this.l = Math.max(0, i2);
        }
        v1(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int g0(View view, int i2, int i3) {
        return l35.c(view, view.getResources().getString(i2), r0(i3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g1(int i2) {
        this.f = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getState() {
        return this.U;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h0(g gVar) {
        if (this.i0.contains(gVar)) {
            return;
        }
        this.i0.add(gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h1(int i2) {
        this.j = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i0() {
        int iM0 = m0();
        boolean z = this.g;
        int i2 = this.d0;
        if (z) {
            this.N = Math.max(i2 - iM0, this.K);
        } else {
            this.N = i2 - iM0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i1(boolean z) {
        this.Q = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float j0(float f2, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f2 > 0.0f) {
                return radius / f2;
            }
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j1(int i2) {
        View view;
        if (this.U == i2) {
            return;
        }
        this.U = i2;
        if (i2 == 4 || i2 == 3 || i2 == 6 || (this.P && i2 == 5)) {
            this.V = i2;
        }
        WeakReference weakReference = this.e0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            u1(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            u1(false);
        }
        t1(i2, true);
        for (int i3 = 0; i3 < this.i0.size(); i3++) {
            ((g) this.i0.get(i3)).c(view, i2);
        }
        r1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k0() {
        this.L = (int) (this.d0 * (1.0f - this.M));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k1(View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || H0() || this.m) ? false : true;
        if (this.v || this.w || this.x || this.z || this.A || this.B || z) {
            e55.a(view, new d(z));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float l0() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        if (this.p == null || (weakReference = this.e0) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.e0.get();
        if (!F0() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(j0(this.p.L(), rootWindowInsets.getRoundedCorner(0)), j0(this.p.M(), rootWindowInsets.getRoundedCorner(1)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean l1(long j, float f2) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void m(CoordinatorLayout.f fVar) {
        super.m(fVar);
        this.e0 = null;
        this.W = null;
        this.k0 = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int m0() {
        int iMin;
        int i2;
        int i3;
        if (this.m) {
            iMin = Math.min(Math.max(this.n, this.d0 - ((this.c0 * 9) / 16)), this.b0);
            i2 = this.C;
        } else {
            if (!this.u && !this.v && (i3 = this.t) > 0) {
                return Math.max(this.l, i3 + this.o);
            }
            iMin = this.l;
            i2 = this.C;
        }
        return iMin + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m1() {
        if (this.W != null) {
            return this.R || this.U == 1;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float n0(int i2) {
        float f2;
        float fZ0;
        int i3 = this.N;
        if (i2 > i3 || i3 == z0()) {
            int i4 = this.N;
            f2 = i4 - i2;
            fZ0 = this.d0 - i4;
        } else {
            int i5 = this.N;
            f2 = i5 - i2;
            fZ0 = i5 - z0();
        }
        return f2 / fZ0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean n1(View view, float f2) {
        if (this.Q) {
            return true;
        }
        if (J0() && view.getTop() >= this.N) {
            return Math.abs((((float) view.getTop()) + (f2 * this.a0)) - ((float) this.N)) / ((float) m0()) > 0.5f;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o0() {
        return I0() && J0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean o1() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p() {
        super.p();
        this.e0 = null;
        this.W = null;
        this.k0 = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p0() {
        return (this.Q && this.P) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p1() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i2;
        u35 u35Var;
        if (!view.isShown() || !this.R) {
            this.X = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            S0();
        }
        if (this.j0 == null) {
            this.j0 = VelocityTracker.obtain();
        }
        this.j0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.m0 = (int) motionEvent.getY();
            WeakReference weakReference = new WeakReference(w0(coordinatorLayout, (int) motionEvent.getX(), (int) motionEvent.getY()));
            this.n0 = weakReference;
            if (this.U != 2 && weakReference.get() != null) {
                this.l0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (!M0(coordinatorLayout, x, this.m0)) {
                    this.o0 = true;
                }
            }
            this.X = this.l0 == -1 && !coordinatorLayout.B(view, x, this.m0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.o0 = false;
            this.n0 = null;
            this.l0 = -1;
            if (this.X) {
                this.X = false;
                return false;
            }
        }
        if (this.X || (u35Var = this.W) == null || !u35Var.I(motionEvent)) {
            return (actionMasked != 2 || !E0() || this.X || this.U == 1 || N0(coordinatorLayout, motionEvent) || this.W == null || (i2 = this.m0) == -1 || Math.abs(((float) i2) - motionEvent.getY()) <= ((float) this.W.v())) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(View view, int i2) {
        if (view == null) {
            return;
        }
        l35.a0(view, 1048576);
        l35.a0(view, 524288);
        l35.a0(view, 262144);
        int i3 = this.r0.get(i2, -1);
        if (i3 != -1) {
            l35.a0(view, i3);
            this.r0.delete(i2);
        }
        int i4 = this.q0.get(i2, -1);
        if (i4 != -1) {
            l35.a0(view, i4);
            this.q0.delete(i2);
        }
        int i5 = this.s0.get(i2, -1);
        if (i5 != -1) {
            l35.a0(view, i5);
            this.s0.delete(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q1(View view, int i2, boolean z) {
        int iC0 = C0(i2);
        u35 u35Var = this.W;
        if (u35Var == null || (!z ? u35Var.J(view, view.getLeft(), iC0) : u35Var.H(view.getLeft(), iC0))) {
            j1(i2);
            return;
        }
        j1(2);
        t1(i2, true);
        this.H.c(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i2) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.e0 == null) {
            this.n = coordinatorLayout.getResources().getDimensionPixelSize(zk3.i);
            k1(view);
            l35.x0(view, new mk1(view));
            this.e0 = new WeakReference(view);
            this.k0 = new v52(view);
            l62 l62Var = this.p;
            if (l62Var != null) {
                view.setBackground(l62Var);
                l62 l62Var2 = this.p;
                float elevation = this.O;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                l62Var2.d0(elevation);
            } else {
                ColorStateList colorStateList = this.q;
                if (colorStateList != null) {
                    l35.j0(view, colorStateList);
                }
            }
            r1();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.W == null) {
            this.W = u35.n(coordinatorLayout, this.t0);
        }
        int top = view.getTop();
        coordinatorLayout.I(view, i2);
        this.c0 = coordinatorLayout.getWidth();
        this.d0 = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.b0 = height;
        int iMin = this.d0;
        int i3 = iMin - height;
        int i4 = this.D;
        if (i3 < i4) {
            boolean z = this.y;
            int i5 = this.s;
            if (z) {
                if (i5 != -1) {
                    iMin = Math.min(iMin, i5);
                }
                this.b0 = iMin;
            } else {
                int iMin2 = iMin - i4;
                if (i5 != -1) {
                    iMin2 = Math.min(iMin2, i5);
                }
                this.b0 = iMin2;
            }
        }
        this.K = Math.max(0, this.d0 - this.b0);
        k0();
        i0();
        int i6 = this.U;
        if (i6 == 3) {
            l35.S(view, z0());
        } else if (i6 == 6) {
            l35.S(view, this.L);
        } else if (this.P && i6 == 5) {
            l35.S(view, this.d0);
        } else if (i6 == 4) {
            l35.S(view, this.N);
        } else if (i6 == 1 || i6 == 2) {
            l35.S(view, top - view.getTop());
        }
        t1(this.U, false);
        this.h0.clear();
        if (this.k) {
            P0(view);
        } else {
            this.h0.add(new WeakReference(v0(view)));
        }
        for (int i7 = 0; i7 < this.i0.size(); i7++) {
            ((g) this.i0.get(i7)).a(view);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final j2 r0(int i2) {
        return new f(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r1() {
        WeakReference weakReference = this.e0;
        if (weakReference != null) {
            s1((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.f0;
        if (weakReference2 != null) {
            s1((View) weakReference2.get(), 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(y0(i2, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, this.r, marginLayoutParams.width), y0(i4, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, this.s, marginLayoutParams.height));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s0(Context context) {
        if (this.F == null) {
            return;
        }
        l62 l62Var = new l62(this.F);
        this.p = l62Var;
        l62Var.S(context);
        ColorStateList colorStateList = this.q;
        if (colorStateList != null) {
            this.p.e0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.p.setTint(typedValue.data);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s1(View view, int i2) {
        if (view == null) {
            return;
        }
        q0(view, i2);
        if (!this.g && this.U != 6) {
            this.q0.put(i2, g0(view, tm3.c, 6));
        }
        if (this.P && J0() && this.U != 5) {
            R0(view, g2.a.y, 5);
        }
        int i3 = this.U;
        if (i3 == 3) {
            if (p0()) {
                this.s0.put(i2, g0(view, tm3.a, 4));
            }
        } else if (i3 == 4) {
            this.r0.put(i2, g0(view, tm3.b, 3));
        } else {
            if (i3 != 6) {
                return;
            }
            if (p0()) {
                this.s0.put(i2, g0(view, tm3.a, 4));
            }
            this.r0.put(i2, g0(view, tm3.b, 3));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(l0(), 1.0f);
        this.I = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.I.addUpdateListener(new c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t1(int i2, boolean z) {
        boolean zG0;
        ValueAnimator valueAnimator;
        if (i2 == 2 || this.G == (zG0 = G0()) || this.p == null) {
            return;
        }
        this.G = zG0;
        if (!z || (valueAnimator = this.I) == null) {
            ValueAnimator valueAnimator2 = this.I;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.I.cancel();
            }
            this.p.f0(this.G ? l0() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.I.reverse();
        } else {
            this.I.setFloatValues(this.p.D(), zG0 ? l0() : 1.0f);
            this.I.start();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean u(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        return L0() && E0() && O0(view2) && (!(this.U == 3 || this.T) || super.u(coordinatorLayout, view, view2, f2, f3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u0(int i2) {
        View view = (View) this.e0.get();
        if (view == null || this.i0.isEmpty()) {
            return;
        }
        float fN0 = n0(i2);
        for (int i3 = 0; i3 < this.i0.size(); i3++) {
            ((g) this.i0.get(i3)).b(view, fN0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u1(boolean z) {
        Map map;
        WeakReference weakReference = this.e0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.p0 != null) {
                    return;
                } else {
                    this.p0 = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.e0.get()) {
                    if (z) {
                        this.p0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.h) {
                            childAt.setImportantForAccessibility(4);
                        }
                    } else if (this.h && (map = this.p0) != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(((Integer) this.p0.get(childAt)).intValue());
                    }
                }
            }
            if (!z) {
                this.p0 = null;
            } else if (this.h) {
                ((View) this.e0.get()).sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View v0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View viewV0 = v0(viewGroup.getChildAt(i2));
                if (viewV0 != null) {
                    return viewV0;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v1(boolean z) {
        View view;
        if (this.e0 != null) {
            i0();
            if (this.U != 4 || (view = (View) this.e0.get()) == null) {
                return;
            }
            if (z) {
                a(4);
            } else {
                view.requestLayout();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        boolean zO0 = O0(view2);
        if (!L0() || zO0) {
            int top = view.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (!this.Z && !this.S && zO0 && view2.canScrollVertically(1)) {
                    this.T = true;
                    return;
                }
                if (i5 < z0()) {
                    int iZ0 = top - z0();
                    iArr[1] = iZ0;
                    l35.S(view, -iZ0);
                    j1(3);
                } else {
                    if (!this.R) {
                        return;
                    }
                    iArr[1] = i3;
                    l35.S(view, -i3);
                    j1(1);
                }
            } else if (i3 < 0) {
                boolean zCanScrollVertically = view2.canScrollVertically(-1);
                if (!this.Z && !this.S && zO0 && zCanScrollVertically) {
                    this.T = true;
                    return;
                }
                if (!zCanScrollVertically) {
                    if (i5 > this.N && !o0()) {
                        int i6 = top - this.N;
                        iArr[1] = i6;
                        l35.S(view, -i6);
                        j1(4);
                    } else {
                        if (!this.R) {
                            return;
                        }
                        iArr[1] = i3;
                        l35.S(view, -i3);
                        j1(1);
                    }
                }
            }
            u0(view.getTop());
            this.Y = i3;
            this.Z = true;
            this.T = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View w0(CoordinatorLayout coordinatorLayout, int i2, int i3) {
        if (this.h0.isEmpty()) {
            return null;
        }
        Iterator it = this.h0.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view != null && coordinatorLayout.B(view, i2, i3)) {
                return view;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int y0(int i2, int i3, int i4, int i5) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i3, i5);
        if (i4 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i4), Buffer.MAX_SIZE);
        }
        if (size != 0) {
            i4 = Math.min(size, i4);
        }
        return View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int z0() {
        if (this.g) {
            return this.K;
        }
        return Math.max(this.J, this.y ? 0 : this.D);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i {
        public int a;
        public boolean b;
        public final Runnable c;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Runnable {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                i.this.b = false;
                u35 u35Var = BottomSheetBehavior.this.W;
                if (u35Var != null && u35Var.l(true)) {
                    i iVar = i.this;
                    iVar.c(iVar.a);
                    return;
                }
                i iVar2 = i.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.U == 2) {
                    bottomSheetBehavior.j1(iVar2.a);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i() {
            this.c = new a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(int i) {
            WeakReference weakReference = BottomSheetBehavior.this.e0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a = i;
            if (this.b) {
                return;
            }
            ((View) BottomSheetBehavior.this.e0.get()).postOnAnimation(this.c);
            this.b = true;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 com.google.android.material.bottomsheet.BottomSheetBehavior) A[MD:(com.google.android.material.bottomsheet.BottomSheetBehavior):void (m)] (LINE:14) call: com.google.android.material.bottomsheet.BottomSheetBehavior.i.<init>(com.google.android.material.bottomsheet.BottomSheetBehavior):void type: THIS */
        public /* synthetic */ i(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends p {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public final int h;
        public int i;
        public boolean j;
        public boolean k;
        public boolean l;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, (ClassLoader) null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1;
            this.l = parcel.readInt() == 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeInt(this.l ? 1 : 0);
        }

        public h(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.h = bottomSheetBehavior.U;
            this.i = bottomSheetBehavior.l;
            this.j = bottomSheetBehavior.g;
            this.k = bottomSheetBehavior.P;
            this.l = bottomSheetBehavior.Q;
        }
    }

    public BottomSheetBehavior() {
        this.f = 0;
        this.g = true;
        this.h = false;
        this.r = -1;
        this.s = -1;
        this.H = new i(this, null);
        this.M = 0.5f;
        this.O = -1.0f;
        this.R = true;
        this.S = true;
        this.U = 4;
        this.V = 4;
        this.a0 = 0.1f;
        this.h0 = new ArrayList();
        this.i0 = new ArrayList();
        this.m0 = -1;
        this.q0 = new SparseIntArray();
        this.r0 = new SparseIntArray();
        this.s0 = new SparseIntArray();
        this.t0 = new e();
    }
}

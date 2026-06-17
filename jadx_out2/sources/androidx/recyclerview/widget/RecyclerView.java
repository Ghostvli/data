package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.i;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.t;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.e04;
import defpackage.ep3;
import defpackage.fp3;
import defpackage.fu2;
import defpackage.g2;
import defpackage.gp3;
import defpackage.gq4;
import defpackage.hg3;
import defpackage.ho1;
import defpackage.hp3;
import defpackage.ib3;
import defpackage.in3;
import defpackage.jl;
import defpackage.jq0;
import defpackage.kk3;
import defpackage.l23;
import defpackage.l35;
import defpackage.m23;
import defpackage.nl;
import defpackage.o35;
import defpackage.ql0;
import defpackage.r1;
import defpackage.rf3;
import defpackage.rl0;
import defpackage.s1;
import defpackage.vh;
import defpackage.w82;
import defpackage.wx1;
import defpackage.xk3;
import defpackage.yo1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements l23 {
    public static boolean J0;
    public static boolean K0;
    public static final int[] L0 = {R.attr.nestedScrollingEnabled};
    public static final float M0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean N0 = false;
    public static final boolean O0 = true;
    public static final boolean P0 = true;
    public static final Class[] Q0;
    public static final Interpolator R0;
    public static final d0 S0;
    public boolean A;
    public final List A0;
    public int B;
    public Runnable B0;
    public boolean C;
    public boolean C0;
    public boolean D;
    public int D0;
    public boolean E;
    public int E0;
    public int F;
    public boolean F0;
    public boolean G;
    public final t.b G0;
    public final AccessibilityManager H;
    public final rl0 H0;
    public List I;
    public ql0 I0;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public m N;
    public EdgeEffect O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public EdgeEffect R;
    public n S;
    public int T;
    public int U;
    public VelocityTracker V;
    public int W;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public t e0;
    public final float f;
    public final int f0;
    public final z g;
    public final int g0;
    public final x h;
    public float h0;
    public a0 i;
    public float i0;
    public androidx.recyclerview.widget.a j;
    public boolean j0;
    public androidx.recyclerview.widget.e k;
    public final f0 k0;
    public final androidx.recyclerview.widget.t l;
    public androidx.recyclerview.widget.i l0;
    public boolean m;
    public i.b m0;
    public final Runnable n;
    public final c0 n0;
    public final Rect o;
    public v o0;
    public final Rect p;
    public List p0;
    public final RectF q;
    public boolean q0;
    public h r;
    public boolean r0;
    public q s;
    public n.a s0;
    public final List t;
    public boolean t0;
    public final ArrayList u;
    public androidx.recyclerview.widget.o u0;
    public final ArrayList v;
    public final int[] v0;
    public u w;
    public m23 w0;
    public boolean x;
    public final int[] x0;
    public boolean y;
    public final int[] y0;
    public boolean z;
    public final int[] z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.A || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.x) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.D) {
                recyclerView2.C = true;
            } else {
                recyclerView2.z();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            n nVar = RecyclerView.this.S;
            if (nVar != null) {
                nVar.u();
            }
            RecyclerView.this.t0 = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Interpolator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c0 {
        public SparseArray b;
        public int m;
        public long n;
        public int o;
        public int p;
        public int q;
        public int a = -1;
        public int c = 0;
        public int d = 0;
        public int e = 1;
        public int f = 0;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(int i) {
            if ((this.e & i) != 0) {
                return;
            }
            vh.a("Layout state should be one of ", Integer.toBinaryString(i), " but it is ", Integer.toBinaryString(this.e));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            return this.h ? this.c - this.d : this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d() {
            return this.a != -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean e() {
            return this.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(h hVar) {
            this.e = 1;
            this.f = hVar.g();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean g() {
            return this.l;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements t.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.t.b
        public void a(g0 g0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.s.L1(g0Var.f, recyclerView.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.t.b
        public void b(g0 g0Var, n.b bVar, n.b bVar2) {
            RecyclerView.this.n(g0Var, bVar, bVar2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.t.b
        public void c(g0 g0Var, n.b bVar, n.b bVar2) {
            RecyclerView.this.h.O(g0Var);
            RecyclerView.this.p(g0Var, bVar, bVar2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.t.b
        public void d(g0 g0Var, n.b bVar, n.b bVar2) {
            g0Var.H(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.J) {
                if (recyclerView.S.b(g0Var, g0Var, bVar, bVar2)) {
                    RecyclerView.this.W0();
                }
            } else if (recyclerView.S.d(g0Var, bVar, bVar2)) {
                RecyclerView.this.W0();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d0 extends m {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.m
        public EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements rl0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rl0
        public boolean a(float f) {
            int i;
            int i2;
            if (RecyclerView.this.s.M()) {
                i2 = (int) f;
                i = 0;
            } else if (RecyclerView.this.s.L()) {
                i = (int) f;
                i2 = 0;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            RecyclerView.this.J1();
            return RecyclerView.this.i0(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rl0
        public float b() {
            float f;
            boolean zM = RecyclerView.this.s.M();
            RecyclerView recyclerView = RecyclerView.this;
            if (zM) {
                f = recyclerView.i0;
            } else {
                if (!recyclerView.s.L()) {
                    return 0.0f;
                }
                f = RecyclerView.this.h0;
            }
            return -f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rl0
        public void c() {
            RecyclerView.this.J1();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class e0 {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements e.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void b(View view) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (g0VarO0 != null) {
                g0VarO0.C(RecyclerView.this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void d() {
            int iC = c();
            for (int i = 0; i < iC; i++) {
                View viewA = a(i);
                RecyclerView.this.E(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public g0 f(View view) {
            return RecyclerView.o0(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void g(int i) {
            View viewA = a(i);
            if (viewA != null) {
                g0 g0VarO0 = RecyclerView.o0(viewA);
                if (g0VarO0 != null) {
                    if (g0VarO0.y() && !g0VarO0.K()) {
                        StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                        sb.append(g0VarO0);
                        gp3.a(sb, RecyclerView.this.U());
                        return;
                    } else {
                        if (RecyclerView.K0) {
                            Log.d("RecyclerView", "tmpDetach " + g0VarO0);
                        }
                        g0VarO0.b(Buffer.DEFAULT_SIZE);
                    }
                }
            } else if (RecyclerView.J0) {
                fp3.a("No view at offset ", i, RecyclerView.this.U());
                return;
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void h(View view) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (g0VarO0 != null) {
                g0VarO0.D(RecyclerView.this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void i(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.D(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void j(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.E(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.e.b
        public void k(View view, int i, ViewGroup.LayoutParams layoutParams) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (g0VarO0 != null) {
                if (!g0VarO0.y() && !g0VarO0.K()) {
                    StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                    sb.append(g0VarO0);
                    gp3.a(sb, RecyclerView.this.U());
                    return;
                } else {
                    if (RecyclerView.K0) {
                        Log.d("RecyclerView", "reAttach " + g0VarO0);
                    }
                    g0VarO0.f();
                }
            } else if (RecyclerView.J0) {
                StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
                sb2.append(view);
                String strU = RecyclerView.this.U();
                sb2.append(", index: ");
                sb2.append(i);
                sb2.append(strU);
                throw new IllegalArgumentException(sb2.toString());
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f0 implements Runnable {
        public int f;
        public int g;
        public OverScroller h;
        public Interpolator i;
        public boolean j;
        public boolean k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f0() {
            Interpolator interpolator = RecyclerView.R0;
            this.i = interpolator;
            this.j = false;
            this.k = false;
            this.h = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int a(int i, int i2) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.g = 0;
            this.f = 0;
            Interpolator interpolator = this.i;
            Interpolator interpolator2 = RecyclerView.R0;
            if (interpolator != interpolator2) {
                this.i = interpolator2;
                this.h = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.h.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c() {
            RecyclerView.this.removeCallbacks(this);
            l35.Y(RecyclerView.this, this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            if (this.j) {
                this.k = true;
            } else {
                c();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.R0;
            }
            if (this.i != interpolator) {
                this.i = interpolator;
                this.h = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.g = 0;
            this.f = 0;
            RecyclerView.this.setScrollState(2);
            this.h.startScroll(0, 0, i, i2, i4);
            d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.s == null) {
                stop();
                return;
            }
            this.k = false;
            this.j = true;
            recyclerView.z();
            OverScroller overScroller = this.h;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f;
                int i4 = currY - this.g;
                this.f = currX;
                this.g = currY;
                int iW = RecyclerView.this.w(i3);
                int iY = RecyclerView.this.y(i4);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.z0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.K(iW, iY, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.z0;
                    iW -= iArr2[0];
                    iY -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.v(iW, iY);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.r != null) {
                    int[] iArr3 = recyclerView3.z0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.s1(iW, iY, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.z0;
                    int i5 = iArr4[0];
                    int i6 = iArr4[1];
                    iW -= i5;
                    iY -= i6;
                    b0 b0Var = recyclerView4.s.g;
                    if (b0Var != null && !b0Var.g() && b0Var.h()) {
                        int iB = RecyclerView.this.n0.b();
                        if (iB == 0) {
                            b0Var.r();
                        } else if (b0Var.f() >= iB) {
                            b0Var.p(iB - 1);
                            b0Var.j(i5, i6);
                        } else {
                            b0Var.j(i5, i6);
                        }
                    }
                    i2 = i6;
                    i = i5;
                } else {
                    i = 0;
                    i2 = 0;
                }
                int i7 = iW;
                int i8 = iY;
                if (!RecyclerView.this.u.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.z0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.L(i, i2, i7, i8, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.z0;
                int i9 = i7 - iArr6[0];
                int i10 = i8 - iArr6[1];
                if (i != 0 || i2 != 0) {
                    recyclerView6.N(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i9 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i10 != 0));
                b0 b0Var2 = RecyclerView.this.s.g;
                if ((b0Var2 == null || !b0Var2.g()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i11 = i9 < 0 ? -currVelocity : i9 > 0 ? currVelocity : 0;
                        if (i10 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i10 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i11, currVelocity);
                    }
                    if (RecyclerView.P0) {
                        RecyclerView.this.m0.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.i iVar = recyclerView7.l0;
                    if (iVar != null) {
                        iVar.f(recyclerView7, i, i2);
                    }
                }
                if (Build.VERSION.SDK_INT >= 35) {
                    k.a(RecyclerView.this, Math.abs(overScroller.getCurrVelocity()));
                }
            }
            b0 b0Var3 = RecyclerView.this.s.g;
            if (b0Var3 != null && b0Var3.g()) {
                b0Var3.j(0, 0);
            }
            this.j = false;
            if (this.k) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.I1(1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.h.abortAnimation();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements a.InterfaceC0039a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void a(int i, int i2) {
            RecyclerView.this.M0(i, i2);
            RecyclerView.this.q0 = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void b(a.b bVar) {
            i(bVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void c(int i, int i2, Object obj) {
            RecyclerView.this.L1(i, i2, obj);
            RecyclerView.this.r0 = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void d(a.b bVar) {
            i(bVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public g0 e(int i) {
            g0 g0VarF0 = RecyclerView.this.f0(i, true);
            if (g0VarF0 == null) {
                return null;
            }
            if (!RecyclerView.this.k.n(g0VarF0.f)) {
                return g0VarF0;
            }
            if (RecyclerView.K0) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void f(int i, int i2) {
            RecyclerView.this.N0(i, i2, false);
            RecyclerView.this.q0 = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void g(int i, int i2) {
            RecyclerView.this.L0(i, i2);
            RecyclerView.this.q0 = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void h(int i, int i2) {
            RecyclerView.this.N0(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.q0 = true;
            recyclerView.n0.d += i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(a.b bVar) {
            int i = bVar.a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.s.p1(recyclerView, bVar.b, bVar.d);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.s.s1(recyclerView2, bVar.b, bVar.d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.s.u1(recyclerView3, bVar.b, bVar.d, bVar.c);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.s.r1(recyclerView4, bVar.b, bVar.d, 1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class g0 {
        public static final List y = Collections.EMPTY_LIST;
        public final View f;
        public WeakReference g;
        public int o;
        public RecyclerView w;
        public h x;
        public int h = -1;
        public int i = -1;
        public long j = -1;
        public int k = -1;
        public int l = -1;
        public g0 m = null;
        public g0 n = null;
        public List p = null;
        public List q = null;
        public int r = 0;
        public x s = null;
        public boolean t = false;
        public int u = 0;
        public int v = -1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g0(View view) {
            if (view != null) {
                this.f = view;
            } else {
                jl.a("itemView may not be null");
                throw null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean A() {
            return (this.o & 2) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void B(int i, boolean z) {
            if (this.i == -1) {
                this.i = this.h;
            }
            if (this.l == -1) {
                this.l = this.h;
            }
            if (z) {
                this.l += i;
            }
            this.h += i;
            if (this.f.getLayoutParams() != null) {
                ((r) this.f.getLayoutParams()).h = true;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void C(RecyclerView recyclerView) {
            int i = this.v;
            if (i != -1) {
                this.u = i;
            } else {
                this.u = this.f.getImportantForAccessibility();
            }
            recyclerView.v1(this, 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void D(RecyclerView recyclerView) {
            recyclerView.v1(this, this.u);
            this.u = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void E() {
            if (RecyclerView.J0 && y()) {
                wx1.a("Attempting to reset temp-detached ViewHolder: ", this, ". ViewHolders should be fully detached before resetting.");
                return;
            }
            this.o = 0;
            this.h = -1;
            this.i = -1;
            this.j = -1L;
            this.l = -1;
            this.r = 0;
            this.m = null;
            this.n = null;
            d();
            this.u = 0;
            this.v = -1;
            RecyclerView.t(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void F() {
            if (this.i == -1) {
                this.i = this.h;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void G(int i, int i2) {
            this.o = (i & i2) | (this.o & (~i2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void H(boolean z) {
            int i = this.r;
            int i2 = z ? i - 1 : i + 1;
            this.r = i2;
            if (i2 < 0) {
                this.r = 0;
                if (RecyclerView.J0) {
                    ib3.a("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ", this);
                    return;
                } else {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else if (!z && i2 == 1) {
                this.o |= 16;
            } else if (z && i2 == 0) {
                this.o &= -17;
            }
            if (RecyclerView.K0) {
                Log.d("RecyclerView", "setIsRecyclable val:" + z + ":" + this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void I(x xVar, boolean z) {
            this.s = xVar;
            this.t = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean J() {
            return (this.o & 16) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean K() {
            return (this.o & 128) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void L() {
            this.s.O(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean M() {
            return (this.o & 32) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.o) == 0) {
                g();
                this.p.add(obj);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i) {
            this.o = i | this.o;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            this.i = -1;
            this.l = -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            List list = this.p;
            if (list != null) {
                list.clear();
            }
            this.o &= -1025;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e() {
            this.o &= -33;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f() {
            this.o &= -257;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g() {
            if (this.p == null) {
                ArrayList arrayList = new ArrayList();
                this.p = arrayList;
                this.q = Collections.unmodifiableList(arrayList);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean h() {
            return (this.o & 16) == 0 && l35.K(this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(int i, int i2, boolean z) {
            b(8);
            B(i2, z);
            this.h = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int j() {
            RecyclerView recyclerView = this.w;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.j0(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int k() {
            RecyclerView recyclerView;
            h adapter;
            int iJ0;
            if (this.x == null || (recyclerView = this.w) == null || (adapter = recyclerView.getAdapter()) == null || (iJ0 = this.w.j0(this)) == -1) {
                return -1;
            }
            return adapter.f(this.x, this, iJ0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long l() {
            return this.j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int m() {
            return this.k;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int n() {
            int i = this.l;
            return i == -1 ? this.h : i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int o() {
            return this.i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List p() {
            if ((this.o & 1024) != 0) {
                return y;
            }
            List list = this.p;
            return (list == null || list.size() == 0) ? y : this.q;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean q(int i) {
            return (this.o & i) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean r() {
            return (this.o & 512) != 0 || u();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean s() {
            return (this.f.getParent() == null || this.f.getParent() == this.w) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean t() {
            return (this.o & 1) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.h + " id=" + this.j + ", oldPos=" + this.i + ", pLpos:" + this.l);
            if (x()) {
                sb.append(" scrap ");
                sb.append(this.t ? "[changeScrap]" : "[attachedScrap]");
            }
            if (u()) {
                sb.append(" invalid");
            }
            if (!t()) {
                sb.append(" unbound");
            }
            if (A()) {
                sb.append(" update");
            }
            if (w()) {
                sb.append(" removed");
            }
            if (K()) {
                sb.append(" ignored");
            }
            if (y()) {
                sb.append(" tmpDetached");
            }
            if (!v()) {
                sb.append(" not recyclable(" + this.r + ")");
            }
            if (r()) {
                sb.append(" undefined adapter position");
            }
            if (this.f.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean u() {
            return (this.o & 4) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean v() {
            return (this.o & 16) == 0 && !l35.K(this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean w() {
            return (this.o & 8) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean x() {
            return this.s != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean y() {
            return (this.o & Buffer.DEFAULT_SIZE) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean z() {
            return (this.o & 2) != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class h {
        public final i a = new i();
        public boolean b = false;
        public a c = a.ALLOW;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void A(g0 g0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void B(g0 g0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void C(g0 g0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void D(j jVar) {
            this.a.registerObserver(jVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void E(boolean z) {
            if (j()) {
                e04.a("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            } else {
                this.b = z;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void F(j jVar) {
            this.a.unregisterObserver(jVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c(g0 g0Var, int i) {
            boolean z = g0Var.x == null;
            if (z) {
                g0Var.h = i;
                if (k()) {
                    g0Var.j = h(i);
                }
                g0Var.G(1, 519);
                if (gq4.c()) {
                    Trace.beginSection(String.format("RV onBindViewHolder type=0x%X", Integer.valueOf(g0Var.k)));
                }
            }
            g0Var.x = this;
            if (RecyclerView.J0) {
                if (g0Var.f.getParent() == null && g0Var.f.isAttachedToWindow() != g0Var.y()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + g0Var.y() + ", attached to window: " + g0Var.f.isAttachedToWindow() + ", holder: " + g0Var);
                }
                if (g0Var.f.getParent() == null && g0Var.f.isAttachedToWindow()) {
                    ho1.a("Attempting to bind attached holder with no parent (AKA temp detached): ", g0Var);
                    return;
                }
            }
            w(g0Var, i, g0Var.p());
            if (z) {
                g0Var.d();
                ViewGroup.LayoutParams layoutParams = g0Var.f.getLayoutParams();
                if (layoutParams instanceof r) {
                    ((r) layoutParams).h = true;
                }
                Trace.endSection();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d() {
            int iOrdinal = this.c.ordinal();
            return iOrdinal != 1 ? iOrdinal != 2 : g() > 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final g0 e(ViewGroup viewGroup, int i) {
            try {
                if (gq4.c()) {
                    Trace.beginSection(String.format("RV onCreateViewHolder type=0x%X", Integer.valueOf(i)));
                }
                g0 g0VarX = x(viewGroup, i);
                if (g0VarX.f.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                g0VarX.k = i;
                return g0VarX;
            } finally {
                Trace.endSection();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int f(h hVar, g0 g0Var, int i) {
            if (hVar == this) {
                return i;
            }
            return -1;
        }

        public abstract int g();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long h(int i) {
            return -1L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int i(int i) {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean j() {
            return this.a.a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean k() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void l() {
            this.a.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m(int i) {
            this.a.d(i, 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void n(int i) {
            this.a.f(i, 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void o(int i, int i2) {
            this.a.c(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p(int i, int i2) {
            this.a.d(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void q(int i, int i2, Object obj) {
            this.a.e(i, i2, obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r(int i, int i2) {
            this.a.f(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void s(int i, int i2) {
            this.a.g(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void t(int i) {
            this.a.g(i, 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void u(RecyclerView recyclerView) {
        }

        public abstract void v(g0 g0Var, int i);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void w(g0 g0Var, int i, List list) {
            v(g0Var, i);
        }

        public abstract g0 x(ViewGroup viewGroup, int i);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void y(RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean z(g0 g0Var) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends Observable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).d(i, i2, 1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(int i, int i2) {
            e(i, i2, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).b(i, i2, obj);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).c(i, i2);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).e(i, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class j {
        public abstract void a();

        public abstract void b(int i, int i2, Object obj);

        public abstract void c(int i, int i2);

        public abstract void d(int i, int i2, int i3);

        public abstract void e(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(View view, float f) {
            try {
                view.setFrameContentVelocity(f);
            } catch (LinkageError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface l {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m {
        public abstract EdgeEffect a(RecyclerView recyclerView, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class n {
        public a a = null;
        public ArrayList b = new ArrayList();
        public long c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface a {
            void a(g0 g0Var);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class b {
            public int a;
            public int b;
            public int c;
            public int d;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b a(g0 g0Var) {
                return b(g0Var, 0);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b b(g0 g0Var, int i) {
                View view = g0Var.f;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int e(g0 g0Var) {
            int i = g0Var.o;
            int i2 = i & 14;
            if (g0Var.u()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int iO = g0Var.o();
                int iJ = g0Var.j();
                if (iO != -1 && iJ != -1 && iO != iJ) {
                    return i2 | 2048;
                }
            }
            return i2;
        }

        public abstract boolean a(g0 g0Var, b bVar, b bVar2);

        public abstract boolean b(g0 g0Var, g0 g0Var2, b bVar, b bVar2);

        public abstract boolean c(g0 g0Var, b bVar, b bVar2);

        public abstract boolean d(g0 g0Var, b bVar, b bVar2);

        public abstract boolean f(g0 g0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean g(g0 g0Var, List list) {
            return f(g0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h(g0 g0Var) {
            r(g0Var);
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(g0Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void i() {
            int size = this.b.size();
            ArrayList arrayList = this.b;
            if (size <= 0) {
                arrayList.clear();
            } else {
                w82.a(arrayList.get(0));
                throw null;
            }
        }

        public abstract void j(g0 g0Var);

        public abstract void k();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long l() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long m() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long n() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long o() {
            return this.d;
        }

        public abstract boolean p();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b q() {
            return new b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r(g0 g0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b s(c0 c0Var, g0 g0Var) {
            return q().a(g0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b t(c0 c0Var, g0 g0Var, int i, List list) {
            return q().a(g0Var);
        }

        public abstract void u();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void v(a aVar) {
            this.a = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class o implements n.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public o() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.n.a
        public void a(g0 g0Var) {
            g0Var.H(true);
            if (g0Var.m != null && g0Var.n == null) {
                g0Var.m = null;
            }
            g0Var.n = null;
            if (g0Var.J() || RecyclerView.this.h1(g0Var.f) || !g0Var.y()) {
                return;
            }
            RecyclerView.this.removeDetachedView(g0Var.f, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class p {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(Rect rect, View view, RecyclerView recyclerView, c0 c0Var) {
            d(rect, ((r) view.getLayoutParams()).c(), recyclerView);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(Canvas canvas, RecyclerView recyclerView, c0 c0Var) {
            f(canvas, recyclerView);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(Canvas canvas, RecyclerView recyclerView, c0 c0Var) {
            h(canvas, recyclerView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class q {
        public androidx.recyclerview.widget.e a;
        public RecyclerView b;
        public final s.b c;
        public final s.b d;
        public androidx.recyclerview.widget.s e;
        public androidx.recyclerview.widget.s f;
        public b0 g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements s.b {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public View a(int i) {
                return q.this.j0(i);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int b(View view) {
                return q.this.r0(view) - ((ViewGroup.MarginLayoutParams) ((r) view.getLayoutParams())).leftMargin;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int c() {
                return q.this.y();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int d() {
                return q.this.K0() - q.this.p();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int e(View view) {
                return q.this.u0(view) + ((ViewGroup.MarginLayoutParams) ((r) view.getLayoutParams())).rightMargin;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b implements s.b {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public View a(int i) {
                return q.this.j0(i);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int b(View view) {
                return q.this.v0(view) - ((ViewGroup.MarginLayoutParams) ((r) view.getLayoutParams())).topMargin;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int c() {
                return q.this.w();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int d() {
                return q.this.x0() - q.this.b();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.s.b
            public int e(View view) {
                return q.this.p0(view) + ((ViewGroup.MarginLayoutParams) ((r) view.getLayoutParams())).bottomMargin;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface c {
            void a(int i, int i2);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class d {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public q() {
            a aVar = new a();
            this.c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.e = new androidx.recyclerview.widget.s(aVar);
            this.f = new androidx.recyclerview.widget.s(bVar);
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static d E0(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in3.a, i, i2);
            dVar.a = typedArrayObtainStyledAttributes.getInt(in3.b, 1);
            dVar.b = typedArrayObtainStyledAttributes.getInt(in3.l, 1);
            dVar.c = typedArrayObtainStyledAttributes.getBoolean(in3.k, false);
            dVar.d = typedArrayObtainStyledAttributes.getBoolean(in3.m, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int O(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private static boolean U0(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int l0(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                        i2 = 0;
                        i4 = 0;
                    } else {
                        i4 = iMax;
                    }
                }
                i2 = 1073741824;
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 != -1) {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i4 = iMax;
                        i2 = Integer.MIN_VALUE;
                    } else {
                        i4 = iMax;
                        i2 = 0;
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int A0(View view) {
            return ((r) view.getLayoutParams()).g.left;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void A1(Parcelable parcelable) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int B0() {
            return l35.y(this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Parcelable B1() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void C(View view) {
            D(view, -1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int C0() {
            return l35.z(this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void C1(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void D(View view, int i) {
            G(view, i, true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int D0(View view) {
            return ((r) view.getLayoutParams()).c();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void D1(b0 b0Var) {
            if (this.g == b0Var) {
                this.g = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void E(View view) {
            F(view, -1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean E1(int i, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return F1(recyclerView.h, recyclerView.n0, i, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void F(View view, int i) {
            G(view, i, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int F0(View view) {
            return ((r) view.getLayoutParams()).g.right;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[PHI: r11
          0x0065: PHI (r11v8 int) = (r11v5 int), (r11v20 int) binds: [B:27:0x0081, B:19:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean F1(x xVar, c0 c0Var, int i, Bundle bundle) {
            int iW;
            int iY;
            float f;
            if (this.b == null) {
                return false;
            }
            int iX0 = x0();
            int iK0 = K0();
            Rect rect = new Rect();
            if (this.b.getMatrix().isIdentity() && this.b.getGlobalVisibleRect(rect)) {
                iX0 = rect.height();
                iK0 = rect.width();
            }
            if (i == 4096) {
                iW = this.b.canScrollVertically(1) ? (iX0 - w()) - b() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    iY = (iK0 - y()) - p();
                }
            } else if (i != 8192) {
                iW = 0;
                iY = 0;
            } else {
                iW = this.b.canScrollVertically(-1) ? -((iX0 - w()) - b()) : 0;
                iY = this.b.canScrollHorizontally(-1) ? -((iK0 - y()) - p()) : 0;
            }
            if (iW == 0 && iY == 0) {
                return false;
            }
            if (bundle != null) {
                f = bundle.getFloat("androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT", 1.0f);
                if (f < 0.0f) {
                    if (!RecyclerView.J0) {
                        return false;
                    }
                    throw new IllegalArgumentException("attempting to use ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT with a negative value (" + f + ")");
                }
            } else {
                f = 1.0f;
            }
            if (Float.compare(f, Float.POSITIVE_INFINITY) != 0) {
                if (Float.compare(1.0f, f) != 0 && Float.compare(0.0f, f) != 0) {
                    iY = (int) (iY * f);
                    iW = (int) (iW * f);
                }
                this.b.B1(iY, iW, null, Integer.MIN_VALUE, true);
                return true;
            }
            RecyclerView recyclerView = this.b;
            h hVar = recyclerView.r;
            if (hVar == null) {
                return false;
            }
            if (i == 4096) {
                recyclerView.C1(hVar.g() - 1);
            } else if (i == 8192) {
                recyclerView.C1(0);
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void G(View view, int i, boolean z) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (z || g0VarO0.w()) {
                this.b.l.b(g0VarO0);
            } else {
                this.b.l.p(g0VarO0);
            }
            r rVar = (r) view.getLayoutParams();
            if (g0VarO0.M() || g0VarO0.x()) {
                if (g0VarO0.x()) {
                    g0VarO0.L();
                } else {
                    g0VarO0.e();
                }
                this.a.c(view, i, view.getLayoutParams(), false);
            } else {
                ViewParent parent = view.getParent();
                RecyclerView recyclerView = this.b;
                androidx.recyclerview.widget.e eVar = this.a;
                if (parent == recyclerView) {
                    int iM = eVar.m(view);
                    if (i == -1) {
                        i = this.a.g();
                    }
                    if (iM == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.U());
                    }
                    if (iM != i) {
                        this.b.s.Z0(iM, i);
                    }
                } else {
                    eVar.a(view, i, false);
                    rVar.h = true;
                    b0 b0Var = this.g;
                    if (b0Var != null && b0Var.h()) {
                        this.g.k(view);
                    }
                }
            }
            if (rVar.i) {
                if (RecyclerView.K0) {
                    Log.d("RecyclerView", "consuming pending invalidate on child " + rVar.f);
                }
                g0VarO0.f.invalidate();
                rVar.i = false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int G0(x xVar, c0 c0Var) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.r == null || !M()) {
                return 1;
            }
            return this.b.r.g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean G1(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return H1(recyclerView.h, recyclerView.n0, view, i, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void H(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.q(str);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int H0(x xVar, c0 c0Var) {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean H1(x xVar, c0 c0Var, View view, int i, Bundle bundle) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void I(View view, int i) {
            J(view, i, (r) view.getLayoutParams());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int I0(View view) {
            return ((r) view.getLayoutParams()).g.top;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void I1() {
            for (int iK0 = k0() - 1; iK0 >= 0; iK0--) {
                this.a.q(iK0);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void J(View view, int i, r rVar) {
            g0 g0VarO0 = RecyclerView.o0(view);
            boolean zW = g0VarO0.w();
            RecyclerView recyclerView = this.b;
            if (zW) {
                recyclerView.l.b(g0VarO0);
            } else {
                recyclerView.l.p(g0VarO0);
            }
            this.a.c(view, i, rVar, g0VarO0.w());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void J0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((r) view.getLayoutParams()).g;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.b.q;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void J1(x xVar) {
            for (int iK0 = k0() - 1; iK0 >= 0; iK0--) {
                if (!RecyclerView.o0(j0(iK0)).K()) {
                    M1(iK0, xVar);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void K(View view, Rect rect) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.s0(view));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int K0() {
            return this.q;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void K1(x xVar) {
            int iJ = xVar.j();
            for (int i = iJ - 1; i >= 0; i--) {
                View viewN = xVar.n(i);
                g0 g0VarO0 = RecyclerView.o0(viewN);
                if (!g0VarO0.K()) {
                    g0VarO0.H(false);
                    if (g0VarO0.y()) {
                        this.b.removeDetachedView(viewN, false);
                    }
                    n nVar = this.b.S;
                    if (nVar != null) {
                        nVar.j(g0VarO0);
                    }
                    g0VarO0.H(true);
                    xVar.D(viewN);
                }
            }
            xVar.e();
            if (iJ > 0) {
                this.b.invalidate();
            }
        }

        public abstract boolean L();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int L0() {
            return this.o;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void L1(View view, x xVar) {
            O1(view);
            xVar.G(view);
        }

        public abstract boolean M();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean M0() {
            int iK0 = k0();
            for (int i = 0; i < iK0; i++) {
                ViewGroup.LayoutParams layoutParams = j0(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void M1(int i, x xVar) {
            View viewJ0 = j0(i);
            P1(i);
            xVar.G(viewJ0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean N(r rVar) {
            return rVar != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean N0() {
            return this.i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean N1(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public abstract boolean O0();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void O1(View view) {
            this.a.p(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void P(int i, int i2, c0 c0Var, c cVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean P0(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iY = y();
            int iW = w();
            int iK0 = K0() - p();
            int iX0 = x0() - b();
            Rect rect = this.b.o;
            q0(focusedChild, rect);
            return rect.left - i < iK0 && rect.right - i > iY && rect.top - i2 < iX0 && rect.bottom - i2 > iW;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void P1(int i) {
            if (j0(i) != null) {
                this.a.q(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Q(int i, c cVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean Q0() {
            return this.l;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean Q1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return R1(recyclerView, view, rect, z, false);
        }

        public abstract int R(c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean R0(x xVar, c0 c0Var) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean R1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrM0 = m0(view, rect);
            int i = iArrM0[0];
            int i2 = iArrM0[1];
            if ((z2 && !P0(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.y1(i, i2);
            }
            return true;
        }

        public abstract int S(c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean S0() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void S1() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int T(c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean T0() {
            return this.k;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void T1() {
            this.h = true;
        }

        public abstract int U(c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void U1(x xVar, int i, View view) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (g0VarO0.K()) {
                if (RecyclerView.K0) {
                    Log.d("RecyclerView", "ignoring view " + g0VarO0);
                    return;
                }
                return;
            }
            if (g0VarO0.u() && !g0VarO0.w() && !this.b.r.k()) {
                P1(i);
                xVar.H(g0VarO0);
            } else {
                Y(i);
                xVar.I(view);
                this.b.l.k(g0VarO0);
            }
        }

        public abstract int V(c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean V0() {
            b0 b0Var = this.g;
            return b0Var != null && b0Var.h();
        }

        public abstract int V1(int i, x xVar, c0 c0Var);

        public abstract int W(c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean W0(View view, boolean z, boolean z2) {
            boolean z3 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public abstract void W1(int i);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void X(x xVar) {
            for (int iK0 = k0() - 1; iK0 >= 0; iK0--) {
                U1(xVar, iK0, j0(iK0));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void X0(View view, int i, int i2, int i3, int i4) {
            r rVar = (r) view.getLayoutParams();
            Rect rect = rVar.g;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) rVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) rVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) rVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) rVar).bottomMargin);
        }

        public abstract int X1(int i, x xVar, c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Y(int i) {
            Z(i, j0(i));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Y0(View view, int i, int i2) {
            r rVar = (r) view.getLayoutParams();
            Rect rectS0 = this.b.s0(view);
            int i3 = i + rectS0.left + rectS0.right;
            int i4 = i2 + rectS0.top + rectS0.bottom;
            int iL0 = l0(K0(), L0(), y() + p() + ((ViewGroup.MarginLayoutParams) rVar).leftMargin + ((ViewGroup.MarginLayoutParams) rVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) rVar).width, L());
            int iL02 = l0(x0(), y0(), w() + b() + ((ViewGroup.MarginLayoutParams) rVar).topMargin + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) rVar).height, M());
            if (e2(view, iL0, iL02, rVar)) {
                view.measure(iL0, iL02);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Y1(RecyclerView recyclerView) {
            Z1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Buffer.MAX_SIZE));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void Z(int i, View view) {
            this.a.d(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Z0(int i, int i2) {
            View viewJ0 = j0(i);
            if (viewJ0 != null) {
                Y(i);
                I(viewJ0, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.b.toString());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Z1(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.o = mode;
            if (mode == 0 && !RecyclerView.O0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.p = mode2;
            if (mode2 != 0 || RecyclerView.O0) {
                return;
            }
            this.r = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a0(RecyclerView recyclerView) {
            this.i = true;
            e1(recyclerView);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a1(int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.J0(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a2(int i, int i2) {
            this.b.setMeasuredDimension(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b0(RecyclerView recyclerView, x xVar) {
            this.i = false;
            g1(recyclerView, xVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b1(int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.K0(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b2(Rect rect, int i, int i2) {
            a2(O(i, rect.width() + y() + p(), C0()), O(i2, rect.height() + w() + b(), B0()));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return l35.B(recyclerView);
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View c0(View view) {
            View viewW;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (viewW = recyclerView.W(view)) == null || this.a.n(viewW)) {
                return null;
            }
            return viewW;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c1(h hVar, h hVar2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c2(int i, int i2) {
            int iK0 = k0();
            if (iK0 == 0) {
                this.b.B(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iK0; i7++) {
                View viewJ0 = j0(i7);
                Rect rect = this.b.o;
                q0(viewJ0, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.b.o.set(i6, i4, i3, i5);
            b2(this.b.o, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View d0(int i) {
            int iK0 = k0();
            for (int i2 = 0; i2 < iK0; i2++) {
                View viewJ0 = j0(i2);
                g0 g0VarO0 = RecyclerView.o0(viewJ0);
                if (g0VarO0 != null && g0VarO0.n() == i && !g0VarO0.K() && (this.b.n0.e() || !g0VarO0.w())) {
                    return viewJ0;
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d1(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d2(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.k;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = Buffer.MAX_SIZE;
            this.p = Buffer.MAX_SIZE;
        }

        public abstract r e0();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e1(RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean e2(View view, int i, int i2, r rVar) {
            return (!view.isLayoutRequested() && this.k && U0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) rVar).width) && U0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) rVar).height)) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public r f0(Context context, AttributeSet attributeSet) {
            return new r(context, attributeSet);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f1(RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean f2() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public r g0(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof r ? new r((r) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new r((ViewGroup.MarginLayoutParams) layoutParams) : new r(layoutParams);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g1(RecyclerView recyclerView, x xVar) {
            f1(recyclerView);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean g2(View view, int i, int i2, r rVar) {
            return (this.k && U0(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) rVar).width) && U0(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) rVar).height)) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int h0() {
            return -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View h1(View view, int i, x xVar, c0 c0Var) {
            return null;
        }

        public abstract void h2(RecyclerView recyclerView, c0 c0Var, int i);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int i0(View view) {
            return ((r) view.getLayoutParams()).g.bottom;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i1(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            j1(recyclerView.h, recyclerView.n0, accessibilityEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i2(b0 b0Var) {
            b0 b0Var2 = this.g;
            if (b0Var2 != null && b0Var != b0Var2 && b0Var2.h()) {
                this.g.r();
            }
            this.g = b0Var;
            b0Var.q(this.b, this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View j0(int i) {
            androidx.recyclerview.widget.e eVar = this.a;
            if (eVar != null) {
                return eVar.f(i);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j1(x xVar, c0 c0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            h hVar = this.b.r;
            if (hVar != null) {
                accessibilityEvent.setItemCount(hVar.g());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j2() {
            b0 b0Var = this.g;
            if (b0Var != null) {
                b0Var.r();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int k0() {
            androidx.recyclerview.widget.e eVar = this.a;
            if (eVar != null) {
                return eVar.g();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k1(g2 g2Var) {
            RecyclerView recyclerView = this.b;
            l1(recyclerView.h, recyclerView.n0, g2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean k2() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l1(x xVar, c0 c0Var, g2 g2Var) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                g2Var.a(8192);
                g2Var.H0(true);
                g2Var.v0(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                g2Var.a(okio.internal.Buffer.SEGMENTING_THRESHOLD);
                g2Var.H0(true);
                g2Var.v0(true);
            }
            g2Var.n0(g2.e.a(G0(xVar, c0Var), o0(xVar, c0Var), R0(xVar, c0Var), H0(xVar, c0Var)));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int[] m0(View view, Rect rect) {
            int iY = y();
            int iW = w();
            int iK0 = K0() - p();
            int iX0 = x0() - b();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iY;
            int iMin = Math.min(0, i);
            int i2 = top - iW;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iK0;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iX0);
            if (z0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void m1(View view, g2 g2Var) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (g0VarO0 == null || g0VarO0.w() || this.a.n(g0VarO0.f)) {
                return;
            }
            RecyclerView recyclerView = this.b;
            n1(recyclerView.h, recyclerView.n0, view, g2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean n0() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.m;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n1(x xVar, c0 c0Var, View view, g2 g2Var) {
            g2Var.o0(g2.f.a(M() ? D0(view) : 0, 1, L() ? D0(view) : 0, 1, false, false));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int o0(x xVar, c0 c0Var) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.r == null || !L()) {
                return 1;
            }
            return this.b.r.g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View o1(View view, int i) {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int p() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int p0(View view) {
            return view.getBottom() + i0(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void p1(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q0(View view, Rect rect) {
            RecyclerView.p0(view, rect);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q1(RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int r0(View view) {
            return view.getLeft() - A0(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r1(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int s0(View view) {
            Rect rect = ((r) view.getLayoutParams()).g;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s1(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int t0(View view) {
            Rect rect = ((r) view.getLayoutParams()).g;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void t1(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int u() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return l35.C(recyclerView);
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int u0(View view) {
            return view.getRight() + F0(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void u1(RecyclerView recyclerView, int i, int i2, Object obj) {
            t1(recyclerView, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int v() {
            RecyclerView recyclerView = this.b;
            h adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.g();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int v0(View view) {
            return view.getTop() - I0(view);
        }

        public abstract void v1(x xVar, c0 c0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int w() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View w0() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void w1(c0 c0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int x0() {
            return this.r;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void x1(x xVar, c0 c0Var, int i, int i2) {
            this.b.B(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int y() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int y0() {
            return this.p;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean y1(RecyclerView recyclerView, View view, View view2) {
            return V0() || recyclerView.D0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int z0() {
            return this.b.getLayoutDirection();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean z1(RecyclerView recyclerView, c0 c0Var, View view, View view2) {
            return y1(recyclerView, view, view2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface s {
        void a(View view);

        void b(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class t {
        public abstract boolean a(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface u {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class v {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(RecyclerView recyclerView, int i) {
        }

        public abstract void b(RecyclerView recyclerView, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class w {
        public SparseArray a = new SparseArray();
        public int b = 0;
        public Set c = Collections.newSetFromMap(new IdentityHashMap());

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a {
            public final ArrayList a = new ArrayList();
            public int b = 5;
            public long c = 0;
            public long d = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.b++;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(h hVar) {
            this.c.add(hVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            for (int i = 0; i < this.a.size(); i++) {
                a aVar = (a) this.a.valueAt(i);
                Iterator it = aVar.a.iterator();
                while (it.hasNext()) {
                    rf3.a(((g0) it.next()).f);
                }
                aVar.a.clear();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            this.b--;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(h hVar, boolean z) {
            this.c.remove(hVar);
            if (this.c.size() != 0 || z) {
                return;
            }
            for (int i = 0; i < this.a.size(); i++) {
                SparseArray sparseArray = this.a;
                ArrayList arrayList = ((a) sparseArray.get(sparseArray.keyAt(i))).a;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    rf3.a(((g0) arrayList.get(i2)).f);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(int i, long j) {
            a aVarI = i(i);
            aVarI.d = l(aVarI.d, j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(int i, long j) {
            a aVarI = i(i);
            aVarI.c = l(aVarI.c, j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g0 h(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((g0) arrayList.get(size)).s()) {
                    return (g0) arrayList.remove(size);
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final a i(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j(h hVar, h hVar2, boolean z) {
            if (hVar != null) {
                d();
            }
            if (!z && this.b == 0) {
                c();
            }
            if (hVar2 != null) {
                a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k(g0 g0Var) {
            int iM = g0Var.m();
            ArrayList arrayList = i(iM).a;
            if (((a) this.a.get(iM)).b <= arrayList.size()) {
                rf3.a(g0Var.f);
            } else if (RecyclerView.J0 && arrayList.contains(g0Var)) {
                jl.a("this scrap item already exists");
            } else {
                g0Var.E();
                arrayList.add(g0Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long l(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean m(int i, long j, long j2) {
            long j3 = i(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean n(int i, long j, long j2) {
            long j3 = i(i).c;
            return j3 == 0 || j + j3 < j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class x {
        public final ArrayList a;
        public ArrayList b;
        public final ArrayList c;
        public final List d;
        public int e;
        public int f;
        public w g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public x() {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            this.b = null;
            this.c = new ArrayList();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void A() {
            for (int i = 0; i < this.c.size(); i++) {
                rf3.a(((g0) this.c.get(i)).f);
            }
            B(RecyclerView.this.r);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void B(h hVar) {
            C(hVar, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void C(h hVar, boolean z) {
            w wVar = this.g;
            if (wVar != null) {
                wVar.e(hVar, z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void D(View view) {
            g0 g0VarO0 = RecyclerView.o0(view);
            g0VarO0.s = null;
            g0VarO0.t = false;
            g0VarO0.e();
            H(g0VarO0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void E() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.c.clear();
            if (RecyclerView.P0) {
                RecyclerView.this.m0.b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void F(int i) {
            if (RecyclerView.K0) {
                Log.d("RecyclerView", "Recycling cached view at index " + i);
            }
            g0 g0Var = (g0) this.c.get(i);
            if (RecyclerView.K0) {
                Log.d("RecyclerView", "CachedViewHolder to be recycled: " + g0Var);
            }
            a(g0Var, true);
            this.c.remove(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void G(View view) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (g0VarO0.y()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (g0VarO0.x()) {
                g0VarO0.L();
            } else if (g0VarO0.M()) {
                g0VarO0.e();
            }
            H(g0VarO0);
            if (RecyclerView.this.S == null || g0VarO0.v()) {
                return;
            }
            RecyclerView.this.S.j(g0VarO0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void H(g0 g0Var) {
            boolean z;
            boolean z2 = true;
            if (g0Var.x() || g0Var.f.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(g0Var.x());
                sb.append(" isAttached:");
                sb.append(g0Var.f.getParent() != null);
                sb.append(RecyclerView.this.U());
                throw new IllegalArgumentException(sb.toString());
            }
            if (g0Var.y()) {
                StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(g0Var);
                gp3.a(sb2, RecyclerView.this.U());
                return;
            }
            if (g0Var.K()) {
                nl.a("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.", RecyclerView.this.U());
                return;
            }
            boolean zH = g0Var.h();
            h hVar = RecyclerView.this.r;
            boolean z3 = hVar != null && zH && hVar.z(g0Var);
            if (RecyclerView.J0 && this.c.contains(g0Var)) {
                StringBuilder sb3 = new StringBuilder("cached view received recycle internal? ");
                sb3.append(g0Var);
                gp3.a(sb3, RecyclerView.this.U());
                return;
            }
            if (z3 || g0Var.v()) {
                if (this.f <= 0 || g0Var.q(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.f && size > 0) {
                        F(0);
                        size--;
                    }
                    if (RecyclerView.P0 && size > 0 && !RecyclerView.this.m0.d(g0Var.h)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.m0.d(((g0) this.c.get(i)).h)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, g0Var);
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    a(g0Var, true);
                }
                z = z;
            } else {
                if (RecyclerView.K0) {
                    Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.U());
                }
                z2 = false;
            }
            RecyclerView.this.l.q(g0Var);
            if (z || z2 || !zH) {
                return;
            }
            rf3.a(g0Var.f);
            g0Var.x = null;
            g0Var.w = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void I(View view) {
            g0 g0VarO0 = RecyclerView.o0(view);
            if (!g0VarO0.q(12) && g0VarO0.z() && !RecyclerView.this.r(g0VarO0)) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                g0VarO0.I(this, true);
                this.b.add(g0VarO0);
                return;
            }
            if (g0VarO0.u() && !g0VarO0.w() && !RecyclerView.this.r.k()) {
                nl.a("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.", RecyclerView.this.U());
            } else {
                g0VarO0.I(this, false);
                this.a.add(g0VarO0);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void J(w wVar) {
            B(RecyclerView.this.r);
            w wVar2 = this.g;
            if (wVar2 != null) {
                wVar2.d();
            }
            this.g = wVar;
            if (wVar != null && RecyclerView.this.getAdapter() != null) {
                this.g.a();
            }
            u();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void K(e0 e0Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void L(int i) {
            this.e = i;
            P();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean M(g0 g0Var, int i, int i2, long j) {
            g0Var.x = null;
            g0Var.w = RecyclerView.this;
            int iM = g0Var.m();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z = false;
            if (j != Long.MAX_VALUE && !this.g.m(iM, nanoTime, j)) {
                return false;
            }
            if (g0Var.y()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(g0Var.f, recyclerView.getChildCount(), g0Var.f.getLayoutParams());
                z = true;
            }
            RecyclerView.this.r.c(g0Var, i);
            if (z) {
                RecyclerView.this.detachViewFromParent(g0Var.f);
            }
            this.g.f(g0Var.m(), RecyclerView.this.getNanoTime() - nanoTime);
            b(g0Var);
            if (RecyclerView.this.n0.e()) {
                g0Var.l = i2;
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:103:0x020a A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:105:0x020d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01ef  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public g0 N(int i, boolean z, long j) {
            g0 g0VarE;
            boolean z2;
            g0 g0Var;
            boolean z3;
            boolean zM;
            ViewGroup.LayoutParams layoutParams;
            r rVar;
            RecyclerView recyclerViewA0;
            if (i < 0 || i >= RecyclerView.this.n0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.n0.b() + RecyclerView.this.U());
            }
            if (RecyclerView.this.n0.e()) {
                g0VarE = h(i);
                if (g0VarE != null) {
                    z2 = true;
                }
                if (g0VarE == null && (g0VarE = m(i, z)) != null) {
                    if (Q(g0VarE)) {
                        if (!z) {
                            g0VarE.b(4);
                            if (g0VarE.x()) {
                                RecyclerView.this.removeDetachedView(g0VarE.f, false);
                                g0VarE.L();
                            } else if (g0VarE.M()) {
                                g0VarE.e();
                            }
                            H(g0VarE);
                        }
                        g0VarE = null;
                    } else {
                        z2 = true;
                    }
                }
                if (g0VarE == null) {
                    int iM = RecyclerView.this.j.m(i);
                    if (iM < 0 || iM >= RecyclerView.this.r.g()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iM + ").state:" + RecyclerView.this.n0.b() + RecyclerView.this.U());
                    }
                    int i2 = RecyclerView.this.r.i(iM);
                    if (RecyclerView.this.r.k() && (g0VarE = l(RecyclerView.this.r.h(iM), i2, z)) != null) {
                        g0VarE.h = iM;
                        z2 = true;
                    }
                    if (g0VarE == null) {
                        if (RecyclerView.K0) {
                            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i + ") fetching from shared pool");
                        }
                        g0VarE = i().h(i2);
                        if (g0VarE != null) {
                            g0VarE.E();
                            if (RecyclerView.N0) {
                                r(g0VarE);
                            }
                        }
                    }
                    if (g0VarE == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j != Long.MAX_VALUE && !this.g.n(i2, nanoTime, j)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        g0VarE = recyclerView.r.e(recyclerView, i2);
                        if (RecyclerView.P0 && (recyclerViewA0 = RecyclerView.a0(g0VarE.f)) != null) {
                            g0VarE.g = new WeakReference(recyclerViewA0);
                        }
                        this.g.g(i2, RecyclerView.this.getNanoTime() - nanoTime);
                        if (RecyclerView.K0) {
                            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                        }
                    }
                }
                g0Var = g0VarE;
                z3 = z2;
                if (z3 && !RecyclerView.this.n0.e() && g0Var.q(8192)) {
                    g0Var.G(0, 8192);
                    if (RecyclerView.this.n0.k) {
                        int iE = n.e(g0Var) | okio.internal.Buffer.SEGMENTING_THRESHOLD;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.b1(g0Var, recyclerView2.S.t(recyclerView2.n0, g0Var, iE, g0Var.p()));
                    }
                }
                if (RecyclerView.this.n0.e() || !g0Var.t()) {
                    if (g0Var.t() || g0Var.A() || g0Var.u()) {
                        if (!RecyclerView.J0 && g0Var.w()) {
                            StringBuilder sb = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                            sb.append(g0Var);
                            ep3.a(sb, RecyclerView.this.U());
                            return null;
                        }
                        zM = M(g0Var, RecyclerView.this.j.m(i), i, j);
                    }
                    layoutParams = g0Var.f.getLayoutParams();
                    RecyclerView recyclerView3 = RecyclerView.this;
                    if (layoutParams == null) {
                        rVar = (r) recyclerView3.generateDefaultLayoutParams();
                        g0Var.f.setLayoutParams(rVar);
                    } else if (recyclerView3.checkLayoutParams(layoutParams)) {
                        rVar = (r) layoutParams;
                    } else {
                        rVar = (r) RecyclerView.this.generateLayoutParams(layoutParams);
                        g0Var.f.setLayoutParams(rVar);
                    }
                    rVar.f = g0Var;
                    rVar.i = z3 && zM;
                    return g0Var;
                }
                g0Var.l = i;
                zM = false;
                layoutParams = g0Var.f.getLayoutParams();
                RecyclerView recyclerView32 = RecyclerView.this;
                if (layoutParams == null) {
                }
                rVar.f = g0Var;
                rVar.i = z3 && zM;
                return g0Var;
            }
            g0VarE = null;
            z2 = false;
            if (g0VarE == null) {
                if (Q(g0VarE)) {
                }
            }
            if (g0VarE == null) {
            }
            g0Var = g0VarE;
            z3 = z2;
            if (z3) {
                g0Var.G(0, 8192);
                if (RecyclerView.this.n0.k) {
                }
            }
            if (RecyclerView.this.n0.e()) {
                if (g0Var.t()) {
                }
                if (!RecyclerView.J0) {
                }
                zM = M(g0Var, RecyclerView.this.j.m(i), i, j);
            }
            layoutParams = g0Var.f.getLayoutParams();
            RecyclerView recyclerView322 = RecyclerView.this;
            if (layoutParams == null) {
            }
            rVar.f = g0Var;
            rVar.i = z3 && zM;
            return g0Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void O(g0 g0Var) {
            if (g0Var.t) {
                this.b.remove(g0Var);
            } else {
                this.a.remove(g0Var);
            }
            g0Var.s = null;
            g0Var.t = false;
            g0Var.e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void P() {
            q qVar = RecyclerView.this.s;
            this.f = this.e + (qVar != null ? qVar.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                F(size);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean Q(g0 g0Var) {
            if (g0Var.w()) {
                if (!RecyclerView.J0 || RecyclerView.this.n0.e()) {
                    return RecyclerView.this.n0.e();
                }
                defpackage.d.a("should not receive a removed view unless it is pre layout", RecyclerView.this.U());
                return false;
            }
            int i = g0Var.h;
            if (i < 0 || i >= RecyclerView.this.r.g()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + g0Var + RecyclerView.this.U());
            }
            if (RecyclerView.this.n0.e() || RecyclerView.this.r.i(g0Var.h) == g0Var.m()) {
                return !RecyclerView.this.r.k() || g0Var.l() == RecyclerView.this.r.h(g0Var.h);
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void R(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                g0 g0Var = (g0) this.c.get(size);
                if (g0Var != null && (i3 = g0Var.h) >= i && i3 < i4) {
                    g0Var.b(2);
                    F(size);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(g0 g0Var, boolean z) {
            RecyclerView.t(g0Var);
            View view = g0Var.f;
            androidx.recyclerview.widget.o oVar = RecyclerView.this.u0;
            if (oVar != null) {
                r1 r1VarN = oVar.n();
                l35.g0(view, r1VarN instanceof o.a ? ((o.a) r1VarN).n(view) : null);
            }
            if (z) {
                g(g0Var);
            }
            g0Var.x = null;
            g0Var.w = null;
            i().k(g0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b(g0 g0Var) {
            if (RecyclerView.this.C0()) {
                View view = g0Var.f;
                if (view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                androidx.recyclerview.widget.o oVar = RecyclerView.this.u0;
                if (oVar == null) {
                    return;
                }
                r1 r1VarN = oVar.n();
                if (r1VarN instanceof o.a) {
                    ((o.a) r1VarN).o(view);
                }
                l35.g0(view, r1VarN);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            this.a.clear();
            E();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((g0) this.c.get(i)).c();
            }
            int size2 = this.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((g0) this.a.get(i2)).c();
            }
            ArrayList arrayList = this.b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((g0) this.b.get(i3)).c();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e() {
            this.a.clear();
            ArrayList arrayList = this.b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int f(int i) {
            if (i >= 0 && i < RecyclerView.this.n0.b()) {
                return !RecyclerView.this.n0.e() ? i : RecyclerView.this.j.m(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.n0.b() + RecyclerView.this.U());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(g0 g0Var) {
            RecyclerView.this.getClass();
            int size = RecyclerView.this.t.size();
            RecyclerView recyclerView = RecyclerView.this;
            if (size > 0) {
                w82.a(recyclerView.t.get(0));
                throw null;
            }
            h hVar = recyclerView.r;
            if (hVar != null) {
                hVar.C(g0Var);
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (recyclerView2.n0 != null) {
                recyclerView2.l.q(g0Var);
            }
            if (RecyclerView.K0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + g0Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g0 h(int i) {
            int size;
            int iM;
            ArrayList arrayList = this.b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    g0 g0Var = (g0) this.b.get(i2);
                    if (!g0Var.M() && g0Var.n() == i) {
                        g0Var.b(32);
                        return g0Var;
                    }
                }
                if (RecyclerView.this.r.k() && (iM = RecyclerView.this.j.m(i)) > 0 && iM < RecyclerView.this.r.g()) {
                    long jH = RecyclerView.this.r.h(iM);
                    for (int i3 = 0; i3 < size; i3++) {
                        g0 g0Var2 = (g0) this.b.get(i3);
                        if (!g0Var2.M() && g0Var2.l() == jH) {
                            g0Var2.b(32);
                            return g0Var2;
                        }
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public w i() {
            if (this.g == null) {
                this.g = new w();
                u();
            }
            return this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int j() {
            return this.a.size();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List k() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Move duplicate insns, count: 1 to block B:20:0x0061 */
        public g0 l(long j, int i, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g0 g0Var = (g0) this.a.get(size);
                if (g0Var.l() == j && !g0Var.M()) {
                    if (i == g0Var.m()) {
                        g0Var.b(32);
                        if (g0Var.w() && !RecyclerView.this.n0.e()) {
                            g0Var.G(2, 14);
                        }
                        return g0Var;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(g0Var.f, false);
                        D(g0Var.f);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                g0 g0Var2 = (g0) this.c.get(size2);
                if (g0Var2.l() == j && !g0Var2.s()) {
                    if (i == g0Var2.m()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return g0Var2;
                    }
                    if (!z) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g0 m(int i, boolean z) {
            View viewE;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                g0 g0Var = (g0) this.a.get(i2);
                if (!g0Var.M() && g0Var.n() == i && !g0Var.u() && (RecyclerView.this.n0.h || !g0Var.w())) {
                    g0Var.b(32);
                    return g0Var;
                }
            }
            if (!z && (viewE = RecyclerView.this.k.e(i)) != null) {
                g0 g0VarO0 = RecyclerView.o0(viewE);
                RecyclerView.this.k.s(viewE);
                int iM = RecyclerView.this.k.m(viewE);
                if (iM != -1) {
                    RecyclerView.this.k.d(iM);
                    I(viewE);
                    g0VarO0.b(8224);
                    return g0VarO0;
                }
                StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                sb.append(g0VarO0);
                ep3.a(sb, RecyclerView.this.U());
                return null;
            }
            int size2 = this.c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                g0 g0Var2 = (g0) this.c.get(i3);
                if (!g0Var2.u() && g0Var2.n() == i && !g0Var2.s()) {
                    if (!z) {
                        this.c.remove(i3);
                    }
                    if (RecyclerView.K0) {
                        Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i + ") found match in cache: " + g0Var2);
                    }
                    return g0Var2;
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View n(int i) {
            return ((g0) this.a.get(i)).f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View o(int i) {
            return p(i, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View p(int i, boolean z) {
            return N(i, z, Long.MAX_VALUE).f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r(g0 g0Var) {
            View view = g0Var.f;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                r rVar = (r) ((g0) this.c.get(i)).f.getLayoutParams();
                if (rVar != null) {
                    rVar.h = true;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void t() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                g0 g0Var = (g0) this.c.get(i);
                if (g0Var != null) {
                    g0Var.b(6);
                    g0Var.a(null);
                }
            }
            h hVar = RecyclerView.this.r;
            if (hVar == null || !hVar.k()) {
                E();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u() {
            if (this.g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.r == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                this.g.b(RecyclerView.this.r);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void v(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                g0 g0Var = (g0) this.c.get(i3);
                if (g0Var != null && g0Var.h >= i) {
                    if (RecyclerView.K0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i3 + " holder " + g0Var + " now at position " + (g0Var.h + i2));
                    }
                    g0Var.B(i2, false);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void w(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                g0 g0Var = (g0) this.c.get(i7);
                if (g0Var != null && (i6 = g0Var.h) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        g0Var.B(i2 - i, false);
                    } else {
                        g0Var.B(i3, false);
                    }
                    if (RecyclerView.K0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i7 + " holder " + g0Var);
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void x(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                g0 g0Var = (g0) this.c.get(size);
                if (g0Var != null) {
                    int i4 = g0Var.h;
                    if (i4 >= i3) {
                        if (RecyclerView.K0) {
                            Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + g0Var + " now at position " + (g0Var.h - i2));
                        }
                        g0Var.B(-i2, z);
                    } else if (i4 >= i) {
                        g0Var.b(8);
                        F(size);
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void y(h hVar, h hVar2, boolean z) {
            c();
            C(hVar, true);
            i().j(hVar, hVar2, z);
            u();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void z() {
            u();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface y {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class z extends j {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public z() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            RecyclerView.this.q(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n0.g = true;
            recyclerView.Z0(true);
            if (RecyclerView.this.j.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void b(int i, int i2, Object obj) {
            RecyclerView.this.q(null);
            if (RecyclerView.this.j.r(i, i2, obj)) {
                f();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i, int i2) {
            RecyclerView.this.q(null);
            if (RecyclerView.this.j.s(i, i2)) {
                f();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2, int i3) {
            RecyclerView.this.q(null);
            if (RecyclerView.this.j.t(i, i2, i3)) {
                f();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2) {
            RecyclerView.this.q(null);
            if (RecyclerView.this.j.u(i, i2)) {
                f();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.y && recyclerView.x) {
                l35.Y(recyclerView, recyclerView.n);
            } else {
                recyclerView.G = true;
                recyclerView.requestLayout();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        Class cls = Integer.TYPE;
        Q0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        R0 = new c();
        S0 = new d0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = new z();
        this.h = new x();
        this.l = new androidx.recyclerview.widget.t();
        this.n = new a();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new RectF();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.B = 0;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = 0;
        this.N = S0;
        this.S = new androidx.recyclerview.widget.f();
        this.T = 0;
        this.U = -1;
        this.h0 = Float.MIN_VALUE;
        this.i0 = Float.MIN_VALUE;
        this.j0 = true;
        this.k0 = new f0();
        this.m0 = P0 ? new i.b() : null;
        this.n0 = new c0();
        this.q0 = false;
        this.r0 = false;
        this.s0 = new o();
        this.t0 = false;
        this.v0 = new int[2];
        this.x0 = new int[2];
        this.y0 = new int[2];
        this.z0 = new int[2];
        this.A0 = new ArrayList();
        this.B0 = new b();
        this.D0 = 0;
        this.E0 = 0;
        this.G0 = new d();
        e eVar = new e();
        this.H0 = eVar;
        this.I0 = new ql0(getContext(), eVar);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.d0 = viewConfiguration.getScaledTouchSlop();
        this.h0 = o35.f(viewConfiguration, context);
        this.i0 = o35.j(viewConfiguration, context);
        this.f0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.g0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.S.v(this.s0);
        x0();
        z0();
        y0();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.o(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in3.a, i2, 0);
        l35.e0(this, context, in3.a, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        String string = typedArrayObtainStyledAttributes.getString(in3.j);
        if (typedArrayObtainStyledAttributes.getInt(in3.d, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.m = typedArrayObtainStyledAttributes.getBoolean(in3.c, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(in3.e, false);
        this.z = z2;
        if (z2) {
            A0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(in3.h), typedArrayObtainStyledAttributes.getDrawable(in3.i), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(in3.f), typedArrayObtainStyledAttributes.getDrawable(in3.g));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.F0 = context.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        A(context, string, attributeSet, i2, 0);
        int[] iArr = L0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        l35.e0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
        rf3.d(this, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean G1(MotionEvent motionEvent) {
        boolean z2;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect == null || jq0.b(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z2 = false;
        } else {
            jq0.d(this.O, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z2 = true;
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null && jq0.b(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            jq0.d(this.Q, 0.0f, motionEvent.getY() / getHeight());
            z2 = true;
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && jq0.b(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            jq0.d(this.P, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 == null || jq0.b(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z2;
        }
        jq0.d(this.R, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static RecyclerView a0(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewA0 = a0(viewGroup.getChildAt(i2));
            if (recyclerViewA0 != null) {
                return recyclerViewA0;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int f1(int i2, float f2) {
        float width = f2 / getWidth();
        float height = i2 / getHeight();
        EdgeEffect edgeEffect = this.P;
        float f3 = 0.0f;
        if (edgeEffect == null || jq0.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.R;
            if (edgeEffect2 != null && jq0.b(edgeEffect2) != 0.0f) {
                boolean zCanScrollVertically = canScrollVertically(1);
                EdgeEffect edgeEffect3 = this.R;
                if (zCanScrollVertically) {
                    edgeEffect3.onRelease();
                } else {
                    float fD = jq0.d(edgeEffect3, height, 1.0f - width);
                    if (jq0.b(this.R) == 0.0f) {
                        this.R.onRelease();
                    }
                    f3 = fD;
                }
                invalidate();
            }
        } else {
            boolean zCanScrollVertically2 = canScrollVertically(-1);
            EdgeEffect edgeEffect4 = this.P;
            if (zCanScrollVertically2) {
                edgeEffect4.onRelease();
            } else {
                float f4 = -jq0.d(edgeEffect4, -height, width);
                if (jq0.b(this.P) == 0.0f) {
                    this.P.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getHeight());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private m23 getScrollingChildHelper() {
        if (this.w0 == null) {
            this.w0 = new m23(this);
        }
        return this.w0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static g0 o0(View view) {
        if (view == null) {
            return null;
        }
        return ((r) view.getLayoutParams()).f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void p0(View view, Rect rect) {
        r rVar = (r) view.getLayoutParams();
        Rect rect2 = rVar.g;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) rVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) rVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) rVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void setDebugAssertionsEnabled(boolean z2) {
        J0 = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void setVerboseLoggingEnabled(boolean z2) {
        K0 = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void t(g0 g0Var) {
        WeakReference weakReference = g0Var.g;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == g0Var.f) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            g0Var.g = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private float t0(int i2) {
        double dLog = Math.log((Math.abs(i2) * 0.35f) / (this.f * 0.015f));
        float f2 = M0;
        return (float) (((double) (this.f * 0.015f)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * dLog));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strR0 = r0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strR0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(q.class);
                try {
                    constructor = clsAsSubclass.getConstructor(Q0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strR0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((q) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                hp3.a(attributeSet.getPositionDescription(), ": Class is not a LayoutManager ", strR0, e4);
            } catch (ClassNotFoundException e5) {
                hp3.a(attributeSet.getPositionDescription(), ": Unable to find LayoutManager ", strR0, e5);
            } catch (IllegalAccessException e6) {
                hp3.a(attributeSet.getPositionDescription(), ": Cannot access non-public constructor ", strR0, e6);
            } catch (InstantiationException e7) {
                hp3.a(attributeSet.getPositionDescription(), ": Could not instantiate the LayoutManager: ", strR0, e7);
            } catch (InvocationTargetException e8) {
                hp3.a(attributeSet.getPositionDescription(), ": Could not instantiate the LayoutManager: ", strR0, e8);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            nl.a("Trying to set fast scroller without both required drawables.", U());
        } else {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.h(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(xk3.a), resources.getDimensionPixelSize(xk3.c), resources.getDimensionPixelOffset(xk3.b));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A1(int i2, int i3, Interpolator interpolator, int i4) {
        B1(i2, i3, interpolator, i4, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(int i2, int i3) {
        setMeasuredDimension(q.O(i2, getPaddingLeft() + getPaddingRight(), l35.z(this)), q.O(i3, getPaddingTop() + getPaddingBottom(), l35.y(this)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B0() {
        this.R = null;
        this.P = null;
        this.Q = null;
        this.O = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B1(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        q qVar = this.s;
        if (qVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.D) {
            return;
        }
        if (!qVar.L()) {
            i2 = 0;
        }
        if (!this.s.M()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 != Integer.MIN_VALUE && i4 <= 0) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            E1(i5, 1);
        }
        this.k0.e(i2, i3, i4, interpolator);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean C(int i2, int i3) {
        Z(this.v0);
        int[] iArr = this.v0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean C0() {
        AccessibilityManager accessibilityManager = this.H;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C1(int i2) {
        if (this.D) {
            return;
        }
        q qVar = this.s;
        if (qVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            qVar.h2(this, this.n0, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D(View view) {
        g0 g0VarO0 = o0(view);
        O0(view);
        h hVar = this.r;
        if (hVar != null && g0VarO0 != null) {
            hVar.A(g0VarO0);
        }
        List list = this.I;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.I.get(size)).b(view);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean D0() {
        return this.L > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D1() {
        int i2 = this.B + 1;
        this.B = i2;
        if (i2 != 1 || this.D) {
            return;
        }
        this.C = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(View view) {
        g0 g0VarO0 = o0(view);
        P0(view);
        h hVar = this.r;
        if (hVar != null && g0VarO0 != null) {
            hVar.B(g0VarO0);
        }
        List list = this.I;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.I.get(size)).a(view);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || view2 == view || W(view2) == null) {
            return false;
        }
        if (view == null || W(view) == null) {
            return true;
        }
        this.o.set(0, 0, view.getWidth(), view.getHeight());
        this.p.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.o);
        offsetDescendantRectToMyCoords(view2, this.p);
        byte b2 = -1;
        int i4 = this.s.z0() == 1 ? -1 : 1;
        Rect rect = this.o;
        int i5 = rect.left;
        Rect rect2 = this.p;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            b2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                b2 = 0;
            }
        }
        if (i2 == 1) {
            return b2 < 0 || (b2 == 0 && i3 * i4 < 0);
        }
        if (i2 == 2) {
            return b2 > 0 || (b2 == 0 && i3 * i4 > 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b2 > 0;
        }
        fp3.a("Invalid direction: ", i2, U());
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean E1(int i2, int i3) {
        return getScrollingChildHelper().p(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F() {
        int i2 = this.F;
        this.F = 0;
        if (i2 == 0 || !C0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        s1.b(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F0(int i2) {
        if (this.s == null) {
            return;
        }
        setScrollState(2);
        this.s.W1(i2);
        awakenScrollBars();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public final void F1(int i2) {
        boolean zL = this.s.L();
        int i3 = zL;
        if (this.s.M()) {
            i3 = (zL ? 1 : 0) | 2;
        }
        E1(i3, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G() {
        if (this.r == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.s == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.n0.j = false;
        boolean z2 = this.C0 && !(this.D0 == getWidth() && this.E0 == getHeight());
        this.D0 = 0;
        this.E0 = 0;
        this.C0 = false;
        if (this.n0.e == 1) {
            H();
            this.s.Y1(this);
            I();
        } else if (this.j.q() || z2 || this.s.K0() != getWidth() || this.s.x0() != getHeight()) {
            this.s.Y1(this);
            I();
        } else {
            this.s.Y1(this);
        }
        J();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G0() {
        int iJ = this.k.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            ((r) this.k.i(i2).getLayoutParams()).h = true;
        }
        this.h.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H() {
        this.n0.a(1);
        V(this.n0);
        this.n0.j = false;
        D1();
        this.l.f();
        Q0();
        Y0();
        p1();
        c0 c0Var = this.n0;
        c0Var.i = c0Var.k && this.r0;
        this.r0 = false;
        this.q0 = false;
        c0Var.h = c0Var.l;
        c0Var.f = this.r.g();
        Z(this.v0);
        if (this.n0.k) {
            int iG = this.k.g();
            for (int i2 = 0; i2 < iG; i2++) {
                g0 g0VarO0 = o0(this.k.f(i2));
                if (!g0VarO0.K() && (!g0VarO0.u() || this.r.k())) {
                    this.l.e(g0VarO0, this.S.t(this.n0, g0VarO0, n.e(g0VarO0), g0VarO0.p()));
                    if (this.n0.i && g0VarO0.z() && !g0VarO0.w() && !g0VarO0.K() && !g0VarO0.u()) {
                        this.l.c(k0(g0VarO0), g0VarO0);
                    }
                }
            }
        }
        if (this.n0.l) {
            q1();
            c0 c0Var2 = this.n0;
            boolean z2 = c0Var2.g;
            c0Var2.g = false;
            this.s.v1(this.h, c0Var2);
            this.n0.g = z2;
            for (int i3 = 0; i3 < this.k.g(); i3++) {
                g0 g0VarO02 = o0(this.k.f(i3));
                if (!g0VarO02.K() && !this.l.i(g0VarO02)) {
                    int iE = n.e(g0VarO02);
                    boolean zQ = g0VarO02.q(8192);
                    if (!zQ) {
                        iE |= okio.internal.Buffer.SEGMENTING_THRESHOLD;
                    }
                    n.b bVarT = this.S.t(this.n0, g0VarO02, iE, g0VarO02.p());
                    if (zQ) {
                        b1(g0VarO02, bVarT);
                    } else {
                        this.l.a(g0VarO02, bVarT);
                    }
                }
            }
            u();
        } else {
            u();
        }
        R0();
        H1(false);
        this.n0.e = 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H0() {
        int iJ = this.k.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            g0 g0VarO0 = o0(this.k.i(i2));
            if (g0VarO0 != null && !g0VarO0.K()) {
                g0VarO0.b(6);
            }
        }
        G0();
        this.h.t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H1(boolean z2) {
        if (this.B < 1) {
            if (J0) {
                defpackage.d.a("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.", U());
                return;
            }
            this.B = 1;
        }
        if (!z2 && !this.D) {
            this.C = false;
        }
        if (this.B == 1) {
            if (z2 && this.C && !this.D && this.s != null && this.r != null) {
                G();
            }
            if (!this.D) {
                this.C = false;
            }
        }
        this.B--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I() {
        D1();
        Q0();
        this.n0.a(6);
        this.j.j();
        this.n0.f = this.r.g();
        this.n0.d = 0;
        if (this.i != null && this.r.d()) {
            Parcelable parcelable = this.i.h;
            if (parcelable != null) {
                this.s.A1(parcelable);
            }
            this.i = null;
        }
        c0 c0Var = this.n0;
        c0Var.h = false;
        this.s.v1(this.h, c0Var);
        c0 c0Var2 = this.n0;
        c0Var2.g = false;
        c0Var2.k = c0Var2.k && this.S != null;
        c0Var2.e = 4;
        R0();
        H1(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I0(int i2, int i3, MotionEvent motionEvent, int i4) {
        q qVar = this.s;
        if (qVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.D) {
            return;
        }
        int[] iArr = this.z0;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zL = qVar.L();
        boolean zM = this.s.M();
        int i5 = zM ? (zL ? 1 : 0) | 2 : zL ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int iE1 = i2 - e1(i2, height);
        int iF1 = i3 - f1(i3, width);
        E1(i5, i4);
        if (K(zL ? iE1 : 0, zM ? iF1 : 0, this.z0, this.x0, i4)) {
            int[] iArr2 = this.z0;
            iE1 -= iArr2[0];
            iF1 -= iArr2[1];
        }
        r1(zL ? iE1 : 0, zM ? iF1 : 0, motionEvent, i4);
        androidx.recyclerview.widget.i iVar = this.l0;
        if (iVar != null && (iE1 != 0 || iF1 != 0)) {
            iVar.f(this, iE1, iF1);
        }
        I1(i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I1(int i2) {
        getScrollingChildHelper().r(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        this.n0.a(4);
        D1();
        Q0();
        c0 c0Var = this.n0;
        c0Var.e = 1;
        if (c0Var.k) {
            int iG = this.k.g() - 1;
            while (iG >= 0) {
                g0 g0VarO0 = o0(this.k.f(iG));
                if (g0VarO0.K()) {
                    recyclerView2 = this;
                } else {
                    long jK0 = this.k0(g0VarO0);
                    n.b bVarS = this.S.s(this.n0, g0VarO0);
                    g0 g0VarG = this.l.g(jK0);
                    if (g0VarG == null || g0VarG.K()) {
                        recyclerView2 = this;
                        recyclerView2.l.d(g0VarO0, bVarS);
                    } else {
                        boolean zH = this.l.h(g0VarG);
                        boolean zH2 = this.l.h(g0VarO0);
                        if (zH && g0VarG == g0VarO0) {
                            this.l.d(g0VarO0, bVarS);
                        } else {
                            n.b bVarN = this.l.n(g0VarG);
                            this.l.d(g0VarO0, bVarS);
                            n.b bVarM = this.l.m(g0VarO0);
                            if (bVarN == null) {
                                this.u0(jK0, g0VarO0, g0VarG);
                            } else {
                                recyclerView2 = this;
                                recyclerView2.o(g0VarG, g0VarO0, bVarN, bVarM, zH, zH2);
                            }
                        }
                        recyclerView2 = this;
                    }
                }
                iG--;
                this = recyclerView2;
            }
            recyclerView = this;
            recyclerView.l.o(recyclerView.G0);
        } else {
            recyclerView = this;
        }
        recyclerView.s.K1(recyclerView.h);
        c0 c0Var2 = recyclerView.n0;
        c0Var2.c = c0Var2.f;
        recyclerView.J = false;
        recyclerView.K = false;
        c0Var2.k = false;
        c0Var2.l = false;
        recyclerView.s.h = false;
        ArrayList arrayList = recyclerView.h.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        q qVar = recyclerView.s;
        if (qVar.n) {
            qVar.m = 0;
            qVar.n = false;
            recyclerView.h.P();
        }
        recyclerView.s.w1(recyclerView.n0);
        recyclerView.R0();
        recyclerView.H1(false);
        recyclerView.l.f();
        int[] iArr = recyclerView.v0;
        if (recyclerView.C(iArr[0], iArr[1])) {
            recyclerView.N(0, 0);
        }
        recyclerView.c1();
        recyclerView.n1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J0(int i2) {
        int iG = this.k.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.k.f(i3).offsetLeftAndRight(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J1() {
        setScrollState(0);
        K1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean K(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K0(int i2) {
        int iG = this.k.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.k.f(i3).offsetTopAndBottom(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K1() {
        this.k0.stop();
        q qVar = this.s;
        if (qVar != null) {
            qVar.j2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L0(int i2, int i3) {
        int iJ = this.k.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            g0 g0VarO0 = o0(this.k.i(i4));
            if (g0VarO0 != null && !g0VarO0.K() && g0VarO0.h >= i2) {
                if (K0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i4 + " holder " + g0VarO0 + " now at position " + (g0VarO0.h + i3));
                }
                g0VarO0.B(i3, false);
                this.n0.g = true;
            }
        }
        this.h.v(i2, i3);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L1(int i2, int i3, Object obj) {
        int i4;
        int iJ = this.k.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iJ; i6++) {
            View viewI = this.k.i(i6);
            g0 g0VarO0 = o0(viewI);
            if (g0VarO0 != null && !g0VarO0.K() && (i4 = g0VarO0.h) >= i2 && i4 < i5) {
                g0VarO0.b(2);
                g0VarO0.a(obj);
                ((r) viewI.getLayoutParams()).h = true;
            }
        }
        this.h.R(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M(int i2) {
        q qVar = this.s;
        if (qVar != null) {
            qVar.C1(i2);
        }
        U0(i2);
        v vVar = this.o0;
        if (vVar != null) {
            vVar.a(this, i2);
        }
        List list = this.p0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((v) this.p0.get(size)).a(this, i2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iJ = this.k.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iJ; i8++) {
            g0 g0VarO0 = o0(this.k.i(i8));
            if (g0VarO0 != null && (i7 = g0VarO0.h) >= i5 && i7 <= i4) {
                if (K0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i8 + " holder " + g0VarO0);
                }
                if (g0VarO0.h == i2) {
                    g0VarO0.B(i3 - i2, false);
                } else {
                    g0VarO0.B(i6, false);
                }
                this.n0.g = true;
            }
        }
        this.h.w(i2, i3);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(int i2, int i3) {
        this.M++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        V0(i2, i3);
        v vVar = this.o0;
        if (vVar != null) {
            vVar.b(this, i2, i3);
        }
        List list = this.p0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((v) this.p0.get(size)).b(this, i2, i3);
            }
        }
        this.M--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iJ = this.k.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            g0 g0VarO0 = o0(this.k.i(i5));
            if (g0VarO0 != null && !g0VarO0.K()) {
                int i6 = g0VarO0.h;
                if (i6 >= i4) {
                    if (K0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + g0VarO0 + " now at position " + (g0VarO0.h - i3));
                    }
                    g0VarO0.B(-i3, z2);
                    this.n0.g = true;
                } else if (i6 >= i2) {
                    if (K0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + g0VarO0 + " now REMOVED");
                    }
                    g0VarO0.i(i2 - 1, -i3, z2);
                    this.n0.g = true;
                }
            }
        }
        this.h.x(i2, i3, z2);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:3:0x0008 */
    public void O() {
        int i2;
        int size = this.A0.size();
        while (true) {
            size--;
            List list = this.A0;
            if (size < 0) {
                list.clear();
                return;
            }
            g0 g0Var = (g0) list.get(size);
            if (g0Var.f.getParent() == this && !g0Var.K() && (i2 = g0Var.v) != -1) {
                g0Var.f.setImportantForAccessibility(i2);
                g0Var.v = -1;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O0(View view) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P(MotionEvent motionEvent) {
        u uVar = this.w;
        if (uVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return Y(motionEvent);
        }
        uVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.w = null;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P0(View view) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q() {
        if (this.R != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 3);
        this.R = edgeEffectA;
        if (this.m) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q0() {
        this.L++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R() {
        if (this.O != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 0);
        this.O = edgeEffectA;
        if (this.m) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R0() {
        S0(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S() {
        if (this.Q != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 2);
        this.Q = edgeEffectA;
        if (this.m) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S0(boolean z2) {
        int i2 = this.L - 1;
        this.L = i2;
        if (i2 < 1) {
            if (J0 && i2 < 0) {
                defpackage.d.a("layout or scroll counter cannot go below zero.Some calls are not matching", U());
                return;
            }
            this.L = 0;
            if (z2) {
                F();
                O();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T() {
        if (this.P != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 1);
        this.P = edgeEffectA;
        if (this.m) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.U) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.U = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.b0 = x2;
            this.W = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.c0 = y2;
            this.a0 = y2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String U() {
        return " " + super.toString() + ", adapter:" + this.r + ", layout:" + this.s + ", context:" + getContext();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U0(int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V(c0 c0Var) {
        if (getScrollState() != 2) {
            c0Var.p = 0;
            c0Var.q = 0;
        } else {
            OverScroller overScroller = this.k0.h;
            c0Var.p = overScroller.getFinalX() - overScroller.getCurrX();
            c0Var.q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V0(int i2, int i3) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View W(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W0() {
        if (this.t0 || !this.x) {
            return;
        }
        l35.Y(this, this.B0);
        this.t0 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g0 X(View view) {
        View viewW = W(view);
        if (viewW == null) {
            return null;
        }
        return n0(viewW);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean X0() {
        return this.S != null && this.s.k2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Y(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            u uVar = (u) this.v.get(i2);
            if (uVar.b(this, motionEvent) && action != 3) {
                this.w = uVar;
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y0() {
        boolean z2;
        if (this.J) {
            this.j.y();
            if (this.K) {
                this.s.q1(this);
            }
        }
        boolean zX0 = X0();
        androidx.recyclerview.widget.a aVar = this.j;
        if (zX0) {
            aVar.w();
        } else {
            aVar.j();
        }
        boolean z3 = this.q0 || this.r0;
        this.n0.k = this.A && this.S != null && ((z2 = this.J) || z3 || this.s.h) && (!z2 || this.r.k());
        c0 c0Var = this.n0;
        c0Var.l = c0Var.k && z3 && !this.J && X0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(int[] iArr) {
        int iG = this.k.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iG; i4++) {
            g0 g0VarO0 = o0(this.k.f(i4));
            if (!g0VarO0.K()) {
                int iN = g0VarO0.n();
                if (iN < i2) {
                    i2 = iN;
                }
                if (iN > i3) {
                    i3 = iN;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z0(boolean z2) {
        this.K = z2 | this.K;
        this.J = true;
        H0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(int i2, int i3) {
        if (i2 < 0) {
            R();
            if (this.O.isFinished()) {
                this.O.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            S();
            if (this.Q.isFinished()) {
                this.Q.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            T();
            if (this.P.isFinished()) {
                this.P.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            Q();
            if (this.R.isFinished()) {
                this.R.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        postInvalidateOnAnimation();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a1(float f2, float f3, float f4, float f5) {
        boolean z2;
        boolean z3 = true;
        if (f3 < 0.0f) {
            R();
            jq0.d(this.O, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
        } else {
            if (f3 <= 0.0f) {
                z2 = false;
                if (f5 >= 0.0f) {
                    T();
                    jq0.d(this.P, (-f5) / getHeight(), f2 / getWidth());
                } else if (f5 > 0.0f) {
                    Q();
                    jq0.d(this.R, f5 / getHeight(), 1.0f - (f2 / getWidth()));
                } else {
                    z3 = z2;
                }
                if (z3 && f3 == 0.0f && f5 == 0.0f) {
                    return;
                }
                postInvalidateOnAnimation();
            }
            S();
            jq0.d(this.Q, f3 / getWidth(), f4 / getHeight());
        }
        z2 = true;
        if (f5 >= 0.0f) {
        }
        if (z3) {
        }
        postInvalidateOnAnimation();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        q qVar = this.s;
        if (qVar == null || !qVar.d1(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:17:0x002b */
    public final View b0() {
        g0 g0VarC0;
        c0 c0Var = this.n0;
        int i2 = c0Var.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int iB = c0Var.b();
        for (int i3 = i2; i3 < iB; i3++) {
            g0 g0VarC02 = c0(i3);
            if (g0VarC02 == null) {
                break;
            }
            if (g0VarC02.f.hasFocusable()) {
                return g0VarC02.f;
            }
        }
        int iMin = Math.min(iB, i2);
        do {
            iMin--;
            if (iMin < 0 || (g0VarC0 = c0(iMin)) == null) {
                return null;
            }
        } while (!g0VarC0.f.hasFocusable());
        return g0VarC0.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b1(g0 g0Var, n.b bVar) {
        g0Var.G(0, 8192);
        if (this.n0.i && g0Var.z() && !g0Var.w() && !g0Var.K()) {
            this.l.c(k0(g0Var), g0Var);
        }
        this.l.e(g0Var, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g0 c0(int i2) {
        g0 g0Var = null;
        if (this.J) {
            return null;
        }
        int iJ = this.k.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            g0 g0VarO0 = o0(this.k.i(i3));
            if (g0VarO0 != null && !g0VarO0.w() && j0(g0VarO0) == i2) {
                if (!this.k.n(g0VarO0.f)) {
                    return g0VarO0;
                }
                g0Var = g0VarO0;
            }
        }
        return g0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c1() {
        View viewFindViewById;
        if (!this.j0 || this.r == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            if (!this.k.n(getFocusedChild())) {
                return;
            }
        }
        View viewB0 = null;
        g0 g0VarD0 = (this.n0.n == -1 || !this.r.k()) ? null : d0(this.n0.n);
        if (g0VarD0 != null && !this.k.n(g0VarD0.f) && g0VarD0.f.hasFocusable()) {
            viewB0 = g0VarD0.f;
        } else if (this.k.g() > 0) {
            viewB0 = b0();
        }
        if (viewB0 != null) {
            int i2 = this.n0.o;
            if (i2 != -1 && (viewFindViewById = viewB0.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewB0 = viewFindViewById;
            }
            viewB0.requestFocus();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof r) && this.s.N((r) layoutParams);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        q qVar = this.s;
        if (qVar != null && qVar.L()) {
            return this.s.R(this.n0);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        q qVar = this.s;
        if (qVar != null && qVar.L()) {
            return this.s.S(this.n0);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        q qVar = this.s;
        if (qVar != null && qVar.L()) {
            return this.s.T(this.n0);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        q qVar = this.s;
        if (qVar != null && qVar.M()) {
            return this.s.U(this.n0);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        q qVar = this.s;
        if (qVar != null && qVar.M()) {
            return this.s.V(this.n0);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int computeVerticalScrollRange() {
        q qVar = this.s;
        if (qVar != null && qVar.M()) {
            return this.s.W(this.n0);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g0 d0(long j2) {
        h hVar = this.r;
        g0 g0Var = null;
        if (hVar != null && hVar.k()) {
            int iJ = this.k.j();
            for (int i2 = 0; i2 < iJ; i2++) {
                g0 g0VarO0 = o0(this.k.i(i2));
                if (g0VarO0 != null && !g0VarO0.w() && g0VarO0.l() == j2) {
                    if (!this.k.n(g0VarO0.f)) {
                        return g0VarO0;
                    }
                    g0Var = g0VarO0;
                }
            }
        }
        return g0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d1() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.O.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.P;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.P.isFinished();
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.R.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        q layoutManager = getLayoutManager();
        int iG = 0;
        if (layoutManager == null) {
            return false;
        }
        if (layoutManager.M()) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 92 || keyCode == 93) {
                int measuredHeight = getMeasuredHeight();
                if (keyCode == 93) {
                    A1(0, measuredHeight, null, Integer.MIN_VALUE);
                } else {
                    A1(0, -measuredHeight, null, Integer.MIN_VALUE);
                }
                return true;
            }
            if (keyCode == 122 || keyCode == 123) {
                boolean zS0 = layoutManager.S0();
                if (keyCode == 122) {
                    if (zS0) {
                        iG = getAdapter().g();
                    }
                } else if (!zS0) {
                    iG = getAdapter().g();
                }
                C1(iG);
                return true;
            }
        } else if (layoutManager.L()) {
            int keyCode2 = keyEvent.getKeyCode();
            if (keyCode2 == 92 || keyCode2 == 93) {
                int measuredWidth = getMeasuredWidth();
                if (keyCode2 == 93) {
                    A1(measuredWidth, 0, null, Integer.MIN_VALUE);
                } else {
                    A1(-measuredWidth, 0, null, Integer.MIN_VALUE);
                }
                return true;
            }
            if (keyCode2 == 122 || keyCode2 == 123) {
                boolean zS02 = layoutManager.S0();
                if (keyCode2 == 122) {
                    if (zS02) {
                        iG = getAdapter().g();
                    }
                } else if (!zS02) {
                    iG = getAdapter().g();
                }
                C1(iG);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.u.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((p) this.u.get(i2)).i(canvas, this, this.n0);
        }
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.m ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.O;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.m) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.P;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.Q;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.m ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.Q;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.R;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.m) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.R;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.S == null || this.u.size() <= 0 || !this.S.p()) ? z2 : true) {
            postInvalidateOnAnimation();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g0 e0(int i2) {
        return f0(i2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int e1(int i2, float f2) {
        float height = f2 / getHeight();
        float width = i2 / getWidth();
        EdgeEffect edgeEffect = this.O;
        float f3 = 0.0f;
        if (edgeEffect == null || jq0.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.Q;
            if (edgeEffect2 != null && jq0.b(edgeEffect2) != 0.0f) {
                boolean zCanScrollHorizontally = canScrollHorizontally(1);
                EdgeEffect edgeEffect3 = this.Q;
                if (zCanScrollHorizontally) {
                    edgeEffect3.onRelease();
                } else {
                    float fD = jq0.d(edgeEffect3, width, height);
                    if (jq0.b(this.Q) == 0.0f) {
                        this.Q.onRelease();
                    }
                    f3 = fD;
                }
                invalidate();
            }
        } else {
            boolean zCanScrollHorizontally2 = canScrollHorizontally(-1);
            EdgeEffect edgeEffect4 = this.O;
            if (zCanScrollHorizontally2) {
                edgeEffect4.onRelease();
            } else {
                float f4 = -jq0.d(edgeEffect4, -width, 1.0f - height);
                if (jq0.b(this.O) == 0.0f) {
                    this.O.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g0 f0(int i2, boolean z2) {
        int iJ = this.k.j();
        g0 g0Var = null;
        for (int i3 = 0; i3 < iJ; i3++) {
            g0 g0VarO0 = o0(this.k.i(i3));
            if (g0VarO0 != null && !g0VarO0.w()) {
                if (z2) {
                    if (g0VarO0.h != i2) {
                        continue;
                    } else {
                        if (!this.k.n(g0VarO0.f)) {
                            return g0VarO0;
                        }
                        g0Var = g0VarO0;
                    }
                } else if (g0VarO0.n() != i2) {
                    continue;
                }
            }
        }
        return g0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0071  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View focusSearch(View view, int i2) {
        View viewH1;
        boolean z2;
        View viewO1 = this.s.o1(view, i2);
        if (viewO1 != null) {
            return viewO1;
        }
        boolean z3 = (this.r == null || this.s == null || D0() || this.D) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (!z3 || (i2 != 2 && i2 != 1)) {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                z();
                if (W(view) == null) {
                    return null;
                }
                D1();
                viewH1 = this.s.h1(view, i2, this.h, this.n0);
                H1(false);
            } else {
                viewH1 = viewFindNextFocus;
            }
        } else if (this.s.M()) {
            if (focusFinder.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null) {
                z2 = true;
            }
            if (!z2) {
                z2 = focusFinder.findNextFocus(this, view, !((this.s.z0() != 1) ^ (i2 != 2)) ? 66 : 17) == null;
            }
            if (z2) {
            }
            viewH1 = focusFinder.findNextFocus(this, view, i2);
        } else {
            z2 = false;
            if (!z2 && this.s.L()) {
                z2 = focusFinder.findNextFocus(this, view, !((this.s.z0() != 1) ^ (i2 != 2)) ? 66 : 17) == null;
            }
            if (z2) {
                z();
                if (W(view) == null) {
                    return null;
                }
                D1();
                this.s.h1(view, i2, this.h, this.n0);
                H1(false);
            }
            viewH1 = focusFinder.findNextFocus(this, view, i2);
        }
        if (viewH1 == null || viewH1.hasFocusable()) {
            return E0(view, viewH1, i2) ? viewH1 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        m1(viewH1, null);
        return view;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g0(int i2, int i3) {
        return h0(i2, i3, this.f0, this.g0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g1() {
        n nVar = this.S;
        if (nVar != null) {
            nVar.k();
        }
        q qVar = this.s;
        if (qVar != null) {
            qVar.J1(this.h);
            this.s.K1(this.h);
        }
        this.h.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.e0();
        }
        defpackage.d.a("RecyclerView has no LayoutManager", U());
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.f0(getContext(), attributeSet);
        }
        defpackage.d.a("RecyclerView has no LayoutManager", U());
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h getAdapter() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int getBaseline() {
        q qVar = this.s;
        return qVar != null ? qVar.h0() : super.getBaseline();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public androidx.recyclerview.widget.o getCompatAccessibilityDelegate() {
        return this.u0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public m getEdgeEffectFactory() {
        return this.N;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public n getItemAnimator() {
        return this.S;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemDecorationCount() {
        return this.u.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q getLayoutManager() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMaxFlingVelocity() {
        return this.g0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMinFlingVelocity() {
        return this.f0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getNanoTime() {
        if (P0) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t getOnFlingListener() {
        return this.e0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean getPreserveFocusAfterLayout() {
        return this.j0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public w getRecycledViewPool() {
        return this.h.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getScrollState() {
        return this.T;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(g0 g0Var) {
        View view = g0Var.f;
        boolean z2 = view.getParent() == this;
        this.h.O(n0(view));
        if (g0Var.y()) {
            this.k.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.e eVar = this.k;
        if (z2) {
            eVar.k(view);
        } else {
            eVar.b(view, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h0(int i2, int i3, int i4, int i5) {
        int iMax;
        int i6;
        q qVar = this.s;
        if (qVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.D) {
            return false;
        }
        boolean zL = qVar.L();
        boolean zM = this.s.M();
        if (!zL || Math.abs(i2) < i4) {
            i2 = 0;
        }
        if (!zM || Math.abs(i3) < i4) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        if (i2 == 0) {
            iMax = 0;
        } else {
            EdgeEffect edgeEffect = this.O;
            if (edgeEffect == null || jq0.b(edgeEffect) == 0.0f) {
                EdgeEffect edgeEffect2 = this.Q;
                if (edgeEffect2 != null && jq0.b(edgeEffect2) != 0.0f) {
                    if (w1(this.Q, i2, getWidth())) {
                        this.Q.onAbsorb(i2);
                        i2 = 0;
                    }
                    iMax = i2;
                    i2 = 0;
                }
                iMax = 0;
            } else {
                int i7 = -i2;
                if (w1(this.O, i7, getWidth())) {
                    this.O.onAbsorb(i7);
                    i2 = 0;
                }
                iMax = i2;
                i2 = 0;
            }
        }
        if (i3 == 0) {
            i6 = i3;
            i3 = 0;
        } else {
            EdgeEffect edgeEffect3 = this.P;
            if (edgeEffect3 == null || jq0.b(edgeEffect3) == 0.0f) {
                EdgeEffect edgeEffect4 = this.R;
                if (edgeEffect4 != null && jq0.b(edgeEffect4) != 0.0f) {
                    if (w1(this.R, i3, getHeight())) {
                        this.R.onAbsorb(i3);
                        i3 = 0;
                    }
                    i6 = 0;
                }
                i6 = i3;
                i3 = 0;
            } else {
                int i8 = -i3;
                if (w1(this.P, i8, getHeight())) {
                    this.P.onAbsorb(i8);
                    i3 = 0;
                }
                i6 = 0;
            }
        }
        if (iMax != 0 || i3 != 0) {
            int i9 = -i5;
            iMax = Math.max(i9, Math.min(iMax, i5));
            i3 = Math.max(i9, Math.min(i3, i5));
            F1(1);
            this.k0.b(iMax, i3);
        }
        if (i2 == 0 && i6 == 0) {
            return (iMax == 0 && i3 == 0) ? false : true;
        }
        float f2 = i2;
        float f3 = i6;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = zL || zM;
            dispatchNestedFling(f2, f3, z2);
            t tVar = this.e0;
            if (tVar != null && tVar.a(i2, i6)) {
                return true;
            }
            if (z2) {
                F1(1);
                int i10 = -i5;
                this.k0.b(Math.max(i10, Math.min(i2, i5)), Math.max(i10, Math.min(i6, i5)));
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h1(View view) {
        D1();
        boolean zR = this.k.r(view);
        if (zR) {
            g0 g0VarO0 = o0(view);
            this.h.O(g0VarO0);
            this.h.H(g0VarO0);
            if (K0) {
                Log.d("RecyclerView", "after removing animated view: " + view + ", " + this);
            }
        }
        H1(!zR);
        return zR;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(p pVar) {
        j(pVar, -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i0(int i2, int i3) {
        return h0(i2, i3, 0, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i1(p pVar) {
        q qVar = this.s;
        if (qVar != null) {
            qVar.H("Cannot remove item decoration during a scroll  or layout");
        }
        this.u.remove(pVar);
        if (this.u.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        G0();
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.D;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(p pVar, int i2) {
        q qVar = this.s;
        if (qVar != null) {
            qVar.H("Cannot add item decoration during a scroll  or layout");
        }
        if (this.u.isEmpty()) {
            setWillNotDraw(false);
        }
        ArrayList arrayList = this.u;
        if (i2 < 0) {
            arrayList.add(pVar);
        } else {
            arrayList.add(i2, pVar);
        }
        G0();
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j0(g0 g0Var) {
        if (g0Var.q(524) || !g0Var.t()) {
            return -1;
        }
        return this.j.e(g0Var.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j1(u uVar) {
        this.v.remove(uVar);
        if (this.w == uVar) {
            this.w = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(s sVar) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.add(sVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long k0(g0 g0Var) {
        return this.r.k() ? g0Var.l() : g0Var.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k1(v vVar) {
        List list = this.p0;
        if (list != null) {
            list.remove(vVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(u uVar) {
        this.v.add(uVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l0(View view) {
        g0 g0VarO0 = o0(view);
        if (g0VarO0 != null) {
            return g0VarO0.j();
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l1() {
        g0 g0Var;
        int iG = this.k.g();
        for (int i2 = 0; i2 < iG; i2++) {
            View viewF = this.k.f(i2);
            g0 g0VarN0 = n0(viewF);
            if (g0VarN0 != null && (g0Var = g0VarN0.n) != null) {
                View view = g0Var.f;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(v vVar) {
        if (this.p0 == null) {
            this.p0 = new ArrayList();
        }
        this.p0.add(vVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m0(View view) {
        g0 g0VarO0 = o0(view);
        if (g0VarO0 != null) {
            return g0VarO0.n();
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.o.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof r) {
            r rVar = (r) layoutParams;
            if (!rVar.h) {
                Rect rect = rVar.g;
                Rect rect2 = this.o;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.o);
            offsetRectIntoDescendantCoords(view, this.o);
        }
        this.s.R1(this, view, this.o, !this.A, view2 == null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(g0 g0Var, n.b bVar, n.b bVar2) {
        g0Var.H(false);
        if (this.S.a(g0Var, bVar, bVar2)) {
            W0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g0 n0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return o0(view);
        }
        yo1.a("View ", view, " is not a direct child of ", this);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n1() {
        c0 c0Var = this.n0;
        c0Var.n = -1L;
        c0Var.m = -1;
        c0Var.o = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(g0 g0Var, g0 g0Var2, n.b bVar, n.b bVar2, boolean z2, boolean z3) {
        g0Var.H(false);
        if (z2) {
            h(g0Var);
        }
        if (g0Var != g0Var2) {
            if (z3) {
                h(g0Var2);
            }
            g0Var.m = g0Var2;
            h(g0Var);
            this.h.O(g0Var);
            g0Var2.H(false);
            g0Var2.n = g0Var;
        }
        if (this.S.b(g0Var, g0Var2, bVar, bVar2)) {
            W0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o1() {
        VelocityTracker velocityTracker = this.V;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        I1(0);
        d1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.L = 0;
        this.x = true;
        this.A = this.A && !isLayoutRequested();
        this.h.z();
        q qVar = this.s;
        if (qVar != null) {
            qVar.a0(this);
        }
        this.t0 = false;
        if (P0) {
            ThreadLocal threadLocal = androidx.recyclerview.widget.i.j;
            androidx.recyclerview.widget.i iVar = (androidx.recyclerview.widget.i) threadLocal.get();
            this.l0 = iVar;
            if (iVar == null) {
                this.l0 = new androidx.recyclerview.widget.i();
                Display displayS = l35.s(this);
                if (isInEditMode() || displayS == null) {
                    refreshRate = 60.0f;
                    androidx.recyclerview.widget.i iVar2 = this.l0;
                    iVar2.h = (long) (1.0E9f / refreshRate);
                    threadLocal.set(iVar2);
                } else {
                    refreshRate = displayS.getRefreshRate();
                    if (refreshRate < 30.0f) {
                    }
                    androidx.recyclerview.widget.i iVar22 = this.l0;
                    iVar22.h = (long) (1.0E9f / refreshRate);
                    threadLocal.set(iVar22);
                }
            }
            this.l0.a(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.i iVar;
        super.onDetachedFromWindow();
        n nVar = this.S;
        if (nVar != null) {
            nVar.k();
        }
        J1();
        this.x = false;
        q qVar = this.s;
        if (qVar != null) {
            qVar.b0(this, this.h);
        }
        this.A0.clear();
        removeCallbacks(this.B0);
        this.l.j();
        this.h.A();
        rf3.b(this);
        if (!P0 || (iVar = this.l0) == null) {
            return;
        }
        iVar.j(this);
        this.l0 = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((p) this.u.get(i2)).g(canvas, this, this.n0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i2;
        boolean z2;
        float axisValue;
        RecyclerView recyclerView;
        if (this.s != null && !this.D && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f2 = this.s.M() ? -motionEvent.getAxisValue(9) : 0.0f;
                z2 = false;
                axisValue = this.s.L() ? motionEvent.getAxisValue(10) : 0.0f;
                f = f2;
                i2 = 0;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                i2 = 26;
                axisValue = motionEvent.getAxisValue(26);
                if (this.s.M()) {
                    float f3 = -axisValue;
                    axisValue = 0.0f;
                    f = f3;
                } else if (!this.s.L()) {
                    axisValue = 0.0f;
                }
                z2 = this.F0;
            } else {
                i2 = 0;
                z2 = false;
                axisValue = 0.0f;
            }
            int i3 = (int) (f * this.i0);
            int i4 = (int) (axisValue * this.h0);
            if (z2) {
                OverScroller overScroller = this.k0.h;
                recyclerView = this;
                recyclerView.B1(i4 + (overScroller.getFinalX() - overScroller.getCurrX()), i3 + (overScroller.getFinalY() - overScroller.getCurrY()), null, Integer.MIN_VALUE, true);
            } else {
                recyclerView = this;
                recyclerView.I0(i4, i3, motionEvent, 1);
            }
            if (i2 != 0 && !z2) {
                recyclerView.I0.g(motionEvent, i2);
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.D) {
            return false;
        }
        this.w = null;
        if (Y(motionEvent)) {
            s();
            return true;
        }
        q qVar = this.s;
        if (qVar == null) {
            return false;
        }
        boolean zL = qVar.L();
        boolean zM = this.s.M();
        if (this.V == null) {
            this.V = VelocityTracker.obtain();
        }
        this.V.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.E) {
                this.E = false;
            }
            this.U = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.b0 = x2;
            this.W = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.c0 = y2;
            this.a0 = y2;
            if (G1(motionEvent) || this.T == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                I1(1);
            }
            int[] iArr = this.y0;
            iArr[1] = 0;
            iArr[0] = 0;
            F1(0);
        } else if (actionMasked == 1) {
            this.V.clear();
            I1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.U);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.U + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.T != 1) {
                int i2 = x3 - this.W;
                int i3 = y3 - this.a0;
                if (!zL || Math.abs(i2) <= this.d0) {
                    z2 = false;
                } else {
                    this.b0 = x3;
                    z2 = true;
                }
                if (zM && Math.abs(i3) > this.d0) {
                    this.c0 = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            s();
        } else if (actionMasked == 5) {
            this.U = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.b0 = x4;
            this.W = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.c0 = y4;
            this.a0 = y4;
        } else if (actionMasked == 6) {
            T0(motionEvent);
        }
        return this.T == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Trace.beginSection("RV OnLayout");
        G();
        Trace.endSection();
        this.A = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        q qVar = this.s;
        if (qVar == null) {
            B(i2, i3);
            return;
        }
        boolean z2 = false;
        if (qVar.O0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.s.x1(this.h, this.n0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.C0 = z2;
            if (z2 || this.r == null) {
                return;
            }
            if (this.n0.e == 1) {
                H();
            }
            this.s.Z1(i2, i3);
            this.n0.j = true;
            I();
            this.s.c2(i2, i3);
            if (this.s.f2()) {
                this.s.Z1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Buffer.MAX_SIZE));
                this.n0.j = true;
                I();
                this.s.c2(i2, i3);
            }
            this.D0 = getMeasuredWidth();
            this.E0 = getMeasuredHeight();
            return;
        }
        if (this.y) {
            this.s.x1(this.h, this.n0, i2, i3);
            return;
        }
        if (this.G) {
            D1();
            Q0();
            Y0();
            R0();
            c0 c0Var = this.n0;
            if (c0Var.l) {
                c0Var.h = true;
            } else {
                this.j.j();
                this.n0.h = false;
            }
            this.G = false;
            H1(false);
        } else if (this.n0.l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        h hVar = this.r;
        c0 c0Var2 = this.n0;
        if (hVar != null) {
            c0Var2.f = hVar.g();
        } else {
            c0Var2.f = 0;
        }
        D1();
        this.s.x1(this.h, this.n0, i2, i3);
        H1(false);
        this.n0.h = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (D0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a0 a0Var = (a0) parcelable;
        this.i = a0Var;
        super.onRestoreInstanceState(a0Var.c());
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a0 a0Var = new a0(super.onSaveInstanceState());
        a0 a0Var2 = this.i;
        if (a0Var2 != null) {
            a0Var.d(a0Var2);
            return a0Var;
        }
        q qVar = this.s;
        if (qVar != null) {
            a0Var.h = qVar.B1();
            return a0Var;
        }
        a0Var.h = null;
        return a0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        B0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da A[PHI: r1
      0x00da: PHI (r1v45 int) = (r1v25 int), (r1v49 int) binds: [B:41:0x00c5, B:46:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.D || this.E) {
            return false;
        }
        if (P(motionEvent)) {
            s();
            return true;
        }
        q qVar = this.s;
        if (qVar == null) {
            return false;
        }
        boolean zL = qVar.L();
        boolean zM = this.s.M();
        if (this.V == null) {
            this.V = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.y0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.y0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.U = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.b0 = x2;
            this.W = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.c0 = y2;
            this.a0 = y2;
            F1(0);
        } else {
            if (actionMasked == 1) {
                this.V.addMovement(motionEventObtain);
                this.V.computeCurrentVelocity(1000, this.g0);
                float f2 = zL ? -this.V.getXVelocity(this.U) : 0.0f;
                float f3 = zM ? -this.V.getYVelocity(this.U) : 0.0f;
                if ((f2 == 0.0f && f3 == 0.0f) || !g0((int) f2, (int) f3)) {
                    setScrollState(0);
                }
                o1();
                motionEventObtain.recycle();
                return true;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.U);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.U + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.b0 - x3;
                int iMax2 = this.c0 - y3;
                if (this.T != 1) {
                    if (zL) {
                        int i2 = this.d0;
                        iMax = iMax > 0 ? Math.max(0, iMax - i2) : Math.min(0, iMax + i2);
                        boolean z2 = iMax != 0;
                        if (zM) {
                            int i3 = this.d0;
                            iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - i3) : Math.min(0, iMax2 + i3);
                            if (iMax2 != 0) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                if (this.T == 1) {
                    int[] iArr3 = this.z0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    int iE1 = iMax - e1(iMax, motionEvent.getY());
                    int iF1 = iMax2 - f1(iMax2, motionEvent.getX());
                    if (K(zL ? iE1 : 0, zM ? iF1 : 0, this.z0, this.x0, 0)) {
                        int[] iArr4 = this.z0;
                        iE1 -= iArr4[0];
                        iF1 -= iArr4[1];
                        int[] iArr5 = this.y0;
                        int i4 = iArr5[0];
                        int[] iArr6 = this.x0;
                        iArr5[0] = i4 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int[] iArr7 = this.x0;
                    this.b0 = x3 - iArr7[0];
                    this.c0 = y3 - iArr7[1];
                    if (r1(zL ? iE1 : 0, zM ? iF1 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    androidx.recyclerview.widget.i iVar = this.l0;
                    if (iVar != null && (iE1 != 0 || iF1 != 0)) {
                        iVar.f(this, iE1, iF1);
                    }
                }
            } else if (actionMasked == 3) {
                s();
            } else if (actionMasked == 5) {
                this.U = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.b0 = x4;
                this.W = x4;
                int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.c0 = y4;
                this.a0 = y4;
            } else if (actionMasked == 6) {
                T0(motionEvent);
            }
        }
        this.V.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(g0 g0Var, n.b bVar, n.b bVar2) {
        h(g0Var);
        g0Var.H(false);
        if (this.S.c(g0Var, bVar, bVar2)) {
            W0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p1() {
        View focusedChild = (this.j0 && hasFocus() && this.r != null) ? getFocusedChild() : null;
        g0 g0VarX = focusedChild != null ? X(focusedChild) : null;
        if (g0VarX == null) {
            n1();
            return;
        }
        this.n0.n = this.r.k() ? g0VarX.l() : -1L;
        this.n0.m = this.J ? -1 : g0VarX.w() ? g0VarX.i : g0VarX.j();
        this.n0.o = q0(g0VarX.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(String str) {
        if (D0()) {
            if (str == null) {
                defpackage.d.a("Cannot call this method while RecyclerView is computing a layout or scrolling", U());
                return;
            } else {
                e04.a(str);
                return;
            }
        }
        if (this.M > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + U()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int q0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q1() {
        int iJ = this.k.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            g0 g0VarO0 = o0(this.k.i(i2));
            if (J0 && g0VarO0.h == -1 && !g0VarO0.w()) {
                defpackage.d.a("view holder cannot have position -1 unless it is removed", U());
                return;
            } else {
                if (!g0VarO0.K()) {
                    g0VarO0.F();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r(g0 g0Var) {
        n nVar = this.S;
        return nVar == null || nVar.g(g0Var, g0Var.p());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String r0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r1(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        z();
        if (this.r != null) {
            int[] iArr = this.z0;
            iArr[0] = 0;
            iArr[1] = 0;
            s1(i2, i3, iArr);
            int[] iArr2 = this.z0;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i7 = i2 - i9;
            i8 = i3 - i10;
            i6 = i10;
            i5 = i9;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.u.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.z0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        L(i5, i6, i7, i8, this.x0, i4, iArr3);
        int[] iArr4 = this.z0;
        int i11 = iArr4[0];
        int i12 = i7 - i11;
        int i13 = iArr4[1];
        int i14 = i8 - i13;
        boolean z2 = (i11 == 0 && i13 == 0) ? false : true;
        int i15 = this.b0;
        int[] iArr5 = this.x0;
        int i16 = iArr5[0];
        this.b0 = i15 - i16;
        int i17 = this.c0;
        int i18 = iArr5[1];
        this.c0 = i17 - i18;
        int[] iArr6 = this.y0;
        iArr6[0] = iArr6[0] + i16;
        iArr6[1] = iArr6[1] + i18;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !fu2.a(motionEvent, 8194)) {
                a1(motionEvent.getX(), i12, motionEvent.getY(), i14);
                if (Build.VERSION.SDK_INT >= 31 && fu2.a(motionEvent, 4194304)) {
                    d1();
                }
            }
            v(i2, i3);
        }
        if (i5 != 0 || i6 != 0) {
            N(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i6 == 0) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        g0 g0VarO0 = o0(view);
        if (g0VarO0 != null) {
            if (g0VarO0.y()) {
                g0VarO0.f();
            } else if (!g0VarO0.K()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(g0VarO0);
                gp3.a(sb, U());
                return;
            }
        } else if (J0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            gp3.a(sb2, U());
            return;
        }
        view.clearAnimation();
        E(view);
        super.removeDetachedView(view, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.s.z1(this, this.n0, view, view2) && view2 != null) {
            m1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.s.Q1(this, view, rect, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((u) this.v.get(i2)).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.B != 0 || this.D) {
            this.C = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s() {
        o1();
        setScrollState(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Rect s0(View view) {
        r rVar = (r) view.getLayoutParams();
        if (!rVar.h) {
            return rVar.g;
        }
        if (this.n0.e() && (rVar.d() || rVar.u())) {
            return rVar.g;
        }
        Rect rect = rVar.g;
        rect.set(0, 0, 0, 0);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.o.set(0, 0, 0, 0);
            ((p) this.u.get(i2)).e(this.o, view, this, this.n0);
            int i3 = rect.left;
            Rect rect2 = this.o;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        rVar.h = false;
        return rect;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s1(int i2, int i3, int[] iArr) {
        D1();
        Q0();
        Trace.beginSection("RV Scroll");
        V(this.n0);
        int iV1 = i2 != 0 ? this.s.V1(i2, this.h, this.n0) : 0;
        int iX1 = i3 != 0 ? this.s.X1(i3, this.h, this.n0) : 0;
        Trace.endSection();
        l1();
        R0();
        H1(false);
        if (iArr != null) {
            iArr[0] = iV1;
            iArr[1] = iX1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        q qVar = this.s;
        if (qVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.D) {
            return;
        }
        boolean zL = qVar.L();
        boolean zM = this.s.M();
        if (zL || zM) {
            if (!zL) {
                i2 = 0;
            }
            if (!zM) {
                i3 = 0;
            }
            r1(i2, i3, null, 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (x1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.o oVar) {
        this.u0 = oVar;
        l35.g0(this, oVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAdapter(h hVar) {
        setLayoutFrozen(false);
        u1(hVar, false, true);
        Z0(false);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChildDrawingOrderCallback(l lVar) {
        if (lVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.m) {
            B0();
        }
        this.m = z2;
        super.setClipToPadding(z2);
        if (this.A) {
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEdgeEffectFactory(m mVar) {
        hg3.g(mVar);
        this.N = mVar;
        B0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHasFixedSize(boolean z2) {
        this.y = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemAnimator(n nVar) {
        n nVar2 = this.S;
        if (nVar2 != null) {
            nVar2.k();
            this.S.v(null);
        }
        this.S = nVar;
        if (nVar != null) {
            nVar.v(this.s0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemViewCacheSize(int i2) {
        this.h.L(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLayoutManager(q qVar) {
        if (qVar == this.s) {
            return;
        }
        J1();
        if (this.s != null) {
            n nVar = this.S;
            if (nVar != null) {
                nVar.k();
            }
            this.s.J1(this.h);
            this.s.K1(this.h);
            this.h.c();
            if (this.x) {
                this.s.b0(this, this.h);
            }
            this.s.d2(null);
            this.s = null;
        } else {
            this.h.c();
        }
        this.k.o();
        this.s = qVar;
        if (qVar != null) {
            if (qVar.b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(qVar);
                String strU = qVar.b.U();
                sb.append(" is already attached to a RecyclerView:");
                sb.append(strU);
                throw new IllegalArgumentException(sb.toString());
            }
            qVar.d2(this);
            if (this.x) {
                this.s.a0(this);
            }
        }
        this.h.P();
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
        } else {
            jl.a("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOnFlingListener(t tVar) {
        this.e0 = tVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setOnScrollListener(v vVar) {
        this.o0 = vVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPreserveFocusAfterLayout(boolean z2) {
        this.j0 = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRecycledViewPool(w wVar) {
        this.h.J(wVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setRecyclerListener(y yVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setScrollState(int i2) {
        if (i2 == this.T) {
            return;
        }
        if (K0) {
            Log.d("RecyclerView", "setting scroll state to " + i2 + " from " + this.T, new Exception());
        }
        this.T = i2;
        if (i2 != 2) {
            K1();
        }
        M(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.d0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.d0 = viewConfiguration.getScaledTouchSlop();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setViewCacheExtension(e0 e0Var) {
        this.h.K(e0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().o(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.D) {
            q("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.D = true;
                this.E = true;
                J1();
                return;
            }
            this.D = false;
            if (this.C && this.s != null && this.r != null) {
                requestLayout();
            }
            this.C = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t1(int i2) {
        if (this.D) {
            return;
        }
        J1();
        q qVar = this.s;
        if (qVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            qVar.W1(i2);
            awakenScrollBars();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u() {
        int iJ = this.k.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            g0 g0VarO0 = o0(this.k.i(i2));
            if (!g0VarO0.K()) {
                g0VarO0.c();
            }
        }
        this.h.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u0(long j2, g0 g0Var, g0 g0Var2) {
        int iG = this.k.g();
        for (int i2 = 0; i2 < iG; i2++) {
            g0 g0VarO0 = o0(this.k.f(i2));
            if (g0VarO0 != g0Var && k0(g0VarO0) == j2) {
                h hVar = this.r;
                if (hVar == null || !hVar.k()) {
                    StringBuilder sb = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(g0VarO0);
                    sb.append(" \n View Holder 2:");
                    sb.append(g0Var);
                    ep3.a(sb, U());
                    return;
                }
                StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(g0VarO0);
                sb2.append(" \n View Holder 2:");
                sb2.append(g0Var);
                ep3.a(sb2, U());
                return;
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + g0Var2 + " cannot be found but it is necessary for " + g0Var + U());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u1(h hVar, boolean z2, boolean z3) {
        h hVar2 = this.r;
        if (hVar2 != null) {
            hVar2.F(this.g);
            this.r.y(this);
        }
        if (!z2 || z3) {
            g1();
        }
        this.j.y();
        h hVar3 = this.r;
        this.r = hVar;
        if (hVar != null) {
            hVar.D(this.g);
            hVar.u(this);
        }
        q qVar = this.s;
        if (qVar != null) {
            qVar.c1(hVar3, this.r);
        }
        this.h.y(hVar3, this.r, z2);
        this.n0.g = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.O.onRelease();
            zIsFinished = this.O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.Q.onRelease();
            zIsFinished |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.P.onRelease();
            zIsFinished |= this.P.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.R.onRelease();
            zIsFinished |= this.R.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v0() {
        return !this.A || this.J || this.j.p();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v1(g0 g0Var, int i2) {
        if (!D0()) {
            g0Var.f.setImportantForAccessibility(i2);
            return true;
        }
        g0Var.v = i2;
        this.A0.add(g0Var);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int w(int i2) {
        return x(i2, this.O, this.Q, getWidth());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w0() {
        int iG = this.k.g();
        for (int i2 = 0; i2 < iG; i2++) {
            g0 g0VarO0 = o0(this.k.f(i2));
            if (g0VarO0 != null && !g0VarO0.K() && g0VarO0.z()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w1(EdgeEffect edgeEffect, int i2, int i3) {
        if (i2 > 0) {
            return true;
        }
        return t0(-i2) < jq0.b(edgeEffect) * ((float) i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int x(int i2, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i3) {
        if (i2 > 0 && edgeEffect != null && jq0.b(edgeEffect) != 0.0f) {
            int iRound = Math.round(((-i3) / 4.0f) * jq0.d(edgeEffect, ((-i2) * 4.0f) / i3, 0.5f));
            if (iRound != i2) {
                edgeEffect.finish();
            }
            return i2 - iRound;
        }
        if (i2 >= 0 || edgeEffect2 == null || jq0.b(edgeEffect2) == 0.0f) {
            return i2;
        }
        float f2 = i3;
        int iRound2 = Math.round((f2 / 4.0f) * jq0.d(edgeEffect2, (i2 * 4.0f) / f2, 0.5f));
        if (iRound2 != i2) {
            edgeEffect2.finish();
        }
        return i2 - iRound2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x0() {
        this.j = new androidx.recyclerview.widget.a(new g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean x1(AccessibilityEvent accessibilityEvent) {
        if (!D0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? s1.a(accessibilityEvent) : 0;
        this.F |= iA != 0 ? iA : 0;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int y(int i2) {
        return x(i2, this.P, this.R, getHeight());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y0() {
        if (l35.w(this) == 0) {
            l35.o0(this, 8);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y1(int i2, int i3) {
        z1(i2, i3, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z() {
        if (!this.A || this.J) {
            Trace.beginSection("RV FullInvalidate");
            G();
            Trace.endSection();
            return;
        }
        if (this.j.p()) {
            if (!this.j.o(4) || this.j.o(11)) {
                if (this.j.p()) {
                    Trace.beginSection("RV FullInvalidate");
                    G();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            D1();
            Q0();
            this.j.w();
            if (!this.C) {
                if (w0()) {
                    G();
                } else {
                    this.j.i();
                }
            }
            H1(true);
            R0();
            Trace.endSection();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z0() {
        this.k = new androidx.recyclerview.widget.e(new f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z1(int i2, int i3, Interpolator interpolator) {
        A1(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class r extends ViewGroup.MarginLayoutParams {
        public g0 f;
        public final Rect g;
        public boolean h;
        public boolean i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public r(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.g = new Rect();
            this.h = true;
            this.i = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c() {
            return this.f.n();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d() {
            return this.f.z();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean s() {
            return this.f.w();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean u() {
            return this.f.u();
        }

        public r(int i, int i2) {
            super(i, i2);
            this.g = new Rect();
            this.h = true;
            this.i = false;
        }

        public r(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.g = new Rect();
            this.h = true;
            this.i = false;
        }

        public r(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.g = new Rect();
            this.h = true;
            this.i = false;
        }

        public r(r rVar) {
            super((ViewGroup.LayoutParams) rVar);
            this.g = new Rect();
            this.h = true;
            this.i = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a0 extends defpackage.p {
        public static final Parcelable.Creator<a0> CREATOR = new a();
        public Parcelable h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a0 createFromParcel(Parcel parcel) {
                return new a0(parcel, null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a0 createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a0(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public a0[] newArray(int i) {
                return new a0[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a0(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = parcel.readParcelable(classLoader == null ? q.class.getClassLoader() : classLoader);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(a0 a0Var) {
            this.h = a0Var.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.h, 0);
        }

        public a0(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b0 {
        public RecyclerView b;
        public q c;
        public boolean d;
        public boolean e;
        public View f;
        public boolean h;
        public int a = -1;
        public final a g = new a(0, 0);

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface b {
            PointF f(int i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PointF a(int i) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).f(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View b(int i) {
            return this.b.s.d0(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c() {
            return this.b.s.k0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int d(View view) {
            return this.b.m0(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public q e() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int f() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean g() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean h() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j(int i, int i2) {
            PointF pointFA;
            RecyclerView recyclerView = this.b;
            if (this.a == -1 || recyclerView == null) {
                r();
            }
            if (this.d && this.f == null && this.c != null && (pointFA = a(this.a)) != null) {
                float f = pointFA.x;
                if (f != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.s1((int) Math.signum(f), (int) Math.signum(pointFA.y), null);
                }
            }
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (d(view) == this.a) {
                    o(this.f, recyclerView.n0, this.g);
                    this.g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                l(i, i2, recyclerView.n0, this.g);
                boolean zA = this.g.a();
                this.g.c(recyclerView);
                if (zA && this.e) {
                    this.d = true;
                    recyclerView.k0.d();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k(View view) {
            if (d(view) == f()) {
                this.f = view;
                if (RecyclerView.K0) {
                    Log.d("RecyclerView", "smooth scroll target view has been attached");
                }
            }
        }

        public abstract void l(int i, int i2, c0 c0Var, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, c0 c0Var, a aVar);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void p(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q(RecyclerView recyclerView, q qVar) {
            recyclerView.k0.stop();
            if (this.h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.b = recyclerView;
            this.c = qVar;
            int i = this.a;
            if (i == -1) {
                jl.a("Invalid target position");
                return;
            }
            recyclerView.n0.a = i;
            this.e = true;
            this.d = true;
            this.f = b(f());
            m();
            this.b.k0.d();
            this.h = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r() {
            if (this.e) {
                this.e = false;
                n();
                this.b.n0.a = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.D1(this);
                this.c = null;
                this.b = null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a {
            public int a;
            public int b;
            public int c;
            public int d;
            public Interpolator e;
            public boolean f;
            public int g;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public boolean a() {
                return this.d >= 0;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void b(int i) {
                this.d = i;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void c(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.F0(i);
                    this.f = false;
                } else {
                    if (!this.f) {
                        this.g = 0;
                        return;
                    }
                    e();
                    recyclerView.k0.e(this.a, this.b, this.c, this.e);
                    int i2 = this.g + 1;
                    this.g = i2;
                    if (i2 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void d(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final void e() {
                if (this.e != null && this.c < 1) {
                    e04.a("If you provide an interpolator, you must set a positive duration");
                } else {
                    if (this.c >= 1) {
                        return;
                    }
                    e04.a("Scroll duration must be a positive number");
                }
            }

            public a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.g0(layoutParams);
        }
        defpackage.d.a("RecyclerView has no LayoutManager", U());
        return null;
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kk3.a);
    }

    public RecyclerView(Context context) {
        this(context, null);
    }
}

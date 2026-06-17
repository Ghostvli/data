package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.m;
import com.google.android.flexbox.a;
import defpackage.fn;
import defpackage.p21;
import defpackage.q21;
import defpackage.r21;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.q implements p21, RecyclerView.b0.b {
    public static final Rect S = new Rect();
    public final com.google.android.flexbox.a A;
    public RecyclerView.x B;
    public RecyclerView.c0 C;
    public d D;
    public b E;
    public m F;
    public m G;
    public e H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public SparseArray N;
    public final Context O;
    public View P;
    public int Q;
    public a.C0060a R;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public List z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;
        public boolean g;

        public b() {
            this.d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i) {
            int i2 = bVar.d + i;
            bVar.d = i2;
            return i2;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.A() || !FlexboxLayoutManager.this.x) {
                boolean z = this.e;
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                this.c = z ? flexboxLayoutManager.F.i() : flexboxLayoutManager.F.m();
            } else {
                boolean z2 = this.e;
                FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
                this.c = z2 ? flexboxLayoutManager2.F.i() : flexboxLayoutManager2.K0() - FlexboxLayoutManager.this.F.m();
            }
        }

        public final void s(View view) {
            int i = FlexboxLayoutManager.this.t;
            FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
            m mVar = i == 0 ? flexboxLayoutManager.G : flexboxLayoutManager.F;
            if (FlexboxLayoutManager.this.A() || !FlexboxLayoutManager.this.x) {
                if (this.e) {
                    this.c = mVar.d(view) + mVar.o();
                } else {
                    this.c = mVar.g(view);
                }
            } else if (this.e) {
                this.c = mVar.g(view) + mVar.o();
            } else {
                this.c = mVar.d(view);
            }
            this.a = FlexboxLayoutManager.this.D0(view);
            this.g = false;
            int[] iArr = FlexboxLayoutManager.this.A.c;
            int i2 = this.a;
            if (i2 == -1) {
                i2 = 0;
            }
            int i3 = iArr[i2];
            this.b = i3 != -1 ? i3 : 0;
            if (FlexboxLayoutManager.this.z.size() > this.b) {
                this.a = ((r21) FlexboxLayoutManager.this.z.get(this.b)).o;
            }
        }

        public final void t() {
            this.a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.f = false;
            this.g = false;
            boolean zA = FlexboxLayoutManager.this.A();
            FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
            if (zA) {
                int i = flexboxLayoutManager.t;
                FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
                if (i == 0) {
                    this.e = flexboxLayoutManager2.s == 1;
                    return;
                } else {
                    this.e = flexboxLayoutManager2.t == 2;
                    return;
                }
            }
            int i2 = flexboxLayoutManager.t;
            FlexboxLayoutManager flexboxLayoutManager3 = FlexboxLayoutManager.this;
            if (i2 == 0) {
                this.e = flexboxLayoutManager3.s == 3;
            } else {
                this.e = flexboxLayoutManager3.t == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.e + ", mValid=" + this.f + ", mAssignedFromSavedState=" + this.g + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public int a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean j;

        public d() {
            this.h = 1;
            this.i = 1;
        }

        public static /* synthetic */ int c(d dVar, int i) {
            int i2 = dVar.e + i;
            dVar.e = i2;
            return i2;
        }

        public static /* synthetic */ int d(d dVar, int i) {
            int i2 = dVar.e - i;
            dVar.e = i2;
            return i2;
        }

        public static /* synthetic */ int i(d dVar, int i) {
            int i2 = dVar.a - i;
            dVar.a = i2;
            return i2;
        }

        public static /* synthetic */ int l(d dVar) {
            int i = dVar.c;
            dVar.c = i + 1;
            return i;
        }

        public static /* synthetic */ int m(d dVar) {
            int i = dVar.c;
            dVar.c = i - 1;
            return i;
        }

        public static /* synthetic */ int n(d dVar, int i) {
            int i2 = dVar.c + i;
            dVar.c = i2;
            return i2;
        }

        public static /* synthetic */ int q(d dVar, int i) {
            int i2 = dVar.f + i;
            dVar.f = i2;
            return i2;
        }

        public static /* synthetic */ int u(d dVar, int i) {
            int i2 = dVar.d + i;
            dVar.d = i2;
            return i2;
        }

        public static /* synthetic */ int v(d dVar, int i) {
            int i2 = dVar.d - i;
            dVar.d = i2;
            return i2;
        }

        public final boolean D(RecyclerView.c0 c0Var, List list) {
            int i;
            int i2 = this.d;
            return i2 >= 0 && i2 < c0Var.b() && (i = this.c) >= 0 && i < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.c + ", mPosition=" + this.d + ", mOffset=" + this.e + ", mScrollingOffset=" + this.f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.w = -1;
        this.z = new ArrayList();
        this.A = new com.google.android.flexbox.a(this);
        this.E = new b();
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new SparseArray();
        this.Q = -1;
        this.R = new a.C0060a();
        RecyclerView.q.d dVarE0 = RecyclerView.q.E0(context, attributeSet, i, i2);
        int i3 = dVarE0.a;
        if (i3 != 0) {
            if (i3 == 1) {
                if (dVarE0.c) {
                    e3(3);
                } else {
                    e3(2);
                }
            }
        } else if (dVarE0.c) {
            e3(1);
        } else {
            e3(0);
        }
        f3(1);
        d3(4);
        this.O = context;
    }

    private int J2(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z) {
        int iR2;
        int i2;
        if (A() || !this.x) {
            int i3 = this.F.i() - i;
            if (i3 <= 0) {
                return 0;
            }
            iR2 = -R2(-i3, xVar, c0Var);
        } else {
            int iM = i - this.F.m();
            if (iM <= 0) {
                return 0;
            }
            iR2 = R2(iM, xVar, c0Var);
        }
        int i4 = i + iR2;
        if (!z || (i2 = this.F.i() - i4) <= 0) {
            return iR2;
        }
        this.F.r(i2);
        return i2 + iR2;
    }

    private int K2(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z) {
        int iR2;
        int iM;
        if (A() || !this.x) {
            int iM2 = i - this.F.m();
            if (iM2 <= 0) {
                return 0;
            }
            iR2 = -R2(iM2, xVar, c0Var);
        } else {
            int i2 = this.F.i() - i;
            if (i2 <= 0) {
                return 0;
            }
            iR2 = R2(-i2, xVar, c0Var);
        }
        int i3 = i + iR2;
        if (!z || (iM = i3 - this.F.m()) <= 0) {
            return iR2;
        }
        this.F.r(-iM);
        return iR2 - iM;
    }

    private View M2() {
        return j0(0);
    }

    public static boolean U0(int i, int i2, int i3) {
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

    private void Y2(RecyclerView.x xVar, int i, int i2) {
        while (i2 >= i) {
            M1(i2, xVar);
            i2--;
        }
    }

    private boolean e2(View view, int i, int i2, RecyclerView.r rVar) {
        return (!view.isLayoutRequested() && T0() && U0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) rVar).width) && U0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) rVar).height)) ? false : true;
    }

    private int v2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        int iB = c0Var.b();
        z2();
        View viewB2 = B2(iB);
        View viewE2 = E2(iB);
        if (c0Var.b() == 0 || viewB2 == null || viewE2 == null) {
            return 0;
        }
        return Math.min(this.F.n(), this.F.d(viewE2) - this.F.g(viewB2));
    }

    private int w2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        int iB = c0Var.b();
        View viewB2 = B2(iB);
        View viewE2 = E2(iB);
        if (c0Var.b() != 0 && viewB2 != null && viewE2 != null) {
            int iD0 = D0(viewB2);
            int iD02 = D0(viewE2);
            int iAbs = Math.abs(this.F.d(viewE2) - this.F.g(viewB2));
            int i = this.A.c[iD0];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((r4[iD02] - i) + 1))) + (this.F.m() - this.F.g(viewB2)));
            }
        }
        return 0;
    }

    private int x2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        int iB = c0Var.b();
        View viewB2 = B2(iB);
        View viewE2 = E2(iB);
        if (c0Var.b() == 0 || viewB2 == null || viewE2 == null) {
            return 0;
        }
        int iD2 = D2();
        return (int) ((Math.abs(this.F.d(viewE2) - this.F.g(viewB2)) / ((G2() - iD2) + 1)) * c0Var.b());
    }

    private void y2() {
        if (this.D == null) {
            this.D = new d();
        }
    }

    @Override // defpackage.p21
    public boolean A() {
        int i = this.s;
        return i == 0 || i == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void A1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.H = (e) parcelable;
            S1();
        }
    }

    public final int A2(RecyclerView.x xVar, RecyclerView.c0 c0Var, d dVar) {
        if (dVar.f != Integer.MIN_VALUE) {
            if (dVar.a < 0) {
                d.q(dVar, dVar.a);
            }
            X2(xVar, dVar);
        }
        int i = dVar.a;
        int iA = dVar.a;
        boolean zA = A();
        int iU2 = 0;
        while (true) {
            if ((iA <= 0 && !this.D.b) || !dVar.D(c0Var, this.z)) {
                break;
            }
            r21 r21Var = (r21) this.z.get(dVar.c);
            dVar.d = r21Var.o;
            iU2 += U2(r21Var, dVar);
            if (zA || !this.x) {
                d.c(dVar, r21Var.a() * dVar.i);
            } else {
                d.d(dVar, r21Var.a() * dVar.i);
            }
            iA -= r21Var.a();
        }
        d.i(dVar, iU2);
        if (dVar.f != Integer.MIN_VALUE) {
            d.q(dVar, iU2);
            if (dVar.a < 0) {
                d.q(dVar, dVar.a);
            }
            X2(xVar, dVar);
        }
        return i - dVar.a;
    }

    @Override // defpackage.p21
    public int B(View view) {
        int iA0;
        int iF0;
        if (A()) {
            iA0 = I0(view);
            iF0 = i0(view);
        } else {
            iA0 = A0(view);
            iF0 = F0(view);
        }
        return iA0 + iF0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public Parcelable B1() {
        if (this.H != null) {
            return new e(this.H);
        }
        e eVar = new e();
        if (k0() <= 0) {
            eVar.y();
            return eVar;
        }
        View viewM2 = M2();
        eVar.f = D0(viewM2);
        eVar.g = this.F.g(viewM2) - this.F.m();
        return eVar;
    }

    public final View B2(int i) {
        View viewI2 = I2(0, k0(), i);
        if (viewI2 == null) {
            return null;
        }
        int i2 = this.A.c[D0(viewI2)];
        if (i2 == -1) {
            return null;
        }
        return C2(viewI2, (r21) this.z.get(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View C2(android.view.View r6, defpackage.r21 r7) {
        /*
            r5 = this;
            boolean r0 = r5.A()
            int r7 = r7.h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.j0(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.x
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.m r3 = r5.F
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.m r4 = r5.F
            int r4 = r4.d(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.m r3 = r5.F
            int r3 = r3.g(r6)
            androidx.recyclerview.widget.m r4 = r5.F
            int r4 = r4.g(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.C2(android.view.View, r21):android.view.View");
    }

    public int D2() {
        View viewH2 = H2(0, k0(), false);
        if (viewH2 == null) {
            return -1;
        }
        return D0(viewH2);
    }

    public final View E2(int i) {
        View viewI2 = I2(k0() - 1, -1, i);
        if (viewI2 == null) {
            return null;
        }
        return F2(viewI2, (r21) this.z.get(this.A.c[D0(viewI2)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View F2(android.view.View r6, defpackage.r21 r7) {
        /*
            r5 = this;
            boolean r0 = r5.A()
            int r1 = r5.k0()
            int r1 = r1 + (-2)
            int r2 = r5.k0()
            int r7 = r7.h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.j0(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.x
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.m r3 = r5.F
            int r3 = r3.g(r6)
            androidx.recyclerview.widget.m r4 = r5.F
            int r4 = r4.g(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.m r3 = r5.F
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.m r4 = r5.F
            int r4 = r4.d(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.F2(android.view.View, r21):android.view.View");
    }

    public int G2() {
        View viewH2 = H2(k0() - 1, -1, false);
        if (viewH2 == null) {
            return -1;
        }
        return D0(viewH2);
    }

    public final View H2(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View viewJ0 = j0(i);
            if (T2(viewJ0, z)) {
                return viewJ0;
            }
            i += i3;
        }
        return null;
    }

    public final View I2(int i, int i2, int i3) {
        int iD0;
        z2();
        y2();
        int iM = this.F.m();
        int i4 = this.F.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewJ0 = j0(i);
            if (viewJ0 != null && (iD0 = D0(viewJ0)) >= 0 && iD0 < i3) {
                if (((RecyclerView.r) viewJ0.getLayoutParams()).s()) {
                    if (view2 == null) {
                        view2 = viewJ0;
                    }
                } else {
                    if (this.F.g(viewJ0) >= iM && this.F.d(viewJ0) <= i4) {
                        return viewJ0;
                    }
                    if (view == null) {
                        view = viewJ0;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean L() {
        if (this.t == 0) {
            return A();
        }
        if (!A()) {
            return true;
        }
        int iK0 = K0();
        View view = this.P;
        return iK0 > (view != null ? view.getWidth() : 0);
    }

    public final int L2(View view) {
        return p0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean M() {
        if (this.t == 0) {
            return !A();
        }
        if (!A()) {
            int iX0 = x0();
            View view = this.P;
            if (iX0 <= (view != null ? view.getHeight() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean N(RecyclerView.r rVar) {
        return rVar instanceof c;
    }

    public final int N2(View view) {
        return r0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean O0() {
        return true;
    }

    public final int O2(View view) {
        return u0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).rightMargin;
    }

    public final int P2(View view) {
        return v0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).topMargin;
    }

    public View Q2(int i) {
        View view = (View) this.N.get(i);
        return view != null ? view : this.B.o(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int R(RecyclerView.c0 c0Var) {
        return v2(c0Var);
    }

    public final int R2(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (k0() == 0 || i == 0) {
            return 0;
        }
        z2();
        int i2 = 1;
        this.D.j = true;
        boolean z = !A() && this.x;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int iAbs = Math.abs(i);
        l3(i2, iAbs);
        int iA2 = this.D.f + A2(xVar, c0Var, this.D);
        if (iA2 < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iA2) {
                i = (-i2) * iA2;
            }
        } else if (iAbs > iA2) {
            i = i2 * iA2;
        }
        this.F.r(-i);
        this.D.g = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int S(RecyclerView.c0 c0Var) {
        return w2(c0Var);
    }

    public final int S2(int i) {
        if (k0() == 0 || i == 0) {
            return 0;
        }
        z2();
        boolean zA = A();
        View view = this.P;
        int width = zA ? view.getWidth() : view.getHeight();
        int iK0 = zA ? K0() : x0();
        if (z0() == 1) {
            int iAbs = Math.abs(i);
            b bVar = this.E;
            if (i < 0) {
                return -Math.min((iK0 + bVar.d) - width, iAbs);
            }
            if (bVar.d + i > 0) {
                return -this.E.d;
            }
        } else {
            b bVar2 = this.E;
            if (i > 0) {
                return Math.min((iK0 - bVar2.d) - width, i);
            }
            if (bVar2.d + i < 0) {
                return -this.E.d;
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int T(RecyclerView.c0 c0Var) {
        return x2(c0Var);
    }

    public final boolean T2(View view, boolean z) {
        int iY = y();
        int iW = w();
        int iK0 = K0() - p();
        int iX0 = x0() - b();
        int iN2 = N2(view);
        int iP2 = P2(view);
        int iO2 = O2(view);
        int iL2 = L2(view);
        return z ? (iY <= iN2 && iK0 >= iO2) && (iW <= iP2 && iX0 >= iL2) : (iN2 >= iK0 || iO2 >= iY) && (iP2 >= iX0 || iL2 >= iW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int U(RecyclerView.c0 c0Var) {
        return v2(c0Var);
    }

    public final int U2(r21 r21Var, d dVar) {
        return A() ? V2(r21Var, dVar) : W2(r21Var, dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V(RecyclerView.c0 c0Var) {
        return w2(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (!A() || this.t == 0) {
            int iR2 = R2(i, xVar, c0Var);
            this.N.clear();
            return iR2;
        }
        int iS2 = S2(i);
        b.l(this.E, iS2);
        this.G.r(-iS2);
        return iS2;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int V2(defpackage.r21 r18, com.google.android.flexbox.FlexboxLayoutManager.d r19) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.V2(r21, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int W(RecyclerView.c0 c0Var) {
        return x2(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void W1(int i) {
        this.I = i;
        this.J = Integer.MIN_VALUE;
        e eVar = this.H;
        if (eVar != null) {
            eVar.y();
        }
        S1();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int W2(defpackage.r21 r21, com.google.android.flexbox.FlexboxLayoutManager.d r22) {
        /*
            Method dump skipped, instruction units count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.W2(r21, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int X1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (A() || (this.t == 0 && !A())) {
            int iR2 = R2(i, xVar, c0Var);
            this.N.clear();
            return iR2;
        }
        int iS2 = S2(i);
        b.l(this.E, iS2);
        this.G.r(-iS2);
        return iS2;
    }

    public final void X2(RecyclerView.x xVar, d dVar) {
        if (dVar.j) {
            if (dVar.i == -1) {
                Z2(xVar, dVar);
            } else {
                a3(xVar, dVar);
            }
        }
    }

    public final void Z2(RecyclerView.x xVar, d dVar) {
        int iK0;
        int i;
        View viewJ0;
        int i2;
        if (dVar.f < 0 || (iK0 = k0()) == 0 || (viewJ0 = j0(iK0 - 1)) == null || (i2 = this.A.c[D0(viewJ0)]) == -1) {
            return;
        }
        r21 r21Var = (r21) this.z.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            View viewJ02 = j0(i3);
            if (viewJ02 != null) {
                if (!s2(viewJ02, dVar.f)) {
                    break;
                }
                if (r21Var.o != D0(viewJ02)) {
                    continue;
                } else if (i2 <= 0) {
                    iK0 = i3;
                    break;
                } else {
                    i2 += dVar.i;
                    r21Var = (r21) this.z.get(i2);
                    iK0 = i3;
                }
            }
            i3--;
        }
        Y2(xVar, iK0, i);
    }

    public final void a3(RecyclerView.x xVar, d dVar) {
        int iK0;
        View viewJ0;
        if (dVar.f < 0 || (iK0 = k0()) == 0 || (viewJ0 = j0(0)) == null) {
            return;
        }
        int i = this.A.c[D0(viewJ0)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        r21 r21Var = (r21) this.z.get(i);
        int i3 = 0;
        while (true) {
            if (i3 >= iK0) {
                break;
            }
            View viewJ02 = j0(i3);
            if (viewJ02 != null) {
                if (!t2(viewJ02, dVar.f)) {
                    break;
                }
                if (r21Var.p != D0(viewJ02)) {
                    continue;
                } else if (i >= this.z.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += dVar.i;
                    r21Var = (r21) this.z.get(i);
                    i2 = i3;
                }
            }
            i3++;
        }
        Y2(xVar, 0, i2);
    }

    public final void b3() {
        int iY0 = A() ? y0() : L0();
        this.D.b = iY0 == 0 || iY0 == Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c1(RecyclerView.h hVar, RecyclerView.h hVar2) {
        I1();
    }

    public final void c3() {
        int iZ0 = z0();
        int i = this.s;
        if (i == 0) {
            this.x = iZ0 == 1;
            this.y = this.t == 2;
            return;
        }
        if (i == 1) {
            this.x = iZ0 != 1;
            this.y = this.t == 2;
            return;
        }
        if (i == 2) {
            boolean z = iZ0 == 1;
            this.x = z;
            if (this.t == 2) {
                this.x = !z;
            }
            this.y = false;
            return;
        }
        if (i != 3) {
            this.x = false;
            this.y = false;
            return;
        }
        boolean z2 = iZ0 == 1;
        this.x = z2;
        if (this.t == 2) {
            this.x = !z2;
        }
        this.y = true;
    }

    public void d3(int i) {
        int i2 = this.v;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                I1();
                u2();
            }
            this.v = i;
            S1();
        }
    }

    @Override // defpackage.p21
    public int e() {
        return this.C.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r e0() {
        return new c(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void e1(RecyclerView recyclerView) {
        super.e1(recyclerView);
        this.P = (View) recyclerView.getParent();
    }

    public void e3(int i) {
        if (this.s != i) {
            I1();
            this.s = i;
            this.F = null;
            this.G = null;
            u2();
            S1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0.b
    public PointF f(int i) {
        View viewJ0;
        if (k0() == 0 || (viewJ0 = j0(0)) == null) {
            return null;
        }
        int i2 = i < D0(viewJ0) ? -1 : 1;
        return A() ? new PointF(0.0f, i2) : new PointF(i2, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r f0(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public void f3(int i) {
        if (i == 2) {
            fn.a("wrap_reverse is not supported in FlexboxLayoutManager");
            return;
        }
        int i2 = this.t;
        if (i2 != i) {
            if (i2 == 0 || i == 0) {
                I1();
                u2();
            }
            this.t = i;
            this.F = null;
            this.G = null;
            S1();
        }
    }

    @Override // defpackage.p21
    public int g() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void g1(RecyclerView recyclerView, RecyclerView.x xVar) {
        super.g1(recyclerView, xVar);
        if (this.M) {
            J1(xVar);
            xVar.c();
        }
    }

    public final boolean g3(RecyclerView.c0 c0Var, b bVar) {
        if (k0() == 0) {
            return false;
        }
        View viewE2 = bVar.e ? E2(c0Var.b()) : B2(c0Var.b());
        if (viewE2 == null) {
            return false;
        }
        bVar.s(viewE2);
        if (c0Var.e() || !k2()) {
            return true;
        }
        if (this.F.g(viewE2) < this.F.i() && this.F.d(viewE2) >= this.F.m()) {
            return true;
        }
        boolean z = bVar.e;
        m mVar = this.F;
        bVar.c = z ? mVar.i() : mVar.m();
        return true;
    }

    @Override // defpackage.p21
    public int h() {
        return this.w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void h2(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i) {
        k kVar = new k(recyclerView.getContext());
        kVar.p(i);
        i2(kVar);
    }

    public final boolean h3(RecyclerView.c0 c0Var, b bVar, e eVar) {
        int i;
        View viewJ0;
        if (!c0Var.e() && (i = this.I) != -1) {
            if (i >= 0 && i < c0Var.b()) {
                bVar.a = this.I;
                bVar.b = this.A.c[bVar.a];
                e eVar2 = this.H;
                if (eVar2 != null && eVar2.x(c0Var.b())) {
                    bVar.c = this.F.m() + eVar.g;
                    bVar.g = true;
                    bVar.b = -1;
                    return true;
                }
                if (this.J != Integer.MIN_VALUE) {
                    if (A() || !this.x) {
                        bVar.c = this.F.m() + this.J;
                    } else {
                        bVar.c = this.J - this.F.j();
                    }
                    return true;
                }
                View viewD0 = d0(this.I);
                if (viewD0 == null) {
                    if (k0() > 0 && (viewJ0 = j0(0)) != null) {
                        bVar.e = this.I < D0(viewJ0);
                    }
                    bVar.r();
                } else {
                    if (this.F.e(viewD0) > this.F.n()) {
                        bVar.r();
                        return true;
                    }
                    int iG = this.F.g(viewD0) - this.F.m();
                    m mVar = this.F;
                    if (iG < 0) {
                        bVar.c = mVar.m();
                        bVar.e = false;
                        return true;
                    }
                    if (mVar.i() - this.F.d(viewD0) < 0) {
                        bVar.c = this.F.i();
                        bVar.e = true;
                        return true;
                    }
                    boolean z = bVar.e;
                    m mVar2 = this.F;
                    bVar.c = z ? mVar2.d(viewD0) + this.F.o() : mVar2.g(viewD0);
                }
                return true;
            }
            this.I = -1;
            this.J = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // defpackage.p21
    public int i() {
        if (this.z.size() == 0) {
            return 0;
        }
        int size = this.z.size();
        int iMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, ((r21) this.z.get(i)).e);
        }
        return iMax;
    }

    public final void i3(RecyclerView.c0 c0Var, b bVar) {
        if (h3(c0Var, bVar, this.H) || g3(c0Var, bVar)) {
            return;
        }
        bVar.r();
        bVar.a = 0;
        bVar.b = 0;
    }

    @Override // defpackage.p21
    public int j() {
        return this.t;
    }

    public final void j3(int i) {
        if (i >= G2()) {
            return;
        }
        int iK0 = k0();
        this.A.m(iK0);
        this.A.n(iK0);
        this.A.l(iK0);
        if (i >= this.A.c.length) {
            return;
        }
        this.Q = i;
        View viewM2 = M2();
        if (viewM2 == null) {
            return;
        }
        this.I = D0(viewM2);
        if (A() || !this.x) {
            this.J = this.F.g(viewM2) - this.F.m();
        } else {
            this.J = this.F.d(viewM2) + this.F.j();
        }
    }

    @Override // defpackage.p21
    public View k(int i) {
        return Q2(i);
    }

    public final void k3(int i) {
        int i2;
        int i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(K0(), L0());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(x0(), y0());
        int iK0 = K0();
        int iX0 = x0();
        boolean z = false;
        if (A()) {
            int i4 = this.K;
            if (i4 != Integer.MIN_VALUE && i4 != iK0) {
                z = true;
            }
            i2 = this.D.b ? this.O.getResources().getDisplayMetrics().heightPixels : this.D.a;
        } else {
            int i5 = this.L;
            if (i5 != Integer.MIN_VALUE && i5 != iX0) {
                z = true;
            }
            i2 = this.D.b ? this.O.getResources().getDisplayMetrics().widthPixels : this.D.a;
        }
        int i6 = i2;
        this.K = iK0;
        this.L = iX0;
        int i7 = this.Q;
        if (i7 == -1 && (this.I != -1 || z)) {
            if (this.E.e) {
                return;
            }
            this.z.clear();
            this.R.a();
            boolean zA = A();
            com.google.android.flexbox.a aVar = this.A;
            if (zA) {
                aVar.d(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i6, this.E.a, this.z);
            } else {
                aVar.f(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i6, this.E.a, this.z);
            }
            this.z = this.R.a;
            this.A.i(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.A.O();
            b bVar = this.E;
            bVar.b = this.A.c[bVar.a];
            this.D.c = this.E.b;
            return;
        }
        b bVar2 = this.E;
        int iMin = i7 != -1 ? Math.min(i7, bVar2.a) : bVar2.a;
        this.R.a();
        boolean zA2 = A();
        List list = this.z;
        if (zA2) {
            int size = list.size();
            com.google.android.flexbox.a aVar2 = this.A;
            if (size > 0) {
                aVar2.h(this.z, iMin);
                this.A.b(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i6, iMin, this.E.a, this.z);
                i3 = iMin;
            } else {
                i3 = iMin;
                aVar2.l(i);
                this.A.c(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i6, 0, this.z);
            }
        } else {
            i3 = iMin;
            int size2 = list.size();
            com.google.android.flexbox.a aVar3 = this.A;
            if (size2 > 0) {
                aVar3.h(this.z, i3);
                iMin = i3;
                this.A.b(this.R, iMakeMeasureSpec2, iMakeMeasureSpec, i6, iMin, this.E.a, this.z);
                iMakeMeasureSpec2 = iMakeMeasureSpec2;
                iMakeMeasureSpec = iMakeMeasureSpec;
                i3 = iMin;
            } else {
                aVar3.l(i);
                this.A.e(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i6, 0, this.z);
            }
        }
        this.z = this.R.a;
        this.A.j(iMakeMeasureSpec, iMakeMeasureSpec2, i3);
        this.A.P(i3);
    }

    @Override // defpackage.p21
    public int l(int i, int i2, int i3) {
        return RecyclerView.q.l0(K0(), L0(), i2, i3, L());
    }

    public final void l3(int i, int i2) {
        this.D.i = i;
        boolean zA = A();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(K0(), L0());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(x0(), y0());
        boolean z = !zA && this.x;
        if (i == 1) {
            View viewJ0 = j0(k0() - 1);
            if (viewJ0 == null) {
                return;
            }
            this.D.e = this.F.d(viewJ0);
            int iD0 = D0(viewJ0);
            View viewF2 = F2(viewJ0, (r21) this.z.get(this.A.c[iD0]));
            this.D.h = 1;
            d dVar = this.D;
            dVar.d = iD0 + dVar.h;
            int length = this.A.c.length;
            int i3 = this.D.d;
            d dVar2 = this.D;
            if (length <= i3) {
                dVar2.c = -1;
            } else {
                dVar2.c = this.A.c[dVar2.d];
            }
            d dVar3 = this.D;
            if (z) {
                dVar3.e = this.F.g(viewF2);
                this.D.f = (-this.F.g(viewF2)) + this.F.m();
                d dVar4 = this.D;
                dVar4.f = Math.max(dVar4.f, 0);
            } else {
                dVar3.e = this.F.d(viewF2);
                this.D.f = this.F.d(viewF2) - this.F.i();
            }
            if ((this.D.c == -1 || this.D.c > this.z.size() - 1) && this.D.d <= e()) {
                int i4 = i2 - this.D.f;
                this.R.a();
                if (i4 > 0) {
                    com.google.android.flexbox.a aVar = this.A;
                    if (zA) {
                        aVar.c(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.D.d, this.z);
                    } else {
                        aVar.e(this.R, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.D.d, this.z);
                    }
                    this.A.j(iMakeMeasureSpec, iMakeMeasureSpec2, this.D.d);
                    this.A.P(this.D.d);
                }
            }
        } else {
            View viewJ02 = j0(0);
            if (viewJ02 == null) {
                return;
            }
            this.D.e = this.F.g(viewJ02);
            int iD02 = D0(viewJ02);
            View viewC2 = C2(viewJ02, (r21) this.z.get(this.A.c[iD02]));
            this.D.h = 1;
            int i5 = this.A.c[iD02];
            if (i5 == -1) {
                i5 = 0;
            }
            if (i5 > 0) {
                this.D.d = iD02 - ((r21) this.z.get(i5 - 1)).b();
            } else {
                this.D.d = -1;
            }
            this.D.c = i5 > 0 ? i5 - 1 : 0;
            d dVar5 = this.D;
            if (z) {
                dVar5.e = this.F.d(viewC2);
                this.D.f = this.F.d(viewC2) - this.F.i();
                d dVar6 = this.D;
                dVar6.f = Math.max(dVar6.f, 0);
            } else {
                dVar5.e = this.F.g(viewC2);
                this.D.f = (-this.F.g(viewC2)) + this.F.m();
            }
        }
        d dVar7 = this.D;
        dVar7.a = i2 - dVar7.f;
    }

    @Override // defpackage.p21
    public int m() {
        return this.v;
    }

    public final void m3(b bVar, boolean z, boolean z2) {
        if (z2) {
            b3();
        } else {
            this.D.b = false;
        }
        if (A() || !this.x) {
            this.D.a = this.F.i() - bVar.c;
        } else {
            this.D.a = bVar.c - p();
        }
        this.D.d = bVar.a;
        this.D.h = 1;
        this.D.i = 1;
        this.D.e = bVar.c;
        this.D.f = Integer.MIN_VALUE;
        this.D.c = bVar.b;
        if (!z || this.z.size() <= 1 || bVar.b < 0 || bVar.b >= this.z.size() - 1) {
            return;
        }
        r21 r21Var = (r21) this.z.get(bVar.b);
        d.l(this.D);
        d.u(this.D, r21Var.b());
    }

    @Override // defpackage.p21
    public void n(int i, View view) {
        this.N.put(i, view);
    }

    public final void n3(b bVar, boolean z, boolean z2) {
        if (z2) {
            b3();
        } else {
            this.D.b = false;
        }
        if (A() || !this.x) {
            this.D.a = bVar.c - this.F.m();
        } else {
            this.D.a = (this.P.getWidth() - bVar.c) - this.F.m();
        }
        this.D.d = bVar.a;
        this.D.h = 1;
        this.D.i = -1;
        this.D.e = bVar.c;
        this.D.f = Integer.MIN_VALUE;
        this.D.c = bVar.b;
        if (!z || bVar.b <= 0 || this.z.size() <= bVar.b) {
            return;
        }
        r21 r21Var = (r21) this.z.get(bVar.b);
        d.m(this.D);
        d.v(this.D, r21Var.b());
    }

    @Override // defpackage.p21
    public void o(View view, int i, int i2, r21 r21Var) {
        K(view, S);
        if (A()) {
            int iA0 = A0(view) + F0(view);
            r21Var.e += iA0;
            r21Var.f += iA0;
        } else {
            int iI0 = I0(view) + i0(view);
            r21Var.e += iI0;
            r21Var.f += iI0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void p1(RecyclerView recyclerView, int i, int i2) {
        super.p1(recyclerView, i, i2);
        j3(i);
    }

    @Override // defpackage.p21
    public int q(View view, int i, int i2) {
        int iI0;
        int iI02;
        if (A()) {
            iI0 = A0(view);
            iI02 = F0(view);
        } else {
            iI0 = I0(view);
            iI02 = i0(view);
        }
        return iI0 + iI02;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void r1(RecyclerView recyclerView, int i, int i2, int i3) {
        super.r1(recyclerView, i, i2, i3);
        j3(Math.min(i, i2));
    }

    @Override // defpackage.p21
    public List s() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void s1(RecyclerView recyclerView, int i, int i2) {
        super.s1(recyclerView, i, i2);
        j3(i);
    }

    public final boolean s2(View view, int i) {
        return (A() || !this.x) ? this.F.g(view) >= this.F.h() - i : this.F.d(view) <= i;
    }

    @Override // defpackage.p21
    public int t(int i, int i2, int i3) {
        return RecyclerView.q.l0(x0(), y0(), i2, i3, M());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void t1(RecyclerView recyclerView, int i, int i2) {
        super.t1(recyclerView, i, i2);
        j3(i);
    }

    public final boolean t2(View view, int i) {
        return (A() || !this.x) ? this.F.d(view) <= i : this.F.h() - this.F.g(view) <= i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void u1(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.u1(recyclerView, i, i2, obj);
        j3(i);
    }

    public final void u2() {
        this.z.clear();
        this.E.t();
        this.E.d = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void v1(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        int i;
        int i2;
        this.B = xVar;
        this.C = c0Var;
        int iB = c0Var.b();
        if (iB == 0 && c0Var.e()) {
            return;
        }
        c3();
        z2();
        y2();
        this.A.m(iB);
        this.A.n(iB);
        this.A.l(iB);
        this.D.j = false;
        e eVar = this.H;
        if (eVar != null && eVar.x(iB)) {
            this.I = this.H.f;
        }
        if (!this.E.f || this.I != -1 || this.H != null) {
            this.E.t();
            i3(c0Var, this.E);
            this.E.f = true;
        }
        X(xVar);
        boolean z = this.E.e;
        b bVar = this.E;
        if (z) {
            n3(bVar, false, true);
        } else {
            m3(bVar, false, true);
        }
        k3(iB);
        A2(xVar, c0Var, this.D);
        boolean z2 = this.E.e;
        d dVar = this.D;
        if (z2) {
            i2 = dVar.e;
            m3(this.E, true, false);
            A2(xVar, c0Var, this.D);
            i = this.D.e;
        } else {
            i = dVar.e;
            n3(this.E, true, false);
            A2(xVar, c0Var, this.D);
            i2 = this.D.e;
        }
        if (k0() > 0) {
            if (this.E.e) {
                K2(i2 + J2(i, xVar, c0Var, true), xVar, c0Var, false);
            } else {
                J2(i + K2(i2, xVar, c0Var, true), xVar, c0Var, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void w1(RecyclerView.c0 c0Var) {
        super.w1(c0Var);
        this.H = null;
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.Q = -1;
        this.E.t();
        this.N.clear();
    }

    @Override // defpackage.p21
    public void x(r21 r21Var) {
    }

    public final void z2() {
        if (this.F != null) {
            return;
        }
        boolean zA = A();
        int i = this.t;
        if (zA) {
            if (i == 0) {
                this.F = m.a(this);
                this.G = m.c(this);
                return;
            } else {
                this.F = m.c(this);
                this.G = m.a(this);
                return;
            }
        }
        if (i == 0) {
            this.F = m.c(this);
            this.G = m.a(this);
        } else {
            this.F = m.a(this);
            this.G = m.c(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public int f;
        public int g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f + ", mAnchorOffset=" + this.g + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public final boolean x(int i) {
            int i2 = this.f;
            return i2 >= 0 && i2 < i;
        }

        public final void y() {
            this.f = -1;
        }

        public e() {
        }

        public e(e eVar) {
            this.f = eVar.f;
            this.g = eVar.g;
        }
    }

    public FlexboxLayoutManager(Context context, int i, int i2) {
        this.w = -1;
        this.z = new ArrayList();
        this.A = new com.google.android.flexbox.a(this);
        this.E = new b();
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new SparseArray();
        this.Q = -1;
        this.R = new a.C0060a();
        e3(i);
        f3(i2);
        d3(4);
        this.O = context;
    }

    public FlexboxLayoutManager(Context context, int i) {
        this(context, i, 1);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends RecyclerView.r implements q21 {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public float j;
        public float k;
        public int l;
        public float m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcel parcel) {
            super(-2, -2);
            this.j = 0.0f;
            this.k = 1.0f;
            this.l = -1;
            this.m = -1.0f;
            this.p = 16777215;
            this.q = 16777215;
            this.j = parcel.readFloat();
            this.k = parcel.readFloat();
            this.l = parcel.readInt();
            this.m = parcel.readFloat();
            this.n = parcel.readInt();
            this.o = parcel.readInt();
            this.p = parcel.readInt();
            this.q = parcel.readInt();
            this.r = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        @Override // defpackage.q21
        public int a() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // defpackage.q21
        public int b() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // defpackage.q21
        public int e() {
            return this.l;
        }

        @Override // defpackage.q21
        public float f() {
            return this.k;
        }

        @Override // defpackage.q21
        public int g() {
            return this.n;
        }

        @Override // defpackage.q21
        public void h(int i) {
            this.n = i;
        }

        @Override // defpackage.q21
        public int i() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // defpackage.q21
        public int j() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // defpackage.q21
        public int k() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // defpackage.q21
        public void l(int i) {
            this.o = i;
        }

        @Override // defpackage.q21
        public float m() {
            return this.j;
        }

        @Override // defpackage.q21
        public float n() {
            return this.m;
        }

        @Override // defpackage.q21
        public int o() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // defpackage.q21
        public int p() {
            return this.o;
        }

        @Override // defpackage.q21
        public boolean q() {
            return this.r;
        }

        @Override // defpackage.q21
        public int r() {
            return this.q;
        }

        @Override // defpackage.q21
        public int t() {
            return this.p;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.j);
            parcel.writeFloat(this.k);
            parcel.writeInt(this.l);
            parcel.writeFloat(this.m);
            parcel.writeInt(this.n);
            parcel.writeInt(this.o);
            parcel.writeInt(this.p);
            parcel.writeInt(this.q);
            parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public c(int i, int i2) {
            super(i, i2);
            this.j = 0.0f;
            this.k = 1.0f;
            this.l = -1;
            this.m = -1.0f;
            this.p = 16777215;
            this.q = 16777215;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.j = 0.0f;
            this.k = 1.0f;
            this.l = -1;
            this.m = -1.0f;
            this.p = 16777215;
            this.q = 16777215;
        }
    }
}

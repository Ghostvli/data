package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.g2;
import defpackage.jl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.q implements RecyclerView.b0.b {
    public BitSet B;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public int[] O;
    public f[] t;
    public m u;
    public m v;
    public int w;
    public int x;
    public final j y;
    public int s = -1;
    public boolean z = false;
    public boolean A = false;
    public int C = -1;
    public int D = Integer.MIN_VALUE;
    public d E = new d();
    public int F = 2;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public final Runnable P = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.r2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b {
        public int a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            c();
        }

        public void a() {
            boolean z = this.c;
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            this.b = z ? staggeredGridLayoutManager.u.i() : staggeredGridLayoutManager.u.m();
        }

        public void b(int i) {
            boolean z = this.c;
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            if (z) {
                this.b = staggeredGridLayoutManager.u.i() - i;
            } else {
                this.b = staggeredGridLayoutManager.u.m() + i;
            }
        }

        public void c() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = fVarArr[i].p(Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f {
        public ArrayList a = new ArrayList();
        public int b = Integer.MIN_VALUE;
        public int c = Integer.MIN_VALUE;
        public int d = 0;
        public final int e;

        public f(int i) {
            this.e = i;
        }

        public void a(View view) {
            c cVarN = n(view);
            cVarN.j = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (cVarN.s() || cVarN.d()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        public void b(boolean z, int i) {
            int iL = z ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iL >= StaggeredGridLayoutManager.this.u.i()) {
                if (z || iL <= StaggeredGridLayoutManager.this.u.m()) {
                    if (i != Integer.MIN_VALUE) {
                        iL += i;
                    }
                    this.c = iL;
                    this.b = iL;
                }
            }
        }

        public void c() {
            d.a aVarF;
            ArrayList arrayList = this.a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.c = StaggeredGridLayoutManager.this.u.d(view);
            if (cVarN.k && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarN.c())) != null && aVarF.g == 1) {
                this.c += aVarF.c(this.e);
            }
        }

        public void d() {
            d.a aVarF;
            View view = (View) this.a.get(0);
            c cVarN = n(view);
            this.b = StaggeredGridLayoutManager.this.u.g(view);
            if (cVarN.k && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarN.c())) != null && aVarF.g == -1) {
                this.b -= aVarF.c(this.e);
            }
        }

        public void e() {
            this.a.clear();
            q();
            this.d = 0;
        }

        public int f() {
            boolean z = StaggeredGridLayoutManager.this.z;
            ArrayList arrayList = this.a;
            return z ? i(arrayList.size() - 1, -1, true) : i(0, arrayList.size(), true);
        }

        public int g() {
            boolean z = StaggeredGridLayoutManager.this.z;
            ArrayList arrayList = this.a;
            return z ? i(0, arrayList.size(), true) : i(arrayList.size() - 1, -1, true);
        }

        public int h(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iM = StaggeredGridLayoutManager.this.u.m();
            int i3 = StaggeredGridLayoutManager.this.u.i();
            int i4 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.a.get(i);
                int iG = StaggeredGridLayoutManager.this.u.g(view);
                int iD = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iG >= i3 : iG > i3;
                if (!z3 ? iD > iM : iD >= iM) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iG >= iM && iD <= i3) {
                            return StaggeredGridLayoutManager.this.D0(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.D0(view);
                        }
                        if (iG < iM || iD > i3) {
                            return StaggeredGridLayoutManager.this.D0(view);
                        }
                    }
                }
                i += i4;
            }
            return -1;
        }

        public int i(int i, int i2, boolean z) {
            return h(i, i2, false, false, z);
        }

        public int j() {
            return this.d;
        }

        public int k() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        public int l(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        public View m(int i, int i2) {
            ArrayList arrayList = this.a;
            View view = null;
            if (i2 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.D0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.D0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = (View) this.a.get(i3);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.D0(view3) <= i) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.D0(view3) >= i) || !view3.hasFocusable()) {
                    break;
                }
                i3++;
                view = view3;
            }
            return view;
        }

        public c n(View view) {
            return (c) view.getLayoutParams();
        }

        public int o() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.b;
        }

        public int p(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            d();
            return this.b;
        }

        public void q() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        public void r(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        public void s() {
            int size = this.a.size();
            View view = (View) this.a.remove(size - 1);
            c cVarN = n(view);
            cVarN.j = null;
            if (cVarN.s() || cVarN.d()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(view);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public void t() {
            View view = (View) this.a.remove(0);
            c cVarN = n(view);
            cVarN.j = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (cVarN.s() || cVarN.d()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(view);
            }
            this.b = Integer.MIN_VALUE;
        }

        public void u(View view) {
            c cVarN = n(view);
            cVarN.j = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (cVarN.s() || cVarN.d()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        public void v(int i) {
            this.b = i;
            this.c = i;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.q.d dVarE0 = RecyclerView.q.E0(context, attributeSet, i, i2);
        g3(dVarE0.a);
        i3(dVarE0.b);
        h3(dVarE0.c);
        this.y = new j();
        z2();
    }

    private void T2(View view, int i, int i2, boolean z) {
        K(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int iQ3 = q3(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int iQ32 = q3(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? g2(view, iQ3, iQ32, cVar) : e2(view, iQ3, iQ32, cVar)) {
            view.measure(iQ3, iQ32);
        }
    }

    private void d3() {
        if (this.w == 1 || !S2()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    private int t2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        return p.a(c0Var, this.u, D2(!this.N), C2(!this.N), this, this.N);
    }

    private int u2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        return p.b(c0Var, this.u, D2(!this.N), C2(!this.N), this, this.N, this.A);
    }

    private int v2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        return p.c(c0Var, this.u, D2(!this.N), C2(!this.N), this, this.N);
    }

    private int w2(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && S2()) ? -1 : 1 : (this.w != 1 && S2()) ? 1 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void A1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            this.I = eVar;
            if (this.C != -1) {
                eVar.c();
                this.I.d();
            }
            S1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.RecyclerView$q, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    public final int A2(RecyclerView.x xVar, j jVar, RecyclerView.c0 c0Var) {
        f fVarO2;
        int iN2;
        int iE;
        int iM;
        int iE2;
        ?? r0;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this;
        ?? r8 = 0;
        staggeredGridLayoutManager.B.set(0, staggeredGridLayoutManager.s, true);
        int i = staggeredGridLayoutManager.y.i ? jVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : jVar.e == 1 ? jVar.g + jVar.b : jVar.f - jVar.b;
        staggeredGridLayoutManager.j3(jVar.e, i);
        boolean z = staggeredGridLayoutManager.A;
        m mVar = staggeredGridLayoutManager.u;
        int i2 = z ? mVar.i() : mVar.m();
        boolean z2 = false;
        ?? r02 = staggeredGridLayoutManager;
        while (jVar.a(c0Var) && (r02.y.i || !r02.B.isEmpty())) {
            View viewB = jVar.b(xVar);
            c cVar = (c) viewB.getLayoutParams();
            int iC = cVar.c();
            int iG = r02.E.g(iC);
            ?? r5 = iG == -1 ? 1 : r8;
            if (r5 != 0) {
                fVarO2 = cVar.k ? r02.t[r8] : r02.O2(jVar);
                r02.E.n(iC, fVarO2);
            } else {
                fVarO2 = r02.t[iG];
            }
            f fVar = fVarO2;
            cVar.j = fVar;
            if (jVar.e == 1) {
                r02.E(viewB);
            } else {
                r02.F(viewB, r8);
            }
            r02.U2(viewB, cVar, r8);
            int i3 = jVar.e;
            boolean z3 = cVar.k;
            if (i3 == 1) {
                iE = z3 ? r02.K2(i2) : fVar.l(i2);
                iN2 = r02.u.e(viewB) + iE;
                if (r5 != 0 && cVar.k) {
                    d.a aVarX2 = r02.x2(iE);
                    aVarX2.g = -1;
                    aVarX2.f = iC;
                    r02.E.a(aVarX2);
                }
            } else {
                iN2 = z3 ? r02.N2(i2) : fVar.p(i2);
                iE = iN2 - r02.u.e(viewB);
                if (r5 != 0 && cVar.k) {
                    d.a aVarY2 = r02.y2(iN2);
                    aVarY2.g = 1;
                    aVarY2.f = iC;
                    r02.E.a(aVarY2);
                }
            }
            if (cVar.k && jVar.d == -1) {
                if (r5 != 0) {
                    r02.M = true;
                } else {
                    if (!(jVar.e == 1 ? r02.n2() : r02.o2())) {
                        d.a aVarF = r02.E.f(iC);
                        if (aVarF != null) {
                            aVarF.i = true;
                        }
                        r02.M = true;
                    }
                }
            }
            r02.p2(viewB, cVar, jVar);
            if (r02.S2() && r02.w == 1) {
                boolean z4 = cVar.k;
                m mVar2 = r02.v;
                iE2 = z4 ? mVar2.i() : mVar2.i() - (((r02.s - 1) - fVar.e) * r02.x);
                iM = iE2 - r02.v.e(viewB);
            } else {
                iM = cVar.k ? r02.v.m() : (fVar.e * r02.x) + r02.v.m();
                iE2 = r02.v.e(viewB) + iM;
            }
            int i4 = iE2;
            int i5 = iM;
            if (r02.w == 1) {
                r02.X0(viewB, i5, iE, i4, iN2);
                r0 = this;
            } else {
                r02.X0(viewB, iE, i5, iN2, i4);
                r0 = r02;
            }
            boolean z5 = cVar.k;
            j jVar2 = r0.y;
            if (z5) {
                r0.j3(jVar2.e, i);
            } else {
                r0.p3(fVar, jVar2.e, i);
            }
            r0.Z2(xVar, r0.y);
            if (r0.y.h && viewB.hasFocusable()) {
                boolean z6 = cVar.k;
                BitSet bitSet = r0.B;
                if (z6) {
                    bitSet.clear();
                } else {
                    bitSet.set(fVar.e, false);
                }
            }
            z2 = true;
            r8 = 0;
            r02 = r0;
        }
        if (!z2) {
            r02.Z2(xVar, r02.y);
        }
        int i6 = r02.y.e;
        m mVar3 = r02.u;
        int iM2 = i6 == -1 ? r02.u.m() - r02.N2(mVar3.m()) : r02.K2(mVar3.i()) - r02.u.i();
        if (iM2 > 0) {
            return Math.min(jVar.b, iM2);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public Parcelable B1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.m = this.z;
        eVar.n = this.G;
        eVar.o = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar.j = 0;
        } else {
            eVar.k = iArr;
            eVar.j = iArr.length;
            eVar.l = dVar.b;
        }
        if (k0() <= 0) {
            eVar.f = -1;
            eVar.g = -1;
            eVar.h = 0;
            return eVar;
        }
        eVar.f = this.G ? J2() : I2();
        eVar.g = E2();
        int i = this.s;
        eVar.h = i;
        eVar.i = new int[i];
        for (int i2 = 0; i2 < this.s; i2++) {
            boolean z = this.G;
            f[] fVarArr = this.t;
            if (z) {
                iP = fVarArr[i2].l(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iM = this.u.i();
                    iP -= iM;
                }
            } else {
                iP = fVarArr[i2].p(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iM = this.u.m();
                    iP -= iM;
                }
            }
            eVar.i[i2] = iP;
        }
        return eVar;
    }

    public final int B2(int i) {
        int iK0 = k0();
        for (int i2 = 0; i2 < iK0; i2++) {
            int iD0 = D0(j0(i2));
            if (iD0 >= 0 && iD0 < i) {
                return iD0;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void C1(int i) {
        if (i == 0) {
            r2();
        }
    }

    public View C2(boolean z) {
        int iM = this.u.m();
        int i = this.u.i();
        View view = null;
        for (int iK0 = k0() - 1; iK0 >= 0; iK0--) {
            View viewJ0 = j0(iK0);
            int iG = this.u.g(viewJ0);
            int iD = this.u.d(viewJ0);
            if (iD > iM && iG < i) {
                if (iD <= i || !z) {
                    return viewJ0;
                }
                if (view == null) {
                    view = viewJ0;
                }
            }
        }
        return view;
    }

    public View D2(boolean z) {
        int iM = this.u.m();
        int i = this.u.i();
        int iK0 = k0();
        View view = null;
        for (int i2 = 0; i2 < iK0; i2++) {
            View viewJ0 = j0(i2);
            int iG = this.u.g(viewJ0);
            if (this.u.d(viewJ0) > iM && iG < i) {
                if (iG >= iM || !z) {
                    return viewJ0;
                }
                if (view == null) {
                    view = viewJ0;
                }
            }
        }
        return view;
    }

    public int E2() {
        View viewC2 = this.A ? C2(true) : D2(true);
        if (viewC2 == null) {
            return -1;
        }
        return D0(viewC2);
    }

    public final int F2(int i) {
        for (int iK0 = k0() - 1; iK0 >= 0; iK0--) {
            int iD0 = D0(j0(iK0));
            if (iD0 >= 0 && iD0 < i) {
                return iD0;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int G0(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (this.w == 0) {
            return Math.min(this.s, c0Var.b());
        }
        return -1;
    }

    public final void G2(RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z) {
        int i;
        int iK2 = K2(Integer.MIN_VALUE);
        if (iK2 != Integer.MIN_VALUE && (i = this.u.i() - iK2) > 0) {
            int i2 = i - (-e3(-i, xVar, c0Var));
            if (!z || i2 <= 0) {
                return;
            }
            this.u.r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void H(String str) {
        if (this.I == null) {
            super.H(str);
        }
    }

    public final void H2(RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z) {
        int iM;
        int iN2 = N2(Integer.MAX_VALUE);
        if (iN2 != Integer.MAX_VALUE && (iM = iN2 - this.u.m()) > 0) {
            int iE3 = iM - e3(iM, xVar, c0Var);
            if (!z || iE3 <= 0) {
                return;
            }
            this.u.r(-iE3);
        }
    }

    public int I2() {
        if (k0() == 0) {
            return 0;
        }
        return D0(j0(0));
    }

    public int J2() {
        int iK0 = k0();
        if (iK0 == 0) {
            return 0;
        }
        return D0(j0(iK0 - 1));
    }

    public final int K2(int i) {
        int iL = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iL2 = this.t[i2].l(i);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean L() {
        return this.w == 0;
    }

    public final int L2(int i) {
        int iP = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iP2 = this.t[i2].p(i);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean M() {
        return this.w == 1;
    }

    public final int M2(int i) {
        int iL = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iL2 = this.t[i2].l(i);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean N(RecyclerView.r rVar) {
        return rVar instanceof c;
    }

    public final int N2(int i) {
        int iP = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iP2 = this.t[i2].p(i);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean O0() {
        return this.F != 0;
    }

    public final f O2(j jVar) {
        int i;
        int i2;
        int i3;
        boolean zW2 = W2(jVar.e);
        int i4 = this.s;
        if (zW2) {
            i2 = i4 - 1;
            i3 = -1;
            i = -1;
        } else {
            i = i4;
            i2 = 0;
            i3 = 1;
        }
        int i5 = jVar.e;
        m mVar = this.u;
        f fVar = null;
        if (i5 == 1) {
            int iM = mVar.m();
            int i6 = Integer.MAX_VALUE;
            while (i2 != i) {
                f fVar2 = this.t[i2];
                int iL = fVar2.l(iM);
                if (iL < i6) {
                    fVar = fVar2;
                    i6 = iL;
                }
                i2 += i3;
            }
            return fVar;
        }
        int i7 = mVar.i();
        int i8 = Integer.MIN_VALUE;
        while (i2 != i) {
            f fVar3 = this.t[i2];
            int iP = fVar3.p(i7);
            if (iP > i8) {
                fVar = fVar3;
                i8 = iP;
            }
            i2 += i3;
        }
        return fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void P(int i, int i2, RecyclerView.c0 c0Var, RecyclerView.q.c cVar) {
        int iL;
        int iP;
        if (this.w != 0) {
            i = i2;
        }
        if (k0() == 0 || i == 0) {
            return;
        }
        X2(i, c0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.s; i4++) {
            j jVar = this.y;
            if (jVar.d == -1) {
                iL = jVar.f;
                iP = this.t[i4].p(iL);
            } else {
                iL = this.t[i4].l(jVar.g);
                iP = this.y.g;
            }
            int i5 = iL - iP;
            if (i5 >= 0) {
                this.O[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.O, 0, i3);
        for (int i6 = 0; i6 < i3 && this.y.a(c0Var); i6++) {
            cVar.a(this.y.c, this.O[i6]);
            j jVar2 = this.y;
            jVar2.c += jVar2.d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.J2()
            goto Ld
        L9:
            int r0 = r6.I2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            goto L57
        L45:
            boolean r7 = r6.A
            if (r7 == 0) goto L4e
            int r7 = r6.I2()
            goto L52
        L4e:
            int r7 = r6.J2()
        L52:
            if (r3 > r7) goto L57
            r6.S1()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P2(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View Q2() {
        /*
            r12 = this;
            int r0 = r12.k0()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.w
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.S2()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.A
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La2
            android.view.View r7 = r12.j0(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.j
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.j
            boolean r9 = r12.s2(r9)
            if (r9 == 0) goto L4b
            goto L9f
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.j
            int r9 = r9.e
            r2.clear(r9)
        L52:
            boolean r9 = r8.k
            if (r9 == 0) goto L57
            goto La0
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La0
            android.view.View r9 = r12.j0(r9)
            boolean r10 = r12.A
            androidx.recyclerview.widget.m r11 = r12.u
            if (r10 == 0) goto L75
            int r10 = r11.d(r7)
            androidx.recyclerview.widget.m r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            goto L9f
        L72:
            if (r10 != r11) goto La0
            goto L84
        L75:
            int r10 = r11.g(r7)
            androidx.recyclerview.widget.m r11 = r12.u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L82
            goto L9f
        L82:
            if (r10 != r11) goto La0
        L84:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.j
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.j
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L97
            r8 = r5
            goto L98
        L97:
            r8 = r4
        L98:
            if (r3 >= 0) goto L9c
            r9 = r5
            goto L9d
        L9c:
            r9 = r4
        L9d:
            if (r8 == r9) goto La0
        L9f:
            return r7
        La0:
            int r1 = r1 + r6
            goto L2c
        La2:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int R(RecyclerView.c0 c0Var) {
        return t2(c0Var);
    }

    public void R2() {
        this.E.b();
        S1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int S(RecyclerView.c0 c0Var) {
        return u2(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean S0() {
        return this.z;
    }

    public boolean S2() {
        return z0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int T(RecyclerView.c0 c0Var) {
        return v2(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int U(RecyclerView.c0 c0Var) {
        return t2(c0Var);
    }

    public final void U2(View view, c cVar, boolean z) {
        boolean z2 = cVar.k;
        int i = this.w;
        if (z2) {
            if (i == 1) {
                T2(view, this.J, RecyclerView.q.l0(x0(), y0(), w() + b(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
                return;
            } else {
                T2(view, RecyclerView.q.l0(K0(), L0(), y() + p(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z);
                return;
            }
        }
        if (i == 1) {
            T2(view, RecyclerView.q.l0(this.x, L0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.q.l0(x0(), y0(), w() + b(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
        } else {
            T2(view, RecyclerView.q.l0(K0(), L0(), y() + p(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.q.l0(this.x, y0(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V(RecyclerView.c0 c0Var) {
        return u2(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        return e3(i, xVar, c0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V2(androidx.recyclerview.widget.RecyclerView.x r9, androidx.recyclerview.widget.RecyclerView.c0 r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V2(androidx.recyclerview.widget.RecyclerView$x, androidx.recyclerview.widget.RecyclerView$c0, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int W(RecyclerView.c0 c0Var) {
        return v2(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void W1(int i) {
        e eVar = this.I;
        if (eVar != null && eVar.f != i) {
            eVar.c();
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        S1();
    }

    public final boolean W2(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == S2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int X1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        return e3(i, xVar, c0Var);
    }

    public void X2(int i, RecyclerView.c0 c0Var) {
        int iI2;
        int i2;
        if (i > 0) {
            iI2 = J2();
            i2 = 1;
        } else {
            iI2 = I2();
            i2 = -1;
        }
        this.y.a = true;
        n3(iI2, c0Var);
        f3(i2);
        j jVar = this.y;
        jVar.c = iI2 + jVar.d;
        jVar.b = Math.abs(i);
    }

    public final void Y2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].u(view);
        }
    }

    public final void Z2(RecyclerView.x xVar, j jVar) {
        if (!jVar.a || jVar.i) {
            return;
        }
        int i = jVar.b;
        int i2 = jVar.e;
        if (i == 0) {
            if (i2 == -1) {
                a3(xVar, jVar.g);
                return;
            } else {
                b3(xVar, jVar.f);
                return;
            }
        }
        if (i2 != -1) {
            int iM2 = M2(jVar.g) - jVar.g;
            int iMin = jVar.f;
            if (iM2 >= 0) {
                iMin += Math.min(iM2, jVar.b);
            }
            b3(xVar, iMin);
            return;
        }
        int i3 = jVar.f;
        int iL2 = i3 - L2(i3);
        int iMin2 = jVar.g;
        if (iL2 >= 0) {
            iMin2 -= Math.min(iL2, jVar.b);
        }
        a3(xVar, iMin2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a1(int i) {
        super.a1(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    public final void a3(RecyclerView.x xVar, int i) {
        for (int iK0 = k0() - 1; iK0 >= 0; iK0--) {
            View viewJ0 = j0(iK0);
            if (this.u.g(viewJ0) < i || this.u.q(viewJ0) < i) {
                return;
            }
            c cVar = (c) viewJ0.getLayoutParams();
            if (cVar.k) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].s();
                }
            } else if (cVar.j.a.size() == 1) {
                return;
            } else {
                cVar.j.s();
            }
            L1(viewJ0, xVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b1(int i) {
        super.b1(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b2(Rect rect, int i, int i2) {
        int iO;
        int iO2;
        int iY = y() + p();
        int iW = w() + b();
        if (this.w == 1) {
            iO2 = RecyclerView.q.O(i2, rect.height() + iW, B0());
            iO = RecyclerView.q.O(i, (this.x * this.s) + iY, C0());
        } else {
            iO = RecyclerView.q.O(i, rect.width() + iY, C0());
            iO2 = RecyclerView.q.O(i2, (this.x * this.s) + iW, B0());
        }
        a2(iO, iO2);
    }

    public final void b3(RecyclerView.x xVar, int i) {
        while (k0() > 0) {
            View viewJ0 = j0(0);
            if (this.u.d(viewJ0) > i || this.u.p(viewJ0) > i) {
                return;
            }
            c cVar = (c) viewJ0.getLayoutParams();
            if (cVar.k) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].t();
                }
            } else if (cVar.j.a.size() == 1) {
                return;
            } else {
                cVar.j.t();
            }
            L1(viewJ0, xVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c1(RecyclerView.h hVar, RecyclerView.h hVar2) {
        this.E.b();
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
    }

    public final void c3() {
        if (this.v.k() == 1073741824) {
            return;
        }
        int iK0 = k0();
        float fMax = 0.0f;
        for (int i = 0; i < iK0; i++) {
            View viewJ0 = j0(i);
            float fE = this.v.e(viewJ0);
            if (fE >= fMax) {
                if (((c) viewJ0.getLayoutParams()).w()) {
                    fE = (fE * 1.0f) / this.s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i2 = this.x;
        int iRound = Math.round(fMax * this.s);
        if (this.v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.v.n());
        }
        o3(iRound);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < iK0; i3++) {
            View viewJ02 = j0(i3);
            c cVar = (c) viewJ02.getLayoutParams();
            if (!cVar.k) {
                if (S2() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = cVar.j.e;
                    viewJ02.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = cVar.j.e;
                    int i7 = this.x * i6;
                    int i8 = i6 * i2;
                    if (this.w == 1) {
                        viewJ02.offsetLeftAndRight(i7 - i8);
                    } else {
                        viewJ02.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r e0() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public int e3(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (k0() == 0 || i == 0) {
            return 0;
        }
        X2(i, c0Var);
        int iA2 = A2(xVar, this.y, c0Var);
        if (this.y.b >= iA2) {
            i = i < 0 ? -iA2 : iA2;
        }
        this.u.r(-i);
        this.G = this.A;
        j jVar = this.y;
        jVar.b = 0;
        Z2(xVar, jVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0.b
    public PointF f(int i) {
        int iQ2 = q2(i);
        PointF pointF = new PointF();
        if (iQ2 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = iQ2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = iQ2;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r f0(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public final void f3(int i) {
        j jVar = this.y;
        jVar.e = i;
        jVar.d = this.A != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r g0(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void g1(RecyclerView recyclerView, RecyclerView.x xVar) {
        super.g1(recyclerView, xVar);
        N1(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
        recyclerView.requestLayout();
    }

    public void g3(int i) {
        if (i != 0 && i != 1) {
            jl.a("invalid orientation.");
            return;
        }
        H(null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        m mVar = this.u;
        this.u = this.v;
        this.v = mVar;
        S1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public View h1(View view, int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        View viewC0;
        View viewM;
        if (k0() == 0 || (viewC0 = c0(view)) == null) {
            return null;
        }
        d3();
        int iW2 = w2(i);
        if (iW2 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewC0.getLayoutParams();
        boolean z = cVar.k;
        f fVar = cVar.j;
        int iJ2 = iW2 == 1 ? J2() : I2();
        n3(iJ2, c0Var);
        f3(iW2);
        j jVar = this.y;
        jVar.c = jVar.d + iJ2;
        jVar.b = (int) (this.u.n() * 0.33333334f);
        j jVar2 = this.y;
        jVar2.h = true;
        jVar2.a = false;
        A2(xVar, jVar2, c0Var);
        this.G = this.A;
        if (!z && (viewM = fVar.m(iJ2, iW2)) != null && viewM != viewC0) {
            return viewM;
        }
        if (W2(iW2)) {
            for (int i2 = this.s - 1; i2 >= 0; i2--) {
                View viewM2 = this.t[i2].m(iJ2, iW2);
                if (viewM2 != null && viewM2 != viewC0) {
                    return viewM2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.s; i3++) {
                View viewM3 = this.t[i3].m(iJ2, iW2);
                if (viewM3 != null && viewM3 != viewC0) {
                    return viewM3;
                }
            }
        }
        boolean z2 = (this.z ^ true) == (iW2 == -1);
        if (!z) {
            View viewD0 = d0(z2 ? fVar.f() : fVar.g());
            if (viewD0 != null && viewD0 != viewC0) {
                return viewD0;
            }
        }
        if (W2(iW2)) {
            for (int i4 = this.s - 1; i4 >= 0; i4--) {
                if (i4 != fVar.e) {
                    f[] fVarArr = this.t;
                    View viewD02 = d0(z2 ? fVarArr[i4].f() : fVarArr[i4].g());
                    if (viewD02 != null && viewD02 != viewC0) {
                        return viewD02;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.s; i5++) {
                f[] fVarArr2 = this.t;
                View viewD03 = d0(z2 ? fVarArr2[i5].f() : fVarArr2[i5].g());
                if (viewD03 != null && viewD03 != viewC0) {
                    return viewD03;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void h2(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i) {
        k kVar = new k(recyclerView.getContext());
        kVar.p(i);
        i2(kVar);
    }

    public void h3(boolean z) {
        H(null);
        e eVar = this.I;
        if (eVar != null && eVar.m != z) {
            eVar.m = z;
        }
        this.z = z;
        S1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void i1(AccessibilityEvent accessibilityEvent) {
        super.i1(accessibilityEvent);
        if (k0() > 0) {
            View viewD2 = D2(false);
            View viewC2 = C2(false);
            if (viewD2 == null || viewC2 == null) {
                return;
            }
            int iD0 = D0(viewD2);
            int iD02 = D0(viewC2);
            if (iD0 < iD02) {
                accessibilityEvent.setFromIndex(iD0);
                accessibilityEvent.setToIndex(iD02);
            } else {
                accessibilityEvent.setFromIndex(iD02);
                accessibilityEvent.setToIndex(iD0);
            }
        }
    }

    public void i3(int i) {
        H(null);
        if (i != this.s) {
            R2();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new f(i2);
            }
            S1();
        }
    }

    public final void j3(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].a.isEmpty()) {
                p3(this.t[i3], i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean k2() {
        return this.I == null;
    }

    public final boolean k3(RecyclerView.c0 c0Var, b bVar) {
        bVar.a = this.G ? F2(c0Var.b()) : B2(c0Var.b());
        bVar.b = Integer.MIN_VALUE;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void l1(RecyclerView.x xVar, RecyclerView.c0 c0Var, g2 g2Var) {
        super.l1(xVar, c0Var, g2Var);
        g2Var.l0("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    public final void l2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    public boolean l3(RecyclerView.c0 c0Var, b bVar) {
        int i;
        if (!c0Var.e() && (i = this.C) != -1) {
            if (i >= 0 && i < c0Var.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.f == -1 || eVar.h < 1) {
                    View viewD0 = d0(this.C);
                    if (viewD0 != null) {
                        bVar.a = this.A ? J2() : I2();
                        if (this.D != Integer.MIN_VALUE) {
                            boolean z = bVar.c;
                            m mVar = this.u;
                            if (z) {
                                bVar.b = (mVar.i() - this.D) - this.u.d(viewD0);
                            } else {
                                bVar.b = (mVar.m() + this.D) - this.u.g(viewD0);
                            }
                            return true;
                        }
                        if (this.u.e(viewD0) > this.u.n()) {
                            boolean z2 = bVar.c;
                            m mVar2 = this.u;
                            bVar.b = z2 ? mVar2.i() : mVar2.m();
                            return true;
                        }
                        int iG = this.u.g(viewD0) - this.u.m();
                        if (iG < 0) {
                            bVar.b = -iG;
                            return true;
                        }
                        int i2 = this.u.i() - this.u.d(viewD0);
                        if (i2 < 0) {
                            bVar.b = i2;
                            return true;
                        }
                        bVar.b = Integer.MIN_VALUE;
                    } else {
                        int i3 = this.C;
                        bVar.a = i3;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.c = q2(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i4);
                        }
                        bVar.d = true;
                    }
                } else {
                    bVar.b = Integer.MIN_VALUE;
                    bVar.a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void m2(b bVar) {
        e eVar = this.I;
        int i = eVar.h;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].e();
                    e eVar2 = this.I;
                    int i3 = eVar2.i[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        boolean z = eVar2.n;
                        m mVar = this.u;
                        i3 += z ? mVar.i() : mVar.m();
                    }
                    this.t[i2].v(i3);
                }
            } else {
                eVar.d();
                e eVar3 = this.I;
                eVar3.f = eVar3.g;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.o;
        h3(eVar4.m);
        d3();
        e eVar5 = this.I;
        int i4 = eVar5.f;
        if (i4 != -1) {
            this.C = i4;
            bVar.c = eVar5.n;
        } else {
            bVar.c = this.A;
        }
        if (eVar5.j > 1) {
            d dVar = this.E;
            dVar.a = eVar5.k;
            dVar.b = eVar5.l;
        }
    }

    public void m3(RecyclerView.c0 c0Var, b bVar) {
        if (l3(c0Var, bVar) || k3(c0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void n1(RecyclerView.x xVar, RecyclerView.c0 c0Var, View view, g2 g2Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.m1(view, g2Var);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.w == 0) {
            g2Var.o0(g2.f.a(cVar.v(), cVar.k ? this.s : 1, -1, -1, false, false));
        } else {
            g2Var.o0(g2.f.a(-1, -1, cVar.v(), cVar.k ? this.s : 1, false, false));
        }
    }

    public boolean n2() {
        int iL = this.t[0].l(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    public final void n3(int i, RecyclerView.c0 c0Var) {
        int iN;
        int iN2;
        int iC;
        j jVar = this.y;
        boolean z = false;
        jVar.b = 0;
        jVar.c = i;
        if (!V0() || (iC = c0Var.c()) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            boolean z2 = this.A;
            boolean z3 = iC < i;
            m mVar = this.u;
            if (z2 == z3) {
                iN = mVar.n();
                iN2 = 0;
            } else {
                iN2 = mVar.n();
                iN = 0;
            }
        }
        boolean zN0 = n0();
        j jVar2 = this.y;
        if (zN0) {
            jVar2.f = this.u.m() - iN2;
            this.y.g = this.u.i() + iN;
        } else {
            jVar2.g = this.u.h() + iN;
            this.y.f = -iN2;
        }
        j jVar3 = this.y;
        jVar3.h = false;
        jVar3.a = true;
        if (this.u.k() == 0 && this.u.h() == 0) {
            z = true;
        }
        jVar3.i = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int o0(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (this.w == 1) {
            return Math.min(this.s, c0Var.b());
        }
        return -1;
    }

    public boolean o2() {
        int iP = this.t[0].p(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    public void o3(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void p1(RecyclerView recyclerView, int i, int i2) {
        P2(i, i2, 1);
    }

    public final void p2(View view, c cVar, j jVar) {
        if (jVar.e == 1) {
            if (cVar.k) {
                l2(view);
                return;
            } else {
                cVar.j.a(view);
                return;
            }
        }
        if (cVar.k) {
            Y2(view);
        } else {
            cVar.j.u(view);
        }
    }

    public final void p3(f fVar, int i, int i2) {
        int iJ = fVar.j();
        if (i == -1) {
            if (fVar.o() + iJ <= i2) {
                this.B.set(fVar.e, false);
            }
        } else if (fVar.k() - iJ >= i2) {
            this.B.set(fVar.e, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void q1(RecyclerView recyclerView) {
        this.E.b();
        S1();
    }

    public final int q2(int i) {
        if (k0() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < I2()) != this.A ? -1 : 1;
    }

    public final int q3(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void r1(RecyclerView recyclerView, int i, int i2, int i3) {
        P2(i, i2, 8);
    }

    public boolean r2() {
        int iI2;
        int iJ2;
        if (k0() == 0 || this.F == 0 || !N0()) {
            return false;
        }
        if (this.A) {
            iI2 = J2();
            iJ2 = I2();
        } else {
            iI2 = I2();
            iJ2 = J2();
        }
        if (iI2 == 0 && Q2() != null) {
            this.E.b();
            T1();
            S1();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i = this.A ? -1 : 1;
        int i2 = iJ2 + 1;
        d.a aVarE = this.E.e(iI2, i2, i, true);
        if (aVarE == null) {
            this.M = false;
            this.E.d(i2);
            return false;
        }
        d.a aVarE2 = this.E.e(iI2, aVarE.f, i * (-1), true);
        d dVar = this.E;
        if (aVarE2 == null) {
            dVar.d(aVarE.f);
        } else {
            dVar.d(aVarE2.f + 1);
        }
        T1();
        S1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void s1(RecyclerView recyclerView, int i, int i2) {
        P2(i, i2, 2);
    }

    public final boolean s2(f fVar) {
        boolean z;
        if (!this.A) {
            if (fVar.o() > this.u.m()) {
                z = fVar.n((View) fVar.a.get(0)).k;
                return !z;
            }
            return false;
        }
        if (fVar.k() < this.u.i()) {
            z = fVar.n((View) fVar.a.get(r2.size() - 1)).k;
            return !z;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void u1(RecyclerView recyclerView, int i, int i2, Object obj) {
        P2(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void v1(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        V2(xVar, c0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void w1(RecyclerView.c0 c0Var) {
        super.w1(c0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public final d.a x2(int i) {
        d.a aVar = new d.a();
        aVar.h = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.h[i2] = i - this.t[i2].l(i);
        }
        return aVar;
    }

    public final d.a y2(int i) {
        d.a aVar = new d.a();
        aVar.h = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.h[i2] = this.t[i2].p(i) - i;
        }
        return aVar;
    }

    public final void z2() {
        this.u = m.b(this, this.w);
        this.v = m.b(this, 1 - this.w);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends RecyclerView.r {
        public f j;
        public boolean k;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int v() {
            f fVar = this.j;
            if (fVar == null) {
                return -1;
            }
            return fVar.e;
        }

        public boolean w() {
            return this.k;
        }

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public int[] a;
        public List b;

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            int i = 0;
            while (true) {
                List list = this.b;
                if (i >= size) {
                    list.add(aVar);
                    return;
                }
                a aVar2 = (a) list.get(i);
                if (aVar2.f == aVar.f) {
                    this.b.remove(i);
                }
                if (aVar2.f >= aVar.f) {
                    this.b.add(i, aVar);
                    return;
                }
                i++;
            }
        }

        public void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        public void c(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[o(i)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i) {
            List list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.b.get(size)).f >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return h(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) this.b.get(i4);
                int i5 = aVar.f;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.g == i3 || (z && aVar.i))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                if (aVar.f == i) {
                    return aVar;
                }
            }
            return null;
        }

        public int g(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        public int h(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int i2 = i(i);
            int[] iArr2 = this.a;
            if (i2 == -1) {
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.a.length;
            }
            int iMin = Math.min(i2 + 1, iArr2.length);
            Arrays.fill(this.a, i, iMin, -1);
            return iMin;
        }

        public final int i(int i) {
            if (this.b == null) {
                return -1;
            }
            a aVarF = f(i);
            if (aVarF != null) {
                this.b.remove(aVarF);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (((a) this.b.get(i2)).f >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = (a) this.b.get(i2);
            this.b.remove(i2);
            return aVar.f;
        }

        public void j(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            l(i, i2);
        }

        public void k(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m(i, i2);
        }

        public final void l(int i, int i2) {
            List list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                int i3 = aVar.f;
                if (i3 >= i) {
                    aVar.f = i3 + i2;
                }
            }
        }

        public final void m(int i, int i2) {
            List list = this.b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                int i4 = aVar.f;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.b.remove(size);
                    } else {
                        aVar.f = i4 - i2;
                    }
                }
            }
        }

        public void n(int i, f fVar) {
            c(i);
            this.a[i] = fVar.e;
        }

        public int o(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0038a();
            public int f;
            public int g;
            public int[] h;
            public boolean i;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public class C0038a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            public a(Parcel parcel) {
                this.f = parcel.readInt();
                this.g = parcel.readInt();
                this.i = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int c(int i) {
                int[] iArr = this.h;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f + ", mGapDir=" + this.g + ", mHasUnwantedGapAfter=" + this.i + ", mGapPerSpan=" + Arrays.toString(this.h) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f);
                parcel.writeInt(this.g);
                parcel.writeInt(this.i ? 1 : 0);
                int[] iArr = this.h;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.h);
                }
            }

            public a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public int f;
        public int g;
        public int h;
        public int[] i;
        public int j;
        public int[] k;
        public List l;
        public boolean m;
        public boolean n;
        public boolean o;

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
            int i = parcel.readInt();
            this.h = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.i = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.j = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.k = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.m = parcel.readInt() == 1;
            this.n = parcel.readInt() == 1;
            this.o = parcel.readInt() == 1;
            this.l = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public void c() {
            this.i = null;
            this.h = 0;
            this.f = -1;
            this.g = -1;
        }

        public void d() {
            this.i = null;
            this.h = 0;
            this.j = 0;
            this.k = null;
            this.l = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            if (this.h > 0) {
                parcel.writeIntArray(this.i);
            }
            parcel.writeInt(this.j);
            if (this.j > 0) {
                parcel.writeIntArray(this.k);
            }
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeList(this.l);
        }

        public e() {
        }

        public e(e eVar) {
            this.h = eVar.h;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.m = eVar.m;
            this.n = eVar.n;
            this.o = eVar.o;
            this.l = eVar.l;
        }
    }
}

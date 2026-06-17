package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.g2;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.q implements RecyclerView.b0.b {
    public int A;
    public int B;
    public boolean C;
    public d D;
    public final a E;
    public final b F;
    public int G;
    public int[] H;
    public int s;
    public c t;
    public m u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public m a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            boolean z = this.d;
            m mVar = this.a;
            this.c = z ? mVar.i() : mVar.m();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(View view, int i) {
            boolean z = this.d;
            m mVar = this.a;
            if (z) {
                this.c = mVar.d(view) + this.a.o();
            } else {
                this.c = mVar.g(view);
            }
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(View view, int i) {
            int iO = this.a.o();
            if (iO >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            boolean z = this.d;
            m mVar = this.a;
            if (z) {
                int i2 = (mVar.i() - iO) - this.a.d(view);
                this.c = this.a.i() - i2;
                if (i2 > 0) {
                    int iE = this.c - this.a.e(view);
                    int iM = this.a.m();
                    int iMin = iE - (iM + Math.min(this.a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.c += Math.min(i2, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = mVar.g(view);
            int iM2 = iG - this.a.m();
            this.c = iG;
            if (iM2 > 0) {
                int i3 = (this.a.i() - Math.min(0, (this.a.i() - iO) - this.a.d(view))) - (iG + this.a.e(view));
                if (i3 < 0) {
                    this.c -= Math.min(iM2, -i3);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d(View view, RecyclerView.c0 c0Var) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return !rVar.s() && rVar.c() >= 0 && rVar.c() < c0Var.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int k;
        public boolean m;
        public boolean a = true;
        public int h = 0;
        public int i = 0;
        public boolean j = false;
        public List l = null;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            b(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.r) viewF.getLayoutParams()).c();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c(RecyclerView.c0 c0Var) {
            int i = this.d;
            return i >= 0 && i < c0Var.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View d(RecyclerView.x xVar) {
            if (this.l != null) {
                return e();
            }
            View viewO = xVar.o(this.d);
            this.d += this.e;
            return viewO;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final View e() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = ((RecyclerView.g0) this.l.get(i)).f;
                RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
                if (!rVar.s() && this.d == rVar.c()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public View f(View view) {
            int iC;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((RecyclerView.g0) this.l.get(i2)).f;
                RecyclerView.r rVar = (RecyclerView.r) view3.getLayoutParams();
                if (view3 != view && !rVar.s() && (iC = (rVar.c() - this.d) * this.e) >= 0 && iC < i) {
                    if (iC == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = iC;
                }
            }
            return view2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.q.d dVarE0 = RecyclerView.q.E0(context, attributeSet, i, i2);
        Y2(dVarE0.a);
        Z2(dVarE0.c);
        a3(dVarE0.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private View H2() {
        return j0(this.x ? 0 : k0() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private View I2() {
        return j0(this.x ? k0() - 1 : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void A1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            this.D = dVar;
            if (this.A != -1) {
                dVar.d();
            }
            S1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View A2(int i, int i2) {
        int i3;
        int i4;
        s2();
        if (i2 <= i && i2 >= i) {
            return j0(i);
        }
        if (this.u.g(j0(i)) < this.u.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.s == 0 ? this.e.a(i, i2, i3, i4) : this.f.a(i, i2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public Parcelable B1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (k0() <= 0) {
            dVar.d();
            return dVar;
        }
        s2();
        boolean z = this.v ^ this.x;
        dVar.h = z;
        if (z) {
            View viewH2 = H2();
            dVar.g = this.u.i() - this.u.d(viewH2);
            dVar.f = D0(viewH2);
            return dVar;
        }
        View viewI2 = I2();
        dVar.f = D0(viewI2);
        dVar.g = this.u.g(viewI2) - this.u.m();
        return dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View B2(int i, int i2, boolean z, boolean z2) {
        s2();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.s == 0 ? this.e.a(i, i2, i3, i4) : this.f.a(i, i2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View C2() {
        return this.x ? u2() : y2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View D2() {
        return this.x ? y2() : u2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean E1(int i, Bundle bundle) {
        int iMin;
        if (super.E1(i, bundle)) {
            return true;
        }
        if (i == 16908343 && bundle != null) {
            if (this.s == 1) {
                int i2 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
                if (i2 < 0) {
                    return false;
                }
                RecyclerView recyclerView = this.b;
                iMin = Math.min(i2, G0(recyclerView.h, recyclerView.n0) - 1);
            } else {
                int i3 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
                if (i3 < 0) {
                    return false;
                }
                RecyclerView recyclerView2 = this.b;
                iMin = Math.min(i3, o0(recyclerView2.h, recyclerView2.n0) - 1);
            }
            if (iMin >= 0) {
                X2(iMin, 0);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View E2(RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z, boolean z2) {
        int i;
        int iK0;
        int i2;
        s2();
        int iK02 = k0();
        if (z2) {
            iK0 = k0() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iK02;
            iK0 = 0;
            i2 = 1;
        }
        int iB = c0Var.b();
        int iM = this.u.m();
        int i3 = this.u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iK0 != i) {
            View viewJ0 = j0(iK0);
            int iD0 = D0(viewJ0);
            int iG = this.u.g(viewJ0);
            int iD = this.u.d(viewJ0);
            if (iD0 >= 0 && iD0 < iB) {
                if (!((RecyclerView.r) viewJ0.getLayoutParams()).s()) {
                    boolean z3 = iD <= iM && iG < iM;
                    boolean z4 = iG >= i3 && iD > i3;
                    if (!z3 && !z4) {
                        return viewJ0;
                    }
                    if (z) {
                        if (z4) {
                            view2 = viewJ0;
                        } else if (view == null) {
                            view = viewJ0;
                        }
                    } else if (!z3) {
                        if (view == null) {
                        }
                    }
                } else if (view3 == null) {
                    view3 = viewJ0;
                }
            }
            iK0 += i2;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int F2(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -W2(-i3, xVar, c0Var);
        int i5 = i + i4;
        if (!z || (i2 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i2);
        return i2 + i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int G2(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z) {
        int iM;
        int iM2 = i - this.u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i2 = -W2(iM2, xVar, c0Var);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-iM);
        return i2 - iM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void H(String str) {
        if (this.D == null) {
            super.H(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int J2(RecyclerView.c0 c0Var) {
        if (c0Var.d()) {
            return this.u.n();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int K2() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean L() {
        return this.s == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L2() {
        return z0() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean M() {
        return this.s == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean M2() {
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N2(RecyclerView.x xVar, RecyclerView.c0 c0Var, c cVar, b bVar) {
        int i;
        int i2;
        int iY;
        int i3;
        LinearLayoutManager linearLayoutManager;
        int iF;
        View viewD = cVar.d(xVar);
        if (viewD == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.r rVar = (RecyclerView.r) viewD.getLayoutParams();
        List list = cVar.l;
        boolean z = this.x;
        if (list == null) {
            if (z == (cVar.f == -1)) {
                E(viewD);
            } else {
                F(viewD, 0);
            }
        } else {
            if (z == (cVar.f == -1)) {
                C(viewD);
            } else {
                D(viewD, 0);
            }
        }
        Y0(viewD, 0, 0);
        bVar.a = this.u.e(viewD);
        if (this.s == 1) {
            if (L2()) {
                iF = K0() - p();
                iY = iF - this.u.f(viewD);
            } else {
                iY = y();
                iF = this.u.f(viewD) + iY;
            }
            int i4 = cVar.f;
            int i5 = cVar.b;
            if (i4 != -1) {
                i2 = iF;
                i = bVar.a + i5;
                linearLayoutManager = this;
                i3 = i5;
                linearLayoutManager.X0(viewD, iY, i3, i2, i);
                if (!rVar.s() || rVar.d()) {
                    bVar.c = true;
                }
                bVar.d = viewD.hasFocusable();
            }
            i3 = i5 - bVar.a;
            i = i5;
            i2 = iF;
        } else {
            int iW = w();
            int iF2 = this.u.f(viewD) + iW;
            int i6 = cVar.f;
            int i7 = cVar.b;
            if (i6 == -1) {
                i2 = i7;
                i = iF2;
                iY = i7 - bVar.a;
            } else {
                i = iF2;
                i2 = bVar.a + i7;
                iY = i7;
            }
            i3 = iW;
        }
        linearLayoutManager = this;
        linearLayoutManager.X0(viewD, iY, i3, i2, i);
        if (!rVar.s()) {
            bVar.c = true;
        }
        bVar.d = viewD.hasFocusable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean O0() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O2(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i, int i2) {
        if (!c0Var.g() || k0() == 0 || c0Var.e() || !k2()) {
            return;
        }
        List listK = xVar.k();
        int size = listK.size();
        int iD0 = D0(j0(0));
        int iE = 0;
        int iE2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.g0 g0Var = (RecyclerView.g0) listK.get(i3);
            if (!g0Var.w()) {
                boolean z = g0Var.n() < iD0;
                boolean z2 = this.x;
                m mVar = this.u;
                if (z != z2) {
                    iE += mVar.e(g0Var.f);
                } else {
                    iE2 += mVar.e(g0Var.f);
                }
            }
        }
        this.t.l = listK;
        if (iE > 0) {
            h3(D0(I2()), i);
            c cVar = this.t;
            cVar.h = iE;
            cVar.c = 0;
            cVar.a();
            t2(xVar, this.t, c0Var, false);
        }
        if (iE2 > 0) {
            f3(D0(H2()), i2);
            c cVar2 = this.t;
            cVar2.h = iE2;
            cVar2.c = 0;
            cVar2.a();
            t2(xVar, this.t, c0Var, false);
        }
        this.t.l = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void P(int i, int i2, RecyclerView.c0 c0Var, RecyclerView.q.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (k0() == 0 || i == 0) {
            return;
        }
        s2();
        e3(i > 0 ? 1 : -1, Math.abs(i), true, c0Var);
        m2(c0Var, this.t, cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P2(RecyclerView.x xVar, RecyclerView.c0 c0Var, a aVar, int i) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void Q(int i, RecyclerView.q.c cVar) {
        boolean z;
        int i2;
        d dVar = this.D;
        if (dVar == null || !dVar.c()) {
            V2();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z = dVar2.h;
            i2 = dVar2.f;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q2(RecyclerView.x xVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            S2(xVar, i, i2);
        } else {
            T2(xVar, i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int R(RecyclerView.c0 c0Var) {
        return n2(c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R2(RecyclerView.x xVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                M1(i, xVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                M1(i3, xVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int S(RecyclerView.c0 c0Var) {
        return o2(c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean S0() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S2(RecyclerView.x xVar, int i, int i2) {
        int iK0 = k0();
        if (i < 0) {
            return;
        }
        int iH = (this.u.h() - i) + i2;
        if (this.x) {
            for (int i3 = 0; i3 < iK0; i3++) {
                View viewJ0 = j0(i3);
                if (this.u.g(viewJ0) < iH || this.u.q(viewJ0) < iH) {
                    R2(xVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iK0 - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewJ02 = j0(i5);
            if (this.u.g(viewJ02) < iH || this.u.q(viewJ02) < iH) {
                R2(xVar, i4, i5);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int T(RecyclerView.c0 c0Var) {
        return p2(c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T2(RecyclerView.x xVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iK0 = k0();
        if (!this.x) {
            for (int i4 = 0; i4 < iK0; i4++) {
                View viewJ0 = j0(i4);
                if (this.u.d(viewJ0) > i3 || this.u.p(viewJ0) > i3) {
                    R2(xVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iK0 - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewJ02 = j0(i6);
            if (this.u.d(viewJ02) > i3 || this.u.p(viewJ02) > i3) {
                R2(xVar, i5, i6);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int U(RecyclerView.c0 c0Var) {
        return n2(c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean U2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V(RecyclerView.c0 c0Var) {
        return o2(c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (this.s == 1) {
            return 0;
        }
        return W2(i, xVar, c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V2() {
        if (this.s == 1 || !L2()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int W(RecyclerView.c0 c0Var) {
        return p2(c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void W1(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.d();
        }
        S1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int W2(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (k0() == 0 || i == 0) {
            return 0;
        }
        s2();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        e3(i2, iAbs, true, c0Var);
        c cVar = this.t;
        int iT2 = cVar.g + t2(xVar, cVar, c0Var, false);
        if (iT2 < 0) {
            return 0;
        }
        if (iAbs > iT2) {
            i = i2 * iT2;
        }
        this.u.r(-i);
        this.t.k = i;
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int X1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (this.s == 0) {
            return 0;
        }
        return W2(i, xVar, c0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X2(int i, int i2) {
        this.A = i;
        this.B = i2;
        d dVar = this.D;
        if (dVar != null) {
            dVar.d();
        }
        S1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y2(int i) {
        if (i != 0 && i != 1) {
            defpackage.b.a("invalid orientation:", i);
            return;
        }
        H(null);
        if (i != this.s || this.u == null) {
            m mVarB = m.b(this, i);
            this.u = mVarB;
            this.E.a = mVarB;
            this.s = i;
            S1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z2(boolean z) {
        H(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        S1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a3(boolean z) {
        H(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        S1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean b3(RecyclerView.x xVar, RecyclerView.c0 c0Var, a aVar) {
        View viewE2;
        boolean z = false;
        if (k0() == 0) {
            return false;
        }
        View viewW0 = w0();
        if (viewW0 != null && aVar.d(viewW0, c0Var)) {
            aVar.c(viewW0, D0(viewW0));
            return true;
        }
        boolean z2 = this.v;
        boolean z3 = this.y;
        if (z2 != z3 || (viewE2 = E2(xVar, c0Var, aVar.d, z3)) == null) {
            return false;
        }
        aVar.b(viewE2, D0(viewE2));
        if (!c0Var.e() && k2()) {
            int iG = this.u.g(viewE2);
            int iD = this.u.d(viewE2);
            int iM = this.u.m();
            int i = this.u.i();
            boolean z4 = iD <= iM && iG < iM;
            if (iG >= i && iD > i) {
                z = true;
            }
            if (z4 || z) {
                if (aVar.d) {
                    iM = i;
                }
                aVar.c = iM;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean c3(RecyclerView.c0 c0Var, a aVar) {
        int i;
        if (!c0Var.e() && (i = this.A) != -1) {
            if (i >= 0 && i < c0Var.b()) {
                aVar.b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.c()) {
                    boolean z = this.D.h;
                    aVar.d = z;
                    m mVar = this.u;
                    if (z) {
                        aVar.c = mVar.i() - this.D.g;
                    } else {
                        aVar.c = mVar.m() + this.D.g;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.x;
                    aVar.d = z2;
                    m mVar2 = this.u;
                    if (z2) {
                        aVar.c = mVar2.i() - this.B;
                    } else {
                        aVar.c = mVar2.m() + this.B;
                    }
                    return true;
                }
                View viewD0 = d0(this.A);
                if (viewD0 == null) {
                    if (k0() > 0) {
                        aVar.d = (this.A < D0(j0(0))) == this.x;
                    }
                    aVar.a();
                } else {
                    if (this.u.e(viewD0) > this.u.n()) {
                        aVar.a();
                        return true;
                    }
                    int iG = this.u.g(viewD0) - this.u.m();
                    m mVar3 = this.u;
                    if (iG < 0) {
                        aVar.c = mVar3.m();
                        aVar.d = false;
                        return true;
                    }
                    if (mVar3.i() - this.u.d(viewD0) < 0) {
                        aVar.c = this.u.i();
                        aVar.d = true;
                        return true;
                    }
                    boolean z3 = aVar.d;
                    m mVar4 = this.u;
                    aVar.c = z3 ? mVar4.d(viewD0) + this.u.o() : mVar4.g(viewD0);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public View d0(int i) {
        int iK0 = k0();
        if (iK0 == 0) {
            return null;
        }
        int iD0 = i - D0(j0(0));
        if (iD0 >= 0 && iD0 < iK0) {
            View viewJ0 = j0(iD0);
            if (D0(viewJ0) == i) {
                return viewJ0;
            }
        }
        return super.d0(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d3(RecyclerView.x xVar, RecyclerView.c0 c0Var, a aVar) {
        if (c3(c0Var, aVar) || b3(xVar, c0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.y ? c0Var.b() - 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r e0() {
        return new RecyclerView.r(-2, -2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e3(int i, int i2, boolean z, RecyclerView.c0 c0Var) {
        int iM;
        this.t.m = U2();
        this.t.f = i;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        l2(c0Var, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z2 = i == 1;
        c cVar = this.t;
        int i3 = z2 ? iMax2 : iMax;
        cVar.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i = iMax;
        if (z2) {
            cVar.h = i3 + this.u.j();
            View viewH2 = H2();
            c cVar2 = this.t;
            cVar2.e = this.x ? -1 : 1;
            int iD0 = D0(viewH2);
            c cVar3 = this.t;
            cVar2.d = iD0 + cVar3.e;
            cVar3.b = this.u.d(viewH2);
            iM = this.u.d(viewH2) - this.u.i();
        } else {
            View viewI2 = I2();
            this.t.h += this.u.m();
            c cVar4 = this.t;
            cVar4.e = this.x ? 1 : -1;
            int iD02 = D0(viewI2);
            c cVar5 = this.t;
            cVar4.d = iD02 + cVar5.e;
            cVar5.b = this.u.g(viewI2);
            iM = (-this.u.g(viewI2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - iM;
        }
        cVar6.g = iM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.b0.b
    public PointF f(int i) {
        if (k0() == 0) {
            return null;
        }
        int i2 = (i < D0(j0(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean f2() {
        return (y0() == 1073741824 || L0() == 1073741824 || !M0()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f3(int i, int i2) {
        this.t.c = this.u.i() - i2;
        c cVar = this.t;
        cVar.e = this.x ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void g1(RecyclerView recyclerView, RecyclerView.x xVar) {
        super.g1(recyclerView, xVar);
        if (this.C) {
            J1(xVar);
            xVar.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g3(a aVar) {
        f3(aVar.b, aVar.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public View h1(View view, int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        int iQ2;
        V2();
        if (k0() == 0 || (iQ2 = q2(i)) == Integer.MIN_VALUE) {
            return null;
        }
        s2();
        e3(iQ2, (int) (this.u.n() * 0.33333334f), false, c0Var);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.a = false;
        t2(xVar, cVar, c0Var, true);
        View viewD2 = iQ2 == -1 ? D2() : C2();
        View viewI2 = iQ2 == -1 ? I2() : H2();
        if (!viewI2.hasFocusable()) {
            return viewD2;
        }
        if (viewD2 == null) {
            return null;
        }
        return viewI2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void h2(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i) {
        k kVar = new k(recyclerView.getContext());
        kVar.p(i);
        i2(kVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h3(int i, int i2) {
        this.t.c = i2 - this.u.m();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void i1(AccessibilityEvent accessibilityEvent) {
        super.i1(accessibilityEvent);
        if (k0() > 0) {
            accessibilityEvent.setFromIndex(x2());
            accessibilityEvent.setToIndex(z2());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i3(a aVar) {
        h3(aVar.b, aVar.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean k2() {
        return this.D == null && this.v == this.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void l1(RecyclerView.x xVar, RecyclerView.c0 c0Var, g2 g2Var) {
        super.l1(xVar, c0Var, g2Var);
        RecyclerView.h hVar = this.b.r;
        if (hVar == null || hVar.g() <= 0) {
            return;
        }
        g2Var.b(g2.a.B);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l2(RecyclerView.c0 c0Var, int[] iArr) {
        int i;
        int iJ2 = J2(c0Var);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = iJ2;
            iJ2 = 0;
        }
        iArr[0] = iJ2;
        iArr[1] = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m2(RecyclerView.c0 c0Var, c cVar, RecyclerView.q.c cVar2) {
        int i = cVar.d;
        if (i < 0 || i >= c0Var.b()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.g));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        s2();
        return p.a(c0Var, this.u, w2(!this.z, true), v2(!this.z, true), this, this.z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int o2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        s2();
        return p.b(c0Var, this.u, w2(!this.z, true), v2(!this.z, true), this, this.z, this.x);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int p2(RecyclerView.c0 c0Var) {
        if (k0() == 0) {
            return 0;
        }
        s2();
        return p.c(c0Var, this.u, w2(!this.z, true), v2(!this.z, true), this, this.z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int q2(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && L2()) ? -1 : 1 : (this.s != 1 && L2()) ? 1 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c r2() {
        return new c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s2() {
        if (this.t == null) {
            this.t = r2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int t2(RecyclerView.x xVar, c cVar, RecyclerView.c0 c0Var, boolean z) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            Q2(xVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(c0Var)) {
                break;
            }
            bVar.a();
            N2(xVar, c0Var, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || cVar.l != null || !c0Var.e()) {
                    int i4 = cVar.c;
                    int i5 = bVar.a;
                    cVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.a;
                    cVar.g = i7;
                    int i8 = cVar.c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    Q2(xVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View u2() {
        return A2(0, k0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void v1(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int iF2;
        int i5;
        View viewD0;
        int iG;
        int i6;
        int i7 = -1;
        if (!(this.D == null && this.A == -1) && c0Var.b() == 0) {
            J1(xVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.c()) {
            this.A = this.D.f;
        }
        s2();
        this.t.a = false;
        V2();
        View viewW0 = w0();
        a aVar = this.E;
        if (!aVar.e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.d = this.x ^ this.y;
            d3(xVar, c0Var, aVar2);
            this.E.e = true;
        } else if (viewW0 != null && (this.u.g(viewW0) >= this.u.i() || this.u.d(viewW0) <= this.u.m())) {
            this.E.c(viewW0, D0(viewW0));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        l2(c0Var, iArr);
        int iMax = Math.max(0, this.H[0]) + this.u.m();
        int iMax2 = Math.max(0, this.H[1]) + this.u.j();
        if (c0Var.e() && (i5 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewD0 = d0(i5)) != null) {
            boolean z = this.x;
            m mVar = this.u;
            if (z) {
                i6 = mVar.i() - this.u.d(viewD0);
                iG = this.B;
            } else {
                iG = mVar.g(viewD0) - this.u.m();
                i6 = this.B;
            }
            int i8 = i6 - iG;
            if (i8 > 0) {
                iMax += i8;
            } else {
                iMax2 -= i8;
            }
        }
        a aVar3 = this.E;
        boolean z2 = aVar3.d;
        boolean z3 = this.x;
        if (!z2 ? !z3 : z3) {
            i7 = 1;
        }
        P2(xVar, c0Var, aVar3, i7);
        X(xVar);
        this.t.m = U2();
        this.t.j = c0Var.e();
        this.t.i = 0;
        a aVar4 = this.E;
        if (aVar4.d) {
            i3(aVar4);
            c cVar2 = this.t;
            cVar2.h = iMax;
            t2(xVar, cVar2, c0Var, false);
            c cVar3 = this.t;
            i2 = cVar3.b;
            int i9 = cVar3.d;
            int i10 = cVar3.c;
            if (i10 > 0) {
                iMax2 += i10;
            }
            g3(this.E);
            c cVar4 = this.t;
            cVar4.h = iMax2;
            cVar4.d += cVar4.e;
            t2(xVar, cVar4, c0Var, false);
            c cVar5 = this.t;
            i = cVar5.b;
            int i11 = cVar5.c;
            if (i11 > 0) {
                h3(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                t2(xVar, cVar6, c0Var, false);
                i2 = this.t.b;
            }
        } else {
            g3(aVar4);
            c cVar7 = this.t;
            cVar7.h = iMax2;
            t2(xVar, cVar7, c0Var, false);
            c cVar8 = this.t;
            i = cVar8.b;
            int i12 = cVar8.d;
            int i13 = cVar8.c;
            if (i13 > 0) {
                iMax += i13;
            }
            i3(this.E);
            c cVar9 = this.t;
            cVar9.h = iMax;
            cVar9.d += cVar9.e;
            t2(xVar, cVar9, c0Var, false);
            c cVar10 = this.t;
            i2 = cVar10.b;
            int i14 = cVar10.c;
            if (i14 > 0) {
                f3(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                t2(xVar, cVar11, c0Var, false);
                i = this.t.b;
            }
        }
        if (k0() > 0) {
            if (this.x ^ this.y) {
                int iF22 = F2(i, xVar, c0Var, true);
                i3 = i2 + iF22;
                i4 = i + iF22;
                iF2 = G2(i3, xVar, c0Var, false);
            } else {
                int iG2 = G2(i2, xVar, c0Var, true);
                i3 = i2 + iG2;
                i4 = i + iG2;
                iF2 = F2(i4, xVar, c0Var, false);
            }
            i2 = i3 + iF2;
            i = i4 + iF2;
        }
        O2(xVar, c0Var, i2, i);
        if (c0Var.e()) {
            this.E.e();
        } else {
            this.u.s();
        }
        this.v = this.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View v2(boolean z, boolean z2) {
        return this.x ? B2(0, k0(), z, z2) : B2(k0() - 1, -1, z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void w1(RecyclerView.c0 c0Var) {
        super.w1(c0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View w2(boolean z, boolean z2) {
        return this.x ? B2(k0() - 1, -1, z, z2) : B2(0, k0(), z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int x2() {
        View viewB2 = B2(0, k0(), false, true);
        if (viewB2 == null) {
            return -1;
        }
        return D0(viewB2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View y2() {
        return A2(k0() - 1, -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int z2() {
        View viewB2 = B2(k0() - 1, -1, false, true);
        if (viewB2 == null) {
            return -1;
        }
        return D0(viewB2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public int f;
        public int g;
        public boolean h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt() == 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c() {
            return this.f >= 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            this.f = -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h ? 1 : 0);
        }

        public d() {
        }

        public d(d dVar) {
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        Y2(i);
        Z2(z);
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }
}

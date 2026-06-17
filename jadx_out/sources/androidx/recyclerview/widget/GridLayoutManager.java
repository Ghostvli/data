package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.fn;
import defpackage.g2;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final Set U = Collections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    public boolean I;
    public int J;
    public int[] K;
    public View[] L;
    public final SparseIntArray M;
    public final SparseIntArray N;
    public d O;
    public final Rect P;
    public boolean Q;
    public int R;
    public int S;
    public int T;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends d {
        @Override // androidx.recyclerview.widget.GridLayoutManager.d
        public int e(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.d
        public int f(int i) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class d {
        public final SparseIntArray a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();
        public boolean c = false;
        public boolean d = false;

        public static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int b(int i, int i2) {
            if (!this.d) {
                return d(i, i2);
            }
            int i3 = this.b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iD = d(i, i2);
            this.b.put(i, iD);
            return iD;
        }

        public int c(int i, int i2) {
            if (!this.c) {
                return e(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iE = e(i, i2);
            this.a.put(i, iE);
            return iE;
        }

        public int d(int i, int i2) {
            int i3;
            int i4;
            int iC;
            int iA;
            if (!this.d || (iA = a(this.b, i)) == -1) {
                i3 = 0;
                i4 = 0;
                iC = 0;
            } else {
                i3 = this.b.get(iA);
                i4 = iA + 1;
                iC = c(iA, i2) + f(iA);
                if (iC == i2) {
                    i3++;
                    iC = 0;
                }
            }
            int iF = f(i);
            while (i4 < i) {
                int iF2 = f(i4);
                iC += iF2;
                if (iC == i2) {
                    i3++;
                    iC = 0;
                } else if (iC > i2) {
                    i3++;
                    iC = iF2;
                }
                i4++;
            }
            return iC + iF > i2 ? i3 + 1 : i3;
        }

        public abstract int e(int i, int i2);

        public abstract int f(int i);

        public void g() {
            this.b.clear();
        }

        public void h() {
            this.a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new b();
        this.P = new Rect();
        this.R = -1;
        this.S = -1;
        this.T = -1;
        M3(RecyclerView.q.E0(context, attributeSet, i, i2).b);
    }

    public static int[] m3(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    public final Set A3(int i) {
        return D3(z3(i), i);
    }

    public final int B3(int i) {
        int i2 = this.s;
        RecyclerView recyclerView = this.b;
        return i2 == 1 ? F3(recyclerView.h, recyclerView.n0, i) : G3(recyclerView.h, recyclerView.n0, i);
    }

    public final Set C3(int i) {
        return D3(B3(i), i);
    }

    public final Set D3(int i, int i2) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.b;
        int iH3 = H3(recyclerView.h, recyclerView.n0, i2);
        for (int i3 = i; i3 < i + iH3; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public boolean E1(int i, Bundle bundle) {
        RecyclerView.g0 g0VarN0;
        int iX3;
        if (i != g2.a.V.b() || i == -1) {
            if (i != 16908343 || bundle == null) {
                return super.E1(i, bundle);
            }
            int i2 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
            int i3 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
            if (i2 != -1 && i3 != -1) {
                int iG = this.b.r.g();
                int i4 = 0;
                while (true) {
                    if (i4 >= iG) {
                        i4 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.b;
                    int iG3 = G3(recyclerView.h, recyclerView.n0, i4);
                    RecyclerView recyclerView2 = this.b;
                    int iF3 = F3(recyclerView2.h, recyclerView2.n0, i4);
                    if (this.s != 1) {
                        if (iG3 == i2 && iF3 == i3) {
                            break;
                        }
                        i4++;
                    } else {
                        if (iG3 == i3 && iF3 == i2) {
                            break;
                        }
                        i4++;
                    }
                }
                if (i4 > -1) {
                    X2(i4, 0);
                    return true;
                }
            }
            return false;
        }
        View viewS3 = s3();
        if (viewS3 == null || bundle == null) {
            return false;
        }
        int i5 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
        if (!U.contains(Integer.valueOf(i5)) || (g0VarN0 = this.b.n0(viewS3)) == null) {
            return false;
        }
        int iJ = g0VarN0.j();
        int iB3 = B3(iJ);
        int iZ3 = z3(iJ);
        if (iB3 >= 0 && iZ3 >= 0) {
            if (J3(iJ)) {
                this.S = iB3;
                this.T = iZ3;
            }
            int i6 = this.S;
            if (i6 == -1) {
                i6 = iB3;
            }
            int i7 = this.T;
            if (i7 != -1) {
                iZ3 = i7;
            }
            if (i5 == 17) {
                iX3 = x3(i6, iZ3, iJ);
            } else if (i5 == 33) {
                iX3 = v3(i6, iZ3, iJ);
            } else if (i5 == 66) {
                iX3 = y3(i6, iZ3, iJ);
            } else {
                if (i5 != 130) {
                    return false;
                }
                iX3 = w3(i6, iZ3, iJ);
            }
            if (iX3 == -1 && this.s == 0) {
                if (i5 == 17) {
                    iX3 = u3(iB3);
                } else if (i5 == 66) {
                    iX3 = t3(iB3);
                }
            }
            if (iX3 != -1) {
                W1(iX3);
                this.R = iX3;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View E2(RecyclerView.x xVar, RecyclerView.c0 c0Var, boolean z, boolean z2) {
        int i;
        int iK0;
        int iK02 = k0();
        int i2 = 1;
        if (z2) {
            iK0 = k0() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iK02;
            iK0 = 0;
        }
        int iB = c0Var.b();
        s2();
        int iM = this.u.m();
        int i3 = this.u.i();
        View view = null;
        View view2 = null;
        while (iK0 != i) {
            View viewJ0 = j0(iK0);
            int iD0 = D0(viewJ0);
            if (iD0 >= 0 && iD0 < iB && G3(xVar, c0Var, iD0) == 0) {
                if (((RecyclerView.r) viewJ0.getLayoutParams()).s()) {
                    if (view2 == null) {
                        view2 = viewJ0;
                    }
                } else {
                    if (this.u.g(viewJ0) < i3 && this.u.d(viewJ0) >= iM) {
                        return viewJ0;
                    }
                    if (view == null) {
                        view = viewJ0;
                    }
                }
            }
            iK0 += i2;
        }
        return view != null ? view : view2;
    }

    public int E3(int i, int i2) {
        if (this.s != 1 || !L2()) {
            int[] iArr = this.K;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.K;
        int i3 = this.J;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int F3(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i) {
        if (!c0Var.e()) {
            return this.O.b(i, this.J);
        }
        int iF = xVar.f(i);
        if (iF != -1) {
            return this.O.b(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int G0(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (this.s == 0) {
            return Math.min(this.J, v());
        }
        if (c0Var.b() < 1) {
            return 0;
        }
        return F3(xVar, c0Var, c0Var.b() - 1) + 1;
    }

    public final int G3(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i) {
        if (!c0Var.e()) {
            return this.O.c(i, this.J);
        }
        int i2 = this.N.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iF = xVar.f(i);
        if (iF != -1) {
            return this.O.c(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int H3(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i) {
        if (!c0Var.e()) {
            return this.O.f(i);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iF = xVar.f(i);
        if (iF != -1) {
            return this.O.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void I3(float f, int i) {
        l3(Math.max(Math.round(f * this.J), i));
    }

    public final boolean J3(int i) {
        return (C3(i).contains(Integer.valueOf(this.S)) && A3(i).contains(Integer.valueOf(this.T))) ? false : true;
    }

    public final void K3(View view, int i, boolean z) {
        int iL0;
        int iL02;
        c cVar = (c) view.getLayoutParams();
        Rect rect = cVar.g;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) cVar).topMargin + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) cVar).leftMargin + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
        int iE3 = E3(cVar.j, cVar.k);
        if (this.s == 1) {
            iL02 = RecyclerView.q.l0(iE3, i, i3, ((ViewGroup.MarginLayoutParams) cVar).width, false);
            iL0 = RecyclerView.q.l0(this.u.n(), y0(), i2, ((ViewGroup.MarginLayoutParams) cVar).height, true);
        } else {
            int iL03 = RecyclerView.q.l0(iE3, i, i2, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            int iL04 = RecyclerView.q.l0(this.u.n(), L0(), i3, ((ViewGroup.MarginLayoutParams) cVar).width, true);
            iL0 = iL03;
            iL02 = iL04;
        }
        L3(view, iL02, iL0, z);
    }

    public final void L3(View view, int i, int i2, boolean z) {
        RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
        if (z ? g2(view, i, i2, rVar) : e2(view, i, i2, rVar)) {
            view.measure(i, i2);
        }
    }

    public void M3(int i) {
        if (i == this.J) {
            return;
        }
        this.I = true;
        if (i < 1) {
            defpackage.b.a("Span count should be at least 1. Provided ", i);
            return;
        }
        this.J = i;
        this.O.h();
        S1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean N(RecyclerView.r rVar) {
        return rVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void N2(RecyclerView.x xVar, RecyclerView.c0 c0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int iY;
        int i2;
        int iW;
        int iF;
        int iL0;
        int iL02;
        View viewD;
        GridLayoutManager gridLayoutManager = this;
        int iL = gridLayoutManager.u.l();
        boolean z = iL != 1073741824;
        int i3 = gridLayoutManager.k0() > 0 ? gridLayoutManager.K[gridLayoutManager.J] : 0;
        if (z) {
            gridLayoutManager.N3();
        }
        boolean z2 = cVar.e == 1;
        int iG3 = gridLayoutManager.J;
        if (!z2) {
            iG3 = gridLayoutManager.G3(xVar, c0Var, cVar.d) + gridLayoutManager.H3(xVar, c0Var, cVar.d);
        }
        int i4 = 0;
        while (i4 < gridLayoutManager.J && cVar.c(c0Var) && iG3 > 0) {
            int i5 = cVar.d;
            int iH3 = gridLayoutManager.H3(xVar, c0Var, i5);
            if (iH3 > gridLayoutManager.J) {
                throw new IllegalArgumentException("Item at position " + i5 + " requires " + iH3 + " spans but GridLayoutManager has only " + gridLayoutManager.J + " spans.");
            }
            iG3 -= iH3;
            if (iG3 < 0 || (viewD = cVar.d(xVar)) == null) {
                break;
            }
            gridLayoutManager.L[i4] = viewD;
            i4++;
        }
        if (i4 == 0) {
            bVar.b = true;
            return;
        }
        gridLayoutManager.j3(xVar, c0Var, i4, z2);
        float f = 0.0f;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            View view = gridLayoutManager.L[i7];
            if (cVar.l == null) {
                if (z2) {
                    gridLayoutManager.E(view);
                } else {
                    gridLayoutManager.F(view, 0);
                }
            } else if (z2) {
                gridLayoutManager.C(view);
            } else {
                gridLayoutManager.D(view, 0);
            }
            gridLayoutManager.K(view, gridLayoutManager.P);
            gridLayoutManager.K3(view, iL, false);
            int iE = gridLayoutManager.u.e(view);
            if (iE > i6) {
                i6 = iE;
            }
            float f2 = (gridLayoutManager.u.f(view) * 1.0f) / ((c) view.getLayoutParams()).k;
            if (f2 > f) {
                f = f2;
            }
        }
        if (z) {
            gridLayoutManager.I3(f, i3);
            i6 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                View view2 = gridLayoutManager.L[i8];
                gridLayoutManager.K3(view2, Buffer.MAX_SIZE, true);
                int iE2 = gridLayoutManager.u.e(view2);
                if (iE2 > i6) {
                    i6 = iE2;
                }
            }
        }
        for (int i9 = 0; i9 < i4; i9++) {
            View view3 = gridLayoutManager.L[i9];
            if (gridLayoutManager.u.e(view3) != i6) {
                c cVar2 = (c) view3.getLayoutParams();
                Rect rect = cVar2.g;
                int i10 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) cVar2).topMargin + ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin;
                int i11 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                int iE3 = gridLayoutManager.E3(cVar2.j, cVar2.k);
                if (gridLayoutManager.s == 1) {
                    iL02 = RecyclerView.q.l0(iE3, Buffer.MAX_SIZE, i11, ((ViewGroup.MarginLayoutParams) cVar2).width, false);
                    iL0 = View.MeasureSpec.makeMeasureSpec(i6 - i10, Buffer.MAX_SIZE);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6 - i11, Buffer.MAX_SIZE);
                    iL0 = RecyclerView.q.l0(iE3, Buffer.MAX_SIZE, i10, ((ViewGroup.MarginLayoutParams) cVar2).height, false);
                    iL02 = iMakeMeasureSpec;
                }
                gridLayoutManager.L3(view3, iL02, iL0, true);
            }
        }
        bVar.a = i6;
        int i12 = gridLayoutManager.s;
        int i13 = cVar.f;
        if (i12 == 1) {
            i2 = cVar.b;
            if (i13 == -1) {
                iW = i2 - i6;
                iY = 0;
            } else {
                iW = i2;
                iY = 0;
                i2 = i6 + i2;
            }
            i = iY;
        } else {
            int i14 = cVar.b;
            if (i13 == -1) {
                iY = i14 - i6;
                i = i14;
            } else {
                i = i6 + i14;
                iY = i14;
            }
            i2 = 0;
            iW = 0;
        }
        int iF2 = i;
        int i15 = 0;
        while (true) {
            View[] viewArr = gridLayoutManager.L;
            if (i15 >= i4) {
                Arrays.fill(viewArr, (Object) null);
                return;
            }
            int i16 = i2;
            View view4 = viewArr[i15];
            c cVar3 = (c) view4.getLayoutParams();
            if (gridLayoutManager.s == 1) {
                if (gridLayoutManager.L2()) {
                    iF2 = gridLayoutManager.K[gridLayoutManager.J - cVar3.j] + gridLayoutManager.y();
                    iY = iF2 - gridLayoutManager.u.f(view4);
                } else {
                    iY = gridLayoutManager.y() + gridLayoutManager.K[cVar3.j];
                    iF2 = gridLayoutManager.u.f(view4) + iY;
                }
                iF = i16;
            } else {
                iW = gridLayoutManager.w() + gridLayoutManager.K[cVar3.j];
                iF = gridLayoutManager.u.f(view4) + iW;
            }
            gridLayoutManager.X0(view4, iY, iW, iF2, iF);
            i2 = iF;
            if (cVar3.s() || cVar3.d()) {
                bVar.c = true;
            }
            bVar.d = view4.hasFocusable() | bVar.d;
            i15++;
            gridLayoutManager = this;
        }
    }

    public final void N3() {
        int iX0;
        int iW;
        if (K2() == 1) {
            iX0 = K0() - p();
            iW = y();
        } else {
            iX0 = x0() - b();
            iW = w();
        }
        l3(iX0 - iW);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void P2(RecyclerView.x xVar, RecyclerView.c0 c0Var, LinearLayoutManager.a aVar, int i) {
        super.P2(xVar, c0Var, aVar, i);
        N3();
        if (c0Var.b() > 0 && !c0Var.e()) {
            q3(xVar, c0Var, aVar, i);
        }
        r3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public int S(RecyclerView.c0 c0Var) {
        return this.Q ? o3(c0Var) : super.S(c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public int T(RecyclerView.c0 c0Var) {
        return this.Q ? p3(c0Var) : super.T(c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public int V(RecyclerView.c0 c0Var) {
        return this.Q ? o3(c0Var) : super.V(c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public int V1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        N3();
        r3();
        return super.V1(i, xVar, c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public int W(RecyclerView.c0 c0Var) {
        return this.Q ? p3(c0Var) : super.W(c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public int X1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        N3();
        r3();
        return super.X1(i, xVar, c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a3(boolean z) {
        if (z) {
            fn.a("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.a3(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b2(Rect rect, int i, int i2) {
        int iO;
        int iO2;
        if (this.K == null) {
            super.b2(rect, i, i2);
        }
        int iY = y() + p();
        int iW = w() + b();
        if (this.s == 1) {
            iO2 = RecyclerView.q.O(i2, rect.height() + iW, B0());
            int[] iArr = this.K;
            iO = RecyclerView.q.O(i, iArr[iArr.length - 1] + iY, C0());
        } else {
            iO = RecyclerView.q.O(i, rect.width() + iY, C0());
            int[] iArr2 = this.K;
            iO2 = RecyclerView.q.O(i2, iArr2[iArr2.length - 1] + iW, B0());
        }
        a2(iO, iO2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r e0() {
        return this.s == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r f0(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r g0(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0110  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View h1(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.x r26, androidx.recyclerview.widget.RecyclerView.c0 r27) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.h1(android.view.View, int, androidx.recyclerview.widget.RecyclerView$x, androidx.recyclerview.widget.RecyclerView$c0):android.view.View");
    }

    public final void j3(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (z) {
            i4 = 1;
            i3 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View view = this.L[i2];
            c cVar = (c) view.getLayoutParams();
            int iH3 = H3(xVar, c0Var, D0(view));
            cVar.k = iH3;
            cVar.j = i5;
            i5 += iH3;
            i2 += i4;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public boolean k2() {
        return this.D == null && !this.I;
    }

    public final void k3() {
        int iK0 = k0();
        for (int i = 0; i < iK0; i++) {
            c cVar = (c) j0(i).getLayoutParams();
            int iC = cVar.c();
            this.M.put(iC, cVar.w());
            this.N.put(iC, cVar.v());
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public void l1(RecyclerView.x xVar, RecyclerView.c0 c0Var, g2 g2Var) {
        super.l1(xVar, c0Var, g2Var);
        g2Var.l0(GridView.class.getName());
        RecyclerView.h hVar = this.b.r;
        if (hVar == null || hVar.g() <= 1) {
            return;
        }
        g2Var.b(g2.a.V);
    }

    public final void l3(int i) {
        this.K = m3(this.K, this.J, i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void m2(RecyclerView.c0 c0Var, LinearLayoutManager.c cVar, RecyclerView.q.c cVar2) {
        int iF = this.J;
        for (int i = 0; i < this.J && cVar.c(c0Var) && iF > 0; i++) {
            int i2 = cVar.d;
            cVar2.a(i2, Math.max(0, cVar.g));
            iF -= this.O.f(i2);
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void n1(RecyclerView.x xVar, RecyclerView.c0 c0Var, View view, g2 g2Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.m1(view, g2Var);
            return;
        }
        c cVar = (c) layoutParams;
        int iF3 = F3(xVar, c0Var, cVar.c());
        if (this.s == 0) {
            g2Var.o0(g2.f.a(cVar.v(), cVar.w(), iF3, 1, false, false));
        } else {
            g2Var.o0(g2.f.a(iF3, 1, cVar.v(), cVar.w(), false, false));
        }
    }

    public final void n3() {
        this.M.clear();
        this.N.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int o0(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (this.s == 1) {
            return Math.min(this.J, v());
        }
        if (c0Var.b() < 1) {
            return 0;
        }
        return F3(xVar, c0Var, c0Var.b() - 1) + 1;
    }

    public final int o3(RecyclerView.c0 c0Var) {
        if (k0() != 0 && c0Var.b() != 0) {
            s2();
            boolean zM2 = M2();
            View viewW2 = w2(!zM2, true);
            View viewV2 = v2(!zM2, true);
            if (viewW2 != null && viewV2 != null) {
                int iB = this.O.b(D0(viewW2), this.J);
                int iB2 = this.O.b(D0(viewV2), this.J);
                int iMax = this.x ? Math.max(0, ((this.O.b(c0Var.b() - 1, this.J) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zM2) {
                    return Math.round((iMax * (Math.abs(this.u.d(viewV2) - this.u.g(viewW2)) / ((this.O.b(D0(viewV2), this.J) - this.O.b(D0(viewW2), this.J)) + 1))) + (this.u.m() - this.u.g(viewW2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void p1(RecyclerView recyclerView, int i, int i2) {
        this.O.h();
        this.O.g();
    }

    public final int p3(RecyclerView.c0 c0Var) {
        if (k0() != 0 && c0Var.b() != 0) {
            s2();
            View viewW2 = w2(!M2(), true);
            View viewV2 = v2(!M2(), true);
            if (viewW2 != null && viewV2 != null) {
                if (!M2()) {
                    return this.O.b(c0Var.b() - 1, this.J) + 1;
                }
                int iD = this.u.d(viewV2) - this.u.g(viewW2);
                int iB = this.O.b(D0(viewW2), this.J);
                return (int) ((iD / ((this.O.b(D0(viewV2), this.J) - iB) + 1)) * (this.O.b(c0Var.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void q1(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    public final void q3(RecyclerView.x xVar, RecyclerView.c0 c0Var, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iG3 = G3(xVar, c0Var, aVar.b);
        if (z) {
            while (iG3 > 0) {
                int i2 = aVar.b;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                aVar.b = i3;
                iG3 = G3(xVar, c0Var, i3);
            }
            return;
        }
        int iB = c0Var.b() - 1;
        int i4 = aVar.b;
        while (i4 < iB) {
            int i5 = i4 + 1;
            int iG32 = G3(xVar, c0Var, i5);
            if (iG32 <= iG3) {
                break;
            }
            i4 = i5;
            iG3 = iG32;
        }
        aVar.b = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void r1(RecyclerView recyclerView, int i, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    public final void r3() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void s1(RecyclerView recyclerView, int i, int i2) {
        this.O.h();
        this.O.g();
    }

    public final View s3() {
        for (int i = 0; i < k0(); i++) {
            View viewJ0 = j0(i);
            Objects.requireNonNull(viewJ0);
            if (a.a(viewJ0)) {
                return j0(i);
            }
        }
        return null;
    }

    public int t3(int i) {
        if (i < 0 || this.s == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap();
        for (int i2 = 0; i2 < v(); i2++) {
            for (Integer num : C3(i2)) {
                if (num.intValue() < 0) {
                    return -1;
                }
                if (!treeMap.containsKey(num)) {
                    treeMap.put(num, Integer.valueOf(i2));
                }
            }
        }
        for (Integer num2 : treeMap.keySet()) {
            int iIntValue = num2.intValue();
            if (iIntValue > i) {
                int iIntValue2 = ((Integer) treeMap.get(num2)).intValue();
                this.S = iIntValue;
                this.T = 0;
                return iIntValue2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void u1(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.O.h();
        this.O.g();
    }

    public int u3(int i) {
        if (i < 0 || this.s == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        for (int i2 = 0; i2 < v(); i2++) {
            for (Integer num : C3(i2)) {
                if (num.intValue() < 0) {
                    return -1;
                }
                treeMap.put(num, Integer.valueOf(i2));
            }
        }
        for (Integer num2 : treeMap.keySet()) {
            int iIntValue = num2.intValue();
            if (iIntValue < i) {
                int iIntValue2 = ((Integer) treeMap.get(num2)).intValue();
                this.S = iIntValue;
                this.T = z3(iIntValue2);
                return iIntValue2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public void v1(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (c0Var.e()) {
            k3();
        }
        super.v1(xVar, c0Var);
        n3();
    }

    public final int v3(int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            int iB3 = B3(i4);
            int iZ3 = z3(i4);
            if (iB3 < 0 || iZ3 < 0) {
                break;
            }
            if (this.s == 1) {
                if (iB3 < i && A3(i4).contains(Integer.valueOf(i2))) {
                    this.S = iB3;
                    return i4;
                }
            } else if (iB3 < i && iZ3 == i2) {
                this.S = ((Integer) Collections.max(C3(i4))).intValue();
                return i4;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
    public void w1(RecyclerView.c0 c0Var) {
        View viewD0;
        super.w1(c0Var);
        this.I = false;
        int i = this.R;
        if (i == -1 || (viewD0 = d0(i)) == null) {
            return;
        }
        viewD0.sendAccessibilityEvent(67108864);
        this.R = -1;
    }

    public final int w3(int i, int i2, int i3) {
        for (int i4 = i3 + 1; i4 < v(); i4++) {
            int iB3 = B3(i4);
            int iZ3 = z3(i4);
            if (iB3 < 0 || iZ3 < 0) {
                break;
            }
            if (this.s == 1) {
                if (iB3 > i && (iZ3 == i2 || A3(i4).contains(Integer.valueOf(i2)))) {
                    this.S = iB3;
                    return i4;
                }
            } else if (iB3 > i && iZ3 == i2) {
                this.S = B3(i4);
                return i4;
            }
        }
        return -1;
    }

    public final int x3(int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            int iB3 = B3(i4);
            int iZ3 = z3(i4);
            if (iB3 < 0 || iZ3 < 0) {
                break;
            }
            if (this.s == 1) {
                if ((iB3 == i && iZ3 < i2) || iB3 < i) {
                    this.S = iB3;
                    this.T = iZ3;
                    return i4;
                }
            } else if (C3(i4).contains(Integer.valueOf(i)) && iZ3 < i2) {
                this.T = iZ3;
                return i4;
            }
        }
        return -1;
    }

    public final int y3(int i, int i2, int i3) {
        for (int i4 = i3 + 1; i4 < v(); i4++) {
            int iB3 = B3(i4);
            int iZ3 = z3(i4);
            if (iB3 < 0 || iZ3 < 0) {
                break;
            }
            if (this.s == 1) {
                if ((iB3 == i && iZ3 > i2) || iB3 > i) {
                    this.S = iB3;
                    this.T = iZ3;
                    return i4;
                }
            } else if (iZ3 > i2 && C3(i4).contains(Integer.valueOf(i))) {
                this.T = iZ3;
                return i4;
            }
        }
        return -1;
    }

    public final int z3(int i) {
        int i2 = this.s;
        RecyclerView recyclerView = this.b;
        return i2 == 0 ? F3(recyclerView.h, recyclerView.n0, i) : G3(recyclerView.h, recyclerView.n0, i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends RecyclerView.r {
        public int j;
        public int k;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.j = -1;
            this.k = 0;
        }

        public int v() {
            return this.j;
        }

        public int w() {
            return this.k;
        }

        public c(int i, int i2) {
            super(i, i2);
            this.j = -1;
            this.k = 0;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.j = -1;
            this.k = 0;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.j = -1;
            this.k = 0;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new b();
        this.P = new Rect();
        this.R = -1;
        this.S = -1;
        this.T = -1;
        M3(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new b();
        this.P = new Rect();
        this.R = -1;
        this.S = -1;
        this.T = -1;
        M3(i);
    }
}

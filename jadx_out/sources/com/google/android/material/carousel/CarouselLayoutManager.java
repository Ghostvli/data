package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.c;
import defpackage.cn3;
import defpackage.gx;
import defpackage.hg3;
import defpackage.in3;
import defpackage.iq;
import defpackage.k7;
import defpackage.lq;
import defpackage.r62;
import defpackage.xv2;
import defpackage.zk3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.q implements iq, RecyclerView.b0.b {
    public int A;
    public Map B;
    public lq C;
    public final View.OnLayoutChangeListener D;
    public int E;
    public int F;
    public int G;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public final c w;
    public com.google.android.material.carousel.a x;
    public com.google.android.material.carousel.d y;
    public com.google.android.material.carousel.c z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends k {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b0
        public PointF a(int i) {
            return CarouselLayoutManager.this.f(i);
        }

        @Override // androidx.recyclerview.widget.k
        public int t(View view, int i) {
            if (CarouselLayoutManager.this.y == null || !CarouselLayoutManager.this.z()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.B2(carouselLayoutManager.D0(view));
        }

        @Override // androidx.recyclerview.widget.k
        public int u(View view, int i) {
            if (CarouselLayoutManager.this.y == null || CarouselLayoutManager.this.z()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.B2(carouselLayoutManager.D0(view));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final View a;
        public final float b;
        public final float c;
        public final d d;

        public b(View view, float f, float f2, d dVar) {
            this.a = view;
            this.b = f;
            this.c = f2;
            this.d = dVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends RecyclerView.p {
        public final Paint a;
        public List b;

        public c() {
            Paint paint = new Paint();
            this.a = paint;
            this.b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            super.i(canvas, recyclerView, c0Var);
            this.a.setStrokeWidth(recyclerView.getResources().getDimension(zk3.w));
            for (c.C0064c c0064c : this.b) {
                this.a.setColor(gx.c(-65281, -16776961, c0064c.c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).z()) {
                    canvas.drawLine(c0064c.b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).V2(), c0064c.b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).R2(), this.a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).S2(), c0064c.b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).T2(), c0064c.b, this.a);
                }
            }
        }

        public void j(List list) {
            this.b = Collections.unmodifiableList(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final c.C0064c a;
        public final c.C0064c b;

        public d(c.C0064c c0064c, c.C0064c c0064c2) {
            hg3.a(c0064c.a <= c0064c2.a);
            this.a = c0064c;
            this.b = c0064c2;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.v = false;
        this.w = new c();
        this.A = 0;
        this.D = new View.OnLayoutChangeListener() { // from class: jq
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                CarouselLayoutManager.m2(this.a, view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        };
        this.F = -1;
        this.G = 0;
        n3(new xv2());
        m3(context, attributeSet);
    }

    public static int C2(int i, int i2, int i3, int i4) {
        int i5 = i2 + i;
        return i5 < i3 ? i3 - i2 : i5 > i4 ? i4 - i2 : i;
    }

    private int E2(int i) {
        int iQ2 = Q2();
        if (i == 1) {
            return -1;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 17) {
            if (iQ2 == 0) {
                return a3() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i == 33) {
            return iQ2 == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            if (iQ2 == 0) {
                return a3() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i == 130) {
            return iQ2 == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i);
        return Integer.MIN_VALUE;
    }

    public static d Z2(List list, float f, boolean z) {
        float f2 = Float.MAX_VALUE;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        float f3 = -3.4028235E38f;
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < list.size(); i5++) {
            c.C0064c c0064c = (c.C0064c) list.get(i5);
            float f6 = z ? c0064c.b : c0064c.a;
            float fAbs = Math.abs(f6 - f);
            if (f6 <= f && fAbs <= f2) {
                i = i5;
                f2 = fAbs;
            }
            if (f6 > f && fAbs <= f4) {
                i3 = i5;
                f4 = fAbs;
            }
            if (f6 <= f5) {
                i2 = i5;
                f5 = f6;
            }
            if (f6 > f3) {
                i4 = i5;
                f3 = f6;
            }
        }
        if (i == -1) {
            i = i2;
        }
        if (i3 == -1) {
            i3 = i4;
        }
        return new d((c.C0064c) list.get(i), (c.C0064c) list.get(i3));
    }

    private int j3(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (k0() == 0 || i == 0) {
            return 0;
        }
        if (this.y == null) {
            g3(xVar);
        }
        if (v() <= L2(this.y).n()) {
            return 0;
        }
        int iC2 = C2(i, this.s, this.t, this.u);
        this.s += iC2;
        q3(this.y);
        float fG = this.z.g() / 2.0f;
        float fZ2 = z2(D0(j0(0)));
        Rect rect = new Rect();
        boolean zA3 = a3();
        com.google.android.material.carousel.c cVar = this.z;
        float f = zA3 ? cVar.i().b : cVar.b().b;
        float f2 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < k0(); i2++) {
            View viewJ0 = j0(i2);
            float fAbs = Math.abs(f - f3(viewJ0, fZ2, fG, rect));
            if (viewJ0 != null && fAbs < f2) {
                this.F = D0(viewJ0);
                f2 = fAbs;
            }
            fZ2 = t2(fZ2, this.z.g());
        }
        F2(xVar, c0Var);
        return iC2;
    }

    public static /* synthetic */ void m2(final CarouselLayoutManager carouselLayoutManager, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        carouselLayoutManager.getClass();
        if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
            return;
        }
        view.post(new Runnable() { // from class: kq
            @Override // java.lang.Runnable
            public final void run() {
                this.f.h3();
            }
        });
    }

    public final int A2(RecyclerView.c0 c0Var, com.google.android.material.carousel.d dVar) {
        boolean zA3 = a3();
        com.google.android.material.carousel.c cVarL = zA3 ? dVar.l() : dVar.h();
        c.C0064c c0064cB = zA3 ? cVarL.b() : cVarL.i();
        int iB = (int) (((((c0Var.b() - 1) * cVarL.g()) * (zA3 ? -1.0f : 1.0f)) - (c0064cB.a - U2())) + (((zA3 ? -1 : 1) * c0064cB.d) / 2.0f));
        return zA3 ? Math.min(0, iB) : Math.max(0, iB);
    }

    public int B2(int i) {
        return (int) (this.s - X2(i, M2(i)));
    }

    public final int D2(com.google.android.material.carousel.d dVar) {
        boolean zA3 = a3();
        com.google.android.material.carousel.c cVarH = zA3 ? dVar.h() : dVar.l();
        return (int) (U2() - u2((zA3 ? cVarH.i() : cVarH.b()).a, cVarH.g() / 2.0f));
    }

    public final void F2(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        i3(xVar);
        if (k0() == 0) {
            x2(xVar, this.A - 1);
            w2(xVar, c0Var, this.A);
        } else {
            int iD0 = D0(j0(0));
            int iD02 = D0(j0(k0() - 1));
            x2(xVar, iD0 - 1);
            w2(xVar, c0Var, iD02 + 1);
        }
        s3();
    }

    public final View G2() {
        return j0(a3() ? 0 : k0() - 1);
    }

    public final View H2() {
        return j0(a3() ? k0() - 1 : 0);
    }

    public final int I2() {
        return z() ? a() : d();
    }

    public final float J2(View view) {
        super.q0(view, new Rect());
        return z() ? r0.centerX() : r0.centerY();
    }

    public final int K2() {
        int i;
        int i2;
        if (k0() <= 0) {
            return 0;
        }
        RecyclerView.r rVar = (RecyclerView.r) j0(0).getLayoutParams();
        if (this.C.a == 0) {
            i = ((ViewGroup.MarginLayoutParams) rVar).leftMargin;
            i2 = ((ViewGroup.MarginLayoutParams) rVar).rightMargin;
        } else {
            i = ((ViewGroup.MarginLayoutParams) rVar).topMargin;
            i2 = ((ViewGroup.MarginLayoutParams) rVar).bottomMargin;
        }
        return i + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean L() {
        return z();
    }

    public final com.google.android.material.carousel.c L2(com.google.android.material.carousel.d dVar) {
        return a3() ? dVar.h() : dVar.l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean M() {
        return !z();
    }

    public final com.google.android.material.carousel.c M2(int i) {
        com.google.android.material.carousel.c cVar;
        Map map = this.B;
        return (map == null || (cVar = (com.google.android.material.carousel.c) map.get(Integer.valueOf(r62.b(i, 0, Math.max(0, v() + (-1)))))) == null) ? this.y.g() : cVar;
    }

    public final int N2() {
        if (n0()) {
            return 0;
        }
        return Q2() == 1 ? w() : y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean O0() {
        return true;
    }

    public final float O2(float f, d dVar) {
        c.C0064c c0064c = dVar.a;
        float f2 = c0064c.d;
        c.C0064c c0064c2 = dVar.b;
        return k7.b(f2, c0064c2.d, c0064c.b, c0064c2.b, f);
    }

    public int P2(int i, com.google.android.material.carousel.c cVar) {
        return X2(i, cVar) - this.s;
    }

    public int Q2() {
        return this.C.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int R(RecyclerView.c0 c0Var) {
        if (k0() == 0 || this.y == null || v() <= 1) {
            return 0;
        }
        return (int) (K0() * (this.y.g().g() / T(c0Var)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean R1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        int iY2;
        if (this.y == null || (iY2 = Y2(D0(view), M2(D0(view)))) == 0) {
            return false;
        }
        k3(recyclerView, Y2(D0(view), this.y.j(this.s + C2(iY2, this.s, this.t, this.u), this.t, this.u)));
        return true;
    }

    public final int R2() {
        return this.C.d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int S(RecyclerView.c0 c0Var) {
        return this.s;
    }

    public final int S2() {
        return this.C.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int T(RecyclerView.c0 c0Var) {
        return this.u - this.t;
    }

    public final int T2() {
        return this.C.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int U(RecyclerView.c0 c0Var) {
        if (k0() == 0 || this.y == null || v() <= 1) {
            return 0;
        }
        return (int) (x0() * (this.y.g().g() / W(c0Var)));
    }

    public final int U2() {
        return this.C.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V(RecyclerView.c0 c0Var) {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int V1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (L()) {
            return j3(i, xVar, c0Var);
        }
        return 0;
    }

    public final int V2() {
        return this.C.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int W(RecyclerView.c0 c0Var) {
        return this.u - this.t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void W1(int i) {
        this.F = i;
        if (this.y == null) {
            return;
        }
        this.s = X2(i, M2(i));
        this.A = r62.b(i, 0, Math.max(0, v() - 1));
        q3(this.y);
        S1();
    }

    public final int W2() {
        if (n0()) {
            return 0;
        }
        return Q2() == 1 ? b() : p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public int X1(int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (M()) {
            return j3(i, xVar, c0Var);
        }
        return 0;
    }

    public final int X2(int i, com.google.android.material.carousel.c cVar) {
        return (int) (a3() ? ((I2() - cVar.i().a) - (i * cVar.g())) - (cVar.g() / 2.0f) : ((i * cVar.g()) - cVar.b().a) + (cVar.g() / 2.0f));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void Y0(View view, int i, int i2) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public final int Y2(int i, com.google.android.material.carousel.c cVar) {
        int i2 = Integer.MAX_VALUE;
        for (c.C0064c c0064c : cVar.f()) {
            float fG = (i * cVar.g()) + (cVar.g() / 2.0f);
            int iI2 = (a3() ? (int) ((I2() - c0064c.a) - fG) : (int) (fG - c0064c.a)) - this.s;
            if (Math.abs(i2) > Math.abs(iI2)) {
                i2 = iI2;
            }
        }
        return i2;
    }

    @Override // defpackage.iq
    public int a() {
        return K0();
    }

    public boolean a3() {
        return z() && z0() == 1;
    }

    public final boolean b3(float f, d dVar) {
        float fU2 = u2(f, O2(f, dVar) / 2.0f);
        return a3() ? fU2 < 0.0f : fU2 > ((float) I2());
    }

    public final boolean c3(float f, d dVar) {
        float fT2 = t2(f, O2(f, dVar) / 2.0f);
        return a3() ? fT2 > ((float) I2()) : fT2 < 0.0f;
    }

    @Override // defpackage.iq
    public int d() {
        return x0();
    }

    public final void d3() {
        if (this.v && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i = 0; i < k0(); i++) {
                View viewJ0 = j0(i);
                Log.d("CarouselLayoutManager", "item position " + D0(viewJ0) + ", center:" + J2(viewJ0) + ", child index:" + i);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public RecyclerView.r e0() {
        return new RecyclerView.r(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void e1(RecyclerView recyclerView) {
        super.e1(recyclerView);
        this.x.f(recyclerView.getContext());
        h3();
        recyclerView.addOnLayoutChangeListener(this.D);
    }

    public final b e3(RecyclerView.x xVar, float f, int i) {
        View viewO = xVar.o(i);
        Y0(viewO, 0, 0);
        float fT2 = t2(f, this.z.g() / 2.0f);
        d dVarZ2 = Z2(this.z.h(), fT2, false);
        return new b(viewO, fT2, y2(fT2, dVarZ2), dVarZ2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0.b
    public PointF f(int i) {
        if (this.y == null) {
            return null;
        }
        int iP2 = P2(i, M2(i));
        return z() ? new PointF(iP2, 0.0f) : new PointF(0.0f, iP2);
    }

    public final float f3(View view, float f, float f2, Rect rect) {
        float fT2 = t2(f, f2);
        d dVarZ2 = Z2(this.z.h(), fT2, false);
        float fY2 = y2(fT2, dVarZ2);
        super.q0(view, rect);
        p3(view, fT2, dVarZ2);
        this.C.j(view, rect, f2, fY2);
        return fY2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void g1(RecyclerView recyclerView, RecyclerView.x xVar) {
        super.g1(recyclerView, xVar);
        recyclerView.removeOnLayoutChangeListener(this.D);
    }

    public final void g3(RecyclerView.x xVar) {
        View viewO = xVar.o(0);
        Y0(viewO, 0, 0);
        com.google.android.material.carousel.c cVarG = this.x.g(this, viewO);
        if (a3()) {
            cVarG = com.google.android.material.carousel.c.p(cVarG, I2());
        }
        this.y = com.google.android.material.carousel.d.f(this, cVarG, K2(), N2(), W2(), this.x.e());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public View h1(View view, int i, RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        int iE2;
        if (k0() == 0 || (iE2 = E2(i)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iE2 == -1) {
            if (D0(view) == 0) {
                return null;
            }
            v2(xVar, D0(j0(0)) - 1, 0);
            return H2();
        }
        if (D0(view) == v() - 1) {
            return null;
        }
        v2(xVar, D0(j0(k0() - 1)) + 1, -1);
        return G2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void h2(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        i2(aVar);
    }

    public final void h3() {
        this.y = null;
        S1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void i1(AccessibilityEvent accessibilityEvent) {
        super.i1(accessibilityEvent);
        if (k0() > 0) {
            accessibilityEvent.setFromIndex(D0(j0(0)));
            accessibilityEvent.setToIndex(D0(j0(k0() - 1)));
        }
    }

    public final void i3(RecyclerView.x xVar) {
        while (k0() > 0) {
            View viewJ0 = j0(0);
            float fJ2 = J2(viewJ0);
            if (!c3(fJ2, Z2(this.z.h(), fJ2, true))) {
                break;
            } else {
                L1(viewJ0, xVar);
            }
        }
        while (k0() - 1 >= 0) {
            View viewJ02 = j0(k0() - 1);
            float fJ22 = J2(viewJ02);
            if (!b3(fJ22, Z2(this.z.h(), fJ22, true))) {
                return;
            } else {
                L1(viewJ02, xVar);
            }
        }
    }

    public final void k3(RecyclerView recyclerView, int i) {
        if (z()) {
            recyclerView.scrollBy(i, 0);
        } else {
            recyclerView.scrollBy(0, i);
        }
    }

    public void l3(int i) {
        this.G = i;
        h3();
    }

    public final void m3(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cn3.M0);
            l3(typedArrayObtainStyledAttributes.getInt(cn3.N0, 0));
            o3(typedArrayObtainStyledAttributes.getInt(in3.b, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void n3(com.google.android.material.carousel.a aVar) {
        this.x = aVar;
        h3();
    }

    public void o3(int i) {
        if (i != 0 && i != 1) {
            defpackage.b.a("invalid orientation:", i);
            return;
        }
        H(null);
        lq lqVar = this.C;
        if (lqVar == null || i != lqVar.a) {
            this.C = lq.b(this, i);
            h3();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void p1(RecyclerView recyclerView, int i, int i2) {
        super.p1(recyclerView, i, i2);
        r3();
    }

    public final void p3(View view, float f, d dVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void q0(View view, Rect rect) {
        super.q0(view, rect);
        float fCenterY = rect.centerY();
        if (z()) {
            fCenterY = rect.centerX();
        }
        float fO2 = O2(fCenterY, Z2(this.z.h(), fCenterY, true));
        float fWidth = z() ? (rect.width() - fO2) / 2.0f : 0.0f;
        float fHeight = z() ? 0.0f : (rect.height() - fO2) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void q1(RecyclerView recyclerView) {
        super.q1(recyclerView);
        r3();
    }

    public final void q3(com.google.android.material.carousel.d dVar) {
        int i = this.u;
        int i2 = this.t;
        if (i <= i2) {
            this.z = L2(dVar);
        } else {
            this.z = dVar.j(this.s, i2, i);
        }
        this.w.j(this.z.h());
    }

    @Override // defpackage.iq
    public int r() {
        return this.G;
    }

    public final void r3() {
        int iV = v();
        int i = this.E;
        if (iV == i || this.y == null) {
            return;
        }
        if (this.x.h(this, i)) {
            h3();
        }
        this.E = iV;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void s1(RecyclerView recyclerView, int i, int i2) {
        super.s1(recyclerView, i, i2);
        r3();
    }

    public final void s2(View view, int i, b bVar) {
        float fG = this.z.g() / 2.0f;
        F(view, i);
        Y0(view, 0, 0);
        float f = bVar.c;
        this.C.i(view, (int) (f - fG), (int) (f + fG));
        p3(view, bVar.b, bVar.d);
    }

    public final void s3() {
        if (!this.v || k0() < 1) {
            return;
        }
        int i = 0;
        while (i < k0() - 1) {
            int iD0 = D0(j0(i));
            int i2 = i + 1;
            int iD02 = D0(j0(i2));
            if (iD0 > iD02) {
                d3();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i + "] had adapter position [" + iD0 + "] and child at index [" + i2 + "] had adapter position [" + iD02 + "].");
            }
            i = i2;
        }
    }

    public final float t2(float f, float f2) {
        return a3() ? f - f2 : f + f2;
    }

    public final float u2(float f, float f2) {
        return a3() ? f + f2 : f - f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void v1(RecyclerView.x xVar, RecyclerView.c0 c0Var) {
        if (c0Var.b() <= 0 || I2() <= 0.0f) {
            J1(xVar);
            this.A = 0;
            return;
        }
        boolean zA3 = a3();
        com.google.android.material.carousel.d dVar = this.y;
        boolean z = dVar == null;
        if (z || dVar.g().a() != I2()) {
            g3(xVar);
        }
        int iD2 = D2(this.y);
        int iA2 = A2(c0Var, this.y);
        this.t = zA3 ? iA2 : iD2;
        if (zA3) {
            iA2 = iD2;
        }
        this.u = iA2;
        if (z) {
            this.s = iD2;
            this.B = this.y.i(v(), this.t, this.u, a3());
            int i = this.F;
            if (i != -1) {
                this.s = X2(i, M2(i));
            }
        }
        int i2 = this.s;
        this.s = i2 + C2(0, i2, this.t, this.u);
        this.A = r62.b(this.A, 0, c0Var.b());
        q3(this.y);
        X(xVar);
        F2(xVar, c0Var);
        this.E = v();
    }

    public final void v2(RecyclerView.x xVar, int i, int i2) {
        if (i < 0 || i >= v()) {
            return;
        }
        b bVarE3 = e3(xVar, z2(i), i);
        s2(bVarE3.a, i2, bVarE3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void w1(RecyclerView.c0 c0Var) {
        super.w1(c0Var);
        if (k0() == 0) {
            this.A = 0;
        } else {
            this.A = D0(j0(0));
        }
        s3();
    }

    public final void w2(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i) {
        float fZ2 = z2(i);
        while (i < c0Var.b()) {
            float fT2 = t2(fZ2, this.z.g() / 2.0f);
            d dVarZ2 = Z2(this.z.h(), fT2, false);
            float fY2 = y2(fT2, dVarZ2);
            if (b3(fY2, dVarZ2)) {
                return;
            }
            fZ2 = t2(fZ2, this.z.g());
            if (!c3(fY2, dVarZ2)) {
                View viewO = xVar.o(i);
                s2(viewO, -1, new b(viewO, fT2, fY2, dVarZ2));
            }
            i++;
        }
    }

    public final void x2(RecyclerView.x xVar, int i) {
        float fZ2 = z2(i);
        while (i >= 0) {
            float fT2 = t2(fZ2, this.z.g() / 2.0f);
            d dVarZ2 = Z2(this.z.h(), fT2, false);
            float fY2 = y2(fT2, dVarZ2);
            if (c3(fY2, dVarZ2)) {
                return;
            }
            fZ2 = u2(fZ2, this.z.g());
            if (!b3(fY2, dVarZ2)) {
                View viewO = xVar.o(i);
                s2(viewO, 0, new b(viewO, fT2, fY2, dVarZ2));
            }
            i--;
        }
    }

    public final float y2(float f, d dVar) {
        c.C0064c c0064c = dVar.a;
        float f2 = c0064c.b;
        c.C0064c c0064c2 = dVar.b;
        float fB = k7.b(f2, c0064c2.b, c0064c.a, c0064c2.a, f);
        if (dVar.b != this.z.d() && dVar.a != this.z.k()) {
            return fB;
        }
        c.C0064c c0064c3 = dVar.b;
        return fB + ((f - c0064c3.a) * (1.0f - c0064c3.c));
    }

    @Override // defpackage.iq
    public boolean z() {
        return this.C.a == 0;
    }

    public final float z2(int i) {
        return t2(U2() - this.s, this.z.g() * i);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.a aVar) {
        this(aVar, 0);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.a aVar, int i) {
        this.v = false;
        this.w = new c();
        this.A = 0;
        this.D = new View.OnLayoutChangeListener() { // from class: jq
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                CarouselLayoutManager.m2(this.a, view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        };
        this.F = -1;
        this.G = 0;
        n3(aVar);
        o3(i);
    }

    public CarouselLayoutManager() {
        this(new xv2());
    }
}

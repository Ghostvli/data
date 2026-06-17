package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e04;
import defpackage.g2;
import defpackage.j2;
import defpackage.jl;
import defpackage.ke4;
import defpackage.kn3;
import defpackage.l35;
import defpackage.vz0;
import defpackage.z20;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static boolean z = true;
    public final Rect f;
    public final Rect g;
    public androidx.viewpager2.widget.a h;
    public int i;
    public boolean j;
    public RecyclerView.j k;
    public LinearLayoutManager l;
    public int m;
    public Parcelable n;
    public RecyclerView o;
    public androidx.recyclerview.widget.n p;
    public androidx.viewpager2.widget.c q;
    public androidx.viewpager2.widget.a r;
    public vz0 s;
    public androidx.viewpager2.widget.b t;
    public RecyclerView.n u;
    public boolean v;
    public boolean w;
    public int x;
    public e y;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends g {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            super(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.j = true;
            viewPager2.q.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i) {
            if (i == 0) {
                ViewPager2.this.o();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.i != i) {
                viewPager2.i = i;
                viewPager2.y.r();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.o.requestFocus(2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements RecyclerView.s {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(View view) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) rVar).width == -1 && ((ViewGroup.MarginLayoutParams) rVar).height == -1) {
                return;
            }
            e04.a("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
            super(ViewPager2.this, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(g2 g2Var) {
            if (ViewPager2.this.e()) {
                return;
            }
            g2Var.d0(g2.a.r);
            g2Var.d0(g2.a.q);
            g2Var.H0(false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i) {
            if (b(i)) {
                return false;
            }
            z20.a();
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence o() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            z20.a();
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends LinearLayoutManager {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(Context context) {
            super(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.q
        public boolean F1(RecyclerView.x xVar, RecyclerView.c0 c0Var, int i, Bundle bundle) {
            return ViewPager2.this.y.b(i) ? ViewPager2.this.y.l(i) : super.F1(xVar, c0Var, i, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.q
        public boolean R1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.q
        public void l1(RecyclerView.x xVar, RecyclerView.c0 c0Var, g2 g2Var) {
            super.l1(xVar, c0Var, g2Var);
            ViewPager2.this.y.j(g2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void l2(RecyclerView.c0 c0Var, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.l2(c0Var, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void n1(RecyclerView.x xVar, RecyclerView.c0 c0Var, View view, g2 g2Var) {
            ViewPager2.this.y.k(view, g2Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i, float f, int i2) {
        }

        public abstract void c(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class j extends e {
        public final j2 b;
        public final j2 c;
        public RecyclerView.j d;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements j2 {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.j2
            public boolean a(View view, j2.a aVar) {
                j.this.x(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b implements j2 {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.j2
            public boolean a(View view, j2.a aVar) {
                j.this.x(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class c extends g {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c() {
                super(null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.j
            public void a() {
                j.this.y();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j() {
            super(ViewPager2.this, null);
            this.b = new a();
            this.c = new b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.h hVar) {
            y();
            if (hVar != null) {
                hVar.D(this.d);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.h hVar) {
            if (hVar != null) {
                hVar.F(this.d);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            z20.a();
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.a aVar, RecyclerView recyclerView) {
            recyclerView.setImportantForAccessibility(2);
            this.d = new c();
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            g2 g2VarP0 = g2.P0(accessibilityNodeInfo);
            u(g2VarP0);
            w(g2VarP0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void k(View view, g2 g2Var) {
            v(view, g2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean m(int i, Bundle bundle) {
            if (!c(i, bundle)) {
                z20.a();
                return false;
            }
            ViewPager2 viewPager2 = ViewPager2.this;
            x(i == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1);
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void n() {
            y();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            y();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            y();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            y();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void t() {
            y();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u(g2 g2Var) {
            int iG;
            int iG2;
            if (ViewPager2.this.getAdapter() != null) {
                int orientation = ViewPager2.this.getOrientation();
                ViewPager2 viewPager2 = ViewPager2.this;
                iG2 = 1;
                if (orientation == 1) {
                    iG2 = viewPager2.getAdapter().g();
                    iG = 1;
                } else {
                    iG = viewPager2.getAdapter().g();
                }
            } else {
                iG = 0;
                iG2 = 0;
            }
            g2Var.n0(g2.e.a(iG2, iG, false, 0));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void v(View view, g2 g2Var) {
            g2Var.o0(g2.f.a(ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.l.D0(view) : 0, 1, ViewPager2.this.getOrientation() == 0 ? ViewPager2.this.l.D0(view) : 0, 1, false, false));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void w(g2 g2Var) {
            int iG;
            RecyclerView.h adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (iG = adapter.g()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.i > 0) {
                g2Var.a(8192);
            }
            if (ViewPager2.this.i < iG - 1) {
                g2Var.a(Buffer.SEGMENTING_THRESHOLD);
            }
            g2Var.H0(true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void x(int i) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i, true);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void y() {
            int iG;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = R.id.accessibilityActionPageLeft;
            l35.a0(viewPager2, R.id.accessibilityActionPageLeft);
            l35.a0(viewPager2, R.id.accessibilityActionPageRight);
            l35.a0(viewPager2, R.id.accessibilityActionPageUp);
            l35.a0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (iG = ViewPager2.this.getAdapter().g()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            int orientation = ViewPager2.this.getOrientation();
            ViewPager2 viewPager22 = ViewPager2.this;
            if (orientation != 0) {
                if (viewPager22.i < iG - 1) {
                    l35.c0(viewPager2, new g2.a(R.id.accessibilityActionPageDown, null), null, this.b);
                }
                if (ViewPager2.this.i > 0) {
                    l35.c0(viewPager2, new g2.a(R.id.accessibilityActionPageUp, null), null, this.c);
                    return;
                }
                return;
            }
            boolean zD = viewPager22.d();
            int i2 = zD ? 16908360 : 16908361;
            if (zD) {
                i = 16908361;
            }
            if (ViewPager2.this.i < iG - 1) {
                l35.c0(viewPager2, new g2.a(i2, null), null, this.b);
            }
            if (ViewPager2.this.i > 0) {
                l35.c0(viewPager2, new g2.a(i, null), null, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface k {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class l extends androidx.recyclerview.widget.n {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public l() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.n, androidx.recyclerview.widget.r
        public View f(RecyclerView.q qVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.f(qVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class m extends RecyclerView {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public m(Context context) {
            super(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.y.d() ? ViewPager2.this.y.o() : super.getAccessibilityClassName();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.i);
            accessibilityEvent.setToIndex(ViewPager2.this.i);
            ViewPager2.this.y.p(accessibilityEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class o implements Runnable {
        public final int f;
        public final RecyclerView g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public o(int i, RecyclerView recyclerView) {
            this.f = i;
            this.g = recyclerView;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            this.g.C1(this.f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ViewPager2(Context context) {
        super(context);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new androidx.viewpager2.widget.a(3);
        this.j = false;
        this.k = new a();
        this.m = -1;
        this.u = null;
        this.v = false;
        this.w = true;
        this.x = -1;
        b(context, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final RecyclerView.s a() {
        return new d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(Context context, AttributeSet attributeSet) {
        this.y = z ? new j() : new f();
        m mVar = new m(context);
        this.o = mVar;
        mVar.setId(View.generateViewId());
        this.o.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.l = hVar;
        this.o.setLayoutManager(hVar);
        this.o.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.o.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.o.k(a());
        androidx.viewpager2.widget.c cVar = new androidx.viewpager2.widget.c(this);
        this.q = cVar;
        this.s = new vz0(this, cVar, this.o);
        l lVar = new l();
        this.p = lVar;
        lVar.b(this.o);
        this.o.m(this.q);
        androidx.viewpager2.widget.a aVar = new androidx.viewpager2.widget.a(3);
        this.r = aVar;
        this.q.o(aVar);
        b bVar = new b();
        c cVar2 = new c();
        this.r.d(bVar);
        this.r.d(cVar2);
        this.y.h(this.r, this.o);
        this.r.d(this.h);
        androidx.viewpager2.widget.b bVar2 = new androidx.viewpager2.widget.b(this.l);
        this.t = bVar2;
        this.r.d(bVar2);
        RecyclerView recyclerView = this.o;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c() {
        return this.s.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.o.canScrollHorizontally(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.o.canScrollVertically(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d() {
        return this.l.z0() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof n) {
            int i2 = ((n) parcelable).f;
            sparseArray.put(this.o.getId(), (Parcelable) sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(RecyclerView.h hVar) {
        if (hVar != null) {
            hVar.D(this.k);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(i iVar) {
        this.h.d(iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.y.a() ? this.y.g() : super.getAccessibilityClassName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RecyclerView.h getAdapter() {
        return this.o.getAdapter();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCurrentItem() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemDecorationCount() {
        return this.o.getItemDecorationCount();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getOffscreenPageLimit() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getOrientation() {
        return this.l.K2() == 1 ? 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.o;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getScrollState() {
        return this.q.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        this.t.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.recyclerview.widget.RecyclerView$h */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        RecyclerView.h adapter;
        if (this.m == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.n;
        if (parcelable != null) {
            if (adapter instanceof ke4) {
                ((ke4) adapter).b(parcelable);
            }
            this.n = null;
        }
        int iMax = Math.max(0, Math.min(this.m, adapter.g() - 1));
        this.i = iMax;
        this.m = -1;
        this.o.t1(iMax);
        this.y.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(int i2, boolean z2) {
        if (c()) {
            e04.a("Cannot change current item when ViewPager2 is fake dragging");
        } else {
            k(i2, z2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(int i2, boolean z2) {
        RecyclerView.h adapter = getAdapter();
        if (adapter == null) {
            if (this.m != -1) {
                this.m = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.g() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.g() - 1);
        if (iMin == this.i && this.q.j()) {
            return;
        }
        int i3 = this.i;
        if (iMin == i3 && z2) {
            return;
        }
        double dG = i3;
        this.i = iMin;
        this.y.r();
        if (!this.q.j()) {
            dG = this.q.g();
        }
        this.q.m(iMin, z2);
        if (!z2) {
            this.o.t1(iMin);
            return;
        }
        double d2 = iMin;
        double dAbs = Math.abs(d2 - dG);
        RecyclerView recyclerView = this.o;
        if (dAbs <= 3.0d) {
            recyclerView.C1(iMin);
            return;
        }
        recyclerView.t1(d2 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView2 = this.o;
        recyclerView2.post(new o(iMin, recyclerView2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, kn3.a);
        l35.e0(this, context, kn3.a, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(kn3.b, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(RecyclerView.h hVar) {
        if (hVar != null) {
            hVar.F(this.k);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(i iVar) {
        this.h.e(iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o() {
        androidx.recyclerview.widget.n nVar = this.p;
        if (nVar == null) {
            e04.a("Design assumption violated.");
            return;
        }
        View viewF = nVar.f(this.l);
        if (viewF == null) {
            return;
        }
        int iD0 = this.l.D0(viewF);
        if (iD0 != this.i && getScrollState() == 0) {
            this.r.c(iD0);
        }
        this.j = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.y.i(accessibilityNodeInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        this.f.left = getPaddingLeft();
        this.f.right = (i4 - i2) - getPaddingRight();
        this.f.top = getPaddingTop();
        this.f.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f, this.g);
        RecyclerView recyclerView = this.o;
        Rect rect = this.g;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.j) {
            o();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        measureChild(this.o, i2, i3);
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        int measuredState = this.o.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.onRestoreInstanceState(nVar.getSuperState());
        this.m = nVar.g;
        this.n = nVar.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        n nVar = new n(super.onSaveInstanceState());
        nVar.f = this.o.getId();
        int i2 = this.m;
        if (i2 == -1) {
            i2 = this.i;
        }
        nVar.g = i2;
        Parcelable parcelable = this.n;
        if (parcelable != null) {
            nVar.h = parcelable;
            return nVar;
        }
        Object adapter = this.o.getAdapter();
        if (adapter instanceof ke4) {
            nVar.h = ((ke4) adapter).a();
        }
        return nVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName().concat(" does not support direct child views"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.y.c(i2, bundle) ? this.y.m(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAdapter(RecyclerView.h hVar) {
        RecyclerView.h adapter = this.o.getAdapter();
        this.y.f(adapter);
        m(adapter);
        this.o.setAdapter(hVar);
        this.i = 0;
        i();
        this.y.e(hVar);
        f(hVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCurrentItem(int i2) {
        j(i2, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.y.q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            jl.a("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        } else {
            this.x = i2;
            this.o.requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOrientation(int i2) {
        this.l.Y2(i2);
        this.y.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPageTransformer(k kVar) {
        boolean z2 = this.v;
        if (kVar != null) {
            if (!z2) {
                this.u = this.o.getItemAnimator();
                this.v = true;
            }
            this.o.setItemAnimator(null);
        } else if (z2) {
            this.o.setItemAnimator(this.u);
            this.u = null;
            this.v = false;
        }
        this.t.d();
        if (kVar == null) {
            return;
        }
        this.t.e(kVar);
        h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUserInputEnabled(boolean z2) {
        this.w = z2;
        this.y.t();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class g extends RecyclerView.j {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public abstract void a();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void b(int i, int i2, Object obj) {
            a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void c(int i, int i2) {
            a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void d(int i, int i2, int i3) {
            a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void e(int i, int i2) {
            a();
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:5) call: androidx.viewpager2.widget.ViewPager2.g.<init>():void type: THIS */
        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public abstract class e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b(int i) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c(int i, Bundle bundle) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean d() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(RecyclerView.h hVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(RecyclerView.h hVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(androidx.viewpager2.widget.a aVar, RecyclerView recyclerView) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j(g2 g2Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k(View view, g2 g2Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean l(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean m(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CharSequence o() {
            throw new IllegalStateException("Not implemented.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void p(AccessibilityEvent accessibilityEvent) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void t() {
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 androidx.viewpager2.widget.ViewPager2) A[MD:(androidx.viewpager2.widget.ViewPager2):void (m)] (LINE:7) call: androidx.viewpager2.widget.ViewPager2.e.<init>(androidx.viewpager2.widget.ViewPager2):void type: THIS */
        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class n extends View.BaseSavedState {
        public static final Parcelable.Creator<n> CREATOR = new a();
        public int f;
        public int g;
        public Parcelable h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i) {
                return new n[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public n(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            c(parcel, classLoader);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c(Parcel parcel, ClassLoader classLoader) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readParcelable(classLoader);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeParcelable(this.h, i);
        }

        public n(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new androidx.viewpager2.widget.a(3);
        this.j = false;
        this.k = new a();
        this.m = -1;
        this.u = null;
        this.v = false;
        this.w = true;
        this.x = -1;
        b(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new androidx.viewpager2.widget.a(3);
        this.j = false;
        this.k = new a();
        this.m = -1;
        this.u = null;
        this.v = false;
        this.w = true;
        this.x = -1;
        b(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new androidx.viewpager2.widget.a(3);
        this.j = false;
        this.k = new a();
        this.m = -1;
        this.u = null;
        this.v = false;
        this.w = true;
        this.x = -1;
        b(context, attributeSet);
    }
}

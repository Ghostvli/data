package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import defpackage.k61;
import defpackage.p51;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v61 extends RecyclerView.h implements ke4 {
    public final androidx.lifecycle.g d;
    public final k61 e;
    public final w02 f;
    public final w02 g;
    public final w02 h;
    public g i;
    public f j;
    public boolean k;
    public boolean l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements i {
        public final /* synthetic */ k71 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(k71 k71Var) {
            this.f = k71Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            if (v61.this.Z()) {
                return;
            }
            bt1Var.getLifecycle().c(this);
            if (this.f.O().isAttachedToWindow()) {
                v61.this.V(this.f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends k61.l {
        public final /* synthetic */ p51 a;
        public final /* synthetic */ FrameLayout b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(p51 p51Var, FrameLayout frameLayout) {
            this.a = p51Var;
            this.b = frameLayout;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // k61.l
        public void m(k61 k61Var, p51 p51Var, View view, Bundle bundle) {
            if (p51Var == this.a) {
                k61Var.w1(this);
                v61.this.G(view, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            v61 v61Var = v61.this;
            v61Var.k = false;
            v61Var.L();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements i {
        public final /* synthetic */ Handler f;
        public final /* synthetic */ Runnable g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Handler handler, Runnable runnable) {
            this.f = handler;
            this.g = runnable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            if (aVar == g.a.ON_DESTROY) {
                this.f.removeCallbacks(this.g);
                bt1Var.getLifecycle().c(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public List a = new CopyOnWriteArrayList();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List a(p51 p51Var, g.b bVar) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            w82.a(it.next());
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(List list) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                w82.a(it.next());
                throw null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List c(p51 p51Var) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            w82.a(it.next());
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List d(p51 p51Var) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            w82.a(it.next());
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List e(p51 p51Var) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            w82.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g {
        public ViewPager2.i a;
        public RecyclerView.j b;
        public i c;
        public ViewPager2 d;
        public long e = -1;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends ViewPager2.i {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void a(int i) {
                g.this.d(false);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void c(int i) {
                g.this.d(false);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b extends e {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b() {
                super(null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // v61.e, androidx.recyclerview.widget.RecyclerView.j
            public void a() {
                g.this.d(true);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class c implements i {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.lifecycle.i
            public void c(bt1 bt1Var, g.a aVar) {
                g.this.d(false);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            ho1.a("Expected ViewPager2 instance. Got: ", parent);
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(RecyclerView recyclerView) {
            this.d = a(recyclerView);
            a aVar = new a();
            this.a = aVar;
            this.d.g(aVar);
            b bVar = new b();
            this.b = bVar;
            v61.this.D(bVar);
            c cVar = new c();
            this.c = cVar;
            v61.this.d.a(cVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(RecyclerView recyclerView) {
            a(recyclerView).n(this.a);
            v61.this.F(this.b);
            v61.this.d.c(this.c);
            this.d = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(boolean z) {
            int currentItem;
            p51 p51Var;
            if (v61.this.Z() || this.d.getScrollState() != 0 || v61.this.f.f() || v61.this.g() == 0 || (currentItem = this.d.getCurrentItem()) >= v61.this.g()) {
                return;
            }
            long jH = v61.this.h(currentItem);
            if ((jH != this.e || z) && (p51Var = (p51) v61.this.f.d(jH)) != null && p51Var.H0()) {
                this.e = jH;
                d71 d71VarO = v61.this.e.o();
                ArrayList arrayList = new ArrayList();
                p51 p51Var2 = null;
                for (int i = 0; i < v61.this.f.k(); i++) {
                    long jG = v61.this.f.g(i);
                    p51 p51Var3 = (p51) v61.this.f.l(i);
                    if (p51Var3.H0()) {
                        if (jG != this.e) {
                            g.b bVar = g.b.i;
                            d71VarO.s(p51Var3, bVar);
                            arrayList.add(v61.this.j.a(p51Var3, bVar));
                        } else {
                            p51Var2 = p51Var3;
                        }
                        p51Var3.h2(jG == this.e);
                    }
                }
                if (p51Var2 != null) {
                    g.b bVar2 = g.b.j;
                    d71VarO.s(p51Var2, bVar2);
                    arrayList.add(v61.this.j.a(p51Var2, bVar2));
                }
                if (d71VarO.o()) {
                    return;
                }
                d71VarO.j();
                Collections.reverse(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    v61.this.j.b((List) it.next());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v61(k61 k61Var, androidx.lifecycle.g gVar) {
        this.f = new w02();
        this.g = new w02();
        this.h = new w02();
        this.j = new f();
        this.k = false;
        this.l = false;
        this.e = k61Var;
        this.d = gVar;
        super.E(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String J(String str, long j) {
        return str + j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean N(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long U(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            e04.a("Design assumption violated.");
            return;
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean H(long j) {
        return j >= 0 && j < ((long) g());
    }

    public abstract p51 I(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(int i) {
        long jH = h(i);
        if (this.f.c(jH)) {
            return;
        }
        p51 p51VarI = I(i);
        p51VarI.g2((p51.n) this.g.d(jH));
        this.f.h(jH, p51VarI);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L() {
        if (!this.l || Z()) {
            return;
        }
        na naVar = new na();
        for (int i = 0; i < this.f.k(); i++) {
            long jG = this.f.g(i);
            if (!H(jG)) {
                naVar.add(Long.valueOf(jG));
                this.h.i(jG);
            }
        }
        if (!this.k) {
            this.l = false;
            for (int i2 = 0; i2 < this.f.k(); i2++) {
                long jG2 = this.f.g(i2);
                if (!M(jG2)) {
                    naVar.add(Long.valueOf(jG2));
                }
            }
        }
        Iterator it = naVar.iterator();
        while (it.hasNext()) {
            W(((Long) it.next()).longValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M(long j) {
        View viewB0;
        if (this.h.c(j)) {
            return true;
        }
        p51 p51Var = (p51) this.f.d(j);
        return (p51Var == null || (viewB0 = p51Var.B0()) == null || viewB0.getParent() == null) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long O(int i) {
        Long lValueOf = null;
        for (int i2 = 0; i2 < this.h.k(); i2++) {
            if (((Integer) this.h.l(i2)).intValue() == i) {
                if (lValueOf != null) {
                    e04.a("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                    return null;
                }
                lValueOf = Long.valueOf(this.h.g(i2));
            }
        }
        return lValueOf;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final void v(k71 k71Var, int i) {
        long jL = k71Var.l();
        int id = k71Var.O().getId();
        Long lO = O(id);
        if (lO != null && lO.longValue() != jL) {
            W(lO.longValue());
            this.h.i(lO.longValue());
        }
        this.h.h(jL, Integer.valueOf(id));
        K(i);
        if (k71Var.O().isAttachedToWindow()) {
            V(k71Var);
        }
        L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final k71 x(ViewGroup viewGroup, int i) {
        return k71.N(viewGroup);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: z(Landroidx/recyclerview/widget/RecyclerView$g0;)Z */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final boolean z(k71 k71Var) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: A(Landroidx/recyclerview/widget/RecyclerView$g0;)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void A(k71 k71Var) {
        V(k71Var);
        L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: C(Landroidx/recyclerview/widget/RecyclerView$g0;)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final void C(k71 k71Var) {
        Long lO = O(k71Var.O().getId());
        if (lO != null) {
            W(lO.longValue());
            this.h.i(lO.longValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V(k71 k71Var) {
        p51 p51Var = (p51) this.f.d(k71Var.l());
        if (p51Var == null) {
            e04.a("Design assumption violated.");
            return;
        }
        FrameLayout frameLayoutO = k71Var.O();
        View viewB0 = p51Var.B0();
        if (!p51Var.H0() && viewB0 != null) {
            e04.a("Design assumption violated.");
            return;
        }
        if (p51Var.H0() && viewB0 == null) {
            Y(p51Var, frameLayoutO);
            return;
        }
        if (p51Var.H0() && viewB0.getParent() != null) {
            if (viewB0.getParent() != frameLayoutO) {
                G(viewB0, frameLayoutO);
                return;
            }
            return;
        }
        if (p51Var.H0()) {
            G(viewB0, frameLayoutO);
            return;
        }
        if (Z()) {
            if (this.e.J0()) {
                return;
            }
            this.d.a(new a(k71Var));
            return;
        }
        Y(p51Var, frameLayoutO);
        List listC = this.j.c(p51Var);
        try {
            p51Var.h2(false);
            this.e.o().d(p51Var, "f" + k71Var.l()).s(p51Var, g.b.i).j();
            this.i.d(false);
        } finally {
            this.j.b(listC);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W(long j) {
        ViewParent parent;
        p51 p51Var = (p51) this.f.d(j);
        if (p51Var == null) {
            return;
        }
        if (p51Var.B0() != null && (parent = p51Var.B0().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!H(j)) {
            this.g.i(j);
        }
        if (!p51Var.H0()) {
            this.f.i(j);
            return;
        }
        if (Z()) {
            this.l = true;
            return;
        }
        if (p51Var.H0() && H(j)) {
            List listE = this.j.e(p51Var);
            p51.n nVarL1 = this.e.l1(p51Var);
            this.j.b(listE);
            this.g.h(j, nVarL1);
        }
        List listD = this.j.d(p51Var);
        try {
            this.e.o().p(p51Var).j();
            this.f.i(j);
        } finally {
            this.j.b(listD);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X() {
        Handler handler = new Handler(Looper.getMainLooper());
        c cVar = new c();
        this.d.a(new d(handler, cVar));
        handler.postDelayed(cVar, 10000L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y(p51 p51Var, FrameLayout frameLayout) {
        this.e.e1(new b(p51Var, frameLayout), false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Z() {
        return this.e.R0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ke4
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f.k() + this.g.k());
        for (int i = 0; i < this.f.k(); i++) {
            long jG = this.f.g(i);
            p51 p51Var = (p51) this.f.d(jG);
            if (p51Var != null && p51Var.H0()) {
                this.e.d1(bundle, J("f#", jG), p51Var);
            }
        }
        for (int i2 = 0; i2 < this.g.k(); i2++) {
            long jG2 = this.g.g(i2);
            if (H(jG2)) {
                bundle.putParcelable(J("s#", jG2), (Parcelable) this.g.d(jG2));
            }
        }
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ke4
    public final void b(Parcelable parcelable) {
        if (!this.g.f() || !this.f.f()) {
            e04.a("Expected the adapter to be 'fresh' while restoring state.");
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (N(str, "f#")) {
                this.f.h(U(str, "f#"), this.e.t0(bundle, str));
            } else {
                if (!N(str, "s#")) {
                    defpackage.c.a("Unexpected key in savedState: ", str);
                    return;
                }
                long jU = U(str, "s#");
                p51.n nVar = (p51.n) bundle.getParcelable(str);
                if (H(jU)) {
                    this.g.h(jU, nVar);
                }
            }
        }
        if (this.f.f()) {
            return;
        }
        this.l = true;
        this.k = true;
        L();
        X();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long h(int i) {
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void u(RecyclerView recyclerView) {
        hg3.a(this.i == null);
        g gVar = new g();
        this.i = gVar;
        gVar.b(recyclerView);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void y(RecyclerView recyclerView) {
        this.i.c(recyclerView);
        this.i = null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class e extends RecyclerView.j {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
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

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:5) call: v61.e.<init>():void type: THIS */
        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public v61(p51 p51Var) {
        this(p51Var.T(), p51Var.getLifecycle());
    }
}

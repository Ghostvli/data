package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.l35;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f extends q {
    public static TimeInterpolator s;
    public ArrayList h = new ArrayList();
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public ArrayList k = new ArrayList();
    public ArrayList l = new ArrayList();
    public ArrayList m = new ArrayList();
    public ArrayList n = new ArrayList();
    public ArrayList o = new ArrayList();
    public ArrayList p = new ArrayList();
    public ArrayList q = new ArrayList();
    public ArrayList r = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final /* synthetic */ ArrayList f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ArrayList arrayList) {
            this.f = arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f) {
                f.this.S(jVar.a, jVar.b, jVar.c, jVar.d, jVar.e);
            }
            this.f.clear();
            f.this.m.remove(this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        public final /* synthetic */ ArrayList f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(ArrayList arrayList) {
            this.f = arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                f.this.R((i) it.next());
            }
            this.f.clear();
            f.this.n.remove(this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public final /* synthetic */ ArrayList f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(ArrayList arrayList) {
            this.f = arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                f.this.Q((RecyclerView.g0) it.next());
            }
            this.f.clear();
            f.this.l.remove(this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.g0 a;
        public final /* synthetic */ ViewPropertyAnimator b;
        public final /* synthetic */ View c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(RecyclerView.g0 g0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = g0Var;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            f.this.G(this.a);
            f.this.q.remove(this.a);
            f.this.V();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.H(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.g0 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ViewPropertyAnimator c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(RecyclerView.g0 g0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = g0Var;
            this.b = view;
            this.c = viewPropertyAnimator;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.b.setAlpha(1.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.c.setListener(null);
            f.this.A(this.a);
            f.this.o.remove(this.a);
            f.this.V();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.B(this.a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0041f extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.g0 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewPropertyAnimator e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0041f(RecyclerView.g0 g0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = g0Var;
            this.b = i;
            this.c = view;
            this.d = i2;
            this.e = viewPropertyAnimator;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.b != 0) {
                this.c.setTranslationX(0.0f);
            }
            if (this.d != 0) {
                this.c.setTranslationY(0.0f);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(null);
            f.this.E(this.a);
            f.this.p.remove(this.a);
            f.this.V();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.F(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ViewPropertyAnimator b;
        public final /* synthetic */ View c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            f.this.C(this.a.a, true);
            f.this.r.remove(this.a.a);
            f.this.V();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.D(this.a.a, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ViewPropertyAnimator b;
        public final /* synthetic */ View c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            f.this.C(this.a.b, false);
            f.this.r.remove(this.a.b);
            f.this.V();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.D(this.a.b, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j {
        public RecyclerView.g0 a;
        public int b;
        public int c;
        public int d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j(RecyclerView.g0 g0Var, int i, int i2, int i3, int i4) {
            this.a = g0Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(RecyclerView.g0 g0Var) {
        View view = g0Var.f;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.o.add(g0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new e(g0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R(i iVar) {
        RecyclerView.g0 g0Var = iVar.a;
        View view = g0Var == null ? null : g0Var.f;
        RecyclerView.g0 g0Var2 = iVar.b;
        View view2 = g0Var2 != null ? g0Var2.f : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.r.add(iVar.a);
            duration.translationX(iVar.e - iVar.c);
            duration.translationY(iVar.f - iVar.d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.r.add(iVar.b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(RecyclerView.g0 g0Var, int i2, int i3, int i4, int i5) {
        View view = g0Var.f;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.p.add(g0Var);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new C0041f(g0Var, i6, view, i7, viewPropertyAnimatorAnimate)).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T(RecyclerView.g0 g0Var) {
        View view = g0Var.f;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.q.add(g0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(g0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.g0) list.get(size)).f.animate().cancel();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V() {
        if (p()) {
            return;
        }
        i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W(List list, RecyclerView.g0 g0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, g0Var) && iVar.a == null && iVar.b == null) {
                list.remove(iVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X(i iVar) {
        RecyclerView.g0 g0Var = iVar.a;
        if (g0Var != null) {
            Y(iVar, g0Var);
        }
        RecyclerView.g0 g0Var2 = iVar.b;
        if (g0Var2 != null) {
            Y(iVar, g0Var2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Y(i iVar, RecyclerView.g0 g0Var) {
        boolean z = false;
        if (iVar.b == g0Var) {
            iVar.b = null;
        } else {
            if (iVar.a != g0Var) {
                return false;
            }
            iVar.a = null;
            z = true;
        }
        g0Var.f.setAlpha(1.0f);
        g0Var.f.setTranslationX(0.0f);
        g0Var.f.setTranslationY(0.0f);
        C(g0Var, z);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(RecyclerView.g0 g0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        g0Var.f.animate().setInterpolator(s);
        j(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean g(RecyclerView.g0 g0Var, List list) {
        return !list.isEmpty() || super.g(g0Var, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:3:0x0011 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void j(RecyclerView.g0 g0Var) {
        View view = g0Var.f;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.j.get(size)).a == g0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(g0Var);
                this.j.remove(size);
            }
        }
        W(this.k, g0Var);
        if (this.h.remove(g0Var)) {
            view.setAlpha(1.0f);
            G(g0Var);
        }
        if (this.i.remove(g0Var)) {
            view.setAlpha(1.0f);
            A(g0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.n.get(size2);
            W(arrayList, g0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).a == g0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(g0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.l.get(size5);
            if (arrayList3.remove(g0Var)) {
                view.setAlpha(1.0f);
                A(g0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(g0Var);
        this.o.remove(g0Var);
        this.r.remove(g0Var);
        this.p.remove(g0Var);
        V();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:10:0x004f */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:14:0x0073 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:3:0x0008 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k() {
        ArrayList arrayList;
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.j.get(size);
            View view = jVar.a.f;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.a);
            this.j.remove(size);
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.g0) this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.g0 g0Var = (RecyclerView.g0) this.i.get(size3);
            g0Var.f.setAlpha(1.0f);
            A(g0Var);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            arrayList = this.k;
            if (size4 < 0) {
                break;
            } else {
                X((i) arrayList.get(size4));
            }
        }
        arrayList.clear();
        if (p()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList2 = (ArrayList) this.m.get(size5);
                for (int size6 = arrayList2.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList2.get(size6);
                    View view2 = jVar2.a.f;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.a);
                    arrayList2.remove(size6);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(arrayList2);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList3 = (ArrayList) this.l.get(size7);
                for (int size8 = arrayList3.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.g0 g0Var2 = (RecyclerView.g0) arrayList3.get(size8);
                    g0Var2.f.setAlpha(1.0f);
                    A(g0Var2);
                    arrayList3.remove(size8);
                    if (arrayList3.isEmpty()) {
                        this.l.remove(arrayList3);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList4 = (ArrayList) this.n.get(size9);
                for (int size10 = arrayList4.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList4.get(size10));
                    if (arrayList4.isEmpty()) {
                        this.n.remove(arrayList4);
                    }
                }
            }
            U(this.q);
            U(this.p);
            U(this.o);
            U(this.r);
            i();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean p() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void u() {
        boolean zIsEmpty = this.h.isEmpty();
        boolean zIsEmpty2 = this.j.isEmpty();
        boolean zIsEmpty3 = this.k.isEmpty();
        boolean zIsEmpty4 = this.i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            T((RecyclerView.g0) it.next());
        }
        this.h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.j);
            this.m.add(arrayList);
            this.j.clear();
            a aVar = new a(arrayList);
            if (zIsEmpty) {
                aVar.run();
            } else {
                l35.Z(((j) arrayList.get(0)).a.f, aVar, o());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.k);
            this.n.add(arrayList2);
            this.k.clear();
            b bVar = new b(arrayList2);
            if (zIsEmpty) {
                bVar.run();
            } else {
                l35.Z(((i) arrayList2.get(0)).a.f, bVar, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.i);
        this.l.add(arrayList3);
        this.i.clear();
        c cVar = new c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            cVar.run();
        } else {
            l35.Z(((RecyclerView.g0) arrayList3.get(0)).f, cVar, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.q
    public boolean w(RecyclerView.g0 g0Var) {
        Z(g0Var);
        g0Var.f.setAlpha(0.0f);
        this.i.add(g0Var);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.q
    public boolean x(RecyclerView.g0 g0Var, RecyclerView.g0 g0Var2, int i2, int i3, int i4, int i5) {
        if (g0Var == g0Var2) {
            return y(g0Var, i2, i3, i4, i5);
        }
        float translationX = g0Var.f.getTranslationX();
        float translationY = g0Var.f.getTranslationY();
        float alpha = g0Var.f.getAlpha();
        Z(g0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        g0Var.f.setTranslationX(translationX);
        g0Var.f.setTranslationY(translationY);
        g0Var.f.setAlpha(alpha);
        if (g0Var2 != null) {
            Z(g0Var2);
            g0Var2.f.setTranslationX(-i6);
            g0Var2.f.setTranslationY(-i7);
            g0Var2.f.setAlpha(0.0f);
        }
        this.k.add(new i(g0Var, g0Var2, i2, i3, i4, i5));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.q
    public boolean y(RecyclerView.g0 g0Var, int i2, int i3, int i4, int i5) {
        View view = g0Var.f;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) g0Var.f.getTranslationY());
        Z(g0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            E(g0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.j.add(new j(g0Var, translationX, translationY, i4, i5));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.q
    public boolean z(RecyclerView.g0 g0Var) {
        Z(g0Var);
        this.h.add(g0Var);
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i {
        public RecyclerView.g0 a;
        public RecyclerView.g0 b;
        public int c;
        public int d;
        public int e;
        public int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(RecyclerView.g0 g0Var, RecyclerView.g0 g0Var2, int i, int i2, int i3, int i4) {
            this(g0Var, g0Var2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }

        public i(RecyclerView.g0 g0Var, RecyclerView.g0 g0Var2) {
            this.a = g0Var;
            this.b = g0Var2;
        }
    }
}

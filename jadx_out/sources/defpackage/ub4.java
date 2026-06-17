package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import defpackage.ub4;
import defpackage.wp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ub4 {
    public static final a f = new a(null);
    public final ViewGroup a;
    public final List b;
    public final List c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends c {
        public final w61 h;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(c.b bVar, c.a aVar, w61 w61Var, wp wpVar) {
            bVar.getClass();
            aVar.getClass();
            w61Var.getClass();
            wpVar.getClass();
            p51 p51VarK = w61Var.k();
            p51VarK.getClass();
            super(bVar, aVar, p51VarK, wpVar);
            this.h = w61Var;
        }

        @Override // ub4.c
        public void d() {
            super.d();
            this.h.m();
        }

        @Override // ub4.c
        public void m() {
            if (h() != c.a.ADDING) {
                if (h() == c.a.REMOVING) {
                    p51 p51VarK = this.h.k();
                    p51VarK.getClass();
                    View viewZ1 = p51VarK.Z1();
                    viewZ1.getClass();
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewZ1.findFocus() + " on view " + viewZ1 + " for Fragment " + p51VarK);
                    }
                    viewZ1.clearFocus();
                    return;
                }
                return;
            }
            p51 p51VarK2 = this.h.k();
            p51VarK2.getClass();
            View viewFindFocus = p51VarK2.N.findFocus();
            if (viewFindFocus != null) {
                p51VarK2.f2(viewFindFocus);
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + p51VarK2);
                }
            }
            View viewZ12 = g().Z1();
            viewZ12.getClass();
            if (viewZ12.getParent() == null) {
                this.h.b();
                viewZ12.setAlpha(0.0f);
            }
            if (viewZ12.getAlpha() == 0.0f && viewZ12.getVisibility() == 0) {
                viewZ12.setVisibility(4);
            }
            viewZ12.setAlpha(p51VarK2.q0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.a.values().length];
            try {
                iArr[c.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    public ub4(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.a = viewGroup;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public static void a(ub4 ub4Var, b bVar) {
        ub4Var.getClass();
        bVar.getClass();
        if (ub4Var.b.contains(bVar)) {
            c.b bVarF = bVar.f();
            View view = bVar.g().N;
            view.getClass();
            bVarF.b(view);
        }
    }

    public static void b(ub4 ub4Var, b bVar) {
        ub4Var.getClass();
        bVar.getClass();
        ub4Var.b.remove(bVar);
        ub4Var.c.remove(bVar);
    }

    public static final ub4 p(ViewGroup viewGroup, k61 k61Var) {
        return f.a(viewGroup, k61Var);
    }

    public static final ub4 q(ViewGroup viewGroup, wb4 wb4Var) {
        return f.b(viewGroup, wb4Var);
    }

    public final void c(c.b bVar, c.a aVar, w61 w61Var) {
        synchronized (this.b) {
            wp wpVar = new wp();
            p51 p51VarK = w61Var.k();
            p51VarK.getClass();
            c cVarJ = j(p51VarK);
            if (cVarJ != null) {
                cVarJ.l(bVar, aVar);
                return;
            }
            final b bVar2 = new b(bVar, aVar, w61Var, wpVar);
            this.b.add(bVar2);
            bVar2.b(new Runnable() { // from class: sb4
                @Override // java.lang.Runnable
                public final void run() {
                    ub4.a(this.f, bVar2);
                }
            });
            bVar2.b(new Runnable() { // from class: tb4
                @Override // java.lang.Runnable
                public final void run() {
                    ub4.b(this.f, bVar2);
                }
            });
            fw4 fw4Var = fw4.a;
        }
    }

    public final void d(c.b bVar, w61 w61Var) {
        bVar.getClass();
        w61Var.getClass();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + w61Var.k());
        }
        c(bVar, c.a.ADDING, w61Var);
    }

    public final void e(w61 w61Var) {
        w61Var.getClass();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + w61Var.k());
        }
        c(c.b.GONE, c.a.NONE, w61Var);
    }

    public final void f(w61 w61Var) {
        w61Var.getClass();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + w61Var.k());
        }
        c(c.b.REMOVED, c.a.REMOVING, w61Var);
    }

    public final void g(w61 w61Var) {
        w61Var.getClass();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + w61Var.k());
        }
        c(c.b.VISIBLE, c.a.NONE, w61Var);
    }

    public abstract void h(List list, boolean z);

    public final void i() {
        if (this.e) {
            return;
        }
        if (!l35.M(this.a)) {
            l();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    List<c> listC0 = ww.c0(this.c);
                    this.c.clear();
                    for (c cVar : listC0) {
                        if (k61.K0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + cVar);
                        }
                        cVar.c();
                        if (!cVar.j()) {
                            this.c.add(cVar);
                        }
                    }
                    s();
                    List listC02 = ww.c0(this.b);
                    this.b.clear();
                    this.c.addAll(listC02);
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it = listC02.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).m();
                    }
                    h(listC02, this.d);
                    this.d = false;
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final c j(p51 p51Var) {
        Object next;
        Iterator it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            c cVar = (c) next;
            if (il1.a(cVar.g(), p51Var) && !cVar.i()) {
                break;
            }
        }
        return (c) next;
    }

    public final c k(p51 p51Var) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            c cVar = (c) next;
            if (il1.a(cVar.g(), p51Var) && !cVar.i()) {
                break;
            }
        }
        return (c) next;
    }

    public final void l() {
        if (k61.K0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zM = l35.M(this.a);
        synchronized (this.b) {
            try {
                s();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).m();
                }
                for (c cVar : ww.c0(this.c)) {
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zM ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling running operation " + cVar);
                    }
                    cVar.c();
                }
                for (c cVar2 : ww.c0(this.b)) {
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zM ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling pending operation " + cVar2);
                    }
                    cVar2.c();
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m() {
        if (this.e) {
            if (k61.K0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.e = false;
            i();
        }
    }

    public final c.a n(w61 w61Var) {
        w61Var.getClass();
        p51 p51VarK = w61Var.k();
        p51VarK.getClass();
        c cVarJ = j(p51VarK);
        c.a aVarH = cVarJ != null ? cVarJ.h() : null;
        c cVarK = k(p51VarK);
        c.a aVarH2 = cVarK != null ? cVarK.h() : null;
        int i = aVarH == null ? -1 : d.a[aVarH.ordinal()];
        return (i == -1 || i == 1) ? aVarH2 : aVarH;
    }

    public final ViewGroup o() {
        return this.a;
    }

    public final void r() {
        Object objPrevious;
        synchronized (this.b) {
            try {
                s();
                List list = this.b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    c cVar = (c) objPrevious;
                    c.b.a aVar = c.b.f;
                    View view = cVar.g().N;
                    view.getClass();
                    c.b bVarA = aVar.a(view);
                    c.b bVarF = cVar.f();
                    c.b bVar = c.b.VISIBLE;
                    if (bVarF == bVar && bVarA != bVar) {
                        break;
                    }
                }
                c cVar2 = (c) objPrevious;
                p51 p51VarG = cVar2 != null ? cVar2.g() : null;
                this.e = p51VarG != null ? p51VarG.L0() : false;
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        for (c cVar : this.b) {
            if (cVar.h() == c.a.ADDING) {
                View viewZ1 = cVar.g().Z1();
                viewZ1.getClass();
                cVar.l(c.b.f.b(viewZ1.getVisibility()), c.a.NONE);
            }
        }
    }

    public final void t(boolean z) {
        this.d = z;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public b a;
        public a b;
        public final p51 c;
        public final List d;
        public final Set e;
        public boolean f;
        public boolean g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: renamed from: ub4$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public /* synthetic */ class C0123c {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        public c(b bVar, a aVar, p51 p51Var, wp wpVar) {
            bVar.getClass();
            aVar.getClass();
            p51Var.getClass();
            wpVar.getClass();
            this.a = bVar;
            this.b = aVar;
            this.c = p51Var;
            this.d = new ArrayList();
            this.e = new LinkedHashSet();
            wpVar.c(new wp.a() { // from class: vb4
                @Override // wp.a
                public final void onCancel() {
                    ub4.c.a(this.a);
                }
            });
        }

        public static void a(c cVar) {
            cVar.getClass();
            cVar.c();
        }

        public final void b(Runnable runnable) {
            runnable.getClass();
            this.d.add(runnable);
        }

        public final void c() {
            if (this.f) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                d();
                return;
            }
            Iterator it = ww.d0(this.e).iterator();
            while (it.hasNext()) {
                ((wp) it.next()).a();
            }
        }

        public void d() {
            if (this.g) {
                return;
            }
            if (k61.K0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void e(wp wpVar) {
            wpVar.getClass();
            if (this.e.remove(wpVar) && this.e.isEmpty()) {
                d();
            }
        }

        public final b f() {
            return this.a;
        }

        public final p51 g() {
            return this.c;
        }

        public final a h() {
            return this.b;
        }

        public final boolean i() {
            return this.f;
        }

        public final boolean j() {
            return this.g;
        }

        public final void k(wp wpVar) {
            wpVar.getClass();
            m();
            this.e.add(wpVar);
        }

        public final void l(b bVar, a aVar) {
            bVar.getClass();
            aVar.getClass();
            int i = C0123c.a[aVar.ordinal()];
            if (i == 1) {
                if (this.a == b.REMOVED) {
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                    }
                    this.a = b.VISIBLE;
                    this.b = a.ADDING;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                }
                this.a = b.REMOVED;
                this.b = a.REMOVING;
                return;
            }
            if (i == 3 && this.a != b.REMOVED) {
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + bVar + '.');
                }
                this.a = bVar;
            }
        }

        public abstract void m();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.a + " lifecycleImpact = " + this.b + " fragment = " + this.c + '}';
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static final a f = new a(null);

            /* JADX INFO: renamed from: ub4$c$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public /* synthetic */ class C0122b {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            public static final b e(int i) {
                return f.b(i);
            }

            public final void b(View view) {
                view.getClass();
                int i = C0122b.a[ordinal()];
                if (i == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (k61.K0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i == 3) {
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class a {
                public /* synthetic */ a(we0 we0Var) {
                    this();
                }

                public final b a(View view) {
                    view.getClass();
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i) {
                    if (i == 0) {
                        return b.VISIBLE;
                    }
                    if (i == 4) {
                        return b.INVISIBLE;
                    }
                    if (i == 8) {
                        return b.GONE;
                    }
                    defpackage.b.a("Unknown visibility ", i);
                    return null;
                }

                public a() {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final ub4 a(ViewGroup viewGroup, k61 k61Var) {
            viewGroup.getClass();
            k61Var.getClass();
            wb4 wb4VarC0 = k61Var.C0();
            wb4VarC0.getClass();
            return b(viewGroup, wb4VarC0);
        }

        public final ub4 b(ViewGroup viewGroup, wb4 wb4Var) {
            viewGroup.getClass();
            wb4Var.getClass();
            Object tag = viewGroup.getTag(tl3.b);
            if (tag instanceof ub4) {
                return (ub4) tag;
            }
            ub4 ub4VarA = wb4Var.a(viewGroup);
            ub4VarA.getClass();
            viewGroup.setTag(tl3.b, ub4VarA);
            return ub4VarA;
        }

        public a() {
        }
    }
}

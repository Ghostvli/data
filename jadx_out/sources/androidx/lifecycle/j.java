package androidx.lifecycle;

import androidx.lifecycle.g;
import defpackage.at1;
import defpackage.bt1;
import defpackage.ct1;
import defpackage.dt1;
import defpackage.e04;
import defpackage.ee4;
import defpackage.gt1;
import defpackage.qw2;
import defpackage.we0;
import defpackage.yw3;
import defpackage.zz0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j extends g {
    public static final a k = new a(null);
    public final boolean b;
    public zz0 c;
    public g.b d;
    public final WeakReference e;
    public int f;
    public boolean g;
    public boolean h;
    public ArrayList i;
    public final qw2 j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public g.b a;
        public i b;

        public b(at1 at1Var, g.b bVar) {
            bVar.getClass();
            at1Var.getClass();
            this.b = gt1.f(at1Var);
            this.a = bVar;
        }

        public final void a(bt1 bt1Var, g.a aVar) {
            aVar.getClass();
            g.b bVarE = aVar.e();
            this.a = j.k.a(this.a, bVarE);
            i iVar = this.b;
            bt1Var.getClass();
            iVar.c(bt1Var, aVar);
            this.a = bVarE;
        }

        public final g.b b() {
            return this.a;
        }
    }

    public j(bt1 bt1Var, boolean z) {
        this.b = z;
        this.c = new zz0();
        g.b bVar = g.b.g;
        this.d = bVar;
        this.i = new ArrayList();
        this.e = new WeakReference(bt1Var);
        this.j = ee4.a(bVar);
    }

    @Override // androidx.lifecycle.g
    public void a(at1 at1Var) {
        bt1 bt1Var;
        at1Var.getClass();
        f("addObserver");
        g.b bVar = this.d;
        g.b bVar2 = g.b.f;
        if (bVar != bVar2) {
            bVar2 = g.b.g;
        }
        b bVar3 = new b(at1Var, bVar2);
        if (((b) this.c.g(at1Var, bVar3)) == null && (bt1Var = (bt1) this.e.get()) != null) {
            boolean z = this.f != 0 || this.g;
            g.b bVarE = e(at1Var);
            this.f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.c.contains(at1Var)) {
                l(bVar3.b());
                g.a aVarB = g.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    defpackage.d.a("no event up from ", bVar3.b());
                    return;
                } else {
                    bVar3.a(bt1Var, aVarB);
                    k();
                    bVarE = e(at1Var);
                }
            }
            if (!z) {
                n();
            }
            this.f--;
        }
    }

    @Override // androidx.lifecycle.g
    public g.b b() {
        return this.d;
    }

    @Override // androidx.lifecycle.g
    public void c(at1 at1Var) {
        at1Var.getClass();
        f("removeObserver");
        this.c.j(at1Var);
    }

    public final void d(bt1 bt1Var) {
        Iterator itDescendingIterator = this.c.descendingIterator();
        itDescendingIterator.getClass();
        while (itDescendingIterator.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            entry.getClass();
            at1 at1Var = (at1) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.d) > 0 && !this.h && this.c.contains(at1Var)) {
                g.a aVarA = g.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    defpackage.d.a("no event down from ", bVar.b());
                    return;
                } else {
                    l(aVarA.e());
                    bVar.a(bt1Var, aVarA);
                    k();
                }
            }
        }
    }

    public final g.b e(at1 at1Var) {
        b bVar;
        Map.Entry entryK = this.c.k(at1Var);
        g.b bVar2 = null;
        g.b bVarB = (entryK == null || (bVar = (b) entryK.getValue()) == null) ? null : bVar.b();
        if (!this.i.isEmpty()) {
            bVar2 = (g.b) this.i.get(r0.size() - 1);
        }
        a aVar = k;
        return aVar.a(aVar.a(this.d, bVarB), bVar2);
    }

    public final void f(String str) {
        if (!this.b || dt1.a()) {
            return;
        }
        ct1.a("Method ", str, " must be called on the main thread");
    }

    public final void g(bt1 bt1Var) {
        yw3.d dVarD = this.c.d();
        dVarD.getClass();
        while (dVarD.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) dVarD.next();
            at1 at1Var = (at1) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.d) < 0 && !this.h && this.c.contains(at1Var)) {
                l(bVar.b());
                g.a aVarB = g.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    defpackage.d.a("no event up from ", bVar.b());
                    return;
                } else {
                    bVar.a(bt1Var, aVarB);
                    k();
                }
            }
        }
    }

    public void h(g.a aVar) {
        aVar.getClass();
        f("handleLifecycleEvent");
        j(aVar.e());
    }

    public final boolean i() {
        if (this.c.size() == 0) {
            return true;
        }
        Map.Entry entryB = this.c.b();
        entryB.getClass();
        g.b bVarB = ((b) entryB.getValue()).b();
        Map.Entry entryE = this.c.e();
        entryE.getClass();
        g.b bVarB2 = ((b) entryE.getValue()).b();
        return bVarB == bVarB2 && this.d == bVarB2;
    }

    public final void j(g.b bVar) {
        if (this.d == bVar) {
            return;
        }
        k.a((bt1) this.e.get(), this.d, bVar);
        this.d = bVar;
        if (this.g || this.f != 0) {
            this.h = true;
            return;
        }
        this.g = true;
        n();
        this.g = false;
        if (this.d == g.b.f) {
            this.c = new zz0();
        }
    }

    public final void k() {
        this.i.remove(r1.size() - 1);
    }

    public final void l(g.b bVar) {
        this.i.add(bVar);
    }

    public void m(g.b bVar) {
        bVar.getClass();
        f("setCurrentState");
        j(bVar);
    }

    public final void n() {
        bt1 bt1Var = (bt1) this.e.get();
        if (bt1Var == null) {
            e04.a("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
            return;
        }
        while (!i()) {
            this.h = false;
            g.b bVar = this.d;
            Map.Entry entryB = this.c.b();
            entryB.getClass();
            if (bVar.compareTo(((b) entryB.getValue()).b()) < 0) {
                d(bt1Var);
            }
            Map.Entry entryE = this.c.e();
            if (!this.h && entryE != null && this.d.compareTo(((b) entryE.getValue()).b()) > 0) {
                g(bt1Var);
            }
        }
        this.h = false;
        this.j.setValue(b());
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final g.b a(g.b bVar, g.b bVar2) {
            bVar.getClass();
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }

        public a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(bt1 bt1Var) {
        this(bt1Var, true);
        bt1Var.getClass();
    }
}

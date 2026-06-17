package androidx.lifecycle;

import androidx.lifecycle.g;
import defpackage.bt1;
import defpackage.ca;
import defpackage.jl;
import defpackage.wx1;
import defpackage.x43;
import defpackage.yw3;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static final Object k = new Object();
    public final Object a = new Object();
    public yw3 b = new yw3();
    public int c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final Runnable j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (l.this.a) {
                obj = l.this.f;
                l.this.f = l.k;
            }
            l.this.l(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends d {
        public b(x43 x43Var) {
            super(x43Var);
        }

        @Override // androidx.lifecycle.l.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends d implements i {
        public final bt1 j;

        public c(bt1 bt1Var, x43 x43Var) {
            super(x43Var);
            this.j = bt1Var;
        }

        @Override // androidx.lifecycle.l.d
        public void b() {
            this.j.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            g.b bVarB = this.j.getLifecycle().b();
            if (bVarB == g.b.f) {
                l.this.k(this.f);
                return;
            }
            g.b bVar = null;
            while (bVar != bVarB) {
                a(e());
                bVar = bVarB;
                bVarB = this.j.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.l.d
        public boolean d(bt1 bt1Var) {
            return this.j == bt1Var;
        }

        @Override // androidx.lifecycle.l.d
        public boolean e() {
            return this.j.getLifecycle().b().b(g.b.i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public abstract class d {
        public final x43 f;
        public boolean g;
        public int h = -1;

        public d(x43 x43Var) {
            this.f = x43Var;
        }

        public void a(boolean z) {
            if (z == this.g) {
                return;
            }
            this.g = z;
            l.this.b(z ? 1 : -1);
            if (this.g) {
                l.this.d(this);
            }
        }

        public void b() {
        }

        public boolean d(bt1 bt1Var) {
            return false;
        }

        public abstract boolean e();
    }

    public l() {
        Object obj = k;
        this.f = obj;
        this.j = new a();
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        if (ca.g().b()) {
            return;
        }
        wx1.a("Cannot invoke ", str, " on a background thread");
    }

    public void b(int i) {
        int i2 = this.c;
        this.c = i + i2;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i3 = this.c;
                if (i2 == i3) {
                    this.d = false;
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    h();
                } else if (z2) {
                    i();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        }
    }

    public final void c(d dVar) {
        if (dVar.g) {
            if (!dVar.e()) {
                dVar.a(false);
                return;
            }
            int i = dVar.h;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            dVar.h = i2;
            dVar.f.a(this.e);
        }
    }

    public void d(d dVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (dVar != null) {
                c(dVar);
                dVar = null;
            } else {
                yw3.d dVarD = this.b.d();
                while (dVarD.hasNext()) {
                    c((d) ((Map.Entry) dVarD.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object e() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    public void f(bt1 bt1Var, x43 x43Var) {
        a("observe");
        if (bt1Var.getLifecycle().b() == g.b.f) {
            return;
        }
        c cVar = new c(bt1Var, x43Var);
        d dVar = (d) this.b.g(x43Var, cVar);
        if (dVar != null && !dVar.d(bt1Var)) {
            jl.a("Cannot add the same observer with different lifecycles");
        } else {
            if (dVar != null) {
                return;
            }
            bt1Var.getLifecycle().a(cVar);
        }
    }

    public void g(x43 x43Var) {
        a("observeForever");
        b bVar = new b(x43Var);
        d dVar = (d) this.b.g(x43Var, bVar);
        if (dVar instanceof c) {
            jl.a("Cannot add the same observer with different lifecycles");
        } else {
            if (dVar != null) {
                return;
            }
            bVar.a(true);
        }
    }

    public void h() {
    }

    public void i() {
    }

    public void j(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = obj;
        }
        if (z) {
            ca.g().c(this.j);
        }
    }

    public void k(x43 x43Var) {
        a("removeObserver");
        d dVar = (d) this.b.j(x43Var);
        if (dVar == null) {
            return;
        }
        dVar.b();
        dVar.a(false);
    }

    public void l(Object obj) {
        a("setValue");
        this.g++;
        this.e = obj;
        d(null);
    }
}

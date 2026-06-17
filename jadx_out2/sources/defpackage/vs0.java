package defpackage;

import defpackage.bb0;
import defpackage.sz0;
import defpackage.zs0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vs0 implements bb0.b, sz0.f {
    public static final c E = new c();
    public zs0 A;
    public bb0 B;
    public volatile boolean C;
    public boolean D;
    public final e f;
    public final je4 g;
    public final zs0.a h;
    public final tf3 i;
    public final c j;
    public final ws0 k;
    public final ka1 l;
    public final ka1 m;
    public final ka1 n;
    public final ka1 o;
    public final AtomicInteger p;
    public wq1 q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public yr3 v;
    public ba0 w;
    public boolean x;
    public ja1 y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final cs3 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(cs3 cs3Var) {
            this.f = cs3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f.f()) {
                synchronized (vs0.this) {
                    try {
                        if (vs0.this.f.c(this.f)) {
                            vs0.this.e(this.f);
                        }
                        vs0.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        public final cs3 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(cs3 cs3Var) {
            this.f = cs3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f.f()) {
                synchronized (vs0.this) {
                    try {
                        if (vs0.this.f.c(this.f)) {
                            vs0.this.A.a();
                            vs0.this.f(this.f);
                            vs0.this.r(this.f);
                        }
                        vs0.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public zs0 a(yr3 yr3Var, boolean z, wq1 wq1Var, zs0.a aVar) {
            return new zs0(yr3Var, z, true, wq1Var, aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final cs3 a;
        public final Executor b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(cs3 cs3Var, Executor executor) {
            this.a = cs3Var;
            this.b = executor;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vs0(ka1 ka1Var, ka1 ka1Var2, ka1 ka1Var3, ka1 ka1Var4, ws0 ws0Var, zs0.a aVar, tf3 tf3Var, c cVar) {
        this.f = new e();
        this.g = je4.a();
        this.p = new AtomicInteger();
        this.l = ka1Var;
        this.m = ka1Var2;
        this.n = ka1Var3;
        this.o = ka1Var4;
        this.k = ws0Var;
        this.h = aVar;
        this.i = tf3Var;
        this.j = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private synchronized void q() {
        if (this.q == null) {
            throw new IllegalArgumentException();
        }
        this.f.clear();
        this.q = null;
        this.A = null;
        this.v = null;
        this.z = false;
        this.C = false;
        this.x = false;
        this.D = false;
        this.B.A(false);
        this.B = null;
        this.y = null;
        this.w = null;
        this.i.b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void a(cs3 cs3Var, Executor executor) {
        try {
            this.g.c();
            this.f.b(cs3Var, executor);
            if (this.x) {
                k(1);
                executor.execute(new b(cs3Var));
            } else if (this.z) {
                k(1);
                executor.execute(new a(cs3Var));
            } else {
                fg3.b(!this.C, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // bb0.b
    public void b(ja1 ja1Var) {
        synchronized (this) {
            this.y = ja1Var;
        }
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // bb0.b
    public void c(yr3 yr3Var, ba0 ba0Var, boolean z) {
        synchronized (this) {
            this.v = yr3Var;
            this.w = ba0Var;
            this.D = z;
        }
        o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // bb0.b
    public void d(bb0 bb0Var) {
        j().execute(bb0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(cs3 cs3Var) {
        try {
            cs3Var.b(this.y);
        } catch (Throwable th) {
            throw new uo(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(cs3 cs3Var) {
        try {
            cs3Var.c(this.A, this.w, this.D);
        } catch (Throwable th) {
            throw new uo(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // sz0.f
    public je4 g() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        if (m()) {
            return;
        }
        this.C = true;
        this.B.b();
        this.k.b(this, this.q);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        zs0 zs0Var;
        synchronized (this) {
            try {
                this.g.c();
                fg3.b(m(), "Not yet complete!");
                int iDecrementAndGet = this.p.decrementAndGet();
                fg3.b(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    zs0Var = this.A;
                    q();
                } else {
                    zs0Var = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zs0Var != null) {
            zs0Var.g();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ka1 j() {
        return this.s ? this.n : this.t ? this.o : this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void k(int i) {
        zs0 zs0Var;
        fg3.b(m(), "Not yet complete!");
        if (this.p.getAndAdd(i) == 0 && (zs0Var = this.A) != null) {
            zs0Var.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized vs0 l(wq1 wq1Var, boolean z, boolean z2, boolean z3, boolean z4) {
        this.q = wq1Var;
        this.r = z;
        this.s = z2;
        this.t = z3;
        this.u = z4;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m() {
        return this.z || this.x || this.C;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n() {
        synchronized (this) {
            try {
                this.g.c();
                if (this.C) {
                    q();
                    return;
                }
                if (this.f.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.z) {
                    throw new IllegalStateException("Already failed once");
                }
                this.z = true;
                wq1 wq1Var = this.q;
                e<d> eVarD = this.f.d();
                k(eVarD.size() + 1);
                this.k.c(this, wq1Var, null);
                for (d dVar : eVarD) {
                    dVar.b.execute(new a(dVar.a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o() {
        synchronized (this) {
            try {
                this.g.c();
                if (this.C) {
                    this.v.b();
                    q();
                    return;
                }
                if (this.f.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.x) {
                    throw new IllegalStateException("Already have resource");
                }
                this.A = this.j.a(this.v, this.r, this.q, this.h);
                this.x = true;
                e<d> eVarD = this.f.d();
                k(eVarD.size() + 1);
                this.k.c(this, this.q, this.A);
                for (d dVar : eVarD) {
                    dVar.b.execute(new b(dVar.a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void r(cs3 cs3Var) {
        try {
            this.g.c();
            this.f.f(cs3Var);
            if (this.f.isEmpty()) {
                h();
                if (this.x || this.z) {
                    if (this.p.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void s(bb0 bb0Var) {
        try {
            this.B = bb0Var;
            (bb0Var.I() ? this.l : j()).execute(bb0Var);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e implements Iterable {
        public final List f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
            this(new ArrayList(2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static d e(cs3 cs3Var) {
            return new d(cs3Var, sv0.a());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(cs3 cs3Var, Executor executor) {
            this.f.add(new d(cs3Var, executor));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c(cs3 cs3Var) {
            return this.f.contains(e(cs3Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void clear() {
            this.f.clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e d() {
            return new e(new ArrayList(this.f));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(cs3 cs3Var) {
            this.f.remove(e(cs3Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f.iterator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int size() {
            return this.f.size();
        }

        public e(List list) {
            this.f = list;
        }
    }

    public vs0(ka1 ka1Var, ka1 ka1Var2, ka1 ka1Var3, ka1 ka1Var4, ws0 ws0Var, zs0.a aVar, tf3 tf3Var) {
        this(ka1Var, ka1Var2, ka1Var3, ka1Var4, ws0Var, aVar, tf3Var, E);
    }
}

package androidx.media3.session;

import androidx.media3.session.b;
import androidx.media3.session.u;
import defpackage.ac3;
import defpackage.du2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.la;
import defpackage.lu1;
import defpackage.x81;
import defpackage.xi1;
import defpackage.y14;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final WeakReference d;
    public final la b = new la();
    public final la c = new la();
    public final Object a = new Object();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        lu1 run();
    }

    /* JADX INFO: renamed from: androidx.media3.session.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0027b {
        public final Object a;
        public final c0 b;
        public d0 d;
        public hd3.b e;
        public hd3.b f;
        public boolean g;
        public ac3 i;
        public b0 j;
        public final Deque c = new ArrayDeque();
        public hd3.b h = hd3.b.b;

        public C0027b(Object obj, c0 c0Var, d0 d0Var, hd3.b bVar) {
            this.a = obj;
            this.b = c0Var;
            this.d = d0Var;
            this.e = bVar;
        }
    }

    public b(v vVar) {
        this.d = new WeakReference(vVar);
    }

    public static /* synthetic */ void a(b bVar, AtomicBoolean atomicBoolean, C0027b c0027b, AtomicBoolean atomicBoolean2) {
        synchronized (bVar.a) {
            try {
                if (atomicBoolean.get()) {
                    atomicBoolean2.set(true);
                } else {
                    bVar.g(c0027b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void b(final b bVar, a aVar, final AtomicBoolean atomicBoolean, final C0027b c0027b, final AtomicBoolean atomicBoolean2) {
        bVar.getClass();
        aVar.run().g(new Runnable() { // from class: k00
            @Override // java.lang.Runnable
            public final void run() {
                b.a(this.f, atomicBoolean, c0027b, atomicBoolean2);
            }
        }, du2.b());
    }

    public static /* synthetic */ lu1 c(b bVar, u.g gVar, hd3.b bVar2) {
        v vVar = (v) bVar.d.get();
        if (vVar != null) {
            vVar.T0(gVar, bVar2);
        }
        return x81.f();
    }

    public static /* synthetic */ void d(v vVar, u.g gVar) {
        if (vVar.H0()) {
            return;
        }
        vVar.O0(gVar);
    }

    public void e(Object obj, u.g gVar, d0 d0Var, hd3.b bVar) {
        synchronized (this.a) {
            try {
                u.g gVarK = k(obj);
                if (gVarK == null) {
                    this.b.put(obj, gVar);
                    this.c.put(gVar, new C0027b(obj, new c0(), d0Var, bVar));
                } else {
                    C0027b c0027b = (C0027b) gg3.q((C0027b) this.c.get(gVarK));
                    c0027b.d = d0Var;
                    c0027b.e = bVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(u.g gVar, int i, a aVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b != null) {
                    c0027b.h = c0027b.h.b().a(i).f();
                    c0027b.c.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(final C0027b c0027b) {
        v vVar = (v) this.d.get();
        if (vVar == null) {
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            final a aVar = (a) c0027b.c.poll();
            if (aVar == null) {
                c0027b.g = false;
                return;
            }
            final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            final b bVar = this;
            fy4.o1(vVar.e0(), vVar.Q(this.k(c0027b.a), new Runnable() { // from class: j00
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(this.f, aVar, atomicBoolean2, c0027b, atomicBoolean);
                }
            }));
            atomicBoolean2.set(false);
            this = bVar;
        }
    }

    public void h(final u.g gVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b == null) {
                    return;
                }
                final hd3.b bVar = c0027b.h;
                c0027b.h = hd3.b.b;
                c0027b.c.add(new a() { // from class: i00
                    @Override // androidx.media3.session.b.a
                    public final lu1 run() {
                        return b.c(this.a, gVar, bVar);
                    }
                });
                if (c0027b.g) {
                    return;
                }
                c0027b.g = true;
                g(c0027b);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public hd3.b i(u.g gVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b == null) {
                    return null;
                }
                return c0027b.e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public xi1 j() {
        xi1 xi1VarP;
        synchronized (this.a) {
            xi1VarP = xi1.p(this.b.values());
        }
        return xi1VarP;
    }

    public u.g k(Object obj) {
        u.g gVar;
        synchronized (this.a) {
            gVar = (u.g) this.b.get(obj);
        }
        return gVar;
    }

    public ac3 l(u.g gVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b == null) {
                    return null;
                }
                return c0027b.i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b0 m(u.g gVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b == null) {
                    return null;
                }
                return c0027b.j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public c0 n(u.g gVar) {
        C0027b c0027b;
        synchronized (this.a) {
            c0027b = (C0027b) this.c.get(gVar);
        }
        if (c0027b != null) {
            return c0027b.b;
        }
        return null;
    }

    public c0 o(Object obj) {
        C0027b c0027b;
        synchronized (this.a) {
            try {
                u.g gVarK = k(obj);
                c0027b = gVarK != null ? (C0027b) this.c.get(gVarK) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c0027b != null) {
            return c0027b.b;
        }
        return null;
    }

    public boolean p(u.g gVar) {
        boolean z;
        synchronized (this.a) {
            z = this.c.get(gVar) != null;
        }
        return z;
    }

    public boolean q(u.g gVar, int i) {
        C0027b c0027b;
        synchronized (this.a) {
            c0027b = (C0027b) this.c.get(gVar);
        }
        v vVar = (v) this.d.get();
        return c0027b != null && c0027b.e.c(i) && vVar != null && vVar.v0().getAvailableCommands().c(i);
    }

    public boolean r(u.g gVar, int i) {
        C0027b c0027b;
        synchronized (this.a) {
            c0027b = (C0027b) this.c.get(gVar);
        }
        return c0027b != null && c0027b.d.a(i);
    }

    public boolean s(u.g gVar, y14 y14Var) {
        C0027b c0027b;
        synchronized (this.a) {
            c0027b = (C0027b) this.c.get(gVar);
        }
        if (c0027b != null) {
            return c0027b.d.b(y14Var) || androidx.media3.session.a.w(y14Var.b);
        }
        return false;
    }

    public void t(final u.g gVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.remove(gVar);
                if (c0027b == null) {
                    return;
                }
                this.b.remove(c0027b.a);
                c0027b.b.d();
                final v vVar = (v) this.d.get();
                if (vVar == null || vVar.H0()) {
                    return;
                }
                fy4.o1(vVar.e0(), new Runnable() { // from class: h00
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d(vVar, gVar);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u(Object obj) {
        u.g gVarK = k(obj);
        if (gVarK != null) {
            t(gVarK);
        }
    }

    public void v(u.g gVar, ac3 ac3Var, hd3.b bVar) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b != null) {
                    c0027b.i = ac3Var;
                    c0027b.f = bVar;
                    c0027b.j = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w(u.g gVar, b0 b0Var) {
        synchronized (this.a) {
            try {
                C0027b c0027b = (C0027b) this.c.get(gVar);
                if (c0027b != null) {
                    gg3.q(c0027b.i);
                    c0027b.j = b0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

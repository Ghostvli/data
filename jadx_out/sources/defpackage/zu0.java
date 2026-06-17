package defpackage;

import defpackage.gj0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zu0 extends av0 implements gj0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(zu0.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(zu0.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(zu0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a extends c {
        public final qp h;

        public a(long j, qp qpVar) {
            super(j);
            this.h = qpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.h.e(zu0.this, fw4.a);
        }

        @Override // zu0.c
        public String toString() {
            return super.toString() + this.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends c {
        public final Runnable h;

        public b(long j, Runnable runnable) {
            super(j);
            this.h = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.h.run();
        }

        @Override // zu0.c
        public String toString() {
            return super.toString() + this.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c implements Runnable, Comparable, qm0, sn4 {
        private volatile Object _heap;
        public long f;
        public int g = -1;

        public c(long j) {
            this.f = j;
        }

        @Override // defpackage.sn4
        public rn4 b() {
            Object obj = this._heap;
            if (obj instanceof rn4) {
                return (rn4) obj;
            }
            return null;
        }

        @Override // defpackage.qm0
        public final void e() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == cv0.a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.h(this);
                    }
                    this._heap = cv0.a;
                    fw4 fw4Var = fw4.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // defpackage.sn4
        public void f(rn4 rn4Var) {
            if (this._heap != cv0.a) {
                this._heap = rn4Var;
            } else {
                jl.a("Failed requirement.");
            }
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j = this.f - cVar.f;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // defpackage.sn4
        public int getIndex() {
            return this.g;
        }

        public final int h(long j, d dVar, zu0 zu0Var) {
            synchronized (this) {
                if (this._heap == cv0.a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (zu0Var.U()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.c = j;
                        } else {
                            long j2 = cVar.f;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - dVar.c > 0) {
                                dVar.c = j;
                            }
                        }
                        long j3 = this.f;
                        long j4 = dVar.c;
                        if (j3 - j4 < 0) {
                            this.f = j4;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean i(long j) {
            return j - this.f >= 0;
        }

        @Override // defpackage.sn4
        public void setIndex(int i) {
            this.g = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends rn4 {
        public long c;

        public d(long j) {
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U() {
        return m.get(this) != 0;
    }

    public final void A0() {
        sn4 sn4VarI;
        d dVar = (d) l.get(this);
        if (dVar == null || dVar.e()) {
            return;
        }
        g1.a();
        long jNanoTime = System.nanoTime();
        do {
            synchronized (dVar) {
                try {
                    sn4 sn4VarB = dVar.b();
                    if (sn4VarB != null) {
                        c cVar = (c) sn4VarB;
                        sn4VarI = cVar.i(jNanoTime) ? B0(cVar) : false ? dVar.i(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((c) sn4VarI) != null);
    }

    public final boolean B0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (U()) {
                return false;
            }
            if (obj == null) {
                if (z0.a(k, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof uz1) {
                uz1 uz1Var = (uz1) obj;
                int iA = uz1Var.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    z0.a(k, this, obj, uz1Var.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == cv0.b) {
                    return false;
                }
                uz1 uz1Var2 = new uz1(8, true);
                uz1Var2.a((Runnable) obj);
                uz1Var2.a(runnable);
                if (z0.a(k, this, obj, uz1Var2)) {
                    return true;
                }
            }
        }
    }

    @Override // defpackage.gj0
    public void F(long j, qp qpVar) {
        long jC = cv0.c(j);
        if (jC < 4611686018427387903L) {
            g1.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, qpVar);
            I0(jNanoTime, aVar);
            up.a(qpVar, aVar);
        }
    }

    public boolean F0() {
        if (!p0()) {
            return false;
        }
        d dVar = (d) l.get(this);
        if (dVar != null && !dVar.e()) {
            return false;
        }
        Object obj = k.get(this);
        if (obj == null) {
            return true;
        }
        return obj instanceof uz1 ? ((uz1) obj).j() : obj == cv0.b;
    }

    public final void G0() {
        c cVar;
        g1.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) l.get(this);
            if (dVar == null || (cVar = (c) dVar.j()) == null) {
                return;
            } else {
                u0(jNanoTime, cVar);
            }
        }
    }

    public final void H0() {
        k.set(this, null);
        l.set(this, null);
    }

    public final void I0(long j, c cVar) {
        int iJ0 = J0(j, cVar);
        if (iJ0 == 0) {
            if (M0(cVar)) {
                v0();
            }
        } else if (iJ0 == 1) {
            u0(j, cVar);
        } else {
            if (iJ0 == 2) {
                return;
            }
            e04.a("unexpected result");
        }
    }

    public final int J0(long j, c cVar) {
        if (U()) {
            return 1;
        }
        d dVar = (d) l.get(this);
        if (dVar == null) {
            z0.a(l, this, null, new d(j));
            Object obj = l.get(this);
            obj.getClass();
            dVar = (d) obj;
        }
        return cVar.h(j, dVar, this);
    }

    public final qm0 K0(long j, Runnable runnable) {
        long jC = cv0.c(j);
        if (jC >= 4611686018427387903L) {
            return u33.f;
        }
        g1.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        I0(jNanoTime, bVar);
        return bVar;
    }

    public final void L0(boolean z) {
        m.set(this, z ? 1 : 0);
    }

    public final boolean M0(c cVar) {
        d dVar = (d) l.get(this);
        return (dVar != null ? (c) dVar.f() : null) == cVar;
    }

    @Override // defpackage.n40
    public final void c0(g40 g40Var, Runnable runnable) {
        z0(runnable);
    }

    @Override // defpackage.yu0
    public long l0() {
        c cVar;
        if (super.l0() == 0) {
            return 0L;
        }
        Object obj = k.get(this);
        if (obj != null) {
            if (!(obj instanceof uz1)) {
                return obj == cv0.b ? Long.MAX_VALUE : 0L;
            }
            if (!((uz1) obj).j()) {
                return 0L;
            }
        }
        d dVar = (d) l.get(this);
        if (dVar == null || (cVar = (c) dVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j = cVar.f;
        g1.a();
        return xn3.c(j - System.nanoTime(), 0L);
    }

    @Override // defpackage.yu0
    public long q0() {
        if (r0()) {
            return 0L;
        }
        A0();
        Runnable runnableY0 = y0();
        if (runnableY0 == null) {
            return l0();
        }
        runnableY0.run();
        return 0L;
    }

    @Override // defpackage.yu0
    public void shutdown() {
        mn4.a.c();
        L0(true);
        x0();
        while (q0() <= 0) {
        }
        G0();
    }

    public final void x0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (z0.a(k, this, null, cv0.b)) {
                    return;
                }
            } else if (obj instanceof uz1) {
                ((uz1) obj).d();
                return;
            } else {
                if (obj == cv0.b) {
                    return;
                }
                uz1 uz1Var = new uz1(8, true);
                uz1Var.a((Runnable) obj);
                if (z0.a(k, this, obj, uz1Var)) {
                    return;
                }
            }
        }
    }

    public qm0 y(long j, Runnable runnable, g40 g40Var) {
        return gj0.a.a(this, j, runnable, g40Var);
    }

    public final Runnable y0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof uz1) {
                uz1 uz1Var = (uz1) obj;
                Object objM = uz1Var.m();
                if (objM != uz1.h) {
                    return (Runnable) objM;
                }
                z0.a(k, this, obj, uz1Var.l());
            } else {
                if (obj == cv0.b) {
                    return null;
                }
                if (z0.a(k, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void z0(Runnable runnable) {
        A0();
        if (B0(runnable)) {
            v0();
        } else {
            qf0.n.z0(runnable);
        }
    }
}

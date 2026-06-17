package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ht1 extends n40 implements gj0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(ht1.class, "runningWorkers$volatile");
    public final /* synthetic */ gj0 h;
    public final n40 i;
    public final int j;
    public final String k;
    public final tz1 l;
    public final Object m;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements Runnable {
        public Runnable f;

        public a(Runnable runnable) {
            this.f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.f.run();
                } catch (Throwable th) {
                    r40.a(bs0.f, th);
                }
                Runnable runnableK0 = ht1.this.k0();
                if (runnableK0 == null) {
                    return;
                }
                this.f = runnableK0;
                i++;
                if (i >= 16 && ht1.this.i.d0(ht1.this)) {
                    ht1.this.i.c0(ht1.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ht1(n40 n40Var, int i, String str) {
        gj0 gj0Var = n40Var instanceof gj0 ? (gj0) n40Var : null;
        this.h = gj0Var == null ? rf0.a() : gj0Var;
        this.i = n40Var;
        this.j = i;
        this.k = str;
        this.l = new tz1(false);
        this.m = new Object();
    }

    @Override // defpackage.gj0
    public void F(long j, qp qpVar) {
        this.h.F(j, qpVar);
    }

    @Override // defpackage.n40
    public void c0(g40 g40Var, Runnable runnable) {
        Runnable runnableK0;
        this.l.a(runnable);
        if (n.get(this) >= this.j || !l0() || (runnableK0 = k0()) == null) {
            return;
        }
        this.i.c0(this, new a(runnableK0));
    }

    @Override // defpackage.n40
    public n40 f0(int i, String str) {
        it1.a(i);
        return i >= this.j ? it1.b(this, str) : super.f0(i, str);
    }

    public final Runnable k0() {
        while (true) {
            Runnable runnable = (Runnable) this.l.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.m) {
                n.decrementAndGet(this);
                if (this.l.c() == 0) {
                    return null;
                }
                n.incrementAndGet(this);
            }
        }
    }

    public final boolean l0() {
        synchronized (this.m) {
            if (n.get(this) >= this.j) {
                return false;
            }
            n.incrementAndGet(this);
            return true;
        }
    }

    @Override // defpackage.n40
    public String toString() {
        String str = this.k;
        if (str != null) {
            return str;
        }
        return this.i + ".limitedParallelism(" + this.j + ')';
    }

    @Override // defpackage.gj0
    public qm0 y(long j, Runnable runnable, g40 g40Var) {
        return this.h.y(j, runnable, g40Var);
    }
}

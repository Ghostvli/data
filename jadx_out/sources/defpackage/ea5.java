package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ea5 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(ea5.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(ea5.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(ea5.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(ea5.class, "blockingTasksInBuffer$volatile");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final vl4 a(vl4 vl4Var, boolean z) {
        if (z) {
            return b(vl4Var);
        }
        vl4 vl4Var2 = (vl4) b.getAndSet(this, vl4Var);
        if (vl4Var2 == null) {
            return null;
        }
        return b(vl4Var2);
    }

    public final vl4 b(vl4 vl4Var) {
        if (e() == 127) {
            return vl4Var;
        }
        if (vl4Var.g) {
            e.incrementAndGet(this);
        }
        int i = c.get(this) & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, vl4Var);
        c.incrementAndGet(this);
        return null;
    }

    public final void c(vl4 vl4Var) {
        if (vl4Var == null || !vl4Var.g) {
            return;
        }
        e.decrementAndGet(this);
    }

    public final int e() {
        return c.get(this) - d.get(this);
    }

    public final int i() {
        Object obj = b.get(this);
        int iE = e();
        return obj != null ? iE + 1 : iE;
    }

    public final void j(ua1 ua1Var) {
        vl4 vl4Var = (vl4) b.getAndSet(this, null);
        if (vl4Var != null) {
            ua1Var.a(vl4Var);
        }
        while (n(ua1Var)) {
        }
    }

    public final vl4 k() {
        vl4 vl4Var = (vl4) b.getAndSet(this, null);
        return vl4Var == null ? m() : vl4Var;
    }

    public final vl4 l() {
        return o(true);
    }

    public final vl4 m() {
        vl4 vl4Var;
        while (true) {
            int i = d.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (vl4Var = (vl4) this.a.getAndSet(i2, null)) != null) {
                c(vl4Var);
                return vl4Var;
            }
        }
    }

    public final boolean n(ua1 ua1Var) {
        vl4 vl4VarM = m();
        if (vl4VarM == null) {
            return false;
        }
        ua1Var.a(vl4VarM);
        return true;
    }

    public final vl4 o(boolean z) {
        vl4 vl4Var;
        do {
            vl4Var = (vl4) b.get(this);
            if (vl4Var == null || vl4Var.g != z) {
                int i = d.get(this);
                int i2 = c.get(this);
                while (i != i2) {
                    if (z && e.get(this) == 0) {
                        return null;
                    }
                    i2--;
                    vl4 vl4VarQ = q(i2, z);
                    if (vl4VarQ != null) {
                        return vl4VarQ;
                    }
                }
                return null;
            }
        } while (!z0.a(b, this, vl4Var, null));
        return vl4Var;
    }

    public final vl4 p(int i) {
        int i2 = d.get(this);
        int i3 = c.get(this);
        boolean z = i == 1;
        while (i2 != i3) {
            if (z && e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            vl4 vl4VarQ = q(i2, z);
            if (vl4VarQ != null) {
                return vl4VarQ;
            }
            i2 = i4;
        }
        return null;
    }

    public final vl4 q(int i, boolean z) {
        int i2 = i & 127;
        vl4 vl4Var = (vl4) this.a.get(i2);
        if (vl4Var == null || vl4Var.g != z || !fs.a(this.a, i2, vl4Var, null)) {
            return null;
        }
        if (z) {
            e.decrementAndGet(this);
        }
        return vl4Var;
    }

    public final long r(int i, mp3 mp3Var) {
        vl4 vl4VarM = i == 3 ? m() : p(i);
        if (vl4VarM == null) {
            return s(i, mp3Var);
        }
        mp3Var.f = vl4VarM;
        return -1L;
    }

    public final long s(int i, mp3 mp3Var) {
        vl4 vl4Var;
        do {
            vl4Var = (vl4) b.get(this);
            if (vl4Var == null) {
                return -2L;
            }
            if (((vl4Var.g ? 1 : 2) & i) == 0) {
                return -2L;
            }
            long jA = zl4.f.a() - vl4Var.f;
            long j = zl4.b;
            if (jA < j) {
                return j - jA;
            }
        } while (!z0.a(b, this, vl4Var, null));
        mp3Var.f = vl4Var;
        return -1L;
    }
}

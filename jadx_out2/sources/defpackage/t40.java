package defpackage;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class t40 implements Executor, Closeable {
    public static final a m = new a(null);
    public static final /* synthetic */ AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(t40.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater o = AtomicLongFieldUpdater.newUpdater(t40.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater p = AtomicIntegerFieldUpdater.newUpdater(t40.class, "_isTerminated$volatile");
    public static final qj4 q = new qj4("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int f;
    public final int g;
    public final long h;
    public final String i;
    public final ua1 j;
    public final ua1 k;
    public final wr3 l;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static final d f = new d("CPU_ACQUIRED", 0);
        public static final d g = new d("BLOCKING", 1);
        public static final d h = new d("PARKING", 2);
        public static final d i = new d("DORMANT", 3);
        public static final d j = new d("TERMINATED", 4);
        public static final /* synthetic */ d[] k;
        public static final /* synthetic */ gt0 l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            d[] dVarArrA = a();
            k = dVarArrA;
            l = ht0.a(dVarArrA);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(String str, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static final /* synthetic */ d[] a() {
            return new d[]{f, g, h, i, j};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static d[] values() {
            return (d[]) k.clone();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t40(int i, int i2, long j, String str) {
        this.f = i;
        this.g = i2;
        this.h = j;
        this.i = str;
        if (i < 1) {
            i04.a("Core pool size ", i, " should be at least 1");
            throw null;
        }
        if (i2 < i) {
            ux4.a("Max pool size ", i2, " should be greater than or equals to core pool size ", i);
            throw null;
        }
        if (i2 > 2097150) {
            i04.a("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150");
            throw null;
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.j = new ua1();
        this.k = new ua1();
        this.l = new wr3((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
        this._isTerminated$volatile = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean V(t40 t40Var, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = o.get(t40Var);
        }
        return t40Var.U(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void v(t40 t40Var, Runnable runnable, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        t40Var.u(runnable, z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [t40.c.b(vl4):void, t40.c.p():boolean, t40.c.p():boolean, t40.c.r(t40$d):boolean, t40.c.s(int):vl4, t40.c.t():void, t40.c.t():void, t40.Q(long):void] */
    public static final /* synthetic */ AtomicLongFieldUpdater y() {
        return o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int J(c cVar) {
        Object objG = cVar.g();
        while (objG != q) {
            if (objG == null) {
                return 0;
            }
            c cVar2 = (c) objG;
            int iF = cVar2.f();
            if (iF != 0) {
                return iF;
            }
            objG = cVar2.g();
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c M() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = n;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.l.b((int) (2097151 & j));
            if (cVar == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int iJ = this.J(cVar);
            if (iJ >= 0) {
                t40 t40Var = this;
                if (n.compareAndSet(t40Var, j, ((long) iJ) | j2)) {
                    cVar.o(q);
                    return cVar;
                }
                this = t40Var;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean N(c cVar) {
        if (cVar.g() != q) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = n;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int iF = cVar.f();
            cVar.o(this.l.b((int) (2097151 & j)));
            long j2 = ((2097152 + j) & (-2097152)) | ((long) iF);
            t40 t40Var = this;
            if (n.compareAndSet(t40Var, j, j2)) {
                return true;
            }
            this = t40Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O(c cVar, int i, int i2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = n;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int iJ = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iJ == i) {
                iJ = i2 == 0 ? this.J(cVar) : i2;
            }
            if (iJ >= 0) {
                t40 t40Var = this;
                if (n.compareAndSet(t40Var, j, j2 | ((long) iJ))) {
                    return;
                } else {
                    this = t40Var;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P(vl4 vl4Var) {
        try {
            vl4Var.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                g1.a();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(long j) throws InterruptedException {
        int i;
        vl4 vl4VarE;
        if (p.compareAndSet(this, 0, 1)) {
            c cVarT = t();
            synchronized (this.l) {
                i = (int) (y().get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object objB = this.l.b(i2);
                    objB.getClass();
                    c cVar = (c) objB;
                    if (cVar != cVarT) {
                        while (cVar.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(cVar);
                            cVar.join(j);
                        }
                        cVar.f.j(this.k);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.k.b();
            this.j.b();
            while (true) {
                if (cVarT == null) {
                    vl4VarE = (vl4) this.j.e();
                    if (vl4VarE == null && (vl4VarE = (vl4) this.k.e()) == null) {
                        break;
                    }
                } else {
                    vl4VarE = cVarT.e(true);
                    if (vl4VarE != null) {
                        continue;
                    }
                }
                P(vl4VarE);
            }
            if (cVarT != null) {
                cVarT.r(d.j);
            }
            n.set(this, 0L);
            o.set(this, 0L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R(long j, boolean z) {
        if (z || W() || U(j)) {
            return;
        }
        W();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S() {
        if (W() || V(this, 0L, 1, null)) {
            return;
        }
        W();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final vl4 T(c cVar, vl4 vl4Var, boolean z) {
        d dVar;
        if (cVar == null || (dVar = cVar.h) == d.j) {
            return vl4Var;
        }
        if (!vl4Var.g && dVar == d.g) {
            return vl4Var;
        }
        cVar.l = true;
        return cVar.f.a(vl4Var, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean U(long j) {
        if (xn3.b(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f) {
            int iH = h();
            if (iH == 1 && this.f > 1) {
                h();
            }
            if (iH > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean W() {
        c cVarM;
        do {
            cVarM = M();
            if (cVarM == null) {
                return false;
            }
        } while (!c.n.compareAndSet(cVarM, -1, 0));
        LockSupport.unpark(cVarM);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean c(vl4 vl4Var) {
        return vl4Var.g ? this.k.a(vl4Var) : this.j.a(vl4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        Q(10000L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        v(this, runnable, false, false, 6, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int h() {
        synchronized (this.l) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j = o.get(this);
                int i = (int) (j & 2097151);
                int iB = xn3.b(i - ((int) ((j & 4398044413952L) >> 21)), 0);
                if (iB >= this.f) {
                    return 0;
                }
                if (i >= this.g) {
                    return 0;
                }
                int i2 = ((int) (y().get(this) & 2097151)) + 1;
                if (i2 <= 0 || this.l.b(i2) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i2);
                this.l.c(i2, cVar);
                if (i2 != ((int) (2097151 & o.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i3 = iB + 1;
                cVar.start();
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isTerminated() {
        return p.get(this) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final vl4 l(Runnable runnable, boolean z) {
        long jA = zl4.f.a();
        if (!(runnable instanceof vl4)) {
            return zl4.b(runnable, jA, z);
        }
        vl4 vl4Var = (vl4) runnable;
        vl4Var.f = jA;
        vl4Var.g = z;
        return vl4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c t() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !il1.a(t40.this, this)) {
            return null;
        }
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: r10v1, 100 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: r10v1, 98 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: r10v1, 99 */
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.l.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            c cVar = (c) this.l.b(i6);
            if (cVar != null) {
                int i7 = cVar.f.i();
                int i8 = b.a[cVar.h.ordinal()];
                if (i8 == 1) {
                    i3++;
                } else if (i8 == 2) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (i8 != 5) {
                        throw new j33();
                    }
                    i5++;
                }
            }
        }
        long j = o.get(this);
        return this.i + '@' + ua0.b(this) + "[Pool Size {core = " + this.f + ", max = " + this.g + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.j.c() + ", global blocking queue size = " + this.k.c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(Runnable runnable, boolean z, boolean z2) {
        g1.a();
        vl4 vl4VarL = l(runnable, z);
        boolean z3 = vl4VarL.g;
        long jAddAndGet = z3 ? o.addAndGet(this, 2097152L) : 0L;
        c cVarT = t();
        vl4 vl4VarT = T(cVarT, vl4VarL, z2);
        if (vl4VarT != null && !c(vl4VarT)) {
            throw new RejectedExecutionException(this.i + " was terminated");
        }
        boolean z4 = z2 && cVarT != null;
        if (z3) {
            R(jAddAndGet, z4);
        } else {
            if (z4) {
                return;
            }
            S();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: t40.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");
        public final ea5 f;
        public final mp3 g;
        public d h;
        public long i;
        private volatile int indexInArray;
        public long j;
        public int k;
        public boolean l;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
            setDaemon(true);
            setContextClassLoader(t40.this.getClass().getClassLoader());
            this.f = new ea5();
            this.g = new mp3();
            this.h = d.i;
            this.nextParkedWorker = t40.q;
            int iNanoTime = (int) System.nanoTime();
            this.k = iNanoTime == 0 ? 42 : iNanoTime;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b(vl4 vl4Var) {
            this.i = 0L;
            if (this.h == d.h) {
                this.h = d.g;
            }
            if (!vl4Var.g) {
                t40.this.P(vl4Var);
                return;
            }
            if (r(d.g)) {
                t40.this.S();
            }
            t40.this.P(vl4Var);
            t40.y().addAndGet(t40.this, -2097152L);
            if (this.h != d.j) {
                this.h = d.i;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final vl4 c(boolean z) {
            vl4 vl4VarL;
            vl4 vl4VarL2;
            if (z) {
                boolean z2 = j(t40.this.f * 2) == 0;
                if (z2 && (vl4VarL2 = l()) != null) {
                    return vl4VarL2;
                }
                vl4 vl4VarK = this.f.k();
                if (vl4VarK != null) {
                    return vl4VarK;
                }
                if (!z2 && (vl4VarL = l()) != null) {
                    return vl4VarL;
                }
            } else {
                vl4 vl4VarL3 = l();
                if (vl4VarL3 != null) {
                    return vl4VarL3;
                }
            }
            return s(3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final vl4 d() {
            vl4 vl4VarL = this.f.l();
            return (vl4VarL == null && (vl4VarL = (vl4) t40.this.k.e()) == null) ? s(1) : vl4VarL;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final vl4 e(boolean z) {
            return p() ? c(z) : d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int f() {
            return this.indexInArray;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Object g() {
            return this.nextParkedWorker;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean i() {
            return this.nextParkedWorker != t40.q;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int j(int i) {
            int i2 = this.k;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.k = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void k() {
            if (this.i == 0) {
                this.i = System.nanoTime() + t40.this.h;
            }
            LockSupport.parkNanos(t40.this.h);
            if (System.nanoTime() - this.i >= 0) {
                this.i = 0L;
                t();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final vl4 l() {
            int iJ = j(2);
            t40 t40Var = t40.this;
            if (iJ == 0) {
                vl4 vl4Var = (vl4) t40Var.j.e();
                return vl4Var != null ? vl4Var : (vl4) t40.this.k.e();
            }
            vl4 vl4Var2 = (vl4) t40Var.k.e();
            return vl4Var2 != null ? vl4Var2 : (vl4) t40.this.j.e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m() {
            loop0: while (true) {
                boolean z = false;
                while (!t40.this.isTerminated() && this.h != d.j) {
                    vl4 vl4VarE = e(this.l);
                    if (vl4VarE != null) {
                        this.j = 0L;
                        b(vl4VarE);
                    } else {
                        this.l = false;
                        if (this.j == 0) {
                            q();
                        } else if (z) {
                            r(d.h);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.j);
                            this.j = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            r(d.j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void n(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(t40.this.i);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean p() {
            long j;
            if (this.h == d.f) {
                return true;
            }
            t40 t40Var = t40.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterY = t40.y();
            do {
                j = atomicLongFieldUpdaterY.get(t40Var);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!t40.y().compareAndSet(t40Var, j, j - 4398046511104L));
            this.h = d.f;
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void q() {
            if (!i()) {
                t40.this.N(this);
                return;
            }
            n.set(this, -1);
            while (i() && n.get(this) == -1 && !t40.this.isTerminated() && this.h != d.j) {
                r(d.h);
                Thread.interrupted();
                k();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean r(d dVar) {
            d dVar2 = this.h;
            boolean z = dVar2 == d.f;
            if (z) {
                t40.y().addAndGet(t40.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.h = dVar;
            }
            return z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final vl4 s(int i) {
            int i2 = (int) (t40.y().get(t40.this) & 2097151);
            if (i2 < 2) {
                return null;
            }
            int iJ = j(i2);
            t40 t40Var = t40.this;
            long jMin = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                iJ++;
                if (iJ > i2) {
                    iJ = 1;
                }
                c cVar = (c) t40Var.l.b(iJ);
                if (cVar != null && cVar != this) {
                    long jR = cVar.f.r(i, this.g);
                    if (jR == -1) {
                        mp3 mp3Var = this.g;
                        vl4 vl4Var = (vl4) mp3Var.f;
                        mp3Var.f = null;
                        return vl4Var;
                    }
                    if (jR > 0) {
                        jMin = Math.min(jMin, jR);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.j = jMin;
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void t() {
            t40 t40Var = t40.this;
            synchronized (t40Var.l) {
                try {
                    if (t40Var.isTerminated()) {
                        return;
                    }
                    if (((int) (t40.y().get(t40Var) & 2097151)) <= t40Var.f) {
                        return;
                    }
                    if (n.compareAndSet(this, -1, 1)) {
                        int i = this.indexInArray;
                        n(0);
                        t40Var.O(this, i, 0);
                        int andDecrement = (int) (t40.y().getAndDecrement(t40Var) & 2097151);
                        if (andDecrement != i) {
                            Object objB = t40Var.l.b(andDecrement);
                            objB.getClass();
                            c cVar = (c) objB;
                            t40Var.l.c(i, cVar);
                            cVar.n(i);
                            t40Var.O(cVar, andDecrement, i);
                        }
                        t40Var.l.c(andDecrement, null);
                        fw4 fw4Var = fw4.a;
                        this.h = d.j;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(t40 t40Var, int i) {
            this();
            n(i);
        }
    }
}

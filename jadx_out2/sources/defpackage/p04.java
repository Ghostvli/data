package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class p04 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(p04.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(p04.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(p04.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(p04.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(p04.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    public final int f;
    public final Function3 g;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class a extends t81 implements Function2 {
        public static final a f = new a();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            super(2, r04.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        /* JADX DEBUG: Class process forced to load method for inline: r04.c(long, s04):s04 */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final s04 e(long j, s04 s04Var) {
            return r04.j(j, s04Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e(((Number) obj).longValue(), (s04) obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class b extends t81 implements Function2 {
        public static final b f = new b();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            super(2, r04.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final s04 e(long j, s04 s04Var) {
            return r04.j(j, s04Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e(((Number) obj).longValue(), (s04) obj2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p04(int i2, int i3) {
        this.f = i2;
        if (i2 <= 0) {
            vx4.a("Semaphore should have at least 1 permit, but had ", i2);
            throw null;
        }
        if (i3 < 0 || i3 > i2) {
            vx4.a("The number of acquired permits should be in 0..", i2);
            throw null;
        }
        s04 s04Var = new s04(0L, null, 2);
        this.head$volatile = s04Var;
        this.tail$volatile = s04Var;
        this._availablePermits$volatile = i2 - i3;
        this.g = new Function3() { // from class: o04
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return p04.d(this.f, (Throwable) obj, (fw4) obj2, (g40) obj3);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 d(p04 p04Var, Throwable th, fw4 fw4Var, g40 g40Var) {
        p04Var.release();
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int a() {
        return Math.max(l.get(this), 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object b(f30 f30Var) {
        if (k() > 0) {
            return fw4.a;
        }
        Object objG = g(f30Var);
        return objG == kl1.e() ? objG : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(qp qpVar) {
        while (k() <= 0) {
            qpVar.getClass();
            if (i((f85) qpVar)) {
                return;
            }
        }
        qpVar.i(fw4.a, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object g(f30 f30Var) {
        sp spVarB = up.b(jl1.c(f30Var));
        try {
            if (!i(spVarB)) {
                f(spVarB);
            }
            Object objY = spVarB.y();
            if (objY == kl1.e()) {
                ta0.c(f30Var);
            }
            return objY == kl1.e() ? objY : fw4.a;
        } catch (Throwable th) {
            spVarB.N();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i(f85 f85Var) {
        Object objC;
        s04 s04Var = (s04) j.get(this);
        long andIncrement = k.getAndIncrement(this);
        a aVar = a.f;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        long j2 = andIncrement / ((long) r04.f);
        loop0: while (true) {
            objC = zy.c(s04Var, j2, aVar);
            if (!h04.c(objC)) {
                f04 f04VarB = h04.b(objC);
                while (true) {
                    f04 f04Var = (f04) atomicReferenceFieldUpdater.get(this);
                    if (f04Var.c >= f04VarB.c) {
                        break loop0;
                    }
                    if (!f04VarB.u()) {
                        break;
                    }
                    if (z0.a(atomicReferenceFieldUpdater, this, f04Var, f04VarB)) {
                        if (f04Var.p()) {
                            f04Var.n();
                        }
                    } else if (f04VarB.p()) {
                        f04VarB.n();
                    }
                }
            } else {
                break;
            }
        }
        s04 s04Var2 = (s04) h04.b(objC);
        int i2 = (int) (andIncrement % ((long) r04.f));
        if (fs.a(s04Var2.v(), i2, null, f85Var)) {
            f85Var.a(s04Var2, i2);
            return true;
        }
        if (fs.a(s04Var2.v(), i2, r04.b, r04.c)) {
            if (f85Var instanceof qp) {
                f85Var.getClass();
                ((qp) f85Var).i(fw4.a, this.g);
                return true;
            }
            rn1.a("unexpected: ", f85Var);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        int i2;
        do {
            i2 = l.get(this);
            if (i2 <= this.f) {
                return;
            }
        } while (!l.compareAndSet(this, i2, this.f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int k() {
        int andDecrement;
        do {
            andDecrement = l.getAndDecrement(this);
        } while (andDecrement > this.f);
        return andDecrement;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean q() {
        while (true) {
            int i2 = l.get(this);
            if (i2 > this.f) {
                j();
            } else {
                if (i2 <= 0) {
                    return false;
                }
                if (l.compareAndSet(this, i2, i2 - 1)) {
                    return true;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean r(Object obj) {
        if (!(obj instanceof qp)) {
            rn1.a("unexpected: ", obj);
            return false;
        }
        qp qpVar = (qp) obj;
        Object objK = qpVar.k(fw4.a, null, this.g);
        if (objK == null) {
            return false;
        }
        qpVar.m(objK);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void release() {
        do {
            int andIncrement = l.getAndIncrement(this);
            if (andIncrement >= this.f) {
                j();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!s());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean s() {
        Object objC;
        s04 s04Var = (s04) h.get(this);
        long andIncrement = i.getAndIncrement(this);
        long j2 = andIncrement / ((long) r04.f);
        b bVar = b.f;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        loop0: while (true) {
            objC = zy.c(s04Var, j2, bVar);
            if (h04.c(objC)) {
                break;
            }
            f04 f04VarB = h04.b(objC);
            while (true) {
                f04 f04Var = (f04) atomicReferenceFieldUpdater.get(this);
                if (f04Var.c >= f04VarB.c) {
                    break loop0;
                }
                if (!f04VarB.u()) {
                    break;
                }
                if (z0.a(atomicReferenceFieldUpdater, this, f04Var, f04VarB)) {
                    if (f04Var.p()) {
                        f04Var.n();
                    }
                } else if (f04VarB.p()) {
                    f04VarB.n();
                }
            }
        }
        s04 s04Var2 = (s04) h04.b(objC);
        s04Var2.c();
        if (s04Var2.c > j2) {
            return false;
        }
        int i2 = (int) (andIncrement % ((long) r04.f));
        Object andSet = s04Var2.v().getAndSet(i2, r04.b);
        if (andSet != null) {
            if (andSet == r04.e) {
                return false;
            }
            return r(andSet);
        }
        int i3 = r04.a;
        for (int i4 = 0; i4 < i3; i4++) {
            if (s04Var2.v().get(i2) == r04.c) {
                return true;
            }
        }
        return !fs.a(s04Var2.v(), i2, r04.b, r04.d);
    }
}

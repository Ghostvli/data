package defpackage;

import defpackage.kt3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class yl implements or {
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(yl.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(yl.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(yl.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater l = AtomicLongFieldUpdater.newUpdater(yl.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(yl.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(yl.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(yl.class, Object.class, "bufferEndSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(yl.class, Object.class, "_closeCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater q = AtomicReferenceFieldUpdater.newUpdater(yl.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final int f;
    public final Function1 g;
    public final Function3 h;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements bs, f85 {
        public Object f = zl.p;
        public sp g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.f85
        public void a(f04 f04Var, int i) {
            sp spVar = this.g;
            if (spVar != null) {
                spVar.a(f04Var, i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.bs
        public Object b(f30 f30Var) throws Throwable {
            gs gsVarI;
            boolean zG = true;
            if (this.f == zl.p || this.f == zl.z()) {
                yl ylVar = yl.this;
                gs gsVar = (gs) yl.R().get(ylVar);
                while (true) {
                    if (ylVar.f0()) {
                        zG = g();
                        break;
                    }
                    long andIncrement = yl.S().getAndIncrement(ylVar);
                    int i = zl.b;
                    long j = andIncrement / ((long) i);
                    int i2 = (int) (andIncrement % ((long) i));
                    if (gsVar.c != j) {
                        gsVarI = ylVar.I(j, gsVar);
                        if (gsVarI == null) {
                            continue;
                        }
                    } else {
                        gsVarI = gsVar;
                    }
                    Object objL0 = ylVar.L0(gsVarI, i2, andIncrement, null);
                    if (objL0 == zl.m) {
                        e04.a("unreachable");
                        return null;
                    }
                    if (objL0 == zl.o) {
                        if (andIncrement < ylVar.X()) {
                            gsVarI.c();
                        }
                        gsVar = gsVarI;
                    } else {
                        if (objL0 == zl.n) {
                            return f(gsVarI, i2, andIncrement, f30Var);
                        }
                        gsVarI.c();
                        this.f = objL0;
                    }
                }
            }
            return hl.a(zG);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Object f(gs gsVar, int i, long j, f30 f30Var) {
            Boolean boolA;
            Function1 function1;
            gs gsVar2;
            yl ylVar = yl.this;
            sp spVarB = up.b(jl1.c(f30Var));
            try {
                this.g = spVarB;
                Object objL0 = ylVar.L0(gsVar, i, j, this);
                if (objL0 == zl.m) {
                    ylVar.w0(this, gsVar, i);
                } else {
                    Function3 function3W = null;
                    if (objL0 == zl.o) {
                        if (j < ylVar.X()) {
                            gsVar.c();
                        }
                        gs gsVar3 = (gs) yl.R().get(ylVar);
                        while (true) {
                            if (ylVar.f0()) {
                                h();
                                break;
                            }
                            long andIncrement = yl.S().getAndIncrement(ylVar);
                            int i2 = zl.b;
                            long j2 = andIncrement / ((long) i2);
                            int i3 = (int) (andIncrement % ((long) i2));
                            if (gsVar3.c != j2) {
                                gs gsVarI = ylVar.I(j2, gsVar3);
                                if (gsVarI != null) {
                                    gsVar2 = gsVarI;
                                }
                            } else {
                                gsVar2 = gsVar3;
                            }
                            objL0 = ylVar.L0(gsVar2, i3, andIncrement, this);
                            gs gsVar4 = gsVar2;
                            if (objL0 == zl.m) {
                                ylVar.w0(this, gsVar4, i3);
                                break;
                            }
                            if (objL0 == zl.o) {
                                if (andIncrement < ylVar.X()) {
                                    gsVar4.c();
                                }
                                gsVar3 = gsVar4;
                            } else {
                                if (objL0 == zl.n) {
                                    throw new IllegalStateException("unexpected");
                                }
                                gsVar4.c();
                                this.f = objL0;
                                this.g = null;
                                boolA = hl.a(true);
                                function1 = ylVar.g;
                                if (function1 != null) {
                                }
                            }
                        }
                        spVarB.i(boolA, function3W);
                    } else {
                        gsVar.c();
                        this.f = objL0;
                        this.g = null;
                        boolA = hl.a(true);
                        function1 = ylVar.g;
                        if (function1 != null) {
                            function3W = ylVar.w(function1, objL0);
                        }
                        spVarB.i(boolA, function3W);
                    }
                }
                Object objY = spVarB.y();
                if (objY == kl1.e()) {
                    ta0.c(f30Var);
                }
                return objY;
            } catch (Throwable th) {
                spVarB.N();
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean g() throws Throwable {
            this.f = zl.z();
            Throwable thN = yl.this.N();
            if (thN == null) {
                return false;
            }
            throw nd4.a(thN);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            sp spVar = this.g;
            spVar.getClass();
            this.g = null;
            this.f = zl.z();
            Throwable thN = yl.this.N();
            if (thN == null) {
                kt3.a aVar = kt3.g;
                spVar.resumeWith(kt3.b(Boolean.FALSE));
            } else {
                kt3.a aVar2 = kt3.g;
                spVar.resumeWith(kt3.b(lt3.a(thN)));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean i(Object obj) {
            sp spVar = this.g;
            spVar.getClass();
            this.g = null;
            this.f = obj;
            Boolean bool = Boolean.TRUE;
            yl ylVar = yl.this;
            Function1 function1 = ylVar.g;
            return zl.B(spVar, bool, function1 != null ? ylVar.w(function1, obj) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void j() {
            sp spVar = this.g;
            spVar.getClass();
            this.g = null;
            this.f = zl.z();
            Throwable thN = yl.this.N();
            if (thN == null) {
                kt3.a aVar = kt3.g;
                spVar.resumeWith(kt3.b(Boolean.FALSE));
            } else {
                kt3.a aVar2 = kt3.g;
                spVar.resumeWith(kt3.b(lt3.a(thN)));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.bs
        public Object next() throws Throwable {
            Object obj = this.f;
            if (obj == zl.p) {
                e04.a("`hasNext()` has not been invoked");
                return null;
            }
            this.f = zl.p;
            if (obj != zl.z()) {
                return obj;
            }
            throw nd4.a(yl.this.Q());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class b extends t81 implements Function3 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Object obj) {
            super(3, obj, yl.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e(Throwable th, Object obj, g40 g40Var) throws IllegalAccessException, InvocationTargetException {
            ((yl) this.receiver).q0(th, obj, g40Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws IllegalAccessException, InvocationTargetException {
            e((Throwable) obj, obj2, (g40) obj3);
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yl(int i2, Function1 function1) {
        this.f = i2;
        this.g = function1;
        if (i2 < 0) {
            i04.a("Invalid channel capacity: ", i2, ", should be >=0");
            throw null;
        }
        this.bufferEnd$volatile = zl.A(i2);
        this.completedExpandBuffersAndPauseFlag$volatile = L();
        gs gsVar = new gs(0L, null, this, 3);
        this.sendSegment$volatile = gsVar;
        this.receiveSegment$volatile = gsVar;
        if (k0()) {
            gsVar = zl.a;
            gsVar.getClass();
        }
        this.bufferEndSegment$volatile = gsVar;
        this.h = function1 != null ? new Function3() { // from class: vl
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                yl ylVar = this.f;
                w82.a(obj);
                return yl.c(ylVar, null, obj2, obj3);
            }
        } : null;
        this._closeCause$volatile = zl.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object C0(yl ylVar, Object obj, f30 f30Var) throws IllegalAccessException, InvocationTargetException {
        gs gsVar;
        gs gsVar2 = (gs) V().get(ylVar);
        while (true) {
            long andIncrement = W().getAndIncrement(ylVar);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zI0 = ylVar.i0(andIncrement);
            int i2 = zl.b;
            long j3 = j2 / ((long) i2);
            int i3 = (int) (j2 % ((long) i2));
            if (gsVar2.c != j3) {
                gs gsVarJ = ylVar.J(j3, gsVar2);
                if (gsVarJ != null) {
                    gsVar = gsVarJ;
                } else if (zI0) {
                    Object objS0 = ylVar.s0(obj, f30Var);
                    if (objS0 == kl1.e()) {
                        return objS0;
                    }
                }
            } else {
                gsVar = gsVar2;
            }
            yl ylVar2 = ylVar;
            Object obj2 = obj;
            int iN0 = ylVar2.N0(gsVar, i3, obj2, j2, null, zI0);
            if (iN0 == 0) {
                gsVar.c();
                break;
            }
            if (iN0 == 1) {
                break;
            }
            if (iN0 != 2) {
                if (iN0 == 3) {
                    Object objD0 = ylVar2.D0(gsVar, i3, obj2, j2, f30Var);
                    if (objD0 == kl1.e()) {
                        return objD0;
                    }
                } else if (iN0 != 4) {
                    if (iN0 == 5) {
                        gsVar.c();
                    }
                    ylVar = ylVar2;
                    gsVar2 = gsVar;
                    obj = obj2;
                } else {
                    if (j2 < ylVar2.T()) {
                        gsVar.c();
                    }
                    Object objS02 = ylVar2.s0(obj2, f30Var);
                    if (objS02 == kl1.e()) {
                        return objS02;
                    }
                }
            } else if (zI0) {
                gsVar.t();
                Object objS03 = ylVar2.s0(obj2, f30Var);
                if (objS03 == kl1.e()) {
                    return objS03;
                }
            }
        }
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [yl.a.b(f30):java.lang.Object, yl.a.f(gs, int, long, f30):java.lang.Object] */
    public static final /* synthetic */ AtomicReferenceFieldUpdater R() {
        return n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [yl.a.b(f30):java.lang.Object, yl.a.f(gs, int, long, f30):java.lang.Object] */
    public static final /* synthetic */ AtomicLongFieldUpdater S() {
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [yl.C0(yl, java.lang.Object, f30):java.lang.Object, yl.D0(gs, int, java.lang.Object, long, f30):java.lang.Object, yl.H0(java.lang.Object):java.lang.Object, yl.I0(java.lang.Object):java.lang.Object] */
    public static final /* synthetic */ AtomicReferenceFieldUpdater V() {
        return m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [yl.C0(yl, java.lang.Object, f30):java.lang.Object, yl.D0(gs, int, java.lang.Object, long, f30):java.lang.Object, yl.H0(java.lang.Object):java.lang.Object, yl.I0(java.lang.Object):java.lang.Object] */
    public static final /* synthetic */ AtomicLongFieldUpdater W() {
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 a(Object obj, yl ylVar, l04 l04Var, Throwable th, Object obj2, g40 g40Var) throws IllegalAccessException, InvocationTargetException {
        if (obj != zl.z()) {
            p63.a(ylVar.g, obj, l04Var.getContext());
        }
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b0(yl ylVar, long j2, int i2, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
            return;
        }
        if ((i2 & 1) != 0) {
            j2 = 1;
        }
        ylVar.a0(j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Function3 c(final yl ylVar, final l04 l04Var, Object obj, final Object obj2) {
        return new Function3(obj2, ylVar, l04Var) { // from class: xl
            public final /* synthetic */ Object f;
            public final /* synthetic */ yl g;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return yl.a(this.f, this.g, null, (Throwable) obj3, obj4, (g40) obj5);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 e(Function1 function1, Object obj, Throwable th, Object obj2, g40 g40Var) throws IllegalAccessException, InvocationTargetException {
        p63.a(function1, obj, g40Var);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gs A() {
        Object obj = o.get(this);
        gs gsVar = (gs) m.get(this);
        if (gsVar.c > ((gs) obj).c) {
            obj = gsVar;
        }
        gs gsVar2 = (gs) n.get(this);
        if (gsVar2.c > ((gs) obj).c) {
            obj = gsVar2;
        }
        return (gs) zy.b((az) obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A0(f85 f85Var) {
        B0(f85Var, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B(Throwable th, boolean z) {
        if (z) {
            m0();
        }
        boolean zA = z0.a(p, this, zl.s, th);
        if (z) {
            n0();
        } else {
            o0();
        }
        E();
        r0();
        if (zA) {
            c0();
        }
        return zA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B0(f85 f85Var, boolean z) {
        if (f85Var instanceof qp) {
            f30 f30Var = (f30) f85Var;
            kt3.a aVar = kt3.g;
            f30Var.resumeWith(kt3.b(lt3.a(z ? Q() : U())));
        } else if (f85Var instanceof a) {
            ((a) f85Var).j();
        } else {
            rn1.a("Unexpected waiter: ", f85Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(long j2) throws IllegalAccessException, InvocationTargetException {
        y0(D(j2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gs D(long j2) {
        gs gsVarA = A();
        if (j0()) {
            long jL0 = l0(gsVarA);
            if (jL0 != -1) {
                F(jL0);
            }
        }
        z(gsVarA, j2);
        return gsVarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object D0(gs gsVar, int i2, Object obj, long j2, f30 f30Var) {
        fw4 fw4Var;
        Object objY;
        sp spVarB = up.b(jl1.c(f30Var));
        try {
            int iN0 = N0(gsVar, i2, obj, j2, spVarB, false);
            if (iN0 == 0) {
                gsVar.c();
                kt3.a aVar = kt3.g;
                fw4Var = fw4.a;
            } else {
                if (iN0 != 1) {
                    if (iN0 != 2) {
                        if (iN0 != 4) {
                            if (iN0 != 5) {
                                throw new IllegalStateException("unexpected");
                            }
                            gsVar.c();
                            gs gsVar2 = (gs) V().get(this);
                            while (true) {
                                long andIncrement = W().getAndIncrement(this);
                                long j3 = 1152921504606846975L & andIncrement;
                                boolean zI0 = i0(andIncrement);
                                int i3 = zl.b;
                                long j4 = j3 / ((long) i3);
                                int i4 = (int) (j3 % ((long) i3));
                                if (gsVar2.c != j4) {
                                    gs gsVarJ = J(j4, gsVar2);
                                    if (gsVarJ != null) {
                                        gsVar2 = gsVarJ;
                                    } else if (zI0) {
                                        break;
                                    }
                                }
                                int iN02 = N0(gsVar2, i4, obj, j3, spVarB, zI0);
                                if (iN02 == 0) {
                                    gsVar2.c();
                                    kt3.a aVar2 = kt3.g;
                                    fw4Var = fw4.a;
                                    break;
                                }
                                if (iN02 == 1) {
                                    kt3.a aVar3 = kt3.g;
                                    fw4Var = fw4.a;
                                    break;
                                }
                                if (iN02 != 2) {
                                    if (iN02 == 3) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    if (iN02 != 4) {
                                        if (iN02 == 5) {
                                            gsVar2.c();
                                        }
                                    } else if (j3 < T()) {
                                        gsVar2.c();
                                    }
                                } else if (zI0) {
                                    gsVar2.t();
                                } else {
                                    sp spVar = spVarB != null ? spVarB : null;
                                    if (spVar != null) {
                                        x0(spVar, gsVar2, i4);
                                    }
                                }
                            }
                        } else if (j2 < T()) {
                            gsVar.c();
                        }
                        t0(obj, spVarB);
                    } else {
                        x0(spVarB, gsVar, i2);
                    }
                    objY = spVarB.y();
                    if (objY == kl1.e()) {
                        ta0.c(f30Var);
                    }
                    return objY != kl1.e() ? objY : fw4.a;
                }
                kt3.a aVar4 = kt3.g;
                fw4Var = fw4.a;
            }
            spVarB.resumeWith(kt3.b(fw4Var));
            objY = spVarB.y();
            if (objY == kl1.e()) {
            }
            if (objY != kl1.e()) {
            }
        } catch (Throwable th) {
            spVarB.N();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E() {
        h0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E0(long j2) {
        if (i0(j2)) {
            return false;
        }
        return !x(j2 & 1152921504606846975L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(long j2) {
        gs gsVar;
        xv4 xv4VarC;
        gs gsVar2 = (gs) n.get(this);
        while (true) {
            long j3 = j.get(this);
            if (j2 < Math.max(((long) this.f) + j3, this.L())) {
                return;
            }
            yl ylVar = this;
            if (j.compareAndSet(ylVar, j3, 1 + j3)) {
                int i2 = zl.b;
                long j4 = j3 / ((long) i2);
                int i3 = (int) (j3 % ((long) i2));
                if (gsVar2.c != j4) {
                    gs gsVarI = ylVar.I(j4, gsVar2);
                    if (gsVarI != null) {
                        gsVar = gsVarI;
                    }
                } else {
                    gsVar = gsVar2;
                }
                Object objL0 = ylVar.L0(gsVar, i3, j3, null);
                if (objL0 != zl.o) {
                    gsVar.c();
                    Function1 function1 = ylVar.g;
                    if (function1 != null && (xv4VarC = p63.c(function1, objL0, null, 2, null)) != null) {
                        throw xv4VarC;
                    }
                } else if (j3 < ylVar.X()) {
                    gsVar.c();
                }
                this = ylVar;
                gsVar2 = gsVar;
            }
            this = ylVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean F0(Object obj, Object obj2) {
        if (obj instanceof a) {
            return ((a) obj).i(obj2);
        }
        if (!(obj instanceof qp)) {
            rn1.a("Unexpected receiver type: ", obj);
            return false;
        }
        qp qpVar = (qp) obj;
        Function1 function1 = this.g;
        return zl.B(qpVar, obj2, (Function3) (function1 != null ? v(function1) : null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G() {
        yl ylVar;
        if (k0()) {
            return;
        }
        gs gsVar = (gs) o.get(this);
        while (true) {
            long andIncrement = k.getAndIncrement(this);
            int i2 = zl.b;
            long j2 = andIncrement / ((long) i2);
            if (this.X() <= andIncrement) {
                if (gsVar.c < j2 && gsVar.f() != null) {
                    this.p0(j2, gsVar);
                }
                b0(this, 0L, 1, null);
                return;
            }
            if (gsVar.c != j2) {
                ylVar = this;
                gs gsVarH = ylVar.H(j2, gsVar, andIncrement);
                if (gsVarH == null) {
                    continue;
                    this = ylVar;
                } else {
                    gsVar = gsVarH;
                }
            } else {
                ylVar = this;
            }
            if (ylVar.J0(gsVar, (int) (andIncrement % ((long) i2)), andIncrement)) {
                b0(ylVar, 0L, 1, null);
                return;
            } else {
                b0(ylVar, 0L, 1, null);
                this = ylVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G0(Object obj, gs gsVar, int i2) {
        if (obj instanceof qp) {
            return zl.C((qp) obj, fw4.a, null, 2, null);
        }
        rn1.a("Unexpected waiter: ", obj);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gs H(long j2, gs gsVar, long j3) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
        Function2 function2 = (Function2) zl.y();
        loop0: while (true) {
            objC = zy.c(gsVar, j2, function2);
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
        if (h04.c(objC)) {
            E();
            p0(j2, gsVar);
            b0(this, 0L, 1, null);
            return null;
        }
        gs gsVar2 = (gs) h04.b(objC);
        if (gsVar2.c <= j2) {
            return gsVar2;
        }
        long j4 = gsVar2.c;
        int i2 = zl.b;
        if (k.compareAndSet(this, j3 + 1, j4 * ((long) i2))) {
            a0((gsVar2.c * ((long) i2)) - j3);
        } else {
            b0(this, 0L, 1, null);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object H0(Object obj) {
        Object obj2;
        int i2;
        gs gsVar;
        yl ylVar;
        if (E0(i.get(this))) {
            return es.a.b();
        }
        Object obj3 = zl.j;
        gs gsVar2 = (gs) V().get(this);
        while (true) {
            long andIncrement = W().getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zI0 = this.i0(andIncrement);
            int i3 = zl.b;
            long j3 = j2 / ((long) i3);
            int i4 = (int) (j2 % ((long) i3));
            if (gsVar2.c != j3) {
                gs gsVarJ = this.J(j3, gsVar2);
                if (gsVarJ != null) {
                    i2 = i4;
                    gsVar = gsVarJ;
                    ylVar = this;
                    obj2 = obj;
                } else if (zI0) {
                    return es.a.a(this.U());
                }
            } else {
                obj2 = obj;
                i2 = i4;
                gsVar = gsVar2;
                ylVar = this;
            }
            int iN0 = ylVar.N0(gsVar, i2, obj2, j2, obj3, zI0);
            yl ylVar2 = ylVar;
            gsVar2 = gsVar;
            if (iN0 == 0) {
                gsVar2.c();
                return es.a.c(fw4.a);
            }
            if (iN0 == 1) {
                return es.a.c(fw4.a);
            }
            if (iN0 == 2) {
                if (zI0) {
                    gsVar2.t();
                    return es.a.a(ylVar2.U());
                }
                f85 f85Var = obj3 instanceof f85 ? (f85) obj3 : null;
                if (f85Var != null) {
                    ylVar2.x0(f85Var, gsVar2, i2);
                }
                gsVar2.t();
                return es.a.b();
            }
            if (iN0 == 3) {
                e04.a("unexpected");
                return null;
            }
            if (iN0 == 4) {
                if (j2 < ylVar2.T()) {
                    gsVar2.c();
                }
                return es.a.a(ylVar2.U());
            }
            if (iN0 == 5) {
                gsVar2.c();
            }
            this = ylVar2;
            obj = obj2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gs I(long j2, gs gsVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
        Function2 function2 = (Function2) zl.y();
        loop0: while (true) {
            objC = zy.c(gsVar, j2, function2);
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
        if (h04.c(objC)) {
            E();
            if (gsVar.c * ((long) zl.b) < X()) {
                gsVar.c();
            }
            return null;
        }
        gs gsVar2 = (gs) h04.b(objC);
        if (!k0() && j2 <= L() / ((long) zl.b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = o;
            while (true) {
                f04 f04Var2 = (f04) atomicReferenceFieldUpdater2.get(this);
                if (f04Var2.c >= gsVar2.c || !gsVar2.u()) {
                    break;
                }
                if (z0.a(atomicReferenceFieldUpdater2, this, f04Var2, gsVar2)) {
                    if (f04Var2.p()) {
                        f04Var2.n();
                    }
                } else if (gsVar2.p()) {
                    gsVar2.n();
                }
            }
        }
        long j3 = gsVar2.c;
        if (j3 <= j2) {
            return gsVar2;
        }
        int i2 = zl.b;
        P0(j3 * ((long) i2));
        if (gsVar2.c * ((long) i2) < X()) {
            gsVar2.c();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object I0(Object obj) {
        gs gsVarJ;
        int i2;
        yl ylVar;
        Object obj2 = zl.d;
        gs gsVar = (gs) V().get(this);
        while (true) {
            long andIncrement = W().getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zI0 = this.i0(andIncrement);
            int i3 = zl.b;
            long j3 = j2 / ((long) i3);
            int i4 = (int) (j2 % ((long) i3));
            if (gsVar.c != j3) {
                gsVarJ = this.J(j3, gsVar);
                if (gsVarJ != null) {
                    ylVar = this;
                    i2 = i4;
                } else if (zI0) {
                    return es.a.a(this.U());
                }
            } else {
                gsVarJ = gsVar;
                i2 = i4;
                ylVar = this;
            }
            Object obj3 = obj;
            int iN0 = ylVar.N0(gsVarJ, i2, obj3, j2, obj2, zI0);
            yl ylVar2 = ylVar;
            gsVar = gsVarJ;
            if (iN0 == 0) {
                gsVar.c();
                return es.a.c(fw4.a);
            }
            if (iN0 == 1) {
                return es.a.c(fw4.a);
            }
            if (iN0 == 2) {
                if (zI0) {
                    gsVar.t();
                    return es.a.a(ylVar2.U());
                }
                f85 f85Var = obj2 instanceof f85 ? (f85) obj2 : null;
                if (f85Var != null) {
                    ylVar2.x0(f85Var, gsVar, i2);
                }
                ylVar2.F((gsVar.c * ((long) i3)) + ((long) i2));
                return es.a.c(fw4.a);
            }
            if (iN0 == 3) {
                e04.a("unexpected");
                return null;
            }
            if (iN0 == 4) {
                if (j2 < ylVar2.T()) {
                    gsVar.c();
                }
                return es.a.a(ylVar2.U());
            }
            if (iN0 == 5) {
                gsVar.c();
            }
            this = ylVar2;
            obj = obj3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gs J(long j2, gs gsVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        Function2 function2 = (Function2) zl.y();
        loop0: while (true) {
            objC = zy.c(gsVar, j2, function2);
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
        if (h04.c(objC)) {
            E();
            if (gsVar.c * ((long) zl.b) < T()) {
                gsVar.c();
            }
            return null;
        }
        gs gsVar2 = (gs) h04.b(objC);
        long j3 = gsVar2.c;
        if (j3 <= j2) {
            return gsVar2;
        }
        int i2 = zl.b;
        Q0(j3 * ((long) i2));
        if (gsVar2.c * ((long) i2) < T()) {
            gsVar2.c();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J0(gs gsVar, int i2, long j2) {
        Object objB = gsVar.B(i2);
        if (!(objB instanceof f85) || j2 < j.get(this) || !gsVar.v(i2, objB, zl.g)) {
            return K0(gsVar, i2, j2);
        }
        if (G0(objB, gsVar, i2)) {
            gsVar.F(i2, zl.d);
            return true;
        }
        gsVar.F(i2, zl.j);
        gsVar.C(i2, false);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean K0(gs gsVar, int i2, long j2) {
        while (true) {
            Object objB = gsVar.B(i2);
            if (objB instanceof f85) {
                if (j2 < j.get(this)) {
                    if (gsVar.v(i2, objB, new g85((f85) objB))) {
                        return true;
                    }
                } else if (gsVar.v(i2, objB, zl.g)) {
                    if (G0(objB, gsVar, i2)) {
                        gsVar.F(i2, zl.d);
                        return true;
                    }
                    gsVar.F(i2, zl.j);
                    gsVar.C(i2, false);
                    return false;
                }
            } else {
                if (objB == zl.j) {
                    return false;
                }
                if (objB == null) {
                    if (gsVar.v(i2, objB, zl.e)) {
                        return true;
                    }
                } else {
                    if (objB == zl.d || objB == zl.h || objB == zl.i || objB == zl.k || objB == zl.z()) {
                        return true;
                    }
                    if (objB != zl.f) {
                        rn1.a("Unexpected cell state: ", objB);
                        return false;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long L() {
        return k.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object L0(gs gsVar, int i2, long j2, Object obj) {
        Object objB = gsVar.B(i2);
        if (objB == null) {
            if (j2 >= (i.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return zl.n;
                }
                if (gsVar.v(i2, objB, obj)) {
                    G();
                    return zl.m;
                }
            }
        } else if (objB == zl.d && gsVar.v(i2, objB, zl.i)) {
            G();
            return gsVar.D(i2);
        }
        return M0(gsVar, i2, j2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object M0(gs gsVar, int i2, long j2, Object obj) {
        while (true) {
            Object objB = gsVar.B(i2);
            if (objB == null || objB == zl.e) {
                if (j2 < (i.get(this) & 1152921504606846975L)) {
                    if (gsVar.v(i2, objB, zl.h)) {
                        G();
                        return zl.o;
                    }
                } else {
                    if (obj == null) {
                        return zl.n;
                    }
                    if (gsVar.v(i2, objB, obj)) {
                        G();
                        return zl.m;
                    }
                }
            } else {
                if (objB != zl.d) {
                    if (objB != zl.j && objB != zl.h) {
                        if (objB == zl.z()) {
                            G();
                            return zl.o;
                        }
                        if (objB != zl.g && gsVar.v(i2, objB, zl.f)) {
                            boolean z = objB instanceof g85;
                            if (z) {
                                objB = ((g85) objB).a;
                            }
                            if (G0(objB, gsVar, i2)) {
                                gsVar.F(i2, zl.i);
                                G();
                                return gsVar.D(i2);
                            }
                            gsVar.F(i2, zl.j);
                            gsVar.C(i2, false);
                            if (z) {
                                G();
                            }
                            return zl.o;
                        }
                    }
                    return zl.o;
                }
                if (gsVar.v(i2, objB, zl.i)) {
                    G();
                    return gsVar.D(i2);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Throwable N() {
        return (Throwable) p.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int N0(gs gsVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        gsVar.G(i2, obj);
        if (z) {
            return O0(gsVar, i2, obj, j2, obj2, z);
        }
        Object objB = gsVar.B(i2);
        if (objB == null) {
            if (x(j2)) {
                if (gsVar.v(i2, null, zl.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (gsVar.v(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objB instanceof f85) {
            gsVar.w(i2);
            if (F0(objB, obj)) {
                gsVar.F(i2, zl.i);
                u0();
                return 0;
            }
            if (gsVar.x(i2, zl.k) == zl.k) {
                return 5;
            }
            gsVar.C(i2, true);
            return 5;
        }
        return O0(gsVar, i2, obj, j2, obj2, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int O0(gs gsVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object objB = gsVar.B(i2);
            if (objB == null) {
                if (!x(j2) || z) {
                    if (z) {
                        if (gsVar.v(i2, null, zl.j)) {
                            gsVar.C(i2, false);
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (gsVar.v(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (gsVar.v(i2, null, zl.d)) {
                    return 1;
                }
            } else {
                if (objB != zl.e) {
                    if (objB == zl.k) {
                        gsVar.w(i2);
                        return 5;
                    }
                    if (objB == zl.h) {
                        gsVar.w(i2);
                        return 5;
                    }
                    if (objB == zl.z()) {
                        gsVar.w(i2);
                        E();
                        return 4;
                    }
                    gsVar.w(i2);
                    if (objB instanceof g85) {
                        objB = ((g85) objB).a;
                    }
                    if (F0(objB, obj)) {
                        gsVar.F(i2, zl.i);
                        u0();
                        return 0;
                    }
                    if (gsVar.x(i2, zl.k) != zl.k) {
                        gsVar.C(i2, true);
                    }
                    return 5;
                }
                if (gsVar.v(i2, objB, zl.d)) {
                    return 1;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P0(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = j;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            if (j3 >= j2) {
                return;
            }
            yl ylVar = this;
            long j4 = j2;
            if (j.compareAndSet(ylVar, j3, j4)) {
                return;
            }
            this = ylVar;
            j2 = j4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Throwable Q() {
        Throwable thN = N();
        return thN == null ? new cv("Channel was closed") : thN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q0(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            long j4 = 1152921504606846975L & j3;
            if (j4 >= j2) {
                return;
            }
            yl ylVar = this;
            if (i.compareAndSet(ylVar, j3, zl.w(j4, (int) (j3 >> 60)))) {
                return;
            } else {
                this = ylVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R0(long j2) {
        yl ylVar = this;
        if (ylVar.k0()) {
            return;
        }
        while (ylVar.L() <= j2) {
            ylVar = this;
        }
        int i2 = zl.c;
        for (int i3 = 0; i3 < i2; i3++) {
            long jL = ylVar.L();
            if (jL == (4611686018427387903L & l.get(ylVar)) && jL == ylVar.L()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = l;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(ylVar);
            if (atomicLongFieldUpdater.compareAndSet(ylVar, j3, zl.v(j3 & 4611686018427387903L, true))) {
                break;
            } else {
                ylVar = this;
            }
        }
        while (true) {
            long jL2 = ylVar.L();
            long j4 = l.get(ylVar);
            long j5 = j4 & 4611686018427387903L;
            boolean z = (4611686018427387904L & j4) != 0;
            if (jL2 == j5 && jL2 == ylVar.L()) {
                break;
            }
            if (z) {
                ylVar = this;
            } else {
                ylVar = this;
                l.compareAndSet(ylVar, j4, zl.v(j5, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = l;
        while (true) {
            long j6 = atomicLongFieldUpdater2.get(ylVar);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(ylVar, j6, zl.v(j6 & 4611686018427387903L, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            ylVar = this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long T() {
        return j.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Throwable U() {
        Throwable thN = N();
        return thN == null ? new dv("Channel was closed") : thN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long X() {
        return i.get(this) & 1152921504606846975L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Z() {
        while (true) {
            gs gsVarI = (gs) n.get(this);
            long jT = T();
            if (X() <= jT) {
                return false;
            }
            int i2 = zl.b;
            long j2 = jT / ((long) i2);
            if (gsVarI.c == j2 || (gsVarI = I(j2, gsVarI)) != null) {
                gsVarI.c();
                if (d0(gsVarI, (int) (jT % ((long) i2)), jT)) {
                    return true;
                }
                j.compareAndSet(this, jT, 1 + jT);
            } else if (((gs) n.get(this)).c < j2) {
                return false;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a0(long j2) {
        if ((l.addAndGet(this, j2) & 4611686018427387904L) != 0) {
            while ((l.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t04
    public Object b(Object obj, f30 f30Var) {
        return C0(this, obj, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!z0.a(atomicReferenceFieldUpdater, this, obj, obj == null ? zl.q : zl.r));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(N());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t04
    public boolean d(Throwable th) {
        return B(th, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean d0(gs gsVar, int i2, long j2) {
        Object objB;
        do {
            objB = gsVar.B(i2);
            if (objB != null && objB != zl.e) {
                if (objB == zl.d) {
                    return true;
                }
                if (objB == zl.j || objB == zl.z() || objB == zl.i || objB == zl.h) {
                    return false;
                }
                if (objB == zl.g) {
                    return true;
                }
                return objB != zl.f && j2 == T();
            }
        } while (!gsVar.v(i2, objB, zl.h));
        G();
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e0(long j2, boolean z) throws IllegalAccessException, InvocationTargetException {
        int i2 = (int) (j2 >> 60);
        if (i2 == 0 || i2 == 1) {
            return false;
        }
        if (i2 == 2) {
            D(j2 & 1152921504606846975L);
            return (z && Z()) ? false : true;
        }
        if (i2 == 3) {
            C(j2 & 1152921504606846975L);
            return true;
        }
        vs3.a("unexpected close status: ", i2);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f0() {
        return g0(i.get(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g0(long j2) {
        return e0(j2, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oo3
    public final void h(CancellationException cancellationException) {
        y(cancellationException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h0() {
        return i0(i.get(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i0(long j2) {
        return e0(j2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oo3
    public bs iterator() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j0() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k0() {
        long jL = L();
        return jL == 0 || jL == Long.MAX_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:3:0x0004 */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (defpackage.gs) r8.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long l0(gs gsVar) {
        do {
            int i2 = zl.b;
            while (true) {
                i2--;
                if (-1 >= i2) {
                    break;
                }
                long j2 = (gsVar.c * ((long) zl.b)) + ((long) i2);
                if (j2 < T()) {
                    return -1L;
                }
                while (true) {
                    Object objB = gsVar.B(i2);
                    if (objB == null || objB == zl.e) {
                        if (gsVar.v(i2, objB, zl.z())) {
                            gsVar.t();
                            break;
                        }
                    } else if (objB == zl.d) {
                        return j2;
                    }
                }
            }
        } while (gsVar != null);
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            if (((int) (j2 >> 60)) != 0) {
                return;
            }
            yl ylVar = this;
            if (atomicLongFieldUpdater.compareAndSet(ylVar, j2, zl.w(1152921504606846975L & j2, 1))) {
                return;
            } else {
                this = ylVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            yl ylVar = this;
            if (atomicLongFieldUpdater.compareAndSet(ylVar, j2, zl.w(1152921504606846975L & j2, 3))) {
                return;
            } else {
                this = ylVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o0() {
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            int i2 = (int) (j2 >> 60);
            if (i2 == 0) {
                jW = zl.w(1152921504606846975L & j2, 2);
            } else if (i2 != 1) {
                return;
            } else {
                jW = zl.w(1152921504606846975L & j2, 3);
            }
            yl ylVar = this;
            if (atomicLongFieldUpdater.compareAndSet(ylVar, j2, jW)) {
                return;
            } else {
                this = ylVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p0(long j2, gs gsVar) {
        gs gsVar2;
        gs gsVar3;
        while (gsVar.c < j2 && (gsVar3 = (gs) gsVar.f()) != null) {
            gsVar = gsVar3;
        }
        while (true) {
            if (!gsVar.k() || (gsVar2 = (gs) gsVar.f()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
                while (true) {
                    f04 f04Var = (f04) atomicReferenceFieldUpdater.get(this);
                    if (f04Var.c >= gsVar.c) {
                        return;
                    }
                    if (!gsVar.u()) {
                        break;
                    }
                    if (z0.a(atomicReferenceFieldUpdater, this, f04Var, gsVar)) {
                        if (f04Var.p()) {
                            f04Var.n();
                            return;
                        }
                        return;
                    } else if (gsVar.p()) {
                        gsVar.n();
                    }
                }
            } else {
                gsVar = gsVar2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(Throwable th, Object obj, g40 g40Var) throws IllegalAccessException, InvocationTargetException {
        Function1 function1 = this.g;
        function1.getClass();
        p63.a(function1, obj, g40Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object s0(Object obj, f30 f30Var) throws IllegalAccessException, InvocationTargetException {
        xv4 xv4VarC;
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        Function1 function1 = this.g;
        if (function1 == null || (xv4VarC = p63.c(function1, obj, null, 2, null)) == null) {
            Throwable thU = U();
            kt3.a aVar = kt3.g;
            spVar.resumeWith(kt3.b(lt3.a(thU)));
        } else {
            mv0.a(xv4VarC, U());
            kt3.a aVar2 = kt3.g;
            spVar.resumeWith(kt3.b(lt3.a(xv4VarC)));
        }
        Object objY = spVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY == kl1.e() ? objY : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0(Object obj, qp qpVar) throws IllegalAccessException, InvocationTargetException {
        Function1 function1 = this.g;
        if (function1 != null) {
            p63.a(function1, obj, qpVar.getContext());
        }
        Throwable thU = U();
        kt3.a aVar = kt3.g;
        qpVar.resumeWith(kt3.b(lt3.a(thU)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: gs[] */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a1, code lost:
    
        r3 = (defpackage.gs) r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01a8, code lost:
    
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        int i2 = (int) (i.get(this) >> 60);
        if (i2 == 2) {
            sb.append("closed,");
        } else if (i2 == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.f + ',');
        sb.append("data=[");
        int i3 = 0;
        List listM = ow.m(n.get(this), m.get(this), o.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((gs) obj) != zl.a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            bo.a();
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j2 = ((gs) next).c;
            do {
                Object next2 = it.next();
                long j3 = ((gs) next2).c;
                if (j2 > j3) {
                    next = next2;
                    j2 = j3;
                }
            } while (it.hasNext());
        }
        gs gsVar = (gs) next;
        long jT = T();
        long jX = X();
        loop2: while (true) {
            int i4 = zl.b;
            int i5 = i3;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                long j4 = (gsVar.c * ((long) zl.b)) + ((long) i5);
                if (j4 >= jX && j4 >= jT) {
                    break loop2;
                }
                Object objB = gsVar.B(i5);
                Object objA = gsVar.A(i5);
                if (objB instanceof qp) {
                    string = (j4 >= jT || j4 < jX) ? (j4 >= jX || j4 < jT) ? "cont" : "send" : "receive";
                } else if (objB instanceof g85) {
                    string = "EB(" + objB + ')';
                } else if (il1.a(objB, zl.f) || il1.a(objB, zl.g)) {
                    string = "resuming_sender";
                } else if (objB == null || il1.a(objB, zl.e) || il1.a(objB, zl.i) || il1.a(objB, zl.h) || il1.a(objB, zl.k) || il1.a(objB, zl.j) || il1.a(objB, zl.z())) {
                    i5++;
                } else {
                    string = objB.toString();
                }
                if (objA != null) {
                    sb.append("(" + string + ',' + objA + "),");
                } else {
                    sb.append(string + ',');
                }
                i5++;
            }
            i3 = 0;
        }
        if (yg4.S0(sb) == ',') {
            sb.deleteCharAt(sb.length() - 1).getClass();
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final np1 v(Function1 function1) {
        return new b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Function3 w(final Function1 function1, final Object obj) {
        return new Function3() { // from class: wl
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return yl.e(function1, obj, (Throwable) obj2, obj3, (g40) obj4);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w0(f85 f85Var, gs gsVar, int i2) {
        v0();
        f85Var.a(gsVar, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x(long j2) {
        return j2 < L() || j2 < T() + ((long) this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x0(f85 f85Var, gs gsVar, int i2) {
        f85Var.a(gsVar, i2 + zl.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean y(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return B(th, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (defpackage.gs) r12.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y0(gs gsVar) throws IllegalAccessException, InvocationTargetException {
        Function1 function1 = this.g;
        xv4 xv4VarB = null;
        Object objB = ck1.b(null, 1, null);
        loop0: do {
            int i2 = zl.b - 1;
            while (true) {
                if (-1 >= i2) {
                    break;
                }
                long j2 = (gsVar.c * ((long) zl.b)) + ((long) i2);
                while (true) {
                    Object objB2 = gsVar.B(i2);
                    if (objB2 == zl.i) {
                        break loop0;
                    }
                    if (objB2 != zl.d) {
                        if (objB2 != zl.e && objB2 != null) {
                            if (!(objB2 instanceof f85) && !(objB2 instanceof g85)) {
                                if (objB2 != zl.g && objB2 != zl.f) {
                                    if (objB2 != zl.g) {
                                        break;
                                    }
                                } else {
                                    break loop0;
                                }
                            } else {
                                if (j2 < T()) {
                                    break loop0;
                                }
                                f85 f85Var = objB2 instanceof g85 ? ((g85) objB2).a : (f85) objB2;
                                if (gsVar.v(i2, objB2, zl.z())) {
                                    if (function1 != null) {
                                        xv4VarB = p63.b(function1, gsVar.A(i2), xv4VarB);
                                    }
                                    objB = ck1.c(objB, f85Var);
                                    gsVar.w(i2);
                                    gsVar.t();
                                }
                            }
                        } else {
                            if (gsVar.v(i2, objB2, zl.z())) {
                                gsVar.t();
                                break;
                            }
                        }
                    } else {
                        if (j2 < T()) {
                            break loop0;
                        }
                        if (gsVar.v(i2, objB2, zl.z())) {
                            if (function1 != null) {
                                xv4VarB = p63.b(function1, gsVar.A(i2), xv4VarB);
                            }
                            gsVar.w(i2);
                            gsVar.t();
                        }
                    }
                }
                i2--;
            }
        } while (gsVar != null);
        if (objB != null) {
            if (objB instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    A0((f85) arrayList.get(size));
                }
            } else {
                A0((f85) objB);
            }
        }
        if (xv4VarB != null) {
            throw xv4VarB;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(gs gsVar, long j2) {
        Object objB = ck1.b(null, 1, null);
        loop0: while (gsVar != null) {
            for (int i2 = zl.b - 1; -1 < i2; i2--) {
                if ((gsVar.c * ((long) zl.b)) + ((long) i2) < j2) {
                    break loop0;
                }
                while (true) {
                    Object objB2 = gsVar.B(i2);
                    if (objB2 != null && objB2 != zl.e) {
                        if (!(objB2 instanceof g85)) {
                            if (!(objB2 instanceof f85)) {
                                break;
                            }
                            if (gsVar.v(i2, objB2, zl.z())) {
                                objB = ck1.c(objB, objB2);
                                gsVar.C(i2, true);
                                break;
                            }
                        } else {
                            if (gsVar.v(i2, objB2, zl.z())) {
                                objB = ck1.c(objB, ((g85) objB2).a);
                                gsVar.C(i2, true);
                                break;
                            }
                        }
                    } else {
                        if (gsVar.v(i2, objB2, zl.z())) {
                            gsVar.t();
                            break;
                        }
                    }
                }
            }
            gsVar = (gs) gsVar.h();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                z0((f85) objB);
                return;
            }
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                z0((f85) arrayList.get(size));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z0(f85 f85Var) {
        B0(f85Var, true);
    }
}

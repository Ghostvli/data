package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.np;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sp extends jm0 implements qp, x40, f85 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(sp.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(sp.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(sp.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final f30 i;
    public final g40 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sp(f30 f30Var, int i) {
        super(i);
        this.i = f30Var;
        this.j = f30Var.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = x2.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void R(sp spVar, Object obj, int i, Function3 function3, int i2, Object obj2) {
        if (obj2 != null) {
            fn.a("Super calls with default arguments not supported in this target, function: resumeImpl");
            return;
        }
        if ((i2 & 4) != 0) {
            function3 = null;
        }
        spVar.Q(obj, i, function3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 n(Function1 function1, Throwable th, Object obj, g40 g40Var) {
        function1.invoke(th);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String A() {
        Object objZ = z();
        return objZ instanceof a43 ? "Active" : objZ instanceof yp ? "Cancelled" : "Completed";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E() {
        qm0 qm0VarF = F();
        if (qm0VarF != null && I()) {
            qm0VarF.e();
            m.set(this, u33.f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qm0 F() {
        ln1 ln1Var = (ln1) getContext().a(ln1.e);
        if (ln1Var == null) {
            return null;
        }
        qm0 qm0VarH = pn1.h(ln1Var, false, new ft(this), 1, null);
        z0.a(m, this, null, qm0VarH);
        return qm0VarH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof x2) {
                if (z0.a(l, this, obj2, obj)) {
                    return;
                }
            } else if ((obj2 instanceof np) || (obj2 instanceof f04)) {
                K(obj, obj2);
            } else {
                if (obj2 instanceof zx) {
                    zx zxVar = (zx) obj2;
                    if (!zxVar.c()) {
                        K(obj, obj2);
                    }
                    if (obj2 instanceof yp) {
                        Throwable th = zxVar.a;
                        if (obj instanceof np) {
                            p((np) obj, th);
                            return;
                        } else {
                            obj.getClass();
                            r((f04) obj, th);
                            return;
                        }
                    }
                    return;
                }
                if (obj2 instanceof xx) {
                    xx xxVar = (xx) obj2;
                    if (xxVar.b != null) {
                        K(obj, obj2);
                    }
                    if (obj instanceof f04) {
                        return;
                    }
                    obj.getClass();
                    np npVar = (np) obj;
                    if (xxVar.c()) {
                        p(npVar, xxVar.e);
                        return;
                    } else {
                        if (z0.a(l, this, obj2, xx.b(xxVar, null, npVar, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (obj instanceof f04) {
                        return;
                    }
                    obj.getClass();
                    if (z0.a(l, this, obj2, new xx(obj2, (np) obj, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(np npVar) {
        G(npVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean I() {
        return !(z() instanceof a43);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J() {
        if (!km0.c(this.h)) {
            return false;
        }
        f30 f30Var = this.i;
        f30Var.getClass();
        return ((gm0) f30Var).r();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String L() {
        return "CancellableContinuation";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(Throwable th) {
        if (s(th)) {
            return;
        }
        j(th);
        u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N() {
        Throwable thU;
        f30 f30Var = this.i;
        gm0 gm0Var = f30Var instanceof gm0 ? (gm0) f30Var : null;
        if (gm0Var == null || (thU = gm0Var.u(this)) == null) {
            return;
        }
        t();
        j(thU);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean O() {
        Object obj = l.get(this);
        if ((obj instanceof xx) && ((xx) obj).d != null) {
            t();
            return false;
        }
        k.set(this, 536870911);
        l.set(this, x2.a);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(Object obj, final Function1 function1) {
        Q(obj, this.h, function1 != null ? new Function3() { // from class: rp
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return sp.n(function1, (Throwable) obj2, obj3, (g40) obj4);
            }
        } : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q(Object obj, int i, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof a43)) {
                sp spVar = this;
                Object obj3 = obj;
                Function3 function32 = function3;
                if (obj2 instanceof yp) {
                    yp ypVar = (yp) obj2;
                    if (ypVar.e()) {
                        if (function32 != null) {
                            spVar.q(function32, ypVar.a, obj3);
                            return;
                        }
                        return;
                    }
                }
                spVar.o(obj3);
                mx3.a();
                return;
            }
            sp spVar2 = this;
            Object obj4 = obj;
            int i2 = i;
            Function3 function33 = function3;
            if (z0.a(l, spVar2, obj2, spVar2.S((a43) obj2, obj4, i2, function33, null))) {
                spVar2.u();
                spVar2.v(i2);
                return;
            } else {
                this = spVar2;
                obj = obj4;
                i = i2;
                function3 = function33;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object S(a43 a43Var, Object obj, int i, Function3 function3, Object obj2) {
        if (obj instanceof zx) {
            return obj;
        }
        if ((km0.b(i) || obj2 != null) && !(function3 == null && !(a43Var instanceof np) && obj2 == null)) {
            return new xx(obj, a43Var instanceof np ? (np) a43Var : null, function3, obj2, null, 16, null);
        }
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean T() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                e04.a("Already resumed");
                return false;
            }
        } while (!k.compareAndSet(this, i, Buffer.MAX_SIZE + (536870911 & i)));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qj4 U(Object obj, Object obj2, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof a43)) {
                Object obj4 = obj2;
                if ((obj3 instanceof xx) && obj4 != null && ((xx) obj3).d == obj4) {
                    return tp.a;
                }
                return null;
            }
            sp spVar = this;
            Object obj5 = obj;
            Object obj6 = obj2;
            Function3 function32 = function3;
            if (z0.a(l, spVar, obj3, spVar.S((a43) obj3, obj5, this.h, function32, obj6))) {
                spVar.u();
                return tp.a;
            }
            this = spVar;
            obj = obj5;
            function3 = function32;
            obj2 = obj6;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean V() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                e04.a("Already suspended");
                return false;
            }
        } while (!k.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f85
    public void a(f04 f04Var, int i) {
        int i2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                e04.a("invokeOnCancellation should be called at most once");
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        G(f04Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public void b(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof a43) {
                e04.a("Not completed");
                return;
            }
            if (obj2 instanceof zx) {
                return;
            }
            if (obj2 instanceof xx) {
                xx xxVar = (xx) obj2;
                if (xxVar.c()) {
                    e04.a("Must be called at most once");
                    return;
                }
                Throwable th3 = th;
                th2 = th3;
                if (z0.a(l, this, obj2, xx.b(xxVar, null, null, null, null, th3, 15, null))) {
                    xxVar.d(this, th2);
                    return;
                }
            } else {
                th2 = th;
                if (z0.a(l, this, obj2, new xx(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            }
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public final f30 c() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qp
    public void e(n40 n40Var, Object obj) {
        f30 f30Var = this.i;
        gm0 gm0Var = f30Var instanceof gm0 ? (gm0) f30Var : null;
        R(this, obj, (gm0Var != null ? gm0Var.i : null) == n40Var ? 4 : this.h, null, 4, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qp
    public void f(Function1 function1) {
        up.c(this, new np.a(function1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public Object g(Object obj) {
        return obj instanceof xx ? ((xx) obj).a : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x40
    public x40 getCallerFrame() {
        f30 f30Var = this.i;
        if (f30Var instanceof x40) {
            return (x40) f30Var;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public g40 getContext() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qp
    public void i(Object obj, Function3 function3) {
        Q(obj, this.h, function3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qp
    public boolean j(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof a43)) {
                return false;
            }
        } while (!z0.a(l, this, obj, new yp(this, th, (obj instanceof np) || (obj instanceof f04))));
        a43 a43Var = (a43) obj;
        if (a43Var instanceof np) {
            p((np) obj, th);
        } else if (a43Var instanceof f04) {
            r((f04) obj, th);
        }
        u();
        v(this.h);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qp
    public Object k(Object obj, Object obj2, Function3 function3) {
        return U(obj, obj2, function3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public Object l() {
        return z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qp
    public void m(Object obj) {
        v(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Void o(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(np npVar, Throwable th) {
        try {
            npVar.a(th);
        } catch (Throwable th2) {
            r40.a(getContext(), new ay("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(Function3 function3, Throwable th, Object obj) {
        try {
            function3.invoke(th, obj, getContext());
        } catch (Throwable th2) {
            r40.a(getContext(), new ay("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r(f04 f04Var, Throwable th) {
        int i = k.get(this) & 536870911;
        if (i == 536870911) {
            e04.a("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            f04Var.s(i, th, getContext());
        } catch (Throwable th2) {
            r40.a(getContext(), new ay("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public void resumeWith(Object obj) {
        R(this, cy.c(obj, this), this.h, null, 4, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean s(Throwable th) {
        if (!J()) {
            return false;
        }
        f30 f30Var = this.i;
        f30Var.getClass();
        return ((gm0) f30Var).s(th);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t() {
        qm0 qm0VarX = x();
        if (qm0VarX == null) {
            return;
        }
        qm0VarX.e();
        m.set(this, u33.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return L() + '(' + ua0.c(this.i) + "){" + A() + "}@" + ua0.b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        if (J()) {
            return;
        }
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(int i) {
        if (T()) {
            return;
        }
        km0.a(this, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Throwable w(ln1 ln1Var) {
        return ln1Var.v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qm0 x() {
        return (qm0) m.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object y() {
        ln1 ln1Var;
        boolean zJ = J();
        if (V()) {
            if (x() == null) {
                F();
            }
            if (zJ) {
                N();
            }
            return kl1.e();
        }
        if (zJ) {
            N();
        }
        Object objZ = z();
        if (objZ instanceof zx) {
            throw ((zx) objZ).a;
        }
        if (!km0.b(this.h) || (ln1Var = (ln1) getContext().a(ln1.e)) == null || ln1Var.c()) {
            return g(objZ);
        }
        CancellationException cancellationExceptionV = ln1Var.v();
        b(objZ, cancellationExceptionV);
        throw cancellationExceptionV;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object z() {
        return l.get(this);
    }
}

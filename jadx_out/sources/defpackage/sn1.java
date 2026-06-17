package defpackage;

import defpackage.g40;
import defpackage.ln1;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sn1 implements ln1, jt, p73 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(sn1.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(sn1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends sp {
        public final sn1 n;

        public a(f30 f30Var, sn1 sn1Var) {
            super(f30Var, 1);
            this.n = sn1Var;
        }

        @Override // defpackage.sp
        public String L() {
            return "AwaitContinuation";
        }

        @Override // defpackage.sp
        public Throwable w(ln1 ln1Var) {
            Throwable thF;
            Object objE0 = this.n.e0();
            return (!(objE0 instanceof c) || (thF = ((c) objE0).f()) == null) ? objE0 instanceof zx ? ((zx) objE0).a : ln1Var.v() : thF;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends qn1 {
        public final sn1 j;
        public final c k;
        public final ht l;
        public final Object m;

        public b(sn1 sn1Var, c cVar, ht htVar, Object obj) {
            this.j = sn1Var;
            this.k = cVar;
            this.l = htVar;
            this.m = obj;
        }

        @Override // defpackage.qn1
        public boolean w() {
            return false;
        }

        @Override // defpackage.qn1
        public void x(Throwable th) {
            this.j.F(this.k, this.l, this.m);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements gj1 {
        public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");
        public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");
        public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;
        public final o33 f;

        public c(o33 o33Var, boolean z, Throwable th) {
            this.f = o33Var;
            this._isCompleting$volatile = z ? 1 : 0;
            this._rootCause$volatile = th;
        }

        public final void a(Throwable th) {
            Throwable thF = f();
            if (thF == null) {
                p(th);
                return;
            }
            if (th == thF) {
                return;
            }
            Object objE = e();
            if (objE == null) {
                o(th);
                return;
            }
            if (!(objE instanceof Throwable)) {
                if (objE instanceof ArrayList) {
                    ((ArrayList) objE).add(th);
                    return;
                } else {
                    rn1.a("State is ", objE);
                    return;
                }
            }
            if (th == objE) {
                return;
            }
            ArrayList arrayListD = d();
            arrayListD.add(objE);
            arrayListD.add(th);
            o(arrayListD);
        }

        @Override // defpackage.gj1
        public o33 b() {
            return this.f;
        }

        @Override // defpackage.gj1
        public boolean c() {
            return f() == null;
        }

        public final ArrayList d() {
            return new ArrayList(4);
        }

        public final Object e() {
            return i.get(this);
        }

        public final Throwable f() {
            return (Throwable) h.get(this);
        }

        public final boolean j() {
            return f() != null;
        }

        public final boolean k() {
            return g.get(this) != 0;
        }

        public final boolean l() {
            return e() == tn1.e;
        }

        public final List m(Throwable th) {
            ArrayList arrayListD;
            Object objE = e();
            if (objE == null) {
                arrayListD = d();
            } else if (objE instanceof Throwable) {
                ArrayList arrayListD2 = d();
                arrayListD2.add(objE);
                arrayListD = arrayListD2;
            } else {
                if (!(objE instanceof ArrayList)) {
                    rn1.a("State is ", objE);
                    return null;
                }
                arrayListD = (ArrayList) objE;
            }
            Throwable thF = f();
            if (thF != null) {
                arrayListD.add(0, thF);
            }
            if (th != null && !il1.a(th, thF)) {
                arrayListD.add(th);
            }
            o(tn1.e);
            return arrayListD;
        }

        public final void n(boolean z) {
            g.set(this, z ? 1 : 0);
        }

        public final void o(Object obj) {
            i.set(this, obj);
        }

        public final void p(Throwable th) {
            h.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + j() + ", completing=" + k() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + b() + ']';
        }
    }

    public sn1(boolean z) {
        this._state$volatile = z ? tn1.g : tn1.f;
    }

    public static /* synthetic */ CancellationException H0(sn1 sn1Var, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: toCancellationException");
            return null;
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return sn1Var.G0(th, str);
    }

    public final boolean A(Throwable th) {
        if (n0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        gt gtVarD0 = d0();
        return (gtVarD0 == null || gtVarD0 == u33.f) ? z : gtVarD0.a(th) || z;
    }

    public final void A0(zr0 zr0Var) {
        o33 o33Var = new o33();
        Object fj1Var = o33Var;
        if (!zr0Var.c()) {
            fj1Var = new fj1(o33Var);
        }
        z0.a(f, this, zr0Var, fj1Var);
    }

    @Override // defpackage.g40
    public g40 B(g40.c cVar) {
        return ln1.a.d(this, cVar);
    }

    public final void B0(qn1 qn1Var) {
        qn1Var.g(new o33());
        z0.a(f, this, qn1Var, qn1Var.m());
    }

    public String C() {
        return "Job was cancelled";
    }

    public final void C0(qn1 qn1Var) {
        Object objE0;
        do {
            objE0 = e0();
            if (!(objE0 instanceof qn1)) {
                if (!(objE0 instanceof gj1) || ((gj1) objE0).b() == null) {
                    return;
                }
                qn1Var.s();
                return;
            }
            if (objE0 != qn1Var) {
                return;
            }
        } while (!z0.a(f, this, objE0, tn1.g));
    }

    public boolean D(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return x(th) && X();
    }

    public final void D0(gt gtVar) {
        g.set(this, gtVar);
    }

    public final void E(gj1 gj1Var, Object obj) throws Throwable {
        gt gtVarD0 = d0();
        if (gtVarD0 != null) {
            gtVarD0.e();
            D0(u33.f);
        }
        zx zxVar = obj instanceof zx ? (zx) obj : null;
        Throwable th = zxVar != null ? zxVar.a : null;
        if (!(gj1Var instanceof qn1)) {
            o33 o33VarB = gj1Var.b();
            if (o33VarB != null) {
                w0(o33VarB, th);
                return;
            }
            return;
        }
        try {
            ((qn1) gj1Var).x(th);
        } catch (Throwable th2) {
            i0(new ay("Exception in completion handler " + gj1Var + " for " + this, th2));
        }
    }

    public final int E0(Object obj) {
        if (obj instanceof zr0) {
            if (((zr0) obj).c()) {
                return 0;
            }
            if (!z0.a(f, this, obj, tn1.g)) {
                return -1;
            }
            z0();
            return 1;
        }
        if (!(obj instanceof fj1)) {
            return 0;
        }
        if (!z0.a(f, this, obj, ((fj1) obj).b())) {
            return -1;
        }
        z0();
        return 1;
    }

    public final void F(c cVar, ht htVar, Object obj) {
        ht htVarU0 = u0(htVar);
        if (htVarU0 == null || !N0(cVar, htVarU0, obj)) {
            cVar.b().h(2);
            ht htVarU02 = u0(htVar);
            if (htVarU02 == null || !N0(cVar, htVarU02, obj)) {
                q(H(cVar, obj));
            }
        }
    }

    public final String F0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof gj1 ? ((gj1) obj).c() ? "Active" : "New" : obj instanceof zx ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.j() ? "Cancelling" : cVar.k() ? "Completing" : "Active";
    }

    public final Throwable G(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new mn1(C(), null, this) : th;
        }
        obj.getClass();
        return ((p73) obj).R();
    }

    public final CancellationException G0(Throwable th, String str) {
        CancellationException mn1Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (mn1Var == null) {
            if (str == null) {
                str = C();
            }
            mn1Var = new mn1(str, th, this);
        }
        return mn1Var;
    }

    public final Object H(c cVar, Object obj) throws Throwable {
        boolean zJ;
        Throwable thL;
        zx zxVar = obj instanceof zx ? (zx) obj : null;
        Throwable th = zxVar != null ? zxVar.a : null;
        synchronized (cVar) {
            zJ = cVar.j();
            List listM = cVar.m(th);
            thL = L(cVar, listM);
            if (thL != null) {
                p(thL, listM);
            }
        }
        if (thL != null && thL != th) {
            obj = new zx(thL, false, 2, null);
        }
        if (thL != null && (A(thL) || h0(thL))) {
            obj.getClass();
            ((zx) obj).c();
        }
        if (!zJ) {
            x0(thL);
        }
        y0(obj);
        z0.a(f, this, cVar, tn1.g(obj));
        E(cVar, obj);
        return obj;
    }

    public final Object I() throws Throwable {
        Object objE0 = e0();
        if (objE0 instanceof gj1) {
            e04.a("This job has not completed yet");
            return null;
        }
        if (objE0 instanceof zx) {
            throw ((zx) objE0).a;
        }
        return tn1.h(objE0);
    }

    public final String I0() {
        return t0() + '{' + F0(e0()) + '}';
    }

    @Override // defpackage.jt
    public final void J(p73 p73Var) throws Throwable {
        x(p73Var);
    }

    public final boolean J0(gj1 gj1Var, Object obj) throws Throwable {
        if (!z0.a(f, this, gj1Var, tn1.g(obj))) {
            return false;
        }
        x0(null);
        y0(obj);
        E(gj1Var, obj);
        return true;
    }

    public final Throwable K(Object obj) {
        zx zxVar = obj instanceof zx ? (zx) obj : null;
        if (zxVar != null) {
            return zxVar.a;
        }
        return null;
    }

    public final boolean K0(gj1 gj1Var, Throwable th) throws Throwable {
        o33 o33VarA0 = a0(gj1Var);
        if (o33VarA0 == null) {
            return false;
        }
        if (!z0.a(f, this, gj1Var, new c(o33VarA0, false, th))) {
            return false;
        }
        v0(o33VarA0, th);
        return true;
    }

    public final Throwable L(c cVar, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.j()) {
                return new mn1(C(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof po4) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof po4)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public final Object L0(Object obj, Object obj2) {
        return !(obj instanceof gj1) ? tn1.a : ((!(obj instanceof zr0) && !(obj instanceof qn1)) || (obj instanceof ht) || (obj2 instanceof zx)) ? M0((gj1) obj, obj2) : J0((gj1) obj, obj2) ? obj2 : tn1.c;
    }

    public final Object M0(gj1 gj1Var, Object obj) throws Throwable {
        o33 o33VarA0 = a0(gj1Var);
        if (o33VarA0 == null) {
            return tn1.c;
        }
        c cVar = gj1Var instanceof c ? (c) gj1Var : null;
        if (cVar == null) {
            cVar = new c(o33VarA0, false, null);
        }
        mp3 mp3Var = new mp3();
        synchronized (cVar) {
            if (cVar.k()) {
                return tn1.a;
            }
            cVar.n(true);
            if (cVar != gj1Var && !z0.a(f, this, gj1Var, cVar)) {
                return tn1.c;
            }
            boolean zJ = cVar.j();
            zx zxVar = obj instanceof zx ? (zx) obj : null;
            if (zxVar != null) {
                cVar.a(zxVar.a);
            }
            Throwable thF = zJ ? null : cVar.f();
            mp3Var.f = thF;
            fw4 fw4Var = fw4.a;
            if (thF != null) {
                v0(o33VarA0, thF);
            }
            ht htVarU0 = u0(o33VarA0);
            if (htVarU0 != null && N0(cVar, htVarU0, obj)) {
                return tn1.b;
            }
            o33VarA0.h(2);
            ht htVarU02 = u0(o33VarA0);
            return (htVarU02 == null || !N0(cVar, htVarU02, obj)) ? H(cVar, obj) : tn1.b;
        }
    }

    @Override // defpackage.g40
    public g40 N(g40 g40Var) {
        return ln1.a.e(this, g40Var);
    }

    public final boolean N0(c cVar, ht htVar, Object obj) {
        while (on1.g(htVar.j, false, new b(this, cVar, htVar, obj)) == u33.f) {
            htVar = u0(htVar);
            if (htVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.p73
    public CancellationException R() {
        Throwable thF;
        Object objE0 = e0();
        if (objE0 instanceof c) {
            thF = ((c) objE0).f();
        } else if (objE0 instanceof zx) {
            thF = ((zx) objE0).a;
        } else {
            if (objE0 instanceof gj1) {
                rn1.a("Cannot be cancelling child in this state: ", objE0);
                return null;
            }
            thF = null;
        }
        CancellationException cancellationException = thF instanceof CancellationException ? (CancellationException) thF : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new mn1("Parent job is " + F0(objE0), thF, this);
    }

    @Override // defpackage.g40
    public Object T(Object obj, Function2 function2) {
        return ln1.a.b(this, obj, function2);
    }

    @Override // defpackage.ln1
    public final boolean U() {
        return !(e0() instanceof gj1);
    }

    @Override // defpackage.ln1
    public final gt V(jt jtVar) {
        ht htVar = new ht(jtVar);
        htVar.y(this);
        while (true) {
            Object objE0 = e0();
            if (objE0 instanceof zr0) {
                zr0 zr0Var = (zr0) objE0;
                if (!zr0Var.c()) {
                    A0(zr0Var);
                } else if (z0.a(f, this, objE0, htVar)) {
                    return htVar;
                }
            } else {
                if (!(objE0 instanceof gj1)) {
                    Object objE02 = e0();
                    zx zxVar = objE02 instanceof zx ? (zx) objE02 : null;
                    htVar.x(zxVar != null ? zxVar.a : null);
                    return u33.f;
                }
                o33 o33VarB = ((gj1) objE0).b();
                if (o33VarB != null) {
                    if (!o33VarB.d(htVar, 7)) {
                        boolean zD = o33VarB.d(htVar, 3);
                        Object objE03 = e0();
                        if (objE03 instanceof c) {
                            thF = ((c) objE03).f();
                        } else {
                            zx zxVar2 = objE03 instanceof zx ? (zx) objE03 : null;
                            if (zxVar2 != null) {
                                thF = zxVar2.a;
                            }
                        }
                        htVar.x(thF);
                        if (!zD) {
                            return u33.f;
                        }
                    }
                    return htVar;
                }
                B0((qn1) objE0);
            }
        }
    }

    public boolean X() {
        return true;
    }

    public boolean Y() {
        return false;
    }

    @Override // g40.b, defpackage.g40
    public g40.b a(g40.c cVar) {
        return ln1.a.c(this, cVar);
    }

    public final o33 a0(gj1 gj1Var) {
        o33 o33VarB = gj1Var.b();
        if (o33VarB != null) {
            return o33VarB;
        }
        if (gj1Var instanceof zr0) {
            return new o33();
        }
        if (gj1Var instanceof qn1) {
            B0((qn1) gj1Var);
            return null;
        }
        rn1.a("State should have list: ", gj1Var);
        return null;
    }

    @Override // defpackage.ln1
    public final Object b0(f30 f30Var) {
        if (o0()) {
            Object objP0 = p0(f30Var);
            return objP0 == kl1.e() ? objP0 : fw4.a;
        }
        on1.e(f30Var.getContext());
        return fw4.a;
    }

    @Override // defpackage.ln1
    public boolean c() {
        Object objE0 = e0();
        return (objE0 instanceof gj1) && ((gj1) objE0).c();
    }

    public ln1 c0() {
        gt gtVarD0 = d0();
        if (gtVarD0 != null) {
            return gtVarD0.getParent();
        }
        return null;
    }

    public final gt d0() {
        return (gt) g.get(this);
    }

    public final Object e0() {
        return f.get(this);
    }

    @Override // g40.b
    public final g40.c getKey() {
        return ln1.e;
    }

    @Override // defpackage.ln1
    public void h(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new mn1(C(), null, this);
        }
        y(cancellationException);
    }

    public boolean h0(Throwable th) {
        return false;
    }

    public void i0(Throwable th) throws Throwable {
        throw th;
    }

    public final void j0(ln1 ln1Var) {
        if (ln1Var == null) {
            D0(u33.f);
            return;
        }
        ln1Var.start();
        gt gtVarV = ln1Var.V(this);
        D0(gtVarV);
        if (U()) {
            gtVarV.e();
            D0(u33.f);
        }
    }

    public final qm0 k0(Function1 function1) {
        return l0(true, new hm1(function1));
    }

    public final qm0 l0(boolean z, qn1 qn1Var) {
        boolean z2;
        boolean zD;
        qn1Var.y(this);
        while (true) {
            Object objE0 = e0();
            z2 = true;
            if (!(objE0 instanceof zr0)) {
                if (!(objE0 instanceof gj1)) {
                    z2 = false;
                    break;
                }
                gj1 gj1Var = (gj1) objE0;
                o33 o33VarB = gj1Var.b();
                if (o33VarB == null) {
                    B0((qn1) objE0);
                } else {
                    if (qn1Var.w()) {
                        c cVar = gj1Var instanceof c ? (c) gj1Var : null;
                        Throwable thF = cVar != null ? cVar.f() : null;
                        if (thF != null) {
                            if (z) {
                                qn1Var.x(thF);
                            }
                            return u33.f;
                        }
                        zD = o33VarB.d(qn1Var, 5);
                    } else {
                        zD = o33VarB.d(qn1Var, 1);
                    }
                    if (zD) {
                        break;
                    }
                }
            } else {
                zr0 zr0Var = (zr0) objE0;
                if (!zr0Var.c()) {
                    A0(zr0Var);
                } else if (z0.a(f, this, objE0, qn1Var)) {
                    break;
                }
            }
        }
        if (z2) {
            return qn1Var;
        }
        if (z) {
            Object objE02 = e0();
            zx zxVar = objE02 instanceof zx ? (zx) objE02 : null;
            qn1Var.x(zxVar != null ? zxVar.a : null);
        }
        return u33.f;
    }

    public final boolean m0() {
        Object objE0 = e0();
        if (objE0 instanceof zx) {
            return true;
        }
        return (objE0 instanceof c) && ((c) objE0).j();
    }

    public boolean n0() {
        return false;
    }

    public final boolean o0() {
        Object objE0;
        do {
            objE0 = e0();
            if (!(objE0 instanceof gj1)) {
                return false;
            }
        } while (E0(objE0) < 0);
        return true;
    }

    public final void p(Throwable th, List list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                mv0.a(th, th2);
            }
        }
    }

    public final Object p0(f30 f30Var) {
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        up.a(spVar, pn1.h(this, false, new ot3(spVar), 1, null));
        Object objY = spVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY == kl1.e() ? objY : fw4.a;
    }

    public void q(Object obj) {
    }

    public final Object q0(Object obj) throws Throwable {
        Throwable thG = null;
        while (true) {
            Object objE0 = e0();
            if (objE0 instanceof c) {
                synchronized (objE0) {
                    if (((c) objE0).l()) {
                        return tn1.d;
                    }
                    boolean zJ = ((c) objE0).j();
                    if (obj != null || !zJ) {
                        if (thG == null) {
                            thG = G(obj);
                        }
                        ((c) objE0).a(thG);
                    }
                    Throwable thF = zJ ? null : ((c) objE0).f();
                    if (thF != null) {
                        v0(((c) objE0).b(), thF);
                    }
                    return tn1.a;
                }
            }
            if (!(objE0 instanceof gj1)) {
                return tn1.d;
            }
            if (thG == null) {
                thG = G(obj);
            }
            gj1 gj1Var = (gj1) objE0;
            if (!gj1Var.c()) {
                Object objL0 = L0(objE0, new zx(thG, false, 2, null));
                if (objL0 == tn1.a) {
                    rn1.a("Cannot happen in ", objE0);
                    return null;
                }
                if (objL0 != tn1.c) {
                    return objL0;
                }
            } else if (K0(gj1Var, thG)) {
                return tn1.a;
            }
        }
    }

    public final Object r(f30 f30Var) throws Throwable {
        Object objE0;
        do {
            objE0 = e0();
            if (!(objE0 instanceof gj1)) {
                if (objE0 instanceof zx) {
                    throw ((zx) objE0).a;
                }
                return tn1.h(objE0);
            }
        } while (E0(objE0) < 0);
        return s(f30Var);
    }

    public final boolean r0(Object obj) {
        Object objL0;
        do {
            objL0 = L0(e0(), obj);
            if (objL0 == tn1.a) {
                return false;
            }
            if (objL0 == tn1.b) {
                return true;
            }
        } while (objL0 == tn1.c);
        q(objL0);
        return true;
    }

    public final Object s(f30 f30Var) {
        a aVar = new a(jl1.c(f30Var), this);
        aVar.E();
        up.a(aVar, pn1.h(this, false, new nt3(aVar), 1, null));
        Object objY = aVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY;
    }

    public final Object s0(Object obj) {
        Object objL0;
        do {
            objL0 = L0(e0(), obj);
            if (objL0 == tn1.a) {
                l02.a("Job " + this + " is already complete or completing, but is being completed with " + obj, K(obj));
                return null;
            }
        } while (objL0 == tn1.c);
        return objL0;
    }

    @Override // defpackage.ln1
    public final boolean start() {
        int iE0;
        do {
            iE0 = E0(e0());
            if (iE0 == 0) {
                return false;
            }
        } while (iE0 != 1);
        return true;
    }

    public String t0() {
        return ua0.a(this);
    }

    public String toString() {
        return I0() + '@' + ua0.b(this);
    }

    @Override // defpackage.ln1
    public final qm0 u(boolean z, boolean z2, Function1 function1) {
        return l0(z2, z ? new gm1(function1) : new hm1(function1));
    }

    public final ht u0(sz1 sz1Var) {
        while (sz1Var.r()) {
            sz1Var = sz1Var.n();
        }
        while (true) {
            sz1Var = sz1Var.m();
            if (!sz1Var.r()) {
                if (sz1Var instanceof ht) {
                    return (ht) sz1Var;
                }
                if (sz1Var instanceof o33) {
                    return null;
                }
            }
        }
    }

    @Override // defpackage.ln1
    public final CancellationException v() {
        Object objE0 = e0();
        if (!(objE0 instanceof c)) {
            if (objE0 instanceof gj1) {
                rn1.a("Job is still new or active: ", this);
                return null;
            }
            if (objE0 instanceof zx) {
                return H0(this, ((zx) objE0).a, null, 1, null);
            }
            return new mn1(ua0.a(this) + " has completed normally", null, this);
        }
        Throwable thF = ((c) objE0).f();
        if (thF != null) {
            CancellationException cancellationExceptionG0 = G0(thF, ua0.a(this) + " is cancelling");
            if (cancellationExceptionG0 != null) {
                return cancellationExceptionG0;
            }
        }
        rn1.a("Job is still new or active: ", this);
        return null;
    }

    public final void v0(o33 o33Var, Throwable th) throws Throwable {
        x0(th);
        o33Var.h(4);
        Object objL = o33Var.l();
        objL.getClass();
        ay ayVar = null;
        for (sz1 sz1VarM = (sz1) objL; !il1.a(sz1VarM, o33Var); sz1VarM = sz1VarM.m()) {
            if ((sz1VarM instanceof qn1) && ((qn1) sz1VarM).w()) {
                try {
                    ((qn1) sz1VarM).x(th);
                } catch (Throwable th2) {
                    if (ayVar != null) {
                        mv0.a(ayVar, th2);
                    } else {
                        ayVar = new ay("Exception in completion handler " + sz1VarM + " for " + this, th2);
                        fw4 fw4Var = fw4.a;
                    }
                }
            }
        }
        if (ayVar != null) {
            i0(ayVar);
        }
        A(th);
    }

    public final boolean w(Throwable th) {
        return x(th);
    }

    public final void w0(o33 o33Var, Throwable th) throws Throwable {
        o33Var.h(1);
        Object objL = o33Var.l();
        objL.getClass();
        ay ayVar = null;
        for (sz1 sz1VarM = (sz1) objL; !il1.a(sz1VarM, o33Var); sz1VarM = sz1VarM.m()) {
            if (sz1VarM instanceof qn1) {
                try {
                    ((qn1) sz1VarM).x(th);
                } catch (Throwable th2) {
                    if (ayVar != null) {
                        mv0.a(ayVar, th2);
                    } else {
                        ayVar = new ay("Exception in completion handler " + sz1VarM + " for " + this, th2);
                        fw4 fw4Var = fw4.a;
                    }
                }
            }
        }
        if (ayVar != null) {
            i0(ayVar);
        }
    }

    public final boolean x(Object obj) throws Throwable {
        Object objQ0 = tn1.a;
        if (Y() && (objQ0 = z(obj)) == tn1.b) {
            return true;
        }
        if (objQ0 == tn1.a) {
            objQ0 = q0(obj);
        }
        if (objQ0 == tn1.a || objQ0 == tn1.b) {
            return true;
        }
        if (objQ0 == tn1.d) {
            return false;
        }
        q(objQ0);
        return true;
    }

    public void x0(Throwable th) {
    }

    public void y(Throwable th) throws Throwable {
        x(th);
    }

    public void y0(Object obj) {
    }

    public final Object z(Object obj) {
        Object objL0;
        do {
            Object objE0 = e0();
            if (!(objE0 instanceof gj1) || ((objE0 instanceof c) && ((c) objE0).k())) {
                return tn1.a;
            }
            objL0 = L0(objE0, new zx(G(obj), false, 2, null));
        } while (objL0 == tn1.c);
        return objL0;
    }

    public void z0() {
    }
}

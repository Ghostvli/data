package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class gm0 extends jm0 implements x40, f30 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(gm0.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final n40 i;
    public final f30 j;
    public Object k;
    public final Object l;

    /* JADX DEBUG: Class process forced to load method for inline: hm0.a():qj4 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gm0(n40 n40Var, f30 f30Var) {
        super(-1);
        this.i = n40Var;
        this.j = f30Var;
        this.k = hm0.a;
        this.l = kn4.e(getContext());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public f30 c() {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x40
    public x40 getCallerFrame() {
        f30 f30Var = this.j;
        if (f30Var instanceof x40) {
            return (x40) f30Var;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public g40 getContext() {
        return this.j.getContext();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jm0
    public Object l() {
        Object obj = this.k;
        this.k = hm0.a;
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        while (m.get(this) == hm0.b) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sp o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                m.set(this, hm0.b);
                return null;
            }
            if (obj instanceof sp) {
                if (z0.a(m, this, obj, hm0.b)) {
                    return (sp) obj;
                }
            } else if (obj != hm0.b && !(obj instanceof Throwable)) {
                rn1.a("Inconsistent state ", obj);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sp p() {
        Object obj = m.get(this);
        if (obj instanceof sp) {
            return (sp) obj;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean r() {
        return m.get(this) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public void resumeWith(Object obj) {
        Object objB = cy.b(obj);
        if (this.i.d0(getContext())) {
            this.k = objB;
            this.h = 0;
            this.i.c0(getContext(), this);
            return;
        }
        yu0 yu0VarB = mn4.a.b();
        if (yu0VarB.o0()) {
            this.k = objB;
            this.h = 0;
            yu0VarB.k0(this);
            return;
        }
        yu0VarB.m0(true);
        try {
            g40 context = getContext();
            Object objF = kn4.f(context, this.l);
            try {
                this.j.resumeWith(obj);
                fw4 fw4Var = fw4.a;
                while (yu0VarB.r0()) {
                }
            } finally {
                kn4.d(context, objF);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean s(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            qj4 qj4Var = hm0.b;
            if (il1.a(obj, qj4Var)) {
                if (z0.a(m, this, qj4Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (z0.a(m, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t() {
        n();
        sp spVarP = p();
        if (spVarP != null) {
            spVarP.t();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "DispatchedContinuation[" + this.i + ", " + ua0.c(this.j) + ']';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Throwable u(qp qpVar) {
        qj4 qj4Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            qj4Var = hm0.b;
            if (obj != qj4Var) {
                if (!(obj instanceof Throwable)) {
                    rn1.a("Inconsistent state ", obj);
                    return null;
                }
                if (z0.a(m, this, obj, null)) {
                    return (Throwable) obj;
                }
                jl.a("Failed requirement.");
                return null;
            }
        } while (!z0.a(m, this, qj4Var, qpVar));
        return null;
    }
}

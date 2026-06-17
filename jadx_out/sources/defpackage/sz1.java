package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sz1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(sz1.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(sz1.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(sz1.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean d(sz1 sz1Var, int i) {
        sz1 sz1VarN;
        do {
            sz1VarN = n();
            if (sz1VarN instanceof au1) {
                return (((au1) sz1VarN).i & i) == 0 && sz1VarN.d(sz1Var, i);
            }
        } while (!sz1VarN.f(sz1Var, this));
        return true;
    }

    public final boolean f(sz1 sz1Var, sz1 sz1Var2) {
        g.set(sz1Var, this);
        f.set(sz1Var, sz1Var2);
        if (!z0.a(f, this, sz1Var2, sz1Var)) {
            return false;
        }
        sz1Var.k(sz1Var2);
        return true;
    }

    public final boolean g(sz1 sz1Var) {
        g.set(sz1Var, this);
        f.set(sz1Var, this);
        while (l() == this) {
            if (z0.a(f, this, this, sz1Var)) {
                sz1Var.k(this);
                return true;
            }
        }
        return false;
    }

    public final void h(int i) {
        d(new au1(i), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (defpackage.z0.a(defpackage.sz1.f, r3, r2, ((defpackage.gq3) r4).a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.sz1 i() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = p()
            java.lang.Object r0 = r0.get(r7)
            sz1 r0 = (defpackage.sz1) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = o()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            goto L25
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = p()
            boolean r0 = defpackage.z0.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.r()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof defpackage.gq3
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = o()
            gq3 r4 = (defpackage.gq3) r4
            sz1 r4 = r4.a
            boolean r2 = defpackage.z0.a(r5, r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = p()
            java.lang.Object r2 = r4.get(r2)
            sz1 r2 = (defpackage.sz1) r2
            goto Ld
        L4f:
            r4.getClass()
            r3 = r4
            sz1 r3 = (defpackage.sz1) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sz1.i():sz1");
    }

    public final sz1 j(sz1 sz1Var) {
        while (sz1Var.r()) {
            sz1Var = (sz1) g.get(sz1Var);
        }
        return sz1Var;
    }

    public final void k(sz1 sz1Var) {
        sz1 sz1Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            sz1Var2 = (sz1) atomicReferenceFieldUpdater.get(sz1Var);
            if (l() != sz1Var) {
                return;
            }
        } while (!z0.a(g, sz1Var, sz1Var2, this));
        if (r()) {
            sz1Var.i();
        }
    }

    public final Object l() {
        return f.get(this);
    }

    public final sz1 m() {
        sz1 sz1Var;
        Object objL = l();
        gq3 gq3Var = objL instanceof gq3 ? (gq3) objL : null;
        if (gq3Var != null && (sz1Var = gq3Var.a) != null) {
            return sz1Var;
        }
        objL.getClass();
        return (sz1) objL;
    }

    public final sz1 n() {
        sz1 sz1VarI = i();
        return sz1VarI == null ? j((sz1) g.get(this)) : sz1VarI;
    }

    public boolean r() {
        return l() instanceof gq3;
    }

    public boolean s() {
        return t() == null;
    }

    public final sz1 t() {
        Object objL;
        sz1 sz1Var;
        do {
            objL = l();
            if (objL instanceof gq3) {
                return ((gq3) objL).a;
            }
            if (objL == this) {
                return (sz1) objL;
            }
            objL.getClass();
            sz1Var = (sz1) objL;
        } while (!z0.a(f, this, objL, sz1Var.u()));
        sz1Var.i();
        return null;
    }

    public String toString() {
        return new ei3(this) { // from class: sz1.a
            @Override // defpackage.qp1
            public Object get() {
                return ua0.a(this.receiver);
            }
        } + '@' + ua0.b(this);
    }

    public final gq3 u() {
        gq3 gq3Var = (gq3) h.get(this);
        if (gq3Var != null) {
            return gq3Var;
        }
        gq3 gq3Var2 = new gq3(this);
        h.set(this, gq3Var2);
        return gq3Var2;
    }
}

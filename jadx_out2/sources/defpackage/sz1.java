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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean f(sz1 sz1Var, sz1 sz1Var2) {
        g.set(sz1Var, this);
        f.set(sz1Var, sz1Var2);
        if (!z0.a(f, this, sz1Var2, sz1Var)) {
            return false;
        }
        sz1Var.k(sz1Var2);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(int i) {
        d(new au1(i), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (defpackage.z0.a(defpackage.sz1.f, r3, r2, ((defpackage.gq3) r4).a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final sz1 i() {
        while (true) {
            sz1 sz1Var = (sz1) g.get(this);
            sz1 sz1Var2 = sz1Var;
            while (true) {
                sz1 sz1Var3 = null;
                while (true) {
                    Object obj = f.get(sz1Var2);
                    if (obj == this) {
                        if (sz1Var == sz1Var2 || z0.a(g, this, sz1Var, sz1Var2)) {
                            break;
                        }
                    } else {
                        if (r()) {
                            return null;
                        }
                        if (!(obj instanceof gq3)) {
                            obj.getClass();
                            sz1Var3 = sz1Var2;
                            sz1Var2 = (sz1) obj;
                        } else {
                            if (sz1Var3 != null) {
                                break;
                            }
                            sz1Var2 = (sz1) g.get(sz1Var2);
                        }
                    }
                }
                sz1Var2 = sz1Var3;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sz1 j(sz1 sz1Var) {
        while (sz1Var.r()) {
            sz1Var = (sz1) g.get(sz1Var);
        }
        return sz1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object l() {
        return f.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sz1 n() {
        sz1 sz1VarI = i();
        return sz1VarI == null ? j((sz1) g.get(this)) : sz1VarI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r() {
        return l() instanceof gq3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s() {
        return t() == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return new ei3(this) { // from class: sz1.a
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.qp1
            public Object get() {
                return ua0.a(this.receiver);
            }
        } + '@' + ua0.b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

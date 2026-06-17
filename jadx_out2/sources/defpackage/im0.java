package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class im0 extends ty3 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(im0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public im0(g40 g40Var, f30 f30Var) {
        super(g40Var, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final boolean U0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                e04.a("Already resumed");
                return false;
            }
        } while (!j.compareAndSet(this, 0, 2));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final boolean V0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                e04.a("Already suspended");
                return false;
            }
        } while (!j.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ty3, defpackage.w
    public void O0(Object obj) {
        if (U0()) {
            return;
        }
        hm0.b(jl1.c(this.i), cy.a(obj, this.i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object S0() {
        if (V0()) {
            return kl1.e();
        }
        Object objH = tn1.h(e0());
        if (objH instanceof zx) {
            throw ((zx) objH).a;
        }
        return objH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ty3, defpackage.sn1
    public void q(Object obj) {
        O0(obj);
    }
}

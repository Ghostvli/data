package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class vk extends w {
    public final Thread i;
    public final yu0 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vk(g40 g40Var, Thread thread, yu0 yu0Var) {
        super(g40Var, true, true);
        this.i = thread;
        this.j = yu0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object S0() throws Throwable {
        g1.a();
        try {
            yu0 yu0Var = this.j;
            if (yu0Var != null) {
                yu0.n0(yu0Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    yu0 yu0Var2 = this.j;
                    long jQ0 = yu0Var2 != null ? yu0Var2.q0() : Long.MAX_VALUE;
                    if (U()) {
                        yu0 yu0Var3 = this.j;
                        if (yu0Var3 != null) {
                            yu0.i0(yu0Var3, false, 1, null);
                        }
                        g1.a();
                        Object objH = tn1.h(e0());
                        zx zxVar = objH instanceof zx ? (zx) objH : null;
                        if (zxVar == null) {
                            return objH;
                        }
                        throw zxVar.a;
                    }
                    g1.a();
                    LockSupport.parkNanos(this, jQ0);
                } catch (Throwable th) {
                    yu0 yu0Var4 = this.j;
                    if (yu0Var4 != null) {
                        yu0.i0(yu0Var4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            w(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            g1.a();
            throw th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public boolean n0() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public void q(Object obj) {
        if (il1.a(Thread.currentThread(), this.i)) {
            return;
        }
        Thread thread = this.i;
        g1.a();
        LockSupport.unpark(thread);
    }
}

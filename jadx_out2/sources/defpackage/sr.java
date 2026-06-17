package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sr extends w implements or {
    public final or i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sr(g40 g40Var, or orVar, boolean z, boolean z2) {
        super(g40Var, z, z2);
        this.i = orVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final or S0() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t04
    public Object b(Object obj, f30 f30Var) {
        return this.i.b(obj, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t04
    public boolean d(Throwable th) {
        return this.i.d(th);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1, defpackage.ln1
    public final void h(CancellationException cancellationException) {
        if (m0()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new mn1(C(), null, this);
        }
        y(cancellationException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oo3
    public bs iterator() {
        return this.i.iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public void y(Throwable th) {
        CancellationException cancellationExceptionH0 = sn1.H0(this, th, null, 1, null);
        this.i.h(cancellationExceptionH0);
        w(cancellationExceptionH0);
    }
}

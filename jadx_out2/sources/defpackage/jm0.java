package defpackage;

import defpackage.kt3;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jm0 extends vl4 {
    public int h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jm0(int i) {
        this.h = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(Object obj, Throwable th) {
    }

    public abstract f30 c();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Throwable d(Object obj) {
        zx zxVar = obj instanceof zx ? (zx) obj : null;
        if (zxVar != null) {
            return zxVar.a;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object g(Object obj) {
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(Throwable th) {
        r40.a(c().getContext(), new z40("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object l();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            f30 f30VarC = c();
            f30VarC.getClass();
            gm0 gm0Var = (gm0) f30VarC;
            f30 f30Var = gm0Var.j;
            Object obj = gm0Var.l;
            g40 context = f30Var.getContext();
            Object objF = kn4.f(context, obj);
            ln1 ln1Var = null;
            zv4 zv4VarJ = objF != kn4.a ? k40.j(f30Var, context, objF) : null;
            try {
                g40 context2 = f30Var.getContext();
                Object objL = l();
                Throwable thD = d(objL);
                if (thD == null && km0.b(this.h)) {
                    ln1Var = (ln1) context2.a(ln1.e);
                }
                if (ln1Var != null && !ln1Var.c()) {
                    CancellationException cancellationExceptionV = ln1Var.v();
                    b(objL, cancellationExceptionV);
                    kt3.a aVar = kt3.g;
                    f30Var.resumeWith(kt3.b(lt3.a(cancellationExceptionV)));
                } else if (thD != null) {
                    kt3.a aVar2 = kt3.g;
                    f30Var.resumeWith(kt3.b(lt3.a(thD)));
                } else {
                    kt3.a aVar3 = kt3.g;
                    f30Var.resumeWith(kt3.b(g(objL)));
                }
                fw4 fw4Var = fw4.a;
                if (zv4VarJ != null && !zv4VarJ.S0()) {
                    return;
                }
                kn4.d(context, objF);
            } catch (Throwable th) {
                if (zv4VarJ == null || zv4VarJ.S0()) {
                    kn4.d(context, objF);
                }
                throw th;
            }
        } catch (Throwable th2) {
            h(th2);
        }
    }
}

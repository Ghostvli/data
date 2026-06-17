package defpackage;

import defpackage.kt3;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hh implements f30, x40, Serializable {
    private final f30 completion;

    public hh(f30 f30Var) {
        this.completion = f30Var;
    }

    public f30 create(f30 f30Var) {
        f30Var.getClass();
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // defpackage.x40
    public x40 getCallerFrame() {
        f30 f30Var = this.completion;
        if (f30Var instanceof x40) {
            return (x40) f30Var;
        }
        return null;
    }

    public final f30 getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return sa0.c(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [f30] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // defpackage.f30
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        ?? r2 = this;
        while (true) {
            ta0.b(r2);
            hh hhVar = (hh) r2;
            f30 f30Var = hhVar.completion;
            f30Var.getClass();
            try {
                objInvokeSuspend = hhVar.invokeSuspend(obj);
            } catch (Throwable th) {
                kt3.a aVar = kt3.g;
                obj = kt3.b(lt3.a(th));
            }
            if (objInvokeSuspend == kl1.e()) {
                return;
            }
            obj = kt3.b(objInvokeSuspend);
            hhVar.releaseIntercepted();
            if (!(f30Var instanceof hh)) {
                f30Var.resumeWith(obj);
                return;
            }
            r2 = f30Var;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public f30 create(Object obj, f30 f30Var) {
        f30Var.getClass();
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}

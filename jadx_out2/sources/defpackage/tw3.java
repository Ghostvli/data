package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class tw3 extends g30 implements a31, x40 {
    public final a31 f;
    public final g40 g;
    public final int h;
    public g40 i;
    public f30 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tw3(a31 a31Var, g40 g40Var) {
        super(f33.f, bs0.f);
        this.f = a31Var;
        this.g = g40Var;
        this.h = ((Number) g40Var.T(0, new Function2() { // from class: sw3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(tw3.h(((Integer) obj).intValue(), (g40.b) obj2));
            }
        })).intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(int i, g40.b bVar) {
        return i + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.a31
    public Object emit(Object obj, f30 f30Var) {
        try {
            Object objN = n(f30Var, obj);
            if (objN == kl1.e()) {
                ta0.c(f30Var);
            }
            return objN == kl1.e() ? objN : fw4.a;
        } catch (Throwable th) {
            this.i = new on0(th, f30Var.getContext());
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh, defpackage.x40
    public x40 getCallerFrame() {
        f30 f30Var = this.j;
        if (f30Var instanceof x40) {
            return (x40) f30Var;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g30, defpackage.f30
    public g40 getContext() {
        g40 g40Var = this.i;
        return g40Var == null ? bs0.f : g40Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh
    public Object invokeSuspend(Object obj) {
        Throwable thD = kt3.d(obj);
        if (thD != null) {
            this.i = new on0(thD, getContext());
        }
        f30 f30Var = this.j;
        if (f30Var != null) {
            f30Var.resumeWith(obj);
        }
        return kl1.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(g40 g40Var, g40 g40Var2, Object obj) {
        if (g40Var2 instanceof on0) {
            o((on0) g40Var2, obj);
        }
        ww3.b(this, g40Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object n(f30 f30Var, Object obj) {
        g40 context = f30Var.getContext();
        on1.e(context);
        g40 g40Var = this.i;
        if (g40Var != context) {
            l(context, g40Var, obj);
            this.i = context;
        }
        this.j = f30Var;
        Function3 function3 = uw3.a;
        a31 a31Var = this.f;
        a31Var.getClass();
        Object objInvoke = function3.invoke(a31Var, obj, this);
        if (!il1.a(objInvoke, kl1.e())) {
            this.j = null;
        }
        return objInvoke;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(on0 on0Var, Object obj) {
        throw new IllegalStateException(lg4.n("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + on0Var.g + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g30, defpackage.hh
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}

package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class pn1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class a extends t81 implements Function1 {
        public a(Object obj) {
            super(1, obj, qn1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        public final void e(Throwable th) {
            ((qn1) this.receiver).x(th);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            e((Throwable) obj);
            return fw4.a;
        }
    }

    public static final wx a(ln1 ln1Var) {
        return new nn1(ln1Var);
    }

    public static /* synthetic */ wx b(ln1 ln1Var, int i, Object obj) {
        if ((i & 1) != 0) {
            ln1Var = null;
        }
        return on1.a(ln1Var);
    }

    public static final void c(g40 g40Var, CancellationException cancellationException) {
        ln1 ln1Var = (ln1) g40Var.a(ln1.e);
        if (ln1Var != null) {
            ln1Var.h(cancellationException);
        }
    }

    public static final qm0 d(ln1 ln1Var, qm0 qm0Var) {
        return h(ln1Var, false, new sm0(qm0Var), 1, null);
    }

    public static final void e(g40 g40Var) {
        ln1 ln1Var = (ln1) g40Var.a(ln1.e);
        if (ln1Var != null) {
            on1.f(ln1Var);
        }
    }

    public static final void f(ln1 ln1Var) {
        if (!ln1Var.c()) {
            throw ln1Var.v();
        }
    }

    public static final qm0 g(ln1 ln1Var, boolean z, qn1 qn1Var) {
        return ln1Var instanceof sn1 ? ((sn1) ln1Var).l0(z, qn1Var) : ln1Var.u(qn1Var.w(), z, new a(qn1Var));
    }

    public static /* synthetic */ qm0 h(ln1 ln1Var, boolean z, qn1 qn1Var, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return on1.g(ln1Var, z, qn1Var);
    }
}

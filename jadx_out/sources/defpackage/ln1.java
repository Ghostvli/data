package defpackage;

import defpackage.g40;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ln1 extends g40.b {
    public static final b e = b.f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static /* synthetic */ void a(ln1 ln1Var, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                fn.a("Super calls with default arguments not supported in this target, function: cancel");
                return;
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            ln1Var.h(cancellationException);
        }

        public static Object b(ln1 ln1Var, Object obj, Function2 function2) {
            return g40.b.a.a(ln1Var, obj, function2);
        }

        public static g40.b c(ln1 ln1Var, g40.c cVar) {
            return g40.b.a.b(ln1Var, cVar);
        }

        public static g40 d(ln1 ln1Var, g40.c cVar) {
            return g40.b.a.c(ln1Var, cVar);
        }

        public static g40 e(ln1 ln1Var, g40 g40Var) {
            return g40.b.a.d(ln1Var, g40Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements g40.c {
        public static final /* synthetic */ b f = new b();
    }

    boolean U();

    gt V(jt jtVar);

    Object b0(f30 f30Var);

    boolean c();

    void h(CancellationException cancellationException);

    boolean start();

    qm0 u(boolean z, boolean z2, Function1 function1);

    CancellationException v();
}

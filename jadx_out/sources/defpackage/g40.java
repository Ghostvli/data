package defpackage;

import defpackage.g40;
import defpackage.h30;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface g40 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static g40 a(g40 g40Var, b bVar) {
            g40Var.getClass();
            bVar.getClass();
            g40 g40VarB = g40Var.B(bVar.getKey());
            bs0 bs0Var = bs0.f;
            if (g40VarB == bs0Var) {
                return bVar;
            }
            h30.b bVar2 = h30.b;
            h30 h30Var = (h30) g40VarB.a(bVar2);
            if (h30Var == null) {
                return new ix(g40VarB, bVar);
            }
            g40 g40VarB2 = g40VarB.B(bVar2);
            return g40VarB2 == bs0Var ? new ix(bVar, h30Var) : new ix(new ix(g40VarB2, bVar), h30Var);
        }

        public static g40 b(g40 g40Var, g40 g40Var2) {
            g40Var2.getClass();
            return g40Var2 == bs0.f ? g40Var : (g40) g40Var2.T(g40Var, new Function2() { // from class: f40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return g40.a.a((g40) obj, (g40.b) obj2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b extends g40 {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public static Object a(b bVar, Object obj, Function2 function2) {
                function2.getClass();
                return function2.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                cVar.getClass();
                if (il1.a(bVar.getKey(), cVar)) {
                    return bVar;
                }
                return null;
            }

            public static g40 c(b bVar, c cVar) {
                cVar.getClass();
                return il1.a(bVar.getKey(), cVar) ? bs0.f : bVar;
            }

            public static g40 d(b bVar, g40 g40Var) {
                g40Var.getClass();
                return a.b(bVar, g40Var);
            }
        }

        @Override // defpackage.g40
        b a(c cVar);

        c getKey();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
    }

    g40 B(c cVar);

    g40 N(g40 g40Var);

    Object T(Object obj, Function2 function2);

    b a(c cVar);
}

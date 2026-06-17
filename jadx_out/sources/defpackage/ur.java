package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ur {
    public static final Object b(g40 g40Var, Object obj, Object obj2, Function2 function2, f30 f30Var) {
        Object objF = kn4.f(g40Var, obj2);
        try {
            md4 md4Var = new md4(f30Var, g40Var);
            Object objD = !(function2 instanceof hh) ? jl1.d(function2, obj, md4Var) : ((Function2) vu4.b(function2, 2)).invoke(obj, md4Var);
            kn4.d(g40Var, objF);
            if (objD == kl1.e()) {
                ta0.c(f30Var);
            }
            return objD;
        } catch (Throwable th) {
            kn4.d(g40Var, objF);
            throw th;
        }
    }

    public static /* synthetic */ Object c(g40 g40Var, Object obj, Object obj2, Function2 function2, f30 f30Var, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = kn4.e(g40Var);
        }
        return b(g40Var, obj, obj2, function2, f30Var);
    }

    public static final a31 d(a31 a31Var, g40 g40Var) {
        return ((a31Var instanceof v04) || (a31Var instanceof w33)) ? a31Var : new yv4(a31Var, g40Var);
    }
}

package defpackage;

import defpackage.kt3;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class aw4 {
    public static final void a(Function2 function2, Object obj, f30 f30Var) {
        f30 f30VarA = ta0.a(f30Var);
        try {
            g40 context = f30VarA.getContext();
            Object objF = kn4.f(context, null);
            try {
                ta0.b(f30VarA);
                Object objD = !(function2 instanceof hh) ? jl1.d(function2, obj, f30VarA) : ((Function2) vu4.b(function2, 2)).invoke(obj, f30VarA);
                kn4.d(context, objF);
                if (objD != kl1.e()) {
                    f30VarA.resumeWith(kt3.b(objD));
                }
            } catch (Throwable th) {
                kn4.d(context, objF);
                throw th;
            }
        } catch (Throwable th2) {
            kt3.a aVar = kt3.g;
            f30VarA.resumeWith(kt3.b(lt3.a(th2)));
        }
    }

    public static final Object b(ty3 ty3Var, Object obj, Function2 function2) {
        Object zxVar;
        try {
            zxVar = !(function2 instanceof hh) ? jl1.d(function2, obj, ty3Var) : ((Function2) vu4.b(function2, 2)).invoke(obj, ty3Var);
        } catch (Throwable th) {
            zxVar = new zx(th, false, 2, null);
        }
        if (zxVar == kl1.e()) {
            return kl1.e();
        }
        Object objS0 = ty3Var.s0(zxVar);
        if (objS0 == tn1.b) {
            return kl1.e();
        }
        if (objS0 instanceof zx) {
            throw ((zx) objS0).a;
        }
        return tn1.h(objS0);
    }

    public static final Object c(ty3 ty3Var, Object obj, Function2 function2) throws Throwable {
        Object zxVar;
        try {
            zxVar = !(function2 instanceof hh) ? jl1.d(function2, obj, ty3Var) : ((Function2) vu4.b(function2, 2)).invoke(obj, ty3Var);
        } catch (Throwable th) {
            zxVar = new zx(th, false, 2, null);
        }
        if (zxVar == kl1.e()) {
            return kl1.e();
        }
        Object objS0 = ty3Var.s0(zxVar);
        if (objS0 == tn1.b) {
            return kl1.e();
        }
        if (objS0 instanceof zx) {
            Throwable th2 = ((zx) objS0).a;
            if (!(th2 instanceof po4) || ((po4) th2).f != ty3Var) {
                throw th2;
            }
            if (zxVar instanceof zx) {
                throw ((zx) zxVar).a;
            }
        } else {
            zxVar = tn1.h(objS0);
        }
        return zxVar;
    }
}

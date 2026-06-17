package defpackage;

import defpackage.h30;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class dm {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ln1 a(u40 u40Var, g40 g40Var, y40 y40Var, Function2 function2) {
        g40 g40VarH = k40.h(u40Var, g40Var);
        pd4 ks1Var = y40Var.e() ? new ks1(g40VarH, function2) : new pd4(g40VarH, true);
        ks1Var.R0(y40Var, ks1Var, function2);
        return ks1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ ln1 b(u40 u40Var, g40 g40Var, y40 y40Var, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            g40Var = bs0.f;
        }
        if ((i & 2) != 0) {
            y40Var = y40.f;
        }
        return bm.a(u40Var, g40Var, y40Var, function2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object c(g40 g40Var, Function2 function2, f30 f30Var) {
        Object objS0;
        g40 context = f30Var.getContext();
        g40 g40VarG = k40.g(context, g40Var);
        on1.e(g40VarG);
        if (g40VarG == context) {
            ty3 ty3Var = new ty3(g40VarG, f30Var);
            objS0 = aw4.b(ty3Var, ty3Var, function2);
        } else {
            h30.b bVar = h30.b;
            if (il1.a(g40VarG.a(bVar), context.a(bVar))) {
                zv4 zv4Var = new zv4(g40VarG, f30Var);
                g40 context2 = zv4Var.getContext();
                Object objF = kn4.f(context2, null);
                try {
                    Object objB = aw4.b(zv4Var, zv4Var, function2);
                    kn4.d(context2, objF);
                    objS0 = objB;
                } catch (Throwable th) {
                    kn4.d(context2, objF);
                    throw th;
                }
            } else {
                im0 im0Var = new im0(g40VarG, f30Var);
                vp.c(function2, im0Var, im0Var);
                objS0 = im0Var.S0();
            }
        }
        if (objS0 == kl1.e()) {
            ta0.c(f30Var);
        }
        return objS0;
    }
}

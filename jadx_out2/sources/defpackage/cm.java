package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class cm {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(g40 g40Var, Function2 function2) {
        yu0 yu0VarA;
        g40 g40VarH;
        Thread threadCurrentThread = Thread.currentThread();
        h30 h30Var = (h30) g40Var.a(h30.b);
        if (h30Var == null) {
            yu0VarA = mn4.a.b();
            g40VarH = k40.h(va1.f, g40Var.N(yu0VarA));
        } else {
            yu0 yu0Var = h30Var instanceof yu0 ? (yu0) h30Var : null;
            if (yu0Var == null) {
                yu0VarA = mn4.a.a();
                g40VarH = k40.h(va1.f, g40Var);
            } else {
                yu0 yu0Var2 = yu0Var.s0() ? yu0Var : null;
                if (yu0Var2 != null) {
                    yu0VarA = yu0Var2;
                }
                g40VarH = k40.h(va1.f, g40Var);
            }
        }
        vk vkVar = new vk(g40VarH, threadCurrentThread, yu0VarA);
        vkVar.R0(y40.f, vkVar, function2);
        return vkVar.S0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object b(g40 g40Var, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            g40Var = bs0.f;
        }
        return bm.c(g40Var, function2);
    }
}

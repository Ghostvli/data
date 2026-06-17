package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class km0 {
    public static final void a(jm0 jm0Var, int i) {
        f30 f30VarC = jm0Var.c();
        boolean z = i == 4;
        if (z || !(f30VarC instanceof gm0) || b(i) != b(jm0Var.h)) {
            d(jm0Var, f30VarC, z);
            return;
        }
        gm0 gm0Var = (gm0) f30VarC;
        n40 n40Var = gm0Var.i;
        g40 context = gm0Var.getContext();
        if (n40Var.d0(context)) {
            n40Var.c0(context, jm0Var);
        } else {
            e(jm0Var);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final void d(jm0 jm0Var, f30 f30Var, boolean z) {
        Object objG;
        Object objL = jm0Var.l();
        Throwable thD = jm0Var.d(objL);
        if (thD != null) {
            kt3.a aVar = kt3.g;
            objG = lt3.a(thD);
        } else {
            kt3.a aVar2 = kt3.g;
            objG = jm0Var.g(objL);
        }
        Object objB = kt3.b(objG);
        if (!z) {
            f30Var.resumeWith(objB);
            return;
        }
        f30Var.getClass();
        gm0 gm0Var = (gm0) f30Var;
        f30 f30Var2 = gm0Var.j;
        Object obj = gm0Var.l;
        g40 context = f30Var2.getContext();
        Object objF = kn4.f(context, obj);
        zv4 zv4VarJ = objF != kn4.a ? k40.j(f30Var2, context, objF) : null;
        try {
            gm0Var.j.resumeWith(objB);
            fw4 fw4Var = fw4.a;
            if (zv4VarJ == null || zv4VarJ.S0()) {
                kn4.d(context, objF);
            }
        } catch (Throwable th) {
            if (zv4VarJ == null || zv4VarJ.S0()) {
                kn4.d(context, objF);
            }
            throw th;
        }
    }

    public static final void e(jm0 jm0Var) {
        yu0 yu0VarB = mn4.a.b();
        if (yu0VarB.o0()) {
            yu0VarB.k0(jm0Var);
            return;
        }
        yu0VarB.m0(true);
        try {
            d(jm0Var, jm0Var.c(), true);
            do {
            } while (yu0VarB.r0());
        } finally {
            try {
            } finally {
            }
        }
    }
}

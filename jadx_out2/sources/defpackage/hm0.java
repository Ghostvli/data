package defpackage;

import defpackage.kt3;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hm0 {
    public static final qj4 a = new qj4("UNDEFINED");
    public static final qj4 b = new qj4("REUSABLE_CLAIMED");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: all -> 0x0067, DONT_GENERATE, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x003e, B:13:0x004c, B:15:0x0052, B:28:0x0091, B:18:0x0069, B:20:0x0079, B:25:0x0088, B:27:0x008e, B:33:0x009e, B:36:0x00a7, B:35:0x00a4, B:23:0x007f), top: B:45:0x003e, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(f30 f30Var, Object obj) {
        ln1 ln1Var;
        if (!(f30Var instanceof gm0)) {
            f30Var.resumeWith(obj);
            return;
        }
        gm0 gm0Var = (gm0) f30Var;
        Object objB = cy.b(obj);
        if (gm0Var.i.d0(gm0Var.getContext())) {
            gm0Var.k = objB;
            gm0Var.h = 1;
            gm0Var.i.c0(gm0Var.getContext(), gm0Var);
            return;
        }
        yu0 yu0VarB = mn4.a.b();
        if (yu0VarB.o0()) {
            gm0Var.k = objB;
            gm0Var.h = 1;
            yu0VarB.k0(gm0Var);
            return;
        }
        yu0VarB.m0(true);
        try {
            ln1Var = (ln1) gm0Var.getContext().a(ln1.e);
        } finally {
            try {
            } finally {
            }
        }
        if (ln1Var == null || ln1Var.c()) {
            f30 f30Var2 = gm0Var.j;
            Object obj2 = gm0Var.l;
            g40 context = f30Var2.getContext();
            Object objF = kn4.f(context, obj2);
            zv4 zv4VarJ = objF != kn4.a ? k40.j(f30Var2, context, objF) : null;
            try {
                gm0Var.j.resumeWith(obj);
                fw4 fw4Var = fw4.a;
            } finally {
                if (zv4VarJ == null || zv4VarJ.S0()) {
                    kn4.d(context, objF);
                }
            }
        }
        CancellationException cancellationExceptionV = ln1Var.v();
        gm0Var.b(objB, cancellationExceptionV);
        kt3.a aVar = kt3.g;
        gm0Var.resumeWith(kt3.b(lt3.a(cancellationExceptionV)));
        while (yu0VarB.r0()) {
        }
    }
}

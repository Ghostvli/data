package defpackage;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fs4 {
    public static boolean a(ow3 ow3Var) {
        ow3Var.getClass();
        return ow3Var.Y();
    }

    public static final Object b(pf3 pf3Var, String str, f30 f30Var) {
        Object objA = pf3Var.a(str, new Function1() { // from class: es4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(fs4.a((ow3) obj));
            }
        }, f30Var);
        return objA == kl1.e() ? objA : fw4.a;
    }
}

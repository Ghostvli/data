package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ua0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(f30 f30Var) {
        Object objB;
        if (f30Var instanceof gm0) {
            return ((gm0) f30Var).toString();
        }
        try {
            kt3.a aVar = kt3.g;
            objB = kt3.b(f30Var + '@' + b(f30Var));
        } catch (Throwable th) {
            kt3.a aVar2 = kt3.g;
            objB = kt3.b(lt3.a(th));
        }
        if (kt3.d(objB) != null) {
            objB = f30Var.getClass().getName() + '@' + b(f30Var);
        }
        return (String) objB;
    }
}

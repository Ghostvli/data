package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class cy {
    public static final Object a(Object obj, f30 f30Var) {
        if (!(obj instanceof zx)) {
            return kt3.b(obj);
        }
        kt3.a aVar = kt3.g;
        return kt3.b(lt3.a(((zx) obj).a));
    }

    public static final Object b(Object obj) {
        Throwable thD = kt3.d(obj);
        return thD == null ? obj : new zx(thD, false, 2, null);
    }

    public static final Object c(Object obj, qp qpVar) {
        Throwable thD = kt3.d(obj);
        return thD == null ? obj : new zx(thD, false, 2, null);
    }
}

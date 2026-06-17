package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class lt3 {
    public static final Object a(Throwable th) {
        th.getClass();
        return new kt3.b(th);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof kt3.b) {
            throw ((kt3.b) obj).f;
        }
    }
}

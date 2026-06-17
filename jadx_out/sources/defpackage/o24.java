package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o24 extends n24 {
    public static Set d() {
        return ks0.f;
    }

    public static final Set e(Set set) {
        set.getClass();
        int size = set.size();
        return size != 0 ? size != 1 ? set : n24.c(set.iterator().next()) : d();
    }

    public static Set f(Object... objArr) {
        objArr.getClass();
        return ua.N(objArr);
    }
}

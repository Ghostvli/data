package defpackage;

import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g32 {
    public final LinkedHashMap a;

    public g32(int i, float f) {
        this.a = new LinkedHashMap(i, f, true);
    }

    public final Object a(Object obj) {
        obj.getClass();
        return this.a.get(obj);
    }

    public final Set b() {
        Set setEntrySet = this.a.entrySet();
        setEntrySet.getClass();
        return setEntrySet;
    }

    public final boolean c() {
        return this.a.isEmpty();
    }

    public final Object d(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        return this.a.put(obj, obj2);
    }

    public final Object e(Object obj) {
        obj.getClass();
        return this.a.remove(obj);
    }
}

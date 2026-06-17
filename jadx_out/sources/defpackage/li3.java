package defpackage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class li3 {
    public static final li3 c = new li3();
    public final ConcurrentMap b = new ConcurrentHashMap();
    public final qy3 a = new f42();

    public static li3 a() {
        return c;
    }

    public py3 b(Class cls) {
        bl1.b(cls, "messageType");
        py3 py3VarA = (py3) this.b.get(cls);
        if (py3VarA == null) {
            py3VarA = this.a.a(cls);
            bl1.b(py3VarA, "schema");
            py3 py3Var = (py3) this.b.putIfAbsent(cls, py3VarA);
            if (py3Var != null) {
                return py3Var;
            }
        }
        return py3VarA;
    }

    public py3 c(Object obj) {
        return b(obj.getClass());
    }
}

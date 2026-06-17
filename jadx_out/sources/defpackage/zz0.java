package defpackage;

import defpackage.yw3;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zz0 extends yw3 {
    public final HashMap j = new HashMap();

    @Override // defpackage.yw3
    public yw3.c c(Object obj) {
        return (yw3.c) this.j.get(obj);
    }

    public boolean contains(Object obj) {
        return this.j.containsKey(obj);
    }

    @Override // defpackage.yw3
    public Object g(Object obj, Object obj2) {
        yw3.c cVarC = c(obj);
        if (cVarC != null) {
            return cVarC.g;
        }
        this.j.put(obj, f(obj, obj2));
        return null;
    }

    @Override // defpackage.yw3
    public Object j(Object obj) {
        Object objJ = super.j(obj);
        this.j.remove(obj);
        return objJ;
    }

    public Map.Entry k(Object obj) {
        if (contains(obj)) {
            return ((yw3.c) this.j.get(obj)).i;
        }
        return null;
    }
}

package defpackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class k45 {
    public final Map a = new LinkedHashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((c45) it.next()).b();
        }
        this.a.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c45 b(String str) {
        str.getClass();
        return (c45) this.a.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Set c() {
        return new HashSet(this.a.keySet());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(String str, c45 c45Var) {
        str.getClass();
        c45Var.getClass();
        c45 c45Var2 = (c45) this.a.put(str, c45Var);
        if (c45Var2 != null) {
            c45Var2.b();
        }
    }
}

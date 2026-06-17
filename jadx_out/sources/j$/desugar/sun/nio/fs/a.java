package j$.desugar.sun.nio.fs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public Set a;
    public Map b;
    public boolean c;

    public final void a(String str, Object obj) {
        ((HashMap) this.b).put(str, obj);
    }

    public final boolean b(String str) {
        return this.c || ((HashSet) this.a).contains(str);
    }
}

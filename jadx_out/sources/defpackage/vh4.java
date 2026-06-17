package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class vh4 implements ih1 {
    public volatile boolean a = false;
    public final Map b = new ConcurrentHashMap();
    public final LinkedBlockingQueue c = new LinkedBlockingQueue();

    @Override // defpackage.ih1
    public synchronized j02 a(String str) {
        uh4 uh4Var;
        uh4Var = (uh4) this.b.get(str);
        if (uh4Var == null) {
            uh4Var = new uh4(str, this.c, this.a);
            this.b.put(str, uh4Var);
        }
        return uh4Var;
    }

    public void b() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue c() {
        return this.c;
    }

    public List d() {
        return new ArrayList(this.b.values());
    }

    public void e() {
        this.a = true;
    }
}

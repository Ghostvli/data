package defpackage;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yt2 {
    public final AtomicReference a = new AtomicReference();
    public final la b = new la();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        yv2 yv2Var = (yv2) this.a.getAndSet(null);
        if (yv2Var == null) {
            yv2Var = new yv2(cls, cls2, cls3);
        } else {
            yv2Var.a(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = (List) this.b.get(yv2Var);
        }
        this.a.set(yv2Var);
        return list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.b) {
            this.b.put(new yv2(cls, cls2, cls3), list);
        }
    }
}

package defpackage;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b30 {
    public final Set a = new CopyOnWriteArraySet();
    public volatile Context b;

    public final void a(j63 j63Var) {
        j63Var.getClass();
        Context context = this.b;
        if (context != null) {
            j63Var.a(context);
        }
        this.a.add(j63Var);
    }

    public final void b() {
        this.b = null;
    }

    public final void c(Context context) {
        context.getClass();
        this.b = context;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((j63) it.next()).a(context);
        }
    }
}

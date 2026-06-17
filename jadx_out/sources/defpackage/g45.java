package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g45 {
    public final dk4 a = new dk4();
    public final Map b = new LinkedHashMap();
    public final Set c = new LinkedHashSet();
    public volatile boolean d;

    public final void d(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        str.getClass();
        autoCloseable.getClass();
        if (this.d) {
            f(autoCloseable);
            return;
        }
        synchronized (this.a) {
            autoCloseable2 = (AutoCloseable) this.b.put(str, autoCloseable);
        }
        f(autoCloseable2);
    }

    public final void e() {
        if (this.d) {
            return;
        }
        this.d = true;
        synchronized (this.a) {
            try {
                Iterator it = this.b.values().iterator();
                while (it.hasNext()) {
                    f((AutoCloseable) it.next());
                }
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    f((AutoCloseable) it2.next());
                }
                this.c.clear();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                d45.a(autoCloseable);
            } catch (Exception e) {
                wg1.a(e);
            }
        }
    }

    public final AutoCloseable g(String str) {
        AutoCloseable autoCloseable;
        str.getClass();
        synchronized (this.a) {
            autoCloseable = (AutoCloseable) this.b.get(str);
        }
        return autoCloseable;
    }
}

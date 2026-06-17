package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e32 {
    public final Map a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;
    public long d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Object a;
        public final int b;

        public a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }
    }

    public e32(long j) {
        this.b = j;
        this.c = j;
    }

    public void b() {
        m(0L);
    }

    public final void f() {
        m(this.c);
    }

    public synchronized Object g(Object obj) {
        a aVar;
        aVar = (a) this.a.get(obj);
        return aVar != null ? aVar.a : null;
    }

    public synchronized long h() {
        return this.c;
    }

    public int i(Object obj) {
        return 1;
    }

    public void j(Object obj, Object obj2) {
    }

    public synchronized Object k(Object obj, Object obj2) {
        int i = i(obj2);
        long j = i;
        if (j >= this.c) {
            j(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.d += j;
        }
        a aVar = (a) this.a.put(obj, obj2 == null ? null : new a(obj2, i));
        if (aVar != null) {
            this.d -= (long) aVar.b;
            if (!aVar.a.equals(obj2)) {
                j(obj, aVar.a);
            }
        }
        f();
        return aVar != null ? aVar.a : null;
    }

    public synchronized Object l(Object obj) {
        a aVar = (a) this.a.remove(obj);
        if (aVar == null) {
            return null;
        }
        this.d -= (long) aVar.b;
        return aVar.a;
    }

    public synchronized void m(long j) {
        while (this.d > j) {
            Iterator it = this.a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            a aVar = (a) entry.getValue();
            this.d -= (long) aVar.b;
            Object key = entry.getKey();
            it.remove();
            j(key, aVar.a);
        }
    }
}

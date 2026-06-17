package defpackage;

import defpackage.up3;
import defpackage.vt2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bw2 {
    public static final c e = new c();
    public static final vt2 f = new a();
    public final List a;
    public final c b;
    public final Set c;
    public final tf3 d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements vt2 {
        @Override // defpackage.vt2
        public boolean a(Object obj) {
            return false;
        }

        @Override // defpackage.vt2
        public vt2.a b(Object obj, int i, int i2, u63 u63Var) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final Class a;
        public final Class b;
        public final wt2 c;

        public b(Class cls, Class cls2, wt2 wt2Var) {
            this.a = cls;
            this.b = cls2;
            this.c = wt2Var;
        }

        public boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public aw2 a(List list, tf3 tf3Var) {
            return new aw2(list, tf3Var);
        }
    }

    public bw2(tf3 tf3Var, c cVar) {
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = tf3Var;
        this.b = cVar;
    }

    public static vt2 f() {
        return f;
    }

    public final void a(Class cls, Class cls2, wt2 wt2Var, boolean z) {
        b bVar = new b(cls, cls2, wt2Var);
        List list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    public synchronized void b(Class cls, Class cls2, wt2 wt2Var) {
        a(cls, cls2, wt2Var, true);
    }

    public final vt2 c(b bVar) {
        return (vt2) fg3.e(bVar.c.e(this));
    }

    public synchronized vt2 d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (vt2) arrayList.get(0);
            }
            if (!z) {
                throw new up3.c(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    public synchronized List e(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.a) {
                if (!this.c.contains(bVar) && bVar.a(cls)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    public final wt2 h(b bVar) {
        return bVar.c;
    }

    public synchronized List i(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(bVar));
            }
        }
        return arrayList;
    }

    public synchronized List j(Class cls, Class cls2, wt2 wt2Var) {
        List listI;
        listI = i(cls, cls2);
        b(cls, cls2, wt2Var);
        return listI;
    }

    public bw2(tf3 tf3Var) {
        this(tf3Var, e);
    }
}

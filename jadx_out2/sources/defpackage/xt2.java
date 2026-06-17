package defpackage;

import defpackage.up3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xt2 {
    public final bw2 a;
    public final a b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final Map a = new HashMap();

        /* JADX INFO: renamed from: xt2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class C0134a {
            public final List a;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0134a(List list) {
                this.a = list;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a.clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List b(Class cls) {
            C0134a c0134a = (C0134a) this.a.get(cls);
            if (c0134a == null) {
                return null;
            }
            return c0134a.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(Class cls, List list) {
            if (((C0134a) this.a.put(cls, new C0134a(list))) == null) {
                return;
            }
            ho1.a("Already cached loaders for model: ", cls);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xt2(bw2 bw2Var) {
        this.b = new a();
        this.a = bw2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Class b(Object obj) {
        return obj.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void a(Class cls, Class cls2, wt2 wt2Var) {
        this.a.b(cls, cls2, wt2Var);
        this.b.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized List c(Class cls) {
        return this.a.g(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List d(Object obj) {
        List listE = e(b(obj));
        if (listE.isEmpty()) {
            throw new up3.c(obj);
        }
        int size = listE.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z = true;
        for (int i = 0; i < size; i++) {
            vt2 vt2Var = (vt2) listE.get(i);
            if (vt2Var.a(obj)) {
                if (z) {
                    arrayList = new ArrayList(size - i);
                    z = false;
                }
                arrayList.add(vt2Var);
            }
        }
        if (arrayList.isEmpty()) {
            throw new up3.c(obj, listE);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized List e(Class cls) {
        List listB;
        listB = this.b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.a.e(cls));
            this.b.c(cls, listB);
        }
        return listB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void f(Class cls, Class cls2, wt2 wt2Var) {
        g(this.a.j(cls, cls2, wt2Var));
        this.b.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((wt2) it.next()).d();
        }
    }

    public xt2(tf3 tf3Var) {
        this(new bw2(tf3Var));
    }
}

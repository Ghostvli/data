package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nb1 {
    public final a a = new a();
    public final Map b = new HashMap();

    public static void e(a aVar) {
        a aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
    }

    public static void g(a aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }

    public Object a(nf3 nf3Var) {
        a aVar = (a) this.b.get(nf3Var);
        if (aVar == null) {
            aVar = new a(nf3Var);
            this.b.put(nf3Var, aVar);
        } else {
            nf3Var.a();
        }
        b(aVar);
        return aVar.b();
    }

    public final void b(a aVar) {
        e(aVar);
        a aVar2 = this.a;
        aVar.d = aVar2;
        aVar.c = aVar2.c;
        g(aVar);
    }

    public final void c(a aVar) {
        e(aVar);
        a aVar2 = this.a;
        aVar.d = aVar2.d;
        aVar.c = aVar2;
        g(aVar);
    }

    public void d(nf3 nf3Var, Object obj) {
        a aVar = (a) this.b.get(nf3Var);
        if (aVar == null) {
            aVar = new a(nf3Var);
            c(aVar);
            this.b.put(nf3Var, aVar);
        } else {
            nf3Var.a();
        }
        aVar.a(obj);
    }

    public Object f() {
        for (a aVar = this.a.d; !aVar.equals(this.a); aVar = aVar.d) {
            Object objB = aVar.b();
            if (objB != null) {
                return objB;
            }
            e(aVar);
            this.b.remove(aVar.a);
            ((nf3) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.a.c;
        boolean z = false;
        while (!aVar.equals(this.a)) {
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final Object a;
        public List b;
        public a c;
        public a d;

        public a(Object obj) {
            this.d = this;
            this.c = this;
            this.a = obj;
        }

        public void a(Object obj) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(obj);
        }

        public Object b() {
            int iC = c();
            if (iC > 0) {
                return this.b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a() {
            this(null);
        }
    }
}

package defpackage;

import com.bumptech.glide.c;
import com.bumptech.glide.load.data.a;
import defpackage.bb0;
import defpackage.vt2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ab0 {
    public final List a = new ArrayList();
    public final List b = new ArrayList();
    public c c;
    public Object d;
    public int e;
    public int f;
    public Class g;
    public bb0.e h;
    public u63 i;
    public Map j;
    public Class k;
    public boolean l;
    public boolean m;
    public wq1 n;
    public ug3 o;
    public zl0 p;
    public boolean q;
    public boolean r;

    public void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    public ma b() {
        return this.c.b();
    }

    public List c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                vt2.a aVar = (vt2.a) listG.get(i);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add((wq1) aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    public xl0 d() {
        return this.h.a();
    }

    public zl0 e() {
        return this.p;
    }

    public int f() {
        return this.f;
    }

    public List g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List listI = this.c.i().i(this.d);
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                vt2.a aVarB = ((vt2) listI.get(i)).b(this.d, this.e, this.f, this.i);
                if (aVarB != null) {
                    this.a.add(aVarB);
                }
            }
        }
        return this.a;
    }

    public uy1 h(Class cls) {
        return this.c.i().h(cls, this.g, this.k);
    }

    public Class i() {
        return this.d.getClass();
    }

    public List j(File file) {
        return this.c.i().i(file);
    }

    public u63 k() {
        return this.i;
    }

    public ug3 l() {
        return this.o;
    }

    public List m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }

    public gs3 n(yr3 yr3Var) {
        return this.c.i().k(yr3Var);
    }

    public a o(Object obj) {
        return this.c.i().l(obj);
    }

    public wq1 p() {
        return this.n;
    }

    public ns0 q(Object obj) {
        return this.c.i().m(obj);
    }

    public Class r() {
        return this.k;
    }

    public ns4 s(Class cls) {
        ns4 ns4Var = (ns4) this.j.get(cls);
        if (ns4Var == null) {
            Iterator it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    ns4Var = (ns4) entry.getValue();
                    break;
                }
            }
        }
        if (ns4Var != null) {
            return ns4Var;
        }
        if (!this.j.isEmpty() || !this.q) {
            return kw4.c();
        }
        f02.a("Missing transformation for ", cls, ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        return null;
    }

    public int t() {
        return this.e;
    }

    public boolean u(Class cls) {
        return h(cls) != null;
    }

    public void v(c cVar, Object obj, wq1 wq1Var, int i, int i2, zl0 zl0Var, Class cls, Class cls2, ug3 ug3Var, u63 u63Var, Map map, boolean z, boolean z2, bb0.e eVar) {
        this.c = cVar;
        this.d = obj;
        this.n = wq1Var;
        this.e = i;
        this.f = i2;
        this.p = zl0Var;
        this.g = cls;
        this.h = eVar;
        this.k = cls2;
        this.o = ug3Var;
        this.i = u63Var;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    public boolean w(yr3 yr3Var) {
        return this.c.i().n(yr3Var);
    }

    public boolean x() {
        return this.r;
    }

    public boolean y(wq1 wq1Var) {
        List listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (((vt2.a) listG.get(i)).a.equals(wq1Var)) {
                return true;
            }
        }
        return false;
    }
}

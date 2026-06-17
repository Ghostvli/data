package defpackage;

import defpackage.t90;
import defpackage.vt2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class aw2 implements vt2 {
    public final List a;
    public final tf3 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements t90, t90.a {
        public final List f;
        public final tf3 g;
        public int h;
        public ug3 i;
        public t90.a j;
        public List k;
        public boolean l;

        public a(List list, tf3 tf3Var) {
            this.g = tf3Var;
            fg3.d(list);
            this.f = list;
            this.h = 0;
        }

        @Override // defpackage.t90
        public Class a() {
            return ((t90) this.f.get(0)).a();
        }

        @Override // defpackage.t90
        public void b() {
            List list = this.k;
            if (list != null) {
                this.g.b(list);
            }
            this.k = null;
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((t90) it.next()).b();
            }
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            this.i = ug3Var;
            this.j = aVar;
            this.k = (List) this.g.a();
            ((t90) this.f.get(this.h)).c(ug3Var, this);
            if (this.l) {
                cancel();
            }
        }

        @Override // defpackage.t90
        public void cancel() {
            this.l = true;
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((t90) it.next()).cancel();
            }
        }

        @Override // t90.a
        public void d(Exception exc) {
            ((List) fg3.e(this.k)).add(exc);
            g();
        }

        @Override // defpackage.t90
        public ba0 e() {
            return ((t90) this.f.get(0)).e();
        }

        @Override // t90.a
        public void f(Object obj) {
            if (obj != null) {
                this.j.f(obj);
            } else {
                g();
            }
        }

        public final void g() {
            if (this.l) {
                return;
            }
            if (this.h < this.f.size() - 1) {
                this.h++;
                c(this.i, this.j);
            } else {
                fg3.e(this.k);
                this.j.d(new ja1("Fetch failed", new ArrayList(this.k)));
            }
        }
    }

    public aw2(List list, tf3 tf3Var) {
        this.a = list;
        this.b = tf3Var;
    }

    @Override // defpackage.vt2
    public boolean a(Object obj) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((vt2) it.next()).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.vt2
    public vt2.a b(Object obj, int i, int i2, u63 u63Var) {
        vt2.a aVarB;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        wq1 wq1Var = null;
        for (int i3 = 0; i3 < size; i3++) {
            vt2 vt2Var = (vt2) this.a.get(i3);
            if (vt2Var.a(obj) && (aVarB = vt2Var.b(obj, i, i2, u63Var)) != null) {
                wq1Var = aVarB.a;
                arrayList.add(aVarB.c);
            }
        }
        if (arrayList.isEmpty() || wq1Var == null) {
            return null;
        }
        return new vt2.a(wq1Var, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }
}

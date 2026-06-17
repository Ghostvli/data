package defpackage;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f12 {
    public Map c;
    public Map d;
    public float e;
    public Map f;
    public List g;
    public mb4 h;
    public w02 i;
    public List j;
    public Rect k;
    public float l;
    public float m;
    public float n;
    public boolean o;
    public int q;
    public int r;
    public final ma3 a = new ma3();
    public final HashSet b = new HashSet();
    public int p = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(String str) {
        k02.c(str);
        this.b.add(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Rect b() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mb4 c() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float d() {
        return (long) ((e() / this.n) * 1000.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float e() {
        return this.m - this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float f() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map g() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float h(float f) {
        return ot2.i(this.l, this.m, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float i() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map j() {
        float fE = uy4.e();
        if (fE != this.e) {
            for (Map.Entry entry : this.d.entrySet()) {
                this.d.put((String) entry.getKey(), ((l22) entry.getValue()).a(this.e / fE));
            }
        }
        this.e = fE;
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List k() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c52 l(String str) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            c52 c52Var = (c52) this.g.get(i);
            if (c52Var.a(str)) {
                return c52Var;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ma3 n() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List o(String str) {
        return (List) this.c.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float p() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(int i) {
        this.p += i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(Rect rect, float f, float f2, float f3, List list, w02 w02Var, Map map, Map map2, float f4, mb4 mb4Var, Map map3, List list2, int i, int i2) {
        this.k = rect;
        this.l = f;
        this.m = f2;
        this.n = f3;
        this.j = list;
        this.i = w02Var;
        this.c = map;
        this.d = map2;
        this.e = f4;
        this.h = mb4Var;
        this.f = map3;
        this.g = list2;
        this.q = i;
        this.r = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yr1 t(long j) {
        return (yr1) this.i.d(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            sb.append(((yr1) it.next()).z("\t"));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u(boolean z) {
        this.o = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(boolean z) {
        this.a.b(z);
    }
}

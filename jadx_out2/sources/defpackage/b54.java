package defpackage;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b54 {
    public final List a;
    public PointF b;
    public boolean c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b54(PointF pointF, boolean z, List list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List a() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PointF b() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(b54 b54Var, b54 b54Var2, float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = b54Var.d() || b54Var2.d();
        if (b54Var.a().size() != b54Var2.a().size()) {
            k02.c("Curves must have the same number of control points. Shape 1: " + b54Var.a().size() + "\tShape 2: " + b54Var2.a().size());
        }
        int iMin = Math.min(b54Var.a().size(), b54Var2.a().size());
        int size = this.a.size();
        List list = this.a;
        if (size < iMin) {
            for (int size2 = list.size(); size2 < iMin; size2++) {
                this.a.add(new o50());
            }
        } else if (list.size() > iMin) {
            for (int size3 = this.a.size() - 1; size3 >= iMin; size3--) {
                List list2 = this.a;
                list2.remove(list2.size() - 1);
            }
        }
        PointF pointFB = b54Var.b();
        PointF pointFB2 = b54Var2.b();
        f(ot2.i(pointFB.x, pointFB2.x, f), ot2.i(pointFB.y, pointFB2.y, f));
        for (int size4 = this.a.size() - 1; size4 >= 0; size4--) {
            o50 o50Var = (o50) b54Var.a().get(size4);
            o50 o50Var2 = (o50) b54Var2.a().get(size4);
            PointF pointFA = o50Var.a();
            PointF pointFB3 = o50Var.b();
            PointF pointFC = o50Var.c();
            PointF pointFA2 = o50Var2.a();
            PointF pointFB4 = o50Var2.b();
            PointF pointFC2 = o50Var2.c();
            ((o50) this.a.get(size4)).d(ot2.i(pointFA.x, pointFA2.x, f), ot2.i(pointFA.y, pointFA2.y, f));
            ((o50) this.a.get(size4)).e(ot2.i(pointFB3.x, pointFB4.x, f), ot2.i(pointFB3.y, pointFB4.y, f));
            ((o50) this.a.get(size4)).f(ot2.i(pointFC.x, pointFC2.x, f), ot2.i(pointFC.y, pointFC2.y, f));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(boolean z) {
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public b54() {
        this.a = new ArrayList();
    }
}

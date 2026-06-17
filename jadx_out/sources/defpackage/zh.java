package defpackage;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zh {
    public final d c;
    public y22 e;
    public final List a = new ArrayList(1);
    public boolean b = false;
    public float d = 0.0f;
    public Object f = null;
    public float g = -1.0f;
    public float h = -1.0f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements d {
        public c() {
        }

        @Override // zh.d
        public boolean a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // zh.d
        public dr1 b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // zh.d
        public boolean c(float f) {
            return false;
        }

        @Override // zh.d
        public float d() {
            return 1.0f;
        }

        @Override // zh.d
        public float e() {
            return 0.0f;
        }

        @Override // zh.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        boolean a(float f);

        dr1 b();

        boolean c(float f);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e implements d {
        public final List a;
        public dr1 c = null;
        public float d = -1.0f;
        public dr1 b = f(0.0f);

        public e(List list) {
            this.a = list;
        }

        @Override // zh.d
        public boolean a(float f) {
            dr1 dr1Var = this.c;
            dr1 dr1Var2 = this.b;
            if (dr1Var == dr1Var2 && this.d == f) {
                return true;
            }
            this.c = dr1Var2;
            this.d = f;
            return false;
        }

        @Override // zh.d
        public dr1 b() {
            return this.b;
        }

        @Override // zh.d
        public boolean c(float f) {
            if (this.b.a(f)) {
                return !this.b.i();
            }
            this.b = f(f);
            return true;
        }

        @Override // zh.d
        public float d() {
            return ((dr1) this.a.get(r1.size() - 1)).c();
        }

        @Override // zh.d
        public float e() {
            return ((dr1) this.a.get(0)).f();
        }

        public final dr1 f(float f) {
            List list = this.a;
            dr1 dr1Var = (dr1) list.get(list.size() - 1);
            if (f >= dr1Var.f()) {
                return dr1Var;
            }
            int size = this.a.size() - 2;
            while (true) {
                List list2 = this.a;
                if (size < 1) {
                    return (dr1) list2.get(0);
                }
                dr1 dr1Var2 = (dr1) list2.get(size);
                if (this.b != dr1Var2 && dr1Var2.a(f)) {
                    return dr1Var2;
                }
                size--;
            }
        }

        @Override // zh.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements d {
        public final dr1 a;
        public float b = -1.0f;

        public f(List list) {
            this.a = (dr1) list.get(0);
        }

        @Override // zh.d
        public boolean a(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // zh.d
        public dr1 b() {
            return this.a;
        }

        @Override // zh.d
        public boolean c(float f) {
            return !this.a.i();
        }

        @Override // zh.d
        public float d() {
            return this.a.c();
        }

        @Override // zh.d
        public float e() {
            return this.a.f();
        }

        @Override // zh.d
        public boolean isEmpty() {
            return false;
        }
    }

    public zh(List list) {
        this.c = q(list);
    }

    public static d q(List list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.a.add(bVar);
    }

    public dr1 b() {
        if (or1.h()) {
            or1.b("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        dr1 dr1VarB = this.c.b();
        if (or1.h()) {
            or1.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return dr1VarB;
    }

    public float c() {
        if (this.h == -1.0f) {
            this.h = this.c.d();
        }
        return this.h;
    }

    public float d() {
        Interpolator interpolator;
        dr1 dr1VarB = b();
        if (dr1VarB == null || dr1VarB.i() || (interpolator = dr1VarB.d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    public float e() {
        if (this.b) {
            return 0.0f;
        }
        dr1 dr1VarB = b();
        if (dr1VarB.i()) {
            return 0.0f;
        }
        return (this.d - dr1VarB.f()) / (dr1VarB.c() - dr1VarB.f());
    }

    public float f() {
        return this.d;
    }

    public final float g() {
        if (this.g == -1.0f) {
            this.g = this.c.e();
        }
        return this.g;
    }

    public Object h() {
        float fE = e();
        if (this.e == null && this.c.a(fE) && !p()) {
            return this.f;
        }
        dr1 dr1VarB = b();
        Interpolator interpolator = dr1VarB.e;
        Object objI = (interpolator == null || dr1VarB.f == null) ? i(dr1VarB, d()) : j(dr1VarB, fE, interpolator.getInterpolation(fE), dr1VarB.f.getInterpolation(fE));
        this.f = objI;
        return objI;
    }

    public abstract Object i(dr1 dr1Var, float f2);

    public Object j(dr1 dr1Var, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        return this.e != null;
    }

    public void l() {
        if (or1.h()) {
            or1.b("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i = 0; i < this.a.size(); i++) {
            ((b) this.a.get(i)).a();
        }
        if (or1.h()) {
            or1.c("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public void m() {
        this.b = true;
    }

    public void n(float f2) {
        if (or1.h()) {
            or1.b("BaseKeyframeAnimation#setProgress");
        }
        if (this.c.isEmpty()) {
            if (or1.h()) {
                or1.c("BaseKeyframeAnimation#setProgress");
                return;
            }
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.d) {
            if (or1.h()) {
                or1.c("BaseKeyframeAnimation#setProgress");
            }
        } else {
            this.d = f2;
            if (this.c.c(f2)) {
                l();
            }
            if (or1.h()) {
                or1.c("BaseKeyframeAnimation#setProgress");
            }
        }
    }

    public void o(y22 y22Var) {
        y22 y22Var2 = this.e;
        if (y22Var2 != null) {
            y22Var2.c(null);
        }
        this.e = y22Var;
        if (y22Var != null) {
            y22Var.c(this);
        }
    }

    public boolean p() {
        return false;
    }
}

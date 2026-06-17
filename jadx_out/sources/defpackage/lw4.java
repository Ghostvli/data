package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lw4 {
    public static volatile int a = 100;

    public abstract void a(Object obj, int i, int i2);

    public abstract void b(Object obj, int i, long j);

    public abstract void c(Object obj, int i, Object obj2);

    public abstract void d(Object obj, int i, hn hnVar);

    public abstract void e(Object obj, int i, long j);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, io3 io3Var, int i) {
        while (io3Var.A() != Integer.MAX_VALUE && m(obj, io3Var, i)) {
        }
    }

    public final boolean m(Object obj, io3 io3Var, int i) throws ol1 {
        int iA = io3Var.a();
        int iA2 = aa5.a(iA);
        int iB = aa5.b(iA);
        if (iB == 0) {
            e(obj, iA2, io3Var.M());
            return true;
        }
        if (iB == 1) {
            b(obj, iA2, io3Var.e());
            return true;
        }
        if (iB == 2) {
            d(obj, iA2, io3Var.D());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                if (i != 0) {
                    return false;
                }
                throw ol1.b();
            }
            if (iB != 5) {
                throw ol1.e();
            }
            a(obj, iA2, io3Var.i());
            return true;
        }
        Object objN = n();
        int iC = aa5.c(iA2, 4);
        int i2 = i + 1;
        if (i2 >= a) {
            throw ol1.i();
        }
        l(objN, io3Var, i2);
        if (iC != io3Var.a()) {
            throw ol1.b();
        }
        c(obj, iA2, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(io3 io3Var);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, ha5 ha5Var);

    public abstract void t(Object obj, ha5 ha5Var);
}

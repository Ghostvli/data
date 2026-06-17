package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface j02 {
    void A(String str, Object obj, Object obj2);

    void a(String str, Throwable th);

    void b(String str);

    void c(String str, Object obj);

    void d(String str, Object obj);

    boolean e();

    void error(String str);

    void f(String str, Object obj, Object obj2);

    boolean g();

    String getName();

    void h(String str, Object obj);

    void i(String str, Object obj, Object obj2);

    void info(String str);

    boolean j();

    void k(String str, Object... objArr);

    boolean l();

    void m(String str, Object obj, Object obj2);

    boolean n();

    void o(String str, Object obj, Object obj2);

    void p(String str, Object... objArr);

    void q(String str, Object obj);

    void r(String str, Object obj);

    void s(String str, Object... objArr);

    void t(String str, Throwable th);

    void u(String str, Throwable th);

    void v(String str, Throwable th);

    void w(String str, Throwable th);

    void warn(String str);

    default boolean x(rs1 rs1Var) {
        int iB = rs1Var.b();
        if (iB == 0) {
            return n();
        }
        if (iB == 10) {
            return g();
        }
        if (iB == 20) {
            return l();
        }
        if (iB == 30) {
            return e();
        }
        if (iB == 40) {
            return j();
        }
        f02.a("Level [", rs1Var, "] not recognized.");
        return false;
    }

    void y(String str);

    void z(String str, Object... objArr);
}

package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class mn4 {
    public static final mn4 a = new mn4();
    public static final ThreadLocal b = on4.a(new qj4("ThreadLocalEventLoop"));

    public final yu0 a() {
        return (yu0) b.get();
    }

    public final yu0 b() {
        ThreadLocal threadLocal = b;
        yu0 yu0Var = (yu0) threadLocal.get();
        if (yu0Var != null) {
            return yu0Var;
        }
        yu0 yu0VarA = bv0.a();
        threadLocal.set(yu0VarA);
        return yu0VarA;
    }

    public final void c() {
        b.set(null);
    }

    public final void d(yu0 yu0Var) {
        b.set(yu0Var);
    }
}

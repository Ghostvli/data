package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f42 implements qy3 {
    public static final qs2 b = new a();
    public final qs2 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements qs2 {
        @Override // defpackage.qs2
        public ps2 a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // defpackage.qs2
        public boolean b(Class cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ki3.values().length];
            a = iArr;
            try {
                iArr[ki3.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements qs2 {
        public qs2[] a;

        public c(qs2... qs2VarArr) {
            this.a = qs2VarArr;
        }

        @Override // defpackage.qs2
        public ps2 a(Class cls) {
            for (qs2 qs2Var : this.a) {
                if (qs2Var.b(cls)) {
                    return qs2Var.a(cls);
                }
            }
            fn.a("No factory is available for message type: ".concat(cls.getName()));
            return null;
        }

        @Override // defpackage.qs2
        public boolean b(Class cls) {
            for (qs2 qs2Var : this.a) {
                if (qs2Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public f42(qs2 qs2Var) {
        this.a = (qs2) bl1.b(qs2Var, "messageInfoFactory");
    }

    public static boolean b(ps2 ps2Var) {
        return b.a[ps2Var.c().ordinal()] != 1;
    }

    public static qs2 c() {
        return new c(h91.c(), d());
    }

    public static qs2 d() {
        if (s5.b) {
            return b;
        }
        try {
            return (qs2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return b;
        }
    }

    public static py3 e(Class cls, ps2 ps2Var) {
        if (f(cls)) {
            return us2.Q(cls, ps2Var, z23.b(), eu1.b(), sy3.P(), b(ps2Var) ? az0.b() : null, p42.b());
        }
        x23 x23VarA = z23.a();
        yy0 yy0VarA = null;
        cu1 cu1VarA = eu1.a();
        lw4 lw4VarO = sy3.O();
        if (b(ps2Var)) {
            yy0VarA = az0.a();
        }
        return us2.Q(cls, ps2Var, x23VarA, cu1VarA, lw4VarO, yy0VarA, p42.a());
    }

    public static boolean f(Class cls) {
        return s5.b || i91.class.isAssignableFrom(cls);
    }

    @Override // defpackage.qy3
    public py3 a(Class cls) {
        sy3.L(cls);
        ps2 ps2VarA = this.a.a(cls);
        return ps2VarA.a() ? f(cls) ? vs2.l(sy3.P(), az0.b(), ps2VarA.b()) : vs2.l(sy3.O(), az0.a(), ps2VarA.b()) : e(cls, ps2VarA);
    }

    public f42() {
        this(c());
    }
}

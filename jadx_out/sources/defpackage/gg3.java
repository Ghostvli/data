package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gg3 {
    public static void A(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        e04.a(mb3.b(str, obj));
    }

    public static void B(boolean z, String str, Object obj, Object obj2) {
        if (z) {
            return;
        }
        e04.a(mb3.b(str, obj, obj2));
    }

    public static String a(int i, int i2, String str) {
        if (i < 0) {
            return gg4.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return gg4.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        b.a("negative size: ", i2);
        return null;
    }

    public static String b(int i, int i2, String str) {
        if (i < 0) {
            return gg4.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return gg4.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        b.a("negative size: ", i2);
        return null;
    }

    public static String c(int i, int i2, int i3) {
        return (i < 0 || i > i3) ? b(i, i3, "start index") : (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : gg4.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void d(boolean z) {
        if (z) {
            return;
        }
        d04.a();
    }

    public static void e(boolean z, Object obj) {
        if (z) {
            return;
        }
        jl.a(mb3.f(obj));
    }

    public static void f(boolean z, String str, char c) {
        if (z) {
            return;
        }
        jl.a(gg4.b(str, Character.valueOf(c)));
    }

    public static void g(boolean z, String str, int i) {
        if (z) {
            return;
        }
        jl.a(gg4.b(str, Integer.valueOf(i)));
    }

    public static void h(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        jl.a(gg4.b(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static void i(boolean z, String str, long j) {
        if (z) {
            return;
        }
        jl.a(gg4.b(str, Long.valueOf(j)));
    }

    public static void j(boolean z, String str, long j, long j2) {
        if (z) {
            return;
        }
        jl.a(gg4.b(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    public static void k(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        jl.a(mb3.b(str, obj));
    }

    public static void l(boolean z, String str, Object obj, int i) {
        if (z) {
            return;
        }
        jl.a(mb3.b(str, obj, Integer.valueOf(i)));
    }

    public static void m(boolean z, String str, Object obj, Object obj2) {
        if (z) {
            return;
        }
        jl.a(mb3.b(str, obj, obj2));
    }

    public static void n(boolean z, String str, Object... objArr) {
        if (z) {
            return;
        }
        jl.a(mb3.b(str, objArr));
    }

    public static int o(int i, int i2) {
        return p(i, i2, "index");
    }

    public static int p(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        x32.a(a(i, i2, str));
        return 0;
    }

    public static Object q(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object r(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        om1.a(mb3.f(obj2));
        return null;
    }

    public static int s(int i, int i2) {
        return t(i, i2, "index");
    }

    public static int t(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        x32.a(b(i, i2, str));
        return 0;
    }

    public static void u(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            x32.a(c(i, i2, i3));
        }
    }

    public static void v(boolean z) {
        if (z) {
            return;
        }
        z20.a();
    }

    public static void w(boolean z, Object obj) {
        if (z) {
            return;
        }
        e04.a(mb3.f(obj));
    }

    public static void x(boolean z, String str, char c, char c2) {
        if (z) {
            return;
        }
        e04.a(gg4.b(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    public static void y(boolean z, String str, int i) {
        if (z) {
            return;
        }
        e04.a(gg4.b(str, Integer.valueOf(i)));
    }

    public static void z(boolean z, String str, long j, long j2) {
        if (z) {
            return;
        }
        e04.a(gg4.b(str, Long.valueOf(j), Long.valueOf(j2)));
    }
}

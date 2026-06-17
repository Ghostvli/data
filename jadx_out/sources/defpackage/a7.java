package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a7 {
    public static List a(no1 no1Var, float f, f12 f12Var, cz4 cz4Var) {
        return gr1.a(no1Var, f12Var, f, cz4Var, false);
    }

    public static List b(no1 no1Var, f12 f12Var, cz4 cz4Var) {
        return gr1.a(no1Var, f12Var, 1.0f, cz4Var, false);
    }

    public static i6 c(no1 no1Var, f12 f12Var) {
        return new i6(b(no1Var, f12Var, dx.a));
    }

    public static s6 d(no1 no1Var, f12 f12Var) {
        return new s6(a(no1Var, uy4.e(), f12Var, ym0.a));
    }

    public static j6 e(no1 no1Var, f12 f12Var) {
        return f(no1Var, f12Var, true);
    }

    public static j6 f(no1 no1Var, f12 f12Var, boolean z) {
        return new j6(a(no1Var, z ? uy4.e() : 1.0f, f12Var, u21.a));
    }

    public static k6 g(no1 no1Var, f12 f12Var, int i) {
        return new k6(b(no1Var, f12Var, new za1(i)));
    }

    public static l6 h(no1 no1Var, f12 f12Var) {
        return new l6(b(no1Var, f12Var, wk1.a));
    }

    public static o6 i(no1 no1Var, f12 f12Var) {
        return new o6(gr1.a(no1Var, f12Var, uy4.e(), ef3.a, true));
    }

    public static p6 j(no1 no1Var, f12 f12Var) {
        return new p6(b(no1Var, f12Var, cy3.a));
    }

    public static q6 k(no1 no1Var, f12 f12Var) {
        return new q6(a(no1Var, uy4.e(), f12Var, c54.a));
    }
}

package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k40 {
    public static g40 a(mp3 mp3Var, boolean z, g40 g40Var, g40.b bVar) {
        return g40Var.N(bVar);
    }

    public static g40 b(g40 g40Var, g40.b bVar) {
        return g40Var.N(bVar);
    }

    public static boolean c(boolean z, g40.b bVar) {
        return z;
    }

    public static final g40 d(g40 g40Var, g40 g40Var2, final boolean z) {
        boolean zF = f(g40Var);
        boolean zF2 = f(g40Var2);
        if (!zF && !zF2) {
            return g40Var.N(g40Var2);
        }
        final mp3 mp3Var = new mp3();
        mp3Var.f = g40Var2;
        bs0 bs0Var = bs0.f;
        g40 g40Var3 = (g40) g40Var.T(bs0Var, new Function2() { // from class: i40
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return k40.a(mp3Var, z, (g40) obj, (g40.b) obj2);
            }
        });
        if (zF2) {
            mp3Var.f = ((g40) mp3Var.f).T(bs0Var, new Function2() { // from class: j40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return k40.b((g40) obj, (g40.b) obj2);
                }
            });
        }
        return g40Var3.N((g40) mp3Var.f);
    }

    public static final String e(g40 g40Var) {
        return null;
    }

    public static final boolean f(g40 g40Var) {
        return ((Boolean) g40Var.T(Boolean.FALSE, new Function2() { // from class: h40
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(k40.c(((Boolean) obj).booleanValue(), (g40.b) obj2));
            }
        })).booleanValue();
    }

    public static final g40 g(g40 g40Var, g40 g40Var2) {
        return !f(g40Var2) ? g40Var.N(g40Var2) : d(g40Var, g40Var2, false);
    }

    public static final g40 h(u40 u40Var, g40 g40Var) {
        g40 g40VarD = d(u40Var.g(), g40Var, true);
        return (g40VarD == mm0.a() || g40VarD.a(h30.b) != null) ? g40VarD : g40VarD.N(mm0.a());
    }

    public static final zv4 i(x40 x40Var) {
        while (!(x40Var instanceof im0) && (x40Var = x40Var.getCallerFrame()) != null) {
            if (x40Var instanceof zv4) {
                return (zv4) x40Var;
            }
        }
        return null;
    }

    public static final zv4 j(f30 f30Var, g40 g40Var, Object obj) {
        if (!(f30Var instanceof x40) || g40Var.a(bw4.f) == null) {
            return null;
        }
        zv4 zv4VarI = i((x40) f30Var);
        if (zv4VarI != null) {
            zv4VarI.T0(g40Var, obj);
        }
        return zv4VarI;
    }
}

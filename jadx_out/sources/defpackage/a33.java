package defpackage;

import defpackage.wf4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a33 {
    public static final String a = "a33";
    public static gn0 b;
    public static pz1 c;
    public static m20 d;

    public static gn0 a() {
        return b;
    }

    public static m20 b() {
        m20 m20Var = d;
        return m20Var == null ? m20.g : m20Var;
    }

    public static pz1 c() {
        pz1 pz1Var = c;
        return pz1Var == null ? pz1.h : pz1Var;
    }

    public static wf4 d(String str) throws fz0 {
        for (wf4 wf4Var : x14.a()) {
            if (wf4Var.c(str) != wf4.a.NONE) {
                return wf4Var;
            }
        }
        throw new fz0("No service can handle the url = \"" + str + "\"");
    }

    public static void e(gn0 gn0Var, pz1 pz1Var) {
        kz0.a(a, "Default init called with localization={}");
        f(gn0Var, pz1Var, pz1Var.d().isEmpty() ? m20.g : new m20(pz1Var.d()));
    }

    public static void f(gn0 gn0Var, pz1 pz1Var, m20 m20Var) {
        kz0.b(a, "Initializing with downloader={}, localization={}, country={}", gn0Var, pz1Var, m20Var);
        b = gn0Var;
        c = pz1Var;
        d = m20Var;
    }
}

package defpackage;

import defpackage.ja0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n90 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ja0 a(tq3 tq3Var, String str, vn3 vn3Var, int i, Map map) {
        return new ja0.b().i(vn3Var.b(str)).h(vn3Var.a).g(vn3Var.b).f(b(tq3Var, vn3Var)).b(i).e(map).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b(tq3 tq3Var, vn3 vn3Var) {
        String strK = tq3Var.k();
        return strK != null ? strK : vn3Var.b(((dj) tq3Var.c.get(0)).a).toString();
    }
}

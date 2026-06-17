package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gn0 {
    public abstract ws3 a(xq3 xq3Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 b(String str) {
        return e(str, null, a33.c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 c(String str, pz1 pz1Var) {
        return e(str, null, pz1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 d(String str, Map map) {
        return e(str, map, a33.c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 e(String str, Map map, pz1 pz1Var) {
        return a(xq3.e().h(str).j(map).k(pz1Var).g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 f(String str) {
        return g(str, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 g(String str, Map map) {
        return a(xq3.e().i(str).j(map).g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 h(String str, Map map, byte[] bArr, pz1 pz1Var) {
        return a(xq3.e().l(str, bArr).j(map).k(pz1Var).g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 i(String str, Map map, byte[] bArr, pz1 pz1Var, String str2) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("Content-Type", Collections.singletonList(str2));
        return h(str, map2, bArr, pz1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 j(String str, Map map, byte[] bArr) {
        return k(str, map, bArr, a33.c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ws3 k(String str, Map map, byte[] bArr, pz1 pz1Var) {
        return i(str, map, bArr, pz1Var, "application/json");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getClass().getSimpleName();
    }
}

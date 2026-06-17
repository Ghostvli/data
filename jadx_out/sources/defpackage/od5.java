package defpackage;

import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class od5 {
    public static void a(fo1 fo1Var, String str, String str2) {
        fo1Var.h("videoId", str);
        if (str2 != null) {
            fo1Var.h("cpn", str2);
        }
        fo1Var.i("contentCheckOk", true).i("racyCheckOk", true);
    }

    public static ko1 b(m20 m20Var, pz1 pz1Var, String str, String str2) {
        ek1 ek1VarA = ek1.a();
        Map mapD = d(cc5.x(pz1Var));
        ek1VarA.a.e = cc5.Q(ek1VarA, pz1Var, m20Var, mapD, "https://youtubei.googleapis.com/youtubei/v1/", null, false);
        fo1 fo1VarI0 = cc5.i0(pz1Var, m20Var, ek1VarA, null);
        fo1VarI0.e("playerRequest");
        a(fo1VarI0, str, str2);
        fo1VarI0.c().i("disablePlayerResponse", false);
        return xo1.k(cc5.P(a33.a().k("https://youtubei.googleapis.com/youtubei/v1/reel/reel_item_watch?prettyPrint=false&t=" + cc5.w() + "&id=" + str + "&$fields=playerResponse", mapD, zo1.b(fo1VarI0.b()).getBytes(StandardCharsets.UTF_8), pz1Var))).m("playerResponse");
    }

    public static ko1 c(m20 m20Var, pz1 pz1Var, String str, String str2, df3 df3Var) {
        ek1 ek1VarB = ek1.b();
        Map mapD = d(cc5.G(pz1Var));
        ek1VarB.a.e = cc5.Q(ek1VarB, pz1Var, m20Var, mapD, "https://www.youtube.com/youtubei/v1/", null, false);
        fo1 fo1VarI0 = cc5.i0(pz1Var, m20Var, ek1VarB, null);
        a(fo1VarI0, str, str2);
        return xo1.k(cc5.P(a33.a().k("https://youtubei.googleapis.com/youtubei/v1/player?prettyPrint=false&t=" + cc5.w() + "&id=" + str, mapD, zo1.b(fo1VarI0.b()).getBytes(StandardCharsets.UTF_8), pz1Var)));
    }

    public static Map d(String str) {
        return m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("User-Agent", av4.a(new Object[]{str})), new AbstractMap.SimpleEntry("X-Goog-Api-Format-Version", av4.a(new Object[]{"2"}))});
    }

    public static ko1 e(pz1 pz1Var, m20 m20Var, String str) {
        ek1 ek1VarC = ek1.c();
        ek1VarC.a.b = cc5.A();
        Map mapR = cc5.R();
        ek1VarC.a.e = cc5.Q(ek1VarC, pz1Var, m20Var, mapR, "https://www.youtube.com/youtubei/v1/", null, false);
        fo1 fo1VarI0 = cc5.i0(pz1Var, m20Var, ek1VarC, null);
        a(fo1VarI0, str, null);
        return xo1.k(cc5.P(a33.a().k("https://www.youtube.com/youtubei/v1/player?prettyPrint=false&$fields=microformat,videoDetails.thumbnail.thumbnails,videoDetails.videoId", mapR, zo1.b(fo1VarI0.b()).getBytes(StandardCharsets.UTF_8), pz1Var)));
    }
}

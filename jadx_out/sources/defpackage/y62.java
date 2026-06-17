package defpackage;

import android.net.Uri;
import com.fongmi.android.tv.service.PlaybackService;
import com.google.gson.JsonObject;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y62 implements zg3 {
    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith("/media");
    }

    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        PlaybackService playbackServiceF = t14.b().f();
        if (playbackServiceF == null) {
            return gx2.f("{}");
        }
        me3 me3VarPlayer = playbackServiceF.player();
        fg2 fg2VarV = me3VarPlayer.v();
        ph2 ph2Var = fg2VarV != null ? fg2VarV.e : ph2.M;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("state", Integer.valueOf(c(me3VarPlayer)));
        jsonObject.addProperty("speed", Float.valueOf(me3VarPlayer.G()));
        jsonObject.addProperty("duration", Long.valueOf(me3VarPlayer.z()));
        jsonObject.addProperty("position", Long.valueOf(me3VarPlayer.E()));
        jsonObject.addProperty("url", e(me3VarPlayer.I()));
        jsonObject.addProperty("title", e(ph2Var.a));
        jsonObject.addProperty("artist", e(ph2Var.b));
        jsonObject.addProperty("artwork", d(ph2Var.n));
        return gx2.f(jsonObject.toString());
    }

    public final int c(me3 me3Var) {
        if (me3Var.S()) {
            return 3;
        }
        int iC = me3Var.C();
        if (iC == 2) {
            return 6;
        }
        return iC == 3 ? 2 : 1;
    }

    public final String d(Uri uri) {
        return uri != null ? uri.toString() : "";
    }

    public final String e(CharSequence charSequence) {
        return charSequence != null ? charSequence.toString() : "";
    }
}

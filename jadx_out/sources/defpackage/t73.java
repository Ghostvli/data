package defpackage;

import com.github.catvod.utils.Asset;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t73 implements zg3 {
    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith("/parse");
    }

    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        try {
            Map<String, String> parms = iHTTPSession.getParms();
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_HTML, String.format(Asset.read("parse.html"), parms.get("jxs"), parms.get("url")));
        } catch (Exception e) {
            return gx2.c(e.getMessage());
        }
    }
}

package defpackage;

import android.text.TextUtils;
import com.github.catvod.utils.Prefers;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class co implements zg3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith("/cache");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        Map<String, String> parms = iHTTPSession.getParms();
        String str2 = parms.get("do");
        String str3 = parms.get("rule");
        String str4 = parms.get("key");
        if ("get".equals(str2)) {
            return gx2.f(Prefers.getString(c(str3, str4)));
        }
        if ("set".equals(str2)) {
            Prefers.put(c(str3, str4), parms.get(ES6Iterator.VALUE_PROPERTY));
        }
        if ("del".equals(str2)) {
            Prefers.remove(c(str3, str4));
        }
        return gx2.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String c(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder("cache_");
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "_";
        }
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }
}

package defpackage;

import com.fongmi.android.tv.bean.Device;
import com.github.catvod.utils.Asset;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gx2 extends NanoHTTPD {
    public List a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gx2(int i) {
        super(i);
        a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NanoHTTPD.Response b(NanoHTTPD.Response.Status status, String str) {
        return NanoHTTPD.newFixedLengthResponse(status, NanoHTTPD.MIME_PLAINTEXT, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NanoHTTPD.Response c(String str) {
        return b(NanoHTTPD.Response.Status.INTERNAL_ERROR, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NanoHTTPD.Response e() {
        return f("OK");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NanoHTTPD.Response f(String str) {
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new p2());
        this.a.add(new co());
        this.a.add(new fz1());
        this.a.add(new y62());
        this.a.add(new t73());
        this.a.add(new ri3());
        this.a.add(new xt4());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response d(String str) {
        try {
            if (str.isEmpty()) {
                str = "index.html";
            }
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.getMimeTypeForFile(str), Asset.open(str), -1L);
        } catch (Exception unused) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, null, 0L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(NanoHTTPD.IHTTPSession iHTTPSession, Map map) {
        try {
            String str = iHTTPSession.getHeaders().get("content-type");
            if (str != null) {
                iHTTPSession.getHeaders().put("content-type", str.replace("multipart/form-data", "multipart/form-data; charset=utf-8"));
            }
            iHTTPSession.parseBody(map);
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        String strTrim = iHTTPSession.getUri().trim();
        HashMap map = new HashMap();
        if (iHTTPSession.getMethod() == NanoHTTPD.Method.POST) {
            g(iHTTPSession, map);
        }
        if (strTrim.startsWith("/tvbus")) {
            return f(lx1.Q());
        }
        if (strTrim.startsWith("/device")) {
            return f(Device.get().toString());
        }
        for (zg3 zg3Var : this.a) {
            if (zg3Var.a(iHTTPSession, strTrim)) {
                return zg3Var.b(iHTTPSession, strTrim, map);
            }
        }
        return d(strTrim.substring(1));
    }
}

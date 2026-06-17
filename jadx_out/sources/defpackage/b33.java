package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b33 extends gn0 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile b33 a = new b33();
    }

    public static b33 l() {
        return a.a;
    }

    @Override // defpackage.gn0
    public ws3 a(xq3 xq3Var) throws fo3 {
        String strD = xq3Var.d();
        String strF = xq3Var.f();
        Map mapC = xq3Var.c();
        byte[] bArrA = xq3Var.a();
        Request.Builder builderAddHeader = new Request.Builder().method(strD, bArrA != null ? RequestBody.create((MediaType) null, bArrA) : null).url(strF).addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:128.0) Gecko/20100101 Firefox/128.0");
        for (Map.Entry entry : mapC.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() > 1) {
                builderAddHeader.removeHeader(str);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    builderAddHeader.addHeader(str, (String) it.next());
                }
            } else if (list.size() == 1) {
                builderAddHeader.header(str, (String) list.get(0));
            }
        }
        Response responseExecute = q53.j().newCall(builderAddHeader.build()).execute();
        if (responseExecute.code() != 429) {
            return new ws3(responseExecute.code(), responseExecute.message(), responseExecute.headers().toMultimap(), responseExecute.body().string(), responseExecute.request().url().toString());
        }
        responseExecute.close();
        throw new fo3("reCaptcha Challenge requested", strF);
    }
}

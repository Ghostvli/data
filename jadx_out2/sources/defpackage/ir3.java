package defpackage;

import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ir3 implements Interceptor {
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(HttpUrl httpUrl, Request.Builder builder) {
        String strHost = httpUrl.host();
        String strQueryParameter = httpUrl.queryParameter("auth");
        ConcurrentHashMap concurrentHashMap = this.a;
        if (strQueryParameter != null) {
            concurrentHashMap.put(strHost, strQueryParameter);
        } else if (concurrentHashMap.containsKey(strHost)) {
            builder.url(httpUrl.newBuilder().addQueryParameter("auth", (String) this.a.get(strHost)).build());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        a(request.url(), builderNewBuilder);
        return chain.proceed(builderNewBuilder.build());
    }
}

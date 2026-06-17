package defpackage;

import com.github.catvod.utils.Auth;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ke implements Interceptor {
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Request a(Request request) {
        URI uri = request.url().uri();
        if (uri.getUserInfo() == null) {
            return request;
        }
        this.a.put(request.url().host(), uri.getUserInfo());
        return request.newBuilder().header("Authorization", Auth.basic(uri.getUserInfo())).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean c(String str) {
        return str != null && str.startsWith("Digest");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request requestA = a(chain.request());
        Response responseProceed = chain.proceed(requestA);
        if (responseProceed.code() == 401) {
            String strHost = requestA.url().host();
            String userInfo = requestA.url().uri().getUserInfo();
            if (userInfo == null) {
                userInfo = (String) this.a.get(strHost);
            }
            if (userInfo != null) {
                responseProceed.close();
                String strHeader = responseProceed.header("WWW-Authenticate");
                return chain.proceed(requestA.newBuilder().header("Authorization", c(strHeader) ? Auth.digest(userInfo, strHeader, requestA) : Auth.basic(userInfo)).build());
            }
        }
        return responseProceed;
    }
}

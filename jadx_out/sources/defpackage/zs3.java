package defpackage;

import com.github.catvod.utils.Json;
import com.github.catvod.utils.Util;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zs3 implements Interceptor {
    public final List a = new CopyOnWriteArrayList();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ResponseBody {
        public final /* synthetic */ Response f;
        public final /* synthetic */ InflaterInputStream g;

        public a(Response response, InflaterInputStream inflaterInputStream) {
            this.f = response;
            this.g = inflaterInputStream;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f.body().contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f.body().contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return Okio.buffer(Okio.source(this.g));
        }
    }

    private Request b(Request request) {
        String strHost = request.url().host();
        final Request.Builder builderNewBuilder = request.newBuilder();
        for (xc1 xc1Var : this.a) {
            if (Util.containOrMatch(strHost, xc1Var.c())) {
                Map<String, String> map = Json.toMap(xc1Var.b());
                Objects.requireNonNull(builderNewBuilder);
                map.forEach(new BiConsumer() { // from class: ys3
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        builderNewBuilder.header((String) obj, (String) obj2);
                    }
                });
            }
        }
        return builderNewBuilder.build();
    }

    public void a(List list) {
        this.a.addAll(list);
    }

    public void c() {
        this.a.clear();
        this.b.clear();
    }

    public final Response d(Response response) {
        return response.newBuilder().headers(response.headers()).body(new a(response, new InflaterInputStream(response.body().byteStream(), new Inflater(true)))).build();
    }

    public final Response e(Request request, Response response) {
        return new Response.Builder().request(request).protocol(response.protocol()).code(302).message("Found").header("Location", (String) this.b.get(request.url().toString())).build();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request requestB = b(chain.request());
        Response responseProceed = chain.proceed(requestB);
        if ("deflate".equals(responseProceed.header("Content-Encoding"))) {
            return d(responseProceed);
        }
        if (responseProceed.code() == 406 && this.b.containsKey(requestB.url().toString())) {
            return e(requestB, responseProceed);
        }
        if (responseProceed.code() == 302 && responseProceed.header("Location") != null) {
            this.b.put(responseProceed.header("Location"), requestB.url().toString());
        }
        return responseProceed;
    }
}

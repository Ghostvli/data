package okhttp3;

import defpackage.dp1;
import defpackage.e04;
import defpackage.fn;
import defpackage.hp1;
import defpackage.i73;
import defpackage.il1;
import defpackage.jl;
import defpackage.np3;
import defpackage.ow;
import defpackage.r53;
import defpackage.sg4;
import defpackage.vq3;
import defpackage.we0;
import java.net.URL;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.EmptyTags;
import okhttp3.internal.IsProbablyUtf8Kt;
import okhttp3.internal.Tags;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.GzipRequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Request {
    private final RequestBody body;
    private final HttpUrl cacheUrlOverride;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Tags tags;
    private final HttpUrl url;

    public Request(Builder builder) {
        builder.getClass();
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp == null) {
            e04.a("url == null");
            throw null;
        }
        this.url = url$okhttp;
        this.method = builder.getMethod$okhttp();
        this.headers = builder.getHeaders$okhttp().build();
        this.body = builder.getBody$okhttp();
        this.cacheUrlOverride = builder.getCacheUrlOverride$okhttp();
        this.tags = builder.getTags$okhttp();
    }

    private final String shellEscape(String str) {
        return "'" + sg4.G(str, "'", "'\\''", false, 4, null) + '\'';
    }

    public static /* synthetic */ String toCurl$default(Request request, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return request.toCurl(z);
    }

    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m131deprecated_body() {
        return this.body;
    }

    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m132deprecated_cacheControl() {
        return cacheControl();
    }

    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m133deprecated_headers() {
        return this.headers;
    }

    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m134deprecated_method() {
        return this.method;
    }

    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m135deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final HttpUrl cacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    public final Tags getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        str.getClass();
        return this.headers.get(str);
    }

    public final List<String> headers(String str) {
        str.getClass();
        return this.headers.values(str);
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final /* synthetic */ <T> T reifiedTag() {
        il1.d(4, "T");
        return (T) tag(np3.b(Object.class));
    }

    public final <T> T tag(hp1 hp1Var) {
        hp1Var.getClass();
        return (T) dp1.a(hp1Var).cast(this.tags.get(hp1Var));
    }

    public final String toCurl(boolean z) {
        MediaType mediaTypeContentType;
        StringBuilder sb = new StringBuilder();
        sb.append("curl " + shellEscape(this.url.toString()));
        RequestBody requestBody = this.body;
        String string = (requestBody == null || (mediaTypeContentType = requestBody.contentType()) == null) ? null : mediaTypeContentType.toString();
        if (!il1.a(this.method, (!z || this.body == null) ? "GET" : "POST")) {
            sb.append(" \\\n  -X " + shellEscape(this.method));
        }
        for (i73 i73Var : this.headers) {
            String str = (String) i73Var.a();
            String str2 = (String) i73Var.b();
            if (string == null || !sg4.y(str, "Content-Type", true)) {
                StringBuilder sb2 = new StringBuilder(" \\\n  -H ");
                sb2.append(shellEscape(str + ": " + str2));
                sb.append(sb2.toString());
            }
        }
        if (string != null) {
            sb.append(" \\\n  -H " + shellEscape("Content-Type: ".concat(string)));
        }
        if (z && this.body != null) {
            Buffer buffer = new Buffer();
            this.body.writeTo(buffer);
            if (IsProbablyUtf8Kt.isProbablyUtf8$default(buffer, 0L, 1, null)) {
                sb.append(" \\\n  --data " + shellEscape(buffer.readUtf8()));
            } else {
                sb.append(" \\\n  --data-binary " + shellEscape(buffer.readByteString().hex()));
            }
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (i73 i73Var : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    ow.s();
                }
                i73 i73Var2 = i73Var;
                String str = (String) i73Var2.a();
                String str2 = (String) i73Var2.b();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                if (_UtilCommonKt.isSensitiveHeader(str)) {
                    str2 = "██";
                }
                sb.append(str2);
                i = i2;
            }
            sb.append(']');
        }
        if (!il1.a(this.tags, EmptyTags.INSTANCE)) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        return sb.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Builder {
        private RequestBody body;
        private HttpUrl cacheUrlOverride;
        private Headers.Builder headers;
        private String method;
        private Tags tags;
        private HttpUrl url;

        public Builder(Request request) {
            request.getClass();
            this.tags = EmptyTags.INSTANCE;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp();
            this.headers = request.headers().newBuilder();
            this.cacheUrlOverride = request.cacheUrlOverride();
        }

        private final String canonicalUrl(String str) {
            return sg4.I(str, "ws:", true) ? "http:".concat(str.substring(3)) : sg4.I(str, "wss:", true) ? "https:".concat(str.substring(4)) : str;
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                fn.a("Super calls with default arguments not supported in this target, function: delete");
                return null;
            }
            if ((i & 1) != 0) {
                requestBody = RequestBody.EMPTY;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String str, String str2) {
            str.getClass();
            str2.getClass();
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder cacheControl(CacheControl cacheControl) {
            cacheControl.getClass();
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder cacheUrlOverride(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
            return this;
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final HttpUrl getCacheUrlOverride$okhttp() {
            return this.cacheUrlOverride;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Tags getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final Builder gzip() {
            RequestBody requestBody = this.body;
            if (requestBody == null) {
                e04.a("cannot gzip a request that has no body");
                return null;
            }
            String str = this.headers.get("Content-Encoding");
            if (str != null) {
                r53.a("Content-Encoding already set: ", str);
                return null;
            }
            this.headers.add("Content-Encoding", "gzip");
            this.body = new GzipRequestBody(requestBody);
            return this;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            str.getClass();
            str2.getClass();
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            headers.getClass();
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            str.getClass();
            if (str.length() <= 0) {
                jl.a("method.isEmpty() == true");
                return null;
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(str)) {
                    vq3.a("method ", str, " must have a request body.");
                    return null;
                }
            } else if (!HttpMethod.permitsRequestBody(str)) {
                vq3.a("method ", str, " must not have a request body.");
                return null;
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            requestBody.getClass();
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            requestBody.getClass();
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            requestBody.getClass();
            return method("PUT", requestBody);
        }

        public Builder query(RequestBody requestBody) {
            requestBody.getClass();
            return method("QUERY", requestBody);
        }

        public final /* synthetic */ <T> Builder reifiedTag(T t) {
            il1.d(4, "T");
            return tag(np3.b(Object.class), t);
        }

        public Builder removeHeader(String str) {
            str.getClass();
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setCacheUrlOverride$okhttp(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            builder.getClass();
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            str.getClass();
            this.method = str;
        }

        public final void setTags$okhttp(Tags tags) {
            tags.getClass();
            this.tags = tags;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public final <T> Builder tag(hp1 hp1Var, T t) {
            hp1Var.getClass();
            this.tags = this.tags.plus(hp1Var, t);
            return this;
        }

        public Builder url(URL url) {
            url.getClass();
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            string.getClass();
            return url(companion.get(string));
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder tag(Object obj) {
            return tag(np3.b(Object.class), obj);
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            cls.getClass();
            return tag(dp1.c(cls), t);
        }

        public Builder url(String str) {
            str.getClass();
            return url(HttpUrl.Companion.get(canonicalUrl(str)));
        }

        public Builder url(HttpUrl httpUrl) {
            httpUrl.getClass();
            this.url = httpUrl;
            return this;
        }

        public Builder() {
            this.tags = EmptyTags.INSTANCE;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }
    }

    public final Headers headers() {
        return this.headers;
    }

    public final <T> T tag(Class<? extends T> cls) {
        cls.getClass();
        return (T) tag(dp1.c(cls));
    }

    public final Object tag() {
        return tag(np3.b(Object.class));
    }

    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i, we0 we0Var) {
        this(httpUrl, (i & 2) != 0 ? Headers.Companion.of(new String[0]) : headers, (i & 4) != 0 ? "\u0000" : str, (i & 8) != 0 ? null : requestBody);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody) {
        httpUrl.getClass();
        headers.getClass();
        str.getClass();
        Builder builderHeaders = new Builder().url(httpUrl).headers(headers);
        if (il1.a(str, "\u0000")) {
            if (requestBody != null) {
                str = "POST";
            } else {
                str = "GET";
            }
        }
        this(builderHeaders.method(str, requestBody));
    }

    public final String toCurl() {
        return toCurl$default(this, false, 1, null);
    }
}

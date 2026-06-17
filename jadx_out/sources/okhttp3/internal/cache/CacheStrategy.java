package okhttp3.internal.cache;

import defpackage.sg4;
import defpackage.we0;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.DateFormattingKt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheStrategy {
    public static final Companion Companion = new Companion(null);
    private final Response cacheResponse;
    private final Request networkRequest;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j, Request request, Response response) {
            request.getClass();
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = response;
            this.ageSeconds = -1;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String strName = headers.name(i);
                    String strValue = headers.value(i);
                    if (sg4.y(strName, "Date", true)) {
                        this.servedDate = DateFormattingKt.toHttpDateOrNull(strValue);
                        this.servedDateString = strValue;
                    } else if (sg4.y(strName, "Expires", true)) {
                        this.expires = DateFormattingKt.toHttpDateOrNull(strValue);
                    } else if (sg4.y(strName, "Last-Modified", true)) {
                        this.lastModified = DateFormattingKt.toHttpDateOrNull(strValue);
                        this.lastModifiedString = strValue;
                    } else if (sg4.y(strName, "ETag", true)) {
                        this.etag = strValue;
                    } else if (sg4.y(strName, "Age", true)) {
                        this.ageSeconds = _UtilCommonKt.toNonNegativeInt(strValue, -1);
                    }
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            return jMax + Math.max(0L, this.receivedResponseMillis - this.sentRequestMillis) + Math.max(0L, this.nowMillis - this.receivedResponseMillis);
        }

        private final CacheStrategy computeCandidate() {
            String str;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            int iMaxAgeSeconds = cacheControl.maxAgeSeconds();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (iMaxAgeSeconds != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, timeUnit.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? timeUnit.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = timeUnit.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j = millis2 + jCacheResponseAge;
                if (j < millis + jComputeFreshnessLifetime) {
                    Response.Builder builderNewBuilder = this.cacheResponse.newBuilder();
                    if (j >= jComputeFreshnessLifetime) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builderNewBuilder.build());
                }
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else {
                    if (this.servedDate == null) {
                        return new CacheStrategy(this.request, null);
                    }
                    str2 = this.servedDateString;
                }
                str = "If-Modified-Since";
            }
            Headers.Builder builderNewBuilder2 = this.request.headers().newBuilder();
            str2.getClass();
            builderNewBuilder2.addLenient$okhttp(str, str2);
            return new CacheStrategy(this.request.newBuilder().headers(builderNewBuilder2.build()).build(), this.cacheResponse);
        }

        private final long computeFreshnessLifetime() {
            Response response = this.cacheResponse;
            response.getClass();
            if (response.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                date4.getClass();
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / 10;
                }
            }
            return 0L;
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            response.getClass();
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        public final CacheStrategy compute() {
            CacheStrategy cacheStrategyComputeCandidate = computeCandidate();
            return (cacheStrategyComputeCandidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) ? cacheStrategyComputeCandidate : new CacheStrategy(null, null);
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean isCacheable(okhttp3.Response r4, okhttp3.Request r5) {
            /*
                r3 = this;
                r4.getClass()
                r5.getClass()
                int r3 = r4.code()
                r0 = 200(0xc8, float:2.8E-43)
                r1 = 0
                if (r3 == r0) goto L61
                r0 = 410(0x19a, float:5.75E-43)
                if (r3 == r0) goto L61
                r0 = 414(0x19e, float:5.8E-43)
                if (r3 == r0) goto L61
                r0 = 501(0x1f5, float:7.02E-43)
                if (r3 == r0) goto L61
                r0 = 203(0xcb, float:2.84E-43)
                if (r3 == r0) goto L61
                r0 = 204(0xcc, float:2.86E-43)
                if (r3 == r0) goto L61
                r0 = 307(0x133, float:4.3E-43)
                if (r3 == r0) goto L37
                r0 = 308(0x134, float:4.32E-43)
                if (r3 == r0) goto L61
                r0 = 404(0x194, float:5.66E-43)
                if (r3 == r0) goto L61
                r0 = 405(0x195, float:5.68E-43)
                if (r3 == r0) goto L61
                switch(r3) {
                    case 300: goto L61;
                    case 301: goto L61;
                    case 302: goto L37;
                    default: goto L36;
                }
            L36:
                return r1
            L37:
                java.lang.String r3 = "Expires"
                r0 = 2
                r2 = 0
                java.lang.String r3 = okhttp3.Response.header$default(r4, r3, r2, r0, r2)
                if (r3 != 0) goto L61
                okhttp3.CacheControl r3 = r4.cacheControl()
                int r3 = r3.maxAgeSeconds()
                r0 = -1
                if (r3 != r0) goto L61
                okhttp3.CacheControl r3 = r4.cacheControl()
                boolean r3 = r3.isPublic()
                if (r3 != 0) goto L61
                okhttp3.CacheControl r3 = r4.cacheControl()
                boolean r3 = r3.isPrivate()
                if (r3 != 0) goto L61
                return r1
            L61:
                okhttp3.CacheControl r3 = r4.cacheControl()
                boolean r3 = r3.noStore()
                if (r3 != 0) goto L77
                okhttp3.CacheControl r3 = r5.cacheControl()
                boolean r3 = r3.noStore()
                if (r3 != 0) goto L77
                r3 = 1
                return r3
            L77:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.Companion.isCacheable(okhttp3.Response, okhttp3.Request):boolean");
        }

        private Companion() {
        }
    }
}

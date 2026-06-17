package okhttp3.logging;

import defpackage.bv;
import defpackage.gt0;
import defpackage.ht0;
import defpackage.il1;
import defpackage.o24;
import defpackage.sg4;
import defpackage.tw;
import defpackage.we0;
import defpackage.yf4;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.IsProbablyUtf8Kt;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;
    private volatile Set<String> queryParamsNameToRedact;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Level {
        private static final /* synthetic */ gt0 $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = ht0.a(levelArr$values);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private Level(String str, int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static gt0 getEntries() {
            return $ENTRIES;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class DefaultLogger implements Logger {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String str) {
                    str.getClass();
                    Platform.log$default(Platform.Companion.get(), str, 0, null, 6, null);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private Companion() {
            }
        }

        void log(String str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HttpLoggingInterceptor(Logger logger) {
        logger.getClass();
        this.logger = logger;
        this.headersToRedact = o24.d();
        this.queryParamsNameToRedact = o24.d();
        this.level = Level.NONE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || sg4.y(str, "identity", true) || sg4.y(str, "gzip", true)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final boolean bodyIsStreaming(Response response) {
        MediaType mediaTypeContentType = response.body().contentType();
        return mediaTypeContentType != null && il1.a(mediaTypeContentType.type(), "text") && il1.a(mediaTypeContentType.subtype(), "event-stream");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void logHeader(Headers headers, int i) {
        String strValue = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        this.logger.log(headers.name(i) + ": " + strValue);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_level, reason: not valid java name */
    public final Level m160deprecated_level() {
        return this.level;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Level getLevel() {
        return this.level;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105 A[LOOP:0: B:42:0x0103->B:43:0x0105, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0111  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws Exception {
        boolean z;
        boolean z2;
        String str;
        String str2;
        Long l;
        GzipSource gzipSource;
        String str3;
        int size;
        int i;
        Long lValueOf;
        chain.getClass();
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z3 = level == Level.BODY;
        boolean z4 = z3 || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(redactUrl$logging_interceptor(request.url()));
        sb.append(connection != null ? " " + connection.protocol() : "");
        String string = sb.toString();
        if (!z4 && requestBodyBody != null) {
            string = string + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(string);
        if (z4) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType == null || headers.get("Content-Type") != null) {
                    z = z4;
                    z2 = z3;
                } else {
                    z = z4;
                    z2 = z3;
                    this.logger.log("Content-Type: " + mediaTypeContentType);
                }
                if (requestBodyBody.contentLength() != -1 && headers.get("Content-Length") == null) {
                    Logger logger = this.logger;
                    StringBuilder sb2 = new StringBuilder("Content-Length: ");
                    str3 = " ";
                    str2 = " (";
                    sb2.append(requestBodyBody.contentLength());
                    logger.log(sb2.toString());
                }
                size = headers.size();
                for (i = 0; i < size; i++) {
                    logHeader(headers, i);
                }
                if (z2 || requestBodyBody == null) {
                    str = str3;
                    this.logger.log("--> END " + request.method());
                } else {
                    if (bodyHasUnknownEncoding(request.headers())) {
                        this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                    } else if (requestBodyBody.isDuplex()) {
                        this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                    } else if (requestBodyBody.isOneShot()) {
                        this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                    } else {
                        Buffer buffer = new Buffer();
                        requestBodyBody.writeTo(buffer);
                        if (sg4.y("gzip", headers.get("Content-Encoding"), true)) {
                            lValueOf = Long.valueOf(buffer.size());
                            gzipSource = new GzipSource(buffer);
                            try {
                                buffer = new Buffer();
                                buffer.writeAll(gzipSource);
                                bv.a(gzipSource, null);
                            } finally {
                            }
                        } else {
                            lValueOf = null;
                        }
                        Charset charsetCharsetOrUtf8 = Internal.charsetOrUtf8(requestBodyBody.contentType());
                        this.logger.log("");
                        str = str3;
                        if (IsProbablyUtf8Kt.isProbablyUtf8(buffer, 16L)) {
                            Logger logger2 = this.logger;
                            if (lValueOf != null) {
                                logger2.log("--> END " + request.method() + str2 + buffer.size() + "-byte, " + lValueOf.longValue() + "-gzipped-byte body)");
                            } else {
                                logger2.log(buffer.readString(charsetCharsetOrUtf8));
                                this.logger.log("--> END " + request.method() + str2 + requestBodyBody.contentLength() + "-byte body)");
                            }
                        } else {
                            this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                        }
                    }
                    str = str3;
                }
            } else {
                z = z4;
                z2 = z3;
            }
            str3 = " ";
            str2 = " (";
            size = headers.size();
            while (i < size) {
            }
            if (z2) {
                str = str3;
                this.logger.log("--> END " + request.method());
            }
        } else {
            z = z4;
            z2 = z3;
            str = " ";
            str2 = " (";
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
            ResponseBody responseBodyBody = responseProceed.body();
            responseBodyBody.getClass();
            long jContentLength = responseBodyBody.contentLength();
            String str4 = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            Logger logger3 = this.logger;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- " + responseProceed.code());
            if (responseProceed.message().length() > 0) {
                sb3.append(str + responseProceed.message());
            }
            sb3.append(str + redactUrl$logging_interceptor(responseProceed.request().url()) + str2 + jNanoTime2 + "ms");
            if (!z) {
                sb3.append(", " + str4 + " body");
            }
            sb3.append(")");
            logger3.log(sb3.toString());
            if (z) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (z2 && HttpHeaders.promisesBody(responseProceed)) {
                    if (bodyHasUnknownEncoding(responseProceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                        return responseProceed;
                    }
                    if (bodyIsStreaming(responseProceed)) {
                        this.logger.log("<-- END HTTP (streaming)");
                        return responseProceed;
                    }
                    BufferedSource bufferedSourceSource = responseBodyBody.source();
                    bufferedSourceSource.request(Long.MAX_VALUE);
                    long jNanoTime3 = (System.nanoTime() - jNanoTime) / 1000000;
                    Buffer buffer2 = bufferedSourceSource.getBuffer();
                    if (sg4.y("gzip", headers2.get("Content-Encoding"), true)) {
                        Long lValueOf2 = Long.valueOf(buffer2.size());
                        gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            bv.a(gzipSource, null);
                            l = lValueOf2;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        l = null;
                    }
                    Charset charsetCharsetOrUtf82 = Internal.charsetOrUtf8(responseBodyBody.contentType());
                    if (!IsProbablyUtf8Kt.isProbablyUtf8(buffer2, 16L)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (" + jNanoTime3 + "ms, binary " + buffer2.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (jContentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charsetCharsetOrUtf82));
                    }
                    Logger logger4 = this.logger;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("<-- END HTTP (" + jNanoTime3 + "ms, " + buffer2.size() + "-byte");
                    if (l != null) {
                        sb4.append(", " + l.longValue() + "-gzipped-byte");
                    }
                    sb4.append(" body)");
                    logger4.log(sb4.toString());
                    return responseProceed;
                }
                this.logger.log("<-- END HTTP");
            }
            return responseProceed;
        } catch (Exception e) {
            this.logger.log(("<-- HTTP FAILED: " + e + '.').concat(str + redactUrl$logging_interceptor(request.url()) + str2 + ((System.nanoTime() - jNanoTime) / 1000000) + "ms)"));
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void level(Level level) {
        level.getClass();
        this.level = level;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void redactHeader(String str) {
        str.getClass();
        TreeSet treeSet = new TreeSet(sg4.z(yf4.a));
        tw.w(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void redactQueryParams(String... strArr) {
        strArr.getClass();
        TreeSet treeSet = new TreeSet(sg4.z(yf4.a));
        tw.w(treeSet, this.queryParamsNameToRedact);
        tw.x(treeSet, strArr);
        this.queryParamsNameToRedact = treeSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String redactUrl$logging_interceptor(HttpUrl httpUrl) {
        httpUrl.getClass();
        if (this.queryParamsNameToRedact.isEmpty() || httpUrl.querySize() == 0) {
            return httpUrl.toString();
        }
        HttpUrl.Builder builderQuery = httpUrl.newBuilder().query(null);
        int iQuerySize = httpUrl.querySize();
        for (int i = 0; i < iQuerySize; i++) {
            String strQueryParameterName = httpUrl.queryParameterName(i);
            builderQuery.addEncodedQueryParameter(strQueryParameterName, this.queryParamsNameToRedact.contains(strQueryParameterName) ? "██" : httpUrl.queryParameterValue(i));
        }
        return builderQuery.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final HttpLoggingInterceptor setLevel(Level level) {
        level.getClass();
        this.level = level;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.logging.HttpLoggingInterceptor.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
      (wrap:okhttp3.logging.HttpLoggingInterceptor$Logger:?: TERNARY null = ((wrap:int:0x0000: ARITH (r2v0 int) & (1 int) A[WRAPPED]) != (0 int)) ? (wrap:okhttp3.logging.HttpLoggingInterceptor$Logger:0x0004: SGET  A[WRAPPED] (LINE:27) okhttp3.logging.HttpLoggingInterceptor.Logger.DEFAULT okhttp3.logging.HttpLoggingInterceptor$Logger) : (r1v0 okhttp3.logging.HttpLoggingInterceptor$Logger))
     A[MD:(okhttp3.logging.HttpLoggingInterceptor$Logger):void (m)] (LINE:28) call: okhttp3.logging.HttpLoggingInterceptor.<init>(okhttp3.logging.HttpLoggingInterceptor$Logger):void type: THIS */
    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, we0 we0Var) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }
}

package okhttp3.logging;

import defpackage.gt0;
import defpackage.ht0;
import defpackage.il1;
import defpackage.o24;
import defpackage.sg4;
import defpackage.tw;
import defpackage.we0;
import defpackage.yf4;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;

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

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = ht0.a(levelArr$values);
        }

        private Level(String str, int i) {
        }

        public static gt0 getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

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
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String str) {
                    str.getClass();
                    Platform.log$default(Platform.Companion.get(), str, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor(Logger logger) {
        logger.getClass();
        this.logger = logger;
        this.headersToRedact = o24.d();
        this.queryParamsNameToRedact = o24.d();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || sg4.y(str, "identity", true) || sg4.y(str, "gzip", true)) ? false : true;
    }

    private final boolean bodyIsStreaming(Response response) {
        MediaType mediaTypeContentType = response.body().contentType();
        return mediaTypeContentType != null && il1.a(mediaTypeContentType.type(), "text") && il1.a(mediaTypeContentType.subtype(), "event-stream");
    }

    private final void logHeader(Headers headers, int i) {
        String strValue = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        this.logger.log(headers.name(i) + ": " + strValue);
    }

    /* JADX INFO: renamed from: -deprecated_level, reason: not valid java name */
    public final Level m160deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0105 A[LOOP:0: B:42:0x0103->B:43:0x0105, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0111  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r25) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public final void level(Level level) {
        level.getClass();
        this.level = level;
    }

    public final void redactHeader(String str) {
        str.getClass();
        TreeSet treeSet = new TreeSet(sg4.z(yf4.a));
        tw.w(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final void redactQueryParams(String... strArr) {
        strArr.getClass();
        TreeSet treeSet = new TreeSet(sg4.z(yf4.a));
        tw.w(treeSet, this.queryParamsNameToRedact);
        tw.x(treeSet, strArr);
        this.queryParamsNameToRedact = treeSet;
    }

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

    public final HttpLoggingInterceptor setLevel(Level level) {
        level.getClass();
        this.level = level;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, we0 we0Var) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }
}

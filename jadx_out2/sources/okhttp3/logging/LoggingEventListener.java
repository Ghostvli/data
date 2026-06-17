package okhttp3.logging;

import defpackage.we0;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class LoggingEventListener extends EventListener {
    public static final Companion Companion = new Companion(null);
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void logWithTime(String str) {
        long jNanoTime = (System.nanoTime() - this.startNs) / 1000000;
        this.logger.log("[" + jNanoTime + " ms] " + str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response response) {
        call.getClass();
        response.getClass();
        logWithTime("cacheConditionalHit: " + response);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        call.getClass();
        response.getClass();
        logWithTime("cacheHit: " + response);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        call.getClass();
        logWithTime("cacheMiss");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        call.getClass();
        logWithTime("callEnd");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
        logWithTime("callFailed: " + iOException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        call.getClass();
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        call.getClass();
        logWithTime("canceled");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
        logWithTime("connectEnd: " + protocol);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
        iOException.getClass();
        logWithTime("connectFailed: " + protocol + ' ' + iOException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        call.getClass();
        connection.getClass();
        logWithTime("connectionAcquired: " + connection);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        call.getClass();
        connection.getClass();
        logWithTime("connectionReleased");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
        call.getClass();
        dispatcher.getClass();
        logWithTime("dispatcherQueueEnd: " + call + " queuedCallsCount=" + dispatcher.queuedCallsCount());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
        call.getClass();
        dispatcher.getClass();
        logWithTime("dispatcherQueueStart: " + call + " queuedCallsCount=" + dispatcher.queuedCallsCount());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        call.getClass();
        str.getClass();
        list.getClass();
        logWithTime("dnsEnd: " + list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        call.getClass();
        str.getClass();
        logWithTime("dnsStart: " + str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        call.getClass();
        httpUrl.getClass();
        list.getClass();
        logWithTime("proxySelectEnd: " + list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        call.getClass();
        httpUrl.getClass();
        logWithTime("proxySelectStart: " + httpUrl);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        call.getClass();
        logWithTime("requestBodyEnd: byteCount=" + j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        call.getClass();
        logWithTime("requestBodyStart");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
        logWithTime("requestFailed: " + iOException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        call.getClass();
        request.getClass();
        logWithTime("requestHeadersEnd");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        call.getClass();
        logWithTime("requestHeadersStart");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        call.getClass();
        logWithTime("responseBodyEnd: byteCount=" + j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        call.getClass();
        logWithTime("responseBodyStart");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
        logWithTime("responseFailed: " + iOException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        call.getClass();
        response.getClass();
        logWithTime("responseHeadersEnd: " + response);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        call.getClass();
        logWithTime("responseHeadersStart");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        call.getClass();
        response.getClass();
        logWithTime("satisfactionFailure: " + response);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        call.getClass();
        logWithTime("secureConnectEnd: " + handshake);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        call.getClass();
        logWithTime("secureConnectStart");
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.logging.LoggingEventListener.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 okhttp3.logging.HttpLoggingInterceptor$Logger) A[MD:(okhttp3.logging.HttpLoggingInterceptor$Logger):void (m)] (LINE:7) call: okhttp3.logging.LoggingEventListener.<init>(okhttp3.logging.HttpLoggingInterceptor$Logger):void type: THIS */
    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, we0 we0Var) {
        this(logger);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
          (wrap:okhttp3.logging.HttpLoggingInterceptor$Logger:?: TERNARY null = ((wrap:int:0x0000: ARITH (r2v0 int) & (1 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (wrap:okhttp3.logging.HttpLoggingInterceptor$Logger:0x0004: SGET  A[WRAPPED] (LINE:5) okhttp3.logging.HttpLoggingInterceptor.Logger.DEFAULT okhttp3.logging.HttpLoggingInterceptor$Logger) : (r1v0 okhttp3.logging.HttpLoggingInterceptor$Logger))
         A[MD:(okhttp3.logging.HttpLoggingInterceptor$Logger):void (m)] (LINE:7) call: okhttp3.logging.LoggingEventListener.Factory.<init>(okhttp3.logging.HttpLoggingInterceptor$Logger):void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i, we0 we0Var) {
            this((i & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            call.getClass();
            return new LoggingEventListener(this.logger, null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger) {
            logger.getClass();
            this.logger = logger;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }
    }
}

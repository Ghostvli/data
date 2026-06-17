package defpackage;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.transport.spi.AbstractStreamClient;
import org.jupnp.transport.spi.AbstractStreamClientConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z53 extends AbstractStreamClient {
    public final a a;
    public final OkHttpClient b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends AbstractStreamClientConfiguration {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ExecutorService executorService) {
            super(executorService);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z53(a aVar) {
        this.a = aVar;
        int timeoutSeconds = aVar.getTimeoutSeconds() + 5;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j = timeoutSeconds;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.b = builder.connectTimeout(j, timeUnit).readTimeout(j, timeUnit).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ StreamResponseMessage d(Call call) {
        final Response responseExecute = call.execute();
        try {
            StreamResponseMessage streamResponseMessage = new StreamResponseMessage(new UpnpResponse(responseExecute.code(), responseExecute.message()));
            final UpnpHeaders upnpHeaders = new UpnpHeaders();
            responseExecute.headers().names().forEach(new Consumer() { // from class: x53
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    String str = (String) obj;
                    responseExecute.headers(str).forEach(new Consumer() { // from class: y53
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj2) {
                            upnpHeaders.add(str, (String) obj2);
                        }
                    });
                }
            });
            streamResponseMessage.setHeaders(upnpHeaders);
            byte[] bArrBytes = responseExecute.body().bytes();
            if (bArrBytes.length > 0) {
                streamResponseMessage.setBodyCharacters(bArrBytes);
            }
            responseExecute.close();
            return streamResponseMessage;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean k(String str) {
        return "POST".equals(str) || "NOTIFY".equals(str) || "PUT".equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: abort(Ljava/lang/Object;)V */
    @Override // org.jupnp.transport.spi.AbstractStreamClient
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void abort(Call call) {
        call.cancel();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final RequestBody g(StreamRequestMessage streamRequestMessage, String str) {
        byte[] bodyBytes;
        MediaType mediaType = null;
        if (!streamRequestMessage.hasBody() || (bodyBytes = streamRequestMessage.getBodyBytes()) == null || bodyBytes.length <= 0) {
            if (k(str)) {
                return RequestBody.create(new byte[0]);
            }
            return null;
        }
        List<String> list = streamRequestMessage.getHeaders().get("content-type");
        if (list != null && !list.isEmpty()) {
            mediaType = MediaType.parse(list.get(0));
        }
        return RequestBody.create(bodyBytes, mediaType);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: createCallable(Lorg/jupnp/model/message/StreamRequestMessage;Ljava/lang/Object;)Ljava/util/concurrent/Callable; */
    @Override // org.jupnp.transport.spi.AbstractStreamClient
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Callable createCallable(StreamRequestMessage streamRequestMessage, final Call call) {
        return new Callable() { // from class: t53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z53.d(call);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: createRequest(Lorg/jupnp/model/message/StreamRequestMessage;)Ljava/lang/Object; */
    @Override // org.jupnp.transport.spi.AbstractStreamClient
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Call createRequest(StreamRequestMessage streamRequestMessage) {
        String httpMethodName = streamRequestMessage.getOperation().getHttpMethodName();
        final Request.Builder builderMethod = new Request.Builder().url(streamRequestMessage.getOperation().getURI().toString()).method(httpMethodName, g(streamRequestMessage, httpMethodName));
        streamRequestMessage.getHeaders().forEach(new BiConsumer() { // from class: u53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((List) obj2).stream().filter(new v53()).forEach(new Consumer() { // from class: w53
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj3) {
                        builder.addHeader(str, (String) obj3);
                    }
                });
            }
        });
        if (streamRequestMessage.getHeaders().get("user-agent") == null) {
            builderMethod.header("User-Agent", this.a.getUserAgentValue(streamRequestMessage.getUdaMajorVersion(), streamRequestMessage.getUdaMinorVersion()));
        }
        return this.b.newCall(builderMethod.build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getConfiguration()Lorg/jupnp/transport/spi/StreamClientConfiguration; */
    @Override // org.jupnp.transport.spi.StreamClient
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a getConfiguration() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.AbstractStreamClient
    public boolean logExecutionException(Throwable th) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.StreamClient
    public void stop() {
        this.b.dispatcher().executorService().shutdown();
        this.b.connectionPool().evictAll();
    }
}

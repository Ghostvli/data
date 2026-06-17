package org.jupnp.transport.impl.jetty;

import defpackage.j02;
import defpackage.n02;
import java.util.concurrent.Callable;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.util.BytesContentProvider;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.UpnpOperation;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.transport.spi.AbstractStreamClient;
import org.jupnp.transport.spi.InitializationException;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JettyStreamClientImpl extends AbstractStreamClient<StreamClientConfigurationImpl, Request> {
    protected final StreamClientConfigurationImpl configuration;
    protected final HttpClient httpClient;
    private final j02 logger = n02.k(StreamClient.class);
    protected final HttpFields defaultHttpFields = new HttpFields();

    /* JADX INFO: renamed from: org.jupnp.transport.impl.jetty.JettyStreamClientImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jupnp$model$message$UpnpRequest$Method;

        static {
            int[] iArr = new int[UpnpRequest.Method.values().length];
            $SwitchMap$org$jupnp$model$message$UpnpRequest$Method = iArr;
            try {
                iArr[UpnpRequest.Method.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jupnp$model$message$UpnpRequest$Method[UpnpRequest.Method.SUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jupnp$model$message$UpnpRequest$Method[UpnpRequest.Method.UNSUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jupnp$model$message$UpnpRequest$Method[UpnpRequest.Method.POST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jupnp$model$message$UpnpRequest$Method[UpnpRequest.Method.NOTIFY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public JettyStreamClientImpl(StreamClientConfigurationImpl streamClientConfigurationImpl) {
        this.configuration = streamClientConfigurationImpl;
        HttpClient httpClient = new HttpClient();
        this.httpClient = httpClient;
        httpClient.setConnectTimeout((getConfiguration().getTimeoutSeconds() + 5) * 1000);
        httpClient.setMaxConnectionsPerDestination(2);
        httpClient.setExecutor(createThreadPool("jupnp-jetty-client", 5, Runtime.getRuntime().availableProcessors() * 5, 60000));
        if (getConfiguration().getSocketBufferSize() != -1) {
            httpClient.setRequestBufferSize(getConfiguration().getSocketBufferSize());
            httpClient.setResponseBufferSize(getConfiguration().getSocketBufferSize());
        }
        try {
            httpClient.start();
        } catch (Exception e) {
            this.logger.a("Failed to instantiate HTTP client", e);
            throw new InitializationException("Failed to instantiate HTTP client", e);
        }
    }

    private QueuedThreadPool createThreadPool(String str, int i, int i2, int i3) {
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool(i2, i, i3);
        queuedThreadPool.setName(str);
        queuedThreadPool.setDaemon(true);
        return queuedThreadPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ StreamResponseMessage lambda$createCallable$0(StreamRequestMessage streamRequestMessage, Request request) {
        this.logger.h("Sending HTTP request: {}", streamRequestMessage);
        try {
            ContentResponse contentResponseSend = request.send();
            this.logger.h("Received HTTP response: {}", contentResponseSend.getReason());
            StreamResponseMessage streamResponseMessage = new StreamResponseMessage(new UpnpResponse(contentResponseSend.getStatus(), contentResponseSend.getReason()));
            streamResponseMessage.setHeaders(new UpnpHeaders(HeaderUtil.get((Response) contentResponseSend)));
            byte[] content = contentResponseSend.getContent();
            if (content != null && content.length != 0) {
                boolean zIsContentTypeMissingOrText = streamResponseMessage.isContentTypeMissingOrText();
                j02 j02Var = this.logger;
                if (zIsContentTypeMissingOrText) {
                    j02Var.y("HTTP response message contains text entity");
                } else {
                    j02Var.y("HTTP response message contains binary entity");
                }
                streamResponseMessage.setBodyCharacters(content);
                return streamResponseMessage;
            }
            this.logger.y("HTTP response message has no entity");
            return streamResponseMessage;
        } catch (RuntimeException e) {
            this.logger.o("Request: {} failed", request, e);
            throw e;
        }
    }

    @Override // org.jupnp.transport.spi.AbstractStreamClient
    public void abort(Request request) {
        request.abort(new Exception("Request aborted by API"));
    }

    public <O extends UpnpOperation> ContentProvider.Typed createContentProvider(UpnpMessage<O> upnpMessage) {
        boolean zEquals = upnpMessage.getBodyType().equals(UpnpMessage.BodyType.STRING);
        j02 j02Var = this.logger;
        if (zEquals) {
            j02Var.y("Preparing HTTP request entity as String");
            return new StringContentProvider(upnpMessage.getBodyString(), upnpMessage.getContentTypeCharset());
        }
        j02Var.y("Preparing HTTP request entity as byte[]");
        return new BytesContentProvider(new byte[][]{upnpMessage.getBodyBytes()});
    }

    @Override // org.jupnp.transport.spi.AbstractStreamClient
    public Request createRequest(StreamRequestMessage streamRequestMessage) {
        UpnpRequest operation = streamRequestMessage.getOperation();
        this.logger.i("Creating HTTP request. URI: '{}' method: '{}'", operation.getURI(), operation.getMethod());
        int[] iArr = AnonymousClass1.$SwitchMap$org$jupnp$model$message$UpnpRequest$Method;
        int i = iArr[operation.getMethod().ordinal()];
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            throw new RuntimeException("Unknown HTTP method: " + operation.getHttpMethodName());
        }
        try {
            Request requestMethod = this.httpClient.newRequest(operation.getURI()).method(operation.getHttpMethodName());
            int i2 = iArr[operation.getMethod().ordinal()];
            if (i2 == 4 || i2 == 5) {
                requestMethod.content(createContentProvider(streamRequestMessage));
            }
            requestMethod.getHeaders().add(this.defaultHttpFields);
            if (streamRequestMessage.getOperation().getHttpMinorVersion() == 0) {
                requestMethod.version(HttpVersion.HTTP_1_0);
            } else {
                requestMethod.version(HttpVersion.HTTP_1_1);
                requestMethod.header(HttpHeader.CONNECTION, "close");
            }
            if (!streamRequestMessage.getHeaders().containsKey(UpnpHeader.Type.USER_AGENT)) {
                requestMethod.agent(getConfiguration().getUserAgentValue(streamRequestMessage.getUdaMajorVersion(), streamRequestMessage.getUdaMinorVersion()));
            }
            HeaderUtil.add(requestMethod, streamRequestMessage.getHeaders());
            return requestMethod;
        } catch (IllegalArgumentException e) {
            this.logger.f("Cannot create request because URI '{}' is invalid", operation.getURI(), e);
            return null;
        }
    }

    @Override // org.jupnp.transport.spi.AbstractStreamClient
    public boolean logExecutionException(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof IllegalStateException) {
            this.logger.h("Illegal state: {}", th.getMessage());
            return true;
        }
        String message = th.getMessage();
        if (message == null || !message.contains("HTTP protocol violation")) {
            return false;
        }
        SpecificationViolationReporter.report(message, new Object[0]);
        return true;
    }

    @Override // org.jupnp.transport.spi.StreamClient
    public void stop() {
        this.logger.y("Shutting down HTTP client connection manager/pool");
        try {
            this.httpClient.stop();
        } catch (Exception e) {
            this.logger.t("Shutting down of HTTP client throwed exception", e);
        }
    }

    @Override // org.jupnp.transport.spi.StreamClient
    public StreamClientConfigurationImpl getConfiguration() {
        return this.configuration;
    }

    @Override // org.jupnp.transport.spi.AbstractStreamClient
    public Callable<StreamResponseMessage> createCallable(final StreamRequestMessage streamRequestMessage, final Request request) {
        return new Callable() { // from class: in1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.lambda$createCallable$0(streamRequestMessage, request);
            }
        };
    }
}

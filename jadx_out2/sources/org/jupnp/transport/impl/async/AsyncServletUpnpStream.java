package org.jupnp.transport.impl.async;

import defpackage.e04;
import defpackage.j02;
import defpackage.n02;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.transport.impl.ServletUpnpStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AsyncServletUpnpStream extends ServletUpnpStream implements AsyncListener {
    protected final AsyncContext asyncContext;
    private final j02 logger;
    protected final HttpServletRequest request;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AsyncServletUpnpStream(ProtocolFactory protocolFactory, AsyncContext asyncContext, HttpServletRequest httpServletRequest) {
        super(protocolFactory);
        this.logger = n02.k(AsyncServletUpnpStream.class);
        this.asyncContext = asyncContext;
        this.request = httpServletRequest;
        asyncContext.addListener(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.impl.ServletUpnpStream
    public void complete() {
        try {
            this.asyncContext.complete();
        } catch (IllegalStateException e) {
            this.logger.t("Error calling servlet container's AsyncContext#complete() method", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.impl.ServletUpnpStream
    public HttpServletRequest getRequest() {
        return this.request;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.impl.ServletUpnpStream
    public HttpServletResponse getResponse() {
        HttpServletResponse response = this.asyncContext.getResponse();
        if (response != null) {
            return response;
        }
        e04.a("Couldn't get response from asynchronous context, already timed out");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onComplete(AsyncEvent asyncEvent) {
        this.logger.h("Completed asynchronous processing of HTTP request: {}", asyncEvent.getSuppliedRequest());
        responseSent(this.responseMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onError(AsyncEvent asyncEvent) {
        this.logger.v("Asynchronous processing of HTTP request error", asyncEvent.getThrowable());
        responseException(asyncEvent.getThrowable());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onStartAsync(AsyncEvent asyncEvent) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onTimeout(AsyncEvent asyncEvent) {
        this.logger.h("Asynchronous processing of HTTP request timed out: {}", asyncEvent.getSuppliedRequest());
        responseException(new Exception("Asynchronous request timed out"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: r1v1 */
    @Override // org.jupnp.transport.spi.UpnpStream
    public String toString() {
        int iHashCode = hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(iHashCode);
        return sb.toString();
    }
}

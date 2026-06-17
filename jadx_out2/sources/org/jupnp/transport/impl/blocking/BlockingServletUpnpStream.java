package org.jupnp.transport.impl.blocking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.transport.impl.ServletUpnpStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BlockingServletUpnpStream extends ServletUpnpStream {
    protected final FauxAsyncContext asyncContext;
    protected StreamResponseMessage responseMessage;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BlockingServletUpnpStream(ProtocolFactory protocolFactory, FauxAsyncContext fauxAsyncContext) {
        super(protocolFactory);
        this.asyncContext = fauxAsyncContext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.impl.ServletUpnpStream
    public void complete() {
        try {
            this.asyncContext.complete();
        } catch (Exception e) {
            ((ServletUpnpStream) this).logger.t("Error calling servlet container's AsyncContext#complete() method", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.impl.ServletUpnpStream
    public HttpServletRequest getRequest() {
        return this.asyncContext.getRequest();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.impl.ServletUpnpStream
    public HttpServletResponse getResponse() {
        return this.asyncContext.getResponse();
    }
}

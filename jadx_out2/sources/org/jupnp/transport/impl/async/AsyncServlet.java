package org.jupnp.transport.impl.async;

import defpackage.j02;
import defpackage.n02;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jupnp.model.message.Connection;
import org.jupnp.transport.Router;
import org.jupnp.transport.impl.ServletConnection;
import org.jupnp.transport.impl.ServletStreamServerConfigurationImpl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = -5751553619541219814L;
    private final ServletStreamServerConfigurationImpl configuration;
    private final j02 logger = n02.k(AsyncServlet.class);
    private int mCounter = 0;
    private final Router router;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AsyncServlet(Router router, ServletStreamServerConfigurationImpl servletStreamServerConfigurationImpl) {
        this.router = router;
        this.configuration = servletStreamServerConfigurationImpl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final int i = this.mCounter;
        this.mCounter = i + 1;
        this.logger.c("{}", String.format("HttpServlet.service(): id: %3d, request URI: %s", Integer.valueOf(i), httpServletRequest.getRequestURI()));
        this.logger.q("Handling Servlet request asynchronously: {}", httpServletRequest);
        AsyncContext asyncContextStartAsync = httpServletRequest.startAsync();
        asyncContextStartAsync.setTimeout(this.configuration.getAsyncTimeoutSeconds() * 1000);
        asyncContextStartAsync.addListener(new AsyncListener(this) { // from class: org.jupnp.transport.impl.async.AsyncServlet.1
            final /* synthetic */ AsyncServlet this$0;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            {
                this.this$0 = this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onComplete(AsyncEvent asyncEvent) {
                this.this$0.logger.q("{}", String.format("AsyncListener.onComplete(): id: %3d, duration: %,4d, response: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), asyncEvent.getSuppliedResponse()));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onError(AsyncEvent asyncEvent) {
                this.this$0.logger.q("{}", String.format("AsyncListener.onError(): id: %3d, duration: %,4d, response: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), asyncEvent.getSuppliedResponse()));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onStartAsync(AsyncEvent asyncEvent) {
                this.this$0.logger.q("{}", String.format("AsyncListener.onStartAsync(): id: %3d, request: %s", Integer.valueOf(i), asyncEvent.getSuppliedRequest()));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onTimeout(AsyncEvent asyncEvent) {
                this.this$0.logger.q("{}", String.format("AsyncListener.onTimeout(): id: %3d, duration: %,4d, request: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), asyncEvent.getSuppliedRequest()));
            }
        });
        this.router.received(new AsyncServletUpnpStream(this.router.getProtocolFactory(), asyncContextStartAsync, httpServletRequest) { // from class: org.jupnp.transport.impl.async.AsyncServlet.2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.transport.impl.ServletUpnpStream
            public Connection createConnection() {
                return new ServletConnection(getRequest());
            }
        });
    }
}

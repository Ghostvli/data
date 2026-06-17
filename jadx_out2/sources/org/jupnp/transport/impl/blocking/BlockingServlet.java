package org.jupnp.transport.impl.blocking;

import defpackage.j02;
import defpackage.n02;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jupnp.model.message.Connection;
import org.jupnp.transport.Router;
import org.jupnp.transport.impl.ServletConnection;
import org.jupnp.transport.impl.ServletStreamServerConfigurationImpl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BlockingServlet extends HttpServlet {
    private static final long serialVersionUID = 3124088565842038644L;
    private final ServletStreamServerConfigurationImpl configuration;
    private final j02 logger = n02.k(BlockingServlet.class);
    private int mCounter = 0;
    private final Router router;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BlockingServlet(Router router, ServletStreamServerConfigurationImpl servletStreamServerConfigurationImpl) {
        this.router = router;
        this.configuration = servletStreamServerConfigurationImpl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = this.mCounter;
        this.mCounter = i + 1;
        this.logger.h("{}", String.format("HttpServlet.service(): id: %3d, request URI: %s", Integer.valueOf(i), httpServletRequest.getRequestURI()));
        this.logger.h("Handling Servlet request synchronously: {}", httpServletRequest);
        FauxAsyncContext fauxAsyncContext = new FauxAsyncContext(httpServletRequest, httpServletResponse);
        fauxAsyncContext.setTimeout(this.configuration.getAsyncTimeoutSeconds() * 1000);
        this.router.received(new BlockingServletUpnpStream(this.router.getProtocolFactory(), fauxAsyncContext) { // from class: org.jupnp.transport.impl.blocking.BlockingServlet.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.transport.impl.ServletUpnpStream
            public Connection createConnection() {
                return new ServletConnection(getRequest());
            }
        });
        fauxAsyncContext.waitForTimeoutOrCompletion();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (fauxAsyncContext.isCompleted()) {
            this.logger.h("{}", String.format("BlockingServlet completed: id: %3d, duration: %,4d", Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis2)));
        } else {
            httpServletResponse.setStatus(500);
            this.logger.d("{}", String.format("BlockingServlet timed out: id: %3d, duration: %,4d, request: %s", Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis2), httpServletRequest));
        }
    }
}

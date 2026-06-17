package org.jupnp.transport.impl;

import defpackage.j02;
import defpackage.n02;
import java.net.InetAddress;
import javax.servlet.Servlet;
import org.jupnp.transport.Router;
import org.jupnp.transport.impl.async.AsyncServlet;
import org.jupnp.transport.impl.async.AsyncUtil;
import org.jupnp.transport.impl.blocking.BlockingServlet;
import org.jupnp.transport.spi.InitializationException;
import org.jupnp.transport.spi.StreamServer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServletStreamServerImpl implements StreamServer<ServletStreamServerConfigurationImpl> {
    protected final ServletStreamServerConfigurationImpl configuration;
    protected int localPort;
    private final j02 logger = n02.k(ServletStreamServerImpl.class);

    public ServletStreamServerImpl(ServletStreamServerConfigurationImpl servletStreamServerConfigurationImpl) {
        this.configuration = servletStreamServerConfigurationImpl;
    }

    public Servlet createAsyncServlet(Router router) {
        return new AsyncServlet(router, getConfiguration());
    }

    public Servlet createBlockingServlet(Router router) {
        return new BlockingServlet(router, getConfiguration());
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public synchronized int getPort() {
        return this.localPort;
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public synchronized void init(InetAddress inetAddress, Router router) {
        try {
            try {
                this.logger.b("Setting executor service on servlet container adapter");
                getConfiguration().getServletContainerAdapter().setExecutorService(router.getConfiguration().getStreamServerExecutorService());
                this.logger.f("Adding connector: {}:{}", inetAddress, Integer.valueOf(getConfiguration().getListenPort()));
                this.localPort = getConfiguration().getServletContainerAdapter().addConnector(inetAddress.getHostAddress(), getConfiguration().getListenPort());
                getConfiguration().getServletContainerAdapter().registerServlet(router.getConfiguration().getNamespace().getBasePath().getPath(), AsyncUtil.SERVLET3_SUPPORT ? createAsyncServlet(router) : createBlockingServlet(router));
            } catch (Exception e) {
                throw new InitializationException("Could not initialize ".concat(getClass().getSimpleName()), e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        getConfiguration().getServletContainerAdapter().startIfNotRunning();
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public synchronized void stop() {
        getConfiguration().getServletContainerAdapter().stopIfRunning();
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public ServletStreamServerConfigurationImpl getConfiguration() {
        return this.configuration;
    }
}

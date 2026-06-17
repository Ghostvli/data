package org.jupnp.transport.impl.jetty;

import defpackage.j02;
import defpackage.n02;
import java.util.concurrent.ExecutorService;
import javax.servlet.Servlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jupnp.transport.spi.ServletContainerAdapter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JettyServletContainer implements ServletContainerAdapter {
    public static final JettyServletContainer INSTANCE = new JettyServletContainer();
    private final j02 logger = n02.l(JettyServletContainer.class.getName());
    protected Server server;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JettyServletContainer() {
        resetServer();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public synchronized int addConnector(String str, int i) {
        ServerConnector serverConnector;
        serverConnector = new ServerConnector(this.server);
        serverConnector.setHost(str);
        serverConnector.setPort(i);
        serverConnector.open();
        this.server.addConnector(serverConnector);
        if (this.server.isStarted()) {
            try {
                serverConnector.start();
            } catch (Exception e) {
                this.logger.m("Couldn't start connector: {}", serverConnector, e);
                throw new RuntimeException("Couldn't start connector", e);
            }
        }
        return serverConnector.getLocalPort();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public synchronized void registerServlet(String str, Servlet servlet) {
        Handler handler = this.server.getHandler();
        j02 j02Var = this.logger;
        if (handler != null) {
            j02Var.h("Server handler is already set: {}", this.server.getHandler());
            return;
        }
        j02Var.c("Registering UPnP servlet under context path: {}", str);
        ServletContextHandler servletContextHandler = new ServletContextHandler(0);
        if (str != null && !str.isEmpty()) {
            servletContextHandler.setContextPath(str);
        }
        servletContextHandler.addServlet(new ServletHolder(servlet), "/*");
        this.server.setHandler(servletContextHandler);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void resetServer() {
        this.server = new Server();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public synchronized void setExecutorService(ExecutorService executorService) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public synchronized void startIfNotRunning() {
        if (!this.server.isStarted() && !this.server.isStarting()) {
            this.logger.info("Starting Jetty server... ");
            try {
                this.server.start();
            } catch (Exception e) {
                this.logger.a("Couldn't start Jetty server", e);
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public synchronized void stopIfRunning() {
        if (!this.server.isStopped() && !this.server.isStopping()) {
            this.logger.info("Stopping Jetty server...");
            try {
                try {
                    this.server.stop();
                } catch (Exception e) {
                    this.logger.a("Couldn't stop Jetty server", e);
                    throw new RuntimeException(e);
                }
            } finally {
                resetServer();
            }
        }
    }
}

package org.jupnp.transport.impl.osgi;

import defpackage.j02;
import defpackage.n02;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.jupnp.transport.impl.async.AsyncServlet;
import org.jupnp.transport.spi.ServletContainerAdapter;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class HttpServiceServletContainerAdapter implements ServletContainerAdapter {
    private static HttpServiceServletContainerAdapter instance;
    private BundleContext context;
    private String contextPath;
    protected HttpService httpService;
    private final j02 logger = n02.k(HttpServiceServletContainerAdapter.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private HttpServiceServletContainerAdapter(HttpService httpService, BundleContext bundleContext) {
        this.httpService = httpService;
        this.context = bundleContext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized HttpServiceServletContainerAdapter getInstance(HttpService httpService, BundleContext bundleContext) {
        try {
            if (instance == null) {
                instance = new HttpServiceServletContainerAdapter(httpService, bundleContext);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public int addConnector(String str, int i) {
        if (i == -1) {
            try {
                return Integer.parseInt(this.context.getProperty("org.osgi.service.http.port"));
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public void registerServlet(String str, Servlet servlet) {
        if (this.contextPath == null) {
            Properties properties = new Properties();
            try {
                this.logger.c("Registering UPnP callback servlet as {}", str);
                if (servlet instanceof AsyncServlet) {
                    properties.put("async-supported", "true");
                }
                this.httpService.registerServlet(str, servlet, properties, new DisableAuthenticationHttpContext());
                this.contextPath = str;
            } catch (IllegalStateException e) {
                e = e;
                this.logger.a("Failed to register UPnP servlet!", e);
            } catch (ServletException e2) {
                e = e2;
                this.logger.a("Failed to register UPnP servlet!", e);
            } catch (NamespaceException e3) {
                e = e3;
                this.logger.a("Failed to register UPnP servlet!", e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public void setExecutorService(ExecutorService executorService) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public void startIfNotRunning() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.ServletContainerAdapter
    public void stopIfRunning() {
        String str = this.contextPath;
        if (str != null) {
            this.httpService.unregister(str);
            this.contextPath = null;
        }
    }
}

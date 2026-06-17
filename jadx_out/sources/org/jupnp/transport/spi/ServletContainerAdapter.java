package org.jupnp.transport.spi;

import java.util.concurrent.ExecutorService;
import javax.servlet.Servlet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ServletContainerAdapter {
    int addConnector(String str, int i);

    void registerServlet(String str, Servlet servlet);

    void setExecutorService(ExecutorService executorService);

    void startIfNotRunning();

    void stopIfRunning();
}

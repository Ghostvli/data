package org.jupnp.transport.spi;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface StreamClientConfiguration {
    int getLogWarningSeconds();

    ExecutorService getRequestExecutorService();

    int getRetryAfterSeconds();

    int getRetryIterations();

    int getTimeoutSeconds();

    String getUserAgentValue(int i, int i2);
}

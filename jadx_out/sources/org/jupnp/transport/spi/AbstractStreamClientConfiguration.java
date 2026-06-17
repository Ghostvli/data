package org.jupnp.transport.spi;

import java.util.concurrent.ExecutorService;
import org.jupnp.model.ServerClientTokens;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractStreamClientConfiguration implements StreamClientConfiguration {
    protected int logWarningSeconds;
    protected ExecutorService requestExecutorService;
    protected int retryAfterSeconds;
    protected int retryIterations;
    protected int timeoutSeconds;

    public AbstractStreamClientConfiguration(ExecutorService executorService) {
        this.timeoutSeconds = 10;
        this.logWarningSeconds = 5;
        this.retryAfterSeconds = 600;
        this.retryIterations = 5;
        this.requestExecutorService = executorService;
    }

    @Override // org.jupnp.transport.spi.StreamClientConfiguration
    public int getLogWarningSeconds() {
        return this.logWarningSeconds;
    }

    @Override // org.jupnp.transport.spi.StreamClientConfiguration
    public ExecutorService getRequestExecutorService() {
        return this.requestExecutorService;
    }

    @Override // org.jupnp.transport.spi.StreamClientConfiguration
    public int getRetryAfterSeconds() {
        return this.retryAfterSeconds;
    }

    @Override // org.jupnp.transport.spi.StreamClientConfiguration
    public int getRetryIterations() {
        return this.retryIterations;
    }

    @Override // org.jupnp.transport.spi.StreamClientConfiguration
    public int getTimeoutSeconds() {
        return this.timeoutSeconds;
    }

    @Override // org.jupnp.transport.spi.StreamClientConfiguration
    public String getUserAgentValue(int i, int i2) {
        return new ServerClientTokens(i, i2).toString();
    }

    public AbstractStreamClientConfiguration(ExecutorService executorService, int i) {
        this.logWarningSeconds = 5;
        this.retryAfterSeconds = 600;
        this.retryIterations = 5;
        this.requestExecutorService = executorService;
        this.timeoutSeconds = i;
    }

    public AbstractStreamClientConfiguration(ExecutorService executorService, int i, int i2) {
        this.retryAfterSeconds = 600;
        this.retryIterations = 5;
        this.requestExecutorService = executorService;
        this.timeoutSeconds = i;
        this.logWarningSeconds = i2;
    }

    public AbstractStreamClientConfiguration(ExecutorService executorService, int i, int i2, int i3, int i4) {
        this.requestExecutorService = executorService;
        this.timeoutSeconds = i;
        this.logWarningSeconds = i2;
        this.retryAfterSeconds = i3;
        this.retryIterations = i4;
    }
}

package org.jupnp.transport.impl.jetty;

import java.util.concurrent.ExecutorService;
import org.jupnp.transport.spi.AbstractStreamClientConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StreamClientConfigurationImpl extends AbstractStreamClientConfiguration {
    public StreamClientConfigurationImpl(ExecutorService executorService) {
        super(executorService);
    }

    public int getRequestRetryCount() {
        return 0;
    }

    public int getSocketBufferSize() {
        return -1;
    }

    public StreamClientConfigurationImpl(ExecutorService executorService, int i) {
        super(executorService, i);
    }

    public StreamClientConfigurationImpl(ExecutorService executorService, int i, int i2, int i3, int i4) {
        super(executorService, i, i2, i3, i4);
    }
}

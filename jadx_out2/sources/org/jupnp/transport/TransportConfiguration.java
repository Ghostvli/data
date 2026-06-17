package org.jupnp.transport;

import java.util.concurrent.ExecutorService;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamClientConfiguration;
import org.jupnp.transport.spi.StreamServer;
import org.jupnp.transport.spi.StreamServerConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface TransportConfiguration<SCC extends StreamClientConfiguration, SSC extends StreamServerConfiguration> {
    StreamClient<SCC> createStreamClient(ExecutorService executorService, StreamClientConfiguration streamClientConfiguration);

    StreamServer<SSC> createStreamServer(int i);
}

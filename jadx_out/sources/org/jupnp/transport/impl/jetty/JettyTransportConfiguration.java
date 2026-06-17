package org.jupnp.transport.impl.jetty;

import java.util.concurrent.ExecutorService;
import org.jupnp.transport.TransportConfiguration;
import org.jupnp.transport.impl.ServletStreamServerConfigurationImpl;
import org.jupnp.transport.impl.ServletStreamServerImpl;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamClientConfiguration;
import org.jupnp.transport.spi.StreamServer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JettyTransportConfiguration implements TransportConfiguration {
    public static final TransportConfiguration INSTANCE = new JettyTransportConfiguration();

    @Override // org.jupnp.transport.TransportConfiguration
    public StreamClient createStreamClient(ExecutorService executorService, StreamClientConfiguration streamClientConfiguration) {
        return new JettyStreamClientImpl(new StreamClientConfigurationImpl(executorService, streamClientConfiguration.getTimeoutSeconds(), streamClientConfiguration.getLogWarningSeconds(), streamClientConfiguration.getRetryAfterSeconds(), streamClientConfiguration.getRetryIterations()));
    }

    @Override // org.jupnp.transport.TransportConfiguration
    public StreamServer createStreamServer(int i) {
        return new ServletStreamServerImpl(new ServletStreamServerConfigurationImpl(JettyServletContainer.INSTANCE, i));
    }
}

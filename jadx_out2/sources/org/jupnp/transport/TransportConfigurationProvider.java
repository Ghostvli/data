package org.jupnp.transport;

import org.jupnp.transport.impl.jetty.JettyTransportConfiguration;
import org.jupnp.transport.spi.StreamClientConfiguration;
import org.jupnp.transport.spi.StreamServerConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class TransportConfigurationProvider {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static <SCC extends StreamClientConfiguration, SSC extends StreamServerConfiguration> TransportConfiguration<SCC, SSC> getDefaultTransportConfiguration() {
        return new JettyTransportConfiguration();
    }
}

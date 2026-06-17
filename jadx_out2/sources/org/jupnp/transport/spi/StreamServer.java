package org.jupnp.transport.spi;

import java.net.InetAddress;
import org.jupnp.transport.Router;
import org.jupnp.transport.spi.StreamServerConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface StreamServer<C extends StreamServerConfiguration> extends Runnable {
    C getConfiguration();

    int getPort();

    void init(InetAddress inetAddress, Router router);

    void stop();
}

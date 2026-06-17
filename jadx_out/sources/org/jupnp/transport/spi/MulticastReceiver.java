package org.jupnp.transport.spi;

import java.net.NetworkInterface;
import org.jupnp.transport.Router;
import org.jupnp.transport.spi.MulticastReceiverConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface MulticastReceiver<C extends MulticastReceiverConfiguration> extends Runnable {
    C getConfiguration();

    void init(NetworkInterface networkInterface, Router router, NetworkAddressFactory networkAddressFactory, DatagramProcessor datagramProcessor);

    void stop();
}

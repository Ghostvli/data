package org.jupnp.transport.spi;

import java.net.DatagramPacket;
import java.net.InetAddress;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.transport.Router;
import org.jupnp.transport.spi.DatagramIOConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface DatagramIO<C extends DatagramIOConfiguration> extends Runnable {
    C getConfiguration();

    void init(InetAddress inetAddress, int i, Router router, DatagramProcessor datagramProcessor);

    void send(DatagramPacket datagramPacket);

    void send(OutgoingDatagramMessage outgoingDatagramMessage);

    void stop();
}

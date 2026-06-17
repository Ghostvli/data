package org.jupnp.transport;

import java.net.InetAddress;
import java.util.List;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.NetworkAddress;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.transport.spi.InitializationException;
import org.jupnp.transport.spi.UpnpStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Router {
    void broadcast(byte[] bArr);

    boolean disable();

    boolean enable();

    List<NetworkAddress> getActiveStreamServers(InetAddress inetAddress);

    UpnpServiceConfiguration getConfiguration();

    ProtocolFactory getProtocolFactory();

    void handleStartFailure(InitializationException initializationException);

    boolean isEnabled();

    void received(IncomingDatagramMessage incomingDatagramMessage);

    void received(UpnpStream upnpStream);

    StreamResponseMessage send(StreamRequestMessage streamRequestMessage);

    void send(OutgoingDatagramMessage outgoingDatagramMessage);

    void shutdown();
}

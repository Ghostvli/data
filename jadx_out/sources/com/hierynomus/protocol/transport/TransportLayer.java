package com.hierynomus.protocol.transport;

import com.hierynomus.protocol.Packet;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface TransportLayer<P extends Packet<?>> {
    void connect(InetSocketAddress inetSocketAddress);

    void disconnect();

    boolean isConnected();

    void write(P p);
}

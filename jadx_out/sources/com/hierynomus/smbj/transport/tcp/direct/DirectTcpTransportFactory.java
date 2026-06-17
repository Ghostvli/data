package com.hierynomus.smbj.transport.tcp.direct;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.transport.PacketHandlers;
import com.hierynomus.protocol.transport.TransportLayer;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.transport.TransportLayerFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DirectTcpTransportFactory<D extends PacketData<?>, P extends Packet<?>> implements TransportLayerFactory<D, P> {
    @Override // com.hierynomus.smbj.transport.TransportLayerFactory
    public TransportLayer<P> createTransportLayer(PacketHandlers<D, P> packetHandlers, SmbConfig smbConfig) {
        return new DirectTcpTransport(smbConfig.getSocketFactory(), smbConfig.getSoTimeout(), packetHandlers);
    }
}

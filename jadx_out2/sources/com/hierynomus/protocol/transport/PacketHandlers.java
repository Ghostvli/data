package com.hierynomus.protocol.transport;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.PacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PacketHandlers<D extends PacketData<?>, P extends Packet<?>> {
    private final PacketFactory<D> packetFactory;
    private final PacketReceiver<D> receiver;
    private final PacketSerializer<P, ?> serializer;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PacketHandlers(PacketSerializer<P, ?> packetSerializer, PacketReceiver<D> packetReceiver, PacketFactory<D> packetFactory) {
        this.serializer = packetSerializer;
        this.receiver = packetReceiver;
        this.packetFactory = packetFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PacketFactory<D> getPacketFactory() {
        return this.packetFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PacketReceiver<D> getReceiver() {
        return this.receiver;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PacketSerializer<P, ?> getSerializer() {
        return this.serializer;
    }
}

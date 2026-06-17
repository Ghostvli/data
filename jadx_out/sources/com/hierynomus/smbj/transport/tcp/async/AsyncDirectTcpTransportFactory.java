package com.hierynomus.smbj.transport.tcp.async;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.transport.PacketHandlers;
import com.hierynomus.protocol.transport.TransportLayer;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.transport.TransportLayerFactory;
import defpackage.wg1;
import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncDirectTcpTransportFactory<D extends PacketData<?>, P extends Packet<?>> implements TransportLayerFactory<D, P> {
    private static final AsynchronousChannelGroup DEFAULT_CHANNEL_GROUP = null;
    private final AsynchronousChannelGroup group;

    public AsyncDirectTcpTransportFactory(ExecutorService executorService) {
        this(createGroup(executorService));
    }

    private static AsynchronousChannelGroup createGroup(ExecutorService executorService) {
        try {
            return AsynchronousChannelGroup.withThreadPool(executorService);
        } catch (IOException e) {
            wg1.a(e);
            return null;
        }
    }

    @Override // com.hierynomus.smbj.transport.TransportLayerFactory
    public TransportLayer<P> createTransportLayer(PacketHandlers<D, P> packetHandlers, SmbConfig smbConfig) {
        try {
            return new AsyncDirectTcpTransport(smbConfig.getSoTimeout(), packetHandlers, this.group);
        } catch (IOException e) {
            throw new SMBRuntimeException(e);
        }
    }

    public AsyncDirectTcpTransportFactory() {
        this(DEFAULT_CHANNEL_GROUP);
    }

    public AsyncDirectTcpTransportFactory(AsynchronousChannelGroup asynchronousChannelGroup) {
        this.group = asynchronousChannelGroup;
    }
}

package com.hierynomus.smbj.transport.tcp.tunnel;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.transport.TransportLayer;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TunnelTransport<P extends Packet<?>> implements TransportLayer<P> {
    private TransportLayer<P> tunnel;
    private String tunnelHost;
    private int tunnelPort;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TunnelTransport(TransportLayer<P> transportLayer, String str, int i) {
        this.tunnel = transportLayer;
        this.tunnelHost = str;
        this.tunnelPort = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void connect(InetSocketAddress inetSocketAddress) {
        this.tunnel.connect(new InetSocketAddress(this.tunnelHost, this.tunnelPort));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void disconnect() {
        this.tunnel.disconnect();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public boolean isConnected() {
        return this.tunnel.isConnected();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void write(P p) {
        this.tunnel.write(p);
    }
}

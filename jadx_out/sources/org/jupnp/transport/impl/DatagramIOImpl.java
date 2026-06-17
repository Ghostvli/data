package org.jupnp.transport.impl;

import defpackage.j02;
import defpackage.n02;
import defpackage.wg1;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.transport.Router;
import org.jupnp.transport.spi.DatagramIO;
import org.jupnp.transport.spi.DatagramProcessor;
import org.jupnp.transport.spi.InitializationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DatagramIOImpl implements DatagramIO<DatagramIOConfigurationImpl> {
    protected final DatagramIOConfigurationImpl configuration;
    protected DatagramProcessor datagramProcessor;
    protected InetSocketAddress localAddress;
    private final j02 logger = n02.k(DatagramIOImpl.class);
    protected Router router;
    protected MulticastSocket socket;

    public DatagramIOImpl(DatagramIOConfigurationImpl datagramIOConfigurationImpl) {
        this.configuration = datagramIOConfigurationImpl;
    }

    @Override // org.jupnp.transport.spi.DatagramIO
    public synchronized void init(InetAddress inetAddress, int i, Router router, DatagramProcessor datagramProcessor) {
        this.router = router;
        this.datagramProcessor = datagramProcessor;
        try {
            this.logger.f("Creating bound socket (for datagram input/output) on: {}:{}", inetAddress, Integer.valueOf(i));
            this.localAddress = new InetSocketAddress(inetAddress, i);
            MulticastSocket multicastSocket = new MulticastSocket(this.localAddress);
            this.socket = multicastSocket;
            multicastSocket.setTimeToLive(this.configuration.getTimeToLive());
            this.socket.setReceiveBufferSize(262144);
        } catch (Exception e) {
            throw new InitializationException("Could not initialize ".concat(getClass().getSimpleName()), e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.logger.f("Entering blocking receiving loop, listening for UDP datagrams on: {}:{}", this.socket.getLocalAddress(), Integer.valueOf(this.socket.getPort()));
        while (true) {
            try {
                int maxDatagramBytes = getConfiguration().getMaxDatagramBytes();
                DatagramPacket datagramPacket = new DatagramPacket(new byte[maxDatagramBytes], maxDatagramBytes);
                this.socket.receive(datagramPacket);
                this.logger.s("UDP datagram received from: {}:{} on: {}", datagramPacket.getAddress().getHostAddress(), Integer.valueOf(datagramPacket.getPort()), this.localAddress);
                this.router.received(this.datagramProcessor.read(this.localAddress.getAddress(), datagramPacket));
            } catch (SocketException unused) {
                this.logger.b("Socket closed");
                try {
                    if (this.socket.isClosed()) {
                        return;
                    }
                    this.logger.b("Closing unicast socket");
                    this.socket.close();
                    return;
                } catch (Exception e) {
                    wg1.a(e);
                    return;
                }
            } catch (UnsupportedDataException e2) {
                this.logger.c("Could not read datagram: {}", e2.getMessage());
            } catch (Exception e3) {
                wg1.a(e3);
                return;
            }
        }
    }

    @Override // org.jupnp.transport.spi.DatagramIO
    public synchronized void send(DatagramPacket datagramPacket) {
        this.logger.q("Sending message from address: {}", this.localAddress);
        try {
            try {
                try {
                    this.socket.send(datagramPacket);
                } catch (RuntimeException e) {
                    throw e;
                }
            } catch (SocketException unused) {
                this.logger.q("Socket closed, aborting datagram send to: {}", datagramPacket.getAddress());
            }
        } catch (Exception e2) {
            this.logger.o("Exception sending datagram to: {}", datagramPacket.getAddress(), e2);
            this.logger.p("  Details: datagram.socketAddress={}, length={}, offset={}, data.bytes={}", datagramPacket.getSocketAddress(), Integer.valueOf(datagramPacket.getLength()), Integer.valueOf(datagramPacket.getOffset()), Integer.valueOf(datagramPacket.getData().length));
            try {
                this.logger.p("  Details: socket={}, closed={}, bound={}, inetAddress={}, remoteSocketAddress={}, networkInterface={}", this.socket.toString(), Boolean.valueOf(this.socket.isClosed()), Boolean.valueOf(this.socket.isBound()), this.socket.getInetAddress(), this.socket.getRemoteSocketAddress(), this.socket.getNetworkInterface());
            } catch (SocketException e3) {
                this.logger.a("  Details: could not get network interface", e3);
            }
        }
    }

    @Override // org.jupnp.transport.spi.DatagramIO
    public synchronized void stop() {
        MulticastSocket multicastSocket = this.socket;
        if (multicastSocket != null && !multicastSocket.isClosed()) {
            this.socket.close();
        }
    }

    @Override // org.jupnp.transport.spi.DatagramIO
    public DatagramIOConfigurationImpl getConfiguration() {
        return this.configuration;
    }

    @Override // org.jupnp.transport.spi.DatagramIO
    public synchronized void send(OutgoingDatagramMessage outgoingDatagramMessage) {
        this.logger.q("Sending message from address: {}", this.localAddress);
        DatagramPacket datagramPacketWrite = this.datagramProcessor.write(outgoingDatagramMessage);
        this.logger.f("Sending UDP datagram packet to: {}:{}", outgoingDatagramMessage.getDestinationAddress(), Integer.valueOf(outgoingDatagramMessage.getDestinationPort()));
        send(datagramPacketWrite);
    }
}

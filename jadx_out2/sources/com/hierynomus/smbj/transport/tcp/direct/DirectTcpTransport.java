package com.hierynomus.smbj.transport.tcp.direct;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.socket.ProxySocketFactory;
import com.hierynomus.protocol.transport.PacketHandlers;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.protocol.transport.TransportLayer;
import com.hierynomus.smbj.transport.PacketReader;
import defpackage.j02;
import defpackage.n02;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DirectTcpTransport<D extends PacketData<?>, P extends Packet<?>> implements TransportLayer<P> {
    private static final int INITIAL_BUFFER_SIZE = 9000;
    private final PacketHandlers<D, P> handlers;
    private BufferedOutputStream output;
    private PacketReader<D> packetReaderThread;
    private int soTimeout;
    private Socket socket;
    private SocketFactory socketFactory;
    private final j02 logger = n02.k(getClass());
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DirectTcpTransport(SocketFactory socketFactory, int i, PacketHandlers<D, P> packetHandlers) {
        new ProxySocketFactory();
        this.soTimeout = i;
        this.socketFactory = socketFactory;
        this.handlers = packetHandlers;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void initWithSocket(String str) throws SocketException {
        this.socket.setSoTimeout(this.soTimeout);
        this.output = new BufferedOutputStream(this.socket.getOutputStream(), 9000);
        DirectTcpPacketReader directTcpPacketReader = new DirectTcpPacketReader(str, this.socket.getInputStream(), this.handlers.getPacketFactory(), this.handlers.getReceiver());
        this.packetReaderThread = directTcpPacketReader;
        directTcpPacketReader.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeDirectTcpPacketHeader(int i) throws IOException {
        this.output.write(0);
        this.output.write((byte) (i >> 16));
        this.output.write((byte) (i >> 8));
        this.output.write((byte) (i & 255));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writePacketData(Buffer<?> buffer) throws IOException {
        this.output.write(buffer.array(), buffer.rpos(), buffer.available());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void connect(InetSocketAddress inetSocketAddress) throws SocketException {
        String hostString = inetSocketAddress.getHostString();
        this.socket = this.socketFactory.createSocket(hostString, inetSocketAddress.getPort());
        initWithSocket(hostString);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void disconnect() {
        if (isConnected()) {
            this.lock.writeLock().lock();
            try {
                if (isConnected()) {
                    this.packetReaderThread.stop();
                    if (this.socket.getInputStream() != null) {
                        this.socket.getInputStream().close();
                    }
                    BufferedOutputStream bufferedOutputStream = this.output;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                        this.output = null;
                    }
                    Socket socket = this.socket;
                    if (socket != null) {
                        socket.close();
                        this.socket = null;
                    }
                }
                this.lock.writeLock().unlock();
            } catch (Throwable th) {
                this.lock.writeLock().unlock();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isConnected() {
        boolean z;
        this.lock.readLock().lock();
        try {
            Socket socket = this.socket;
            if (socket == null || !socket.isConnected()) {
                z = false;
            } else if (!this.socket.isClosed()) {
                z = true;
            }
            return z;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSoTimeout(int i) {
        this.soTimeout = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void write(P p) throws TransportException {
        this.logger.h("Acquiring write lock to send packet << {} >>", p);
        if (!isConnected()) {
            throw new TransportException(String.format("Cannot write %s as transport is disconnected", p));
        }
        this.lock.writeLock().lock();
        try {
            try {
                if (!isConnected()) {
                    throw new TransportException(String.format("Cannot write %s as transport got disconnected", p));
                }
                this.logger.q("Writing packet {}", p);
                Buffer<?> bufferWrite = this.handlers.getSerializer().write(p);
                writeDirectTcpPacketHeader(bufferWrite.available());
                writePacketData(bufferWrite);
                this.output.flush();
                this.logger.h("Packet {} sent, lock released.", p);
            } catch (IOException e) {
                throw new TransportException(e);
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}

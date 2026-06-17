package com.hierynomus.smbj.transport.tcp.async;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.transport.PacketHandlers;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.protocol.transport.TransportLayer;
import com.hierynomus.smbj.common.SMBRuntimeException;
import defpackage.e04;
import defpackage.j02;
import defpackage.n02;
import j$.nio.channels.CompletionHandler;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncDirectTcpTransport<D extends PacketData<?>, P extends Packet<?>> implements TransportLayer<P> {
    private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    private static final int DIRECT_HEADER_SIZE = 4;
    private final AtomicBoolean connected;
    private final PacketHandlers<D, P> handlers;
    private final j02 logger = n02.k(getClass());
    private final AsyncPacketReader<D> packetReader;
    private int soTimeout;
    private final AsynchronousSocketChannel socketChannel;
    private final Queue<ByteBuffer> writeQueue;
    private AtomicBoolean writingNow;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AsyncDirectTcpTransport(int i, PacketHandlers<D, P> packetHandlers, AsynchronousChannelGroup asynchronousChannelGroup) throws IOException {
        this.soTimeout = i;
        this.handlers = packetHandlers;
        AsynchronousSocketChannel asynchronousSocketChannelOpen = AsynchronousSocketChannel.open(asynchronousChannelGroup);
        this.socketChannel = asynchronousSocketChannelOpen;
        this.packetReader = new AsyncPacketReader<>(asynchronousSocketChannelOpen, packetHandlers.getPacketFactory(), packetHandlers.getReceiver());
        this.writeQueue = new LinkedBlockingQueue();
        this.connected = new AtomicBoolean(false);
        this.writingNow = new AtomicBoolean(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ByteBuffer prepareBufferToSend(P p) {
        Buffer bufferWrite = this.handlers.getSerializer().write(p);
        int iAvailable = bufferWrite.available();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iAvailable + 4);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.putInt(bufferWrite.available());
        byteBufferAllocate.put(bufferWrite.array(), bufferWrite.rpos(), bufferWrite.available());
        byteBufferAllocate.flip();
        try {
            bufferWrite.skip(iAvailable);
            return byteBufferAllocate;
        } catch (Buffer.BufferException e) {
            throw ((SMBRuntimeException) SMBRuntimeException.Wrapper.wrap(e));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void startAsyncWrite() {
        if (!isConnected()) {
            e04.a("Transport is not connected");
            return;
        }
        this.socketChannel.write(this.writeQueue.peek(), this.soTimeout, TimeUnit.MILLISECONDS, null, CompletionHandler.Wrapper.convert(new CompletionHandler<Integer, Object>() { // from class: com.hierynomus.smbj.transport.tcp.async.AsyncDirectTcpTransport.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private void startNextWriteIfWaiting() {
                synchronized (AsyncDirectTcpTransport.this) {
                    ByteBuffer byteBuffer = (ByteBuffer) AsyncDirectTcpTransport.this.writeQueue.peek();
                    if (byteBuffer == null || !byteBuffer.hasRemaining()) {
                        AsyncDirectTcpTransport asyncDirectTcpTransport = AsyncDirectTcpTransport.this;
                        if (byteBuffer != null) {
                            asyncDirectTcpTransport.writeQueue.remove();
                            startNextWriteIfWaiting();
                        } else {
                            asyncDirectTcpTransport.writingNow.set(false);
                        }
                    } else {
                        AsyncDirectTcpTransport.this.startAsyncWrite();
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: completed(Ljava/lang/Object;Ljava/lang/Object;)V */
            @Override // j$.nio.channels.CompletionHandler
            public void completed(Integer num, Object obj) {
                AsyncDirectTcpTransport.this.logger.h("Written {} bytes to async transport", num);
                startNextWriteIfWaiting();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // j$.nio.channels.CompletionHandler
            public void failed(Throwable th, Object obj) {
                try {
                    if (th instanceof ClosedChannelException) {
                        AsyncDirectTcpTransport.this.connected.set(false);
                    } else {
                        startNextWriteIfWaiting();
                    }
                    AsyncDirectTcpTransport.this.handlers.getReceiver().handleError(th);
                } catch (Throwable th2) {
                    AsyncDirectTcpTransport.this.handlers.getReceiver().handleError(th);
                    throw th2;
                }
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeOrEnqueue(ByteBuffer byteBuffer) {
        synchronized (this) {
            try {
                this.writeQueue.add(byteBuffer);
                if (!this.writingNow.getAndSet(true)) {
                    startAsyncWrite();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void connect(InetSocketAddress inetSocketAddress) throws TransportException {
        String hostString = inetSocketAddress.getHostString();
        try {
            this.socketChannel.connect(inetSocketAddress).get(5000L, TimeUnit.MILLISECONDS);
            this.connected.set(true);
            this.packetReader.start(hostString, this.soTimeout);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw ((TransportException) TransportException.Wrapper.wrap(e));
        } catch (ExecutionException | TimeoutException e2) {
            throw ((TransportException) TransportException.Wrapper.wrap(e2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void disconnect() {
        this.connected.set(false);
        this.socketChannel.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public boolean isConnected() {
        return this.connected.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSoTimeout(int i) {
        this.soTimeout = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.TransportLayer
    public void write(P p) {
        ByteBuffer byteBufferPrepareBufferToSend = prepareBufferToSend(p);
        this.logger.h("Sending packet << {} >>", p);
        writeOrEnqueue(byteBufferPrepareBufferToSend);
    }
}

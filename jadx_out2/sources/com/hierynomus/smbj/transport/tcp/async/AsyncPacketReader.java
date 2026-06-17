package com.hierynomus.smbj.transport.tcp.async;

import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.transport.PacketFactory;
import com.hierynomus.protocol.transport.PacketReceiver;
import defpackage.j02;
import defpackage.n02;
import j$.nio.channels.CompletionHandler;
import java.io.EOFException;
import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncPacketReader<D extends PacketData<?>> {
    private static final j02 logger = n02.k(AsyncPacketReader.class);
    private final AsynchronousSocketChannel channel;
    private PacketReceiver<D> handler;
    private final PacketFactory<D> packetFactory;
    private String remoteHost;
    private int soTimeout = 0;
    private AtomicBoolean stopped = new AtomicBoolean(false);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AsyncPacketReader(AsynchronousSocketChannel asynchronousSocketChannel, PacketFactory<D> packetFactory, PacketReceiver<D> packetReceiver) {
        this.channel = asynchronousSocketChannel;
        this.packetFactory = packetFactory;
        this.handler = packetReceiver;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void closeChannelQuietly() {
        try {
            this.channel.close();
        } catch (IOException e) {
            logger.s("{} while closing channel to {} on failure: {}", e.getClass().getSimpleName(), this.remoteHost, e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void handleAsyncFailure(Throwable th) {
        if (isChannelClosedByOtherParty(th)) {
            logger.h("Channel to {} closed by other party, closing it locally.", this.remoteHost);
        } else {
            String simpleName = th.getClass().getSimpleName();
            j02 j02Var = logger;
            j02Var.p("{} on channel to {}, closing channel: {}", simpleName, this.remoteHost, th.getMessage());
            j02Var.w("Exception was: ", th);
        }
        closeChannelQuietly();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void initiateNextRead(PacketBufferReader packetBufferReader) {
        if (this.stopped.get()) {
            logger.y("Stopped, not initiating another read operation.");
            return;
        }
        logger.y("Initiating next read");
        this.channel.read(packetBufferReader.getBuffer(), this.soTimeout, TimeUnit.MILLISECONDS, packetBufferReader, CompletionHandler.Wrapper.convert(new CompletionHandler<Integer, PacketBufferReader>() { // from class: com.hierynomus.smbj.transport.tcp.async.AsyncPacketReader.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private void handleClosedReader() {
                if (AsyncPacketReader.this.stopped.get()) {
                    return;
                }
                AsyncPacketReader.this.handleAsyncFailure(new EOFException("Connection closed by server"));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private void processPackets(PacketBufferReader packetBufferReader2) {
                byte[] next = packetBufferReader2.readNext();
                while (next != null) {
                    AsyncPacketReader.this.readAndHandlePacket(next);
                    next = packetBufferReader2.readNext();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: completed(Ljava/lang/Object;Ljava/lang/Object;)V */
            @Override // j$.nio.channels.CompletionHandler
            public void completed(Integer num, PacketBufferReader packetBufferReader2) {
                AsyncPacketReader.logger.h("Received {} bytes", num);
                if (num.intValue() < 0) {
                    handleClosedReader();
                    return;
                }
                try {
                    processPackets(packetBufferReader2);
                    AsyncPacketReader.this.initiateNextRead(packetBufferReader2);
                } catch (RuntimeException e) {
                    AsyncPacketReader.this.handleAsyncFailure(e);
                }
            }

            /* JADX DEBUG: Method merged with bridge method: failed(Ljava/lang/Throwable;Ljava/lang/Object;)V */
            @Override // j$.nio.channels.CompletionHandler
            public void failed(Throwable th, PacketBufferReader packetBufferReader2) {
                AsyncPacketReader.this.handleAsyncFailure(th);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isChannelClosedByOtherParty(Throwable th) {
        return th instanceof AsynchronousCloseException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void readAndHandlePacket(byte[] bArr) {
        try {
            PacketData packetData = this.packetFactory.read(bArr);
            logger.h("Received packet << {} >>", packetData);
            this.handler.handle(packetData);
        } catch (Buffer.BufferException | IOException e) {
            handleAsyncFailure(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void start(String str, int i) {
        this.remoteHost = str;
        this.soTimeout = i;
        initiateNextRead(new PacketBufferReader());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void stop() {
        this.stopped.set(true);
    }
}

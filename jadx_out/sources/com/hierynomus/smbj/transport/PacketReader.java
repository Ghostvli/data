package com.hierynomus.smbj.transport;

import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.transport.PacketReceiver;
import com.hierynomus.protocol.transport.TransportException;
import defpackage.j02;
import defpackage.n02;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PacketReader<D extends PacketData<?>> implements Runnable {
    private PacketReceiver<D> handler;
    protected InputStream in;
    private final j02 logger = n02.k(getClass());
    private AtomicBoolean stopped = new AtomicBoolean(false);
    private Thread thread;

    public PacketReader(String str, InputStream inputStream, PacketReceiver<D> packetReceiver) {
        if (inputStream instanceof BufferedInputStream) {
            this.in = inputStream;
        } else {
            this.in = new BufferedInputStream(inputStream);
        }
        this.handler = packetReceiver;
        Thread thread = new Thread(this, "Packet Reader for " + str);
        this.thread = thread;
        thread.setDaemon(true);
    }

    private void readPacket() {
        PacketData packetDataDoRead = doRead();
        this.logger.q("Received packet {}", packetDataDoRead);
        this.handler.handle(packetDataDoRead);
    }

    public abstract D doRead();

    @Override // java.lang.Runnable
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !this.stopped.get()) {
            try {
                readPacket();
            } catch (TransportException e) {
                if (!this.stopped.get()) {
                    this.logger.t("PacketReader error, got exception.", e);
                    this.handler.handleError(e);
                    return;
                }
            }
        }
        if (this.stopped.get()) {
            this.logger.c("{} stopped.", this.thread);
        }
    }

    public void start() {
        this.logger.q("Starting PacketReader on thread: {}", this.thread.getName());
        this.thread.start();
    }

    public void stop() {
        this.logger.b("Stopping PacketReader...");
        this.stopped.set(true);
        this.thread.interrupt();
    }
}

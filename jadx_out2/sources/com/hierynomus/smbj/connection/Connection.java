package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb.SMB1PacketFactory;
import com.hierynomus.mssmb2.SMB2MessageConverter;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketFactory;
import com.hierynomus.mssmb2.SMB3CompressedPacketFactory;
import com.hierynomus.mssmb2.SMB3EncryptedPacketFactory;
import com.hierynomus.mssmb2.messages.SMB2Cancel;
import com.hierynomus.protocol.commons.concurrent.AFuture;
import com.hierynomus.protocol.commons.concurrent.CancellableFuture;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.protocol.transport.PacketFactory;
import com.hierynomus.protocol.transport.PacketHandlers;
import com.hierynomus.protocol.transport.PacketReceiver;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.protocol.transport.TransportLayer;
import com.hierynomus.smb.SMBPacket;
import com.hierynomus.smb.SMBPacketData;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.common.Pooled;
import com.hierynomus.smbj.connection.SMBSessionBuilder;
import com.hierynomus.smbj.connection.packet.DeadLetterPacketHandler;
import com.hierynomus.smbj.connection.packet.IncomingPacketHandler;
import com.hierynomus.smbj.connection.packet.SMB1PacketHandler;
import com.hierynomus.smbj.connection.packet.SMB2AsyncResponsePacketHandler;
import com.hierynomus.smbj.connection.packet.SMB2CompoundedPacketHandler;
import com.hierynomus.smbj.connection.packet.SMB2CreditGrantingPacketHandler;
import com.hierynomus.smbj.connection.packet.SMB2IsOutstandingPacketHandler;
import com.hierynomus.smbj.connection.packet.SMB2ProcessResponsePacketHandler;
import com.hierynomus.smbj.connection.packet.SMB2SignatureVerificationPacketHandler;
import com.hierynomus.smbj.connection.packet.SMB3DecryptingPacketHandler;
import com.hierynomus.smbj.event.ConnectionClosed;
import com.hierynomus.smbj.event.SMBEventBus;
import com.hierynomus.smbj.event.SessionLoggedOff;
import com.hierynomus.smbj.paths.DFSPathResolver;
import com.hierynomus.smbj.paths.PathResolver;
import com.hierynomus.smbj.paths.SymlinkPathResolver;
import com.hierynomus.smbj.server.ServerList;
import com.hierynomus.smbj.session.Session;
import defpackage.j02;
import defpackage.n02;
import defpackage.r14;
import defpackage.sb1;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import net.engio.mbassy.listener.Handler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Connection extends Pooled<Connection> implements Closeable, PacketReceiver<SMBPacketData<?>> {
    private final SMBEventBus bus;
    private final SMBClient client;
    private SmbConfig config;
    private ConnectionContext connectionContext;
    private PacketEncryptor encryptor;
    private IncomingPacketHandler packetHandlerChain;
    private PathResolver pathResolver;
    SequenceWindow sequenceWindow;
    final ServerList serverList;
    private Signatory signatory;
    TransportLayer<SMBPacket<?, ?>> transport;
    private static final j02 logger = n02.k(Connection.class);
    private static final DelegatingSMBMessageConverter converter = new DelegatingSMBMessageConverter(new SMB3EncryptedPacketFactory(), new SMB3CompressedPacketFactory(), new SMB2PacketFactory(), new SMB1PacketFactory());
    private SessionTable sessionTable = new SessionTable();
    private SessionTable preauthSessionTable = new SessionTable();
    OutstandingRequests outstandingRequests = new OutstandingRequests();
    private SMB2MessageConverter messageConverter = new SMB2MessageConverter();
    private final ReentrantLock lock = new ReentrantLock();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class CancelRequest implements CancellableFuture.CancelCallback {
        private Request request;
        private long sessionId;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CancelRequest(Request request, long j) {
            this.request = request;
            this.sessionId = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.concurrent.CancellableFuture.CancelCallback
        public void cancel() {
            SMB2Cancel sMB2Cancel = new SMB2Cancel(Connection.this.connectionContext.getNegotiatedProtocol().getDialect(), this.sessionId, this.request.getMessageId(), this.request.getAsyncId());
            try {
                Connection.this.sessionTable.find(Long.valueOf(this.sessionId)).send(sMB2Cancel);
            } catch (TransportException unused) {
                Connection.logger.r("Failed to send {}", sMB2Cancel);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class DelegatingSMBMessageConverter implements PacketFactory<SMBPacketData<?>> {
        private PacketFactory<?>[] packetFactories;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DelegatingSMBMessageConverter(PacketFactory<?>... packetFactoryArr) {
            this.packetFactories = packetFactoryArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.transport.PacketFactory
        public boolean canHandle(byte[] bArr) {
            for (PacketFactory<?> packetFactory : this.packetFactories) {
                if (packetFactory.canHandle(bArr)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: read([B)Lcom/hierynomus/protocol/PacketData; */
        @Override // com.hierynomus.protocol.transport.PacketFactory
        public SMBPacketData<?> read(byte[] bArr) throws IOException {
            for (PacketFactory<?> packetFactory : this.packetFactories) {
                if (packetFactory.canHandle(bArr)) {
                    return (SMBPacketData) packetFactory.read(bArr);
                }
            }
            sb1.a("Unknown packet format received.");
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: com.hierynomus.protocol.transport.TransportLayer<P extends com.hierynomus.protocol.Packet<?>>, com.hierynomus.protocol.transport.TransportLayer<com.hierynomus.smb.SMBPacket<?, ?>> */
    public Connection(SmbConfig smbConfig, SMBClient sMBClient, SMBEventBus sMBEventBus, ServerList serverList) {
        this.config = smbConfig;
        this.client = sMBClient;
        this.transport = smbConfig.getTransportLayerFactory().createTransportLayer(new PacketHandlers<>(new SMBPacketSerializer(), this, converter), smbConfig);
        this.bus = sMBEventBus;
        this.serverList = serverList;
        init();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int calculateGrantedCredits(SMB2Packet sMB2Packet, int i) {
        int iCreditsNeeded = creditsNeeded(sMB2Packet.getMaxPayloadSize());
        if (iCreditsNeeded <= 1 || this.connectionContext.supportsMultiCredit()) {
            if (iCreditsNeeded >= i) {
                if (iCreditsNeeded > 1 && i > 1) {
                    iCreditsNeeded = i - 1;
                }
            }
            sMB2Packet.setCreditsAssigned(iCreditsNeeded);
            return iCreditsNeeded;
        }
        logger.h("Connection to {} does not support multi-credit requests.", getRemoteHostname());
        iCreditsNeeded = 1;
        sMB2Packet.setCreditsAssigned(iCreditsNeeded);
        return iCreditsNeeded;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int creditsNeeded(int i) {
        return Math.abs((i - 1) / 65536) + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void init() {
        this.bus.subscribe(this);
        this.sequenceWindow = new SequenceWindow();
        if (this.config.isSigningEnabled()) {
            this.signatory = new PacketSignatory(this.config.getSecurityProvider());
        } else {
            logger.warn("Signing is disabled for this connection.");
            this.signatory = new NoSignatory();
        }
        this.encryptor = new PacketEncryptor(this.config.getSecurityProvider());
        this.packetHandlerChain = new SMB3DecryptingPacketHandler(this.sessionTable, this.encryptor).setNext(new SMB2CompoundedPacketHandler().setNext(new SMB2IsOutstandingPacketHandler(this.outstandingRequests).setNext(new SMB2SignatureVerificationPacketHandler(this.sessionTable, this.signatory).setNext(new SMB2CreditGrantingPacketHandler(this.sequenceWindow).setNext(new SMB2AsyncResponsePacketHandler(this.outstandingRequests).setNext(new SMB2ProcessResponsePacketHandler(this.messageConverter, this.outstandingRequests).setNext(new SMB1PacketHandler().setNext(new DeadLetterPacketHandler()))))))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Handler
    private void sessionLogoff(SessionLoggedOff sessionLoggedOff) {
        this.sessionTable.removeSession(Long.valueOf(sessionLoggedOff.getSessionId()));
        logger.q("Session << {} >> logged off", Long.valueOf(sessionLoggedOff.getSessionId()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Session authenticate(AuthenticationContext authenticationContext) {
        return new SMBSessionBuilder(this, this.config, new SMBSessionBuilder.SessionFactory() { // from class: com.hierynomus.smbj.connection.Connection.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // com.hierynomus.smbj.connection.SMBSessionBuilder.SessionFactory
            public Session createSession(AuthenticationContext authenticationContext2) {
                Connection connection = Connection.this;
                return new Session(connection, connection.config, authenticationContext2, Connection.this.bus, Connection.this.pathResolver, Connection.this.signatory, Connection.this.encryptor);
            }
        }).establish(authenticationContext);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void close(boolean z) {
        if (z || release()) {
            if (!z) {
                try {
                    for (Session session : this.sessionTable.activeSessions()) {
                        try {
                            session.close();
                        } catch (IOException e) {
                            logger.m("Exception while closing session {}", Long.valueOf(session.getSessionId()), e);
                        }
                    }
                } finally {
                    this.transport.disconnect();
                    logger.c("Closed connection to {}", getRemoteHostname());
                    this.bus.publish(new ConnectionClosed(this.connectionContext.getServer().getServerName(), this.connectionContext.getServer().getPort()));
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void connect(String str, int i) throws TransportException {
        if (isConnected()) {
            r14.a("This connection is already connected to %s", new Object[]{getRemoteHostname()});
            return;
        }
        this.transport.connect(new InetSocketAddress(str, i));
        this.connectionContext = new ConnectionContext(this.config.getClientGuid(), str, i, this.config);
        new SMBProtocolNegotiator(this, this.config, this.connectionContext).negotiateDialect();
        this.encryptor.init(this.connectionContext);
        this.pathResolver = new SymlinkPathResolver(PathResolver.LOCAL);
        if (this.config.isDfsEnabled() && this.connectionContext.supportsDFS()) {
            this.pathResolver = new DFSPathResolver(this.pathResolver, this.config.getTransactTimeout());
        }
        logger.c("Successfully connected to: {}", getRemoteHostname());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMBClient getClient() {
        return this.client;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ConnectionContext getConnectionContext() {
        return this.connectionContext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NegotiatedProtocol getNegotiatedProtocol() {
        return this.connectionContext.getNegotiatedProtocol();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SessionTable getPreauthSessionTable() {
        return this.preauthSessionTable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRemoteHostname() {
        return this.connectionContext.getServer().getServerName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SessionTable getSessionTable() {
        return this.sessionTable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.transport.PacketReceiver
    public void handleError(Throwable th) {
        this.outstandingRequests.handleError(th);
        try {
            close();
        } catch (Exception e) {
            logger.f("{} while closing connection on error, ignoring: {}", e.getClass().getSimpleName(), e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isConnected() {
        return this.transport.isConnected();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <T extends SMB2Packet> Future<T> send(SMB2Packet sMB2Packet) {
        AFuture<T> future;
        if (sMB2Packet.getPacket() instanceof SMB2Cancel) {
            future = null;
        } else {
            this.lock.lock();
            try {
                int iAvailable = this.sequenceWindow.available();
                int iCalculateGrantedCredits = calculateGrantedCredits(sMB2Packet, iAvailable);
                if (iAvailable == 0) {
                    logger.d("There are no credits left to send {}, will block until there are more credits available.", sMB2Packet.getHeader().getMessage());
                }
                sMB2Packet.getHeader().setMessageId(this.sequenceWindow.get(iCalculateGrantedCredits)[0]);
                sMB2Packet.getHeader().setCreditRequest(Math.max((512 - iAvailable) - iCalculateGrantedCredits, iCalculateGrantedCredits));
                logger.s("Granted {} (out of {}) credits to {}", Integer.valueOf(iCalculateGrantedCredits), Integer.valueOf(iAvailable), sMB2Packet);
                this.lock.unlock();
                Request request = new Request(sMB2Packet.getPacket(), sMB2Packet.getHeader().getMessageId(), UUID.randomUUID());
                this.outstandingRequests.registerOutstanding(request);
                future = request.getFuture(new CancelRequest(request, sMB2Packet.getHeader().getSessionId()));
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.transport.write(sMB2Packet);
        return future;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <T extends SMB2Packet> T sendAndReceive(SMB2Packet sMB2Packet) {
        return (T) Futures.get(send(sMB2Packet), this.config.getTransactTimeout(), TimeUnit.MILLISECONDS, TransportException.Wrapper);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMessageConverter(SMB2MessageConverter sMB2MessageConverter) {
        this.messageConverter = sMB2MessageConverter;
    }

    /* JADX DEBUG: Method merged with bridge method: handle(Lcom/hierynomus/protocol/PacketData;)V */
    @Override // com.hierynomus.protocol.transport.PacketReceiver
    public void handle(SMBPacketData<?> sMBPacketData) {
        this.packetHandlerChain.handle(sMBPacketData);
    }

    public Connection(Connection connection) {
        this.client = connection.client;
        this.config = connection.config;
        this.transport = connection.transport;
        this.bus = connection.bus;
        this.serverList = connection.serverList;
        init();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(false);
    }
}

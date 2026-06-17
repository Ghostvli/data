package com.hierynomus.smbj.session;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.mssmb2.SMB2ShareCapabilities;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2CreateRequest;
import com.hierynomus.mssmb2.messages.SMB2Logoff;
import com.hierynomus.mssmb2.messages.SMB2TreeConnectRequest;
import com.hierynomus.mssmb2.messages.SMB2TreeConnectResponse;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.connection.PacketEncryptor;
import com.hierynomus.smbj.connection.Signatory;
import com.hierynomus.smbj.event.SMBEventBus;
import com.hierynomus.smbj.event.SessionLoggedOff;
import com.hierynomus.smbj.event.TreeDisconnected;
import com.hierynomus.smbj.paths.PathResolveException;
import com.hierynomus.smbj.paths.PathResolver;
import com.hierynomus.smbj.share.DiskShare;
import com.hierynomus.smbj.share.PipeShare;
import com.hierynomus.smbj.share.PrinterShare;
import com.hierynomus.smbj.share.Share;
import com.hierynomus.smbj.share.TreeConnect;
import defpackage.j02;
import defpackage.n02;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.SecretKey;
import net.engio.mbassy.listener.Handler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Session implements AutoCloseable {
    private static final j02 logger = n02.k(Session.class);
    private SMBEventBus bus;
    private final SmbConfig config;
    private Connection connection;
    private PacketEncryptor encryptor;
    private final PathResolver pathResolver;
    private long sessionId;
    private Signatory signatory;
    private AuthenticationContext userCredentials;
    private TreeConnectTable treeConnectTable = new TreeConnectTable();
    private Map<String, Session> nestedSessionsByHost = new HashMap();
    private ReentrantReadWriteLock nestedSessionsRwLock = new ReentrantReadWriteLock();
    private SessionContext sessionContext = new SessionContext();

    public Session(Connection connection, SmbConfig smbConfig, AuthenticationContext authenticationContext, SMBEventBus sMBEventBus, PathResolver pathResolver, Signatory signatory, PacketEncryptor packetEncryptor) {
        this.connection = connection;
        this.config = smbConfig;
        this.userCredentials = authenticationContext;
        this.bus = sMBEventBus;
        this.pathResolver = pathResolver;
        this.signatory = signatory;
        this.encryptor = packetEncryptor;
        if (sMBEventBus != null) {
            sMBEventBus.subscribe(this);
        }
    }

    private Share connectTree(String str) {
        Share printerShare;
        final SmbPath smbPath = new SmbPath(this.connection.getRemoteHostname(), str);
        logger.A("Connecting to {} on session {}", smbPath, Long.valueOf(this.sessionId));
        try {
            SMB2TreeConnectRequest sMB2TreeConnectRequest = new SMB2TreeConnectRequest(this.connection.getNegotiatedProtocol().getDialect(), smbPath, this.sessionId);
            sMB2TreeConnectRequest.getHeader().setCreditRequest(Buffer.DEFAULT_SIZE);
            SMB2TreeConnectResponse sMB2TreeConnectResponse = (SMB2TreeConnectResponse) Futures.get(send(sMB2TreeConnectRequest), this.config.getTransactTimeout(), TimeUnit.MILLISECONDS, TransportException.Wrapper);
            try {
                Share share = (Share) this.pathResolver.resolve(this, sMB2TreeConnectResponse, smbPath, new PathResolver.ResolveAction<Share>() { // from class: com.hierynomus.smbj.session.Session.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.hierynomus.smbj.paths.PathResolver.ResolveAction
                    public Share apply(SmbPath smbPath2) {
                        Session nestedSession = Session.this;
                        if (!smbPath2.isOnSameHost(smbPath)) {
                            Session.logger.c("Re-routing the connection to host {}", smbPath2.getHostname());
                            nestedSession = Session.this.getNestedSession(smbPath2);
                        }
                        if (smbPath2.isOnSameShare(smbPath)) {
                            return null;
                        }
                        return nestedSession.connectShare(smbPath2.getShareName());
                    }
                });
                if (share != null) {
                    return share;
                }
            } catch (PathResolveException unused) {
            }
            if (NtStatus.isError(sMB2TreeConnectResponse.getHeader().getStatusCode())) {
                logger.b(sMB2TreeConnectResponse.getHeader().toString());
                throw new SMBApiException(sMB2TreeConnectResponse.getHeader(), "Could not connect to " + smbPath);
            }
            if (sMB2TreeConnectResponse.getCapabilities().contains(SMB2ShareCapabilities.SMB2_SHARE_CAP_ASYMMETRIC)) {
                throw new SMBRuntimeException("ASYMMETRIC capability unsupported");
            }
            TreeConnect treeConnect = new TreeConnect(sMB2TreeConnectResponse.getHeader().getTreeId(), smbPath, this, sMB2TreeConnectResponse.getCapabilities(), this.config, this.connection.getConnectionContext(), this.bus, sMB2TreeConnectResponse.getMaximalAccess(), sMB2TreeConnectResponse.getShareFlags());
            if (sMB2TreeConnectResponse.isDiskShare()) {
                printerShare = new DiskShare(smbPath, treeConnect, this.pathResolver);
            } else if (sMB2TreeConnectResponse.isNamedPipe()) {
                printerShare = new PipeShare(smbPath, treeConnect);
            } else {
                if (!sMB2TreeConnectResponse.isPrinterShare()) {
                    throw new SMBRuntimeException("Unknown ShareType returned in the TREE_CONNECT Response");
                }
                printerShare = new PrinterShare(smbPath, treeConnect);
            }
            this.treeConnectTable.register(printerShare);
            return printerShare;
        } catch (TransportException e) {
            throw new SMBRuntimeException(e);
        }
    }

    private Session createNestedSession(SmbPath smbPath) {
        try {
            return getConnection().getClient().connect(smbPath.getHostname()).authenticate(getAuthenticationContext());
        } catch (IOException e) {
            throw new SMBApiException(NtStatus.STATUS_OTHER.getValue(), SMB2MessageCommandCode.SMB2_NEGOTIATE, "Could not connect to DFS root " + smbPath, e);
        }
    }

    @Handler
    private void disconnectTree(TreeDisconnected treeDisconnected) {
        if (treeDisconnected.getSessionId() == this.sessionId) {
            logger.q("Notified of TreeDisconnected <<{}>>", Long.valueOf(treeDisconnected.getTreeId()));
            this.treeConnectTable.closed(treeDisconnected.getTreeId());
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        logoff();
    }

    public Share connectShare(String str) {
        if (str.contains("\\")) {
            throw new IllegalArgumentException(String.format("Share name (%s) cannot contain '\\' characters.", str));
        }
        Share treeConnect = this.treeConnectTable.getTreeConnect(str);
        if (treeConnect == null) {
            return connectTree(str);
        }
        logger.f("Returning cached Share {} for {}", treeConnect, str);
        return treeConnect;
    }

    public AuthenticationContext getAuthenticationContext() {
        return this.userCredentials;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Session getNestedSession(SmbPath smbPath) {
        this.nestedSessionsRwLock.readLock().lock();
        try {
            Session session = this.nestedSessionsByHost.get(smbPath.getHostname());
            ReentrantReadWriteLock reentrantReadWriteLock = this.nestedSessionsRwLock;
            if (session != null) {
                reentrantReadWriteLock.readLock().unlock();
                return session;
            }
            reentrantReadWriteLock.readLock().unlock();
            this.nestedSessionsRwLock.writeLock().lock();
            try {
                Session sessionCreateNestedSession = this.nestedSessionsByHost.get(smbPath.getHostname());
                if (sessionCreateNestedSession == null) {
                    sessionCreateNestedSession = createNestedSession(smbPath);
                    this.nestedSessionsByHost.put(smbPath.getHostname(), sessionCreateNestedSession);
                }
                this.nestedSessionsRwLock.readLock().lock();
                this.nestedSessionsRwLock.writeLock().unlock();
                return sessionCreateNestedSession;
            } catch (Throwable th) {
                this.nestedSessionsRwLock.writeLock().unlock();
                throw th;
            }
        } finally {
            this.nestedSessionsRwLock.readLock().unlock();
        }
    }

    public SessionContext getSessionContext() {
        return this.sessionContext;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public SecretKey getSigningKey(SMB2PacketHeader sMB2PacketHeader, boolean z) {
        if (!this.connection.getNegotiatedProtocol().getDialect().isSmb3x()) {
            return this.sessionContext.getSessionKey();
        }
        if (sMB2PacketHeader.getMessage() == SMB2MessageCommandCode.SMB2_SESSION_SETUP) {
            if (z) {
                return this.sessionContext.getSigningKey();
            }
            if (sMB2PacketHeader.getStatusCode() != NtStatus.STATUS_SUCCESS.getValue()) {
                return this.sessionContext.getSigningKey();
            }
        }
        return this.sessionContext.getSigningKey();
    }

    public boolean isAnonymous() {
        return this.sessionContext.isAnonymous();
    }

    public boolean isGuest() {
        return this.sessionContext.isGuest();
    }

    public boolean isSigningRequired() {
        return this.sessionContext.isSigningRequired();
    }

    public void logoff() {
        try {
            logger.A("Logging off session {} from host {}", Long.valueOf(this.sessionId), this.connection.getRemoteHostname());
            for (Share share : this.treeConnectTable.getOpenTreeConnects()) {
                try {
                    share.close();
                } catch (IOException e) {
                    logger.o("Caught exception while closing TreeConnect with id: {}", Long.valueOf(share.getTreeConnect().getTreeId()), e);
                }
            }
            this.nestedSessionsRwLock.writeLock().lock();
            try {
                for (Session session : this.nestedSessionsByHost.values()) {
                    logger.A("Logging off nested session {} for session {}", Long.valueOf(session.getSessionId()), Long.valueOf(this.sessionId));
                    try {
                        session.logoff();
                    } catch (TransportException unused) {
                        logger.r("Caught exception while logging off nested session {}", Long.valueOf(session.getSessionId()));
                    }
                }
                this.nestedSessionsRwLock.writeLock().unlock();
                SMB2Logoff sMB2Logoff = (SMB2Logoff) Futures.get(send(new SMB2Logoff(this.connection.getNegotiatedProtocol().getDialect(), this.sessionId)), this.config.getTransactTimeout(), TimeUnit.MILLISECONDS, TransportException.Wrapper);
                if (NtStatus.isSuccess(sMB2Logoff.getHeader().getStatusCode())) {
                    return;
                }
                throw new SMBApiException(sMB2Logoff.getHeader(), "Could not logoff session <<" + this.sessionId + ">>");
            } catch (Throwable th) {
                this.nestedSessionsRwLock.writeLock().unlock();
                throw th;
            }
        } finally {
            this.bus.publish(new SessionLoggedOff(this.sessionId));
        }
    }

    public <T extends SMB2Packet> T processSendResponse(SMB2CreateRequest sMB2CreateRequest) {
        return (T) Futures.get(send(sMB2CreateRequest), SMBRuntimeException.Wrapper);
    }

    public <T extends SMB2Packet> Future<T> send(SMB2Packet sMB2Packet) {
        SecretKey signingKey = getSigningKey(sMB2Packet.getHeader(), true);
        if (this.sessionContext.isSigningRequired() && signingKey == null) {
            throw new TransportException("Message signing is required, but no signing key is negotiated");
        }
        boolean zShouldEncryptData = shouldEncryptData();
        Connection connection = this.connection;
        return zShouldEncryptData ? connection.send(this.encryptor.encrypt(sMB2Packet, this.sessionContext.getEncryptionKey())) : connection.send(this.signatory.sign(sMB2Packet, signingKey));
    }

    public void setSessionId(long j) {
        this.sessionId = j;
    }

    public boolean shouldEncryptData() throws TransportException {
        if (this.sessionContext.isEncryptData() && this.sessionContext.getEncryptionKey() == null) {
            throw new TransportException("Message encryption is required, but no encryption key is negotiated");
        }
        return (this.sessionContext.getEncryptionKey() != null && this.connection.getConnectionContext().clientPrefersEncryption()) | this.sessionContext.isEncryptData();
    }
}

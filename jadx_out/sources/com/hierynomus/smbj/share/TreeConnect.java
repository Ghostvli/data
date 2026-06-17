package com.hierynomus.smbj.share;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2ShareCapabilities;
import com.hierynomus.mssmb2.SMB2ShareFlags;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2TreeDisconnect;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.connection.ConnectionContext;
import com.hierynomus.smbj.connection.NegotiatedProtocol;
import com.hierynomus.smbj.event.SMBEventBus;
import com.hierynomus.smbj.event.TreeDisconnected;
import com.hierynomus.smbj.session.Session;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TreeConnect {
    private final SMBEventBus bus;
    private final Set<SMB2ShareCapabilities> capabilities;
    private SmbConfig config;
    private final boolean encryptData;
    private final Set<AccessMask> maximalAccess;
    private final NegotiatedProtocol negotiatedProtocol;
    private Session session;
    private SmbPath smbPath;
    private long treeId;

    public TreeConnect(long j, SmbPath smbPath, Session session, Set<SMB2ShareCapabilities> set, SmbConfig smbConfig, ConnectionContext connectionContext, SMBEventBus sMBEventBus, Set<AccessMask> set2, Set<SMB2ShareFlags> set3) {
        this.treeId = j;
        this.smbPath = smbPath;
        this.session = session;
        this.capabilities = set;
        NegotiatedProtocol negotiatedProtocol = connectionContext.getNegotiatedProtocol();
        this.negotiatedProtocol = negotiatedProtocol;
        this.config = smbConfig;
        this.bus = sMBEventBus;
        this.maximalAccess = set2;
        this.encryptData = set3.contains(SMB2ShareFlags.SMB2_SHAREFLAG_ENCRYPT_DATA) && negotiatedProtocol.getDialect().isSmb3x() && connectionContext.supportsEncryption();
    }

    public void close() {
        try {
            SMB2Packet sMB2Packet = (SMB2Packet) Futures.get(this.session.send(new SMB2TreeDisconnect(this.negotiatedProtocol.getDialect(), this.session.getSessionId(), this.treeId)), this.config.getTransactTimeout(), TimeUnit.MILLISECONDS, TransportException.Wrapper);
            if (NtStatus.isSuccess(sMB2Packet.getHeader().getStatusCode())) {
                return;
            }
            throw new SMBApiException(sMB2Packet.getHeader(), "Error closing connection to " + this.smbPath);
        } finally {
            this.bus.publish(new TreeDisconnected(this.session.getSessionId(), this.treeId));
        }
    }

    public SmbConfig getConfig() {
        return this.config;
    }

    public Set<AccessMask> getMaximalAccess() {
        return this.maximalAccess;
    }

    public NegotiatedProtocol getNegotiatedProtocol() {
        return this.negotiatedProtocol;
    }

    public Session getSession() {
        return this.session;
    }

    public String getShareName() {
        return this.smbPath.getShareName();
    }

    public long getTreeId() {
        return this.treeId;
    }

    public boolean isCAShare() {
        return this.capabilities.contains(SMB2ShareCapabilities.SMB2_SHARE_CAP_CONTINUOUS_AVAILABILITY);
    }

    public boolean isDfsShare() {
        return this.capabilities.contains(SMB2ShareCapabilities.SMB2_SHARE_CAP_DFS);
    }

    public boolean isScaleoutShare() {
        return this.capabilities.contains(SMB2ShareCapabilities.SMB2_SHARE_CAP_SCALEOUT);
    }

    public String toString() {
        return String.format("TreeConnect[%s](%s)", Long.valueOf(this.treeId), this.smbPath);
    }
}

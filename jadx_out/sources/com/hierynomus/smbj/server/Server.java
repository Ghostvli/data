package com.hierynomus.smbj.server;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2GlobalCapability;
import defpackage.r14;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Server {
    private Set<SMB2GlobalCapability> capabilities;
    private SMB2Dialect dialectRevision;
    private boolean initialized = false;
    private int port;
    private int securityMode;
    private UUID serverGUID;
    private String serverName;

    public Server(String str, int i) {
        this.serverName = str;
        this.port = i;
    }

    public Set<SMB2GlobalCapability> getCapabilities() {
        return this.capabilities;
    }

    public SMB2Dialect getDialectRevision() {
        return this.dialectRevision;
    }

    public int getPort() {
        return this.port;
    }

    public int getSecurityMode() {
        return this.securityMode;
    }

    public UUID getServerGUID() {
        return this.serverGUID;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void init(UUID uuid, SMB2Dialect sMB2Dialect, int i, Set<SMB2GlobalCapability> set) {
        if (this.initialized) {
            r14.a("Server object '%s' already initialized", new Object[]{this.serverName});
            return;
        }
        this.initialized = true;
        this.serverGUID = uuid;
        this.dialectRevision = sMB2Dialect;
        this.securityMode = i;
        this.capabilities = set;
    }

    public boolean validate(Server server) {
        return server.getServerGUID().equals(this.serverGUID) && server.getDialectRevision().equals(this.dialectRevision) && (server.getSecurityMode() == this.securityMode) && server.getCapabilities().equals(this.capabilities);
    }
}

package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2GlobalCapability;
import com.hierynomus.mssmb2.SMB3CompressionAlgorithm;
import com.hierynomus.mssmb2.SMB3EncryptionCipher;
import com.hierynomus.mssmb2.SMB3HashAlgorithm;
import com.hierynomus.mssmb2.messages.SMB2NegotiateResponse;
import com.hierynomus.ntlm.messages.WindowsVersion;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.connection.SMBProtocolNegotiator;
import com.hierynomus.smbj.server.Server;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectionContext {
    private static final int SIGNING_ENABLED = 1;
    private static final int SIGNING_REQUIRED = 2;
    private SMB3EncryptionCipher cipherId;
    private EnumSet<SMB2GlobalCapability> clientCapabilities;
    private final UUID clientGuid;
    private int clientSecurityMode;
    private Set<SMB3CompressionAlgorithm> compressionIds;
    private byte[] gssNegotiateToken = new byte[0];
    private NegotiatedProtocol negotiatedProtocol;
    private String netBiosName;
    private SMB3HashAlgorithm preauthIntegrityHashId;
    private byte[] preauthIntegrityHashValue;
    private Server server;
    private Long timeOffsetMillis;
    private WindowsVersion windowsVersion;

    public ConnectionContext(UUID uuid, String str, int i, SmbConfig smbConfig) {
        this.clientGuid = uuid;
        this.clientCapabilities = EnumSet.copyOf((Collection) smbConfig.getClientCapabilities());
        this.clientSecurityMode = smbConfig.isSigningRequired() ? 2 : 1;
        this.server = new Server(str, i);
    }

    private boolean supports(SMB2GlobalCapability sMB2GlobalCapability) {
        return this.server.getCapabilities().contains(sMB2GlobalCapability);
    }

    public boolean clientPrefersEncryption() {
        return this.negotiatedProtocol.getDialect().isSmb3x() && supportsEncryption();
    }

    public SMB3EncryptionCipher getCipherId() {
        return this.cipherId;
    }

    public EnumSet<SMB2GlobalCapability> getClientCapabilities() {
        return this.clientCapabilities;
    }

    public UUID getClientGuid() {
        return this.clientGuid;
    }

    public Set<SMB3CompressionAlgorithm> getCompressionIds() {
        return this.compressionIds;
    }

    public byte[] getGssNegotiateToken() {
        byte[] bArr = this.gssNegotiateToken;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public NegotiatedProtocol getNegotiatedProtocol() {
        return this.negotiatedProtocol;
    }

    public String getNetBiosName() {
        return this.netBiosName;
    }

    public SMB3HashAlgorithm getPreauthIntegrityHashId() {
        return this.preauthIntegrityHashId;
    }

    public byte[] getPreauthIntegrityHashValue() {
        return this.preauthIntegrityHashValue;
    }

    public Server getServer() {
        return this.server;
    }

    public Set<SMB2GlobalCapability> getServerCapabilities() {
        return this.server.getCapabilities();
    }

    public UUID getServerGuid() {
        return this.server.getServerGUID();
    }

    public String getServerName() {
        return this.server.getServerName();
    }

    public int getServerSecurityMode() {
        return this.server.getSecurityMode();
    }

    public Long getTimeOffsetMillis() {
        return this.timeOffsetMillis;
    }

    public WindowsVersion getWindowsVersion() {
        return this.windowsVersion;
    }

    public boolean isServerRequiresSigning() {
        return (this.server.getSecurityMode() & 2) > 0;
    }

    public boolean isServerSigningEnabled() {
        return (this.server.getSecurityMode() & 1) > 0;
    }

    public void negotiated(SMBProtocolNegotiator.NegotiationContext negotiationContext) {
        SMB2NegotiateResponse negotiationResponse = negotiationContext.getNegotiationResponse();
        this.server = negotiationContext.getServer();
        this.negotiatedProtocol = new NegotiatedProtocol(negotiationResponse.getDialect(), negotiationResponse.getMaxTransactSize(), negotiationResponse.getMaxReadSize(), negotiationResponse.getMaxWriteSize(), supportsMultiCredit());
        this.cipherId = negotiationContext.getCipher();
        this.compressionIds = negotiationContext.getCompressionIds();
        this.preauthIntegrityHashId = negotiationContext.getPreauthIntegrityHashId();
        this.preauthIntegrityHashValue = negotiationContext.getPreauthIntegrityHashValue() != null ? negotiationContext.getPreauthIntegrityHashValue() : new byte[0];
        this.timeOffsetMillis = Long.valueOf(System.currentTimeMillis() - negotiationResponse.getSystemTime().toEpochMillis());
    }

    public void setNetBiosName(String str) {
        this.netBiosName = str;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setWindowsVersion(WindowsVersion windowsVersion) {
        this.windowsVersion = windowsVersion;
    }

    public boolean supportsDFS() {
        return supports(SMB2GlobalCapability.SMB2_GLOBAL_CAP_DFS);
    }

    public boolean supportsDirectoryLeasing() {
        return this.negotiatedProtocol.getDialect().isSmb3x() && supports(SMB2GlobalCapability.SMB2_GLOBAL_CAP_DIRECTORY_LEASING);
    }

    public boolean supportsEncryption() {
        if (this.negotiatedProtocol.getDialect() == SMB2Dialect.SMB_3_1_1) {
            return this.cipherId != null;
        }
        EnumSet<SMB2GlobalCapability> enumSet = this.clientCapabilities;
        SMB2GlobalCapability sMB2GlobalCapability = SMB2GlobalCapability.SMB2_GLOBAL_CAP_ENCRYPTION;
        return enumSet.contains(sMB2GlobalCapability) && supports(sMB2GlobalCapability);
    }

    public boolean supportsFileLeasing() {
        return supports(SMB2GlobalCapability.SMB2_GLOBAL_CAP_LEASING);
    }

    public boolean supportsMultiChannel() {
        return this.negotiatedProtocol.getDialect().isSmb3x() && supports(SMB2GlobalCapability.SMB2_GLOBAL_CAP_MULTI_CHANNEL);
    }

    public boolean supportsMultiCredit() {
        return supports(SMB2GlobalCapability.SMB2_GLOBAL_CAP_LARGE_MTU);
    }

    public String toString() {
        return "ConnectionContext{\n  serverGuid=" + this.server.getServerGUID() + ",\n  serverName='" + this.server.getServerName() + "',\n  negotiatedProtocol=" + this.negotiatedProtocol + ",\n  clientGuid=" + this.clientGuid + ",\n  clientCapabilities=" + this.clientCapabilities + ",\n  serverCapabilities=" + this.server.getCapabilities() + ",\n  clientSecurityMode=" + this.clientSecurityMode + ",\n  serverSecurityMode=" + this.server.getSecurityMode() + ",\n  server='" + this.server + "'\n}";
    }
}

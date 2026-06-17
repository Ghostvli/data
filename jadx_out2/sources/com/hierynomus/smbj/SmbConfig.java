package com.hierynomus.smbj;

import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2GlobalCapability;
import com.hierynomus.ntlm.NtlmConfig;
import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.protocol.commons.socket.ProxySocketFactory;
import com.hierynomus.security.SecurityProvider;
import com.hierynomus.security.bc.BCSecurityProvider;
import com.hierynomus.smb.SMBPacket;
import com.hierynomus.smb.SMBPacketData;
import com.hierynomus.smbj.auth.Authenticator;
import com.hierynomus.smbj.auth.NtlmAuthenticator;
import com.hierynomus.smbj.auth.SpnegoAuthenticator;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.transport.TransportLayerFactory;
import com.hierynomus.smbj.transport.tcp.direct.DirectTcpTransportFactory;
import defpackage.e04;
import defpackage.jl;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class SmbConfig {
    private static final boolean ANDROID;
    private static final int DEFAULT_BUFFER_SIZE = 1048576;
    private static final int DEFAULT_SO_TIMEOUT = 0;
    private static final TimeUnit DEFAULT_SO_TIMEOUT_UNIT;
    private static final int DEFAULT_TIMEOUT = 60;
    private static final TimeUnit DEFAULT_TIMEOUT_UNIT;
    private static final TransportLayerFactory<SMBPacketData<?>, SMBPacket<?, ?>> DEFAULT_TRANSPORT_LAYER_FACTORY;
    private List<Factory.Named<Authenticator>> authenticators;
    private GSSContextConfig clientGSSContextConfig;
    private UUID clientGuid;
    private boolean dfsEnabled;
    private Set<SMB2Dialect> dialects;
    private boolean encryptData;
    private NtlmConfig ntlmConfig;
    private Random random;
    private int readBufferSize;
    private long readTimeout;
    private SecurityProvider securityProvider;
    private boolean signingEnabled;
    private boolean signingRequired;
    private int soTimeout;
    private SocketFactory socketFactory;
    private int transactBufferSize;
    private long transactTimeout;
    private TransportLayerFactory<SMBPacketData<?>, SMBPacket<?, ?>> transportLayerFactory;
    private boolean useMultiProtocolNegotiate;
    private int writeBufferSize;
    private long writeTimeout;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        boolean z;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        DEFAULT_SO_TIMEOUT_UNIT = timeUnit;
        DEFAULT_TIMEOUT_UNIT = timeUnit;
        DEFAULT_TRANSPORT_LAYER_FACTORY = new DirectTcpTransportFactory();
        try {
            Class.forName("android.os.Build");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        ANDROID = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private SmbConfig(SmbConfig smbConfig) {
        this();
        this.dialects.addAll(smbConfig.dialects);
        this.authenticators.addAll(smbConfig.authenticators);
        this.socketFactory = smbConfig.socketFactory;
        this.random = smbConfig.random;
        this.clientGuid = smbConfig.clientGuid;
        this.signingRequired = smbConfig.signingRequired;
        this.signingEnabled = smbConfig.signingEnabled;
        this.dfsEnabled = smbConfig.dfsEnabled;
        this.securityProvider = smbConfig.securityProvider;
        this.readBufferSize = smbConfig.readBufferSize;
        this.readTimeout = smbConfig.readTimeout;
        this.writeBufferSize = smbConfig.writeBufferSize;
        this.writeTimeout = smbConfig.writeTimeout;
        this.transactBufferSize = smbConfig.transactBufferSize;
        this.transactTimeout = smbConfig.transactTimeout;
        this.transportLayerFactory = smbConfig.transportLayerFactory;
        this.soTimeout = smbConfig.soTimeout;
        this.useMultiProtocolNegotiate = smbConfig.useMultiProtocolNegotiate;
        this.clientGSSContextConfig = smbConfig.clientGSSContextConfig;
        this.encryptData = smbConfig.encryptData;
        this.ntlmConfig = smbConfig.ntlmConfig;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Builder builder() {
        return new Builder().withClientGuid(UUID.randomUUID()).withSecurityProvider(getDefaultSecurityProvider()).withSocketFactory(new ProxySocketFactory()).withSigningRequired(false).withSigningEnabled(true).withDfsEnabled(false).withMultiProtocolNegotiate(false).withBufferSize(DEFAULT_BUFFER_SIZE).withTransportLayerFactory(DEFAULT_TRANSPORT_LAYER_FACTORY).withSoTimeout(0L, DEFAULT_SO_TIMEOUT_UNIT).withDialects(SMB2Dialect.SMB_3_1_1, SMB2Dialect.SMB_3_0_2, SMB2Dialect.SMB_3_0, SMB2Dialect.SMB_2_1, SMB2Dialect.SMB_2_0_2).withAuthenticators(getDefaultAuthenticators()).withTimeout(60L, DEFAULT_TIMEOUT_UNIT).withClientGSSContextConfig(GSSContextConfig.createDefaultConfig()).withEncryptData(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SmbConfig createDefaultConfig() {
        return builder().build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static List<Factory.Named<Authenticator>> getDefaultAuthenticators() {
        ArrayList arrayList = new ArrayList();
        if (!ANDROID) {
            try {
                arrayList.add((Factory.Named) SpnegoAuthenticator.Factory.class.getDeclaredConstructor(null).newInstance(null));
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                throw new SMBRuntimeException(e);
            }
        }
        arrayList.add(new NtlmAuthenticator.Factory());
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static SecurityProvider getDefaultSecurityProvider() {
        return new BCSecurityProvider();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<SMB2GlobalCapability> getClientCapabilities() {
        if (!SMB2Dialect.supportsSmb3x(this.dialects)) {
            return EnumSet.noneOf(SMB2GlobalCapability.class);
        }
        EnumSet enumSetOf = EnumSet.of(SMB2GlobalCapability.SMB2_GLOBAL_CAP_LARGE_MTU);
        if (isDfsEnabled()) {
            enumSetOf.add(SMB2GlobalCapability.SMB2_GLOBAL_CAP_DFS);
        }
        if (isEncryptData()) {
            enumSetOf.add(SMB2GlobalCapability.SMB2_GLOBAL_CAP_ENCRYPTION);
        }
        return enumSetOf;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GSSContextConfig getClientGSSContextConfig() {
        return this.clientGSSContextConfig;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UUID getClientGuid() {
        return this.clientGuid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtlmConfig getNtlmConfig() {
        return this.ntlmConfig;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Random getRandomProvider() {
        return this.random;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getReadBufferSize() {
        return this.readBufferSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getReadTimeout() {
        return this.readTimeout;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SecurityProvider getSecurityProvider() {
        return this.securityProvider;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSoTimeout() {
        return this.soTimeout;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Factory.Named<Authenticator>> getSupportedAuthenticators() {
        return new ArrayList(this.authenticators);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<SMB2Dialect> getSupportedDialects() {
        return EnumSet.copyOf((Collection) this.dialects);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTransactBufferSize() {
        return this.transactBufferSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTransactTimeout() {
        return this.transactTimeout;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TransportLayerFactory<SMBPacketData<?>, SMBPacket<?, ?>> getTransportLayerFactory() {
        return this.transportLayerFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getWorkStationName() {
        return getNtlmConfig().getWorkstationName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getWriteTimeout() {
        return this.writeTimeout;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDfsEnabled() {
        return this.dfsEnabled;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEncryptData() {
        return this.encryptData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSigningEnabled() {
        return this.signingEnabled;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSigningRequired() {
        return this.signingRequired;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isUseMultiProtocolNegotiate() {
        return this.useMultiProtocolNegotiate;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Builder {
        private SmbConfig config;
        private NtlmConfig.Builder ntlmConfigBuilder;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder() {
            SmbConfig smbConfig = new SmbConfig();
            this.config = smbConfig;
            this.ntlmConfigBuilder = NtlmConfig.builder(smbConfig.random);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public SmbConfig build() {
            if (this.config.dialects.isEmpty()) {
                e04.a("At least one SMB dialect should be specified");
                return null;
            }
            if (this.config.signingRequired && !this.config.signingEnabled) {
                e04.a("If signing is required, it should also be enabled");
                return null;
            }
            if (!this.config.signingEnabled && SMB2Dialect.supportsSmb3x(this.config.dialects)) {
                e04.a("Signing cannot be disabled when using SMB3.x dialects");
                return null;
            }
            if (this.config.encryptData && !SMB2Dialect.supportsSmb3x(this.config.dialects)) {
                e04.a("If encryption is enabled, at least one dialect should be SMB3.x compatible");
                return null;
            }
            this.config.ntlmConfig = this.ntlmConfigBuilder.build();
            return new SmbConfig();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withAuthenticators(Iterable<Factory.Named<Authenticator>> iterable) {
            if (iterable == null) {
                jl.a("Authenticators may not be null");
                return null;
            }
            this.config.authenticators.clear();
            for (Factory.Named<Authenticator> named : iterable) {
                if (named == null) {
                    jl.a("Authenticator may not be null");
                    return null;
                }
                this.config.authenticators.add(named);
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withBufferSize(int i) {
            if (i > 0) {
                return withReadBufferSize(i).withWriteBufferSize(i).withTransactBufferSize(i);
            }
            jl.a("Buffer size must be greater than zero");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withClientGSSContextConfig(GSSContextConfig gSSContextConfig) {
            if (gSSContextConfig != null) {
                this.config.clientGSSContextConfig = gSSContextConfig;
                return this;
            }
            jl.a("Client GSSContext Config may not be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withClientGuid(UUID uuid) {
            if (uuid != null) {
                this.config.clientGuid = uuid;
                return this;
            }
            jl.a("Client GUID may not be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withDfsEnabled(boolean z) {
            this.config.dfsEnabled = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withDialects(Iterable<SMB2Dialect> iterable) {
            if (iterable == null) {
                jl.a("Dialects may not be null");
                return null;
            }
            this.config.dialects.clear();
            for (SMB2Dialect sMB2Dialect : iterable) {
                if (sMB2Dialect == null) {
                    jl.a("Dialect may not be null");
                    return null;
                }
                this.config.dialects.add(sMB2Dialect);
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withEncryptData(boolean z) {
            this.config.encryptData = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withMultiProtocolNegotiate(boolean z) {
            this.config.useMultiProtocolNegotiate = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withNegotiatedBufferSize() {
            return withBufferSize(Integer.MAX_VALUE);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public NtlmConfig.Builder withNtlmConfig() {
            return this.ntlmConfigBuilder;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withRandomProvider(Random random) {
            if (random != null) {
                this.config.random = random;
                return this;
            }
            jl.a("Random provider may not be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withReadBufferSize(int i) {
            if (i > 0) {
                this.config.readBufferSize = i;
                return this;
            }
            jl.a("Read buffer size must be greater than zero");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withReadTimeout(long j, TimeUnit timeUnit) {
            this.config.readTimeout = timeUnit.toMillis(j);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withSecurityProvider(SecurityProvider securityProvider) {
            if (securityProvider != null) {
                this.config.securityProvider = securityProvider;
                return this;
            }
            jl.a("Security provider may not be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withSigningEnabled(boolean z) {
            this.config.signingEnabled = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withSigningRequired(boolean z) {
            this.config.signingRequired = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withSoTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                jl.a("Socket timeout should be either 0 (no timeout) or a positive value");
                return null;
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                jl.a("Socket timeout should be less than 2147483647ms");
                return null;
            }
            this.config.soTimeout = (int) millis;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withSocketFactory(SocketFactory socketFactory) {
            if (socketFactory != null) {
                this.config.socketFactory = socketFactory;
                return this;
            }
            jl.a("Socket factory may not be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withTimeout(long j, TimeUnit timeUnit) {
            return withReadTimeout(j, timeUnit).withWriteTimeout(j, timeUnit).withTransactTimeout(j, timeUnit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withTransactBufferSize(int i) {
            if (i > 0) {
                this.config.transactBufferSize = i;
                return this;
            }
            jl.a("Transact buffer size must be greater than zero");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withTransactTimeout(long j, TimeUnit timeUnit) {
            this.config.transactTimeout = timeUnit.toMillis(j);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withTransportLayerFactory(TransportLayerFactory<SMBPacketData<?>, SMBPacket<?, ?>> transportLayerFactory) {
            if (transportLayerFactory != null) {
                this.config.transportLayerFactory = transportLayerFactory;
                return this;
            }
            jl.a("Transport layer factory may not be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withWorkStationName(String str) {
            this.ntlmConfigBuilder.withWorkstationName(str);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withWriteBufferSize(int i) {
            if (i > 0) {
                this.config.writeBufferSize = i;
                return this;
            }
            jl.a("Write buffer size must be greater than zero");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder withWriteTimeout(long j, TimeUnit timeUnit) {
            this.config.writeTimeout = timeUnit.toMillis(j);
            return this;
        }

        public Builder(SmbConfig smbConfig) {
            SmbConfig smbConfig2 = new SmbConfig();
            this.config = smbConfig2;
            this.ntlmConfigBuilder = NtlmConfig.builder(smbConfig2.ntlmConfig);
        }

        public Builder withSoTimeout(int i) {
            return withSoTimeout(i, TimeUnit.MILLISECONDS);
        }

        @SafeVarargs
        public final Builder withAuthenticators(Factory.Named<Authenticator>... namedArr) {
            return withAuthenticators(Arrays.asList(namedArr));
        }

        public Builder withDialects(SMB2Dialect... sMB2DialectArr) {
            return withDialects(Arrays.asList(sMB2DialectArr));
        }
    }

    private SmbConfig() {
        this.dialects = EnumSet.noneOf(SMB2Dialect.class);
        this.random = new SecureRandom();
        this.authenticators = new ArrayList();
    }

    public static Builder builder(SmbConfig smbConfig) {
        return new Builder(smbConfig);
    }
}

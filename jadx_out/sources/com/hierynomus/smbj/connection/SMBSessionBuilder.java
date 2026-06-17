package com.hierynomus.smbj.connection;

import com.hierynomus.asn1.types.primitive.ASN1ObjectIdentifier;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2SessionSetup;
import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import com.hierynomus.security.DerivationFunction;
import com.hierynomus.security.MessageDigest;
import com.hierynomus.security.SecurityException;
import com.hierynomus.security.jce.derivationfunction.CounterDerivationParameters;
import com.hierynomus.smb.Packets;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.auth.AuthenticateResponse;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.auth.Authenticator;
import com.hierynomus.smbj.auth.NtlmAuthenticator;
import com.hierynomus.smbj.auth.NtlmSealer;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.session.SMB2GuestSigningRequiredException;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.session.SessionContext;
import com.hierynomus.smbj.utils.DigestUtil;
import com.hierynomus.spnego.NegTokenInit2;
import com.hierynomus.spnego.SpnegoException;
import com.hierynomus.spnego.SpnegoToken;
import com.hierynomus.utils.Strings;
import defpackage.j02;
import defpackage.n02;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBSessionBuilder {
    static final String AES_128_CMAC_ALGORITHM = "AesCmac";
    static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private final SmbConfig config;
    private final Connection connection;
    private final ConnectionContext connectionContext;
    private final SessionTable preauthSessionTable;
    private final SessionFactory sessionFactory;
    private final SessionTable sessionTable;
    static final byte[] KDF_ENC_LABEL_SMB311 = Strings.nullTerminatedBytes("SMBC2SCipherKey");
    static final byte[] KDF_DEC_LABEL_SMB311 = Strings.nullTerminatedBytes("SMBS2CCipherKey");
    static final byte[] KDF_ENCDEC_LABEL = Strings.nullTerminatedBytes("SMB2AESCCM");
    static final byte[] KDF_ENC_CONTEXT = Strings.nullTerminatedBytes("ServerIn ");
    static final byte[] KDF_DEC_CONTEXT = Strings.nullTerminatedBytes("ServerOut");
    static final byte[] KDF_SIGN_CONTEXT = Strings.nullTerminatedBytes("SmbSign");
    static final byte[] KDF_SIGN_LABEL = Strings.nullTerminatedBytes("SMB2AESCMAC");
    static final byte[] KDF_SIGN_LABEL_SMB311 = Strings.nullTerminatedBytes("SMBSigningKey");
    static final byte[] KDF_APP_CONTEXT = Strings.nullTerminatedBytes("SmbRpc");
    static final byte[] KDF_APP_LABEL = Strings.nullTerminatedBytes("SMB2APP");
    static final byte[] KDF_APP_LABEL_SMB311 = Strings.nullTerminatedBytes("SMBAppKey");
    private static final j02 logger = n02.k(SMBSessionBuilder.class);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class BuilderContext {
        private AuthenticationContext authContext;
        private Authenticator authenticator;
        private MessageDigest digest;
        private SMB2SessionSetup request;
        private SMB2SessionSetup response;
        private byte[] securityContext;
        private long sessionId;
        private byte[] sessionKey;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface SessionFactory {
        Session createSession(AuthenticationContext authenticationContext);
    }

    public SMBSessionBuilder(Connection connection, SmbConfig smbConfig, SessionFactory sessionFactory) {
        this.connection = connection;
        this.config = smbConfig;
        this.connectionContext = connection.getConnectionContext();
        this.sessionTable = connection.getSessionTable();
        this.preauthSessionTable = connection.getPreauthSessionTable();
        this.sessionFactory = sessionFactory;
    }

    private SecretKey deriveKey(SecretKey secretKey, byte[] bArr, byte[] bArr2, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(25);
        try {
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(new byte[]{0, 0, 0, -128});
            try {
                DerivationFunction derivationFunction = this.config.getSecurityProvider().getDerivationFunction("KDF/Counter/HMACSHA256");
                derivationFunction.init(new CounterDerivationParameters(secretKey.getEncoded(), byteArrayOutputStream.toByteArray(), 32));
                byte[] bArr3 = new byte[16];
                derivationFunction.generateBytes(bArr3, 0, 16);
                return new SecretKeySpec(bArr3, str);
            } catch (SecurityException e) {
                throw new SMBRuntimeException(e);
            }
        } catch (IOException e2) {
            logger.a("Unable to format suffix, error occur : ", e2);
            return null;
        }
    }

    private void deriveKeys(SMB2SessionSetup sMB2SessionSetup, SMB2Dialect sMB2Dialect, SessionContext sessionContext) {
        if (!sMB2Dialect.isSmb3x() || sMB2SessionSetup.getSessionFlags().contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_IS_NULL) || sMB2SessionSetup.getSessionFlags().contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_IS_GUEST)) {
            return;
        }
        SMB2Dialect sMB2Dialect2 = SMB2Dialect.SMB_3_1_1;
        if (sMB2Dialect == sMB2Dialect2) {
            sessionContext.setSigningKey(deriveKey(sessionContext.getSessionKey(), KDF_SIGN_LABEL_SMB311, sessionContext.getPreauthIntegrityHashValue(), AES_128_CMAC_ALGORITHM));
        } else {
            sessionContext.setSigningKey(deriveKey(sessionContext.getSessionKey(), KDF_SIGN_LABEL, KDF_SIGN_CONTEXT, AES_128_CMAC_ALGORITHM));
        }
        if (this.connectionContext.supportsEncryption()) {
            String algorithmName = this.connectionContext.getCipherId().getAlgorithmName();
            if (sMB2Dialect == sMB2Dialect2) {
                sessionContext.setEncryptionKey(deriveKey(sessionContext.getSessionKey(), KDF_ENC_LABEL_SMB311, sessionContext.getPreauthIntegrityHashValue(), algorithmName));
                sessionContext.setDecryptionKey(deriveKey(sessionContext.getSessionKey(), KDF_DEC_LABEL_SMB311, sessionContext.getPreauthIntegrityHashValue(), algorithmName));
                sessionContext.setApplicationKey(deriveKey(sessionContext.getSessionKey(), KDF_APP_LABEL_SMB311, sessionContext.getPreauthIntegrityHashValue(), algorithmName));
            } else {
                SecretKey sessionKey = sessionContext.getSessionKey();
                byte[] bArr = KDF_ENCDEC_LABEL;
                sessionContext.setEncryptionKey(deriveKey(sessionKey, bArr, KDF_ENC_CONTEXT, algorithmName));
                sessionContext.setDecryptionKey(deriveKey(sessionContext.getSessionKey(), bArr, KDF_DEC_CONTEXT, algorithmName));
                sessionContext.setApplicationKey(deriveKey(sessionContext.getSessionKey(), KDF_APP_LABEL, KDF_APP_CONTEXT, algorithmName));
            }
        }
    }

    private Authenticator getAuthenticator(AuthenticationContext authenticationContext) {
        ArrayList arrayList = new ArrayList(this.config.getSupportedAuthenticators());
        List<ASN1ObjectIdentifier> arrayList2 = new ArrayList<>();
        if (this.connectionContext.getGssNegotiateToken().length > 0) {
            arrayList2 = new NegTokenInit2().read(this.connectionContext.getGssNegotiateToken()).getSupportedMechTypes();
        }
        for (Factory.Named named : new ArrayList(arrayList)) {
            if (arrayList2.isEmpty() || arrayList2.contains(new ASN1ObjectIdentifier(named.getName()))) {
                Authenticator authenticator = (Authenticator) named.create();
                if (authenticator.supports(authenticationContext)) {
                    return authenticator;
                }
            }
        }
        throw new SMBRuntimeException("Could not find a configured authenticator for mechtypes: " + arrayList2 + " and authentication context: " + authenticationContext);
    }

    private BuilderContext initiateSessionSetup(BuilderContext builderContext, byte[] bArr) {
        SMB2SessionSetup sMB2SessionSetup = new SMB2SessionSetup(this.connectionContext.getNegotiatedProtocol().getDialect(), EnumSet.of(this.connectionContext.isServerRequiresSigning() ? SMB2SessionSetup.SMB2SecurityMode.SMB2_NEGOTIATE_SIGNING_REQUIRED : SMB2SessionSetup.SMB2SecurityMode.SMB2_NEGOTIATE_SIGNING_ENABLED), this.connectionContext.getClientCapabilities());
        sMB2SessionSetup.setSecurityBuffer(bArr);
        sMB2SessionSetup.getHeader().setSessionId(builderContext.sessionId);
        builderContext.request = sMB2SessionSetup;
        builderContext.response = (SMB2SessionSetup) this.connection.sendAndReceive(sMB2SessionSetup);
        return builderContext;
    }

    private BuilderContext newContext(AuthenticationContext authenticationContext, Authenticator authenticator) {
        BuilderContext builderContext = new BuilderContext();
        builderContext.authenticator = authenticator;
        builderContext.authContext = authenticationContext;
        return builderContext;
    }

    private Session newSession(BuilderContext builderContext) {
        Session sessionCreateSession = this.sessionFactory.createSession(builderContext.authContext);
        sessionCreateSession.setSessionId(builderContext.sessionId);
        sessionCreateSession.getSessionContext().setPreauthIntegrityHashValue(this.connectionContext.getPreauthIntegrityHashValue());
        return sessionCreateSession;
    }

    private void processAuthenticationToken(BuilderContext builderContext, byte[] bArr) throws IOException {
        AuthenticateResponse authenticateResponseAuthenticate = builderContext.authenticator.authenticate(builderContext.authContext, bArr, this.connectionContext);
        if (authenticateResponseAuthenticate == null) {
            return;
        }
        this.connectionContext.setWindowsVersion(authenticateResponseAuthenticate.getWindowsVersion());
        this.connectionContext.setNetBiosName(authenticateResponseAuthenticate.getNetBiosName());
        builderContext.sessionKey = authenticateResponseAuthenticate.getSessionKey();
        SpnegoToken negToken = authenticateResponseAuthenticate.getNegToken();
        Buffer.PlainBuffer plainBuffer = new Buffer.PlainBuffer(Endian.LE);
        try {
            negToken.write(plainBuffer);
            builderContext.securityContext = plainBuffer.getCompactData();
        } catch (SpnegoException e) {
            throw new IOException(e);
        }
    }

    private Session setupSession(BuilderContext builderContext) throws IOException {
        initiateSessionSetup(builderContext, builderContext.securityContext);
        SMB2SessionSetup sMB2SessionSetup = builderContext.response;
        builderContext.sessionId = sMB2SessionSetup.getHeader().getSessionId();
        SMB2Dialect dialect = this.connectionContext.getNegotiatedProtocol().getDialect();
        if (sMB2SessionSetup.getHeader().getStatusCode() == NtStatus.STATUS_MORE_PROCESSING_REQUIRED.getValue()) {
            if (dialect == SMB2Dialect.SMB_3_1_1) {
                Session sessionFind = this.preauthSessionTable.find(Long.valueOf(builderContext.sessionId));
                if (sessionFind == null) {
                    sessionFind = newSession(builderContext);
                    this.preauthSessionTable.registerSession(Long.valueOf(builderContext.sessionId), sessionFind);
                }
                updatePreauthIntegrityValue(builderContext, sessionFind.getSessionContext(), builderContext.request);
                updatePreauthIntegrityValue(builderContext, sessionFind.getSessionContext(), builderContext.response);
            }
            logger.f("More processing required for authentication of {} using {}", builderContext.authContext.getUsername(), builderContext.authenticator);
            processAuthenticationToken(builderContext, sMB2SessionSetup.getSecurityBuffer());
            return setupSession(builderContext);
        }
        if (sMB2SessionSetup.getHeader().getStatusCode() != NtStatus.STATUS_SUCCESS.getValue()) {
            throw new SMBApiException(sMB2SessionSetup.getHeader(), String.format("Authentication failed for '%s' using %s", builderContext.authContext.getUsername(), builderContext.authenticator));
        }
        Session sessionFind2 = this.preauthSessionTable.find(Long.valueOf(builderContext.sessionId));
        SMB2Dialect sMB2Dialect = SMB2Dialect.SMB_3_1_1;
        if (dialect != sMB2Dialect || sessionFind2 == null) {
            sessionFind2 = newSession(builderContext);
        } else {
            this.preauthSessionTable.removeSession(Long.valueOf(sessionFind2.getSessionId()));
        }
        SessionContext sessionContext = sessionFind2.getSessionContext();
        processAuthenticationToken(builderContext, sMB2SessionSetup.getSecurityBuffer());
        if (builderContext.sessionKey != null) {
            sessionContext.setSessionKey(new SecretKeySpec(builderContext.sessionKey, HMAC_SHA256_ALGORITHM));
        }
        if (dialect == sMB2Dialect) {
            updatePreauthIntegrityValue(builderContext, sessionContext, builderContext.request);
        }
        validateAndSetSigning(builderContext, sessionContext);
        deriveKeys(sMB2SessionSetup, dialect, sessionContext);
        sessionContext.established(sMB2SessionSetup);
        return sessionFind2;
    }

    private void updatePreauthIntegrityValue(BuilderContext builderContext, SessionContext sessionContext, SMB2Packet sMB2Packet) {
        if (builderContext.digest == null) {
            String algorithmName = this.connection.getConnectionContext().getPreauthIntegrityHashId().getAlgorithmName();
            try {
                builderContext.digest = this.config.getSecurityProvider().getDigest(algorithmName);
            } catch (SecurityException e) {
                throw new SMBRuntimeException("Cannot get the message digest for " + algorithmName, e);
            }
        }
        sessionContext.setPreauthIntegrityHashValue(DigestUtil.digest(builderContext.digest, sessionContext.getPreauthIntegrityHashValue(), Packets.getPacketBytes(sMB2Packet)));
    }

    private void validateAndSetSigning(BuilderContext builderContext, SessionContext sessionContext) {
        boolean zIsSigningRequired = this.config.isSigningRequired();
        sessionContext.setSigningRequired(zIsSigningRequired || this.connection.getConnectionContext().isServerRequiresSigning());
        if (builderContext.response.getSessionFlags().contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_IS_NULL)) {
            sessionContext.setSigningRequired(false);
        }
        boolean zContains = builderContext.response.getSessionFlags().contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_IS_GUEST);
        if (zContains && sessionContext.isSigningRequired()) {
            throw new SMB2GuestSigningRequiredException();
        }
        if (zContains && !zIsSigningRequired) {
            sessionContext.setSigningRequired(false);
        }
        if (this.connection.getNegotiatedProtocol().getDialect().isSmb3x() && this.connection.getConnectionContext().supportsEncryption() && builderContext.response.getSessionFlags().contains(SMB2SessionSetup.SMB2SessionFlags.SMB2_SESSION_FLAG_ENCRYPT_DATA)) {
            sessionContext.setEncryptData(true);
            sessionContext.setSigningRequired(false);
        }
    }

    public Session establish(AuthenticationContext authenticationContext) {
        try {
            Authenticator authenticator = getAuthenticator(authenticationContext);
            if ((authenticator instanceof NtlmAuthenticator) && this.config.getNtlmConfig().isIntegrityEnabled() && (!authenticationContext.isAnonymous() || authenticationContext.isGuest())) {
                authenticator = new NtlmSealer((NtlmAuthenticator) authenticator);
            }
            BuilderContext builderContextNewContext = newContext(authenticationContext, authenticator);
            authenticator.init(this.config);
            processAuthenticationToken(builderContextNewContext, this.connectionContext.getGssNegotiateToken());
            Session session = setupSession(builderContextNewContext);
            logger.z("Successfully authenticated {} on {}, session is {}", authenticationContext.getUsername(), this.connection.getRemoteHostname(), Long.valueOf(session.getSessionId()));
            this.sessionTable.registerSession(Long.valueOf(session.getSessionId()), session);
            return session;
        } catch (SpnegoException | IOException e) {
            throw new SMBRuntimeException(e);
        }
    }
}

package com.hierynomus.smbj.auth;

import com.hierynomus.protocol.commons.ByteArrayUtils;
import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.GSSContextConfig;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.connection.ConnectionContext;
import com.hierynomus.spnego.RawToken;
import defpackage.j02;
import defpackage.n02;
import java.security.Key;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import javax.security.auth.Subject;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SpnegoAuthenticator implements Authenticator {
    private static final j02 logger = n02.k(SpnegoAuthenticator.class);
    private GSSContext gssContext;
    private GSSContextConfig gssContextConfig;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Factory implements Factory.Named<Authenticator> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
        @Override // com.hierynomus.protocol.commons.Factory
        public SpnegoAuthenticator create() {
            return new SpnegoAuthenticator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.Factory.Named
        public String getName() {
            return "1.3.6.1.4.1.311.2.2.30";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private byte[] adjustSessionKeyLength(byte[] bArr) {
        if (bArr.length > 16) {
            return Arrays.copyOfRange(bArr, 0, 16);
        }
        if (bArr.length >= 16) {
            return bArr;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        Arrays.fill(bArr2, bArr.length, 15, (byte) 0);
        return bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public AuthenticateResponse authenticateSession(GSSAuthenticationContext gSSAuthenticationContext, byte[] bArr, ConnectionContext connectionContext) throws TransportException {
        Key keyKrb5GetSessionKey;
        try {
            j02 j02Var = logger;
            j02Var.f("Authenticating {} on {} using SPNEGO", gSSAuthenticationContext.getUsername(), connectionContext.getServerName());
            if (this.gssContext == null) {
                GSSManager gSSManager = GSSManager.getInstance();
                GSSContext gSSContextCreateContext = gSSManager.createContext(gSSManager.createName("cifs@" + connectionContext.getServerName(), GSSName.NT_HOSTBASED_SERVICE), new Oid("1.3.6.1.5.5.2"), gSSAuthenticationContext.getCreds(), 0);
                this.gssContext = gSSContextCreateContext;
                gSSContextCreateContext.requestMutualAuth(this.gssContextConfig.isRequestMutualAuth());
                this.gssContext.requestCredDeleg(this.gssContextConfig.isRequestCredDeleg());
            }
            byte[] bArrInitSecContext = this.gssContext.initSecContext(bArr, 0, bArr.length);
            if (bArrInitSecContext != null) {
                j02Var.h("Received token: {}", ByteArrayUtils.printHex(bArrInitSecContext));
            }
            AuthenticateResponse authenticateResponse = new AuthenticateResponse(new RawToken(bArrInitSecContext));
            if (this.gssContext.isEstablished() && (keyKrb5GetSessionKey = ExtendedGSSContext.krb5GetSessionKey(this.gssContext)) != null) {
                authenticateResponse.setSessionKey(adjustSessionKeyLength(keyKrb5GetSessionKey.getEncoded()));
            }
            return authenticateResponse;
        } catch (GSSException e) {
            throw new TransportException((Throwable) e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.auth.Authenticator
    public AuthenticateResponse authenticate(AuthenticationContext authenticationContext, final byte[] bArr, final ConnectionContext connectionContext) throws TransportException {
        final GSSAuthenticationContext gSSAuthenticationContext = (GSSAuthenticationContext) authenticationContext;
        try {
            return (AuthenticateResponse) Subject.doAs(gSSAuthenticationContext.getSubject(), new PrivilegedExceptionAction<AuthenticateResponse>() { // from class: com.hierynomus.smbj.auth.SpnegoAuthenticator.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: run()Ljava/lang/Object; */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public AuthenticateResponse run() {
                    return SpnegoAuthenticator.this.authenticateSession(gSSAuthenticationContext, bArr, connectionContext);
                }
            });
        } catch (PrivilegedActionException e) {
            throw new TransportException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.auth.Authenticator
    public void init(SmbConfig smbConfig) {
        this.gssContextConfig = smbConfig.getClientGSSContextConfig();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.auth.Authenticator
    public boolean supports(AuthenticationContext authenticationContext) {
        return authenticationContext.getClass().equals(GSSAuthenticationContext.class);
    }
}

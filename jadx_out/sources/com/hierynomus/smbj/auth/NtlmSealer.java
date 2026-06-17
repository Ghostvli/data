package com.hierynomus.smbj.auth;

import com.hierynomus.asn1.ASN1OutputStream;
import com.hierynomus.asn1.encodingrules.der.DEREncoder;
import com.hierynomus.asn1.types.constructed.ASN1Sequence;
import com.hierynomus.asn1.types.primitive.ASN1ObjectIdentifier;
import com.hierynomus.ntlm.functions.NtlmFunctions;
import com.hierynomus.ntlm.messages.NtlmNegotiateFlag;
import com.hierynomus.ntlm.messages.WindowsVersion;
import com.hierynomus.security.SecurityProvider;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.connection.ConnectionContext;
import com.hierynomus.spnego.NegTokenInit;
import com.hierynomus.spnego.NegTokenTarg;
import defpackage.j02;
import defpackage.n02;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmSealer implements Authenticator {
    private static final byte[] C2S_SEAL_CONSTANT;
    private static final byte[] C2S_SIGN_CONSTANT;
    private static final j02 logger = n02.k(NtlmSealer.class);
    private List<ASN1ObjectIdentifier> mechTypes;
    private byte[] sealKey;
    private SecurityProvider securityProvider;
    private AtomicInteger sequenceNumber = new AtomicInteger(0);
    private byte[] signKey;
    private NtlmAuthenticator wrapped;

    static {
        Charset charset = StandardCharsets.US_ASCII;
        C2S_SIGN_CONSTANT = "session key to client-to-server signing key magic constant\u0000".getBytes(charset);
        C2S_SEAL_CONSTANT = "session key to client-to-server sealing key magic constant\u0000".getBytes(charset);
    }

    public NtlmSealer(NtlmAuthenticator ntlmAuthenticator) {
        this.wrapped = ntlmAuthenticator;
    }

    private byte[] derBytes(List<ASN1ObjectIdentifier> list) throws IOException {
        ASN1Sequence aSN1Sequence = new ASN1Sequence(new ArrayList(list));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(new DEREncoder(), byteArrayOutputStream);
        try {
            aSN1OutputStream.writeObject(aSN1Sequence);
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                aSN1OutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private byte[] deriveSealingKey(byte[] bArr, Set<NtlmNegotiateFlag> set, WindowsVersion windowsVersion) {
        if (set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY)) {
            if (!set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_128)) {
                bArr = set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_56) ? Arrays.copyOf(bArr, 7) : Arrays.copyOf(bArr, 5);
            }
            return NtlmFunctions.md5(this.securityProvider, bArr, C2S_SEAL_CONSTANT);
        }
        if (!set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_LM_KEY) && (!set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_DATAGRAM) || windowsVersion.getNtlmRevision().getValue() < WindowsVersion.NtlmRevisionCurrent.NTLMSSP_REVISION_W2K3.getValue())) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        byte[] bArr2 = new byte[8];
        if (set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_56)) {
            System.arraycopy(bArr, 0, bArr2, 0, 7);
            bArr2[7] = -96;
            return bArr2;
        }
        System.arraycopy(bArr, 0, bArr2, 0, 5);
        bArr2[5] = -27;
        bArr2[6] = 56;
        bArr2[7] = -80;
        return bArr2;
    }

    private byte[] deriveSigningKey(byte[] bArr, Set<NtlmNegotiateFlag> set) {
        if (set.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY)) {
            return NtlmFunctions.md5(this.securityProvider, bArr, C2S_SIGN_CONSTANT);
        }
        return null;
    }

    private byte[] sign(byte[] bArr, int i) throws IOException {
        byte[] bArrHmac_md5 = NtlmFunctions.hmac_md5(this.securityProvider, bArr, uint32(i), derBytes(this.mechTypes));
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArrHmac_md5, 0, bArr2, 0, 8);
        return bArr2;
    }

    private byte[] uint32(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    @Override // com.hierynomus.smbj.auth.Authenticator
    public AuthenticateResponse authenticate(AuthenticationContext authenticationContext, byte[] bArr, ConnectionContext connectionContext) throws IOException {
        AuthenticateResponse authenticateResponseAuthenticate = this.wrapped.authenticate(authenticationContext, bArr, connectionContext);
        if (authenticateResponseAuthenticate == null) {
            return null;
        }
        byte[] sessionKey = authenticateResponseAuthenticate.getSessionKey();
        Set<NtlmNegotiateFlag> negotiateFlags = authenticateResponseAuthenticate.getNegotiateFlags();
        if (sessionKey != null) {
            logger.b("Calculating signing and sealing keys for NTLM Extended Session Security");
            this.signKey = deriveSigningKey(sessionKey, negotiateFlags);
            this.sealKey = deriveSealingKey(sessionKey, negotiateFlags, authenticateResponseAuthenticate.getWindowsVersion());
        }
        if (authenticateResponseAuthenticate.getNegToken() instanceof NegTokenInit) {
            this.mechTypes = ((NegTokenInit) authenticateResponseAuthenticate.getNegToken()).getSupportedMechTypes();
        }
        if (this.signKey != null && (authenticateResponseAuthenticate.getNegToken() instanceof NegTokenTarg)) {
            NegTokenTarg negTokenTarg = (NegTokenTarg) authenticateResponseAuthenticate.getNegToken();
            logger.b("Signing with NTLM Extended Session Security");
            int andIncrement = this.sequenceNumber.getAndIncrement();
            byte[] bArrSign = sign(this.signKey, andIncrement);
            if (negotiateFlags.contains(NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_KEY_EXCH)) {
                bArrSign = NtlmFunctions.rc4k(this.securityProvider, this.sealKey, bArrSign);
            }
            SMBBuffer sMBBuffer = new SMBBuffer();
            sMBBuffer.putUInt32(1L);
            sMBBuffer.putRawBytes(bArrSign, 0, 8);
            sMBBuffer.putUInt32(andIncrement);
            negTokenTarg.setMechListMic(sMBBuffer.getCompactData());
        }
        return authenticateResponseAuthenticate;
    }

    @Override // com.hierynomus.smbj.auth.Authenticator
    public void init(SmbConfig smbConfig) {
        this.wrapped.init(smbConfig);
        this.securityProvider = smbConfig.getSecurityProvider();
    }

    @Override // com.hierynomus.smbj.auth.Authenticator
    public boolean supports(AuthenticationContext authenticationContext) {
        return this.wrapped.supports(authenticationContext);
    }
}

package com.hierynomus.ntlm.functions;

import com.hierynomus.ntlm.NtlmException;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.SecurityException;
import com.hierynomus.security.SecurityProvider;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class NtlmV1Functions {
    static final byte[] LMOWFv1_SECRET = {75, 71, 83, 33, 64, 35, 36, 37};
    private SecurityProvider securityProvider;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtlmV1Functions(Random random, SecurityProvider securityProvider) {
        this.securityProvider = securityProvider;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] LMOWFv1(String str, String str2, String str3) {
        try {
            byte[] bytes = str.toUpperCase().getBytes("US-ASCII");
            if (bytes.length != 14) {
                bytes = Arrays.copyOf(bytes, 14);
            }
            Cipher dESCipher = NtlmFunctions.getDESCipher(this.securityProvider, Arrays.copyOfRange(bytes, 0, 7));
            Cipher dESCipher2 = NtlmFunctions.getDESCipher(this.securityProvider, Arrays.copyOfRange(bytes, 7, 14));
            byte[] bArr = new byte[16];
            byte[] bArr2 = LMOWFv1_SECRET;
            int iUpdate = dESCipher.update(bArr2, 0, bArr2.length, bArr, 0);
            int iDoFinal = iUpdate + dESCipher.doFinal(bArr, iUpdate);
            int iUpdate2 = iDoFinal + dESCipher2.update(bArr2, 0, bArr2.length, bArr, iDoFinal);
            if (iUpdate2 + dESCipher2.doFinal(bArr, iUpdate2) == 16) {
                return bArr;
            }
            throw new NtlmException("Incorrect lmHash calculated");
        } catch (SecurityException | UnsupportedEncodingException e) {
            throw new NtlmException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] NTOWFv1(String str, String str2, String str3) {
        return NtlmFunctions.md4(this.securityProvider, NtlmFunctions.unicode(str));
    }
}

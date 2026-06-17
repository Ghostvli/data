package com.hierynomus.ntlm.functions;

import com.hierynomus.ntlm.NtlmException;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.Mac;
import com.hierynomus.security.MessageDigest;
import com.hierynomus.security.SecurityException;
import com.hierynomus.security.SecurityProvider;
import java.nio.charset.Charset;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmFunctions {
    public static final Charset UNICODE = Charsets.UTF_16LE;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private NtlmFunctions() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Cipher getDESCipher(SecurityProvider securityProvider, byte[] bArr) {
        try {
            Cipher cipher = securityProvider.getCipher("DES/ECB/NoPadding");
            cipher.init(Cipher.CryptMode.ENCRYPT, setupKey(bArr));
            return cipher;
        } catch (SecurityException e) {
            throw new NtlmException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] hmac_md5(SecurityProvider securityProvider, byte[] bArr, byte[]... bArr2) {
        try {
            Mac mac = securityProvider.getMac("HMACT64");
            mac.init(bArr);
            for (byte[] bArr3 : bArr2) {
                mac.update(bArr3);
            }
            return mac.doFinal();
        } catch (SecurityException e) {
            throw new NtlmException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] md4(SecurityProvider securityProvider, byte[] bArr) {
        try {
            MessageDigest digest = securityProvider.getDigest("MD4");
            digest.update(bArr);
            return digest.digest();
        } catch (SecurityException e) {
            throw new NtlmException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] md5(SecurityProvider securityProvider, byte[]... bArr) {
        try {
            MessageDigest digest = securityProvider.getDigest("MD5");
            for (byte[] bArr2 : bArr) {
                digest.update(bArr2);
            }
            return digest.digest();
        } catch (SecurityException e) {
            throw new NtlmException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] oem(String str) {
        return str != null ? str.getBytes(Charset.forName("Cp850")) : new byte[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] rc4k(SecurityProvider securityProvider, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        try {
            Cipher cipher = securityProvider.getCipher("RC4");
            cipher.init(Cipher.CryptMode.ENCRYPT, bArr);
            cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
            return bArr3;
        } catch (SecurityException e) {
            throw new NtlmException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static byte[] setupKey(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = (byte) ((bArr[0] >> 1) & 255);
        bArr2[1] = (byte) ((((bArr[0] & 1) << 6) | (((bArr[1] & 255) >> 2) & 255)) & 255);
        bArr2[2] = (byte) ((((bArr[1] & 3) << 5) | (((bArr[2] & 255) >> 3) & 255)) & 255);
        bArr2[3] = (byte) ((((bArr[2] & 7) << 4) | (((bArr[3] & 255) >> 4) & 255)) & 255);
        bArr2[4] = (byte) ((((bArr[3] & 15) << 3) | (((bArr[4] & 255) >> 5) & 255)) & 255);
        bArr2[5] = (byte) ((((bArr[4] & 31) << 2) | (((bArr[5] & 255) >> 6) & 255)) & 255);
        bArr2[6] = (byte) ((((bArr[5] & Utf8.REPLACEMENT_BYTE) << 1) | (((bArr[6] & 255) >> 7) & 255)) & 255);
        bArr2[7] = (byte) (bArr[6] & 127);
        for (int i = 0; i < 8; i++) {
            bArr2[i] = (byte) (bArr2[i] << 1);
        }
        return bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] unicode(String str) {
        return str == null ? new byte[0] : str.getBytes(UNICODE);
    }

    public static String unicode(byte[] bArr) {
        return bArr != null ? new String(bArr, UNICODE) : "";
    }

    public static String oem(byte[] bArr) {
        return bArr != null ? new String(bArr, Charset.forName("Cp850")) : "";
    }
}

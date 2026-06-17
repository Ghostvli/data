package com.github.catvod.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CryptoUtil {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String decrypt(String str) {
        try {
            byte[] bArrHexDecode = hexDecode(str);
            SecretKeySpec secretKeySpec = new SecretKeySpec(getKey(), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return stripPadding(cipher.doFinal(bArrHexDecode)).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static byte[] getKey() {
        return new byte[]{72, 82, 90, -100, 27, -93, 96, -71, -77, -74, -118, -26, -114, -105, -5, 1, -48, 84, 82, -6, 106, 78, 25, 0};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static byte[] hexDecode(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isEncrypted(String str) {
        return str != null && str.startsWith("1:");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String stripPadding(byte[] bArr) {
        int i = bArr[bArr.length - 1] & 255;
        if (i < 1 || i > 8) {
            i = 0;
        }
        int length = bArr.length - i;
        int i2 = length;
        while (true) {
            if (i2 < bArr.length) {
                if ((bArr[i2] & 255) != i) {
                    length = bArr.length;
                    break;
                }
                i2++;
            }
        }
        try {
            return new String(bArr, 0, length, "UTF-8");
        } catch (Throwable unused) {
            return new String(bArr, 0, length);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String unwrap(String str) {
        String strDecrypt;
        return (isEncrypted(str) && (strDecrypt = decrypt(str.substring(2))) != null) ? strDecrypt : str;
    }
}

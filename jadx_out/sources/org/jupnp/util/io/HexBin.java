package org.jupnp.util.io;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class HexBin {
    private static final int BASELENGTH = 255;
    private static final int LOOKUPLENGTH = 16;
    private static byte[] hexNumberTable;
    private static byte[] lookUpHexAlphabet;

    static {
        int i;
        byte[] bArr = new byte[BASELENGTH];
        hexNumberTable = bArr;
        lookUpHexAlphabet = new byte[16];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 57; i2 >= 48; i2--) {
            hexNumberTable[i2] = (byte) (i2 - 48);
        }
        for (int i3 = 70; i3 >= 65; i3--) {
            hexNumberTable[i3] = (byte) (i3 - 55);
        }
        for (int i4 = 102; i4 >= 97; i4--) {
            hexNumberTable[i4] = (byte) (i4 - 87);
        }
        int i5 = 0;
        while (true) {
            if (i5 >= 10) {
                break;
            }
            lookUpHexAlphabet[i5] = (byte) (i5 + 48);
            i5++;
        }
        for (i = 10; i <= 15; i++) {
            lookUpHexAlphabet[i] = (byte) (i + 55);
        }
    }

    public static String bytesToString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        String str2 = new String(encode(bArr));
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (char c : str2.toCharArray()) {
            sb.append(c);
            if (i == 2) {
                sb.append(str);
                i = 1;
            } else {
                i++;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length % 2 != 0) {
            return null;
        }
        int i = length / 2;
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            if (isHex(bArr[i3])) {
                int i4 = i3 + 1;
                if (isHex(bArr[i4])) {
                    byte[] bArr3 = hexNumberTable;
                    bArr2[i2] = (byte) ((bArr3[bArr[i3]] << 4) | bArr3[bArr[i4]]);
                }
            }
            return null;
        }
        return bArr2;
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            byte[] bArr3 = lookUpHexAlphabet;
            bArr2[i2] = bArr3[(bArr[i] >> 4) & 15];
            bArr2[i2 + 1] = bArr3[bArr[i] & 15];
        }
        return bArr2;
    }

    public static boolean isHex(byte b) {
        return hexNumberTable[b] != -1;
    }

    public static byte[] stringToBytes(String str, String str2) {
        return decode(str.replaceAll(str2, "").getBytes());
    }

    public static byte[] stringToBytes(String str) {
        return decode(str.getBytes());
    }

    public static String encode(String str) {
        byte[] bArrEncode;
        if (str == null || (bArrEncode = encode(str.getBytes(StandardCharsets.UTF_8))) == null) {
            return null;
        }
        return new String(bArrEncode);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(encode(bArr));
    }

    public static String decode(String str) {
        byte[] bArrDecode;
        if (str == null || (bArrDecode = decode(str.getBytes(StandardCharsets.UTF_8))) == null) {
            return null;
        }
        return new String(bArrDecode);
    }
}

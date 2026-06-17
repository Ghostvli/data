package com.hierynomus.protocol.commons;

import defpackage.f02;
import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ByteArrayUtils {
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length < i + i3 || bArr2.length < i2 + i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i + i4] != bArr2[i2 + i4]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] parseHex(String str) {
        if (str == null) {
            jl.a("Hex string is null");
            return null;
        }
        if (str.length() % 2 != 0) {
            f02.a("Hex string '", str, "' should have even length.");
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((parseHexDigit(str.charAt(i2)) << 4) + parseHexDigit(str.charAt(i2 + 1)));
        }
        return bArr;
    }

    private static int parseHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        throw new IllegalArgumentException("Digit '" + c + "' out of bounds [0-9a-fA-F]");
    }

    public static String printHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i + i3];
            if (sb.length() > 0) {
                sb.append(' ');
            }
            char[] cArr = digits;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public static String toHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i + i3];
            char[] cArr = digits;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public static String toHex(byte[] bArr) {
        return toHex(bArr, 0, bArr.length);
    }

    public static String printHex(byte[] bArr) {
        return printHex(bArr, 0, bArr.length);
    }
}

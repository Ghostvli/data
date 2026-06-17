package okhttp3.internal;

import defpackage.il1;
import defpackage.jl;
import defpackage.rp3;
import defpackage.sg4;
import defpackage.ua;
import defpackage.wg4;
import defpackage.xn3;
import java.io.EOFException;
import okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import okhttp3.internal.idn.Punycode;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class _HostnamesCommonKt {
    private static final rp3 VERIFY_AS_IP_ADDRESS = new rp3("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String str) {
        str.getClass();
        return VERIFY_AS_IP_ADDRESS.b(str);
    }

    public static final byte[] canonicalizeInetAddress(byte[] bArr) {
        bArr.getClass();
        return isMappedIpv4Address(bArr) ? ua.J(bArr, xn3.j(12, 16)) : bArr;
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        str.getClass();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (il1.b(cCharAt, 31) <= 0 || il1.b(cCharAt, 127) >= 0 || wg4.Z(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsInvalidLabelLengths(String str) {
        str.getClass();
        int length = str.length();
        if (1 <= length && length < 254) {
            int i = 0;
            while (true) {
                String str2 = str;
                int iZ = wg4.Z(str2, '.', i, false, 4, null);
                int length2 = iZ == -1 ? str2.length() - i : iZ - i;
                if (1 > length2 || length2 >= 64) {
                    break;
                }
                if (iZ == -1 || iZ == str2.length() - 1) {
                    break;
                }
                i = iZ + 1;
                str = str2;
            }
            return false;
        }
        return true;
    }

    public static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        str.getClass();
        bArr.getClass();
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (il1.b(cCharAt, 48) < 0 || il1.b(cCharAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
    
        if (r11 == 16) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        if (r12 != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
    
        defpackage.ta.d(r8, r8, 16 - (r11 - r12), r12, r11);
        defpackage.ta.m(r8, (byte) 0, r12, (16 - r11) + r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
    
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final byte[] decodeIpv6(java.lang.String r16, int r17, int r18) {
        /*
            r6 = r18
            r16.getClass()
            r7 = 16
            byte[] r8 = new byte[r7]
            r9 = 0
            r10 = -1
            r2 = r17
            r11 = r9
            r12 = r10
            r13 = r12
        L10:
            r14 = 0
            if (r2 >= r6) goto L94
            if (r11 != r7) goto L16
            return r14
        L16:
            int r15 = r2 + 2
            if (r15 > r6) goto L36
            r4 = 4
            r5 = 0
            java.lang.String r1 = "::"
            r3 = 0
            r0 = r16
            boolean r1 = defpackage.sg4.J(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L36
            if (r12 == r10) goto L2a
            return r14
        L2a:
            int r11 = r11 + 2
            if (r15 != r6) goto L31
            r12 = r11
            goto L94
        L31:
            r0 = r16
            r12 = r11
            r13 = r15
            goto L65
        L36:
            if (r11 == 0) goto L47
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r3 = 0
            r0 = r16
            boolean r1 = defpackage.sg4.J(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L4b
            int r2 = r2 + 1
        L47:
            r0 = r16
            r13 = r2
            goto L65
        L4b:
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r3 = 0
            r0 = r16
            boolean r1 = defpackage.sg4.J(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L64
            int r1 = r11 + (-2)
            boolean r0 = decodeIpv4Suffix(r0, r13, r6, r8, r1)
            if (r0 != 0) goto L61
            return r14
        L61:
            int r11 = r11 + 2
            goto L94
        L64:
            return r14
        L65:
            r1 = r9
            r2 = r13
        L67:
            if (r2 >= r6) goto L79
            char r3 = r0.charAt(r2)
            int r3 = okhttp3.internal._UtilCommonKt.parseHexDigit(r3)
            if (r3 == r10) goto L79
            int r1 = r1 << 4
            int r1 = r1 + r3
            int r2 = r2 + 1
            goto L67
        L79:
            int r3 = r2 - r13
            if (r3 == 0) goto L93
            r4 = 4
            if (r3 <= r4) goto L81
            goto L93
        L81:
            int r3 = r11 + 1
            int r4 = r1 >>> 8
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r8[r11] = r4
            int r11 = r11 + 2
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r8[r3] = r1
            goto L10
        L93:
            return r14
        L94:
            if (r11 == r7) goto La5
            if (r12 != r10) goto L99
            return r14
        L99:
            int r0 = r11 - r12
            int r0 = 16 - r0
            defpackage.ta.d(r8, r8, r0, r12, r11)
            int r7 = r7 - r11
            int r7 = r7 + r12
            defpackage.ta.m(r8, r9, r12, r7)
        La5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesCommonKt.decodeIpv6(java.lang.String, int, int):byte[]");
    }

    public static final String idnToAscii(String str) throws EOFException {
        str.getClass();
        Buffer bufferWriteUtf8 = new Buffer().writeUtf8(str);
        Buffer buffer = new Buffer();
        while (!bufferWriteUtf8.exhausted()) {
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(bufferWriteUtf8.readUtf8CodePoint(), buffer)) {
                return null;
            }
        }
        bufferWriteUtf8.writeUtf8(_NormalizeJvmKt.normalizeNfc(buffer.readUtf8()));
        Punycode punycode = Punycode.INSTANCE;
        String strDecode = punycode.decode(bufferWriteUtf8.readUtf8());
        if (strDecode != null && il1.a(strDecode, _NormalizeJvmKt.normalizeNfc(strDecode))) {
            return punycode.encode(strDecode);
        }
        return null;
    }

    public static final String inet4AddressToAscii(byte[] bArr) {
        bArr.getClass();
        if (bArr.length == 4) {
            return new Buffer().writeDecimalLong(_UtilCommonKt.and(bArr[0], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(bArr[1], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(bArr[2], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(bArr[3], 255)).readUtf8();
        }
        jl.a("Failed requirement.");
        return null;
    }

    public static final String inet6AddressToAscii(byte[] bArr) {
        bArr.getClass();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < bArr.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((_UtilCommonKt.and(bArr[i2], 255) << 8) | _UtilCommonKt.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    private static final boolean isMappedIpv4Address(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (bArr[i] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    public static final String toCanonicalHost(String str) {
        str.getClass();
        if (!wg4.P(str, ":", false, 2, null)) {
            String strIdnToAscii = idnToAscii(str);
            if (strIdnToAscii == null || strIdnToAscii.length() == 0 || containsInvalidHostnameAsciiCodes(strIdnToAscii) || containsInvalidLabelLengths(strIdnToAscii)) {
                return null;
            }
            return strIdnToAscii;
        }
        byte[] bArrDecodeIpv6 = (sg4.K(str, "[", false, 2, null) && sg4.x(str, "]", false, 2, null)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (bArrDecodeIpv6 == null) {
            return null;
        }
        byte[] bArrCanonicalizeInetAddress = canonicalizeInetAddress(bArrDecodeIpv6);
        if (bArrCanonicalizeInetAddress.length == 16) {
            return inet6AddressToAscii(bArrCanonicalizeInetAddress);
        }
        if (bArrCanonicalizeInetAddress.length == 4) {
            return inet4AddressToAscii(bArrCanonicalizeInetAddress);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}

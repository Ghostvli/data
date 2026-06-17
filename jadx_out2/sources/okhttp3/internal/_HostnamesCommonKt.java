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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean canParseAsIpAddress(String str) {
        str.getClass();
        return VERIFY_AS_IP_ADDRESS.b(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final byte[] canonicalizeInetAddress(byte[] bArr) {
        bArr.getClass();
        return isMappedIpv4Address(bArr) ? ua.J(bArr, xn3.j(12, 16)) : bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public static final byte[] decodeIpv6(String str, int i, int i2) {
        String str2;
        int i3;
        str.getClass();
        byte[] bArr = new byte[16];
        int i4 = i;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 < i2) {
                if (i5 != 16) {
                    int i8 = i4 + 2;
                    if (i8 <= i2 && sg4.J(str, "::", i4, false, 4, null)) {
                        if (i6 == -1) {
                            i5 += 2;
                            if (i8 != i2) {
                                str2 = str;
                                i6 = i5;
                                i7 = i8;
                                int i9 = 0;
                                i4 = i7;
                                while (i4 < i2) {
                                }
                                i3 = i4 - i7;
                                if (i3 == 0) {
                                    break;
                                }
                                break;
                                break;
                            }
                            i6 = i5;
                            break;
                        }
                        return null;
                    }
                    if (i5 != 0) {
                        if (sg4.J(str, ":", i4, false, 4, null)) {
                            i4++;
                        } else {
                            if (!sg4.J(str, ".", i4, false, 4, null) || !decodeIpv4Suffix(str, i7, i2, bArr, i5 - 2)) {
                                return null;
                            }
                            i5 += 2;
                        }
                    }
                    str2 = str;
                    i7 = i4;
                    int i92 = 0;
                    i4 = i7;
                    while (i4 < i2) {
                        int hexDigit = _UtilCommonKt.parseHexDigit(str2.charAt(i4));
                        if (hexDigit == -1) {
                            break;
                        }
                        i92 = (i92 << 4) + hexDigit;
                        i4++;
                    }
                    i3 = i4 - i7;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i10 = i5 + 1;
                    bArr[i5] = (byte) ((i92 >>> 8) & 255);
                    i5 += 2;
                    bArr[i10] = (byte) (i92 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String inet4AddressToAscii(byte[] bArr) {
        bArr.getClass();
        if (bArr.length == 4) {
            return new Buffer().writeDecimalLong(_UtilCommonKt.and(bArr[0], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(bArr[1], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(bArr[2], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(bArr[3], 255)).readUtf8();
        }
        jl.a("Failed requirement.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

package okhttp3.internal.idn;

import defpackage.at;
import defpackage.bo;
import defpackage.qk1;
import defpackage.sg4;
import defpackage.wg4;
import defpackage.xn3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Punycode {
    private static final int BASE = 36;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final int SKEW = 38;
    private static final int TMAX = 26;
    private static final int TMIN = 1;
    public static final Punycode INSTANCE = new Punycode();
    private static final String PREFIX_STRING = "xn--";
    private static final ByteString PREFIX = ByteString.Companion.encodeUtf8("xn--");

    private Punycode() {
    }

    private final int adapt(int i, int i2, boolean z) {
        int i3 = z ? i / DAMP : i / 2;
        int i4 = i3 + (i3 / i2);
        int i5 = 0;
        while (i4 > 455) {
            i4 /= 35;
            i5 += 36;
        }
        return i5 + ((i4 * 36) / (i4 + 38));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [char] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    private final List<Integer> codePoints(String str, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            int iCharAt = str.charAt(i);
            if (at.e(iCharAt)) {
                int i3 = i + 1;
                char cCharAt = i3 < i2 ? str.charAt(i3) : (char) 0;
                if (Character.isLowSurrogate(iCharAt) || !Character.isLowSurrogate(cCharAt)) {
                    iCharAt = 63;
                } else {
                    iCharAt = 65536 + (((iCharAt & 1023) << 10) | (cCharAt & 1023));
                    i = i3;
                }
            }
            arrayList.add(Integer.valueOf(iCharAt));
            i++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean decodeLabel(String str, int i, int i2, Buffer buffer) {
        int i3;
        int i4;
        int i5 = 1;
        if (!sg4.A(str, i, PREFIX_STRING, 0, 4, true)) {
            buffer.writeUtf8(str, i, i2);
            return true;
        }
        int i6 = i + 4;
        ArrayList arrayList = new ArrayList();
        int iF0 = wg4.f0(str, '-', i2, false, 4, null);
        char c = '0';
        char c2 = '[';
        char c3 = '{';
        boolean z = false;
        if (iF0 >= i6) {
            while (i6 < iF0) {
                int i7 = i6 + 1;
                char cCharAt = str.charAt(i6);
                if (('a' > cCharAt || cCharAt >= '{') && (('A' > cCharAt || cCharAt >= '[') && (('0' > cCharAt || cCharAt >= ':') && cCharAt != '-'))) {
                    return false;
                }
                arrayList.add(Integer.valueOf(cCharAt));
                i6 = i7;
            }
            i6++;
        }
        int i8 = 128;
        int iAdapt = 72;
        int i9 = 0;
        while (i6 < i2) {
            int i10 = i5;
            boolean z2 = z;
            qk1 qk1VarI = xn3.i(xn3.j(36, Integer.MAX_VALUE), 36);
            int iB = qk1VarI.b();
            int iC = qk1VarI.c();
            int iD = qk1VarI.d();
            if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
                i3 = i9;
                int i11 = i10;
                while (i6 != i2) {
                    int i12 = i6 + 1;
                    char cCharAt2 = str.charAt(i6);
                    if ('a' <= cCharAt2 && cCharAt2 < c3) {
                        i4 = cCharAt2 - 'a';
                    } else if ('A' <= cCharAt2 && cCharAt2 < c2) {
                        i4 = cCharAt2 - 'A';
                    } else {
                        if (c > cCharAt2 || cCharAt2 >= ':') {
                            return z2;
                        }
                        i4 = cCharAt2 - 22;
                    }
                    int i13 = i11;
                    int i14 = i4 * i13;
                    int i15 = i3;
                    if (i15 > Integer.MAX_VALUE - i14) {
                        return z2;
                    }
                    i3 = i15 + i14;
                    int i16 = iB <= iAdapt ? i10 : iB >= iAdapt + 26 ? 26 : iB - iAdapt;
                    if (i4 >= i16) {
                        int i17 = 36 - i16;
                        if (i13 > Integer.MAX_VALUE / i17) {
                            return z2;
                        }
                        i11 = i13 * i17;
                        if (iB != iC) {
                            iB += iD;
                            i6 = i12;
                            c = '0';
                            c2 = '[';
                            c3 = '{';
                        }
                    }
                    i6 = i12;
                }
                return z2;
            }
            i3 = i9;
            iAdapt = adapt(i3 - i9, arrayList.size() + 1, i9 == 0 ? i10 : z2);
            int size = i3 / (arrayList.size() + 1);
            if (i8 > Integer.MAX_VALUE - size) {
                return z2;
            }
            i8 += size;
            int size2 = i3 % (arrayList.size() + 1);
            if (i8 > 1114111) {
                return z2;
            }
            arrayList.add(size2, Integer.valueOf(i8));
            i9 = size2 + 1;
            z = z2;
            i5 = i10;
            c = '0';
            c2 = '[';
            c3 = '{';
        }
        boolean z3 = i5;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            buffer.writeUtf8CodePoint(((Number) it.next()).intValue());
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean encodeLabel(String str, int i, int i2, Buffer buffer) {
        int i3;
        int i4;
        int i5;
        int i6 = 1;
        if (!requiresEncode(str, i, i2)) {
            buffer.writeUtf8(str, i, i2);
            return true;
        }
        buffer.write(PREFIX);
        List<Integer> listCodePoints = codePoints(str, i, i2);
        Iterator<Integer> it = listCodePoints.iterator();
        int i7 = 0;
        while (true) {
            i3 = 128;
            if (!it.hasNext()) {
                break;
            }
            int iIntValue = it.next().intValue();
            if (iIntValue < 128) {
                buffer.writeByte(iIntValue);
                i7++;
            }
        }
        if (i7 > 0) {
            buffer.writeByte(45);
        }
        int iAdapt = 72;
        int i8 = 0;
        int i9 = i7;
        while (i9 < listCodePoints.size()) {
            Iterator<T> it2 = listCodePoints.iterator();
            if (!it2.hasNext()) {
                bo.a();
                return false;
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int iIntValue2 = ((Number) next).intValue();
                if (iIntValue2 < i3) {
                    iIntValue2 = Integer.MAX_VALUE;
                }
                do {
                    Object next2 = it2.next();
                    int iIntValue3 = ((Number) next2).intValue();
                    if (iIntValue3 < i3) {
                        iIntValue3 = Integer.MAX_VALUE;
                    }
                    if (iIntValue2 > iIntValue3) {
                        next = next2;
                        iIntValue2 = iIntValue3;
                    }
                } while (it2.hasNext());
            }
            int iIntValue4 = ((Number) next).intValue();
            int i10 = (iIntValue4 - i3) * (i9 + 1);
            if (i8 > Integer.MAX_VALUE - i10) {
                return false;
            }
            int i11 = i8 + i10;
            Iterator<Integer> it3 = listCodePoints.iterator();
            while (it3.hasNext()) {
                int iIntValue5 = it3.next().intValue();
                if (iIntValue5 < iIntValue4) {
                    if (i11 == Integer.MAX_VALUE) {
                        return false;
                    }
                    i11++;
                } else if (iIntValue5 == iIntValue4) {
                    qk1 qk1VarI = xn3.i(xn3.j(36, Integer.MAX_VALUE), 36);
                    int iB = qk1VarI.b();
                    int iC = qk1VarI.c();
                    int iD = qk1VarI.d();
                    if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
                        i5 = i11;
                        while (true) {
                            if (iB <= iAdapt) {
                                i4 = i6;
                            } else {
                                i4 = i6;
                                i6 = iB >= iAdapt + 26 ? 26 : iB - iAdapt;
                            }
                            if (i5 < i6) {
                                break;
                            }
                            int i12 = i5 - i6;
                            int i13 = 36 - i6;
                            buffer.writeByte(getPunycodeDigit(i6 + (i12 % i13)));
                            i5 = i12 / i13;
                            if (iB == iC) {
                                break;
                            }
                            iB += iD;
                            i6 = i4;
                        }
                    } else {
                        i4 = i6;
                        i5 = i11;
                    }
                    buffer.writeByte(getPunycodeDigit(i5));
                    int i14 = i9 + 1;
                    iAdapt = adapt(i11, i14, i9 == i7 ? i4 : false);
                    i9 = i14;
                    i11 = 0;
                    i6 = i4;
                }
            }
            i8 = i11 + 1;
            i3 = iIntValue4 + 1;
        }
        return i6;
    }

    private final int getPunycodeDigit(int i) {
        if (i < 26) {
            return i + 97;
        }
        if (i < 36) {
            return i + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i).toString());
    }

    private final boolean requiresEncode(String str, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) >= 128) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final String decode(String str) {
        str.getClass();
        int length = str.length();
        Buffer buffer = new Buffer();
        int i = 0;
        while (i < length) {
            String str2 = str;
            int iZ = wg4.Z(str2, '.', i, false, 4, null);
            if (iZ == -1) {
                iZ = length;
            }
            if (!decodeLabel(str2, i, iZ, buffer)) {
                return null;
            }
            if (iZ >= length) {
                break;
            }
            buffer.writeByte(46);
            i = iZ + 1;
            str = str2;
        }
        return buffer.readUtf8();
    }

    public final String encode(String str) {
        str.getClass();
        int length = str.length();
        Buffer buffer = new Buffer();
        int i = 0;
        while (i < length) {
            String str2 = str;
            int iZ = wg4.Z(str2, '.', i, false, 4, null);
            if (iZ == -1) {
                iZ = length;
            }
            if (!encodeLabel(str2, i, iZ, buffer)) {
                return null;
            }
            if (iZ >= length) {
                break;
            }
            buffer.writeByte(46);
            i = iZ + 1;
            str = str2;
        }
        return buffer.readUtf8();
    }

    public final ByteString getPREFIX() {
        return PREFIX;
    }

    public final String getPREFIX_STRING() {
        return PREFIX_STRING;
    }
}

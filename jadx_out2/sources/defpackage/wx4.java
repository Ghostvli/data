package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wx4 {
    public static final b a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void h(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws ol1 {
            if (m(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m(b3) || m(b4)) {
                throw ol1.d();
            }
            int iR = ((b & 7) << 18) | (r(b2) << 12) | (r(b3) << 6) | r(b4);
            cArr[i] = l(iR);
            cArr[i + 1] = q(iR);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void i(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void j(byte b, byte b2, byte b3, char[] cArr, int i) throws ol1 {
            if (m(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m(b3)))) {
                throw ol1.d();
            }
            cArr[i] = (char) (((b & 15) << 12) | (r(b2) << 6) | r(b3));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void k(byte b, byte b2, char[] cArr, int i) throws ol1 {
            if (b < -62 || m(b2)) {
                throw ol1.d();
            }
            cArr[i] = (char) (((b & 31) << 6) | r(b2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static char l(int i) {
            return (char) ((i >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean m(byte b) {
            return b > -65;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean n(byte b) {
            return b >= 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean o(byte b) {
            return b < -16;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean p(byte b) {
            return b < -32;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static char q(int i) {
            return (char) ((i & 1023) + Utf8.LOG_SURROGATE_HEADER);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int r(byte b) {
            return b & Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public abstract String a(byte[] bArr, int i, int i2);

        public abstract int b(String str, byte[] bArr, int i, int i2);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c(String str, byte[] bArr, int i, int i2) {
            byte[] bytes = str.getBytes(bl1.a);
            if (bytes.length - i > i2) {
                throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
            }
            System.arraycopy(bytes, 0, bArr, i, bytes.length);
            return i + bytes.length;
        }

        public abstract boolean d(byte[] bArr, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean e(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 < i2 && b >= -62) {
                            i += 2;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return false;
                    }
                    if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return false;
                        }
                        int i4 = i + 2;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i + 3;
                            if (bArr[i4] <= -65) {
                                i += 4;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return false;
                    }
                    if (i3 >= i2 - 1) {
                        return false;
                    }
                    int i6 = i + 2;
                    byte b3 = bArr[i3];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        i += 3;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return false;
                }
                i = i3;
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // wx4.b
        public String a(byte[] bArr, int i, int i2) throws ol1 {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!a.n(b)) {
                    break;
                }
                i++;
                a.i(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (a.n(b2)) {
                    int i7 = i5 + 1;
                    a.i(b2, cArr, i5);
                    int i8 = i6;
                    while (i8 < i3) {
                        byte b3 = bArr[i8];
                        if (!a.n(b3)) {
                            break;
                        }
                        i8++;
                        a.i(b3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    i = i8;
                } else if (a.p(b2)) {
                    if (i6 >= i3) {
                        throw ol1.d();
                    }
                    i += 2;
                    a.k(b2, bArr[i6], cArr, i5);
                    i5++;
                } else if (a.o(b2)) {
                    if (i6 >= i3 - 1) {
                        throw ol1.d();
                    }
                    int i9 = i + 2;
                    i += 3;
                    a.j(b2, bArr[i6], bArr[i9], cArr, i5);
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw ol1.d();
                    }
                    byte b4 = bArr[i6];
                    int i10 = i + 3;
                    byte b5 = bArr[i + 2];
                    i += 4;
                    a.h(b2, b4, b5, bArr[i10], cArr, i5);
                    i5 += 2;
                }
            }
            return new String(cArr, 0, i5);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // wx4.b
        public int b(String str, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            char cCharAt;
            int length = str.length();
            int i5 = i + i2;
            int i6 = 0;
            while (i6 < length && (i4 = i6 + i) < i5 && (cCharAt = str.charAt(i6)) < 128) {
                bArr[i4] = (byte) cCharAt;
                i6++;
            }
            if (i6 == length) {
                return i + length;
            }
            int i7 = i + i6;
            while (i6 < length) {
                char cCharAt2 = str.charAt(i6);
                if (cCharAt2 < 128 && i7 < i5) {
                    bArr[i7] = (byte) cCharAt2;
                    i7++;
                } else if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt2 >>> 6) | 960);
                    i7 += 2;
                    bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                        if (i7 > i5 - 4) {
                            if (55296 > cCharAt2 || cCharAt2 > 57343 || ((i3 = i6 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i3)))) {
                                throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                            }
                            return c(str, bArr, i, i2);
                        }
                        i6++;
                        if (i6 != str.length()) {
                            char cCharAt3 = str.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i9 = i7 + 3;
                                bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i7 += 4;
                                bArr[i9] = (byte) ((codePoint & 63) | 128);
                            }
                        }
                        return c(str, bArr, i, i2);
                    }
                    bArr[i7] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i10 = i7 + 2;
                    bArr[i7 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i7 += 3;
                    bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
                }
                i6++;
            }
            return i7;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // wx4.b
        public boolean d(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return true;
            }
            return e(bArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends Exception {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean e() {
            return vw4.E() && vw4.F();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int f(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            int i3 = 8 - (((int) j) & 7);
            while (i2 < i3) {
                long j2 = 1 + j;
                if (vw4.u(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j2;
            }
            while (true) {
                int i4 = i2 + 8;
                if (i4 > i || (vw4.A(bArr, vw4.h + j) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j += 8;
                i2 = i4;
            }
            while (i2 < i) {
                long j3 = j + 1;
                if (vw4.u(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j3;
            }
            return i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // wx4.b
        public String a(byte[] bArr, int i, int i2) throws ol1 {
            Charset charset = bl1.a;
            String str = new String(bArr, i, i2, charset);
            if (str.indexOf(Utf8.REPLACEMENT_CODE_POINT) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                throw ol1.d();
            }
            return str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // wx4.b
        public int b(String str, byte[] bArr, int i, int i2) {
            return c(str, bArr, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
        
            return false;
         */
        @Override // wx4.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean d(byte[] bArr, int i, int i2) {
            if ((i | i2 | (bArr.length - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            long j = i;
            int i3 = i2 - i;
            int iF = f(bArr, j, i3);
            int i4 = i3 - iF;
            long j2 = j + ((long) iF);
            while (true) {
                byte bU = 0;
                while (true) {
                    if (i4 <= 0) {
                        break;
                    }
                    long j3 = j2 + 1;
                    bU = vw4.u(bArr, j2);
                    if (bU < 0) {
                        j2 = j3;
                        break;
                    }
                    i4--;
                    j2 = j3;
                }
                if (i4 != 0) {
                    int i5 = i4 - 1;
                    if (bU >= -32) {
                        if (bU >= -16) {
                            if (i5 >= 3) {
                                i4 -= 4;
                                long j4 = 1 + j2;
                                byte bU2 = vw4.u(bArr, j2);
                                if (bU2 <= -65 && (((bU << 28) + (bU2 + 112)) >> 30) == 0) {
                                    long j5 = 2 + j2;
                                    if (vw4.u(bArr, j4) > -65) {
                                        break;
                                    }
                                    j2 += 3;
                                    if (vw4.u(bArr, j5) > -65) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            if (i5 < 2) {
                                return false;
                            }
                            i4 -= 3;
                            long j6 = 1 + j2;
                            byte bU3 = vw4.u(bArr, j2);
                            if (bU3 > -65 || ((bU == -32 && bU3 < -96) || (bU == -19 && bU3 >= -96))) {
                                break;
                            }
                            j2 += 2;
                            if (vw4.u(bArr, j6) > -65) {
                                break;
                            }
                        }
                    } else if (i5 != 0) {
                        i4 -= 2;
                        if (bU < -62) {
                            break;
                        }
                        long j7 = 1 + j2;
                        if (vw4.u(bArr, j2) > -65) {
                            break;
                        }
                        j2 = j7;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        a = (!e.e() || s5.c()) ? new c() : new e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(byte[] bArr, int i, int i2) {
        return i2 == 0 ? "" : a.a(bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(String str, byte[] bArr, int i, int i2) {
        return a.b(str, bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r2 < r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        throw new java.lang.IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r2) + 4294967296L));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str) {
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) < 128) {
            i++;
        }
        int iD = length;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt >= 2048) {
                try {
                    iD += d(str, i);
                    break;
                } catch (d unused) {
                    return str.getBytes(bl1.a).length;
                }
            }
            iD += (127 - cCharAt) >>> 31;
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(String str, int i) throws d {
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(str, i) < 65536) {
                        throw new d(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(byte[] bArr) {
        return a.d(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f(byte[] bArr, int i, int i2) {
        return a.d(bArr, i, i2);
    }
}
